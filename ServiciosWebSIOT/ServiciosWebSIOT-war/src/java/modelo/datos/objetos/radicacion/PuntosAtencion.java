/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.datos.objetos.radicacion;

import java.io.*;
import java.sql.*;
import java.util.*;
import java.math.*;

 /**
  * PuntosAtencion Value Object.
  * This class is value object representing database table PUNTOS_ATENCION
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



public class PuntosAtencion implements Cloneable, Serializable {

    /** 
     * Persistent Instance variables. This data is directly 
     * mapped to the columns of database table.
     */
    private int ID_PUNTOS_ATENCION;
    private String NOMBRE_PA;
    private int ID_DEPENDENCIA;
    private String HOST_LOCAL;
    private String TURNO_ACTUAL;
    private String ESTADO;



    /** 
     * Constructors. DaoGen generates two constructors by default.
     * The first one takes no arguments and provides the most simple
     * way to create object instance. The another one takes one
     * argument, which is the primary key of the corresponding table.
     */

    public PuntosAtencion () {

    }

    public PuntosAtencion (int ID_PUNTOS_ATENCIONIn) {

          this.ID_PUNTOS_ATENCION = ID_PUNTOS_ATENCIONIn;

    }


    /** 
     * Get- and Set-methods for persistent variables. The default
     * behaviour does not make any checks against malformed data,
     * so these might require some manual additions.
     */

    public int getID_PUNTOS_ATENCION() {
          return this.ID_PUNTOS_ATENCION;
    }
    public void setID_PUNTOS_ATENCION(int ID_PUNTOS_ATENCIONIn) {
          this.ID_PUNTOS_ATENCION = ID_PUNTOS_ATENCIONIn;
    }

    public String getNOMBRE_PA() {
          return this.NOMBRE_PA;
    }
    public void setNOMBRE_PA(String NOMBRE_PAIn) {
          this.NOMBRE_PA = NOMBRE_PAIn;
    }

    public int getID_DEPENDENCIA() {
          return this.ID_DEPENDENCIA;
    }
    public void setID_DEPENDENCIA(int ID_DEPENDENCIAIn) {
          this.ID_DEPENDENCIA = ID_DEPENDENCIAIn;
    }

    public String getHOST_LOCAL() {
          return this.HOST_LOCAL;
    }
    public void setHOST_LOCAL(String HOST_LOCALIn) {
          this.HOST_LOCAL = HOST_LOCALIn;
    }



    /** 
     * setAll allows to set all persistent variables in one method call.
     * This is useful, when all data is available and it is needed to 
     * set the initial state of this object. Note that this method will
     * directly modify instance variales, without going trough the 
     * individual set-methods.
     */

    public void setAll(int ID_PUNTOS_ATENCIONIn,
          String NOMBRE_PAIn,
          int ID_DEPENDENCIAIn,
          String HOST_LOCALIn, String TURNO_ACTUALIn) {
          this.ID_PUNTOS_ATENCION = ID_PUNTOS_ATENCIONIn;
          this.NOMBRE_PA = NOMBRE_PAIn;
          this.ID_DEPENDENCIA = ID_DEPENDENCIAIn;
          this.HOST_LOCAL = HOST_LOCALIn;
          this.TURNO_ACTUAL = TURNO_ACTUALIn;
    }


    /** 
     * hasEqualMapping-method will compare two PuntosAtencion instances
     * and return true if they contain same values in all persistent instance 
     * variables. If hasEqualMapping returns true, it does not mean the objects
     * are the same instance. However it does mean that in that moment, they 
     * are mapped to the same row in database.
     */
    public boolean hasEqualMapping(PuntosAtencion valueObject) {

          if (valueObject.getID_PUNTOS_ATENCION() != this.ID_PUNTOS_ATENCION) {
                    return(false);
          }
          if (this.NOMBRE_PA == null) {
                    if (valueObject.getNOMBRE_PA() != null)
                           return(false);
          } else if (!this.NOMBRE_PA.equals(valueObject.getNOMBRE_PA())) {
                    return(false);
          }
          if (valueObject.getID_DEPENDENCIA() != this.ID_DEPENDENCIA) {
                    return(false);
          }
          if (this.HOST_LOCAL == null) {
                    if (valueObject.getHOST_LOCAL() != null)
                           return(false);
          } else if (!this.HOST_LOCAL.equals(valueObject.getHOST_LOCAL())) {
                    return(false);
          }
          if (this.TURNO_ACTUAL == null) {
                    if (valueObject.getTURNO_ACTUAL() != null)
                           return(false);
          } else if (!this.TURNO_ACTUAL.equals(valueObject.getTURNO_ACTUAL())) {
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
        out.append("\nclass PuntosAtencion, mapping to table PUNTOS_ATENCION\n");
        out.append("Persistent attributes: \n"); 
        out.append("ID_PUNTOS_ATENCION = " + this.ID_PUNTOS_ATENCION + "\n"); 
        out.append("NOMBRE_PA = " + this.NOMBRE_PA + "\n"); 
        out.append("ID_DEPENDENCIA = " + this.ID_DEPENDENCIA + "\n"); 
        out.append("HOST_LOCAL = " + this.HOST_LOCAL + "\n"); 
        out.append("TURNO_ACTUAL = " + this.TURNO_ACTUAL + "\n"); 
        return out.toString();
    }


    /**
     * Clone will return identical deep copy of this valueObject.
     * Note, that this method is different than the clone() which
     * is defined in java.lang.Object. Here, the retuned cloned object
     * will also have all its attributes cloned.
     */
    public Object clone() {
        PuntosAtencion cloned = new PuntosAtencion();

        cloned.setID_PUNTOS_ATENCION(this.ID_PUNTOS_ATENCION); 
        if (this.NOMBRE_PA != null)
             cloned.setNOMBRE_PA(new String(this.NOMBRE_PA)); 
        cloned.setID_DEPENDENCIA(this.ID_DEPENDENCIA); 
        if (this.HOST_LOCAL != null)
             cloned.setHOST_LOCAL(new String(this.HOST_LOCAL)); 
        if (this.TURNO_ACTUAL != null)
             cloned.setTURNO_ACTUAL(new String(this.TURNO_ACTUAL)); 
        return cloned;
        
    }



    /** 
     * getDaogenVersion will return information about
     * generator which created these sources.
     */
    public String getDaogenVersion() {
        return "DaoGen version 2.4.1";
    }

    /**
     * @return the TURNO_ACTUAL
     */
    public String getTURNO_ACTUAL() {
        return TURNO_ACTUAL;
    }

    /**
     * @param TURNO_ACTUAL the TURNO_ACTUAL to set
     */
    public void setTURNO_ACTUAL(String TURNO_ACTUAL) {
        this.TURNO_ACTUAL = TURNO_ACTUAL;
    }

    /**
     * @return the ESTADO
     */
    public String getESTADO() {
        return ESTADO;
    }

    /**
     * @param ESTADO the ESTADO to set
     */
    public void setESTADO(String ESTADO) {
        this.ESTADO = ESTADO;
    }

}