package modelo.datos.objetos.runt;

import java.io.Serializable;

import java.util.Calendar;

import modelo.datos.objetos.comparendos.generales.PropietarioVehComp;
import modelo.datos.objetos.generales.Persona;
import modelo.datos.objetos.generales.RuntRegrabacionVehiculo;
import modelo.datos.objetos.generales.vehiculo.Vehiculo;
import modelo.datos.objetos.tramites.Comprador;

public class DatosRunt implements Cloneable, Serializable{

    /********** Globales ****************************/
    
    private String tokenhuella;
    private String usuario;
    private String codtramite;
    private int idPersona;
    private String placa;
    private String tokenCliente;
    private int idTransito;
    private String numLiquidacion;
    private String rechazos;
    
    private String autorizacionLimitacion;
    private String descripcionAutorizacion;
    private String tipoSolicitud;
    private String registroSolicitud;
    private String tutelaOActoAdministrativo;
    private String validacionRequisitos;
    private int idPersonaPropietario;
    private int idPropietario;
    private String idTransitoOrigen;
    
    /********** WEB *********************************/
    
    //tramite 51 - Duplicado de licencia
    private String categoria;
    
    //tramite 29 - Expedicion de licencia
    private String idPais;
    //String categoria;
    
    //tramite 28 - Refrendacion Licencia Conduccion
    //String categoria;
    
    //tramite 53 - Recategorizacion Licencia Conduccion
    private String nuevaCategoria;
    private String numeroLicencia;
    //String categoria;
    
    /*************** NO WEB ********************************/
    //tramite 3 Tramite Cambio Color
    private String idColor;
    
    //tramite 9 Tramite Matricula Inicial
    private Calendar fechaCompraVenta;
    
    //tramite 20 Tramite Cancelacion Matricula
    private String motivoCancelacion;
    private String enteJudicial;
    private String numeroOficio;
    
    //tramite 16 Tramite Traspaso
    private int [] idperComprador;
    private int [] idperApoderadoC;
    private int [] idproVendedor;
    
    //tramite 4 Tramite Cambio Motor
    private String numMotor;
    
    //tramite 12 Tramite Regrabacion Vehiculo
    private String TIPOREGRABACION;
    private String NUMERO_REVISIONTECNOMECANICA;
    
    //tramite 11 Tramite Inscripcion Prenda
    private String gradoAlerta;
    private String tipoAlerta;
    
    //tramite 26 Tramite Levantamiento Prenda
    //String gradoAlerta;
    // String tipoAlerta;
    
    //tramite 54 Tramite Recategorizacion Licencia Conduccion   
    
    public DatosRunt() {        
        
    }

    public void setTokenhuella(String tokenhuella) {
        this.tokenhuella = tokenhuella;
    }

