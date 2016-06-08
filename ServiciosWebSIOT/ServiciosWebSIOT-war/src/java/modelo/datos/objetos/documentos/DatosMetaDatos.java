package modelo.datos.objetos.documentos;

public class DatosMetaDatos {
    String info;
    String meta;
    public DatosMetaDatos() {
        super();
        info="";
        meta="";
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getMeta() {
        return meta;
    }

    public void setMeta(String meta) {
        this.meta = meta;
    }
}
