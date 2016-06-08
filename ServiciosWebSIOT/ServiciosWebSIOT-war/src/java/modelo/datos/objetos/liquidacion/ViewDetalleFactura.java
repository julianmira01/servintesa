package modelo.datos.objetos.liquidacion;

import java.io.*;
import java.sql.*;
import java.util.*;
import java.math.*;

 /**
  * ViewDetalleFactura Value Object.
  * This class is value object representing database table ViewDetalleFactura
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



public class ViewDetalleFactura implements Cloneable, Serializable {

    /** 
     * Persistent Instance variables. This data is directly 
     * mapped to the columns of database table.
     */
    private int LFD_ID;
    private int LF_ID;
    private String LF_NUMERO;
    private int LT_ID;
    private String LT_NOMBRE;
    private String LCC_NOMBRE;
    private int LT_VIGENCIA;
    private String LT_IDTARIFAAPLICA_CARRO;
    private String LT_IDTARIFAAPLICA_MOTO;
    private int LFD_VALOR;
    private int CODTRAMITE;



    /** 
     * Constructors. DaoGen generates two constructors by default.
     * The first one takes no arguments and provides the most simple
     * way to create object instance. The another one takes one
     * argument, which is the primary key of the corresponding table.
     */

    public ViewDetalleFactura () {

    }

    public ViewDetalleFactura (int LFD_IDIn) {

          this.LFD_ID = LFD_IDIn;

    }


    /** 
     * Get- and Set-methods for persistent variables. The default
     * behaviour does not make any checks against malformed data,
     * so these might require some manual additions.
     */

    public int getLFD_ID() {
          return this.LFD_ID;
    }
    public void setLFD_ID(int LFD_IDIn) {
          this.LFD_ID = LFD_IDIn;
    }

    public int getLF_ID() {
          return this.LF_ID;
    }
    public void setLF_ID(int LF_IDIn) {
          this.LF_ID = LF_IDIn;
    }

    public String getLF_NUMERO() {
          return this.LF_NUMERO;
    }
    public void setLF_NUMERO(String LF_NUMEROIn) {
          this.LF_NUMERO = LF_NUMEROIn;
    }

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

    public String getLCC_NOMBRE() {
          return this.LCC_NOMBRE;
    }
    public void setLCC_NOMBRE(String LCC_NOMBREIn) {
          this.LCC_NOMBRE = LCC_NOMBREIn;
    }

    public int getLT_VIGENCIA() {
          return this.LT_VIGENCIA;
    }
    public void setLT_VIGENCIA(int LT_VIGENCIAIn) {
          this.LT_VIGENCIA = LT_VIGENCIAIn;
    }

    public String getLT_IDTARIFAAPLICA_CARRO() {
          return this.LT_IDTARIFAAPLICA_CARRO;
    }
    public void setLT_IDTARIFAAPLICA_CARRO(String LT_IDTARIFAAPLICA_CARROIn) {
          this.LT_IDTARIFAAPLICA_CARRO = LT_IDTARIFAAPLICA_CARROIn;
    }

    public String getLT_IDTARIFAAPLICA_MOTO() {
          return this.LT_IDTARIFAAPLICA_MOTO;
    }
    public void setLT_IDTARIFAAPLICA_MOTO(String LT_IDTARIFAAPLICA_MOTOIn) {
          this.LT_IDTARIFAAPLICA_MOTO = LT_IDTARIFAAPLICA_MOTOIn;
    }

    public int getLFD_VALOR() {
          return this.LFD_VALOR;
    }
    public void setLFD_VALOR(int LFD_VALORIn) {
          this.LFD_VALOR = LFD_VALORIn;
    }

    public int getCODTRAMITE() {
          return this.CODTRAMITE;
    }
    public void setCODTRAMITE(int CODTRAMITEIn) {
          this.CODTRAMITE = CODTRAMITEIn;
    }



    /** 
     * setAll allows to set all persistent variables in one method call.
     * This is useful, when all data is available and it is needed to 
     * set the initial state of this object. Note that this method will
     * directly modify instance variales, without going trough the 
     * individual set-methods.
     */

    public void setAll(int LFD_IDIn,
          int LF_IDIn,
          String LF_NUMEROIn,
          int LT_IDIn,
          String LT_NOMBREIn,
          String LCC_NOMBREIn,
          int LT_VIGENCIAIn,
          String LT_IDTARIFAAPLICA_CARROIn,
          String LT_IDTARIFAAPLICA_MOTOIn,
          int LFD_VALORIn,
          int CODTRAMITEIn) {
          this.LFD_ID = LFD_IDIn;
          this.LF_ID = LF_IDIn;
          this.LF_NUMERO = LF_NUMEROIn;
          this.LT_ID = LT_IDIn;
          this.LT_NOMBRE = LT_NOMBREIn;
          this.LCC_NOMBRE = LCC_NOMBREIn;
          this.LT_VIGENCIA = LT_VIGENCIAIn;
          this.LT_IDTARIFAAPLICA_CARRO = LT_IDTARIFAAPLICA_CARROIn;
          this.LT_IDTARIFAAPLICA_MOTO = LT_IDTARIFAAPLICA_MOTOIn;
          this.LFD_VALOR = LFD_VALORIn;
          this.CODTRAMITE = CODTRAMITEIn;
    }


    /** 
     * hasEqualMapping-method will compare two ViewDetalleFactura instances
     * and return true if they contain same values in all persistent instance 
     * variables. If hasEqualMapping returns true, it does not mean the objects
     * are the same instance. However it does mean that in that moment, they 
     * are mapped to the same row in database.
     */
    public boolean hasEqualMapping(ViewDetalleFactura valueObject) {

          if (valueObject.getLFD_ID() != this.LFD_ID) {
                    return(false);
          }
          if (valueObject.getLF_ID() != this.LF_ID) {
                    return(false);
          }
          if (this.LF_NUMERO == null) {
                    if (valueObject.getLF_NUMERO() != null)
                           return(false);
          } else if (!this.LF_NUMERO.equals(valueObject.getLF_NUMERO())) {
                    return(false);
          }
          if (valueObject.getLT_ID() != this.LT_ID) {
                    return(false);
          }
          if (this.LT_NOMBRE == null) {
                    if (valueObject.getLT_NOMBRE() != null)
                           return(false);
          } else if (!this.LT_NOMBRE.equals(valueObject.getLT_NOMBRE())) {
                    return(false);
          }
          if (this.LCC_NOMBRE == null) {
                    if (valueObject.getLCC_NOMBRE() != null)
                           return(false);
          } else if (!this.LCC_NOMBRE.equals(valueObject.getLCC_NOMBRE())) {
                    return(false);
          }
          if (valueObject.getLT_VIGENCIA() != this.LT_VIGENCIA) {
                    return(false);
          }
          if (this.LT_IDTARIFAAPLICA_CARRO == null) {
                    if (valueObject.getLT_IDTARIFAAPLICA_CARRO() != null)
                           return(false);
          } else if (!this.LT_IDTARIFAAPLICA_CARRO.equals(valueObject.getLT_IDTARIFAAPLICA_CARRO())) {
                    return(false);
          }
          if (this.LT_IDTARIFAAPLICA_MOTO == null) {
                    if (valueObject.getLT_IDTARIFAAPLICA_MOTO() != null)
                           return(false);
          } else if (!this.LT_IDTARIFAAPLICA_MOTO.equals(valueObject.getLT_IDTARIFAAPLICA_MOTO())) {
                    return(false);
          }
          if (valueObject.getLFD_VALOR() != this.LFD_VALOR) {
                    return(false);
          }
          if (valueObject.getCODTRAMITE() != this.CODTRAMITE) {
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
        out.append("\nclass ViewDetalleFactura, mapping to table ViewDetalleFactura\n");
        out.append("Persistent attributes: \n"); 
        out.append("LFD_ID = " + this.LFD_ID + "\n"); 
        out.append("LF_ID = " + this.LF_ID + "\n"); 
        out.append("LF_NUMERO = " + this.LF_NUMERO + "\n"); 
        out.append("LT_ID = " + this.LT_ID + "\n"); 
        out.append("LT_NOMBRE = " + this.LT_NOMBRE + "\n"); 
        out.append("LCC_NOMBRE = " + this.LCC_NOMBRE + "\n"); 
        out.append("LT_VIGENCIA = " + this.LT_VIGENCIA + "\n"); 
        out.append("LT_IDTARIFAAPLICA_CARRO = " + this.LT_IDTARIFAAPLICA_CARRO + "\n"); 
        out.append("LT_IDTARIFAAPLICA_MOTO = " + this.LT_IDTARIFAAPLICA_MOTO + "\n"); 
        out.append("LFD_VALOR = " + this.LFD_VALOR + "\n"); 
        out.append("CODTRAMITE = " + this.CODTRAMITE + "\n"); 
        return out.toString();
    }


    /**
     * Clone will return identical deep copy of this valueObject.
     * Note, that this method is different than the clone() which
     * is defined in java.lang.Object. Here, the retuned cloned object
     * will also have all its attributes cloned.
     */
    public Object clone() {
        ViewDetalleFactura cloned = new ViewDetalleFactura();

        cloned.setLFD_ID(this.LFD_ID); 
        cloned.setLF_ID(this.LF_ID); 
        if (this.LF_NUMERO != null)
             cloned.setLF_NUMERO(new String(this.LF_NUMERO)); 
        cloned.setLT_ID(this.LT_ID); 
        if (this.LT_NOMBRE != null)
             cloned.setLT_NOMBRE(new String(this.LT_NOMBRE)); 
        if (this.LCC_NOMBRE != null)
             cloned.setLCC_NOMBRE(new String(this.LCC_NOMBRE)); 
        cloned.setLT_VIGENCIA(this.LT_VIGENCIA); 
        if (this.LT_IDTARIFAAPLICA_CARRO != null)
             cloned.setLT_IDTARIFAAPLICA_CARRO(new String(this.LT_IDTARIFAAPLICA_CARRO)); 
        if (this.LT_IDTARIFAAPLICA_MOTO != null)
             cloned.setLT_IDTARIFAAPLICA_MOTO(new String(this.LT_IDTARIFAAPLICA_MOTO)); 
        cloned.setLFD_VALOR(this.LFD_VALOR); 
        cloned.setCODTRAMITE(this.CODTRAMITE); 
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

