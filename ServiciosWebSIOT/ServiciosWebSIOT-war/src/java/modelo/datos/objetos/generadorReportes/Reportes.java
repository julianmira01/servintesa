package modelo.datos.objetos.generadorReportes;

import java.io.Serializable;


public class Reportes implements Cloneable, Serializable {
	private int ID;
	private String TITULO;
	private String DIRECCION_RUTA;
	private int ID_TIPO_GRAFICO;
	private int ID_SENTENCIA;
	private int ID_ETIQUETAS_GRAFICO;
	private int ID_BASE_DATOS;

	public Reportes(){

	}

	public Reportes(int IDIn) {

		this.ID = IDIn; 
	}


	public int getID() {
		return this.ID;
	}

	public void  setID(int IDIn) {
		this.ID = IDIn;
	}

	public String getTITULO() {
		return this.TITULO;
	}

	public void  setTITULO(String TITULOIn) {
		this.TITULO = TITULOIn;
	}

	public String getDIRECCION_RUTA() {
		return this.DIRECCION_RUTA;
	}

	public void  setDIRECCION_RUTA(String DIRECCION_RUTAIn) {
		this.DIRECCION_RUTA = DIRECCION_RUTAIn;
	}

	public int getID_TIPO_GRAFICO() {
		return this.ID_TIPO_GRAFICO;
	}

	public void  setID_TIPO_GRAFICO(int ID_TIPO_GRAFICOIn) {
		this.ID_TIPO_GRAFICO = ID_TIPO_GRAFICOIn;
	}

	public int getID_SENTENCIA() {
		return this.ID_SENTENCIA;
	}

	public void  setID_SENTENCIA(int ID_SENTENCIAIn) {
		this.ID_SENTENCIA = ID_SENTENCIAIn;
	}

	public int getID_ETIQUETAS_GRAFICO() {
		return this.ID_ETIQUETAS_GRAFICO;
	}

	public void  setID_ETIQUETAS_GRAFICO(int ID_ETIQUETAS_GRAFICOIn) {
		this.ID_ETIQUETAS_GRAFICO = ID_ETIQUETAS_GRAFICOIn;
	}

	public int getID_BASE_DATOS() {
		return this.ID_BASE_DATOS;
	}

	public void  setID_BASE_DATOS(int ID_BASE_DATOSIn) {
		this.ID_BASE_DATOS = ID_BASE_DATOSIn;
	}
}
