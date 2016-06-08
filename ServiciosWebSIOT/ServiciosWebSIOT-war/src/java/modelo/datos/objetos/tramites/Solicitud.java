package modelo.datos.objetos.tramites;

import modelo.datos.objetos.generales.Persona;

public class Solicitud {
    String IdMarca;
    String NumeroAutomotor;
    String NumeroChasis;
    String NumeroMotor;
    String NumeroPlaca;
    String NumeroSerie;
    String NumeroVIN;
    String identificadorOT;
    String numeroDocumentoApoderado;
    String tipoDocumentoApoderado;
    String numeroDocumentoSolicitante;
    String tipoDocumentoSolicitante;
    String descripcionAutorizacion;    
    String numeroFacturaRunt;
    String nombrePropietario;
    
    public Solicitud() {
        
        super();
    }

    public String getIdMarca() {
        return IdMarca;
    }

    public void setIdMarca(String IdMarca) {
        this.IdMarca = IdMarca;
    }

    public String getNumeroAutomotor() {
        return NumeroAutomotor;
    }

    public void setNumeroAutomotor(String NumeroAutomotor) {
        this.NumeroAutomotor = NumeroAutomotor;
    }

    public String getNumeroChasis() {
        return NumeroChasis;
    }

    public void setNumeroChasis(String NumeroChasis) {
        this.NumeroChasis = NumeroChasis;
    }

    public String getNumeroMotor() {
        return NumeroMotor;
    }

    public void setNumeroMotor(String NumeroMotor) {
        this.NumeroMotor = NumeroMotor;
    }

    public String getNumeroPlaca() {
        return NumeroPlaca;
    }

    public void setNumeroPlaca(String NumeroPlaca) {
        this.NumeroPlaca = NumeroPlaca;
    }

    public String getNumeroSerie() {
        return NumeroSerie;
    }

    public void setNumeroSerie(String NumeroSerie) {
        this.NumeroSerie = NumeroSerie;
    }

    public String getNumeroVIN() {
        return NumeroVIN;
    }

    public void setNumeroVIN(String NumeroVIN) {
        this.NumeroVIN = NumeroVIN;
    }

    public String getIdentificadorOT() {
        return identificadorOT;
    }

    public void setIdentificadorOT(String identificadorOT) {
        this.identificadorOT = identificadorOT;
    }

    public String getNumeroDocumentoApoderado() {
        return numeroDocumentoApoderado;
    }

    public void setNumeroDocumentoApoderado(String numeroDocumentoApoderado) {
        this.numeroDocumentoApoderado = numeroDocumentoApoderado;
    }

    public String getTipoDocumentoApoderado() {
        return tipoDocumentoApoderado;
    }

    public void setTipoDocumentoApoderado(String tipoDocumentoApoderado) {
        this.tipoDocumentoApoderado = tipoDocumentoApoderado;
    }

    public String getDescripcionAutorizacion() {
        return descripcionAutorizacion;
    }

    public void setDescripcionAutorizacion(String descripcionAutorizacion) {
        this.descripcionAutorizacion = descripcionAutorizacion;
    }

    public String getNumeroDocumentoSolicitante() {
        return numeroDocumentoSolicitante;
    }

    public void setNumeroDocumentoSolicitante(String numeroDocumentoSolicitante) {
        this.numeroDocumentoSolicitante = numeroDocumentoSolicitante;
    }

    public String getTipoDocumentoSolicitante() {
        return tipoDocumentoSolicitante;
    }

    public void setTipoDocumentoSolicitante(String tipoDocumentoSolicitante) {
        this.tipoDocumentoSolicitante = tipoDocumentoSolicitante;
    }

    public String getNumeroFacturaRunt() {
        return numeroFacturaRunt;
    }

    public void setNumeroFacturaRunt(String numeroFacturaRunt) {
        this.numeroFacturaRunt = numeroFacturaRunt;
    }

    public String getNombrePropietario() {
        return nombrePropietario;
    }

    public void setNombrePropietario(String nombrePropietario) {
        this.nombrePropietario = nombrePropietario;
    }

}
