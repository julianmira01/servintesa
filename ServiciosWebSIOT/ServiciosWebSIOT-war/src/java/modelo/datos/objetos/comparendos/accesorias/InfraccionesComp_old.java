package modelo.datos.objetos.comparendos.accesorias;



import java.io.*;
import java.sql.*;
import java.util.*;
import java.math.*;

 /**
  * InfraccionesComp Value Object.
  * This class is value object representing database table INFRACCIONES
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



public class InfraccionesComp_old implements Cloneable, Serializable {

    /** 
     * Persistent Instance variables. This data is directly 
     * mapped to the columns of database table.
     */
    private int ID_INFRACCION;
    private String COD_INFRACCION;
    private double NUMEROSALARIO;
    private String DESCRIPCION;
    private String ESTADO;
    private String NUEVO_CODIGO;
    private String FECHADESDE;
    private String FECHAHASTA;
    private String REPORTARSIMIT;
    private String NUEVO_CODIGOCORREGIDO;
    private Integer PORCENTAJE_MOROSIDAD;



    /** 
     * Constructors. DaoGen generates two constructors by default.
     * The first one takes no arguments and provides the most simple
     * way to create object instance. The another one takes one
     * argument, which is the primary key of the corresponding table.
     */

    public InfraccionesComp_old () {

    }

    public InfraccionesComp_old (int ID_INFRACCIONIn) {

          this.ID_INFRACCION = ID_INFRACCIONIn;

    }


    /** 
     * Get- and Set-methods for persistent variables. The default
     * behaviour does not make any checks against malformed data,
     * so these might require some manual additions.
     */

    public int getID_INFRACCION() {
          return this.ID_INFRACCION;
    }
    public void setID_INFRACCION(int ID_INFRACCIONIn) {
          this.ID_INFRACCION = ID_INFRACCIONIn;
    }

    public int getPORCENTAJE_MOROSIDAD() {
          return this.PORCENTAJE_MOROSIDAD;
    }
    public void setPORCENTAJE_MOROSIDAD(int PORCENTAJE_MOROSIDADIn) {
          this.PORCENTAJE_MOROSIDAD = PORCENTAJE_MOROSIDADIn;
    }

    public String getCOD_INFRACCION() {
          return this.COD_INFRACCION;
    }
    public void setCOD_INFRACCION(String COD_INFRACCIONIn) {
          this.COD_INFRACCION = COD_INFRACCIONIn;
    }

    public double getNUMEROSALARIO() {
          return this.NUMEROSALARIO;
    }
    public void setNUMEROSALARIO(double NUMEROSALARIOIn) {
          this.NUMEROSALARIO = NUMEROSALARIOIn;
    }

    public String getDESCRIPCION() {
          return this.DESCRIPCION;
    }
    public void setDESCRIPCION(String DESCRIPCIONIn) {
          this.DESCRIPCION = DESCRIPCIONIn;
    }

    public String getESTADO() {
          return this.ESTADO;
    }
    public void setESTADO(String ESTADOIn) {
          this.ESTADO = ESTADOIn;
    }

    public String getNUEVO_CODIGO() {
          return this.NUEVO_CODIGO;
    }
    public void setNUEVO_CODIGO(String NUEVO_CODIGOIn) {
          this.NUEVO_CODIGO = NUEVO_CODIGOIn;
    }

    public String getFECHADESDE() {
          return this.FECHADESDE;
    }
    public void setFECHADESDE(String FECHADESDEIn) {
          this.FECHADESDE = FECHADESDEIn;
    }

    public String getFECHAHASTA() {
          return this.FECHAHASTA;
    }
    public void setFECHAHASTA(String FECHAHASTAIn) {
          this.FECHAHASTA = FECHAHASTAIn;
    }

    public String getREPORTARSIMIT() {
          return this.REPORTARSIMIT;
    }
    public void setREPORTARSIMIT(String REPORTARSIMITIn) {
          this.REPORTARSIMIT = REPORTARSIMITIn;
    }

    public String getNUEVO_CODIGOCORREGIDO() {
          return this.NUEVO_CODIGOCORREGIDO;
    }
    public void setNUEVO_CODIGOCORREGIDO(String NUEVO_CODIGOCORREGIDOIn) {
          this.NUEVO_CODIGOCORREGIDO = NUEVO_CODIGOCORREGIDOIn;
    }



    /** 
     * setAll allows to set all persistent variables in one method call.
     * This is useful, when all data is available and it is needed to 
     * set the initial state of this object. Note that this method will
     * directly modify instance variales, without going trough the 
     * individual set-methods.
     */

    public void setAll(int ID_INFRACCIONIn,
          String COD_INFRACCIONIn,
          double NUMEROSALARIOIn,
          String DESCRIPCIONIn,
          String ESTADOIn,
          String NUEVO_CODIGOIn,
          String FECHADESDEIn,
          String FECHAHASTAIn,
          String REPORTARSIMITIn,
          String NUEVO_CODIGOCORREGIDOIn, Integer PORCENTAJE_MOROSIDADIn ) {
          this.ID_INFRACCION = ID_INFRACCIONIn;
          this.COD_INFRACCION = COD_INFRACCIONIn;
          this.NUMEROSALARIO = NUMEROSALARIOIn;
          this.DESCRIPCION = DESCRIPCIONIn;
          this.ESTADO = ESTADOIn;
          this.NUEVO_CODIGO = NUEVO_CODIGOIn;
          this.FECHADESDE = FECHADESDEIn;
          this.FECHAHASTA = FECHAHASTAIn;
          this.REPORTARSIMIT = REPORTARSIMITIn;
          this.NUEVO_CODIGOCORREGIDO = NUEVO_CODIGOCORREGIDOIn;
          this.PORCENTAJE_MOROSIDAD = PORCENTAJE_MOROSIDADIn;
    }


    /** 
     * hasEqualMapping-method will compare two InfraccionesComp instances
     * and return true if they contain same values in all persistent instance 
     * variables. If hasEqualMapping returns true, it does not mean the objects
     * are the same instance. However it does mean that in that moment, they 
     * are mapped to the same row in database.
     */
    public boolean hasEqualMapping(InfraccionesComp_old valueObject) {

          if (valueObject.getID_INFRACCION() != this.ID_INFRACCION) {
                    return(false);
          }
          if (this.COD_INFRACCION == null) {
                    if (valueObject.getCOD_INFRACCION() != null)
                           return(false);
          } else if (!this.COD_INFRACCION.equals(valueObject.getCOD_INFRACCION())) {
                    return(false);
          }
          if (valueObject.getNUMEROSALARIO() != this.NUMEROSALARIO) {
                    return(false);
          }
          if (this.DESCRIPCION == null) {
                    if (valueObject.getDESCRIPCION() != null)
                           return(false);
          } else if (!this.DESCRIPCION.equals(valueObject.getDESCRIPCION())) {
                    return(false);
          }
          if (this.ESTADO == null) {
                    if (valueObject.getESTADO() != null)
                           return(false);
          } else if (!this.ESTADO.equals(valueObject.getESTADO())) {
                    return(false);
          }
          if (this.NUEVO_CODIGO == null) {
                    if (valueObject.getNUEVO_CODIGO() != null)
                           return(false);
          } else if (!this.NUEVO_CODIGO.equals(valueObject.getNUEVO_CODIGO())) {
                    return(false);
          }
          if (this.FECHADESDE == null) {
                    if (valueObject.getFECHADESDE() != null)
                           return(false);
          } else if (!this.FECHADESDE.equals(valueObject.getFECHADESDE())) {
                    return(false);
          }
          if (this.FECHAHASTA == null) {
                    if (valueObject.getFECHAHASTA() != null)
                           return(false);
          } else if (!this.FECHAHASTA.equals(valueObject.getFECHAHASTA())) {
                    return(false);
          }
          if (this.REPORTARSIMIT == null) {
                    if (valueObject.getREPORTARSIMIT() != null)
                           return(false);
          } else if (!this.REPORTARSIMIT.equals(valueObject.getREPORTARSIMIT())) {
                    return(false);
          }
          if (this.NUEVO_CODIGOCORREGIDO == null) {
                    if (valueObject.getNUEVO_CODIGOCORREGIDO() != null)
                           return(false);
          } else if (!this.NUEVO_CODIGOCORREGIDO.equals(valueObject.getNUEVO_CODIGOCORREGIDO())) {
                    return(false);
          }
            if (valueObject.getPORCENTAJE_MOROSIDAD() != this.PORCENTAJE_MOROSIDAD) {
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
        out.append("\nclass InfraccionesComp, mapping to table INFRACCIONES\n");
        out.append("Persistent attributes: \n"); 
        out.append("ID_INFRACCION = " + this.ID_INFRACCION + "\n"); 
        out.append("COD_INFRACCION = " + this.COD_INFRACCION + "\n"); 
        out.append("NUMEROSALARIO = " + this.NUMEROSALARIO + "\n"); 
        out.append("DESCRIPCION = " + this.DESCRIPCION + "\n"); 
        out.append("ESTADO = " + this.ESTADO + "\n"); 
        out.append("NUEVO_CODIGO = " + this.NUEVO_CODIGO + "\n"); 
        out.append("FECHADESDE = " + this.FECHADESDE + "\n"); 
        out.append("FECHAHASTA = " + this.FECHAHASTA + "\n"); 
        out.append("REPORTARSIMIT = " + this.REPORTARSIMIT + "\n"); 
        out.append("NUEVO_CODIGOCORREGIDO = " + this.NUEVO_CODIGOCORREGIDO + "\n");
        out.append("PORCENTAJE_MOROSIDAD= " + this. PORCENTAJE_MOROSIDAD + "\n"); 
        return out.toString();
    }


    /**
     * Clone will return identical deep copy of this valueObject.
     * Note, that this method is different than the clone() which
     * is defined in java.lang.Object. Here, the retuned cloned object
     * will also have all its attributes cloned.
     */
    public Object clone() {
        InfraccionesComp_old cloned = new InfraccionesComp_old();

        cloned.setID_INFRACCION(this.ID_INFRACCION); 
        if (this.COD_INFRACCION != null)
             cloned.setCOD_INFRACCION(new String(this.COD_INFRACCION)); 
        cloned.setNUMEROSALARIO(this.NUMEROSALARIO); 
        if (this.DESCRIPCION != null)
             cloned.setDESCRIPCION(new String(this.DESCRIPCION)); 
        if (this.ESTADO != null)
             cloned.setESTADO(new String(this.ESTADO)); 
        if (this.NUEVO_CODIGO != null)
             cloned.setNUEVO_CODIGO(new String(this.NUEVO_CODIGO)); 
        if (this.FECHADESDE != null)
             cloned.setFECHADESDE(new String(this.FECHADESDE)); 
        if (this.FECHAHASTA != null)
             cloned.setFECHAHASTA(new String(this.FECHAHASTA)); 
        if (this.REPORTARSIMIT != null)
             cloned.setREPORTARSIMIT(new String(this.REPORTARSIMIT)); 
        if (this.NUEVO_CODIGOCORREGIDO != null)
             cloned.setNUEVO_CODIGOCORREGIDO(new String(this.NUEVO_CODIGOCORREGIDO)); 
        if (this.PORCENTAJE_MOROSIDAD!= null)
             cloned.setPORCENTAJE_MOROSIDAD(new Integer(this.PORCENTAJE_MOROSIDAD)); 
        
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
