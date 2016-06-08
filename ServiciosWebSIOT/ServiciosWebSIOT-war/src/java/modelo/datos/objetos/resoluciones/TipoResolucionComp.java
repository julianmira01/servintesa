package modelo.datos.objetos.resoluciones;


import java.io.*;
import java.sql.*;
import java.util.*;
import java.math.*;

 /**
  * TipoResolucionComp Value Object.
  * This class is value object representing database table TIPORESOLUCION
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



public class TipoResolucionComp implements Cloneable, Serializable {

    /** 
     * Persistent Instance variables. This data is directly 
     * mapped to the columns of database table.
     */
    private int IDTIPORESOLUCION;
    private String CODTIPORESOLUCION;
    private String DES_TIPORESOLUCION;
    private int ID_NUEVOESTADO;



    /** 
     * Constructors. DaoGen generates two constructors by default.
     * The first one takes no arguments and provides the most simple
     * way to create object instance. The another one takes one
     * argument, which is the primary key of the corresponding table.
     */

    public TipoResolucionComp () {

    }

    public TipoResolucionComp (int IDTIPORESOLUCIONIn) {

          this.IDTIPORESOLUCION = IDTIPORESOLUCIONIn;

    }


    /** 
     * Get- and Set-methods for persistent variables. The default
     * behaviour does not make any checks against malformed data,
     * so these might require some manual additions.
     */

    public int getIDTIPORESOLUCION() {
          return this.IDTIPORESOLUCION;
    }
    public void setIDTIPORESOLUCION(int IDTIPORESOLUCIONIn) {
          this.IDTIPORESOLUCION = IDTIPORESOLUCIONIn;
    }
    public String getCODTIPORESOLUCION() {
          return this.CODTIPORESOLUCION;
    }
    public void setCODTIPORESOLUCION(String CODTIPORESOLUCIONIn) {
          this.CODTIPORESOLUCION = CODTIPORESOLUCIONIn;
    }

    public String getDES_TIPORESOLUCION() {
          return this.DES_TIPORESOLUCION;
    }
    public void setDES_TIPORESOLUCION(String DES_TIPORESOLUCIONIn) {
          this.DES_TIPORESOLUCION = DES_TIPORESOLUCIONIn;
    }
    public int getID_NUEVOESTADO() {
        return ID_NUEVOESTADO;
    }
    public void setID_NUEVOESTADO(int ID_NUEVOESTADOIn) {
        this.ID_NUEVOESTADO = ID_NUEVOESTADOIn;
    }


    /** 
     * setAll allows to set all persistent variables in one method call.
     * This is useful, when all data is available and it is needed to 
     * set the initial state of this object. Note that this method will
     * directly modify instance variales, without going trough the 
     * individual set-methods.
     */

    public void setAll(int IDTIPORESOLUCIONIn,
          String CODTIPORESOLUCIONIn,
          String DES_TIPORESOLUCIONIn,
          int ID_NUEVOESTADOIn) {
          this.IDTIPORESOLUCION = IDTIPORESOLUCIONIn;
          this.CODTIPORESOLUCION = CODTIPORESOLUCIONIn;
          this.DES_TIPORESOLUCION = DES_TIPORESOLUCIONIn;
          this.ID_NUEVOESTADO = ID_NUEVOESTADOIn;
    }


    /** 
     * hasEqualMapping-method will compare two TipoResolucionComp instances
     * and return true if they contain same values in all persistent instance 
     * variables. If hasEqualMapping returns true, it does not mean the objects
     * are the same instance. However it does mean that in that moment, they 
     * are mapped to the same row in database.
     */
    public boolean hasEqualMapping(TipoResolucionComp valueObject) {

          if (valueObject.getIDTIPORESOLUCION() != this.IDTIPORESOLUCION) {
                    return(false);
          }
          if (this.CODTIPORESOLUCION == null) {
                    if (valueObject.getCODTIPORESOLUCION() != null)
                           return(false);
          } else if (!this.CODTIPORESOLUCION.equals(valueObject.getCODTIPORESOLUCION())) {
                    return(false);
          }
          if (this.DES_TIPORESOLUCION == null) {
                    if (valueObject.getDES_TIPORESOLUCION() != null)
                           return(false);
          } else if (!this.DES_TIPORESOLUCION.equals(valueObject.getDES_TIPORESOLUCION())) {
                    return(false);
          }
        if (valueObject.getID_NUEVOESTADO() != this.ID_NUEVOESTADO) {
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
        out.append("\nclass TipoResolucionComp, mapping to table TIPORESOLUCION\n");
        out.append("Persistent attributes: \n"); 
        out.append("IDTIPORESOLUCION = " + this.IDTIPORESOLUCION + "\n"); 
        out.append("CODTIPORESOLUCION = " + this.CODTIPORESOLUCION + "\n"); 
        out.append("DES_TIPORESOLUCION = " + this.DES_TIPORESOLUCION + "\n"); 
        out.append("ID_NUEVOESTADO = " + this.ID_NUEVOESTADO + "\n");
        return out.toString();
    }


    /**
     * Clone will return identical deep copy of this valueObject.
     * Note, that this method is different than the clone() which
     * is defined in java.lang.Object. Here, the retuned cloned object
     * will also have all its attributes cloned.
     */
    public Object clone() {
        TipoResolucionComp cloned = new TipoResolucionComp();

        cloned.setIDTIPORESOLUCION(this.IDTIPORESOLUCION); 
        if (this.CODTIPORESOLUCION != null)
             cloned.setCODTIPORESOLUCION(new String(this.CODTIPORESOLUCION)); 
        if (this.DES_TIPORESOLUCION != null)
             cloned.setDES_TIPORESOLUCION(new String(this.DES_TIPORESOLUCION)); 
        cloned.setID_NUEVOESTADO(this.ID_NUEVOESTADO); 
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
