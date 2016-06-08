package modelo.datos.objetos.licenciasConduccion;

import java.io.Serializable;

import java.util.Date;


public class Viewlicenciaconduccion implements Cloneable, Serializable {
	private String ID_LICENCIA;
	private int ID_PERSONA;
	private String NUMEROLICENCIA;
	private String TIPOIDENTIFICACION;
	private String IDENTIFICACION;
	private Date FECHATRAMITE;
	private int ID_TRAMITEINTERNO;
	private String CATEGORIA;
	private int CODESCUELA;
	private int ID_CIUDADPERSONA;
	private String NROCERTIFICADOESCUELA;
	private double CODESPECIEVENAL;
	private String NROLICENCIAANTERIOR;
	private String NROCERTIFICADOMEDICO;
        private double NROCONSIGNACION;
	private Date FECHAVENCIMIENTO;

	public Viewlicenciaconduccion(){

	}

	public Viewlicenciaconduccion(String ID_LICENCIAIn) {

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

	public String getNUMEROLICENCIA() {
		return this.NUMEROLICENCIA;
	}

	public void  setNUMEROLICENCIA(String NUMEROLICENCIAIn) {
		this.NUMEROLICENCIA = NUMEROLICENCIAIn;
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

	public Date getFECHATRAMITE() {
		return this.FECHATRAMITE;
	}

	public void  setFECHATRAMITE(Date FECHATRAMITEIn) {
		this.FECHATRAMITE = FECHATRAMITEIn;
	}

	public int getID_TRAMITEINTERNO() {
		return this.ID_TRAMITEINTERNO;
	}

	public void  setID_TRAMITEINTERNO(int ID_TRAMITEINTERNOIn) {
		this.ID_TRAMITEINTERNO = ID_TRAMITEINTERNOIn;
	}

	public String getCATEGORIA() {
		return this.CATEGORIA;
	}

	public void  setCATEGORIA(String CATEGORIAIn) {
		this.CATEGORIA = CATEGORIAIn;
	}

	public int getCODESCUELA() {
		return this.CODESCUELA;
	}

	public void  setCODESCUELA(int CODESCUELAIn) {
		this.CODESCUELA = CODESCUELAIn;
	}

	public int getID_CIUDADPERSONA() {
		return this.ID_CIUDADPERSONA;
	}

	public void  setID_CIUDADPERSONA(int ID_CIUDADPERSONAIn) {
		this.ID_CIUDADPERSONA = ID_CIUDADPERSONAIn;
	}

	public String getNROCERTIFICADOESCUELA() {
		return this.NROCERTIFICADOESCUELA;
	}

	public void  setNROCERTIFICADOESCUELA(String NROCERTIFICADOESCUELAIn) {
		this.NROCERTIFICADOESCUELA = NROCERTIFICADOESCUELAIn;
	}

	public double getCODESPECIEVENAL() {
		return this.CODESPECIEVENAL;
	}

	public void  setCODESPECIEVENAL(double CODESPECIEVENALIn) {
		this.CODESPECIEVENAL = CODESPECIEVENALIn;
	}

	public String getNROLICENCIAANTERIOR() {
		return this.NROLICENCIAANTERIOR;
	}

	public void  setNROLICENCIAANTERIOR(String NROLICENCIAANTERIORIn) {
		this.NROLICENCIAANTERIOR = NROLICENCIAANTERIORIn;
	}

	public String getNROCERTIFICADOMEDICO() {
		return this.NROCERTIFICADOMEDICO;
	}

	public void  setNROCERTIFICADOMEDICO(String NROCERTIFICADOMEDICOIn) {
		this.NROCERTIFICADOMEDICO = NROCERTIFICADOMEDICOIn;
	}

	public Date getFECHAVENCIMIENTO() {
		return this.FECHAVENCIMIENTO;
	}
        
        public double getNROCONSIGNACION(){
                return this.NROCONSIGNACION;
        }
        
        public void setNROCONSIGNACION(double NROCONSIGNACIOIn){
                this.NROCONSIGNACION = NROCONSIGNACIOIn;
        }

	public void  setFECHAVENCIMIENTO(Date FECHAVENCIMIENTOIn) {
		this.FECHAVENCIMIENTO = FECHAVENCIMIENTOIn;
	}
}
