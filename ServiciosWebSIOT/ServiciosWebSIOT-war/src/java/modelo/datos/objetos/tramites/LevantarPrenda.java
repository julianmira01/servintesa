package modelo.datos.objetos.tramites;

public class LevantarPrenda {
    
    String tipoDocAcreedor;
    String numDocAcreedor;
    String gradoAlerta;
    
    public LevantarPrenda() {
        super();
    }

    public String getTipoDocAcreedor() {
        return tipoDocAcreedor;
    }

    public void setTipoDocAcreedor(String tipoDocAcreedor) {
        this.tipoDocAcreedor = tipoDocAcreedor;
    }

    public String getNumDocAcreedor() {
        return numDocAcreedor;
    }

    public void setNumDocAcreedor(String numDocAcreedor) {
        this.numDocAcreedor = numDocAcreedor;
    }

    public String getGradoAlerta() {
        return gradoAlerta;
    }

    public void setGradoAlerta(String gradoAlerta) {
        this.gradoAlerta = gradoAlerta;
    }
}
