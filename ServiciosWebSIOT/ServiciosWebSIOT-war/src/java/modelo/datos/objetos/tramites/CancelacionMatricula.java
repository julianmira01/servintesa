package modelo.datos.objetos.tramites;

public class CancelacionMatricula {
    String idMotivoCancelacion;
    String fechaCancelacion;
    String numeroMotor;    
    
    public CancelacionMatricula() {
        super();
    }

    public void setIdMotivoCancelacion(String idMotivoCancelacion) {
        this.idMotivoCancelacion = idMotivoCancelacion;
    }

    public String getIdMotivoCancelacion() {
        return idMotivoCancelacion;
    }

    public void setFechaCancelacion(String fechaCancelacion) {
        this.fechaCancelacion = fechaCancelacion;
    }

    public String getFechaCancelacion() {
        return fechaCancelacion;
    }

    public void setNumeroMotor(String numeroMotor) {
        this.numeroMotor = numeroMotor;
    }

    public String getNumeroMotor() {
        return numeroMotor;
    }
}
