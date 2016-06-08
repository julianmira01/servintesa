package modelo.datos.objetos.generadorReportes;

import java.io.Serializable;


public class Etiquetasgrafico implements Cloneable, Serializable {
	private int ID;
	private String CAMPO_X;
	private String CAMPO_Y;

	public Etiquetasgrafico(){

	}

	public Etiquetasgrafico(int IDIn) {

		this.ID = IDIn; 
	}


	public int getID() {
		return this.ID;
	}

	public void  setID(int IDIn) {
		this.ID = IDIn;
	}

	public String getCAMPO_X() {
		return this.CAMPO_X;
	}

	public void  setCAMPO_X(String CAMPO_XIn) {
		this.CAMPO_X = CAMPO_XIn;
	}

	public String getCAMPO_Y() {
		return this.CAMPO_Y;
	}

	public void  setCAMPO_Y(String CAMPO_YIn) {
		this.CAMPO_Y = CAMPO_YIn;
	}
}
