package facturaVehiculo.objetos;

import java.io.ByteArrayInputStream;

import java.util.HashMap;
import java.util.List;

import modelo.datos.objetos.accesorias.Marca;
import modelo.datos.objetos.comparendos.generales.InfractorComp;
import modelo.datos.objetos.generales.Transito;
import modelo.datos.objetos.generales.ViewPropietario;
import modelo.datos.objetos.generales.vehiculo.Vehiculo;

import modelo.logica.accesorias.GestionServiciosAccesoriasLocal;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRField;

import servicios.accesorias.ServiciosAccesorias;

import servicios.generales.ServiciosTransito;


public class FacturaDataSource implements JRDataSource {


    List conceptosTarifas;
    int indice = -1;
    String numeroRecibo = "";
    ServiciosTransito serviciosTransito;
    Transito transito = null;
    Vehiculo vehiculo;
    ViewPropietario propietario;
    String total;
    String saldo;
    String cuotas;
    String totalPagar;
    ServiciosAccesorias serviciosAccesorias;
    Marca marca;
    InfractorComp infractor;
    String tipoLiq = "";
    String codigoBarras = "";
    String avaluo = "";

    public FacturaDataSource() {
        super();
    }

    public FacturaDataSource(List conceptos, String numeroFa, Vehiculo vehi, ViewPropietario pro, String tot,
                             String sal, String cuot, String totalP, String codigoBarras, String avaluoVehiculo) throws Exception {
        super();
        //System.out.println("bien x1x2");
        this.conceptosTarifas = conceptos;
        this.numeroRecibo = numeroFa;
        propietario = pro;
        vehiculo = vehi;
        total = tot;
        saldo = sal;
        cuotas = cuot;
        totalPagar = totalP;
        this.codigoBarras = codigoBarras; 
        this.avaluo = avaluoVehiculo;
        tipoLiq = "T";
        try{
        crearObjetos();
        }catch(Exception e){throw new Exception (e.getMessage());}
    }

    public FacturaDataSource(List conceptos, String numeroFa, InfractorComp infractor, String tot, String sal,
                             String cuot, String totalP, String codigoBarras) {
        super();
        this.conceptosTarifas = conceptos;
        this.numeroRecibo = numeroFa;
        this.infractor = infractor;
        total = tot;
        saldo = sal;
        cuotas = cuot;
        totalPagar = totalP;
        this.codigoBarras = codigoBarras; 
        tipoLiq = "C";
        crearObjetosComparendos();
    }

    public void crearObjetos() throws Exception {
        serviciosTransito = new ServiciosTransito();
        transito = serviciosTransito.obtenerTransito(); //.getTransito(transito);
        serviciosAccesorias = new ServiciosAccesorias();
        if (vehiculo != null && vehiculo.getID_MARCAPPAL() != null && !vehiculo.getID_MARCAPPAL().equals("")) {
            //marca = serviciosAccesorias.getMarcaPorId(vehiculo.getID_MARCAPPAL());
            marca = new Marca();
            marca.setIDMARCPPAL(vehiculo.getID_MARCAPPAL());
            GestionServiciosAccesoriasLocal gestionAccesorias = new GestionServiciosAccesoriasLocal();
            try{
            List objs = gestionAccesorias.searchMarca(marca);
            
            if (objs != null && objs.size() > 0) {
                marca = (Marca)objs.get(0);
            }
            }catch(Exception e){throw new Exception (e.getMessage());}
        }
    }

    public void crearObjetosComparendos() {
        serviciosTransito = new ServiciosTransito();
        transito = serviciosTransito.obtenerTransito(); //.getTransito(transito);
        serviciosAccesorias = new ServiciosAccesorias();
    }

    public boolean next() {

        //return ++indice < conceptosTarifas.size();
        return ++indice < 1;
    }

    public Object getFieldValue(JRField campo) {


        // DATOS FACTURACION
        if (tipoLiq.equals("T")) {
            return asignarDatos(campo);
        } else if (tipoLiq.equals("C")) {
            return asignarDatosComparendos(campo);
        }
        return null;


    }


