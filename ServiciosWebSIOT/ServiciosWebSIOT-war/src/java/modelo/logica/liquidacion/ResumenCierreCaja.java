package modelo.logica.liquidacion;


public class ResumenCierreCaja {
    String cajero_nombre;
    String cajero_documento;
    Double base_valor;
    Double factura_valor;
    Double pago_valor;
    Double desface_valor;
    Double balance_valor;
    
    public ResumenCierreCaja() {
        super();
    }


    public String getCajero_nombre() {
        return cajero_nombre;
    }

    public void setCajero_nombre(String cajero_nombre) {
        this.cajero_nombre = cajero_nombre;
    }

    public String getCajero_documento() {
        return cajero_documento;
    }

    public void setCajero_documento(String cajero_documento) {
        this.cajero_documento = cajero_documento;
    }

    public Double getBase_valor() {
        return base_valor;
    }

    public void setBase_valor(Double base_valor) {
        this.base_valor = base_valor;
    }

    public Double getFactura_valor() {
        return factura_valor;
    }

    public void setFactura_valor(Double factura_valor) {
        this.factura_valor = factura_valor;
    }

    public Double getPago_valor() {
        return pago_valor;
    }

    public void setPago_valor(Double pago_valor) {
        this.pago_valor = pago_valor;
    }

    public Double getDesface_valor() {
        return desface_valor;
    }

    public void setDesface_valor(Double desface_valor) {
        this.desface_valor = desface_valor;
    }

    public Double getBalance_valor() {
        return balance_valor;
    }

    public void setBalance_valor(Double balance_valor) {
        this.balance_valor = balance_valor;
    }
}
