/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.logica.radicacion;

import java.sql.Connection;
import java.util.List;
import modelo.conexion.Conexion;
import modelo.datos.dao.liquidacion.FacturaDao;
import modelo.datos.dao.radicacion.PuntosAtencionDao;
import modelo.datos.dao.radicacion.RadicadoDeVehiculosDao;
import modelo.datos.dao.radicacion.TramitesVehiculosRadicadosDao;
import modelo.datos.objetos.liquidacion.Factura;
import modelo.datos.objetos.radicacion.PuntosAtencion;
import modelo.datos.objetos.radicacion.RadicadoDeVehiculos;
import modelo.datos.objetos.radicacion.TramitesVehiculosRadicados;
import utilidades.Funciones;

/**
 *
 * @author DANIELF YEPES ORTEGA
 */
public class GestionPuntosAtencion {
    Conexion conexion;
    Connection conn;
    String myMotor;
    
    public GestionPuntosAtencion() {
        super();
        conexion = new Conexion();
        myMotor = "";
        
        try{
            myMotor = Funciones.leer_ini("/WSTransito.ini", "MOTOR");
        }catch(Exception exce){}
        if(myMotor.equals(""))
        try{
            myMotor = Funciones.leer_ini("c:\\WSTransito.ini", "MOTOR");
        }catch(Exception exce){}
        //vehiculoDao=new VehiculoDao();
        //crearObjetos();
    }
    
    public List buscarPuntosAtencion(PuntosAtencion puntoAtencion) {
        List mylista;
        mylista = null;
        try {
            conn = conexion.conectar();
            PuntosAtencionDao puntosAtencionDao = new PuntosAtencionDao();
            mylista = puntosAtencionDao.searchMatching(conn, puntoAtencion);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return mylista;
    }
    
    public boolean actualizarPuntosAtencion(PuntosAtencion puntoAtencion) {
        boolean resultado = false;

        try {
            conn = conexion.conectar();
            PuntosAtencionDao myRadicadoDao = new PuntosAtencionDao();
            myRadicadoDao.save(conn, puntoAtencion);
            resultado = true;

        } catch (Exception e) {
            e.printStackTrace();
            resultado = false;
        } finally {
            conexion.cerrarCx();
        }
        return resultado;
    }
    
    public PuntosAtencion insertarTramiteVehiculoRadicado(PuntosAtencion puntoAtencion) {
        try {
            int id;
            List lista;
            conn = conexion.conectar();
            PuntosAtencionDao puntosAtencionDao = new PuntosAtencionDao();
            id = Funciones.obtenerId(conn, "GEN_PUNTOS_ATENCION", "GEN_PUNTOS_ATENCION", myMotor);
            puntoAtencion.setID_PUNTOS_ATENCION(id);
            puntosAtencionDao.create(conn, puntoAtencion);


            lista = puntosAtencionDao.searchMatching(conn, puntoAtencion);
            if (lista != null && lista.size() > 0) {
                puntoAtencion = (PuntosAtencion)lista.get(0);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return puntoAtencion;
    }
    
    public List listarPuntosAtencion() {
        List mylista;
        mylista = null;
        try {
            conn = conexion.conectar();
            PuntosAtencionDao puntosAtencionDao = new PuntosAtencionDao();
            mylista = puntosAtencionDao.loadAll(conn);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return mylista;
    }
    
}
