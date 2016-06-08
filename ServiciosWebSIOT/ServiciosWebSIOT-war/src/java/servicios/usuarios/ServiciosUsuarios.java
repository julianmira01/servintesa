package servicios.usuarios;

import java.util.List;

import javax.jws.Oneway;
import javax.jws.WebMethod;
import javax.jws.WebService;

import modelo.datos.dao.rangos.RangosDeplacasDao;
import modelo.datos.objetos.liquidacion.Factura;

import modelo.datos.dao.tramites.CabrequisitobaseDao;
import modelo.datos.objetos.accesorias.MotivoDeCancelacion;
import modelo.datos.objetos.generales.RuntDuplicadoPlaca;
import modelo.datos.objetos.generales.RuntRegrabacionVehiculo;
import modelo.datos.objetos.generales.TramiteBasico;

import modelo.datos.objetos.generales.Usuarios;
import modelo.datos.objetos.generales.vehiculo.Vehiculo;
import modelo.datos.objetos.liquidacion.Factura;
import modelo.datos.objetos.radicacion.Cita;
import modelo.datos.objetos.radicacion.DetCita;
import modelo.datos.objetos.radicacion.RadRequisitoGral;
import modelo.datos.objetos.tramites.Cabrequisitobase;
import modelo.datos.objetos.tramites.CambioColor;

import modelo.datos.objetos.tramites.CambioServicio;

import modelo.datos.objetos.radicacion.RadicadoDeVehiculos;
import modelo.datos.objetos.radicacion.TramiteDependencia;
import modelo.datos.objetos.radicacion.TramitesPorDependencia;
import modelo.datos.objetos.radicacion.TramitesVehiculosRadicados;
import modelo.datos.objetos.rangos.RangosDeplacas;
import modelo.datos.objetos.rangos.RangosLicencias;
import modelo.datos.objetos.tramites.CancelacionMatricula;
import modelo.datos.objetos.tramites.Detrequisitobase;
import modelo.datos.objetos.tramites.Reqxtramite;
import modelo.datos.objetos.tramites.Subtipotramite;
import modelo.datos.objetos.tramites.Tramiteinterno;


import modelo.datos.objetos.usuarios.PerfilOpcion;
import modelo.datos.objetos.usuarios.Perfiles;

import modelo.logica.liquidacion.GestionServiciosLiquidacionLocal;
import modelo.logica.radicacion.GestionServiciosRadicacionTramites;
import modelo.logica.rangos.GestionServiciosRangos;

import modelo.logica.usuarios.GestionServiciosUsuarios;

import servicios.generales.ServiciosGenerales;

import modelo.logica.clavesutilizadas.GestionClavesutilizadas;
import modelo.logica.historico_claves.GestionHistoricoclaves;
import modelo.datos.objetos.historico_claves.Historicoclaves;
import modelo.datos.objetos.clavesutilizadas.Clavesutilizadas;


@WebService
public class ServiciosUsuarios {
    GestionServiciosUsuarios gestionServiciosUsuarios;
    GestionHistoricoclaves gestionHistoricoclaves;
    GestionClavesutilizadas gestionClavesutilizadas;

    public ServiciosUsuarios() {
        super();
        crearObjetos();
    }

    @Oneway
    @WebMethod
    public void crearObjetos() {
        gestionServiciosUsuarios = new GestionServiciosUsuarios();
        gestionHistoricoclaves = new GestionHistoricoclaves();
        gestionClavesutilizadas = new GestionClavesutilizadas();
    }

    /////////////////////////////////////////////////////
    /////////Gestion de Usuarios SINTRAT/////////////////
    /////////////////////////////////////////////////////

    @WebMethod
    public List getUsuarios(Usuarios usuario) throws Exception {
        try{
        return gestionServiciosUsuarios.getUsuarios(usuario,0);
        }catch(Exception e){throw new Exception(e.getMessage());} 
    }

    @WebMethod
    public List listarUsuarios() throws Exception {
        try{
        return gestionServiciosUsuarios.getUsuarios(0);
        }catch(Exception e){throw new Exception(e.getMessage());} 
    }

    @WebMethod
    public List listarPerfiles()throws Exception {
        try{
        return gestionServiciosUsuarios.getPerfiles(0);
        }catch(Exception e){throw new Exception (e.getMessage());}
    }

    @WebMethod
    public Perfiles insertarPerfil(Perfiles myPerfil) {
        return gestionServiciosUsuarios.insertarPerfil(myPerfil,0);
    }

