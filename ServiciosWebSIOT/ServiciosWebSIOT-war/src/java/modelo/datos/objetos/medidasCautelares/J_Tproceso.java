package modelo.datos.objetos.medidasCautelares;



import java.io.*;
import java.sql.*;
import java.util.*;
import java.math.*;

 /**
  * J_Tproceso Value Object.
  * This class is value object representing database table J_TPROCESO
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



public class J_Tproceso implements Cloneable, Serializable {

    /** 
     * Persistent Instance variables. This data is directly 
     * mapped to the columns of database table.
     */
    private int JTP_ID;
    private String JTP_NOMBRE;
    private String JTP_CODRUNT;



    /** 
     * Constructors. DaoGen generates two constructors by default.
     * The first one takes no arguments and provides the most simple
     * way to create object instance. The another one takes one
     * argument, which is the primary key of the corresponding table.
     */

    public J_Tproceso () {

    }

    public J_Tproceso (int JTP_IDIn) {

          this.JTP_ID = JTP_IDIn;

    }


    /** 
     * Get- and Set-methods for persistent variables. The default
     * behaviour does not make any checks against malformed data,
     * so these might require some manual additions.
     */

    public int getJTP_ID() {
          return this.JTP_ID;
    }
    public void setJTP_ID(int JTP_IDIn) {
          this.JTP_ID = JTP_IDIn;
    }

    public String getJTP_NOMBRE() {
          return this.JTP_NOMBRE;
    }
    public void setJTP_NOMBRE(String JTP_NOMBREIn) {
          this.JTP_NOMBRE = JTP_NOMBREIn;
    }

    public String getJTP_CODRUNT() {
          return this.JTP_CODRUNT;
    }
    public void setJTP_CODRUNT(String JTP_CODRUNTIn) {
          this.JTP_CODRUNT = JTP_CODRUNTIn;
    }



    /** 
     * setAll allows to set all persistent variables in one method call.
     * This is useful, when all data is available and it is needed to 
     * set the initial state of this object. Note that this method will
     * directly modify instance variales, without going trough the 
     * individual set-methods.
     */

    public void setAll(int JTP_IDIn,
          String JTP_NOMBREIn,
          String JTP_CODRUNTIn) {
          this.JTP_ID = JTP_IDIn;
          this.JTP_NOMBRE = JTP_NOMBREIn;
          this.JTP_CODRUNT = JTP_CODRUNTIn;
    }


    /** 
     * hasEqualMapping-method will compare two J_Tproceso instances
     * and return true if they contain same values in all persistent instance 
     * variables. If hasEqualMapping returns true, it does not mean the objects
     * are the same instance. However it does mean that in that moment, they 
     * are mapped to the same row in database.
     */
    public boolean hasEqualMapping(J_Tproceso valueObject) {

          if (valueObject.getJTP_ID() != this.JTP_ID) {
                    return(false);
          }
          if (this.JTP_NOMBRE == null) {
                    if (valueObject.getJTP_NOMBRE() != null)
                           return(false);
          } else if (!this.JTP_NOMBRE.equals(valueObject.getJTP_NOMBRE())) {
                    return(false);
          }
          if (this.JTP_CODRUNT == null) {
                    if (valueObject.getJTP_CODRUNT() != null)
                           return(false);
          } else if (!this.JTP_CODRUNT.equals(valueObject.getJTP_CODRUNT())) {
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
        out.append("\nclass J_Tproceso, mapping to table J_TPROCESO\n");
        out.append("Persistent attributes: \n"); 
        out.append("JTP_ID = " + this.JTP_ID + "\n"); 
        out.append("JTP_NOMBRE = " + this.JTP_NOMBRE + "\n"); 
        out.append("JTP_CODRUNT = " + this.JTP_CODRUNT + "\n"); 
        return out.toString();
    }


    /**
     * Clone will return identical deep copy of this valueObject.
     * Note, that this method is different than the clone() which
     * is defined in java.lang.Object. Here, the retuned cloned object
     * will also have all its attributes cloned.
     */
    public Object clone() {
        J_Tproceso cloned = new J_Tproceso();

        cloned.setJTP_ID(this.JTP_ID); 
        if (this.JTP_NOMBRE != null)
             cloned.setJTP_NOMBRE(new String(this.JTP_NOMBRE)); 
        if (this.JTP_CODRUNT != null)
             cloned.setJTP_CODRUNT(new String(this.JTP_CODRUNT)); 
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

