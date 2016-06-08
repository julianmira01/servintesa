package modelo.datos.objetos.comparendos.generales;

import java.io.*;

public class Viewcompingresados implements Cloneable, Serializable {
	 private int ID_COMPARENDO;
	 private String NUMEROCOMPARENDO;
	 private String PLACA;
	 private int ID_INFRACTOR;
	 private String NOMBRES;
	 private String APELLIDOS;
	 private String FECHACOMPARENDO;
	 private int ID_AGENTE;
	 private String PLACAAGENTE;
	 private String NOMBRES_AGENTE;
	 private String APELL1;

	public Viewcompingresados(){

	}

	public Viewcompingresados(int ID_COMPARENDOIn) {

		this.ID_COMPARENDO = ID_COMPARENDOIn; 
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

	public String getPLACA() {
		return this.PLACA;
	}

	public void  setPLACA(String PLACAIn) {
		this.PLACA = PLACAIn;
	}

	public int getID_INFRACTOR() {
		return this.ID_INFRACTOR;
	}

	public void  setID_INFRACTOR(int ID_INFRACTORIn) {
		this.ID_INFRACTOR = ID_INFRACTORIn;
	}

	public String getNOMBRES() {
		return this.NOMBRES;
	}

	public void  setNOMBRES(String NOMBRESIn) {
		this.NOMBRES = NOMBRESIn;
	}

	public String getAPELLIDOS() {
		return this.APELLIDOS;
	}

	public void  setAPELLIDOS(String APELLIDOSIn) {
		this.APELLIDOS = APELLIDOSIn;
	}

	public String getFECHACOMPARENDO() {
		return this.FECHACOMPARENDO;
	}

	public void  setFECHACOMPARENDO(String FECHACOMPARENDOIn) {
		this.FECHACOMPARENDO = FECHACOMPARENDOIn;
	}

	public int getID_AGENTE() {
		return this.ID_AGENTE;
	}

	public void  setID_AGENTE(int ID_AGENTEIn) {
		this.ID_AGENTE = ID_AGENTEIn;
	}

	public String getPLACAAGENTE() {
		return this.PLACAAGENTE;
	}

	public void  setPLACAAGENTE(String PLACAAGENTEIn) {
		this.PLACAAGENTE = PLACAAGENTEIn;
	}

	public String getNOMBRES_AGENTE() {
		return this.NOMBRES_AGENTE;
	}

	public void  setNOMBRES_AGENTE(String NOMBRES_AGENTEIn) {
		this.NOMBRES_AGENTE = NOMBRES_AGENTEIn;
	}

	public String getAPELL1() {
		return this.APELL1;
	}

	public void  setAPELL1(String APELL1In) {
		this.APELL1 = APELL1In;
	}

	public String toString() {
		StringBuffer out = new StringBuffer();
		out.append("ID_COMPARENDO: "+this.ID_COMPARENDO);
		out.append("NUMEROCOMPARENDO: "+this.NUMEROCOMPARENDO);
		out.append("PLACA: "+this.PLACA);
		out.append("ID_INFRACTOR: "+this.ID_INFRACTOR);
		out.append("NOMBRES: "+this.NOMBRES);
		out.append("APELLIDOS: "+this.APELLIDOS);
		out.append("FECHACOMPARENDO: "+this.FECHACOMPARENDO);
		out.append("ID_AGENTE: "+this.ID_AGENTE);
		out.append("PLACAAGENTE: "+this.PLACAAGENTE);
		out.append("NOMBRES_AGENTE: "+this.NOMBRES_AGENTE);
		out.append("APELL1: "+this.APELL1);
		return out.toString();
	}
}
