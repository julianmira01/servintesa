package modelo.datos.objetos.generales.propietarioDeVehiculo;

public class propietarioActualVehiculo {
    
    
    private String empper;
    private Integer id_propietario;
    private Integer id_propvehiculo;
    private Integer id_tipopropiedad;
    private Integer porcentajepropiedad;
    private String proindiviso;
    private String vender;
    private String fecha;
    private String descripcion;
    
    public propietarioActualVehiculo() {
        super();
    }


    public void setEmpper(String empper) {
        this.empper = empper;
    }

    public String getEmpper() {
        return empper;
    }

    public void setId_propietario(Integer id_propietario) {
        this.id_propietario = id_propietario;
    }

    public Integer getId_propietario() {
        return id_propietario;
    }

    public void setId_propvehiculo(Integer id_propvehiculo) {
        this.id_propvehiculo = id_propvehiculo;
    }

    public Integer getId_propvehiculo() {
        return id_propvehiculo;
    }

    public void setId_tipopropiedad(Integer id_tipopropiedad) {
        this.id_tipopropiedad = id_tipopropiedad;
    }

    public Integer getId_tipopropiedad() {
        return id_tipopropiedad;
    }

    public void setPorcentajepropiedad(Integer porcentajepropiedad) {
        this.porcentajepropiedad = porcentajepropiedad;
    }

    public Integer getPorcentajepropiedad() {
        return porcentajepropiedad;
    }

    public void setProindiviso(String proindiviso) {
        this.proindiviso = proindiviso;
    }

    public String getProindiviso() {
        return proindiviso;
    }

    public void setVender(String vender) {
        this.vender = vender;
    }

    public String getVender() {
        return vender;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getFecha() {
        return fecha;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }
}
