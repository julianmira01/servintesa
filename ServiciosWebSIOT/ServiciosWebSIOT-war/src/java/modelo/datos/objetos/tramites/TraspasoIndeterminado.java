package modelo.datos.objetos.tramites;

public class TraspasoIndeterminado {
    String idTipoTraspaso;
    Vendedor[] vendedores;
    Comprador[] compradores;
    String idMunicipio;
    String nombreJuzgado;
    String tipoDocumentoTraspaso;
    public TraspasoIndeterminado() {
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

    public String getIdMunicipio() {
        return idMunicipio;
    }

    public void setIdMunicipio(String idMunicipio) {
        this.idMunicipio = idMunicipio;
    }

    public String getNombreJuzgado() {
        return nombreJuzgado;
    }

    public void setNombreJuzgado(String nombreJuzgado) {
        this.nombreJuzgado = nombreJuzgado;
    }

    public String getTipoDocumentoTraspaso() {
        return tipoDocumentoTraspaso;
    }

    public void setTipoDocumentoTraspaso(String tipoDocumentoTraspaso) {
        this.tipoDocumentoTraspaso = tipoDocumentoTraspaso;
    }
}
