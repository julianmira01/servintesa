package servicios.transportepublico;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import modelo.datos.objetos.accesorias.CategoriaLicTransito;
import modelo.datos.objetos.transportepublico.tramites.NuevaPersonaTrans;
import modelo.datos.objetos.transportepublico.tramites.NumConceptosFavorablesTrans;
import modelo.datos.objetos.transportepublico.tramites.TNuevosVehiculosTrans;
import modelo.datos.objetos.transportepublico.tramites.TarjetaOperacion;
import modelo.datos.objetos.transportepublico.tramites.TtResolucionesTrans;


import modelo.logica.transportepublico.GestionServiciosTramitesTrans;


@WebService
public class ServiciosTramitesTrans {
    
    GestionServiciosTramitesTrans gestionServiciosTramitesTrans;
    
    public ServiciosTramitesTrans() {
        super();
        crearObjetos();
    }

    @WebMethod(exclude = true)    public void crearObjetos()
    {
        gestionServiciosTramitesTrans=new GestionServiciosTramitesTrans();
    }

    @WebMethod
    public int getMaxConcepto() 
    {
        return gestionServiciosTramitesTrans.getMaxConcepto();
    }

    @WebMethod
    public List getSNumConceptosFavorablesTrans(@WebParam(name = "arg0")        NumConceptosFavorablesTrans numconceptosfavorables)    {
        return gestionServiciosTramitesTrans.getSNumConceptosFavorablesTrans(numconceptosfavorables);
    }

    @WebMethod
    public int crearTNuevosVehiculosTrans(TNuevosVehiculosTrans tnuevovhiculotrans)
    {
        return gestionServiciosTramitesTrans.crearTNuevosVehiculosTrans(tnuevovhiculotrans);
    }

    @WebMethod
    public boolean  editarNumConceptosFavorablesTrans(@WebParam(name = "arg0")        NumConceptosFavorablesTrans numconceptofavorable)    {
        return gestionServiciosTramitesTrans.editarNumConceptosFavorablesTrans(numconceptofavorable);
    }
    @WebMethod
    public boolean crearNumConceptosFavorablesTrans(@WebParam(name = "arg0")        NumConceptosFavorablesTrans numconceptofavorable)    {
        return gestionServiciosTramitesTrans.crearNumConceptosFavorablesTrans(numconceptofavorable);      
    }
    @WebMethod
    public List getTTtResolucionesTrans() 
    {
        return gestionServiciosTramitesTrans.getTTtResolucionesTrans();
    }
    
    @WebMethod
    public TtResolucionesTrans getTtResolucionesTransPorId(@WebParam(name = "arg0")        TtResolucionesTrans ttresoluciones)     {
        return gestionServiciosTramitesTrans.getTtResolucionesTransPorId(ttresoluciones);
    }
    
    @WebMethod    public List getSTtResolucionesTrans(TtResolucionesTrans ttresoluciones)
    {
        return gestionServiciosTramitesTrans.getSTtResolucionesTrans(ttresoluciones);   
    }
    
    @WebMethod
    public int crearTtResolucionesTrans(TtResolucionesTrans ttresoluciones)
    {
        return gestionServiciosTramitesTrans.crearTtResolucionesTrans(ttresoluciones);
    }
    
    @WebMethod(exclude = true)    public boolean editarTtResolucionesTrans(TtResolucionesTrans ttresoluciones)
    {
        return gestionServiciosTramitesTrans.editarTtResolucionesTrans(ttresoluciones);
    }
    
    @WebMethod
    public int crearNuevaPersonaTrans(NuevaPersonaTrans nuevapersona)
    {
        return gestionServiciosTramitesTrans.crearNuevaPersonaTrans(nuevapersona);
    }
    
    @WebMethod
    public TarjetaOperacion crearTarjetaOperacion(TarjetaOperacion tarjetaOperacion){
        return gestionServiciosTramitesTrans.crearTarjetaOperacion(tarjetaOperacion);
    }
    
    @WebMethod
    public boolean modificarTarjetaOperacion(TarjetaOperacion tarjetaOperacion){
        return gestionServiciosTramitesTrans.modificarTarjetaOperacion(tarjetaOperacion);
    }
    
    @WebMethod
    public List ListarCategoriasLicTransito(){
        return gestionServiciosTramitesTrans.getCategoriaLicTrans();
    }
    
    @WebMethod
    public List buscarCategoriasLicTransito(CategoriaLicTransito myCategoria){
        return gestionServiciosTramitesTrans.getCategoriaLicTrans(myCategoria);
    }
    
    @WebMethod
    public List buscarTarjetaOperacion(TarjetaOperacion tarjetaOperacion){
        return gestionServiciosTramitesTrans.getTarjetaOperacion(tarjetaOperacion);
    }
    
    
}
