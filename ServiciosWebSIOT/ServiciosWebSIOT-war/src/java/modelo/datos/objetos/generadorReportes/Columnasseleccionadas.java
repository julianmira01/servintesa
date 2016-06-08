package modelo.datos.objetos.generadorReportes;

import java.io.Serializable;


public class Columnasseleccionadas implements Cloneable, Serializable {
	private int ID;
	private String VALOR_CAMPO;
	private String NOMBRE;
	private int ID_REPORTES;
	private int ID_ETIQUETAS_GRAFICO;

	public Columnasseleccionadas(){

	}

	public Columnasseleccionadas(int IDIn) {

		this.ID = IDIn; 
	}


	public int getID() {
		return this.ID;
	}

	public void  setID(int IDIn) {
		this.ID = IDIn;
	}

	public String getVALOR_CAMPO() {
		return this.VALOR_CAMPO;
	}

	public void  setVALOR_CAMPO(String VALOR_CAMPOIn) {
		this.VALOR_CAMPO = VALOR_CAMPOIn;
	}

	public String getNOMBRE() {
		return this.NOMBRE;
	}

	public void  setNOMBRE(String NOMBREIn) {
		this.NOMBRE = NOMBREIn;
	}

	public int getID_REPORTES() {
		return this.ID_REPORTES;
	}

	public void  setID_REPORTES(int ID_REPORTESIn) {
		this.ID_REPORTES = ID_REPORTESIn;
	}

	public int getID_ETIQUETAS_GRAFICO() {
		return this.ID_ETIQUETAS_GRAFICO;
	}

	public void  setID_ETIQUETAS_GRAFICO(int ID_ETIQUETAS_GRAFICOIn) {
		this.ID_ETIQUETAS_GRAFICO = ID_ETIQUETAS_GRAFICOIn;
	}
}
