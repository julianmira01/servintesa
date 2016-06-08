package modelo.datos.objetos.generales;

public class TramiteBasico {

    String idVehiculo;
    String placa;
    String idReciboLiquidacion;
    String numeroFactura;
    String ordenEjecucion;
    int nroTramites;
    String codTramite;
    String estado;
    
    


    public TramiteBasico() {
        super();
    }

    public void setIdVehiculo(String idVehiculo) {
        this.idVehiculo = idVehiculo;
    }

    public String getIdVehiculo() {
        return idVehiculo;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getPlaca() {
        return placa;
    }

    public void setIdReciboLiquidacion(String idReciboLiquidacion) {
        this.idReciboLiquidacion = idReciboLiquidacion;
    }

    public String getIdReciboLiquidacion() {
        return idReciboLiquidacion;
    }

    public void setNumeroFactura(String numeroFactura) {
        this.numeroFactura = numeroFactura;
    }

    public String getNumeroFactura() {
        return numeroFactura;
    }


    public String getCodTramite() {
        return codTramite;
    }

    public void setCodTramite(String codTramite) {
        this.codTramite = codTramite;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }


    public String getOrdenEjecucion() {
        return ordenEjecucion;
    }

    public void setOrdenEjecucion(String ordenEjecucion) {
        this.ordenEjecucion = ordenEjecucion;
    }

    public int getNroTramites() {
        return nroTramites;
    }

    public void setNroTramites(int nroTramites) {
        this.nroTramites = nroTramites;
    }
}
