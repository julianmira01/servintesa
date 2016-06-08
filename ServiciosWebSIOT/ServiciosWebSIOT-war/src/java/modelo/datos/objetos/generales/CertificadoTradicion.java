package modelo.datos.objetos.generales;

import java.util.ArrayList;

import modelo.datos.objetos.generales.propietarioDeVehiculo.PropietarioDeVehiculo;
import modelo.datos.objetos.generales.vehiculo.Vehiculo;

import modelo.datos.objetos.generales.vehiculo.ViewVehiculo;

import modelo.logica.generales.GestionServiciosTransitoLocal;
import modelo.logica.generales.vehiculo.GestionServiciosVehiculosLocal;
import modelo.logica.generales.vehiculo.GestionServiciosViewVehiculosLocal;
import java.util.List;

import modelo.datos.dao.medidasCautelares.J_PendienteDao;
import modelo.datos.objetos.documentos.CertificadoTrad;
import modelo.datos.objetos.generales.vistas.ViewPropietarioEmpresa;

import modelo.datos.objetos.generales.vistas.ViewPropietarioPersona;

import modelo.datos.objetos.generales.vistas.ViewTramitesVehiculo;
import modelo.datos.objetos.medidasCautelares.J_Pendiente;

import modelo.logica.generales.GestionServiciosMedidasCautelaresLocal;
import modelo.logica.generales.GestionServiciosPropietariosLocal;
import modelo.logica.generales.GestionServiciosViewPropietario;
import modelo.logica.generales.GestionViewGeneralesLocal;


public class CertificadoTradicion {
    
    private Transito transito;
    private ViewVehiculo viewVehiculo;
    private ViewTramitesVehiculo viewTramitesVehiculo;
    private List listaMedidasCautelares;
    private List listaPropietariosPersonas;
    private List listaPropietariosEmpresas;
    private List listaTramitesVehiculo = null;
    //PropietarioDeVehiculo propietarioDeVehiculo;
    private GestionServiciosPropietariosLocal gestionPropietarioDeVehiculo; 
    private GestionServiciosTransitoLocal gestionTransito;
    private GestionServiciosViewVehiculosLocal gestionViewVehiculos;
    private GestionViewGeneralesLocal gestionViewGenerales;
    private GestionServiciosMedidasCautelaresLocal gestionMedidasCautelares; 
        
    public CertificadoTradicion() {
        super();
        crearObjetos();
    }
    
    public void crearObjetos(){
      gestionTransito = new GestionServiciosTransitoLocal();
      gestionViewVehiculos = new GestionServiciosViewVehiculosLocal();
      //propietarioDeVehiculo = new PropietarioDeVehiculo();
      gestionPropietarioDeVehiculo = new GestionServiciosPropietariosLocal();
      gestionViewGenerales = new GestionViewGeneralesLocal();
      gestionMedidasCautelares = new GestionServiciosMedidasCautelaresLocal();
    }
    
