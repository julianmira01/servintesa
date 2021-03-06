package modelo.datos.objetos.licenciasConduccion;

import java.io.*;
import java.sql.*;
import java.util.*;
import java.math.*;

 /**
  * ESTADOS_LICENCIACOND Value Object.
  * This class is value object representing database table ESTADOS_LICENCIACOND
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



public class ESTADOS_LICENCIACOND implements Cloneable, Serializable {

    /** 
     * Persistent Instance variables. This data is directly 
     * mapped to the columns of database table.
     */
    private int ID_ESTADOS_LICENCIACOND;
    private int ID_INFRACTOR;
    private String FECHA_TRANSACCION;
    private String OBSERVACIONES;
    private String ESTADO;



    /** 
     * Constructors. DaoGen generates two constructors by default.
     * The first one takes no arguments and provides the most simple
     * way to create object instance. The another one takes one
     * argument, which is the primary key of the corresponding table.
     */

    public ESTADOS_LICENCIACOND () {

    }

    public ESTADOS_LICENCIACOND (int ID_ESTADOS_LICENCIACONDIn) {

          this.ID_ESTADOS_LICENCIACOND = ID_ESTADOS_LICENCIACONDIn;

    }


    /** 
     * Get- and Set-methods for persistent variables. The default
     * behaviour does not make any checks against malformed data,
     * so these might require some manual additions.
     */

    public int getID_ESTADOS_LICENCIACOND() {
          return this.ID_ESTADOS_LICENCIACOND;
    }
    public void setID_ESTADOS_LICENCIACOND(int ID_ESTADOS_LICENCIACONDIn) {
          this.ID_ESTADOS_LICENCIACOND = ID_ESTADOS_LICENCIACONDIn;
    }

    public int getID_INFRACTOR() {
          return this.ID_INFRACTOR;
    }
    public void setID_INFRACTOR(int ID_INFRACTORIn) {
          this.ID_INFRACTOR = ID_INFRACTORIn;
    }

    public String getFECHA_TRANSACCION() {
          return this.FECHA_TRANSACCION;
    }
    public void setFECHA_TRANSACCION(String FECHA_TRANSACCIONIn) {
          this.FECHA_TRANSACCION = FECHA_TRANSACCIONIn;
    }

    public String getOBSERVACIONES() {
          return this.OBSERVACIONES;
    }
    public void setOBSERVACIONES(String OBSERVACIONESIn) {
          this.OBSERVACIONES = OBSERVACIONESIn;
    }

    public String getESTADO() {
          return this.ESTADO;
    }
    public void setESTADO(String ESTADOIn) {
          this.ESTADO = ESTADOIn;
    }



    /** 
     * setAll allows to set all persistent variables in one method call.
     * This is useful, when all data is available and it is needed to 
     * set the initial state of this object. Note that this method will
     * directly modify instance variales, without going trough the 
     * individual set-methods.
     */

    public void setAll(int ID_ESTADOS_LICENCIACONDIn,
          int ID_INFRACTORIn,
          String FECHA_TRANSACCIONIn,
          String OBSERVACIONESIn,
          String ESTADOIn) {
          this.ID_ESTADOS_LICENCIACOND = ID_ESTADOS_LICENCIACONDIn;
          this.ID_INFRACTOR = ID_INFRACTORIn;
          this.FECHA_TRANSACCION = FECHA_TRANSACCIONIn;
          this.OBSERVACIONES = OBSERVACIONESIn;
          this.ESTADO = ESTADOIn;
    }


    /** 
     * hasEqualMapping-method will compare two ESTADOS_LICENCIACOND instances
     * and return true if they contain same values in all persistent instance 
     * variables. If hasEqualMapping returns true, it does not mean the objects
     * are the same instance. However it does mean that in that moment, they 
     * are mapped to the same row in database.
     */
    public boolean hasEqualMapping(ESTADOS_LICENCIACOND valueObject) {

          if (valueObject.getID_ESTADOS_LICENCIACOND() != this.ID_ESTADOS_LICENCIACOND) {
                    return(false);
          }
          if (valueObject.getID_INFRACTOR() != this.ID_INFRACTOR) {
                    return(false);
          }
          if (this.FECHA_TRANSACCION == null) {
                    if (valueObject.getFECHA_TRANSACCION() != null)
                           return(false);
          } else if (!this.FECHA_TRANSACCION.equals(valueObject.getFECHA_TRANSACCION())) {
                    return(false);
          }
          if (this.OBSERVACIONES == null) {
                    if (valueObject.getOBSERVACIONES() != null)
                           return(false);
          } else if (!this.OBSERVACIONES.equals(valueObject.getOBSERVACIONES())) {
                    return(false);
          }
          if (this.ESTADO == null) {
                    if (valueObject.getESTADO() != null)
                           return(false);
          } else if (!this.ESTADO.equals(valueObject.getESTADO())) {
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
        out.append("\nclass ESTADOS_LICENCIACOND, mapping to table ESTADOS_LICENCIACOND\n");
        out.append("Persistent attributes: \n"); 
        out.append("ID_ESTADOS_LICENCIACOND = " + this.ID_ESTADOS_LICENCIACOND + "\n"); 
        out.append("ID_INFRACTOR = " + this.ID_INFRACTOR + "\n"); 
        out.append("FECHA_TRANSACCION = " + this.FECHA_TRANSACCION + "\n"); 
        out.append("OBSERVACIONES = " + this.OBSERVACIONES + "\n"); 
        out.append("ESTADO = " + this.ESTADO + "\n"); 
        return out.toString();
    }


    /**
     * Clone will return identical deep copy of this valueObject.
     * Note, that this method is different than the clone() which
     * is defined in java.lang.Object. Here, the retuned cloned object
     * will also have all its attributes cloned.
     */
    public Object clone() {
        ESTADOS_LICENCIACOND cloned = new ESTADOS_LICENCIACOND();

        cloned.setID_ESTADOS_LICENCIACOND(this.ID_ESTADOS_LICENCIACOND); 
        cloned.setID_INFRACTOR(this.ID_INFRACTOR); 
        if (this.FECHA_TRANSACCION != null)
             cloned.setFECHA_TRANSACCION(new String(this.FECHA_TRANSACCION)); 
        if (this.OBSERVACIONES != null)
             cloned.setOBSERVACIONES(new String(this.OBSERVACIONES)); 
        if (this.ESTADO != null)
             cloned.setESTADO(new String(this.ESTADO)); 
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

