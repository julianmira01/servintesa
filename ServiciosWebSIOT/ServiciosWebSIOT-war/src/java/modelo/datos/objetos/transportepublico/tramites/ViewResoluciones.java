package modelo.datos.objetos.transportepublico.tramites;

import java.io.*;
import java.sql.*;
import java.util.*;
import java.math.*;

 /**
  * ViewResoluciones Value Object.
  * This class is value object representing database table ViewResoluciones
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



public class ViewResoluciones implements Cloneable, Serializable {

    /** 
     * Persistent Instance variables. This data is directly 
     * mapped to the columns of database table.
     */
    private int IDRESOLUCION;
    private String NUMERORESOLUCION;
    private String FECHARESOLUCION;
    private int IDPERSONA;
    private String IDENTIFICACION;
    private String NOMBRESPERSONA;
    private String APELLIDO1;
    private String APELLIDO2;
    private int IDCUPOTAXI;
    private int NUMEROCUPO;
    private int IDEMPRESADESERVICIO;
    private String EMPRESADESERVICIO;
    private int IDVEHICULO;
    private String PLACA;
    private int MODELO;
    private String NROMOTOR;
    private String CHASIS;
    private String IDMARCA;
    private String MARCAVEHICULO;
    private int IDTIPOVEHICULO;
    private String NOMTIPOVEHICULO;
    private String IDDOCUMENTO;
    private String DESCDOCUMENTO;
    private String ADESCRIPCION;
    private String DFECHAREGISTRO;
    private int IDTIPORESOLUCION;



    /** 
     * Constructors. DaoGen generates two constructors by default.
     * The first one takes no arguments and provides the most simple
     * way to create object instance. The another one takes one
     * argument, which is the primary key of the corresponding table.
     */

    public ViewResoluciones () {

    }

    public ViewResoluciones (int IDRESOLUCIONIn) {

          this.IDRESOLUCION = IDRESOLUCIONIn;

    }


    /** 
     * Get- and Set-methods for persistent variables. The default
     * behaviour does not make any checks against malformed data,
     * so these might require some manual additions.
     */

    public int getIDRESOLUCION() {
          return this.IDRESOLUCION;
    }
    public void setIDRESOLUCION(int IDRESOLUCIONIn) {
          this.IDRESOLUCION = IDRESOLUCIONIn;
    }

    public String getNUMERORESOLUCION() {
          return this.NUMERORESOLUCION;
    }
    public void setNUMERORESOLUCION(String NUMERORESOLUCIONIn) {
          this.NUMERORESOLUCION = NUMERORESOLUCIONIn;
    }

    public String getFECHARESOLUCION() {
          return this.FECHARESOLUCION;
    }
    public void setFECHARESOLUCION(String FECHARESOLUCIONIn) {
          this.FECHARESOLUCION = FECHARESOLUCIONIn;
    }

    public int getIDPERSONA() {
          return this.IDPERSONA;
    }
    public void setIDPERSONA(int IDPERSONAIn) {
          this.IDPERSONA = IDPERSONAIn;
    }

    public String getIDENTIFICACION() {
          return this.IDENTIFICACION;
    }
    public void setIDENTIFICACION(String IDENTIFICACIONIn) {
          this.IDENTIFICACION = IDENTIFICACIONIn;
    }

    public String getNOMBRESPERSONA() {
          return this.NOMBRESPERSONA;
    }
    public void setNOMBRESPERSONA(String NOMBRESPERSONAIn) {
          this.NOMBRESPERSONA = NOMBRESPERSONAIn;
    }

    public String getAPELLIDO1() {
          return this.APELLIDO1;
    }
    public void setAPELLIDO1(String APELLIDO1In) {
          this.APELLIDO1 = APELLIDO1In;
    }

    public String getAPELLIDO2() {
          return this.APELLIDO2;
    }
    public void setAPELLIDO2(String APELLIDO2In) {
          this.APELLIDO2 = APELLIDO2In;
    }

    public int getIDCUPOTAXI() {
          return this.IDCUPOTAXI;
    }
    public void setIDCUPOTAXI(int IDCUPOTAXIIn) {
          this.IDCUPOTAXI = IDCUPOTAXIIn;
    }

    public int getNUMEROCUPO() {
          return this.NUMEROCUPO;
    }
    public void setNUMEROCUPO(int NUMEROCUPOIn) {
          this.NUMEROCUPO = NUMEROCUPOIn;
    }

    public int getIDEMPRESADESERVICIO() {
          return this.IDEMPRESADESERVICIO;
    }
    public void setIDEMPRESADESERVICIO(int IDEMPRESADESERVICIOIn) {
          this.IDEMPRESADESERVICIO = IDEMPRESADESERVICIOIn;
    }

    public String getEMPRESADESERVICIO() {
          return this.EMPRESADESERVICIO;
    }
    public void setEMPRESADESERVICIO(String EMPRESADESERVICIOIn) {
          this.EMPRESADESERVICIO = EMPRESADESERVICIOIn;
    }

    public int getIDVEHICULO() {
          return this.IDVEHICULO;
    }
    public void setIDVEHICULO(int IDVEHICULOIn) {
          this.IDVEHICULO = IDVEHICULOIn;
    }

    public String getPLACA() {
          return this.PLACA;
    }
    public void setPLACA(String PLACAIn) {
          this.PLACA = PLACAIn;
    }

    public int getMODELO() {
          return this.MODELO;
    }
    public void setMODELO(int MODELOIn) {
          this.MODELO = MODELOIn;
    }

    public String getNROMOTOR() {
          return this.NROMOTOR;
    }
    public void setNROMOTOR(String NROMOTORIn) {
          this.NROMOTOR = NROMOTORIn;
    }

    public String getCHASIS() {
          return this.CHASIS;
    }
    public void setCHASIS(String CHASISIn) {
          this.CHASIS = CHASISIn;
    }

    public String getIDMARCA() {
          return this.IDMARCA;
    }
    public void setIDMARCA(String IDMARCAIn) {
          this.IDMARCA = IDMARCAIn;
    }

    public String getMARCAVEHICULO() {
          return this.MARCAVEHICULO;
    }
    public void setMARCAVEHICULO(String MARCAVEHICULOIn) {
          this.MARCAVEHICULO = MARCAVEHICULOIn;
    }

    public int getIDTIPOVEHICULO() {
          return this.IDTIPOVEHICULO;
    }
    public void setIDTIPOVEHICULO(int IDTIPOVEHICULOIn) {
          this.IDTIPOVEHICULO = IDTIPOVEHICULOIn;
    }

    public String getNOMTIPOVEHICULO() {
          return this.NOMTIPOVEHICULO;
    }
    public void setNOMTIPOVEHICULO(String NOMTIPOVEHICULOIn) {
          this.NOMTIPOVEHICULO = NOMTIPOVEHICULOIn;
    }

    public String getIDDOCUMENTO() {
          return this.IDDOCUMENTO;
    }
    public void setIDDOCUMENTO(String IDDOCUMENTOIn) {
          this.IDDOCUMENTO = IDDOCUMENTOIn;
    }

    public String getDESCDOCUMENTO() {
          return this.DESCDOCUMENTO;
    }
    public void setDESCDOCUMENTO(String DESCDOCUMENTOIn) {
          this.DESCDOCUMENTO = DESCDOCUMENTOIn;
    }

    public String getADESCRIPCION() {
          return this.ADESCRIPCION;
    }
    public void setADESCRIPCION(String ADESCRIPCIONIn) {
          this.ADESCRIPCION = ADESCRIPCIONIn;
    }

    public String getDFECHAREGISTRO() {
          return this.DFECHAREGISTRO;
    }
    public void setDFECHAREGISTRO(String DFECHAREGISTROIn) {
          this.DFECHAREGISTRO = DFECHAREGISTROIn;
    }



    /** 
     * setAll allows to set all persistent variables in one method call.
     * This is useful, when all data is available and it is needed to 
     * set the initial state of this object. Note that this method will
     * directly modify instance variales, without going trough the 
     * individual set-methods.
     */

    public void setAll(int IDRESOLUCIONIn,
          String NUMERORESOLUCIONIn,
          String FECHARESOLUCIONIn,
          int IDPERSONAIn,
          String IDENTIFICACIONIn,
          String NOMBRESPERSONAIn,
          String APELLIDO1In,
          String APELLIDO2In,
          int IDCUPOTAXIIn,
          int NUMEROCUPOIn,
          int IDEMPRESADESERVICIOIn,
          String EMPRESADESERVICIOIn,
          int IDVEHICULOIn,
          String PLACAIn,
          int MODELOIn,
          String NROMOTORIn,
          String CHASISIn,
          String IDMARCAIn,
          String MARCAVEHICULOIn,
          int IDTIPOVEHICULOIn,
          String NOMTIPOVEHICULOIn,
          String IDDOCUMENTOIn,
          String DESCDOCUMENTOIn,
          String ADESCRIPCIONIn,
          String DFECHAREGISTROIn) {
          this.IDRESOLUCION = IDRESOLUCIONIn;
          this.NUMERORESOLUCION = NUMERORESOLUCIONIn;
          this.FECHARESOLUCION = FECHARESOLUCIONIn;
          this.IDPERSONA = IDPERSONAIn;
          this.IDENTIFICACION = IDENTIFICACIONIn;
          this.NOMBRESPERSONA = NOMBRESPERSONAIn;
          this.APELLIDO1 = APELLIDO1In;
          this.APELLIDO2 = APELLIDO2In;
          this.IDCUPOTAXI = IDCUPOTAXIIn;
          this.NUMEROCUPO = NUMEROCUPOIn;
          this.IDEMPRESADESERVICIO = IDEMPRESADESERVICIOIn;
          this.EMPRESADESERVICIO = EMPRESADESERVICIOIn;
          this.IDVEHICULO = IDVEHICULOIn;
          this.PLACA = PLACAIn;
          this.MODELO = MODELOIn;
          this.NROMOTOR = NROMOTORIn;
          this.CHASIS = CHASISIn;
          this.IDMARCA = IDMARCAIn;
          this.MARCAVEHICULO = MARCAVEHICULOIn;
          this.IDTIPOVEHICULO = IDTIPOVEHICULOIn;
          this.NOMTIPOVEHICULO = NOMTIPOVEHICULOIn;
          this.IDDOCUMENTO = IDDOCUMENTOIn;
          this.DESCDOCUMENTO = DESCDOCUMENTOIn;
          this.ADESCRIPCION = ADESCRIPCIONIn;
          this.DFECHAREGISTRO = DFECHAREGISTROIn;
    }


    /** 
     * hasEqualMapping-method will compare two ViewResoluciones instances
     * and return true if they contain same values in all persistent instance 
     * variables. If hasEqualMapping returns true, it does not mean the objects
     * are the same instance. However it does mean that in that moment, they 
     * are mapped to the same row in database.
     */
    public boolean hasEqualMapping(ViewResoluciones valueObject) {

          if (valueObject.getIDRESOLUCION() != this.IDRESOLUCION) {
                    return(false);
          }
          if (this.NUMERORESOLUCION == null) {
                    if (valueObject.getNUMERORESOLUCION() != null)
                           return(false);
          } else if (!this.NUMERORESOLUCION.equals(valueObject.getNUMERORESOLUCION())) {
                    return(false);
          }
          if (this.FECHARESOLUCION == null) {
                    if (valueObject.getFECHARESOLUCION() != null)
                           return(false);
          } else if (!this.FECHARESOLUCION.equals(valueObject.getFECHARESOLUCION())) {
                    return(false);
          }
          if (valueObject.getIDPERSONA() != this.IDPERSONA) {
                    return(false);
          }
          if (this.IDENTIFICACION == null) {
                    if (valueObject.getIDENTIFICACION() != null)
                           return(false);
          } else if (!this.IDENTIFICACION.equals(valueObject.getIDENTIFICACION())) {
                    return(false);
          }
          if (this.NOMBRESPERSONA == null) {
                    if (valueObject.getNOMBRESPERSONA() != null)
                           return(false);
          } else if (!this.NOMBRESPERSONA.equals(valueObject.getNOMBRESPERSONA())) {
                    return(false);
          }
          if (this.APELLIDO1 == null) {
                    if (valueObject.getAPELLIDO1() != null)
                           return(false);
          } else if (!this.APELLIDO1.equals(valueObject.getAPELLIDO1())) {
                    return(false);
          }
          if (this.APELLIDO2 == null) {
                    if (valueObject.getAPELLIDO2() != null)
                           return(false);
          } else if (!this.APELLIDO2.equals(valueObject.getAPELLIDO2())) {
                    return(false);
          }
          if (valueObject.getIDCUPOTAXI() != this.IDCUPOTAXI) {
                    return(false);
          }
          if (valueObject.getNUMEROCUPO() != this.NUMEROCUPO) {
                    return(false);
          }
          if (valueObject.getIDEMPRESADESERVICIO() != this.IDEMPRESADESERVICIO) {
                    return(false);
          }
          if (this.EMPRESADESERVICIO == null) {
                    if (valueObject.getEMPRESADESERVICIO() != null)
                           return(false);
          } else if (!this.EMPRESADESERVICIO.equals(valueObject.getEMPRESADESERVICIO())) {
                    return(false);
          }
          if (valueObject.getIDVEHICULO() != this.IDVEHICULO) {
                    return(false);
          }
          if (this.PLACA == null) {
                    if (valueObject.getPLACA() != null)
                           return(false);
          } else if (!this.PLACA.equals(valueObject.getPLACA())) {
                    return(false);
          }
          if (valueObject.getMODELO() != this.MODELO) {
                    return(false);
          }
          if (this.NROMOTOR == null) {
                    if (valueObject.getNROMOTOR() != null)
                           return(false);
          } else if (!this.NROMOTOR.equals(valueObject.getNROMOTOR())) {
                    return(false);
          }
          if (this.CHASIS == null) {
                    if (valueObject.getCHASIS() != null)
                           return(false);
          } else if (!this.CHASIS.equals(valueObject.getCHASIS())) {
                    return(false);
          }
          if (this.IDMARCA == null) {
                    if (valueObject.getIDMARCA() != null)
                           return(false);
          } else if (!this.IDMARCA.equals(valueObject.getIDMARCA())) {
                    return(false);
          }
          if (this.MARCAVEHICULO == null) {
                    if (valueObject.getMARCAVEHICULO() != null)
                           return(false);
          } else if (!this.MARCAVEHICULO.equals(valueObject.getMARCAVEHICULO())) {
                    return(false);
          }
          if (valueObject.getIDTIPOVEHICULO() != this.IDTIPOVEHICULO) {
                    return(false);
          }
          if (this.NOMTIPOVEHICULO == null) {
                    if (valueObject.getNOMTIPOVEHICULO() != null)
                           return(false);
          } else if (!this.NOMTIPOVEHICULO.equals(valueObject.getNOMTIPOVEHICULO())) {
                    return(false);
          }
          if (this.IDDOCUMENTO == null) {
                    if (valueObject.getIDDOCUMENTO() != null)
                           return(false);
          } else if (!this.IDDOCUMENTO.equals(valueObject.getIDDOCUMENTO())) {
                    return(false);
          }
          if (this.DESCDOCUMENTO == null) {
                    if (valueObject.getDESCDOCUMENTO() != null)
                           return(false);
          } else if (!this.DESCDOCUMENTO.equals(valueObject.getDESCDOCUMENTO())) {
                    return(false);
          }
          if (this.ADESCRIPCION == null) {
                    if (valueObject.getADESCRIPCION() != null)
                           return(false);
          } else if (!this.ADESCRIPCION.equals(valueObject.getADESCRIPCION())) {
                    return(false);
          }
          if (this.DFECHAREGISTRO == null) {
                    if (valueObject.getDFECHAREGISTRO() != null)
                           return(false);
          } else if (!this.DFECHAREGISTRO.equals(valueObject.getDFECHAREGISTRO())) {
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
        out.append("\nclass ViewResoluciones, mapping to table ViewResoluciones\n");
        out.append("Persistent attributes: \n"); 
        out.append("IDRESOLUCION = " + this.IDRESOLUCION + "\n"); 
        out.append("NUMERORESOLUCION = " + this.NUMERORESOLUCION + "\n"); 
        out.append("FECHARESOLUCION = " + this.FECHARESOLUCION + "\n"); 
        out.append("IDPERSONA = " + this.IDPERSONA + "\n"); 
        out.append("IDENTIFICACION = " + this.IDENTIFICACION + "\n"); 
        out.append("NOMBRESPERSONA = " + this.NOMBRESPERSONA + "\n"); 
        out.append("APELLIDO1 = " + this.APELLIDO1 + "\n"); 
        out.append("APELLIDO2 = " + this.APELLIDO2 + "\n"); 
        out.append("IDCUPOTAXI = " + this.IDCUPOTAXI + "\n"); 
        out.append("NUMEROCUPO = " + this.NUMEROCUPO + "\n"); 
        out.append("IDEMPRESADESERVICIO = " + this.IDEMPRESADESERVICIO + "\n"); 
        out.append("EMPRESADESERVICIO = " + this.EMPRESADESERVICIO + "\n"); 
        out.append("IDVEHICULO = " + this.IDVEHICULO + "\n"); 
        out.append("PLACA = " + this.PLACA + "\n"); 
        out.append("MODELO = " + this.MODELO + "\n"); 
        out.append("NROMOTOR = " + this.NROMOTOR + "\n"); 
        out.append("CHASIS = " + this.CHASIS + "\n"); 
        out.append("IDMARCA = " + this.IDMARCA + "\n"); 
        out.append("MARCAVEHICULO = " + this.MARCAVEHICULO + "\n"); 
        out.append("IDTIPOVEHICULO = " + this.IDTIPOVEHICULO + "\n"); 
        out.append("NOMTIPOVEHICULO = " + this.NOMTIPOVEHICULO + "\n"); 
        out.append("IDDOCUMENTO = " + this.IDDOCUMENTO + "\n"); 
        out.append("DESCDOCUMENTO = " + this.DESCDOCUMENTO + "\n"); 
        out.append("ADESCRIPCION = " + this.ADESCRIPCION + "\n"); 
        out.append("DFECHAREGISTRO = " + this.DFECHAREGISTRO + "\n"); 
        return out.toString();
    }


    /**
     * Clone will return identical deep copy of this valueObject.
     * Note, that this method is different than the clone() which
     * is defined in java.lang.Object. Here, the retuned cloned object
     * will also have all its attributes cloned.
     */
    public Object clone() {
        ViewResoluciones cloned = new ViewResoluciones();

        cloned.setIDRESOLUCION(this.IDRESOLUCION); 
        if (this.NUMERORESOLUCION != null)
             cloned.setNUMERORESOLUCION(new String(this.NUMERORESOLUCION)); 
        if (this.FECHARESOLUCION != null)
             cloned.setFECHARESOLUCION(new String(this.FECHARESOLUCION)); 
        cloned.setIDPERSONA(this.IDPERSONA); 
        if (this.IDENTIFICACION != null)
             cloned.setIDENTIFICACION(new String(this.IDENTIFICACION)); 
        if (this.NOMBRESPERSONA != null)
             cloned.setNOMBRESPERSONA(new String(this.NOMBRESPERSONA)); 
        if (this.APELLIDO1 != null)
             cloned.setAPELLIDO1(new String(this.APELLIDO1)); 
        if (this.APELLIDO2 != null)
             cloned.setAPELLIDO2(new String(this.APELLIDO2)); 
        cloned.setIDCUPOTAXI(this.IDCUPOTAXI); 
        cloned.setNUMEROCUPO(this.NUMEROCUPO); 
        cloned.setIDEMPRESADESERVICIO(this.IDEMPRESADESERVICIO); 
        if (this.EMPRESADESERVICIO != null)
             cloned.setEMPRESADESERVICIO(new String(this.EMPRESADESERVICIO)); 
        cloned.setIDVEHICULO(this.IDVEHICULO); 
        if (this.PLACA != null)
             cloned.setPLACA(new String(this.PLACA)); 
        cloned.setMODELO(this.MODELO); 
        if (this.NROMOTOR != null)
             cloned.setNROMOTOR(new String(this.NROMOTOR)); 
        if (this.CHASIS != null)
             cloned.setCHASIS(new String(this.CHASIS)); 
        if (this.IDMARCA != null)
             cloned.setIDMARCA(new String(this.IDMARCA)); 
        if (this.MARCAVEHICULO != null)
             cloned.setMARCAVEHICULO(new String(this.MARCAVEHICULO)); 
        cloned.setIDTIPOVEHICULO(this.IDTIPOVEHICULO); 
        if (this.NOMTIPOVEHICULO != null)
             cloned.setNOMTIPOVEHICULO(new String(this.NOMTIPOVEHICULO)); 
        if (this.IDDOCUMENTO != null)
             cloned.setIDDOCUMENTO(new String(this.IDDOCUMENTO)); 
        if (this.DESCDOCUMENTO != null)
             cloned.setDESCDOCUMENTO(new String(this.DESCDOCUMENTO)); 
        if (this.ADESCRIPCION != null)
             cloned.setADESCRIPCION(new String(this.ADESCRIPCION)); 
        if (this.DFECHAREGISTRO != null)
             cloned.setDFECHAREGISTRO(new String(this.DFECHAREGISTRO)); 
        return cloned;
    }



    /** 
     * getDaogenVersion will return information about
     * generator which created these sources.
     */
    public String getDaogenVersion() {
        return "DaoGen version 2.4.1";
    }

    public int getIDTIPORESOLUCION() {
        return IDTIPORESOLUCION;
    }

    public void setIDTIPORESOLUCION(int IDTIPORESOLUCION) {
        this.IDTIPORESOLUCION = IDTIPORESOLUCION;
    }
}
