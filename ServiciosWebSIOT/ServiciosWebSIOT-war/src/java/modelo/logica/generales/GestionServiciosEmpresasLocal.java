package modelo.logica.generales;

import java.sql.Connection;

import java.util.ArrayList;
import java.util.List;

import modelo.conexion.Conexion;

import modelo.datos.dao.generales.EmpresaDao;
import modelo.datos.objetos.generales.Empresa;

import utilidades.Funciones;


public class GestionServiciosEmpresasLocal {

    Conexion conexion;
    Connection conn;
    EmpresaDao empresaDao;
    String myMotor;

    public GestionServiciosEmpresasLocal() {
        super();
        crearObjetos();
    }

    public void crearObjetos() {
        conexion = new Conexion();
        empresaDao = new EmpresaDao();
        myMotor = "";
        
        try{
            myMotor = Funciones.leer_ini("/WSTransito.ini", "MOTOR");
        }catch(Exception exce){}
        if(myMotor.equals(""))
        try{
            myMotor = Funciones.leer_ini("c:\\WSTransito.ini", "MOTOR");
        }catch(Exception exce){}
    }

    public List getEmpresa(Empresa empresa) {
        List lista = null;
        try {
            conn = conexion.conectar();
            lista = (ArrayList)empresaDao.searchMatching(conn, empresa);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            conexion.cerrarCx();
        }
        return lista;
    }

    public Empresa getEmpresaPorId(Empresa empresa) {
        List lista = null;
        Empresa emp = null;
        try {
            conn = conexion.conectar();
            lista = empresaDao.searchMatching(conn, empresa);
            if (lista != null && lista.size() > 0)
                emp = (Empresa)lista.get(0);
            else
                emp.setID_EMPRESA(-1);

        } catch (Exception e) {
            System.out.println(e.getMessage());
            emp.setID_EMPRESA(-1);
        } finally {
            conexion.cerrarCx();
        }
        return emp;
    }

    public Empresa crearEmpresa(Empresa empresa) {
        List lista = null;
        int id = 0;
        try {
            conn = conexion.conectar();
            id = Funciones.obtenerId(conn, "GEN_EMPRESA", "GEN_EMPRESA", myMotor);
            empresa.setID_EMPRESA(id);
            empresaDao.create(conn, empresa);
            empresa = new Empresa();
            empresa.setID_EMPRESA(id);
            lista = empresaDao.searchMatching(conn, empresa);
            if (lista != null && lista.size() > 0) {
                empresa = (Empresa)lista.get(0);
            }
        } catch (Exception e) {
            e.printStackTrace();
            empresa.setID_EMPRESA(-1);

        } finally {
            conexion.cerrarCx();
        }
        return empresa;
    }

    public Empresa actualizarEmpresa(Empresa empresa) {
        List lista = null;
        int id = 0;
        try {
            conn = conexion.conectar();
            id = empresa.getID_EMPRESA();
            empresaDao.save(conn, empresa);
            empresa = new Empresa();
            empresa.setID_EMPRESA(id);
            lista = empresaDao.searchMatching(conn, empresa);
            if (lista != null && lista.size() > 0) {
                empresa = (Empresa)lista.get(0);
            }
        } catch (Exception e) {
            e.printStackTrace();
            empresa.setID_EMPRESA(-1);

        } finally {
            conexion.cerrarCx();
        }
        return empresa;
    }

    public boolean validarExistenciaEmpresa(Empresa empresa) {
        List lista = null;
        boolean resultado;
        try {
            conn = conexion.conectar();
            lista = (ArrayList)empresaDao.validarExistenciaEmpresa(conn, empresa);
            if (lista != null && lista.size() > 0) {
                resultado = true;
            } else {
                resultado = false;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            resultado = false;
        } finally {
            conexion.cerrarCx();
        }
        return resultado;
    }

    public boolean validarExistenciaEmpresaLlavePrimiaria(Empresa empresa) {
        List lista = null;
        boolean resultado;
        try {
            conn = conexion.conectar();
            lista = (ArrayList)empresaDao.validarExistenciaEmpresaLlavePrimiaria(conn, empresa);
            if (lista != null && lista.size() > 0) {
                resultado = true;
            } else {
                resultado = false;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            resultado = false;
        } finally {
            conexion.cerrarCx();
        }
        return resultado;
    }

    public List loadAllEmpresa(Empresa empresa) {
        List lista = null;
        try {
            conn = conexion.conectar();
            lista = (ArrayList)empresaDao.loadAll(conn);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            conexion.cerrarCx();
        }
        return lista;
    }

}
