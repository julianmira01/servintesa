package modelo.datos.objetos.generadorReportes;

import java.io.Serializable;


public class Motorbd implements Cloneable, Serializable {
	private int ID;
	private String DESCRIPCION;
	private String VERSION;
	private String TITULO;

	public Motorbd(){

	}

	public Motorbd(int IDIn) {

		this.ID = IDIn; 
	}


	public int getID() {
		return this.ID;
	}

	public void  setID(int IDIn) {
		this.ID = IDIn;
	}

	public String getDESCRIPCION() {
		return this.DESCRIPCION;
	}

	public void  setDESCRIPCION(String DESCRIPCIONIn) {
		this.DESCRIPCION = DESCRIPCIONIn;
	}

	public String getVERSION() {
		return this.VERSION;
	}

	public void  setVERSION(String VERSIONIn) {
		this.VERSION = VERSIONIn;
	}

	public String getTITULO() {
		return this.TITULO;
	}

	public void  setTITULO(String TITULOIn) {
		this.TITULO = TITULOIn;
	}
}
