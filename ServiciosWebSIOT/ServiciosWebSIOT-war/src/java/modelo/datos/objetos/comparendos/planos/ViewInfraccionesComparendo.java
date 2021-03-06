package modelo.datos.objetos.comparendos.planos;

import java.io.*;
import java.sql.*;
import java.util.*;
import java.math.*;

 /**
  * ViewInfraccionesComparendo Value Object.
  * This class is value object representing database table VIEW_INFRACCIONES_COMPARENDO
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



public class ViewInfraccionesComparendo implements Cloneable, Serializable {

    /** 
     * Persistent Instance variables. This data is directly 
     * mapped to the columns of database table.
     */
    private String COD_INFRACCION;
    private String NUEVO_CODIGO;
    private String VALORINFRACCION;
    private String IDCOMPARENDO;



    /** 
     * Constructors. DaoGen generates two constructors by default.
     * The first one takes no arguments and provides the most simple
     * way to create object instance. The another one takes one
     * argument, which is the primary key of the corresponding table.
     */

    public ViewInfraccionesComparendo () {

    }

    public ViewInfraccionesComparendo (String COD_INFRACCIONIn) {

          this.COD_INFRACCION = COD_INFRACCIONIn;

    }


    /** 
     * Get- and Set-methods for persistent variables. The default
     * behaviour does not make any checks against malformed data,
     * so these might require some manual additions.
     */

    public String getCOD_INFRACCION() {
          return this.COD_INFRACCION;
    }
    public void setCOD_INFRACCION(String COD_INFRACCIONIn) {
          this.COD_INFRACCION = COD_INFRACCIONIn;
    }

    public String getNUEVO_CODIGO() {
          return this.NUEVO_CODIGO;
    }
    public void setNUEVO_CODIGO(String NUEVO_CODIGOIn) {
          this.NUEVO_CODIGO = NUEVO_CODIGOIn;
    }

    public String getVALORINFRACCION() {
          return this.VALORINFRACCION;
    }
    public void setVALORINFRACCION(String VALORINFRACCIONIn) {
          this.VALORINFRACCION = VALORINFRACCIONIn;
    }

    public String getIDCOMPARENDO() {
          return this.IDCOMPARENDO;
    }
    public void setIDCOMPARENDO(String IDCOMPARENDOIn) {
          this.IDCOMPARENDO = IDCOMPARENDOIn;
    }



    /** 
     * setAll allows to set all persistent variables in one method call.
     * This is useful, when all data is available and it is needed to 
     * set the initial state of this object. Note that this method will
     * directly modify instance variales, without going trough the 
     * individual set-methods.
     */

    public void setAll(String COD_INFRACCIONIn,
          String NUEVO_CODIGOIn,
          String VALORINFRACCIONIn,
          String IDCOMPARENDOIn) {
          this.COD_INFRACCION = COD_INFRACCIONIn;
          this.NUEVO_CODIGO = NUEVO_CODIGOIn;
          this.VALORINFRACCION = VALORINFRACCIONIn;
          this.IDCOMPARENDO = IDCOMPARENDOIn;
    }


    /** 
     * hasEqualMapping-method will compare two ViewInfraccionesComparendo instances
     * and return true if they contain same values in all persistent instance 
     * variables. If hasEqualMapping returns true, it does not mean the objects
     * are the same instance. However it does mean that in that moment, they 
     * are mapped to the same row in database.
     */
    public boolean hasEqualMapping(ViewInfraccionesComparendo valueObject) {

          if (this.COD_INFRACCION == null) {
                    if (valueObject.getCOD_INFRACCION() != null)
                           return(false);
          } else if (!this.COD_INFRACCION.equals(valueObject.getCOD_INFRACCION())) {
                    return(false);
          }
          if (this.NUEVO_CODIGO == null) {
                    if (valueObject.getNUEVO_CODIGO() != null)
                           return(false);
          } else if (!this.NUEVO_CODIGO.equals(valueObject.getNUEVO_CODIGO())) {
                    return(false);
          }
          if (this.VALORINFRACCION == null) {
                    if (valueObject.getVALORINFRACCION() != null)
                           return(false);
          } else if (!this.VALORINFRACCION.equals(valueObject.getVALORINFRACCION())) {
                    return(false);
          }
          if (this.IDCOMPARENDO == null) {
                    if (valueObject.getIDCOMPARENDO() != null)
                           return(false);
          } else if (!this.IDCOMPARENDO.equals(valueObject.getIDCOMPARENDO())) {
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
        out.append("\nclass ViewInfraccionesComparendo, mapping to table VIEW_INFRACCIONES_COMPARENDO\n");
        out.append("Persistent attributes: \n"); 
        out.append("COD_INFRACCION = " + this.COD_INFRACCION + "\n"); 
        out.append("NUEVO_CODIGO = " + this.NUEVO_CODIGO + "\n"); 
        out.append("VALORINFRACCION = " + this.VALORINFRACCION + "\n"); 
        out.append("IDCOMPARENDO = " + this.IDCOMPARENDO + "\n"); 
        return out.toString();
    }


    /**
     * Clone will return identical deep copy of this valueObject.
     * Note, that this method is different than the clone() which
     * is defined in java.lang.Object. Here, the retuned cloned object
     * will also have all its attributes cloned.
     */
    public Object clone() {
        ViewInfraccionesComparendo cloned = new ViewInfraccionesComparendo();

        if (this.COD_INFRACCION != null)
             cloned.setCOD_INFRACCION(new String(this.COD_INFRACCION)); 
        if (this.NUEVO_CODIGO != null)
             cloned.setNUEVO_CODIGO(new String(this.NUEVO_CODIGO)); 
        if (this.VALORINFRACCION != null)
             cloned.setVALORINFRACCION(new String(this.VALORINFRACCION)); 
        if (this.IDCOMPARENDO != null)
             cloned.setIDCOMPARENDO(new String(this.IDCOMPARENDO)); 
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