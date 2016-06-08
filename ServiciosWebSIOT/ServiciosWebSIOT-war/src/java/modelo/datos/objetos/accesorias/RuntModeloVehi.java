package modelo.datos.objetos.accesorias;

import java.io.*;
import java.sql.*;
import java.util.*;
import java.math.*;

 /**
  * RuntModeloVehi Value Object.
  * This class is value object representing database table RUNT_MODELOVEH
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



public class RuntModeloVehi implements Cloneable, Serializable {

    /** 
     * Persistent Instance variables. This data is directly 
     * mapped to the columns of database table.
     */
    private int ID_MODELO;
    private String COD_MODELO;
    private String DESC_MODELO;



    /** 
     * Constructors. DaoGen generates two constructors by default.
     * The first one takes no arguments and provides the most simple
     * way to create object instance. The another one takes one
     * argument, which is the primary key of the corresponding table.
     */

    public RuntModeloVehi () {

    }

    public RuntModeloVehi (int ID_MODELOIn) {

          this.ID_MODELO = ID_MODELOIn;

    }


    /** 
     * Get- and Set-methods for persistent variables. The default
     * behaviour does not make any checks against malformed data,
     * so these might require some manual additions.
     */

    public int getID_MODELO() {
          return this.ID_MODELO;
    }
    public void setID_MODELO(int ID_MODELOIn) {
          this.ID_MODELO = ID_MODELOIn;
    }

    public String getCOD_MODELO() {
          return this.COD_MODELO;
    }
    public void setCOD_MODELO(String COD_MODELOIn) {
          this.COD_MODELO = COD_MODELOIn;
    }

    public String getDESC_MODELO() {
          return this.DESC_MODELO;
    }
    public void setDESC_MODELO(String DESC_MODELOIn) {
          this.DESC_MODELO = DESC_MODELOIn;
    }



    /** 
     * setAll allows to set all persistent variables in one method call.
     * This is useful, when all data is available and it is needed to 
     * set the initial state of this object. Note that this method will
     * directly modify instance variales, without going trough the 
     * individual set-methods.
     */

    public void setAll(int ID_MODELOIn,
          String COD_MODELOIn,
          String DESC_MODELOIn) {
          this.ID_MODELO = ID_MODELOIn;
          this.COD_MODELO = COD_MODELOIn;
          this.DESC_MODELO = DESC_MODELOIn;
    }


    /** 
     * hasEqualMapping-method will compare two RuntModeloVehi instances
     * and return true if they contain same values in all persistent instance 
     * variables. If hasEqualMapping returns true, it does not mean the objects
     * are the same instance. However it does mean that in that moment, they 
     * are mapped to the same row in database.
     */
    public boolean hasEqualMapping(RuntModeloVehi valueObject) {

          if (valueObject.getID_MODELO() != this.ID_MODELO) {
                    return(false);
          }
          if (this.COD_MODELO == null) {
                    if (valueObject.getCOD_MODELO() != null)
                           return(false);
          } else if (!this.COD_MODELO.equals(valueObject.getCOD_MODELO())) {
                    return(false);
          }
          if (this.DESC_MODELO == null) {
                    if (valueObject.getDESC_MODELO() != null)
                           return(false);
          } else if (!this.DESC_MODELO.equals(valueObject.getDESC_MODELO())) {
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
        out.append("\nclass RuntModeloVehi, mapping to table RUNT_MODELOVEH\n");
        out.append("Persistent attributes: \n"); 
        out.append("ID_MODELO = " + this.ID_MODELO + "\n"); 
        out.append("COD_MODELO = " + this.COD_MODELO + "\n"); 
        out.append("DESC_MODELO = " + this.DESC_MODELO + "\n"); 
        return out.toString();
    }


    /**
     * Clone will return identical deep copy of this valueObject.
     * Note, that this method is different than the clone() which
     * is defined in java.lang.Object. Here, the retuned cloned object
     * will also have all its attributes cloned.
     */
    public Object clone() {
        RuntModeloVehi cloned = new RuntModeloVehi();

        cloned.setID_MODELO(this.ID_MODELO); 
        if (this.COD_MODELO != null)
             cloned.setCOD_MODELO(new String(this.COD_MODELO)); 
        if (this.DESC_MODELO != null)
             cloned.setDESC_MODELO(new String(this.DESC_MODELO)); 
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