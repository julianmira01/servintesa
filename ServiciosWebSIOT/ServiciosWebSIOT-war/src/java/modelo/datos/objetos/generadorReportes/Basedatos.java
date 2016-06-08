package modelo.datos.objetos.generadorReportes;

import java.io.Serializable;


public class Basedatos implements Cloneable, Serializable {
	private int ID;
	private String DESCRIPCION;
	private String TITULO;
	private int ID_CONFIGURACION_DB;

	public Basedatos(){

	}

	public Basedatos(int IDIn) {

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

	public int getID_CONFIGURACION_DB() {
		return this.ID_CONFIGURACION_DB;
	}

	public void  setID_CONFIGURACION_DB(int ID_CONFIGURACION_DBIn) {
		this.ID_CONFIGURACION_DB = ID_CONFIGURACION_DBIn;
	}
}
