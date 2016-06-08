package modelo.datos.objetos.tramites;

import java.io.*;
import java.sql.*;
import java.util.*;
import java.math.*;

 /**
  * Runtactaimportacion Value Object.
  * This class is value object representing database table RUNTACTAIMPORTACION
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



public class Runtactaimportacion implements Cloneable, Serializable {

    /** 
     * Persistent Instance variables. This data is directly 
     * mapped to the columns of database table.
     */
    private int ID_RUNTACTAMANIFIMPORT;
    private String NUMACTAMANIFIMPORTACION;
    private String FECHAMANIFIESTO;
    private String FECHALEVANTE;
    private int NUMEROBULTOS;
    private int NUMEROCUOTAS;
    private String NUMSUBPARTARANCE;
    private String NUMEROLEVANTE;
    private int PAISORIGEN;
    private String ESTADO;
    private String NUMDECLARAVIGENTE;
    private int MODALIDADDECLARAIMP;
    private int TIPODECLARACION;
    private int TIPOIMPORTACION;
    private int ID_VEHICULO;
    private int ID_IMPORTADOR;
    private String ID_DOCTO;
    private String DOCIMP;
    private int ID_TIPO_REGISTRO;
    private int ID_TIPO_AUTOMOTOR;
    private String CARGADO;



    /** 
     * Constructors. DaoGen generates two constructors by default.
     * The first one takes no arguments and provides the most simple
     * way to create object instance. The another one takes one
     * argument, which is the primary key of the corresponding table.
     */

    public Runtactaimportacion () {

    }

    public Runtactaimportacion (int ID_RUNTACTAMANIFIMPORTIn) {

          this.ID_RUNTACTAMANIFIMPORT = ID_RUNTACTAMANIFIMPORTIn;

    }


    /** 
     * Get- and Set-methods for persistent variables. The default
     * behaviour does not make any checks against malformed data,
     * so these might require some manual additions.
     */

    public int getID_RUNTACTAMANIFIMPORT() {
          return this.ID_RUNTACTAMANIFIMPORT;
    }
    public void setID_RUNTACTAMANIFIMPORT(int ID_RUNTACTAMANIFIMPORTIn) {
          this.ID_RUNTACTAMANIFIMPORT = ID_RUNTACTAMANIFIMPORTIn;
    }

    public String getNUMACTAMANIFIMPORTACION() {
          return this.NUMACTAMANIFIMPORTACION;
    }
    public void setNUMACTAMANIFIMPORTACION(String NUMACTAMANIFIMPORTACIONIn) {
          this.NUMACTAMANIFIMPORTACION = NUMACTAMANIFIMPORTACIONIn;
    }

    public String getFECHAMANIFIESTO() {
          return this.FECHAMANIFIESTO;
    }
    public void setFECHAMANIFIESTO(String FECHAMANIFIESTOIn) {
          this.FECHAMANIFIESTO = FECHAMANIFIESTOIn;
    }

    public String getFECHALEVANTE() {
          return this.FECHALEVANTE;
    }
    public void setFECHALEVANTE(String FECHALEVANTEIn) {
          this.FECHALEVANTE = FECHALEVANTEIn;
    }

    public int getNUMEROBULTOS() {
          return this.NUMEROBULTOS;
    }
    public void setNUMEROBULTOS(int NUMEROBULTOSIn) {
          this.NUMEROBULTOS = NUMEROBULTOSIn;
    }

    public int getNUMEROCUOTAS() {
          return this.NUMEROCUOTAS;
    }
    public void setNUMEROCUOTAS(int NUMEROCUOTASIn) {
          this.NUMEROCUOTAS = NUMEROCUOTASIn;
    }

    public String getNUMSUBPARTARANCE() {
          return this.NUMSUBPARTARANCE;
    }
    public void setNUMSUBPARTARANCE(String NUMSUBPARTARANCEIn) {
          this.NUMSUBPARTARANCE = NUMSUBPARTARANCEIn;
    }

    public String getNUMEROLEVANTE() {
          return this.NUMEROLEVANTE;
    }
    public void setNUMEROLEVANTE(String NUMEROLEVANTEIn) {
          this.NUMEROLEVANTE = NUMEROLEVANTEIn;
    }

    public int getPAISORIGEN() {
          return this.PAISORIGEN;
    }
    public void setPAISORIGEN(int PAISORIGENIn) {
          this.PAISORIGEN = PAISORIGENIn;
    }

    public String getESTADO() {
          return this.ESTADO;
    }
    public void setESTADO(String ESTADOIn) {
          this.ESTADO = ESTADOIn;
    }

    public String getNUMDECLARAVIGENTE() {
          return this.NUMDECLARAVIGENTE;
    }
    public void setNUMDECLARAVIGENTE(String NUMDECLARAVIGENTEIn) {
          this.NUMDECLARAVIGENTE = NUMDECLARAVIGENTEIn;
    }

    public int getMODALIDADDECLARAIMP() {
          return this.MODALIDADDECLARAIMP;
    }
    public void setMODALIDADDECLARAIMP(int MODALIDADDECLARAIMPIn) {
          this.MODALIDADDECLARAIMP = MODALIDADDECLARAIMPIn;
    }

    public int getTIPODECLARACION() {
          return this.TIPODECLARACION;
    }
    public void setTIPODECLARACION(int TIPODECLARACIONIn) {
          this.TIPODECLARACION = TIPODECLARACIONIn;
    }

    public int getTIPOIMPORTACION() {
          return this.TIPOIMPORTACION;
    }
    public void setTIPOIMPORTACION(int TIPOIMPORTACIONIn) {
          this.TIPOIMPORTACION = TIPOIMPORTACIONIn;
    }

    public int getID_VEHICULO() {
          return this.ID_VEHICULO;
    }
    public void setID_VEHICULO(int ID_VEHICULOIn) {
          this.ID_VEHICULO = ID_VEHICULOIn;
    }

    public int getID_IMPORTADOR() {
          return this.ID_IMPORTADOR;
    }
    public void setID_IMPORTADOR(int ID_IMPORTADORIn) {
          this.ID_IMPORTADOR = ID_IMPORTADORIn;
    }

    public String getID_DOCTO() {
          return this.ID_DOCTO;
    }
    public void setID_DOCTO(String ID_DOCTOIn) {
          this.ID_DOCTO = ID_DOCTOIn;
    }

    public String getDOCIMP() {
          return this.DOCIMP;
    }
    public void setDOCIMP(String DOCIMPIn) {
          this.DOCIMP = DOCIMPIn;
    }

    public int getID_TIPO_REGISTRO() {
          return this.ID_TIPO_REGISTRO;
    }
    public void setID_TIPO_REGISTRO(int ID_TIPO_REGISTROIn) {
          this.ID_TIPO_REGISTRO = ID_TIPO_REGISTROIn;
    }

    public int getID_TIPO_AUTOMOTOR() {
          return this.ID_TIPO_AUTOMOTOR;
    }
    public void setID_TIPO_AUTOMOTOR(int ID_TIPO_AUTOMOTORIn) {
          this.ID_TIPO_AUTOMOTOR = ID_TIPO_AUTOMOTORIn;
    }

    public String getCARGADO() {
          return this.CARGADO;
    }
    public void setCARGADO(String CARGADOIn) {
          this.CARGADO = CARGADOIn;
    }



    /** 
     * setAll allows to set all persistent variables in one method call.
     * This is useful, when all data is available and it is needed to 
     * set the initial state of this object. Note that this method will
     * directly modify instance variales, without going trough the 
     * individual set-methods.
     */

    public void setAll(int ID_RUNTACTAMANIFIMPORTIn,
          String NUMACTAMANIFIMPORTACIONIn,
          String FECHAMANIFIESTOIn,
          String FECHALEVANTEIn,
          int NUMEROBULTOSIn,
          int NUMEROCUOTASIn,
          String NUMSUBPARTARANCEIn,
          String NUMEROLEVANTEIn,
          int PAISORIGENIn,
          String ESTADOIn,
          String NUMDECLARAVIGENTEIn,
          int MODALIDADDECLARAIMPIn,
          int TIPODECLARACIONIn,
          int TIPOIMPORTACIONIn,
          int ID_VEHICULOIn,
          int ID_IMPORTADORIn,
          String ID_DOCTOIn,
          String DOCIMPIn,
          int ID_TIPO_REGISTROIn,
          int ID_TIPO_AUTOMOTORIn,
          String CARGADOIn) {
          this.ID_RUNTACTAMANIFIMPORT = ID_RUNTACTAMANIFIMPORTIn;
          this.NUMACTAMANIFIMPORTACION = NUMACTAMANIFIMPORTACIONIn;
          this.FECHAMANIFIESTO = FECHAMANIFIESTOIn;
          this.FECHALEVANTE = FECHALEVANTEIn;
          this.NUMEROBULTOS = NUMEROBULTOSIn;
          this.NUMEROCUOTAS = NUMEROCUOTASIn;
          this.NUMSUBPARTARANCE = NUMSUBPARTARANCEIn;
          this.NUMEROLEVANTE = NUMEROLEVANTEIn;
          this.PAISORIGEN = PAISORIGENIn;
          this.ESTADO = ESTADOIn;
          this.NUMDECLARAVIGENTE = NUMDECLARAVIGENTEIn;
          this.MODALIDADDECLARAIMP = MODALIDADDECLARAIMPIn;
          this.TIPODECLARACION = TIPODECLARACIONIn;
          this.TIPOIMPORTACION = TIPOIMPORTACIONIn;
          this.ID_VEHICULO = ID_VEHICULOIn;
          this.ID_IMPORTADOR = ID_IMPORTADORIn;
          this.ID_DOCTO = ID_DOCTOIn;
          this.DOCIMP = DOCIMPIn;
          this.ID_TIPO_REGISTRO = ID_TIPO_REGISTROIn;
          this.ID_TIPO_AUTOMOTOR = ID_TIPO_AUTOMOTORIn;
          this.CARGADO = CARGADOIn;
    }


    /** 
     * hasEqualMapping-method will compare two Runtactaimportacion instances
     * and return true if they contain same values in all persistent instance 
     * variables. If hasEqualMapping returns true, it does not mean the objects
     * are the same instance. However it does mean that in that moment, they 
     * are mapped to the same row in database.
     */
    public boolean hasEqualMapping(Runtactaimportacion valueObject) {

          if (valueObject.getID_RUNTACTAMANIFIMPORT() != this.ID_RUNTACTAMANIFIMPORT) {
                    return(false);
          }
          if (this.NUMACTAMANIFIMPORTACION == null) {
                    if (valueObject.getNUMACTAMANIFIMPORTACION() != null)
                           return(false);
          } else if (!this.NUMACTAMANIFIMPORTACION.equals(valueObject.getNUMACTAMANIFIMPORTACION())) {
                    return(false);
          }
          if (this.FECHAMANIFIESTO == null) {
                    if (valueObject.getFECHAMANIFIESTO() != null)
                           return(false);
          } else if (!this.FECHAMANIFIESTO.equals(valueObject.getFECHAMANIFIESTO())) {
                    return(false);
          }
          if (this.FECHALEVANTE == null) {
                    if (valueObject.getFECHALEVANTE() != null)
                           return(false);
          } else if (!this.FECHALEVANTE.equals(valueObject.getFECHALEVANTE())) {
                    return(false);
          }
          if (valueObject.getNUMEROBULTOS() != this.NUMEROBULTOS) {
                    return(false);
          }
          if (valueObject.getNUMEROCUOTAS() != this.NUMEROCUOTAS) {
                    return(false);
          }
          if (this.NUMSUBPARTARANCE == null) {
                    if (valueObject.getNUMSUBPARTARANCE() != null)
                           return(false);
          } else if (!this.NUMSUBPARTARANCE.equals(valueObject.getNUMSUBPARTARANCE())) {
                    return(false);
          }
          if (this.NUMEROLEVANTE == null) {
                    if (valueObject.getNUMEROLEVANTE() != null)
                           return(false);
          } else if (!this.NUMEROLEVANTE.equals(valueObject.getNUMEROLEVANTE())) {
                    return(false);
          }
          if (valueObject.getPAISORIGEN() != this.PAISORIGEN) {
                    return(false);
          }
          if (this.ESTADO == null) {
                    if (valueObject.getESTADO() != null)
                           return(false);
          } else if (!this.ESTADO.equals(valueObject.getESTADO())) {
                    return(false);
          }
          if (this.NUMDECLARAVIGENTE == null) {
                    if (valueObject.getNUMDECLARAVIGENTE() != null)
                           return(false);
          } else if (!this.NUMDECLARAVIGENTE.equals(valueObject.getNUMDECLARAVIGENTE())) {
                    return(false);
          }
          if (valueObject.getMODALIDADDECLARAIMP() != this.MODALIDADDECLARAIMP) {
                    return(false);
          }
          if (valueObject.getTIPODECLARACION() != this.TIPODECLARACION) {
                    return(false);
          }
          if (valueObject.getTIPOIMPORTACION() != this.TIPOIMPORTACION) {
                    return(false);
          }
          if (valueObject.getID_VEHICULO() != this.ID_VEHICULO) {
                    return(false);
          }
          if (valueObject.getID_IMPORTADOR() != this.ID_IMPORTADOR) {
                    return(false);
          }
          if (valueObject.getID_DOCTO() != this.ID_DOCTO) {
                    return(false);
          }
          if (this.DOCIMP == null) {
                    if (valueObject.getDOCIMP() != null)
                           return(false);
          } else if (!this.DOCIMP.equals(valueObject.getDOCIMP())) {
                    return(false);
          }
          if (valueObject.getID_TIPO_REGISTRO() != this.ID_TIPO_REGISTRO) {
                    return(false);
          }
          if (valueObject.getID_TIPO_AUTOMOTOR() != this.ID_TIPO_AUTOMOTOR) {
                    return(false);
          }
          if (this.CARGADO == null) {
                    if (valueObject.getCARGADO() != null)
                           return(false);
          } else if (!this.CARGADO.equals(valueObject.getCARGADO())) {
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
        out.append("\nclass Runtactaimportacion, mapping to table RUNTACTAIMPORTACION\n");
        out.append("Persistent attributes: \n"); 
        out.append("ID_RUNTACTAMANIFIMPORT = " + this.ID_RUNTACTAMANIFIMPORT + "\n"); 
        out.append("NUMACTAMANIFIMPORTACION = " + this.NUMACTAMANIFIMPORTACION + "\n"); 
        out.append("FECHAMANIFIESTO = " + this.FECHAMANIFIESTO + "\n"); 
        out.append("FECHALEVANTE = " + this.FECHALEVANTE + "\n"); 
        out.append("NUMEROBULTOS = " + this.NUMEROBULTOS + "\n"); 
        out.append("NUMEROCUOTAS = " + this.NUMEROCUOTAS + "\n"); 
        out.append("NUMSUBPARTARANCE = " + this.NUMSUBPARTARANCE + "\n"); 
        out.append("NUMEROLEVANTE = " + this.NUMEROLEVANTE + "\n"); 
        out.append("PAISORIGEN = " + this.PAISORIGEN + "\n"); 
        out.append("ESTADO = " + this.ESTADO + "\n"); 
        out.append("NUMDECLARAVIGENTE = " + this.NUMDECLARAVIGENTE + "\n"); 
        out.append("MODALIDADDECLARAIMP = " + this.MODALIDADDECLARAIMP + "\n"); 
        out.append("TIPODECLARACION = " + this.TIPODECLARACION + "\n"); 
        out.append("TIPOIMPORTACION = " + this.TIPOIMPORTACION + "\n"); 
        out.append("ID_VEHICULO = " + this.ID_VEHICULO + "\n"); 
        out.append("ID_IMPORTADOR = " + this.ID_IMPORTADOR + "\n"); 
        out.append("ID_DOCTO = " + this.ID_DOCTO + "\n"); 
        out.append("DOCIMP = " + this.DOCIMP + "\n"); 
        out.append("ID_TIPO_REGISTRO = " + this.ID_TIPO_REGISTRO + "\n"); 
        out.append("ID_TIPO_AUTOMOTOR = " + this.ID_TIPO_AUTOMOTOR + "\n"); 
        out.append("CARGADO = " + this.CARGADO + "\n"); 
        return out.toString();
    }


    /**
     * Clone will return identical deep copy of this valueObject.
     * Note, that this method is different than the clone() which
     * is defined in java.lang.Object. Here, the retuned cloned object
     * will also have all its attributes cloned.
     */
    public Object clone() {
        Runtactaimportacion cloned = new Runtactaimportacion();

        cloned.setID_RUNTACTAMANIFIMPORT(this.ID_RUNTACTAMANIFIMPORT); 
        if (this.NUMACTAMANIFIMPORTACION != null)
             cloned.setNUMACTAMANIFIMPORTACION(new String(this.NUMACTAMANIFIMPORTACION)); 
        if (this.FECHAMANIFIESTO != null)
             cloned.setFECHAMANIFIESTO(new String(this.FECHAMANIFIESTO)); 
        if (this.FECHALEVANTE != null)
             cloned.setFECHALEVANTE(new String(this.FECHALEVANTE)); 
        cloned.setNUMEROBULTOS(this.NUMEROBULTOS); 
        cloned.setNUMEROCUOTAS(this.NUMEROCUOTAS); 
        if (this.NUMSUBPARTARANCE != null)
             cloned.setNUMSUBPARTARANCE(new String(this.NUMSUBPARTARANCE)); 
        if (this.NUMEROLEVANTE != null)
             cloned.setNUMEROLEVANTE(new String(this.NUMEROLEVANTE)); 
        cloned.setPAISORIGEN(this.PAISORIGEN); 
        if (this.ESTADO != null)
             cloned.setESTADO(new String(this.ESTADO)); 
        if (this.NUMDECLARAVIGENTE != null)
             cloned.setNUMDECLARAVIGENTE(new String(this.NUMDECLARAVIGENTE)); 
        cloned.setMODALIDADDECLARAIMP(this.MODALIDADDECLARAIMP); 
        cloned.setTIPODECLARACION(this.TIPODECLARACION); 
        cloned.setTIPOIMPORTACION(this.TIPOIMPORTACION); 
        cloned.setID_VEHICULO(this.ID_VEHICULO); 
        cloned.setID_IMPORTADOR(this.ID_IMPORTADOR); 
        cloned.setID_DOCTO(this.ID_DOCTO); 
        if (this.DOCIMP != null)
             cloned.setDOCIMP(new String(this.DOCIMP)); 
        cloned.setID_TIPO_REGISTRO(this.ID_TIPO_REGISTRO); 
        cloned.setID_TIPO_AUTOMOTOR(this.ID_TIPO_AUTOMOTOR); 
        if (this.CARGADO != null)
             cloned.setCARGADO(new String(this.CARGADO)); 
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