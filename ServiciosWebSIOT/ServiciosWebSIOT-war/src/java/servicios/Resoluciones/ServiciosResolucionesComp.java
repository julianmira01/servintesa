/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios.Resoluciones;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import modelo.conexion.Conexion;
import modelo.datos.dao.resoluciones.ResolucionesComparendoCompDao;
import modelo.datos.objetos.resoluciones.ResolucionesComparendoComp;

/**
 *
 * @author daniel
 */
@WebService(serviceName = "ServiciosResolucionesComp")
public class ServiciosResolucionesComp {

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "hello")
    public String crearResolucion(@WebParam(name = "ResolucionIn") ResolucionesComparendoComp resolucionIn) {
        try{
            ResolucionesComparendoCompDao daoResoluciones = new ResolucionesComparendoCompDao();
            Conexion conn = new Conexion();
            java.sql.Connection con = conn.conectarComparendos();
            daoResoluciones.create(con, resolucionIn);
        }catch(Exception Exce){Exce.printStackTrace();}
        return "Hello ";
    }
}
