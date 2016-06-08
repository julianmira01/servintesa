package modelo.datos.objetos.distribucionRecursos;
import java.io.*;

public class Elementodistribucionrecurso implements Cloneable, Serializable {
	 private int ID_ELEMENTO;
	 private String COD_ELEMENTO;
	 private String NOMBREELEMENTO;
	 private String LIQUIDAR_PORCOMPARENDO;

	public Elementodistribucionrecurso(){

	}

	public Elementodistribucionrecurso(int ID_ELEMENTOIn) {

		this.ID_ELEMENTO = ID_ELEMENTOIn; 
	}


	public int getID_ELEMENTO() {
		return this.ID_ELEMENTO;
	}

	public void  setID_ELEMENTO(int ID_ELEMENTOIn) {
		this.ID_ELEMENTO = ID_ELEMENTOIn;
	}

	public String getCOD_ELEMENTO() {
		return this.COD_ELEMENTO;
	}

	public void  setCOD_ELEMENTO(String COD_ELEMENTOIn) {
		this.COD_ELEMENTO = COD_ELEMENTOIn;
	}

	public String getNOMBREELEMENTO() {
		return this.NOMBREELEMENTO;
	}

	public void  setNOMBREELEMENTO(String NOMBREELEMENTOIn) {
		this.NOMBREELEMENTO = NOMBREELEMENTOIn;
	}

	public String getLIQUIDAR_PORCOMPARENDO() {
		return this.LIQUIDAR_PORCOMPARENDO;
	}

	public void  setLIQUIDAR_PORCOMPARENDO(String LIQUIDAR_PORCOMPARENDOIn) {
		this.LIQUIDAR_PORCOMPARENDO = LIQUIDAR_PORCOMPARENDOIn;
	}

	public String toString() {
		StringBuffer out = new StringBuffer();
		out.append("ID_ELEMENTO: "+this.ID_ELEMENTO);
		out.append("COD_ELEMENTO: "+this.COD_ELEMENTO);
		out.append("NOMBREELEMENTO: "+this.NOMBREELEMENTO);
		out.append("LIQUIDAR_PORCOMPARENDO: "+this.LIQUIDAR_PORCOMPARENDO);
		return out.toString();
	}
}
