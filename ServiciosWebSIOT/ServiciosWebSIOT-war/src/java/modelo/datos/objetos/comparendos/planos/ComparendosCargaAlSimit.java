package modelo.datos.objetos.comparendos.planos;

import java.io.*;
import java.sql.*;
import java.util.*;
import java.math.*;

 /**
  * ComparendosCargaAlSimit Value Object.
  * This class is value object representing database table COMPARENDOS_CARGAALSIMIT
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



public class ComparendosCargaAlSimit implements Cloneable, Serializable {

    /** 
     * Persistent Instance variables. This data is directly 
     * mapped to the columns of database table.
     */
    private int ID_COMPARENDOCARGA;
    private int ID_COMPARENDO;
    private String NROCOMPARENDO;
    private int ID_PLANOSSIMIT;
    private String REPORTADO_A_SIMIT;
    private String SUBIDO_A_SIMIT;



    /** 
     * Constructors. DaoGen generates two constructors by default.
     * The first one takes no arguments and provides the most simple
     * way to create object instance. The another one takes one
     * argument, which is the primary key of the corresponding table.
     */

    public ComparendosCargaAlSimit () {

    }

    public ComparendosCargaAlSimit (int ID_COMPARENDOCARGAIn) {

          this.ID_COMPARENDOCARGA = ID_COMPARENDOCARGAIn;

    }


    /** 
     * Get- and Set-methods for persistent variables. The default
     * behaviour does not make any checks against malformed data,
     * so these might require some manual additions.
     */

    public int getID_COMPARENDOCARGA() {
          return this.ID_COMPARENDOCARGA;
    }
    public void setID_COMPARENDOCARGA(int ID_COMPARENDOCARGAIn) {
          this.ID_COMPARENDOCARGA = ID_COMPARENDOCARGAIn;
    }

    public int getID_COMPARENDO() {
          return this.ID_COMPARENDO;
    }
    public void setID_COMPARENDO(int ID_COMPARENDOIn) {
          this.ID_COMPARENDO = ID_COMPARENDOIn;
    }

    public String getNROCOMPARENDO() {
          return this.NROCOMPARENDO;
    }
    public void setNROCOMPARENDO(String NROCOMPARENDOIn) {
          this.NROCOMPARENDO = NROCOMPARENDOIn;
    }

    public int getID_PLANOSSIMIT() {
          return this.ID_PLANOSSIMIT;
    }
    public void setID_PLANOSSIMIT(int ID_PLANOSSIMITIn) {
          this.ID_PLANOSSIMIT = ID_PLANOSSIMITIn;
    }

    public String getREPORTADO_A_SIMIT() {
          return this.REPORTADO_A_SIMIT;
    }
    public void setREPORTADO_A_SIMIT(String REPORTADO_A_SIMITIn) {
          this.REPORTADO_A_SIMIT = REPORTADO_A_SIMITIn;
    }

    public String getSUBIDO_A_SIMIT() {
          return this.SUBIDO_A_SIMIT;
    }
    public void setSUBIDO_A_SIMIT(String SUBIDO_A_SIMITIn) {
          this.SUBIDO_A_SIMIT = SUBIDO_A_SIMITIn;
    }



    /** 
     * setAll allows to set all persistent variables in one method call.
     * This is useful, when all data is available and it is needed to 
     * set the initial state of this object. Note that this method will
     * directly modify instance variales, without going trough the 
     * individual set-methods.
     */

    public void setAll(int ID_COMPARENDOCARGAIn,
          int ID_COMPARENDOIn,
          String NROCOMPARENDOIn,
          int ID_PLANOSSIMITIn,
          String REPORTADO_A_SIMITIn,
          String SUBIDO_A_SIMITIn) {
          this.ID_COMPARENDOCARGA = ID_COMPARENDOCARGAIn;
          this.ID_COMPARENDO = ID_COMPARENDOIn;
          this.NROCOMPARENDO = NROCOMPARENDOIn;
          this.ID_PLANOSSIMIT = ID_PLANOSSIMITIn;
          this.REPORTADO_A_SIMIT = REPORTADO_A_SIMITIn;
          this.SUBIDO_A_SIMIT = SUBIDO_A_SIMITIn;
    }


    /** 
     * hasEqualMapping-method will compare two ComparendosCargaAlSimit instances
     * and return true if they contain same values in all persistent instance 
     * variables. If hasEqualMapping returns true, it does not mean the objects
     * are the same instance. However it does mean that in that moment, they 
     * are mapped to the same row in database.
     */
    public boolean hasEqualMapping(ComparendosCargaAlSimit valueObject) {

          if (valueObject.getID_COMPARENDOCARGA() != this.ID_COMPARENDOCARGA) {
                    return(false);
          }
          if (valueObject.getID_COMPARENDO() != this.ID_COMPARENDO) {
                    return(false);
          }
          if (this.NROCOMPARENDO == null) {
                    if (valueObject.getNROCOMPARENDO() != null)
                           return(false);
          } else if (!this.NROCOMPARENDO.equals(valueObject.getNROCOMPARENDO())) {
                    return(false);
          }
          if (valueObject.getID_PLANOSSIMIT() != this.ID_PLANOSSIMIT) {
                    return(false);
          }
          if (this.REPORTADO_A_SIMIT == null) {
                    if (valueObject.getREPORTADO_A_SIMIT() != null)
                           return(false);
          } else if (!this.REPORTADO_A_SIMIT.equals(valueObject.getREPORTADO_A_SIMIT())) {
                    return(false);
          }
          if (this.SUBIDO_A_SIMIT == null) {
                    if (valueObject.getSUBIDO_A_SIMIT() != null)
                           return(false);
          } else if (!this.SUBIDO_A_SIMIT.equals(valueObject.getSUBIDO_A_SIMIT())) {
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
        out.append("\nclass ComparendosCargaAlSimit, mapping to table COMPARENDOS_CARGAALSIMIT\n");
        out.append("Persistent attributes: \n"); 
        out.append("ID_COMPARENDOCARGA = " + this.ID_COMPARENDOCARGA + "\n"); 
        out.append("ID_COMPARENDO = " + this.ID_COMPARENDO + "\n"); 
        out.append("NROCOMPARENDO = " + this.NROCOMPARENDO + "\n"); 
        out.append("ID_PLANOSSIMIT = " + this.ID_PLANOSSIMIT + "\n"); 
        out.append("REPORTADO_A_SIMIT = " + this.REPORTADO_A_SIMIT + "\n"); 
        out.append("SUBIDO_A_SIMIT = " + this.SUBIDO_A_SIMIT + "\n"); 
        return out.toString();
    }


    /**
     * Clone will return identical deep copy of this valueObject.
     * Note, that this method is different than the clone() which
     * is defined in java.lang.Object. Here, the retuned cloned object
     * will also have all its attributes cloned.
     */
    public Object clone() {
        ComparendosCargaAlSimit cloned = new ComparendosCargaAlSimit();

        cloned.setID_COMPARENDOCARGA(this.ID_COMPARENDOCARGA); 
        cloned.setID_COMPARENDO(this.ID_COMPARENDO); 
        if (this.NROCOMPARENDO != null)
             cloned.setNROCOMPARENDO(new String(this.NROCOMPARENDO)); 
        cloned.setID_PLANOSSIMIT(this.ID_PLANOSSIMIT); 
        if (this.REPORTADO_A_SIMIT != null)
             cloned.setREPORTADO_A_SIMIT(new String(this.REPORTADO_A_SIMIT)); 
        if (this.SUBIDO_A_SIMIT != null)
             cloned.setSUBIDO_A_SIMIT(new String(this.SUBIDO_A_SIMIT)); 
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