package servicios.accesorias;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import javax.jws.Oneway;
import javax.jws.WebMethod;
import javax.jws.WebService;
import modelo.conexion.Conexion;
import modelo.datos.dao.accesorias.RuntConcesionarioDao;

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
import modelo.datos.objetos.medidasCautelares.J_Entes;
import modelo.datos.objetos.medidasCautelares.J_Tproceso;
import modelo.datos.objetos.medidasCautelares.Runt_Tprocesocautelar;

import modelo.logica.accesorias.GestionServiciosAccesoriasLocal;

import utilidades.Funciones;


@WebService
public class ServiciosAccesorias {
    GestionServiciosAccesoriasLocal gestionServiciosAccesoriasLocal; 
  
    
    public ServiciosAccesorias() {
        super();
        crearObjetos();
    }    

    @Oneway
    @WebMethod
    public void crearObjetos(){
       gestionServiciosAccesoriasLocal=new GestionServiciosAccesoriasLocal(); 
    }

    @WebMethod
    public List getCiudades() {
      return  gestionServiciosAccesoriasLocal.getCiudades();
      
    }
    
    @WebMethod
    public List getCiudadesPorDepto(Ciudad myCiudad) {
        return  gestionServiciosAccesoriasLocal.getCiudades(myCiudad);
    }
    
    @WebMethod 
    public List buscarCiudad(Ciudad ciudad){
      return gestionServiciosAccesoriasLocal.buscarCiudad(ciudad);
    }
    
    @WebMethod
    public List getPaises(Pais pais) {
        return gestionServiciosAccesoriasLocal.getPaises(pais);
    }

    @WebMethod
    public List getDepartamentos(Departamento departamento) {
       return gestionServiciosAccesoriasLocal.getDepartamentos(departamento);
    }

    @WebMethod
    public List getGruposSanguineos(GrupoSanguineo grupoSanguineo) {
       return gestionServiciosAccesoriasLocal.getGruposSanguineos(grupoSanguineo);
    }

    @WebMethod
    public List getDocumentos() throws Exception {
       return gestionServiciosAccesoriasLocal.getDocumentos();
    }

    @WebMethod
    public List getSexos(Sexo sexo) {
       return  gestionServiciosAccesoriasLocal.getSexos(sexo);
    }
    
    @WebMethod
    public Sexo getSexo(Sexo sexo) {
       return  gestionServiciosAccesoriasLocal.getSexo(sexo);
    }

    @WebMethod
    public List getDirecciones(Direccion direccion) {
        return gestionServiciosAccesoriasLocal.getDirecciones(direccion);
    }

    @WebMethod
    public List getTipoDireccion(TipoDireccion tipoDireccion) {
        return gestionServiciosAccesoriasLocal.getTipoDireccion(tipoDireccion);
    }


    @WebMethod
    public List getTipoRegistro(RuntTipoRegistro tipoRegistro) {
        return gestionServiciosAccesoriasLocal.getTipoRegistro(tipoRegistro); 
    }

    @WebMethod
    public List getTipoServicio(Servicio tipoServicio){
        return gestionServiciosAccesoriasLocal.getTipoServicio(tipoServicio);      
    }

    @WebMethod
    public Servicio getTipoServicioPorIdServicio(Servicio servicio){
        return gestionServiciosAccesoriasLocal.getTipoServicioPorIdServicio(servicio);
    }
    
    @WebMethod
    public Servicio getTipoServicioPorIdServicioRunt(Servicio servicio){
        return gestionServiciosAccesoriasLocal.getTipoServicioPorIdServicioRunt(servicio);
    }

    @WebMethod
    public List getServiciosValidos(Servicio servicio){
        return gestionServiciosAccesoriasLocal.getServiciosValidos(servicio);
    }

    @WebMethod
    public List getModalidad(Modalidad tipoModalidad){
      return gestionServiciosAccesoriasLocal.getModalidad(tipoModalidad);      
    }
    
        
    @WebMethod
    public List getModalidadSearch(Modalidad modalidad) {
      return gestionServiciosAccesoriasLocal.getModalidadSearch(modalidad);      
    }
    

