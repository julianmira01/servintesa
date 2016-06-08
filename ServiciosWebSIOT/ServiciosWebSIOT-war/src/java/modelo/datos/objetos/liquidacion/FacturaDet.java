package modelo.datos.objetos.liquidacion;

import java.io.*;
import java.sql.*;
import java.util.*;
import java.math.*;

 /**
  * FacturaDet Value Object.
  * This class is value object representing database table L_FACTURASDET
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



public class FacturaDet implements Cloneable, Serializable {

    /** 
     * Persistent Instance variables. This data is directly 
     * mapped to the columns of database table.
     */
    private int LFD_ID;
    private String LFD_LF_ID;
    private String LFD_LTD_ID;
    private String LFD_LCC_ID;
    private String LFD_VIGENCIA;
    private String LFD_VALOR;
    private String LFD_DIAS_MORA;
    private String LFD_VALOR_MORA;
    private String LFD_NUMORDTRAMITE;



    /** 
     * Constructors. DaoGen generates two constructors by default.
     * The first one takes no arguments and provides the most simple
     * way to create object instance. The another one takes one
     * argument, which is the primary key of the corresponding table.
     */

    public FacturaDet () {

    }

    public FacturaDet (int LFD_IDIn) {

          this.LFD_ID = LFD_IDIn;

    }


    /** 
     * Get- and Set-methods for persistent variables. The default
     * behaviour does not make any checks against malformed data,
     * so these might require some manual additions.
     */

    public int getLFD_ID() {
          return this.LFD_ID;
    }
    public void setLFD_ID(int LFD_IDIn) {
          this.LFD_ID = LFD_IDIn;
    }

    public String getLFD_LF_ID() {
          return this.LFD_LF_ID;
    }
    public void setLFD_LF_ID(String LFD_LF_IDIn) {
          this.LFD_LF_ID = LFD_LF_IDIn;
    }

    public String getLFD_LTD_ID() {
          return this.LFD_LTD_ID;
    }
    public void setLFD_LTD_ID(String LFD_LTD_IDIn) {
          this.LFD_LTD_ID = LFD_LTD_IDIn;
    }

    public String getLFD_LCC_ID() {
          return this.LFD_LCC_ID;
    }
    public void setLFD_LCC_ID(String LFD_LCC_IDIn) {
          this.LFD_LCC_ID = LFD_LCC_IDIn;
    }

    public String getLFD_VIGENCIA() {
          return this.LFD_VIGENCIA;
    }
    public void setLFD_VIGENCIA(String LFD_VIGENCIAIn) {
          this.LFD_VIGENCIA = LFD_VIGENCIAIn;
    }

    public String getLFD_VALOR() {
          return this.LFD_VALOR;
    }
    public void setLFD_VALOR(String LFD_VALORIn) {
          this.LFD_VALOR = LFD_VALORIn;
    }

    public String getLFD_DIAS_MORA() {
          return this.LFD_DIAS_MORA;
    }
    public void setLFD_DIAS_MORA(String LFD_DIAS_MORAIn) {
          this.LFD_DIAS_MORA = LFD_DIAS_MORAIn;
    }

    public String getLFD_VALOR_MORA() {
          return this.LFD_VALOR_MORA;
    }
    public void setLFD_VALOR_MORA(String LFD_VALOR_MORAIn) {
          this.LFD_VALOR_MORA = LFD_VALOR_MORAIn;
    }

    public String getLFD_NUMORDTRAMITE() {
          return this.LFD_NUMORDTRAMITE;
    }
    public void setLFD_NUMORDTRAMITE(String LFD_NUMORDTRAMITEIn) {
          this.LFD_NUMORDTRAMITE = LFD_NUMORDTRAMITEIn;
    }



    /** 
     * setAll allows to set all persistent variables in one method call.
     * This is useful, when all data is available and it is needed to 
     * set the initial state of this object. Note that this method will
     * directly modify instance variales, without going trough the 
     * individual set-methods.
     */

    public void setAll(int LFD_IDIn,
          String LFD_LF_IDIn,
          String LFD_LTD_IDIn,
          String LFD_LCC_IDIn,
          String LFD_VIGENCIAIn,
          String LFD_VALORIn,
          String LFD_DIAS_MORAIn,
          String LFD_VALOR_MORAIn,
          String LFD_NUMORDTRAMITEIn) {
          this.LFD_ID = LFD_IDIn;
          this.LFD_LF_ID = LFD_LF_IDIn;
          this.LFD_LTD_ID = LFD_LTD_IDIn;
          this.LFD_LCC_ID = LFD_LCC_IDIn;
          this.LFD_VIGENCIA = LFD_VIGENCIAIn;
          this.LFD_VALOR = LFD_VALORIn;
          this.LFD_DIAS_MORA = LFD_DIAS_MORAIn;
          this.LFD_VALOR_MORA = LFD_VALOR_MORAIn;
          this.LFD_NUMORDTRAMITE = LFD_NUMORDTRAMITEIn;
    }


    /** 
     * hasEqualMapping-method will compare two FacturaDet instances
     * and return true if they contain same values in all persistent instance 
     * variables. If hasEqualMapping returns true, it does not mean the objects
     * are the same instance. However it does mean that in that moment, they 
     * are mapped to the same row in database.
     */
    public boolean hasEqualMapping(FacturaDet valueObject) {

          if (valueObject.getLFD_ID() != this.LFD_ID) {
                    return(false);
          }
          if (this.LFD_LF_ID == null) {
                    if (valueObject.getLFD_LF_ID() != null)
                           return(false);
          } else if (!this.LFD_LF_ID.equals(valueObject.getLFD_LF_ID())) {
                    return(false);
          }
          if (this.LFD_LTD_ID == null) {
                    if (valueObject.getLFD_LTD_ID() != null)
                           return(false);
          } else if (!this.LFD_LTD_ID.equals(valueObject.getLFD_LTD_ID())) {
                    return(false);
          }
          if (this.LFD_LCC_ID == null) {
                    if (valueObject.getLFD_LCC_ID() != null)
                           return(false);
          } else if (!this.LFD_LCC_ID.equals(valueObject.getLFD_LCC_ID())) {
                    return(false);
          }
          if (this.LFD_VIGENCIA == null) {
                    if (valueObject.getLFD_VIGENCIA() != null)
                           return(false);
          } else if (!this.LFD_VIGENCIA.equals(valueObject.getLFD_VIGENCIA())) {
                    return(false);
          }
          if (this.LFD_VALOR == null) {
                    if (valueObject.getLFD_VALOR() != null)
                           return(false);
          } else if (!this.LFD_VALOR.equals(valueObject.getLFD_VALOR())) {
                    return(false);
          }
          if (this.LFD_DIAS_MORA == null) {
                    if (valueObject.getLFD_DIAS_MORA() != null)
                           return(false);
          } else if (!this.LFD_DIAS_MORA.equals(valueObject.getLFD_DIAS_MORA())) {
                    return(false);
          }
          if (this.LFD_VALOR_MORA == null) {
                    if (valueObject.getLFD_VALOR_MORA() != null)
                           return(false);
          } else if (!this.LFD_VALOR_MORA.equals(valueObject.getLFD_VALOR_MORA())) {
                    return(false);
          }
          if (this.LFD_NUMORDTRAMITE == null) {
                    if (valueObject.getLFD_NUMORDTRAMITE() != null)
                           return(false);
          } else if (!this.LFD_NUMORDTRAMITE.equals(valueObject.getLFD_NUMORDTRAMITE())) {
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
        out.append("\nclass FacturaDet, mapping to table L_FACTURASDET\n");
        out.append("Persistent attributes: \n"); 
        out.append("LFD_ID = " + this.LFD_ID + "\n"); 
        out.append("LFD_LF_ID = " + this.LFD_LF_ID + "\n"); 
        out.append("LFD_LTD_ID = " + this.LFD_LTD_ID + "\n"); 
        out.append("LFD_LCC_ID = " + this.LFD_LCC_ID + "\n"); 
        out.append("LFD_VIGENCIA = " + this.LFD_VIGENCIA + "\n"); 
        out.append("LFD_VALOR = " + this.LFD_VALOR + "\n"); 
        out.append("LFD_DIAS_MORA = " + this.LFD_DIAS_MORA + "\n"); 
        out.append("LFD_VALOR_MORA = " + this.LFD_VALOR_MORA + "\n"); 
        out.append("LFD_NUMORDTRAMITE = " + this.LFD_NUMORDTRAMITE + "\n"); 
        return out.toString();
    }


    /**
     * Clone will return identical deep copy of this valueObject.
     * Note, that this method is different than the clone() which
     * is defined in java.lang.Object. Here, the retuned cloned object
     * will also have all its attributes cloned.
     */
    public Object clone() {
        FacturaDet cloned = new FacturaDet();

        cloned.setLFD_ID(this.LFD_ID); 
        if (this.LFD_LF_ID != null)
             cloned.setLFD_LF_ID(new String(this.LFD_LF_ID)); 
        if (this.LFD_LTD_ID != null)
             cloned.setLFD_LTD_ID(new String(this.LFD_LTD_ID)); 
        if (this.LFD_LCC_ID != null)
             cloned.setLFD_LCC_ID(new String(this.LFD_LCC_ID)); 
        if (this.LFD_VIGENCIA != null)
             cloned.setLFD_VIGENCIA(new String(this.LFD_VIGENCIA)); 
        if (this.LFD_VALOR != null)
             cloned.setLFD_VALOR(new String(this.LFD_VALOR)); 
        if (this.LFD_DIAS_MORA != null)
             cloned.setLFD_DIAS_MORA(new String(this.LFD_DIAS_MORA)); 
        if (this.LFD_VALOR_MORA != null)
             cloned.setLFD_VALOR_MORA(new String(this.LFD_VALOR_MORA)); 
        if (this.LFD_NUMORDTRAMITE != null)
             cloned.setLFD_NUMORDTRAMITE(new String(this.LFD_NUMORDTRAMITE)); 
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

