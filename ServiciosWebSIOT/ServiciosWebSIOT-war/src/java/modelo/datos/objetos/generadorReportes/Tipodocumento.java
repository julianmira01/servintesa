package modelo.datos.objetos.generadorReportes;

import java.io.Serializable;


public class Tipodocumento implements Cloneable, Serializable {
	private int ID;
	private String EXTENSION_ARCHIVO;
	private int CODIGO;
	private String TITULO;

	public Tipodocumento(){

	}

	public Tipodocumento(int IDIn) {

		this.ID = IDIn; 
	}


	public int getID() {
		return this.ID;
	}

	public void  setID(int IDIn) {
		this.ID = IDIn;
	}

	public String getEXTENSION_ARCHIVO() {
		return this.EXTENSION_ARCHIVO;
	}

	public void  setEXTENSION_ARCHIVO(String EXTENSION_ARCHIVOIn) {
		this.EXTENSION_ARCHIVO = EXTENSION_ARCHIVOIn;
	}

	public int getCODIGO() {
		return this.CODIGO;
	}

	public void  setCODIGO(int CODIGOIn) {
		this.CODIGO = CODIGOIn;
	}

	public String getTITULO() {
		return this.TITULO;
	}

	public void  setTITULO(String TITULOIn) {
		this.TITULO = TITULOIn;
	}
}
