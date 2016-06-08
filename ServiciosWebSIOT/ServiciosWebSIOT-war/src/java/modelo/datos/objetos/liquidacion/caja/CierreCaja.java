package modelo.datos.objetos.liquidacion.caja;

import java.io.*;
import java.sql.*;
import java.util.*;
import java.math.*;

 /**
  * CierreCaja Value Object.
  * This class is value object representing database table CierreCaja
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



public class CierreCaja implements Cloneable, Serializable {

    /** 
     * Persistent Instance variables. This data is directly 
     * mapped to the columns of database table.
     */
    private int IDCIERRE_CAJA;
    private String FECHACIERRE;
    private String HORACIERRE;
    private int ID_USUARIO;
    private String OBSERVACIONES;
    private String FECHAINICIERRE;
    private String FECHAFINCIERRE;
    private String CIERRERUNT;



    /** 
     * Constructors. DaoGen generates two constructors by default.
     * The first one takes no arguments and provides the most simple
     * way to create object instance. The another one takes one
     * argument, which is the primary key of the corresponding table.
     */

    public CierreCaja () {

    }

    public CierreCaja (int IDCIERRE_CAJAIn) {

          this.IDCIERRE_CAJA = IDCIERRE_CAJAIn;

    }


    /** 
     * Get- and Set-methods for persistent variables. The default
     * behaviour does not make any checks against malformed data,
     * so these might require some manual additions.
     */

    public int getIDCIERRE_CAJA() {
          return this.IDCIERRE_CAJA;
    }
    public void setIDCIERRE_CAJA(int IDCIERRE_CAJAIn) {
          this.IDCIERRE_CAJA = IDCIERRE_CAJAIn;
    }

    public String getFECHACIERRE() {
          return this.FECHACIERRE;
    }
    public void setFECHACIERRE(String FECHACIERREIn) {
          this.FECHACIERRE = FECHACIERREIn;
    }

    public String getHORACIERRE() {
          return this.HORACIERRE;
    }
    public void setHORACIERRE(String HORACIERREIn) {
          this.HORACIERRE = HORACIERREIn;
    }

    public int getID_USUARIO() {
          return this.ID_USUARIO;
    }
    public void setID_USUARIO(int ID_USUARIOIn) {
          this.ID_USUARIO = ID_USUARIOIn;
    }

    public String getOBSERVACIONES() {
          return this.OBSERVACIONES;
    }
    public void setOBSERVACIONES(String OBSERVACIONESIn) {
          this.OBSERVACIONES = OBSERVACIONESIn;
    }

    public String getFECHAINICIERRE() {
          return this.FECHAINICIERRE;
    }
    public void setFECHAINICIERRE(String FECHAINICIERREIn) {
          this.FECHAINICIERRE = FECHAINICIERREIn;
    }

    public String getFECHAFINCIERRE() {
          return this.FECHAFINCIERRE;
    }
    public void setFECHAFINCIERRE(String FECHAFINCIERREIn) {
          this.FECHAFINCIERRE = FECHAFINCIERREIn;
    }

    public String getCIERRERUNT() {
          return this.CIERRERUNT;
    }
    public void setCIERRERUNT(String CIERRERUNTIn) {
          this.CIERRERUNT = CIERRERUNTIn;
    }



    /** 
     * setAll allows to set all persistent variables in one method call.
     * This is useful, when all data is available and it is needed to 
     * set the initial state of this object. Note that this method will
     * directly modify instance variales, without going trough the 
     * individual set-methods.
     */

    public void setAll(int IDCIERRE_CAJAIn,
          String FECHACIERREIn,
          String HORACIERREIn,
          int ID_USUARIOIn,
          String OBSERVACIONESIn,
          String FECHAINICIERREIn,
          String FECHAFINCIERREIn,
          String CIERRERUNTIn) {
          this.IDCIERRE_CAJA = IDCIERRE_CAJAIn;
          this.FECHACIERRE = FECHACIERREIn;
          this.HORACIERRE = HORACIERREIn;
          this.ID_USUARIO = ID_USUARIOIn;
          this.OBSERVACIONES = OBSERVACIONESIn;
          this.FECHAINICIERRE = FECHAINICIERREIn;
          this.FECHAFINCIERRE = FECHAFINCIERREIn;
          this.CIERRERUNT = CIERRERUNTIn;
    }


    /** 
     * hasEqualMapping-method will compare two CierreCaja instances
     * and return true if they contain same values in all persistent instance 
     * variables. If hasEqualMapping returns true, it does not mean the objects
     * are the same instance. However it does mean that in that moment, they 
     * are mapped to the same row in database.
     */
    public boolean hasEqualMapping(CierreCaja valueObject) {

          if (valueObject.getIDCIERRE_CAJA() != this.IDCIERRE_CAJA) {
                    return(false);
          }
          if (this.FECHACIERRE == null) {
                    if (valueObject.getFECHACIERRE() != null)
                           return(false);
          } else if (!this.FECHACIERRE.equals(valueObject.getFECHACIERRE())) {
                    return(false);
          }
          if (this.HORACIERRE == null) {
                    if (valueObject.getHORACIERRE() != null)
                           return(false);
          } else if (!this.HORACIERRE.equals(valueObject.getHORACIERRE())) {
                    return(false);
          }
          if (valueObject.getID_USUARIO() != this.ID_USUARIO) {
                    return(false);
          }
          if (this.OBSERVACIONES == null) {
                    if (valueObject.getOBSERVACIONES() != null)
                           return(false);
          } else if (!this.OBSERVACIONES.equals(valueObject.getOBSERVACIONES())) {
                    return(false);
          }
          if (this.FECHAINICIERRE == null) {
                    if (valueObject.getFECHAINICIERRE() != null)
                           return(false);
          } else if (!this.FECHAINICIERRE.equals(valueObject.getFECHAINICIERRE())) {
                    return(false);
          }
          if (this.FECHAFINCIERRE == null) {
                    if (valueObject.getFECHAFINCIERRE() != null)
                           return(false);
          } else if (!this.FECHAFINCIERRE.equals(valueObject.getFECHAFINCIERRE())) {
                    return(false);
          }
          if (this.CIERRERUNT == null) {
                    if (valueObject.getCIERRERUNT() != null)
                           return(false);
          } else if (!this.CIERRERUNT.equals(valueObject.getCIERRERUNT())) {
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
        out.append("\nclass CierreCaja, mapping to table CierreCaja\n");
        out.append("Persistent attributes: \n"); 
        out.append("IDCIERRE_CAJA = " + this.IDCIERRE_CAJA + "\n"); 
        out.append("FECHACIERRE = " + this.FECHACIERRE + "\n"); 
        out.append("HORACIERRE = " + this.HORACIERRE + "\n"); 
        out.append("ID_USUARIO = " + this.ID_USUARIO + "\n"); 
        out.append("OBSERVACIONES = " + this.OBSERVACIONES + "\n"); 
        out.append("FECHAINICIERRE = " + this.FECHAINICIERRE + "\n"); 
        out.append("FECHAFINCIERRE = " + this.FECHAFINCIERRE + "\n"); 
        out.append("CIERRERUNT = " + this.CIERRERUNT + "\n"); 
        return out.toString();
    }


    /**
     * Clone will return identical deep copy of this valueObject.
     * Note, that this method is different than the clone() which
     * is defined in java.lang.Object. Here, the retuned cloned object
     * will also have all its attributes cloned.
     */
    public Object clone() {
        CierreCaja cloned = new CierreCaja();

        cloned.setIDCIERRE_CAJA(this.IDCIERRE_CAJA); 
        if (this.FECHACIERRE != null)
             cloned.setFECHACIERRE(new String(this.FECHACIERRE)); 
        if (this.HORACIERRE != null)
             cloned.setHORACIERRE(new String(this.HORACIERRE)); 
        cloned.setID_USUARIO(this.ID_USUARIO); 
        if (this.OBSERVACIONES != null)
             cloned.setOBSERVACIONES(new String(this.OBSERVACIONES)); 
        if (this.FECHAINICIERRE != null)
             cloned.setFECHAINICIERRE(new String(this.FECHAINICIERRE)); 
        if (this.FECHAFINCIERRE != null)
             cloned.setFECHAFINCIERRE(new String(this.FECHAFINCIERRE)); 
        if (this.CIERRERUNT != null)
             cloned.setCIERRERUNT(new String(this.CIERRERUNT)); 
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
