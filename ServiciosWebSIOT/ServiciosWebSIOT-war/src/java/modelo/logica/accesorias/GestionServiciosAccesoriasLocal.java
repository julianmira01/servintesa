package modelo.logica.accesorias;

import java.sql.Connection;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;

import modelo.conexion.Conexion;

import modelo.datos.dao.accesorias.CampoDao;
import modelo.datos.dao.accesorias.CiudadDao;
import modelo.datos.dao.accesorias.ClaseEmpresaDao;
import modelo.datos.dao.accesorias.ClaseVehiculoDao;
import modelo.datos.dao.accesorias.ColoresDao;
import modelo.datos.dao.accesorias.CombustibleDao;
import modelo.datos.dao.accesorias.DepartamentoDao;
import modelo.datos.dao.accesorias.DependenciaDao;
import modelo.datos.dao.accesorias.DireccionDao;
import modelo.datos.dao.accesorias.DocumentoDao;
import modelo.datos.dao.accesorias.EmpresaAseguradoraDao;
import modelo.datos.dao.accesorias.EscuelasConduccionDao;
import modelo.datos.dao.accesorias.EspecieVenalDao;
import modelo.datos.dao.accesorias.EstadosFacturaDao;
import modelo.datos.dao.accesorias.GradoAlertaDao;
import modelo.datos.dao.accesorias.GrupoSanguineoDao;
import modelo.datos.dao.accesorias.LClaseVehiculoDao;
import modelo.datos.dao.accesorias.LTiposPagoDao;
import modelo.datos.dao.accesorias.LimitacionPropiedadDao;
import modelo.datos.dao.accesorias.MarcaDao;
import modelo.datos.dao.accesorias.ModalidadDao;
import modelo.datos.dao.accesorias.MotivoDeCancelacionDao;
import modelo.datos.dao.accesorias.MotivoDuplicadoDao;
import modelo.datos.dao.accesorias.NiveldeServicioDao;
import modelo.datos.dao.accesorias.OrgExpideDoctoDao;
import modelo.datos.dao.accesorias.OrganismoTransitoDao;
import modelo.datos.dao.accesorias.PaisDao;
import modelo.datos.dao.accesorias.RequisitotramiteDao;
import modelo.datos.dao.accesorias.RuntAduanaDao;
import modelo.datos.dao.accesorias.RuntAntiClasiDao;
import modelo.datos.dao.accesorias.RuntConcesionarioDao;
import modelo.datos.dao.accesorias.RuntEstadoPropiedadDao;
import modelo.datos.dao.accesorias.RuntEstadoRepresentacionDao;
import modelo.datos.dao.accesorias.RuntGrupoDao;
import modelo.datos.dao.accesorias.RuntLineaDao;
import modelo.datos.dao.accesorias.RuntModalidadDeclaraImpDao;
import modelo.datos.dao.accesorias.RuntModeloVehiDao;
import modelo.datos.dao.accesorias.RuntMotivoRegrabacionDao;
import modelo.datos.dao.accesorias.RuntOrigenRegistroDao;
import modelo.datos.dao.accesorias.RuntTipoActaDao;
import modelo.datos.dao.accesorias.RuntTipoDeclaracionDao;
import modelo.datos.dao.accesorias.RuntTipoEntidadDao;
import modelo.datos.dao.accesorias.RuntTipoImportacionDao;
import modelo.datos.dao.accesorias.RuntTipoMatriculaDao;
import modelo.datos.dao.accesorias.RuntTipoMotorDao;
import modelo.datos.dao.accesorias.RuntTipoPlacaDao;
import modelo.datos.dao.accesorias.RuntTipoPropiedadDao;
import modelo.datos.dao.accesorias.RuntTipoRegistroDao;
import modelo.datos.dao.accesorias.RuntTipoRegrabacionDao;
import modelo.datos.dao.accesorias.RuntTipoSociedadDao;
import modelo.datos.dao.accesorias.RuntTipoblindajeDao;
import modelo.datos.dao.accesorias.ServicioDao;
import modelo.datos.dao.accesorias.SexoDao;
import modelo.datos.dao.accesorias.TablaCampoDao;
import modelo.datos.dao.accesorias.TablaDao;
import modelo.datos.dao.accesorias.TipCarroceriaDao;
import modelo.datos.dao.accesorias.TipDoctoVehiDao;
import modelo.datos.dao.accesorias.TipoAutomotorDao;
import modelo.datos.dao.accesorias.TipoDireccionDao;
import modelo.datos.dao.accesorias.TipoOperacionDao;
import modelo.datos.dao.accesorias.TipoRegistroDao;
import modelo.datos.dao.accesorias.TipobaseDao;
import modelo.datos.dao.accesorias.TramitesdevehiculosDao;
import modelo.datos.dao.accesorias.ViewCamposDeTablaDao;
import modelo.datos.dao.avaluos.LineaMinDao;
import modelo.datos.dao.avaluos.MarcaMinDao;
import modelo.datos.dao.comparendos.accesorias.CiudadCompDao;
import modelo.datos.dao.documentos.PlantillaDao;
import modelo.datos.dao.generales.UsuariosDao;
import modelo.datos.dao.medidasCautelares.J_EntesDao;
import modelo.datos.dao.medidasCautelares.J_TprocesoDao;
import modelo.datos.dao.medidasCautelares.Runt_TprocesocautelarDao;
import modelo.datos.objetos.accesorias.Campo;
import modelo.datos.objetos.accesorias.Ciudad;
import modelo.datos.objetos.accesorias.ClaseEmpresa;
import modelo.datos.objetos.accesorias.ClaseVehiculo;
import modelo.datos.objetos.accesorias.Colores;
import modelo.datos.objetos.accesorias.Combustible;
import modelo.datos.objetos.accesorias.Departamento;
import modelo.datos.objetos.accesorias.Dependencia;
import modelo.datos.objetos.accesorias.Direccion;
import modelo.datos.objetos.accesorias.Documento;
import modelo.datos.objetos.accesorias.EmpresaAseguradora;
import modelo.datos.objetos.accesorias.EscuelasConduccion;
import modelo.datos.objetos.accesorias.EspecieVenal;
import modelo.datos.objetos.accesorias.EstadosFactura;
import modelo.datos.objetos.accesorias.GradoAlerta;
import modelo.datos.objetos.accesorias.GrupoSanguineo;
import modelo.datos.objetos.accesorias.LClaseVehiculo;
import modelo.datos.objetos.accesorias.LTiposPago;
import modelo.datos.objetos.accesorias.LimitacionPropiedad;
import modelo.datos.objetos.accesorias.Marca;
import modelo.datos.objetos.accesorias.Modalidad;
import modelo.datos.objetos.accesorias.MotivoDeCancelacion;
import modelo.datos.objetos.accesorias.MotivoDuplicado;
import modelo.datos.objetos.accesorias.NiveldeServicio;
import modelo.datos.objetos.accesorias.OrgExpideDocto;
import modelo.datos.objetos.accesorias.OrganismoTransito;
import modelo.datos.objetos.accesorias.Pais;
import modelo.datos.objetos.accesorias.Requisitotramite;
import modelo.datos.objetos.accesorias.RuntAduana;
import modelo.datos.objetos.accesorias.RuntAntiClasi;
import modelo.datos.objetos.accesorias.RuntConcesionario;
import modelo.datos.objetos.accesorias.RuntEstadoPropiedad;
import modelo.datos.objetos.accesorias.RuntEstadoRepresentacion;
import modelo.datos.objetos.accesorias.RuntGrupo;
import modelo.datos.objetos.accesorias.RuntLinea;
import modelo.datos.objetos.accesorias.RuntModalidadDeclaraImp;
import modelo.datos.objetos.accesorias.RuntModeloVehi;
import modelo.datos.objetos.accesorias.RuntMotivoRegrabacion;
import modelo.datos.objetos.accesorias.RuntOrigenRegistro;
import modelo.datos.objetos.accesorias.RuntTipoActa;
import modelo.datos.objetos.accesorias.RuntTipoDeclaracion;
import modelo.datos.objetos.accesorias.RuntTipoEntidad;
import modelo.datos.objetos.accesorias.RuntTipoImportacion;
import modelo.datos.objetos.accesorias.RuntTipoMatricula;
import modelo.datos.objetos.accesorias.RuntTipoMotor;
import modelo.datos.objetos.accesorias.RuntTipoPlaca;
import modelo.datos.objetos.accesorias.RuntTipoPropiedad;
import modelo.datos.objetos.accesorias.RuntTipoRegistro;
import modelo.datos.objetos.accesorias.RuntTipoRegrabacion;
import modelo.datos.objetos.accesorias.RuntTipoSociedad;
import modelo.datos.objetos.accesorias.RuntTipoblindaje;
import modelo.datos.objetos.accesorias.Servicio;
import modelo.datos.objetos.accesorias.Sexo;
import modelo.datos.objetos.accesorias.Tabla;
import modelo.datos.objetos.accesorias.TablaCampo;
import modelo.datos.objetos.accesorias.TipCarroceria;
import modelo.datos.objetos.accesorias.TipDoctoVehi;
import modelo.datos.objetos.accesorias.TipoAutomotor;
import modelo.datos.objetos.accesorias.TipoDireccion;
import modelo.datos.objetos.accesorias.TipoOperacion;
import modelo.datos.objetos.accesorias.TipoRegistro;
import modelo.datos.objetos.accesorias.Tipobase;
import modelo.datos.objetos.accesorias.Tramitesdevehiculos;
import modelo.datos.objetos.accesorias.ViewCamposDeTabla;
import modelo.datos.objetos.avaluos.LineaMin;
import modelo.datos.objetos.avaluos.MarcaMin;
import modelo.datos.objetos.comparendos.accesorias.CiudadComp;
import modelo.datos.objetos.generales.AuditoriaSystem;
import modelo.datos.objetos.generales.Usuarios;
import modelo.datos.objetos.medidasCautelares.J_Entes;
import modelo.datos.objetos.medidasCautelares.J_Tproceso;
import modelo.datos.objetos.medidasCautelares.Runt_Tprocesocautelar;

import utilidades.Auditoria;
import utilidades.Funciones;


//import org.apache.xmlbeans.impl.xb.xsdschema.Public;


//import org.opensaml.saml2.metadata.impl.OrganizationBuilder;

public class GestionServiciosAccesoriasLocal {
    Conexion conexion;
    Connection conn;
    CiudadDao ciudadDao;
    String myMotor;
    DireccionDao direccionDao;
    DepartamentoDao departamentoDao;
    TipoDireccionDao tipoDireccionDao;
    RuntTipoRegistroDao runtTipoRegistroDao;
    RuntTipoPlacaDao tipoPlacaDao;
    RuntConcesionarioDao runtConcesionarioDao;
    RuntTipoMatriculaDao runtTipoMatriculaDao;
    RuntAduanaDao runtAduanaDao;
    OrganismoTransitoDao organismoTransitoDao;
    TipDoctoVehiDao tipDoctoVehiDao;
    OrgExpideDoctoDao orgExpideDoctoDao;
    RuntModeloVehiDao runtModeloVehiDao;
    ClaseEmpresaDao claseEmpresaDao;
    RuntTipoSociedadDao runtTipoSociedadDao;
    RuntTipoEntidadDao runtTipoEntidadDao;
    RuntEstadoRepresentacionDao runtEstadoRepresentacionDao;
    Runt_TprocesocautelarDao runt_tprocesocautelarDao;
    Tramitesdevehiculos tipo_tramite;
    TramitesdevehiculosDao tipo_tramiteDao;
    Tipobase tipo_base;
    TipobaseDao tipo_baseDao;
    Requisitotramite requisito;
    RequisitotramiteDao requisitoDao;
    J_TprocesoDao jtprocesodado; 

    public GestionServiciosAccesoriasLocal() {
        super();
        crearObjetos();
    }

