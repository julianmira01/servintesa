package modelo.datos.objetos.accesorias;

import java.io.*;
import java.sql.*;
import java.util.*;
import java.math.*;

 /**
  * RuntTipoActa Value Object.
  * This class is value object representing database table RUNTTIPO_ACTAREMATE
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



public class RuntTipoActa implements Cloneable, Serializable {

    /** 
     * Persistent Instance variables. This data is directly 
     * mapped to the columns of database table.
     */
    private String CODIGO;
    private String TIPO;



    /** 
     * Constructors. DaoGen generates two constructors by default.
     * The first one takes no arguments and provides the most simple
     * way to create object instance. The another one takes one
     * argument, which is the primary key of the corresponding table.
     */

    public RuntTipoActa () {

    }

    public RuntTipoActa (String CODIGOIn) {

          this.CODIGO = CODIGOIn;

    }


    /** 
     * Get- and Set-methods for persistent variables. The default
     * behaviour does not make any checks against malformed data,
     * so these might require some manual additions.
     */

    public String getCODIGO() {
          return this.CODIGO;
    }
    public void setCODIGO(String CODIGOIn) {
          this.CODIGO = CODIGOIn;
    }

    public String getTIPO() {
          return this.TIPO;
    }
    public void setTIPO(String TIPOIn) {
          this.TIPO = TIPOIn;
    }



    /** 
     * setAll allows to set all persistent variables in one method call.
     * This is useful, when all data is available and it is needed to 
     * set the initial state of this object. Note that this method will
     * directly modify instance variales, without going trough the 
     * individual set-methods.
     */

    public void setAll(String CODIGOIn,
          String TIPOIn) {
          this.CODIGO = CODIGOIn;
          this.TIPO = TIPOIn;
    }


    /** 
     * hasEqualMapping-method will compare two RuntTipoActa instances
     * and return true if they contain same values in all persistent instance 
     * variables. If hasEqualMapping returns true, it does not mean the objects
     * are the same instance. However it does mean that in that moment, they 
     * are mapped to the same row in database.
     */
    public boolean hasEqualMapping(RuntTipoActa valueObject) {

          if (this.CODIGO == null) {
                    if (valueObject.getCODIGO() != null)
                           return(false);
          } else if (!this.CODIGO.equals(valueObject.getCODIGO())) {
                    return(false);
          }
          if (this.TIPO == null) {
                    if (valueObject.getTIPO() != null)
                           return(false);
          } else if (!this.TIPO.equals(valueObject.getTIPO())) {
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
        out.append("\nclass RuntTipoActa, mapping to table RUNTTIPO_ACTAREMATE\n");
        out.append("Persistent attributes: \n"); 
        out.append("CODIGO = " + this.CODIGO + "\n"); 
        out.append("TIPO = " + this.TIPO + "\n"); 
        return out.toString();
    }


    /**
     * Clone will return identical deep copy of this valueObject.
     * Note, that this method is different than the clone() which
     * is defined in java.lang.Object. Here, the retuned cloned object
     * will also have all its attributes cloned.
     */
    public Object clone() {
        RuntTipoActa cloned = new RuntTipoActa();

        if (this.CODIGO != null)
             cloned.setCODIGO(new String(this.CODIGO)); 
        if (this.TIPO != null)
             cloned.setTIPO(new String(this.TIPO)); 
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
