package modelo.datos.objetos.liquidador;

public class DatosAdicionalesFactura {

    String nota;
    String tipo; //1 factura  //2 comparendos //3 gps monitoreo
    String tipoPE;//1 persona, 2 vehiculo
    String idVehiculo;
    String idPersona;
    String tipoIT;// 1 impuestos, 2 tramites,  1 impuestos y tramites 
    String estado;//1 liquidado,2 pago, 3 tramitado, 4 cancelado
    String total;
    
    public DatosAdicionalesFactura() {
        super();
    }

    public void setNota(String nota) {
        this.nota = nota;
    }

    public String getNota() {
        return nota;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setIdVehiculo(String idVehiculo) {
        this.idVehiculo = idVehiculo;
    }

    public String getIdVehiculo() {
        return idVehiculo;
    }

    public void setTipoPE(String tipoPE) {
        this.tipoPE = tipoPE;
    }

    public String getTipoPE() {
        return tipoPE;
    }

    public void setIdPersona(String idPersona) {
        this.idPersona = idPersona;
    }

    public String getIdPersona() {
        return idPersona;
    }

    public void setTipoIT(String tipoIT) {
        this.tipoIT = tipoIT;
    }

    public String getTipoIT() {
        return tipoIT;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getEstado() {
        return estado;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getTotal() {
        return total;
    }
}
