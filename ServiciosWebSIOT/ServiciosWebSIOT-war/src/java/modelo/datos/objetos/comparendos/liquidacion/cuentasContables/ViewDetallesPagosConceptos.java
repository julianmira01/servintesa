package modelo.datos.objetos.comparendos.liquidacion.cuentasContables;

import java.io.*;
import java.sql.*;
import java.util.*;
import java.math.*;

 /**
  * ViewDetallesPagosConceptos Value Object.
  * This class is value object representing database table ViewDetallesPagosConceptos
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



public class ViewDetallesPagosConceptos implements Cloneable, Serializable {

    /** 
     * Persistent Instance variables. This data is directly 
     * mapped to the columns of database table.
     */
    private int IDCUENTACONTABLE;
    private String DECOMPARENDO;
    private String CODIGOCUENTA;
    private String NOMBRECUENTA;
    private int VIGENCIAINICIAL;
    private int VIGENCIAFINAL;
    private String FILTROPORFECHAS;
    private int IDTARIFA;
    private int IDCONCEPTO;
    private String NOMBRECONCEPTO;
    private int IDITEM;
    private double VALORPAGO;
    private String FECHAPAGO;
    private int VIGENCIA;



    /** 
     * Constructors. DaoGen generates two constructors by default.
     * The first one takes no arguments and provides the most simple
     * way to create object instance. The another one takes one
     * argument, which is the primary key of the corresponding table.
     */

    public ViewDetallesPagosConceptos () {

    }

    public ViewDetallesPagosConceptos (int IDCUENTACONTABLEIn) {

          this.IDCUENTACONTABLE = IDCUENTACONTABLEIn;

    }


    /** 
     * Get- and Set-methods for persistent variables. The default
     * behaviour does not make any checks against malformed data,
     * so these might require some manual additions.
     */

    public int getIDCUENTACONTABLE() {
          return this.IDCUENTACONTABLE;
    }
    public void setIDCUENTACONTABLE(int IDCUENTACONTABLEIn) {
          this.IDCUENTACONTABLE = IDCUENTACONTABLEIn;
    }

    public String getDECOMPARENDO() {
          return this.DECOMPARENDO;
    }
    public void setDECOMPARENDO(String DECOMPARENDOIn) {
          this.DECOMPARENDO = DECOMPARENDOIn;
    }

    public String getCODIGOCUENTA() {
          return this.CODIGOCUENTA;
    }
    public void setCODIGOCUENTA(String CODIGOCUENTAIn) {
          this.CODIGOCUENTA = CODIGOCUENTAIn;
    }

    public String getNOMBRECUENTA() {
          return this.NOMBRECUENTA;
    }
    public void setNOMBRECUENTA(String NOMBRECUENTAIn) {
          this.NOMBRECUENTA = NOMBRECUENTAIn;
    }

    public int getVIGENCIAINICIAL() {
          return this.VIGENCIAINICIAL;
    }
    public void setVIGENCIAINICIAL(int VIGENCIAINICIALIn) {
          this.VIGENCIAINICIAL = VIGENCIAINICIALIn;
    }

    public int getVIGENCIAFINAL() {
          return this.VIGENCIAFINAL;
    }
    public void setVIGENCIAFINAL(int VIGENCIAFINALIn) {
          this.VIGENCIAFINAL = VIGENCIAFINALIn;
    }

    public String getFILTROPORFECHAS() {
          return this.FILTROPORFECHAS;
    }
    public void setFILTROPORFECHAS(String FILTROPORFECHASIn) {
          this.FILTROPORFECHAS = FILTROPORFECHASIn;
    }

    public int getIDTARIFA() {
          return this.IDTARIFA;
    }
    public void setIDTARIFA(int IDTARIFAIn) {
          this.IDTARIFA = IDTARIFAIn;
    }

    public int getIDCONCEPTO() {
          return this.IDCONCEPTO;
    }
    public void setIDCONCEPTO(int IDCONCEPTOIn) {
          this.IDCONCEPTO = IDCONCEPTOIn;
    }

    public String getNOMBRECONCEPTO() {
          return this.NOMBRECONCEPTO;
    }
    public void setNOMBRECONCEPTO(String NOMBRECONCEPTOIn) {
          this.NOMBRECONCEPTO = NOMBRECONCEPTOIn;
    }

    public int getIDITEM() {
          return this.IDITEM;
    }
    public void setIDITEM(int IDITEMIn) {
          this.IDITEM = IDITEMIn;
    }

    public double getVALORPAGO() {
          return this.VALORPAGO;
    }
    public void setVALORPAGO(double VALORPAGOIn) {
          this.VALORPAGO = VALORPAGOIn;
    }

    public String getFECHAPAGO() {
          return this.FECHAPAGO;
    }
    public void setFECHAPAGO(String FECHAPAGOIn) {
          this.FECHAPAGO = FECHAPAGOIn;
    }

    public int getVIGENCIA() {
          return this.VIGENCIA;
    }
    public void setVIGENCIA(int VIGENCIAIn) {
          this.VIGENCIA = VIGENCIAIn;
    }



    /** 
     * setAll allows to set all persistent variables in one method call.
     * This is useful, when all data is available and it is needed to 
     * set the initial state of this object. Note that this method will
     * directly modify instance variales, without going trough the 
     * individual set-methods.
     */

    public void setAll(int IDCUENTACONTABLEIn,
          String DECOMPARENDOIn,
          String CODIGOCUENTAIn,
          String NOMBRECUENTAIn,
          int VIGENCIAINICIALIn,
          int VIGENCIAFINALIn,
          String FILTROPORFECHASIn,
          int IDTARIFAIn,
          int IDCONCEPTOIn,
          String NOMBRECONCEPTOIn,
          int IDITEMIn,
          double VALORPAGOIn,
          String FECHAPAGOIn,
          int VIGENCIAIn) {
          this.IDCUENTACONTABLE = IDCUENTACONTABLEIn;
          this.DECOMPARENDO = DECOMPARENDOIn;
          this.CODIGOCUENTA = CODIGOCUENTAIn;
          this.NOMBRECUENTA = NOMBRECUENTAIn;
          this.VIGENCIAINICIAL = VIGENCIAINICIALIn;
          this.VIGENCIAFINAL = VIGENCIAFINALIn;
          this.FILTROPORFECHAS = FILTROPORFECHASIn;
          this.IDTARIFA = IDTARIFAIn;
          this.IDCONCEPTO = IDCONCEPTOIn;
          this.NOMBRECONCEPTO = NOMBRECONCEPTOIn;
          this.IDITEM = IDITEMIn;
          this.VALORPAGO = VALORPAGOIn;
          this.FECHAPAGO = FECHAPAGOIn;
          this.VIGENCIA = VIGENCIAIn;
    }


    /** 
     * hasEqualMapping-method will compare two ViewDetallesPagosConceptos instances
     * and return true if they contain same values in all persistent instance 
     * variables. If hasEqualMapping returns true, it does not mean the objects
     * are the same instance. However it does mean that in that moment, they 
     * are mapped to the same row in database.
     */
    public boolean hasEqualMapping(ViewDetallesPagosConceptos valueObject) {

          if (valueObject.getIDCUENTACONTABLE() != this.IDCUENTACONTABLE) {
                    return(false);
          }
          if (this.DECOMPARENDO == null) {
                    if (valueObject.getDECOMPARENDO() != null)
                           return(false);
          } else if (!this.DECOMPARENDO.equals(valueObject.getDECOMPARENDO())) {
                    return(false);
          }
          if (this.CODIGOCUENTA == null) {
                    if (valueObject.getCODIGOCUENTA() != null)
                           return(false);
          } else if (!this.CODIGOCUENTA.equals(valueObject.getCODIGOCUENTA())) {
                    return(false);
          }
          if (this.NOMBRECUENTA == null) {
                    if (valueObject.getNOMBRECUENTA() != null)
                           return(false);
          } else if (!this.NOMBRECUENTA.equals(valueObject.getNOMBRECUENTA())) {
                    return(false);
          }
          if (valueObject.getVIGENCIAINICIAL() != this.VIGENCIAINICIAL) {
                    return(false);
          }
          if (valueObject.getVIGENCIAFINAL() != this.VIGENCIAFINAL) {
                    return(false);
          }
          if (this.FILTROPORFECHAS == null) {
                    if (valueObject.getFILTROPORFECHAS() != null)
                           return(false);
          } else if (!this.FILTROPORFECHAS.equals(valueObject.getFILTROPORFECHAS())) {
                    return(false);
          }
          if (valueObject.getIDTARIFA() != this.IDTARIFA) {
                    return(false);
          }
          if (valueObject.getIDCONCEPTO() != this.IDCONCEPTO) {
                    return(false);
          }
          if (this.NOMBRECONCEPTO == null) {
                    if (valueObject.getNOMBRECONCEPTO() != null)
                           return(false);
          } else if (!this.NOMBRECONCEPTO.equals(valueObject.getNOMBRECONCEPTO())) {
                    return(false);
          }
          if (valueObject.getIDITEM() != this.IDITEM) {
                    return(false);
          }
          if (valueObject.getVALORPAGO() != this.VALORPAGO) {
                    return(false);
          }
          if (this.FECHAPAGO == null) {
                    if (valueObject.getFECHAPAGO() != null)
                           return(false);
          } else if (!this.FECHAPAGO.equals(valueObject.getFECHAPAGO())) {
                    return(false);
          }
          if (valueObject.getVIGENCIA() != this.VIGENCIA) {
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
        out.append("\nclass ViewDetallesPagosConceptos, mapping to table ViewDetallesPagosConceptos\n");
        out.append("Persistent attributes: \n"); 
        out.append("IDCUENTACONTABLE = " + this.IDCUENTACONTABLE + "\n"); 
        out.append("DECOMPARENDO = " + this.DECOMPARENDO + "\n"); 
        out.append("CODIGOCUENTA = " + this.CODIGOCUENTA + "\n"); 
        out.append("NOMBRECUENTA = " + this.NOMBRECUENTA + "\n"); 
        out.append("VIGENCIAINICIAL = " + this.VIGENCIAINICIAL + "\n"); 
        out.append("VIGENCIAFINAL = " + this.VIGENCIAFINAL + "\n"); 
        out.append("FILTROPORFECHAS = " + this.FILTROPORFECHAS + "\n"); 
        out.append("IDTARIFA = " + this.IDTARIFA + "\n"); 
        out.append("IDCONCEPTO = " + this.IDCONCEPTO + "\n"); 
        out.append("NOMBRECONCEPTO = " + this.NOMBRECONCEPTO + "\n"); 
        out.append("IDITEM = " + this.IDITEM + "\n"); 
        out.append("VALORPAGO = " + this.VALORPAGO + "\n"); 
        out.append("FECHAPAGO = " + this.FECHAPAGO + "\n"); 
        out.append("VIGENCIA = " + this.VIGENCIA + "\n"); 
        return out.toString();
    }


    /**
     * Clone will return identical deep copy of this valueObject.
     * Note, that this method is different than the clone() which
     * is defined in java.lang.Object. Here, the retuned cloned object
     * will also have all its attributes cloned.
     */
    public Object clone() {
        ViewDetallesPagosConceptos cloned = new ViewDetallesPagosConceptos();

        cloned.setIDCUENTACONTABLE(this.IDCUENTACONTABLE); 
        if (this.DECOMPARENDO != null)
             cloned.setDECOMPARENDO(new String(this.DECOMPARENDO)); 
        if (this.CODIGOCUENTA != null)
             cloned.setCODIGOCUENTA(new String(this.CODIGOCUENTA)); 
        if (this.NOMBRECUENTA != null)
             cloned.setNOMBRECUENTA(new String(this.NOMBRECUENTA)); 
        cloned.setVIGENCIAINICIAL(this.VIGENCIAINICIAL); 
        cloned.setVIGENCIAFINAL(this.VIGENCIAFINAL); 
        if (this.FILTROPORFECHAS != null)
             cloned.setFILTROPORFECHAS(new String(this.FILTROPORFECHAS)); 
        cloned.setIDTARIFA(this.IDTARIFA); 
        cloned.setIDCONCEPTO(this.IDCONCEPTO); 
        if (this.NOMBRECONCEPTO != null)
             cloned.setNOMBRECONCEPTO(new String(this.NOMBRECONCEPTO)); 
        cloned.setIDITEM(this.IDITEM); 
        cloned.setVALORPAGO(this.VALORPAGO); 
        if (this.FECHAPAGO != null)
             cloned.setFECHAPAGO(new String(this.FECHAPAGO)); 
        cloned.setVIGENCIA(this.VIGENCIA); 
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

