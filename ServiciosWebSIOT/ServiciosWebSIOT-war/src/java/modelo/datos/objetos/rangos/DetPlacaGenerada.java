package modelo.datos.objetos.rangos;


import java.io.*;
import java.sql.*;
import java.util.*;
import java.math.*;

 /**
  * DetPlacaGenerada Value Object.
  * This class is value object representing database table DETPLACAGENERADA
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



public class DetPlacaGenerada implements Cloneable, Serializable {

    /** 
     * Persistent Instance variables. This data is directly 
     * mapped to the columns of database table.
     */
    private int IDDET_PLACAGEN;
    private int IDRANGOPLACA;
    private String PLACAGEN;
    private String ASIGNADA;



    /** 
     * Constructors. DaoGen generates two constructors by default.
     * The first one takes no arguments and provides the most simple
     * way to create object instance. The another one takes one
     * argument, which is the primary key of the corresponding table.
     */

    public DetPlacaGenerada () {

    }

    public DetPlacaGenerada (int IDDET_PLACAGENIn) {

          this.IDDET_PLACAGEN = IDDET_PLACAGENIn;

    }


    /** 
     * Get- and Set-methods for persistent variables. The default
     * behaviour does not make any checks against malformed data,
     * so these might require some manual additions.
     */

    public int getIDDET_PLACAGEN() {
          return this.IDDET_PLACAGEN;
    }
    public void setIDDET_PLACAGEN(int IDDET_PLACAGENIn) {
          this.IDDET_PLACAGEN = IDDET_PLACAGENIn;
    }

    public int getIDRANGOPLACA() {
          return this.IDRANGOPLACA;
    }
    public void setIDRANGOPLACA(int IDRANGOPLACAIn) {
          this.IDRANGOPLACA = IDRANGOPLACAIn;
    }

    public String getPLACAGEN() {
          return this.PLACAGEN;
    }
    public void setPLACAGEN(String PLACAGENIn) {
          this.PLACAGEN = PLACAGENIn;
    }

    public String getASIGNADA() {
          return this.ASIGNADA;
    }
    public void setASIGNADA(String ASIGNADAIn) {
          this.ASIGNADA = ASIGNADAIn;
    }



    /** 
     * setAll allows to set all persistent variables in one method call.
     * This is useful, when all data is available and it is needed to 
     * set the initial state of this object. Note that this method will
     * directly modify instance variales, without going trough the 
     * individual set-methods.
     */

    public void setAll(int IDDET_PLACAGENIn,
          int IDRANGOPLACAIn,
          String PLACAGENIn,
          String ASIGNADAIn) {
          this.IDDET_PLACAGEN = IDDET_PLACAGENIn;
          this.IDRANGOPLACA = IDRANGOPLACAIn;
          this.PLACAGEN = PLACAGENIn;
          this.ASIGNADA = ASIGNADAIn;
    }


    /** 
     * hasEqualMapping-method will compare two DetPlacaGenerada instances
     * and return true if they contain same values in all persistent instance 
     * variables. If hasEqualMapping returns true, it does not mean the objects
     * are the same instance. However it does mean that in that moment, they 
     * are mapped to the same row in database.
     */
    public boolean hasEqualMapping(DetPlacaGenerada valueObject) {

          if (valueObject.getIDDET_PLACAGEN() != this.IDDET_PLACAGEN) {
                    return(false);
          }
          if (valueObject.getIDRANGOPLACA() != this.IDRANGOPLACA) {
                    return(false);
          }
          if (this.PLACAGEN == null) {
                    if (valueObject.getPLACAGEN() != null)
                           return(false);
          } else if (!this.PLACAGEN.equals(valueObject.getPLACAGEN())) {
                    return(false);
          }
          if (this.ASIGNADA == null) {
                    if (valueObject.getASIGNADA() != null)
                           return(false);
          } else if (!this.ASIGNADA.equals(valueObject.getASIGNADA())) {
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
        out.append("\nclass DetPlacaGenerada, mapping to table DETPLACAGENERADA\n");
        out.append("Persistent attributes: \n"); 
        out.append("IDDET_PLACAGEN = " + this.IDDET_PLACAGEN + "\n"); 
        out.append("IDRANGOPLACA = " + this.IDRANGOPLACA + "\n"); 
        out.append("PLACAGEN = " + this.PLACAGEN + "\n"); 
        out.append("ASIGNADA = " + this.ASIGNADA + "\n"); 
        return out.toString();
    }


    /**
     * Clone will return identical deep copy of this valueObject.
     * Note, that this method is different than the clone() which
     * is defined in java.lang.Object. Here, the retuned cloned object
     * will also have all its attributes cloned.
     */
    public Object clone() {
        DetPlacaGenerada cloned = new DetPlacaGenerada();

        cloned.setIDDET_PLACAGEN(this.IDDET_PLACAGEN); 
        cloned.setIDRANGOPLACA(this.IDRANGOPLACA); 
        if (this.PLACAGEN != null)
             cloned.setPLACAGEN(new String(this.PLACAGEN)); 
        if (this.ASIGNADA != null)
             cloned.setASIGNADA(new String(this.ASIGNADA)); 
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
