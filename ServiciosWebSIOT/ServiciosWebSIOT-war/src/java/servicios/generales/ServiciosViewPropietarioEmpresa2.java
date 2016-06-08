package servicios.generales;

import javax.jws.WebService;

import modelo.datos.objetos.generales.vistas.ViewPopietarioEmpresa2;

import modelo.logica.generales.GestionServiciosViewPropietarios2;

import java.util.List;

@WebService
public class ServiciosViewPropietarioEmpresa2 {
    
    GestionServiciosViewPropietarios2 gestionServiciosViewPropietarios2;
    
    public ServiciosViewPropietarioEmpresa2() {
        super();
        gestionServiciosViewPropietarios2 = new GestionServiciosViewPropietarios2();
    }
    
    public List getViewPropietarioEmpresa2(ViewPopietarioEmpresa2 propEmpresa) {
        return gestionServiciosViewPropietarios2.getPropietarioEmpresa(propEmpresa);
    }
}
