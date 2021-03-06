package modelo.datos.objetos.logs;

import java.io.*;
import java.sql.*;
import java.util.*;
import java.math.*;

 /**
  * LOGS Value Object.
  * This class is value object representing database table LOGS
  * This class is intented to be used together with associated Dao object.
  */

 /**
  * This sourcecode has been generated by FREE DaoGen generator version 2.4.1.
  * The usage of generated code is restricted to OpenSource software projects
  * only. DaoGen is available in http://titaniclinux.net/daogen/
  * It has been programmed by Tuomo Lukka, Tuomo.Lukka@iki.fi
  *
  * DaoGen license: The following DaoGen generated source code is licensed
  * under the terms of GNU GPL license. The full text for license is available
  * in GNU project's pages: http://www.gnu.org/copyleft/gpl.html
  *
  * If you wish to use the DaoGen generator to produce code for closed-source
  * commercial applications, you must pay the lisence fee. The price is
  * 5 USD or 5 Eur for each database table, you are generating code for.
  * (That includes unlimited amount of iterations with all supported languages
  * for each database table you are paying for.) Send mail to
  * "Tuomo.Lukka@iki.fi" for more information. Thank you!
  */



public class LOGS implements Cloneable, Serializable {

    /** 
     * Persistent Instance variables. This data is directly 
     * mapped to the columns of database table.
     */
    private int ID_LOGS;
    private String MODULO;
    private int ID_USUARIO;
    private String TIPO_TRANSACCION;
    private String ESTADO_ANTERIOR;
    private String ESTADO_FINAL;
    private String FECHA_HORA;
    private int TIEMPO_EJECUCION;
    private String OBJETO;
    private String TIPO_SERVICIO;



    /** 
     * Constructors. DaoGen generates two constructors by default.
     * The first one takes no arguments and provides the most simple
     * way to create object instance. The another one takes one
     * argument, which is the primary key of the corresponding table.
     */

    public LOGS () {

    }

    public LOGS (int ID_LOGSIn) {

          this.ID_LOGS = ID_LOGSIn;

    }


    /** 
     * Get- and Set-methods for persistent variables. The default
     * behaviour does not make any checks against malformed data,
     * so these might require some manual additions.
     */

    public int getID_LOGS() {
          return this.ID_LOGS;
    }
    public void setID_LOGS(int ID_LOGSIn) {
          this.ID_LOGS = ID_LOGSIn;
    }

    public String getMODULO() {
          return this.MODULO;
    }
    public void setMODULO(String MODULOIn) {
          this.MODULO = MODULOIn;
    }

    public int getID_USUARIO() {
          return this.ID_USUARIO;
    }
    public void setID_USUARIO(int ID_USUARIOIn) {
          this.ID_USUARIO = ID_USUARIOIn;
    }

    public String getTIPO_TRANSACCION() {
          return this.TIPO_TRANSACCION;
    }
    public void setTIPO_TRANSACCION(String TIPO_TRANSACCIONIn) {
          this.TIPO_TRANSACCION = TIPO_TRANSACCIONIn;
    }

    public String getESTADO_ANTERIOR() {
          return this.ESTADO_ANTERIOR;
    }
    public void setESTADO_ANTERIOR(String ESTADO_ANTERIORIn) {
          this.ESTADO_ANTERIOR = ESTADO_ANTERIORIn;
    }

    public String getESTADO_FINAL() {
          return this.ESTADO_FINAL;
    }
    public void setESTADO_FINAL(String ESTADO_FINALIn) {
          this.ESTADO_FINAL = ESTADO_FINALIn;
    }

    public String getFECHA_HORA() {
          return this.FECHA_HORA;
    }
    public void setFECHA_HORA(String FECHA_HORAIn) {
          this.FECHA_HORA = FECHA_HORAIn;
    }

    public int getTIEMPO_EJECUCION() {
          return this.TIEMPO_EJECUCION;
    }
    public void setTIEMPO_EJECUCION(int TIEMPO_EJECUCIONIn) {
          this.TIEMPO_EJECUCION = TIEMPO_EJECUCIONIn;
    }

    public String getOBJETO() {
          return this.OBJETO;
    }
    public void setOBJETO(String OBJETOIn) {
          this.OBJETO = OBJETOIn;
    }



    /** 
     * setAll allows to set all persistent variables in one method call.
     * This is useful, when all data is available and it is needed to 
     * set the initial state of this object. Note that this method will
     * directly modify instance variales, without going trough the 
     * individual set-methods.
     */

    public void setAll(int ID_LOGSIn,
          String MODULOIn,
          int ID_USUARIOIn,
          String TIPO_TRANSACCIONIn,
          String ESTADO_ANTERIORIn,
          String ESTADO_FINALIn,
          String FECHA_HORAIn,
          int TIEMPO_EJECUCIONIn,
          String OBJETOIn) {
          this.ID_LOGS = ID_LOGSIn;
          this.MODULO = MODULOIn;
          this.ID_USUARIO = ID_USUARIOIn;
          this.TIPO_TRANSACCION = TIPO_TRANSACCIONIn;
          this.ESTADO_ANTERIOR = ESTADO_ANTERIORIn;
          this.ESTADO_FINAL = ESTADO_FINALIn;
          this.FECHA_HORA = FECHA_HORAIn;
          this.TIEMPO_EJECUCION = TIEMPO_EJECUCIONIn;
          this.OBJETO = OBJETOIn;
    }


