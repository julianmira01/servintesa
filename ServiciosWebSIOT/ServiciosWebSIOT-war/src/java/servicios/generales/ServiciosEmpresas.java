package servicios.generales;


import java.util.List;

import javax.jws.Oneway;
import javax.jws.WebMethod;
import javax.jws.WebService;

import modelo.datos.objetos.generales.Empresa;

import modelo.logica.generales.GestionServiciosEmpresasLocal;


@WebService
public class ServiciosEmpresas {
    
    GestionServiciosEmpresasLocal gestionServiciosEmpresasLocal;
    
    public ServiciosEmpresas() {
        super();
        crearObjetos();
    }

    @Oneway
    @WebMethod
    public void crearObjetos(){
      gestionServiciosEmpresasLocal=new GestionServiciosEmpresasLocal();      
  }

    @WebMethod
    public List getEmpresa(Empresa empresa){
      return gestionServiciosEmpresasLocal.getEmpresa(empresa);
  }

    @WebMethod
    public Empresa crearEmpresa(Empresa empresa){
      return gestionServiciosEmpresasLocal.crearEmpresa(empresa);
  }

    @WebMethod
    public Empresa actualizarEmpresa(Empresa empresa){
      return gestionServiciosEmpresasLocal.actualizarEmpresa(empresa);
    }
    
    @WebMethod
    public boolean validarExistenciaEmpresa(Empresa empresa){
      return gestionServiciosEmpresasLocal.validarExistenciaEmpresa(empresa);
    }

    @WebMethod
    public boolean validarExistenciaEmpresaLlavePrimiaria(Empresa empresa){
      return gestionServiciosEmpresasLocal.validarExistenciaEmpresaLlavePrimiaria(empresa);
    }

    @WebMethod
    public List getLoadAllEmpresas(Empresa empresa){
      return gestionServiciosEmpresasLocal.loadAllEmpresa(empresa);
    }
}
