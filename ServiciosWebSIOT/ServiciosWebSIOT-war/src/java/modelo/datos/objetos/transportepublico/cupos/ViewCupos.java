package modelo.datos.objetos.transportepublico.cupos;


import java.io.Serializable;

/**
  * ViewCupos Value Object.
  * This class is value object representing database table VIEW_CUPOS
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



public class ViewCupos implements Cloneable, Serializable {

    /** 
     * Persistent Instance variables. This data is directly 
     * mapped to the columns of database table.
     */
    private int ID;
    private int NUMERO;
    private String PLACA;
    private String EMPRESAS;
    private String NIT;
    private String RAZONSOCIAL;
    private String NOMBRE;
    private String APELLIDO1;
    private String APELLIDO2;
    private String TIPOVEHI;
    private int MODELO;
    private String MARCAN;
    private String TARJETAOPERACION;
    private String FECHAVENCIMIENTO;



    /** 
     * Constructors. DaoGen generates two constructors by default.
     * The first one takes no arguments and provides the most simple
     * way to create object instance. The another one takes one
     * argument, which is the primary key of the corresponding table.
     */

    public ViewCupos () {

    }

    public ViewCupos (int IDIn) {

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

    public int getNUMERO() {
          return this.NUMERO;
    }
    public void setNUMERO(int NUMEROIn) {
          this.NUMERO = NUMEROIn;
    }

    public String getPLACA() {
          return this.PLACA;
    }
    public void setPLACA(String PLACAIn) {
          this.PLACA = PLACAIn;
    }

    public String getEMPRESAS() {
          return this.EMPRESAS;
    }
    public void setEMPRESAS(String EMPRESASIn) {
          this.EMPRESAS = EMPRESASIn;
    }

    public String getNIT() {
          return this.NIT;
    }
    public void setNIT(String NITIn) {
          this.NIT = NITIn;
    }

    public String getRAZONSOCIAL() {
          return this.RAZONSOCIAL;
    }
    public void setRAZONSOCIAL(String RAZONSOCIALIn) {
          this.RAZONSOCIAL = RAZONSOCIALIn;
    }

    public String getNOMBRE() {
          return this.NOMBRE;
    }
    public void setNOMBRE(String NOMBREIn) {
          this.NOMBRE = NOMBREIn;
    }

    public String getAPELLIDO1() {
          return this.APELLIDO1;
    }
    public void setAPELLIDO1(String APELLIDO1In) {
          this.APELLIDO1 = APELLIDO1In;
    }

    public String getAPELLIDO2() {
          return this.APELLIDO2;
    }
    public void setAPELLIDO2(String APELLIDO2In) {
          this.APELLIDO2 = APELLIDO2In;
    }

    public String getTIPOVEHI() {
          return this.TIPOVEHI;
    }
    public void setTIPOVEHI(String TIPOVEHIIn) {
          this.TIPOVEHI = TIPOVEHIIn;
    }

    public int getMODELO() {
          return this.MODELO;
    }
    public void setMODELO(int MODELOIn) {
          this.MODELO = MODELOIn;
    }

    public String getMARCAN() {
          return this.MARCAN;
    }
    public void setMARCAN(String MARCANIn) {
          this.MARCAN = MARCANIn;
    }

    public String getTARJETAOPERACION() {
          return this.TARJETAOPERACION;
    }
    public void setTARJETAOPERACION(String TARJETAOPERACIONIn) {
          this.TARJETAOPERACION = TARJETAOPERACIONIn;
    }

    public String getFECHAVENCIMIENTO() {
          return this.FECHAVENCIMIENTO;
    }
    public void setFECHAVENCIMIENTO(String FECHAVENCIMIENTOIn) {
          this.FECHAVENCIMIENTO = FECHAVENCIMIENTOIn;
    }



    /** 
     * setAll allows to set all persistent variables in one method call.
     * This is useful, when all data is available and it is needed to 
     * set the initial state of this object. Note that this method will
     * directly modify instance variales, without going trough the 
     * individual set-methods.
     */

    public void setAll(int IDIn,
          int NUMEROIn,
          String PLACAIn,
          String EMPRESASIn,
          String NITIn,
          String RAZONSOCIALIn,
          String NOMBREIn,
          String APELLIDO1In,
          String APELLIDO2In,
          String TIPOVEHIIn,
          int MODELOIn,
          String MARCANIn,
          String TARJETAOPERACIONIn,
          String FECHAVENCIMIENTOIn) {
          this.ID = IDIn;
          this.NUMERO = NUMEROIn;
          this.PLACA = PLACAIn;
          this.EMPRESAS = EMPRESASIn;
          this.NIT = NITIn;
          this.RAZONSOCIAL = RAZONSOCIALIn;
          this.NOMBRE = NOMBREIn;
          this.APELLIDO1 = APELLIDO1In;
          this.APELLIDO2 = APELLIDO2In;
          this.TIPOVEHI = TIPOVEHIIn;
          this.MODELO = MODELOIn;
          this.MARCAN = MARCANIn;
          this.TARJETAOPERACION = TARJETAOPERACIONIn;
          this.FECHAVENCIMIENTO = FECHAVENCIMIENTOIn;
    }


    /** 
     * hasEqualMapping-method will compare two ViewCupos instances
     * and return true if they contain same values in all persistent instance 
     * variables. If hasEqualMapping returns true, it does not mean the objects
     * are the same instance. However it does mean that in that moment, they 
     * are mapped to the same row in database.
     */
    public boolean hasEqualMapping(ViewCupos valueObject) {

          if (valueObject.getID() != this.ID) {
                    return(false);
          }
          if (valueObject.getNUMERO() != this.NUMERO) {
                    return(false);
          }
          if (this.PLACA == null) {
                    if (valueObject.getPLACA() != null)
                           return(false);
          } else if (!this.PLACA.equals(valueObject.getPLACA())) {
                    return(false);
          }
          if (this.EMPRESAS == null) {
                    if (valueObject.getEMPRESAS() != null)
                           return(false);
          } else if (!this.EMPRESAS.equals(valueObject.getEMPRESAS())) {
                    return(false);
          }
          if (this.NIT == null) {
                    if (valueObject.getNIT() != null)
                           return(false);
          } else if (!this.NIT.equals(valueObject.getNIT())) {
                    return(false);
          }
          if (this.RAZONSOCIAL == null) {
                    if (valueObject.getRAZONSOCIAL() != null)
                           return(false);
          } else if (!this.RAZONSOCIAL.equals(valueObject.getRAZONSOCIAL())) {
                    return(false);
          }
          if (this.NOMBRE == null) {
                    if (valueObject.getNOMBRE() != null)
                           return(false);
          } else if (!this.NOMBRE.equals(valueObject.getNOMBRE())) {
                    return(false);
          }
          if (this.APELLIDO1 == null) {
                    if (valueObject.getAPELLIDO1() != null)
                           return(false);
          } else if (!this.APELLIDO1.equals(valueObject.getAPELLIDO1())) {
                    return(false);
          }
          if (this.APELLIDO2 == null) {
                    if (valueObject.getAPELLIDO2() != null)
                           return(false);
          } else if (!this.APELLIDO2.equals(valueObject.getAPELLIDO2())) {
                    return(false);
          }
          if (this.TIPOVEHI == null) {
                    if (valueObject.getTIPOVEHI() != null)
                           return(false);
          } else if (!this.TIPOVEHI.equals(valueObject.getTIPOVEHI())) {
                    return(false);
          }
          if (valueObject.getMODELO() != this.MODELO) {
                    return(false);
          }
          if (this.MARCAN == null) {
                    if (valueObject.getMARCAN() != null)
                           return(false);
          } else if (!this.MARCAN.equals(valueObject.getMARCAN())) {
                    return(false);
          }
          if (this.TARJETAOPERACION == null) {
                    if (valueObject.getTARJETAOPERACION() != null)
                           return(false);
          } else if (!this.TARJETAOPERACION.equals(valueObject.getTARJETAOPERACION())) {
                    return(false);
          }
          if (this.FECHAVENCIMIENTO == null) {
                    if (valueObject.getFECHAVENCIMIENTO() != null)
                           return(false);
          } else if (!this.FECHAVENCIMIENTO.equals(valueObject.getFECHAVENCIMIENTO())) {
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
        out.append("\nclass ViewCupos, mapping to table VIEW_CUPOS\n");
        out.append("Persistent attributes: \n"); 
        out.append("ID = " + this.ID + "\n"); 
        out.append("NUMERO = " + this.NUMERO + "\n"); 
        out.append("PLACA = " + this.PLACA + "\n"); 
        out.append("EMPRESAS = " + this.EMPRESAS + "\n"); 
        out.append("NIT = " + this.NIT + "\n"); 
        out.append("RAZONSOCIAL = " + this.RAZONSOCIAL + "\n"); 
        out.append("NOMBRE = " + this.NOMBRE + "\n"); 
        out.append("APELLIDO1 = " + this.APELLIDO1 + "\n"); 
        out.append("APELLIDO2 = " + this.APELLIDO2 + "\n"); 
        out.append("TIPOVEHI = " + this.TIPOVEHI + "\n"); 
        out.append("MODELO = " + this.MODELO + "\n"); 
        out.append("MARCAN = " + this.MARCAN + "\n"); 
        out.append("TARJETAOPERACION = " + this.TARJETAOPERACION + "\n"); 
        out.append("FECHAVENCIMIENTO = " + this.FECHAVENCIMIENTO + "\n"); 
        return out.toString();
    }


    /**
     * Clone will return identical deep copy of this valueObject.
     * Note, that this method is different than the clone() which
     * is defined in java.lang.Object. Here, the retuned cloned object
     * will also have all its attributes cloned.
     */
    public Object clone() {
        ViewCupos cloned = new ViewCupos();

        cloned.setID(this.ID); 
        cloned.setNUMERO(this.NUMERO); 
        if (this.PLACA != null)
             cloned.setPLACA(new String(this.PLACA)); 
        if (this.EMPRESAS != null)
             cloned.setEMPRESAS(new String(this.EMPRESAS)); 
        if (this.NIT != null)
             cloned.setNIT(new String(this.NIT)); 
        if (this.RAZONSOCIAL != null)
             cloned.setRAZONSOCIAL(new String(this.RAZONSOCIAL)); 
        if (this.NOMBRE != null)
             cloned.setNOMBRE(new String(this.NOMBRE)); 
        if (this.APELLIDO1 != null)
             cloned.setAPELLIDO1(new String(this.APELLIDO1)); 
        if (this.APELLIDO2 != null)
             cloned.setAPELLIDO2(new String(this.APELLIDO2)); 
        if (this.TIPOVEHI != null)
             cloned.setTIPOVEHI(new String(this.TIPOVEHI)); 
        cloned.setMODELO(this.MODELO); 
        if (this.MARCAN != null)
             cloned.setMARCAN(new String(this.MARCAN)); 
        if (this.TARJETAOPERACION != null)
             cloned.setTARJETAOPERACION(new String(this.TARJETAOPERACION)); 
        if (this.FECHAVENCIMIENTO != null)
             cloned.setFECHAVENCIMIENTO(new String(this.FECHAVENCIMIENTO)); 
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
