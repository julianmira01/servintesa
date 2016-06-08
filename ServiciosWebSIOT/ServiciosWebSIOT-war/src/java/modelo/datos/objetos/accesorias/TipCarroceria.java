package modelo.datos.objetos.accesorias;

import java.io.*;
import java.sql.*;
import java.util.*;
import java.math.*;

 /**
  * TipCarroceria Value Object.
  * This class is value object representing database table TIPCARROCERIA
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



public class TipCarroceria implements Cloneable, Serializable {

    /** 
     * Persistent Instance variables. This data is directly 
     * mapped to the columns of database table.
     */
    private int ID_TCARROCERIA;
    private String DESCRIPCION;
    private String ID_CARROCERIAMIN;
    private String ID_TCARROCERIARUNT;



    /** 
     * Constructors. DaoGen generates two constructors by default.
     * The first one takes no arguments and provides the most simple
     * way to create object instance. The another one takes one
     * argument, which is the primary key of the corresponding table.
     */

    public TipCarroceria () {

    }

    public TipCarroceria (int ID_TCARROCERIAIn) {

          this.ID_TCARROCERIA = ID_TCARROCERIAIn;

    }


    /** 
     * Get- and Set-methods for persistent variables. The default
     * behaviour does not make any checks against malformed data,
     * so these might require some manual additions.
     */

    public int getID_TCARROCERIA() {
          return this.ID_TCARROCERIA;
    }
    public void setID_TCARROCERIA(int ID_TCARROCERIAIn) {
          this.ID_TCARROCERIA = ID_TCARROCERIAIn;
    }

    public String getDESCRIPCION() {
          return this.DESCRIPCION;
    }
    public void setDESCRIPCION(String DESCRIPCIONIn) {
          this.DESCRIPCION = DESCRIPCIONIn;
    }

    public String getID_CARROCERIAMIN() {
          return this.ID_CARROCERIAMIN;
    }
    public void setID_CARROCERIAMIN(String ID_CARROCERIAMINIn) {
          this.ID_CARROCERIAMIN = ID_CARROCERIAMINIn;
    }

    public String getID_TCARROCERIARUNT() {
          return this.ID_TCARROCERIARUNT;
    }
    public void setID_TCARROCERIARUNT(String ID_TCARROCERIARUNTIn) {
          this.ID_TCARROCERIARUNT = ID_TCARROCERIARUNTIn;
    }



    /** 
     * setAll allows to set all persistent variables in one method call.
     * This is useful, when all data is available and it is needed to 
     * set the initial state of this object. Note that this method will
     * directly modify instance variales, without going trough the 
     * individual set-methods.
     */

    public void setAll(int ID_TCARROCERIAIn,
          String DESCRIPCIONIn,
          String ID_CARROCERIAMINIn,
          String ID_TCARROCERIARUNTIn) {
          this.ID_TCARROCERIA = ID_TCARROCERIAIn;
          this.DESCRIPCION = DESCRIPCIONIn;
          this.ID_CARROCERIAMIN = ID_CARROCERIAMINIn;
          this.ID_TCARROCERIARUNT = ID_TCARROCERIARUNTIn;
    }


    /** 
     * hasEqualMapping-method will compare two TipCarroceria instances
     * and return true if they contain same values in all persistent instance 
     * variables. If hasEqualMapping returns true, it does not mean the objects
     * are the same instance. However it does mean that in that moment, they 
     * are mapped to the same row in database.
     */
    public boolean hasEqualMapping(TipCarroceria valueObject) {

          if (valueObject.getID_TCARROCERIA() != this.ID_TCARROCERIA) {
                    return(false);
          }
          if (this.DESCRIPCION == null) {
                    if (valueObject.getDESCRIPCION() != null)
                           return(false);
          } else if (!this.DESCRIPCION.equals(valueObject.getDESCRIPCION())) {
                    return(false);
          }
          if (this.ID_CARROCERIAMIN == null) {
                    if (valueObject.getID_CARROCERIAMIN() != null)
                           return(false);
          } else if (!this.ID_CARROCERIAMIN.equals(valueObject.getID_CARROCERIAMIN())) {
                    return(false);
          }
          if (this.ID_TCARROCERIARUNT == null) {
                    if (valueObject.getID_TCARROCERIARUNT() != null)
                           return(false);
          } else if (!this.ID_TCARROCERIARUNT.equals(valueObject.getID_TCARROCERIARUNT())) {
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
        out.append("\nclass TipCarroceria, mapping to table TIPCARROCERIA\n");
        out.append("Persistent attributes: \n"); 
        out.append("ID_TCARROCERIA = " + this.ID_TCARROCERIA + "\n"); 
        out.append("DESCRIPCION = " + this.DESCRIPCION + "\n"); 
        out.append("ID_CARROCERIAMIN = " + this.ID_CARROCERIAMIN + "\n"); 
        out.append("ID_TCARROCERIARUNT = " + this.ID_TCARROCERIARUNT + "\n"); 
        return out.toString();
    }


    /**
     * Clone will return identical deep copy of this valueObject.
     * Note, that this method is different than the clone() which
     * is defined in java.lang.Object. Here, the retuned cloned object
     * will also have all its attributes cloned.
     */
    public Object clone() {
        TipCarroceria cloned = new TipCarroceria();

        cloned.setID_TCARROCERIA(this.ID_TCARROCERIA); 
        if (this.DESCRIPCION != null)
             cloned.setDESCRIPCION(new String(this.DESCRIPCION)); 
        if (this.ID_CARROCERIAMIN != null)
             cloned.setID_CARROCERIAMIN(new String(this.ID_CARROCERIAMIN)); 
        if (this.ID_TCARROCERIARUNT != null)
             cloned.setID_TCARROCERIARUNT(new String(this.ID_TCARROCERIARUNT)); 
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