package servicios.generales;

import java.util.List;

import javax.jws.WebService;

import modelo.datos.objetos.generales.HistoriaDeVehiculo;

import modelo.logica.generales.GestionServiciosHistoriaDeVehiculo;


@WebService
public class ServiciosHistoriaDeVehiculo {
    private GestionServiciosHistoriaDeVehiculo myGesionHistoriaVehiculo;

    public ServiciosHistoriaDeVehiculo() {
        super();
        myGesionHistoriaVehiculo = new GestionServiciosHistoriaDeVehiculo();
    }

    public HistoriaDeVehiculo getHistoriaDeVehiculo(HistoriaDeVehiculo myHistoriaDeVehiculo)
    {
        return myGesionHistoriaVehiculo.getHistoriaDeVehiculo(myHistoriaDeVehiculo);
    }
    
    public List getHistoriasDeVehiculo(HistoriaDeVehiculo myHistoriaDeVehiculo)
    {
        return myGesionHistoriaVehiculo.getHistoriasDeVehiculo(myHistoriaDeVehiculo);
    }
    
    public List getHistoricoVehiculosSinFecha()
    {
        return myGesionHistoriaVehiculo.getHistoricoVehiculosSinFecha();
    }

    public HistoriaDeVehiculo crearHistoriaDeVehiculo(HistoriaDeVehiculo myHistoria) {
        return myGesionHistoriaVehiculo.crearHistoriaDeVehiculo(myHistoria, false);
    }

    public HistoriaDeVehiculo crearHistoriaDeVehiculoDesatrasar(HistoriaDeVehiculo myHistoria) {
        return myGesionHistoriaVehiculo.crearHistoriaDeVehiculo(myHistoria, true);
    }
    
    public boolean actualizarHistoriaDeVehiculo(HistoriaDeVehiculo myHistoria) {
        return myGesionHistoriaVehiculo.actualizarHistoriaDeVehiculo(myHistoria);
    }
    
    public boolean eliminarHistoriaDeVehiculo(HistoriaDeVehiculo myHistoria) {
        return myGesionHistoriaVehiculo.eliminarHistoriaDeVehiculo(myHistoria);
    }
}
