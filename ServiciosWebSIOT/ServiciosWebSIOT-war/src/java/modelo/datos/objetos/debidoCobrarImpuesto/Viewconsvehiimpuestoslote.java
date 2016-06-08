package modelo.datos.objetos.debidoCobrarImpuesto;
import java.io.*;

public class Viewconsvehiimpuestoslote implements Cloneable, Serializable {
	 private int ID;
	 private String PLACA;
	 private int VIGENCIA;
	 private String GRUPO_LIQUIDACION;
	 private String CILINDRAJE;

	public Viewconsvehiimpuestoslote(){

	}

	public Viewconsvehiimpuestoslote(int IDIn) {

		this.ID = IDIn; 
	}


	public int getID() {
		return this.ID;
	}

	public void  setID(int IDIn) {
		this.ID = IDIn;
	}

	public String getPLACA() {
		return this.PLACA;
	}

	public void  setPLACA(String PLACAIn) {
		this.PLACA = PLACAIn;
	}

	public int getVIGENCIA() {
		return this.VIGENCIA;
	}

	public void  setVIGENCIA(int VIGENCIAIn) {
		this.VIGENCIA = VIGENCIAIn;
	}

	public String getGRUPO_LIQUIDACION() {
		return this.GRUPO_LIQUIDACION;
	}

	public void  setGRUPO_LIQUIDACION(String GRUPO_LIQUIDACIONIn) {
		this.GRUPO_LIQUIDACION = GRUPO_LIQUIDACIONIn;
	}

	public String getCILINDRAJE() {
		return this.CILINDRAJE;
	}

	public void  setCILINDRAJE(String CILINDRAJEIn) {
		this.CILINDRAJE = CILINDRAJEIn;
	}

	public String toString() {
		StringBuffer out = new StringBuffer();
		out.append("ID: "+this.ID);
		out.append("PLACA: "+this.PLACA);
		out.append("VIGENCIA: "+this.VIGENCIA);
		out.append("GRUPO_LIQUIDACION: "+this.GRUPO_LIQUIDACION);
		out.append("CILINDRAJE: "+this.CILINDRAJE);
		return out.toString();
	}
}
