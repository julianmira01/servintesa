package modelo.logica.generales;

import java.sql.Connection;

import java.util.ArrayList;
import java.util.List;

import modelo.conexion.Conexion;

import modelo.datos.dao.accesorias.DireccionDao;
import modelo.datos.dao.generales.PersonaDao;
import modelo.datos.dao.generales.SucursalDao;
import modelo.datos.objetos.accesorias.Direccion;
import modelo.datos.objetos.generales.Persona;
import modelo.datos.objetos.generales.Sucursal;

import utilidades.Archivo;
import utilidades.Funciones;


public class GestionServiciosPersonasLocal {


    Conexion conexion;
    Connection conn;

    PersonaDao personaDao;
    Archivo imagen;
    String myMotor;

    public GestionServiciosPersonasLocal() {
        super();
        crearObjetos();
    }

    public void crearObjetos() {

        conexion = new Conexion();
        personaDao = new PersonaDao();
        imagen = new Archivo();
        myMotor = "";
        
        try{
            myMotor = Funciones.leer_ini("/WSTransito.ini", "MOTOR");
        }catch(Exception exce){}
        if(myMotor.equals(""))
        try{
            myMotor = Funciones.leer_ini("c:\\WSTransito.ini", "MOTOR");
        }catch(Exception exce){}
    }

    public Persona getPersona(Persona persona, boolean runt) throws Exception {
            try{
                persona = getPersona(persona);}
                catch(Exception e){throw new Exception(e.getMessage());}
        return persona;
    }

    public Persona getPersona(Persona persona) throws Exception {
        List lista = null;
        Persona myPer = null;
        try {
            GestionServiciosSucursalesLocal gssl = new GestionServiciosSucursalesLocal();
            conn = conexion.conectar();
            lista = personaDao.searchMatching(conn, persona);
            if (lista != null && lista.size() > 0) {
                myPer = (Persona)lista.get(0);
                
                Direccion tmpDireccion = new Direccion();
                tmpDireccion.setID_PERSONA(String.valueOf(myPer.getID_PERSONAS()));
                DireccionDao direccionDao = new DireccionDao();
                List direcciones = direccionDao.searchMatching(conn, tmpDireccion);
                myPer.setDirecciones((ArrayList)direcciones);
            } else {
                myPer = new Persona();
                myPer.setID_PERSONAS(-1);
            }

        } catch (Exception e) {
            e.printStackTrace();
            myPer = new Persona();
            myPer.setID_PERSONAS(-1);
            throw new Exception(e.getMessage());
        } finally {
            conexion.cerrarCx();
        }
        return myPer;
    }


    public List getPersonas(Persona persona) throws Exception {
        List lista = null;
        try {
            conn = conexion.conectar();
            lista = personaDao.searchMatching(conn, persona);
        } catch (Exception e) {
            e.getMessage();
            throw new Exception(e.getMessage());
        } finally {
            conexion.cerrarCx();
        }
        return lista;
    }

    public List getPersonasNombres(Persona persona) throws Exception {
        List lista = null;
        try {
            conn = conexion.conectar();
            lista = personaDao.searchMatching2(conn, persona);
        } catch (Exception e) {
            e.getMessage();
            throw new Exception(e.getMessage());
        } finally {
            conexion.cerrarCx();
        }
        return lista;
    }


    public Persona crearPersona(Persona persona, boolean runt) throws Exception {
        return crearPersona(persona);
    }

    public String crearImagenes(Persona persona) {
        try {
            if(persona.getHUELLA1() != null && persona.getHUELLA2() != "" &&persona.getIDENTIFICACION() != "")
                guardarImagen("huellas", persona.getHUELLA1(), persona.getIDENTIFICACION() + "_d1");
            if(persona.getHUELLA2() != null && persona.getHUELLA2() != "" && persona.getIDENTIFICACION() != "")
                guardarImagen("huellas", persona.getHUELLA2(), persona.getIDENTIFICACION() + "_d2");
            if(persona.getFIRMA() != null && persona.getIDENTIFICACION() != "")
                guardarImagenFromByteArray("firmas", persona.getFIRMA(), persona.getIDENTIFICACION());
            if(persona.getFOTO() != null && persona.getIDENTIFICACION() != "")
                guardarImagenFromByteArray("fotos", persona.getFOTO(), persona.getIDENTIFICACION());
        } catch (Exception e) {
            return "MAL";
        }
        return "OK";

    }


