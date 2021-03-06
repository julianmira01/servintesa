package modelo.datos.objetos.comparendos.documentos.digitales;

import java.io.*;
import java.sql.*;
import java.util.*;
import java.math.*;

/**
  * IndiceComp Value Object.
  * This class is value object representing database table IndiceComp
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



public class IndiceComp implements Cloneable, Serializable {

    /** 
     * Persistent Instance variables. This data is directly 
     * mapped to the columns of database table.
     */
    private int ID_INDICE;
    private String COD_INDICE;
    private String DESC_INDICE;



    /** 
     * Constructors. DaoGen generates two constructors by default.
     * The first one takes no arguments and provides the most simple
     * way to create object instance. The another one takes one
     * argument, which is the primary key of the corresponding table.
     */

    public IndiceComp () {

    }

    public IndiceComp (int ID_INDICEIn) {

          this.ID_INDICE = ID_INDICEIn;

    }


    /** 
     * Get- and Set-methods for persistent variables. The default
     * behaviour does not make any checks against malformed data,
     * so these might require some manual additions.
     */

    public int getID_INDICE() {
          return this.ID_INDICE;
    }
    public void setID_INDICE(int ID_INDICEIn) {
          this.ID_INDICE = ID_INDICEIn;
    }

    public String getCOD_INDICE() {
          return this.COD_INDICE;
    }
    public void setCOD_INDICE(String COD_INDICEIn) {
          this.COD_INDICE = COD_INDICEIn;
    }

    public String getDESC_INDICE() {
          return this.DESC_INDICE;
    }
    public void setDESC_INDICE(String DESC_INDICEIn) {
          this.DESC_INDICE = DESC_INDICEIn;
    }



    /** 
     * setAll allows to set all persistent variables in one method call.
     * This is useful, when all data is available and it is needed to 
     * set the initial state of this object. Note that this method will
     * directly modify instance variales, without going trough the 
     * individual set-methods.
     */

    public void setAll(int ID_INDICEIn,
          String COD_INDICEIn,
          String DESC_INDICEIn) {
          this.ID_INDICE = ID_INDICEIn;
          this.COD_INDICE = COD_INDICEIn;
          this.DESC_INDICE = DESC_INDICEIn;
    }


    /** 
     * hasEqualMapping-method will compare two IndiceComp instances
     * and return true if they contain same values in all persistent instance 
     * variables. If hasEqualMapping returns true, it does not mean the objects
     * are the same instance. However it does mean that in that moment, they 
     * are mapped to the same row in database.
     */
    public boolean hasEqualMapping(IndiceComp valueObject) {

          if (valueObject.getID_INDICE() != this.ID_INDICE) {
                    return(false);
          }
          if (this.COD_INDICE == null) {
                    if (valueObject.getCOD_INDICE() != null)
                           return(false);
          } else if (!this.COD_INDICE.equals(valueObject.getCOD_INDICE())) {
                    return(false);
          }
          if (this.DESC_INDICE == null) {
                    if (valueObject.getDESC_INDICE() != null)
                           return(false);
          } else if (!this.DESC_INDICE.equals(valueObject.getDESC_INDICE())) {
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
        out.append("\nclass IndiceComp, mapping to table IndiceComp\n");
        out.append("Persistent attributes: \n"); 
        out.append("ID_INDICE = " + this.ID_INDICE + "\n"); 
        out.append("COD_INDICE = " + this.COD_INDICE + "\n"); 
        out.append("DESC_INDICE = " + this.DESC_INDICE + "\n"); 
        return out.toString();
    }


    /**
     * Clone will return identical deep copy of this valueObject.
     * Note, that this method is different than the clone() which
     * is defined in java.lang.Object. Here, the retuned cloned object
     * will also have all its attributes cloned.
     */
    public Object clone() {
        IndiceComp cloned = new IndiceComp();

        cloned.setID_INDICE(this.ID_INDICE); 
        if (this.COD_INDICE != null)
             cloned.setCOD_INDICE(new String(this.COD_INDICE)); 
        if (this.DESC_INDICE != null)
             cloned.setDESC_INDICE(new String(this.DESC_INDICE)); 
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
