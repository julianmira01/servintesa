package modelo.datos.objetos.distribucionRecursos;
import java.io.*;

public class Distribuciondinerodetalle implements Cloneable, Serializable {
	 private int ID;
	 private int IDLIQUIDACION;
	 private int IDINFRACCION;
	 private int IDELEMENTO;
	 private double VALOR;
	 private int ID_RECIBOCOMP;

	public Distribuciondinerodetalle(){

	}

	public Distribuciondinerodetalle(int IDIn) {

		this.ID = IDIn; 
	}


	public int getID() {
		return this.ID;
	}

	public void  setID(int IDIn) {
		this.ID = IDIn;
	}

	public int getIDLIQUIDACION() {
		return this.IDLIQUIDACION;
	}

	public void  setIDLIQUIDACION(int IDLIQUIDACIONIn) {
		this.IDLIQUIDACION = IDLIQUIDACIONIn;
	}

	public int getIDINFRACCION() {
		return this.IDINFRACCION;
	}

	public void  setIDINFRACCION(int IDINFRACCIONIn) {
		this.IDINFRACCION = IDINFRACCIONIn;
	}

	public int getIDELEMENTO() {
		return this.IDELEMENTO;
	}

	public void  setIDELEMENTO(int IDELEMENTOIn) {
		this.IDELEMENTO = IDELEMENTOIn;
	}

	public double getVALOR() {
		return this.VALOR;
	}

	public void  setVALOR(double VALORIn) {
		this.VALOR = VALORIn;
	}

	public int getID_RECIBOCOMP() {
		return this.ID_RECIBOCOMP;
	}

	public void  setID_RECIBOCOMP(int ID_RECIBOCOMPIn) {
		this.ID_RECIBOCOMP = ID_RECIBOCOMPIn;
	}

	public String toString() {
		StringBuffer out = new StringBuffer();
		out.append("ID: "+this.ID);
		out.append("IDLIQUIDACION: "+this.IDLIQUIDACION);
		out.append("IDINFRACCION: "+this.IDINFRACCION);
		out.append("IDELEMENTO: "+this.IDELEMENTO);
		out.append("VALOR: "+this.VALOR);
		out.append("ID_RECIBOCOMP: "+this.ID_RECIBOCOMP);
		return out.toString();
	}
}
