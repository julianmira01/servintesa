package servicios.documentos;

import java.sql.ResultSet;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

import modelo.datos.objetos.documentos.Plantilla;
import modelo.datos.objetos.documentos.SqlPlantilla;
import modelo.datos.objetos.documentos.digitales.ElementoDigital;
import modelo.datos.objetos.documentos.digitales.ElementoTipoDocumento;
import modelo.datos.objetos.documentos.digitales.TipoDocumento;
import modelo.datos.objetos.documentos.digitales.ViewElementoIndices;
import modelo.datos.objetos.resoluciones.ResolucionInfraccionesComp;
import modelo.datos.objetos.resoluciones.ResolucionesComparendoComp;
import modelo.datos.objetos.resoluciones.TipoResolucionComp;
import modelo.datos.objetos.resoluciones.ViewResolucionesInfractorComp;

import modelo.logica.documentos.GestionServiciosDocumentos;

import modelo.datos.objetos.resoluciones.Viewnumerosresolucion;
import modelo.datos.objetos.resoluciones.Vigencias;
import modelo.datos.objetos.resoluciones.Numerosresoluciondisp;

import utilidades.Seguridad;


@WebService
public class ServiciosDocumentos {
    private GestionServiciosDocumentos gestionServicio;    
    
    public ServiciosDocumentos() {
        super();
        gestionServicio = new GestionServiciosDocumentos();
    }
       
    public int obtenerNumeroResolucion(int numero)
    {
        return gestionServicio.obtenerNumResolucion(numero,0);
    }
    
    public int obtenerNumeroResolucionComp(int numero)
    {
        return gestionServicio.obtenerNumResolucion(numero,1);
    }
    
    public List ListarTipoResolucion()
    {
        return gestionServicio.getTipoResolucion(0);
    }
    
    public List ListarTipoResolucionComp()
    {
        return gestionServicio.getTipoResolucion(1);
    }
    
    public TipoResolucionComp insertarTipoResolucion(TipoResolucionComp myTipoResol)
    {
        return gestionServicio.insertarTipoResolucion(myTipoResol,0);
    }
    
    public TipoResolucionComp insertarTipoResolucionComp(TipoResolucionComp myTipoResol)
    {
        return gestionServicio.insertarTipoResolucion(myTipoResol,1);
    }
    
    public void visualizarTexto(String myTexto)
    {
        System.out.println(myTexto);
    }
    
    public List verificarConsulta(String query)
    {
        return gestionServicio.executeQuery(query,0);
    }
    
    public List consultarCampos(String query)
    {
        return gestionServicio.executeQuery(query,0);
    }
    
    public Object[][] executeQueryComp(String query)
    {
      return gestionServicio.executeQueryComp(query);
    }
  
    public List ListarPlantillas()
    {
        return gestionServicio.getPlantillas(0);
    }
    
    public List ListarPlantillasComp()
    {
        return gestionServicio.getPlantillas(1);
    }
    
    public List buscarPlantillas(Plantilla myPlantilla)
    {
        return gestionServicio.getPlantillas(myPlantilla,0);
    }
    
    public List buscarPlantillasComp(Plantilla myPlantilla)
    {
        return gestionServicio.getPlantillas(myPlantilla,1);
    }
    
    public List buscarTipoResolucion(TipoResolucionComp myTipoRes, int base)
    {
        return gestionServicio.getTipoResolucion(myTipoRes,base);
    }
    
    public List buscarTipoResolucionComp(TipoResolucionComp myTipoRes)
    {
        return gestionServicio.getTipoResolucion(myTipoRes,1);
    }
    
    public List buscarSqlPlantillas(SqlPlantilla mySqlPlantilla)
    {
        return gestionServicio.getSqlPlantillas(mySqlPlantilla,0);
    }
    
    public List buscarSqlPlantillasComp(SqlPlantilla mySqlPlantilla)
    {
        return gestionServicio.getSqlPlantillas(mySqlPlantilla,1);
    }
    
    public Plantilla  insertarPlantilla(Plantilla myPlantilla)
    {
        return gestionServicio.insertarPlantilla(myPlantilla,0);
    }
    
    public Plantilla  insertarPlantillaComp(Plantilla myPlantilla)
    {
        return gestionServicio.insertarPlantilla(myPlantilla,1);
    }
    
    public boolean  eliminarPlantilla(Plantilla myPlantilla)
    {
        return gestionServicio.eliminarPlantilla(myPlantilla,0);
    }
    
