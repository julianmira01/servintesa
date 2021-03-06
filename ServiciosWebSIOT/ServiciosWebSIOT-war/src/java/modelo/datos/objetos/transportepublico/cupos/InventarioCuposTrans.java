package modelo.datos.objetos.transportepublico.cupos;

import java.io.*;
import java.sql.*;
import java.util.*;
import java.math.*;

 /**
  * InventarioCuposTrans Value Object.
  * This class is value object representing database table InventarioCuposTrans
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



public class InventarioCuposTrans implements Cloneable, Serializable {

    /** 
     * Persistent Instance variables. This data is directly 
     * mapped to the columns of database table.
     */
    private int ID_INVENTARIOCUPO;
    private String NROCUPO;
    private String DISPONIBLE;
    private int ID_EMPRESAASIGNADA;
    private int ID_TIPOVEHICULO;



    /** 
     * Constructors. DaoGen generates two constructors by default.
     * The first one takes no arguments and provides the most simple
     * way to create object instance. The another one takes one
     * argument, which is the primary key of the corresponding table.
     */

    public InventarioCuposTrans () {

    }

    public InventarioCuposTrans (int ID_INVENTARIOCUPOIn) {

          this.ID_INVENTARIOCUPO = ID_INVENTARIOCUPOIn;

    }


    /** 
     * Get- and Set-methods for persistent variables. The default
     * behaviour does not make any checks against malformed data,
     * so these might require some manual additions.
     */

    public int getID_INVENTARIOCUPO() {
          return this.ID_INVENTARIOCUPO;
    }
    public void setID_INVENTARIOCUPO(int ID_INVENTARIOCUPOIn) {
          this.ID_INVENTARIOCUPO = ID_INVENTARIOCUPOIn;
    }

    public String getNROCUPO() {
          return this.NROCUPO;
    }
    public void setNROCUPO(String NROCUPOIn) {
          this.NROCUPO = NROCUPOIn;
    }

    public String getDISPONIBLE() {
          return this.DISPONIBLE;
    }
    public void setDISPONIBLE(String DISPONIBLEIn) {
          this.DISPONIBLE = DISPONIBLEIn;
    }

    public int getID_EMPRESAASIGNADA() {
          return this.ID_EMPRESAASIGNADA;
    }
    public void setID_EMPRESAASIGNADA(int ID_EMPRESAASIGNADAIn) {
          this.ID_EMPRESAASIGNADA = ID_EMPRESAASIGNADAIn;
    }

    public int getID_TIPOVEHICULO() {
          return this.ID_TIPOVEHICULO;
    }
    public void setID_TIPOVEHICULO(int ID_TIPOVEHICULOIn) {
          this.ID_TIPOVEHICULO = ID_TIPOVEHICULOIn;
    }



    /** 
     * setAll allows to set all persistent variables in one method call.
     * This is useful, when all data is available and it is needed to 
     * set the initial state of this object. Note that this method will
     * directly modify instance variales, without going trough the 
     * individual set-methods.
     */

    public void setAll(int ID_INVENTARIOCUPOIn,
          String NROCUPOIn,
          String DISPONIBLEIn,
          int ID_EMPRESAASIGNADAIn,
          int ID_TIPOVEHICULOIn) {
          this.ID_INVENTARIOCUPO = ID_INVENTARIOCUPOIn;
          this.NROCUPO = NROCUPOIn;
          this.DISPONIBLE = DISPONIBLEIn;
          this.ID_EMPRESAASIGNADA = ID_EMPRESAASIGNADAIn;
          this.ID_TIPOVEHICULO = ID_TIPOVEHICULOIn;
    }


    /** 
     * hasEqualMapping-method will compare two InventarioCuposTrans instances
     * and return true if they contain same values in all persistent instance 
     * variables. If hasEqualMapping returns true, it does not mean the objects
     * are the same instance. However it does mean that in that moment, they 
     * are mapped to the same row in database.
     */
    public boolean hasEqualMapping(InventarioCuposTrans valueObject) {

          if (valueObject.getID_INVENTARIOCUPO() != this.ID_INVENTARIOCUPO) {
                    return(false);
          }
          if (this.NROCUPO == null) {
                    if (valueObject.getNROCUPO() != null)
                           return(false);
          } else if (!this.NROCUPO.equals(valueObject.getNROCUPO())) {
                    return(false);
          }
          if (this.DISPONIBLE == null) {
                    if (valueObject.getDISPONIBLE() != null)
                           return(false);
          } else if (!this.DISPONIBLE.equals(valueObject.getDISPONIBLE())) {
                    return(false);
          }
          if (valueObject.getID_EMPRESAASIGNADA() != this.ID_EMPRESAASIGNADA) {
                    return(false);
          }
          if (valueObject.getID_TIPOVEHICULO() != this.ID_TIPOVEHICULO) {
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
        out.append("\nclass InventarioCuposTrans, mapping to table InventarioCuposTrans\n");
        out.append("Persistent attributes: \n"); 
        out.append("ID_INVENTARIOCUPO = " + this.ID_INVENTARIOCUPO + "\n"); 
        out.append("NROCUPO = " + this.NROCUPO + "\n"); 
        out.append("DISPONIBLE = " + this.DISPONIBLE + "\n"); 
        out.append("ID_EMPRESAASIGNADA = " + this.ID_EMPRESAASIGNADA + "\n"); 
        out.append("ID_TIPOVEHICULO = " + this.ID_TIPOVEHICULO + "\n"); 
        return out.toString();
    }


    /**
     * Clone will return identical deep copy of this valueObject.
     * Note, that this method is different than the clone() which
     * is defined in java.lang.Object. Here, the retuned cloned object
     * will also have all its attributes cloned.
     */
    public Object clone() {
        InventarioCuposTrans cloned = new InventarioCuposTrans();

        cloned.setID_INVENTARIOCUPO(this.ID_INVENTARIOCUPO); 
        if (this.NROCUPO != null)
             cloned.setNROCUPO(new String(this.NROCUPO)); 
        if (this.DISPONIBLE != null)
             cloned.setDISPONIBLE(new String(this.DISPONIBLE)); 
        cloned.setID_EMPRESAASIGNADA(this.ID_EMPRESAASIGNADA); 
        cloned.setID_TIPOVEHICULO(this.ID_TIPOVEHICULO); 
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