    @WebMethod
    public Usuarios insertarUsuario(Usuarios myUsuario, int idUsuario, String myIp, String myHost) {
        return gestionServiciosUsuarios.insertarUsuario(myUsuario, idUsuario, myIp, myHost,0);
    }

    @WebMethod
    public Usuarios validarUsuario(Usuarios myUsuario, String ipAdress) throws Exception {
        try{
        return gestionServiciosUsuarios.validarUsuario(myUsuario,0,ipAdress);
        }catch(Exception e){
                throw new Exception(e.getMessage());
            }
    }
    
    @WebMethod
    public boolean validarSession(Usuarios myUsuario, String ipAdress) throws Exception {
        try{
            return gestionServiciosUsuarios.validarSesionActiva(myUsuario,ipAdress);
        }catch(Exception e){
                return false;
            }
    }        

    @WebMethod
    public int cambiarInicio(Usuarios myUsuario, String myCadena) {
        return gestionServiciosUsuarios.cambiarInicio(myUsuario, myCadena,0);
    }

    @WebMethod
    public Usuarios actualizarUsuario(Usuarios myUsuario, int idUsuario, String myIp, String myHost, boolean actualizarFechaClave) {
        return gestionServiciosUsuarios.actualizarUsuario(myUsuario, idUsuario, myIp, myHost,0, actualizarFechaClave);
    }

    @WebMethod
    public List OpcionesDePerfil(PerfilOpcion myPerOpc) throws Exception {
        return gestionServiciosUsuarios.getOpcionesPerfil(myPerOpc,0);
    }

    @WebMethod
    public PerfilOpcion insertarOpcionDePerfil(PerfilOpcion myPerOpc) {
        return gestionServiciosUsuarios.insertarPerfilOpcion(myPerOpc,0);
    }

    @WebMethod
    public void cerrarSesion(int idUsuario)throws Exception {
        try{gestionServiciosUsuarios.cerrarSesion(idUsuario);
        }catch(Exception e){throw new Exception (e.getMessage());}
    }

    @WebMethod
    public void eliminarOpcionDePerfil(PerfilOpcion myPerOpc) {
        gestionServiciosUsuarios.eliminarPerfilOpcion(myPerOpc,0);
    }

    /////////////////////////////////////////////////////
    /////////Gestion de Usuarios Comparendos/////////////////
    /////////////////////////////////////////////////////

    @WebMethod
    public List getUsuariosComp(Usuarios usuario) throws Exception {
        try{
        return gestionServiciosUsuarios.getUsuarios(usuario,1);
        }catch(Exception e){throw new Exception(e.getMessage());} 
    }

    @WebMethod
    public List listarUsuariosComp() throws Exception 
    {
        try{
        return gestionServiciosUsuarios.getUsuarios(1);
        }catch(Exception e){throw new Exception(e.getMessage());} 
    }

    @WebMethod
    public List listarPerfilesComp() {
        return gestionServiciosUsuarios.getPerfiles(1);
    }

    @WebMethod
    public Perfiles insertarPerfilComp(Perfiles myPerfil) {
        return gestionServiciosUsuarios.insertarPerfil(myPerfil,1);
    }

    @WebMethod
    public Usuarios insertarUsuarioComp(Usuarios myUsuario, int idUsuario, String myIp, String myHost) {
        return gestionServiciosUsuarios.insertarUsuario(myUsuario, idUsuario, myIp, myHost,1);
    }

    @WebMethod
    public Usuarios validarUsuarioComp(Usuarios myUsuario, String ipAdress) throws Exception {
        try{
        return gestionServiciosUsuarios.validarUsuario(myUsuario,1,ipAdress);
        }catch(Exception e){throw new Exception (e.getMessage());}
    }

    @WebMethod
    public int cambiarInicioComp(Usuarios myUsuario, String myCadena) {
        return gestionServiciosUsuarios.cambiarInicio(myUsuario, myCadena,1);
    }

    @WebMethod
    public Usuarios actualizarUsuarioComp(Usuarios myUsuario, int idUsuario, String myIp, String myHost, boolean actualizarFechaClave) {
        return gestionServiciosUsuarios.actualizarUsuario(myUsuario, idUsuario, myIp, myHost,1,actualizarFechaClave);
    }

    @WebMethod
    public List OpcionesDePerfilComp(PerfilOpcion myPerOpc) {
        return gestionServiciosUsuarios.getOpcionesPerfil(myPerOpc,1);
    }

