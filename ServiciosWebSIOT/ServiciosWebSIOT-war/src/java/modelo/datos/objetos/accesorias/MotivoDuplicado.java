package modelo.datos.objetos.accesorias;

import java.io.*;
import java.sql.*;
import java.util.*;
import java.math.*;

 /**
  * MotivoDuplicado Value Object.
  * This class is value object representing database table MOTIVODUPLICADO
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



public class MotivoDuplicado implements Cloneable, Serializable {

    /** 
     * Persistent Instance variables. This data is directly 
     * mapped to the columns of database table.
     */
    private int ID_MOTIVODUPLICADO;
    private String COD_MOTIVODUPLICADO;
    private String DES_MOTIVODUPLICADO;
    private int IDRUNT;



    /** 
     * Constructors. DaoGen generates two constructors by default.
     * The first one takes no arguments and provides the most simple
     * way to create object instance. The another one takes one
     * argument, which is the primary key of the corresponding table.
     */

    public MotivoDuplicado () {

    }

    public MotivoDuplicado (int ID_MOTIVODUPLICADOIn) {

          this.ID_MOTIVODUPLICADO = ID_MOTIVODUPLICADOIn;

    }


    /** 
     * Get- and Set-methods for persistent variables. The default
     * behaviour does not make any checks against malformed data,
     * so these might require some manual additions.
     */

    public int getID_MOTIVODUPLICADO() {
          return this.ID_MOTIVODUPLICADO;
    }
    public void setID_MOTIVODUPLICADO(int ID_MOTIVODUPLICADOIn) {
          this.ID_MOTIVODUPLICADO = ID_MOTIVODUPLICADOIn;
    }

    public String getCOD_MOTIVODUPLICADO() {
          return this.COD_MOTIVODUPLICADO;
    }
    public void setCOD_MOTIVODUPLICADO(String COD_MOTIVODUPLICADOIn) {
          this.COD_MOTIVODUPLICADO = COD_MOTIVODUPLICADOIn;
    }

    public String getDES_MOTIVODUPLICADO() {
          return this.DES_MOTIVODUPLICADO;
    }
    public void setDES_MOTIVODUPLICADO(String DES_MOTIVODUPLICADOIn) {
          this.DES_MOTIVODUPLICADO = DES_MOTIVODUPLICADOIn;
    }

    public int getIDRUNT() {
          return this.IDRUNT;
    }
    public void setIDRUNT(int IDRUNTIn) {
          this.IDRUNT = IDRUNTIn;
    }



    /** 
     * setAll allows to set all persistent variables in one method call.
     * This is useful, when all data is available and it is needed to 
     * set the initial state of this object. Note that this method will
     * directly modify instance variales, without going trough the 
     * individual set-methods.
     */

    public void setAll(int ID_MOTIVODUPLICADOIn,
          String COD_MOTIVODUPLICADOIn,
          String DES_MOTIVODUPLICADOIn,
          int IDRUNTIn) {
          this.ID_MOTIVODUPLICADO = ID_MOTIVODUPLICADOIn;
          this.COD_MOTIVODUPLICADO = COD_MOTIVODUPLICADOIn;
          this.DES_MOTIVODUPLICADO = DES_MOTIVODUPLICADOIn;
          this.IDRUNT = IDRUNTIn;
    }


    /** 
     * hasEqualMapping-method will compare two MotivoDuplicado instances
     * and return true if they contain same values in all persistent instance 
     * variables. If hasEqualMapping returns true, it does not mean the objects
     * are the same instance. However it does mean that in that moment, they 
     * are mapped to the same row in database.
     */
    public boolean hasEqualMapping(MotivoDuplicado valueObject) {

          if (valueObject.getID_MOTIVODUPLICADO() != this.ID_MOTIVODUPLICADO) {
                    return(false);
          }
          if (this.COD_MOTIVODUPLICADO == null) {
                    if (valueObject.getCOD_MOTIVODUPLICADO() != null)
                           return(false);
          } else if (!this.COD_MOTIVODUPLICADO.equals(valueObject.getCOD_MOTIVODUPLICADO())) {
                    return(false);
          }
          if (this.DES_MOTIVODUPLICADO == null) {
                    if (valueObject.getDES_MOTIVODUPLICADO() != null)
                           return(false);
          } else if (!this.DES_MOTIVODUPLICADO.equals(valueObject.getDES_MOTIVODUPLICADO())) {
                    return(false);
          }
          if (valueObject.getIDRUNT() != this.IDRUNT) {
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
        out.append("\nclass MotivoDuplicado, mapping to table MOTIVODUPLICADO\n");
        out.append("Persistent attributes: \n"); 
        out.append("ID_MOTIVODUPLICADO = " + this.ID_MOTIVODUPLICADO + "\n"); 
        out.append("COD_MOTIVODUPLICADO = " + this.COD_MOTIVODUPLICADO + "\n"); 
        out.append("DES_MOTIVODUPLICADO = " + this.DES_MOTIVODUPLICADO + "\n"); 
        out.append("IDRUNT = " + this.IDRUNT + "\n"); 
        return out.toString();
    }


    /**
     * Clone will return identical deep copy of this valueObject.
     * Note, that this method is different than the clone() which
     * is defined in java.lang.Object. Here, the retuned cloned object
     * will also have all its attributes cloned.
     */
    public Object clone() {
        MotivoDuplicado cloned = new MotivoDuplicado();

        cloned.setID_MOTIVODUPLICADO(this.ID_MOTIVODUPLICADO); 
        if (this.COD_MOTIVODUPLICADO != null)
             cloned.setCOD_MOTIVODUPLICADO(new String(this.COD_MOTIVODUPLICADO)); 
        if (this.DES_MOTIVODUPLICADO != null)
             cloned.setDES_MOTIVODUPLICADO(new String(this.DES_MOTIVODUPLICADO)); 
        cloned.setIDRUNT(this.IDRUNT); 
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