package modelo.datos.objetos.tramites;

import java.io.*;
import java.sql.*;
import java.util.*;
import java.math.*;

 /**
  * TipoTraspaso Value Object.
  * This class is value object representing database table TipoTraspaso
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



public class TipoTraspaso implements Cloneable, Serializable {

    /** 
     * Persistent Instance variables. This data is directly 
     * mapped to the columns of database table.
     */
    private int ID_TIPOTRASPASO;
    private String COD_TIPOTRASPASO;
    private String DES_TIPOTRASPASO;



    /** 
     * Constructors. DaoGen generates two constructors by default.
     * The first one takes no arguments and provides the most simple
     * way to create object instance. The another one takes one
     * argument, which is the primary key of the corresponding table.
     */

    public TipoTraspaso () {

    }

    public TipoTraspaso (int ID_TIPOTRASPASOIn) {

          this.ID_TIPOTRASPASO = ID_TIPOTRASPASOIn;

    }


    /** 
     * Get- and Set-methods for persistent variables. The default
     * behaviour does not make any checks against malformed data,
     * so these might require some manual additions.
     */

    public int getID_TIPOTRASPASO() {
          return this.ID_TIPOTRASPASO;
    }
    public void setID_TIPOTRASPASO(int ID_TIPOTRASPASOIn) {
          this.ID_TIPOTRASPASO = ID_TIPOTRASPASOIn;
    }

    public String getCOD_TIPOTRASPASO() {
          return this.COD_TIPOTRASPASO;
    }
    public void setCOD_TIPOTRASPASO(String COD_TIPOTRASPASOIn) {
          this.COD_TIPOTRASPASO = COD_TIPOTRASPASOIn;
    }

    public String getDES_TIPOTRASPASO() {
          return this.DES_TIPOTRASPASO;
    }
    public void setDES_TIPOTRASPASO(String DES_TIPOTRASPASOIn) {
          this.DES_TIPOTRASPASO = DES_TIPOTRASPASOIn;
    }



    /** 
     * setAll allows to set all persistent variables in one method call.
     * This is useful, when all data is available and it is needed to 
     * set the initial state of this object. Note that this method will
     * directly modify instance variales, without going trough the 
     * individual set-methods.
     */

    public void setAll(int ID_TIPOTRASPASOIn,
          String COD_TIPOTRASPASOIn,
          String DES_TIPOTRASPASOIn) {
          this.ID_TIPOTRASPASO = ID_TIPOTRASPASOIn;
          this.COD_TIPOTRASPASO = COD_TIPOTRASPASOIn;
          this.DES_TIPOTRASPASO = DES_TIPOTRASPASOIn;
    }


    /** 
     * hasEqualMapping-method will compare two TipoTraspaso instances
     * and return true if they contain same values in all persistent instance 
     * variables. If hasEqualMapping returns true, it does not mean the objects
     * are the same instance. However it does mean that in that moment, they 
     * are mapped to the same row in database.
     */
    public boolean hasEqualMapping(TipoTraspaso valueObject) {

          if (valueObject.getID_TIPOTRASPASO() != this.ID_TIPOTRASPASO) {
                    return(false);
          }
          if (this.COD_TIPOTRASPASO == null) {
                    if (valueObject.getCOD_TIPOTRASPASO() != null)
                           return(false);
          } else if (!this.COD_TIPOTRASPASO.equals(valueObject.getCOD_TIPOTRASPASO())) {
                    return(false);
          }
          if (this.DES_TIPOTRASPASO == null) {
                    if (valueObject.getDES_TIPOTRASPASO() != null)
                           return(false);
          } else if (!this.DES_TIPOTRASPASO.equals(valueObject.getDES_TIPOTRASPASO())) {
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
        out.append("\nclass TipoTraspaso, mapping to table TipoTraspaso\n");
        out.append("Persistent attributes: \n"); 
        out.append("ID_TIPOTRASPASO = " + this.ID_TIPOTRASPASO + "\n"); 
        out.append("COD_TIPOTRASPASO = " + this.COD_TIPOTRASPASO + "\n"); 
        out.append("DES_TIPOTRASPASO = " + this.DES_TIPOTRASPASO + "\n"); 
        return out.toString();
    }


    /**
     * Clone will return identical deep copy of this valueObject.
     * Note, that this method is different than the clone() which
     * is defined in java.lang.Object. Here, the retuned cloned object
     * will also have all its attributes cloned.
     */
    public Object clone() {
        TipoTraspaso cloned = new TipoTraspaso();

        cloned.setID_TIPOTRASPASO(this.ID_TIPOTRASPASO); 
        if (this.COD_TIPOTRASPASO != null)
             cloned.setCOD_TIPOTRASPASO(new String(this.COD_TIPOTRASPASO)); 
        if (this.DES_TIPOTRASPASO != null)
             cloned.setDES_TIPOTRASPASO(new String(this.DES_TIPOTRASPASO)); 
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