    @WebMethod
    public Modalidad obtenerModalidad(Modalidad tipoModalidad){
      return gestionServiciosAccesoriasLocal.obtenerModalidad(tipoModalidad);      
    }

    @WebMethod
    public List getTipoPlaca(RuntTipoPlaca tipoPlaca){
      return gestionServiciosAccesoriasLocal.getTipoPlaca(tipoPlaca);      
    }


    @WebMethod
    public RuntTipoPlaca getTipoPlacaPorIdTipoPlaca(RuntTipoPlaca tipoPlaca){
      return gestionServiciosAccesoriasLocal.getTipoPlacaPorIdTipoPlaca(tipoPlaca);
  }

    @WebMethod
    public List getClaseVehiculo(ClaseVehiculo claseVehiculo, boolean remolqueSemiremolque)throws Exception
    {
      try 
      { 
        return gestionServiciosAccesoriasLocal.getClaseVehiculo(claseVehiculo, remolqueSemiremolque);
      }catch(Exception e)
      {
          throw new Exception(e.getMessage());
      }      
    }
    
    @WebMethod
    public List getClaseVehiculoAll(){
      return gestionServiciosAccesoriasLocal.getClaseVehiculoAll();
    }

    @WebMethod
    public List getMarca(Marca  marca){
      return gestionServiciosAccesoriasLocal.getMarca(marca);      
    }
    
    @WebMethod
    public List getMarcaSeach(Marca  marca){
      return gestionServiciosAccesoriasLocal.getMarcaSearch(marca);      
    }
    
    
    @WebMethod
    public Marca getMarcaPorId(String  idMarca){
      return gestionServiciosAccesoriasLocal.getMarca(idMarca);      
    }
    
    

    @WebMethod
    public List getTipoMotor(RuntTipoMotor tipoMotor){
      return gestionServiciosAccesoriasLocal.getTipoMotor(tipoMotor);      
    }

    @WebMethod
    public List getColor(Colores colores){
      return gestionServiciosAccesoriasLocal.getColor(colores);
    }

    @WebMethod
    public Colores getColorPorIdColor(Colores color) {
      return gestionServiciosAccesoriasLocal.getColorPorIdColor(color);
    }

    @WebMethod
    public List getTipoCombustible(Combustible combustible){
      return gestionServiciosAccesoriasLocal.getTipoCombustible(combustible);      
    }

    @WebMethod
    public Combustible obtenerTipoCombustible(Combustible combustible){
      return gestionServiciosAccesoriasLocal.obtenerTipoCombustible(combustible);      
    }

    @WebMethod
    public List getConcesionario(RuntConcesionario runtConcesionario){
      return gestionServiciosAccesoriasLocal.getConcesionario(runtConcesionario);      
    }

