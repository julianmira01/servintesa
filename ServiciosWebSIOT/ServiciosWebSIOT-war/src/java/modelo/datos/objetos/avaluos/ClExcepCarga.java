package modelo.datos.objetos.avaluos;

import java.io.*;
import java.sql.*;
import java.util.*;
import java.math.*;

 /**
  * ClExcepCarga Value Object.
  * This class is value object representing database table CLEXCEPCARGA
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



public class ClExcepCarga implements Cloneable, Serializable {

    /** 
     * Persistent Instance variables. This data is directly 
     * mapped to the columns of database table.
     */
    private int ID_CLEXCEPCARGA;
    private String GRUPO;
    private int VIGENCIA;
    private int ID_MARCA;
    private int ID_LINEA;
    private int CILINDRAJE;
    private String TIPO;



    /** 
     * Constructors. DaoGen generates two constructors by default.
     * The first one takes no arguments and provides the most simple
     * way to create object instance. The another one takes one
     * argument, which is the primary key of the corresponding table.
     */

    public ClExcepCarga () {

    }

    public ClExcepCarga (int ID_CLEXCEPCARGAIn) {

          this.ID_CLEXCEPCARGA = ID_CLEXCEPCARGAIn;

    }


    /** 
     * Get- and Set-methods for persistent variables. The default
     * behaviour does not make any checks against malformed data,
     * so these might require some manual additions.
     */

    public int getID_CLEXCEPCARGA() {
          return this.ID_CLEXCEPCARGA;
    }
    public void setID_CLEXCEPCARGA(int ID_CLEXCEPCARGAIn) {
          this.ID_CLEXCEPCARGA = ID_CLEXCEPCARGAIn;
    }

    public String getGRUPO() {
          return this.GRUPO;
    }
    public void setGRUPO(String GRUPOIn) {
          this.GRUPO = GRUPOIn;
    }

    public int getVIGENCIA() {
          return this.VIGENCIA;
    }
    public void setVIGENCIA(int VIGENCIAIn) {
          this.VIGENCIA = VIGENCIAIn;
    }

    public int getID_MARCA() {
          return this.ID_MARCA;
    }
    public void setID_MARCA(int ID_MARCAIn) {
          this.ID_MARCA = ID_MARCAIn;
    }

    public int getID_LINEA() {
          return this.ID_LINEA;
    }
    public void setID_LINEA(int ID_LINEAIn) {
          this.ID_LINEA = ID_LINEAIn;
    }

    public int getCILINDRAJE() {
          return this.CILINDRAJE;
    }
    public void setCILINDRAJE(int CILINDRAJEIn) {
          this.CILINDRAJE = CILINDRAJEIn;
    }



    /** 
     * setAll allows to set all persistent variables in one method call.
     * This is useful, when all data is available and it is needed to 
     * set the initial state of this object. Note that this method will
     * directly modify instance variales, without going trough the 
     * individual set-methods.
     */

    public void setAll(int ID_CLEXCEPCARGAIn,
          String GRUPOIn,
          int VIGENCIAIn,
          int ID_MARCAIn,
          int ID_LINEAIn,
          int CILINDRAJEIn,
          String TIPOIn) {
          this.ID_CLEXCEPCARGA = ID_CLEXCEPCARGAIn;
          this.GRUPO = GRUPOIn;
          this.VIGENCIA = VIGENCIAIn;
          this.ID_MARCA = ID_MARCAIn;
          this.ID_LINEA = ID_LINEAIn;
          this.CILINDRAJE = CILINDRAJEIn;
          this.TIPO = TIPOIn;
    }


    /** 
     * hasEqualMapping-method will compare two ClExcepCarga instances
     * and return true if they contain same values in all persistent instance 
     * variables. If hasEqualMapping returns true, it does not mean the objects
     * are the same instance. However it does mean that in that moment, they 
     * are mapped to the same row in database.
     */
    public boolean hasEqualMapping(ClExcepCarga valueObject) {

          if (valueObject.getID_CLEXCEPCARGA() != this.ID_CLEXCEPCARGA) {
                    return(false);
          }
          if (this.GRUPO == null) {
                    if (valueObject.getGRUPO() != null)
                           return(false);
          } else if (!this.GRUPO.equals(valueObject.getGRUPO())) {
                    return(false);
          }
          if (valueObject.getVIGENCIA() != this.VIGENCIA) {
                    return(false);
          }
          if (valueObject.getID_MARCA() != this.ID_MARCA) {
                    return(false);
          }
          if (valueObject.getID_LINEA() != this.ID_LINEA) {
                    return(false);
          }
          if (valueObject.getCILINDRAJE() != this.CILINDRAJE) {
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
        out.append("\nclass ClExcepCarga, mapping to table CLEXCEPCARGA\n");
        out.append("Persistent attributes: \n"); 
        out.append("ID_CLEXCEPCARGA = " + this.ID_CLEXCEPCARGA + "\n"); 
        out.append("GRUPO = " + this.GRUPO + "\n"); 
        out.append("VIGENCIA = " + this.VIGENCIA + "\n"); 
        out.append("ID_MARCA = " + this.ID_MARCA + "\n"); 
        out.append("ID_LINEA = " + this.ID_LINEA + "\n"); 
        out.append("CILINDRAJE = " + this.CILINDRAJE + "\n"); 
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
        ClExcepCarga cloned = new ClExcepCarga();

        cloned.setID_CLEXCEPCARGA(this.ID_CLEXCEPCARGA); 
        if (this.GRUPO != null)
             cloned.setGRUPO(new String(this.GRUPO)); 
        cloned.setVIGENCIA(this.VIGENCIA); 
        cloned.setID_MARCA(this.ID_MARCA); 
        cloned.setID_LINEA(this.ID_LINEA); 
        cloned.setCILINDRAJE(this.CILINDRAJE); 
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

    public String getTIPO() {
        return TIPO;
    }

    public void setTIPO(String TIPO) {
        this.TIPO = TIPO;
    }
}