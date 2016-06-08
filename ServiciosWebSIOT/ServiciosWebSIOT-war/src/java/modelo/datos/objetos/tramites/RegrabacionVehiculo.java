package modelo.datos.objetos.tramites;

public class RegrabacionVehiculo {
    
    String MotivoRegrabacion;
    String NumeroChasis;
    String NumeroMotor;
    String NumeroRevisionTecnicoMecanica;
    String NumeroSerie;
    String TipoRegrabacion;
    
    public RegrabacionVehiculo() {
        super();
    }

    public String getMotivoRegrabacion() {
        return MotivoRegrabacion;
    }

    public void setMotivoRegrabacion(String MotivoRegrabacion) {
        this.MotivoRegrabacion = MotivoRegrabacion;
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

    public String getNumeroRevisionTecnicoMecanica() {
        return NumeroRevisionTecnicoMecanica;
    }

    public void setNumeroRevisionTecnicoMecanica(String NumeroRevisionTecnicoMecanica) {
        this.NumeroRevisionTecnicoMecanica = NumeroRevisionTecnicoMecanica;
    }

    public String getNumeroSerie() {
        return NumeroSerie;
    }

    public void setNumeroSerie(String NumeroSerie) {
        this.NumeroSerie = NumeroSerie;
    }

    public String getTipoRegrabacion() {
        return TipoRegrabacion;
    }

    public void setTipoRegrabacion(String TipoRegrabacion) {
        this.TipoRegrabacion = TipoRegrabacion;
    }
}
