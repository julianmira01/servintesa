package modelo.datos.objetos.liquidacion.caja;

import java.io.*;
import java.sql.*;
import java.util.*;
import java.math.*;

 /**
  * ViewAsobancaria Value Object.
  * This class is value object representing database table ViewAsobancaria
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



public class ViewAsobancaria implements Cloneable, Serializable {

    /** 
     * Persistent Instance variables. This data is directly 
     * mapped to the columns of database table.
     */
    private int IDPAGORUNT;
    private int IDFACTURA;
    private String FECHASOLICITUD;
    private String FECHAREGISTRO;
    private String FECHAVIGENCIA;
    private String TIPOLIQUIDACION;
    private String TIPOCOMPROBANTEPAGO;
    private double VALORMT;
    private double VALORRUNT;
    private double VALORTOTAL;
    private String ESTADOLIQUIDACION;
    private String FECHAPAGO;
    private int IDBANCO;
    private int IDTIPOMONEDA;
    private String NUMAUTORIZACIONBANCO;
    private int IDUSRPAGO;
    private int IDARQUEO;
    private String LFNUMRUNT;



    /** 
     * Constructors. DaoGen generates two constructors by default.
     * The first one takes no arguments and provides the most simple
     * way to create object instance. The another one takes one
     * argument, which is the primary key of the corresponding table.
     */

    public ViewAsobancaria () {

    }

    public ViewAsobancaria (int IDPAGORUNTIn) {

          this.IDPAGORUNT = IDPAGORUNTIn;

    }


    /** 
     * Get- and Set-methods for persistent variables. The default
     * behaviour does not make any checks against malformed data,
     * so these might require some manual additions.
     */

    public int getIDPAGORUNT() {
          return this.IDPAGORUNT;
    }
    public void setIDPAGORUNT(int IDPAGORUNTIn) {
          this.IDPAGORUNT = IDPAGORUNTIn;
    }

    public int getIDFACTURA() {
          return this.IDFACTURA;
    }
    public void setIDFACTURA(int IDFACTURAIn) {
          this.IDFACTURA = IDFACTURAIn;
    }

    public String getFECHASOLICITUD() {
          return this.FECHASOLICITUD;
    }
    public void setFECHASOLICITUD(String FECHASOLICITUDIn) {
          this.FECHASOLICITUD = FECHASOLICITUDIn;
    }

    public String getFECHAREGISTRO() {
          return this.FECHAREGISTRO;
    }
    public void setFECHAREGISTRO(String FECHAREGISTROIn) {
          this.FECHAREGISTRO = FECHAREGISTROIn;
    }

    public String getFECHAVIGENCIA() {
          return this.FECHAVIGENCIA;
    }
    public void setFECHAVIGENCIA(String FECHAVIGENCIAIn) {
          this.FECHAVIGENCIA = FECHAVIGENCIAIn;
    }

    public String getTIPOLIQUIDACION() {
          return this.TIPOLIQUIDACION;
    }
    public void setTIPOLIQUIDACION(String TIPOLIQUIDACIONIn) {
          this.TIPOLIQUIDACION = TIPOLIQUIDACIONIn;
    }

    public String getTIPOCOMPROBANTEPAGO() {
          return this.TIPOCOMPROBANTEPAGO;
    }
    public void setTIPOCOMPROBANTEPAGO(String TIPOCOMPROBANTEPAGOIn) {
          this.TIPOCOMPROBANTEPAGO = TIPOCOMPROBANTEPAGOIn;
    }

    public double getVALORMT() {
          return this.VALORMT;
    }
    public void setVALORMT(double VALORMTIn) {
          this.VALORMT = VALORMTIn;
    }

    public double getVALORRUNT() {
          return this.VALORRUNT;
    }
    public void setVALORRUNT(double VALORRUNTIn) {
          this.VALORRUNT = VALORRUNTIn;
    }

    public double getVALORTOTAL() {
          return this.VALORTOTAL;
    }
    public void setVALORTOTAL(double VALORTOTALIn) {
          this.VALORTOTAL = VALORTOTALIn;
    }

    public String getESTADOLIQUIDACION() {
          return this.ESTADOLIQUIDACION;
    }
    public void setESTADOLIQUIDACION(String ESTADOLIQUIDACIONIn) {
          this.ESTADOLIQUIDACION = ESTADOLIQUIDACIONIn;
    }

    public String getFECHAPAGO() {
          return this.FECHAPAGO;
    }
    public void setFECHAPAGO(String FECHAPAGOIn) {
          this.FECHAPAGO = FECHAPAGOIn;
    }

    public int getIDBANCO() {
          return this.IDBANCO;
    }
    public void setIDBANCO(int IDBANCOIn) {
          this.IDBANCO = IDBANCOIn;
    }

    public int getIDTIPOMONEDA() {
          return this.IDTIPOMONEDA;
    }
    public void setIDTIPOMONEDA(int IDTIPOMONEDAIn) {
          this.IDTIPOMONEDA = IDTIPOMONEDAIn;
    }

    public String getNUMAUTORIZACIONBANCO() {
          return this.NUMAUTORIZACIONBANCO;
    }
    public void setNUMAUTORIZACIONBANCO(String NUMAUTORIZACIONBANCOIn) {
          this.NUMAUTORIZACIONBANCO = NUMAUTORIZACIONBANCOIn;
    }

    public int getIDUSRPAGO() {
          return this.IDUSRPAGO;
    }
    public void setIDUSRPAGO(int IDUSRPAGOIn) {
          this.IDUSRPAGO = IDUSRPAGOIn;
    }

    public int getIDARQUEO() {
          return this.IDARQUEO;
    }
    public void setIDARQUEO(int IDARQUEOIn) {
          this.IDARQUEO = IDARQUEOIn;
    }

    public String getLFNUMRUNT() {
          return this.LFNUMRUNT;
    }
    public void setLFNUMRUNT(String LFNUMRUNTIn) {
          this.LFNUMRUNT = LFNUMRUNTIn;
    }



    /** 
     * setAll allows to set all persistent variables in one method call.
     * This is useful, when all data is available and it is needed to 
     * set the initial state of this object. Note that this method will
     * directly modify instance variales, without going trough the 
     * individual set-methods.
     */

    public void setAll(int IDPAGORUNTIn,
          int IDFACTURAIn,
          String FECHASOLICITUDIn,
          String FECHAREGISTROIn,
          String FECHAVIGENCIAIn,
          String TIPOLIQUIDACIONIn,
          String TIPOCOMPROBANTEPAGOIn,
          double VALORMTIn,
          double VALORRUNTIn,
          double VALORTOTALIn,
          String ESTADOLIQUIDACIONIn,
          String FECHAPAGOIn,
          int IDBANCOIn,
          int IDTIPOMONEDAIn,
          String NUMAUTORIZACIONBANCOIn,
          int IDUSRPAGOIn,
          int IDARQUEOIn,
          String LFNUMRUNTIn) {
          this.IDPAGORUNT = IDPAGORUNTIn;
          this.IDFACTURA = IDFACTURAIn;
          this.FECHASOLICITUD = FECHASOLICITUDIn;
          this.FECHAREGISTRO = FECHAREGISTROIn;
          this.FECHAVIGENCIA = FECHAVIGENCIAIn;
          this.TIPOLIQUIDACION = TIPOLIQUIDACIONIn;
          this.TIPOCOMPROBANTEPAGO = TIPOCOMPROBANTEPAGOIn;
          this.VALORMT = VALORMTIn;
          this.VALORRUNT = VALORRUNTIn;
          this.VALORTOTAL = VALORTOTALIn;
          this.ESTADOLIQUIDACION = ESTADOLIQUIDACIONIn;
          this.FECHAPAGO = FECHAPAGOIn;
          this.IDBANCO = IDBANCOIn;
          this.IDTIPOMONEDA = IDTIPOMONEDAIn;
          this.NUMAUTORIZACIONBANCO = NUMAUTORIZACIONBANCOIn;
          this.IDUSRPAGO = IDUSRPAGOIn;
          this.IDARQUEO = IDARQUEOIn;
          this.LFNUMRUNT = LFNUMRUNTIn;
    }


    /** 
     * hasEqualMapping-method will compare two ViewAsobancaria instances
     * and return true if they contain same values in all persistent instance 
     * variables. If hasEqualMapping returns true, it does not mean the objects
     * are the same instance. However it does mean that in that moment, they 
     * are mapped to the same row in database.
     */
    public boolean hasEqualMapping(ViewAsobancaria valueObject) {

          if (valueObject.getIDPAGORUNT() != this.IDPAGORUNT) {
                    return(false);
          }
          if (valueObject.getIDFACTURA() != this.IDFACTURA) {
                    return(false);
          }
          if (this.FECHASOLICITUD == null) {
                    if (valueObject.getFECHASOLICITUD() != null)
                           return(false);
          } else if (!this.FECHASOLICITUD.equals(valueObject.getFECHASOLICITUD())) {
                    return(false);
          }
          if (this.FECHAREGISTRO == null) {
                    if (valueObject.getFECHAREGISTRO() != null)
                           return(false);
          } else if (!this.FECHAREGISTRO.equals(valueObject.getFECHAREGISTRO())) {
                    return(false);
          }
          if (this.FECHAVIGENCIA == null) {
                    if (valueObject.getFECHAVIGENCIA() != null)
                           return(false);
          } else if (!this.FECHAVIGENCIA.equals(valueObject.getFECHAVIGENCIA())) {
                    return(false);
          }
          if (this.TIPOLIQUIDACION == null) {
                    if (valueObject.getTIPOLIQUIDACION() != null)
                           return(false);
          } else if (!this.TIPOLIQUIDACION.equals(valueObject.getTIPOLIQUIDACION())) {
                    return(false);
          }
          if (this.TIPOCOMPROBANTEPAGO == null) {
                    if (valueObject.getTIPOCOMPROBANTEPAGO() != null)
                           return(false);
          } else if (!this.TIPOCOMPROBANTEPAGO.equals(valueObject.getTIPOCOMPROBANTEPAGO())) {
                    return(false);
          }
          if (valueObject.getVALORMT() != this.VALORMT) {
                    return(false);
          }
          if (valueObject.getVALORRUNT() != this.VALORRUNT) {
                    return(false);
          }
          if (valueObject.getVALORTOTAL() != this.VALORTOTAL) {
                    return(false);
          }
          if (this.ESTADOLIQUIDACION == null) {
                    if (valueObject.getESTADOLIQUIDACION() != null)
                           return(false);
          } else if (!this.ESTADOLIQUIDACION.equals(valueObject.getESTADOLIQUIDACION())) {
                    return(false);
          }
          if (this.FECHAPAGO == null) {
                    if (valueObject.getFECHAPAGO() != null)
                           return(false);
          } else if (!this.FECHAPAGO.equals(valueObject.getFECHAPAGO())) {
                    return(false);
          }
          if (valueObject.getIDBANCO() != this.IDBANCO) {
                    return(false);
          }
          if (valueObject.getIDTIPOMONEDA() != this.IDTIPOMONEDA) {
                    return(false);
          }
          if (this.NUMAUTORIZACIONBANCO == null) {
                    if (valueObject.getNUMAUTORIZACIONBANCO() != null)
                           return(false);
          } else if (!this.NUMAUTORIZACIONBANCO.equals(valueObject.getNUMAUTORIZACIONBANCO())) {
                    return(false);
          }
          if (valueObject.getIDUSRPAGO() != this.IDUSRPAGO) {
                    return(false);
          }
          if (valueObject.getIDARQUEO() != this.IDARQUEO) {
                    return(false);
          }
          if (this.LFNUMRUNT == null) {
                    if (valueObject.getLFNUMRUNT() != null)
                           return(false);
          } else if (!this.LFNUMRUNT.equals(valueObject.getLFNUMRUNT())) {
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
        out.append("\nclass ViewAsobancaria, mapping to table ViewAsobancaria\n");
        out.append("Persistent attributes: \n"); 
        out.append("IDPAGORUNT = " + this.IDPAGORUNT + "\n"); 
        out.append("IDFACTURA = " + this.IDFACTURA + "\n"); 
        out.append("FECHASOLICITUD = " + this.FECHASOLICITUD + "\n"); 
        out.append("FECHAREGISTRO = " + this.FECHAREGISTRO + "\n"); 
        out.append("FECHAVIGENCIA = " + this.FECHAVIGENCIA + "\n"); 
        out.append("TIPOLIQUIDACION = " + this.TIPOLIQUIDACION + "\n"); 
        out.append("TIPOCOMPROBANTEPAGO = " + this.TIPOCOMPROBANTEPAGO + "\n"); 
        out.append("VALORMT = " + this.VALORMT + "\n"); 
        out.append("VALORRUNT = " + this.VALORRUNT + "\n"); 
        out.append("VALORTOTAL = " + this.VALORTOTAL + "\n"); 
        out.append("ESTADOLIQUIDACION = " + this.ESTADOLIQUIDACION + "\n"); 
        out.append("FECHAPAGO = " + this.FECHAPAGO + "\n"); 
        out.append("IDBANCO = " + this.IDBANCO + "\n"); 
        out.append("IDTIPOMONEDA = " + this.IDTIPOMONEDA + "\n"); 
        out.append("NUMAUTORIZACIONBANCO = " + this.NUMAUTORIZACIONBANCO + "\n"); 
        out.append("IDUSRPAGO = " + this.IDUSRPAGO + "\n"); 
        out.append("IDARQUEO = " + this.IDARQUEO + "\n"); 
        out.append("LFNUMRUNT = " + this.LFNUMRUNT + "\n"); 
        return out.toString();
    }


    /**
     * Clone will return identical deep copy of this valueObject.
     * Note, that this method is different than the clone() which
     * is defined in java.lang.Object. Here, the retuned cloned object
     * will also have all its attributes cloned.
     */
    public Object clone() {
        ViewAsobancaria cloned = new ViewAsobancaria();

        cloned.setIDPAGORUNT(this.IDPAGORUNT); 
        cloned.setIDFACTURA(this.IDFACTURA); 
        if (this.FECHASOLICITUD != null)
             cloned.setFECHASOLICITUD(new String(this.FECHASOLICITUD)); 
        if (this.FECHAREGISTRO != null)
             cloned.setFECHAREGISTRO(new String(this.FECHAREGISTRO)); 
        if (this.FECHAVIGENCIA != null)
             cloned.setFECHAVIGENCIA(new String(this.FECHAVIGENCIA)); 
        if (this.TIPOLIQUIDACION != null)
             cloned.setTIPOLIQUIDACION(new String(this.TIPOLIQUIDACION)); 
        if (this.TIPOCOMPROBANTEPAGO != null)
             cloned.setTIPOCOMPROBANTEPAGO(new String(this.TIPOCOMPROBANTEPAGO)); 
        cloned.setVALORMT(this.VALORMT); 
        cloned.setVALORRUNT(this.VALORRUNT); 
        cloned.setVALORTOTAL(this.VALORTOTAL); 
        if (this.ESTADOLIQUIDACION != null)
             cloned.setESTADOLIQUIDACION(new String(this.ESTADOLIQUIDACION)); 
        if (this.FECHAPAGO != null)
             cloned.setFECHAPAGO(new String(this.FECHAPAGO)); 
        cloned.setIDBANCO(this.IDBANCO); 
        cloned.setIDTIPOMONEDA(this.IDTIPOMONEDA); 
        if (this.NUMAUTORIZACIONBANCO != null)
             cloned.setNUMAUTORIZACIONBANCO(new String(this.NUMAUTORIZACIONBANCO)); 
        cloned.setIDUSRPAGO(this.IDUSRPAGO); 
        cloned.setIDARQUEO(this.IDARQUEO); 
        if (this.LFNUMRUNT != null)
             cloned.setLFNUMRUNT(new String(this.LFNUMRUNT)); 
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

