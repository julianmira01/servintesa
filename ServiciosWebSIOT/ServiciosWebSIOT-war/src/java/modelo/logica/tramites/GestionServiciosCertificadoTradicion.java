package modelo.logica.tramites;

import java.sql.Connection;

import java.util.ArrayList;
import java.util.List;

import modelo.conexion.Conexion;

import modelo.datos.dao.generales.vistas.ViewTramitesVehiculoDao;
import modelo.datos.objetos.generales.AuditoriaSystem;
import modelo.datos.objetos.generales.TramiteBasico;
import modelo.datos.objetos.generales.ViewPropietario;
import modelo.datos.objetos.generales.vehiculo.ViewVehiculo;
import modelo.datos.objetos.generales.vistas.ViewPropietarioEmpresa;
import modelo.datos.objetos.generales.vistas.ViewPropietarioPersona;
import modelo.datos.objetos.generales.vistas.ViewTramitesVehiculo;
import modelo.datos.objetos.medidasCautelares.J_Pendiente;

import modelo.logica.generales.GestionServiciosMedidasCautelaresLocal;
import modelo.logica.generales.GestionServiciosViewPropietario;
import modelo.logica.generales.GestionViewGeneralesLocal;
import modelo.logica.generales.vehiculo.GestionServiciosViewVehiculosLocal;

import utilidades.Auditoria;
import utilidades.Funciones;


public class GestionServiciosCertificadoTradicion {
    Conexion conexion;
    Connection conn;
    String myMotor;
    
    public GestionServiciosCertificadoTradicion() {
        super();
        conexion = new Conexion();
        myMotor = "";
        
        try{
            myMotor = Funciones.leer_ini("/WSTransito.ini", "MOTOR");
        }catch(Exception exce){}
        if(myMotor.equals(""))
        try{
            myMotor = Funciones.leer_ini("c:\\WSTransito.ini", "MOTOR");
        }catch(Exception exce){}
    }
    
    //Aqui obtengo la informacion del vehiculo
    public ViewVehiculo getInfoVehiculo(TramiteBasico tramiteBasico) {
        List lista;
        ViewVehiculo myVehiculo = new ViewVehiculo();
        if(tramiteBasico!=null)
        {
            GestionServiciosViewVehiculosLocal gestionViewVehiculos = new GestionServiciosViewVehiculosLocal();
            myVehiculo.setIDVEHICULO(Integer.parseInt(tramiteBasico.getIdVehiculo()));
            lista=gestionViewVehiculos.getSViewVehiculo(myVehiculo);
            if(lista!=null&&lista.size()>0)
            {
                myVehiculo=(ViewVehiculo)lista.get(0);
            }
            else
                myVehiculo.setIDVEHICULO(-1);
        }
        else
            myVehiculo.setIDVEHICULO(-1);
        return myVehiculo;
    }
    
    public boolean auditarCertificadoTradicion(TramiteBasico tramiteBasico, int idUsuario, String myIp, String myHost) {
        boolean res = false;
        try {
            conn = conexion.conectar();
            Auditoria myAuditoria = new Auditoria();
            AuditoriaSystem myAuditSx = new AuditoriaSystem();
            myAuditSx.setTABLAAFECTADA("TRAMITE BASICO");
            myAuditSx.setCAMPOCLAVE("IDVEHICULO");
            myAuditSx.setVLRCAMPOCLAVE(String.valueOf(tramiteBasico.getIdVehiculo()));
            myAuditSx.setID_USUARIO(idUsuario);
            myAuditSx.setIP(myIp);
            myAuditSx.setNOMBREEQUIPO(myHost);
            myAuditSx.setDESCRIPOPERACION(" Expedicion certificado de tradicion ");
            myAuditSx.setTIPOPERACION("EXPE");
            myAuditoria.auditarOtraOp(conn,myAuditSx, 0);
            res = true;
        }
        catch (Exception e){
          e.printStackTrace();
        }
        finally{
          conexion.cerrarCx();
        }
        return res;
    }
    
    //Obtengo las medidas cautelares
    public List getMedidasCautelares(ViewVehiculo viewVehiculo){
        J_Pendiente medidaCautelar = new J_Pendiente();
        GestionServiciosMedidasCautelaresLocal gestionMedidasCautelares = new GestionServiciosMedidasCautelaresLocal(); 
        List listaMedidasCautelares = null;
        medidaCautelar.setJP_V_ID(viewVehiculo.getIDVEHICULO());
        listaMedidasCautelares = gestionMedidasCautelares.ListarMedidaCautelar(medidaCautelar);
        return listaMedidasCautelares;
    }
    
