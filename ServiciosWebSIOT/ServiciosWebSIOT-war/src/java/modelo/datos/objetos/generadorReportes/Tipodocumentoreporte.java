package modelo.datos.objetos.generadorReportes;

import java.io.Serializable;


public class Tipodocumentoreporte implements Cloneable, Serializable {
	private int ID;
	private int ID_REPORTES;
	private int ID_TIPO_DOCUMENTO;

	public Tipodocumentoreporte(){

	}

	public Tipodocumentoreporte(int IDIn) {

		this.ID = IDIn; 
	}


	public int getID() {
		return this.ID;
	}

	public void  setID(int IDIn) {
		this.ID = IDIn;
	}

	public int getID_REPORTES() {
		return this.ID_REPORTES;
	}

	public void  setID_REPORTES(int ID_REPORTESIn) {
		this.ID_REPORTES = ID_REPORTESIn;
	}

	public int getID_TIPO_DOCUMENTO() {
		return this.ID_TIPO_DOCUMENTO;
	}

	public void  setID_TIPO_DOCUMENTO(int ID_TIPO_DOCUMENTOIn) {
		this.ID_TIPO_DOCUMENTO = ID_TIPO_DOCUMENTOIn;
	}
}
