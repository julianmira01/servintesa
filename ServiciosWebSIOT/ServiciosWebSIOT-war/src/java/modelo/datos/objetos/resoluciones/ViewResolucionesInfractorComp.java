package modelo.datos.objetos.resoluciones;

import java.io.Serializable;

/**
  * ViewResolucionesInfractorComp Value Object.
  * This class is value object representing database table VIEW_RESOLUCIONESINFRACTOR
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



public class ViewResolucionesInfractorComp implements Cloneable, Serializable {

    /** 
     * Persistent Instance variables. This data is directly 
     * mapped to the columns of database table.
     */
    private int ID_RESOLUCION;
    private String NUMERO;
    private String FECHA;
    private String CONTENIDO;
    private String NOMBRE;
    private String NROIDENTIFICACION;
    private int ID_DOCTO;
    private String NOMBRES;
    private String APELLIDOS;
    private String DIRECCION;
    private String TELEFONO;
    private int ID_TIPORESOLUCION;



    /** 
     * Constructors. DaoGen generates two constructors by default.
     * The first one takes no arguments and provides the most simple
     * way to create object instance. The another one takes one
     * argument, which is the primary key of the corresponding table.
     */

    public ViewResolucionesInfractorComp () {

    }

    public ViewResolucionesInfractorComp (int ID_RESOLUCIONIn) {

          this.ID_RESOLUCION = ID_RESOLUCIONIn;

    }


    /** 
     * Get- and Set-methods for persistent variables. The default
     * behaviour does not make any checks against malformed data,
     * so these might require some manual additions.
     */

    public int getID_RESOLUCION() {
          return this.ID_RESOLUCION;
    }
    public void setID_RESOLUCION(int ID_RESOLUCIONIn) {
          this.ID_RESOLUCION = ID_RESOLUCIONIn;
    }

    public String getNUMERO() {
          return this.NUMERO;
    }
    public void setNUMERO(String NUMEROIn) {
          this.NUMERO = NUMEROIn;
    }

    public String getFECHA() {
          return this.FECHA;
    }
    public void setFECHA(String FECHAIn) {
          this.FECHA = FECHAIn;
    }

    public String getCONTENIDO() {
          return this.CONTENIDO;
    }
    public void setCONTENIDO(String CONTENIDOIn) {
          this.CONTENIDO = CONTENIDOIn;
    }

    public String getNOMBRE() {
          return this.NOMBRE;
    }
    public void setNOMBRE(String NOMBREIn) {
          this.NOMBRE = NOMBREIn;
    }

    public String getNROIDENTIFICACION() {
          return this.NROIDENTIFICACION;
    }
    public void setNROIDENTIFICACION(String NROIDENTIFICACIONIn) {
          this.NROIDENTIFICACION = NROIDENTIFICACIONIn;
    }

    public int getID_DOCTO() {
          return this.ID_DOCTO;
    }
    public void setID_DOCTO(int ID_DOCTOIn) {
          this.ID_DOCTO = ID_DOCTOIn;
    }

    public String getNOMBRES() {
          return this.NOMBRES;
    }
    public void setNOMBRES(String NOMBRESIn) {
          this.NOMBRES = NOMBRESIn;
    }

    public String getAPELLIDOS() {
          return this.APELLIDOS;
    }
    public void setAPELLIDOS(String APELLIDOSIn) {
          this.APELLIDOS = APELLIDOSIn;
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



    /** 
     * setAll allows to set all persistent variables in one method call.
     * This is useful, when all data is available and it is needed to 
     * set the initial state of this object. Note that this method will
     * directly modify instance variales, without going trough the 
     * individual set-methods.
     */

    public void setAll(int ID_RESOLUCIONIn,
          String NUMEROIn,
          String FECHAIn,
          String CONTENIDOIn,
          String NOMBREIn,
          String NROIDENTIFICACIONIn,
          int ID_DOCTOIn,
          String NOMBRESIn,
          String APELLIDOSIn,
          String DIRECCIONIn,
          String TELEFONOIn) {
          this.ID_RESOLUCION = ID_RESOLUCIONIn;
          this.NUMERO = NUMEROIn;
          this.FECHA = FECHAIn;
          this.CONTENIDO = CONTENIDOIn;
          this.NOMBRE = NOMBREIn;
          this.NROIDENTIFICACION = NROIDENTIFICACIONIn;
          this.ID_DOCTO = ID_DOCTOIn;
          this.NOMBRES = NOMBRESIn;
          this.APELLIDOS = APELLIDOSIn;
          this.DIRECCION = DIRECCIONIn;
          this.TELEFONO = TELEFONOIn;
    }


    /** 
     * hasEqualMapping-method will compare two ViewResolucionesInfractorComp instances
     * and return true if they contain same values in all persistent instance 
     * variables. If hasEqualMapping returns true, it does not mean the objects
     * are the same instance. However it does mean that in that moment, they 
     * are mapped to the same row in database.
     */
    public boolean hasEqualMapping(ViewResolucionesInfractorComp valueObject) {

          if (valueObject.getID_RESOLUCION() != this.ID_RESOLUCION) {
                    return(false);
          }
          if (this.NUMERO == null) {
                    if (valueObject.getNUMERO() != null)
                           return(false);
          } else if (!this.NUMERO.equals(valueObject.getNUMERO())) {
                    return(false);
          }
          if (this.FECHA == null) {
                    if (valueObject.getFECHA() != null)
                           return(false);
          } else if (!this.FECHA.equals(valueObject.getFECHA())) {
                    return(false);
          }
          if (this.CONTENIDO == null) {
                    if (valueObject.getCONTENIDO() != null)
                           return(false);
          } else if (!this.CONTENIDO.equals(valueObject.getCONTENIDO())) {
                    return(false);
          }
          if (this.NOMBRE == null) {
                    if (valueObject.getNOMBRE() != null)
                           return(false);
          } else if (!this.NOMBRE.equals(valueObject.getNOMBRE())) {
                    return(false);
          }
          if (this.NROIDENTIFICACION == null) {
                    if (valueObject.getNROIDENTIFICACION() != null)
                           return(false);
          } else if (!this.NROIDENTIFICACION.equals(valueObject.getNROIDENTIFICACION())) {
                    return(false);
          }
          if (valueObject.getID_DOCTO() != this.ID_DOCTO) {
                    return(false);
          }
          if (this.NOMBRES == null) {
                    if (valueObject.getNOMBRES() != null)
                           return(false);
          } else if (!this.NOMBRES.equals(valueObject.getNOMBRES())) {
                    return(false);
          }
          if (this.APELLIDOS == null) {
                    if (valueObject.getAPELLIDOS() != null)
                           return(false);
          } else if (!this.APELLIDOS.equals(valueObject.getAPELLIDOS())) {
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

          return true;
    }



    /**
     * toString will return String object representing the state of this 
     * valueObject. This is useful during application development, and 
     * possibly when application is writing object states in textlog.
     */
    public String toString() {
        StringBuffer out = new StringBuffer(this.getDaogenVersion());
        out.append("\nclass ViewResolucionesInfractorComp, mapping to table VIEW_RESOLUCIONESINFRACTOR\n");
        out.append("Persistent attributes: \n"); 
        out.append("ID_RESOLUCION = " + this.ID_RESOLUCION + "\n"); 
        out.append("NUMERO = " + this.NUMERO + "\n"); 
        out.append("FECHA = " + this.FECHA + "\n"); 
        out.append("CONTENIDO = " + this.CONTENIDO + "\n"); 
        out.append("NOMBRE = " + this.NOMBRE + "\n"); 
        out.append("NROIDENTIFICACION = " + this.NROIDENTIFICACION + "\n"); 
        out.append("ID_DOCTO = " + this.ID_DOCTO + "\n"); 
        out.append("NOMBRES = " + this.NOMBRES + "\n"); 
        out.append("APELLIDOS = " + this.APELLIDOS + "\n"); 
        out.append("DIRECCION = " + this.DIRECCION + "\n"); 
        out.append("TELEFONO = " + this.TELEFONO + "\n"); 
        return out.toString();
    }


    /**
     * Clone will return identical deep copy of this valueObject.
     * Note, that this method is different than the clone() which
     * is defined in java.lang.Object. Here, the retuned cloned object
     * will also have all its attributes cloned.
     */
    public Object clone() {
        ViewResolucionesInfractorComp cloned = new ViewResolucionesInfractorComp();

        cloned.setID_RESOLUCION(this.ID_RESOLUCION); 
        if (this.NUMERO != null)
             cloned.setNUMERO(new String(this.NUMERO)); 
        if (this.FECHA != null)
             cloned.setFECHA(new String(this.FECHA)); 
        if (this.CONTENIDO != null)
             cloned.setCONTENIDO(new String(this.CONTENIDO)); 
        if (this.NOMBRE != null)
             cloned.setNOMBRE(new String(this.NOMBRE)); 
        if (this.NROIDENTIFICACION != null)
             cloned.setNROIDENTIFICACION(new String(this.NROIDENTIFICACION)); 
        cloned.setID_DOCTO(this.ID_DOCTO); 
        if (this.NOMBRES != null)
             cloned.setNOMBRES(new String(this.NOMBRES)); 
        if (this.APELLIDOS != null)
             cloned.setAPELLIDOS(new String(this.APELLIDOS)); 
        if (this.DIRECCION != null)
             cloned.setDIRECCION(new String(this.DIRECCION)); 
        if (this.TELEFONO != null)
             cloned.setTELEFONO(new String(this.TELEFONO)); 
        return cloned;
    }



    /** 
     * getDaogenVersion will return information about
     * generator which created these sources.
     */
    public String getDaogenVersion() {
        return "DaoGen version 2.4.1";
    }

    public int getID_TIPORESOLUCION() {
        return ID_TIPORESOLUCION;
    }

    public void setID_TIPORESOLUCION(int ID_TIPORESOLUCION) {
        this.ID_TIPORESOLUCION = ID_TIPORESOLUCION;
    }
}
