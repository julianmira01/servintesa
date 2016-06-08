package modelo.datos.objetos.comparendos.coactivo;

import java.io.*;

public class Tipodoccobro implements Cloneable, Serializable {
	 private int ID_TIPODOC_COBRO;
	 private String DESCRIPCION;

	public Tipodoccobro(){

	}

	public Tipodoccobro(int ID_TIPODOC_COBROIn) {

		this.ID_TIPODOC_COBRO = ID_TIPODOC_COBROIn; 
	}


	public int getID_TIPODOC_COBRO() {
		return this.ID_TIPODOC_COBRO;
	}

	public void  setID_TIPODOC_COBRO(int ID_TIPODOC_COBROIn) {
		this.ID_TIPODOC_COBRO = ID_TIPODOC_COBROIn;
	}

	public String getDESCRIPCION() {
		return this.DESCRIPCION;
	}

	public void  setDESCRIPCION(String DESCRIPCIONIn) {
		this.DESCRIPCION = DESCRIPCIONIn;
	}

	public String toString() {
		StringBuffer out = new StringBuffer();
		out.append("ID_TIPODOC_COBRO: "+this.ID_TIPODOC_COBRO);
		out.append("DESCRIPCION: "+this.DESCRIPCION);
		return out.toString();
	}
}
