package modelo.datos.objetos.tramites;

import java.io.*;
import java.sql.*;
import java.util.*;
import java.math.*;

 /**
  * Tramiteinterno Value Object.
  * This class is value object representing database table TRAMITEINTERNO
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



public class Tramiteinterno implements Cloneable, Serializable {

    /** 
     * Persistent Instance variables. This data is directly 
     * mapped to the columns of database table.
     */
    private int IDTRAM_INTERNO;
    private String CODTRAMITE;
    private String DESCTRAMITE;
    private String CONFVEHICULO_LIC;
    private String ESTADOTRAMITE;
    private int ID_TIPO_TRAMITE;
    private String PAZYSALVO;
    private String TIPOVALIDACION;
    private int CANTIDADDIAS;
    private String TIPODIAS;
    private int IDINFRACCION;
    private String TIPOVEHICULO;
    private int IDTRAMITEVEHICULO;
    private String GENERALIC_TRANSITO;
    private String REQUIEREPROPIETARIO;
    private String REPORTAMINISTERIO;
    private String REPORTARCERTTRADICION;
    private int PRIORIDAD;
    private String DESCRIPREDUCIDA;
    private String TIENEBASEREQ;
    private int ID_COD_RUNT;
    private String ID_TARAPLICADA_C;
    private String ID_TARAPLICADA_M;
    private String T_INICIAL;



    /** 
     * Constructors. DaoGen generates two constructors by default.
     * The first one takes no arguments and provides the most simple
     * way to create object instance. The another one takes one
     * argument, which is the primary key of the corresponding table.
     */

    public Tramiteinterno () {

    }

    public Tramiteinterno (int IDTRAM_INTERNOIn) {

          this.IDTRAM_INTERNO = IDTRAM_INTERNOIn;

    }


    /** 
     * Get- and Set-methods for persistent variables. The default
     * behaviour does not make any checks against malformed data,
     * so these might require some manual additions.
     */

    public int getIDTRAM_INTERNO() {
          return this.IDTRAM_INTERNO;
    }
    public void setIDTRAM_INTERNO(int IDTRAM_INTERNOIn) {
          this.IDTRAM_INTERNO = IDTRAM_INTERNOIn;
    }

    public String getCODTRAMITE() {
          return this.CODTRAMITE;
    }
    public void setCODTRAMITE(String CODTRAMITEIn) {
          this.CODTRAMITE = CODTRAMITEIn;
    }

    public String getDESCTRAMITE() {
          return this.DESCTRAMITE;
    }
    public void setDESCTRAMITE(String DESCTRAMITEIn) {
          this.DESCTRAMITE = DESCTRAMITEIn;
    }

    public String getCONFVEHICULO_LIC() {
          return this.CONFVEHICULO_LIC;
    }
    public void setCONFVEHICULO_LIC(String CONFVEHICULO_LICIn) {
          this.CONFVEHICULO_LIC = CONFVEHICULO_LICIn;
    }

    public String getESTADOTRAMITE() {
          return this.ESTADOTRAMITE;
    }
    public void setESTADOTRAMITE(String ESTADOTRAMITEIn) {
          this.ESTADOTRAMITE = ESTADOTRAMITEIn;
    }

    public int getID_TIPO_TRAMITE() {
          return this.ID_TIPO_TRAMITE;
    }
    public void setID_TIPO_TRAMITE(int ID_TIPO_TRAMITEIn) {
          this.ID_TIPO_TRAMITE = ID_TIPO_TRAMITEIn;
    }

    public String getPAZYSALVO() {
          return this.PAZYSALVO;
    }
    public void setPAZYSALVO(String PAZYSALVOIn) {
          this.PAZYSALVO = PAZYSALVOIn;
    }

    public String getTIPOVALIDACION() {
          return this.TIPOVALIDACION;
    }
    public void setTIPOVALIDACION(String TIPOVALIDACIONIn) {
          this.TIPOVALIDACION = TIPOVALIDACIONIn;
    }

    public int getCANTIDADDIAS() {
          return this.CANTIDADDIAS;
    }
    public void setCANTIDADDIAS(int CANTIDADDIASIn) {
          this.CANTIDADDIAS = CANTIDADDIASIn;
    }

    public String getTIPODIAS() {
          return this.TIPODIAS;
    }
    public void setTIPODIAS(String TIPODIASIn) {
          this.TIPODIAS = TIPODIASIn;
    }

    public int getIDINFRACCION() {
          return this.IDINFRACCION;
    }
    public void setIDINFRACCION(int IDINFRACCIONIn) {
          this.IDINFRACCION = IDINFRACCIONIn;
    }

    public String getTIPOVEHICULO() {
          return this.TIPOVEHICULO;
    }
    public void setTIPOVEHICULO(String TIPOVEHICULOIn) {
          this.TIPOVEHICULO = TIPOVEHICULOIn;
    }

    public int getIDTRAMITEVEHICULO() {
          return this.IDTRAMITEVEHICULO;
    }
    public void setIDTRAMITEVEHICULO(int IDTRAMITEVEHICULOIn) {
          this.IDTRAMITEVEHICULO = IDTRAMITEVEHICULOIn;
    }

    public String getGENERALIC_TRANSITO() {
          return this.GENERALIC_TRANSITO;
    }
    public void setGENERALIC_TRANSITO(String GENERALIC_TRANSITOIn) {
          this.GENERALIC_TRANSITO = GENERALIC_TRANSITOIn;
    }

    public String getREQUIEREPROPIETARIO() {
          return this.REQUIEREPROPIETARIO;
    }
    public void setREQUIEREPROPIETARIO(String REQUIEREPROPIETARIOIn) {
          this.REQUIEREPROPIETARIO = REQUIEREPROPIETARIOIn;
    }

    public String getREPORTAMINISTERIO() {
          return this.REPORTAMINISTERIO;
    }
    public void setREPORTAMINISTERIO(String REPORTAMINISTERIOIn) {
          this.REPORTAMINISTERIO = REPORTAMINISTERIOIn;
    }

    public String getREPORTARCERTTRADICION() {
          return this.REPORTARCERTTRADICION;
    }
    public void setREPORTARCERTTRADICION(String REPORTARCERTTRADICIONIn) {
          this.REPORTARCERTTRADICION = REPORTARCERTTRADICIONIn;
    }

    public int getPRIORIDAD() {
          return this.PRIORIDAD;
    }
    public void setPRIORIDAD(int PRIORIDADIn) {
          this.PRIORIDAD = PRIORIDADIn;
    }

    public String getDESCRIPREDUCIDA() {
          return this.DESCRIPREDUCIDA;
    }
    public void setDESCRIPREDUCIDA(String DESCRIPREDUCIDAIn) {
          this.DESCRIPREDUCIDA = DESCRIPREDUCIDAIn;
    }

    public String getTIENEBASEREQ() {
          return this.TIENEBASEREQ;
    }
    public void setTIENEBASEREQ(String TIENEBASEREQIn) {
          this.TIENEBASEREQ = TIENEBASEREQIn;
    }

    public int getID_COD_RUNT() {
          return this.ID_COD_RUNT;
    }
    public void setID_COD_RUNT(int ID_COD_RUNTIn) {
          this.ID_COD_RUNT = ID_COD_RUNTIn;
    }

    public String getID_TARAPLICADA_C() {
          return this.ID_TARAPLICADA_C;
    }
    public void setID_TARAPLICADA_C(String ID_TARAPLICADA_CIn) {
          this.ID_TARAPLICADA_C = ID_TARAPLICADA_CIn;
    }

    public String getID_TARAPLICADA_M() {
          return this.ID_TARAPLICADA_M;
    }
    public void setID_TARAPLICADA_M(String ID_TARAPLICADA_MIn) {
          this.ID_TARAPLICADA_M = ID_TARAPLICADA_MIn;
    }



    /** 
     * setAll allows to set all persistent variables in one method call.
     * This is useful, when all data is available and it is needed to 
     * set the initial state of this object. Note that this method will
     * directly modify instance variales, without going trough the 
     * individual set-methods.
     */

    public void setAll(int IDTRAM_INTERNOIn,
          String CODTRAMITEIn,
          String DESCTRAMITEIn,
          String CONFVEHICULO_LICIn,
          String ESTADOTRAMITEIn,
          int ID_TIPO_TRAMITEIn,
          String PAZYSALVOIn,
          String TIPOVALIDACIONIn,
          int CANTIDADDIASIn,
          String TIPODIASIn,
          int IDINFRACCIONIn,
          String TIPOVEHICULOIn,
          int IDTRAMITEVEHICULOIn,
          String GENERALIC_TRANSITOIn,
          String REQUIEREPROPIETARIOIn,
          String REPORTAMINISTERIOIn,
          String REPORTARCERTTRADICIONIn,
          int PRIORIDADIn,
          String DESCRIPREDUCIDAIn,
          String TIENEBASEREQIn,
          int ID_COD_RUNTIn,
          String ID_TARAPLICADA_CIn,
          String ID_TARAPLICADA_MIn,
          String T_INICIALIn) {
          this.IDTRAM_INTERNO = IDTRAM_INTERNOIn;
          this.CODTRAMITE = CODTRAMITEIn;
          this.DESCTRAMITE = DESCTRAMITEIn;
          this.CONFVEHICULO_LIC = CONFVEHICULO_LICIn;
          this.ESTADOTRAMITE = ESTADOTRAMITEIn;
          this.ID_TIPO_TRAMITE = ID_TIPO_TRAMITEIn;
          this.PAZYSALVO = PAZYSALVOIn;
          this.TIPOVALIDACION = TIPOVALIDACIONIn;
          this.CANTIDADDIAS = CANTIDADDIASIn;
          this.TIPODIAS = TIPODIASIn;
          this.IDINFRACCION = IDINFRACCIONIn;
          this.TIPOVEHICULO = TIPOVEHICULOIn;
          this.IDTRAMITEVEHICULO = IDTRAMITEVEHICULOIn;
          this.GENERALIC_TRANSITO = GENERALIC_TRANSITOIn;
          this.REQUIEREPROPIETARIO = REQUIEREPROPIETARIOIn;
          this.REPORTAMINISTERIO = REPORTAMINISTERIOIn;
          this.REPORTARCERTTRADICION = REPORTARCERTTRADICIONIn;
          this.PRIORIDAD = PRIORIDADIn;
          this.DESCRIPREDUCIDA = DESCRIPREDUCIDAIn;
          this.TIENEBASEREQ = TIENEBASEREQIn;
          this.ID_COD_RUNT = ID_COD_RUNTIn;
          this.ID_TARAPLICADA_C = ID_TARAPLICADA_CIn;
          this.ID_TARAPLICADA_M = ID_TARAPLICADA_MIn;
          this.T_INICIAL = T_INICIALIn;
    }


    /** 
     * hasEqualMapping-method will compare two Tramiteinterno instances
     * and return true if they contain same values in all persistent instance 
     * variables. If hasEqualMapping returns true, it does not mean the objects
     * are the same instance. However it does mean that in that moment, they 
     * are mapped to the same row in database.
     */
    public boolean hasEqualMapping(Tramiteinterno valueObject) {

          if (valueObject.getIDTRAM_INTERNO() != this.IDTRAM_INTERNO) {
                    return(false);
          }
          if (this.CODTRAMITE == null) {
                    if (valueObject.getCODTRAMITE() != null)
                           return(false);
          } else if (!this.CODTRAMITE.equals(valueObject.getCODTRAMITE())) {
                    return(false);
          }
          if (this.DESCTRAMITE == null) {
                    if (valueObject.getDESCTRAMITE() != null)
                           return(false);
          } else if (!this.DESCTRAMITE.equals(valueObject.getDESCTRAMITE())) {
                    return(false);
          }
          if (this.CONFVEHICULO_LIC == null) {
                    if (valueObject.getCONFVEHICULO_LIC() != null)
                           return(false);
          } else if (!this.CONFVEHICULO_LIC.equals(valueObject.getCONFVEHICULO_LIC())) {
                    return(false);
          }
          if (this.ESTADOTRAMITE == null) {
                    if (valueObject.getESTADOTRAMITE() != null)
                           return(false);
          } else if (!this.ESTADOTRAMITE.equals(valueObject.getESTADOTRAMITE())) {
                    return(false);
          }
          if (valueObject.getID_TIPO_TRAMITE() != this.ID_TIPO_TRAMITE) {
                    return(false);
          }
          if (this.PAZYSALVO == null) {
                    if (valueObject.getPAZYSALVO() != null)
                           return(false);
          } else if (!this.PAZYSALVO.equals(valueObject.getPAZYSALVO())) {
                    return(false);
          }
          if (this.TIPOVALIDACION == null) {
                    if (valueObject.getTIPOVALIDACION() != null)
                           return(false);
          } else if (!this.TIPOVALIDACION.equals(valueObject.getTIPOVALIDACION())) {
                    return(false);
          }
          if (valueObject.getCANTIDADDIAS() != this.CANTIDADDIAS) {
                    return(false);
          }
          if (this.TIPODIAS == null) {
                    if (valueObject.getTIPODIAS() != null)
                           return(false);
          } else if (!this.TIPODIAS.equals(valueObject.getTIPODIAS())) {
                    return(false);
          }
          if (valueObject.getIDINFRACCION() != this.IDINFRACCION) {
                    return(false);
          }
          if (this.TIPOVEHICULO == null) {
                    if (valueObject.getTIPOVEHICULO() != null)
                           return(false);
          } else if (!this.TIPOVEHICULO.equals(valueObject.getTIPOVEHICULO())) {
                    return(false);
          }
          if (valueObject.getIDTRAMITEVEHICULO() != this.IDTRAMITEVEHICULO) {
                    return(false);
          }
          if (this.GENERALIC_TRANSITO == null) {
                    if (valueObject.getGENERALIC_TRANSITO() != null)
                           return(false);
          } else if (!this.GENERALIC_TRANSITO.equals(valueObject.getGENERALIC_TRANSITO())) {
                    return(false);
          }
          if (this.REQUIEREPROPIETARIO == null) {
                    if (valueObject.getREQUIEREPROPIETARIO() != null)
                           return(false);
          } else if (!this.REQUIEREPROPIETARIO.equals(valueObject.getREQUIEREPROPIETARIO())) {
                    return(false);
          }
          if (this.REPORTAMINISTERIO == null) {
                    if (valueObject.getREPORTAMINISTERIO() != null)
                           return(false);
          } else if (!this.REPORTAMINISTERIO.equals(valueObject.getREPORTAMINISTERIO())) {
                    return(false);
          }
          if (this.REPORTARCERTTRADICION == null) {
                    if (valueObject.getREPORTARCERTTRADICION() != null)
                           return(false);
          } else if (!this.REPORTARCERTTRADICION.equals(valueObject.getREPORTARCERTTRADICION())) {
                    return(false);
          }
          if (valueObject.getPRIORIDAD() != this.PRIORIDAD) {
                    return(false);
          }
          if (this.DESCRIPREDUCIDA == null) {
                    if (valueObject.getDESCRIPREDUCIDA() != null)
                           return(false);
          } else if (!this.DESCRIPREDUCIDA.equals(valueObject.getDESCRIPREDUCIDA())) {
                    return(false);
          }
          if (this.TIENEBASEREQ == null) {
                    if (valueObject.getTIENEBASEREQ() != null)
                           return(false);
          } else if (!this.TIENEBASEREQ.equals(valueObject.getTIENEBASEREQ())) {
                    return(false);
          }
          if (valueObject.getID_COD_RUNT() != this.ID_COD_RUNT) {
                    return(false);
          }
          if (this.ID_TARAPLICADA_C == null) {
                    if (valueObject.getID_TARAPLICADA_C() != null)
                           return(false);
          } else if (!this.ID_TARAPLICADA_C.equals(valueObject.getID_TARAPLICADA_C())) {
                    return(false);
          }
          if (this.ID_TARAPLICADA_M == null) {
                    if (valueObject.getID_TARAPLICADA_M() != null)
                           return(false);
          } else if (!this.ID_TARAPLICADA_M.equals(valueObject.getID_TARAPLICADA_M())) {
                    return(false);
          }
          if (this.T_INICIAL == null) {
                    if (valueObject.getT_INICIAL() != null)
                           return(false);
          } else if (!this.T_INICIAL.equals(valueObject.getT_INICIAL())) {
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
        out.append("\nclass Tramiteinterno, mapping to table TRAMITEINTERNO\n");
        out.append("Persistent attributes: \n"); 
        out.append("IDTRAM_INTERNO = " + this.IDTRAM_INTERNO + "\n"); 
        out.append("CODTRAMITE = " + this.CODTRAMITE + "\n"); 
        out.append("DESCTRAMITE = " + this.DESCTRAMITE + "\n"); 
        out.append("CONFVEHICULO_LIC = " + this.CONFVEHICULO_LIC + "\n"); 
        out.append("ESTADOTRAMITE = " + this.ESTADOTRAMITE + "\n"); 
        out.append("ID_TIPO_TRAMITE = " + this.ID_TIPO_TRAMITE + "\n"); 
        out.append("PAZYSALVO = " + this.PAZYSALVO + "\n"); 
        out.append("TIPOVALIDACION = " + this.TIPOVALIDACION + "\n"); 
        out.append("CANTIDADDIAS = " + this.CANTIDADDIAS + "\n"); 
        out.append("TIPODIAS = " + this.TIPODIAS + "\n"); 
        out.append("IDINFRACCION = " + this.IDINFRACCION + "\n"); 
        out.append("TIPOVEHICULO = " + this.TIPOVEHICULO + "\n"); 
        out.append("IDTRAMITEVEHICULO = " + this.IDTRAMITEVEHICULO + "\n"); 
        out.append("GENERALIC_TRANSITO = " + this.GENERALIC_TRANSITO + "\n"); 
        out.append("REQUIEREPROPIETARIO = " + this.REQUIEREPROPIETARIO + "\n"); 
        out.append("REPORTAMINISTERIO = " + this.REPORTAMINISTERIO + "\n"); 
        out.append("REPORTARCERTTRADICION = " + this.REPORTARCERTTRADICION + "\n"); 
        out.append("PRIORIDAD = " + this.PRIORIDAD + "\n"); 
        out.append("DESCRIPREDUCIDA = " + this.DESCRIPREDUCIDA + "\n"); 
        out.append("TIENEBASEREQ = " + this.TIENEBASEREQ + "\n"); 
        out.append("ID_COD_RUNT = " + this.ID_COD_RUNT + "\n"); 
        out.append("ID_TARAPLICADA_C = " + this.ID_TARAPLICADA_C + "\n"); 
        out.append("ID_TARAPLICADA_M = " + this.ID_TARAPLICADA_M + "\n"); 
        out.append("T_INICIAL = " + this.T_INICIAL + "\n"); 
        return out.toString();
    }


    /**
     * Clone will return identical deep copy of this valueObject.
     * Note, that this method is different than the clone() which
     * is defined in java.lang.Object. Here, the retuned cloned object
     * will also have all its attributes cloned.
     */
    public Object clone() {
        Tramiteinterno cloned = new Tramiteinterno();

        cloned.setIDTRAM_INTERNO(this.IDTRAM_INTERNO); 
        if (this.CODTRAMITE != null)
             cloned.setCODTRAMITE(new String(this.CODTRAMITE)); 
        if (this.DESCTRAMITE != null)
             cloned.setDESCTRAMITE(new String(this.DESCTRAMITE)); 
        if (this.CONFVEHICULO_LIC != null)
             cloned.setCONFVEHICULO_LIC(new String(this.CONFVEHICULO_LIC)); 
        if (this.ESTADOTRAMITE != null)
             cloned.setESTADOTRAMITE(new String(this.ESTADOTRAMITE)); 
        cloned.setID_TIPO_TRAMITE(this.ID_TIPO_TRAMITE); 
        if (this.PAZYSALVO != null)
             cloned.setPAZYSALVO(new String(this.PAZYSALVO)); 
        if (this.TIPOVALIDACION != null)
             cloned.setTIPOVALIDACION(new String(this.TIPOVALIDACION)); 
        cloned.setCANTIDADDIAS(this.CANTIDADDIAS); 
        if (this.TIPODIAS != null)
             cloned.setTIPODIAS(new String(this.TIPODIAS)); 
        cloned.setIDINFRACCION(this.IDINFRACCION); 
        if (this.TIPOVEHICULO != null)
             cloned.setTIPOVEHICULO(new String(this.TIPOVEHICULO)); 
        cloned.setIDTRAMITEVEHICULO(this.IDTRAMITEVEHICULO); 
        if (this.GENERALIC_TRANSITO != null)
             cloned.setGENERALIC_TRANSITO(new String(this.GENERALIC_TRANSITO)); 
        if (this.REQUIEREPROPIETARIO != null)
             cloned.setREQUIEREPROPIETARIO(new String(this.REQUIEREPROPIETARIO)); 
        if (this.REPORTAMINISTERIO != null)
             cloned.setREPORTAMINISTERIO(new String(this.REPORTAMINISTERIO)); 
        if (this.REPORTARCERTTRADICION != null)
             cloned.setREPORTARCERTTRADICION(new String(this.REPORTARCERTTRADICION)); 
        cloned.setPRIORIDAD(this.PRIORIDAD); 
        if (this.DESCRIPREDUCIDA != null)
             cloned.setDESCRIPREDUCIDA(new String(this.DESCRIPREDUCIDA)); 
        if (this.TIENEBASEREQ != null)
             cloned.setTIENEBASEREQ(new String(this.TIENEBASEREQ)); 
        cloned.setID_COD_RUNT(this.ID_COD_RUNT); 
        if (this.ID_TARAPLICADA_C != null)
             cloned.setID_TARAPLICADA_C(new String(this.ID_TARAPLICADA_C)); 
        if (this.ID_TARAPLICADA_M != null)
             cloned.setID_TARAPLICADA_M(new String(this.ID_TARAPLICADA_M)); 
        if (this.T_INICIAL != null)
             cloned.setT_INICIAL(new String(this.T_INICIAL)); 
        return cloned;
    }



    /** 
     * getDaogenVersion will return information about
     * generator which created these sources.
     */
    public String getDaogenVersion() {
        return "DaoGen version 2.4.1";
    }

    public String getT_INICIAL() {
        return T_INICIAL;
    }

    public void setT_INICIAL(String T_INICIAL) {
        this.T_INICIAL = T_INICIAL;
    }
}
