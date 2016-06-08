package modelo.datos.objetos.rangos;



import java.io.*;
import java.sql.*;
import java.util.*;
import java.math.*;

 /**
  * DetRangoLicencia Value Object.
  * This class is value object representing database table DET_RANGOLICENCIA
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



public class DetRangoLicencia implements Cloneable, Serializable {

    /** 
     * Persistent Instance variables. This data is directly 
     * mapped to the columns of database table.
     */
    private int IDDET_RANGOLIC;
    private int IDRANGO_LIC;
    private String NUMESP_VENAL;
    private String ASIGNADO;



    /** 
     * Constructors. DaoGen generates two constructors by default.
     * The first one takes no arguments and provides the most simple
     * way to create object instance. The another one takes one
     * argument, which is the primary key of the corresponding table.
     */

    public DetRangoLicencia () {

    }

    public DetRangoLicencia (int IDDET_RANGOLICIn) {

          this.IDDET_RANGOLIC = IDDET_RANGOLICIn;

    }


    /** 
     * Get- and Set-methods for persistent variables. The default
     * behaviour does not make any checks against malformed data,
     * so these might require some manual additions.
     */

    public int getIDDET_RANGOLIC() {
          return this.IDDET_RANGOLIC;
    }
    public void setIDDET_RANGOLIC(int IDDET_RANGOLICIn) {
          this.IDDET_RANGOLIC = IDDET_RANGOLICIn;
    }

    public int getIDRANGO_LIC() {
          return this.IDRANGO_LIC;
    }
    public void setIDRANGO_LIC(int IDRANGO_LICIn) {
          this.IDRANGO_LIC = IDRANGO_LICIn;
    }

    public String getNUMESP_VENAL() {
          return this.NUMESP_VENAL;
    }
    public void setNUMESP_VENAL(String NUMESP_VENALIn) {
          this.NUMESP_VENAL = NUMESP_VENALIn;
    }

    public String getASIGNADO() {
          return this.ASIGNADO;
    }
    public void setASIGNADO(String ASIGNADOIn) {
          this.ASIGNADO = ASIGNADOIn;
    }



    /** 
     * setAll allows to set all persistent variables in one method call.
     * This is useful, when all data is available and it is needed to 
     * set the initial state of this object. Note that this method will
     * directly modify instance variales, without going trough the 
     * individual set-methods.
     */

    public void setAll(int IDDET_RANGOLICIn,
          int IDRANGO_LICIn,
          String NUMESP_VENALIn,
          String ASIGNADOIn) {
          this.IDDET_RANGOLIC = IDDET_RANGOLICIn;
          this.IDRANGO_LIC = IDRANGO_LICIn;
          this.NUMESP_VENAL = NUMESP_VENALIn;
          this.ASIGNADO = ASIGNADOIn;
    }


    /** 
     * hasEqualMapping-method will compare two DetRangoLicencia instances
     * and return true if they contain same values in all persistent instance 
     * variables. If hasEqualMapping returns true, it does not mean the objects
     * are the same instance. However it does mean that in that moment, they 
     * are mapped to the same row in database.
     */
    public boolean hasEqualMapping(DetRangoLicencia valueObject) {

          if (valueObject.getIDDET_RANGOLIC() != this.IDDET_RANGOLIC) {
                    return(false);
          }
          if (valueObject.getIDRANGO_LIC() != this.IDRANGO_LIC) {
                    return(false);
          }
          if (this.NUMESP_VENAL == null) {
                    if (valueObject.getNUMESP_VENAL() != null)
                           return(false);
          } else if (!this.NUMESP_VENAL.equals(valueObject.getNUMESP_VENAL())) {
                    return(false);
          }
          if (this.ASIGNADO == null) {
                    if (valueObject.getASIGNADO() != null)
                           return(false);
          } else if (!this.ASIGNADO.equals(valueObject.getASIGNADO())) {
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
        out.append("\nclass DetRangoLicencia, mapping to table DET_RANGOLICENCIA\n");
        out.append("Persistent attributes: \n"); 
        out.append("IDDET_RANGOLIC = " + this.IDDET_RANGOLIC + "\n"); 
        out.append("IDRANGO_LIC = " + this.IDRANGO_LIC + "\n"); 
        out.append("NUMESP_VENAL = " + this.NUMESP_VENAL + "\n"); 
        out.append("ASIGNADO = " + this.ASIGNADO + "\n"); 
        return out.toString();
    }


    /**
     * Clone will return identical deep copy of this valueObject.
     * Note, that this method is different than the clone() which
     * is defined in java.lang.Object. Here, the retuned cloned object
     * will also have all its attributes cloned.
     */
    public Object clone() {
        DetRangoLicencia cloned = new DetRangoLicencia();

        cloned.setIDDET_RANGOLIC(this.IDDET_RANGOLIC); 
        cloned.setIDRANGO_LIC(this.IDRANGO_LIC); 
        if (this.NUMESP_VENAL != null)
             cloned.setNUMESP_VENAL(new String(this.NUMESP_VENAL)); 
        if (this.ASIGNADO != null)
             cloned.setASIGNADO(new String(this.ASIGNADO)); 
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