    public String getTokenhuella() {
        return tokenhuella;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setCodtramite(String codtramite) {
        this.codtramite = codtramite;
    }

    public String getCodtramite() {
        return codtramite;
    }

    public void setIdPersona(int idPersona) {
        this.idPersona = idPersona;
    }

    public int getIdPersona() {
        return idPersona;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getPlaca() {
        return placa;
    }

    public void setTokenCliente(String tokenCliente) {
        this.tokenCliente = tokenCliente;
    }

    public String getTokenCliente() {
        return tokenCliente;
    }

    public void setIdTransito(int idTransito) {
        this.idTransito = idTransito;
    }

    public int getIdTransito() {
        return idTransito;
    }
    
    public void setNumLiquidacion(String numLiquidacion) {
        this.numLiquidacion = numLiquidacion;
    }

    public String getNumLiquidacion() {
        return numLiquidacion;
    }

    public void setRechazos(String rechazos) {
        this.rechazos = rechazos;
    }

    public String getRechazos() {
        return rechazos;
    }

    public void setAutorizacionLimitacion(String autorizacionLimitacion) {
        this.autorizacionLimitacion = autorizacionLimitacion;
    }

    public String getAutorizacionLimitacion() {
        return autorizacionLimitacion;
    }

    public void setDescripcionAutorizacion(String descripcionAutorizacion) {
        this.descripcionAutorizacion = descripcionAutorizacion;
    }

    public String getDescripcionAutorizacion() {
        return descripcionAutorizacion;
    }

    public void setTipoSolicitud(String tipoSolicitud) {
        this.tipoSolicitud = tipoSolicitud;
    }

    public String getTipoSolicitud() {
        return tipoSolicitud;
    }

    public void setRegistroSolicitud(String registroSolicitud) {
        this.registroSolicitud = registroSolicitud;
    }

    public String getRegistroSolicitud() {
        return registroSolicitud;
    }

    public void setTutelaOActoAdministrativo(String tutelaOActoAdministrativo) {
        this.tutelaOActoAdministrativo = tutelaOActoAdministrativo;
    }

    public String getTutelaOActoAdministrativo() {
        return tutelaOActoAdministrativo;
    }

    public void setValidacionRequisitos(String validacionRequisitos) {
        this.validacionRequisitos = validacionRequisitos;
    }

    public String getValidacionRequisitos() {
        return validacionRequisitos;
    }

    public void setIdPersonaPropietario(int idPersonaPropietario) {
        this.idPersonaPropietario = idPersonaPropietario;
    }

    public int getIdPersonaPropietario() {
        return idPersonaPropietario;
    }

    public void setIdPropietario(int idPropietario) {
        this.idPropietario = idPropietario;
    }

    public int getIdPropietario() {
        return idPropietario;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setIdPais(String idPais) {
        this.idPais = idPais;
    }

    public String getIdPais() {
        return idPais;
    }

    public void setNuevaCategoria(String nuevaCategoria) {
        this.nuevaCategoria = nuevaCategoria;
    }

    public String getNuevaCategoria() {
        return nuevaCategoria;
    }

    public void setNumeroLicencia(String numeroLicencia) {
        this.numeroLicencia = numeroLicencia;
    }

    public String getNumeroLicencia() {
        return numeroLicencia;
    }

    public void setIdColor(String idColor) {
        this.idColor = idColor;
    }

    public String getIdColor() {
        return idColor;
    }

    public void setFechaCompraVenta(Calendar fechaCompraVenta) {
        this.fechaCompraVenta = fechaCompraVenta;
    }

    public Calendar getFechaCompraVenta() {
        return fechaCompraVenta;
    }

    public void setMotivoCancelacion(String motivoCancelacion) {
        this.motivoCancelacion = motivoCancelacion;
    }

    public String getMotivoCancelacion() {
        return motivoCancelacion;
    }

    public void setEnteJudicial(String enteJudicial) {
        this.enteJudicial = enteJudicial;
    }

    public String getEnteJudicial() {
        return enteJudicial;
    }

    public void setNumeroOficio(String numeroOficio) {
        this.numeroOficio = numeroOficio;
    }

    public String getNumeroOficio() {
        return numeroOficio;
    }

    public void setIdperComprador(int[] idperComprador) {
        this.idperComprador = idperComprador;
    }

    public int[] getIdperComprador() {
        return idperComprador;
    }

    public void setIdperApoderadoC(int[] idperApoderadoC) {
        this.idperApoderadoC = idperApoderadoC;
    }

    public int[] getIdperApoderadoC() {
        return idperApoderadoC;
    }

    public void setNumMotor(String numMotor) {
        this.numMotor = numMotor;
    }

    public String getNumMotor() {
        return numMotor;
    }

    public void setTIPOREGRABACION(String TIPOREGRABACION) {
        this.TIPOREGRABACION = TIPOREGRABACION;
    }

    public String getTIPOREGRABACION() {
        return TIPOREGRABACION;
    }

    public void setNUMERO_REVISIONTECNOMECANICA(String NUMERO_REVISIONTECNOMECANICA) {
        this.NUMERO_REVISIONTECNOMECANICA = NUMERO_REVISIONTECNOMECANICA;
    }

    public String getNUMERO_REVISIONTECNOMECANICA() {
        return NUMERO_REVISIONTECNOMECANICA;
    }

    public void setGradoAlerta(String gradoAlerta) {
        this.gradoAlerta = gradoAlerta;
    }

    public String getGradoAlerta() {
        return gradoAlerta;
    }

    public void setTipoAlerta(String tipoAlerta) {
        this.tipoAlerta = tipoAlerta;
    }

    public String getTipoAlerta() {
        return tipoAlerta;
    }
    
    public void setIdTransitoOrigen(String idTransitoOrigen) {
        this.idTransitoOrigen = idTransitoOrigen;
    }

    public String getIdTransitoOrigen() {
        return idTransitoOrigen;
    }

    public void setIdproVendedor(int[] idproVendedor) {
        this.idproVendedor = idproVendedor;
    }

    public int[] getIdproVendedor() {
        return idproVendedor;
    }
}
