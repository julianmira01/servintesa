package modelo.datos.objetos.Tiporodaje;

import java.io.*;

public class Tiporodaje implements Cloneable, Serializable {
	 private int ID;
	 private String TIPO;

	public Tiporodaje(){

	}

	public Tiporodaje(int IDIn) {

		this.ID = IDIn; 
	}


	public int getID() {
		return this.ID;
	}

	public void  setID(int IDIn) {
		this.ID = IDIn;
	}

	public String getTIPO() {
		return this.TIPO;
	}

	public void  setTIPO(String TIPOIn) {
		this.TIPO = TIPOIn;
	}

	public String toString() {
		StringBuffer out = new StringBuffer();
		out.append("ID: "+this.ID);
		out.append("TIPO: "+this.TIPO);
		return out.toString();
	}
}
