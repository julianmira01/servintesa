package modelo.datos.objetos.liquidador;

import java.io.Serializable;

/**
  * Factura Value Object.
  * This class is value object representing database table L_FACTURAS
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


public class Factura implements Cloneable, Serializable {

    /** 
     * Persistent Instance variables. This data is directly 
     * mapped to the columns of database table.
     */
    private int LF_ID;
    private String LF_TIPO;
    private String LF_V_ID;
    private String LF_ID_PERSONA;
    private String LF_ESTADO;
    private String LF_FECHA;
    private String LF_FECHA_PAGO;
    private String LF_FECHA_TRAMITE;
    private String LF_TOTAL;
    private String LF_NOTA;
    private String LF_ID_USUARIO;
    private String LF_ID_ARQUEO;
    private String LF_ID_USUARIOANULA;
    private String LF_FECHAANULA;
    private String LF_HORAANULA;
    private String LF_MOTIVOCANCELACION;
    private String LF_FACTURAERROR;
    private String LF_NUMERO;
    private String LF_DESCUENTO;
    private String LF_NOTAADICIONAL;
    private String LF_SIREVNUMERO;
    private String LF_SIREVVALOR;
    private String LF_IDRADICADO;
    private String LF_IDDETCITA;
    private String LF_NUMRUNT;
    private String LF_IDSOLICRUNT;
    private String LF_FECHARADICARUNT;
    private String LF_IDSOLICITANTE;
    private String LF_EMPERSOL;
    private String LF_IDAPODERADO;
    private String LF_TOTALFACTURARUNT;
    private String CARGADO;



    /** 
     * Constructors. DaoGen generates two constructors by default.
     * The first one takes no arguments and provides the most simple
     * way to create object instance. The another one takes one
     * argument, which is the primary key of the corresponding table.
     */

    public Factura () {

    }

    public Factura (int LF_IDIn) {

          this.LF_ID = LF_IDIn;

    }


    /** 
     * Get- and Set-methods for persistent variables. The default
     * behaviour does not make any checks against malformed data,
     * so these might require some manual additions.
     */

    public int getLF_ID() {
          return this.LF_ID;
    }
    public void setLF_ID(int LF_IDIn) {
          this.LF_ID = LF_IDIn;
    }

    public String getLF_TIPO() {
          return this.LF_TIPO;
    }
    public void setLF_TIPO(String LF_TIPOIn) {
          this.LF_TIPO = LF_TIPOIn;
    }

    public String getLF_V_ID() {
          return this.LF_V_ID;
    }
    public void setLF_V_ID(String LF_V_IDIn) {
          this.LF_V_ID = LF_V_IDIn;
    }

    public String getLF_ID_PERSONA() {
          return this.LF_ID_PERSONA;
    }
    public void setLF_ID_PERSONA(String LF_ID_PERSONAIn) {
          this.LF_ID_PERSONA = LF_ID_PERSONAIn;
    }

    public String getLF_ESTADO() {
          return this.LF_ESTADO;
    }
    public void setLF_ESTADO(String LF_ESTADOIn) {
          this.LF_ESTADO = LF_ESTADOIn;
    }

    public String getLF_FECHA() {
          return this.LF_FECHA;
    }
    public void setLF_FECHA(String LF_FECHAIn) {
          this.LF_FECHA = LF_FECHAIn;
    }

    public String getLF_FECHA_PAGO() {
          return this.LF_FECHA_PAGO;
    }
    public void setLF_FECHA_PAGO(String LF_FECHA_PAGOIn) {
          this.LF_FECHA_PAGO = LF_FECHA_PAGOIn;
    }

    public String getLF_FECHA_TRAMITE() {
          return this.LF_FECHA_TRAMITE;
    }
    public void setLF_FECHA_TRAMITE(String LF_FECHA_TRAMITEIn) {
          this.LF_FECHA_TRAMITE = LF_FECHA_TRAMITEIn;
    }

    public String getLF_TOTAL() {
          return this.LF_TOTAL;
    }
    public void setLF_TOTAL(String LF_TOTALIn) {
          this.LF_TOTAL = LF_TOTALIn;
    }

    public String getLF_NOTA() {
          return this.LF_NOTA;
    }
    public void setLF_NOTA(String LF_NOTAIn) {
          this.LF_NOTA = LF_NOTAIn;
    }

    public String getLF_ID_USUARIO() {
          return this.LF_ID_USUARIO;
    }
    public void setLF_ID_USUARIO(String LF_ID_USUARIOIn) {
          this.LF_ID_USUARIO = LF_ID_USUARIOIn;
    }

    public String getLF_ID_ARQUEO() {
          return this.LF_ID_ARQUEO;
    }
    public void setLF_ID_ARQUEO(String LF_ID_ARQUEOIn) {
          this.LF_ID_ARQUEO = LF_ID_ARQUEOIn;
    }

    public String getLF_ID_USUARIOANULA() {
          return this.LF_ID_USUARIOANULA;
    }
    public void setLF_ID_USUARIOANULA(String LF_ID_USUARIOANULAIn) {
          this.LF_ID_USUARIOANULA = LF_ID_USUARIOANULAIn;
    }

    public String getLF_FECHAANULA() {
          return this.LF_FECHAANULA;
    }
    public void setLF_FECHAANULA(String LF_FECHAANULAIn) {
          this.LF_FECHAANULA = LF_FECHAANULAIn;
    }

    public String getLF_HORAANULA() {
          return this.LF_HORAANULA;
    }
    public void setLF_HORAANULA(String LF_HORAANULAIn) {
          this.LF_HORAANULA = LF_HORAANULAIn;
    }

    public String getLF_MOTIVOCANCELACION() {
          return this.LF_MOTIVOCANCELACION;
    }
    public void setLF_MOTIVOCANCELACION(String LF_MOTIVOCANCELACIONIn) {
          this.LF_MOTIVOCANCELACION = LF_MOTIVOCANCELACIONIn;
    }

    public String getLF_FACTURAERROR() {
          return this.LF_FACTURAERROR;
    }
    public void setLF_FACTURAERROR(String LF_FACTURAERRORIn) {
          this.LF_FACTURAERROR = LF_FACTURAERRORIn;
    }

    public String getLF_NUMERO() {
          return this.LF_NUMERO;
    }
    public void setLF_NUMERO(String LF_NUMEROIn) {
          this.LF_NUMERO = LF_NUMEROIn;
    }

    public String getLF_DESCUENTO() {
          return this.LF_DESCUENTO;
    }
    public void setLF_DESCUENTO(String LF_DESCUENTOIn) {
          this.LF_DESCUENTO = LF_DESCUENTOIn;
    }

    public String getLF_NOTAADICIONAL() {
          return this.LF_NOTAADICIONAL;
    }
    public void setLF_NOTAADICIONAL(String LF_NOTAADICIONALIn) {
          this.LF_NOTAADICIONAL = LF_NOTAADICIONALIn;
    }

    public String getLF_SIREVNUMERO() {
          return this.LF_SIREVNUMERO;
    }
    public void setLF_SIREVNUMERO(String LF_SIREVNUMEROIn) {
          this.LF_SIREVNUMERO = LF_SIREVNUMEROIn;
    }

    public String getLF_SIREVVALOR() {
          return this.LF_SIREVVALOR;
    }
    public void setLF_SIREVVALOR(String LF_SIREVVALORIn) {
          this.LF_SIREVVALOR = LF_SIREVVALORIn;
    }

    public String getLF_IDRADICADO() {
          return this.LF_IDRADICADO;
    }
    public void setLF_IDRADICADO(String LF_IDRADICADOIn) {
          this.LF_IDRADICADO = LF_IDRADICADOIn;
    }

    public String getLF_IDDETCITA() {
          return this.LF_IDDETCITA;
    }
    public void setLF_IDDETCITA(String LF_IDDETCITAIn) {
          this.LF_IDDETCITA = LF_IDDETCITAIn;
    }

    public String getLF_NUMRUNT() {
          return this.LF_NUMRUNT;
    }
    public void setLF_NUMRUNT(String LF_NUMRUNTIn) {
          this.LF_NUMRUNT = LF_NUMRUNTIn;
    }

    public String getLF_IDSOLICRUNT() {
          return this.LF_IDSOLICRUNT;
    }
    public void setLF_IDSOLICRUNT(String LF_IDSOLICRUNTIn) {
          this.LF_IDSOLICRUNT = LF_IDSOLICRUNTIn;
    }

    public String getLF_FECHARADICARUNT() {
          return this.LF_FECHARADICARUNT;
    }
    public void setLF_FECHARADICARUNT(String LF_FECHARADICARUNTIn) {
          this.LF_FECHARADICARUNT = LF_FECHARADICARUNTIn;
    }

    public String getLF_IDSOLICITANTE() {
          return this.LF_IDSOLICITANTE;
    }
    public void setLF_IDSOLICITANTE(String LF_IDSOLICITANTEIn) {
          this.LF_IDSOLICITANTE = LF_IDSOLICITANTEIn;
    }

    public String getLF_EMPERSOL() {
          return this.LF_EMPERSOL;
    }
    public void setLF_EMPERSOL(String LF_EMPERSOLIn) {
          this.LF_EMPERSOL = LF_EMPERSOLIn;
    }

    public String getLF_IDAPODERADO() {
          return this.LF_IDAPODERADO;
    }
    public void setLF_IDAPODERADO(String LF_IDAPODERADOIn) {
          this.LF_IDAPODERADO = LF_IDAPODERADOIn;
    }

    public String getLF_TOTALFACTURARUNT() {
          return this.LF_TOTALFACTURARUNT;
    }
    public void setLF_TOTALFACTURARUNT(String LF_TOTALFACTURARUNTIn) {
          this.LF_TOTALFACTURARUNT = LF_TOTALFACTURARUNTIn;
    }

    public String getCARGADO() {
          return this.CARGADO;
    }
    public void setCARGADO(String CARGADOIn) {
          this.CARGADO = CARGADOIn;
    }



    /** 
     * setAll allows to set all persistent variables in one method call.
     * This is useful, when all data is available and it is needed to 
     * set the initial state of this object. Note that this method will
     * directly modify instance variales, without going trough the 
     * individual set-methods.
     */

    public void setAll(int LF_IDIn,
          String LF_TIPOIn,
          String LF_V_IDIn,
          String LF_ID_PERSONAIn,
          String LF_ESTADOIn,
          String LF_FECHAIn,
          String LF_FECHA_PAGOIn,
          String LF_FECHA_TRAMITEIn,
          String LF_TOTALIn,
          String LF_NOTAIn,
          String LF_ID_USUARIOIn,
          String LF_ID_ARQUEOIn,
          String LF_ID_USUARIOANULAIn,
          String LF_FECHAANULAIn,
          String LF_HORAANULAIn,
          String LF_MOTIVOCANCELACIONIn,
          String LF_FACTURAERRORIn,
          String LF_NUMEROIn,
          String LF_DESCUENTOIn,
          String LF_NOTAADICIONALIn,
          String LF_SIREVNUMEROIn,
          String LF_SIREVVALORIn,
          String LF_IDRADICADOIn,
          String LF_IDDETCITAIn,
          String LF_NUMRUNTIn,
          String LF_IDSOLICRUNTIn,
          String LF_FECHARADICARUNTIn,
          String LF_IDSOLICITANTEIn,
          String LF_EMPERSOLIn,
          String LF_IDAPODERADOIn,
          String LF_TOTALFACTURARUNTIn,
          String CARGADOIn) {
          this.LF_ID = LF_IDIn;
          this.LF_TIPO = LF_TIPOIn;
          this.LF_V_ID = LF_V_IDIn;
          this.LF_ID_PERSONA = LF_ID_PERSONAIn;
          this.LF_ESTADO = LF_ESTADOIn;
          this.LF_FECHA = LF_FECHAIn;
          this.LF_FECHA_PAGO = LF_FECHA_PAGOIn;
          this.LF_FECHA_TRAMITE = LF_FECHA_TRAMITEIn;
          this.LF_TOTAL = LF_TOTALIn;
          this.LF_NOTA = LF_NOTAIn;
          this.LF_ID_USUARIO = LF_ID_USUARIOIn;
          this.LF_ID_ARQUEO = LF_ID_ARQUEOIn;
          this.LF_ID_USUARIOANULA = LF_ID_USUARIOANULAIn;
          this.LF_FECHAANULA = LF_FECHAANULAIn;
          this.LF_HORAANULA = LF_HORAANULAIn;
          this.LF_MOTIVOCANCELACION = LF_MOTIVOCANCELACIONIn;
          this.LF_FACTURAERROR = LF_FACTURAERRORIn;
          this.LF_NUMERO = LF_NUMEROIn;
          this.LF_DESCUENTO = LF_DESCUENTOIn;
          this.LF_NOTAADICIONAL = LF_NOTAADICIONALIn;
          this.LF_SIREVNUMERO = LF_SIREVNUMEROIn;
          this.LF_SIREVVALOR = LF_SIREVVALORIn;
          this.LF_IDRADICADO = LF_IDRADICADOIn;
          this.LF_IDDETCITA = LF_IDDETCITAIn;
          this.LF_NUMRUNT = LF_NUMRUNTIn;
          this.LF_IDSOLICRUNT = LF_IDSOLICRUNTIn;
          this.LF_FECHARADICARUNT = LF_FECHARADICARUNTIn;
          this.LF_IDSOLICITANTE = LF_IDSOLICITANTEIn;
          this.LF_EMPERSOL = LF_EMPERSOLIn;
          this.LF_IDAPODERADO = LF_IDAPODERADOIn;
          this.LF_TOTALFACTURARUNT = LF_TOTALFACTURARUNTIn;
          this.CARGADO = CARGADOIn;
    }


    /** 
     * hasEqualMapping-method will compare two Factura instances
     * and return true if they contain same values in all persistent instance 
     * variables. If hasEqualMapping returns true, it does not mean the objects
     * are the same instance. However it does mean that in that moment, they 
     * are mapped to the same row in database.
     */
    public boolean hasEqualMapping(Factura valueObject) {

          if (valueObject.getLF_ID() != this.LF_ID) {
                    return(false);
          }
          if (this.LF_TIPO == null) {
                    if (valueObject.getLF_TIPO() != null)
                           return(false);
          } else if (!this.LF_TIPO.equals(valueObject.getLF_TIPO())) {
                    return(false);
          }
          if (this.LF_V_ID == null) {
                    if (valueObject.getLF_V_ID() != null)
                           return(false);
          } else if (!this.LF_V_ID.equals(valueObject.getLF_V_ID())) {
                    return(false);
          }
          if (this.LF_ID_PERSONA == null) {
                    if (valueObject.getLF_ID_PERSONA() != null)
                           return(false);
          } else if (!this.LF_ID_PERSONA.equals(valueObject.getLF_ID_PERSONA())) {
                    return(false);
          }
          if (this.LF_ESTADO == null) {
                    if (valueObject.getLF_ESTADO() != null)
                           return(false);
          } else if (!this.LF_ESTADO.equals(valueObject.getLF_ESTADO())) {
                    return(false);
          }
          if (this.LF_FECHA == null) {
                    if (valueObject.getLF_FECHA() != null)
                           return(false);
          } else if (!this.LF_FECHA.equals(valueObject.getLF_FECHA())) {
                    return(false);
          }
          if (this.LF_FECHA_PAGO == null) {
                    if (valueObject.getLF_FECHA_PAGO() != null)
                           return(false);
          } else if (!this.LF_FECHA_PAGO.equals(valueObject.getLF_FECHA_PAGO())) {
                    return(false);
          }
          if (this.LF_FECHA_TRAMITE == null) {
                    if (valueObject.getLF_FECHA_TRAMITE() != null)
                           return(false);
          } else if (!this.LF_FECHA_TRAMITE.equals(valueObject.getLF_FECHA_TRAMITE())) {
                    return(false);
          }
          if (this.LF_TOTAL == null) {
                    if (valueObject.getLF_TOTAL() != null)
                           return(false);
          } else if (!this.LF_TOTAL.equals(valueObject.getLF_TOTAL())) {
                    return(false);
          }
          if (this.LF_NOTA == null) {
                    if (valueObject.getLF_NOTA() != null)
                           return(false);
          } else if (!this.LF_NOTA.equals(valueObject.getLF_NOTA())) {
                    return(false);
          }
          if (this.LF_ID_USUARIO == null) {
                    if (valueObject.getLF_ID_USUARIO() != null)
                           return(false);
          } else if (!this.LF_ID_USUARIO.equals(valueObject.getLF_ID_USUARIO())) {
                    return(false);
          }
          if (this.LF_ID_ARQUEO == null) {
                    if (valueObject.getLF_ID_ARQUEO() != null)
                           return(false);
          } else if (!this.LF_ID_ARQUEO.equals(valueObject.getLF_ID_ARQUEO())) {
                    return(false);
          }
          if (this.LF_ID_USUARIOANULA == null) {
                    if (valueObject.getLF_ID_USUARIOANULA() != null)
                           return(false);
          } else if (!this.LF_ID_USUARIOANULA.equals(valueObject.getLF_ID_USUARIOANULA())) {
                    return(false);
          }
          if (this.LF_FECHAANULA == null) {
                    if (valueObject.getLF_FECHAANULA() != null)
                           return(false);
          } else if (!this.LF_FECHAANULA.equals(valueObject.getLF_FECHAANULA())) {
                    return(false);
          }
          if (this.LF_HORAANULA == null) {
                    if (valueObject.getLF_HORAANULA() != null)
                           return(false);
          } else if (!this.LF_HORAANULA.equals(valueObject.getLF_HORAANULA())) {
                    return(false);
          }
          if (this.LF_MOTIVOCANCELACION == null) {
                    if (valueObject.getLF_MOTIVOCANCELACION() != null)
                           return(false);
          } else if (!this.LF_MOTIVOCANCELACION.equals(valueObject.getLF_MOTIVOCANCELACION())) {
                    return(false);
          }
          if (this.LF_FACTURAERROR == null) {
                    if (valueObject.getLF_FACTURAERROR() != null)
                           return(false);
          } else if (!this.LF_FACTURAERROR.equals(valueObject.getLF_FACTURAERROR())) {
                    return(false);
          }
          if (this.LF_NUMERO == null) {
                    if (valueObject.getLF_NUMERO() != null)
                           return(false);
          } else if (!this.LF_NUMERO.equals(valueObject.getLF_NUMERO())) {
                    return(false);
          }
          if (this.LF_DESCUENTO == null) {
                    if (valueObject.getLF_DESCUENTO() != null)
                           return(false);
          } else if (!this.LF_DESCUENTO.equals(valueObject.getLF_DESCUENTO())) {
                    return(false);
          }
          if (this.LF_NOTAADICIONAL == null) {
                    if (valueObject.getLF_NOTAADICIONAL() != null)
                           return(false);
          } else if (!this.LF_NOTAADICIONAL.equals(valueObject.getLF_NOTAADICIONAL())) {
                    return(false);
          }
          if (this.LF_SIREVNUMERO == null) {
                    if (valueObject.getLF_SIREVNUMERO() != null)
                           return(false);
          } else if (!this.LF_SIREVNUMERO.equals(valueObject.getLF_SIREVNUMERO())) {
                    return(false);
          }
          if (this.LF_SIREVVALOR == null) {
                    if (valueObject.getLF_SIREVVALOR() != null)
                           return(false);
          } else if (!this.LF_SIREVVALOR.equals(valueObject.getLF_SIREVVALOR())) {
                    return(false);
          }
          if (this.LF_IDRADICADO == null) {
                    if (valueObject.getLF_IDRADICADO() != null)
                           return(false);
          } else if (!this.LF_IDRADICADO.equals(valueObject.getLF_IDRADICADO())) {
                    return(false);
          }
          if (this.LF_IDDETCITA == null) {
                    if (valueObject.getLF_IDDETCITA() != null)
                           return(false);
          } else if (!this.LF_IDDETCITA.equals(valueObject.getLF_IDDETCITA())) {
                    return(false);
          }
          if (this.LF_NUMRUNT == null) {
                    if (valueObject.getLF_NUMRUNT() != null)
                           return(false);
          } else if (!this.LF_NUMRUNT.equals(valueObject.getLF_NUMRUNT())) {
                    return(false);
          }
          if (this.LF_IDSOLICRUNT == null) {
                    if (valueObject.getLF_IDSOLICRUNT() != null)
                           return(false);
          } else if (!this.LF_IDSOLICRUNT.equals(valueObject.getLF_IDSOLICRUNT())) {
                    return(false);
          }
          if (this.LF_FECHARADICARUNT == null) {
                    if (valueObject.getLF_FECHARADICARUNT() != null)
                           return(false);
          } else if (!this.LF_FECHARADICARUNT.equals(valueObject.getLF_FECHARADICARUNT())) {
                    return(false);
          }
          if (this.LF_IDSOLICITANTE == null) {
                    if (valueObject.getLF_IDSOLICITANTE() != null)
                           return(false);
          } else if (!this.LF_IDSOLICITANTE.equals(valueObject.getLF_IDSOLICITANTE())) {
                    return(false);
          }
          if (this.LF_EMPERSOL == null) {
                    if (valueObject.getLF_EMPERSOL() != null)
                           return(false);
          } else if (!this.LF_EMPERSOL.equals(valueObject.getLF_EMPERSOL())) {
                    return(false);
          }
          if (this.LF_IDAPODERADO == null) {
                    if (valueObject.getLF_IDAPODERADO() != null)
                           return(false);
          } else if (!this.LF_IDAPODERADO.equals(valueObject.getLF_IDAPODERADO())) {
                    return(false);
          }
          if (this.LF_TOTALFACTURARUNT == null) {
                    if (valueObject.getLF_TOTALFACTURARUNT() != null)
                           return(false);
          } else if (!this.LF_TOTALFACTURARUNT.equals(valueObject.getLF_TOTALFACTURARUNT())) {
                    return(false);
          }
          if (this.CARGADO == null) {
                    if (valueObject.getCARGADO() != null)
                           return(false);
          } else if (!this.CARGADO.equals(valueObject.getCARGADO())) {
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
        out.append("\nclass Factura, mapping to table L_FACTURAS\n");
        out.append("Persistent attributes: \n"); 
        out.append("LF_ID = " + this.LF_ID + "\n"); 
        out.append("LF_TIPO = " + this.LF_TIPO + "\n"); 
        out.append("LF_V_ID = " + this.LF_V_ID + "\n"); 
        out.append("LF_ID_PERSONA = " + this.LF_ID_PERSONA + "\n"); 
        out.append("LF_ESTADO = " + this.LF_ESTADO + "\n"); 
        out.append("LF_FECHA = " + this.LF_FECHA + "\n"); 
        out.append("LF_FECHA_PAGO = " + this.LF_FECHA_PAGO + "\n"); 
        out.append("LF_FECHA_TRAMITE = " + this.LF_FECHA_TRAMITE + "\n"); 
        out.append("LF_TOTAL = " + this.LF_TOTAL + "\n"); 
        out.append("LF_NOTA = " + this.LF_NOTA + "\n"); 
        out.append("LF_ID_USUARIO = " + this.LF_ID_USUARIO + "\n"); 
        out.append("LF_ID_ARQUEO = " + this.LF_ID_ARQUEO + "\n"); 
        out.append("LF_ID_USUARIOANULA = " + this.LF_ID_USUARIOANULA + "\n"); 
        out.append("LF_FECHAANULA = " + this.LF_FECHAANULA + "\n"); 
        out.append("LF_HORAANULA = " + this.LF_HORAANULA + "\n"); 
        out.append("LF_MOTIVOCANCELACION = " + this.LF_MOTIVOCANCELACION + "\n"); 
        out.append("LF_FACTURAERROR = " + this.LF_FACTURAERROR + "\n"); 
        out.append("LF_NUMERO = " + this.LF_NUMERO + "\n"); 
        out.append("LF_DESCUENTO = " + this.LF_DESCUENTO + "\n"); 
        out.append("LF_NOTAADICIONAL = " + this.LF_NOTAADICIONAL + "\n"); 
        out.append("LF_SIREVNUMERO = " + this.LF_SIREVNUMERO + "\n"); 
        out.append("LF_SIREVVALOR = " + this.LF_SIREVVALOR + "\n"); 
        out.append("LF_IDRADICADO = " + this.LF_IDRADICADO + "\n"); 
        out.append("LF_IDDETCITA = " + this.LF_IDDETCITA + "\n"); 
        out.append("LF_NUMRUNT = " + this.LF_NUMRUNT + "\n"); 
        out.append("LF_IDSOLICRUNT = " + this.LF_IDSOLICRUNT + "\n"); 
        out.append("LF_FECHARADICARUNT = " + this.LF_FECHARADICARUNT + "\n"); 
        out.append("LF_IDSOLICITANTE = " + this.LF_IDSOLICITANTE + "\n"); 
        out.append("LF_EMPERSOL = " + this.LF_EMPERSOL + "\n"); 
        out.append("LF_IDAPODERADO = " + this.LF_IDAPODERADO + "\n"); 
        out.append("LF_TOTALFACTURARUNT = " + this.LF_TOTALFACTURARUNT + "\n"); 
        out.append("CARGADO = " + this.CARGADO + "\n"); 
        return out.toString();
    }


    /**
     * Clone will return identical deep copy of this valueObject.
     * Note, that this method is different than the clone() which
     * is defined in java.lang.Object. Here, the retuned cloned object
     * will also have all its attributes cloned.
     */
    public Object clone() {
        Factura cloned = new Factura();

        cloned.setLF_ID(this.LF_ID); 
        if (this.LF_TIPO != null)
             cloned.setLF_TIPO(new String(this.LF_TIPO)); 
        if (this.LF_V_ID != null)
             cloned.setLF_V_ID(new String(this.LF_V_ID)); 
        if (this.LF_ID_PERSONA != null)
             cloned.setLF_ID_PERSONA(new String(this.LF_ID_PERSONA)); 
        if (this.LF_ESTADO != null)
             cloned.setLF_ESTADO(new String(this.LF_ESTADO)); 
        if (this.LF_FECHA != null)
             cloned.setLF_FECHA(new String(this.LF_FECHA)); 
        if (this.LF_FECHA_PAGO != null)
             cloned.setLF_FECHA_PAGO(new String(this.LF_FECHA_PAGO)); 
        if (this.LF_FECHA_TRAMITE != null)
             cloned.setLF_FECHA_TRAMITE(new String(this.LF_FECHA_TRAMITE)); 
        if (this.LF_TOTAL != null)
             cloned.setLF_TOTAL(new String(this.LF_TOTAL)); 
        if (this.LF_NOTA != null)
             cloned.setLF_NOTA(new String(this.LF_NOTA)); 
        if (this.LF_ID_USUARIO != null)
             cloned.setLF_ID_USUARIO(new String(this.LF_ID_USUARIO)); 
        if (this.LF_ID_ARQUEO != null)
             cloned.setLF_ID_ARQUEO(new String(this.LF_ID_ARQUEO)); 
        if (this.LF_ID_USUARIOANULA != null)
             cloned.setLF_ID_USUARIOANULA(new String(this.LF_ID_USUARIOANULA)); 
        if (this.LF_FECHAANULA != null)
             cloned.setLF_FECHAANULA(new String(this.LF_FECHAANULA)); 
        if (this.LF_HORAANULA != null)
             cloned.setLF_HORAANULA(new String(this.LF_HORAANULA)); 
        if (this.LF_MOTIVOCANCELACION != null)
             cloned.setLF_MOTIVOCANCELACION(new String(this.LF_MOTIVOCANCELACION)); 
        if (this.LF_FACTURAERROR != null)
             cloned.setLF_FACTURAERROR(new String(this.LF_FACTURAERROR)); 
        if (this.LF_NUMERO != null)
             cloned.setLF_NUMERO(new String(this.LF_NUMERO)); 
        if (this.LF_DESCUENTO != null)
             cloned.setLF_DESCUENTO(new String(this.LF_DESCUENTO)); 
        if (this.LF_NOTAADICIONAL != null)
             cloned.setLF_NOTAADICIONAL(new String(this.LF_NOTAADICIONAL)); 
        if (this.LF_SIREVNUMERO != null)
             cloned.setLF_SIREVNUMERO(new String(this.LF_SIREVNUMERO)); 
        if (this.LF_SIREVVALOR != null)
             cloned.setLF_SIREVVALOR(new String(this.LF_SIREVVALOR)); 
        if (this.LF_IDRADICADO != null)
             cloned.setLF_IDRADICADO(new String(this.LF_IDRADICADO)); 
        if (this.LF_IDDETCITA != null)
             cloned.setLF_IDDETCITA(new String(this.LF_IDDETCITA)); 
        if (this.LF_NUMRUNT != null)
             cloned.setLF_NUMRUNT(new String(this.LF_NUMRUNT)); 
        if (this.LF_IDSOLICRUNT != null)
             cloned.setLF_IDSOLICRUNT(new String(this.LF_IDSOLICRUNT)); 
        if (this.LF_FECHARADICARUNT != null)
             cloned.setLF_FECHARADICARUNT(new String(this.LF_FECHARADICARUNT)); 
        if (this.LF_IDSOLICITANTE != null)
             cloned.setLF_IDSOLICITANTE(new String(this.LF_IDSOLICITANTE)); 
        if (this.LF_EMPERSOL != null)
             cloned.setLF_EMPERSOL(new String(this.LF_EMPERSOL)); 
        if (this.LF_IDAPODERADO != null)
             cloned.setLF_IDAPODERADO(new String(this.LF_IDAPODERADO)); 
        if (this.LF_TOTALFACTURARUNT != null)
             cloned.setLF_TOTALFACTURARUNT(new String(this.LF_TOTALFACTURARUNT)); 
        if (this.CARGADO != null)
             cloned.setCARGADO(new String(this.CARGADO)); 
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

