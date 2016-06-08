package modelo.datos.objetos.comparendos.accesorias;

import java.io.*;
import java.sql.*;
import java.util.*;
import java.math.*;

 /**
  * PatiosInmovilizacionComp Value Object.
  * This class is value object representing database table PATIOSINMOVILIZACION
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



public class PatiosInmovilizacionComp implements Cloneable, Serializable {

    /** 
     * Persistent Instance variables. This data is directly 
     * mapped to the columns of database table.
     */
    private int ID_PATIO;
    private String COD_PATIO;
    private String DESCRIPCIONPATIO;
    private String DIRECCIONPATIO;



    /** 
     * Constructors. DaoGen generates two constructors by default.
     * The first one takes no arguments and provides the most simple
     * way to create object instance. The another one takes one
     * argument, which is the primary key of the corresponding table.
     */

    public PatiosInmovilizacionComp () {

    }

    public PatiosInmovilizacionComp (int ID_PATIOIn) {

          this.ID_PATIO = ID_PATIOIn;

    }


    /** 
     * Get- and Set-methods for persistent variables. The default
     * behaviour does not make any checks against malformed data,
     * so these might require some manual additions.
     */

    public int getID_PATIO() {
          return this.ID_PATIO;
    }
    public void setID_PATIO(int ID_PATIOIn) {
          this.ID_PATIO = ID_PATIOIn;
    }

    public String getCOD_PATIO() {
          return this.COD_PATIO;
    }
    public void setCOD_PATIO(String COD_PATIOIn) {
          this.COD_PATIO = COD_PATIOIn;
    }

    public String getDESCRIPCIONPATIO() {
          return this.DESCRIPCIONPATIO;
    }
    public void setDESCRIPCIONPATIO(String DESCRIPCIONPATIOIn) {
          this.DESCRIPCIONPATIO = DESCRIPCIONPATIOIn;
    }

    public String getDIRECCIONPATIO() {
          return this.DIRECCIONPATIO;
    }
    public void setDIRECCIONPATIO(String DIRECCIONPATIOIn) {
          this.DIRECCIONPATIO = DIRECCIONPATIOIn;
    }



    /** 
     * setAll allows to set all persistent variables in one method call.
     * This is useful, when all data is available and it is needed to 
     * set the initial state of this object. Note that this method will
     * directly modify instance variales, without going trough the 
     * individual set-methods.
     */

    public void setAll(int ID_PATIOIn,
          String COD_PATIOIn,
          String DESCRIPCIONPATIOIn,
          String DIRECCIONPATIOIn) {
          this.ID_PATIO = ID_PATIOIn;
          this.COD_PATIO = COD_PATIOIn;
          this.DESCRIPCIONPATIO = DESCRIPCIONPATIOIn;
          this.DIRECCIONPATIO = DIRECCIONPATIOIn;
    }


    /** 
     * hasEqualMapping-method will compare two PatiosInmovilizacionComp instances
     * and return true if they contain same values in all persistent instance 
     * variables. If hasEqualMapping returns true, it does not mean the objects
     * are the same instance. However it does mean that in that moment, they 
     * are mapped to the same row in database.
     */
    public boolean hasEqualMapping(PatiosInmovilizacionComp valueObject) {

          if (valueObject.getID_PATIO() != this.ID_PATIO) {
                    return(false);
          }
          if (this.COD_PATIO == null) {
                    if (valueObject.getCOD_PATIO() != null)
                           return(false);
          } else if (!this.COD_PATIO.equals(valueObject.getCOD_PATIO())) {
                    return(false);
          }
          if (this.DESCRIPCIONPATIO == null) {
                    if (valueObject.getDESCRIPCIONPATIO() != null)
                           return(false);
          } else if (!this.DESCRIPCIONPATIO.equals(valueObject.getDESCRIPCIONPATIO())) {
                    return(false);
          }
          if (this.DIRECCIONPATIO == null) {
                    if (valueObject.getDIRECCIONPATIO() != null)
                           return(false);
          } else if (!this.DIRECCIONPATIO.equals(valueObject.getDIRECCIONPATIO())) {
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
        out.append("\nclass PatiosInmovilizacionComp, mapping to table PATIOSINMOVILIZACION\n");
        out.append("Persistent attributes: \n"); 
        out.append("ID_PATIO = " + this.ID_PATIO + "\n"); 
        out.append("COD_PATIO = " + this.COD_PATIO + "\n"); 
        out.append("DESCRIPCIONPATIO = " + this.DESCRIPCIONPATIO + "\n"); 
        out.append("DIRECCIONPATIO = " + this.DIRECCIONPATIO + "\n"); 
        return out.toString();
    }


    /**
     * Clone will return identical deep copy of this valueObject.
     * Note, that this method is different than the clone() which
     * is defined in java.lang.Object. Here, the retuned cloned object
     * will also have all its attributes cloned.
     */
    public Object clone() {
        PatiosInmovilizacionComp cloned = new PatiosInmovilizacionComp();

        cloned.setID_PATIO(this.ID_PATIO); 
        if (this.COD_PATIO != null)
             cloned.setCOD_PATIO(new String(this.COD_PATIO)); 
        if (this.DESCRIPCIONPATIO != null)
             cloned.setDESCRIPCIONPATIO(new String(this.DESCRIPCIONPATIO)); 
        if (this.DIRECCIONPATIO != null)
             cloned.setDIRECCIONPATIO(new String(this.DIRECCIONPATIO)); 
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