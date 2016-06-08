package utilidades;

import java.io.ByteArrayInputStream;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import modelo.datos.objetos.accesorias.EstadosFactura;
import modelo.datos.objetos.generales.Transito;
import modelo.datos.objetos.generales.Usuarios;
import modelo.datos.objetos.liquidacion.Factura;
import modelo.datos.objetos.liquidacion.Viewfactura;
import modelo.datos.objetos.liquidacion.caja.AperturaTurno;
import modelo.datos.objetos.liquidacion.caja.ArqueoCaja;
import modelo.datos.objetos.liquidacion.caja.DetArqueo;
import modelo.datos.objetos.liquidacion.caja.DetArqueoRunt;
import modelo.datos.objetos.liquidacion.caja.LPagos;
import modelo.datos.objetos.liquidacion.caja.LPagosRunt;

import modelo.logica.accesorias.GestionServiciosAccesoriasLocal;
import modelo.logica.liquidacion.GestionViewfactura;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRField;


public class DSArqueo implements JRDataSource {
    GestionServiciosAccesoriasLocal gestionAccesorias;

    private int indice = -1;
    private int cantidad = 0;
    String tipoArqueo = "local";
    Transito transito;
    ArqueoCaja arqueoCaja;
    AperturaTurno aperturaTurno;
    Usuarios usuarioArquea;
    Usuarios usuarioArqueado;
    ArrayList listaDetArqueo; //DetArqueo detArqueo;
    ArrayList listaDetArqueoRunt; //DetArqueoRunt detArqueoRunt;
    ArrayList listaFactura; //Factura factura;
    ArrayList listaPago; //LPagos pago;
    ArrayList listaPagoRunt; //LPagosRunt pagoRunt;
    ArrayList listaViewFactura;

    public DSArqueo() {
        super();
        gestionAccesorias = new GestionServiciosAccesoriasLocal();
    }

    @Override
    public boolean next() throws JRException {
        indice++;
        return indice < cantidad;
    }

