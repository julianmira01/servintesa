package modelo.datos.objetos.liquidador;

import java.io.Serializable;

import java.util.List;


/**
  * Tarifa Value Object.
  * This class is value object representing database table VISTA_TARIFAS
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



public class Tarifa implements Cloneable, Serializable {

    /** 
     * Persistent Instance variables. This data is directly 
     * mapped to the columns of database table.
     */
    private int LT_ID;
    private String LT_NOMBRE;
    private String LT_VIGENCIA;
    private String TIPOIT;
    private String ID_COD_RUNT;
    private String ID_TARAPLICADA_C;
    private String ID_TARAPLICADA_M;
    private String TIPO;
    private String LT_APLICAWEB;
    private String LT_LCV_ID;
    private String ID_TRAMITEINTERNO;
    private List conceptos;



    /** 
     * Constructors. DaoGen generates two constructors by default.
     * The first one takes no arguments and provides the most simple
     * way to create object instance. The another one takes one
     * argument, which is the primary key of the corresponding table.
     */

    public Tarifa () {

    }

    public Tarifa (int LT_IDIn) {

          this.LT_ID = LT_IDIn;

    }


    /** 
     * Get- and Set-methods for persistent variables. The default
     * behaviour does not make any checks against malformed data,
     * so these might require some manual additions.
     */

    public int getLT_ID() {
          return this.LT_ID;
    }
    public void setLT_ID(int LT_IDIn) {
          this.LT_ID = LT_IDIn;
    }

    public String getLT_NOMBRE() {
          return this.LT_NOMBRE;
    }
    public void setLT_NOMBRE(String LT_NOMBREIn) {
          this.LT_NOMBRE = LT_NOMBREIn;
    }

    public String getLT_VIGENCIA() {
          return this.LT_VIGENCIA;
    }
    public void setLT_VIGENCIA(String LT_VIGENCIAIn) {
          this.LT_VIGENCIA = LT_VIGENCIAIn;
    }

    public String getTIPOIT() {
          return this.TIPOIT;
    }
    public void setTIPOIT(String TIPOITIn) {
          this.TIPOIT = TIPOITIn;
    }

    public String getID_COD_RUNT() {
          return this.ID_COD_RUNT;
    }
    public void setID_COD_RUNT(String ID_COD_RUNTIn) {
          this.ID_COD_RUNT = ID_COD_RUNTIn;
    }

    public String getID_TARAPLICADA_C() {
          return this.ID_TARAPLICADA_C;
    }
    public void setID_TARAPLICADA_C(String ID_TARAPLICADA_CIn) {
          this.ID_TARAPLICADA_C = ID_TARAPLICADA_CIn;
    }

    public String getID_TARAPLICADA_M() {
          return this.ID_TARAPLICADA_M;
    }
    public void setID_TARAPLICADA_M(String ID_TARAPLICADA_MIn) {
          this.ID_TARAPLICADA_M = ID_TARAPLICADA_MIn;
    }

    public String getTIPO() {
          return this.TIPO;
    }
    public void setTIPO(String TIPOIn) {
          this.TIPO = TIPOIn;
    }

    public String getLT_APLICAWEB() {
          return this.LT_APLICAWEB;
    }
    public void setLT_APLICAWEB(String LT_APLICAWEBIn) {
          this.LT_APLICAWEB = LT_APLICAWEBIn;
    }

    public String getLT_LCV_ID() {
          return this.LT_LCV_ID;
    }
    public void setLT_LCV_ID(String LT_LCV_IDIn) {
          this.LT_LCV_ID = LT_LCV_IDIn;
    }

    public String getID_TRAMITEINTERNO() {
          return this.ID_TRAMITEINTERNO;
    }
    public void setID_TRAMITEINTERNO(String ID_TRAMITEINTERNOIn) {
          this.ID_TRAMITEINTERNO = ID_TRAMITEINTERNOIn;
    }



    /** 
     * setAll allows to set all persistent variables in one method call.
     * This is useful, when all data is available and it is needed to 
     * set the initial state of this object. Note that this method will
     * directly modify instance variales, without going trough the 
     * individual set-methods.
     */

    public void setAll(int LT_IDIn,
          String LT_NOMBREIn,
          String LT_VIGENCIAIn,
          String TIPOITIn,
          String ID_COD_RUNTIn,
          String ID_TARAPLICADA_CIn,
          String ID_TARAPLICADA_MIn,
          String TIPOIn,
          String LT_APLICAWEBIn,
          String LT_LCV_IDIn,
          String ID_TRAMITEINTERNOIn) {
          this.LT_ID = LT_IDIn;
          this.LT_NOMBRE = LT_NOMBREIn;
          this.LT_VIGENCIA = LT_VIGENCIAIn;
          this.TIPOIT = TIPOITIn;
          this.ID_COD_RUNT = ID_COD_RUNTIn;
          this.ID_TARAPLICADA_C = ID_TARAPLICADA_CIn;
          this.ID_TARAPLICADA_M = ID_TARAPLICADA_MIn;
          this.TIPO = TIPOIn;
          this.LT_APLICAWEB = LT_APLICAWEBIn;
          this.LT_LCV_ID = LT_LCV_IDIn;
          this.ID_TRAMITEINTERNO = ID_TRAMITEINTERNOIn;
    }


    /** 
     * hasEqualMapping-method will compare two Tarifa instances
     * and return true if they contain same values in all persistent instance 
     * variables. If hasEqualMapping returns true, it does not mean the objects
     * are the same instance. However it does mean that in that moment, they 
     * are mapped to the same row in database.
     */
    public boolean hasEqualMapping(Tarifa valueObject) {

          if (valueObject.getLT_ID() != this.LT_ID) {
                    return(false);
          }
          if (this.LT_NOMBRE == null) {
                    if (valueObject.getLT_NOMBRE() != null)
                           return(false);
          } else if (!this.LT_NOMBRE.equals(valueObject.getLT_NOMBRE())) {
                    return(false);
          }
          if (this.LT_VIGENCIA == null) {
                    if (valueObject.getLT_VIGENCIA() != null)
                           return(false);
          } else if (!this.LT_VIGENCIA.equals(valueObject.getLT_VIGENCIA())) {
                    return(false);
          }
          if (this.TIPOIT == null) {
                    if (valueObject.getTIPOIT() != null)
                           return(false);
          } else if (!this.TIPOIT.equals(valueObject.getTIPOIT())) {
                    return(false);
          }
          if (this.ID_COD_RUNT == null) {
                    if (valueObject.getID_COD_RUNT() != null)
                           return(false);
          } else if (!this.ID_COD_RUNT.equals(valueObject.getID_COD_RUNT())) {
                    return(false);
          }
          if (this.ID_TARAPLICADA_C == null) {
                    if (valueObject.getID_TARAPLICADA_C() != null)
                           return(false);
          } else if (!this.ID_TARAPLICADA_C.equals(valueObject.getID_TARAPLICADA_C())) {
                    return(false);
          }
          if (this.ID_TARAPLICADA_M == null) {
                    if (valueObject.getID_TARAPLICADA_M() != null)
                           return(false);
          } else if (!this.ID_TARAPLICADA_M.equals(valueObject.getID_TARAPLICADA_M())) {
                    return(false);
          }
          if (this.TIPO == null) {
                    if (valueObject.getTIPO() != null)
                           return(false);
          } else if (!this.TIPO.equals(valueObject.getTIPO())) {
                    return(false);
          }
          if (this.LT_APLICAWEB == null) {
                    if (valueObject.getLT_APLICAWEB() != null)
                           return(false);
          } else if (!this.LT_APLICAWEB.equals(valueObject.getLT_APLICAWEB())) {
                    return(false);
          }
          if (this.LT_LCV_ID == null) {
                    if (valueObject.getLT_LCV_ID() != null)
                           return(false);
          } else if (!this.LT_LCV_ID.equals(valueObject.getLT_LCV_ID())) {
                    return(false);
          }
          if (this.ID_TRAMITEINTERNO == null) {
                    if (valueObject.getID_TRAMITEINTERNO() != null)
                           return(false);
          } else if (!this.ID_TRAMITEINTERNO.equals(valueObject.getID_TRAMITEINTERNO())) {
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
        out.append("\nclass Tarifa, mapping to table VISTA_TARIFAS\n");
        out.append("Persistent attributes: \n"); 
        out.append("LT_ID = " + this.LT_ID + "\n"); 
        out.append("LT_NOMBRE = " + this.LT_NOMBRE + "\n"); 
        out.append("LT_VIGENCIA = " + this.LT_VIGENCIA + "\n"); 
        out.append("TIPOIT = " + this.TIPOIT + "\n"); 
        out.append("ID_COD_RUNT = " + this.ID_COD_RUNT + "\n"); 
        out.append("ID_TARAPLICADA_C = " + this.ID_TARAPLICADA_C + "\n"); 
        out.append("ID_TARAPLICADA_M = " + this.ID_TARAPLICADA_M + "\n"); 
        out.append("TIPO = " + this.TIPO + "\n"); 
        out.append("LT_APLICAWEB = " + this.LT_APLICAWEB + "\n"); 
        out.append("LT_LCV_ID = " + this.LT_LCV_ID + "\n"); 
        out.append("ID_TRAMITEINTERNO = " + this.ID_TRAMITEINTERNO + "\n"); 
        return out.toString();
    }


    /**
     * Clone will return identical deep copy of this valueObject.
     * Note, that this method is different than the clone() which
     * is defined in java.lang.Object. Here, the retuned cloned object
     * will also have all its attributes cloned.
     */
    public Object clone() {
        Tarifa cloned = new Tarifa();

        cloned.setLT_ID(this.LT_ID); 
        if (this.LT_NOMBRE != null)
             cloned.setLT_NOMBRE(new String(this.LT_NOMBRE)); 
        if (this.LT_VIGENCIA != null)
             cloned.setLT_VIGENCIA(new String(this.LT_VIGENCIA)); 
        if (this.TIPOIT != null)
             cloned.setTIPOIT(new String(this.TIPOIT)); 
        if (this.ID_COD_RUNT != null)
             cloned.setID_COD_RUNT(new String(this.ID_COD_RUNT)); 
        if (this.ID_TARAPLICADA_C != null)
             cloned.setID_TARAPLICADA_C(new String(this.ID_TARAPLICADA_C)); 
        if (this.ID_TARAPLICADA_M != null)
             cloned.setID_TARAPLICADA_M(new String(this.ID_TARAPLICADA_M)); 
        if (this.TIPO != null)
             cloned.setTIPO(new String(this.TIPO)); 
        if (this.LT_APLICAWEB != null)
             cloned.setLT_APLICAWEB(new String(this.LT_APLICAWEB)); 
        if (this.LT_LCV_ID != null)
             cloned.setLT_LCV_ID(new String(this.LT_LCV_ID)); 
        if (this.ID_TRAMITEINTERNO != null)
             cloned.setID_TRAMITEINTERNO(new String(this.ID_TRAMITEINTERNO)); 
        return cloned;
    }



    /** 
     * getDaogenVersion will return information about
     * generator which created these sources.
     */
    public String getDaogenVersion() {
        return "DaoGen version 2.4.1";
    }

    public void setConceptos(List conceptos) {
        this.conceptos = conceptos;
    }

    public List getConceptos() {
        return conceptos;
    }

}


