package modelo.datos.objetos.generales;

import java.io.*;
import java.sql.*;
import java.util.*;
import java.math.*;

 /**
  * RuntPrendaModificada Value Object.
  * This class is value object representing database table RUNT_PRENDAMODIFICADA
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



public class RuntPrendaModificada implements Cloneable, Serializable {

    /** 
     * Persistent Instance variables. This data is directly 
     * mapped to the columns of database table.
     */
    private int ID_PRENDAMODIFICADA;
    private String FECHAREGISTRO;
    private String FECHALEVANTAMIENTO;
    private String ID_DOCTO;
    private String IDENTIFICACION;
    private int ID_GRADOALERTA;
    private String FECHAMODIFICACION;
    private String FECHAINSCRIPCION;
    private String ESTADOPRENDA;
    private int ID_RUNTMODIFICACION;
    private String RAZONSOCIALACREEDORPRENDARIO;



    /** 
     * Constructors. DaoGen generates two constructors by default.
     * The first one takes no arguments and provides the most simple
     * way to create object instance. The another one takes one
     * argument, which is the primary key of the corresponding table.
     */

    public RuntPrendaModificada () {

    }

    public RuntPrendaModificada (int ID_PRENDAMODIFICADAIn) {

          this.ID_PRENDAMODIFICADA = ID_PRENDAMODIFICADAIn;

    }


    /** 
     * Get- and Set-methods for persistent variables. The default
     * behaviour does not make any checks against malformed data,
     * so these might require some manual additions.
     */

    public int getID_PRENDAMODIFICADA() {
          return this.ID_PRENDAMODIFICADA;
    }
    public void setID_PRENDAMODIFICADA(int ID_PRENDAMODIFICADAIn) {
          this.ID_PRENDAMODIFICADA = ID_PRENDAMODIFICADAIn;
    }

    public String getFECHAREGISTRO() {
          return this.FECHAREGISTRO;
    }
    public void setFECHAREGISTRO(String FECHAREGISTROIn) {
          this.FECHAREGISTRO = FECHAREGISTROIn;
    }

    public String getFECHALEVANTAMIENTO() {
          return this.FECHALEVANTAMIENTO;
    }
    public void setFECHALEVANTAMIENTO(String FECHALEVANTAMIENTOIn) {
          this.FECHALEVANTAMIENTO = FECHALEVANTAMIENTOIn;
    }

    public String getID_DOCTO() {
          return this.ID_DOCTO;
    }
    public void setID_DOCTO(String ID_DOCTOIn) {
          this.ID_DOCTO = ID_DOCTOIn;
    }

    public String getIDENTIFICACION() {
          return this.IDENTIFICACION;
    }
    public void setIDENTIFICACION(String IDENTIFICACIONIn) {
          this.IDENTIFICACION = IDENTIFICACIONIn;
    }

    public int getID_GRADOALERTA() {
          return this.ID_GRADOALERTA;
    }
    public void setID_GRADOALERTA(int ID_GRADOALERTAIn) {
          this.ID_GRADOALERTA = ID_GRADOALERTAIn;
    }

    public String getFECHAMODIFICACION() {
          return this.FECHAMODIFICACION;
    }
    public void setFECHAMODIFICACION(String FECHAMODIFICACIONIn) {
          this.FECHAMODIFICACION = FECHAMODIFICACIONIn;
    }

    public String getFECHAINSCRIPCION() {
          return this.FECHAINSCRIPCION;
    }
    public void setFECHAINSCRIPCION(String FECHAINSCRIPCIONIn) {
          this.FECHAINSCRIPCION = FECHAINSCRIPCIONIn;
    }

    public String getESTADOPRENDA() {
          return this.ESTADOPRENDA;
    }
    public void setESTADOPRENDA(String ESTADOPRENDAIn) {
          this.ESTADOPRENDA = ESTADOPRENDAIn;
    }

    public int getID_RUNTMODIFICACION() {
          return this.ID_RUNTMODIFICACION;
    }
    public void setID_RUNTMODIFICACION(int ID_RUNTMODIFICACIONIn) {
          this.ID_RUNTMODIFICACION = ID_RUNTMODIFICACIONIn;
    }

    public String getRAZONSOCIALACREEDORPRENDARIO() {
          return this.RAZONSOCIALACREEDORPRENDARIO;
    }
    public void setRAZONSOCIALACREEDORPRENDARIO(String RAZONSOCIALACREEDORPRENDARIOIn) {
          this.RAZONSOCIALACREEDORPRENDARIO = RAZONSOCIALACREEDORPRENDARIOIn;
    }



    /** 
     * setAll allows to set all persistent variables in one method call.
     * This is useful, when all data is available and it is needed to 
     * set the initial state of this object. Note that this method will
     * directly modify instance variales, without going trough the 
     * individual set-methods.
     */

    public void setAll(int ID_PRENDAMODIFICADAIn,
          String FECHAREGISTROIn,
          String FECHALEVANTAMIENTOIn,
          String ID_DOCTOIn,
          String IDENTIFICACIONIn,
          int ID_GRADOALERTAIn,
          String FECHAMODIFICACIONIn,
          String FECHAINSCRIPCIONIn,
          String ESTADOPRENDAIn,
          int ID_RUNTMODIFICACIONIn,
          String RAZONSOCIALACREEDORPRENDARIOIn) {
          this.ID_PRENDAMODIFICADA = ID_PRENDAMODIFICADAIn;
          this.FECHAREGISTRO = FECHAREGISTROIn;
          this.FECHALEVANTAMIENTO = FECHALEVANTAMIENTOIn;
          this.ID_DOCTO = ID_DOCTOIn;
          this.IDENTIFICACION = IDENTIFICACIONIn;
          this.ID_GRADOALERTA = ID_GRADOALERTAIn;
          this.FECHAMODIFICACION = FECHAMODIFICACIONIn;
          this.FECHAINSCRIPCION = FECHAINSCRIPCIONIn;
          this.ESTADOPRENDA = ESTADOPRENDAIn;
          this.ID_RUNTMODIFICACION = ID_RUNTMODIFICACIONIn;
          this.RAZONSOCIALACREEDORPRENDARIO = RAZONSOCIALACREEDORPRENDARIOIn;
    }


    /** 
     * hasEqualMapping-method will compare two RuntPrendaModificada instances
     * and return true if they contain same values in all persistent instance 
     * variables. If hasEqualMapping returns true, it does not mean the objects
     * are the same instance. However it does mean that in that moment, they 
     * are mapped to the same row in database.
     */
    public boolean hasEqualMapping(RuntPrendaModificada valueObject) {

          if (valueObject.getID_PRENDAMODIFICADA() != this.ID_PRENDAMODIFICADA) {
                    return(false);
          }
          if (this.FECHAREGISTRO == null) {
                    if (valueObject.getFECHAREGISTRO() != null)
                           return(false);
          } else if (!this.FECHAREGISTRO.equals(valueObject.getFECHAREGISTRO())) {
                    return(false);
          }
          if (this.FECHALEVANTAMIENTO == null) {
                    if (valueObject.getFECHALEVANTAMIENTO() != null)
                           return(false);
          } else if (!this.FECHALEVANTAMIENTO.equals(valueObject.getFECHALEVANTAMIENTO())) {
                    return(false);
          }
          if (this.ID_DOCTO == null) {
                    if (valueObject.getID_DOCTO() != null)
                           return(false);
          } else if (!this.ID_DOCTO.equals(valueObject.getID_DOCTO())) {
                    return(false);
          }
          if (this.IDENTIFICACION == null) {
                    if (valueObject.getIDENTIFICACION() != null)
                           return(false);
          } else if (!this.IDENTIFICACION.equals(valueObject.getIDENTIFICACION())) {
                    return(false);
          }
          if (valueObject.getID_GRADOALERTA() != this.ID_GRADOALERTA) {
                    return(false);
          }
          if (this.FECHAMODIFICACION == null) {
                    if (valueObject.getFECHAMODIFICACION() != null)
                           return(false);
          } else if (!this.FECHAMODIFICACION.equals(valueObject.getFECHAMODIFICACION())) {
                    return(false);
          }
          if (this.FECHAINSCRIPCION == null) {
                    if (valueObject.getFECHAINSCRIPCION() != null)
                           return(false);
          } else if (!this.FECHAINSCRIPCION.equals(valueObject.getFECHAINSCRIPCION())) {
                    return(false);
          }
          if (this.ESTADOPRENDA == null) {
                    if (valueObject.getESTADOPRENDA() != null)
                           return(false);
          } else if (!this.ESTADOPRENDA.equals(valueObject.getESTADOPRENDA())) {
                    return(false);
          }
          if (valueObject.getID_RUNTMODIFICACION() != this.ID_RUNTMODIFICACION) {
                    return(false);
          }
          if (this.RAZONSOCIALACREEDORPRENDARIO == null) {
                    if (valueObject.getRAZONSOCIALACREEDORPRENDARIO() != null)
                           return(false);
          } else if (!this.RAZONSOCIALACREEDORPRENDARIO.equals(valueObject.getRAZONSOCIALACREEDORPRENDARIO())) {
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
        out.append("\nclass RuntPrendaModificada, mapping to table RUNT_PRENDAMODIFICADA\n");
        out.append("Persistent attributes: \n"); 
        out.append("ID_PRENDAMODIFICADA = " + this.ID_PRENDAMODIFICADA + "\n"); 
        out.append("FECHAREGISTRO = " + this.FECHAREGISTRO + "\n"); 
        out.append("FECHALEVANTAMIENTO = " + this.FECHALEVANTAMIENTO + "\n"); 
        out.append("ID_DOCTO = " + this.ID_DOCTO + "\n"); 
        out.append("IDENTIFICACION = " + this.IDENTIFICACION + "\n"); 
        out.append("ID_GRADOALERTA = " + this.ID_GRADOALERTA + "\n"); 
        out.append("FECHAMODIFICACION = " + this.FECHAMODIFICACION + "\n"); 
        out.append("FECHAINSCRIPCION = " + this.FECHAINSCRIPCION + "\n"); 
        out.append("ESTADOPRENDA = " + this.ESTADOPRENDA + "\n"); 
        out.append("ID_RUNTMODIFICACION = " + this.ID_RUNTMODIFICACION + "\n"); 
        out.append("RAZONSOCIALACREEDORPRENDARIO = " + this.RAZONSOCIALACREEDORPRENDARIO + "\n"); 
        return out.toString();
    }


    /**
     * Clone will return identical deep copy of this valueObject.
     * Note, that this method is different than the clone() which
     * is defined in java.lang.Object. Here, the retuned cloned object
     * will also have all its attributes cloned.
     */
    public Object clone() {
        RuntPrendaModificada cloned = new RuntPrendaModificada();

        cloned.setID_PRENDAMODIFICADA(this.ID_PRENDAMODIFICADA); 
        if (this.FECHAREGISTRO != null)
             cloned.setFECHAREGISTRO(new String(this.FECHAREGISTRO)); 
        if (this.FECHALEVANTAMIENTO != null)
             cloned.setFECHALEVANTAMIENTO(new String(this.FECHALEVANTAMIENTO)); 
        if (this.ID_DOCTO != null)
             cloned.setID_DOCTO(new String(this.ID_DOCTO)); 
        if (this.IDENTIFICACION != null)
             cloned.setIDENTIFICACION(new String(this.IDENTIFICACION)); 
        cloned.setID_GRADOALERTA(this.ID_GRADOALERTA); 
        if (this.FECHAMODIFICACION != null)
             cloned.setFECHAMODIFICACION(new String(this.FECHAMODIFICACION)); 
        if (this.FECHAINSCRIPCION != null)
             cloned.setFECHAINSCRIPCION(new String(this.FECHAINSCRIPCION)); 
        if (this.ESTADOPRENDA != null)
             cloned.setESTADOPRENDA(new String(this.ESTADOPRENDA)); 
        cloned.setID_RUNTMODIFICACION(this.ID_RUNTMODIFICACION); 
        if (this.RAZONSOCIALACREEDORPRENDARIO != null)
             cloned.setRAZONSOCIALACREEDORPRENDARIO(new String(this.RAZONSOCIALACREEDORPRENDARIO)); 
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
