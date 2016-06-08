package modelo.datos.objetos.generales.vehiculo;

import java.io.*;
import java.sql.*;
import java.util.*;
import java.math.*;

 /**
  * RuntVehiculoModificado Value Object.
  * This class is value object representing database table RUNT_VEHICULOMODIFICADO
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



public class RuntVehiculoModificado implements Cloneable, Serializable {

    /** 
     * Persistent Instance variables. This data is directly 
     * mapped to the columns of database table.
     */
    private int ID_VEHICULOMODIF;
    private String FECHAREGISTRO;
    private int ID_ESTADO;
    private String NROLICVIGENTE;
    private String FECHAEXPLICENCIA;
    private int ID_MOTIVOCANCELACION;
    private String FECHACANCELACION;
    private int ID_TIPOACTA;
    private String NROACTA;
    private String FECHADECLARACION;
    private String ESREPOSICION;
    private int ID_LINEA;
    private int ID_COLOR;
    private int ID_CARROCERIA;
    private int ID_MODALIDADSERV;
    private int ID_NIVELSERV;
    private int CAPACIDADPAS;
    private String CAPACIDADCARGA;
    private String NROREGRABMOTOR;
    private String NROREGRABCHASIS;
    private String NROREGRABSERIE;
    private String NROPUERTA;
    private String PESOBRUTO;
    private String POTENCIA;
    private int ID_TIPOMOTOR;
    private String NROEJES;
    private String NROFICHATECNICA;
    private String ESREPOTENCIADO;
    private String ESBLINDADO;
    private int ID_NIVELBLINDAJE;
    private String ESENSENANZA;
    private String ESIMPORTADO;
    private int ID_PAISORIGEN;
    private String ANIOFABRICACION;
    private String AUTOMOTORMIGRADO;
    private int ID_ORIGENREGISTRO;
    private int ID_GRUPO;
    private int ID_ANTIGCLASICO;
    private String SEGURIDADESTADO;
    private String PLACA;
    private int ID_CVEHICULO;
    private int ID_SERVICIO;
    private int ID_RUNTMODIFICACION;
    private int ID_MARCA;
    private String CILINDRAJE;
    private String NROVIN;
    private String MODELO;
    private String NROMOTOR;
    private String NROSERIE;
    private String NROCHASIS;
    private String SUBPARTIDAARANCELARIA;



    /** 
     * Constructors. DaoGen generates two constructors by default.
     * The first one takes no arguments and provides the most simple
     * way to create object instance. The another one takes one
     * argument, which is the primary key of the corresponding table.
     */

    public RuntVehiculoModificado () {

    }

    public RuntVehiculoModificado (int ID_VEHICULOMODIFIn) {

          this.ID_VEHICULOMODIF = ID_VEHICULOMODIFIn;

    }


    /** 
     * Get- and Set-methods for persistent variables. The default
     * behaviour does not make any checks against malformed data,
     * so these might require some manual additions.
     */

    public int getID_VEHICULOMODIF() {
          return this.ID_VEHICULOMODIF;
    }
    public void setID_VEHICULOMODIF(int ID_VEHICULOMODIFIn) {
          this.ID_VEHICULOMODIF = ID_VEHICULOMODIFIn;
    }

    public String getFECHAREGISTRO() {
          return this.FECHAREGISTRO;
    }
    public void setFECHAREGISTRO(String FECHAREGISTROIn) {
          this.FECHAREGISTRO = FECHAREGISTROIn;
    }

    public int getID_ESTADO() {
          return this.ID_ESTADO;
    }
    public void setID_ESTADO(int ID_ESTADOIn) {
          this.ID_ESTADO = ID_ESTADOIn;
    }

    public String getNROLICVIGENTE() {
          return this.NROLICVIGENTE;
    }
    public void setNROLICVIGENTE(String NROLICVIGENTEIn) {
          this.NROLICVIGENTE = NROLICVIGENTEIn;
    }

    public String getFECHAEXPLICENCIA() {
          return this.FECHAEXPLICENCIA;
    }
    public void setFECHAEXPLICENCIA(String FECHAEXPLICENCIAIn) {
          this.FECHAEXPLICENCIA = FECHAEXPLICENCIAIn;
    }

    public int getID_MOTIVOCANCELACION() {
          return this.ID_MOTIVOCANCELACION;
    }
    public void setID_MOTIVOCANCELACION(int ID_MOTIVOCANCELACIONIn) {
          this.ID_MOTIVOCANCELACION = ID_MOTIVOCANCELACIONIn;
    }

    public String getFECHACANCELACION() {
          return this.FECHACANCELACION;
    }
    public void setFECHACANCELACION(String FECHACANCELACIONIn) {
          this.FECHACANCELACION = FECHACANCELACIONIn;
    }

    public int getID_TIPOACTA() {
          return this.ID_TIPOACTA;
    }
    public void setID_TIPOACTA(int ID_TIPOACTAIn) {
          this.ID_TIPOACTA = ID_TIPOACTAIn;
    }

    public String getNROACTA() {
          return this.NROACTA;
    }
    public void setNROACTA(String NROACTAIn) {
          this.NROACTA = NROACTAIn;
    }

    public String getFECHADECLARACION() {
          return this.FECHADECLARACION;
    }
    public void setFECHADECLARACION(String FECHADECLARACIONIn) {
          this.FECHADECLARACION = FECHADECLARACIONIn;
    }

    public String getESREPOSICION() {
          return this.ESREPOSICION;
    }
    public void setESREPOSICION(String ESREPOSICIONIn) {
          this.ESREPOSICION = ESREPOSICIONIn;
    }

    public int getID_LINEA() {
          return this.ID_LINEA;
    }
    public void setID_LINEA(int ID_LINEAIn) {
          this.ID_LINEA = ID_LINEAIn;
    }

    public int getID_COLOR() {
          return this.ID_COLOR;
    }
    public void setID_COLOR(int ID_COLORIn) {
          this.ID_COLOR = ID_COLORIn;
    }

    public int getID_CARROCERIA() {
          return this.ID_CARROCERIA;
    }
    public void setID_CARROCERIA(int ID_CARROCERIAIn) {
          this.ID_CARROCERIA = ID_CARROCERIAIn;
    }

    public int getID_MODALIDADSERV() {
          return this.ID_MODALIDADSERV;
    }
    public void setID_MODALIDADSERV(int ID_MODALIDADSERVIn) {
          this.ID_MODALIDADSERV = ID_MODALIDADSERVIn;
    }

    public int getID_NIVELSERV() {
          return this.ID_NIVELSERV;
    }
    public void setID_NIVELSERV(int ID_NIVELSERVIn) {
          this.ID_NIVELSERV = ID_NIVELSERVIn;
    }

    public int getCAPACIDADPAS() {
          return this.CAPACIDADPAS;
    }
    public void setCAPACIDADPAS(int CAPACIDADPASIn) {
          this.CAPACIDADPAS = CAPACIDADPASIn;
    }

    public String getCAPACIDADCARGA() {
          return this.CAPACIDADCARGA;
    }
    public void setCAPACIDADCARGA(String CAPACIDADCARGAIn) {
          this.CAPACIDADCARGA = CAPACIDADCARGAIn;
    }

    public String getNROREGRABMOTOR() {
          return this.NROREGRABMOTOR;
    }
    public void setNROREGRABMOTOR(String NROREGRABMOTORIn) {
          this.NROREGRABMOTOR = NROREGRABMOTORIn;
    }

    public String getNROREGRABCHASIS() {
          return this.NROREGRABCHASIS;
    }
    public void setNROREGRABCHASIS(String NROREGRABCHASISIn) {
          this.NROREGRABCHASIS = NROREGRABCHASISIn;
    }

    public String getNROREGRABSERIE() {
          return this.NROREGRABSERIE;
    }
    public void setNROREGRABSERIE(String NROREGRABSERIEIn) {
          this.NROREGRABSERIE = NROREGRABSERIEIn;
    }

    public String getNROPUERTA() {
          return this.NROPUERTA;
    }
    public void setNROPUERTA(String NROPUERTAIn) {
          this.NROPUERTA = NROPUERTAIn;
    }

    public String getPESOBRUTO() {
          return this.PESOBRUTO;
    }
    public void setPESOBRUTO(String PESOBRUTOIn) {
          this.PESOBRUTO = PESOBRUTOIn;
    }

    public String getPOTENCIA() {
          return this.POTENCIA;
    }
    public void setPOTENCIA(String POTENCIAIn) {
          this.POTENCIA = POTENCIAIn;
    }

    public int getID_TIPOMOTOR() {
          return this.ID_TIPOMOTOR;
    }
    public void setID_TIPOMOTOR(int ID_TIPOMOTORIn) {
          this.ID_TIPOMOTOR = ID_TIPOMOTORIn;
    }

    public String getNROEJES() {
          return this.NROEJES;
    }
    public void setNROEJES(String NROEJESIn) {
          this.NROEJES = NROEJESIn;
    }

    public String getNROFICHATECNICA() {
          return this.NROFICHATECNICA;
    }
    public void setNROFICHATECNICA(String NROFICHATECNICAIn) {
          this.NROFICHATECNICA = NROFICHATECNICAIn;
    }

    public String getESREPOTENCIADO() {
          return this.ESREPOTENCIADO;
    }
    public void setESREPOTENCIADO(String ESREPOTENCIADOIn) {
          this.ESREPOTENCIADO = ESREPOTENCIADOIn;
    }

    public String getESBLINDADO() {
          return this.ESBLINDADO;
    }
    public void setESBLINDADO(String ESBLINDADOIn) {
          this.ESBLINDADO = ESBLINDADOIn;
    }

    public int getID_NIVELBLINDAJE() {
          return this.ID_NIVELBLINDAJE;
    }
    public void setID_NIVELBLINDAJE(int ID_NIVELBLINDAJEIn) {
          this.ID_NIVELBLINDAJE = ID_NIVELBLINDAJEIn;
    }

    public String getESENSENANZA() {
          return this.ESENSENANZA;
    }
    public void setESENSENANZA(String ESENSENANZAIn) {
          this.ESENSENANZA = ESENSENANZAIn;
    }

    public String getESIMPORTADO() {
          return this.ESIMPORTADO;
    }
    public void setESIMPORTADO(String ESIMPORTADOIn) {
          this.ESIMPORTADO = ESIMPORTADOIn;
    }

    public int getID_PAISORIGEN() {
          return this.ID_PAISORIGEN;
    }
    public void setID_PAISORIGEN(int ID_PAISORIGENIn) {
          this.ID_PAISORIGEN = ID_PAISORIGENIn;
    }

    public String getANIOFABRICACION() {
          return this.ANIOFABRICACION;
    }
    public void setANIOFABRICACION(String ANIOFABRICACIONIn) {
          this.ANIOFABRICACION = ANIOFABRICACIONIn;
    }

    public String getAUTOMOTORMIGRADO() {
          return this.AUTOMOTORMIGRADO;
    }
    public void setAUTOMOTORMIGRADO(String AUTOMOTORMIGRADOIn) {
          this.AUTOMOTORMIGRADO = AUTOMOTORMIGRADOIn;
    }

    public int getID_ORIGENREGISTRO() {
          return this.ID_ORIGENREGISTRO;
    }
    public void setID_ORIGENREGISTRO(int ID_ORIGENREGISTROIn) {
          this.ID_ORIGENREGISTRO = ID_ORIGENREGISTROIn;
    }

    public int getID_GRUPO() {
          return this.ID_GRUPO;
    }
    public void setID_GRUPO(int ID_GRUPOIn) {
          this.ID_GRUPO = ID_GRUPOIn;
    }

    public int getID_ANTIGCLASICO() {
          return this.ID_ANTIGCLASICO;
    }
    public void setID_ANTIGCLASICO(int ID_ANTIGCLASICOIn) {
          this.ID_ANTIGCLASICO = ID_ANTIGCLASICOIn;
    }

    public String getSEGURIDADESTADO() {
          return this.SEGURIDADESTADO;
    }
    public void setSEGURIDADESTADO(String SEGURIDADESTADOIn) {
          this.SEGURIDADESTADO = SEGURIDADESTADOIn;
    }

    public String getPLACA() {
          return this.PLACA;
    }
    public void setPLACA(String PLACAIn) {
          this.PLACA = PLACAIn;
    }

    public int getID_CVEHICULO() {
          return this.ID_CVEHICULO;
    }
    public void setID_CVEHICULO(int ID_CVEHICULOIn) {
          this.ID_CVEHICULO = ID_CVEHICULOIn;
    }

    public int getID_SERVICIO() {
          return this.ID_SERVICIO;
    }
    public void setID_SERVICIO(int ID_SERVICIOIn) {
          this.ID_SERVICIO = ID_SERVICIOIn;
    }

    public int getID_RUNTMODIFICACION() {
          return this.ID_RUNTMODIFICACION;
    }
    public void setID_RUNTMODIFICACION(int ID_RUNTMODIFICACIONIn) {
          this.ID_RUNTMODIFICACION = ID_RUNTMODIFICACIONIn;
    }

    public int getID_MARCA() {
          return this.ID_MARCA;
    }
    public void setID_MARCA(int ID_MARCAIn) {
          this.ID_MARCA = ID_MARCAIn;
    }

    public String getCILINDRAJE() {
          return this.CILINDRAJE;
    }
    public void setCILINDRAJE(String CILINDRAJEIn) {
          this.CILINDRAJE = CILINDRAJEIn;
    }

    public String getNROVIN() {
          return this.NROVIN;
    }
    public void setNROVIN(String NROVINIn) {
          this.NROVIN = NROVINIn;
    }

    public String getMODELO() {
          return this.MODELO;
    }
    public void setMODELO(String MODELOIn) {
          this.MODELO = MODELOIn;
    }

    public String getNROMOTOR() {
          return this.NROMOTOR;
    }
    public void setNROMOTOR(String NROMOTORIn) {
          this.NROMOTOR = NROMOTORIn;
    }

    public String getNROSERIE() {
          return this.NROSERIE;
    }
    public void setNROSERIE(String NROSERIEIn) {
          this.NROSERIE = NROSERIEIn;
    }

    public String getNROCHASIS() {
          return this.NROCHASIS;
    }
    public void setNROCHASIS(String NROCHASISIn) {
          this.NROCHASIS = NROCHASISIn;
    }

    public String getSUBPARTIDAARANCELARIA() {
          return this.SUBPARTIDAARANCELARIA;
    }
    public void setSUBPARTIDAARANCELARIA(String SUBPARTIDAARANCELARIAIn) {
          this.SUBPARTIDAARANCELARIA = SUBPARTIDAARANCELARIAIn;
    }



    /** 
     * setAll allows to set all persistent variables in one method call.
     * This is useful, when all data is available and it is needed to 
     * set the initial state of this object. Note that this method will
     * directly modify instance variales, without going trough the 
     * individual set-methods.
     */

    public void setAll(int ID_VEHICULOMODIFIn,
          String FECHAREGISTROIn,
          int ID_ESTADOIn,
          String NROLICVIGENTEIn,
          String FECHAEXPLICENCIAIn,
          int ID_MOTIVOCANCELACIONIn,
          String FECHACANCELACIONIn,
          int ID_TIPOACTAIn,
          String NROACTAIn,
          String FECHADECLARACIONIn,
          String ESREPOSICIONIn,
          int ID_LINEAIn,
          int ID_COLORIn,
          int ID_CARROCERIAIn,
          int ID_MODALIDADSERVIn,
          int ID_NIVELSERVIn,
          int CAPACIDADPASIn,
          String CAPACIDADCARGAIn,
          String NROREGRABMOTORIn,
          String NROREGRABCHASISIn,
          String NROREGRABSERIEIn,
          String NROPUERTAIn,
          String PESOBRUTOIn,
          String POTENCIAIn,
          int ID_TIPOMOTORIn,
          String NROEJESIn,
          String NROFICHATECNICAIn,
          String ESREPOTENCIADOIn,
          String ESBLINDADOIn,
          int ID_NIVELBLINDAJEIn,
          String ESENSENANZAIn,
          String ESIMPORTADOIn,
          int ID_PAISORIGENIn,
          String ANIOFABRICACIONIn,
          String AUTOMOTORMIGRADOIn,
          int ID_ORIGENREGISTROIn,
          int ID_GRUPOIn,
          int ID_ANTIGCLASICOIn,
          String SEGURIDADESTADOIn,
          String PLACAIn,
          int ID_CVEHICULOIn,
          int ID_SERVICIOIn,
          int ID_RUNTMODIFICACIONIn,
          int ID_MARCAIn,
          String CILINDRAJEIn,
          String NROVINIn,
          String MODELOIn,
          String NROMOTORIn,
          String NROSERIEIn,
          String NROCHASISIn,
          String SUBPARTIDAARANCELARIAIn) {
          this.ID_VEHICULOMODIF = ID_VEHICULOMODIFIn;
          this.FECHAREGISTRO = FECHAREGISTROIn;
          this.ID_ESTADO = ID_ESTADOIn;
          this.NROLICVIGENTE = NROLICVIGENTEIn;
          this.FECHAEXPLICENCIA = FECHAEXPLICENCIAIn;
          this.ID_MOTIVOCANCELACION = ID_MOTIVOCANCELACIONIn;
          this.FECHACANCELACION = FECHACANCELACIONIn;
          this.ID_TIPOACTA = ID_TIPOACTAIn;
          this.NROACTA = NROACTAIn;
          this.FECHADECLARACION = FECHADECLARACIONIn;
          this.ESREPOSICION = ESREPOSICIONIn;
          this.ID_LINEA = ID_LINEAIn;
          this.ID_COLOR = ID_COLORIn;
          this.ID_CARROCERIA = ID_CARROCERIAIn;
          this.ID_MODALIDADSERV = ID_MODALIDADSERVIn;
          this.ID_NIVELSERV = ID_NIVELSERVIn;
          this.CAPACIDADPAS = CAPACIDADPASIn;
          this.CAPACIDADCARGA = CAPACIDADCARGAIn;
          this.NROREGRABMOTOR = NROREGRABMOTORIn;
          this.NROREGRABCHASIS = NROREGRABCHASISIn;
          this.NROREGRABSERIE = NROREGRABSERIEIn;
          this.NROPUERTA = NROPUERTAIn;
          this.PESOBRUTO = PESOBRUTOIn;
          this.POTENCIA = POTENCIAIn;
          this.ID_TIPOMOTOR = ID_TIPOMOTORIn;
          this.NROEJES = NROEJESIn;
          this.NROFICHATECNICA = NROFICHATECNICAIn;
          this.ESREPOTENCIADO = ESREPOTENCIADOIn;
          this.ESBLINDADO = ESBLINDADOIn;
          this.ID_NIVELBLINDAJE = ID_NIVELBLINDAJEIn;
          this.ESENSENANZA = ESENSENANZAIn;
          this.ESIMPORTADO = ESIMPORTADOIn;
          this.ID_PAISORIGEN = ID_PAISORIGENIn;
          this.ANIOFABRICACION = ANIOFABRICACIONIn;
          this.AUTOMOTORMIGRADO = AUTOMOTORMIGRADOIn;
          this.ID_ORIGENREGISTRO = ID_ORIGENREGISTROIn;
          this.ID_GRUPO = ID_GRUPOIn;
          this.ID_ANTIGCLASICO = ID_ANTIGCLASICOIn;
          this.SEGURIDADESTADO = SEGURIDADESTADOIn;
          this.PLACA = PLACAIn;
          this.ID_CVEHICULO = ID_CVEHICULOIn;
          this.ID_SERVICIO = ID_SERVICIOIn;
          this.ID_RUNTMODIFICACION = ID_RUNTMODIFICACIONIn;
          this.ID_MARCA = ID_MARCAIn;
          this.CILINDRAJE = CILINDRAJEIn;
          this.NROVIN = NROVINIn;
          this.MODELO = MODELOIn;
          this.NROMOTOR = NROMOTORIn;
          this.NROSERIE = NROSERIEIn;
          this.NROCHASIS = NROCHASISIn;
          this.SUBPARTIDAARANCELARIA = SUBPARTIDAARANCELARIAIn;
    }


    /** 
     * hasEqualMapping-method will compare two RuntVehiculoModificado instances
     * and return true if they contain same values in all persistent instance 
     * variables. If hasEqualMapping returns true, it does not mean the objects
     * are the same instance. However it does mean that in that moment, they 
     * are mapped to the same row in database.
     */
    public boolean hasEqualMapping(RuntVehiculoModificado valueObject) {

          if (valueObject.getID_VEHICULOMODIF() != this.ID_VEHICULOMODIF) {
                    return(false);
          }
          if (this.FECHAREGISTRO == null) {
                    if (valueObject.getFECHAREGISTRO() != null)
                           return(false);
          } else if (!this.FECHAREGISTRO.equals(valueObject.getFECHAREGISTRO())) {
                    return(false);
          }
          if (valueObject.getID_ESTADO() != this.ID_ESTADO) {
                    return(false);
          }
          if (this.NROLICVIGENTE == null) {
                    if (valueObject.getNROLICVIGENTE() != null)
                           return(false);
          } else if (!this.NROLICVIGENTE.equals(valueObject.getNROLICVIGENTE())) {
                    return(false);
          }
          if (this.FECHAEXPLICENCIA == null) {
                    if (valueObject.getFECHAEXPLICENCIA() != null)
                           return(false);
          } else if (!this.FECHAEXPLICENCIA.equals(valueObject.getFECHAEXPLICENCIA())) {
                    return(false);
          }
          if (valueObject.getID_MOTIVOCANCELACION() != this.ID_MOTIVOCANCELACION) {
                    return(false);
          }
          if (this.FECHACANCELACION == null) {
                    if (valueObject.getFECHACANCELACION() != null)
                           return(false);
          } else if (!this.FECHACANCELACION.equals(valueObject.getFECHACANCELACION())) {
                    return(false);
          }
          if (valueObject.getID_TIPOACTA() != this.ID_TIPOACTA) {
                    return(false);
          }
          if (this.NROACTA == null) {
                    if (valueObject.getNROACTA() != null)
                           return(false);
          } else if (!this.NROACTA.equals(valueObject.getNROACTA())) {
                    return(false);
          }
          if (this.FECHADECLARACION == null) {
                    if (valueObject.getFECHADECLARACION() != null)
                           return(false);
          } else if (!this.FECHADECLARACION.equals(valueObject.getFECHADECLARACION())) {
                    return(false);
          }
          if (this.ESREPOSICION == null) {
                    if (valueObject.getESREPOSICION() != null)
                           return(false);
          } else if (!this.ESREPOSICION.equals(valueObject.getESREPOSICION())) {
                    return(false);
          }
          if (valueObject.getID_LINEA() != this.ID_LINEA) {
                    return(false);
          }
          if (valueObject.getID_COLOR() != this.ID_COLOR) {
                    return(false);
          }
          if (valueObject.getID_CARROCERIA() != this.ID_CARROCERIA) {
                    return(false);
          }
          if (valueObject.getID_MODALIDADSERV() != this.ID_MODALIDADSERV) {
                    return(false);
          }
          if (valueObject.getID_NIVELSERV() != this.ID_NIVELSERV) {
                    return(false);
          }
          if (valueObject.getCAPACIDADPAS() != this.CAPACIDADPAS) {
                    return(false);
          }
          if (this.CAPACIDADCARGA == null) {
                    if (valueObject.getCAPACIDADCARGA() != null)
                           return(false);
          } else if (!this.CAPACIDADCARGA.equals(valueObject.getCAPACIDADCARGA())) {
                    return(false);
          }
          if (this.NROREGRABMOTOR == null) {
                    if (valueObject.getNROREGRABMOTOR() != null)
                           return(false);
          } else if (!this.NROREGRABMOTOR.equals(valueObject.getNROREGRABMOTOR())) {
                    return(false);
          }
          if (this.NROREGRABCHASIS == null) {
                    if (valueObject.getNROREGRABCHASIS() != null)
                           return(false);
          } else if (!this.NROREGRABCHASIS.equals(valueObject.getNROREGRABCHASIS())) {
                    return(false);
          }
          if (this.NROREGRABSERIE == null) {
                    if (valueObject.getNROREGRABSERIE() != null)
                           return(false);
          } else if (!this.NROREGRABSERIE.equals(valueObject.getNROREGRABSERIE())) {
                    return(false);
          }
          if (this.NROPUERTA == null) {
                    if (valueObject.getNROPUERTA() != null)
                           return(false);
          } else if (!this.NROPUERTA.equals(valueObject.getNROPUERTA())) {
                    return(false);
          }
          if (this.PESOBRUTO == null) {
                    if (valueObject.getPESOBRUTO() != null)
                           return(false);
          } else if (!this.PESOBRUTO.equals(valueObject.getPESOBRUTO())) {
                    return(false);
          }
          if (this.POTENCIA == null) {
                    if (valueObject.getPOTENCIA() != null)
                           return(false);
          } else if (!this.POTENCIA.equals(valueObject.getPOTENCIA())) {
                    return(false);
          }
          if (valueObject.getID_TIPOMOTOR() != this.ID_TIPOMOTOR) {
                    return(false);
          }
          if (this.NROEJES == null) {
                    if (valueObject.getNROEJES() != null)
                           return(false);
          } else if (!this.NROEJES.equals(valueObject.getNROEJES())) {
                    return(false);
          }
          if (this.NROFICHATECNICA == null) {
                    if (valueObject.getNROFICHATECNICA() != null)
                           return(false);
          } else if (!this.NROFICHATECNICA.equals(valueObject.getNROFICHATECNICA())) {
                    return(false);
          }
          if (this.ESREPOTENCIADO == null) {
                    if (valueObject.getESREPOTENCIADO() != null)
                           return(false);
          } else if (!this.ESREPOTENCIADO.equals(valueObject.getESREPOTENCIADO())) {
                    return(false);
          }
          if (this.ESBLINDADO == null) {
                    if (valueObject.getESBLINDADO() != null)
                           return(false);
          } else if (!this.ESBLINDADO.equals(valueObject.getESBLINDADO())) {
                    return(false);
          }
          if (valueObject.getID_NIVELBLINDAJE() != this.ID_NIVELBLINDAJE) {
                    return(false);
          }
          if (this.ESENSENANZA == null) {
                    if (valueObject.getESENSENANZA() != null)
                           return(false);
          } else if (!this.ESENSENANZA.equals(valueObject.getESENSENANZA())) {
                    return(false);
          }
          if (this.ESIMPORTADO == null) {
                    if (valueObject.getESIMPORTADO() != null)
                           return(false);
          } else if (!this.ESIMPORTADO.equals(valueObject.getESIMPORTADO())) {
                    return(false);
          }
          if (valueObject.getID_PAISORIGEN() != this.ID_PAISORIGEN) {
                    return(false);
          }
          if (this.ANIOFABRICACION == null) {
                    if (valueObject.getANIOFABRICACION() != null)
                           return(false);
          } else if (!this.ANIOFABRICACION.equals(valueObject.getANIOFABRICACION())) {
                    return(false);
          }
          if (this.AUTOMOTORMIGRADO == null) {
                    if (valueObject.getAUTOMOTORMIGRADO() != null)
                           return(false);
          } else if (!this.AUTOMOTORMIGRADO.equals(valueObject.getAUTOMOTORMIGRADO())) {
                    return(false);
          }
          if (valueObject.getID_ORIGENREGISTRO() != this.ID_ORIGENREGISTRO) {
                    return(false);
          }
          if (valueObject.getID_GRUPO() != this.ID_GRUPO) {
                    return(false);
          }
          if (valueObject.getID_ANTIGCLASICO() != this.ID_ANTIGCLASICO) {
                    return(false);
          }
          if (this.SEGURIDADESTADO == null) {
                    if (valueObject.getSEGURIDADESTADO() != null)
                           return(false);
          } else if (!this.SEGURIDADESTADO.equals(valueObject.getSEGURIDADESTADO())) {
                    return(false);
          }
          if (this.PLACA == null) {
                    if (valueObject.getPLACA() != null)
                           return(false);
          } else if (!this.PLACA.equals(valueObject.getPLACA())) {
                    return(false);
          }
          if (valueObject.getID_CVEHICULO() != this.ID_CVEHICULO) {
                    return(false);
          }
          if (valueObject.getID_SERVICIO() != this.ID_SERVICIO) {
                    return(false);
          }
          if (valueObject.getID_RUNTMODIFICACION() != this.ID_RUNTMODIFICACION) {
                    return(false);
          }
          if (valueObject.getID_MARCA() != this.ID_MARCA) {
                    return(false);
          }
          if (this.CILINDRAJE == null) {
                    if (valueObject.getCILINDRAJE() != null)
                           return(false);
          } else if (!this.CILINDRAJE.equals(valueObject.getCILINDRAJE())) {
                    return(false);
          }
          if (this.NROVIN == null) {
                    if (valueObject.getNROVIN() != null)
                           return(false);
          } else if (!this.NROVIN.equals(valueObject.getNROVIN())) {
                    return(false);
          }
          if (this.MODELO == null) {
                    if (valueObject.getMODELO() != null)
                           return(false);
          } else if (!this.MODELO.equals(valueObject.getMODELO())) {
                    return(false);
          }
          if (this.NROMOTOR == null) {
                    if (valueObject.getNROMOTOR() != null)
                           return(false);
          } else if (!this.NROMOTOR.equals(valueObject.getNROMOTOR())) {
                    return(false);
          }
          if (this.NROSERIE == null) {
                    if (valueObject.getNROSERIE() != null)
                           return(false);
          } else if (!this.NROSERIE.equals(valueObject.getNROSERIE())) {
                    return(false);
          }
          if (this.NROCHASIS == null) {
                    if (valueObject.getNROCHASIS() != null)
                           return(false);
          } else if (!this.NROCHASIS.equals(valueObject.getNROCHASIS())) {
                    return(false);
          }
          if (this.SUBPARTIDAARANCELARIA == null) {
                    if (valueObject.getSUBPARTIDAARANCELARIA() != null)
                           return(false);
          } else if (!this.SUBPARTIDAARANCELARIA.equals(valueObject.getSUBPARTIDAARANCELARIA())) {
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
        out.append("\nclass RuntVehiculoModificado, mapping to table RUNT_VEHICULOMODIFICADO\n");
        out.append("Persistent attributes: \n"); 
        out.append("ID_VEHICULOMODIF = " + this.ID_VEHICULOMODIF + "\n"); 
        out.append("FECHAREGISTRO = " + this.FECHAREGISTRO + "\n"); 
        out.append("ID_ESTADO = " + this.ID_ESTADO + "\n"); 
        out.append("NROLICVIGENTE = " + this.NROLICVIGENTE + "\n"); 
        out.append("FECHAEXPLICENCIA = " + this.FECHAEXPLICENCIA + "\n"); 
        out.append("ID_MOTIVOCANCELACION = " + this.ID_MOTIVOCANCELACION + "\n"); 
        out.append("FECHACANCELACION = " + this.FECHACANCELACION + "\n"); 
        out.append("ID_TIPOACTA = " + this.ID_TIPOACTA + "\n"); 
        out.append("NROACTA = " + this.NROACTA + "\n"); 
        out.append("FECHADECLARACION = " + this.FECHADECLARACION + "\n"); 
        out.append("ESREPOSICION = " + this.ESREPOSICION + "\n"); 
        out.append("ID_LINEA = " + this.ID_LINEA + "\n"); 
        out.append("ID_COLOR = " + this.ID_COLOR + "\n"); 
        out.append("ID_CARROCERIA = " + this.ID_CARROCERIA + "\n"); 
        out.append("ID_MODALIDADSERV = " + this.ID_MODALIDADSERV + "\n"); 
        out.append("ID_NIVELSERV = " + this.ID_NIVELSERV + "\n"); 
        out.append("CAPACIDADPAS = " + this.CAPACIDADPAS + "\n"); 
        out.append("CAPACIDADCARGA = " + this.CAPACIDADCARGA + "\n"); 
        out.append("NROREGRABMOTOR = " + this.NROREGRABMOTOR + "\n"); 
        out.append("NROREGRABCHASIS = " + this.NROREGRABCHASIS + "\n"); 
        out.append("NROREGRABSERIE = " + this.NROREGRABSERIE + "\n"); 
        out.append("NROPUERTA = " + this.NROPUERTA + "\n"); 
        out.append("PESOBRUTO = " + this.PESOBRUTO + "\n"); 
        out.append("POTENCIA = " + this.POTENCIA + "\n"); 
        out.append("ID_TIPOMOTOR = " + this.ID_TIPOMOTOR + "\n"); 
        out.append("NROEJES = " + this.NROEJES + "\n"); 
        out.append("NROFICHATECNICA = " + this.NROFICHATECNICA + "\n"); 
        out.append("ESREPOTENCIADO = " + this.ESREPOTENCIADO + "\n"); 
        out.append("ESBLINDADO = " + this.ESBLINDADO + "\n"); 
        out.append("ID_NIVELBLINDAJE = " + this.ID_NIVELBLINDAJE + "\n"); 
        out.append("ESENSENANZA = " + this.ESENSENANZA + "\n"); 
        out.append("ESIMPORTADO = " + this.ESIMPORTADO + "\n"); 
        out.append("ID_PAISORIGEN = " + this.ID_PAISORIGEN + "\n"); 
        out.append("ANIOFABRICACION = " + this.ANIOFABRICACION + "\n"); 
        out.append("AUTOMOTORMIGRADO = " + this.AUTOMOTORMIGRADO + "\n"); 
        out.append("ID_ORIGENREGISTRO = " + this.ID_ORIGENREGISTRO + "\n"); 
        out.append("ID_GRUPO = " + this.ID_GRUPO + "\n"); 
        out.append("ID_ANTIGCLASICO = " + this.ID_ANTIGCLASICO + "\n"); 
        out.append("SEGURIDADESTADO = " + this.SEGURIDADESTADO + "\n"); 
        out.append("PLACA = " + this.PLACA + "\n"); 
        out.append("ID_CVEHICULO = " + this.ID_CVEHICULO + "\n"); 
        out.append("ID_SERVICIO = " + this.ID_SERVICIO + "\n"); 
        out.append("ID_RUNTMODIFICACION = " + this.ID_RUNTMODIFICACION + "\n"); 
        out.append("ID_MARCA = " + this.ID_MARCA + "\n"); 
        out.append("CILINDRAJE = " + this.CILINDRAJE + "\n"); 
        out.append("NROVIN = " + this.NROVIN + "\n"); 
        out.append("MODELO = " + this.MODELO + "\n"); 
        out.append("NROMOTOR = " + this.NROMOTOR + "\n"); 
        out.append("NROSERIE = " + this.NROSERIE + "\n"); 
        out.append("NROCHASIS = " + this.NROCHASIS + "\n"); 
        out.append("SUBPARTIDAARANCELARIA = " + this.SUBPARTIDAARANCELARIA + "\n"); 
        return out.toString();
    }


    /**
     * Clone will return identical deep copy of this valueObject.
     * Note, that this method is different than the clone() which
     * is defined in java.lang.Object. Here, the retuned cloned object
     * will also have all its attributes cloned.
     */
    public Object clone() {
        RuntVehiculoModificado cloned = new RuntVehiculoModificado();

        cloned.setID_VEHICULOMODIF(this.ID_VEHICULOMODIF); 
        if (this.FECHAREGISTRO != null)
             cloned.setFECHAREGISTRO(new String(this.FECHAREGISTRO)); 
        cloned.setID_ESTADO(this.ID_ESTADO); 
        if (this.NROLICVIGENTE != null)
             cloned.setNROLICVIGENTE(new String(this.NROLICVIGENTE)); 
        if (this.FECHAEXPLICENCIA != null)
             cloned.setFECHAEXPLICENCIA(new String(this.FECHAEXPLICENCIA)); 
        cloned.setID_MOTIVOCANCELACION(this.ID_MOTIVOCANCELACION); 
        if (this.FECHACANCELACION != null)
             cloned.setFECHACANCELACION(new String(this.FECHACANCELACION)); 
        cloned.setID_TIPOACTA(this.ID_TIPOACTA); 
        if (this.NROACTA != null)
             cloned.setNROACTA(new String(this.NROACTA)); 
        if (this.FECHADECLARACION != null)
             cloned.setFECHADECLARACION(new String(this.FECHADECLARACION)); 
        if (this.ESREPOSICION != null)
             cloned.setESREPOSICION(new String(this.ESREPOSICION)); 
        cloned.setID_LINEA(this.ID_LINEA); 
        cloned.setID_COLOR(this.ID_COLOR); 
        cloned.setID_CARROCERIA(this.ID_CARROCERIA); 
        cloned.setID_MODALIDADSERV(this.ID_MODALIDADSERV); 
        cloned.setID_NIVELSERV(this.ID_NIVELSERV); 
        cloned.setCAPACIDADPAS(this.CAPACIDADPAS); 
        if (this.CAPACIDADCARGA != null)
             cloned.setCAPACIDADCARGA(new String(this.CAPACIDADCARGA)); 
        if (this.NROREGRABMOTOR != null)
             cloned.setNROREGRABMOTOR(new String(this.NROREGRABMOTOR)); 
        if (this.NROREGRABCHASIS != null)
             cloned.setNROREGRABCHASIS(new String(this.NROREGRABCHASIS)); 
        if (this.NROREGRABSERIE != null)
             cloned.setNROREGRABSERIE(new String(this.NROREGRABSERIE)); 
        if (this.NROPUERTA != null)
             cloned.setNROPUERTA(new String(this.NROPUERTA)); 
        if (this.PESOBRUTO != null)
             cloned.setPESOBRUTO(new String(this.PESOBRUTO)); 
        if (this.POTENCIA != null)
             cloned.setPOTENCIA(new String(this.POTENCIA)); 
        cloned.setID_TIPOMOTOR(this.ID_TIPOMOTOR); 
        if (this.NROEJES != null)
             cloned.setNROEJES(new String(this.NROEJES)); 
        if (this.NROFICHATECNICA != null)
             cloned.setNROFICHATECNICA(new String(this.NROFICHATECNICA)); 
        if (this.ESREPOTENCIADO != null)
             cloned.setESREPOTENCIADO(new String(this.ESREPOTENCIADO)); 
        if (this.ESBLINDADO != null)
             cloned.setESBLINDADO(new String(this.ESBLINDADO)); 
        cloned.setID_NIVELBLINDAJE(this.ID_NIVELBLINDAJE); 
        if (this.ESENSENANZA != null)
             cloned.setESENSENANZA(new String(this.ESENSENANZA)); 
        if (this.ESIMPORTADO != null)
             cloned.setESIMPORTADO(new String(this.ESIMPORTADO)); 
        cloned.setID_PAISORIGEN(this.ID_PAISORIGEN); 
        if (this.ANIOFABRICACION != null)
             cloned.setANIOFABRICACION(new String(this.ANIOFABRICACION)); 
        if (this.AUTOMOTORMIGRADO != null)
             cloned.setAUTOMOTORMIGRADO(new String(this.AUTOMOTORMIGRADO)); 
        cloned.setID_ORIGENREGISTRO(this.ID_ORIGENREGISTRO); 
        cloned.setID_GRUPO(this.ID_GRUPO); 
        cloned.setID_ANTIGCLASICO(this.ID_ANTIGCLASICO); 
        if (this.SEGURIDADESTADO != null)
             cloned.setSEGURIDADESTADO(new String(this.SEGURIDADESTADO)); 
        if (this.PLACA != null)
             cloned.setPLACA(new String(this.PLACA)); 
        cloned.setID_CVEHICULO(this.ID_CVEHICULO); 
        cloned.setID_SERVICIO(this.ID_SERVICIO); 
        cloned.setID_RUNTMODIFICACION(this.ID_RUNTMODIFICACION); 
        cloned.setID_MARCA(this.ID_MARCA); 
        if (this.CILINDRAJE != null)
             cloned.setCILINDRAJE(new String(this.CILINDRAJE)); 
        if (this.NROVIN != null)
             cloned.setNROVIN(new String(this.NROVIN)); 
        if (this.MODELO != null)
             cloned.setMODELO(new String(this.MODELO)); 
        if (this.NROMOTOR != null)
             cloned.setNROMOTOR(new String(this.NROMOTOR)); 
        if (this.NROSERIE != null)
             cloned.setNROSERIE(new String(this.NROSERIE)); 
        if (this.NROCHASIS != null)
             cloned.setNROCHASIS(new String(this.NROCHASIS)); 
        if (this.SUBPARTIDAARANCELARIA != null)
             cloned.setSUBPARTIDAARANCELARIA(new String(this.SUBPARTIDAARANCELARIA)); 
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