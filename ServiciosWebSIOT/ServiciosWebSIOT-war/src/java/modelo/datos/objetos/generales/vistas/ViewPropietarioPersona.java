package modelo.datos.objetos.generales.vistas;

import java.io.*;
import java.sql.*;
import java.util.*;
import java.math.*;

 /**
  * ViewPropietarioPersona Value Object.
  * This class is value object representing database table VIEW_PROPIETARIOPERSONA
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



public class ViewPropietarioPersona implements Cloneable, Serializable {

    /** 
     * Persistent Instance variables. This data is directly 
     * mapped to the columns of database table.
     */
    private String IDENTIFICACION;
    private String ID_DOCTORUNT;
    private int ID_PERSONAS;
    private String NOMBRE;
    private String DIRECCION;
    private String TELEFONO;
    private String CIUDAD;



    /** 
     * Constructors. DaoGen generates two constructors by default.
     * The first one takes no arguments and provides the most simple
     * way to create object instance. The another one takes one
     * argument, which is the primary key of the corresponding table.
     */

    public ViewPropietarioPersona () {

    }

    public ViewPropietarioPersona (String IDENTIFICACIONIn) {

          this.IDENTIFICACION = IDENTIFICACIONIn;

    }


    /** 
     * Get- and Set-methods for persistent variables. The default
     * behaviour does not make any checks against malformed data,
     * so these might require some manual additions.
     */

    public String getIDENTIFICACION() {
          return this.IDENTIFICACION;
    }
    public void setIDENTIFICACION(String IDENTIFICACIONIn) {
          this.IDENTIFICACION = IDENTIFICACIONIn;
    }

    public String getID_DOCTORUNT() {
          return this.ID_DOCTORUNT;
    }
    public void setID_DOCTORUNT(String ID_DOCTORUNTIn) {
          this.ID_DOCTORUNT = ID_DOCTORUNTIn;
    }

    public int getID_PERSONAS() {
          return this.ID_PERSONAS;
    }
    public void setID_PERSONAS(int ID_PERSONASIn) {
          this.ID_PERSONAS = ID_PERSONASIn;
    }

    public String getNOMBRE() {
          return this.NOMBRE;
    }
    public void setNOMBRE(String NOMBREIn) {
          this.NOMBRE = NOMBREIn;
    }

    public String getDIRECCION() {
          return this.DIRECCION;
    }
    public void setDIRECCION(String DIRECCIONIn) {
          this.DIRECCION = DIRECCIONIn;
    }

    public String getTELEFONO() {
          return this.TELEFONO;
    }
    public void setTELEFONO(String TELEFONOIn) {
          this.TELEFONO = TELEFONOIn;
    }

    public String getCIUDAD() {
          return this.CIUDAD;
    }
    public void setCIUDAD(String CIUDADIn) {
          this.CIUDAD = CIUDADIn;
    }



    /** 
     * setAll allows to set all persistent variables in one method call.
     * This is useful, when all data is available and it is needed to 
     * set the initial state of this object. Note that this method will
     * directly modify instance variales, without going trough the 
     * individual set-methods.
     */

    public void setAll(String IDENTIFICACIONIn,
          String ID_DOCTORUNTIn,
          int ID_PERSONASIn,
          String NOMBREIn,
          String DIRECCIONIn,
          String TELEFONOIn,
          String CIUDADIn) {
          this.IDENTIFICACION = IDENTIFICACIONIn;
          this.ID_DOCTORUNT = ID_DOCTORUNTIn;
          this.ID_PERSONAS = ID_PERSONASIn;
          this.NOMBRE = NOMBREIn;
          this.DIRECCION = DIRECCIONIn;
          this.TELEFONO = TELEFONOIn;
          this.CIUDAD = CIUDADIn;
    }


    /** 
     * hasEqualMapping-method will compare two ViewPropietarioPersona instances
     * and return true if they contain same values in all persistent instance 
     * variables. If hasEqualMapping returns true, it does not mean the objects
     * are the same instance. However it does mean that in that moment, they 
     * are mapped to the same row in database.
     */
    public boolean hasEqualMapping(ViewPropietarioPersona valueObject) {

          if (this.IDENTIFICACION == null) {
                    if (valueObject.getIDENTIFICACION() != null)
                           return(false);
          } else if (!this.IDENTIFICACION.equals(valueObject.getIDENTIFICACION())) {
                    return(false);
          }
          if (this.ID_DOCTORUNT == null) {
                    if (valueObject.getID_DOCTORUNT() != null)
                           return(false);
          } else if (!this.ID_DOCTORUNT.equals(valueObject.getID_DOCTORUNT())) {
                    return(false);
          }
          if (valueObject.getID_PERSONAS() != this.ID_PERSONAS) {
                    return(false);
          }
          if (this.NOMBRE == null) {
                    if (valueObject.getNOMBRE() != null)
                           return(false);
          } else if (!this.NOMBRE.equals(valueObject.getNOMBRE())) {
                    return(false);
          }
          if (this.DIRECCION == null) {
                    if (valueObject.getDIRECCION() != null)
                           return(false);
          } else if (!this.DIRECCION.equals(valueObject.getDIRECCION())) {
                    return(false);
          }
          if (this.TELEFONO == null) {
                    if (valueObject.getTELEFONO() != null)
                           return(false);
          } else if (!this.TELEFONO.equals(valueObject.getTELEFONO())) {
                    return(false);
          }
          if (this.CIUDAD == null) {
                    if (valueObject.getCIUDAD() != null)
                           return(false);
          } else if (!this.CIUDAD.equals(valueObject.getCIUDAD())) {
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
        out.append("\nclass ViewPropietarioPersona, mapping to table VIEW_PROPIETARIOPERSONA\n");
        out.append("Persistent attributes: \n"); 
        out.append("IDENTIFICACION = " + this.IDENTIFICACION + "\n"); 
        out.append("ID_DOCTORUNT = " + this.ID_DOCTORUNT + "\n"); 
        out.append("ID_PERSONAS = " + this.ID_PERSONAS + "\n"); 
        out.append("NOMBRE = " + this.NOMBRE + "\n"); 
        out.append("DIRECCION = " + this.DIRECCION + "\n"); 
        out.append("TELEFONO = " + this.TELEFONO + "\n"); 
        out.append("CIUDAD = " + this.CIUDAD + "\n"); 
        return out.toString();
    }


    /**
     * Clone will return identical deep copy of this valueObject.
     * Note, that this method is different than the clone() which
     * is defined in java.lang.Object. Here, the retuned cloned object
     * will also have all its attributes cloned.
     */
    public Object clone() {
        ViewPropietarioPersona cloned = new ViewPropietarioPersona();

        if (this.IDENTIFICACION != null)
             cloned.setIDENTIFICACION(new String(this.IDENTIFICACION)); 
        if (this.ID_DOCTORUNT != null)
             cloned.setID_DOCTORUNT(new String(this.ID_DOCTORUNT)); 
        cloned.setID_PERSONAS(this.ID_PERSONAS); 
        if (this.NOMBRE != null)
             cloned.setNOMBRE(new String(this.NOMBRE)); 
        if (this.DIRECCION != null)
             cloned.setDIRECCION(new String(this.DIRECCION)); 
        if (this.TELEFONO != null)
             cloned.setTELEFONO(new String(this.TELEFONO)); 
        if (this.CIUDAD != null)
             cloned.setCIUDAD(new String(this.CIUDAD)); 
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