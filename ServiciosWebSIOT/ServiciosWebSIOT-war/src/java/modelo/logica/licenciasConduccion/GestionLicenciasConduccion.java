package modelo.logica.licenciasConduccion;

import java.sql.Connection;

import java.util.List;

import modelo.conexion.Conexion;

import modelo.datos.dao.generales.vistas.ViewDetConductoresDao;
import modelo.datos.dao.licenciasConduccion.ESTADOS_LICENCIACONDDao;
import modelo.datos.dao.licenciasConduccion.LicenciasConduccionDao;
import modelo.datos.objetos.generales.vistas.ViewDetConductores;
import modelo.datos.objetos.licenciasConduccion.ESTADOS_LICENCIACOND;
import modelo.datos.objetos.licenciasConduccion.LicenciasConduccion;

import utilidades.Funciones;


public class GestionLicenciasConduccion {
    Conexion conexion;
    Connection conn;
    String myMotor;

    public GestionLicenciasConduccion() {
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

    }

    public int crearLicenciaConduccion(LicenciasConduccion licencia) {
        LicenciasConduccionDao myDao = new LicenciasConduccionDao();
        int id = -1;
        try {
            conn = conexion.conectar();
            id = Funciones.obtenerId(conn, "GEN_ID_LICENCIAC", "GEN_ID_LICENCIAC", myMotor);
            System.out.println("idlic:  " + id);
            licencia.setID_LICENCIAC(String.valueOf(id));
            myDao.create(conn, licencia);
        } catch (Exception e) {
            e.printStackTrace();
            id = -1;
        } finally {
            conexion.cerrarCx();
            myDao = null;
        }
        return id;
    }

    public int crearEstadoLicenciaCond(ESTADOS_LICENCIACOND estadoLicencia) {
            ESTADOS_LICENCIACONDDao myDao = new ESTADOS_LICENCIACONDDao();
            int id = -1;
            try {
                conn = conexion.conectar();
                id = Funciones.obtenerId(conn, "GEN_ID_ESTADOS_LICENCIASCOND", "GEN_ID_ESTADOS_LICENCIASCOND", myMotor);
                System.out.println("idlic:  " + id);
                estadoLicencia.setID_ESTADOS_LICENCIACOND(Integer.valueOf(id));
                myDao.create(conn, estadoLicencia);
            } catch (Exception e) {
                e.printStackTrace();
                id = -1;
            } finally {
                conexion.cerrarCx();
                myDao = null;
            }
            return id;
        }

    public boolean modificarLicenciaConduccion(LicenciasConduccion licencia) {
        boolean resultado;
        resultado = false;
        LicenciasConduccionDao myDao = new LicenciasConduccionDao();
        int id = 0;
        try {
            conn = conexion.conectar();
            myDao.save(conn, licencia);
            resultado = true;
        } catch (Exception e) {
            e.printStackTrace();
            resultado = false;
        } finally {
            conexion.cerrarCx();
            myDao = null;
        }
        return resultado;
    }

    public LicenciasConduccion getLicenciaConduccion(LicenciasConduccion licencia) {
        List lista = null;
        LicenciasConduccionDao myDao = new LicenciasConduccionDao();
        try {
            conn = conexion.conectar();
            lista = myDao.searchMatching(conn, licencia);
            if (lista != null && lista.size() > 0) {
                licencia = (LicenciasConduccion)lista.get(0);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
            myDao = null;
        }
        return licencia;
    }

    public List getLicenciasConduccion(LicenciasConduccion licencia) {
        List lista = null;
        LicenciasConduccionDao myDao = new LicenciasConduccionDao();
        try {
            conn = conexion.conectar();
            lista = myDao.searchMatching(conn, licencia);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
            myDao = null;
        }
        return lista;
    }
    
    public List getEstadosLicencias(ESTADOS_LICENCIACOND estadosLicencias) {
            List lista = null;
            ESTADOS_LICENCIACONDDao myDao = new ESTADOS_LICENCIACONDDao();
            try {
                conn = conexion.conectar();
                lista = myDao.searchMatching(conn, estadosLicencias);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                conexion.cerrarCx();
                myDao = null;
            }
            return lista;
        }

    public boolean eliminarLicenciaConduccion(LicenciasConduccion licencia) {
        boolean resultado;
        resultado = false;
        LicenciasConduccionDao myDao = new LicenciasConduccionDao();
        int id = 0;
        try {
            conn = conexion.conectar();
            myDao.delete(conn, licencia);
            resultado = true;
        } catch (Exception e) {
            e.printStackTrace();
            resultado = false;
        } finally {
            conexion.cerrarCx();
            myDao = null;
        }
        return resultado;
    }

    public List getDetalleFacCond(ViewDetConductores detalleConductores) {
        List lista = null;
        ViewDetConductoresDao myDao = new ViewDetConductoresDao();
        int id = 0;
        try {
            conn = conexion.conectar();
            lista = myDao.searchMatching(conn, detalleConductores);

        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            conexion.cerrarCx();
            myDao = null;
        }
        return lista;
    }

}
