package modelo.datos.objetos.radicacion;

import java.io.*;
import java.sql.*;
import java.util.*;
import java.math.*;

 /**
  * DetCita Value Object.
  * This class is value object representing database table DETCITA
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



public class DetCita implements Cloneable, Serializable {

    /** 
     * Persistent Instance variables. This data is directly 
     * mapped to the columns of database table.
     */
    private int ID_DETCITA;
    private int ID_CITA;
    private int ID_PERSONA;
    private String HORACITA;
    private String OBSERVACION;
    private int ID_USRASIGNA;
    private String HORAASIGNA;
    private String FECHAASIGNA;
    private String ESTADO;
    private int IDUSRTERMINA;
    private String FECHATERMINA;
    private String HORATERMINA;
    private int NUMEROCITA;
    private String TIPO;
    private String PLACACEDULA;
    private int IDTRAMITEINTERNO;
    private String CODTRAMITE;
    private String DESCTRAMITE;



    /** 
     * Constructors. DaoGen generates two constructors by default.
     * The first one takes no arguments and provides the most simple
     * way to create object instance. The another one takes one
     * argument, which is the primary key of the corresponding table.
     */

    public DetCita () {

    }

    public DetCita (int ID_DETCITAIn) {

          this.ID_DETCITA = ID_DETCITAIn;

    }


    /** 
     * Get- and Set-methods for persistent variables. The default
     * behaviour does not make any checks against malformed data,
     * so these might require some manual additions.
     */

    public int getID_DETCITA() {
          return this.ID_DETCITA;
    }
    public void setID_DETCITA(int ID_DETCITAIn) {
          this.ID_DETCITA = ID_DETCITAIn;
    }

    public int getID_CITA() {
          return this.ID_CITA;
    }
    public void setID_CITA(int ID_CITAIn) {
          this.ID_CITA = ID_CITAIn;
    }

    public int getID_PERSONA() {
          return this.ID_PERSONA;
    }
    public void setID_PERSONA(int ID_PERSONAIn) {
          this.ID_PERSONA = ID_PERSONAIn;
    }

    public String getHORACITA() {
          return this.HORACITA;
    }
    public void setHORACITA(String HORACITAIn) {
          this.HORACITA = HORACITAIn;
    }

    public String getOBSERVACION() {
          return this.OBSERVACION;
    }
    public void setOBSERVACION(String OBSERVACIONIn) {
          this.OBSERVACION = OBSERVACIONIn;
    }

    public int getID_USRASIGNA() {
          return this.ID_USRASIGNA;
    }
    public void setID_USRASIGNA(int ID_USRASIGNAIn) {
          this.ID_USRASIGNA = ID_USRASIGNAIn;
    }

    public String getHORAASIGNA() {
          return this.HORAASIGNA;
    }
    public void setHORAASIGNA(String HORAASIGNAIn) {
          this.HORAASIGNA = HORAASIGNAIn;
    }

    public String getFECHAASIGNA() {
          return this.FECHAASIGNA;
    }
    public void setFECHAASIGNA(String FECHAASIGNAIn) {
          this.FECHAASIGNA = FECHAASIGNAIn;
    }

    public String getESTADO() {
          return this.ESTADO;
    }
    public void setESTADO(String ESTADOIn) {
          this.ESTADO = ESTADOIn;
    }

    public int getIDUSRTERMINA() {
          return this.IDUSRTERMINA;
    }
    public void setIDUSRTERMINA(int IDUSRTERMINAIn) {
          this.IDUSRTERMINA = IDUSRTERMINAIn;
    }

    public String getFECHATERMINA() {
          return this.FECHATERMINA;
    }
    public void setFECHATERMINA(String FECHATERMINAIn) {
          this.FECHATERMINA = FECHATERMINAIn;
    }

    public String getHORATERMINA() {
          return this.HORATERMINA;
    }
    public void setHORATERMINA(String HORATERMINAIn) {
          this.HORATERMINA = HORATERMINAIn;
    }

    public int getNUMEROCITA() {
          return this.NUMEROCITA;
    }
    public void setNUMEROCITA(int NUMEROCITAIn) {
          this.NUMEROCITA = NUMEROCITAIn;
    }

    public String getTIPO() {
          return this.TIPO;
    }
    public void setTIPO(String TIPOIn) {
          this.TIPO = TIPOIn;
    }

    public String getPLACACEDULA() {
          return this.PLACACEDULA;
    }
    public void setPLACACEDULA(String PLACACEDULAIn) {
          this.PLACACEDULA = PLACACEDULAIn;
    }

    public int getIDTRAMITEINTERNO() {
          return this.IDTRAMITEINTERNO;
    }
    public void setIDTRAMITEINTERNO(int IDTRAMITEINTERNOIn) {
          this.IDTRAMITEINTERNO = IDTRAMITEINTERNOIn;
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



    /** 
     * setAll allows to set all persistent variables in one method call.
     * This is useful, when all data is available and it is needed to 
     * set the initial state of this object. Note that this method will
     * directly modify instance variales, without going trough the 
     * individual set-methods.
     */

    public void setAll(int ID_DETCITAIn,
          int ID_CITAIn,
          int ID_PERSONAIn,
          String HORACITAIn,
          String OBSERVACIONIn,
          int ID_USRASIGNAIn,
          String HORAASIGNAIn,
          String FECHAASIGNAIn,
          String ESTADOIn,
          int IDUSRTERMINAIn,
          String FECHATERMINAIn,
          String HORATERMINAIn,
          int NUMEROCITAIn,
          String TIPOIn,
          String PLACACEDULAIn,
          int IDTRAMITEINTERNOIn,
          String CODTRAMITEIn,
          String DESCTRAMITEIn) {
          this.ID_DETCITA = ID_DETCITAIn;
          this.ID_CITA = ID_CITAIn;
          this.ID_PERSONA = ID_PERSONAIn;
          this.HORACITA = HORACITAIn;
          this.OBSERVACION = OBSERVACIONIn;
          this.ID_USRASIGNA = ID_USRASIGNAIn;
          this.HORAASIGNA = HORAASIGNAIn;
          this.FECHAASIGNA = FECHAASIGNAIn;
          this.ESTADO = ESTADOIn;
          this.IDUSRTERMINA = IDUSRTERMINAIn;
          this.FECHATERMINA = FECHATERMINAIn;
          this.HORATERMINA = HORATERMINAIn;
          this.NUMEROCITA = NUMEROCITAIn;
          this.TIPO = TIPOIn;
          this.PLACACEDULA = PLACACEDULAIn;
          this.IDTRAMITEINTERNO = IDTRAMITEINTERNOIn;
          this.CODTRAMITE = CODTRAMITEIn;
          this.DESCTRAMITE = DESCTRAMITEIn;
    }


    /** 
     * hasEqualMapping-method will compare two DetCita instances
     * and return true if they contain same values in all persistent instance 
     * variables. If hasEqualMapping returns true, it does not mean the objects
     * are the same instance. However it does mean that in that moment, they 
     * are mapped to the same row in database.
     */
    public boolean hasEqualMapping(DetCita valueObject) {

          if (valueObject.getID_DETCITA() != this.ID_DETCITA) {
                    return(false);
          }
          if (valueObject.getID_CITA() != this.ID_CITA) {
                    return(false);
          }
          if (valueObject.getID_PERSONA() != this.ID_PERSONA) {
                    return(false);
          }
          if (this.HORACITA == null) {
                    if (valueObject.getHORACITA() != null)
                           return(false);
          } else if (!this.HORACITA.equals(valueObject.getHORACITA())) {
                    return(false);
          }
          if (this.OBSERVACION == null) {
                    if (valueObject.getOBSERVACION() != null)
                           return(false);
          } else if (!this.OBSERVACION.equals(valueObject.getOBSERVACION())) {
                    return(false);
          }
          if (valueObject.getID_USRASIGNA() != this.ID_USRASIGNA) {
                    return(false);
          }
          if (this.HORAASIGNA == null) {
                    if (valueObject.getHORAASIGNA() != null)
                           return(false);
          } else if (!this.HORAASIGNA.equals(valueObject.getHORAASIGNA())) {
                    return(false);
          }
          if (this.FECHAASIGNA == null) {
                    if (valueObject.getFECHAASIGNA() != null)
                           return(false);
          } else if (!this.FECHAASIGNA.equals(valueObject.getFECHAASIGNA())) {
                    return(false);
          }
          if (this.ESTADO == null) {
                    if (valueObject.getESTADO() != null)
                           return(false);
          } else if (!this.ESTADO.equals(valueObject.getESTADO())) {
                    return(false);
          }
          if (valueObject.getIDUSRTERMINA() != this.IDUSRTERMINA) {
                    return(false);
          }
          if (this.FECHATERMINA == null) {
                    if (valueObject.getFECHATERMINA() != null)
                           return(false);
          } else if (!this.FECHATERMINA.equals(valueObject.getFECHATERMINA())) {
                    return(false);
          }
          if (this.HORATERMINA == null) {
                    if (valueObject.getHORATERMINA() != null)
                           return(false);
          } else if (!this.HORATERMINA.equals(valueObject.getHORATERMINA())) {
                    return(false);
          }
          if (valueObject.getNUMEROCITA() != this.NUMEROCITA) {
                    return(false);
          }
          if (this.TIPO == null) {
                    if (valueObject.getTIPO() != null)
                           return(false);
          } else if (!this.TIPO.equals(valueObject.getTIPO())) {
                    return(false);
          }
          if (this.PLACACEDULA == null) {
                    if (valueObject.getPLACACEDULA() != null)
                           return(false);
          } else if (!this.PLACACEDULA.equals(valueObject.getPLACACEDULA())) {
                    return(false);
          }
          if (valueObject.getIDTRAMITEINTERNO() != this.IDTRAMITEINTERNO) {
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

          return true;
    }



    /**
     * toString will return String object representing the state of this 
     * valueObject. This is useful during application development, and 
     * possibly when application is writing object states in textlog.
     */
    public String toString() {
        StringBuffer out = new StringBuffer(this.getDaogenVersion());
        out.append("\nclass DetCita, mapping to table DETCITA\n");
        out.append("Persistent attributes: \n"); 
        out.append("ID_DETCITA = " + this.ID_DETCITA + "\n"); 
        out.append("ID_CITA = " + this.ID_CITA + "\n"); 
        out.append("ID_PERSONA = " + this.ID_PERSONA + "\n"); 
        out.append("HORACITA = " + this.HORACITA + "\n"); 
        out.append("OBSERVACION = " + this.OBSERVACION + "\n"); 
        out.append("ID_USRASIGNA = " + this.ID_USRASIGNA + "\n"); 
        out.append("HORAASIGNA = " + this.HORAASIGNA + "\n"); 
        out.append("FECHAASIGNA = " + this.FECHAASIGNA + "\n"); 
        out.append("ESTADO = " + this.ESTADO + "\n"); 
        out.append("IDUSRTERMINA = " + this.IDUSRTERMINA + "\n"); 
        out.append("FECHATERMINA = " + this.FECHATERMINA + "\n"); 
        out.append("HORATERMINA = " + this.HORATERMINA + "\n"); 
        out.append("NUMEROCITA = " + this.NUMEROCITA + "\n"); 
        out.append("TIPO = " + this.TIPO + "\n"); 
        out.append("PLACACEDULA = " + this.PLACACEDULA + "\n"); 
        out.append("IDTRAMITEINTERNO = " + this.IDTRAMITEINTERNO + "\n"); 
        out.append("CODTRAMITE = " + this.CODTRAMITE + "\n"); 
        out.append("DESCTRAMITE = " + this.DESCTRAMITE + "\n"); 
        return out.toString();
    }


    /**
     * Clone will return identical deep copy of this valueObject.
     * Note, that this method is different than the clone() which
     * is defined in java.lang.Object. Here, the retuned cloned object
     * will also have all its attributes cloned.
     */
    public Object clone() {
        DetCita cloned = new DetCita();

        cloned.setID_DETCITA(this.ID_DETCITA); 
        cloned.setID_CITA(this.ID_CITA); 
        cloned.setID_PERSONA(this.ID_PERSONA); 
        if (this.HORACITA != null)
             cloned.setHORACITA(new String(this.HORACITA)); 
        if (this.OBSERVACION != null)
             cloned.setOBSERVACION(new String(this.OBSERVACION)); 
        cloned.setID_USRASIGNA(this.ID_USRASIGNA); 
        if (this.HORAASIGNA != null)
             cloned.setHORAASIGNA(new String(this.HORAASIGNA)); 
        if (this.FECHAASIGNA != null)
             cloned.setFECHAASIGNA(new String(this.FECHAASIGNA)); 
        if (this.ESTADO != null)
             cloned.setESTADO(new String(this.ESTADO)); 
        cloned.setIDUSRTERMINA(this.IDUSRTERMINA); 
        if (this.FECHATERMINA != null)
             cloned.setFECHATERMINA(new String(this.FECHATERMINA)); 
        if (this.HORATERMINA != null)
             cloned.setHORATERMINA(new String(this.HORATERMINA)); 
        cloned.setNUMEROCITA(this.NUMEROCITA); 
        if (this.TIPO != null)
             cloned.setTIPO(new String(this.TIPO)); 
        if (this.PLACACEDULA != null)
             cloned.setPLACACEDULA(new String(this.PLACACEDULA)); 
        cloned.setIDTRAMITEINTERNO(this.IDTRAMITEINTERNO); 
        if (this.CODTRAMITE != null)
             cloned.setCODTRAMITE(new String(this.CODTRAMITE)); 
        if (this.DESCTRAMITE != null)
             cloned.setDESCTRAMITE(new String(this.DESCTRAMITE)); 
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