    //Aqui obtengo la lista de propietarios del vehiculo empresa
    public List getPropietariosVehiculosEmpresas(ViewVehiculo viewVehiculo)
    {
        //Aqui obtengo la lista de propietarios del vehiculo los id persona e id empresa
        int i;
        List listaPropietarios = null;
        GestionServiciosViewPropietario gestionViewPropietarioVehiculo = new GestionServiciosViewPropietario();
        ViewPropietario viewPropietario = new ViewPropietario();
        ViewPropietarioEmpresa viewPropietarioEmpresa = new ViewPropietarioEmpresa();
        GestionViewGeneralesLocal gestionViewGenerales = new GestionViewGeneralesLocal();
        viewPropietario.setID_VEHICULO(viewVehiculo.getIDVEHICULO());
        listaPropietarios = gestionViewPropietarioVehiculo.getViewPropietarios(viewPropietario);
        
        List listaPropietariosEmpresas = new ArrayList();
    
        //Recorro la lista de propietarios del vehiculo
        if(listaPropietarios != null)
            if(listaPropietarios.size() > 0)
                for(i=0;i<listaPropietarios.size();i++){
                    //Obtengo cada propietario
                    viewPropietario=(ViewPropietario)listaPropietarios.get(i);  
                    //Si el propietario es una empresa
                    if(viewPropietario.getEMPPER().equals("EMP")){
                        //obtengo los datos de la empresa
                        viewPropietarioEmpresa.setNIT(viewPropietario.getNIT());
                        viewPropietarioEmpresa = gestionViewGenerales.getUnPropietarioEmpresa(viewPropietarioEmpresa);
                        listaPropietariosEmpresas.add(viewPropietarioEmpresa);
                    }
                }
        return listaPropietariosEmpresas;
    }
    
    //Aqui obtengo la lista de propietarios del vehiculo personas
    public List getPropietariosVehiculosPersonas(ViewVehiculo viewVehiculo)
    {
        //Aqui obtengo la lista de propietarios del vehiculo los id persona e id empresa
        int i;
        List listaPropietarios = null;
        GestionServiciosViewPropietario gestionViewPropietarioVehiculo = new GestionServiciosViewPropietario();
        ViewPropietario viewPropietario = new ViewPropietario();
        ViewPropietarioPersona viewPropietarioPersona = new ViewPropietarioPersona();
        GestionViewGeneralesLocal gestionViewGenerales = new GestionViewGeneralesLocal();
        viewPropietario.setID_VEHICULO(viewVehiculo.getIDVEHICULO());
        listaPropietarios = gestionViewPropietarioVehiculo.getViewPropietarios(viewPropietario);
        
        List listaPropietariosPersonas = new ArrayList();
    
        //Recorro la lista de propietarios del vehiculo
        if(listaPropietarios != null)
            if(listaPropietarios.size() > 0)
                for(i=0;i<listaPropietarios.size();i++){
                    //Obtengo cada propietario
                    viewPropietario=(ViewPropietario)listaPropietarios.get(i);  
                    //Si el propietario es una persona
                    if(viewPropietario.getEMPPER().equals("PER")){
                        //obtengo los datos de la persona
                        viewPropietarioPersona.setIDENTIFICACION(viewPropietario.getIDENTIFICACION());
                        viewPropietarioPersona = gestionViewGenerales.getUnPropietarioPersona(viewPropietarioPersona);
                        listaPropietariosPersonas.add(viewPropietarioPersona);
                    }
                }
        return listaPropietariosPersonas;
    }
    
    //Obtengo los tramites del vehiculo
    public List getTramitesVehiculo(ViewVehiculo viewVehiculo){
        
        ViewTramitesVehiculo viewTramitesVehiculo = new ViewTramitesVehiculo();
        GestionViewGeneralesLocal gestionViewGenerales = new GestionViewGeneralesLocal();
        List listaTramitesVehiculo = null;
        
        viewTramitesVehiculo.setID_VEHICULO(viewVehiculo.getIDVEHICULO());
        listaTramitesVehiculo = (ArrayList)gestionViewGenerales.getTramitesVehiculo(viewTramitesVehiculo);
        return listaTramitesVehiculo;
    }
    
    public List getViewTramitesVehiculo(ViewTramitesVehiculo viewTramitesVehiculo){
        ViewTramitesVehiculoDao myViewTramVehiDao;
        List lista = null;
        int id=0;
        try {
            conn = conexion.conectar();
            myViewTramVehiDao = new ViewTramitesVehiculoDao();
            lista = myViewTramVehiDao.searchMatching(conn, viewTramitesVehiculo);
        }
        catch (Exception e){
          e.printStackTrace();
        }
        finally{
          conexion.cerrarCx();
        }
        return lista;
    }

}
