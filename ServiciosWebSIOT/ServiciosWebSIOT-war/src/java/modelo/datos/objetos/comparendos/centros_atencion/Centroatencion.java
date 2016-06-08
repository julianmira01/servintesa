package modelo.datos.objetos.comparendos.centros_atencion;
import java.io.*;

public class Centroatencion implements Cloneable, Serializable {
	 private int ID_CENTRO;
	 private String NOMBRE_CENTRO;

	public Centroatencion(){

	}

	public Centroatencion(int ID_CENTROIn) {

		this.ID_CENTRO = ID_CENTROIn; 
	}


	public int getID_CENTRO() {
		return this.ID_CENTRO;
	}

	public void  setID_CENTRO(int ID_CENTROIn) {
		this.ID_CENTRO = ID_CENTROIn;
	}

	public String getNOMBRE_CENTRO() {
		return this.NOMBRE_CENTRO;
	}

	public void  setNOMBRE_CENTRO(String NOMBRE_CENTROIn) {
		this.NOMBRE_CENTRO = NOMBRE_CENTROIn;
	}

	public String toString() {
		StringBuffer out = new StringBuffer();
		out.append("ID_CENTRO: "+this.ID_CENTRO);
		out.append("NOMBRE_CENTRO: "+this.NOMBRE_CENTRO);
		return out.toString();
	}
}
