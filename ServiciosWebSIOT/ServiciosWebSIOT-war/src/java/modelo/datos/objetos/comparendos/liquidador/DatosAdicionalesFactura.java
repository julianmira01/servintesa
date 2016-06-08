package modelo.datos.objetos.comparendos.liquidador;

public class DatosAdicionalesFactura {
    
  String nota;
  String idPersona;
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

    public void setIdPersona(String idPersona) {
        this.idPersona = idPersona;
    }

    public String getIdPersona() {
        return idPersona;
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
