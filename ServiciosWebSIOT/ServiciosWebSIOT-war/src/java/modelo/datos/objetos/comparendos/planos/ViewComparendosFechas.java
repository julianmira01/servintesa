package modelo.datos.objetos.comparendos.planos;


import java.io.*;
import java.sql.*;
import java.util.*;
import java.math.*;

 /**
  * ViewComparendosFechas Value Object.
  * This class is value object representing database table VIEW_COMPARENDOS_FECHAS
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



public class ViewComparendosFechas implements Cloneable, Serializable {

    /** 
     * Persistent Instance variables. This data is directly 
     * mapped to the columns of database table.
     */
    private String PLACA;
    private int ID_INFRACTOR;
    private int ID_COMPARENDO;
    private String NUMEROCOMPARENDO;
    private String FECHACOMPARENDO;
    private String FECHAREGISTRO;
    private String HORACOMPARENDO;
    private String DIRECCIONINFRACCION;
    private String OBSERVACION;
    private String REPORTAFUGA;
    private String REPORTAACCIDENTE;
    private String REPORTAINMOVILIZACION;
    private String POLCA;
    private String LOCALIDAD_COMUNADIRECCION;
    private String ID_DEPTO;
    private String CODCIUDAD;
    private String CONSECUTIVOINMOVILIZACION;
    private String PLACAGRUA;
    private String NUMEROGRUA;
    private String DIRECCIONPATIO_INMOVILIZA;
    private String DESCRIPCIONPATIO;
    private String VALORINFRACCION;
    private String NUEVO_CODIGO;
    private String NUEVO_CODIGOCORREGIDO;
    private String PLACAAGENTE;
    private String COD_ESTADO;
    private String CODTIPOINFRACTOR;
    private int IDREPORTECOMPARENDO;
    private String NROIDENTIFICACION;
    private String IDESTADO;



    /** 
     * Constructors. DaoGen generates two constructors by default.
     * The first one takes no arguments and provides the most simple
     * way to create object instance. The another one takes one
     * argument, which is the primary key of the corresponding table.
     */

    public ViewComparendosFechas () {

    }

    public ViewComparendosFechas (String PLACAIn) {

          this.PLACA = PLACAIn;

    }


    /** 
     * Get- and Set-methods for persistent variables. The default
     * behaviour does not make any checks against malformed data,
     * so these might require some manual additions.
     */

    public String getPLACA() {
          return this.PLACA;
    }
    public void setPLACA(String PLACAIn) {
          this.PLACA = PLACAIn;
    }

    public int getID_INFRACTOR() {
          return this.ID_INFRACTOR;
    }
    public void setID_INFRACTOR(int ID_INFRACTORIn) {
          this.ID_INFRACTOR = ID_INFRACTORIn;
    }

    public int getID_COMPARENDO() {
          return this.ID_COMPARENDO;
    }
    public void setID_COMPARENDO(int ID_COMPARENDOIn) {
          this.ID_COMPARENDO = ID_COMPARENDOIn;
    }

    public String getNUMEROCOMPARENDO() {
          return this.NUMEROCOMPARENDO;
    }
    public void setNUMEROCOMPARENDO(String NUMEROCOMPARENDOIn) {
          this.NUMEROCOMPARENDO = NUMEROCOMPARENDOIn;
    }

    public String getFECHACOMPARENDO() {
          return this.FECHACOMPARENDO;
    }
    public void setFECHACOMPARENDO(String FECHACOMPARENDOIn) {
          this.FECHACOMPARENDO = FECHACOMPARENDOIn;
    }

    public String getHORACOMPARENDO() {
          return this.HORACOMPARENDO;
    }
    public void setHORACOMPARENDO(String HORACOMPARENDOIn) {
          this.HORACOMPARENDO = HORACOMPARENDOIn;
    }

    public String getDIRECCIONINFRACCION() {
          return this.DIRECCIONINFRACCION;
    }
    public void setDIRECCIONINFRACCION(String DIRECCIONINFRACCIONIn) {
          this.DIRECCIONINFRACCION = DIRECCIONINFRACCIONIn;
    }

    public String getOBSERVACION() {
          return this.OBSERVACION;
    }
    public void setOBSERVACION(String OBSERVACIONIn) {
          this.OBSERVACION = OBSERVACIONIn;
    }

    public String getREPORTAFUGA() {
          return this.REPORTAFUGA;
    }
    public void setREPORTAFUGA(String REPORTAFUGAIn) {
          this.REPORTAFUGA = REPORTAFUGAIn;
    }

    public String getREPORTAACCIDENTE() {
          return this.REPORTAACCIDENTE;
    }
    public void setREPORTAACCIDENTE(String REPORTAACCIDENTEIn) {
          this.REPORTAACCIDENTE = REPORTAACCIDENTEIn;
    }

    public String getREPORTAINMOVILIZACION() {
          return this.REPORTAINMOVILIZACION;
    }
    public void setREPORTAINMOVILIZACION(String REPORTAINMOVILIZACIONIn) {
          this.REPORTAINMOVILIZACION = REPORTAINMOVILIZACIONIn;
    }

    public String getPOLCA() {
          return this.POLCA;
    }
    public void setPOLCA(String POLCAIn) {
          this.POLCA = POLCAIn;
    }

    public String getLOCALIDAD_COMUNADIRECCION() {
          return this.LOCALIDAD_COMUNADIRECCION;
    }
    public void setLOCALIDAD_COMUNADIRECCION(String LOCALIDAD_COMUNADIRECCIONIn) {
          this.LOCALIDAD_COMUNADIRECCION = LOCALIDAD_COMUNADIRECCIONIn;
    }

    public String getID_DEPTO() {
          return this.ID_DEPTO;
    }
    public void setID_DEPTO(String ID_DEPTOIn) {
          this.ID_DEPTO = ID_DEPTOIn;
    }

    public String getCODCIUDAD() {
          return this.CODCIUDAD;
    }
    public void setCODCIUDAD(String CODCIUDADIn) {
          this.CODCIUDAD = CODCIUDADIn;
    }

    public String getCONSECUTIVOINMOVILIZACION() {
          return this.CONSECUTIVOINMOVILIZACION;
    }
    public void setCONSECUTIVOINMOVILIZACION(String CONSECUTIVOINMOVILIZACIONIn) {
          this.CONSECUTIVOINMOVILIZACION = CONSECUTIVOINMOVILIZACIONIn;
    }

    public String getPLACAGRUA() {
          return this.PLACAGRUA;
    }
    public void setPLACAGRUA(String PLACAGRUAIn) {
          this.PLACAGRUA = PLACAGRUAIn;
    }

    public String getNUMEROGRUA() {
          return this.NUMEROGRUA;
    }
    public void setNUMEROGRUA(String NUMEROGRUAIn) {
          this.NUMEROGRUA = NUMEROGRUAIn;
    }

    public String getDIRECCIONPATIO_INMOVILIZA() {
          return this.DIRECCIONPATIO_INMOVILIZA;
    }
    public void setDIRECCIONPATIO_INMOVILIZA(String DIRECCIONPATIO_INMOVILIZAIn) {
          this.DIRECCIONPATIO_INMOVILIZA = DIRECCIONPATIO_INMOVILIZAIn;
    }

    public String getDESCRIPCIONPATIO() {
          return this.DESCRIPCIONPATIO;
    }
    public void setDESCRIPCIONPATIO(String DESCRIPCIONPATIOIn) {
          this.DESCRIPCIONPATIO = DESCRIPCIONPATIOIn;
    }

    public String getVALORINFRACCION() {
          return this.VALORINFRACCION;
    }
    public void setVALORINFRACCION(String VALORINFRACCIONIn) {
          this.VALORINFRACCION = VALORINFRACCIONIn;
    }

    public String getNUEVO_CODIGO() {
          return this.NUEVO_CODIGO;
    }
    public void setNUEVO_CODIGO(String NUEVO_CODIGOIn) {
          this.NUEVO_CODIGO = NUEVO_CODIGOIn;
    }

    public String getNUEVO_CODIGOCORREGIDO() {
          return this.NUEVO_CODIGOCORREGIDO;
    }
    public void setNUEVO_CODIGOCORREGIDO(String NUEVO_CODIGOCORREGIDOIn) {
          this.NUEVO_CODIGOCORREGIDO = NUEVO_CODIGOCORREGIDOIn;
    }

    public String getPLACAAGENTE() {
          return this.PLACAAGENTE;
    }
    public void setPLACAAGENTE(String PLACAAGENTEIn) {
          this.PLACAAGENTE = PLACAAGENTEIn;
    }

    public String getCOD_ESTADO() {
          return this.COD_ESTADO;
    }
    public void setCOD_ESTADO(String COD_ESTADOIn) {
          this.COD_ESTADO = COD_ESTADOIn;
    }

    public String getCODTIPOINFRACTOR() {
          return this.CODTIPOINFRACTOR;
    }
    public void setCODTIPOINFRACTOR(String CODTIPOINFRACTORIn) {
          this.CODTIPOINFRACTOR = CODTIPOINFRACTORIn;
    }

    public int getIDREPORTECOMPARENDO() {
          return this.IDREPORTECOMPARENDO;
    }
    public void setIDREPORTECOMPARENDO(int IDREPORTECOMPARENDOIn) {
          this.IDREPORTECOMPARENDO = IDREPORTECOMPARENDOIn;
    }

    public String getNROIDENTIFICACION() {
          return this.NROIDENTIFICACION;
    }
    public void setNROIDENTIFICACION(String NROIDENTIFICACIONIn) {
          this.NROIDENTIFICACION = NROIDENTIFICACIONIn;
    }

    public String getIDESTADO() {
          return this.IDESTADO;
    }
    public void setIDESTADO(String IDESTADOIn) {
          this.IDESTADO = IDESTADOIn;
    }



    /** 
     * setAll allows to set all persistent variables in one method call.
     * This is useful, when all data is available and it is needed to 
     * set the initial state of this object. Note that this method will
     * directly modify instance variales, without going trough the 
     * individual set-methods.
     */

    public void setAll(String PLACAIn,
          int ID_INFRACTORIn,
          int ID_COMPARENDOIn,
          String NUMEROCOMPARENDOIn,
          String FECHACOMPARENDOIn,
          String FECHAREGISTROIn,
          String HORACOMPARENDOIn,
          String DIRECCIONINFRACCIONIn,
          String OBSERVACIONIn,
          String REPORTAFUGAIn,
          String REPORTAACCIDENTEIn,
          String REPORTAINMOVILIZACIONIn,
          String POLCAIn,
          String LOCALIDAD_COMUNADIRECCIONIn,
          String ID_DEPTOIn,
          String CODCIUDADIn,
          String CONSECUTIVOINMOVILIZACIONIn,
          String PLACAGRUAIn,
          String NUMEROGRUAIn,
          String DIRECCIONPATIO_INMOVILIZAIn,
          String DESCRIPCIONPATIOIn,
          String VALORINFRACCIONIn,
          String NUEVO_CODIGOIn,
          String NUEVO_CODIGOCORREGIDOIn,
          String PLACAAGENTEIn,
          String COD_ESTADOIn,
          String CODTIPOINFRACTORIn,
          int IDREPORTECOMPARENDOIn,
          String NROIDENTIFICACIONIn,
          String IDESTADOIn) {
          this.PLACA = PLACAIn;
          this.ID_INFRACTOR = ID_INFRACTORIn;
          this.ID_COMPARENDO = ID_COMPARENDOIn;
          this.NUMEROCOMPARENDO = NUMEROCOMPARENDOIn;
          this.FECHACOMPARENDO = FECHACOMPARENDOIn;
          this.FECHAREGISTRO = FECHAREGISTROIn;
          this.HORACOMPARENDO = HORACOMPARENDOIn;
          this.DIRECCIONINFRACCION = DIRECCIONINFRACCIONIn;
          this.OBSERVACION = OBSERVACIONIn;
          this.REPORTAFUGA = REPORTAFUGAIn;
          this.REPORTAACCIDENTE = REPORTAACCIDENTEIn;
          this.REPORTAINMOVILIZACION = REPORTAINMOVILIZACIONIn;
          this.POLCA = POLCAIn;
          this.LOCALIDAD_COMUNADIRECCION = LOCALIDAD_COMUNADIRECCIONIn;
          this.ID_DEPTO = ID_DEPTOIn;
          this.CODCIUDAD = CODCIUDADIn;
          this.CONSECUTIVOINMOVILIZACION = CONSECUTIVOINMOVILIZACIONIn;
          this.PLACAGRUA = PLACAGRUAIn;
          this.NUMEROGRUA = NUMEROGRUAIn;
          this.DIRECCIONPATIO_INMOVILIZA = DIRECCIONPATIO_INMOVILIZAIn;
          this.DESCRIPCIONPATIO = DESCRIPCIONPATIOIn;
          this.VALORINFRACCION = VALORINFRACCIONIn;
          this.NUEVO_CODIGO = NUEVO_CODIGOIn;
          this.NUEVO_CODIGOCORREGIDO = NUEVO_CODIGOCORREGIDOIn;
          this.PLACAAGENTE = PLACAAGENTEIn;
          this.COD_ESTADO = COD_ESTADOIn;
          this.CODTIPOINFRACTOR = CODTIPOINFRACTORIn;
          this.IDREPORTECOMPARENDO = IDREPORTECOMPARENDOIn;
          this.NROIDENTIFICACION = NROIDENTIFICACIONIn;
          this.IDESTADO = IDESTADOIn;
    }


    /** 
     * hasEqualMapping-method will compare two ViewComparendosFechas instances
     * and return true if they contain same values in all persistent instance 
     * variables. If hasEqualMapping returns true, it does not mean the objects
     * are the same instance. However it does mean that in that moment, they 
     * are mapped to the same row in database.
     */
    public boolean hasEqualMapping(ViewComparendosFechas valueObject) {

          if (this.PLACA == null) {
                    if (valueObject.getPLACA() != null)
                           return(false);
          } else if (!this.PLACA.equals(valueObject.getPLACA())) {
                    return(false);
          }
          if (valueObject.getID_INFRACTOR() != this.ID_INFRACTOR) {
                    return(false);
          }
          if (valueObject.getID_COMPARENDO() != this.ID_COMPARENDO) {
                    return(false);
          }
          if (this.NUMEROCOMPARENDO == null) {
                    if (valueObject.getNUMEROCOMPARENDO() != null)
                           return(false);
          } else if (!this.NUMEROCOMPARENDO.equals(valueObject.getNUMEROCOMPARENDO())) {
                    return(false);
          }
          if (this.FECHACOMPARENDO == null) {
                    if (valueObject.getFECHACOMPARENDO() != null)
                           return(false);
          } else if (!this.FECHACOMPARENDO.equals(valueObject.getFECHACOMPARENDO())) {
                    return(false);
          }
        if (this.FECHAREGISTRO == null) {
                  if (valueObject.getFECHAREGISTRO() != null)
                         return(false);
        } else if (!this.FECHAREGISTRO.equals(valueObject.getFECHAREGISTRO())) {
                  return(false);
        }
          if (this.HORACOMPARENDO == null) {
                    if (valueObject.getHORACOMPARENDO() != null)
                           return(false);
          } else if (!this.HORACOMPARENDO.equals(valueObject.getHORACOMPARENDO())) {
                    return(false);
          }
          if (this.DIRECCIONINFRACCION == null) {
                    if (valueObject.getDIRECCIONINFRACCION() != null)
                           return(false);
          } else if (!this.DIRECCIONINFRACCION.equals(valueObject.getDIRECCIONINFRACCION())) {
                    return(false);
          }
          if (this.OBSERVACION == null) {
                    if (valueObject.getOBSERVACION() != null)
                           return(false);
          } else if (!this.OBSERVACION.equals(valueObject.getOBSERVACION())) {
                    return(false);
          }
          if (this.REPORTAFUGA == null) {
                    if (valueObject.getREPORTAFUGA() != null)
                           return(false);
          } else if (!this.REPORTAFUGA.equals(valueObject.getREPORTAFUGA())) {
                    return(false);
          }
          if (this.REPORTAACCIDENTE == null) {
                    if (valueObject.getREPORTAACCIDENTE() != null)
                           return(false);
          } else if (!this.REPORTAACCIDENTE.equals(valueObject.getREPORTAACCIDENTE())) {
                    return(false);
          }
          if (this.REPORTAINMOVILIZACION == null) {
                    if (valueObject.getREPORTAINMOVILIZACION() != null)
                           return(false);
          } else if (!this.REPORTAINMOVILIZACION.equals(valueObject.getREPORTAINMOVILIZACION())) {
                    return(false);
          }
          if (this.POLCA == null) {
                    if (valueObject.getPOLCA() != null)
                           return(false);
          } else if (!this.POLCA.equals(valueObject.getPOLCA())) {
                    return(false);
          }
          if (this.LOCALIDAD_COMUNADIRECCION == null) {
                    if (valueObject.getLOCALIDAD_COMUNADIRECCION() != null)
                           return(false);
          } else if (!this.LOCALIDAD_COMUNADIRECCION.equals(valueObject.getLOCALIDAD_COMUNADIRECCION())) {
                    return(false);
          }
          if (this.ID_DEPTO == null) {
                    if (valueObject.getID_DEPTO() != null)
                           return(false);
          } else if (!this.ID_DEPTO.equals(valueObject.getID_DEPTO())) {
                    return(false);
          }
          if (this.CODCIUDAD == null) {
                    if (valueObject.getCODCIUDAD() != null)
                           return(false);
          } else if (!this.CODCIUDAD.equals(valueObject.getCODCIUDAD())) {
                    return(false);
          }
          if (this.CONSECUTIVOINMOVILIZACION == null) {
                    if (valueObject.getCONSECUTIVOINMOVILIZACION() != null)
                           return(false);
          } else if (!this.CONSECUTIVOINMOVILIZACION.equals(valueObject.getCONSECUTIVOINMOVILIZACION())) {
                    return(false);
          }
          if (this.PLACAGRUA == null) {
                    if (valueObject.getPLACAGRUA() != null)
                           return(false);
          } else if (!this.PLACAGRUA.equals(valueObject.getPLACAGRUA())) {
                    return(false);
          }
          if (this.NUMEROGRUA == null) {
                    if (valueObject.getNUMEROGRUA() != null)
                           return(false);
          } else if (!this.NUMEROGRUA.equals(valueObject.getNUMEROGRUA())) {
                    return(false);
          }
          if (this.DIRECCIONPATIO_INMOVILIZA == null) {
                    if (valueObject.getDIRECCIONPATIO_INMOVILIZA() != null)
                           return(false);
          } else if (!this.DIRECCIONPATIO_INMOVILIZA.equals(valueObject.getDIRECCIONPATIO_INMOVILIZA())) {
                    return(false);
          }
          if (this.DESCRIPCIONPATIO == null) {
                    if (valueObject.getDESCRIPCIONPATIO() != null)
                           return(false);
          } else if (!this.DESCRIPCIONPATIO.equals(valueObject.getDESCRIPCIONPATIO())) {
                    return(false);
          }
          if (this.VALORINFRACCION == null) {
                    if (valueObject.getVALORINFRACCION() != null)
                           return(false);
          } else if (!this.VALORINFRACCION.equals(valueObject.getVALORINFRACCION())) {
                    return(false);
          }
          if (this.NUEVO_CODIGO == null) {
                    if (valueObject.getNUEVO_CODIGO() != null)
                           return(false);
          } else if (!this.NUEVO_CODIGO.equals(valueObject.getNUEVO_CODIGO())) {
                    return(false);
          }
          if (this.NUEVO_CODIGOCORREGIDO == null) {
                    if (valueObject.getNUEVO_CODIGOCORREGIDO() != null)
                           return(false);
          } else if (!this.NUEVO_CODIGOCORREGIDO.equals(valueObject.getNUEVO_CODIGOCORREGIDO())) {
                    return(false);
          }
          if (this.PLACAAGENTE == null) {
                    if (valueObject.getPLACAAGENTE() != null)
                           return(false);
          } else if (!this.PLACAAGENTE.equals(valueObject.getPLACAAGENTE())) {
                    return(false);
          }
          if (this.COD_ESTADO == null) {
                    if (valueObject.getCOD_ESTADO() != null)
                           return(false);
          } else if (!this.COD_ESTADO.equals(valueObject.getCOD_ESTADO())) {
                    return(false);
          }
          if (this.CODTIPOINFRACTOR == null) {
                    if (valueObject.getCODTIPOINFRACTOR() != null)
                           return(false);
          } else if (!this.CODTIPOINFRACTOR.equals(valueObject.getCODTIPOINFRACTOR())) {
                    return(false);
          }
          if (valueObject.getIDREPORTECOMPARENDO() != this.IDREPORTECOMPARENDO) {
                    return(false);
          }
          if (this.NROIDENTIFICACION == null) {
                    if (valueObject.getNROIDENTIFICACION() != null)
                           return(false);
          } else if (!this.NROIDENTIFICACION.equals(valueObject.getNROIDENTIFICACION())) {
                    return(false);
          }
          if (this.IDESTADO == null) {
                    if (valueObject.getIDESTADO() != null)
                           return(false);
          } else if (!this.IDESTADO.equals(valueObject.getIDESTADO())) {
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
        out.append("\nclass ViewComparendosFechas, mapping to table VIEW_COMPARENDOS_FECHAS\n");
        out.append("Persistent attributes: \n"); 
        out.append("PLACA = " + this.PLACA + "\n"); 
        out.append("ID_INFRACTOR = " + this.ID_INFRACTOR + "\n"); 
        out.append("ID_COMPARENDO = " + this.ID_COMPARENDO + "\n"); 
        out.append("NUMEROCOMPARENDO = " + this.NUMEROCOMPARENDO + "\n"); 
        out.append("FECHACOMPARENDO = " + this.FECHACOMPARENDO + "\n"); 
        out.append("FECHAREGISTRO = " + this.FECHAREGISTRO + "\n");
        out.append("HORACOMPARENDO = " + this.HORACOMPARENDO + "\n"); 
        out.append("DIRECCIONINFRACCION = " + this.DIRECCIONINFRACCION + "\n"); 
        out.append("OBSERVACION = " + this.OBSERVACION + "\n"); 
        out.append("REPORTAFUGA = " + this.REPORTAFUGA + "\n"); 
        out.append("REPORTAACCIDENTE = " + this.REPORTAACCIDENTE + "\n"); 
        out.append("REPORTAINMOVILIZACION = " + this.REPORTAINMOVILIZACION + "\n"); 
        out.append("POLCA = " + this.POLCA + "\n"); 
        out.append("LOCALIDAD_COMUNADIRECCION = " + this.LOCALIDAD_COMUNADIRECCION + "\n"); 
        out.append("ID_DEPTO = " + this.ID_DEPTO + "\n"); 
        out.append("CODCIUDAD = " + this.CODCIUDAD + "\n"); 
        out.append("CONSECUTIVOINMOVILIZACION = " + this.CONSECUTIVOINMOVILIZACION + "\n"); 
        out.append("PLACAGRUA = " + this.PLACAGRUA + "\n"); 
        out.append("NUMEROGRUA = " + this.NUMEROGRUA + "\n"); 
        out.append("DIRECCIONPATIO_INMOVILIZA = " + this.DIRECCIONPATIO_INMOVILIZA + "\n"); 
        out.append("DESCRIPCIONPATIO = " + this.DESCRIPCIONPATIO + "\n"); 
        out.append("VALORINFRACCION = " + this.VALORINFRACCION + "\n"); 
        out.append("NUEVO_CODIGO = " + this.NUEVO_CODIGO + "\n"); 
        out.append("NUEVO_CODIGOCORREGIDO = " + this.NUEVO_CODIGOCORREGIDO + "\n"); 
        out.append("PLACAAGENTE = " + this.PLACAAGENTE + "\n"); 
        out.append("COD_ESTADO = " + this.COD_ESTADO + "\n"); 
        out.append("CODTIPOINFRACTOR = " + this.CODTIPOINFRACTOR + "\n"); 
        out.append("IDREPORTECOMPARENDO = " + this.IDREPORTECOMPARENDO + "\n"); 
        out.append("NROIDENTIFICACION = " + this.NROIDENTIFICACION + "\n"); 
        out.append("IDESTADO = " + this.IDESTADO + "\n"); 
        return out.toString();
    }


    /**
     * Clone will return identical deep copy of this valueObject.
     * Note, that this method is different than the clone() which
     * is defined in java.lang.Object. Here, the retuned cloned object
     * will also have all its attributes cloned.
     */
    public Object clone() {
        ViewComparendosFechas cloned = new ViewComparendosFechas();

        if (this.PLACA != null)
             cloned.setPLACA(new String(this.PLACA)); 
        cloned.setID_INFRACTOR(this.ID_INFRACTOR); 
        cloned.setID_COMPARENDO(this.ID_COMPARENDO); 
        if (this.NUMEROCOMPARENDO != null)
             cloned.setNUMEROCOMPARENDO(new String(this.NUMEROCOMPARENDO)); 
        if (this.FECHACOMPARENDO != null)
             cloned.setFECHACOMPARENDO(new String(this.FECHACOMPARENDO)); 
        if (this.FECHAREGISTRO != null)
             cloned.setFECHAREGISTRO(new String(this.FECHAREGISTRO)); 
        if (this.HORACOMPARENDO != null)
             cloned.setHORACOMPARENDO(new String(this.HORACOMPARENDO)); 
        if (this.DIRECCIONINFRACCION != null)
             cloned.setDIRECCIONINFRACCION(new String(this.DIRECCIONINFRACCION)); 
        if (this.OBSERVACION != null)
             cloned.setOBSERVACION(new String(this.OBSERVACION)); 
        if (this.REPORTAFUGA != null)
             cloned.setREPORTAFUGA(new String(this.REPORTAFUGA)); 
        if (this.REPORTAACCIDENTE != null)
             cloned.setREPORTAACCIDENTE(new String(this.REPORTAACCIDENTE)); 
        if (this.REPORTAINMOVILIZACION != null)
             cloned.setREPORTAINMOVILIZACION(new String(this.REPORTAINMOVILIZACION)); 
        if (this.POLCA != null)
             cloned.setPOLCA(new String(this.POLCA)); 
        if (this.LOCALIDAD_COMUNADIRECCION != null)
             cloned.setLOCALIDAD_COMUNADIRECCION(new String(this.LOCALIDAD_COMUNADIRECCION)); 
        if (this.ID_DEPTO != null)
             cloned.setID_DEPTO(new String(this.ID_DEPTO)); 
        if (this.CODCIUDAD != null)
             cloned.setCODCIUDAD(new String(this.CODCIUDAD)); 
        if (this.CONSECUTIVOINMOVILIZACION != null)
             cloned.setCONSECUTIVOINMOVILIZACION(new String(this.CONSECUTIVOINMOVILIZACION)); 
        if (this.PLACAGRUA != null)
             cloned.setPLACAGRUA(new String(this.PLACAGRUA)); 
        if (this.NUMEROGRUA != null)
             cloned.setNUMEROGRUA(new String(this.NUMEROGRUA)); 
        if (this.DIRECCIONPATIO_INMOVILIZA != null)
             cloned.setDIRECCIONPATIO_INMOVILIZA(new String(this.DIRECCIONPATIO_INMOVILIZA)); 
        if (this.DESCRIPCIONPATIO != null)
             cloned.setDESCRIPCIONPATIO(new String(this.DESCRIPCIONPATIO)); 
        if (this.VALORINFRACCION != null)
             cloned.setVALORINFRACCION(new String(this.VALORINFRACCION)); 
        if (this.NUEVO_CODIGO != null)
             cloned.setNUEVO_CODIGO(new String(this.NUEVO_CODIGO)); 
        if (this.NUEVO_CODIGOCORREGIDO != null)
             cloned.setNUEVO_CODIGOCORREGIDO(new String(this.NUEVO_CODIGOCORREGIDO)); 
        if (this.PLACAAGENTE != null)
             cloned.setPLACAAGENTE(new String(this.PLACAAGENTE)); 
        if (this.COD_ESTADO != null)
             cloned.setCOD_ESTADO(new String(this.COD_ESTADO)); 
        if (this.CODTIPOINFRACTOR != null)
             cloned.setCODTIPOINFRACTOR(new String(this.CODTIPOINFRACTOR)); 
        cloned.setIDREPORTECOMPARENDO(this.IDREPORTECOMPARENDO); 
        if (this.NROIDENTIFICACION != null)
             cloned.setNROIDENTIFICACION(new String(this.NROIDENTIFICACION)); 
        if (this.IDESTADO != null)
             cloned.setIDESTADO(new String(this.IDESTADO)); 
        return cloned;
    }



    /** 
     * getDaogenVersion will return information about
     * generator which created these sources.
     */
    public String getDaogenVersion() {
        return "DaoGen version 2.4.1";
    }

    public void setFECHAREGISTRO(String FECHAREGISTRO) {
        this.FECHAREGISTRO = FECHAREGISTRO;
    }

    public String getFECHAREGISTRO() {
        return FECHAREGISTRO;
    }
}
