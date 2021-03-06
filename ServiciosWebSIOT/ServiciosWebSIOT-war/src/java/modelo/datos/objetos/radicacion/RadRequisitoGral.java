package modelo.datos.objetos.radicacion;


import java.io.*;
import java.sql.*;
import java.util.*;
import java.math.*;

 /**
  * RadRequisitoGral Value Object.
  * This class is value object representing database table RADREQUISITOGRAL
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



public class RadRequisitoGral implements Cloneable, Serializable {

    /** 
     * Persistent Instance variables. This data is directly 
     * mapped to the columns of database table.
     */
    private int ID_RADREQGENERAL;
    private int ID_RADICADOVEH;
    private int ID_REQTRAMITE;
    private String ESTADO;
    private String DESCREQUISITO;
    private int ID_USUARIO;
    private String FECHA;
    private String HORA;
    private String OBSERVACION;



    /** 
     * Constructors. DaoGen generates two constructors by default.
     * The first one takes no arguments and provides the most simple
     * way to create object instance. The another one takes one
     * argument, which is the primary key of the corresponding table.
     */

    public RadRequisitoGral () {

    }

    public RadRequisitoGral (int ID_RADREQGENERALIn) {

          this.ID_RADREQGENERAL = ID_RADREQGENERALIn;

    }


    /** 
     * Get- and Set-methods for persistent variables. The default
     * behaviour does not make any checks against malformed data,
     * so these might require some manual additions.
     */

    public int getID_RADREQGENERAL() {
          return this.ID_RADREQGENERAL;
    }
    public void setID_RADREQGENERAL(int ID_RADREQGENERALIn) {
          this.ID_RADREQGENERAL = ID_RADREQGENERALIn;
    }

    public int getID_RADICADOVEH() {
          return this.ID_RADICADOVEH;
    }
    public void setID_RADICADOVEH(int ID_RADICADOVEHIn) {
          this.ID_RADICADOVEH = ID_RADICADOVEHIn;
    }

    public int getID_REQTRAMITE() {
          return this.ID_REQTRAMITE;
    }
    public void setID_REQTRAMITE(int ID_REQTRAMITEIn) {
          this.ID_REQTRAMITE = ID_REQTRAMITEIn;
    }

    public String getESTADO() {
          return this.ESTADO;
    }
    public void setESTADO(String ESTADOIn) {
          this.ESTADO = ESTADOIn;
    }

    public String getDESCREQUISITO() {
          return this.DESCREQUISITO;
    }
    public void setDESCREQUISITO(String DESCREQUISITOIn) {
          this.DESCREQUISITO = DESCREQUISITOIn;
    }

    public int getID_USUARIO() {
          return this.ID_USUARIO;
    }
    public void setID_USUARIO(int ID_USUARIOIn) {
          this.ID_USUARIO = ID_USUARIOIn;
    }

    public String getFECHA() {
          return this.FECHA;
    }
    public void setFECHA(String FECHAIn) {
          this.FECHA = FECHAIn;
    }

    public String getHORA() {
          return this.HORA;
    }
    public void setHORA(String HORAIn) {
          this.HORA = HORAIn;
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

    public void setAll(int ID_RADREQGENERALIn,
          int ID_RADICADOVEHIn,
          int ID_REQTRAMITEIn,
          String ESTADOIn,
          String DESCREQUISITOIn,
          int ID_USUARIOIn,
          String FECHAIn,
          String HORAIn,
          String OBSERVACIONIn) {
          this.ID_RADREQGENERAL = ID_RADREQGENERALIn;
          this.ID_RADICADOVEH = ID_RADICADOVEHIn;
          this.ID_REQTRAMITE = ID_REQTRAMITEIn;
          this.ESTADO = ESTADOIn;
          this.DESCREQUISITO = DESCREQUISITOIn;
          this.ID_USUARIO = ID_USUARIOIn;
          this.FECHA = FECHAIn;
          this.HORA = HORAIn;
          this.OBSERVACION = OBSERVACIONIn;
    }


    /** 
     * hasEqualMapping-method will compare two RadRequisitoGral instances
     * and return true if they contain same values in all persistent instance 
     * variables. If hasEqualMapping returns true, it does not mean the objects
     * are the same instance. However it does mean that in that moment, they 
     * are mapped to the same row in database.
     */
    public boolean hasEqualMapping(RadRequisitoGral valueObject) {

          if (valueObject.getID_RADREQGENERAL() != this.ID_RADREQGENERAL) {
                    return(false);
          }
          if (valueObject.getID_RADICADOVEH() != this.ID_RADICADOVEH) {
                    return(false);
          }
          if (valueObject.getID_REQTRAMITE() != this.ID_REQTRAMITE) {
                    return(false);
          }
          if (this.ESTADO == null) {
                    if (valueObject.getESTADO() != null)
                           return(false);
          } else if (!this.ESTADO.equals(valueObject.getESTADO())) {
                    return(false);
          }
          if (this.DESCREQUISITO == null) {
                    if (valueObject.getDESCREQUISITO() != null)
                           return(false);
          } else if (!this.DESCREQUISITO.equals(valueObject.getDESCREQUISITO())) {
                    return(false);
          }
          if (valueObject.getID_USUARIO() != this.ID_USUARIO) {
                    return(false);
          }
          if (this.FECHA == null) {
                    if (valueObject.getFECHA() != null)
                           return(false);
          } else if (!this.FECHA.equals(valueObject.getFECHA())) {
                    return(false);
          }
          if (this.HORA == null) {
                    if (valueObject.getHORA() != null)
                           return(false);
          } else if (!this.HORA.equals(valueObject.getHORA())) {
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
        out.append("\nclass RadRequisitoGral, mapping to table RADREQUISITOGRAL\n");
        out.append("Persistent attributes: \n"); 
        out.append("ID_RADREQGENERAL = " + this.ID_RADREQGENERAL + "\n"); 
        out.append("ID_RADICADOVEH = " + this.ID_RADICADOVEH + "\n"); 
        out.append("ID_REQTRAMITE = " + this.ID_REQTRAMITE + "\n"); 
        out.append("ESTADO = " + this.ESTADO + "\n"); 
        out.append("DESCREQUISITO = " + this.DESCREQUISITO + "\n"); 
        out.append("ID_USUARIO = " + this.ID_USUARIO + "\n"); 
        out.append("FECHA = " + this.FECHA + "\n"); 
        out.append("HORA = " + this.HORA + "\n"); 
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
        RadRequisitoGral cloned = new RadRequisitoGral();

        cloned.setID_RADREQGENERAL(this.ID_RADREQGENERAL); 
        cloned.setID_RADICADOVEH(this.ID_RADICADOVEH); 
        cloned.setID_REQTRAMITE(this.ID_REQTRAMITE); 
        if (this.ESTADO != null)
             cloned.setESTADO(new String(this.ESTADO)); 
        if (this.DESCREQUISITO != null)
             cloned.setDESCREQUISITO(new String(this.DESCREQUISITO)); 
        cloned.setID_USUARIO(this.ID_USUARIO); 
        if (this.FECHA != null)
             cloned.setFECHA(new String(this.FECHA)); 
        if (this.HORA != null)
             cloned.setHORA(new String(this.HORA)); 
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
