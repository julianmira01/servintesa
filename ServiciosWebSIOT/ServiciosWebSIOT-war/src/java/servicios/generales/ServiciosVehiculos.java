package servicios.generales;

import java.sql.SQLException;

import java.util.List;

import javax.jws.Oneway;
import javax.jws.WebMethod;
import javax.jws.WebService;

import modelo.datos.objetos.Subarancelaria.Subarancelaria;
import modelo.datos.objetos.Tiporodaje.Tiporodaje;
import modelo.datos.objetos.camposRemolques.Camposremolques;
import modelo.datos.objetos.generales.vehiculo.LInfoVehiculo;
import modelo.datos.objetos.generales.vehiculo.VehInmovilizacion;
import modelo.datos.objetos.generales.vehiculo.Vehiculo;
import modelo.datos.objetos.generales.vehiculo.VehiculoNovedad;

import modelo.logica.Subarancelaria.GestionSubarancelaria;
import modelo.logica.Tiporodaje.GestionTiporodaje;
import modelo.logica.generales.vehiculo.GestionServiciosLInfoVehiculos;
import modelo.logica.generales.vehiculo.GestionServiciosVehInmovilizacion;
import modelo.logica.generales.vehiculo.GestionServiciosVehiculosLocal;
import modelo.logica.camposRemolques.GestionCamposremolques;

import utilidades.Seguridad;


@WebService
public class ServiciosVehiculos {

    GestionServiciosVehiculosLocal gestionServiciosVehiculosLocal;
    GestionServiciosLInfoVehiculos gestionServiciosLInfoVehiculos;
    GestionServiciosVehInmovilizacion gestionServiciosVehInmovilizacion;
    GestionCamposremolques gestionServiciosCamposremolques;
    GestionSubarancelaria gestionSubarancelaria;
    GestionTiporodaje gestionTiporodaje;


    public ServiciosVehiculos() {
        super();
        crearObjetos();
    }

    @Oneway
    @WebMethod
    public void crearObjetos() {
        gestionServiciosVehiculosLocal = new GestionServiciosVehiculosLocal();
        gestionServiciosCamposremolques = new GestionCamposremolques();
        gestionSubarancelaria = new GestionSubarancelaria();
        gestionTiporodaje = new GestionTiporodaje();
    }

    @WebMethod
    public Vehiculo getVehiculo(Vehiculo vehiculo) {
        return gestionServiciosVehiculosLocal.getVehiculo(vehiculo);
    }

    @WebMethod
    public Vehiculo crearVehiculo(Vehiculo vehiculo, int idUsuario, String myIp, String myHost) {
        return gestionServiciosVehiculosLocal.crearVehiculo(vehiculo, idUsuario, myIp, myHost);
    }

    @WebMethod
    public Vehiculo activarVehiculo(Vehiculo vehiculo, int idUsuario, String myIp, String myHost) {
        return gestionServiciosVehiculosLocal.activarVehiculo(vehiculo, idUsuario, myIp, myHost);
    }

    @WebMethod
    public boolean validarVehiculoExisteBaseDatos(Vehiculo vehiculo) {
        return gestionServiciosVehiculosLocal.validarVehiculoExisteBaseDatos(vehiculo);
    }

    @WebMethod
    public boolean validarVehiculoActivo(Vehiculo vehiculo) {
        return gestionServiciosVehiculosLocal.validarVehiculoActivo(vehiculo);
    }

    @WebMethod
    public boolean actualizarVehiculo(Vehiculo vehiculo, int idUsuario, String myIp, String myHost) {
        return gestionServiciosVehiculosLocal.actualizarVehiculo(vehiculo, idUsuario, myIp, myHost);
    }

    @WebMethod
    public boolean actualizarTrasladoCuenta(Vehiculo vehiculo, int idUsuario, String myIp, String myHost) {
        return gestionServiciosVehiculosLocal.actualizarTrasladoCuenta(vehiculo, idUsuario, myIp, myHost);
    }

    public boolean crearVehiculoNovedad(Vehiculo vehiculo) {
        return gestionServiciosVehiculosLocal.crearVehiculoNov(vehiculo);
    }

    public boolean eliminarVehiculoNovedad(VehiculoNovedad vehiculoNov) {
        return gestionServiciosVehiculosLocal.eliminarVehiculoNov(vehiculoNov);
    }

    public boolean actualizarVehiculoNovedad(VehiculoNovedad vehiculoNov) {
        return gestionServiciosVehiculosLocal.actualizarVehiculoNov(vehiculoNov);
    }