    @WebMethod
    public List getEmpresasGPS(RuntConcesionario runtConcesionario){
        Connection conn;
        Conexion conexion = new Conexion();
        RuntConcesionarioDao runtConcesionarioDao = new RuntConcesionarioDao();
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
    
    @WebMethod
    public List getTipoMatricula(RuntTipoMatricula runtTipoMatricula){
      return gestionServiciosAccesoriasLocal.getTipoMatricula(runtTipoMatricula);      
    }

    @WebMethod
    public List getLinea(RuntLinea runtLinea){
      return gestionServiciosAccesoriasLocal.getLinea(runtLinea);      
    }

    @WebMethod
    public List getLineaMarca(RuntLinea runtLinea){
      return gestionServiciosAccesoriasLocal.getLineaMarca(runtLinea);      
    }

    @WebMethod
    public List getRuntGrupo(RuntGrupo runtGrupo){
      return gestionServiciosAccesoriasLocal.getRuntGrupo(runtGrupo);      
    }

       @WebMethod
    public List getRuntAntiClasi(RuntAntiClasi runtAntiClasi){
      return gestionServiciosAccesoriasLocal.getRuntAntiClasi(runtAntiClasi);      
    }

    @WebMethod
    public List getRuntAduana(RuntAduana runtAduana){
      return gestionServiciosAccesoriasLocal.getRuntAduana(runtAduana);      
    }
    
    @WebMethod
    public RuntAduana getAduana(RuntAduana runtAduana){
      return gestionServiciosAccesoriasLocal.getAduana(runtAduana);      
    }

    @WebMethod
    public List getRuntTipoActa(RuntTipoActa runtTipoActa){
      return gestionServiciosAccesoriasLocal.getRuntTipoActa(runtTipoActa);      
    }

    @WebMethod
    public List getOrganismoTransito(OrganismoTransito organismoTransito){
      return gestionServiciosAccesoriasLocal.getOrganismoTransito(organismoTransito);      
    }
    
    public OrganismoTransito getOneOrganismoTransito(OrganismoTransito organismoTransito){
      return gestionServiciosAccesoriasLocal.getOneOrganismoTransito(organismoTransito);      
    }
    
    @WebMethod
    public List buscarOrganismoTransito(OrganismoTransito organismoTransito){
      return gestionServiciosAccesoriasLocal.getBuscarOrganismoTransito(organismoTransito);      
    }

    @WebMethod
    public List getCarroceria(TipCarroceria tipoCarroceria, ClaseVehiculo claseVehiculo){
      return gestionServiciosAccesoriasLocal.getCarroceria(tipoCarroceria, claseVehiculo);      
    }
    
        
    @WebMethod
    public List getCarroceriaSearch(TipCarroceria tipoCarroceria) {
      return gestionServiciosAccesoriasLocal.getCarroceriaSearch(tipoCarroceria);
    }
    
    
    @WebMethod
    public TipCarroceria obtenerCarroceria(TipCarroceria tipoCarroceria){
      return gestionServiciosAccesoriasLocal.obtenerCarroceria(tipoCarroceria);      
    }
    
    @WebMethod
    public List ListarTipoCarroceria(){
      return gestionServiciosAccesoriasLocal.ListarTipoCarroceria();      
    }

    @WebMethod
    public List getEmpresaAseguradora(EmpresaAseguradora empresaAseguradora){
      return gestionServiciosAccesoriasLocal.getEmpresaAseguiradora(empresaAseguradora);      
    }

    @WebMethod
    public List getTipoDoctoVehi(TipDoctoVehi tipDoctoVehi ){
      return gestionServiciosAccesoriasLocal.getTipoDoctoVehi(tipDoctoVehi);      
    }

    @WebMethod
    public List getOrgExpideDocto(OrgExpideDocto orgExpideDocto){
      return gestionServiciosAccesoriasLocal.getOrgExpideDocto(orgExpideDocto);      
    }

    @WebMethod
    public RuntModeloVehi getRuntModeloVehi(RuntModeloVehi runtModeloVehi){
      return gestionServiciosAccesoriasLocal.getRuntModeloVehi(runtModeloVehi);      
    }
    
    @WebMethod
    public List ListarRuntModeloVehi(){
      return gestionServiciosAccesoriasLocal.ListarRuntModelosVehi();      
    }

    @WebMethod
    public List getClaseEmpresa(ClaseEmpresa claseEmpresa){
    return gestionServiciosAccesoriasLocal.getClaseEmpresa(claseEmpresa);      
  }

    @WebMethod
    public List getTipoSociedad(RuntTipoSociedad runtTipoSociedad){
    return gestionServiciosAccesoriasLocal.getTipoSociedad(runtTipoSociedad);
  }

    @WebMethod
    public List getTipoEntidad(RuntTipoEntidad runtTipoEntidad){
    return gestionServiciosAccesoriasLocal.getTipoEntidad(runtTipoEntidad);
  }

    @WebMethod
    public List getEstadoRepresentacion(RuntEstadoRepresentacion runtEstadoRepresentacion){
    return gestionServiciosAccesoriasLocal.getRuntEstadoRepresentacion(runtEstadoRepresentacion);
  }

    @WebMethod
    public List getTipoProcesosFiscales(){
      return gestionServiciosAccesoriasLocal.getTipoProcesosFiscales();
    }

    @WebMethod
    public List getTipoMedidaCautelar(){
      return gestionServiciosAccesoriasLocal.getTipoMedidaCauteralRunt();
    }

    public List getTipoProceso()
    {
      return gestionServiciosAccesoriasLocal.getTipoProceso();    
    }

    @WebMethod
    public List getEnteFiscal(){
      return gestionServiciosAccesoriasLocal.getEntesFiscales();
    }

    @WebMethod
    public Ciudad getCiudadporID(Ciudad ciudad) {
      return gestionServiciosAccesoriasLocal.getCiudadporID(ciudad);
    }

    @WebMethod
    public Documento getTipoDocporID(Documento documento){
      return gestionServiciosAccesoriasLocal.getTipoDocporID(documento);
    }

    @WebMethod
    public J_Entes getEnteporID(J_Entes entidad){
      return gestionServiciosAccesoriasLocal.getEnteporID(entidad);
    }

    @WebMethod
    public J_Tproceso getTipoProcesoporID(J_Tproceso tproceso){
      return gestionServiciosAccesoriasLocal.getTipoProcesosporID(tproceso);
    }

    @WebMethod
    public Runt_Tprocesocautelar getTipoMedidaporID(Runt_Tprocesocautelar tmedida){
      return gestionServiciosAccesoriasLocal.getTipoMedidaporID(tmedida);
    }

    @WebMethod
    public List getTipoTramite(){
      return gestionServiciosAccesoriasLocal.getTipoTramite();
    }

    @WebMethod
    public List getHomologacionTramite(){
      return gestionServiciosAccesoriasLocal.getHomologacionTramite();
    }

    @WebMethod
    public Tipobase getTipoTramiteporID(Tipobase tbase){
      return gestionServiciosAccesoriasLocal.getTipoTramiteporID(tbase);
    }

    @WebMethod
    public Tramitesdevehiculos getHomologacionporID(Tramitesdevehiculos tramite){
      return gestionServiciosAccesoriasLocal.getHomologacionporID(tramite);
    }

    @WebMethod
    public List getMotivoDeCancelacion(MotivoDeCancelacion motivoDeCancelacion){
      return gestionServiciosAccesoriasLocal.getMotivoDeCancelacion(motivoDeCancelacion);
    }

    @WebMethod
    public MotivoDeCancelacion obtenerMotivoDeCancelacion(MotivoDeCancelacion motivoDeCancelacion){
      return gestionServiciosAccesoriasLocal.obtenerMotivoDeCancelacion(motivoDeCancelacion);
    }   
  
    @WebMethod
    public List getMotivosCancelacionTrasladoCuenta(MotivoDeCancelacion motivoDeCancelacion){
      return gestionServiciosAccesoriasLocal.getMotivosCancelacionTrasladoCuenta(motivoDeCancelacion);
    }

    @WebMethod
    public boolean crearRequisito(Requisitotramite requisito){
      return gestionServiciosAccesoriasLocal.crearRequisito(requisito);
    }

    @WebMethod
    public boolean eliminarRequisito(Requisitotramite requisito){
        return gestionServiciosAccesoriasLocal.eliminarRequisito(requisito);
    }

    @WebMethod
    public boolean actualizarRequisito(Requisitotramite requisito){
      return gestionServiciosAccesoriasLocal.actualizarRequisito(requisito);
    }

    @WebMethod
    public List getRequisitos(){
      return gestionServiciosAccesoriasLocal.getRequisitos();
    }

    @WebMethod
    public Requisitotramite getRequisitoporID(Requisitotramite requisito){
      return gestionServiciosAccesoriasLocal.getRequisitosporID(requisito);
    }

    @WebMethod
    public List getMotivoDuplicado(MotivoDuplicado motivoDuplicado){
      return gestionServiciosAccesoriasLocal.getMotivoDuplicado(motivoDuplicado);
    }

    @WebMethod
    public MotivoDuplicado getMotivoDuplicadoPorId(MotivoDuplicado motivoDuplicado){
      return gestionServiciosAccesoriasLocal.getMotivoDuplicadoPorId(motivoDuplicado);
    }

    @WebMethod
    public String getFechaActual(){
        String myMotor = "";
        
        try{
            myMotor = Funciones.leer_ini("/WSTransito.ini", "MOTOR");
        }catch(Exception exce){}
        if(myMotor.equals(""))
        try{
            myMotor = Funciones.leer_ini("c:\\WSTransito.ini", "MOTOR");
        }catch(Exception exce){} 
      return Funciones.getFechaSistema(null,myMotor);
    }

    @WebMethod
    public String getFechaActualTexto(){
      return Funciones.getFechaSistemaTexto();
    }
    
    @WebMethod
    public String getHoraActualTexto(){
      return Funciones.getHoraSistemaString(null);
    }
    
    public String getFechaHora(String formato){
        return Funciones.getFechaSistema2(formato,null);
    }

    @WebMethod
    public List getTipoRegrabacion(RuntTipoRegrabacion tipoRegrabacion){
      return gestionServiciosAccesoriasLocal.getTipoRegrabacion(tipoRegrabacion);
    }

    @WebMethod
    public List getMotivoRegrabacion(RuntMotivoRegrabacion motivoRegrabacion){
      return gestionServiciosAccesoriasLocal.getMotivoRegrabacion(motivoRegrabacion);
    }

   
    @WebMethod
    public List getEstadosFactura(){
      return gestionServiciosAccesoriasLocal.getEstadosFactura();
    }

    @WebMethod
    public List getEstadoFactura(EstadosFactura estadoFactura){
      return gestionServiciosAccesoriasLocal.getEstadoFactura(estadoFactura);
    }
    
    @WebMethod
    public List getTipoRegistroImportacion(){
        return gestionServiciosAccesoriasLocal.getTipoRegistro();
    }
    
    @WebMethod
    public List searchTipoRegistroimportacion(TipoRegistro tipoRegistro){
        return gestionServiciosAccesoriasLocal.searchTipoRegistro(tipoRegistro);
    }
    
    @WebMethod
    public List getTipoAutomotor(){
      return gestionServiciosAccesoriasLocal.getTipoAutomotor();
    }
    
    @WebMethod
    public List searchTipoAutomotor(TipoAutomotor tipoAutomotor){
      return gestionServiciosAccesoriasLocal.searchTipoAutomotor(tipoAutomotor);
    }
    
    @WebMethod
    public List getModalidadActaImp(){
      return gestionServiciosAccesoriasLocal.getModalidadActaImp();
    }
    
  @WebMethod
  public List searchModalidadActaImp(RuntModalidadDeclaraImp modalidadActa){
    return gestionServiciosAccesoriasLocal.searchModalidadActaImp(modalidadActa);
  }
  
  @WebMethod
  public List getTipoImportacion(){
    return gestionServiciosAccesoriasLocal.getTipoImportacion();
  }
  
  @WebMethod
  public List searchTipoImportacion(RuntTipoImportacion tipoImportacion){
    return gestionServiciosAccesoriasLocal.searchTipoImportacion(tipoImportacion);
  }
  
  @WebMethod
  public List getTipoDeclaracionImp(){
    return gestionServiciosAccesoriasLocal.getTipoDeclaracionImp();
  }
  
  @WebMethod
  public List searchTipoDeclaracionImp(RuntTipoDeclaracion tipoDeclaracion){
    return gestionServiciosAccesoriasLocal.searchTipoDeclaracionImp(tipoDeclaracion);
  }
  

  @WebMethod
  public List ListarDependencias() {
      return gestionServiciosAccesoriasLocal.getDependencias(0); 
    }
    
  @WebMethod
  public List getDependencia(Dependencia myDependencia) {
      return gestionServiciosAccesoriasLocal.getDependencia(myDependencia,0); 
    }
  
  @WebMethod
  public List getLClaseVehiculo(LClaseVehiculo lclaseVehiculo){
    return gestionServiciosAccesoriasLocal.getLClaseVehiculo(lclaseVehiculo);      
  }
  
  @WebMethod
  public List getEspeciesVenales(EspecieVenal myEspVen) {
    return gestionServiciosAccesoriasLocal.getEspeciesVenales(myEspVen);
  }
  
  @WebMethod
  public List getMotivoCancelacion(MotivoDeCancelacion motivocancelacion) {
      return gestionServiciosAccesoriasLocal.getMotivoCancelacion(motivocancelacion);    
  }
  
  @WebMethod
  public List getNivelServicio(NiveldeServicio nivelServicio){
    return gestionServiciosAccesoriasLocal.getNivelServicio();
  }
  
  @WebMethod
  public List getOrigenRegistro(RuntOrigenRegistro origenRegistro){
    return gestionServiciosAccesoriasLocal.getOrigenRegistro();
  }
  
  @WebMethod
  public List getTipoBlindaje(RuntTipoblindaje tipoBlindaje){
    return gestionServiciosAccesoriasLocal.getTipoBlindaje();
  }
  
    @WebMethod
      public List getEstadosPropiedad(){
        return gestionServiciosAccesoriasLocal.getEstadoPropiedad();
      }
      
      @WebMethod
      public List searchEstadoPropiedad(RuntEstadoPropiedad estadopropiedad){
        return gestionServiciosAccesoriasLocal.searchEstadoPropiedad(estadopropiedad);
      }
      
    @WebMethod
      public List getTipoPropiedad(){
        return gestionServiciosAccesoriasLocal.getTipoPropiedad();
      }
      
      @WebMethod
      public List searchTipoPropiedad(RuntTipoPropiedad tipopropiedad){
        return gestionServiciosAccesoriasLocal.searchTipoPropiedad(tipopropiedad);
      }
      
    @WebMethod
    public List getGradoAlerta(){
      return gestionServiciosAccesoriasLocal.getGradoAlerta();
    }
    
    @WebMethod
    public List searchGradoAlerta(GradoAlerta gradoAlerta){
      return gestionServiciosAccesoriasLocal.searchGradoAlerta(gradoAlerta);
    }
    
    @WebMethod
    public List getTiposPago(LTiposPago tipoPago){
      return gestionServiciosAccesoriasLocal.getTiposPago(tipoPago);
  }
    
    @WebMethod
    public String getDescMarca(int id){
      return gestionServiciosAccesoriasLocal.getDescMarca(id);
    }
    
    @WebMethod
    public String getDescLinea(int id){
      return gestionServiciosAccesoriasLocal.getDesLinea(id);
    }
    
    @WebMethod
    public String getVigenciaActual()
    {
        return Funciones.getVigenciaActual();    
    }
    
    @WebMethod
    public List ListarTablas() {
       return gestionServiciosAccesoriasLocal.getTablas();
    }
    
    @WebMethod
    public List buscarTablas(Tabla myTabla) {
       return gestionServiciosAccesoriasLocal.getTablas(myTabla);
    }
    
    @WebMethod
    public List buscarCampos(Campo myCampo) {
       return gestionServiciosAccesoriasLocal.getCampos(myCampo);
    }
    
    @WebMethod
    public List buscarCampoTabla(TablaCampo myTablaCampo) {
       return gestionServiciosAccesoriasLocal.getTablaCampos(myTablaCampo);
    }
    
    @WebMethod
    public List buscarViewCamposDeTabla(ViewCamposDeTabla myViewCamposDeTabla)  {
       return gestionServiciosAccesoriasLocal.getViewCamposDeTabla(myViewCamposDeTabla);
    }
    
    @WebMethod
    public List executeQueryAccesorias(String query,int idUsuario){
      return gestionServiciosAccesoriasLocal.executeQueryAccesorias(query,idUsuario);
    }
    
    @WebMethod
    public boolean modificarAccesorias(String sql,int idUsuario,String myIp,String myHost){
        return gestionServiciosAccesoriasLocal.modificarAccesorias(sql,idUsuario,myIp,myHost);
    }
    
    @WebMethod
    public List getLimitacionPropiedad(LimitacionPropiedad limitacionPropiedad){
        return gestionServiciosAccesoriasLocal.getLimitacionPropiedad(limitacionPropiedad);
    }
    
    @WebMethod
    public String getDescClaseVehiculo(int id) {
        return gestionServiciosAccesoriasLocal.getDescClaseVehiculo(id);
    }
    
  @WebMethod
  public String getDescTipoServicio(int id) {
      return gestionServiciosAccesoriasLocal.getDescTipoServicio(id);
  }
    
   @WebMethod
   public List getTipoOperacion(){
       return gestionServiciosAccesoriasLocal.getTipoOperacion();
   }
    
    @WebMethod
    public boolean crearTipoOperacion(TipoOperacion tipoOperacion){
        return gestionServiciosAccesoriasLocal.crearTipoOperacion(tipoOperacion);
    }
    
  
    public int getIdMarcaDesc(String nombre) {
        return gestionServiciosAccesoriasLocal.getIdMarcaDesc(nombre);
    }
    
    public int getIdMarcaMinDesc(String nombre) {
        return gestionServiciosAccesoriasLocal.getIdMarcaMinDesc(nombre);
    }
    
    public int getidLineaRunt(String nombre, String idMarca) {
        return gestionServiciosAccesoriasLocal.getidLineaRunt(nombre, idMarca);
    }
    
    public int getidLineaMin(String nombre, int idMarca) {
        return gestionServiciosAccesoriasLocal.getidLineaMin(nombre, idMarca);
    }
    
    public int crearLineaRunt(String nombre, String idMarca) {
        return gestionServiciosAccesoriasLocal.crearLineaRunt(nombre, idMarca);
    }

    public int crearLineaMin(String nombre, int idMarca) {
        return gestionServiciosAccesoriasLocal.crearLineaMin(nombre, idMarca);
    }
    
    public int crearMarca(String nombre) {
        return gestionServiciosAccesoriasLocal.crearMarca(nombre);
    }
    
    public int crearMarcaMin(String nombre) {
        return gestionServiciosAccesoriasLocal.crearMarcaMin(nombre);
    }
    
    public String getLineaById(int id) {
      return gestionServiciosAccesoriasLocal.getLineaById(id);
    }
    
    public String getLineaMinById(int id) {
      return gestionServiciosAccesoriasLocal.getLineaMinById(id);
    }
    
    public String getDescMarcaPorId(String  idMarca){
      return gestionServiciosAccesoriasLocal.getMarcaById(idMarca);      
    }
    
    public String getDescMarcaMinPorId(int  idMarca){
      return gestionServiciosAccesoriasLocal.getMarcaMinById(idMarca);      
    }
    
    public List listarEscuelasConduccion(){
      return gestionServiciosAccesoriasLocal.getEscuelasConduccion();      
    }
    
    public List buscarEscuelasConduccion(EscuelasConduccion myEscCond){
      return gestionServiciosAccesoriasLocal.getEscuelasConduccion(myEscCond);      
    }
    
    public List getAllMarcaMin(MarcaMin marcamin){
        return gestionServiciosAccesoriasLocal.getAllMarcaMin(marcamin);
    }
    
    public List getMarcaMin(MarcaMin marcamin){
        return gestionServiciosAccesoriasLocal.getMarcaMin(marcamin);
    }
    
    public List getAllLineaMin(LineaMin lineaMin){
        return gestionServiciosAccesoriasLocal.getAllLineaMin(lineaMin);
    }
    
    public GradoAlerta getOneGradoAlerta(GradoAlerta gradoAlerta) {
        return gestionServiciosAccesoriasLocal.getOneGradoAlerta(gradoAlerta);
    }
    
    public LimitacionPropiedad getOneLimitacionPropiedad(LimitacionPropiedad limitacionPropiedad){
        return gestionServiciosAccesoriasLocal.getOneLimitacionPropiedad(limitacionPropiedad);
          
    }
    
    @WebMethod
    public int getId(String generador){
      return gestionServiciosAccesoriasLocal.ObtenerId(generador);      
    }
}



