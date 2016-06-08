package modelo.datos.objetos.documentos;

import java.util.List;

import modelo.datos.objetos.generales.CertificadoTradicion;
import modelo.datos.objetos.generales.Transito;
import modelo.datos.objetos.generales.ViewPropietario;
import modelo.datos.objetos.generales.vehiculo.ViewVehiculo;
import modelo.datos.objetos.generales.vistas.ViewPropietarioEmpresa;
import modelo.datos.objetos.generales.vistas.ViewPropietarioPersona;
import modelo.datos.objetos.generales.vistas.ViewTramitesVehiculo;
import modelo.datos.objetos.medidasCautelares.J_Pendiente;

import modelo.logica.generales.GestionServiciosViewPropietario;

public class CertificadoTrad {
    
    private Transito transito;
    private ViewVehiculo viewVehiculo;
    private ViewTramitesVehiculo viewTramitesVehiculo;
    private List listaMedidasCautelares;
    private List listaPropietariosPersonas;
    private List listaPropietariosEmpresas;
    private List listaTramitesVehiculo;
    
    public CertificadoTrad() {
        super();
    }


    public void setTransito(Transito transito) {
        this.transito = transito;
    }

    public Transito getTransito() {
        return transito;
    }

    public void setViewVehiculo(ViewVehiculo viewVehiculo) {
        this.viewVehiculo = viewVehiculo;
    }

    public ViewVehiculo getViewVehiculo() {
        return viewVehiculo;
    }

    public void setViewTramitesVehiculo(ViewTramitesVehiculo viewTramitesVehiculo) {
        this.viewTramitesVehiculo = viewTramitesVehiculo;
    }

    public ViewTramitesVehiculo getViewTramitesVehiculo() {
        return viewTramitesVehiculo;
    }

    public void setListaMedidasCautelares(List listaMedidasCautelares) {
        this.listaMedidasCautelares = listaMedidasCautelares;
    }

    public List getListaMedidasCautelares() {
        return listaMedidasCautelares;
    }

    public void setListaPropietariosPersonas(List listaPropietariosPersonas) {
        this.listaPropietariosPersonas = listaPropietariosPersonas;
    }

    public List getListaPropietariosPersonas() {
        return listaPropietariosPersonas;
    }

    public void setListaPropietariosEmpresas(List listaPropietariosEmpresas) {
        this.listaPropietariosEmpresas = listaPropietariosEmpresas;
    }

    public List getListaPropietariosEmpresas() {
        return listaPropietariosEmpresas;
    }

    public void setListaTramitesVehiculo(List listaTramitesVehiculo) {
        this.listaTramitesVehiculo = listaTramitesVehiculo;
    }

    public List getListaTramitesVehiculo() {
        return listaTramitesVehiculo;
    }
}
