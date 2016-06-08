package modelo.datos.objetos.radicacion;

import java.io.*;
import java.sql.*;
import java.util.*;
import java.math.*;

 /**
  * Cita Value Object.
  * This class is value object representing database table CITA
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



public class Cita implements Cloneable, Serializable {

    /** 
     * Persistent Instance variables. This data is directly 
     * mapped to the columns of database table.
     */
    private int ID_CITA;
    private int ID_DEPENDENCIA;
    private String FECHACITA;
    private int ID_USUARIO;
    private String FECHAREG;
    private String HORAREG;
    private String NOMBRESOLICITA;
    private String ESTADO;
    private int NUMEROCITA;
    private int ID_USRTERMINA;
    private int ID_USRTRASLADA;
    private int ID_USRANULA;
    private String FECHATERMINA;
    private String FECHAANULA;
    private String FECHATRASLADA;
    private String REASIGNADA;
    private String USRREASIGNA;
    private String OBSERVACION;



    /** 
     * Constructors. DaoGen generates two constructors by default.
     * The first one takes no arguments and provides the most simple
     * way to create object instance. The another one takes one
     * argument, which is the primary key of the corresponding table.
     */

    public Cita () {

    }

    public Cita (int ID_CITAIn) {

          this.ID_CITA = ID_CITAIn;

    }


    /** 
     * Get- and Set-methods for persistent variables. The default
     * behaviour does not make any checks against malformed data,
     * so these might require some manual additions.
     */

    public int getID_CITA() {
          return this.ID_CITA;
    }
    public void setID_CITA(int ID_CITAIn) {
          this.ID_CITA = ID_CITAIn;
    }

    public int getID_DEPENDENCIA() {
          return this.ID_DEPENDENCIA;
    }
    public void setID_DEPENDENCIA(int ID_DEPENDENCIAIn) {
          this.ID_DEPENDENCIA = ID_DEPENDENCIAIn;
    }

    public String getFECHACITA() {
          return this.FECHACITA;
    }
    public void setFECHACITA(String FECHACITAIn) {
          this.FECHACITA = FECHACITAIn;
    }

    public int getID_USUARIO() {
          return this.ID_USUARIO;
    }
    public void setID_USUARIO(int ID_USUARIOIn) {
          this.ID_USUARIO = ID_USUARIOIn;
    }

    public String getFECHAREG() {
          return this.FECHAREG;
    }
    public void setFECHAREG(String FECHAREGIn) {
          this.FECHAREG = FECHAREGIn;
    }

    public String getHORAREG() {
          return this.HORAREG;
    }
    public void setHORAREG(String HORAREGIn) {
          this.HORAREG = HORAREGIn;
    }

    public String getNOMBRESOLICITA() {
          return this.NOMBRESOLICITA;
    }
    public void setNOMBRESOLICITA(String NOMBRESOLICITAIn) {
          this.NOMBRESOLICITA = NOMBRESOLICITAIn;
    }

    public String getESTADO() {
          return this.ESTADO;
    }
    public void setESTADO(String ESTADOIn) {
          this.ESTADO = ESTADOIn;
    }

    public int getNUMEROCITA() {
          return this.NUMEROCITA;
    }
    public void setNUMEROCITA(int NUMEROCITAIn) {
          this.NUMEROCITA = NUMEROCITAIn;
    }

    public int getID_USRTERMINA() {
          return this.ID_USRTERMINA;
    }
    public void setID_USRTERMINA(int ID_USRTERMINAIn) {
          this.ID_USRTERMINA = ID_USRTERMINAIn;
    }

    public int getID_USRTRASLADA() {
          return this.ID_USRTRASLADA;
    }
    public void setID_USRTRASLADA(int ID_USRTRASLADAIn) {
          this.ID_USRTRASLADA = ID_USRTRASLADAIn;
    }

    public int getID_USRANULA() {
          return this.ID_USRANULA;
    }
    public void setID_USRANULA(int ID_USRANULAIn) {
          this.ID_USRANULA = ID_USRANULAIn;
    }

    public String getFECHATERMINA() {
          return this.FECHATERMINA;
    }
    public void setFECHATERMINA(String FECHATERMINAIn) {
          this.FECHATERMINA = FECHATERMINAIn;
    }

    public String getFECHAANULA() {
          return this.FECHAANULA;
    }
    public void setFECHAANULA(String FECHAANULAIn) {
          this.FECHAANULA = FECHAANULAIn;
    }

    public String getFECHATRASLADA() {
          return this.FECHATRASLADA;
    }
    public void setFECHATRASLADA(String FECHATRASLADAIn) {
          this.FECHATRASLADA = FECHATRASLADAIn;
    }

    public String getREASIGNADA() {
          return this.REASIGNADA;
    }
    public void setREASIGNADA(String REASIGNADAIn) {
          this.REASIGNADA = REASIGNADAIn;
    }

    public String getUSRREASIGNA() {
          return this.USRREASIGNA;
    }
    public void setUSRREASIGNA(String USRREASIGNAIn) {
          this.USRREASIGNA = USRREASIGNAIn;
    }

    public String getOBSERVACION() {
          return this.OBSERVACION;
    }
    public void setOBSERVACION(String OBSERVACIONIn) {
          this.OBSERVACION = OBSERVACIONIn;
    }



    /** 
     * setAll allows to set all persistent variables in one method call.
     * This is useful, when all data is available and it is needed to 
     * set the initial state of this object. Note that this method will
     * directly modify instance variales, without going trough the 
     * individual set-methods.
     */

    public void setAll(int ID_CITAIn,
          int ID_DEPENDENCIAIn,
          String FECHACITAIn,
          int ID_USUARIOIn,
          String FECHAREGIn,
          String HORAREGIn,
          String NOMBRESOLICITAIn,
          String ESTADOIn,
          int NUMEROCITAIn,
          int ID_USRTERMINAIn,
          int ID_USRTRASLADAIn,
          int ID_USRANULAIn,
          String FECHATERMINAIn,
          String FECHAANULAIn,
          String FECHATRASLADAIn,
          String REASIGNADAIn,
          String USRREASIGNAIn,
          String OBSERVACIONIn) {
          this.ID_CITA = ID_CITAIn;
          this.ID_DEPENDENCIA = ID_DEPENDENCIAIn;
          this.FECHACITA = FECHACITAIn;
          this.ID_USUARIO = ID_USUARIOIn;
          this.FECHAREG = FECHAREGIn;
          this.HORAREG = HORAREGIn;
          this.NOMBRESOLICITA = NOMBRESOLICITAIn;
          this.ESTADO = ESTADOIn;
          this.NUMEROCITA = NUMEROCITAIn;
          this.ID_USRTERMINA = ID_USRTERMINAIn;
          this.ID_USRTRASLADA = ID_USRTRASLADAIn;
          this.ID_USRANULA = ID_USRANULAIn;
          this.FECHATERMINA = FECHATERMINAIn;
          this.FECHAANULA = FECHAANULAIn;
          this.FECHATRASLADA = FECHATRASLADAIn;
          this.REASIGNADA = REASIGNADAIn;
          this.USRREASIGNA = USRREASIGNAIn;
          this.OBSERVACION = OBSERVACIONIn;
    }


    /** 
     * hasEqualMapping-method will compare two Cita instances
     * and return true if they contain same values in all persistent instance 
     * variables. If hasEqualMapping returns true, it does not mean the objects
     * are the same instance. However it does mean that in that moment, they 
     * are mapped to the same row in database.
     */
    public boolean hasEqualMapping(Cita valueObject) {

          if (valueObject.getID_CITA() != this.ID_CITA) {
                    return(false);
          }
          if (valueObject.getID_DEPENDENCIA() != this.ID_DEPENDENCIA) {
                    return(false);
          }
          if (this.FECHACITA == null) {
                    if (valueObject.getFECHACITA() != null)
                           return(false);
          } else if (!this.FECHACITA.equals(valueObject.getFECHACITA())) {
                    return(false);
          }
          if (valueObject.getID_USUARIO() != this.ID_USUARIO) {
                    return(false);
          }
          if (this.FECHAREG == null) {
                    if (valueObject.getFECHAREG() != null)
                           return(false);
          } else if (!this.FECHAREG.equals(valueObject.getFECHAREG())) {
                    return(false);
          }
          if (this.HORAREG == null) {
                    if (valueObject.getHORAREG() != null)
                           return(false);
          } else if (!this.HORAREG.equals(valueObject.getHORAREG())) {
                    return(false);
          }
          if (this.NOMBRESOLICITA == null) {
                    if (valueObject.getNOMBRESOLICITA() != null)
                           return(false);
          } else if (!this.NOMBRESOLICITA.equals(valueObject.getNOMBRESOLICITA())) {
                    return(false);
          }
          if (this.ESTADO == null) {
                    if (valueObject.getESTADO() != null)
                           return(false);
          } else if (!this.ESTADO.equals(valueObject.getESTADO())) {
                    return(false);
          }
          if (valueObject.getNUMEROCITA() != this.NUMEROCITA) {
                    return(false);
          }
          if (valueObject.getID_USRTERMINA() != this.ID_USRTERMINA) {
                    return(false);
          }
          if (valueObject.getID_USRTRASLADA() != this.ID_USRTRASLADA) {
                    return(false);
          }
          if (valueObject.getID_USRANULA() != this.ID_USRANULA) {
                    return(false);
          }
          if (this.FECHATERMINA == null) {
                    if (valueObject.getFECHATERMINA() != null)
                           return(false);
          } else if (!this.FECHATERMINA.equals(valueObject.getFECHATERMINA())) {
                    return(false);
          }
          if (this.FECHAANULA == null) {
                    if (valueObject.getFECHAANULA() != null)
                           return(false);
          } else if (!this.FECHAANULA.equals(valueObject.getFECHAANULA())) {
                    return(false);
          }
          if (this.FECHATRASLADA == null) {
                    if (valueObject.getFECHATRASLADA() != null)
                           return(false);
          } else if (!this.FECHATRASLADA.equals(valueObject.getFECHATRASLADA())) {
                    return(false);
          }
          if (this.REASIGNADA == null) {
                    if (valueObject.getREASIGNADA() != null)
                           return(false);
          } else if (!this.REASIGNADA.equals(valueObject.getREASIGNADA())) {
                    return(false);
          }
          if (this.USRREASIGNA == null) {
                    if (valueObject.getUSRREASIGNA() != null)
                           return(false);
          } else if (!this.USRREASIGNA.equals(valueObject.getUSRREASIGNA())) {
                    return(false);
          }
          if (this.OBSERVACION == null) {
                    if (valueObject.getOBSERVACION() != null)
                           return(false);
          } else if (!this.OBSERVACION.equals(valueObject.getOBSERVACION())) {
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
        out.append("\nclass Cita, mapping to table CITA\n");
        out.append("Persistent attributes: \n"); 
        out.append("ID_CITA = " + this.ID_CITA + "\n"); 
        out.append("ID_DEPENDENCIA = " + this.ID_DEPENDENCIA + "\n"); 
        out.append("FECHACITA = " + this.FECHACITA + "\n"); 
        out.append("ID_USUARIO = " + this.ID_USUARIO + "\n"); 
        out.append("FECHAREG = " + this.FECHAREG + "\n"); 
        out.append("HORAREG = " + this.HORAREG + "\n"); 
        out.append("NOMBRESOLICITA = " + this.NOMBRESOLICITA + "\n"); 
        out.append("ESTADO = " + this.ESTADO + "\n"); 
        out.append("NUMEROCITA = " + this.NUMEROCITA + "\n"); 
        out.append("ID_USRTERMINA = " + this.ID_USRTERMINA + "\n"); 
        out.append("ID_USRTRASLADA = " + this.ID_USRTRASLADA + "\n"); 
        out.append("ID_USRANULA = " + this.ID_USRANULA + "\n"); 
        out.append("FECHATERMINA = " + this.FECHATERMINA + "\n"); 
        out.append("FECHAANULA = " + this.FECHAANULA + "\n"); 
        out.append("FECHATRASLADA = " + this.FECHATRASLADA + "\n"); 
        out.append("REASIGNADA = " + this.REASIGNADA + "\n"); 
        out.append("USRREASIGNA = " + this.USRREASIGNA + "\n"); 
        out.append("OBSERVACION = " + this.OBSERVACION + "\n"); 
        return out.toString();
    }


    /**
     * Clone will return identical deep copy of this valueObject.
     * Note, that this method is different than the clone() which
     * is defined in java.lang.Object. Here, the retuned cloned object
     * will also have all its attributes cloned.
     */
    public Object clone() {
        Cita cloned = new Cita();

        cloned.setID_CITA(this.ID_CITA); 
        cloned.setID_DEPENDENCIA(this.ID_DEPENDENCIA); 
        if (this.FECHACITA != null)
             cloned.setFECHACITA(new String(this.FECHACITA)); 
        cloned.setID_USUARIO(this.ID_USUARIO); 
        if (this.FECHAREG != null)
             cloned.setFECHAREG(new String(this.FECHAREG)); 
        if (this.HORAREG != null)
             cloned.setHORAREG(new String(this.HORAREG)); 
        if (this.NOMBRESOLICITA != null)
             cloned.setNOMBRESOLICITA(new String(this.NOMBRESOLICITA)); 
        if (this.ESTADO != null)
             cloned.setESTADO(new String(this.ESTADO)); 
        cloned.setNUMEROCITA(this.NUMEROCITA); 
        cloned.setID_USRTERMINA(this.ID_USRTERMINA); 
        cloned.setID_USRTRASLADA(this.ID_USRTRASLADA); 
        cloned.setID_USRANULA(this.ID_USRANULA); 
        if (this.FECHATERMINA != null)
             cloned.setFECHATERMINA(new String(this.FECHATERMINA)); 
        if (this.FECHAANULA != null)
             cloned.setFECHAANULA(new String(this.FECHAANULA)); 
        if (this.FECHATRASLADA != null)
             cloned.setFECHATRASLADA(new String(this.FECHATRASLADA)); 
        if (this.REASIGNADA != null)
             cloned.setREASIGNADA(new String(this.REASIGNADA)); 
        if (this.USRREASIGNA != null)
             cloned.setUSRREASIGNA(new String(this.USRREASIGNA)); 
        if (this.OBSERVACION != null)
             cloned.setOBSERVACION(new String(this.OBSERVACION)); 
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