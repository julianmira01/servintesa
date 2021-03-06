package modelo.datos.objetos.accesorias;

import java.io.*;
import java.sql.*;
import java.util.*;
import java.math.*;

 /**
  * RuntGrupo Value Object.
  * This class is value object representing database table RUNTGRUPO
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



public class RuntGrupo implements Cloneable, Serializable {

    /** 
     * Persistent Instance variables. This data is directly 
     * mapped to the columns of database table.
     */
    private int ID_RUNTGRUPO;
    private String CODGRUPO;
    private String DESCRIPCION;



    /** 
     * Constructors. DaoGen generates two constructors by default.
     * The first one takes no arguments and provides the most simple
     * way to create object instance. The another one takes one
     * argument, which is the primary key of the corresponding table.
     */

    public RuntGrupo () {

    }

    public RuntGrupo (int ID_RUNTGRUPOIn) {

          this.ID_RUNTGRUPO = ID_RUNTGRUPOIn;

    }


    /** 
     * Get- and Set-methods for persistent variables. The default
     * behaviour does not make any checks against malformed data,
     * so these might require some manual additions.
     */

    public int getID_RUNTGRUPO() {
          return this.ID_RUNTGRUPO;
    }
    public void setID_RUNTGRUPO(int ID_RUNTGRUPOIn) {
          this.ID_RUNTGRUPO = ID_RUNTGRUPOIn;
    }

    public String getCODGRUPO() {
          return this.CODGRUPO;
    }
    public void setCODGRUPO(String CODGRUPOIn) {
          this.CODGRUPO = CODGRUPOIn;
    }

    public String getDESCRIPCION() {
          return this.DESCRIPCION;
    }
    public void setDESCRIPCION(String DESCRIPCIONIn) {
          this.DESCRIPCION = DESCRIPCIONIn;
    }



    /** 
     * setAll allows to set all persistent variables in one method call.
     * This is useful, when all data is available and it is needed to 
     * set the initial state of this object. Note that this method will
     * directly modify instance variales, without going trough the 
     * individual set-methods.
     */

    public void setAll(int ID_RUNTGRUPOIn,
          String CODGRUPOIn,
          String DESCRIPCIONIn) {
          this.ID_RUNTGRUPO = ID_RUNTGRUPOIn;
          this.CODGRUPO = CODGRUPOIn;
          this.DESCRIPCION = DESCRIPCIONIn;
    }


    /** 
     * hasEqualMapping-method will compare two RuntGrupo instances
     * and return true if they contain same values in all persistent instance 
     * variables. If hasEqualMapping returns true, it does not mean the objects
     * are the same instance. However it does mean that in that moment, they 
     * are mapped to the same row in database.
     */
    public boolean hasEqualMapping(RuntGrupo valueObject) {

          if (valueObject.getID_RUNTGRUPO() != this.ID_RUNTGRUPO) {
                    return(false);
          }
          if (this.CODGRUPO == null) {
                    if (valueObject.getCODGRUPO() != null)
                           return(false);
          } else if (!this.CODGRUPO.equals(valueObject.getCODGRUPO())) {
                    return(false);
          }
          if (this.DESCRIPCION == null) {
                    if (valueObject.getDESCRIPCION() != null)
                           return(false);
          } else if (!this.DESCRIPCION.equals(valueObject.getDESCRIPCION())) {
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
        out.append("\nclass RuntGrupo, mapping to table RUNTGRUPO\n");
        out.append("Persistent attributes: \n"); 
        out.append("ID_RUNTGRUPO = " + this.ID_RUNTGRUPO + "\n"); 
        out.append("CODGRUPO = " + this.CODGRUPO + "\n"); 
        out.append("DESCRIPCION = " + this.DESCRIPCION + "\n"); 
        return out.toString();
    }


    /**
     * Clone will return identical deep copy of this valueObject.
     * Note, that this method is different than the clone() which
     * is defined in java.lang.Object. Here, the retuned cloned object
     * will also have all its attributes cloned.
     */
    public Object clone() {
        RuntGrupo cloned = new RuntGrupo();

        cloned.setID_RUNTGRUPO(this.ID_RUNTGRUPO); 
        if (this.CODGRUPO != null)
             cloned.setCODGRUPO(new String(this.CODGRUPO)); 
        if (this.DESCRIPCION != null)
             cloned.setDESCRIPCION(new String(this.DESCRIPCION)); 
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
