package modelo.datos.objetos.avaluos;

public class AvaluoResultado {
    
    private String GRUPO;    
    private double AVALUO;
    
    public AvaluoResultado() {
        GRUPO = "";
        AVALUO = 0;
    }

    public void setGRUPO(String GRUPO) {
        this.GRUPO = GRUPO;
    }

    public String getGRUPO() {
        return GRUPO;
    }

    public void setAVALUO(double AVALUO) {
        this.AVALUO = AVALUO;
    }

    public double getAVALUO() {
        return AVALUO;
    }
}