    @Override
    public Object getFieldValue(JRField jRField) throws JRException {
        DetArqueo detArqueo = null;
        DetArqueoRunt detArqueoRunt = null;
        Factura factura = null;
        LPagos pago = null;
        LPagosRunt pagoRunt = null;
        Viewfactura viewfactura = null;
        factura = (Factura)listaFactura.get(indice);
        viewfactura = (Viewfactura)listaViewFactura.get(indice);

        if (tipoArqueo.toLowerCase().equals("local")) {
            detArqueo = (DetArqueo)listaDetArqueo.get(indice);
            pago = (LPagos)listaPago.get(indice);
        } else {
            detArqueoRunt = (DetArqueoRunt)listaDetArqueoRunt.get(indice);
            pagoRunt = (LPagosRunt)listaPagoRunt.get(indice);
        }

        if (jRField.getName().equals("REGISTRO_NUMERO")) {
            return indice + 1;
        } else if (jRField.getName().equals("FACTURA_PLACA")) {
            return viewfactura.getPLACA();
        } else if (jRField.getName().equals("FACTURA_PROPIETARIO")) {
            return (viewfactura.getRAZONSOCIAL() == null || viewfactura.getRAZONSOCIAL().equals(" ")) ?
                   viewfactura.getNOMBRE() : viewfactura.getRAZONSOCIAL();
        } else if (jRField.getName().equals("FACTURA_NUMERO")) {
            return tipoArqueo.toLowerCase().equals("local") ? viewfactura.getLF_NUMERO() : viewfactura.getLF_NUMRUNT();
        } else if (jRField.getName().equals("FACTURA_ESTADO")) {
            return viewfactura.getESTADO();
        } else if (jRField.getName().equals("FACTURA_VALOR")) {
            return viewfactura.getLF_TOTAL();
        } else if (jRField.getName().equals("PAGO_ESTADO")) {
            return getEstadoDescripcion(detArqueo.getESTADO());
        } else if (jRField.getName().equals("PAGO_FECHA")) {
            return Funciones.fechaToTimestamp1(pago.getLP_FECHAHORA());
        } else if (jRField.getName().equals("PAGO_VALORPAGADO")) {
            return pago.getLP_VALOR();
        } else if (jRField.getName().equals("PAGO_TIPOPAGO")) {
            return detArqueo.getDESTIPOPAGO();
        }
        return "INDEFINIDO";
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getCantidad() {
        return cantidad;
    }

    public HashMap getParametros() {
        HashMap parametros = new HashMap();
        Double valorBase = Double.parseDouble(aperturaTurno.getVLR_BASE());
        parametros.put("ARQUEOLOGIN", usuarioArquea.getLOGIN());
        parametros.put("ARQUEODOCUMENTO", usuarioArquea.getDOCUMENTO());
        parametros.put("ARQUEONOMBRE", usuarioArquea.getNOMBRE());
        parametros.put("PAGOLOGIN", usuarioArqueado.getLOGIN());
        parametros.put("PAGODOCUMENTO", usuarioArqueado.getDOCUMENTO());
        parametros.put("PAGONOMBRE", usuarioArqueado.getNOMBRE());


        //parametros.put("APERTURA_FECHAINICIO", Funciones.fechaToTimestamp1(aperturaTurno.getFECHA_INI() + " " + aperturaTurno.getHORA_INI()));
        //parametros.put("APERTURA_FECHAFIN", Funciones.fechaToTimestamp1(aperturaTurno.getFECHA_FIN() + " " + aperturaTurno.getHORA_FIN()));
        
                
        parametros.put("APERTURA_FECHAINICIO",
                       Funciones.convertirStringTimestamp(getSoloFecha(aperturaTurno.getFECHA_INI()) + " " +
                                                          getSoloHora(aperturaTurno.getHORA_INI()),
                                                          "yyyy-MM-dd HH:mm:ss"));
        parametros.put("APERTURA_FECHAFIN",
                       Funciones.convertirStringTimestamp(getSoloFecha(aperturaTurno.getFECHA_FIN()) + " " +
                                                          getSoloHora(aperturaTurno.getHORA_FIN()),
                                                          "yyyy-MM-dd HH:mm:ss"));

        parametros.put("APERTURA_VALORBASE", valorBase);


        //parametros.put("ARQUEO_FECHAINICIO", Funciones.fechaToTimestamp2(arqueoCaja.getFEC_INICIAL() + " " + arqueoCaja.getH_INICIAL()));
        //parametros.put("ARQUEO_FECHAFIN", Funciones.fechaToTimestamp2(arqueoCaja.getFEC_FINAL() + " " + arqueoCaja.getH_FINAL()));
        parametros.put("ARQUEO_FECHAINICIO",
                       Funciones.convertirStringTimestamp((getSoloFecha(arqueoCaja.getFEC_INICIAL()) + " " +
                                                           getSoloHora(arqueoCaja.getH_INICIAL())),
                                                          "yyyy-MM-dd HH:mm:ss"));
        parametros.put("ARQUEO_FECHAFIN",
                       Funciones.convertirStringTimestamp((getSoloFecha(arqueoCaja.getFEC_FINAL()) + " " +
                                                           getSoloHora(arqueoCaja.getH_FINAL())),
                                                          "yyyy-MM-dd HH:mm:ss"));


        parametros.put("ARQUEO_VALORBASE", Double.parseDouble(arqueoCaja.getVLR_BASE()));
        parametros.put("ARQUEO_TIPOARQUEO", tipoArqueo.toUpperCase());
        parametros.put("TRANSITO_NOMBRE", transito.getNOMBREALCALDIA());
        parametros.put("TRANSITO_DESCRIPCION", transito.getDESCRIPCION());
        parametros.put("TRANSITO_LOGO", new ByteArrayInputStream(transito.getLOGO()));
        parametros.put("REGISTRO_CANTIDAD", cantidad);
        if (tipoArqueo.toLowerCase().equals("local")) {
            Double totalArqueo = calcularTotalArqueo();
            Double totalFactura = calcularTotalFactura();
            Double totalPago = calcularTotalPago();
            parametros.put("REGISTRO_TOTALARQUEO", totalArqueo);
            parametros.put("REGISTRO_TOTALFACTURA", totalFactura);
            parametros.put("REGISTRO_TOTALPAGO", totalPago);
            parametros.put("REGISTRO_DESFACE", totalPago - totalFactura);
            parametros.put("BALANCE", valorBase + (totalPago - totalFactura));
            parametros.put("REGISTRO_TOTALCAJA", valorBase + totalFactura);
        } else {
            Double totalArqueo = calcularTotalArqueoRunt();
            Double totalFactura = calcularTotalFacturaRunt();
            Double totalPago = calcularTotalPagoRunt();
            parametros.put("REGISTRO_TOTALARQUEO", totalArqueo);
            parametros.put("REGISTRO_TOTALFACTURA", totalFactura);
            parametros.put("REGISTRO_TOTALPAGO", totalPago);
            parametros.put("REGISTRO_DESFACE", totalPago - totalFactura);
            parametros.put("BALANCE", valorBase + (totalPago - totalFactura));
            parametros.put("REGISTRO_TOTALCAJA", valorBase + totalFactura);
        }
        return parametros;
    }

    private String getSoloFecha(String cad) {
        if (cad != null)
            return cad.replaceAll("\\d\\d:\\d\\d:\\d\\d", "");
        else
            return cad;

    }

    private String getSoloHora(String cad) {
        if (cad != null)
            return cad.replaceAll("\\d\\d\\d\\d-\\d\\d-\\d\\d", "");
        else
            return cad;

    }


    public String getTipoArqueo() {
        return tipoArqueo;
    }

    public void setTipoArqueo(String tipoArqueo) {
        this.tipoArqueo = tipoArqueo;
    }

    public Transito getTransito() {
        return transito;
    }

    public void setTransito(Transito transito) {
        this.transito = transito;
    }

    public ArqueoCaja getArqueoCaja() {
        return arqueoCaja;
    }

    public void setArqueoCaja(ArqueoCaja arqueoCaja) {
        this.arqueoCaja = arqueoCaja;
    }

    public AperturaTurno getAperturaTurno() {
        return aperturaTurno;
    }

    public void setAperturaTurno(AperturaTurno aperturaTurno) {
        this.aperturaTurno = aperturaTurno;
    }

    public Usuarios getUsuarioArquea() {
        return usuarioArquea;
    }

    public void setUsuarioArquea(Usuarios usuarioArquea) {
        this.usuarioArquea = usuarioArquea;
    }

    public Usuarios getUsuarioArqueado() {
        return usuarioArqueado;
    }

    public void setUsuarioArqueado(Usuarios usuarioArqueado) {
        this.usuarioArqueado = usuarioArqueado;
    }

    public ArrayList getListaDetArqueo() {
        return listaDetArqueo;
    }

    public void setListaDetArqueo(ArrayList listaDetArqueo) {
        this.listaDetArqueo = listaDetArqueo;
    }

    public ArrayList getListaDetArqueoRunt() {
        return listaDetArqueoRunt;
    }

    public void setListaDetArqueoRunt(ArrayList listaDetArqueoRunt) {
        this.listaDetArqueoRunt = listaDetArqueoRunt;
    }

    public ArrayList getListaFactura() {
        return listaFactura;
    }

    public void setListaFactura(ArrayList listaFactura) {
        this.listaFactura = listaFactura;
        listaViewFactura = setViewFactura(listaFactura);
    }

    public ArrayList getListaPago() {
        return listaPago;
    }

    public void setListaPago(ArrayList listaPago) {
        this.listaPago = listaPago;
    }

    public ArrayList getListaPagoRunt() {
        return listaPagoRunt;
    }

    public void setListaPagoRunt(ArrayList listaPagoRunt) {
        this.listaPagoRunt = listaPagoRunt;
    }

    private ArrayList setViewFactura(ArrayList lista) {
        Factura factura;
        Viewfactura viewFactura;
        ArrayList newLista = new ArrayList();
        for (int i = 0; i < lista.size(); i++) {
            factura = (Factura)lista.get(i);
            viewFactura = new Viewfactura();
            viewFactura.setLF_ID(factura.getLF_ID());
            GestionViewfactura gestionViewfactura = new GestionViewfactura();
            viewFactura = gestionViewfactura.getOne(viewFactura);
            newLista.add(viewFactura);
        }
        return newLista;
    }

    private Double calcularTotalArqueo() {
        Double d = 0.0;
        DetArqueo obj;
        for (int i = 0; i < listaDetArqueo.size(); i++) {
            obj = (DetArqueo)listaDetArqueo.get(i);
            if (obj.getVALORPAGO() != null && !obj.getVALORPAGO().equals(" "))
                d += Double.parseDouble(obj.getVALORPAGO());
        }
        return d;
    }

    private Double calcularTotalArqueoRunt() {
        Double d = 0.0;
        DetArqueoRunt obj;
        for (int i = 0; i < listaDetArqueoRunt.size(); i++) {
            obj = (DetArqueoRunt)listaDetArqueoRunt.get(i);
            if (obj.getVALORPAGORUNT() != null && !obj.getVALORPAGORUNT().equals(" "))
                d += Double.parseDouble(obj.getVALORPAGORUNT());
        }
        return d;
    }

    private Double calcularTotalFactura() {
        Double d = 0.0;
        Factura obj;
        for (int i = 0; i < listaFactura.size(); i++) {
            obj = (Factura)listaFactura.get(i);
            d += obj.getLF_TOTAL();
        }
        return d;
    }

    private Double calcularTotalFacturaRunt() {
        Double d = 0.0;
        Factura obj;
        for (int i = 0; i < listaFactura.size(); i++) {
            obj = (Factura)listaFactura.get(i);
            d += obj.getLF_TOTALFACTURARUNT();
        }
        return d;
    }

    private Double calcularTotalPago() {
        Double d = 0.0;
        LPagos obj;
        for (int i = 0; i < listaPago.size(); i++) {
            obj = (LPagos)listaPago.get(i);
            d += obj.getLP_VALOR();
        }
        return d;
    }

    private Double calcularTotalPagoRunt() {
        Double d = 0.0;
        LPagosRunt obj;
        for (int i = 0; i < listaPagoRunt.size(); i++) {
            obj = (LPagosRunt)listaPagoRunt.get(i);
            d += Double.parseDouble(obj.getVALORRUNT());
        }
        return d;
    }

    private String getEstadoDescripcion(String idEstado) {
        String res = "";
        if (idEstado != null && !idEstado.equals(" ")) {
            EstadosFactura estadoFactura = new EstadosFactura();
            estadoFactura.setID_ESTADO(Integer.parseInt(idEstado));
            List lista = gestionAccesorias.getEstadoFactura(estadoFactura);
            if (lista != null) {
                estadoFactura = (EstadosFactura)lista.get(0);
                res = estadoFactura.getDESCRIPCION();
            }
        }
        return res;
    }
}
