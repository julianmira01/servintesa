package modelo.datos.objetos.tramites;

public class TramiteRadicadoCuenta {
    String nombreAutoridadTransito;
    String nombreAutoridadTransitoOrigen;
    String numeroDocumentoEmpresa;
    String tipoDocumentoEmpresa;
    
    public TramiteRadicadoCuenta() {
        super();
    }

    public String getNombreAutoridadTransito() {
        return nombreAutoridadTransito;
    }

    public void setNombreAutoridadTransito(String nombreAutoridadTransito) {
        this.nombreAutoridadTransito = nombreAutoridadTransito;
    }

    public String getNombreAutoridadTransitoOrigen() {
        return nombreAutoridadTransitoOrigen;
    }

    public void setNombreAutoridadTransitoOrigen(String nombreAutoridadTransitoOrigen) {
        this.nombreAutoridadTransitoOrigen = nombreAutoridadTransitoOrigen;
    }

    public String getNumeroDocumentoEmpresa() {
        return numeroDocumentoEmpresa;
    }

    public void setNumeroDocumentoEmpresa(String numeroDocumentoEmpresa) {
        this.numeroDocumentoEmpresa = numeroDocumentoEmpresa;
    }

    public String getTipoDocumentoEmpresa() {
        return tipoDocumentoEmpresa;
    }

    public void setTipoDocumentoEmpresa(String tipoDocumentoEmpresa) {
        this.tipoDocumentoEmpresa = tipoDocumentoEmpresa;
    }
}
