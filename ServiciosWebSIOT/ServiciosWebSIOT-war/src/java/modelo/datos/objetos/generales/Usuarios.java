package modelo.datos.objetos.generales;

import java.io.*;
import java.sql.*;
import java.util.*;
import java.math.*;

 /**
  * Usuarios Value Object.
  * This class is value object representing database table usuarios
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



public class Usuarios implements Cloneable, Serializable {

    /** 
     * Persistent Instance variables. This data is directly 
     * mapped to the columns of database table.
     */
    private int ID_USUARIO;
    private String LOGIN;
    private String CLAVE;
    private String NOMBRE;
    private String APELLIDO;
    private int ID_PERFIL;
    private String ESTADO;
    private String FECHAINGRESO;
    private String FECHARETIRO;
    private String USUARIORUNT;
    private String TOKENHUELLA;
    private String TOKENHUELLAENVIAR;
    private String DOCUMENTO;
    private String PASSWORDRUNT;
    private String FECHA_CLAVE;



    /** 
     * Constructors. DaoGen generates two constructors by default.
     * The first one takes no arguments and provides the most simple
     * way to create object instance. The another one takes one
     * argument, which is the primary key of the corresponding table.
     */

    public Usuarios () {

    }

    public Usuarios (int ID_USUARIOIn) {

          this.ID_USUARIO = ID_USUARIOIn;

    }


    /** 
     * Get- and Set-methods for persistent variables. The default
     * behaviour does not make any checks against malformed data,
     * so these might require some manual additions.
     */

    public int getID_USUARIO() {
          return this.ID_USUARIO;
    }
    public void setID_USUARIO(int ID_USUARIOIn) {
          this.ID_USUARIO = ID_USUARIOIn;
    }

    public String getLOGIN() {
          return this.LOGIN;
    }
    public void setLOGIN(String LOGINIn) {
          this.LOGIN = LOGINIn;
    }

    public String getCLAVE() {
          return this.CLAVE;
    }
    public void setCLAVE(String CLAVEIn) {
          this.CLAVE = CLAVEIn;
    }

    public String getNOMBRE() {
          return this.NOMBRE;
    }
    public void setNOMBRE(String NOMBREIn) {
          this.NOMBRE = NOMBREIn;
    }

    public String getAPELLIDO() {
          return this.APELLIDO;
    }
    public void setAPELLIDO(String APELLIDOIn) {
          this.APELLIDO = APELLIDOIn;
    }

    public int getID_PERFIL() {
          return this.ID_PERFIL;
    }
    public void setID_PERFIL(int ID_PERFILIn) {
          this.ID_PERFIL = ID_PERFILIn;
    }

    public String getESTADO() {
          return this.ESTADO;
    }
    public void setESTADO(String ESTADOIn) {
          this.ESTADO = ESTADOIn;
    }

    public String getFECHAINGRESO() {
          return this.FECHAINGRESO;
    }
    public void setFECHAINGRESO(String FECHAINGRESOIn) {
          this.FECHAINGRESO = FECHAINGRESOIn;
    }

    public String getFECHARETIRO() {
          return this.FECHARETIRO;
    }
    public void setFECHARETIRO(String FECHARETIROIn) {
          this.FECHARETIRO = FECHARETIROIn;
    }

    public String getUSUARIORUNT() {
          return this.USUARIORUNT;
    }
    public void setUSUARIORUNT(String USUARIORUNTIn) {
          this.USUARIORUNT = USUARIORUNTIn;
    }

    public String getTOKENHUELLA() {
          return this.TOKENHUELLA;
    }
    public void setTOKENHUELLA(String TOKENHUELLAIn) {
          this.TOKENHUELLA = TOKENHUELLAIn;
    }

    public String getDOCUMENTO() {
          return this.DOCUMENTO;
    }
    public void setDOCUMENTO(String DOCUMENTOIn) {
          this.DOCUMENTO = DOCUMENTOIn;
    }

    public String getPASSWORDRUNT() {
          return this.PASSWORDRUNT;
    }
    public void setPASSWORDRUNT(String PASSWORDRUNTIn) {
          this.PASSWORDRUNT = PASSWORDRUNTIn;
    }

    public String getFECHA_CLAVE() {
          return FECHA_CLAVE;
    }

    public void setFECHA_CLAVE(String FECHA_CLAVE) {
          this.FECHA_CLAVE = FECHA_CLAVE;
    }


    /** 
     * setAll allows to set all persistent variables in one method call.
     * This is useful, when all data is available and it is needed to 
     * set the initial state of this object. Note that this method will
     * directly modify instance variales, without going trough the 
     * individual set-methods.
     */

    public void setAll(int ID_USUARIOIn,
          String LOGINIn,
          String CLAVEIn,
          String NOMBREIn,
          String APELLIDOIn,
          int ID_PERFILIn,
          String ESTADOIn,
          String FECHAINGRESOIn,
          String FECHARETIROIn,
          String USUARIORUNTIn,
          String TOKENHUELLAIn,
          String DOCUMENTOIn,
          String PASSWORDRUNTIn,
          String FECHA_CLAVE) {
          this.ID_USUARIO = ID_USUARIOIn;
          this.LOGIN = LOGINIn;
          this.CLAVE = CLAVEIn;
          this.NOMBRE = NOMBREIn;
          this.APELLIDO = APELLIDOIn;
          this.ID_PERFIL = ID_PERFILIn;
          this.ESTADO = ESTADOIn;
          this.FECHAINGRESO = FECHAINGRESOIn;
          this.FECHARETIRO = FECHARETIROIn;
          this.USUARIORUNT = USUARIORUNTIn;
          this.TOKENHUELLA = TOKENHUELLAIn;
          this.DOCUMENTO = DOCUMENTOIn;
          this.PASSWORDRUNT = PASSWORDRUNTIn;
          this.FECHA_CLAVE = FECHA_CLAVE;
    }


    /** 
     * hasEqualMapping-method will compare two Usuarios instances
     * and return true if they contain same values in all persistent instance 
     * variables. If hasEqualMapping returns true, it does not mean the objects
     * are the same instance. However it does mean that in that moment, they 
     * are mapped to the same row in database.
     */
    public boolean hasEqualMapping(Usuarios valueObject) {

          if (valueObject.getID_USUARIO() != this.ID_USUARIO) {
                    return(false);
          }
          if (this.LOGIN == null) {
                    if (valueObject.getLOGIN() != null)
                           return(false);
          } else if (!this.LOGIN.equals(valueObject.getLOGIN())) {
                    return(false);
          }
          if (this.CLAVE == null) {
                    if (valueObject.getCLAVE() != null)
                           return(false);
          } else if (!this.CLAVE.equals(valueObject.getCLAVE())) {
                    return(false);
          }
          if (this.NOMBRE == null) {
                    if (valueObject.getNOMBRE() != null)
                           return(false);
          } else if (!this.NOMBRE.equals(valueObject.getNOMBRE())) {
                    return(false);
          }
          if (this.APELLIDO == null) {
                    if (valueObject.getAPELLIDO() != null)
                           return(false);
          } else if (!this.APELLIDO.equals(valueObject.getAPELLIDO())) {
                    return(false);
          }
          if (valueObject.getID_PERFIL() != this.ID_PERFIL) {
                    return(false);
          }
          if (this.ESTADO == null) {
                    if (valueObject.getESTADO() != null)
                           return(false);
          } else if (!this.ESTADO.equals(valueObject.getESTADO())) {
                    return(false);
          }
          if (this.FECHAINGRESO == null) {
                    if (valueObject.getFECHAINGRESO() != null)
                           return(false);
          } else if (!this.FECHAINGRESO.equals(valueObject.getFECHAINGRESO())) {
                    return(false);
          }
          if (this.FECHARETIRO == null) {
                    if (valueObject.getFECHARETIRO() != null)
                           return(false);
          } else if (!this.FECHARETIRO.equals(valueObject.getFECHARETIRO())) {
                    return(false);
          }
          if (this.USUARIORUNT == null) {
                    if (valueObject.getUSUARIORUNT() != null)
                           return(false);
          } else if (!this.USUARIORUNT.equals(valueObject.getUSUARIORUNT())) {
                    return(false);
          }
          if (this.TOKENHUELLA == null) {
                    if (valueObject.getTOKENHUELLA() != null)
                           return(false);
          } else if (!this.TOKENHUELLA.equals(valueObject.getTOKENHUELLA())) {
                    return(false);
          }
          if (this.DOCUMENTO == null) {
                    if (valueObject.getDOCUMENTO() != null)
                           return(false);
          } else if (!this.DOCUMENTO.equals(valueObject.getDOCUMENTO())) {
                    return(false);
          }
          if (this.PASSWORDRUNT == null) {
                    if (valueObject.getPASSWORDRUNT() != null)
                           return(false);
          } else if (!this.PASSWORDRUNT.equals(valueObject.getPASSWORDRUNT())) {
                    return(false);
          }
          if (this.FECHA_CLAVE == null){
                    if (valueObject.getFECHA_CLAVE() != null)
                          return(false);
          } else if (!this.FECHA_CLAVE.equals(valueObject.getFECHA_CLAVE())) {
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
        out.append("\nclass Usuarios, mapping to table usuarios\n");
        out.append("Persistent attributes: \n"); 
        out.append("ID_USUARIO = " + this.ID_USUARIO + "\n"); 
        out.append("LOGIN = " + this.LOGIN + "\n"); 
        out.append("NOMBRE = " + this.NOMBRE + "\n"); 
        out.append("APELLIDO = " + this.APELLIDO + "\n"); 
        out.append("ID_PERFIL = " + this.ID_PERFIL + "\n"); 
        out.append("ESTADO = " + this.ESTADO + "\n");
        out.append("FECHAINGRESO = " + this.FECHAINGRESO + "\n");
        out.append("FECHARETIRO = " + this.FECHARETIRO + "\n"); 
        out.append("USUARIORUNT = " + this.USUARIORUNT + "\n"); 
        out.append("TOKENHUELLA = " + this.TOKENHUELLA + "\n"); 
        out.append("DOCUMENTO = " + this.DOCUMENTO + "\n"); 
        out.append("FECHA_CLAVE = " + this.FECHA_CLAVE + "\n");
        return out.toString();
    }


    /**
     * Clone will return identical deep copy of this valueObject.
     * Note, that this method is different than the clone() which
     * is defined in java.lang.Object. Here, the retuned cloned object
     * will also have all its attributes cloned.
     */
    public Object clone() {
        Usuarios cloned = new Usuarios();

        cloned.setID_USUARIO(this.ID_USUARIO); 
        if (this.LOGIN != null)
             cloned.setLOGIN(new String(this.LOGIN)); 
        if (this.CLAVE != null)
             cloned.setCLAVE(new String(this.CLAVE)); 
        if (this.NOMBRE != null)
             cloned.setNOMBRE(new String(this.NOMBRE)); 
        if (this.APELLIDO != null)
             cloned.setAPELLIDO(new String(this.APELLIDO)); 
        cloned.setID_PERFIL(this.ID_PERFIL); 
        if (this.ESTADO != null)
             cloned.setESTADO(new String(this.ESTADO)); 
        if (this.FECHAINGRESO != null)
             cloned.setFECHAINGRESO(new String(this.FECHAINGRESO)); 
        if (this.FECHARETIRO != null)
             cloned.setFECHARETIRO(new String(this.FECHARETIRO)); 
        if (this.USUARIORUNT != null)
             cloned.setUSUARIORUNT(new String(this.USUARIORUNT)); 
        if (this.TOKENHUELLA != null)
             cloned.setTOKENHUELLA(new String(this.TOKENHUELLA)); 
        if (this.DOCUMENTO != null)
             cloned.setDOCUMENTO(new String(this.DOCUMENTO)); 
        if (this.PASSWORDRUNT != null)
             cloned.setPASSWORDRUNT(new String(this.PASSWORDRUNT)); 
        if (this.FECHA_CLAVE != null)
                    cloned.setFECHA_CLAVE(new String(this.FECHA_CLAVE));
        return cloned;
    }



    /** 
     * getDaogenVersion will return information about
     * generator which created these sources.
     */
    public String getDaogenVersion() {
        return "DaoGen version 2.4.1";
    }

    public String getTOKENHUELLAENVIAR() {
        return TOKENHUELLAENVIAR;
    }

    public void setTOKENHUELLAENVIAR(String TOKENHUELLAENVIAR) {
        this.TOKENHUELLAENVIAR = TOKENHUELLAENVIAR;
    }
}
