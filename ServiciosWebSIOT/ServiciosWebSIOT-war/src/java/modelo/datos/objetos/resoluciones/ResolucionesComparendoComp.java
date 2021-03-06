package modelo.datos.objetos.resoluciones;


import java.io.*;
import java.sql.*;
import java.util.*;
import java.math.*;

 /**
  * ResolucionesComparendoComp Value Object.
  * This class is value object representing database table RESOLUCIONESCOMPARENDO
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



public class ResolucionesComparendoComp implements Cloneable, Serializable {

    /** 
     * Persistent Instance variables. This data is directly 
     * mapped to the columns of database table.
     */
    private int ID;
    private String FECHA;
    private String NUMERO;
    private int ID_TIPORESOLUCION;
    private String CONTENIDO;
    private String FECHAREGISTRO;
    private String FECHAAUDIENCIA;
    private String MOTIVO;
    private String NOMBRE;
    private int IDUSUARIO;
    private String CONSIDERACIONJURIDICA;
    private int TIEMPOSUSPENSIONLIC;
    private int ACCION_ALCOHOLEMIA;
    
    //Nuevos para resoluciones revocatoria
    private String MOTIVORESOLUCION;
    private String HECHOS;
    private String SOLICITUDRESOLUCION;
    
    //NUEVOS PARA PLANOS RUNT
    private String HORAS_COMUNITARIAS;
    private Float GRADO_ALCOHOLEMIA;
    private Double VALOR_PAGAR;
    private Double VALOR_INFRACCION;
    private String CODIGO_INFRACCION;
    private String POLCA;
    private String FOTOMULTA;
    private Double VALORES_ADICIONALES;
    private Double VALOR_TOTAL;
    private String RESOLUCION_ANTERIOR;
    



    /** 
     * Constructors. DaoGen generates two constructors by default.
     * The first one takes no arguments and provides the most simple
     * way to create object instance. The another one takes one
     * argument, which is the primary key of the corresponding table.
     */

    public ResolucionesComparendoComp () {

    }

    public ResolucionesComparendoComp (int IDIn) {

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

    public String getFECHA() {
          return this.FECHA;
    }
    public void setFECHA(String FECHAIn) {
          this.FECHA = FECHAIn;
    }

    public String getNUMERO() {
          return this.NUMERO;
    }
    public void setNUMERO(String NUMEROIn) {
          this.NUMERO = NUMEROIn;
    }

    public int getID_TIPORESOLUCION() {
          return this.ID_TIPORESOLUCION;
    }
    public void setID_TIPORESOLUCION(int ID_TIPORESOLUCIONIn) {
          this.ID_TIPORESOLUCION = ID_TIPORESOLUCIONIn;
    }

    public String getCONTENIDO() {
          return this.CONTENIDO;
    }
    public void setCONTENIDO(String CONTENIDOIn) {
          this.CONTENIDO = CONTENIDOIn;
    }

    public String getFECHAREGISTRO() {
          return this.FECHAREGISTRO;
    }
    public void setFECHAREGISTRO(String FECHAREGISTROIn) {
          this.FECHAREGISTRO = FECHAREGISTROIn;
    }

    public String getFECHAAUDIENCIA() {
          return this.FECHAAUDIENCIA;
    }
    public void setFECHAAUDIENCIA(String FECHAAUDIENCIAIn) {
          this.FECHAAUDIENCIA = FECHAAUDIENCIAIn;
    }

    public String getMOTIVO() {
          return this.MOTIVO;
    }
    public void setMOTIVO(String MOTIVOIn) {
          this.MOTIVO = MOTIVOIn;
    }

    public String getNOMBRE() {
          return this.NOMBRE;
    }
    public void setNOMBRE(String NOMBREIn) {
          this.NOMBRE = NOMBREIn;
    }

    public int getIDUSUARIO() {
          return this.IDUSUARIO;
    }
    public void setIDUSUARIO(int IDUSUARIOIn) {
          this.IDUSUARIO = IDUSUARIOIn;
    }

    public String getCONSIDERACIONJURIDICA() {
          return this.CONSIDERACIONJURIDICA;
    }
    public void setCONSIDERACIONJURIDICA(String CONSIDERACIONJURIDICAIn) {
          this.CONSIDERACIONJURIDICA = CONSIDERACIONJURIDICAIn;
    }

    public int getTIEMPOSUSPENSIONLIC() {
      return this.TIEMPOSUSPENSIONLIC;
    }

    public void  setTIEMPOSUSPENSIONLIC(int TIEMPOSUSPENSIONLICIn) {
      this.TIEMPOSUSPENSIONLIC = TIEMPOSUSPENSIONLICIn;
    }

    public int getACCION_ALCOHOLEMIA() {
      return this.ACCION_ALCOHOLEMIA;
    }

    public void  setACCION_ALCOHOLEMIA(int ACCION_ALCOHOLEMIAIn) {
      this.ACCION_ALCOHOLEMIA = ACCION_ALCOHOLEMIAIn;
    }

    public String getMOTIVORESOLUCION() {
          return this.MOTIVORESOLUCION;
    }
    public void setMOTIVORESOLUCION(String MOTIVORESOLUCIONIn) {
          this.MOTIVORESOLUCION = MOTIVORESOLUCIONIn;
    }
    
    public String getHECHOS() {
          return this.HECHOS;
    }
    public void setHECHOS(String HECHOSIn) {
          this.HECHOS = HECHOSIn;
    }
    
    public String getSOLICITUDRESOLUCION() {
          return this.getMOTIVORESOLUCION();
    }
    public void setSOLICITUDRESOLUCION(String SOLICITUDRESOLUCIONIn) {
          this.SOLICITUDRESOLUCION = SOLICITUDRESOLUCIONIn;
    }

    /** 
     * setAll allows to set all persistent variables in one method call.
     * This is useful, when all data is available and it is needed to 
     * set the initial state of this object. Note that this method will
     * directly modify instance variales, without going trough the 
     * individual set-methods.
     */

    public void setAll(int IDIn,
          String FECHAIn,
          String NUMEROIn,
          int ID_TIPORESOLUCIONIn,
          String CONTENIDOIn,
          String FECHAREGISTROIn,
          String FECHAAUDIENCIAIn,
          String MOTIVOIn,
          String NOMBREIn,
          int IDUSUARIOIn,
          String CONSIDERACIONJURIDICAIn,
          int TIEMPOSUSPENSIONLICIn,
          int ACCION_ALCOHOLEMIAIn,
          String MOTIVORESOLUCIONIn,
          String HECHOSIn,
          String SOLICITUDRESOLUCIONIn) {
        this.setID(IDIn);
        this.setFECHA(FECHAIn);
        this.setNUMERO(NUMEROIn);
        this.setID_TIPORESOLUCION(ID_TIPORESOLUCIONIn);
        this.setCONTENIDO(CONTENIDOIn);
        this.setFECHAREGISTRO(FECHAREGISTROIn);
        this.setFECHAAUDIENCIA(FECHAAUDIENCIAIn);
        this.setMOTIVO(MOTIVOIn);
        this.setNOMBRE(NOMBREIn);
        this.setIDUSUARIO(IDUSUARIOIn);
        this.setCONSIDERACIONJURIDICA(CONSIDERACIONJURIDICAIn);
        this.setACCION_ALCOHOLEMIA(ACCION_ALCOHOLEMIAIn);
        this.setTIEMPOSUSPENSIONLIC(TIEMPOSUSPENSIONLICIn);
        this.setMOTIVORESOLUCION(MOTIVORESOLUCIONIn);
          this.setHECHOS(HECHOSIn);
          this.setSOLICITUDRESOLUCION(SOLICITUDRESOLUCIONIn);
    }


    /** 
     * hasEqualMapping-method will compare two ResolucionesComparendoComp instances
     * and return true if they contain same values in all persistent instance 
     * variables. If hasEqualMapping returns true, it does not mean the objects
     * are the same instance. However it does mean that in that moment, they 
     * are mapped to the same row in database.
     */
    public boolean hasEqualMapping(ResolucionesComparendoComp valueObject) {

          if (valueObject.getID() != this.getID()) {
                    return(false);
          }
          if (this.getFECHA() == null) {
                    if (valueObject.getFECHA() != null)
                           return(false);
          } else if (!this.FECHA.equals(valueObject.getFECHA())) {
                    return(false);
          }
          if (this.getNUMERO() == null) {
                    if (valueObject.getNUMERO() != null)
                           return(false);
          } else if (!this.NUMERO.equals(valueObject.getNUMERO())) {
                    return(false);
          }
          if (valueObject.getID_TIPORESOLUCION() != this.getID_TIPORESOLUCION()) {
                    return(false);
          }
          if (this.getCONTENIDO() == null) {
                    if (valueObject.getCONTENIDO() != null)
                           return(false);
          } else if (!this.CONTENIDO.equals(valueObject.getCONTENIDO())) {
                    return(false);
          }
          if (this.getFECHAREGISTRO() == null) {
                    if (valueObject.getFECHAREGISTRO() != null)
                           return(false);
          } else if (!this.FECHAREGISTRO.equals(valueObject.getFECHAREGISTRO())) {
                    return(false);
          }
          if (this.getFECHAAUDIENCIA() == null) {
                    if (valueObject.getFECHAAUDIENCIA() != null)
                           return(false);
          } else if (!this.FECHAAUDIENCIA.equals(valueObject.getFECHAAUDIENCIA())) {
                    return(false);
          }
          if (this.getMOTIVO() == null) {
                    if (valueObject.getMOTIVO() != null)
                           return(false);
          } else if (!this.MOTIVO.equals(valueObject.getMOTIVO())) {
                    return(false);
          }
          if (this.getNOMBRE() == null) {
                    if (valueObject.getNOMBRE() != null)
                           return(false);
          } else if (!this.NOMBRE.equals(valueObject.getNOMBRE())) {
                    return(false);
          }
          if (valueObject.getIDUSUARIO() != this.getIDUSUARIO()) {
                    return(false);
          }
          if (this.getCONSIDERACIONJURIDICA() == null) {
                    if (valueObject.getCONSIDERACIONJURIDICA() != null)
                           return(false);
          } else if (!this.CONSIDERACIONJURIDICA.equals(valueObject.getCONSIDERACIONJURIDICA())) {
                    return(false);
          }
          if (this.getMOTIVORESOLUCION() == null) {
                    if (valueObject.getMOTIVORESOLUCION() != null)
                         return(false);
          } else if (!this.MOTIVORESOLUCION.equals(valueObject.getMOTIVORESOLUCION())) {
                    return(false);
          }
          if (this.getHECHOS() == null) {
                  if (valueObject.getHECHOS() != null)
                       return(false);
          } else if (!this.HECHOS.equals(valueObject.getHECHOS())) {
                  return(false);
          }
          if (this.getSOLICITUDRESOLUCION() == null) {
                  if (valueObject.getSOLICITUDRESOLUCION() != null)
                       return(false);
          } else if (!this.SOLICITUDRESOLUCION.equals(valueObject.getSOLICITUDRESOLUCION())) {
                  return(false);
          }
          
          if (valueObject.getTIEMPOSUSPENSIONLIC() != this.getTIEMPOSUSPENSIONLIC()) {
                    return(false);
          }
          if (valueObject.getACCION_ALCOHOLEMIA() != this.getACCION_ALCOHOLEMIA()) {
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
        out.append("\nclass ResolucionesComparendoComp, mapping to table RESOLUCIONESCOMPARENDO\n");
        out.append("Persistent attributes: \n"); 
        out.append("ID = " + this.getID() + "\n"); 
        out.append("FECHA = " + this.getFECHA() + "\n"); 
        out.append("NUMERO = " + this.getNUMERO() + "\n"); 
        out.append("ID_TIPORESOLUCION = " + this.getID_TIPORESOLUCION() + "\n"); 
        out.append("CONTENIDO = " + this.getCONTENIDO() + "\n"); 
        out.append("FECHAREGISTRO = " + this.getFECHAREGISTRO() + "\n"); 
        out.append("FECHAAUDIENCIA = " + this.getFECHAAUDIENCIA() + "\n"); 
        out.append("MOTIVO = " + this.getMOTIVO() + "\n"); 
        out.append("NOMBRE = " + this.getNOMBRE() + "\n"); 
        out.append("IDUSUARIO = " + this.getIDUSUARIO() + "\n"); 
        out.append("CONSIDERACIONJURIDICA = " + this.getCONSIDERACIONJURIDICA() + "\n"); 
        out.append("TIEMPOSUSPENSIONLIC: "+this.getTIEMPOSUSPENSIONLIC());
        out.append("ACCION_ALCOHOLEMIA: "+this.getACCION_ALCOHOLEMIA());
        out.append("MOTIVORESOLUCION = " + this.getMOTIVORESOLUCION() + "\n"); 
        out.append("HECHOS = " + this.getHECHOS() + "\n"); 
        out.append("SOLICITUDRESOLUCION = " + this.getSOLICITUDRESOLUCION() + "\n"); 
        return out.toString();
    }


    /**
     * Clone will return identical deep copy of this valueObject.
     * Note, that this method is different than the clone() which
     * is defined in java.lang.Object. Here, the retuned cloned object
     * will also have all its attributes cloned.
     */
    public Object clone() {
        ResolucionesComparendoComp cloned = new ResolucionesComparendoComp();

        cloned.setID(this.getID()); 
        if (this.getFECHA() != null)
             cloned.setFECHA(new String(this.getFECHA())); 
        if (this.getNUMERO() != null)
             cloned.setNUMERO(new String(this.getNUMERO())); 
        cloned.setID_TIPORESOLUCION(this.getID_TIPORESOLUCION()); 
        if (this.getCONTENIDO() != null)
             cloned.setCONTENIDO(new String(this.getCONTENIDO())); 
        if (this.getFECHAREGISTRO() != null)
             cloned.setFECHAREGISTRO(new String(this.getFECHAREGISTRO())); 
        if (this.getFECHAAUDIENCIA() != null)
             cloned.setFECHAAUDIENCIA(new String(this.getFECHAAUDIENCIA())); 
        if (this.getMOTIVO() != null)
             cloned.setMOTIVO(new String(this.getMOTIVO())); 
        if (this.getNOMBRE() != null)
             cloned.setNOMBRE(new String(this.getNOMBRE())); 
        cloned.setIDUSUARIO(this.getIDUSUARIO()); 
        if (this.getCONSIDERACIONJURIDICA() != null)
             cloned.setCONSIDERACIONJURIDICA(new String(this.getCONSIDERACIONJURIDICA()));
        if (this.getMOTIVORESOLUCION() != null)
             cloned.setMOTIVO(new String(this.getMOTIVORESOLUCION()));
        if (this.getHECHOS() != null)
             cloned.setMOTIVO(new String(this.getHECHOS()));
        if (this.getSOLICITUDRESOLUCION() != null)
             cloned.setMOTIVO(new String(this.getSOLICITUDRESOLUCION()));
        cloned.setTIEMPOSUSPENSIONLIC(this.getTIEMPOSUSPENSIONLIC()); 
        cloned.setACCION_ALCOHOLEMIA(this.getACCION_ALCOHOLEMIA()); 
        return cloned;
    }



    /** 
     * getDaogenVersion will return information about
     * generator which created these sources.
     */
    public String getDaogenVersion() {
        return "DaoGen version 2.4.1";
    }

    /**
     * @return the HORAS_COMUNITARIAS
     */
    public String getHORAS_COMUNITARIAS() {
        return HORAS_COMUNITARIAS;
    }

    /**
     * @param HORAS_COMUNITARIAS the HORAS_COMUNITARIAS to set
     */
    public void setHORAS_COMUNITARIAS(String HORAS_COMUNITARIAS) {
        this.HORAS_COMUNITARIAS = HORAS_COMUNITARIAS;
    }

    /**
     * @return the VALOR_PAGAR
     */
    public Double getVALOR_PAGAR() {
        return VALOR_PAGAR;
    }

    /**
     * @return the VALOR_INFRACCION
     */
    public Double getVALOR_INFRACCION() {
        return VALOR_INFRACCION;
    }

    /**
     * @return the CODIGO_INFRACCION
     */
    public String getCODIGO_INFRACCION() {
        return CODIGO_INFRACCION;
    }

    /**
     * @return the POLCA
     */
    public String getPOLCA() {
        return POLCA;
    }

    /**
     * @return the FOTOMULTA
     */
    public String getFOTOMULTA() {
        return FOTOMULTA;
    }

    /**
     * @return the VALORES_ADICIONALES
     */
    public Double getVALORES_ADICIONALES() {
        return VALORES_ADICIONALES;
    }

    /**
     * @return the VALOR_TOTAL
     */
    public Double getVALOR_TOTAL() {
        return VALOR_TOTAL;
    }

    /**
     * @return the RESOLUCION_ANTERIOR
     */
    public String getRESOLUCION_ANTERIOR() {
        return RESOLUCION_ANTERIOR;
    }

    /**
     * @return the GRADO_ALCOHOLEMIA
     */
    public Float getGRADO_ALCOHOLEMIA() {
        return GRADO_ALCOHOLEMIA;
    }

    /**
     * @param GRADO_ALCOHOLEMIA the GRADO_ALCOHOLEMIA to set
     */
    public void setGRADO_ALCOHOLEMIA(Float GRADO_ALCOHOLEMIA) {
        this.GRADO_ALCOHOLEMIA = GRADO_ALCOHOLEMIA;
    }

    /**
     * @param VALOR_PAGAR the VALOR_PAGAR to set
     */
    public void setVALOR_PAGAR(Double VALOR_PAGAR) {
        this.VALOR_PAGAR = VALOR_PAGAR;
    }

    /**
     * @param VALOR_INFRACCION the VALOR_INFRACCION to set
     */
    public void setVALOR_INFRACCION(Double VALOR_INFRACCION) {
        this.VALOR_INFRACCION = VALOR_INFRACCION;
    }

    /**
     * @param CODIGO_INFRACCION the CODIGO_INFRACCION to set
     */
    public void setCODIGO_INFRACCION(String CODIGO_INFRACCION) {
        this.CODIGO_INFRACCION = CODIGO_INFRACCION;
    }

    /**
     * @param POLCA the POLCA to set
     */
    public void setPOLCA(String POLCA) {
        this.POLCA = POLCA;
    }

    /**
     * @param FOTOMULTA the FOTOMULTA to set
     */
    public void setFOTOMULTA(String FOTOMULTA) {
        this.FOTOMULTA = FOTOMULTA;
    }

    /**
     * @param VALORES_ADICIONALES the VALORES_ADICIONALES to set
     */
    public void setVALORES_ADICIONALES(Double VALORES_ADICIONALES) {
        this.VALORES_ADICIONALES = VALORES_ADICIONALES;
    }

    /**
     * @param VALOR_TOTAL the VALOR_TOTAL to set
     */
    public void setVALOR_TOTAL(Double VALOR_TOTAL) {
        this.VALOR_TOTAL = VALOR_TOTAL;
    }

    /**
     * @param RESOLUCION_ANTERIOR the RESOLUCION_ANTERIOR to set
     */
    public void setRESOLUCION_ANTERIOR(String RESOLUCION_ANTERIOR) {
        this.RESOLUCION_ANTERIOR = RESOLUCION_ANTERIOR;
    }

}
