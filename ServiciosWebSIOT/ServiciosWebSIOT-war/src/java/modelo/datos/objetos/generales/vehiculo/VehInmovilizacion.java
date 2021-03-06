package modelo.datos.objetos.generales.vehiculo;

import java.io.Serializable;

/**
  * VehInmovilizacion Value Object.
  * This class is value object representing database table VEHINMOVILIZACION
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



public class VehInmovilizacion implements Cloneable, Serializable {

    /** 
     * Persistent Instance variables. This data is directly 
     * mapped to the columns of database table.
     */
    private int ID_VEHINMOVILIZA;
    private int ID_VEHICULO;
    private String FECHAINIINMOVILIZA;
    private String FECHAFININMOVILIZA;
    private String PLACA;
    private String ACTIVA;
    private String HORAINIINMOVILIZA;
    private String HORAFININMOVILIZA;



    /** 
     * Constructors. DaoGen generates two constructors by default.
     * The first one takes no arguments and provides the most simple
     * way to create object instance. The another one takes one
     * argument, which is the primary key of the corresponding table.
     */

    public VehInmovilizacion () {

    }

    public VehInmovilizacion (int ID_VEHINMOVILIZAIn) {

          this.ID_VEHINMOVILIZA = ID_VEHINMOVILIZAIn;

    }


    /** 
     * Get- and Set-methods for persistent variables. The default
     * behaviour does not make any checks against malformed data,
     * so these might require some manual additions.
     */

    public int getID_VEHINMOVILIZA() {
          return this.ID_VEHINMOVILIZA;
    }
    public void setID_VEHINMOVILIZA(int ID_VEHINMOVILIZAIn) {
          this.ID_VEHINMOVILIZA = ID_VEHINMOVILIZAIn;
    }

    public int getID_VEHICULO() {
          return this.ID_VEHICULO;
    }
    public void setID_VEHICULO(int ID_VEHICULOIn) {
          this.ID_VEHICULO = ID_VEHICULOIn;
    }

    public String getFECHAINIINMOVILIZA() {
          return this.FECHAINIINMOVILIZA;
    }
    public void setFECHAINIINMOVILIZA(String FECHAINIINMOVILIZAIn) {
          this.FECHAINIINMOVILIZA = FECHAINIINMOVILIZAIn;
    }

    public String getFECHAFININMOVILIZA() {
          return this.FECHAFININMOVILIZA;
    }
    public void setFECHAFININMOVILIZA(String FECHAFININMOVILIZAIn) {
          this.FECHAFININMOVILIZA = FECHAFININMOVILIZAIn;
    }

    public String getPLACA() {
          return this.PLACA;
    }
    public void setPLACA(String PLACAIn) {
          this.PLACA = PLACAIn;
    }

    public String getACTIVA() {
          return this.ACTIVA;
    }
    public void setACTIVA(String ACTIVAIn) {
          this.ACTIVA = ACTIVAIn;
    }

    public String getHORAINIINMOVILIZA() {
          return this.HORAINIINMOVILIZA;
    }
    public void setHORAINIINMOVILIZA(String HORAINIINMOVILIZAIn) {
          this.HORAINIINMOVILIZA = HORAINIINMOVILIZAIn;
    }

    public String getHORAFININMOVILIZA() {
          return this.HORAFININMOVILIZA;
    }
    public void setHORAFININMOVILIZA(String HORAFININMOVILIZAIn) {
          this.HORAFININMOVILIZA = HORAFININMOVILIZAIn;
    }



    /** 
     * setAll allows to set all persistent variables in one method call.
     * This is useful, when all data is available and it is needed to 
     * set the initial state of this object. Note that this method will
     * directly modify instance variales, without going trough the 
     * individual set-methods.
     */

    public void setAll(int ID_VEHINMOVILIZAIn,
          Integer ID_VEHICULOIn,
          String FECHAINIINMOVILIZAIn,
          String FECHAFININMOVILIZAIn,
          String PLACAIn,
          String ACTIVAIn,
          String HORAINIINMOVILIZAIn,
          String HORAFININMOVILIZAIn) {
          this.ID_VEHINMOVILIZA = ID_VEHINMOVILIZAIn;
          this.ID_VEHICULO = ID_VEHICULOIn;
          this.FECHAINIINMOVILIZA = FECHAINIINMOVILIZAIn;
          this.FECHAFININMOVILIZA = FECHAFININMOVILIZAIn;
          this.PLACA = PLACAIn;
          this.ACTIVA = ACTIVAIn;
          this.HORAINIINMOVILIZA = HORAINIINMOVILIZAIn;
          this.HORAFININMOVILIZA = HORAFININMOVILIZAIn;
    }


    /** 
     * hasEqualMapping-method will compare two VehInmovilizacion instances
     * and return true if they contain same values in all persistent instance 
     * variables. If hasEqualMapping returns true, it does not mean the objects
     * are the same instance. However it does mean that in that moment, they 
     * are mapped to the same row in database.
     */
    public boolean hasEqualMapping(VehInmovilizacion valueObject) {

          if (valueObject.getID_VEHINMOVILIZA() != this.ID_VEHINMOVILIZA) {
                    return(false);
          }
          
          if (this.FECHAINIINMOVILIZA == null) {
                    if (valueObject.getFECHAINIINMOVILIZA() != null)
                           return(false);
          } else if (!this.FECHAINIINMOVILIZA.equals(valueObject.getFECHAINIINMOVILIZA())) {
                    return(false);
          }
          if (this.FECHAFININMOVILIZA == null) {
                    if (valueObject.getFECHAFININMOVILIZA() != null)
                           return(false);
          } else if (!this.FECHAFININMOVILIZA.equals(valueObject.getFECHAFININMOVILIZA())) {
                    return(false);
          }
          if (this.PLACA == null) {
                    if (valueObject.getPLACA() != null)
                           return(false);
          } else if (!this.PLACA.equals(valueObject.getPLACA())) {
                    return(false);
          }
          if (this.ACTIVA == null) {
                    if (valueObject.getACTIVA() != null)
                           return(false);
          } else if (!this.ACTIVA.equals(valueObject.getACTIVA())) {
                    return(false);
          }
          if (this.HORAINIINMOVILIZA == null) {
                    if (valueObject.getHORAINIINMOVILIZA() != null)
                           return(false);
          } else if (!this.HORAINIINMOVILIZA.equals(valueObject.getHORAINIINMOVILIZA())) {
                    return(false);
          }
          if (this.HORAFININMOVILIZA == null) {
                    if (valueObject.getHORAFININMOVILIZA() != null)
                           return(false);
          } else if (!this.HORAFININMOVILIZA.equals(valueObject.getHORAFININMOVILIZA())) {
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
        out.append("\nclass VehInmovilizacion, mapping to table VEHINMOVILIZACION\n");
        out.append("Persistent attributes: \n"); 
        out.append("ID_VEHINMOVILIZA = " + this.ID_VEHINMOVILIZA + "\n"); 
        out.append("ID_VEHICULO = " + this.ID_VEHICULO + "\n"); 
        out.append("FECHAINIINMOVILIZA = " + this.FECHAINIINMOVILIZA + "\n"); 
        out.append("FECHAFININMOVILIZA = " + this.FECHAFININMOVILIZA + "\n"); 
        out.append("PLACA = " + this.PLACA + "\n"); 
        out.append("ACTIVA = " + this.ACTIVA + "\n"); 
        out.append("HORAINIINMOVILIZA = " + this.HORAINIINMOVILIZA + "\n"); 
        out.append("HORAFININMOVILIZA = " + this.HORAFININMOVILIZA + "\n"); 
        return out.toString();
    }


    /**
     * Clone will return identical deep copy of this valueObject.
     * Note, that this method is different than the clone() which
     * is defined in java.lang.Object. Here, the retuned cloned object
     * will also have all its attributes cloned.
     */
    public Object clone() {
        VehInmovilizacion cloned = new VehInmovilizacion();

        cloned.setID_VEHINMOVILIZA(this.ID_VEHINMOVILIZA); 
        if (this.FECHAINIINMOVILIZA != null)
             cloned.setFECHAINIINMOVILIZA(new String(this.FECHAINIINMOVILIZA)); 
        if (this.FECHAFININMOVILIZA != null)
             cloned.setFECHAFININMOVILIZA(new String(this.FECHAFININMOVILIZA)); 
        if (this.PLACA != null)
             cloned.setPLACA(new String(this.PLACA)); 
        if (this.ACTIVA != null)
             cloned.setACTIVA(new String(this.ACTIVA)); 
        if (this.HORAINIINMOVILIZA != null)
             cloned.setHORAINIINMOVILIZA(new String(this.HORAINIINMOVILIZA)); 
        if (this.HORAFININMOVILIZA != null)
             cloned.setHORAFININMOVILIZA(new String(this.HORAFININMOVILIZA)); 
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
