package modelo.datos.objetos.accesorias;

import java.io.*;
import java.sql.*;
import java.util.*;
import java.math.*;

 /**
  * LimitacionPropiedad Value Object.
  * This class is value object representing database table LIMITACIONPROPIEDAD
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



public class LimitacionPropiedad implements Cloneable, Serializable {

    /** 
     * Persistent Instance variables. This data is directly 
     * mapped to the columns of database table.
     */
    private int IDLIMITACION;
    private String COD_LIMITACION;
    private String DESC_LIMITACION;
    private String ESTADO_LIMITACION;
    private String COD_LIMITACIONRUNT;



    /** 
     * Constructors. DaoGen generates two constructors by default.
     * The first one takes no arguments and provides the most simple
     * way to create object instance. The another one takes one
     * argument, which is the primary key of the corresponding table.
     */

    public LimitacionPropiedad () {

    }

    public LimitacionPropiedad (int IDLIMITACIONIn) {

          this.IDLIMITACION = IDLIMITACIONIn;

    }


    /** 
     * Get- and Set-methods for persistent variables. The default
     * behaviour does not make any checks against malformed data,
     * so these might require some manual additions.
     */

    public int getIDLIMITACION() {
          return this.IDLIMITACION;
    }
    public void setIDLIMITACION(int IDLIMITACIONIn) {
          this.IDLIMITACION = IDLIMITACIONIn;
    }

    public String getCOD_LIMITACION() {
          return this.COD_LIMITACION;
    }
    public void setCOD_LIMITACION(String COD_LIMITACIONIn) {
          this.COD_LIMITACION = COD_LIMITACIONIn;
    }

    public String getDESC_LIMITACION() {
          return this.DESC_LIMITACION;
    }
    public void setDESC_LIMITACION(String DESC_LIMITACIONIn) {
          this.DESC_LIMITACION = DESC_LIMITACIONIn;
    }

    public String getESTADO_LIMITACION() {
          return this.ESTADO_LIMITACION;
    }
    public void setESTADO_LIMITACION(String ESTADO_LIMITACIONIn) {
          this.ESTADO_LIMITACION = ESTADO_LIMITACIONIn;
    }

    public String getCOD_LIMITACIONRUNT() {
          return this.COD_LIMITACIONRUNT;
    }
    public void setCOD_LIMITACIONRUNT(String COD_LIMITACIONRUNTIn) {
          this.COD_LIMITACIONRUNT = COD_LIMITACIONRUNTIn;
    }



    /** 
     * setAll allows to set all persistent variables in one method call.
     * This is useful, when all data is available and it is needed to 
     * set the initial state of this object. Note that this method will
     * directly modify instance variales, without going trough the 
     * individual set-methods.
     */

    public void setAll(int IDLIMITACIONIn,
          String COD_LIMITACIONIn,
          String DESC_LIMITACIONIn,
          String ESTADO_LIMITACIONIn,
          String COD_LIMITACIONRUNTIn) {
          this.IDLIMITACION = IDLIMITACIONIn;
          this.COD_LIMITACION = COD_LIMITACIONIn;
          this.DESC_LIMITACION = DESC_LIMITACIONIn;
          this.ESTADO_LIMITACION = ESTADO_LIMITACIONIn;
          this.COD_LIMITACIONRUNT = COD_LIMITACIONRUNTIn;
    }


    /** 
     * hasEqualMapping-method will compare two LimitacionPropiedad instances
     * and return true if they contain same values in all persistent instance 
     * variables. If hasEqualMapping returns true, it does not mean the objects
     * are the same instance. However it does mean that in that moment, they 
     * are mapped to the same row in database.
     */
    public boolean hasEqualMapping(LimitacionPropiedad valueObject) {

          if (valueObject.getIDLIMITACION() != this.IDLIMITACION) {
                    return(false);
          }
          if (this.COD_LIMITACION == null) {
                    if (valueObject.getCOD_LIMITACION() != null)
                           return(false);
          } else if (!this.COD_LIMITACION.equals(valueObject.getCOD_LIMITACION())) {
                    return(false);
          }
          if (this.DESC_LIMITACION == null) {
                    if (valueObject.getDESC_LIMITACION() != null)
                           return(false);
          } else if (!this.DESC_LIMITACION.equals(valueObject.getDESC_LIMITACION())) {
                    return(false);
          }
          if (this.ESTADO_LIMITACION == null) {
                    if (valueObject.getESTADO_LIMITACION() != null)
                           return(false);
          } else if (!this.ESTADO_LIMITACION.equals(valueObject.getESTADO_LIMITACION())) {
                    return(false);
          }
          if (this.COD_LIMITACIONRUNT == null) {
                    if (valueObject.getCOD_LIMITACIONRUNT() != null)
                           return(false);
          } else if (!this.COD_LIMITACIONRUNT.equals(valueObject.getCOD_LIMITACIONRUNT())) {
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
        out.append("\nclass LimitacionPropiedad, mapping to table LIMITACIONPROPIEDAD\n");
        out.append("Persistent attributes: \n"); 
        out.append("IDLIMITACION = " + this.IDLIMITACION + "\n"); 
        out.append("COD_LIMITACION = " + this.COD_LIMITACION + "\n"); 
        out.append("DESC_LIMITACION = " + this.DESC_LIMITACION + "\n"); 
        out.append("ESTADO_LIMITACION = " + this.ESTADO_LIMITACION + "\n"); 
        out.append("COD_LIMITACIONRUNT = " + this.COD_LIMITACIONRUNT + "\n"); 
        return out.toString();
    }


    /**
     * Clone will return identical deep copy of this valueObject.
     * Note, that this method is different than the clone() which
     * is defined in java.lang.Object. Here, the retuned cloned object
     * will also have all its attributes cloned.
     */
    public Object clone() {
        LimitacionPropiedad cloned = new LimitacionPropiedad();

        cloned.setIDLIMITACION(this.IDLIMITACION); 
        if (this.COD_LIMITACION != null)
             cloned.setCOD_LIMITACION(new String(this.COD_LIMITACION)); 
        if (this.DESC_LIMITACION != null)
             cloned.setDESC_LIMITACION(new String(this.DESC_LIMITACION)); 
        if (this.ESTADO_LIMITACION != null)
             cloned.setESTADO_LIMITACION(new String(this.ESTADO_LIMITACION)); 
        if (this.COD_LIMITACIONRUNT != null)
             cloned.setCOD_LIMITACIONRUNT(new String(this.COD_LIMITACIONRUNT)); 
        return cloned;
    }



    /** 
     * getDaogenVersion will return information about
     * generator which created these sources.
     */
    public String getDaogenVersion() {
        return "DaoGen version 2.4.1";
    }

}