    public boolean  eliminarPlantillaComp(Plantilla myPlantilla)
    {
        return gestionServicio.eliminarPlantilla(myPlantilla,1);
    }
    
    
    public Plantilla  actualizarPlantilla(Plantilla myPlantilla)
    {
        return gestionServicio.actualizarPlantilla(myPlantilla,0);
    }
    
    public Plantilla  actualizarPlantillaComp(Plantilla myPlantilla)
    {
        return gestionServicio.actualizarPlantilla(myPlantilla,1);
    }
    
    public Plantilla procesarPlantilla(Plantilla myPlantilla, List myFiltros)
    {
        return gestionServicio.procesarPlantilla(myPlantilla,myFiltros,0);
    }
    
    public Plantilla procesarPlantillaComp(Plantilla myPlantilla, List myFiltros)
    {
        return gestionServicio.procesarPlantilla(myPlantilla,myFiltros,1);
    }
    
    public Plantilla procesarPlantillaValores(Plantilla myPlant, List valores) 
    {
        return gestionServicio.procesarPlantillaValores(myPlant, valores);
    }
    
    public SqlPlantilla  insertarSqlPlantilla(SqlPlantilla mySqlPlantilla)
    {
        return gestionServicio.insertarSqlPlantilla(mySqlPlantilla,0);
    }
    
    public SqlPlantilla  insertarSqlPlantillaComp(SqlPlantilla mySqlPlantilla)
    {
        return gestionServicio.insertarSqlPlantilla(mySqlPlantilla,1);
    }
    
    public SqlPlantilla  actualizarSqlPlantilla(SqlPlantilla mySqlPlantilla)
    {
        return gestionServicio.actualizarSqlPlantilla(mySqlPlantilla,0);
    }
    
    public SqlPlantilla  actualizarSqlPlantillaComp(SqlPlantilla mySqlPlantilla)
    {
        return gestionServicio.actualizarSqlPlantilla(mySqlPlantilla,1);
    }
    
    public boolean  eliminarSqlPlantilla(SqlPlantilla mySqlPlantilla)
    {
        return gestionServicio.eliminarSqlPlantilla(mySqlPlantilla,0);
    }
    
    public boolean  eliminarSqlPlantillaComp(SqlPlantilla mySqlPlantilla)
    {
        return gestionServicio.eliminarSqlPlantilla(mySqlPlantilla,1);
    }
    
    public List executeQuery(String query){
      return gestionServicio.executeQuery(query,1);
    }
    
    public List executeQueryVehiculos(String query){
      return gestionServicio.executeQuery(query,0);
    }
    
    public Object[][] executeQueryPrincipal(String query) {
      return gestionServicio.executeQueryPrincipal(query);
    }
    
    public void subirArchivo(byte[] myArchivo,String nombre){
      gestionServicio.subirArchivo(myArchivo, nombre);
    }
    
    public byte[] bajarArchivo(String nombre){
      return gestionServicio.obtenerArchivo(nombre);
    }
    
    public void  probarDoc()
    {
        gestionServicio.pruebaDocumento();
    }
    
    public List getTElementoDigital(ElementoDigital elementodigital) 
    {
        return gestionServicio.getTElementoDigital(elementodigital);
    }

    public List getSViewElementoIndices(ViewElementoIndices viewelementoindices)
    {
        return gestionServicio.getSViewElementoIndices(viewelementoindices);
    }
    
    public List getTTipoDocumento(TipoDocumento tipodocumento) 
    {
        return gestionServicio.getTTipoDocumento(tipodocumento);
    }
    
    public boolean crearElementoTipoDocumento(ElementoTipoDocumento elementotipodocumento)
    {
        return gestionServicio.crearElementoTipoDocumento(elementotipodocumento);
    }
 
    public List getSElementoTipoDocument(ElementoTipoDocumento elementotipodocumento)
    {
        return gestionServicio.getSElementoTipoDocument(elementotipodocumento);
    }
    
    public boolean validarNumeroResolucion(String Numero)
    {
        return gestionServicio.validarNumeroResolucion(Numero,0);
    }
    
    public boolean validarNumeroResolucionComp(String Numero)
    {
        return gestionServicio.validarNumeroResolucion(Numero,1);
    }
    
    public ResolucionesComparendoComp insertarResolucionComparendo(ResolucionesComparendoComp myResComp, int idUsuario, String myIp, String myHost)
    {
        return gestionServicio.insertarResolucionComparendo(myResComp, idUsuario, myIp, myHost);
    }
    
