package modelo.datos.objetos.transportepublico.cupos;

import java.io.*;
import java.sql.*;
import java.util.*;
import java.math.*;

 /**
  * CuposTaxis Value Object.
  * This class is value object representing database table CuposTaxis
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



public class CuposTaxisTrans implements Cloneable, Serializable {

    /** 
     * Persistent Instance variables. This data is directly 
     * mapped to the columns of database table.
     */
    private int TT_NUMCUPO;
    private int TT_ID_PERSONA;
    private int TT_ID_VEHICULO;
    private int TT_ID_EMPSERVICIO;
    private int TT_IDUSUARIOREG;
    private int TT_IDCUPOTAXI;
    private String TT_TIPOVEH;
    private int TT_IDEMPRESA;
    private int TT_IDTARJETA;
    private int T_IDDETALLERANGOCUPO;
    private String T_NUME_DECR;
    private String T_CAPACIDAD_CARGA;



    /** 
     * Constructors. DaoGen generates two constructors by default.
     * The first one takes no arguments and provides the most simple
     * way to create object instance. The another one takes one
     * argument, which is the primary key of the corresponding table.
     */

    public CuposTaxisTrans () {

    }

    public CuposTaxisTrans (int TT_NUMCUPOIn) {

          this.TT_NUMCUPO = TT_NUMCUPOIn;

    }


    /** 
     * Get- and Set-methods for persistent variables. The default
     * behaviour does not make any checks against malformed data,
     * so these might require some manual additions.
     */

    public int getTT_NUMCUPO() {
          return this.TT_NUMCUPO;
    }
    public void setTT_NUMCUPO(int TT_NUMCUPOIn) {
          this.TT_NUMCUPO = TT_NUMCUPOIn;
    }

    public int getTT_ID_PERSONA() {
          return this.TT_ID_PERSONA;
    }
    public void setTT_ID_PERSONA(int TT_ID_PERSONAIn) {
          this.TT_ID_PERSONA = TT_ID_PERSONAIn;
    }

    public int getTT_ID_VEHICULO() {
          return this.TT_ID_VEHICULO;
    }
    public void setTT_ID_VEHICULO(int TT_ID_VEHICULOIn) {
          this.TT_ID_VEHICULO = TT_ID_VEHICULOIn;
    }

    public int getTT_ID_EMPSERVICIO() {
          return this.TT_ID_EMPSERVICIO;
    }
    public void setTT_ID_EMPSERVICIO(int TT_ID_EMPSERVICIOIn) {
          this.TT_ID_EMPSERVICIO = TT_ID_EMPSERVICIOIn;
    }

    public int getTT_IDUSUARIOREG() {
          return this.TT_IDUSUARIOREG;
    }
    public void setTT_IDUSUARIOREG(int TT_IDUSUARIOREGIn) {
          this.TT_IDUSUARIOREG = TT_IDUSUARIOREGIn;
    }

    public int getTT_IDCUPOTAXI() {
          return this.TT_IDCUPOTAXI;
    }
    public void setTT_IDCUPOTAXI(int TT_IDCUPOTAXIIn) {
          this.TT_IDCUPOTAXI = TT_IDCUPOTAXIIn;
    }

    public String getTT_TIPOVEH() {
          return this.TT_TIPOVEH;
    }
    public void setTT_TIPOVEH(String TT_TIPOVEHIn) {
          this.TT_TIPOVEH = TT_TIPOVEHIn;
    }

    public int getTT_IDEMPRESA() {
          return this.TT_IDEMPRESA;
    }
    public void setTT_IDEMPRESA(int TT_IDEMPRESAIn) {
          this.TT_IDEMPRESA = TT_IDEMPRESAIn;
    }

    public int getTT_IDTARJETA() {
          return this.TT_IDTARJETA;
    }
    public void setTT_IDTARJETA(int TT_IDTARJETAIn) {
          this.TT_IDTARJETA = TT_IDTARJETAIn;
    }



    /** 
     * setAll allows to set all persistent variables in one method call.
     * This is useful, when all data is available and it is needed to 
     * set the initial state of this object. Note that this method will
     * directly modify instance variales, without going trough the 
     * individual set-methods.
     */

    public void setAll(int TT_NUMCUPOIn,
          int TT_ID_PERSONAIn,
          int TT_ID_VEHICULOIn,
          int TT_ID_EMPSERVICIOIn,
          int TT_IDUSUARIOREGIn,
          int TT_IDCUPOTAXIIn,
          String TT_TIPOVEHIn,
          int TT_IDEMPRESAIn,
          int TT_IDTARJETAIn) {
          this.TT_NUMCUPO = TT_NUMCUPOIn;
          this.TT_ID_PERSONA = TT_ID_PERSONAIn;
          this.TT_ID_VEHICULO = TT_ID_VEHICULOIn;
          this.TT_ID_EMPSERVICIO = TT_ID_EMPSERVICIOIn;
          this.TT_IDUSUARIOREG = TT_IDUSUARIOREGIn;
          this.TT_IDCUPOTAXI = TT_IDCUPOTAXIIn;
          this.TT_TIPOVEH = TT_TIPOVEHIn;
          this.TT_IDEMPRESA = TT_IDEMPRESAIn;
          this.TT_IDTARJETA = TT_IDTARJETAIn;
    }


    /** 
     * hasEqualMapping-method will compare two CuposTaxis instances
     * and return true if they contain same values in all persistent instance 
     * variables. If hasEqualMapping returns true, it does not mean the objects
     * are the same instance. However it does mean that in that moment, they 
     * are mapped to the same row in database.
     */
    public boolean hasEqualMapping(CuposTaxisTrans valueObject) {

          if (valueObject.getTT_NUMCUPO() != this.TT_NUMCUPO) {
                    return(false);
          }
          if (valueObject.getTT_ID_PERSONA() != this.TT_ID_PERSONA) {
                    return(false);
          }
          if (valueObject.getTT_ID_VEHICULO() != this.TT_ID_VEHICULO) {
                    return(false);
          }
          if (valueObject.getTT_ID_EMPSERVICIO() != this.TT_ID_EMPSERVICIO) {
                    return(false);
          }
          if (valueObject.getTT_IDUSUARIOREG() != this.TT_IDUSUARIOREG) {
                    return(false);
          }
          if (valueObject.getTT_IDCUPOTAXI() != this.TT_IDCUPOTAXI) {
                    return(false);
          }
          if (this.TT_TIPOVEH == null) {
                    if (valueObject.getTT_TIPOVEH() != null)
                           return(false);
          } else if (!this.TT_TIPOVEH.equals(valueObject.getTT_TIPOVEH())) {
                    return(false);
          }
          if (valueObject.getTT_IDEMPRESA() != this.TT_IDEMPRESA) {
                    return(false);
          }
          if (valueObject.getTT_IDTARJETA() != this.TT_IDTARJETA) {
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
        out.append("\nclass CuposTaxis, mapping to table CuposTaxis\n");
        out.append("Persistent attributes: \n"); 
        out.append("TT_NUMCUPO = " + this.TT_NUMCUPO + "\n"); 
        out.append("TT_ID_PERSONA = " + this.TT_ID_PERSONA + "\n"); 
        out.append("TT_ID_VEHICULO = " + this.TT_ID_VEHICULO + "\n"); 
        out.append("TT_ID_EMPSERVICIO = " + this.TT_ID_EMPSERVICIO + "\n"); 
        out.append("TT_IDUSUARIOREG = " + this.TT_IDUSUARIOREG + "\n"); 
        out.append("TT_IDCUPOTAXI = " + this.TT_IDCUPOTAXI + "\n"); 
        out.append("TT_TIPOVEH = " + this.TT_TIPOVEH + "\n"); 
        out.append("TT_IDEMPRESA = " + this.TT_IDEMPRESA + "\n"); 
        out.append("TT_IDTARJETA = " + this.TT_IDTARJETA + "\n"); 
        return out.toString();
    }


    /**
     * Clone will return identical deep copy of this valueObject.
     * Note, that this method is different than the clone() which
     * is defined in java.lang.Object. Here, the retuned cloned object
     * will also have all its attributes cloned.
     */
    public Object clone() {
        CuposTaxisTrans cloned = new CuposTaxisTrans();

        cloned.setTT_NUMCUPO(this.TT_NUMCUPO); 
        cloned.setTT_ID_PERSONA(this.TT_ID_PERSONA); 
        cloned.setTT_ID_VEHICULO(this.TT_ID_VEHICULO); 
        cloned.setTT_ID_EMPSERVICIO(this.TT_ID_EMPSERVICIO); 
        cloned.setTT_IDUSUARIOREG(this.TT_IDUSUARIOREG); 
        cloned.setTT_IDCUPOTAXI(this.TT_IDCUPOTAXI); 
        if (this.TT_TIPOVEH != null)
             cloned.setTT_TIPOVEH(new String(this.TT_TIPOVEH)); 
        cloned.setTT_IDEMPRESA(this.TT_IDEMPRESA); 
        cloned.setTT_IDTARJETA(this.TT_IDTARJETA); 
        return cloned;
    }



    /** 
     * getDaogenVersion will return information about
     * generator which created these sources.
     */
    public String getDaogenVersion() {
        return "DaoGen version 2.4.1";
    }

    public int getT_IDDETALLERANGOCUPO() {
        return T_IDDETALLERANGOCUPO;
    }

    public void setT_IDDETALLERANGOCUPO(int T_IDDETALLERANGOCUPO) {
        this.T_IDDETALLERANGOCUPO = T_IDDETALLERANGOCUPO;
    }

    public String getT_NUME_DECR() {
        return T_NUME_DECR;
    }

    public void setT_NUME_DECR(String T_NUME_DECR) {
        this.T_NUME_DECR = T_NUME_DECR;
    }

    public String getT_CAPACIDAD_CARGA() {
        return T_CAPACIDAD_CARGA;
    }

    public void setT_CAPACIDAD_CARGA(String T_CAPACIDAD_CARGA) {
        this.T_CAPACIDAD_CARGA = T_CAPACIDAD_CARGA;
    }
}
