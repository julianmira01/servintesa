package servicios.accesorias;





import java.util.List;

import javax.jws.Oneway;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

import modelo.datos.objetos.accesorias.Ciudad;
import modelo.datos.objetos.accesorias.Departamento;
import modelo.datos.objetos.accesorias.Direccion;
import modelo.datos.objetos.accesorias.Documento;
import modelo.datos.objetos.accesorias.GrupoSanguineo;
import modelo.datos.objetos.accesorias.Pais;
import modelo.datos.objetos.accesorias.Sexo;
import modelo.datos.objetos.accesorias.TipoDireccion;

import modelo.logica.accesorias.GestionServiciosAccesoriasLocal;

import utilidades.Funciones;


@WebService
public class ServiciosAccesoriasConduccion{
    
  GestionServiciosAccesoriasLocal gestionServiciosAccesoriasLocal; 
    
    public ServiciosAccesoriasConduccion() {
        super();
        crearObjetos();
    }


    @WebMethod
    public void crearObjetos(){
     gestionServiciosAccesoriasLocal=new GestionServiciosAccesoriasLocal(); 
  }


    @WebMethod
    public List getCiudades() throws Exception {
    try{  return   gestionServiciosAccesoriasLocal.getCiudades();}catch(Exception e){throw new Exception(e.getMessage());}  
    
  }

    @WebMethod
    public List getCiudadesDepto(Ciudad ciudad) throws Exception {
  try{  return   gestionServiciosAccesoriasLocal.getCiudades(ciudad);}catch(Exception e){throw new Exception(e.getMessage());} 
  
  }

    @WebMethod
    public List getPaises(Pais pais) throws Exception {
      try{  return  gestionServiciosAccesoriasLocal.getPaises(pais);}catch(Exception e){throw new Exception(e.getMessage());} 
  }

    @WebMethod
    public List getDepartamentos(@WebParam(name = "arg0")
        Departamento departamento) throws Exception {
     try{  return  gestionServiciosAccesoriasLocal.getDepartamentos(departamento);}catch(Exception e){throw new Exception(e.getMessage());} 
  }

    @WebMethod
    public List getGruposSanguineos(@WebParam(name = "arg0")
        GrupoSanguineo grupoSanguineo) throws Exception {
     try{  return  gestionServiciosAccesoriasLocal.getGruposSanguineos(grupoSanguineo);}catch(Exception e){throw new Exception(e.getMessage());} 
  }


    @WebMethod
    public List getDocumentos() throws Exception {
   try{  return  gestionServiciosAccesoriasLocal.getDocumentos();}catch(Exception e){throw new Exception(e.getMessage());} 
  }


    @WebMethod
    public List getTipoDocumentos(@WebParam(name = "arg0")
        Documento documento) throws Exception {
        System.out.println("tipos documento");
  try{  return  gestionServiciosAccesoriasLocal.getDocumentos();}catch(Exception e){throw new Exception(e.getMessage());} 
  }

    @WebMethod
    public List getSexos(@WebParam(name = "arg0")
        Sexo sexo) throws Exception {
     try{  return   gestionServiciosAccesoriasLocal.getSexos(sexo);}catch(Exception e){throw new Exception(e.getMessage());} 
  }

    @WebMethod
    public List getDirecciones(@WebParam(name = "arg0")
        Direccion direccion) throws Exception {
      try{  return  gestionServiciosAccesoriasLocal.getDirecciones(direccion);}catch(Exception e){throw new Exception(e.getMessage());} 
  }

    @WebMethod
    public List getTipoDireccion(@WebParam(name = "arg0")
        TipoDireccion tipoDireccion) throws Exception {
      try{  return  gestionServiciosAccesoriasLocal.getTipoDireccion(tipoDireccion);}catch(Exception e){throw new Exception(e.getMessage());} 
  }

    @WebMethod
    public void crearObjetosSDO() throws RuntimeException {
        crearObjetos(); 
    }
    
    public String getFechaHora(String formato) throws RuntimeException {
      return  Funciones.getFechaSistema2(formato,null);
    }
}