    public ResolucionesComparendoComp buscarResolucionComparendoComp(ResolucionesComparendoComp obj) {
        return gestionServicio.buscarResolucionComparendoComp(obj); 
    }
    
    public boolean actualizarResolucionComparendo(ResolucionesComparendoComp obj) {
        return gestionServicio.actualizarResolucionComparendo(obj);
    }
    
    public ResolucionInfraccionesComp insertarResolucionInfracciones(ResolucionInfraccionesComp myResInf, int idUsuario, String myIp, String myHost)
    {
        return gestionServicio.insertarResolucionInfracciones(myResInf, idUsuario, myIp, myHost);
    }
    
    public ResolucionInfraccionesComp buscarPrimeroResolucionInfracciones(ResolucionInfraccionesComp myResInf)
    {
        return gestionServicio.buscarPrimeroResolucionInfracciones(myResInf);
    }
    
    public List obtenerResolucionInfracciones(ResolucionInfraccionesComp myResInf)
    {
        return gestionServicio.getResolucionInfracciones(myResInf);
    }
    
    public List obtenerResolucionesInfractor(ViewResolucionesInfractorComp myResInfra)
    {
        return gestionServicio.getResolucionesInfractor(myResInfra);
    }
    
    public List obtenerResolucionesInfractorFiltro(ViewResolucionesInfractorComp myResInfra, String fechaIni, String fechaFin)
    {
        return gestionServicio.getResolucionesInfractor(myResInfra, fechaIni, fechaFin);
    }
    
    public List ejecutarSqlReporte(String sql, int modulo) {
        return gestionServicio.ejecutarSqlReporte(sql,modulo);
    }
    
    
    //NUEVOS 16-ENE-2013
    //VISTA N-*-MEROS RESOLUCI-*-N
    public List buscarViewnumerosresolucion(Viewnumerosresolucion obj) {
          return gestionServicio.buscarViewnumerosresolucion(obj);
    }
    
    public List listarViewnumerosresolucion() {
      return gestionServicio.listarViewnumerosresolucion();
    }
    
    public Numerosresoluciondisp getNextNumeroResolucion(int idVigencia){
      return gestionServicio.getNextNumeroResolucion(idVigencia);
    }
    
    public Numerosresoluciondisp getNextNumeroResolucionTRANSITO(int idVigencia){
      return gestionServicio.getNextNumeroResolucionTRANSITO(idVigencia, 0);
    }
    
    //VIGENCIAS
    public Vigencias crearVigencias(Vigencias obj ) {        
          return gestionServicio.crearVigencias(obj);         
    }
    
    public boolean editarVigencias(Vigencias obj) {
          return gestionServicio.editarVigencias(obj);        
    }
    
    public Vigencias buscarPrimeroVigencias(Vigencias obj) {        
          return gestionServicio.buscarPrimeroVigencias(obj);        
    }
    
    public List buscarVigencias(Vigencias obj) {        
      return gestionServicio.buscarVigencias(obj);        
    }
    
    public List listarVigencias() {
      return gestionServicio.listarVigencias();
    }
    
    public boolean eliminarVigencias(Vigencias obj) {
          return gestionServicio.eliminarVigencias(obj);        
    }      
    
    
    //NUMEROS RESOLUCIONES
    public Numerosresoluciondisp crearNumerosresoluciondisp(Numerosresoluciondisp obj ) {
          return gestionServicio.crearNumerosresoluciondisp(obj);     
    }  
    
    public boolean editarNumerosresoluciondisp(Numerosresoluciondisp obj) {
          return gestionServicio.editarNumerosresoluciondisp(obj);    
    }
    
    public Numerosresoluciondisp buscarPrimeroNumerosresoluciondisp(Numerosresoluciondisp obj) {
      return gestionServicio.buscarPrimeroNumerosresoluciondisp(obj);   
    }
    
    public List buscarNumerosresoluciondisp(Numerosresoluciondisp obj) {
      return gestionServicio.buscarNumerosresoluciondisp(obj);    
    }
      
    public List listarNumerosresoluciondisp() {
      return gestionServicio.listarNumerosresoluciondisp();
    }
      
    public boolean eliminarNumerosresoluciondisp(Numerosresoluciondisp obj) {
      return gestionServicio.eliminarNumerosresoluciondisp(obj);    
    }
}
