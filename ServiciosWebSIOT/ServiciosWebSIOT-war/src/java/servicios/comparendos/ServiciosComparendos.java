package servicios.comparendos;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

import modelo.datos.objetos.comparendos.comparenderas.Comparenderas;
import modelo.datos.objetos.comparendos.comparenderas.DetalleComparendera;
import modelo.datos.objetos.comparendos.comparenderas.RangosdeComparendosComp;
import modelo.datos.objetos.comparendos.comparenderas.ViewComparenderas;
import modelo.datos.objetos.comparendos.comparenderas.ViewComparendosInfractor;
import modelo.datos.objetos.comparendos.liquidacion.tarifas.LVigenciasComp;

import modelo.logica.comparendos.GestionServiciosComparendos;


@WebService
public class ServiciosComparendos {
    GestionServiciosComparendos gestionServiciosComparendos;

    public ServiciosComparendos() {
        super();
        gestionServiciosComparendos = new GestionServiciosComparendos();
    }

    @WebMethod
    public List getLTvigencias(LVigenciasComp lvigenciacomp) {
        return gestionServiciosComparendos.getLTvigencias(lvigenciacomp);
    }

    @WebMethod
    public LVigenciasComp getLVigenciasId(LVigenciasComp lvigenciacomp) {
        return gestionServiciosComparendos.getLVigenciasId(lvigenciacomp);
    }

    @WebMethod
    public List getLVigencias(LVigenciasComp lvigenciacomp) {
        return gestionServiciosComparendos.getLVigencias(lvigenciacomp);
    }

    @WebMethod
    public boolean crearLVigencias(LVigenciasComp lvigenciacomp) {
        return gestionServiciosComparendos.crearLVigencias(lvigenciacomp);
    }

    @WebMethod
    public boolean editarLVigencias(LVigenciasComp lvigenciacomp) {
        return gestionServiciosComparendos.editarLVigencias(lvigenciacomp);
    }

    @WebMethod
    public List getRangosComparendos(RangosdeComparendosComp rangosdecomparendos) {
        return gestionServiciosComparendos.getRangosComparendos(rangosdecomparendos);
    }

    @WebMethod
    public List getTComparenderas() {
        return gestionServiciosComparendos.getTComparenderas();
    }

    @WebMethod
    public Comparenderas getComparenderaPorId(Comparenderas comparenderas) {
        return gestionServiciosComparendos.getComparenderaPorId(comparenderas);
    }

    @WebMethod
    public Comparenderas getComparendera(Comparenderas comparenderas) {
        return gestionServiciosComparendos.getComparendera(comparenderas);
    }

    @WebMethod
    public List getSComparenderas(Comparenderas comparenderas) {
        return gestionServiciosComparendos.getSComparenderas(comparenderas);
    }

    @WebMethod
    public Comparenderas crearComparendera(Comparenderas comparenderas, int idUsuario, String myIp, String myHost) {
        return gestionServiciosComparendos.crearComparendera(comparenderas, idUsuario, myIp, myHost);
    }

    @WebMethod
    public boolean editarComparendera(Comparenderas comparenderas, int idUsuario, String myIp, String myHost) {
        return gestionServiciosComparendos.editarComparendera(comparenderas, idUsuario, myIp, myHost);
    }

    @WebMethod
    public boolean eliminarComparendera(Comparenderas comparenderas, int idUsuario, String myIp, String myHost) {
        return gestionServiciosComparendos.eliminarComparendera(comparenderas, idUsuario, myIp, myHost);
    }

    @WebMethod
    public List getTRangosdeComparendosComp() {
        return gestionServiciosComparendos.getTRangosdeComparendosComp();
    }

    @WebMethod
    public RangosdeComparendosComp getRangosdeComparendosCompPorId(RangosdeComparendosComp rangosdecomparendos) {
        return gestionServiciosComparendos.getRangosdeComparendosCompPorId(rangosdecomparendos);
    }

