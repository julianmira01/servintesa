package modelo.datos.objetos.liquidador;

public class DatosFactura {
    
    
    String numeroFacturaLocal;
    String totalFacturaLocal;
    String numeroFacturaRunt;
    String totalFacturaRunt;
    String total;
    
    public DatosFactura() {
        super();
    }

    public void setNumeroFacturaLocal(String numeroFacturaLocal) {
        this.numeroFacturaLocal = numeroFacturaLocal;
    }

    public String getNumeroFacturaLocal() {
        return numeroFacturaLocal;
    }

    public void setTotalFacturaLocal(String totalFacturaLocal) {
        this.totalFacturaLocal = totalFacturaLocal;
    }

    public String getTotalFacturaLocal() {
        return totalFacturaLocal;
    }

    public void setNumeroFacturaRunt(String numeroFacturaRunt) {
        this.numeroFacturaRunt = numeroFacturaRunt;
    }

    public String getNumeroFacturaRunt() {
        return numeroFacturaRunt;
    }

    public void setTotalFacturaRunt(String totalFacturaRunt) {
        this.totalFacturaRunt = totalFacturaRunt;
    }

    public String getTotalFacturaRunt() {
        return totalFacturaRunt;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getTotal() {
        return total;
    }
}
