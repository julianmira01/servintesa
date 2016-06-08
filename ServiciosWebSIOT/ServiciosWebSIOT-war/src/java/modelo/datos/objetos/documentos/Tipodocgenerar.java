package modelo.datos.objetos.documentos;

import java.io.*;

public class Tipodocgenerar implements Cloneable, Serializable {
	 private int ID_TIPODOCGENERAR;
	 private String DES_TIPODOCGENERAR;
         private String PREFIJO;

	public Tipodocgenerar(){

	}

	public Tipodocgenerar(int ID_TIPODOCGENERARIn) {

		this.ID_TIPODOCGENERAR = ID_TIPODOCGENERARIn; 
	}


	public int getID_TIPODOCGENERAR() {
		return this.ID_TIPODOCGENERAR;
	}

	public void  setID_TIPODOCGENERAR(int ID_TIPODOCGENERARIn) {
		this.ID_TIPODOCGENERAR = ID_TIPODOCGENERARIn;
	}

	public String getDES_TIPODOCGENERAR() {
		return this.DES_TIPODOCGENERAR;
	}

	public void  setDES_TIPODOCGENERAR(String DES_TIPODOCGENERARIn) {
		this.DES_TIPODOCGENERAR = DES_TIPODOCGENERARIn;
	}

	public String toString() {
		StringBuffer out = new StringBuffer();
		out.append("ID_TIPODOCGENERAR: "+this.ID_TIPODOCGENERAR);
		out.append("DES_TIPODOCGENERAR: "+this.DES_TIPODOCGENERAR);
		return out.toString();
	}

    public String getPREFIJO() {
        return PREFIJO;
    }

    public void setPREFIJO(String PREFIJO) {
        this.PREFIJO = PREFIJO;
    }
}