    @WebMethod
    public List getSRangosdeComparendosComp(RangosdeComparendosComp rangosdecomparendos) {
        return gestionServiciosComparendos.getSRangosdeComparendosComp(rangosdecomparendos);
    }

    @WebMethod
    public boolean crearRangosdeComparendosComp(RangosdeComparendosComp rangosdecomparendos, int idUsuario,
                                                String myIp, String myHost) {
        return gestionServiciosComparendos.crearRangosdeComparendosComp(rangosdecomparendos, idUsuario, myIp, myHost);
    }

    @WebMethod
    public boolean editarRangosdeComparendosComp(RangosdeComparendosComp rangosdecomparendos, int idUsuario,
                                                 String myIp, String myHost) {
        return gestionServiciosComparendos.editarRangosdeComparendosComp(rangosdecomparendos, idUsuario, myIp, myHost);
    }

    @WebMethod
    public boolean eliminarRangosdeComparendosComp(RangosdeComparendosComp rangosdecomparendos, int idUsuario,
                                                   String myIp, String myHost) {
        return gestionServiciosComparendos.eliminarRangosdeComparendosComp(rangosdecomparendos, idUsuario, myIp,
                                                                           myHost);
    }

    @WebMethod
    public List getTDetalleComparendera() {
        return gestionServiciosComparendos.getTDetalleComparendera();
    }

    @WebMethod
    public DetalleComparendera getDetalleComparenderaPorId(DetalleComparendera detallecomparendera) {
        return gestionServiciosComparendos.getDetalleComparenderaPorId(detallecomparendera);
    }

    @WebMethod
    public List getSDetalleComparendera(DetalleComparendera detallecomparendera) {
        return gestionServiciosComparendos.getSDetalleComparendera(detallecomparendera);
    }

    @WebMethod
    public boolean crearDetalleComparendera(DetalleComparendera detallecomparendera, int idUsuario, String myIp,
                                            String myHost) {
        return gestionServiciosComparendos.crearDetalleComparendera(detallecomparendera, idUsuario, myIp, myHost);
    }

    @WebMethod
    public boolean editarDetalleComparendera(DetalleComparendera detallecomparendera, int idUsuario, String myIp,
                                             String myHost) {
        return gestionServiciosComparendos.editarDetalleComparendera(detallecomparendera, idUsuario, myIp, myHost);
    }

    @WebMethod
    public boolean anularComparendo(DetalleComparendera detallecomparendera, int idUsuario, String myIp,
                                    String myHost) {
        return gestionServiciosComparendos.anularComparendo(detallecomparendera, idUsuario, myIp, myHost);
    }

    @WebMethod
    public boolean eliminarDetalleComparendera(DetalleComparendera detallecomparendera, int idUsuario, String myIp,
                                               String myHost) {
        return gestionServiciosComparendos.eliminarDetalleComparendera(detallecomparendera, idUsuario, myIp, myHost);
    }

    @WebMethod
    public List getTViewComparenderas() {
        return gestionServiciosComparendos.getTViewComparenderas();
    }

    @WebMethod
    public List getSViewComparenderas(ViewComparenderas viewcomparendera) {
        return gestionServiciosComparendos.getSViewComparenderas(viewcomparendera);
    }

    @WebMethod
    public List getSViewComparendosInfractor(ViewComparendosInfractor viewcomparendosinfractor) {
        return gestionServiciosComparendos.getSViewComparendosInfractor(viewcomparendosinfractor);
    }

    @WebMethod
    public boolean comparendoDisponibles(String nrocom) {
        return gestionServiciosComparendos.comparendoDisponioble(nrocom);
    }

    @WebMethod
    public int getConsecutivoInmovilizacion() {
        return gestionServiciosComparendos.getConsecutivoInmovilizacion();
    }

    @WebMethod
    public boolean tieneComparendosActivos(String identificacion) {
        return gestionServiciosComparendos.tieneComparendosActivos(identificacion);
    }


}