    /** 
     * hasEqualMapping-method will compare two LOGS instances
     * and return true if they contain same values in all persistent instance 
     * variables. If hasEqualMapping returns true, it does not mean the objects
     * are the same instance. However it does mean that in that moment, they 
     * are mapped to the same row in database.
     */
    public boolean hasEqualMapping(LOGS valueObject) {

          if (valueObject.getID_LOGS() != this.ID_LOGS) {
                    return(false);
          }
          if (this.MODULO == null) {
                    if (valueObject.getMODULO() != null)
                           return(false);
          } else if (!this.MODULO.equals(valueObject.getMODULO())) {
                    return(false);
          }
          if (valueObject.getID_USUARIO() != this.ID_USUARIO) {
                    return(false);
          }
          if (this.TIPO_TRANSACCION == null) {
                    if (valueObject.getTIPO_TRANSACCION() != null)
                           return(false);
          } else if (!this.TIPO_TRANSACCION.equals(valueObject.getTIPO_TRANSACCION())) {
                    return(false);
          }
          if (this.ESTADO_ANTERIOR == null) {
                    if (valueObject.getESTADO_ANTERIOR() != null)
                           return(false);
          } else if (!this.ESTADO_ANTERIOR.equals(valueObject.getESTADO_ANTERIOR())) {
                    return(false);
          }
          if (this.ESTADO_FINAL == null) {
                    if (valueObject.getESTADO_FINAL() != null)
                           return(false);
          } else if (!this.ESTADO_FINAL.equals(valueObject.getESTADO_FINAL())) {
                    return(false);
          }
          if (this.FECHA_HORA == null) {
                    if (valueObject.getFECHA_HORA() != null)
                           return(false);
          } else if (!this.FECHA_HORA.equals(valueObject.getFECHA_HORA())) {
                    return(false);
          }
          if (valueObject.getTIEMPO_EJECUCION() != this.TIEMPO_EJECUCION) {
                    return(false);
          }
          if (this.OBJETO == null) {
                    if (valueObject.getOBJETO() != null)
                           return(false);
          } else if (!this.OBJETO.equals(valueObject.getOBJETO())) {
                    return(false);
          }

          return true;
    }



    /**
     * toString will return String object representing the state of this 
     * valueObject. This is useful during application development, and 
     * possibly when application is writing object states in textlog.
     */
    public String toString() {
        StringBuffer out = new StringBuffer(this.getDaogenVersion());
        out.append("\nclass LOGS, mapping to table LOGS\n");
        out.append("Persistent attributes: \n"); 
        out.append("ID_LOGS = " + this.ID_LOGS + "\n"); 
        out.append("MODULO = " + this.MODULO + "\n"); 
        out.append("ID_USUARIO = " + this.ID_USUARIO + "\n"); 
        out.append("TIPO_TRANSACCION = " + this.TIPO_TRANSACCION + "\n"); 
        out.append("ESTADO_ANTERIOR = " + this.ESTADO_ANTERIOR + "\n"); 
        out.append("ESTADO_FINAL = " + this.ESTADO_FINAL + "\n"); 
        out.append("FECHA_HORA = " + this.FECHA_HORA + "\n"); 
        out.append("TIEMPO_EJECUCION = " + this.TIEMPO_EJECUCION + "\n"); 
        out.append("OBJETO = " + this.OBJETO + "\n"); 
        return out.toString();
    }


    /**
     * Clone will return identical deep copy of this valueObject.
     * Note, that this method is different than the clone() which
     * is defined in java.lang.Object. Here, the retuned cloned object
     * will also have all its attributes cloned.
     */
    public Object clone() {
        LOGS cloned = new LOGS();

        cloned.setID_LOGS(this.ID_LOGS); 
        if (this.MODULO != null)
             cloned.setMODULO(new String(this.MODULO)); 
        cloned.setID_USUARIO(this.ID_USUARIO); 
        if (this.TIPO_TRANSACCION != null)
             cloned.setTIPO_TRANSACCION(new String(this.TIPO_TRANSACCION)); 
        if (this.ESTADO_ANTERIOR != null)
             cloned.setESTADO_ANTERIOR(new String(this.ESTADO_ANTERIOR)); 
        if (this.ESTADO_FINAL != null)
             cloned.setESTADO_FINAL(new String(this.ESTADO_FINAL)); 
        if (this.FECHA_HORA != null)
             cloned.setFECHA_HORA((String)this.FECHA_HORA); 
        cloned.setTIEMPO_EJECUCION(this.TIEMPO_EJECUCION); 
        if (this.OBJETO != null)
             cloned.setOBJETO(new String(this.OBJETO)); 
        return cloned;
    }



    /** 
     * getDaogenVersion will return information about
     * generator which created these sources.
     */
    public String getDaogenVersion() {
        return "DaoGen version 2.4.1";
    }

    public String getTIPO_SERVICIO() {
        return TIPO_SERVICIO;
    }

    public void setTIPO_SERVICIO(String TIPO_SERVICIO) {
        this.TIPO_SERVICIO = TIPO_SERVICIO;
    }
}