    public boolean eliminarVehiculo(Vehiculo vehiculo, int idUsuario, String myIp, String myHost) {
        return gestionServiciosVehiculosLocal.eliminarVehiculo(vehiculo, idUsuario, myIp, myHost);
    }

    //info vehiculo

    @WebMethod
    public LInfoVehiculo getInfoVehiculoPorIdVehiculo(LInfoVehiculo infoVehiculo) {
        gestionServiciosLInfoVehiculos = new GestionServiciosLInfoVehiculos();
        return gestionServiciosLInfoVehiculos.getInfoVehiculoPorIdVehiculo(infoVehiculo);
    }

    @WebMethod
    public boolean createInfoVehiculo(LInfoVehiculo infoVehiculo, int idUsuario, String myIp, String myHost) {
        gestionServiciosLInfoVehiculos = new GestionServiciosLInfoVehiculos();
        return gestionServiciosLInfoVehiculos.createInfoVehiculo(infoVehiculo, idUsuario, myIp, myHost);
    }

    @WebMethod
    public boolean editarInfoVehiculo(LInfoVehiculo infoVehiculo, int idUsuario, String myIp, String myHost) {
        gestionServiciosLInfoVehiculos = new GestionServiciosLInfoVehiculos();
        return gestionServiciosLInfoVehiculos.editar(infoVehiculo, idUsuario, myIp, myHost);
    }
    
    @WebMethod
    public boolean editarGrupoLiquidacion(LInfoVehiculo infoVehiculo, int idUsuario, String myIp, String myHost) {
        gestionServiciosLInfoVehiculos = new GestionServiciosLInfoVehiculos();
        return gestionServiciosLInfoVehiculos.editarGrupoLiquidacion(infoVehiculo, idUsuario, myIp, myHost);
    }

    //vehiculo inmovilizacion

    public VehInmovilizacion crearVehInmovilizacion(VehInmovilizacion obj, int idUsuario, String myIp, String myHost) {
        gestionServiciosVehInmovilizacion = new GestionServiciosVehInmovilizacion();
        return gestionServiciosVehInmovilizacion.crear(obj, idUsuario, myIp, myHost);
    }

    public boolean editarVehInmovilizacion(VehInmovilizacion obj, int idUsuario, String myIp, String myHost) {
        gestionServiciosVehInmovilizacion = new GestionServiciosVehInmovilizacion();
        return gestionServiciosVehInmovilizacion.editar(obj, idUsuario, myIp, myHost);
    }
    
    public boolean editarVehInmovilizacionEstado(VehInmovilizacion obj) {
        gestionServiciosVehInmovilizacion = new GestionServiciosVehInmovilizacion();
        return gestionServiciosVehInmovilizacion.editarEstado(obj);
    }
    
    public boolean editarVehInmovilizacionHoraFechaFinNull(VehInmovilizacion obj) {
        gestionServiciosVehInmovilizacion = new GestionServiciosVehInmovilizacion();
        return gestionServiciosVehInmovilizacion.editarFechaHoraFinNull(obj);
    }

    public List listarVehInmovilizacion() {
        gestionServiciosVehInmovilizacion = new GestionServiciosVehInmovilizacion();
        return gestionServiciosVehInmovilizacion.listar();
    }

    public List getVehInmovilizacion(VehInmovilizacion obj) {
        gestionServiciosVehInmovilizacion = new GestionServiciosVehInmovilizacion();
        return gestionServiciosVehInmovilizacion.get(obj);
    }

    public boolean auditarLiberarPlaca(Vehiculo obj, int idUsuario, String myIp, String myHost) {
        return gestionServiciosVehiculosLocal.auditarLiberarPlaca(obj, idUsuario, myIp, myHost);
    }


    //SERVICIOS REMOLQUES Y SEMIREMOLQUES

    @WebMethod
            public Camposremolques crearCamposremolques(int id, String token, Camposremolques obj ) {
                    return gestionServiciosCamposremolques.crearCamposremolques(obj); 
            }
            
            @WebMethod
            public boolean editarCamposremolques(int id, String token,Camposremolques obj) {
                    return gestionServiciosCamposremolques.editarCamposremolques(obj);
            }
            
            @WebMethod
            public Camposremolques buscarPrimeroCamposremolques(int id, String token,Camposremolques obj) {
                    return gestionServiciosCamposremolques.buscarPrimeroCamposremolques(obj);
            }
            
            @WebMethod
            public List buscarCamposremolques(int id, String token,Camposremolques obj) {
                    return gestionServiciosCamposremolques.buscarCamposremolques(obj);
            }
            
