package modelo.datos.objetos.generales;

import java.io.*;
import java.sql.*;
import java.util.*;
import java.math.*;

 /**
  * RuntRegrabacionVehiculo Value Object.
  * This class is value object representing database table RUNTREGRABACIONVEHICULO
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



public class RuntRegrabacionVehiculo implements Cloneable, Serializable {

    /** 
     * Persistent Instance variables. This data is directly 
     * mapped to the columns of database table.
     */
    private int ID_RUNTREGRABACION;
    private String TIPOREGRABACION;
    private String NUMERO_SERIE;
    private String NUMERO_CHASIS;
    private String NUMERO_MOTOR;
    private String MOTIVO_REGRABACION;
    private String NUMERO_REVISIONTECNOMECANICA;
    private int ID_FACTURA;
    private int ID_VEHICULO;



    /** 
     * Constructors. DaoGen generates two constructors by default.
     * The first one takes no arguments and provides the most simple
     * way to create object instance. The another one takes one
     * argument, which is the primary key of the corresponding table.
     */

    public RuntRegrabacionVehiculo () {

    }

    public RuntRegrabacionVehiculo (int ID_RUNTREGRABACIONIn) {

          this.ID_RUNTREGRABACION = ID_RUNTREGRABACIONIn;

    }


    /** 
     * Get- and Set-methods for persistent variables. The default
     * behaviour does not make any checks against malformed data,
     * so these might require some manual additions.
     */

    public int getID_RUNTREGRABACION() {
          return this.ID_RUNTREGRABACION;
    }
    public void setID_RUNTREGRABACION(int ID_RUNTREGRABACIONIn) {
          this.ID_RUNTREGRABACION = ID_RUNTREGRABACIONIn;
    }

    public String getTIPOREGRABACION() {
          return this.TIPOREGRABACION;
    }
    public void setTIPOREGRABACION(String TIPOREGRABACIONIn) {
          this.TIPOREGRABACION = TIPOREGRABACIONIn;
    }

    public String getNUMERO_SERIE() {
          return this.NUMERO_SERIE;
    }
    public void setNUMERO_SERIE(String NUMERO_SERIEIn) {
          this.NUMERO_SERIE = NUMERO_SERIEIn;
    }

    public String getNUMERO_CHASIS() {
          return this.NUMERO_CHASIS;
    }
    public void setNUMERO_CHASIS(String NUMERO_CHASISIn) {
          this.NUMERO_CHASIS = NUMERO_CHASISIn;
    }

    public String getNUMERO_MOTOR() {
          return this.NUMERO_MOTOR;
    }
    public void setNUMERO_MOTOR(String NUMERO_MOTORIn) {
          this.NUMERO_MOTOR = NUMERO_MOTORIn;
    }

    public String getMOTIVO_REGRABACION() {
          return this.MOTIVO_REGRABACION;
    }
    public void setMOTIVO_REGRABACION(String MOTIVO_REGRABACIONIn) {
          this.MOTIVO_REGRABACION = MOTIVO_REGRABACIONIn;
    }

    public String getNUMERO_REVISIONTECNOMECANICA() {
          return this.NUMERO_REVISIONTECNOMECANICA;
    }
    public void setNUMERO_REVISIONTECNOMECANICA(String NUMERO_REVISIONTECNOMECANICAIn) {
          this.NUMERO_REVISIONTECNOMECANICA = NUMERO_REVISIONTECNOMECANICAIn;
    }

    public int getID_FACTURA() {
          return this.ID_FACTURA;
    }
    public void setID_FACTURA(int ID_FACTURAIn) {
          this.ID_FACTURA = ID_FACTURAIn;
    }

    public int getID_VEHICULO() {
          return this.ID_VEHICULO;
    }
    public void setID_VEHICULO(int ID_VEHICULOIn) {
          this.ID_VEHICULO = ID_VEHICULOIn;
    }



    /** 
     * setAll allows to set all persistent variables in one method call.
     * This is useful, when all data is available and it is needed to 
     * set the initial state of this object. Note that this method will
     * directly modify instance variales, without going trough the 
     * individual set-methods.
     */

    public void setAll(int ID_RUNTREGRABACIONIn,
          String TIPOREGRABACIONIn,
          String NUMERO_SERIEIn,
          String NUMERO_CHASISIn,
          String NUMERO_MOTORIn,
          String MOTIVO_REGRABACIONIn,
          String NUMERO_REVISIONTECNOMECANICAIn,
          int ID_FACTURAIn,
          int ID_VEHICULOIn) {
          this.ID_RUNTREGRABACION = ID_RUNTREGRABACIONIn;
          this.TIPOREGRABACION = TIPOREGRABACIONIn;
          this.NUMERO_SERIE = NUMERO_SERIEIn;
          this.NUMERO_CHASIS = NUMERO_CHASISIn;
          this.NUMERO_MOTOR = NUMERO_MOTORIn;
          this.MOTIVO_REGRABACION = MOTIVO_REGRABACIONIn;
          this.NUMERO_REVISIONTECNOMECANICA = NUMERO_REVISIONTECNOMECANICAIn;
          this.ID_FACTURA = ID_FACTURAIn;
          this.ID_VEHICULO = ID_VEHICULOIn;
    }


    /** 
     * hasEqualMapping-method will compare two RuntRegrabacionVehiculo instances
     * and return true if they contain same values in all persistent instance 
     * variables. If hasEqualMapping returns true, it does not mean the objects
     * are the same instance. However it does mean that in that moment, they 
     * are mapped to the same row in database.
     */
    public boolean hasEqualMapping(RuntRegrabacionVehiculo valueObject) {

          if (valueObject.getID_RUNTREGRABACION() != this.ID_RUNTREGRABACION) {
                    return(false);
          }
          if (this.TIPOREGRABACION == null) {
                    if (valueObject.getTIPOREGRABACION() != null)
                           return(false);
          } else if (!this.TIPOREGRABACION.equals(valueObject.getTIPOREGRABACION())) {
                    return(false);
          }
          if (this.NUMERO_SERIE == null) {
                    if (valueObject.getNUMERO_SERIE() != null)
                           return(false);
          } else if (!this.NUMERO_SERIE.equals(valueObject.getNUMERO_SERIE())) {
                    return(false);
          }
          if (this.NUMERO_CHASIS == null) {
                    if (valueObject.getNUMERO_CHASIS() != null)
                           return(false);
          } else if (!this.NUMERO_CHASIS.equals(valueObject.getNUMERO_CHASIS())) {
                    return(false);
          }
          if (this.NUMERO_MOTOR == null) {
                    if (valueObject.getNUMERO_MOTOR() != null)
                           return(false);
          } else if (!this.NUMERO_MOTOR.equals(valueObject.getNUMERO_MOTOR())) {
                    return(false);
          }
          if (this.MOTIVO_REGRABACION == null) {
                    if (valueObject.getMOTIVO_REGRABACION() != null)
                           return(false);
          } else if (!this.MOTIVO_REGRABACION.equals(valueObject.getMOTIVO_REGRABACION())) {
                    return(false);
          }
          if (this.NUMERO_REVISIONTECNOMECANICA == null) {
                    if (valueObject.getNUMERO_REVISIONTECNOMECANICA() != null)
                           return(false);
          } else if (!this.NUMERO_REVISIONTECNOMECANICA.equals(valueObject.getNUMERO_REVISIONTECNOMECANICA())) {
                    return(false);
          }
          if (valueObject.getID_FACTURA() != this.ID_FACTURA) {
                    return(false);
          }
          if (valueObject.getID_VEHICULO() != this.ID_VEHICULO) {
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
        out.append("\nclass RuntRegrabacionVehiculo, mapping to table RUNTREGRABACIONVEHICULO\n");
        out.append("Persistent attributes: \n"); 
        out.append("ID_RUNTREGRABACION = " + this.ID_RUNTREGRABACION + "\n"); 
        out.append("TIPOREGRABACION = " + this.TIPOREGRABACION + "\n"); 
        out.append("NUMERO_SERIE = " + this.NUMERO_SERIE + "\n"); 
        out.append("NUMERO_CHASIS = " + this.NUMERO_CHASIS + "\n"); 
        out.append("NUMERO_MOTOR = " + this.NUMERO_MOTOR + "\n"); 
        out.append("MOTIVO_REGRABACION = " + this.MOTIVO_REGRABACION + "\n"); 
        out.append("NUMERO_REVISIONTECNOMECANICA = " + this.NUMERO_REVISIONTECNOMECANICA + "\n"); 
        out.append("ID_FACTURA = " + this.ID_FACTURA + "\n"); 
        out.append("ID_VEHICULO = " + this.ID_VEHICULO + "\n"); 
        return out.toString();
    }


    /**
     * Clone will return identical deep copy of this valueObject.
     * Note, that this method is different than the clone() which
     * is defined in java.lang.Object. Here, the retuned cloned object
     * will also have all its attributes cloned.
     */
    public Object clone() {
        RuntRegrabacionVehiculo cloned = new RuntRegrabacionVehiculo();

        cloned.setID_RUNTREGRABACION(this.ID_RUNTREGRABACION); 
        if (this.TIPOREGRABACION != null)
             cloned.setTIPOREGRABACION(new String(this.TIPOREGRABACION)); 
        if (this.NUMERO_SERIE != null)
             cloned.setNUMERO_SERIE(new String(this.NUMERO_SERIE)); 
        if (this.NUMERO_CHASIS != null)
             cloned.setNUMERO_CHASIS(new String(this.NUMERO_CHASIS)); 
        if (this.NUMERO_MOTOR != null)
             cloned.setNUMERO_MOTOR(new String(this.NUMERO_MOTOR)); 
        if (this.MOTIVO_REGRABACION != null)
             cloned.setMOTIVO_REGRABACION(new String(this.MOTIVO_REGRABACION)); 
        if (this.NUMERO_REVISIONTECNOMECANICA != null)
             cloned.setNUMERO_REVISIONTECNOMECANICA(new String(this.NUMERO_REVISIONTECNOMECANICA)); 
        cloned.setID_FACTURA(this.ID_FACTURA); 
        cloned.setID_VEHICULO(this.ID_VEHICULO); 
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