    public CertificadoTrad generarCertificadoTradicion(Vehiculo vehi1) {
      //vehiculo = gestionVehiculos.getVehiculo(vehi1);
      int i;
      List listaPropietarios = null;
      listaPropietariosPersonas = null;
      listaPropietariosEmpresas = null;
      listaMedidasCautelares = null;
      listaTramitesVehiculo = null;
      GestionServiciosViewPropietario gestionViewPropietarioVehiculo = null;
      ViewPropietario viewPropietario = null;
      ViewPropietarioEmpresa viewPropietarioEmpresa = null;
      ViewPropietarioPersona viewPropietarioPersona = null;
      J_Pendiente medidaCautelar; 
      
      ViewVehiculo tempViewVehiculo = new ViewVehiculo();
      viewTramitesVehiculo = new ViewTramitesVehiculo();
      gestionViewPropietarioVehiculo = new GestionServiciosViewPropietario();
      viewPropietario = new ViewPropietario();
      medidaCautelar = new J_Pendiente();
      CertificadoTrad certificadoTradicion = new CertificadoTrad();
      
      try{
        if(vehi1 != null)
            tempViewVehiculo.setIDVEHICULO(vehi1.getID_VEHICULO()); 
      
        //Aqui obtengo la informacion del vehiculo
        if(tempViewVehiculo != null)
            viewVehiculo = gestionViewVehiculos.consultarInformacionVehiculo(tempViewVehiculo);
        
        if(viewVehiculo != null)
        {
            viewTramitesVehiculo.setID_VEHICULO(viewVehiculo.getIDVEHICULO());
            certificadoTradicion.setViewVehiculo(viewVehiculo);  
        }
      
        //Aqui obtengo la informacion de la secretaria de transito
        transito = gestionTransito.getTransito(transito);
        certificadoTradicion.setTransito(transito);  
        // propietarioDeVehiculo.setID_VEHICULO(vehi1.getID_VEHICULO());
      
        //Obtengo las medidas cautelares
        if(viewVehiculo != null)
        {
            medidaCautelar.setJP_V_ID(viewVehiculo.getIDVEHICULO());
            listaMedidasCautelares = (ArrayList)gestionMedidasCautelares.ListarMedidaCautelar(medidaCautelar);
            certificadoTradicion.setListaMedidasCautelares(listaMedidasCautelares);
            
            //Aqui obtengo la lista de propietarios del vehiculo los id persona e id empresa
            viewPropietario.setID_VEHICULO(viewVehiculo.getIDVEHICULO());
            listaPropietarios = (ArrayList)gestionViewPropietarioVehiculo.getViewPropietarios(viewPropietario);
            
            if(listaPropietarios != null)
                if(listaPropietarios.size() > 0)
                {
                    listaPropietariosEmpresas = new ArrayList();
                    listaPropietariosPersonas = new ArrayList();
            
                    //Recorro la lista de propietarios del vehiculo
                    for(i=0;i<listaPropietarios.size();i++){
                        //Obtengo cada propietario
                        viewPropietario=(ViewPropietario)listaPropietarios.get(i);  
                        //Si el propietario es una empresa
                        if(viewPropietario.getEMPPER().equals("EMP")){
                        //obtengo los datos de la empresa
                        viewPropietarioEmpresa = new ViewPropietarioEmpresa();
                        viewPropietarioEmpresa.setNIT(viewPropietario.getNIT());
                        viewPropietarioEmpresa = gestionViewGenerales.getUnPropietarioEmpresa(viewPropietarioEmpresa);
                        listaPropietariosEmpresas.add(viewPropietarioEmpresa);
                        }
                        else{
                            if(viewPropietario.getEMPPER().equals("PER")){
                                //obtengo los datos de la persona
                                viewPropietarioPersona = new ViewPropietarioPersona();
                                viewPropietarioPersona.setIDENTIFICACION(viewPropietario.getIDENTIFICACION());
                                viewPropietarioPersona = gestionViewGenerales.getUnPropietarioPersona(viewPropietarioPersona);
                                listaPropietariosPersonas.add(viewPropietarioPersona);
                            }
                        }
                    }
                }
            
            if(listaPropietariosEmpresas != null)
                if(listaPropietariosEmpresas.size() > 0)
                    certificadoTradicion.setListaPropietariosEmpresas(listaPropietariosEmpresas);  
            if(listaPropietariosPersonas != null)
                if(listaPropietariosPersonas.size() > 0)
                    certificadoTradicion.setListaPropietariosPersonas(listaPropietariosPersonas);
        }
      
          
          
        //Obtengo los tramites del vehiculo
        listaTramitesVehiculo = (ArrayList)gestionViewGenerales.getTramitesVehiculo(viewTramitesVehiculo);
        if(listaTramitesVehiculo != null)  
            if(listaTramitesVehiculo.size() > 0)
                certificadoTradicion.setListaTramitesVehiculo(listaTramitesVehiculo);  
          
      }catch(Exception e){
        e.printStackTrace();  
        certificadoTradicion = null;
      }
      return certificadoTradicion;
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
