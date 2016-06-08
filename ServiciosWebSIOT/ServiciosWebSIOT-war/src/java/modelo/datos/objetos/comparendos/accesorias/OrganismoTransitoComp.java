package modelo.datos.objetos.comparendos.accesorias;

import java.io.*;
import java.sql.*;
import java.util.*;
import java.math.*;

 /**
  * OrganismoTransitoComp Value Object.
  * This class is value object representing database table ORGANISMOTRANSITO
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



public class OrganismoTransitoComp implements Cloneable, Serializable {

    /** 
     * Persistent Instance variables. This data is directly 
     * mapped to the columns of database table.
     */
    private int IDORGTRANSITO;
    private String NIT;
    private String NOMBRESECRETARIA;
    private String DIRECCION;
    private String TELEFONO;
    private int IDDEPARTAMENTO;
    private String ID_MUNICIPIO;



    /** 
     * Constructors. DaoGen generates two constructors by default.
     * The first one takes no arguments and provides the most simple
     * way to create object instance. The another one takes one
     * argument, which is the primary key of the corresponding table.
     */

    public OrganismoTransitoComp () {

    }

    public OrganismoTransitoComp (int IDORGTRANSITOIn) {

          this.IDORGTRANSITO = IDORGTRANSITOIn;

    }


    /** 
     * Get- and Set-methods for persistent variables. The default
     * behaviour does not make any checks against malformed data,
     * so these might require some manual additions.
     */

    public int getIDORGTRANSITO() {
          return this.IDORGTRANSITO;
    }
    public void setIDORGTRANSITO(int IDORGTRANSITOIn) {
          this.IDORGTRANSITO = IDORGTRANSITOIn;
    }

    public String getNIT() {
          return this.NIT;
    }
    public void setNIT(String NITIn) {
          this.NIT = NITIn;
    }

    public String getNOMBRESECRETARIA() {
          return this.NOMBRESECRETARIA;
    }
    public void setNOMBRESECRETARIA(String NOMBRESECRETARIAIn) {
          this.NOMBRESECRETARIA = NOMBRESECRETARIAIn;
    }

    public String getDIRECCION() {
          return this.DIRECCION;
    }
    public void setDIRECCION(String DIRECCIONIn) {
          this.DIRECCION = DIRECCIONIn;
    }

    public String getTELEFONO() {
          return this.TELEFONO;
    }
    public void setTELEFONO(String TELEFONOIn) {
          this.TELEFONO = TELEFONOIn;
    }

    public int getIDDEPARTAMENTO() {
          return this.IDDEPARTAMENTO;
    }
    public void setIDDEPARTAMENTO(int IDDEPARTAMENTOIn) {
          this.IDDEPARTAMENTO = IDDEPARTAMENTOIn;
    }

    public String getID_MUNICIPIO() {
          return this.ID_MUNICIPIO;
    }
    public void setID_MUNICIPIO(String ID_MUNICIPIOIn) {
          this.ID_MUNICIPIO = ID_MUNICIPIOIn;
    }



    /** 
     * setAll allows to set all persistent variables in one method call.
     * This is useful, when all data is available and it is needed to 
     * set the initial state of this object. Note that this method will
     * directly modify instance variales, without going trough the 
     * individual set-methods.
     */

    public void setAll(int IDORGTRANSITOIn,
          String NITIn,
          String NOMBRESECRETARIAIn,
          String DIRECCIONIn,
          String TELEFONOIn,
          int IDDEPARTAMENTOIn,
          String ID_MUNICIPIOIn) {
          this.IDORGTRANSITO = IDORGTRANSITOIn;
          this.NIT = NITIn;
          this.NOMBRESECRETARIA = NOMBRESECRETARIAIn;
          this.DIRECCION = DIRECCIONIn;
          this.TELEFONO = TELEFONOIn;
          this.IDDEPARTAMENTO = IDDEPARTAMENTOIn;
          this.ID_MUNICIPIO = ID_MUNICIPIOIn;
    }


    /** 
     * hasEqualMapping-method will compare two OrganismoTransitoComp instances
     * and return true if they contain same values in all persistent instance 
     * variables. If hasEqualMapping returns true, it does not mean the objects
     * are the same instance. However it does mean that in that moment, they 
     * are mapped to the same row in database.
     */
    public boolean hasEqualMapping(OrganismoTransitoComp valueObject) {

          if (valueObject.getIDORGTRANSITO() != this.IDORGTRANSITO) {
                    return(false);
          }
          if (this.NIT == null) {
                    if (valueObject.getNIT() != null)
                           return(false);
          } else if (!this.NIT.equals(valueObject.getNIT())) {
                    return(false);
          }
          if (this.NOMBRESECRETARIA == null) {
                    if (valueObject.getNOMBRESECRETARIA() != null)
                           return(false);
          } else if (!this.NOMBRESECRETARIA.equals(valueObject.getNOMBRESECRETARIA())) {
                    return(false);
          }
          if (this.DIRECCION == null) {
                    if (valueObject.getDIRECCION() != null)
                           return(false);
          } else if (!this.DIRECCION.equals(valueObject.getDIRECCION())) {
                    return(false);
          }
          if (this.TELEFONO == null) {
                    if (valueObject.getTELEFONO() != null)
                           return(false);
          } else if (!this.TELEFONO.equals(valueObject.getTELEFONO())) {
                    return(false);
          }
          if (valueObject.getIDDEPARTAMENTO() != this.IDDEPARTAMENTO) {
                    return(false);
          }
          if (this.ID_MUNICIPIO == null) {
                    if (valueObject.getID_MUNICIPIO() != null)
                           return(false);
          } else if (!this.ID_MUNICIPIO.equals(valueObject.getID_MUNICIPIO())) {
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
        out.append("\nclass OrganismoTransitoComp, mapping to table ORGANISMOTRANSITO\n");
        out.append("Persistent attributes: \n"); 
        out.append("IDORGTRANSITO = " + this.IDORGTRANSITO + "\n"); 
        out.append("NIT = " + this.NIT + "\n"); 
        out.append("NOMBRESECRETARIA = " + this.NOMBRESECRETARIA + "\n"); 
        out.append("DIRECCION = " + this.DIRECCION + "\n"); 
        out.append("TELEFONO = " + this.TELEFONO + "\n"); 
        out.append("IDDEPARTAMENTO = " + this.IDDEPARTAMENTO + "\n"); 
        out.append("ID_MUNICIPIO = " + this.ID_MUNICIPIO + "\n"); 
        return out.toString();
    }


    /**
     * Clone will return identical deep copy of this valueObject.
     * Note, that this method is different than the clone() which
     * is defined in java.lang.Object. Here, the retuned cloned object
     * will also have all its attributes cloned.
     */
    public Object clone() {
        OrganismoTransitoComp cloned = new OrganismoTransitoComp();

        cloned.setIDORGTRANSITO(this.IDORGTRANSITO); 
        if (this.NIT != null)
             cloned.setNIT(new String(this.NIT)); 
        if (this.NOMBRESECRETARIA != null)
             cloned.setNOMBRESECRETARIA(new String(this.NOMBRESECRETARIA)); 
        if (this.DIRECCION != null)
             cloned.setDIRECCION(new String(this.DIRECCION)); 
        if (this.TELEFONO != null)
             cloned.setTELEFONO(new String(this.TELEFONO)); 
        cloned.setIDDEPARTAMENTO(this.IDDEPARTAMENTO); 
        if (this.ID_MUNICIPIO != null)
             cloned.setID_MUNICIPIO(new String(this.ID_MUNICIPIO)); 
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
