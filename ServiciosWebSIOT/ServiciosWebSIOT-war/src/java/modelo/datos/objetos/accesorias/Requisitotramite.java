package modelo.datos.objetos.accesorias;
import java.io.*;
import java.sql.*;
import java.util.*;
import java.math.*;

 /**
  * Requisitotramite Value Object.
  * This class is value object representing database table REQUISITOTRAMITE
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



public class Requisitotramite implements Cloneable, Serializable {

    /** 
     * Persistent Instance variables. This data is directly 
     * mapped to the columns of database table.
     */
    private int ID_REQTRAMITE;
    private String COD_REQTRAMITE;
    private String DESC_REQTRAMITE;
    private int TIPO_TRAMITE;
    private String REQUERIDO;



    /** 
     * Constructors. DaoGen generates two constructors by default.
     * The first one takes no arguments and provides the most simple
     * way to create object instance. The another one takes one
     * argument, which is the primary key of the corresponding table.
     */

    public Requisitotramite () {

    }

    public Requisitotramite (int ID_REQTRAMITEIn) {

          this.ID_REQTRAMITE = ID_REQTRAMITEIn;

    }


    /** 
     * Get- and Set-methods for persistent variables. The default
     * behaviour does not make any checks against malformed data,
     * so these might require some manual additions.
     */

    public int getID_REQTRAMITE() {
          return this.ID_REQTRAMITE;
    }
    public void setID_REQTRAMITE(int ID_REQTRAMITEIn) {
          this.ID_REQTRAMITE = ID_REQTRAMITEIn;
    }

    public String getCOD_REQTRAMITE() {
          return this.COD_REQTRAMITE;
    }
    public void setCOD_REQTRAMITE(String COD_REQTRAMITEIn) {
          this.COD_REQTRAMITE = COD_REQTRAMITEIn;
    }

    public String getDESC_REQTRAMITE() {
          return this.DESC_REQTRAMITE;
    }
    public void setDESC_REQTRAMITE(String DESC_REQTRAMITEIn) {
          this.DESC_REQTRAMITE = DESC_REQTRAMITEIn;
    }

    public int getTIPO_TRAMITE() {
          return this.TIPO_TRAMITE;
    }
    public void setTIPO_TRAMITE(int TIPO_TRAMITEIn) {
          this.TIPO_TRAMITE = TIPO_TRAMITEIn;
    }

    public String getREQUERIDO() {
          return this.REQUERIDO;
    }
    public void setREQUERIDO(String REQUERIDOIn) {
          this.REQUERIDO = REQUERIDOIn;
    }



    /** 
     * setAll allows to set all persistent variables in one method call.
     * This is useful, when all data is available and it is needed to 
     * set the initial state of this object. Note that this method will
     * directly modify instance variales, without going trough the 
     * individual set-methods.
     */

    public void setAll(int ID_REQTRAMITEIn,
          String COD_REQTRAMITEIn,
          String DESC_REQTRAMITEIn,
          int TIPO_TRAMITEIn,
          String REQUERIDOIn) {
          this.ID_REQTRAMITE = ID_REQTRAMITEIn;
          this.COD_REQTRAMITE = COD_REQTRAMITEIn;
          this.DESC_REQTRAMITE = DESC_REQTRAMITEIn;
          this.TIPO_TRAMITE = TIPO_TRAMITEIn;
          this.REQUERIDO = REQUERIDOIn;
    }


    /** 
     * hasEqualMapping-method will compare two Requisitotramite instances
     * and return true if they contain same values in all persistent instance 
     * variables. If hasEqualMapping returns true, it does not mean the objects
     * are the same instance. However it does mean that in that moment, they 
     * are mapped to the same row in database.
     */
    public boolean hasEqualMapping(Requisitotramite valueObject) {

          if (valueObject.getID_REQTRAMITE() != this.ID_REQTRAMITE) {
                    return(false);
          }
          if (this.COD_REQTRAMITE == null) {
                    if (valueObject.getCOD_REQTRAMITE() != null)
                           return(false);
          } else if (!this.COD_REQTRAMITE.equals(valueObject.getCOD_REQTRAMITE())) {
                    return(false);
          }
          if (this.DESC_REQTRAMITE == null) {
                    if (valueObject.getDESC_REQTRAMITE() != null)
                           return(false);
          } else if (!this.DESC_REQTRAMITE.equals(valueObject.getDESC_REQTRAMITE())) {
                    return(false);
          }
          if (valueObject.getTIPO_TRAMITE() != this.TIPO_TRAMITE) {
                    return(false);
          }
          if (this.REQUERIDO == null) {
                    if (valueObject.getREQUERIDO() != null)
                           return(false);
          } else if (!this.REQUERIDO.equals(valueObject.getREQUERIDO())) {
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
        out.append("\nclass Requisitotramite, mapping to table REQUISITOTRAMITE\n");
        out.append("Persistent attributes: \n"); 
        out.append("ID_REQTRAMITE = " + this.ID_REQTRAMITE + "\n"); 
        out.append("COD_REQTRAMITE = " + this.COD_REQTRAMITE + "\n"); 
        out.append("DESC_REQTRAMITE = " + this.DESC_REQTRAMITE + "\n"); 
        out.append("TIPO_TRAMITE = " + this.TIPO_TRAMITE + "\n"); 
        out.append("REQUERIDO = " + this.REQUERIDO + "\n"); 
        return out.toString();
    }


    /**
     * Clone will return identical deep copy of this valueObject.
     * Note, that this method is different than the clone() which
     * is defined in java.lang.Object. Here, the retuned cloned object
     * will also have all its attributes cloned.
     */
    public Object clone() {
        Requisitotramite cloned = new Requisitotramite();

        cloned.setID_REQTRAMITE(this.ID_REQTRAMITE); 
        if (this.COD_REQTRAMITE != null)
             cloned.setCOD_REQTRAMITE(new String(this.COD_REQTRAMITE)); 
        if (this.DESC_REQTRAMITE != null)
             cloned.setDESC_REQTRAMITE(new String(this.DESC_REQTRAMITE)); 
        cloned.setTIPO_TRAMITE(this.TIPO_TRAMITE); 
        if (this.REQUERIDO != null)
             cloned.setREQUERIDO(new String(this.REQUERIDO)); 
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