package modelo.datos.objetos.accesorias;

import java.io.*;
import java.sql.*;
import java.util.*;
import java.math.*;

 /**
  * ClaseVehiculo Value Object.
  * This class is value object representing database table CLASE_VEHICULO
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



public class ClaseVehiculo implements Cloneable, Serializable {

    /** 
     * Persistent Instance variables. This data is directly 
     * mapped to the columns of database table.
     */
    private int ID_CVEHICULO;
    private String DESCRIPCION;
    private String SUFIJO_PLACA;
    private String HABILITAPLACA;
    private String CLASEVEH_HOMOLOGA;
    private String ID_CVEHICULORUNT;
    private String MINCILINDRAJE;
    private String MAXCILINDRAJE;
    private String PUERTAS;
    private String MAXPASAJEROS;
    private String MAXCARGA;
    private String IDRUNTCLASIFICACION;



    /** 
     * Constructors. DaoGen generates two constructors by default.
     * The first one takes no arguments and provides the most simple
     * way to create object instance. The another one takes one
     * argument, which is the primary key of the corresponding table.
     */

    public ClaseVehiculo () {

    }

    public ClaseVehiculo (int ID_CVEHICULOIn) {

          this.ID_CVEHICULO = ID_CVEHICULOIn;

    }


    /** 
     * Get- and Set-methods for persistent variables. The default
     * behaviour does not make any checks against malformed data,
     * so these might require some manual additions.
     */

    public int getID_CVEHICULO() {
          return this.ID_CVEHICULO;
    }
    public void setID_CVEHICULO(int ID_CVEHICULOIn) {
          this.ID_CVEHICULO = ID_CVEHICULOIn;
    }

    public String getDESCRIPCION() {
          return this.DESCRIPCION;
    }
    public void setDESCRIPCION(String DESCRIPCIONIn) {
          this.DESCRIPCION = DESCRIPCIONIn;
    }

    public String getSUFIJO_PLACA() {
          return this.SUFIJO_PLACA;
    }
    public void setSUFIJO_PLACA(String SUFIJO_PLACAIn) {
          this.SUFIJO_PLACA = SUFIJO_PLACAIn;
    }

    public String getHABILITAPLACA() {
          return this.HABILITAPLACA;
    }
    public void setHABILITAPLACA(String HABILITAPLACAIn) {
          this.HABILITAPLACA = HABILITAPLACAIn;
    }

    public String getCLASEVEH_HOMOLOGA() {
          return this.CLASEVEH_HOMOLOGA;
    }
    public void setCLASEVEH_HOMOLOGA(String CLASEVEH_HOMOLOGAIn) {
          this.CLASEVEH_HOMOLOGA = CLASEVEH_HOMOLOGAIn;
    }

    public String getID_CVEHICULORUNT() {
          return this.ID_CVEHICULORUNT;
    }
    public void setID_CVEHICULORUNT(String ID_CVEHICULORUNTIn) {
          this.ID_CVEHICULORUNT = ID_CVEHICULORUNTIn;
    }

    public String getMINCILINDRAJE() {
          return this.MINCILINDRAJE;
    }
    public void setMINCILINDRAJE(String MINCILINDRAJEIn) {
          this.MINCILINDRAJE = MINCILINDRAJEIn;
    }

    public String getMAXCILINDRAJE() {
          return this.MAXCILINDRAJE;
    }
    public void setMAXCILINDRAJE(String MAXCILINDRAJEIn) {
          this.MAXCILINDRAJE = MAXCILINDRAJEIn;
    }

    public String getPUERTAS() {
          return this.PUERTAS;
    }
    public void setPUERTAS(String PUERTASIn) {
          this.PUERTAS = PUERTASIn;
    }

    public String getMAXPASAJEROS() {
          return this.MAXPASAJEROS;
    }
    public void setMAXPASAJEROS(String MAXPASAJEROSIn) {
          this.MAXPASAJEROS = MAXPASAJEROSIn;
    }

    public String getMAXCARGA() {
          return this.MAXCARGA;
    }
    public void setMAXCARGA(String MAXCARGAIn) {
          this.MAXCARGA = MAXCARGAIn;
    }

    public String getIDRUNTCLASIFICACION() {
          return this.IDRUNTCLASIFICACION;
    }
    public void setIDRUNTCLASIFICACION(String IDRUNTCLASIFICACIONIn) {
          this.IDRUNTCLASIFICACION = IDRUNTCLASIFICACIONIn;
    }



    /** 
     * setAll allows to set all persistent variables in one method call.
     * This is useful, when all data is available and it is needed to 
     * set the initial state of this object. Note that this method will
     * directly modify instance variales, without going trough the 
     * individual set-methods.
     */

    public void setAll(int ID_CVEHICULOIn,
          String DESCRIPCIONIn,
          String SUFIJO_PLACAIn,
          String HABILITAPLACAIn,
          String CLASEVEH_HOMOLOGAIn,
          String ID_CVEHICULORUNTIn,
          String MINCILINDRAJEIn,
          String MAXCILINDRAJEIn,
          String PUERTASIn,
          String MAXPASAJEROSIn,
          String MAXCARGAIn,
          String IDRUNTCLASIFICACIONIn) {
          this.ID_CVEHICULO = ID_CVEHICULOIn;
          this.DESCRIPCION = DESCRIPCIONIn;
          this.SUFIJO_PLACA = SUFIJO_PLACAIn;
          this.HABILITAPLACA = HABILITAPLACAIn;
          this.CLASEVEH_HOMOLOGA = CLASEVEH_HOMOLOGAIn;
          this.ID_CVEHICULORUNT = ID_CVEHICULORUNTIn;
          this.MINCILINDRAJE = MINCILINDRAJEIn;
          this.MAXCILINDRAJE = MAXCILINDRAJEIn;
          this.PUERTAS = PUERTASIn;
          this.MAXPASAJEROS = MAXPASAJEROSIn;
          this.MAXCARGA = MAXCARGAIn;
          this.IDRUNTCLASIFICACION = IDRUNTCLASIFICACIONIn;
    }


    /** 
     * hasEqualMapping-method will compare two ClaseVehiculo instances
     * and return true if they contain same values in all persistent instance 
     * variables. If hasEqualMapping returns true, it does not mean the objects
     * are the same instance. However it does mean that in that moment, they 
     * are mapped to the same row in database.
     */
    public boolean hasEqualMapping(ClaseVehiculo valueObject) {

          if (valueObject.getID_CVEHICULO() != this.ID_CVEHICULO) {
                    return(false);
          }
          if (this.DESCRIPCION == null) {
                    if (valueObject.getDESCRIPCION() != null)
                           return(false);
          } else if (!this.DESCRIPCION.equals(valueObject.getDESCRIPCION())) {
                    return(false);
          }
          if (this.SUFIJO_PLACA == null) {
                    if (valueObject.getSUFIJO_PLACA() != null)
                           return(false);
          } else if (!this.SUFIJO_PLACA.equals(valueObject.getSUFIJO_PLACA())) {
                    return(false);
          }
          if (this.HABILITAPLACA == null) {
                    if (valueObject.getHABILITAPLACA() != null)
                           return(false);
          } else if (!this.HABILITAPLACA.equals(valueObject.getHABILITAPLACA())) {
                    return(false);
          }
          if (this.CLASEVEH_HOMOLOGA == null) {
                    if (valueObject.getCLASEVEH_HOMOLOGA() != null)
                           return(false);
          } else if (!this.CLASEVEH_HOMOLOGA.equals(valueObject.getCLASEVEH_HOMOLOGA())) {
                    return(false);
          }
          if (this.ID_CVEHICULORUNT == null) {
                    if (valueObject.getID_CVEHICULORUNT() != null)
                           return(false);
          } else if (!this.ID_CVEHICULORUNT.equals(valueObject.getID_CVEHICULORUNT())) {
                    return(false);
          }
          if (this.MINCILINDRAJE == null) {
                    if (valueObject.getMINCILINDRAJE() != null)
                           return(false);
          } else if (!this.MINCILINDRAJE.equals(valueObject.getMINCILINDRAJE())) {
                    return(false);
          }
          if (this.MAXCILINDRAJE == null) {
                    if (valueObject.getMAXCILINDRAJE() != null)
                           return(false);
          } else if (!this.MAXCILINDRAJE.equals(valueObject.getMAXCILINDRAJE())) {
                    return(false);
          }
          if (this.PUERTAS == null) {
                    if (valueObject.getPUERTAS() != null)
                           return(false);
          } else if (!this.PUERTAS.equals(valueObject.getPUERTAS())) {
                    return(false);
          }
          if (this.MAXPASAJEROS == null) {
                    if (valueObject.getMAXPASAJEROS() != null)
                           return(false);
          } else if (!this.MAXPASAJEROS.equals(valueObject.getMAXPASAJEROS())) {
                    return(false);
          }
          if (this.MAXCARGA == null) {
                    if (valueObject.getMAXCARGA() != null)
                           return(false);
          } else if (!this.MAXCARGA.equals(valueObject.getMAXCARGA())) {
                    return(false);
          }
          if (this.IDRUNTCLASIFICACION == null) {
                    if (valueObject.getIDRUNTCLASIFICACION() != null)
                           return(false);
          } else if (!this.IDRUNTCLASIFICACION.equals(valueObject.getIDRUNTCLASIFICACION())) {
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
        out.append("\nclass ClaseVehiculo, mapping to table CLASE_VEHICULO\n");
        out.append("Persistent attributes: \n"); 
        out.append("ID_CVEHICULO = " + this.ID_CVEHICULO + "\n"); 
        out.append("DESCRIPCION = " + this.DESCRIPCION + "\n"); 
        out.append("SUFIJO_PLACA = " + this.SUFIJO_PLACA + "\n"); 
        out.append("HABILITAPLACA = " + this.HABILITAPLACA + "\n"); 
        out.append("CLASEVEH_HOMOLOGA = " + this.CLASEVEH_HOMOLOGA + "\n"); 
        out.append("ID_CVEHICULORUNT = " + this.ID_CVEHICULORUNT + "\n"); 
        out.append("MINCILINDRAJE = " + this.MINCILINDRAJE + "\n"); 
        out.append("MAXCILINDRAJE = " + this.MAXCILINDRAJE + "\n"); 
        out.append("PUERTAS = " + this.PUERTAS + "\n"); 
        out.append("MAXPASAJEROS = " + this.MAXPASAJEROS + "\n"); 
        out.append("MAXCARGA = " + this.MAXCARGA + "\n"); 
        out.append("IDRUNTCLASIFICACION = " + this.IDRUNTCLASIFICACION + "\n"); 
        return out.toString();
    }


    /**
     * Clone will return identical deep copy of this valueObject.
     * Note, that this method is different than the clone() which
     * is defined in java.lang.Object. Here, the retuned cloned object
     * will also have all its attributes cloned.
     */
    public Object clone() {
        ClaseVehiculo cloned = new ClaseVehiculo();

        cloned.setID_CVEHICULO(this.ID_CVEHICULO); 
        if (this.DESCRIPCION != null)
             cloned.setDESCRIPCION(new String(this.DESCRIPCION)); 
        if (this.SUFIJO_PLACA != null)
             cloned.setSUFIJO_PLACA(new String(this.SUFIJO_PLACA)); 
        if (this.HABILITAPLACA != null)
             cloned.setHABILITAPLACA(new String(this.HABILITAPLACA)); 
        if (this.CLASEVEH_HOMOLOGA != null)
             cloned.setCLASEVEH_HOMOLOGA(new String(this.CLASEVEH_HOMOLOGA)); 
        if (this.ID_CVEHICULORUNT != null)
             cloned.setID_CVEHICULORUNT(new String(this.ID_CVEHICULORUNT)); 
        if (this.MINCILINDRAJE != null)
             cloned.setMINCILINDRAJE(new String(this.MINCILINDRAJE)); 
        if (this.MAXCILINDRAJE != null)
             cloned.setMAXCILINDRAJE(new String(this.MAXCILINDRAJE)); 
        if (this.PUERTAS != null)
             cloned.setPUERTAS(new String(this.PUERTAS)); 
        if (this.MAXPASAJEROS != null)
             cloned.setMAXPASAJEROS(new String(this.MAXPASAJEROS)); 
        if (this.MAXCARGA != null)
             cloned.setMAXCARGA(new String(this.MAXCARGA)); 
        if (this.IDRUNTCLASIFICACION != null)
             cloned.setIDRUNTCLASIFICACION(new String(this.IDRUNTCLASIFICACION)); 
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