    public void crearObjetos() {
        conexion = new Conexion();
        ciudadDao = new CiudadDao();
        myMotor = "";
        
        try{
            myMotor = Funciones.leer_ini("/WSTransito.ini", "MOTOR");
        }catch(Exception exce){}
        if(myMotor.equals(""))
        try{
            myMotor = Funciones.leer_ini("c:\\WSTransito.ini", "MOTOR");
        }catch(Exception exce){}


        direccionDao = new DireccionDao();
        departamentoDao = new DepartamentoDao();
        tipoDireccionDao = new TipoDireccionDao();
        runtTipoRegistroDao = new RuntTipoRegistroDao();


        tipoPlacaDao = new RuntTipoPlacaDao();


        runtConcesionarioDao = new RuntConcesionarioDao();
        runtTipoMatriculaDao = new RuntTipoMatriculaDao();


        runtAduanaDao = new RuntAduanaDao();

        organismoTransitoDao = new OrganismoTransitoDao();


        tipDoctoVehiDao = new TipDoctoVehiDao();
        orgExpideDoctoDao = new OrgExpideDoctoDao();
        runtModeloVehiDao = new RuntModeloVehiDao();
        claseEmpresaDao = new ClaseEmpresaDao();
        runtTipoSociedadDao = new RuntTipoSociedadDao();
        runtTipoEntidadDao = new RuntTipoEntidadDao();

        runtEstadoRepresentacionDao = new RuntEstadoRepresentacionDao();


        runt_tprocesocautelarDao = new Runt_TprocesocautelarDao();
        jtprocesodado = new J_TprocesoDao();

    }


    public List getCiudades() {
        List lista = null;
        try {
            conn = conexion.conectar();
            lista = (ArrayList)ciudadDao.loadAll(conn);
        } catch (Exception e) {
            e.printStackTrace();
            ;
        } finally {
            conexion.cerrarCx();
        }
        return lista;
    }

    public List getCiudades(Ciudad ciudad) {
        List lista = null;
        try {
            conn = conexion.conectar();
            lista = (ArrayList)ciudadDao.searchMatching(conn, ciudad);
        } catch (Exception e) {
            e.printStackTrace();
            ;
        } finally {
            conexion.cerrarCx();
        }
        return lista;
    }
    
    public List buscarCiudad(Ciudad ciudad)
    {
        List mylista;
        mylista = null;
        try
        {
            conn = conexion.conectar();
            CiudadDao myDocDao = new CiudadDao();
            mylista = myDocDao.searchMatching(conn, ciudad);
        }
        catch (Exception e){
        e.printStackTrace();
        }
        finally{
            conexion.cerrarCx();
        }
        
        return mylista;
    }