    @WebMethod
    public PerfilOpcion insertarOpcionDePerfilComp(PerfilOpcion myPerOpc) {
        return gestionServiciosUsuarios.insertarPerfilOpcion(myPerOpc,1);
    }

    @WebMethod
    public void eliminarOpcionDePerfilComp(PerfilOpcion myPerOpc) {
        gestionServiciosUsuarios.eliminarPerfilOpcion(myPerOpc,1);
    }
    /////////////////////////////////////////////////////
    ////////// Gestion de Usuarios Comun/////////////////
    /////////////////////////////////////////////////////


    @WebMethod
    public boolean probarConexion(boolean reply) {
        return reply;
    }
    
    @WebMethod
        public Historicoclaves crearHistoricoclaves(int id, String token, Historicoclaves obj ) {
                
                                return gestionHistoricoclaves.crearHistoricoclaves(obj); 
        }
        
        @WebMethod
        public boolean editarHistoricoclaves(int id, String token,Historicoclaves obj) {
                
                                return gestionHistoricoclaves.editarHistoricoclaves(obj);
        }
        
        @WebMethod
        public Historicoclaves buscarPrimeroHistoricoclaves(int id, String token,Historicoclaves obj) {
                
                                return gestionHistoricoclaves.buscarPrimeroHistoricoclaves(obj);
        }
        
        @WebMethod
        public List buscarHistoricoclaves(int id, String token,Historicoclaves obj) {
                
                                return gestionHistoricoclaves.buscarHistoricoclaves(obj);
        }
        
        @WebMethod
        public List buscarPaginacionHistoricoclaves(int id, String token,Historicoclaves obj,int pag,int numReg) {
                
                                return gestionHistoricoclaves.buscarHistoricoclaves(obj, pag, numReg);
        }
        
        @WebMethod
        public List listarHistoricoclaves(int id, String token) {
                
                        return gestionHistoricoclaves.listarHistoricoclaves();
        }
        
        @WebMethod
        public List listarPaginacionHistoricoclaves(int id, String token,int pag,int numReg) {
                
                        return gestionHistoricoclaves.listarHistoricoclaves(pag, numReg);
        }
        
        @WebMethod
        public int contarBusquedaHistoricoclaves(int id, String token,Historicoclaves obj) {
                
                                return gestionHistoricoclaves.contarBusquedaHistoricoclaves(obj);
        }
        
        @WebMethod
        public boolean eliminarHistoricoclaves(int id, String token,Historicoclaves obj) {
                
                                return gestionHistoricoclaves.eliminarHistoricoclaves(obj);
        }
        
        @WebMethod
        public Clavesutilizadas crearClavesutilizadas(int id, String token, Clavesutilizadas obj ) {
            return gestionClavesutilizadas.crearClavesutilizadas(obj); 
        }
                
        @WebMethod
        public boolean editarClavesutilizadas(int id, String token,Clavesutilizadas obj) {
            return gestionClavesutilizadas.editarClavesutilizadas(obj);
        }
                
        @WebMethod
        public Clavesutilizadas buscarPrimeroClavesutilizadas(int id, String token,Clavesutilizadas obj) {
            return gestionClavesutilizadas.buscarPrimeroClavesutilizadas(obj);
        }
                
        @WebMethod
        public List buscarClavesutilizadas(int id, String token,Clavesutilizadas obj) {
            return gestionClavesutilizadas.buscarClavesutilizadas(obj);
        }
                
        @WebMethod
        public List buscarPaginacionClavesutilizadas(int id, String token,Clavesutilizadas obj,int pag,int numReg) {
            return gestionClavesutilizadas.buscarClavesutilizadas(obj, pag, numReg);
        }
                
        @WebMethod
        public List listarClavesutilizadas(int id, String token) {
            return gestionClavesutilizadas.listarClavesutilizadas();
        }
                
        @WebMethod
        public List listarPaginacionClavesutilizadas(int id, String token,int pag,int numReg) {
            return gestionClavesutilizadas.listarClavesutilizadas(pag, numReg);
        }
                
        @WebMethod
        public int contarBusquedaClavesutilizadas(int id, String token,Clavesutilizadas obj) {
            return gestionClavesutilizadas.contarBusquedaClavesutilizadas(obj);
        }
                
        @WebMethod
        public boolean eliminarClavesutilizadas(int id, String token,Clavesutilizadas obj) {
            return gestionClavesutilizadas.eliminarClavesutilizadas(obj);
        }
}

