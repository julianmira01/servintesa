package modelo.datos.objetos.licenciasConduccion;

import java.io.Serializable;


public class Viewlicenciarestriccion implements Cloneable, Serializable {
	private String ID_LICENCIA;
	private int ID_PERSONA;
	private String TIPOIDENTIFICACION;
	private String IDENTIFICACION;
	private String NUMEROLICENCIA;
	private int ID_RESTRICCION;
	private String RESTRICCION;
	private int CONSECUTIVOREGISTRO;

	public Viewlicenciarestriccion(){

	}

	public Viewlicenciarestriccion(String ID_LICENCIAIn) {

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

	public String getNUMEROLICENCIA() {
		return this.NUMEROLICENCIA;
	}

	public void  setNUMEROLICENCIA(String NUMEROLICENCIAIn) {
		this.NUMEROLICENCIA = NUMEROLICENCIAIn;
	}

	public int getID_RESTRICCION() {
		return this.ID_RESTRICCION;
	}

	public void  setID_RESTRICCION(int ID_RESTRICCIONIn) {
		this.ID_RESTRICCION = ID_RESTRICCIONIn;
	}

	public String getRESTRICCION() {
		return this.RESTRICCION;
	}

	public void  setRESTRICCION(String RESTRICCIONIn) {
		this.RESTRICCION = RESTRICCIONIn;
	}

	public int getCONSECUTIVOREGISTRO() {
		return this.CONSECUTIVOREGISTRO;
	}

	public void  setCONSECUTIVOREGISTRO(int CONSECUTIVOREGISTROIn) {
		this.CONSECUTIVOREGISTRO = CONSECUTIVOREGISTROIn;
	}
}