    public Object asignarDatos(JRField campo) {
        Object valor = null;
        modelo.datos.objetos.liquidador.ConceptosTarifa concepto =
            (modelo.datos.objetos.liquidador.ConceptosTarifa)conceptosTarifas.get(indice);

        if ("LCC_NOMBRE".equals(campo.getName())) {
            valor = concepto.getLCC_NOMBRE();
        }
        if ("LT_NOMBRE".equals(campo.getName())) {
            valor = concepto.getLT_NOMBRE();
        }
        if ("LT_VIGENCIA".equals(campo.getName())) {
            valor = concepto.getLT_VIGENCIA();
        }
        if ("LTD_VALOR".equals(campo.getName())) {
            valor = concepto.getLTD_VALOR();
        }
        if ("RECIBO".equals(campo.getName())) {
            valor = numeroRecibo;
        }
        if ("TOTAL".equals(campo.getName())) {
            valor = "" + total;
        }
        if ("SALDO".equals(campo.getName())) {
            valor = "" + saldo;
        }
        if ("CUOTAS".equals(campo.getName())) {
            valor = cuotas;
        }
        if ("VALORPAGAR".equals(campo.getName())) {
            valor = "" + totalPagar;
        }

        //System.out.println("bien 1");
        // DATOS TRANSITO
        if ("NOMBREALCALDIA".equals(campo.getName())) {
            valor = transito.getNOMBREALCALDIA();
        }
        if ("NIT".equals(campo.getName())) {
            valor = transito.getNIT();
        }
        if ("DESCRIPCION".equals(campo.getName())) {
            valor = transito.getDESCRIPCION();
        }
        if ("DIRECCION".equals(campo.getName())) {
            valor = transito.getDIRECCION();
        }
        if ("TELEFONOS".equals(campo.getName())) {
            valor = transito.getTELEFONOS();
        }
        if ("FAX1".equals(campo.getName())) {
            valor = transito.getFAX1();
        }
        if ("LOGO".equals(campo.getName())) {
            ByteArrayInputStream is = new ByteArrayInputStream(transito.getLOGO());
            valor = is;
        }
        if ("LOGO_2".equals(campo.getName())) {
            ByteArrayInputStream is = new ByteArrayInputStream(transito.getLOGO());
            valor = is;
        }
        //System.out.println("bien 2");
        //datos vehiculo
        if (vehiculo != null && "PLACA".equals(campo.getName())) {
            valor = vehiculo.getPLACA();
        }
        if (marca != null && "MARCA".equals(campo.getName())) {
            valor = marca.getDESCRIPCION();
        }
        if (vehiculo != null && "MODELO".equals(campo.getName())) {
            valor = vehiculo.getMODELO();
        }
        if (!avaluo.equals("")&& "AVALUO".equals(campo.getName())) {
            valor = avaluo;
        }
        //System.out.println("bien 3");
        //System.out.println("Propietario " + propietario);
        //datos PROPIETARIO
        if ("IDENTIFICACION".equals(campo.getName())) {
            if (propietario.getEMPPER() != null && propietario.getEMPPER().equals("EMP")) {
                valor = propietario.getNIT();
            } else if (propietario.getEMPPER() != null && propietario.getEMPPER().equals("PER")) {
                valor = propietario.getIDENTIFICACION();
            }
        }
        if ("NOMBRES".equals(campo.getName())) {
            if (propietario.getEMPPER() != null && propietario.getEMPPER().equals("EMP")) {
                valor = propietario.getRAZONSOCIAL();
            } else if (propietario.getEMPPER() != null && propietario.getEMPPER().equals("PER")) {
                valor = propietario.getNOMBRE();
            }
            //System.out.println("bien 4");
        }
        if ("CODIGOBARRAS".equals(campo.getName())) {
            valor = codigoBarras;
        }
        return valor;
    }
    
    public HashMap getParametros() {
        HashMap parametros = new HashMap();
        parametros.put("DETALLE_FACTURA_1", new FacturaDetalleDs(conceptosTarifas, tipoLiq));
        parametros.put("DETALLE_FACTURA_2", new FacturaDetalleDs(conceptosTarifas, tipoLiq));
        return parametros;
    }


    public Object asignarDatosComparendos(JRField campo) {
        Object valor = null;
        modelo.datos.objetos.comparendos.liquidador.ConceptosTarifa concepto =
            (modelo.datos.objetos.comparendos.liquidador.ConceptosTarifa)conceptosTarifas.get(indice);
        //System.out.println("Asignar datos comp");
        if ("LCC_NOMBRE".equals(campo.getName())) {
            valor = concepto.getDESCRIPCION();
        }
        if ("NUMEROCOMPARENDO".equals(campo.getName())) {
            valor = concepto.getNUMEROCOMPARENDO();
        }
        if ("FECHACOMPARENDO".equals(campo.getName())) {
            valor = concepto.getFECHACOMPARENDO();
        }
        if ("LT_VIGENCIA".equals(campo.getName())) {
            valor = concepto.getLT_VIGENCIA();
        }
        if ("LTD_VALOR".equals(campo.getName())) {
            valor = concepto.getLTD_VALOR();
        }
        if ("RECIBO".equals(campo.getName())) {
            valor = numeroRecibo;
        }
        if ("TOTAL".equals(campo.getName())) {
            valor = "" + total;
        }
        if ("SALDO".equals(campo.getName())) {
            valor = "" + saldo;
        }
        if ("CUOTAS".equals(campo.getName())) {
            valor = cuotas;
        }
        if ("VALORPAGAR".equals(campo.getName())) {
            valor = "" + totalPagar;
        }

        // DATOS TRANSITO
        if ("NOMBREALCALDIA".equals(campo.getName())) {
            valor = transito.getNOMBREALCALDIA();
        }
        if ("NIT".equals(campo.getName())) {
            valor = transito.getNIT();
        }
        if ("DESCRIPCION".equals(campo.getName())) {
            valor = transito.getDESCRIPCION();
        }
        if ("DIRECCION".equals(campo.getName())) {
            valor = transito.getDIRECCION();
        }
        if ("TELEFONOS".equals(campo.getName())) {
            valor = transito.getTELEFONOS();
        }
        if ("FAX1".equals(campo.getName())) {
            valor = transito.getFAX1();
        }
        if ("LOGO".equals(campo.getName())) {
            ByteArrayInputStream is = new ByteArrayInputStream(transito.getLOGO());
            valor = is;
        }
        if ("LOGO_2".equals(campo.getName())) {
            ByteArrayInputStream is = new ByteArrayInputStream(transito.getLOGO());
            valor = is;
        }

        //datos vehiculo


        //datos PROPIETARIO
        if ("IDENTIFICACION".equals(campo.getName())) {
            valor = infractor.getNROIDENTIFICACION();
        }
        if ("NOMBRES".equals(campo.getName())) {
            valor = infractor.getNOMBRES() + " " + infractor.getAPELLIDOS();
        }
        if ("CODIGOBARRAS".equals(campo.getName())) {
            valor = codigoBarras;
        }
        return valor;

    }

    public void setNumeroRecibo(String numeroRecibo) {
        this.numeroRecibo = numeroRecibo;
    }

    public String getNumeroRecibo() {
        return numeroRecibo;
    }

    public void setConceptosTarifas(List conceptosTarifas) {
        this.conceptosTarifas = conceptosTarifas;
    }

    public List getConceptosTarifas() {
        return conceptosTarifas;
    }
}
