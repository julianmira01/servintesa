package modelo.logica.liquidacion;

import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Date;

import modelo.datos.objetos.generales.Transito;
import modelo.datos.objetos.generales.Usuarios;
import modelo.datos.objetos.liquidacion.caja.AperturaTurno;
import modelo.datos.objetos.liquidacion.caja.ArqueoCaja;
import modelo.datos.objetos.liquidacion.caja.CierreCaja;

import utilidades.DSArqueo;
import utilidades.DSCierreCaja;
import utilidades.GenerarReportesArqueo;


public class GestionReporteArqueo {
    public GestionReporteArqueo() {
        super();
    }

    public static void main(String[] args) {
        GestionReporteArqueo gestionReporteArqueo = new GestionReporteArqueo();
    }
    
    public String crearReporteArqueo(String tipoArqueo, Usuarios usuarioArquea, Usuarios usuarioArqueado, 
                                   AperturaTurno aperturaTurno, ArqueoCaja arqueoCaja, 
                                   ArrayList listaDetArqueo, ArrayList listaFactura, ArrayList listaPago, 
                                   ArrayList listaDetArqueoRunt, ArrayList listaPagoRunt, Transito transito) {
        GenerarReportesArqueo generarReportesArqueo = new GenerarReportesArqueo();
        DSArqueo dsArqueo = new DSArqueo();
        dsArqueo.setUsuarioArquea(usuarioArquea);
        dsArqueo.setUsuarioArqueado(usuarioArqueado);
        dsArqueo.setAperturaTurno(aperturaTurno);
        dsArqueo.setArqueoCaja(arqueoCaja);
        dsArqueo.setListaDetArqueo(listaDetArqueo);
        dsArqueo.setListaDetArqueoRunt(listaDetArqueoRunt);
        dsArqueo.setListaFactura(listaFactura);
        dsArqueo.setListaPago(listaPago);
        dsArqueo.setListaPagoRunt(listaPagoRunt);
        dsArqueo.setCantidad(listaFactura.size()); 
        dsArqueo.setTipoArqueo(tipoArqueo);
        dsArqueo.setTransito(transito);

        Date fechaActual = new Date();
        SimpleDateFormat formato = new SimpleDateFormat("yyMMddHHmmss");
        String fileName = "Arqueo_" + arqueoCaja.getID_CAJERO() + "_" + arqueoCaja.getID_ARQUEO() + "_" +
            formato.format(fechaActual);
        generarReportesArqueo.crearReporteArqueo(dsArqueo, dsArqueo.getParametros(), fileName);
        return fileName;
    }
    
    public String crearReporteCierreCaja(String tipoArqueo, Usuarios usuarioArquea, CierreCaja cierreCaja, 
                                   Transito transito, ArrayList listaResumenCierreCaja) {
        GenerarReportesArqueo generarReportesArqueo = new GenerarReportesArqueo();
        DSCierreCaja ds = new DSCierreCaja();
        ds.setUsuarioArquea(usuarioArquea);
        ds.setCierreCaja(cierreCaja);
        ds.setListaResumenCierreCaja(listaResumenCierreCaja);
        ds.setCantidad(listaResumenCierreCaja.size()); 
        ds.setTipoArqueo(tipoArqueo);
        ds.setTransito(transito);

        Date fechaActual = new Date();
        SimpleDateFormat formato = new SimpleDateFormat("yyMMddHHmmss");
        String fileName = "CierreCaja_" + cierreCaja.getID_USUARIO() + "_" + cierreCaja.getIDCIERRE_CAJA() + "_" +
            formato.format(fechaActual);
        generarReportesArqueo.crearReporteCierrecaja(ds, ds.getParametros(), fileName);
        return fileName;
    }
}
