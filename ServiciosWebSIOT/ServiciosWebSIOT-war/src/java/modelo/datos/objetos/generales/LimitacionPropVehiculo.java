package modelo.datos.objetos.generales;

import java.io.*;
import java.sql.*;
import java.util.*;
import java.math.*;

 /**
  * LimitacionPropVehiculo Value Object.
  * This class is value object representing database table LIMITACIONPROP_VEHICULO
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



public class LimitacionPropVehiculo implements Cloneable, Serializable {

    /** 
     * Persistent Instance variables. This data is directly 
     * mapped to the columns of database table.
     */
    private int IDLIMITAC_VEHICULO;
    private int ID_VEHICULO;
    private int ID_LIMITACION;
    private String FECHARADICA_LIMITACION;
    private String HORARADICA_LIMITACION;
    private String ACREEDOR;
    private String IDENTIFICACIONACREEDOR;
    private String ID_DOCUMENTO;
    private int ID_CIUDADACREEDOR;
    private String NUMNOTARIA_LIMITACION;
    private int IDCIUDAD_NOTARIALIMITAC;
    private String FECHAAUTENTICACIONLIMITACION;
    private double VALORLIMITACION;
    private String FECHACANCELALIMITACION;
    private String NUMDOCTOCANCELACION;
    private String NUMNOTARIA_CANCELACION;
    private String FECHAAUTENTICACIONCANCELACION;
    private int IDCIUDAD_NOTARIACANCELAC;
    private String ESTADOLIMITACION;
    private int ID_RECIBOLIQ;
    private int ID_GRADOALERTA;
    private int ID_TIPO_ALERTA;
    private String TIPOPERSONA;
    private String DESCRIPCIONAUTORIZACION;



    /** 
     * Constructors. DaoGen generates two constructors by default.
     * The first one takes no arguments and provides the most simple
     * way to create object instance. The another one takes one
     * argument, which is the primary key of the corresponding table.
     */

    public LimitacionPropVehiculo () {

    }

    public LimitacionPropVehiculo (int IDLIMITAC_VEHICULOIn) {

          this.IDLIMITAC_VEHICULO = IDLIMITAC_VEHICULOIn;

    }


    /** 
     * Get- and Set-methods for persistent variables. The default
     * behaviour does not make any checks against malformed data,
     * so these might require some manual additions.
     */

    public int getIDLIMITAC_VEHICULO() {
          return this.IDLIMITAC_VEHICULO;
    }
    public void setIDLIMITAC_VEHICULO(int IDLIMITAC_VEHICULOIn) {
          this.IDLIMITAC_VEHICULO = IDLIMITAC_VEHICULOIn;
    }

    public int getID_VEHICULO() {
          return this.ID_VEHICULO;
    }
    public void setID_VEHICULO(int ID_VEHICULOIn) {
          this.ID_VEHICULO = ID_VEHICULOIn;
    }

    public int getID_LIMITACION() {
          return this.ID_LIMITACION;
    }
    public void setID_LIMITACION(int ID_LIMITACIONIn) {
          this.ID_LIMITACION = ID_LIMITACIONIn;
    }

    public String getFECHARADICA_LIMITACION() {
          return this.FECHARADICA_LIMITACION;
    }
    public void setFECHARADICA_LIMITACION(String FECHARADICA_LIMITACIONIn) {
          this.FECHARADICA_LIMITACION = FECHARADICA_LIMITACIONIn;
    }

    public String getHORARADICA_LIMITACION() {
          return this.HORARADICA_LIMITACION;
    }
    public void setHORARADICA_LIMITACION(String HORARADICA_LIMITACIONIn) {
          this.HORARADICA_LIMITACION = HORARADICA_LIMITACIONIn;
    }

    public String getACREEDOR() {
          return this.ACREEDOR;
    }
    public void setACREEDOR(String ACREEDORIn) {
          this.ACREEDOR = ACREEDORIn;
    }

    public String getIDENTIFICACIONACREEDOR() {
          return this.IDENTIFICACIONACREEDOR;
    }
    public void setIDENTIFICACIONACREEDOR(String IDENTIFICACIONACREEDORIn) {
          this.IDENTIFICACIONACREEDOR = IDENTIFICACIONACREEDORIn;
    }

    public String getID_DOCUMENTO() {
          return this.ID_DOCUMENTO;
    }
    public void setID_DOCUMENTO(String ID_DOCUMENTOIn) {
          this.ID_DOCUMENTO = ID_DOCUMENTOIn;
    }

    public int getID_CIUDADACREEDOR() {
          return this.ID_CIUDADACREEDOR;
    }
    public void setID_CIUDADACREEDOR(int ID_CIUDADACREEDORIn) {
          this.ID_CIUDADACREEDOR = ID_CIUDADACREEDORIn;
    }

    public String getNUMNOTARIA_LIMITACION() {
          return this.NUMNOTARIA_LIMITACION;
    }
    public void setNUMNOTARIA_LIMITACION(String NUMNOTARIA_LIMITACIONIn) {
          this.NUMNOTARIA_LIMITACION = NUMNOTARIA_LIMITACIONIn;
    }

    public int getIDCIUDAD_NOTARIALIMITAC() {
          return this.IDCIUDAD_NOTARIALIMITAC;
    }
    public void setIDCIUDAD_NOTARIALIMITAC(int IDCIUDAD_NOTARIALIMITACIn) {
          this.IDCIUDAD_NOTARIALIMITAC = IDCIUDAD_NOTARIALIMITACIn;
    }

    public String getFECHAAUTENTICACIONLIMITACION() {
          return this.FECHAAUTENTICACIONLIMITACION;
    }
    public void setFECHAAUTENTICACIONLIMITACION(String FECHAAUTENTICACIONLIMITACIONIn) {
          this.FECHAAUTENTICACIONLIMITACION = FECHAAUTENTICACIONLIMITACIONIn;
    }

    public double getVALORLIMITACION() {
          return this.VALORLIMITACION;
    }
    public void setVALORLIMITACION(double VALORLIMITACIONIn) {
          this.VALORLIMITACION = VALORLIMITACIONIn;
    }

    public String getFECHACANCELALIMITACION() {
          return this.FECHACANCELALIMITACION;
    }
    public void setFECHACANCELALIMITACION(String FECHACANCELALIMITACIONIn) {
          this.FECHACANCELALIMITACION = FECHACANCELALIMITACIONIn;
    }

    public String getNUMDOCTOCANCELACION() {
          return this.NUMDOCTOCANCELACION;
    }
    public void setNUMDOCTOCANCELACION(String NUMDOCTOCANCELACIONIn) {
          this.NUMDOCTOCANCELACION = NUMDOCTOCANCELACIONIn;
    }

    public String getNUMNOTARIA_CANCELACION() {
          return this.NUMNOTARIA_CANCELACION;
    }
    public void setNUMNOTARIA_CANCELACION(String NUMNOTARIA_CANCELACIONIn) {
          this.NUMNOTARIA_CANCELACION = NUMNOTARIA_CANCELACIONIn;
    }

    public String getFECHAAUTENTICACIONCANCELACION() {
          return this.FECHAAUTENTICACIONCANCELACION;
    }
    public void setFECHAAUTENTICACIONCANCELACION(String FECHAAUTENTICACIONCANCELACIONIn) {
          this.FECHAAUTENTICACIONCANCELACION = FECHAAUTENTICACIONCANCELACIONIn;
    }

    public int getIDCIUDAD_NOTARIACANCELAC() {
          return this.IDCIUDAD_NOTARIACANCELAC;
    }
    public void setIDCIUDAD_NOTARIACANCELAC(int IDCIUDAD_NOTARIACANCELACIn) {
          this.IDCIUDAD_NOTARIACANCELAC = IDCIUDAD_NOTARIACANCELACIn;
    }

    public String getESTADOLIMITACION() {
          return this.ESTADOLIMITACION;
    }
    public void setESTADOLIMITACION(String ESTADOLIMITACIONIn) {
          this.ESTADOLIMITACION = ESTADOLIMITACIONIn;
    }

    public int getID_RECIBOLIQ() {
          return this.ID_RECIBOLIQ;
    }
    public void setID_RECIBOLIQ(int ID_RECIBOLIQIn) {
          this.ID_RECIBOLIQ = ID_RECIBOLIQIn;
    }

    public int getID_GRADOALERTA() {
          return this.ID_GRADOALERTA;
    }
    public void setID_GRADOALERTA(int ID_GRADOALERTAIn) {
          this.ID_GRADOALERTA = ID_GRADOALERTAIn;
    }

    public int getID_TIPO_ALERTA() {
          return this.ID_TIPO_ALERTA;
    }
    public void setID_TIPO_ALERTA(int ID_TIPO_ALERTAIn) {
          this.ID_TIPO_ALERTA = ID_TIPO_ALERTAIn;
    }

    public String getTIPOPERSONA() {
          return this.TIPOPERSONA;
    }
    public void setTIPOPERSONA(String TIPOPERSONAIn) {
          this.TIPOPERSONA = TIPOPERSONAIn;
    }

    public String getDESCRIPCIONAUTORIZACION() {
          return this.DESCRIPCIONAUTORIZACION;
    }
    public void setDESCRIPCIONAUTORIZACION(String DESCRIPCIONAUTORIZACIONIn) {
          this.DESCRIPCIONAUTORIZACION = DESCRIPCIONAUTORIZACIONIn;
    }



    /** 
     * setAll allows to set all persistent variables in one method call.
     * This is useful, when all data is available and it is needed to 
     * set the initial state of this object. Note that this method will
     * directly modify instance variales, without going trough the 
     * individual set-methods.
     */

    public void setAll(int IDLIMITAC_VEHICULOIn,
          int ID_VEHICULOIn,
          int ID_LIMITACIONIn,
          String FECHARADICA_LIMITACIONIn,
          String HORARADICA_LIMITACIONIn,
          String ACREEDORIn,
          String IDENTIFICACIONACREEDORIn,
          String ID_DOCUMENTOIn,
          int ID_CIUDADACREEDORIn,
          String NUMNOTARIA_LIMITACIONIn,
          int IDCIUDAD_NOTARIALIMITACIn,
          String FECHAAUTENTICACIONLIMITACIONIn,
          double VALORLIMITACIONIn,
          String FECHACANCELALIMITACIONIn,
          String NUMDOCTOCANCELACIONIn,
          String NUMNOTARIA_CANCELACIONIn,
          String FECHAAUTENTICACIONCANCELACIONIn,
          int IDCIUDAD_NOTARIACANCELACIn,
          String ESTADOLIMITACIONIn,
          int ID_RECIBOLIQIn,
          int ID_GRADOALERTAIn,
          int ID_TIPO_ALERTAIn,
          String TIPOPERSONAIn,
          String DESCRIPCIONAUTORIZACIONIn) {
          this.IDLIMITAC_VEHICULO = IDLIMITAC_VEHICULOIn;
          this.ID_VEHICULO = ID_VEHICULOIn;
          this.ID_LIMITACION = ID_LIMITACIONIn;
          this.FECHARADICA_LIMITACION = FECHARADICA_LIMITACIONIn;
          this.HORARADICA_LIMITACION = HORARADICA_LIMITACIONIn;
          this.ACREEDOR = ACREEDORIn;
          this.IDENTIFICACIONACREEDOR = IDENTIFICACIONACREEDORIn;
          this.ID_DOCUMENTO = ID_DOCUMENTOIn;
          this.ID_CIUDADACREEDOR = ID_CIUDADACREEDORIn;
          this.NUMNOTARIA_LIMITACION = NUMNOTARIA_LIMITACIONIn;
          this.IDCIUDAD_NOTARIALIMITAC = IDCIUDAD_NOTARIALIMITACIn;
          this.FECHAAUTENTICACIONLIMITACION = FECHAAUTENTICACIONLIMITACIONIn;
          this.VALORLIMITACION = VALORLIMITACIONIn;
          this.FECHACANCELALIMITACION = FECHACANCELALIMITACIONIn;
          this.NUMDOCTOCANCELACION = NUMDOCTOCANCELACIONIn;
          this.NUMNOTARIA_CANCELACION = NUMNOTARIA_CANCELACIONIn;
          this.FECHAAUTENTICACIONCANCELACION = FECHAAUTENTICACIONCANCELACIONIn;
          this.IDCIUDAD_NOTARIACANCELAC = IDCIUDAD_NOTARIACANCELACIn;
          this.ESTADOLIMITACION = ESTADOLIMITACIONIn;
          this.ID_RECIBOLIQ = ID_RECIBOLIQIn;
          this.ID_GRADOALERTA = ID_GRADOALERTAIn;
          this.ID_TIPO_ALERTA = ID_TIPO_ALERTAIn;
          this.TIPOPERSONA = TIPOPERSONAIn;
          this.DESCRIPCIONAUTORIZACION = DESCRIPCIONAUTORIZACIONIn;
    }


    /** 
     * hasEqualMapping-method will compare two LimitacionPropVehiculo instances
     * and return true if they contain same values in all persistent instance 
     * variables. If hasEqualMapping returns true, it does not mean the objects
     * are the same instance. However it does mean that in that moment, they 
     * are mapped to the same row in database.
     */
    public boolean hasEqualMapping(LimitacionPropVehiculo valueObject) {

          if (valueObject.getIDLIMITAC_VEHICULO() != this.IDLIMITAC_VEHICULO) {
                    return(false);
          }
          if (valueObject.getID_VEHICULO() != this.ID_VEHICULO) {
                    return(false);
          }
          if (valueObject.getID_LIMITACION() != this.ID_LIMITACION) {
                    return(false);
          }
          if (this.FECHARADICA_LIMITACION == null) {
                    if (valueObject.getFECHARADICA_LIMITACION() != null)
                           return(false);
          } else if (!this.FECHARADICA_LIMITACION.equals(valueObject.getFECHARADICA_LIMITACION())) {
                    return(false);
          }
          if (this.HORARADICA_LIMITACION == null) {
                    if (valueObject.getHORARADICA_LIMITACION() != null)
                           return(false);
          } else if (!this.HORARADICA_LIMITACION.equals(valueObject.getHORARADICA_LIMITACION())) {
                    return(false);
          }
          if (this.ACREEDOR == null) {
                    if (valueObject.getACREEDOR() != null)
                           return(false);
          } else if (!this.ACREEDOR.equals(valueObject.getACREEDOR())) {
                    return(false);
          }
          if (this.IDENTIFICACIONACREEDOR == null) {
                    if (valueObject.getIDENTIFICACIONACREEDOR() != null)
                           return(false);
          } else if (!this.IDENTIFICACIONACREEDOR.equals(valueObject.getIDENTIFICACIONACREEDOR())) {
                    return(false);
          }
          if (this.ID_DOCUMENTO == null) {
                    if (valueObject.getID_DOCUMENTO() != null)
                           return(false);
          } else if (!this.ID_DOCUMENTO.equals(valueObject.getID_DOCUMENTO())) {
                    return(false);
          }
          if (valueObject.getID_CIUDADACREEDOR() != this.ID_CIUDADACREEDOR) {
                    return(false);
          }
          if (this.NUMNOTARIA_LIMITACION == null) {
                    if (valueObject.getNUMNOTARIA_LIMITACION() != null)
                           return(false);
          } else if (!this.NUMNOTARIA_LIMITACION.equals(valueObject.getNUMNOTARIA_LIMITACION())) {
                    return(false);
          }
          if (valueObject.getIDCIUDAD_NOTARIALIMITAC() != this.IDCIUDAD_NOTARIALIMITAC) {
                    return(false);
          }
          if (this.FECHAAUTENTICACIONLIMITACION == null) {
                    if (valueObject.getFECHAAUTENTICACIONLIMITACION() != null)
                           return(false);
          } else if (!this.FECHAAUTENTICACIONLIMITACION.equals(valueObject.getFECHAAUTENTICACIONLIMITACION())) {
                    return(false);
          }
          if (valueObject.getVALORLIMITACION() != this.VALORLIMITACION) {
                    return(false);
          }
          if (this.FECHACANCELALIMITACION == null) {
                    if (valueObject.getFECHACANCELALIMITACION() != null)
                           return(false);
          } else if (!this.FECHACANCELALIMITACION.equals(valueObject.getFECHACANCELALIMITACION())) {
                    return(false);
          }
          if (this.NUMDOCTOCANCELACION == null) {
                    if (valueObject.getNUMDOCTOCANCELACION() != null)
                           return(false);
          } else if (!this.NUMDOCTOCANCELACION.equals(valueObject.getNUMDOCTOCANCELACION())) {
                    return(false);
          }
          if (this.NUMNOTARIA_CANCELACION == null) {
                    if (valueObject.getNUMNOTARIA_CANCELACION() != null)
                           return(false);
          } else if (!this.NUMNOTARIA_CANCELACION.equals(valueObject.getNUMNOTARIA_CANCELACION())) {
                    return(false);
          }
          if (this.FECHAAUTENTICACIONCANCELACION == null) {
                    if (valueObject.getFECHAAUTENTICACIONCANCELACION() != null)
                           return(false);
          } else if (!this.FECHAAUTENTICACIONCANCELACION.equals(valueObject.getFECHAAUTENTICACIONCANCELACION())) {
                    return(false);
          }
          if (valueObject.getIDCIUDAD_NOTARIACANCELAC() != this.IDCIUDAD_NOTARIACANCELAC) {
                    return(false);
          }
          if (this.ESTADOLIMITACION == null) {
                    if (valueObject.getESTADOLIMITACION() != null)
                           return(false);
          } else if (!this.ESTADOLIMITACION.equals(valueObject.getESTADOLIMITACION())) {
                    return(false);
          }
          if (valueObject.getID_RECIBOLIQ() != this.ID_RECIBOLIQ) {
                    return(false);
          }
          if (valueObject.getID_GRADOALERTA() != this.ID_GRADOALERTA) {
                    return(false);
          }
          if (valueObject.getID_TIPO_ALERTA() != this.ID_TIPO_ALERTA) {
                    return(false);
          }
          if (this.TIPOPERSONA == null) {
                    if (valueObject.getTIPOPERSONA() != null)
                           return(false);
          } else if (!this.TIPOPERSONA.equals(valueObject.getTIPOPERSONA())) {
                    return(false);
          }
          if (this.DESCRIPCIONAUTORIZACION == null) {
                    if (valueObject.getDESCRIPCIONAUTORIZACION() != null)
                           return(false);
          } else if (!this.DESCRIPCIONAUTORIZACION.equals(valueObject.getDESCRIPCIONAUTORIZACION())) {
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
        out.append("\nclass LimitacionPropVehiculo, mapping to table LIMITACIONPROP_VEHICULO\n");
        out.append("Persistent attributes: \n"); 
        out.append("IDLIMITAC_VEHICULO = " + this.IDLIMITAC_VEHICULO + "\n"); 
        out.append("ID_VEHICULO = " + this.ID_VEHICULO + "\n"); 
        out.append("ID_LIMITACION = " + this.ID_LIMITACION + "\n"); 
        out.append("FECHARADICA_LIMITACION = " + this.FECHARADICA_LIMITACION + "\n"); 
        out.append("HORARADICA_LIMITACION = " + this.HORARADICA_LIMITACION + "\n"); 
        out.append("ACREEDOR = " + this.ACREEDOR + "\n"); 
        out.append("IDENTIFICACIONACREEDOR = " + this.IDENTIFICACIONACREEDOR + "\n"); 
        out.append("ID_DOCUMENTO = " + this.ID_DOCUMENTO + "\n"); 
        out.append("ID_CIUDADACREEDOR = " + this.ID_CIUDADACREEDOR + "\n"); 
        out.append("NUMNOTARIA_LIMITACION = " + this.NUMNOTARIA_LIMITACION + "\n"); 
        out.append("IDCIUDAD_NOTARIALIMITAC = " + this.IDCIUDAD_NOTARIALIMITAC + "\n"); 
        out.append("FECHAAUTENTICACIONLIMITACION = " + this.FECHAAUTENTICACIONLIMITACION + "\n"); 
        out.append("VALORLIMITACION = " + this.VALORLIMITACION + "\n"); 
        out.append("FECHACANCELALIMITACION = " + this.FECHACANCELALIMITACION + "\n"); 
        out.append("NUMDOCTOCANCELACION = " + this.NUMDOCTOCANCELACION + "\n"); 
        out.append("NUMNOTARIA_CANCELACION = " + this.NUMNOTARIA_CANCELACION + "\n"); 
        out.append("FECHAAUTENTICACIONCANCELACION = " + this.FECHAAUTENTICACIONCANCELACION + "\n"); 
        out.append("IDCIUDAD_NOTARIACANCELAC = " + this.IDCIUDAD_NOTARIACANCELAC + "\n"); 
        out.append("ESTADOLIMITACION = " + this.ESTADOLIMITACION + "\n"); 
        out.append("ID_RECIBOLIQ = " + this.ID_RECIBOLIQ + "\n"); 
        out.append("ID_GRADOALERTA = " + this.ID_GRADOALERTA + "\n"); 
        out.append("ID_TIPO_ALERTA = " + this.ID_TIPO_ALERTA + "\n"); 
        out.append("TIPOPERSONA = " + this.TIPOPERSONA + "\n"); 
        out.append("DESCRIPCIONAUTORIZACION = " + this.DESCRIPCIONAUTORIZACION + "\n"); 
        return out.toString();
    }


    /**
     * Clone will return identical deep copy of this valueObject.
     * Note, that this method is different than the clone() which
     * is defined in java.lang.Object. Here, the retuned cloned object
     * will also have all its attributes cloned.
     */
    public Object clone() {
        LimitacionPropVehiculo cloned = new LimitacionPropVehiculo();

        cloned.setIDLIMITAC_VEHICULO(this.IDLIMITAC_VEHICULO); 
        cloned.setID_VEHICULO(this.ID_VEHICULO); 
        cloned.setID_LIMITACION(this.ID_LIMITACION); 
        if (this.FECHARADICA_LIMITACION != null)
             cloned.setFECHARADICA_LIMITACION(new String(this.FECHARADICA_LIMITACION)); 
        if (this.HORARADICA_LIMITACION != null)
             cloned.setHORARADICA_LIMITACION(new String(this.HORARADICA_LIMITACION)); 
        if (this.ACREEDOR != null)
             cloned.setACREEDOR(new String(this.ACREEDOR)); 
        if (this.IDENTIFICACIONACREEDOR != null)
             cloned.setIDENTIFICACIONACREEDOR(new String(this.IDENTIFICACIONACREEDOR)); 
        if (this.ID_DOCUMENTO != null)
             cloned.setID_DOCUMENTO(new String(this.ID_DOCUMENTO)); 
        cloned.setID_CIUDADACREEDOR(this.ID_CIUDADACREEDOR); 
        if (this.NUMNOTARIA_LIMITACION != null)
             cloned.setNUMNOTARIA_LIMITACION(new String(this.NUMNOTARIA_LIMITACION)); 
        cloned.setIDCIUDAD_NOTARIALIMITAC(this.IDCIUDAD_NOTARIALIMITAC); 
        if (this.FECHAAUTENTICACIONLIMITACION != null)
             cloned.setFECHAAUTENTICACIONLIMITACION(new String(this.FECHAAUTENTICACIONLIMITACION)); 
        cloned.setVALORLIMITACION(this.VALORLIMITACION); 
        if (this.FECHACANCELALIMITACION != null)
             cloned.setFECHACANCELALIMITACION(new String(this.FECHACANCELALIMITACION)); 
        if (this.NUMDOCTOCANCELACION != null)
             cloned.setNUMDOCTOCANCELACION(new String(this.NUMDOCTOCANCELACION)); 
        if (this.NUMNOTARIA_CANCELACION != null)
             cloned.setNUMNOTARIA_CANCELACION(new String(this.NUMNOTARIA_CANCELACION)); 
        if (this.FECHAAUTENTICACIONCANCELACION != null)
             cloned.setFECHAAUTENTICACIONCANCELACION(new String(this.FECHAAUTENTICACIONCANCELACION)); 
        cloned.setIDCIUDAD_NOTARIACANCELAC(this.IDCIUDAD_NOTARIACANCELAC); 
        if (this.ESTADOLIMITACION != null)
             cloned.setESTADOLIMITACION(new String(this.ESTADOLIMITACION)); 
        cloned.setID_RECIBOLIQ(this.ID_RECIBOLIQ); 
        cloned.setID_GRADOALERTA(this.ID_GRADOALERTA); 
        cloned.setID_TIPO_ALERTA(this.ID_TIPO_ALERTA); 
        if (this.TIPOPERSONA != null)
             cloned.setTIPOPERSONA(new String(this.TIPOPERSONA)); 
        if (this.DESCRIPCIONAUTORIZACION != null)
             cloned.setDESCRIPCIONAUTORIZACION(new String(this.DESCRIPCIONAUTORIZACION)); 
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