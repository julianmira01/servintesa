package modelo.datos.objetos.avaluos;

public class Avaluo {
    private int idVehiculo;
    private int idTipoVehiculo;
    private String tipoVehiculo;
    private int modelo;
    private int cilindraje;
    private int cod_ciudad;
    private int id_marca;
    private int id_linea;
    private int vigencia;
    private boolean blindado;
    private boolean frontera;
    private int id_carroceria;
    private int cPas;
    private double cCarga;
    private int id_clase;
    
    
    public Avaluo() {
        super();
    }

    public String getTipoVehiculo() {
        return tipoVehiculo;
    }

    public void setTipoVehiculo(String tipoVehiculo) {
        this.tipoVehiculo = tipoVehiculo;
    }

    public int getModelo() {
        return modelo;
    }

    public void setModelo(int modelo) {
        this.modelo = modelo;
    }

    public int getCilindraje() {
        return cilindraje;
    }

    public void setCilindraje(int cilindraje) {
        this.cilindraje = cilindraje;
    }

    public int getCod_ciudad() {
        return cod_ciudad;
    }

    public void setCod_ciudad(int cod_ciudad) {
        this.cod_ciudad = cod_ciudad;
    }

    public int getId_marca() {
        return id_marca;
    }

    public void setId_marca(int id_marca) {
        this.id_marca = id_marca;
    }

    public int getId_linea() {
        return id_linea;
    }

    public void setId_linea(int id_linea) {
        this.id_linea = id_linea;
    }

    public int getVigencia() {
        return vigencia;
    }

    public void setVigencia(int vigencia) {
        this.vigencia = vigencia;
    }

    public boolean isBlindado() {
        return blindado;
    }

    public void setBlindado(boolean blindado) {
        this.blindado = blindado;
    }

    public boolean isFrontera() {
        return frontera;
    }

    public void setFrontera(boolean frontera) {
        this.frontera = frontera;
    }

    public int getId_carroceria() {
        return id_carroceria;
    }

    public void setId_carroceria(int id_carroceria) {
        this.id_carroceria = id_carroceria;
    }

    public int getCPas() {
        return cPas;
    }

    public void setCPas(int cPas) {
        this.cPas = cPas;
    }

    public double getCCarga() {
        return cCarga;
    }

    public void setCCarga(double cCarga) {
        this.cCarga = cCarga;
    }

    public int getIdTipoVehiculo() {
        return idTipoVehiculo;
    }

    public void setIdTipoVehiculo(int idTipoVehiculo) {
        this.idTipoVehiculo = idTipoVehiculo;
    }

    public int getId_clase() {
        return id_clase;
    }

    public void setId_clase(int id_clase) {
        this.id_clase = id_clase;
    }

    public int getIdVehiculo() {
        return idVehiculo;
    }

    public void setIdVehiculo(int idVehiculo) {
        this.idVehiculo = idVehiculo;
    }
}
