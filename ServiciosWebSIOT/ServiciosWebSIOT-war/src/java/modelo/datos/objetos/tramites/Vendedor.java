package modelo.datos.objetos.tramites;

public class Vendedor {
    String tipoDoc;
    String identificacion;
    String tipoDocApoderado;
    String identificacionApoderado;
    
    public Vendedor() {
        super();
    }

    public String getTipoDoc() {
        return tipoDoc;
    }

    public void setTipoDoc(String tipoDoc) {
        this.tipoDoc = tipoDoc;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getTipoDocApoderado() {
        return tipoDocApoderado;
    }

    public void setTipoDocApoderado(String tipoDocApoderado) {
        this.tipoDocApoderado = tipoDocApoderado;
    }

    public String getIdentificacionApoderado() {
        return identificacionApoderado;
    }

    public void setIdentificacionApoderado(String identificacionApoderado) {
        this.identificacionApoderado = identificacionApoderado;
    }
}
