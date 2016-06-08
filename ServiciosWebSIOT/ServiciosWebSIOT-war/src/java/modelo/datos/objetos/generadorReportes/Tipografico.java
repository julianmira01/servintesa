package modelo.datos.objetos.generadorReportes;

import java.io.Serializable;


public class Tipografico implements Cloneable, Serializable {
	private int ID;
	private String DESCRIPCION;
	private String TITULO;
	private String RUTA_IMAGEN;

	public Tipografico(){

	}

	public Tipografico(int IDIn) {

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

	public String getTITULO() {
		return this.TITULO;
	}

	public void  setTITULO(String TITULOIn) {
		this.TITULO = TITULOIn;
	}

	public String getRUTA_IMAGEN() {
		return this.RUTA_IMAGEN;
	}

	public void  setRUTA_IMAGEN(String RUTA_IMAGENIn) {
		this.RUTA_IMAGEN = RUTA_IMAGENIn;
	}
}