    public List getPaises(Pais pais) {
        PaisDao paisDao = new PaisDao();
        List lista = null;
        try {
            conn = conexion.conectar();
            lista = (ArrayList)paisDao.loadAll(conn);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return lista;
    }


    public List getDepartamentos(Departamento departamento) {
        List lista = null;
        try {
            conn = conexion.conectar();
            lista = (ArrayList)departamentoDao.searchMatching(conn, departamento);
        } catch (Exception e) {
            e.printStackTrace();
            ;
        } finally {
            conexion.cerrarCx();
        }
        return lista;
    }

    public List getGruposSanguineos(GrupoSanguineo grupoSanguineo) {
        GrupoSanguineoDao grupoSanguineoDao = new GrupoSanguineoDao();
        List lista = null;
        try {
            conn = conexion.conectar();
            lista = (ArrayList)grupoSanguineoDao.loadAll(conn);
        } catch (Exception e) {
            e.printStackTrace();
            ;
        } finally {
            conexion.cerrarCx();
        }
        return lista;
    }

    public List searchGruposSanguineos(GrupoSanguineo grupoSanguineo) {
        GrupoSanguineoDao grupoSanguineoDao = new GrupoSanguineoDao();
        List lista = null;
        try {
            conn = conexion.conectar();
            lista = (ArrayList)grupoSanguineoDao.searchMatching(conn, grupoSanguineo);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return lista;
    }

    public int getIdGrupoSanguineo(String codRunt) {
        List lista = null;
        GrupoSanguineo grupoSanguineo = new GrupoSanguineo();
        grupoSanguineo.setRUNT(codRunt);
        lista = searchGruposSanguineos(grupoSanguineo);
        if (lista != null)
            grupoSanguineo = (GrupoSanguineo)lista.get(0);
        else
            grupoSanguineo.setID(-1);
        return grupoSanguineo.getID();
    }


    public List getClaseVehiculoAll() {
        ClaseVehiculoDao claseVehiculoDao = new ClaseVehiculoDao();
        List lista = null;
        try {
            conn = conexion.conectar();
            lista = claseVehiculoDao.loadAll(conn);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return lista;
    }

    public List getDocumentos()throws Exception{

        DocumentoDao documentoDao = new DocumentoDao();
        List lista = null;
        try {
            conn = conexion.conectar();
            lista = (ArrayList)documentoDao.loadAll(conn);
        } catch (SQLException e) {
            //System.out.println("error peter="+e.getMessage());
        } finally {
            conexion.cerrarCx();
        }
        return lista;
    }


    public List getSexos(Sexo sexo) {
        SexoDao sexoDao = new SexoDao();
        List lista = null;
        try {
            conn = conexion.conectar();
            lista = (ArrayList)sexoDao.loadAll(conn);
        } catch (Exception e) {
            e.printStackTrace();
            ;
        } finally {
            conexion.cerrarCx();
        }
        return lista;
    }

    public List searchSexos(Sexo sexo) {
        SexoDao sexoDao = new SexoDao();
        List lista = null;
        try {
            conn = conexion.conectar();
            lista = sexoDao.searchMatching(conn, sexo);
        } catch (Exception e) {
            e.printStackTrace();
            ;
        } finally {
            conexion.cerrarCx();
        }
        return lista;
    }

    public Sexo getSexo(Sexo sexo) {
        SexoDao sexoDao = new SexoDao();
        List lista = null;
        
        try {
                conn = conexion.conectar();
                lista = sexoDao.searchMatching(conn, sexo);
            
            if (lista != null && lista.size() > 0) {
                sexo = (Sexo)lista.get(0);
            } 
           else {
               sexo.setID_SEXO(-1);
            }
        } 
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            conexion.cerrarCx();
            //sexo.setCODIGO("M");
        }
        
        return sexo;
    }


    public int getIdSexo(String codRunt) {
        List lista = null;
        Sexo sexo = new Sexo();
        sexo.setCODIGO(codRunt);
        lista = searchSexos(sexo);
        if (lista != null)
            sexo = (Sexo)lista.get(0);
        else
            sexo.setID_SEXO(-1);
        return sexo.getID_SEXO();
    }


    public List getDirecciones(Direccion direccion) {
        List lista = null;
        try {
            conn = conexion.conectar();
            lista = (ArrayList)direccionDao.loadAll(conn);
        } catch (Exception e) {
            e.printStackTrace();
            ;
        } finally {
            conexion.cerrarCx();
        }
        return lista;
    }

    public List getTipoDireccion(TipoDireccion tipoDireccion) {
        List lista = null;
        try {
            conn = conexion.conectar();
            lista = (ArrayList)tipoDireccionDao.loadAll(conn);
        } catch (Exception e) {
            e.printStackTrace();
            ;
        } finally {
            conexion.cerrarCx();
        }
        return lista;
    }

    public List getTipoRegistro(RuntTipoRegistro tipoRegistro) {
        List lista = null;
        try {
            conn = conexion.conectar();
            lista = (ArrayList)runtTipoRegistroDao.loadAll(conn);
        } catch (Exception e) {
            e.printStackTrace();
            ;
        } finally {
            conexion.cerrarCx();
        }
        return lista;
    }

    public List getTipoServicio(Servicio tipoServicio) {
        ServicioDao servicioDao = new ServicioDao();
        List lista = null;
        try {
            conn = conexion.conectar();
            lista = (ArrayList)servicioDao.loadAll(conn);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return lista;
    }

    public Servicio getTipoServicioPorIdServicio(Servicio tipoServicio) {
        ServicioDao servicioDao = new ServicioDao();
        try {
            conn = conexion.conectar();
            servicioDao.load(conn, tipoServicio);
        } catch (Exception e) {
            e.printStackTrace();
            ;
            tipoServicio.setID_SERVICIO(-1);
        } finally {
            conexion.cerrarCx();
        }
        return tipoServicio;
    }

    public String getDescTipoServicio(int id) {
        String res = "";
        Servicio tipoServicio = new Servicio();
        tipoServicio.setID_SERVICIO(id);
        ServicioDao servicioDao = new ServicioDao();
        try {
            conn = conexion.conectar();
            servicioDao.load(conn, tipoServicio);
            res = tipoServicio.getDESCRIPCION();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return res;
    }

    public Servicio getTipoServicioPorIdServicioRunt(Servicio tipoServicio) {
        ServicioDao servicioDao = new ServicioDao();
        try {
            conn = conexion.conectar();
            servicioDao.ServicioPorIdRunt(conn, tipoServicio);
        } catch (Exception e) {
            e.printStackTrace();
            ;
            tipoServicio.setID_SERVICIO(-1);
        } finally {
            conexion.cerrarCx();
        }
        return tipoServicio;
    }

    public List getServiciosValidos(Servicio tipoServicio) {
        ServicioDao servicioDao = new ServicioDao();
        List lista = null;
        try {
            conn = conexion.conectar();
            lista = (ArrayList)servicioDao.getServiciosValidos(conn, tipoServicio);
        } catch (Exception e) {
            e.printStackTrace();
            ;
        } finally {
            conexion.cerrarCx();
        }
        return lista;
    }

    public List getModalidad(Modalidad tipoModalidad) {
        List lista = null;
        ModalidadDao modalidadDao = new ModalidadDao();
        try {
            conn = conexion.conectar();
            lista = (ArrayList)modalidadDao.loadAll(conn);
        } catch (Exception e) {
            e.printStackTrace();
            ;
        } finally {
            conexion.cerrarCx();
        }
        return lista;
    }
    
    public List getModalidadSearch(Modalidad modalidad) {
        List lista = null;
        ModalidadDao modalidadDao = new ModalidadDao();
        try {
            conn = conexion.conectar();
            lista = (ArrayList)modalidadDao.searchMatching(conn, modalidad);
        } catch (Exception e) {
            e.printStackTrace();
            ;
        } finally {
            conexion.cerrarCx();
        }
        return lista;
    }
    
    

    public List getTipoPlaca(RuntTipoPlaca tipoPlaca) {
        List lista = null;
        try {
            conn = conexion.conectar();
            lista = (ArrayList)tipoPlacaDao.loadAll(conn);
        } catch (Exception e) {
            e.printStackTrace();
            ;
        } finally {
            conexion.cerrarCx();
        }
        return lista;
    }

    public RuntTipoPlaca getTipoPlacaPorIdTipoPlaca(RuntTipoPlaca tipoPlaca) {
        try {
            conn = conexion.conectar();
            tipoPlacaDao.load(conn, tipoPlaca);
        } catch (Exception e) {
            e.printStackTrace();
            ;
            tipoPlaca.setID_RUNTTIPOPLACA(-1);
        } finally {
            conexion.cerrarCx();
        }
        return tipoPlaca;
    }


    public List getClaseVehiculo(ClaseVehiculo claseVehiculo, boolean remolqueSemiremolque)throws Exception{
        ClaseVehiculoDao claseVehiculoDao = new ClaseVehiculoDao();
        List lista = null;
        try {
            conn = conexion.conectar();

            if (claseVehiculo != null) {
                if (remolqueSemiremolque)
                    lista = claseVehiculoDao.searchMatchingRemolquesSemiRemnolques(conn, claseVehiculo);
                else
                    lista = claseVehiculoDao.searchMatching(conn, claseVehiculo);
            }

            if (claseVehiculo != null)
            {
                if (remolqueSemiremolque)
                    lista = claseVehiculoDao.searchMatchingRemolquesSemiRemnolques(conn, claseVehiculo);
                else
                    lista = claseVehiculoDao.searchMatching(conn, claseVehiculo);
            }
            else
                lista = claseVehiculoDao.loadAll(conn);
        } catch (Exception e) {
            e.printStackTrace();
            ;
        } finally {
            conexion.cerrarCx();
        }
        return lista;
    }
    

    public List getMarca(Marca marca) {
        MarcaDao marcaDao = new MarcaDao();
        List lista = null;
        try {
            conn = conexion.conectar();
            lista = (ArrayList)marcaDao.loadAll(conn);
        } catch (Exception e) {
            e.printStackTrace();
            ;
        } finally {
            conexion.cerrarCx();
        }
        return lista;
    }
    
    public List getMarcaSearch(Marca marca) {
        MarcaDao marcaDao = new MarcaDao();
        List lista = null;
        try {
            conn = conexion.conectar();
            lista = marcaDao.searchMatching(conn, marca);
        } catch (Exception e) {
            e.printStackTrace();
            ;
        } finally {
            conexion.cerrarCx();
        }
        return lista;
    }
    
    

    public Marca getMarca(String idMarca) {
        MarcaDao marcaDao = new MarcaDao();
        List lista = null;
        Marca marca = new Marca();
        try {
            Funciones f = new Funciones();
            if (f.esEntero(idMarca)) {
                marca.setID_MARCA(Integer.parseInt(idMarca));
                conn = conexion.conectar();
                lista = (ArrayList)marcaDao.searchMatching(conn, marca);
                marca = (Marca)lista.get(0);
            } else {
                marca.setAll(1, "", "1", "", "", "");
            }
        } catch (Exception e) {
            e.printStackTrace();
            ;
        } finally {
            conexion.cerrarCx();
        }
        return marca;
    }


    public String getMarcaById(String idMarca) {
        MarcaDao marcaDao = new MarcaDao();
        List lista = null;
        Marca marca = new Marca();
        try {
            marca.setID_MARCA(Integer.parseInt(idMarca));
            conn = conexion.conectar();
            lista = (ArrayList)marcaDao.searchMatching(conn, marca);
            marca = (Marca)lista.get(0);
        } catch (Exception e) {
            e.printStackTrace();
            ;
        } finally {
            conexion.cerrarCx();
        }
        return marca.getDESCRIPCION();
    }

    public String getMarcaMinById(int idMarca) {
        MarcaMinDao marcaDao = new MarcaMinDao();
        List lista = null;
        MarcaMin marca = new MarcaMin();
        try {
            marca.setID_MARCAMIN(idMarca);
            conn = conexion.conectar();
            lista = marcaDao.searchMatching(conn, marca);
            if (lista != null && lista.size() > 0)
                marca = (MarcaMin)lista.get(0);
            else
                marca.setDESCMARCA("Marca no encontrada");
        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            conexion.cerrarCx();
        }
        return marca.getDESCMARCA();
    }

    public List getAllMarcaMin(MarcaMin marcamin) {
        MarcaMinDao marcaDao = new MarcaMinDao();
        List lista = null;
        try {
            conn = conexion.conectar();
            lista = marcaDao.loadAll(conn);

        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            conexion.cerrarCx();
        }
        return lista;
    }

    public List getMarcaMin(MarcaMin marcamin) {
        MarcaMinDao marcaDao = new MarcaMinDao();
        List lista = null;
        try {
            conn = conexion.conectar();
            lista = marcaDao.searchMatching(conn, marcamin);

        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            conexion.cerrarCx();
        }
        return lista;
    }

    public List getTipoMotor(RuntTipoMotor tipoMotor) {
        RuntTipoMotorDao runtTipoMotorDao = new RuntTipoMotorDao();
        List lista = null;
        try {
            conn = conexion.conectar();
            lista = (ArrayList)runtTipoMotorDao.loadAll(conn);
        } catch (Exception e) {
            e.printStackTrace();
            ;
        } finally {
            conexion.cerrarCx();
        }
        return lista;
    }

    public List getColor(Colores colores) {
        ColoresDao coloresDao = new ColoresDao();
        List lista = null;
        try {
            conn = conexion.conectar();
            lista = (ArrayList)coloresDao.loadAll(conn);
        } catch (Exception e) {
            e.printStackTrace();
            ;
        } finally {
            conexion.cerrarCx();
        }
        return lista;
    }

    public Colores getColorPorIdColor(Colores colores) {
        ColoresDao coloresDao = new ColoresDao();
        try {
            conn = conexion.conectar();
            coloresDao.load(conn, colores);
        } catch (Exception e) {
            e.printStackTrace();
            ;
            colores.setID_COLOR(-1);
        } finally {
            conexion.cerrarCx();
        }
        return colores;
    }

    public List getTipoCombustible(Combustible combustible) {
        CombustibleDao combustibleDao = new CombustibleDao();
        List lista = null;
        try {
            conn = conexion.conectar();
            lista = combustibleDao.loadAll(conn);
        } catch (Exception e) {
            e.printStackTrace();
            ;
        } finally {
            conexion.cerrarCx();
        }
        return lista;
    }

    public Combustible obtenerTipoCombustible(Combustible combustible) {
        CombustibleDao combustibleDao = new CombustibleDao();
        List lista = null;

        try {
            conn = conexion.conectar();
            lista = (ArrayList)combustibleDao.searchMatching(conn, combustible);
            if (lista != null)
                combustible = (Combustible)lista.get(0);
            else
                combustible.setID_COMBUSTIBLEMIN("-1");

        } catch (Exception e) {
            e.printStackTrace();
            ;
            combustible.setID_COMBUSTIBLEMIN("-1");
        } finally {
            conexion.cerrarCx();
        }
        return combustible;
    }


    public List getEmpresasGPS(RuntConcesionario runtConcesionario) {
        List lista = null;
        try {
            conn = conexion.conectar();
            lista = (ArrayList)runtConcesionarioDao.loadAll(conn);
        } catch (Exception e) {
            e.printStackTrace();
            ;
        } finally {
            conexion.cerrarCx();
        }
        return lista;
    }
    
    public List getConcesionario(RuntConcesionario runtConcesionario) {
        List lista = null;
        try {
            conn = conexion.conectar();
            lista = (ArrayList)runtConcesionarioDao.loadAll(conn);
        } catch (Exception e) {
            e.printStackTrace();
            ;
        } finally {
            conexion.cerrarCx();
        }
        return lista;
    }

    public List getTipoMatricula(RuntTipoMatricula runtTipoMatricula) {
        List lista = null;
        try {
            conn = conexion.conectar();
            lista = (ArrayList)runtTipoMatriculaDao.loadAll(conn);
        } catch (Exception e) {
            e.printStackTrace();
            ;
        } finally {
            conexion.cerrarCx();
        }
        return lista;
    }

    public List getLinea(RuntLinea runtLinea) {
        List lista = null;
        RuntLineaDao runtLineaDao = new RuntLineaDao();
        try {
            conn = conexion.conectar();
            lista = (ArrayList)runtLineaDao.loadAll(conn);
        } catch (Exception e) {
            e.printStackTrace();
            ;
        } finally {
            conexion.cerrarCx();
        }
        return lista;
    }

    public List getLineaMarca(RuntLinea runtLinea) {
        List lista = null;
        RuntLineaDao runtLineaDao = new RuntLineaDao();
        try {
            conn = conexion.conectar();
            lista = (ArrayList)runtLineaDao.searchMatching(conn, runtLinea);
        } catch (Exception e) {
            e.printStackTrace();
            ;
        } finally {
            conexion.cerrarCx();
        }
        return lista;
    }

    public List getRuntGrupo(RuntGrupo runtGrupo) {
        RuntGrupoDao runtGrupoDao = new RuntGrupoDao();
        List lista = null;
        try {
            conn = conexion.conectar();
            lista = (ArrayList)runtGrupoDao.loadAll(conn);
        } catch (Exception e) {
            e.printStackTrace();
            ;
        } finally {
            conexion.cerrarCx();
        }
        return lista;
    }


    public List getRuntAntiClasi(RuntAntiClasi runtAntiClasi) {
        RuntAntiClasiDao runtAntiClasiDao = new RuntAntiClasiDao();
        List lista = null;
        try {
            conn = conexion.conectar();
            lista = (ArrayList)runtAntiClasiDao.loadAll(conn);
        } catch (Exception e) {
            e.printStackTrace();
            ;
        } finally {
            conexion.cerrarCx();
        }
        return lista;
    }

    public List getRuntAduana(RuntAduana runtAduana) {
        List lista = null;

        try {
            conn = conexion.conectar();
            lista = (ArrayList)runtAduanaDao.loadAll(conn);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return lista;
    }
    
    public RuntAduana getAduana(RuntAduana runtAduana) {
        List lista = null;
        RuntAduana tmpAduana = new RuntAduana();
        try {
            conn = conexion.conectar();
            lista = (ArrayList)runtAduanaDao.searchMatching(conn, runtAduana);
            if (lista != null && lista.size() > 0)
                tmpAduana = (RuntAduana)lista.get(0);
        } catch (Exception e) {
            e.printStackTrace();
            tmpAduana.setID_ADUANA(-1);
        } finally {
            conexion.cerrarCx();
        }
        return tmpAduana;
    }

    public List getRuntTipoActa(RuntTipoActa runtTipoActa) {
        List lista = null;
        RuntTipoActaDao runtTipoActaDao = new RuntTipoActaDao();
        try {
            conn = conexion.conectar();
            lista = (ArrayList)runtTipoActaDao.loadAll(conn);
        } catch (Exception e) {
            e.printStackTrace();
            ;
        } finally {
            conexion.cerrarCx();
        }
        return lista;
    }

    public List getOrganismoTransito(OrganismoTransito organismoTransito) {
        List lista = null;
        try {
            conn = conexion.conectar();
            lista = (ArrayList)organismoTransitoDao.loadAll(conn);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return lista;
    }


    public List getBuscarOrganismoTransito(OrganismoTransito organismoTransito) {
        List lista = null;
        try {
            conn = conexion.conectar();
            lista = organismoTransitoDao.searchMatching(conn, organismoTransito);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return lista;
    }

    public OrganismoTransito getOneOrganismoTransito(OrganismoTransito organismoTransito) {
        List lista = null;
        OrganismoTransito tmp = new OrganismoTransito();
        try {
            conn = conexion.conectar();
            lista = organismoTransitoDao.searchMatching(conn, organismoTransito);
            if (lista != null && lista.size() > 0)
                tmp = (OrganismoTransito)lista.get(0);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return tmp;
    }

    public List getCarroceria(TipCarroceria tipoCarroceria, ClaseVehiculo claseVehiculo) {
        TipCarroceriaDao tipCarroceriaDao = new TipCarroceriaDao();
        List lista = null;
        try {
            conn = conexion.conectar();
            lista = (ArrayList)tipCarroceriaDao.loadAll(conn, claseVehiculo);
        } catch (Exception e) {
            e.printStackTrace();
            ;
        } finally {
            conexion.cerrarCx();
        }
        return lista;
    }
    
    public List getCarroceriaSearch(TipCarroceria tipoCarroceria) {
        TipCarroceriaDao tipCarroceriaDao = new TipCarroceriaDao();
        List lista = null;
        try {
            conn = conexion.conectar();
            lista = (ArrayList)tipCarroceriaDao.searchMatching(conn, tipoCarroceria);
        } catch (Exception e) {
            e.printStackTrace();
            ;
        } finally {
            conexion.cerrarCx();
        }
        return lista;
    }
    
    

    public List ListarTipoCarroceria() {
        TipCarroceriaDao tipCarroceriaDao = new TipCarroceriaDao();
        List lista = null;
        try {
            conn = conexion.conectar();
            lista = (ArrayList)tipCarroceriaDao.loadAllTodas(conn);
        } catch (Exception e) {
            e.printStackTrace();
            ;
        } finally {
            conexion.cerrarCx();
        }
        return lista;
    }
    
    public TipCarroceria obtenerCarroceria(TipCarroceria tipoCarroceria) {
        TipCarroceriaDao tipCarroceriaDao = new TipCarroceriaDao();
        List lista = null;
        try {
            conn = conexion.conectar();
            lista = (ArrayList)tipCarroceriaDao.searchMatching(conn, tipoCarroceria);
            if (lista != null)
                tipoCarroceria = (TipCarroceria)lista.get(0);
            else
                tipoCarroceria.setID_CARROCERIAMIN("-1");
        } catch (Exception e) {
            e.printStackTrace();
            tipoCarroceria.setID_CARROCERIAMIN("-1");
        } finally {
            conexion.cerrarCx();
        }
        return tipoCarroceria;
    }

    public List getEmpresaAseguiradora(EmpresaAseguradora empresaAseguradora) {
        EmpresaAseguradoraDao empresaAseguradoraDao = new EmpresaAseguradoraDao();
        List lista = null;
        try {
            conn = conexion.conectar();
            lista = (ArrayList)empresaAseguradoraDao.loadAll(conn);
        } catch (Exception e) {
            e.printStackTrace();
            ;
        } finally {
            conexion.cerrarCx();
        }
        return lista;
    }

    public EmpresaAseguradora searchEmpresaAseguiradora(EmpresaAseguradora empresaAseguradora) {
        EmpresaAseguradoraDao empresaAseguradoraDao = new EmpresaAseguradoraDao();
        List lista = null;
        try {
            conn = conexion.conectar();
            lista = (ArrayList)empresaAseguradoraDao.searchMatching(conn, empresaAseguradora);
        } catch (Exception e) {
            e.printStackTrace();
            ;
        } finally {
            conexion.cerrarCx();
        }
        if (lista != null && lista.size() > 0)
            empresaAseguradora = (EmpresaAseguradora)lista.get(0);
        return empresaAseguradora;
    }

    public List getTipoDoctoVehi(TipDoctoVehi tipDoctoVehi) {
        List lista = null;
        try {
            conn = conexion.conectar();
            lista = (ArrayList)tipDoctoVehiDao.loadAll(conn);
        } catch (Exception e) {
            e.printStackTrace();
            ;
        } finally {
            conexion.cerrarCx();
        }
        return lista;
    }

    public List getOrgExpideDocto(OrgExpideDocto orgExpideDocto) {
        List lista = null;
        try {
            conn = conexion.conectar();
            lista = (ArrayList)orgExpideDoctoDao.loadAll(conn);
        } catch (Exception e) {
            e.printStackTrace();
            ;
        } finally {
            conexion.cerrarCx();
        }
        return lista;
    }

    public RuntModeloVehi getRuntModeloVehi(RuntModeloVehi runtModeloVehi) {
        List lista = null;
        try {
            conn = conexion.conectar();
            lista = (ArrayList)runtModeloVehiDao.searchMatching(conn, runtModeloVehi);
            if (lista != null && lista.size() > 0) {
                runtModeloVehi = (RuntModeloVehi)lista.get(0);
            } else {
                runtModeloVehi.setID_MODELO(-1);
            }

        } catch (Exception e) {
            e.printStackTrace();
            ;
        } finally {
            conexion.cerrarCx();
        }
        return runtModeloVehi;
    }

    public List ListarRuntModelosVehi() {
        List lista = null;
        try {
            conn = conexion.conectar();
            lista = (ArrayList)runtModeloVehiDao.loadAll(conn);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return lista;
    }

    public List getClaseEmpresa(ClaseEmpresa claseEmpresa) {
        List lista = null;
        try {
            conn = conexion.conectar();
            lista = (ArrayList)claseEmpresaDao.loadAll(conn);
        } catch (Exception e) {
            e.printStackTrace();
            ;
        } finally {
            conexion.cerrarCx();
        }
        return lista;
    }

    public List getTipoSociedad(RuntTipoSociedad runtTipoSociedad) {
        List lista = null;
        try {
            conn = conexion.conectar();
            lista = (ArrayList)runtTipoSociedadDao.loadAll(conn);
        } catch (Exception e) {
            e.printStackTrace();
            ;
        } finally {
            conexion.cerrarCx();
        }
        return lista;
    }

    public List getTipoEntidad(RuntTipoEntidad runtTipoEntidad) {
        List lista = null;
        try {
            conn = conexion.conectar();
            lista = (ArrayList)runtTipoEntidadDao.loadAll(conn);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return lista;
    }


    public List getRuntEstadoRepresentacion(RuntEstadoRepresentacion runtEstadoRepresentacion) {
        List lista = null;
        try {
            conn = conexion.conectar();
            lista = (ArrayList)runtEstadoRepresentacionDao.loadAll(conn);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return lista;
    }

    public List getEntesFiscales() {
        J_EntesDao entesDao = new J_EntesDao();
        List lista = null;
        try {
            conn = conexion.conectar();
            lista = (ArrayList)entesDao.loadAll(conn);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return lista;
    }

    public List searchEntesFiscales(J_Entes entefiscal) {
        J_EntesDao entesDao = new J_EntesDao();
        List lista = null;
        try {
            conn = conexion.conectar();
            lista = (ArrayList)entesDao.searchMatching(conn, entefiscal);
        } catch (Exception e) {
            e.printStackTrace();
            ;
        } finally {
            conexion.cerrarCx();
        }
        return lista;
    }

    public int getIdEnteFiscal(String codRunt) {
        List lista = null;
        J_Entes entefiscal = new J_Entes();
        entefiscal.setJE_CODRUNT(codRunt);
        lista = searchEntesFiscales(entefiscal);
        if (lista != null)
            entefiscal = (J_Entes)lista.get(0);
        else
            entefiscal.setJE_ID(-1);
        return entefiscal.getJE_ID();
    }


    public List getTipoProcesosFiscales() {
        J_TprocesoDao procesoDao = new J_TprocesoDao();
        List lista = null;
        try {
            conn = conexion.conectar();
            lista = (ArrayList)procesoDao.loadAll(conn);
        } catch (Exception e) {
            e.printStackTrace();
            ;
        } finally {
            conexion.cerrarCx();
        }
        return lista;
    }

    public List searchTipoProcesosFiscales(J_Tproceso tipoproceso) {
        J_TprocesoDao procesoDao = new J_TprocesoDao();
        List lista = null;
        try {
            conn = conexion.conectar();
            lista = (ArrayList)procesoDao.searchMatching(conn, tipoproceso);
        } catch (Exception e) {
            e.printStackTrace();
            ;
        } finally {
            conexion.cerrarCx();
        }
        return lista;
    }

    public int getIdTipoProceso(String codRunt) {
        List lista = null;
        J_Tproceso tipoProceso = new J_Tproceso();
        tipoProceso.setJTP_CODRUNT(codRunt);
        lista = searchTipoProcesosFiscales(tipoProceso);
        if (lista != null)
            tipoProceso = (J_Tproceso)lista.get(0);
        else
            tipoProceso.setJTP_ID(-1);
        return tipoProceso.getJTP_ID();
    }

    public List getTipoMedidaCauteralRunt() {
        List lista = null;
        try {
            conn = conexion.conectar();
            lista = (ArrayList)runt_tprocesocautelarDao.loadAll(conn);
        } catch (Exception e) {
            e.printStackTrace();
            ;
        } finally {
            conexion.cerrarCx();
        }
        return lista;
    }
    
    public List getTipoProceso() {
        List lista = null;
        try {
            conn = conexion.conectar();
            //lista = (ArrayList)runt_tprocesocautelarDao.loadAll(conn);
            lista = (ArrayList)jtprocesodado.loadAll(conn);
        } catch (Exception e) {
            e.printStackTrace();
            ;
        } finally {
            conexion.cerrarCx();
        }
        return lista;
    }
    
    

    public List searchTipoMedidaCauteralRunt(Runt_Tprocesocautelar medidaCautelar) {
        List lista = null;
        try {
            conn = conexion.conectar();
            lista = (ArrayList)runt_tprocesocautelarDao.searchMatching(conn, medidaCautelar);
        } catch (Exception e) {
            e.printStackTrace();
            ;
        } finally {
            conexion.cerrarCx();
        }
        return lista;
    }

    public int getIdTipoMedida(String codRunt) {
        List lista = null;
        Runt_Tprocesocautelar tipoMedida = new Runt_Tprocesocautelar();
        tipoMedida.setCOD_TPROCESO(codRunt);
        lista = searchTipoMedidaCauteralRunt(tipoMedida);
        if (lista != null)
            tipoMedida = (Runt_Tprocesocautelar)lista.get(0);
        else
            tipoMedida.setID_TPROCESO(-1);
        return tipoMedida.getID_TPROCESO();
    }

    public Ciudad getCiudadporID(Ciudad ciudad) {
        try {
            conn = conexion.conectar();
            ciudadDao.load(conn, ciudad);
        } catch (Exception e) {
            e.printStackTrace();
            ;
        } finally {
            conexion.cerrarCx();
        }
        return ciudad;
    }

    public Documento getTipoDocporID(Documento documento) {
        DocumentoDao documentoDao = new DocumentoDao();
        try {
            conn = conexion.conectar();
            documentoDao.load(conn, documento);
        } catch (Exception e) {
            e.printStackTrace();
            ;
        } finally {
            conexion.cerrarCx();
        }
        return documento;
    }

    public J_Entes getEnteporID(J_Entes entidad) {
        J_EntesDao entesDao = new J_EntesDao();
        try {
            conn = conexion.conectar();
            entesDao.load(conn, entidad);
        } catch (Exception e) {
            e.printStackTrace();
            ;
        } finally {
            conexion.cerrarCx();
        }
        return entidad;
    }

    public J_Tproceso getTipoProcesosporID(J_Tproceso tproceso) {
        J_TprocesoDao procesoDao = new J_TprocesoDao();
        try {
            conn = conexion.conectar();
            procesoDao.load(conn, tproceso);
        } catch (Exception e) {
            e.printStackTrace();
            ;
        } finally {
            conexion.cerrarCx();
        }
        return tproceso;
    }

    public Runt_Tprocesocautelar getTipoMedidaporID(Runt_Tprocesocautelar tmedida) {
        try {
            conn = conexion.conectar();
            runt_tprocesocautelarDao.load(conn, tmedida);
        } catch (Exception e) {
            e.printStackTrace();
            ;
        } finally {
            conexion.cerrarCx();
        }
        return tmedida;
    }

    public List getTipoTramite() {
        List lista = null;
        tipo_baseDao = new TipobaseDao();
        try {

            conn = conexion.conectar();
            lista = (ArrayList)tipo_baseDao.loadAll(conn);
        } catch (Exception e) {
            e.printStackTrace();
            ;
        } finally {
            conexion.cerrarCx();
        }
        return lista;
    }

    public List getHomologacionTramite() {
        List lista = null;
        tipo_tramiteDao = new TramitesdevehiculosDao();
        try {
            conn = conexion.conectar();
            lista = (ArrayList)tipo_tramiteDao.loadAll(conn);
        } catch (Exception e) {
            e.printStackTrace();
            ;
        } finally {
            conexion.cerrarCx();
        }
        return lista;
    }

    public Tipobase getTipoTramiteporID(Tipobase tbase) {
        try {
            conn = conexion.conectar();
            tipo_baseDao.load(conn, tbase);
        } catch (Exception e) {
            e.printStackTrace();
            ;
        } finally {
            conexion.cerrarCx();
        }
        return tbase;

    }

    public Tramitesdevehiculos getHomologacionporID(Tramitesdevehiculos tramite) {
        try {
            conn = conexion.conectar();
            tipo_tramiteDao.load(conn, tramite);
        } catch (Exception e) {
            e.printStackTrace();
            ;
        } finally {
            conexion.cerrarCx();
        }
        return tramite;

    }

    public List getMotivoDeCancelacion(MotivoDeCancelacion motivoDeCancelacion) {
        List lista = null;
        try {
            MotivoDeCancelacionDao motivoDeCancelacionDao = new MotivoDeCancelacionDao();
            conn = conexion.conectar();
            lista = (ArrayList)motivoDeCancelacionDao.loadAll(conn);
        } catch (Exception e) {
            e.printStackTrace();
            ;
        } finally {
            conexion.cerrarCx();
        }
        return lista;
    }

    public MotivoDeCancelacion obtenerMotivoDeCancelacion(MotivoDeCancelacion motivoDeCancelacion) {
        List lista = null;
        MotivoDeCancelacion motivoCancelacion = new MotivoDeCancelacion();
        try {
            MotivoDeCancelacionDao motivoDeCancelacionDao = new MotivoDeCancelacionDao();
            conn = conexion.conectar();
            lista = (ArrayList)motivoDeCancelacionDao.searchMatching(conn, motivoDeCancelacion);
            if ((lista != null) && (lista.size() > 0))
                motivoCancelacion = (MotivoDeCancelacion)lista.get(0);
            else
                motivoCancelacion.setIDMOTIVO_CANC(-1);

        } catch (Exception e) {
            e.printStackTrace();
            ;
            motivoCancelacion.setIDMOTIVO_CANC(-1);
        } finally {
            conexion.cerrarCx();
        }
        return motivoCancelacion;
    }

    public List getMotivosCancelacionTrasladoCuenta(MotivoDeCancelacion motivoDeCancelacion) {
        List lista = null;
        try {
            MotivoDeCancelacionDao motivoDeCancelacionDao = new MotivoDeCancelacionDao();
            conn = conexion.conectar();
            lista = (ArrayList)motivoDeCancelacionDao.loadAllMotivosCancelacionTrasladoCuenta(conn);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return lista;
    }

    public MotivoDeCancelacion getMotivoDeCancelacionPorId(MotivoDeCancelacion motivoDeCancelacion) {
        try {
            MotivoDeCancelacionDao motivoDeCancelacionDao = new MotivoDeCancelacionDao();
            conn = conexion.conectar();
            motivoDeCancelacionDao.load(conn, motivoDeCancelacion);
        } catch (Exception e) {
            e.printStackTrace();
            ;
        } finally {
            conexion.cerrarCx();
        }
        return motivoDeCancelacion;
    }

    public boolean crearRequisito(Requisitotramite requisito) {
        boolean resultado;
        resultado = false;
        int id;
        try {
            requisitoDao = new RequisitotramiteDao();
            conn = conexion.conectar();
            if (!myMotor.equals("ORACLE"))
                id = Funciones.getId_FB(conn, "GEN_REQTRAMITE");
            else
                id = Funciones.getId_Oracle(conn, "GEN_REQTRAMITE");
            requisito.setID_REQTRAMITE(id);
            requisitoDao.create(conn, requisito);
            resultado = true;
        } catch (Exception e) {
            e.printStackTrace();
            resultado = false;
        } finally {
            conexion.cerrarCx();
            requisitoDao = null;
        }
        return resultado;
    }

    public boolean eliminarRequisito(Requisitotramite requisito) {
        boolean resultado;
        resultado = false;
        try {
            requisitoDao = new RequisitotramiteDao();
            conn = conexion.conectar();
            requisitoDao.delete(conn, requisito);
            resultado = true;
        } catch (Exception e) {
            e.printStackTrace();
            resultado = false;
        } finally {
            conexion.cerrarCx();
            requisitoDao = null;
        }
        return resultado;
    }

    public boolean actualizarRequisito(Requisitotramite requisito) {
        boolean resultado;
        resultado = false;
        try {
            requisitoDao = new RequisitotramiteDao();
            conn = conexion.conectar();
            requisitoDao.save(conn, requisito);
            resultado = true;
        } catch (Exception e) {
            e.printStackTrace();
            resultado = false;
        } finally {
            conexion.cerrarCx();
            requisitoDao = null;
        }
        return resultado;
    }

    public Requisitotramite getRequisitosporID(Requisitotramite requisito) {
        try {
            requisitoDao = new RequisitotramiteDao();
            conn = conexion.conectar();
            requisitoDao.load(conn, requisito);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
            requisitoDao = null;
        }
        return requisito;
    }

    public List getRequisitos() {
        List lista = null;
        try {
            requisitoDao = new RequisitotramiteDao();
            conn = conexion.conectar();
            lista = (ArrayList)requisitoDao.loadAll(conn);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
            requisitoDao = null;
        }
        return lista;
    }

    public List getMotivoDuplicado(MotivoDuplicado motivoDuplicado) {
        List lista = null;
        try {
            MotivoDuplicadoDao motivoDuplicadoDao = new MotivoDuplicadoDao();
            conn = conexion.conectar();
            lista = (ArrayList)motivoDuplicadoDao.loadAll(conn);
        } catch (Exception e) {
            e.printStackTrace();
            ;
        } finally {
            conexion.cerrarCx();
        }
        return lista;
    }

    public MotivoDuplicado getMotivoDuplicadoPorId(MotivoDuplicado motivoDuplicado) {
        MotivoDuplicadoDao motivoDuplicadoDao = new MotivoDuplicadoDao();
        try {
            conn = conexion.conectar();
            motivoDuplicadoDao.load(conn, motivoDuplicado);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
            motivoDuplicadoDao = null;
        }
        return motivoDuplicado;
    }

    public List getTipoRegrabacion(RuntTipoRegrabacion tipoRegrabacion) {
        List lista = null;
        try {
            RuntTipoRegrabacionDao tipoRegrabacionDao = new RuntTipoRegrabacionDao();
            conn = conexion.conectar();
            lista = (ArrayList)tipoRegrabacionDao.loadAll(conn);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return lista;
    }

    public List getMotivoRegrabacion(RuntMotivoRegrabacion motivoRegrabacion) {
        List lista = null;
        try {
            RuntMotivoRegrabacionDao motivoRegrabacionDao = new RuntMotivoRegrabacionDao();
            conn = conexion.conectar();
            lista = (ArrayList)motivoRegrabacionDao.loadAll(conn);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return lista;
    }

    public List getEstadosFactura() {
        List lista = null;
        EstadosFacturaDao estadoFacturaDao = new EstadosFacturaDao();
        try {
            conn = conexion.conectar();
            //estadoFacturaDao.load(conn,estadoF);
            lista = estadoFacturaDao.loadAll(conn);
        } catch (Exception e) {
            e.printStackTrace();
            ;
        } finally {
            conexion.cerrarCx();
        }
        //return estadoF;
        return lista;
    }

    public List getEstadoFactura(EstadosFactura estadoFactura) {
        List lista = null;
        EstadosFacturaDao estadoFacturaDao = new EstadosFacturaDao();
        try {
            conn = conexion.conectar();
            //estadoFacturaDao.load(conn,estadoF);
            lista = estadoFacturaDao.searchMatching(conn, estadoFactura);
        } catch (Exception e) {
            e.printStackTrace();
            ;
        } finally {
            conexion.cerrarCx();
        }
        //return estadoF;
        return lista;
    }


    //Creadas el 25 - 06 - 2011 Cesar

    public List getTipoRegistro() {
        List lista = null;
        TipoRegistroDao tipoRegistroDao = new TipoRegistroDao();
        try {
            conn = conexion.conectar();
            lista = tipoRegistroDao.loadAll(conn);
        } catch (Exception e) {
            e.printStackTrace();
            ;
        } finally {
            conexion.cerrarCx();
        }
        return lista;
    }

    public List searchTipoRegistro(TipoRegistro tipoRegistro) {
        List lista = null;
        TipoRegistroDao tipoRegistroDao = new TipoRegistroDao();
        try {
            conn = conexion.conectar();
            lista = tipoRegistroDao.searchMatching(conn, tipoRegistro);
        } catch (Exception e) {
            e.printStackTrace();
            ;
        } finally {
            conexion.cerrarCx();
        }
        return lista;
    }

    public List getTipoAutomotor() {
        List lista = null;
        TipoAutomotorDao tipoAutomotorDao = new TipoAutomotorDao();
        try {
            conn = conexion.conectar();
            lista = tipoAutomotorDao.loadAll(conn);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return lista;
    }

    public List searchTipoAutomotor(TipoAutomotor tipoAutomotor) {
        List lista = null;
        TipoAutomotorDao tipoAutomotorDao = new TipoAutomotorDao();
        try {
            conn = conexion.conectar();
            lista = tipoAutomotorDao.searchMatching(conn, tipoAutomotor);
        } catch (Exception e) {
            e.printStackTrace();
            ;
        } finally {
            conexion.cerrarCx();
        }
        return lista;
    }

    public List getModalidadActaImp() {
        List lista = null;
        RuntModalidadDeclaraImpDao modalidadActaDao = new RuntModalidadDeclaraImpDao();
        try {
            conn = conexion.conectar();
            lista = modalidadActaDao.loadAll(conn);
        } catch (Exception e) {
            e.printStackTrace();
            ;
        } finally {
            conexion.cerrarCx();
        }
        return lista;
    }

    public List searchModalidadActaImp(RuntModalidadDeclaraImp modalidadActa) {
        List lista = null;
        RuntModalidadDeclaraImpDao modalidadActaDao = new RuntModalidadDeclaraImpDao();
        try {
            conn = conexion.conectar();
            lista = modalidadActaDao.searchMatching(conn, modalidadActa);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return lista;
    }

    public List getTipoImportacion() {
        List lista = null;
        RuntTipoImportacionDao tipoImportacionDao = new RuntTipoImportacionDao();
        try {
            conn = conexion.conectar();
            lista = tipoImportacionDao.loadAll(conn);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return lista;
    }

    public List searchTipoImportacion(RuntTipoImportacion tipoImportacion) {
        List lista = null;
        RuntTipoImportacionDao tipoimportDao = new RuntTipoImportacionDao();
        try {
            conn = conexion.conectar();
            lista = tipoimportDao.searchMatching(conn, tipoImportacion);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return lista;
    }

    public List getTipoDeclaracionImp() {
        List lista = null;
        RuntTipoDeclaracionDao tipoDeclaracionrDao = new RuntTipoDeclaracionDao();
        try {
            conn = conexion.conectar();
            lista = tipoDeclaracionrDao.loadAll(conn);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return lista;
    }

    public List searchTipoDeclaracionImp(RuntTipoDeclaracion tipoDeclaracion) {
        List lista = null;
        RuntTipoDeclaracionDao tipoDeclaracionrDao = new RuntTipoDeclaracionDao();
        try {
            conn = conexion.conectar();
            lista = tipoDeclaracionrDao.searchMatching(conn, tipoDeclaracion);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return lista;
    }

    public String getNombrePais(int id) {
        PaisDao paisDao = new PaisDao();
        Pais pais = new Pais();
        try {
            conn = conexion.conectar();
            pais = paisDao.getObject(conn, id);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return pais.getDESCRIPCION();
    }

    public String getDescTipoImport(int id) {
        RuntTipoImportacion tipoImp = new RuntTipoImportacion();
        RuntTipoImportacionDao tipoImpDao = new RuntTipoImportacionDao();
        try {
            conn = conexion.conectar();
            tipoImp = tipoImpDao.getObject(conn, id);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return tipoImp.getDESCRIPCION();
    }


    public String getCodRuntPais(int id) {
        PaisDao paisDao = new PaisDao();
        Pais pais = new Pais();
        try {
            conn = conexion.conectar();
            pais = paisDao.getObject(conn, id);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return pais.getCODRUNTPAIS();
    }

    public String getCodRuntTipoImport(int id) {
        RuntTipoImportacion tipoImp = new RuntTipoImportacion();
        RuntTipoImportacionDao tipoImpDao = new RuntTipoImportacionDao();
        try {
            conn = conexion.conectar();
            tipoImp = tipoImpDao.getObject(conn, id);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return tipoImp.getCODIGO();
    }

    public String getClaseVehiculoRunt(int id) {
        ClaseVehiculo claseVehiculo = new ClaseVehiculo();
        ClaseVehiculoDao claseVehiculoDao = new ClaseVehiculoDao();
        claseVehiculo.setID_CVEHICULO(id);
        try {
            conn = conexion.conectar();
            claseVehiculoDao.load(conn, claseVehiculo);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return claseVehiculo.getIDRUNTCLASIFICACION();
    }

    public List getClaseVehiculoAllF() {
        ClaseVehiculoDao claseVehiculoDao = new ClaseVehiculoDao();
        List lista = null;
        try {
            conn = conexion.conectar();
            lista = claseVehiculoDao.loadAll(conn);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return lista;
    }


    public String getLineaRunt(int id) {
        RuntLinea runtLinea = new RuntLinea();
        RuntLineaDao runtLineaDao = new RuntLineaDao();
        runtLinea.setID_LINEAPPAL(String.valueOf(id));
        System.out.println(id);
        try {
            conn = conexion.conectar();
            runtLineaDao.load(conn, runtLinea);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return runtLinea.getID_LINEARUNT();
    }

    public String getLineaById(int id) {
        RuntLinea runtLinea = new RuntLinea();
        RuntLineaDao runtLineaDao = new RuntLineaDao();
        runtLinea.setID_LINEAPPAL(String.valueOf(id));
        System.out.println(id);
        try {
            conn = conexion.conectar();
            runtLineaDao.load(conn, runtLinea);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return runtLinea.getDESCRIPCION();
    }

    public String getLineaMinById(int id) {
        LineaMin lineaMin = new LineaMin();
        LineaMinDao lineaMinDao = new LineaMinDao();
        lineaMin.setID_LINEA(id);
        try {
            conn = conexion.conectar();
            lineaMinDao.load(conn, lineaMin);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return lineaMin.getDESCLINEA();
    }

    public List getAllLineaMin(LineaMin lineamin) {
        List lista = null;
        LineaMinDao lineaMinDao = new LineaMinDao();
        try {
            conn = conexion.conectar();
            lista = lineaMinDao.searchMatching(conn, lineamin);
        } catch (Exception e) {
            e.printStackTrace();
            ;
        } finally {
            conexion.cerrarCx();
        }
        return lista;
    }

    public int getLineaRunt(String codRunt) {
        List lista = null;
        RuntLinea runtLinea = new RuntLinea();
        RuntLineaDao runtLineaDao = new RuntLineaDao();
        runtLinea.setID_LINEARUNT(codRunt);
        try {
            conn = conexion.conectar();
            lista = runtLineaDao.searchMatching(conn, runtLinea);
            if (lista != null && lista.size() > 0)
                runtLinea = (RuntLinea)lista.get(0);
            else
                runtLinea.setID_LINEA(-1);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return runtLinea.getID_LINEA();
    }

    public String getDesLinea(int id) {
        List lista = null;
        String res = "";
        RuntLinea runtLinea = new RuntLinea();
        RuntLineaDao runtLineaDao = new RuntLineaDao();
        runtLinea.setID_LINEAPPAL(Integer.toString(id));
        try {
            conn = conexion.conectar();
            lista = runtLineaDao.searchMatching(conn, runtLinea);
            if (lista.size() > 0 && lista != null) {
                runtLinea = (RuntLinea)lista.get(0);
                res = runtLinea.getDESCRIPCION();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return res;
    }

    public String getMarcaRunt(int id) {
        MarcaDao marcaDao = new MarcaDao();
        Marca marca = new Marca();
        marca.setIDMARCPPAL(String.valueOf(id));
        try {
            conn = conexion.conectar();
            marcaDao.load(conn, marca);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return marca.getID_MARCARUNT();
    }

    public String getDescMarca(int id) {
        List lista = null;
        String res = "";
        MarcaDao marcaDao = new MarcaDao();
        Marca marca = new Marca();
        marca.setIDMARCPPAL(Integer.toString(id));
        try {
            conn = conexion.conectar();
            lista = marcaDao.searchMatching(conn, marca);
            if (lista != null && lista.size() > 0) {
                marca = (Marca)lista.get(0);
                res = marca.getDESCRIPCION();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return marca.getDESCRIPCION();
    }

    public String getCarroceriaRunt(int id) {
        TipCarroceriaDao tipCarroceriaDao = new TipCarroceriaDao();
        TipCarroceria tcarroceria = new TipCarroceria();
        tcarroceria.setID_TCARROCERIA(id);
        try {
            conn = conexion.conectar();
            tipCarroceriaDao.load(conn, tcarroceria);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return tcarroceria.getID_TCARROCERIARUNT();
    }

    public List searchTipoCombustible(Combustible combustible) {
        CombustibleDao combustibleDao = new CombustibleDao();
        List lista = null;
        try {
            conn = conexion.conectar();
            lista = (ArrayList)combustibleDao.searchMatching(conn, combustible);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return lista;
    }

    public String getTipoCombustibleRunt(int id) {

        Combustible combustible = new Combustible();
        combustible.setID_COMBUSTIBLE(id);
        List lista = null;
        lista = searchTipoCombustible(combustible);
        if (lista != null)
            combustible = (Combustible)lista.get(0);
        else
            combustible.setID_COMBRUNT("-1");
        return combustible.getID_COMBRUNT();
    }

    public int getIdTipoCombustible(String codRunt) {

        Combustible combustible = new Combustible();
        combustible.setID_COMBRUNT(codRunt);
        List lista = null;
        lista = searchTipoCombustible(combustible);
        if (lista != null)
            combustible = (Combustible)lista.get(0);
        else
            combustible.setID_COMBUSTIBLE(-1);
        return combustible.getID_COMBUSTIBLE();
    }

    public List searchMotivoDeCancelacion(MotivoDeCancelacion motivoDeCancelacion) {
        List lista = null;
        try {
            MotivoDeCancelacionDao motivoDeCancelacionDao = new MotivoDeCancelacionDao();
            conn = conexion.conectar();
            lista = (ArrayList)motivoDeCancelacionDao.searchMatching(conn, motivoDeCancelacion);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return lista;
    }

    public int getIdMotivoDeCancelacion(String codRunt) {
        MotivoDeCancelacion motivodecancelacion = new MotivoDeCancelacion();
        motivodecancelacion.setCOD_RUNT(codRunt);
        List lista = null;
        System.out.println("buscando");
        lista = searchMotivoDeCancelacion(motivodecancelacion);
        if (lista != null && lista.size() > 0)
            motivodecancelacion = (MotivoDeCancelacion)lista.get(0);
        else
            motivodecancelacion.setIDMOTIVO_CANC(-1);
        return motivodecancelacion.getIDMOTIVO_CANC();
    }

    public int getIdRuntTipoActaImp(String tipoActa) {
        RuntTipoActaDao runtTipoActaDao = new RuntTipoActaDao();
        RuntTipoActa runtTipoActa = new RuntTipoActa();
        // runtTipoActa.set
        try {
            conn = conexion.conectar();
            runtTipoActaDao.load(conn, runtTipoActa);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return 0;
    }

    public List searchColor(Colores colores) {
        ColoresDao coloresDao = new ColoresDao();
        List lista = null;
        try {
            conn = conexion.conectar();
            lista = (ArrayList)coloresDao.searchMatching(conn, colores);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return lista;
    }

    public int getIdColorRunt(String codColor) {
        Colores colores = new Colores();
        colores.setID_COLORRUNT(codColor);
        List lista = null;
        lista = searchColor(colores);
        if (lista != null)
            colores = (Colores)lista.get(0);
        else
            colores.setID_COLOR(-1);
        return colores.getID_COLOR();
    }

    public List searchCarroceria(TipCarroceria tipcarroceria) {
        List lista = null;
        TipCarroceriaDao tipcarroceriaDao = new TipCarroceriaDao();
        try {
            conn = conexion.conectar();
            lista = (ArrayList)tipcarroceriaDao.searchMatching(conn, tipcarroceria);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return lista;
    }

    public int getIdCarroceria(String codRunt) {
        TipCarroceria tipcarroceria = new TipCarroceria();
        tipcarroceria.setID_TCARROCERIARUNT(codRunt);
        List lista = null;
        lista = searchCarroceria(tipcarroceria);
        if (lista != null)
            tipcarroceria = (TipCarroceria)lista.get(0);
        else
            tipcarroceria.setID_TCARROCERIA(-1);
        return tipcarroceria.getID_TCARROCERIA();
    }

    public List searchModalidad(Modalidad tipoModalidad) {
        List lista = null;
        ModalidadDao modalidadDao = new ModalidadDao();
        try {
            conn = conexion.conectar();
            lista = (ArrayList)modalidadDao.searchMatching(conn, tipoModalidad);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return lista;
    }

    public Modalidad obtenerModalidad(Modalidad tipoModalidad) {
        List lista = null;
        ModalidadDao modalidadDao = new ModalidadDao();
        try {
            conn = conexion.conectar();
            lista = (ArrayList)modalidadDao.searchMatching(conn, tipoModalidad);
            if (lista != null)
                tipoModalidad = (Modalidad)lista.get(0);
            else
                tipoModalidad.setCODMODALIDAD("-1");
        } catch (Exception e) {
            e.printStackTrace();
            tipoModalidad.setCODMODALIDAD("-1");
        } finally {
            conexion.cerrarCx();
        }
        return tipoModalidad;
    }

    public int getIdModalidad(String codRunt) {
        Modalidad modalidad = new Modalidad();
        modalidad.setIDMODALIDADRUNT(codRunt);
        List lista = null;
        lista = searchModalidad(modalidad);
        if (lista != null)
            modalidad = (Modalidad)lista.get(0);
        else
            modalidad.setID_MODALIDAD(-1);
        return modalidad.getID_MODALIDAD();
    }


    public List getNivelServicio() {
        NiveldeServicioDao nivelservicioDao = new NiveldeServicioDao();
        List lista = null;
        try {
            conn = conexion.conectar();
            lista = (ArrayList)nivelservicioDao.loadAll(conn);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return lista;
    }

    public List searchNivelServicio(NiveldeServicio nivelservicio) {
        NiveldeServicioDao nivelservicioDao = new NiveldeServicioDao();
        List lista = null;
        try {
            conn = conexion.conectar();
            lista = (ArrayList)nivelservicioDao.searchMatching(conn, nivelservicio);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return lista;
    }

    public int getIdNivelServicio(String codRunt) {
        NiveldeServicio nivelservicio = new NiveldeServicio();
        nivelservicio.setCODIGORUNT(codRunt);
        List lista = null;
        lista = searchNivelServicio(nivelservicio);
        if (lista != null)
            nivelservicio = (NiveldeServicio)lista.get(0);
        else
            nivelservicio.setID_NIVEL(-1);
        return nivelservicio.getID_NIVEL();
    }

    public List searchTipoMotor(RuntTipoMotor tipoMotor) {
        RuntTipoMotorDao runtTipoMotorDao = new RuntTipoMotorDao();
        List lista = null;
        try {
            conn = conexion.conectar();
            lista = (ArrayList)runtTipoMotorDao.searchMatching(conn, tipoMotor);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return lista;
    }

    public int getIdTipoMotor(String codRunt) {
        List lista = null;
        RuntTipoMotor tipomotor = new RuntTipoMotor();
        tipomotor.setID_CODRUNTTIPMO(codRunt);
        lista = searchTipoMotor(tipomotor);
        if (lista != null)
            tipomotor = (RuntTipoMotor)lista.get(0);
        else
            tipomotor.setID_RUNTTIPOMOTOR(-1);
        return tipomotor.getID_RUNTTIPOMOTOR();
    }

    public List getTipoBlindaje() {
        RuntTipoblindajeDao tipoBlindajeDao = new RuntTipoblindajeDao();
        List lista = null;
        try {
            conn = conexion.conectar();
            lista = (ArrayList)tipoBlindajeDao.loadAll(conn);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return lista;
    }


    public List searchTipoBlindaje(RuntTipoblindaje tipoblindaje) {
        RuntTipoblindajeDao tipoBlindajeDao = new RuntTipoblindajeDao();
        List lista = null;
        try {
            conn = conexion.conectar();
            lista = (ArrayList)tipoBlindajeDao.searchMatching(conn, tipoblindaje);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return lista;
    }

    public int getIdTipoBlindaje(String codRunt) {
        List lista = null;
        RuntTipoblindaje tipoblindaje = new RuntTipoblindaje();
        tipoblindaje.setIDRUNT(codRunt);
        lista = searchTipoBlindaje(tipoblindaje);
        if (lista != null)
            tipoblindaje = (RuntTipoblindaje)lista.get(0);
        else
            tipoblindaje.setID_TIPOBLINDAJE(-1);
        return tipoblindaje.getID_TIPOBLINDAJE();
    }

    public List searchPais(Pais pais) {
        PaisDao paisDao = new PaisDao();
        List lista = null;
        try {
            conn = conexion.conectar();
            lista = paisDao.searchMatching(conn, pais);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return lista;
    }

    public int getIdPais(String codRunt) {
        List lista = null;
        Pais pais = new Pais();
        pais.setCODRUNTPAIS(codRunt);
        lista = searchPais(pais);
        if (lista != null)
            pais = (Pais)lista.get(0);
        else
            pais.setID_RUNTPAISES(-1);
        return pais.getID_RUNTPAISES();
    }

    public List getOrigenRegistro() {
        RuntOrigenRegistroDao origenregistroDao = new RuntOrigenRegistroDao();
        List lista = null;
        try {
            conn = conexion.conectar();
            lista = origenregistroDao.loadAll(conn);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return lista;
    }

    public List searchOrigenRegistro(RuntOrigenRegistro origenregistro) {
        RuntOrigenRegistroDao origenregistroDao = new RuntOrigenRegistroDao();
        List lista = null;
        try {
            conn = conexion.conectar();
            lista = origenregistroDao.searchMatching(conn, origenregistro);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return lista;
    }

    public int getIdOrigenRegistro(String codRunt) {
        List lista = null;
        RuntOrigenRegistro origenregistro = new RuntOrigenRegistro();
        origenregistro.setCODORIGREGISTRO(codRunt);
        lista = searchOrigenRegistro(origenregistro);
        if (lista != null)
            origenregistro = (RuntOrigenRegistro)lista.get(0);
        else
            origenregistro.setID_RUNTORIGENREGISTRO(-1);
        return origenregistro.getID_RUNTORIGENREGISTRO();
    }

    public List searchRuntGrupo(RuntGrupo runtGrupo) {
        RuntGrupoDao runtGrupoDao = new RuntGrupoDao();
        List lista = null;
        try {
            conn = conexion.conectar();
            lista = (ArrayList)runtGrupoDao.searchMatching(conn, runtGrupo);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return lista;
    }

    public int getIdRuntGrupo(String codRunt) {
        List lista = null;
        RuntGrupo runtGrupo = new RuntGrupo();
        runtGrupo.setCODGRUPO(codRunt);
        lista = searchRuntGrupo(runtGrupo);
        if (lista != null)
            runtGrupo = (RuntGrupo)lista.get(0);
        else
            runtGrupo.setID_RUNTGRUPO(-1);
        return runtGrupo.getID_RUNTGRUPO();
    }

    public List searchRuntAntiClasi(RuntAntiClasi runtAntiClasi) {
        RuntAntiClasiDao runtAntiClasiDao = new RuntAntiClasiDao();
        List lista = null;
        try {
            conn = conexion.conectar();
            lista = (ArrayList)runtAntiClasiDao.searchMatching(conn, runtAntiClasi);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return lista;
    }

    public int getIdRuntAntiClasic(String codRunt) {
        List lista = null;
        RuntAntiClasi anticlasi = new RuntAntiClasi();
        anticlasi.setDESCRIPCION(codRunt);
        lista = searchRuntAntiClasi(anticlasi);
        if (lista != null)
            anticlasi = (RuntAntiClasi)lista.get(0);
        else
            anticlasi.setID_RUNTANTICLASI(-1);
        return anticlasi.getID_RUNTANTICLASI();
    }

    public List searchClaseVehiculo(ClaseVehiculo claseVehiculo) {
        ClaseVehiculoDao claseVehiculoDao = new ClaseVehiculoDao();
        List lista = null;
        try {
            conn = conexion.conectar();
            lista = (ArrayList)claseVehiculoDao.searchMatching(conn, claseVehiculo);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return lista;
    }

    public int getIdClaseVehiculo(String codRunt) {
        List lista = null;
        ClaseVehiculo claseVehiculo = new ClaseVehiculo();
        claseVehiculo.setID_CVEHICULORUNT(codRunt);
        lista = searchClaseVehiculo(claseVehiculo);
        if (lista != null)
            claseVehiculo = (ClaseVehiculo)lista.get(0);
        else
            claseVehiculo.setID_CVEHICULO(-1);
        return claseVehiculo.getID_CVEHICULO();
    }

    public String getDescClaseVehiculo(int id) {
        List lista = null;
        ClaseVehiculo claseVehiculo = new ClaseVehiculo();
        claseVehiculo.setID_CVEHICULO(id);
        lista = searchClaseVehiculo(claseVehiculo);
        if (lista != null)
            claseVehiculo = (ClaseVehiculo)lista.get(0);
        else
            claseVehiculo.setDESCRIPCION("");
        return claseVehiculo.getDESCRIPCION();
    }

    public List searchServicio(Servicio tipoServicio) {
        ServicioDao servicioDao = new ServicioDao();
        List lista = null;
        try {
            conn = conexion.conectar();
            lista = (ArrayList)servicioDao.searchMatching(conn, tipoServicio);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return lista;
    }

    public int getIdServicio(String codRunt) {
        List lista = null;
        Servicio servicio = new Servicio();
        servicio.setID_SERVICIORUNT(codRunt);
        lista = searchServicio(servicio);
        if (lista != null)
            servicio = (Servicio)lista.get(0);
        else
            servicio.setID_SERVICIO(-1);
        return servicio.getID_SERVICIO();
    }

    public List searchMarca(Marca marca) {
        MarcaDao marcaDao = new MarcaDao();
        List lista = null;
        try {
            conn = conexion.conectar();
            lista = (ArrayList)marcaDao.searchMatching(conn, marca);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return lista;
    }

    public int getIdMarca(String codRunt) {
        List lista = null;
        Marca marca = new Marca();
        marca.setID_MARCARUNT(codRunt);
        lista = searchMarca(marca);
        if (lista != null)
            marca = (Marca)lista.get(0);
        else
            marca.setID_MARCA(-1);
        return marca.getID_MARCA();
    }

    public List getDependencias(int modulo) {
        DependenciaDao dependenciaDao;
        dependenciaDao = new DependenciaDao();
        List lista = null;
        try {
            if (modulo == 0)
                conn = conexion.conectar();
            else
                conn = conexion.conectarComparendos();
            lista = (ArrayList)dependenciaDao.loadAll(conn);
        } catch (SQLException e) {
            System.out.println("error peter=" + e.getMessage());
        } finally {
            conexion.cerrarCx();
        }
        return lista;
    }

    public List getDependencia(Dependencia myDependencia, int modulo) {
        DependenciaDao dependenciaDao;
        dependenciaDao = new DependenciaDao();
        List lista = null;
        try {
            if (modulo == 0)
                conn = conexion.conectar();
            else
                conn = conexion.conectarComparendos();
            lista = (ArrayList)dependenciaDao.searchMatching(conn, myDependencia);
        } catch (SQLException e) {
            System.out.println("error peter=" + e.getMessage());
        } finally {
            conexion.cerrarCx();
        }
        return lista;
    }

    public List getLClaseVehiculo(LClaseVehiculo lclaseVehiculo) {
        LClaseVehiculoDao mylclaseVehiculoDao = new LClaseVehiculoDao();
        List lista = null;
        try {
            conn = conexion.conectar();
            lista = (ArrayList)mylclaseVehiculoDao.loadAll(conn);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return lista;
    }

    public List getTipoPropiedad() {
        RuntTipoPropiedadDao tipopropiedadDao = new RuntTipoPropiedadDao();
        List lista = null;
        try {
            conn = conexion.conectar();
            lista = (ArrayList)tipopropiedadDao.loadAll(conn);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return lista;
    }

    public List searchTipoPropiedad(RuntTipoPropiedad tipopropiedad) {
        RuntTipoPropiedadDao tipopropiedadDao = new RuntTipoPropiedadDao();
        List lista = null;
        try {
            conn = conexion.conectar();
            lista = (ArrayList)tipopropiedadDao.searchMatching(conn, tipopropiedad);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return lista;
    }

    public int getIdTipoPropiedad(String codRunt) {
        List lista = null;
        RuntTipoPropiedad tipopropiedad = new RuntTipoPropiedad();
        tipopropiedad.setDESCRIPCION(codRunt);
        lista = searchTipoPropiedad(tipopropiedad);
        if (lista != null)
            tipopropiedad = (RuntTipoPropiedad)lista.get(0);
        else
            tipopropiedad.setID_TIPOPROPIEDAD(-1);
        return tipopropiedad.getID_TIPOPROPIEDAD();
    }

    public List searchDocumentos(Documento documento) {
        DocumentoDao documentoDao = new DocumentoDao();
        List lista = null;
        try {
            conn = conexion.conectar();
            lista = (ArrayList)documentoDao.searchMatching(conn, documento);
        } catch (SQLException e) {
            //System.out.println("error peter="+e.getMessage());
        } finally {
            conexion.cerrarCx();
        }
        return lista;
    }

    public String getIdDocumento(String codRunt) {
        List lista = null;
        Documento documento = new Documento();
        documento.setID_DOCTORUNT(codRunt);
        lista = searchDocumentos(documento);
        if (lista != null)
            documento = (Documento)lista.get(0);
        else
            documento.setID_DOCTO("");
        return documento.getID_DOCTO();
    }

    public List getEstadoPropiedad() {
        RuntEstadoPropiedadDao estadopropiedadDao = new RuntEstadoPropiedadDao();
        List lista = null;
        try {
            conn = conexion.conectar();
            lista = (ArrayList)estadopropiedadDao.loadAll(conn);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return lista;
    }

    public List searchEstadoPropiedad(RuntEstadoPropiedad estadopropiedad) {
        RuntEstadoPropiedadDao estadopropiedadDao = new RuntEstadoPropiedadDao();
        List lista = null;
        try {
            conn = conexion.conectar();
            lista = (ArrayList)estadopropiedadDao.searchMatching(conn, estadopropiedad);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return lista;
    }

    public int getIdEstadoPropiedad(String codRunt) {
        List lista = null;
        RuntEstadoPropiedad estadopropiedad = new RuntEstadoPropiedad();
        estadopropiedad.setDES_ESTADOPROP(codRunt);
        lista = searchEstadoPropiedad(estadopropiedad);
        if (lista != null)
            estadopropiedad = (RuntEstadoPropiedad)lista.get(0);
        else
            estadopropiedad.setID_RUNTESTADOPROPIEDAD(-1);
        return estadopropiedad.getID_RUNTESTADOPROPIEDAD();
    }

    public List getGradoAlerta() {
        GradoAlertaDao gradoAlertaDao = new GradoAlertaDao();
        List lista = null;
        try {
            conn = conexion.conectar();
            lista = (ArrayList)gradoAlertaDao.loadAll(conn);
        } catch (Exception e) {
            e.printStackTrace();
            ;
        } finally {
            conexion.cerrarCx();
        }
        return lista;
    }

    public GradoAlerta getOneGradoAlerta(GradoAlerta gradoAlerta) {
        GradoAlertaDao gradoAlertaDao = new GradoAlertaDao();
        try {
            conn = conexion.conectar();
            gradoAlertaDao.load(conn, gradoAlerta);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return gradoAlerta;
    }


    public List searchGradoAlerta(GradoAlerta gradoAlerta) {
        GradoAlertaDao gradoAlertaDao = new GradoAlertaDao();
        List lista = null;
        try {
            conn = conexion.conectar();
            lista = (ArrayList)gradoAlertaDao.searchMatching(conn, gradoAlerta);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return lista;
    }

    public int getIdGradoAlerta(String codRunt) {
        List lista = null;
        GradoAlerta gradoAlerta = new GradoAlerta();
        gradoAlerta.setCOD_GRADOALERTA(codRunt);
        lista = searchGradoAlerta(gradoAlerta);
        if (lista != null)
            gradoAlerta = (GradoAlerta)lista.get(0);
        else
            gradoAlerta.setID_GRADOALERTA(-1);
        return gradoAlerta.getID_GRADOALERTA();
    }

    public List getEspeciesVenales(EspecieVenal myEspVen) {
        EspecieVenalDao myEspVEnalDao = new EspecieVenalDao();
        List lista = null;
        try {
            conn = conexion.conectar();
            lista = (ArrayList)myEspVEnalDao.loadAll(conn);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return lista;
    }

    public List getMotivoCancelacion(MotivoDeCancelacion motivocancelacion) {
        List lista = null;
        MotivoDeCancelacionDao myMotivoDeCancelacionDao = new MotivoDeCancelacionDao();
        try {
            conn = conexion.conectar();
            lista = (ArrayList)myMotivoDeCancelacionDao.searchMatching(conn, motivocancelacion);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return lista;
    }

    public String getColorpodIdColor(int id) {
        ColoresDao coloresDao = new ColoresDao();
        Colores color = new Colores();
        try {
            conn = conexion.conectar();
            color = (Colores)coloresDao.getObject(conn, id);
        } catch (Exception e) {
            e.printStackTrace();
            ;
        } finally {
            conexion.cerrarCx();
        }
        return color.getDESCRIPCION();
    }

    public List getTiposPago(LTiposPago tipoPago) {
        List lista = null;
        LTiposPagoDao tiposPagoDao = new LTiposPagoDao();
        try {
            conn = conexion.conectar();
            lista = (ArrayList)tiposPagoDao.loadAll(conn);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return lista;
    }

    public List getTablas() {
        List lista = null;
        TablaDao myTablaDao = new TablaDao();
        try {
            conn = conexion.conectar();
            lista = myTablaDao.loadAll(conn);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return lista;
    }

    public List getTablas(Tabla myTabla) {
        List lista = null;
        TablaDao myTablaDao = new TablaDao();
        try {
            conn = conexion.conectar();
            lista = myTablaDao.searchMatching(conn, myTabla);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return lista;
    }

    public List getTablaCampos(TablaCampo myTablaCampo) {
        List lista = null;
        TablaCampoDao myTablaCampoDao = new TablaCampoDao();
        try {
            conn = conexion.conectar();
            lista = myTablaCampoDao.searchMatching(conn, myTablaCampo);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return lista;
    }

    public List getCampos(Campo myCampo) {
        List lista = null;
        CampoDao myCampoDao = new CampoDao();
        try {
            conn = conexion.conectar();
            lista = myCampoDao.searchMatching(conn, myCampo);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return lista;
    }

    public List getViewCamposDeTabla(ViewCamposDeTabla myViewCamposDeTabla) {
        List lista = null;
        ViewCamposDeTablaDao myViewCamposDeTablaDao = new ViewCamposDeTablaDao();
        try {
            conn = conexion.conectar();
            lista = myViewCamposDeTablaDao.searchMatching(conn, myViewCamposDeTabla);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return lista;
    }

    public List executeQueryAccesorias(String sql, int idUsuario) {
        //Creacion de objetos para validar ke el id es valido
        Usuarios myUser = new Usuarios();
        myUser.setID_USUARIO(idUsuario);
        UsuariosDao myUserDao = new UsuariosDao();
        /////////////////////////////////////////////////////
        List lista = null;
        if (!Funciones.verificarSqlEntrante(sql))
            return null;
        Funciones fnc = new Funciones();
        try {
            conn = conexion.conectar();
            if ((myUserDao.searchMatching(conn, myUser)).size() > 0) {
                PlantillaDao myDao = new PlantillaDao();
                lista = myDao.getData(conn, sql);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return lista;
    }

    public boolean modificarAccesorias(String sql, int idUsuario, String myIp, String myHost) {
        //Creacion de objetos para validar ke el id es valido
        //Campos para la auditoria
        Auditoria myAuditoria;
        AuditoriaSystem myAuditSx;
        Usuarios anterior;
        //--Campos para la auditoria
        Usuarios myUser = new Usuarios();
        myUser.setID_USUARIO(idUsuario);
        UsuariosDao myUserDao = new UsuariosDao();
        boolean insertado = false;
        /////////////////////////////////////////////////////
        if (!Funciones.verificarSqlEntrante2(sql))
            return false;
        Funciones fnc = new Funciones();
        try {
            conn = conexion.conectar();
            if ((myUserDao.searchMatching(conn, myUser)).size() > 0) {
                PlantillaDao myDao = new PlantillaDao();
                if (myDao.setData(conn, sql) > 0) {
                    insertado = true;
                    //System.out.println("la consulta es: "+sql);
                    //Pasos para la auditoria generica
                    myAuditoria = new Auditoria();
                    myAuditSx = new AuditoriaSystem();
                    if (sql.contains("INSERT"))
                        myAuditSx.setTIPOPERACION("I");
                    if (sql.contains("UPDATE"))
                        myAuditSx.setTIPOPERACION("E");
                    myAuditSx.setTABLAAFECTADA("GENERICA");
                    myAuditSx.setCAMPOCLAVE("NO DEFINIDO");
                    myAuditSx.setDESCRIPOPERACION("Se ejecuto la siguiente instruccion: " + sql);
                    myAuditSx.setVLRCAMPOCLAVE("0");
                    myAuditSx.setID_USUARIO(idUsuario);
                    myAuditSx.setIP(myIp);
                    myAuditSx.setNOMBREEQUIPO(myHost);
                    myAuditoria.auditarOtraOp(conn, myAuditSx, 0);
                    //-- para la auditoria
                } else
                    insertado = false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            insertado = false;
        } finally {
            conexion.cerrarCx();
        }
        return insertado;
    }

    public List getLimitacionPropiedad(LimitacionPropiedad limitacionPropiedad) {
        List lista = null;
        LimitacionPropiedadDao limitacionPropiedadDao = new LimitacionPropiedadDao();
        try {
            conn = conexion.conectar();
            lista = (ArrayList)limitacionPropiedadDao.loadAll(conn);
        } catch (Exception e) {
            e.printStackTrace();
            //System.out.println("error peter="+e.getMessage());

        } finally {
            conexion.cerrarCx();
        }
        return lista;
    }


    public LimitacionPropiedad getOneLimitacionPropiedad(LimitacionPropiedad limitacionPropiedad) {
        LimitacionPropiedadDao limitacionPropiedadDao = new LimitacionPropiedadDao();
        try {
            conn = conexion.conectar();
            limitacionPropiedadDao.load(conn, limitacionPropiedad);
        } catch (Exception e) {
            e.printStackTrace();
            //System.out.println("error peter="+e.getMessage());
        } finally {
            conexion.cerrarCx();
        }
        return limitacionPropiedad;
    }


    public List getTipoOperacion() {
        List lista = null;
        TipoOperacionDao myDao = new TipoOperacionDao();
        try {
            conn = conexion.conectar();
            lista = myDao.loadAll(conn);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return lista;
    }

    public boolean crearTipoOperacion(TipoOperacion tipoOperacion) {
        boolean res = false;
        TipoOperacionDao myDao = new TipoOperacionDao();
        try {
            conn = conexion.conectar();
            myDao.create(conn, tipoOperacion);
            res = true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return res;
    }

    public int getIdMarcaDesc(String nombre) {
        List lista = null;
        Marca marca = new Marca();
        marca.setDESCRIPCION(nombre);
        lista = searchMarca(marca);
        if (lista != null && lista.size() > 0)
            marca = (Marca)lista.get(0);
        else
            marca.setIDMARCPPAL("-1");
        return Integer.parseInt(marca.getIDMARCPPAL());
    }

    public int getIdMarcaMinDesc(String nombre) {
        List lista = null;
        MarcaMin marca = new MarcaMin();
        MarcaMinDao marcaDao = new MarcaMinDao();
        marca.setDESCMARCA(nombre);
        try {
            conn = conexion.conectar();
            lista = marcaDao.searchMatching(conn, marca);
            if (lista != null && lista.size() > 0)
                marca = (MarcaMin)lista.get(0);
            else
                marca.setID_MARCAMIN(-1);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return marca.getID_MARCAMIN();
    }

    public int getidLineaRunt(String nombre, String idMarca) {
        List lista = null;
        RuntLinea runtLinea = new RuntLinea();
        RuntLineaDao runtLineaDao = new RuntLineaDao();
        runtLinea.setDESCRIPCION(nombre);
        runtLinea.setID_MARCAPPAL(idMarca);
        try {
            conn = conexion.conectar();
            lista = runtLineaDao.searchMatching(conn, runtLinea);
            if (lista != null && lista.size() > 0)
                runtLinea = (RuntLinea)lista.get(0);
            else
                runtLinea.setID_LINEAPPAL("-1");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return Integer.parseInt(runtLinea.getID_LINEAPPAL());
    }

    public int getidLineaMin(String nombre, int idMarcaMin) {
        List lista = null;
        LineaMin linea = new LineaMin();
        LineaMinDao lineaMinDao = new LineaMinDao();
        linea.setDESCLINEA(nombre);
        linea.setID_MARCA(idMarcaMin);
        try {
            conn = conexion.conectar();
            lista = lineaMinDao.searchMatching(conn, linea);
            if (lista != null && lista.size() > 0)
                linea = (LineaMin)lista.get(0);
            else
                linea.setID_LINEA(-1);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return linea.getID_LINEA();
    }

    public int crearMarca(String nombre) {
        int id = -1;
        conn = conexion.conectar();
        try {
            id = Funciones.obtenerId(conn, "GEN_MARCA", "GEN_MARCA", myMotor);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (id != -1)
            try {
                Marca marca = new Marca();
                marca.setIDMARCPPAL(String.valueOf(id));
                marca.setDESCRIPCION(nombre);
                marca.setCODNUMMARCA(String.valueOf(id));
                
                MarcaDao myDao = new MarcaDao();
                myDao.create(conn, marca);
            } catch (Exception e) {
                e.printStackTrace();
				id = -1;
            }
        return id;
    }

    public int crearMarcaMin(String nombre) {
        int id = -1;
        conn = conexion.conectar();
        try {
            id = Funciones.obtenerId(conn, "GEN_ID_MARCAMIN", "GEN_ID_MARCAMIN", myMotor);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (id != -1)
            try {
                MarcaMin marca = new MarcaMin();
                marca.setID_MARCAMIN(id);
                marca.setDESCMARCA(nombre);
                marca.setCODNUMERO(String.valueOf(id));
                MarcaMinDao myDao = new MarcaMinDao();
                myDao.create(conn, marca);
            } catch (Exception e) {
                e.printStackTrace();
				id = -1;
            }
        return id;
    }


    public int crearLineaRunt(String nombre, String idMarca) {
        int id = -1;
        conn = conexion.conectar();
        try {
            id = Funciones.obtenerId(conn, "GEN_LINEA", "GEN_LINEA", myMotor);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (id != -1)
            try {
                RuntLinea runtLinea = new RuntLinea();
                RuntLineaDao runtLineaDao = new RuntLineaDao();
                runtLinea.setID_LINEAPPAL(String.valueOf(id));
                runtLinea.setDESCRIPCION(nombre);
                runtLinea.setID_MARCAPPAL(idMarca);

                runtLineaDao.create(conn, runtLinea);
            } catch (Exception e) {
                e.printStackTrace();
                id = -1;
            } finally {
                conexion.cerrarCx();
            }
        return id;
    }


    public int crearLineaMin(String nombre, int idMarca) {
        int id = -1;
        conn = conexion.conectar();
        try {
            id = Funciones.obtenerId(conn, "GEN_ID_LINEAMIN", "GEN_ID_LINEAMIN", myMotor);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (id != -1)
            try {
                LineaMin linea = new LineaMin();
                LineaMinDao lineaMinDao = new LineaMinDao();
                linea.setID_LINEA(id);
                linea.setDESCLINEA(nombre);
                linea.setID_MARCA(idMarca);

                lineaMinDao.create(conn, linea);
            } catch (Exception e) {
                e.printStackTrace();
				id = -1;
                ;
            } finally {
                conexion.cerrarCx();
            }
        return id;
    }

    public List getEscuelasConduccion() {
        List lista = null;
        EscuelasConduccionDao myEscConDao = new EscuelasConduccionDao();
        try {
            conn = conexion.conectar();
            lista = myEscConDao.loadAll(conn);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return lista;
    }

    public List getEscuelasConduccion(EscuelasConduccion myEscCond) {
        List lista = null;
        EscuelasConduccionDao myEscConDao = new EscuelasConduccionDao();
        try {
            conn = conexion.conectar();
            lista = myEscConDao.searchMatching(conn, myEscCond);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return lista;
    }
    
    public int ObtenerId(String generador) {
        int id = -1;
        conn = conexion.conectar();
        try {
            id = Funciones.obtenerId(conn, generador, generador, myMotor);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return id;
    }


}
