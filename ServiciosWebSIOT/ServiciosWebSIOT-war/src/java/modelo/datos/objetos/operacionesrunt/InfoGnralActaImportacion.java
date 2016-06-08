package modelo.datos.objetos.operacionesrunt;

public class InfoGnralActaImportacion {
    private String numeroActaManifiestoImportacionDeclaracionAduana;
    private String fechaManifiestoImportacionDeclaracionAduana;
    private String tipoDocumentoPer;
    private String numeroDocumentoPer;
    private String paisOrigen;
    private String numeroLevante;
    private String fechaLevante;
    private String tipoRegistro;
    
    public InfoGnralActaImportacion() {
        super();
    }

    public String getNumeroActaManifiestoImportacionDeclaracionAduana() {
        return numeroActaManifiestoImportacionDeclaracionAduana;
    }

    public void setNumeroActaManifiestoImportacionDeclaracionAduana(String numeroActaManifiestoImportacionDeclaracionAduana) {
        this.numeroActaManifiestoImportacionDeclaracionAduana =
                numeroActaManifiestoImportacionDeclaracionAduana;
    }

    public String getFechaManifiestoImportacionDeclaracionAduana() {
        return fechaManifiestoImportacionDeclaracionAduana;
    }

    public void setFechaManifiestoImportacionDeclaracionAduana(String fechaManifiestoImportacionDeclaracionAduana) {
        this.fechaManifiestoImportacionDeclaracionAduana =
                fechaManifiestoImportacionDeclaracionAduana;
    }

    public String getTipoDocumentoPer() {
        return tipoDocumentoPer;
    }

    public void setTipoDocumentoPer(String tipoDocumentoPer) {
        this.tipoDocumentoPer = tipoDocumentoPer;
    }

    public String getNumeroDocumentoPer() {
        return numeroDocumentoPer;
    }

    public void setNumeroDocumentoPer(String numeroDocumentoPer) {
        this.numeroDocumentoPer = numeroDocumentoPer;
    }

    public String getPaisOrigen() {
        return paisOrigen;
    }

    public void setPaisOrigen(String paisOrigen) {
        this.paisOrigen = paisOrigen;
    }

    public String getNumeroLevante() {
        return numeroLevante;
    }

    public void setNumeroLevante(String numeroLevante) {
        this.numeroLevante = numeroLevante;
    }

    public String getFechaLevante() {
        return fechaLevante;
    }

    public void setFechaLevante(String fechaLevante) {
        this.fechaLevante = fechaLevante;
    }

    public String getTipoRegistro() {
        return tipoRegistro;
    }

    public void setTipoRegistro(String tipoRegistro) {
        this.tipoRegistro = tipoRegistro;
    }
}
