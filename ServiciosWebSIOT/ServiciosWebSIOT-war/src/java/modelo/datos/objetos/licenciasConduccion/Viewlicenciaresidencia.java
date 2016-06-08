package modelo.datos.objetos.licenciasConduccion;

import java.io.Serializable;

import java.util.Date;


public class Viewlicenciaresidencia implements Cloneable, Serializable {
	private String ID_LICENCIA;
	private int ID_PERSONA;
	private String TIPOIDENTIFICACION;
	private String IDENTIFICACION;
	private int ID_SUCURSAL;
	private int ID_CIUDAD;
	private Date FECHARESIDENCIA;
	private String TELEFONO;
	private String FAX;

	public Viewlicenciaresidencia(){

	}

	public Viewlicenciaresidencia(String ID_LICENCIAIn) {

		this.ID_LICENCIA = ID_LICENCIAIn; 
	}


	public String getID_LICENCIA() {
		return this.ID_LICENCIA;
	}

	public void  setID_LICENCIA(String ID_LICENCIAIn) {
		this.ID_LICENCIA = ID_LICENCIAIn;
	}

	public int getID_PERSONA() {
		return this.ID_PERSONA;
	}

	public void  setID_PERSONA(int ID_PERSONAIn) {
		this.ID_PERSONA = ID_PERSONAIn;
	}

	public String getTIPOIDENTIFICACION() {
		return this.TIPOIDENTIFICACION;
	}

	public void  setTIPOIDENTIFICACION(String TIPOIDENTIFICACIONIn) {
		this.TIPOIDENTIFICACION = TIPOIDENTIFICACIONIn;
	}

	public String getIDENTIFICACION() {
		return this.IDENTIFICACION;
	}

	public void  setIDENTIFICACION(String IDENTIFICACIONIn) {
		this.IDENTIFICACION = IDENTIFICACIONIn;
	}

	public int getID_SUCURSAL() {
		return this.ID_SUCURSAL;
	}

	public void  setID_SUCURSAL(int ID_SUCURSALIn) {
		this.ID_SUCURSAL = ID_SUCURSALIn;
	}

	public int getID_CIUDAD() {
		return this.ID_CIUDAD;
	}

	public void  setID_CIUDAD(int ID_CIUDADIn) {
		this.ID_CIUDAD = ID_CIUDADIn;
	}

	public Date getFECHARESIDENCIA() {
		return this.FECHARESIDENCIA;
	}

	public void  setFECHARESIDENCIA(Date FECHARESIDENCIAIn) {
		this.FECHARESIDENCIA = FECHARESIDENCIAIn;
	}

	public String getTELEFONO() {
		return this.TELEFONO;
	}

	public void  setTELEFONO(String TELEFONOIn) {
		this.TELEFONO = TELEFONOIn;
	}

	public String getFAX() {
		return this.FAX;
	}

	public void  setFAX(String FAXIn) {
		this.FAX = FAXIn;
	}
}
