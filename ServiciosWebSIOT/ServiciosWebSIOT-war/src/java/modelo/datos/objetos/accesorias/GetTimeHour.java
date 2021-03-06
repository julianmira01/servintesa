package modelo.datos.objetos.accesorias;

import java.io.*;
import java.sql.*;
import java.util.*;
import java.math.*;

 /**
  * GetTimeHour Value Object.
  * This class is value object representing database table GETTIMEHOUR
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



public class GetTimeHour implements Cloneable, Serializable {

    /** 
     * Persistent Instance variables. This data is directly 
     * mapped to the columns of database table.
     */
    private int ANIO;
    private int MES;
    private int DIA;
    private int HORA;
    private int MINUTO;
    private int SEGUNDO;



    /** 
     * Constructors. DaoGen generates two constructors by default.
     * The first one takes no arguments and provides the most simple
     * way to create object instance. The another one takes one
     * argument, which is the primary key of the corresponding table.
     */

    public GetTimeHour () {

    }

    public GetTimeHour (int ANIOIn) {

          this.ANIO = ANIOIn;

    }


    /** 
     * Get- and Set-methods for persistent variables. The default
     * behaviour does not make any checks against malformed data,
     * so these might require some manual additions.
     */

    public int getANIO() {
          return this.ANIO;
    }
    public void setANIO(int ANIOIn) {
          this.ANIO = ANIOIn;
    }

    public int getMES() {
          return this.MES;
    }
    public void setMES(int MESIn) {
          this.MES = MESIn;
    }

    public int getDIA() {
          return this.DIA;
    }
    public void setDIA(int DIAIn) {
          this.DIA = DIAIn;
    }

    public int getHORA() {
          return this.HORA;
    }
    public void setHORA(int HORAIn) {
          this.HORA = HORAIn;
    }

    public int getMINUTO() {
          return this.MINUTO;
    }
    public void setMINUTO(int MINUTOIn) {
          this.MINUTO = MINUTOIn;
    }



    /** 
     * setAll allows to set all persistent variables in one method call.
     * This is useful, when all data is available and it is needed to 
     * set the initial state of this object. Note that this method will
     * directly modify instance variales, without going trough the 
     * individual set-methods.
     */

    public void setAll(int ANIOIn,
          int MESIn,
          int DIAIn,
          int HORAIn,
          int MINUTOIn,
          int SEGUNDOIn) {
          this.ANIO = ANIOIn;
          this.MES = MESIn;
          this.DIA = DIAIn;
          this.HORA = HORAIn;
          this.MINUTO = MINUTOIn;
          this.SEGUNDO = SEGUNDOIn;
    }


    /** 
     * hasEqualMapping-method will compare two GetTimeHour instances
     * and return true if they contain same values in all persistent instance 
     * variables. If hasEqualMapping returns true, it does not mean the objects
     * are the same instance. However it does mean that in that moment, they 
     * are mapped to the same row in database.
     */
    public boolean hasEqualMapping(GetTimeHour valueObject) {

          if (valueObject.getANIO() != this.ANIO) {
                    return(false);
          }
          if (valueObject.getMES() != this.MES) {
                    return(false);
          }
          if (valueObject.getDIA() != this.DIA) {
                    return(false);
          }
          if (valueObject.getHORA() != this.HORA) {
                    return(false);
          }
          if (valueObject.getMINUTO() != this.MINUTO) {
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
        out.append("\nclass GetTimeHour, mapping to table GETTIMEHOUR\n");
        out.append("Persistent attributes: \n"); 
        out.append("ANIO = " + this.ANIO + "\n"); 
        out.append("MES = " + this.MES + "\n"); 
        out.append("DIA = " + this.DIA + "\n"); 
        out.append("HORA = " + this.HORA + "\n"); 
        out.append("MINUTO = " + this.MINUTO + "\n"); 
        return out.toString();
    }


    /**
     * Clone will return identical deep copy of this valueObject.
     * Note, that this method is different than the clone() which
     * is defined in java.lang.Object. Here, the retuned cloned object
     * will also have all its attributes cloned.
     */
    public Object clone() {
        GetTimeHour cloned = new GetTimeHour();

        cloned.setANIO(this.ANIO); 
        cloned.setMES(this.MES); 
        cloned.setDIA(this.DIA); 
        cloned.setHORA(this.HORA); 
        cloned.setMINUTO(this.MINUTO); 
        return cloned;
    }



    /** 
     * getDaogenVersion will return information about
     * generator which created these sources.
     */
    public String getDaogenVersion() {
        return "DaoGen version 2.4.1";
    }

    public int getSEGUNDO() {
        return SEGUNDO;
    }

    public void setSEGUNDO(int SEGUNDO) {
        this.SEGUNDO = SEGUNDO;
    }
}

