package modelo.datos.objetos.tramites;

import java.io.*;
import java.sql.*;
import java.util.*;
import java.math.*;

 /**
  * Reqxtramite Value Object.
  * This class is value object representing database table REQXTRAMITE
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



public class Reqxtramite implements Cloneable, Serializable {

    /** 
     * Persistent Instance variables. This data is directly 
     * mapped to the columns of database table.
     */
    private int ID_REQXTRAMITE;
    private int ID_TRAMITEINTERNO;
    private int ID_REQUISITOTRAMITE;
    private String COD_REQTRAMITE;
    private String DESC_RECTRAMITE;
    private int ID_SUBTIPOTRAMITE;



    /** 
     * Constructors. DaoGen generates two constructors by default.
     * The first one takes no arguments and provides the most simple
     * way to create object instance. The another one takes one
     * argument, which is the primary key of the corresponding table.
     */

    public Reqxtramite () {

    }

    public Reqxtramite (int ID_REQXTRAMITEIn) {

          this.ID_REQXTRAMITE = ID_REQXTRAMITEIn;

    }


    /** 
     * Get- and Set-methods for persistent variables. The default
     * behaviour does not make any checks against malformed data,
     * so these might require some manual additions.
     */

    public int getID_REQXTRAMITE() {
          return this.ID_REQXTRAMITE;
    }
    public void setID_REQXTRAMITE(int ID_REQXTRAMITEIn) {
          this.ID_REQXTRAMITE = ID_REQXTRAMITEIn;
    }

    public int getID_TRAMITEINTERNO() {
          return this.ID_TRAMITEINTERNO;
    }
    public void setID_TRAMITEINTERNO(int ID_TRAMITEINTERNOIn) {
          this.ID_TRAMITEINTERNO = ID_TRAMITEINTERNOIn;
    }

    public int getID_REQUISITOTRAMITE() {
          return this.ID_REQUISITOTRAMITE;
    }
    public void setID_REQUISITOTRAMITE(int ID_REQUISITOTRAMITEIn) {
          this.ID_REQUISITOTRAMITE = ID_REQUISITOTRAMITEIn;
    }

    public String getCOD_REQTRAMITE() {
          return this.COD_REQTRAMITE;
    }
    public void setCOD_REQTRAMITE(String COD_REQTRAMITEIn) {
          this.COD_REQTRAMITE = COD_REQTRAMITEIn;
    }

    public String getDESC_RECTRAMITE() {
          return this.DESC_RECTRAMITE;
    }
    public void setDESC_RECTRAMITE(String DESC_RECTRAMITEIn) {
          this.DESC_RECTRAMITE = DESC_RECTRAMITEIn;
    }

    public int getID_SUBTIPOTRAMITE() {
          return this.ID_SUBTIPOTRAMITE;
    }
    public void setID_SUBTIPOTRAMITE(int ID_SUBTIPOTRAMITEIn) {
          this.ID_SUBTIPOTRAMITE = ID_SUBTIPOTRAMITEIn;
    }



    /** 
     * setAll allows to set all persistent variables in one method call.
     * This is useful, when all data is available and it is needed to 
     * set the initial state of this object. Note that this method will
     * directly modify instance variales, without going trough the 
     * individual set-methods.
     */

    public void setAll(int ID_REQXTRAMITEIn,
          int ID_TRAMITEINTERNOIn,
          int ID_REQUISITOTRAMITEIn,
          String COD_REQTRAMITEIn,
          String DESC_RECTRAMITEIn,
          int ID_SUBTIPOTRAMITEIn) {
          this.ID_REQXTRAMITE = ID_REQXTRAMITEIn;
          this.ID_TRAMITEINTERNO = ID_TRAMITEINTERNOIn;
          this.ID_REQUISITOTRAMITE = ID_REQUISITOTRAMITEIn;
          this.COD_REQTRAMITE = COD_REQTRAMITEIn;
          this.DESC_RECTRAMITE = DESC_RECTRAMITEIn;
          this.ID_SUBTIPOTRAMITE = ID_SUBTIPOTRAMITEIn;
    }


    /** 
     * hasEqualMapping-method will compare two Reqxtramite instances
     * and return true if they contain same values in all persistent instance 
     * variables. If hasEqualMapping returns true, it does not mean the objects
     * are the same instance. However it does mean that in that moment, they 
     * are mapped to the same row in database.
     */
    public boolean hasEqualMapping(Reqxtramite valueObject) {

          if (valueObject.getID_REQXTRAMITE() != this.ID_REQXTRAMITE) {
                    return(false);
          }
          if (valueObject.getID_TRAMITEINTERNO() != this.ID_TRAMITEINTERNO) {
                    return(false);
          }
          if (valueObject.getID_REQUISITOTRAMITE() != this.ID_REQUISITOTRAMITE) {
                    return(false);
          }
          if (this.COD_REQTRAMITE == null) {
                    if (valueObject.getCOD_REQTRAMITE() != null)
                           return(false);
          } else if (!this.COD_REQTRAMITE.equals(valueObject.getCOD_REQTRAMITE())) {
                    return(false);
          }
          if (this.DESC_RECTRAMITE == null) {
                    if (valueObject.getDESC_RECTRAMITE() != null)
                           return(false);
          } else if (!this.DESC_RECTRAMITE.equals(valueObject.getDESC_RECTRAMITE())) {
                    return(false);
          }
          if (valueObject.getID_SUBTIPOTRAMITE() != this.ID_SUBTIPOTRAMITE) {
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
        out.append("\nclass Reqxtramite, mapping to table REQXTRAMITE\n");
        out.append("Persistent attributes: \n"); 
        out.append("ID_REQXTRAMITE = " + this.ID_REQXTRAMITE + "\n"); 
        out.append("ID_TRAMITEINTERNO = " + this.ID_TRAMITEINTERNO + "\n"); 
        out.append("ID_REQUISITOTRAMITE = " + this.ID_REQUISITOTRAMITE + "\n"); 
        out.append("COD_REQTRAMITE = " + this.COD_REQTRAMITE + "\n"); 
        out.append("DESC_RECTRAMITE = " + this.DESC_RECTRAMITE + "\n"); 
        out.append("ID_SUBTIPOTRAMITE = " + this.ID_SUBTIPOTRAMITE + "\n"); 
        return out.toString();
    }


    /**
     * Clone will return identical deep copy of this valueObject.
     * Note, that this method is different than the clone() which
     * is defined in java.lang.Object. Here, the retuned cloned object
     * will also have all its attributes cloned.
     */
    public Object clone() {
        Reqxtramite cloned = new Reqxtramite();

        cloned.setID_REQXTRAMITE(this.ID_REQXTRAMITE); 
        cloned.setID_TRAMITEINTERNO(this.ID_TRAMITEINTERNO); 
        cloned.setID_REQUISITOTRAMITE(this.ID_REQUISITOTRAMITE); 
        if (this.COD_REQTRAMITE != null)
             cloned.setCOD_REQTRAMITE(new String(this.COD_REQTRAMITE)); 
        if (this.DESC_RECTRAMITE != null)
             cloned.setDESC_RECTRAMITE(new String(this.DESC_RECTRAMITE)); 
        cloned.setID_SUBTIPOTRAMITE(this.ID_SUBTIPOTRAMITE); 
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
