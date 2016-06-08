package modelo.datos.objetos.comparendos.liquidacion.detallerecibo;
import java.io.*;

public class Detallerecibo implements Cloneable, Serializable {
	 private int ID_DETALLE_RECIBO;
	 private int ID_RECIBO;
	 private int ID_COMPARENDO;
	 private String NUMEROCOMPARENDO;
	 private String VALOR;
	 private String NUM_RESOLUCION;

	public Detallerecibo(){

	}

	public Detallerecibo(int ID_DETALLE_RECIBOIn) {

		this.ID_DETALLE_RECIBO = ID_DETALLE_RECIBOIn; 
	}


	public int getID_DETALLE_RECIBO() {
		return this.ID_DETALLE_RECIBO;
	}

	public void  setID_DETALLE_RECIBO(int ID_DETALLE_RECIBOIn) {
		this.ID_DETALLE_RECIBO = ID_DETALLE_RECIBOIn;
	}

	public int getID_RECIBO() {
		return this.ID_RECIBO;
	}

	public void  setID_RECIBO(int ID_RECIBOIn) {
		this.ID_RECIBO = ID_RECIBOIn;
	}

	public int getID_COMPARENDO() {
		return this.ID_COMPARENDO;
	}

	public void  setID_COMPARENDO(int ID_COMPARENDOIn) {
		this.ID_COMPARENDO = ID_COMPARENDOIn;
	}

	public String getNUMEROCOMPARENDO() {
		return this.NUMEROCOMPARENDO;
	}

	public void  setNUMEROCOMPARENDO(String NUMEROCOMPARENDOIn) {
		this.NUMEROCOMPARENDO = NUMEROCOMPARENDOIn;
	}

	public String getVALOR() {
		return this.VALOR;
	}

	public void  setVALOR(String VALORIn) {
		this.VALOR = VALORIn;
	}

	public String getNUM_RESOLUCION() {
		return this.NUM_RESOLUCION;
	}

	public void  setNUM_RESOLUCION(String NUM_RESOLUCIONIn) {
		this.NUM_RESOLUCION = NUM_RESOLUCIONIn;
	}

	public String toString() {
		StringBuffer out = new StringBuffer();
		out.append("ID_DETALLE_RECIBO: "+this.ID_DETALLE_RECIBO);
		out.append("ID_RECIBO: "+this.ID_RECIBO);
		out.append("ID_COMPARENDO: "+this.ID_COMPARENDO);
		out.append("NUMEROCOMPARENDO: "+this.NUMEROCOMPARENDO);
		out.append("VALOR: "+this.VALOR);
		out.append("NUM_RESOLUCION: "+this.NUM_RESOLUCION);
		return out.toString();
	}
}
