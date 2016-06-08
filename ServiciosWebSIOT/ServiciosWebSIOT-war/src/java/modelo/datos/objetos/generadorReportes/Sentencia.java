package modelo.datos.objetos.generadorReportes;

import java.io.Serializable;


public class Sentencia implements Cloneable, Serializable {
	private int ID;
	private String CONTENIDO;
	private String TITULO;

	public Sentencia(){

	}

	public Sentencia(int IDIn) {

		this.ID = IDIn; 
	}


	public int getID() {
		return this.ID;
	}

	public void  setID(int IDIn) {
		this.ID = IDIn;
	}

	public String getCONTENIDO() {
		return this.CONTENIDO;
	}

	public void  setCONTENIDO(String CONTENIDOIn) {
		this.CONTENIDO = CONTENIDOIn;
	}

	public String getTITULO() {
		return this.TITULO;
	}

	public void  setTITULO(String TITULOIn) {
		this.TITULO = TITULOIn;
	}
}
