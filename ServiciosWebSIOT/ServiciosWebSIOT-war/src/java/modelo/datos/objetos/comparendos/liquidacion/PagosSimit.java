package modelo.datos.objetos.comparendos.liquidacion;

import java.io.*;
import java.sql.*;
import java.util.*;
import java.math.*;

 /**
  * PagosSimit Value Object.
  * This class is value object representing database table PAGOSSIMIT
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



public class PagosSimit implements Cloneable, Serializable {

    /** 
     * Persistent Instance variables. This data is directly 
     * mapped to the columns of database table.
     */
    private int ID;
    private String NUMEROCOMPARENDO;
    private String FECHACOMPARENDO;
    private String IDENTIFICACION;
    private String NUMERORECIBO;
    private String FECHAPAGO;
    private double VALOR;
    private int NUM;
    private int IDINFRACCION;
    private String FECHAREGISTRO;
    private int IDUSUARIO;



    /** 
     * Constructors. DaoGen generates two constructors by default.
     * The first one takes no arguments and provides the most simple
     * way to create object instance. The another one takes one
     * argument, which is the primary key of the corresponding table.
     */

    public PagosSimit () {

    }

    public PagosSimit (int IDIn) {

          this.ID = IDIn;

    }


    /** 
     * Get- and Set-methods for persistent variables. The default
     * behaviour does not make any checks against malformed data,
     * so these might require some manual additions.
     */

    public int getID() {
          return this.ID;
    }
    public void setID(int IDIn) {
          this.ID = IDIn;
    }

    public String getNUMEROCOMPARENDO() {
          return this.NUMEROCOMPARENDO;
    }
    public void setNUMEROCOMPARENDO(String NUMEROCOMPARENDOIn) {
          this.NUMEROCOMPARENDO = NUMEROCOMPARENDOIn;
    }

    public String getFECHACOMPARENDO() {
          return this.FECHACOMPARENDO;
    }
    public void setFECHACOMPARENDO(String FECHACOMPARENDOIn) {
          this.FECHACOMPARENDO = FECHACOMPARENDOIn;
    }

    public String getIDENTIFICACION() {
          return this.IDENTIFICACION;
    }
    public void setIDENTIFICACION(String IDENTIFICACIONIn) {
          this.IDENTIFICACION = IDENTIFICACIONIn;
    }

    public String getNUMERORECIBO() {
          return this.NUMERORECIBO;
    }
    public void setNUMERORECIBO(String NUMERORECIBOIn) {
          this.NUMERORECIBO = NUMERORECIBOIn;
    }

    public String getFECHAPAGO() {
          return this.FECHAPAGO;
    }
    public void setFECHAPAGO(String FECHAPAGOIn) {
          this.FECHAPAGO = FECHAPAGOIn;
    }

    public double getVALOR() {
          return this.VALOR;
    }
    public void setVALOR(double VALORIn) {
          this.VALOR = VALORIn;
    }

    public int getNUM() {
          return this.NUM;
    }
    public void setNUM(int NUMIn) {
          this.NUM = NUMIn;
    }

    public int getIDINFRACCION() {
          return this.IDINFRACCION;
    }
    public void setIDINFRACCION(int IDINFRACCIONIn) {
          this.IDINFRACCION = IDINFRACCIONIn;
    }

    public String getFECHAREGISTRO() {
          return this.FECHAREGISTRO;
    }
    public void setFECHAREGISTRO(String FECHAREGISTROIn) {
          this.FECHAREGISTRO = FECHAREGISTROIn;
    }

    public int getIDUSUARIO() {
          return this.IDUSUARIO;
    }
    public void setIDUSUARIO(int IDUSUARIOIn) {
          this.IDUSUARIO = IDUSUARIOIn;
    }



    /** 
     * setAll allows to set all persistent variables in one method call.
     * This is useful, when all data is available and it is needed to 
     * set the initial state of this object. Note that this method will
     * directly modify instance variales, without going trough the 
     * individual set-methods.
     */

    public void setAll(int IDIn,
          String NUMEROCOMPARENDOIn,
          String FECHACOMPARENDOIn,
          String IDENTIFICACIONIn,
          String NUMERORECIBOIn,
          String FECHAPAGOIn,
          double VALORIn,
          int NUMIn,
          int IDINFRACCIONIn,
          String FECHAREGISTROIn,
          int IDUSUARIOIn) {
          this.ID = IDIn;
          this.NUMEROCOMPARENDO = NUMEROCOMPARENDOIn;
          this.FECHACOMPARENDO = FECHACOMPARENDOIn;
          this.IDENTIFICACION = IDENTIFICACIONIn;
          this.NUMERORECIBO = NUMERORECIBOIn;
          this.FECHAPAGO = FECHAPAGOIn;
          this.VALOR = VALORIn;
          this.NUM = NUMIn;
          this.IDINFRACCION = IDINFRACCIONIn;
          this.FECHAREGISTRO = FECHAREGISTROIn;
          this.IDUSUARIO = IDUSUARIOIn;
    }


    /** 
     * hasEqualMapping-method will compare two PagosSimit instances
     * and return true if they contain same values in all persistent instance 
     * variables. If hasEqualMapping returns true, it does not mean the objects
     * are the same instance. However it does mean that in that moment, they 
     * are mapped to the same row in database.
     */
    public boolean hasEqualMapping(PagosSimit valueObject) {

          if (valueObject.getID() != this.ID) {
                    return(false);
          }
          if (this.NUMEROCOMPARENDO == null) {
                    if (valueObject.getNUMEROCOMPARENDO() != null)
                           return(false);
          } else if (!this.NUMEROCOMPARENDO.equals(valueObject.getNUMEROCOMPARENDO())) {
                    return(false);
          }
          if (this.FECHACOMPARENDO == null) {
                    if (valueObject.getFECHACOMPARENDO() != null)
                           return(false);
          } else if (!this.FECHACOMPARENDO.equals(valueObject.getFECHACOMPARENDO())) {
                    return(false);
          }
          if (this.IDENTIFICACION == null) {
                    if (valueObject.getIDENTIFICACION() != null)
                           return(false);
          } else if (!this.IDENTIFICACION.equals(valueObject.getIDENTIFICACION())) {
                    return(false);
          }
          if (this.NUMERORECIBO == null) {
                    if (valueObject.getNUMERORECIBO() != null)
                           return(false);
          } else if (!this.NUMERORECIBO.equals(valueObject.getNUMERORECIBO())) {
                    return(false);
          }
          if (this.FECHAPAGO == null) {
                    if (valueObject.getFECHAPAGO() != null)
                           return(false);
          } else if (!this.FECHAPAGO.equals(valueObject.getFECHAPAGO())) {
                    return(false);
          }
          if (valueObject.getVALOR() != this.VALOR) {
                    return(false);
          }
          if (valueObject.getNUM() != this.NUM) {
                    return(false);
          }
          if (valueObject.getIDINFRACCION() != this.IDINFRACCION) {
                    return(false);
          }
          if (this.FECHAREGISTRO == null) {
                    if (valueObject.getFECHAREGISTRO() != null)
                           return(false);
          } else if (!this.FECHAREGISTRO.equals(valueObject.getFECHAREGISTRO())) {
                    return(false);
          }
          if (valueObject.getIDUSUARIO() != this.IDUSUARIO) {
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
        out.append("\nclass PagosSimit, mapping to table PAGOSSIMIT\n");
        out.append("Persistent attributes: \n"); 
        out.append("ID = " + this.ID + "\n"); 
        out.append("NUMEROCOMPARENDO = " + this.NUMEROCOMPARENDO + "\n"); 
        out.append("FECHACOMPARENDO = " + this.FECHACOMPARENDO + "\n"); 
        out.append("IDENTIFICACION = " + this.IDENTIFICACION + "\n"); 
        out.append("NUMERORECIBO = " + this.NUMERORECIBO + "\n"); 
        out.append("FECHAPAGO = " + this.FECHAPAGO + "\n"); 
        out.append("VALOR = " + this.VALOR + "\n"); 
        out.append("NUM = " + this.NUM + "\n"); 
        out.append("IDINFRACCION = " + this.IDINFRACCION + "\n"); 
        out.append("FECHAREGISTRO = " + this.FECHAREGISTRO + "\n"); 
        out.append("IDUSUARIO = " + this.IDUSUARIO + "\n"); 
        return out.toString();
    }


    /**
     * Clone will return identical deep copy of this valueObject.
     * Note, that this method is different than the clone() which
     * is defined in java.lang.Object. Here, the retuned cloned object
     * will also have all its attributes cloned.
     */
    public Object clone() {
        PagosSimit cloned = new PagosSimit();

        cloned.setID(this.ID); 
        if (this.NUMEROCOMPARENDO != null)
             cloned.setNUMEROCOMPARENDO(new String(this.NUMEROCOMPARENDO)); 
        if (this.FECHACOMPARENDO != null)
             cloned.setFECHACOMPARENDO(new String(this.FECHACOMPARENDO)); 
        if (this.IDENTIFICACION != null)
             cloned.setIDENTIFICACION(new String(this.IDENTIFICACION)); 
        if (this.NUMERORECIBO != null)
             cloned.setNUMERORECIBO(new String(this.NUMERORECIBO)); 
        if (this.FECHAPAGO != null)
             cloned.setFECHAPAGO(new String(this.FECHAPAGO)); 
        cloned.setVALOR(this.VALOR); 
        cloned.setNUM(this.NUM); 
        cloned.setIDINFRACCION(this.IDINFRACCION); 
        if (this.FECHAREGISTRO != null)
             cloned.setFECHAREGISTRO(new String(this.FECHAREGISTRO)); 
        cloned.setIDUSUARIO(this.IDUSUARIO); 
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