    public void guardarImagen(String carpeta, String datos, String nombre) {
        imagen.parseBase64ToFile(datos, carpeta + "\\" + nombre.trim() + ".jpg");
    }
    
    public void guardarImagenFromByteArray(String carpeta, byte[] datos, String nombre) {
        imagen.crearImagenFromByteArray(datos, carpeta + "\\" + nombre.trim() + ".jpg");
    }
    
    public Persona crearPersona(Persona persona) throws Exception {
        List lista = null;
        int id = 0;
        try {
            conn = conexion.conectar();
            id = Funciones.obtenerId(conn, "GEN_PERSONAS", "GEN_PERSONAS", myMotor);
            persona.setID_PERSONAS(id);
            personaDao.create(conn, persona);
            ArrayList direcciones = persona.getDirecciones();
            persona = new Persona();
            persona.setID_PERSONAS(id);
            lista = personaDao.searchMatching(conn, persona);
            if (lista != null && lista.size() > 0) {
                persona = (Persona)lista.get(0);
                //insertar sucursales
                if (direcciones != null) {
                    conexion.cerrarCx();
                    GestionServiciosSucursalesLocal gestionSucursal = new GestionServiciosSucursalesLocal();
                    for (int i = 0; i < direcciones.size(); i++) {
                        //transformar direcion a sucursal
                        Direccion direccion = (Direccion)direcciones.get(i);
                        Sucursal sucursal = direccionToSucursal(direccion);
                        sucursal.setID_PERSONA(id);
                        gestionSucursal.crearSucursal(sucursal);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception (e.getMessage());
            

        } finally {
            conexion.cerrarCx();
        }
        return persona;
    }
    
    public boolean editarPersona(Persona persona) throws Exception {
        boolean res = false;
        try {
            conn = conexion.conectar();
            //persona.setFCH_EXPDOCUMENTO(Funciones.cambiarFormatoFecha2(persona.getFCH_EXPDOCUMENTO()));
            personaDao.save(conn, persona);
            
            //eliminar direcciones de la persona
            DireccionDao direccionDao = new DireccionDao();
            SucursalDao sucursalDao = new SucursalDao();
            Direccion direccion = new Direccion();
            //buscamos las direcciones de la persona
            direccion.setID_PERSONA(String.valueOf(persona.getID_PERSONAS()));
            List direcciones = direccionDao.searchMatching(conn, direccion);
            //recorremos las direcciones
            for (int i = 0; i < direcciones.size(); i++) {
                direccion = (Direccion)direcciones.get(i);
                Sucursal sucursal = direccionToSucursal(direccion);
                        
                sucursalDao.delete(conn, sucursal);        
                //direccionDao.delete(conn, direccion);
            }
            
            //adicionamos las nuevas direcciones
            if (persona.getDirecciones() != null) {
                int id;
                for (int i = 0; i < persona.getDirecciones().size(); i++) {
                    direccion = (Direccion)persona.getDirecciones().get(i);
                    Sucursal sucursal = direccionToSucursal(direccion);
                
                    if (sucursal.getID_SUCURSAL() <= 0) {
                        id = Funciones.obtenerId(conn, "GEN_SUCURSAL", "GEN_SUCURSAL", myMotor);
                        sucursal.setID_SUCURSAL(id);
                    }
                    sucursal.setID_PERSONA(persona.getID_PERSONAS());
                    sucursalDao.create(conn, sucursal);
                }
            }
            res = true;
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception(e.getMessage());
        } finally {
            conexion.cerrarCx();
        }
        return res;
    }

    public boolean validarExistenciaPersonaLlavePrimaria(Persona persona) {
        List lista = null;
        boolean resultado;
        try {
            conn = conexion.conectar();
            lista = personaDao.validarExistenciaPersonaLlavePrimaria(conn, persona);
            if (lista != null && lista.size() > 0) {
                persona = (Persona)lista.get(0);
                resultado = true;
            } else {
                persona.setID_PERSONAS(-1);
                resultado = false;
            }

        } catch (Exception e) {
            resultado = false;
        } finally {
            conexion.cerrarCx();
        }
        return resultado;
    }

    public boolean validarExistenciaPersona(Persona persona) {
        List lista = null;
        boolean resultado;
        try {
            conn = conexion.conectar();
            lista = personaDao.validarExistenciaPersona(conn, persona);
            if (lista != null && lista.size() > 0) {
                persona = (Persona)lista.get(0);
                resultado = true;
            } else {
                persona.setID_PERSONAS(-1);
                resultado = false;
            }

        } catch (Exception e) {
            resultado = false;
        } finally {
            conexion.cerrarCx();
        }
        return resultado;
    }

    public List loadAllPersonas(Persona persona) {
        List lista = null;
        try {
            conn = conexion.conectar();
            lista = personaDao.loadAll(conn);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            conexion.cerrarCx();
        }
        return lista;
    }

    public List getPersonasIdentificacion(Persona persona) {
        List lista = null;
        try {
            conn = conexion.conectar();
            lista = personaDao.getPersonasIdentificacion(conn, persona);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return lista;
    }

    private Sucursal direccionToSucursal(Direccion direccion) {
        Sucursal obj = new Sucursal();
        obj.setID_SUCURSAL(direccion.getID_SUCURSAL());
        if (Funciones.esEntero(direccion.getNRODIRECCION()))
            obj.setNRODIRECCION(Integer.parseInt(direccion.getNRODIRECCION()));
        obj.setDIRECCION(direccion.getDIRECCION());
        obj.setTELEFONO1(direccion.getTELEFONO1());
        obj.setTELEFONO2(direccion.getTELEFONO2());
        obj.setFAX1(direccion.getFAX1());
        obj.setFAX2(direccion.getFAX2());
        obj.setWEB(direccion.getWEB());
        if (Funciones.esEntero(direccion.getID_PERSONA()))
            obj.setID_PERSONA(Integer.parseInt(direccion.getID_PERSONA()));
        if (Funciones.esEntero(direccion.getID_EMPRESA()))
            obj.setID_EMPRESA(Integer.parseInt(direccion.getID_EMPRESA()));
        if (Funciones.esEntero(direccion.getID_CIUDAD()))
            obj.setID_CIUDAD(Integer.parseInt(direccion.getID_CIUDAD()));
        obj.setFECHARES(direccion.getFECHARES());
        obj.setEMAIL(direccion.getEMAIL());
        if (Funciones.esEntero(direccion.getIDTIPO()))
            obj.setIDTIPO(Integer.parseInt(direccion.getIDTIPO()));
        obj.setCELULAR(direccion.getCELULAR());
        obj.setCOD_TIPODIRECCION(direccion.getCOD_TIPODIRECCION());
        obj.setDIRPRINCIPAL(direccion.getDIRPRINCIPAL());
        obj.setID_PAIS(direccion.getID_PAIS());
        obj.setID_DEPARTAMENTO(direccion.getID_DEPARTAMENTO());
        return obj;
    }
    
    private Direccion sucursalToDireccion(Sucursal direccion) {
        Direccion obj = new Direccion();
        obj.setID_SUCURSAL(direccion.getID_SUCURSAL());
        obj.setNRODIRECCION(String.valueOf(direccion.getNRODIRECCION()));
        obj.setDIRECCION(direccion.getDIRECCION());
        obj.setTELEFONO1(direccion.getTELEFONO1());
        obj.setTELEFONO2(direccion.getTELEFONO2());
        obj.setFAX1(direccion.getFAX1());
        obj.setFAX2(direccion.getFAX2());
        obj.setWEB(direccion.getWEB());
        obj.setID_PERSONA(String.valueOf(direccion.getID_PERSONA()));
        obj.setID_EMPRESA(String.valueOf(direccion.getID_EMPRESA()));
        obj.setID_CIUDAD(String.valueOf(direccion.getID_CIUDAD()));
        obj.setFECHARES(direccion.getFECHARES());
        obj.setEMAIL(direccion.getEMAIL());
        obj.setIDTIPO(String.valueOf(direccion.getIDTIPO()));
        obj.setCELULAR(direccion.getCELULAR());
        obj.setCOD_TIPODIRECCION(direccion.getCOD_TIPODIRECCION());
        obj.setDIRPRINCIPAL(direccion.getDIRPRINCIPAL());
        obj.setID_PAIS(direccion.getID_PAIS());
        obj.setID_DEPARTAMENTO(direccion.getID_DEPARTAMENTO());
        return obj;
    }
    
    
}
