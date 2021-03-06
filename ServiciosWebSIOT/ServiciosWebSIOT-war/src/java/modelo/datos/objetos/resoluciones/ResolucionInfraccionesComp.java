package modelo.datos.objetos.resoluciones;

import java.io.*;
import java.sql.*;
import java.util.*;
import java.math.*;

 /**
  * ResolucionInfractoresComp Value Object.
  * This class is value object representing database table RESOLUCIONINFRACCIONES
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



public class ResolucionInfraccionesComp implements Cloneable, Serializable {

    /** 
     * Persistent Instance variables. This data is directly 
     * mapped to the columns of database table.
     */
    private int ID;
    private int IDRESOLUCION;
    private int IDINFRACCION;



    /** 
     * Constructors. DaoGen generates two constructors by default.
     * The first one takes no arguments and provides the most simple
     * way to create object instance. The another one takes one
     * argument, which is the primary key of the corresponding table.
     */

    public ResolucionInfraccionesComp () {

    }

    public ResolucionInfraccionesComp (int IDIn) {

          this.ID = IDIn;

    }


    /** 
     * Get- and Set-methods for persistent variables. The default
     * behaviour does not make any checks against malformed data,
     * so these might require some manual additions.
     */

    public int getID() {
          return this.ID;
    }
    public void setID(int IDIn) {
          this.ID = IDIn;
    }

    public int getIDRESOLUCION() {
          return this.IDRESOLUCION;
    }
    public void setIDRESOLUCION(int IDRESOLUCIONIn) {
          this.IDRESOLUCION = IDRESOLUCIONIn;
    }

    public int getIDINFRACCION() {
          return this.IDINFRACCION;
    }
    public void setIDINFRACCION(int IDINFRACCIONIn) {
          this.IDINFRACCION = IDINFRACCIONIn;
    }



    /** 
     * setAll allows to set all persistent variables in one method call.
     * This is useful, when all data is available and it is needed to 
     * set the initial state of this object. Note that this method will
     * directly modify instance variales, without going trough the 
     * individual set-methods.
     */

    public void setAll(int IDIn,
          int IDRESOLUCIONIn,
          int IDINFRACCIONIn) {
          this.ID = IDIn;
          this.IDRESOLUCION = IDRESOLUCIONIn;
          this.IDINFRACCION = IDINFRACCIONIn;
    }


    /** 
     * hasEqualMapping-method will compare two ResolucionInfractoresComp instances
     * and return true if they contain same values in all persistent instance 
     * variables. If hasEqualMapping returns true, it does not mean the objects
     * are the same instance. However it does mean that in that moment, they 
     * are mapped to the same row in database.
     */
    public boolean hasEqualMapping(ResolucionInfraccionesComp valueObject) {

          if (valueObject.getID() != this.ID) {
                    return(false);
          }
          if (valueObject.getIDRESOLUCION() != this.IDRESOLUCION) {
                    return(false);
          }
          if (valueObject.getIDINFRACCION() != this.IDINFRACCION) {
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
        out.append("\nclass ResolucionInfractoresComp, mapping to table RESOLUCIONINFRACCIONES\n");
        out.append("Persistent attributes: \n"); 
        out.append("ID = " + this.ID + "\n"); 
        out.append("IDRESOLUCION = " + this.IDRESOLUCION + "\n"); 
        out.append("IDINFRACCION = " + this.IDINFRACCION + "\n"); 
        return out.toString();
    }


    /**
     * Clone will return identical deep copy of this valueObject.
     * Note, that this method is different than the clone() which
     * is defined in java.lang.Object. Here, the retuned cloned object
     * will also have all its attributes cloned.
     */
    public Object clone() {
        ResolucionInfraccionesComp cloned = new ResolucionInfraccionesComp();

        cloned.setID(this.ID); 
        cloned.setIDRESOLUCION(this.IDRESOLUCION); 
        cloned.setIDINFRACCION(this.IDINFRACCION); 
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