            @WebMethod
            public List buscarPaginacionCamposremolques(int id, String token,Camposremolques obj,int pag,int numReg) {
                   return gestionServiciosCamposremolques.buscarCamposremolques(obj, pag, numReg);
            }
            
            @WebMethod
            public List listarCamposremolques(int id, String token) {
                    return gestionServiciosCamposremolques.listarCamposremolques();
            }
            
            @WebMethod
            public List listarPaginacionCamposremolques(int id, String token,int pag,int numReg) {
                    return gestionServiciosCamposremolques.listarCamposremolques(pag, numReg);
            }
            
            @WebMethod
            public int contarBusquedaCamposremolques(int id, String token,Camposremolques obj) {
                    return gestionServiciosCamposremolques.contarBusquedaCamposremolques(obj);
            }
            
            @WebMethod
            public boolean eliminarCamposremolques(int id, String token,Camposremolques obj) {
                    return gestionServiciosCamposremolques.eliminarCamposremolques(obj);
            }    
            
            
            
            
            
            @WebMethod
            public Subarancelaria crearSubarancelaria(int id, String token, Subarancelaria obj ) {
                return gestionSubarancelaria.crearSubarancelaria(obj); 
            }
            
            @WebMethod
            public boolean editarSubarancelaria(int id, String token,Subarancelaria obj) {
                                    return gestionSubarancelaria.editarSubarancelaria(obj);
            }
            
            @WebMethod
            public Subarancelaria buscarPrimeroSubarancelaria(int id, String token,Subarancelaria obj) {
                                    return gestionSubarancelaria.buscarPrimeroSubarancelaria(obj);
            }
            
            @WebMethod
            public List buscarSubarancelaria(int id, String token,Subarancelaria obj) {
                                    return gestionSubarancelaria.buscarSubarancelaria(obj);
            }
            
            @WebMethod
            public List buscarPaginacionSubarancelaria(int id, String token,Subarancelaria obj,int pag,int numReg) {
                                    return gestionSubarancelaria.buscarSubarancelaria(obj, pag, numReg);
            }
            
            @WebMethod
            public List listarSubarancelaria(int id, String token) {
                            return gestionSubarancelaria.listarSubarancelaria();
            }
            
            @WebMethod
            public List listarPaginacionSubarancelaria(int id, String token,int pag,int numReg) {
                            return gestionSubarancelaria.listarSubarancelaria(pag, numReg);
            }
            
            @WebMethod
            public int contarBusquedaSubarancelaria(int id, String token,Subarancelaria obj) {
                                    return gestionSubarancelaria.contarBusquedaSubarancelaria(obj);
            }
            
            @WebMethod
            public boolean eliminarSubarancelaria(int id, String token,Subarancelaria obj) {
                                    return gestionSubarancelaria.eliminarSubarancelaria(obj);
            }

            
            
            
            
            
            @WebMethod
            public Tiporodaje crearTiporodaje(int id, String token, Tiporodaje obj ) {
                                    return gestionTiporodaje.crearTiporodaje(obj); 
            }
            
            @WebMethod
            public boolean editarTiporodaje(int id, String token,Tiporodaje obj) {
                                    return gestionTiporodaje.editarTiporodaje(obj);
            }
            
            @WebMethod
            public Tiporodaje buscarPrimeroTiporodaje(int id, String token,Tiporodaje obj) {
                                    return gestionTiporodaje.buscarPrimeroTiporodaje(obj);
            }
            
            @WebMethod
            public List buscarTiporodaje(int id, String token,Tiporodaje obj) {
                                    return gestionTiporodaje.buscarTiporodaje(obj);
            }
            
            @WebMethod
            public List buscarPaginacionTiporodaje(int id, String token,Tiporodaje obj,int pag,int numReg) {
                                    return gestionTiporodaje.buscarTiporodaje(obj, pag, numReg);
            }
            
            @WebMethod
            public List listarTiporodaje(int id, String token) {
                            return gestionTiporodaje.listarTiporodaje();
            }
            
            @WebMethod
            public List listarPaginacionTiporodaje(int id, String token,int pag,int numReg) {
                            return gestionTiporodaje.listarTiporodaje(pag, numReg);
            }
            
            @WebMethod
            public int contarBusquedaTiporodaje(int id, String token,Tiporodaje obj) {
                                    return gestionTiporodaje.contarBusquedaTiporodaje(obj);
            }
            
            @WebMethod
            public boolean eliminarTiporodaje(int id, String token,Tiporodaje obj) {
                                    return gestionTiporodaje.eliminarTiporodaje(obj);
            }
}
