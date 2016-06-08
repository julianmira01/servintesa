package servicios.comparendos;

import java.util.List;

import javax.jws.WebService;

import modelo.datos.objetos.radicacion.Cita;
import modelo.datos.objetos.radicacion.DetCita;
import modelo.datos.objetos.radicacion.TramiteDependencia;
import modelo.datos.objetos.radicacion.TramitesPorDependencia;

import modelo.logica.radicacion.GestionServiciosRadicacionTramites;


@WebService
public class ServiciosCitasComp {
    GestionServiciosRadicacionTramites gestionServiciosRadicacion;

    public ServiciosCitasComp() {
        super();
        crearObjetos();
    }

    public void crearObjetos() {
        gestionServiciosRadicacion = new GestionServiciosRadicacionTramites();
    }

    public List buscarTramitePorDependencia(TramitesPorDependencia myTraPorDep) {
        return gestionServiciosRadicacion.getTramitePorDependencia(myTraPorDep, 1);
    }

    public TramiteDependencia insertarTramiteDependencia(TramiteDependencia myTramDep) {
        return gestionServiciosRadicacion.insertarTramiteDependencia(myTramDep, 1);
    }

    public void eliminarTramiteDependencia(TramiteDependencia myTramDep) {
        gestionServiciosRadicacion.eliminarTramiteDependencia(myTramDep, 1);
    }

    public Cita insertarCita(Cita myCita, int idUsuario, String myIp, String myHost) {
        return gestionServiciosRadicacion.insertarCita(myCita, idUsuario, myIp, myHost, 1);
    }

    public Cita terminarCita(Cita myCita, int idUsuario, String myIp, String myHost) {
        return gestionServiciosRadicacion.terminarCita(myCita, idUsuario, myIp, myHost, 1);
    }

    public Cita anularCita(Cita myCita, int idUsuario, String myIp, String myHost) {
        return gestionServiciosRadicacion.anularCita(myCita, idUsuario, myIp, myHost, 1);
    }

    public List buscarCita(Cita myCita) {
        return gestionServiciosRadicacion.getCita(myCita, 1);
    }

    public Cita ponerObservacionCita(Cita myCita) {
        return gestionServiciosRadicacion.ponerObservacionCita(myCita, 1);
    }

    public DetCita insertarDetCita(DetCita myDetCita) {
        return gestionServiciosRadicacion.insertarDetCita(myDetCita, 1);
    }

    public List buscarDetCita(DetCita myDetCita) {
        return gestionServiciosRadicacion.getDetCita(myDetCita, 1);
    }

    public void eliminarDetCita(DetCita myDetCita) {
        gestionServiciosRadicacion.eliminarDetCita(myDetCita, 1);
    }
}
