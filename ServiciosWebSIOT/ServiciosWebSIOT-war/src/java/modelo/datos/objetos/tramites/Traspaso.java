package modelo.datos.objetos.tramites;

public class Traspaso {
    String idTipoTraspaso;
    Vendedor[] vendedores;
    Comprador[] compradores;
    public Traspaso() {
        super();
    }

    public String getIdTipoTraspaso() {
        return idTipoTraspaso;
    }

    public void setIdTipoTraspaso(String idTipoTraspaso) {
        this.idTipoTraspaso = idTipoTraspaso;
    }


    public Vendedor[] getVendedores() {
        return vendedores;
    }

    public void setVendedores(Vendedor[] vendedores) {
        this.vendedores = vendedores;
    }

    public Comprador[] getCompradores() {
        return compradores;
    }

    public void setCompradores(Comprador[] compradores) {
        this.compradores = compradores;
    }
}
