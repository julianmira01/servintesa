package modelo.logica.liquidador;


import java.sql.Connection;
import java.sql.SQLException;

import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import modelo.conexion.Conexion;

import modelo.datos.dao.distribucionRecursos.CuentacontableDao;
import modelo.datos.dao.liquidacion.tarifas.LtarifasDao;
import modelo.datos.dao.liquidacion.tarifas.LtarifasDetDao;
import modelo.datos.dao.liquidador.ConceptosTarifaDao;
import modelo.datos.dao.liquidador.FacturaDao;
import modelo.datos.dao.liquidador.FacturaDetDao;
import modelo.datos.dao.liquidador.SalarioDao;
import modelo.datos.dao.liquidador.TarifaDao;
import modelo.datos.objetos.distribucionRecursos.Cuentacontable;
import modelo.datos.objetos.generales.AuditoriaSystem;
import modelo.datos.objetos.generales.Auditoriatramite;
import modelo.datos.objetos.generales.Header;
import modelo.datos.objetos.generales.Persona;
import modelo.datos.objetos.generales.Usuarios;
import modelo.datos.objetos.generales.ViewPropietario;
import modelo.datos.objetos.generales.vehiculo.VehInmovilizacion;
import modelo.datos.objetos.generales.vehiculo.Vehiculo;
import modelo.datos.objetos.liquidacion.tarifas.Ltarifas;
import modelo.datos.objetos.liquidacion.tarifas.LtarifasDet;
import modelo.datos.objetos.liquidador.ConceptosTarifa;
import modelo.datos.objetos.liquidador.DatosAdicionalesFactura;
import modelo.datos.objetos.liquidador.DatosFactura;
import modelo.datos.objetos.liquidador.Factura;
import modelo.datos.objetos.liquidador.FacturaDet;
import modelo.datos.objetos.liquidador.Tarifa;
import modelo.datos.objetos.generales.Transito;

import modelo.logica.facturacion.GestionServiciosFacturacion;
import modelo.logica.generales.GestionAuditoriaTramite;
import modelo.logica.generales.vehiculo.GestionServiciosVehInmovilizacion;
import modelo.logica.generales.vehiculo.GestionServiciosVehiculosLocal;
import modelo.logica.usuarios.GestionServiciosUsuarios;
import modelo.logica.generales.GestionServiciosTransitoLocal;


import servicios.generales.ServiciosEmpresas;
import servicios.generales.ServiciosPersonas;
import servicios.generales.ServiciosVehiculos;
import servicios.generales.ServiciosViewPropietario;

import utilidades.Auditoria;
import utilidades.Compilador;
import utilidades.Funciones;
import utilidades.GenerarReportes;


//import modelo.datos.objetos.generales.Header;


public class GestionServiciosLiquidacionLocal2 {

    Conexion conexion;
    Conexion conexionComp;
    Connection conn;
    Connection connComp;
    TarifaDao tarifaDao;
    FacturaDao facturaDao;
    FacturaDetDao facturaDetDao;
    ConceptosTarifaDao conceptosTarifaDao;
    SalarioDao salarioDao;
    Compilador compilador;
    GenerarReportes generarReportes;
    ServiciosVehiculos serviciosVehiculos;
    ServiciosViewPropietario serviciosViewPropietarios;
    ServiciosEmpresas serviciosEmpresas;
    ServiciosPersonas serviciosPersonas;
    ViewPropietario propietario;
    Factura factura;
    String myMotor;

    public GestionServiciosLiquidacionLocal2() {
        super();
        crearObjetos();
    }

    public void crearObjetos() {
        conexion = new Conexion();
        conexionComp = new Conexion();
        conceptosTarifaDao = new ConceptosTarifaDao();
        tarifaDao = new TarifaDao();
        salarioDao = new SalarioDao();
        facturaDao = new FacturaDao();
        facturaDetDao = new FacturaDetDao();
        compilador = new Compilador(null, getSalarios());
        generarReportes = new GenerarReportes();
        serviciosVehiculos = new ServiciosVehiculos();
        serviciosViewPropietarios = new ServiciosViewPropietario();
        serviciosEmpresas = new ServiciosEmpresas();
        serviciosPersonas = new ServiciosPersonas();
        myMotor = "";
        
        try{
            myMotor = Funciones.leer_ini("/WSTransito.ini", "MOTOR");
        }catch(Exception exce){}
        if(myMotor.equals(""))
        try{
            myMotor = Funciones.leer_ini("c:\\WSTransito.ini", "MOTOR");
        }catch(Exception exce){}
    }

    public List getTarifas(Tarifa tarifa, boolean vehiculoActivo) {
        List lista = null;
        try {
            conn = conexion.conectar();
            lista = (ArrayList)tarifaDao.searchMatching(conn, tarifa);
            if (!vehiculoActivo && lista != null) {
                Tarifa obj;
                List objs = new ArrayList();

                String ids = "";
                
                ids = "";
        
                try{
                    ids = Funciones.leer_ini("/WSTransito.ini", "TRAMITES_VEHICULO_INACTIVO");
                }catch(Exception exce){}
                if(ids.equals(""))
                try{
                    ids = Funciones.leer_ini("c:\\WSTransito.ini", "TRAMITES_VEHICULO_INACTIVO");
                }catch(Exception exce){}
                
                ids = ids.replace(" ", "");
                String[] idsArray = ids.split(",");
                for (int i = 0; i < idsArray.length; i++) {
                    for (int j = 0; j < lista.size(); j++) {
                        obj = (Tarifa)lista.get(j);
                        if (idsArray[i].equals(obj.getID_TRAMITEINTERNO())) {
                            objs.add(obj);
                        }
                    }
                }
                lista = objs;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            conexion.cerrarCx();
        }
        return lista;
    }

    //***********************************************************************

    public List getFacturaDetalle(FacturaDet facturadet) {
        List lista = null;
        try {
            conn = conexion.conectar();
            lista = facturaDetDao.searchMatching(conn, facturadet);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            conexion.cerrarCx();
        }
        return lista;
    }

    //***********************************************************************

    public List getTarifasPorRangoVigencia(Tarifa valueObject, int vigenciaInicial, int vigenciaFinal) {
        List searchResults = null;
        try {
            conn = conexion.conectar();

            boolean first = true;
            StringBuffer sql = new StringBuffer("SELECT * FROM VISTA_TARIFAS_TODAS WHERE 1=1 ");

            if (valueObject.getLT_ID() != 0) {
                if (first) {
                    first = false;
                }
                sql.append("AND LT_ID = ").append(valueObject.getLT_ID()).append(" ");
            }

            if (valueObject.getLT_NOMBRE() != null) {
                if (first) {
                    first = false;
                }
                sql.append("AND LT_NOMBRE = '").append(valueObject.getLT_NOMBRE()).append("' ");
            }

            if (vigenciaInicial > 0 && vigenciaFinal > 0) {
                if (first) {
                    first = false;
                }
                sql.append("AND LT_VIGENCIA BETWEEN '").append(vigenciaInicial).append("' AND '").append(vigenciaFinal).append("' ");
            }

            if (valueObject.getTIPOIT() != null) {
                if (first) {
                    first = false;
                }
                sql.append("AND TIPOIT = '").append(valueObject.getTIPOIT()).append("' ");
            }

            if (valueObject.getID_COD_RUNT() != null) {
                if (first) {
                    first = false;
                }
                sql.append("AND ID_COD_RUNT = '").append(valueObject.getID_COD_RUNT()).append("' ");
            }

            if (valueObject.getID_TARAPLICADA_C() != null) {
                if (first) {
                    first = false;
                }
                sql.append("AND ID_TARAPLICADA_C = '").append(valueObject.getID_TARAPLICADA_C()).append("' ");
            }

            if (valueObject.getID_TARAPLICADA_M() != null) {
                if (first) {
                    first = false;
                }
                sql.append("AND ID_TARAPLICADA_M = '").append(valueObject.getID_TARAPLICADA_M()).append("' ");
            }

            if (valueObject.getTIPO() != null) {
                if (first) {
                    first = false;
                }
                sql.append("AND TIPO = '").append(valueObject.getTIPO()).append("' ");
            }

            if (valueObject.getLT_APLICAWEB() != null) {
                if (first) {
                    first = false;
                }
                sql.append("AND LT_APLICAWEB = '").append(valueObject.getLT_APLICAWEB()).append("' ");
            }

            if (valueObject.getLT_LCV_ID() != null) {
                if (first) {
                    first = false;
                }
                sql.append("AND LT_LCV_ID = '").append(valueObject.getLT_LCV_ID()).append("' ");
            }


            sql.append("ORDER BY LT_ID ASC ");

            System.out.println(sql);
            // Prevent accidential full table results.
            // Use loadAll if all rows must be returned.
            if (first)
                searchResults = new ArrayList();
            else
                searchResults = tarifaDao.listQuery(conn, conn.prepareStatement(sql.toString()));

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return searchResults;
    }


    public ArrayList getSalarios() {
        ArrayList lista = null;
        try {
            conn = conexion.conectar();
            lista = (ArrayList)salarioDao.loadAll(conn);
        } catch (Exception e) {

        } finally {
            conexion.cerrarCx();
        }
        return lista;
    }

    public String getMeses() { //Obtiene el numero de meses que faltan para terminar el a-*-o
        String meses = "" + (12 - (new Date().getMonth() + 1));
        return meses;
    }


    public List getConceptosTarifa(ConceptosTarifa conceptoTarifa, Vehiculo vehi) {
        List lista = null;
        String valor = "0";
        boolean esParqueadero = false;
        List listaParqueadero = new ArrayList();

        try {
            conn = conexion.conectar();
            connComp = conexionComp.conectarComparendos();
            compilador.conn = conn;
            compilador.connComp = connComp;
            compilador.conexion = conexion;
            compilador.conexionComp = conexionComp;
            compilador.myMotor = myMotor;

            lista = (ArrayList)conceptosTarifaDao.searchMatching(conn, conceptoTarifa);
            if (lista != null && lista.size() > 0) {
                for (int i = 0; i < lista.size(); i++) {
                    conceptoTarifa = (ConceptosTarifa)lista.get(i);

                    String calculo = conceptoTarifa.getLTD_CALCULO();
                    if (calculo != null && calculo.length() > 0) {
                        if (calculo.contains("MESES")) {
                            String meses = getMeses();
                            calculo = calculo.replace("MESES", meses);
                            conceptoTarifa.setLTD_CALCULO(calculo);
                            System.out.println("XXXXXXXXXXXXXXXXXXXYYYYYYYYYYYYYYYYYYYYYYYXXXXXXXXXXXXXXXXXX" + calculo);
                        }
                    }
                    

                    //TODO Parqueadero
                    compilador.vigenciaInmovilizacion = null;
                    String idTramiteIterno_Parqueadero ="";
                        Funciones.leer_ini("/WSTransito.ini", "ID_TRAMITEINTERNO_PARQUEADERO");
                    
                    idTramiteIterno_Parqueadero = "";
        
                    try{
                        idTramiteIterno_Parqueadero = Funciones.leer_ini("/WSTransito.ini", "ID_TRAMITEINTERNO_PARQUEADERO");
                    }catch(Exception exce){}
                    if(idTramiteIterno_Parqueadero.equals(""))
                    try{
                        idTramiteIterno_Parqueadero = Funciones.leer_ini("c:\\WSTransito.ini", "ID_TRAMITEINTERNO_PARQUEADERO");
                    }catch(Exception exce){}
                    
                    if (conceptoTarifa.getLT_IDTRAMITEINTERNO() != null &&
                        conceptoTarifa.getLT_IDTRAMITEINTERNO().equals(idTramiteIterno_Parqueadero)) {
                        esParqueadero = true;

                        //conseguir las vigencias abarcadas desde inicio a fin inmovilizacion
                        ArrayList listaVigencias = getListaVigenciasInmovilizacion(vehi);
                        float valorInmovilizacion = 0;
                        if (listaVigencias != null && listaVigencias.size() > 0) {
                            for (int j = 0; j < listaVigencias.size(); j++) {
                                //para cada vigencia obtner el concepto tarifa a aplicar
                                ConceptosTarifa conceptoInmovilizacion = new ConceptosTarifa();
                                conceptoInmovilizacion.setLT_VIGENCIA(listaVigencias.get(j).toString());
                                conceptoInmovilizacion.setLCC_NOMBRE(conceptoTarifa.getLCC_NOMBRE());
                                conceptoInmovilizacion.setLT_IDTRAMITEINTERNO(conceptoTarifa.getLT_IDTRAMITEINTERNO());
                                List listaInmovilizacion =
                                    conceptosTarifaDao.searchMatching(conn, conceptoInmovilizacion);
                                if (listaInmovilizacion != null && listaInmovilizacion.size() > 0) {
                                    conceptoInmovilizacion = (ConceptosTarifa)listaInmovilizacion.get(0);
                                    //configurar la vigenciaInmovilizacion del compilador
                                    compilador.vigenciaInmovilizacion = (Integer)listaVigencias.get(j);
                                    //acumular valor de compilar
                                    if (conceptoInmovilizacion != null) {
                                        valorInmovilizacion =
                                                Float.parseFloat(invocarCompilar(conceptoInmovilizacion, vehi));
                                        //conceptoInmovilizacion.setLTD_CALCULO(compilador.descripcion);
                                        conceptoInmovilizacion.setLTD_VALOR("" + valorInmovilizacion);
                                        listaParqueadero.add(conceptoInmovilizacion);
                                    }
                                }
                            }
                            //eliminamos el parqueadero
                            lista.remove(i);
                            i--;
                        }
                    } else {
                        valor = invocarCompilar(conceptoTarifa, vehi);
                        conceptoTarifa.setLTD_VALOR(valor);
                        conceptoTarifa.setCondicion(invocarCondicion(conceptoTarifa, vehi));
                        lista.remove(i);
                        lista.add(i, conceptoTarifa);
                    }

                }
                //adicionamos los parqueadero
                for (int i = 0; i < listaParqueadero.size(); i++) {
                    lista.add(listaParqueadero.get(i));
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            conexionComp.cerrarCx();
            conexion.cerrarCx();
        }
        return lista;
    }

    private String invocarCondicion(ConceptosTarifa conceptosTarifa, Vehiculo vehiculo) {
        String res = "";
        try {
            LtarifasDao tarifaDao = new LtarifasDao();
            Ltarifas tarifa = new Ltarifas();
            tarifa.setLT_ID(conceptosTarifa.getLT_ID());
            if (conn.isClosed())
                conn = conexion.conectar();
            List lista = tarifaDao.searchMatching(conn, tarifa);
            if (lista != null && lista.size() > 0) {
                tarifa = (Ltarifas)lista.get(0);
                if (tarifa.getLT_CONDICIONES() != null && !tarifa.getLT_CONDICIONES().equals("") &&
                    !tarifa.getLT_CONDICIONES().toUpperCase().equals("NULL")) {
                    String[] condiciones = tarifa.getLT_CONDICIONES().split(";");
                    res = "";
                    String resCondicion;
                    String[] condicion;
                    for (int i = 0; i < condiciones.length; i++) {
                        if (!condiciones[i].trim().equals("")) {
                            condicion = condiciones[i].split(",");
                            resCondicion = compilador.compilar(condicion[0] + ",1,0)", "2000", vehiculo, "");
                            if (!resCondicion.trim().equals("")) {
                                if (resCondicion.trim().equals("1")) {
                                    condicion[1] = condicion[1].replace(')', ' ').trim();
                                    if (condicion[1].equals(""))
                                        res += "";
                                    else
                                        res += condicion[1] + ". ";
                                    //res += condicion[1].trim() + ". ";
                                } else {
                                    condicion[2] = condicion[2].replace(')', ' ').trim();
                                    if (condicion[2].equals(""))
                                        res += "";
                                    else
                                        res += condicion[2] + ". ";
                                }
                            }
                        }
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            res = "";
        }
        return res;
    }

    public String invocarCompilar(ConceptosTarifa conceptoTarifa, Vehiculo vehiculo) {
        String valor = "0";
        if (conceptoTarifa.getLTD_TIPO() != null && !conceptoTarifa.getLTD_TIPO().equals("")) {
            if (conceptoTarifa.getLTD_TIPO().equals("1")) {
                //valor
                valor = conceptoTarifa.getLTD_VALOR();
            } else if (conceptoTarifa.getLTD_TIPO().equals("2") && conceptoTarifa.getLTD_DATO_BASE() != null &&
                       conceptoTarifa.getLTD_FACTOR() != null) {
                //dato base
                valor =
                        compilador.compilar(conceptoTarifa.getLTD_DATO_BASE() + "*" + conceptoTarifa.getLTD_FACTOR(), conceptoTarifa.getLT_VIGENCIA(),
                                            vehiculo, "");
            } else if (conceptoTarifa.getLTD_TIPO().equals("4") && conceptoTarifa.getLTD_CALCULO() != null) {
                //formula
                valor =
                        compilador.compilar(conceptoTarifa.getLTD_CALCULO(), conceptoTarifa.getLT_VIGENCIA(), vehiculo, "");
            } else {
                valor = "0";
            }
        } else {
            valor = "0";
        }
        return valor;
    }

    private ArrayList getListaVigenciasInmovilizacion(Vehiculo vehiculo) {
        VehInmovilizacion obj = getVehInmovilizacion(vehiculo.getID_VEHICULO());
        ArrayList list = new ArrayList();
        if (obj != null) {
            Calendar calIni = Funciones.convFechaSC(obj.getFECHAINIINMOVILIZA());
            Calendar calFin = Funciones.convFechaSC(obj.getFECHAFININMOVILIZA());
            for (int i = calIni.get(Calendar.YEAR); i <= calFin.get(Calendar.YEAR); i++) {
                list.add(i);
            }
        }
        return list;
    }

    private VehInmovilizacion getVehInmovilizacion(int idVehiculo) {
        GestionServiciosVehInmovilizacion gestion = new GestionServiciosVehInmovilizacion();
        VehInmovilizacion obj = new VehInmovilizacion();
        obj.setID_VEHICULO(idVehiculo);
        obj.setACTIVA("T");
        List objs = gestion.get(obj);
        if (objs != null && objs.size() > 0) {
            obj = (VehInmovilizacion)objs.get(0);
            return obj;
        }
        return null;
    }

    public DatosFactura facturar(Header header, List tarifas, List listaConceptos,
                                 DatosAdicionalesFactura datosAdionalesFactura, boolean runt, int idUsuario,
                                 String myIp, String myHost, String avaluo, int IdSolicitante) throws Exception {

        DatosFactura df;
            try{
            df = facturar(header, tarifas, listaConceptos, datosAdionalesFactura, idUsuario, myIp, myHost, avaluo, IdSolicitante);
            }catch(Exception e){e.printStackTrace(); return null;}  
        return df;

    }

    public DatosFactura facturar(Header header, List tarifas, List listaConceptos,
                                 DatosAdicionalesFactura datosAdionalesFactura, int idUsuario, String myIp,
                                 String myHost, String avaluo, int IdSolicitante) throws Exception {
        DatosFactura datosFactura = new DatosFactura();
        Tarifa tarifa;
        ConceptosTarifa conceptoTarifa = null;
        factura = new Factura();
        FacturaDet facturaDet = null;
        int idL_factura = 0;
        int idL_facturaDet = 0;
        idL_factura = getGeneradorL_Factura();
        //idL_factura = getGeneradorL_FacturaNuevo();

        factura.setLF_ESTADO("1");
        String numeroFactura = "";
        propietario = new ViewPropietario();
        int targettramite = 0;
        String placa_vehiculo = "", cedula_persona = "";
        List listausuarios = null;

        factura.setLF_FECHA(getFechaFactura());
        factura.setLF_TOTAL(String.valueOf(datosAdionalesFactura.getTotal()));
        if (datosAdionalesFactura.getNota() != null && !datosAdionalesFactura.getNota().trim().equals("")) {
            factura.setLF_NOTA(datosAdionalesFactura.getNota());
            factura.setLF_FACTURAERROR("T");
        } else {
            factura.setLF_FACTURAERROR("F");
        }
        factura.setLF_ID_USUARIO(header.getIdUsuario());
        numeroFactura = getNumeroFactura(idL_factura);
        factura.setLF_NUMERO(numeroFactura.trim());
        factura.setLF_ID(idL_factura);
        factura.setCARGADO("F");
        factura.setLF_TIPO(datosAdionalesFactura.getTipoIT());
        
        if (IdSolicitante > 0) 
        {
            factura.setLF_IDSOLICITANTE(Integer.toString(IdSolicitante));
        }
        
        
        if (datosAdionalesFactura.getTipoPE().equals("1")) { // persona
            factura.setLF_ID_PERSONA(datosAdionalesFactura.getIdPersona());
            Persona persona = new Persona();
            persona.setID_PERSONAS(Integer.parseInt(datosAdionalesFactura.getIdPersona()));
            try{
            persona = serviciosPersonas.getPersona(persona);
            }catch(Exception e){throw new Exception (e.getMessage());}
            propietario.setEMPPER("PER");
            propietario.setIDENTIFICACION(persona.getIDENTIFICACION());
            propietario.setNOMBRE("" + (persona.getNOMBRES() == null ? "" : persona.getNOMBRES()) + " " +
                                  (persona.getAPELLIDO1() == null ? "" : persona.getAPELLIDO1()) + " " +
                                  (persona.getAPELLIDO2() == null ? "" : persona.getAPELLIDO2()));

            targettramite = 1; //persona
            cedula_persona = persona.getIDENTIFICACION();

        } else if (datosAdionalesFactura.getTipoPE().equals("2")) { // vehiculo
            factura.setLF_V_ID(datosAdionalesFactura.getIdVehiculo());
            targettramite = 2; //vehiculo
            Vehiculo objvehiculo = new Vehiculo();
            GestionServiciosVehiculosLocal gestionVehiculos = new GestionServiciosVehiculosLocal();
            if(datosAdionalesFactura.getIdVehiculo()!= null)
            {
                objvehiculo.setID_VEHICULO(Integer.parseInt(datosAdionalesFactura.getIdVehiculo()));
                objvehiculo = gestionVehiculos.getVehiculo(objvehiculo);
                placa_vehiculo = objvehiculo.getPLACA();
            }
        } else if (datosAdionalesFactura.getTipoPE().equals("3")) { // Remolque semiremolque
            factura.setLF_V_ID(datosAdionalesFactura.getIdVehiculo());
            targettramite = 2; //vehiculo
            Vehiculo objvehiculo = new Vehiculo();
            GestionServiciosVehiculosLocal gestionVehiculos = new GestionServiciosVehiculosLocal();
            if(datosAdionalesFactura.getIdVehiculo()!= null)
            {
                objvehiculo.setID_VEHICULO(Integer.parseInt(datosAdionalesFactura.getIdVehiculo()));
                objvehiculo = gestionVehiculos.getVehiculo(objvehiculo);
                placa_vehiculo = objvehiculo.getPLACA();
            }
        } else if (datosAdionalesFactura.getTipoPE().equals("4")) { // Maquinaria
            factura.setLF_V_ID(datosAdionalesFactura.getIdVehiculo());
            targettramite = 2; //vehiculo
            Vehiculo objvehiculo = new Vehiculo();
            GestionServiciosVehiculosLocal gestionVehiculos = new GestionServiciosVehiculosLocal();
            if(datosAdionalesFactura.getIdVehiculo()!= null)
            {
                objvehiculo.setID_VEHICULO(Integer.parseInt(datosAdionalesFactura.getIdVehiculo()));
                objvehiculo = gestionVehiculos.getVehiculo(objvehiculo);
                placa_vehiculo = objvehiculo.getPLACA();
            }
        }

        //auditar
        crearL_FACTURAS(factura, idUsuario, myIp, myHost);
        String tramites = "";
        for (int i = 0; i < listaConceptos.size(); i++) {

            idL_facturaDet = getGeneradorL_FacturaDet();
            conceptoTarifa = (ConceptosTarifa)listaConceptos.get(i);
            System.out.println("-----------------------------> CONCEPTOS" + conceptoTarifa);
            facturaDet = new FacturaDet();
            facturaDet.setLFD_ID(idL_facturaDet);
            facturaDet.setLFD_LCC_ID(conceptoTarifa.getLCC_ID());
            facturaDet.setLFD_LF_ID(String.valueOf(idL_factura));

            facturaDet.setLFD_LTD_ID(conceptoTarifa.getLTD_ID());
            facturaDet.setLFD_VIGENCIA(conceptoTarifa.getLT_VIGENCIA());

            if (conceptoTarifa.getLTD_VALOR() != null && !conceptoTarifa.getLTD_VALOR().equals("")) {
                if (Funciones.esDouble(conceptoTarifa.getLTD_VALOR())) {
                    //double valor = 0;
                    //String valorconcepto = conceptoTarifa.getLTD_VALOR();
                    //valor = Double.valueOf(valorconcepto).doubleValue();
                    //String lfdvalor = String.format("$ %,.2f", valor);
                    //facturaDet.setLFD_VALOR(lfdvalor);

                    facturaDet.setLFD_VALOR(conceptoTarifa.getLTD_VALOR());

                } else
                    facturaDet.setLFD_VALOR("0");
            }

            crearL_FACTURAS_DET(facturaDet, idUsuario, myIp, myHost);
            tramites += conceptoTarifa.getLT_NOMBRE() + ",";
            System.out.println("-----------------------------> CONCEPTOS" + conceptoTarifa.getLT_NOMBRE() + " ______  "+ tramites );
        }


        //AUDITORIA TRAMITE  *****************************************

        GestionAuditoriaTramite mygestionauditoriatramite = new GestionAuditoriaTramite();
        GestionServiciosUsuarios mygestionusuario = new GestionServiciosUsuarios();

        Auditoriatramite objAuditoriaTramite = new Auditoriatramite();
        Usuarios objusuario = new Usuarios();
        objusuario.setID_USUARIO(idUsuario);
        try{
        listausuarios = mygestionusuario.getUsuarios(objusuario, 0);
        }catch(Exception e){throw new Exception (e.getMessage());}
        if (listausuarios != null && listausuarios.size() > 0)
            objAuditoriaTramite.setUSUARIO(((Usuarios)listausuarios.get(0)).getLOGIN());

        objAuditoriaTramite.setTARGET_TRAMITE(targettramite);
        objAuditoriaTramite.setPLACA_VEHICULO(placa_vehiculo);
        objAuditoriaTramite.setCEDULA_PERSONA(cedula_persona);
        objAuditoriaTramite.setTRAMITE(tramites);

        String fecha = Funciones.getFechaSistemaCortaTexto(myMotor);


        objAuditoriaTramite.setFECHA(fecha);
        objAuditoriaTramite.setHORA(Funciones.getHoraSistema().toString());
        objAuditoriaTramite.setACCION(1); //liquidar/facturar
        String datosadicionfactura = "";
        if (datosAdionalesFactura.getNota() != null && !datosAdionalesFactura.getNota().trim().equals(""))
            datosadicionfactura = datosAdionalesFactura.getNota();

        objAuditoriaTramite.setINFO_ADICIONAL("Factura Nro:" + numeroFactura + " Host:" + myHost + " Direccion IP:" +
                                              myIp + ". " + datosadicionfactura);

        mygestionauditoriatramite.crearAuditoriatramite(objAuditoriaTramite);
        //***********************************************************


        try {
            Vehiculo vehiculo = new Vehiculo();
            if (datosAdionalesFactura.getIdVehiculo() != null) {
                vehiculo.setID_VEHICULO(Integer.parseInt(datosAdionalesFactura.getIdVehiculo()));
                vehiculo = serviciosVehiculos.getVehiculo(vehiculo);

                ViewPropietario vistaPropietario = new ViewPropietario();
                vistaPropietario.setID_VEHICULO(Integer.parseInt(datosAdionalesFactura.getIdVehiculo()));

                List listaPropietarios = serviciosViewPropietarios.listarViewPropietarios(vistaPropietario);
                if (listaPropietarios != null && listaPropietarios.size() > 0) {
                    propietario = (ViewPropietario)listaPropietarios.get(0);
                }
            }

            String codigoBarras; // = "(415)7709998013711(8020)000010129389000011127135(3900)0001168375(96)20111207";

            GestionServiciosFacturacion gestionSFacturacion = new GestionServiciosFacturacion();
            Date date = new Date();
            SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
            String str_date = (String)formatter.format(date);
            codigoBarras =
                    //gestionSFacturacion.generarCodigoBarras(propietario.getIDENTIFICACION(), numeroFactura, factura.getLF_TOTAL(),
                    //                                        str_date);
                    gestionSFacturacion.generarCodigoBarras2(propietario.getIDENTIFICACION(), numeroFactura, factura.getLF_TOTAL(),
                                                            str_date);
            
            codigoBarras = codigoBarras.replace("(","").replace(")","");            
            System.out.println("C-*-digo de barras neto: " + codigoBarras);
            
            generarReportes.generarReporte(listaConceptos, numeroFactura.trim(), vehiculo, propietario, factura.getLF_TOTAL(),
                                           factura.getLF_TOTAL(), "1 de 1", factura.getLF_TOTAL(), codigoBarras, avaluo);

            datosFactura.setNumeroFacturaLocal(numeroFactura);

            datosFactura.setTotalFacturaLocal(factura.getLF_TOTAL());


        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("error mensajes=" + e.getMessage());
        }

        return datosFactura;


    }


    public DatosFactura facturarTemp(Header header, List tarifas, List listaConceptos,
                                     DatosAdicionalesFactura datosAdionalesFactura, boolean runt, int idUsuario,
                                     String myIp, String myHost) throws Exception {

        DatosFactura df;
        try{
        df = facturarTemp(header, tarifas, listaConceptos, datosAdionalesFactura, idUsuario, myIp, myHost);
        }catch(Exception e){throw new Exception (e.getMessage());}  
        return df;

    }

    public DatosFactura facturarTemp(Header header, List tarifas, List listaConceptos,
                                     DatosAdicionalesFactura datosAdionalesFactura, int idUsuario, String myIp,
                                     String myHost) throws Exception {
        DatosFactura datosFactura = new DatosFactura();
        Tarifa tarifa;
        ConceptosTarifa conceptoTarifa = null;
        factura = new Factura();
        FacturaDet facturaDet = null;
        int idL_factura = 0;
        int idL_facturaDet = 0;
        idL_factura = getGeneradorL_FacturaTemp();
        //idL_factura = getGeneradorL_FacturaNuevo();

        factura.setLF_ESTADO("1");
        String numeroFactura = "";
        propietario = new ViewPropietario();
        int targettramite = 0;
        String placa_vehiculo = "", cedula_persona = "";
        List listausuarios = null;

        factura.setLF_FECHA(getFechaFactura());
        factura.setLF_TOTAL(String.valueOf(datosAdionalesFactura.getTotal()));
        if (datosAdionalesFactura.getNota() != null && !datosAdionalesFactura.getNota().trim().equals("")) {
            factura.setLF_NOTA(datosAdionalesFactura.getNota());
            factura.setLF_FACTURAERROR("T");
        } else {
            factura.setLF_FACTURAERROR("F");
        }
        factura.setLF_ID_USUARIO(header.getIdUsuario());
        numeroFactura = getNumeroFacturaTemp(idL_factura);
        factura.setLF_NUMERO(numeroFactura);
        factura.setLF_ID(idL_factura);
        factura.setCARGADO("F");
        factura.setLF_TIPO(datosAdionalesFactura.getTipoIT());

        if (datosAdionalesFactura.getTipoPE().equals("1")) { // persona
            factura.setLF_ID_PERSONA(datosAdionalesFactura.getIdPersona());
            Persona persona = new Persona();
            persona.setID_PERSONAS(Integer.parseInt(datosAdionalesFactura.getIdPersona()));
            try{
            persona = serviciosPersonas.getPersona(persona);
            }catch(Exception e){throw new Exception (e.getMessage());}
            propietario.setEMPPER("PER");
            propietario.setIDENTIFICACION(persona.getIDENTIFICACION());
            propietario.setNOMBRE("" + (persona.getNOMBRES() == null ? "" : persona.getNOMBRES()) + " " +
                                  (persona.getAPELLIDO1() == null ? "" : persona.getAPELLIDO1()) + " " +
                                  (persona.getAPELLIDO2() == null ? "" : persona.getAPELLIDO2()));

            targettramite = 1; //persona
            cedula_persona = persona.getIDENTIFICACION();

        } else if (datosAdionalesFactura.getTipoPE().equals("2")) { // vehiculo
            factura.setLF_V_ID(datosAdionalesFactura.getIdVehiculo());
            targettramite = 2; //vehiculo
            Vehiculo objvehiculo = new Vehiculo();
            GestionServiciosVehiculosLocal gestionVehiculos = new GestionServiciosVehiculosLocal();
            objvehiculo.setID_VEHICULO(Integer.parseInt(datosAdionalesFactura.getIdVehiculo()));
            objvehiculo = gestionVehiculos.getVehiculo(objvehiculo);
            placa_vehiculo = objvehiculo.getPLACA();
        }

        //auditar
        crearL_FACTURASTEMP(factura, idUsuario, myIp, myHost);
        String tramites = "";
        for (int i = 0; i < listaConceptos.size(); i++) {

            idL_facturaDet = getGeneradorL_FacturaDetTemp();
            conceptoTarifa = (ConceptosTarifa)listaConceptos.get(i);
            facturaDet = new FacturaDet();
            facturaDet.setLFD_ID(idL_facturaDet);
            facturaDet.setLFD_LCC_ID(conceptoTarifa.getLCC_ID());
            facturaDet.setLFD_LF_ID(String.valueOf(idL_factura));

            facturaDet.setLFD_LTD_ID(conceptoTarifa.getLTD_ID());
            facturaDet.setLFD_VIGENCIA(conceptoTarifa.getLT_VIGENCIA());

            if (conceptoTarifa.getLTD_VALOR() != null && !conceptoTarifa.getLTD_VALOR().equals("")) {
                if (Funciones.esDouble(conceptoTarifa.getLTD_VALOR())) {
                    //double valor = 0;
                    //String valorconcepto = conceptoTarifa.getLTD_VALOR();
                    //valor = Double.valueOf(valorconcepto).doubleValue();
                    //String lfdvalor = String.format("$ %,.2f", valor);
                    //facturaDet.setLFD_VALOR(lfdvalor);

                    facturaDet.setLFD_VALOR(conceptoTarifa.getLTD_VALOR());

                } else
                    facturaDet.setLFD_VALOR("0");
            }

            crearL_FACTURAS_DETTEMP(facturaDet, idUsuario, myIp, myHost);
            tramites += conceptoTarifa.getLT_NOMBRE() + ",";

        }

        return datosFactura;
    }


    public static void main(String[] args) throws Exception {
        System.out.println("Inicia");

        String codigoBarras = "(415)7709998013711(8020)000010129389000011127135(3900)0001168375(96)20111207";

        GestionServiciosFacturacion gestionSFacturacion = new GestionServiciosFacturacion();
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
        String str_date = (String)formatter.format(date);
        codigoBarras = gestionSFacturacion.generarCodigoBarras("25278347", "1120106132670", "30567", "20120106");


        GenerarReportes generarReportes = new GenerarReportes();
        servicios.generales.ServiciosViewPropietario serviciosViewPropietarios =
            new servicios.generales.ServiciosViewPropietario();
        //vehiculo
        Vehiculo vehiculo = new Vehiculo();
        vehiculo.setPLACA("SHS100");
        GestionServiciosVehiculosLocal gestion;
        gestion = new GestionServiciosVehiculosLocal();
        vehiculo = gestion.getVehiculo(vehiculo);
        //propietario
        ViewPropietario propietario = new ViewPropietario();
        propietario.setID_VEHICULO(vehiculo.getID_VEHICULO());
        List lista = serviciosViewPropietarios.listarViewPropietarios(propietario);
        propietario = (ViewPropietario)lista.get(0);
        //conceptos
        ArrayList conceptos = new ArrayList();
        ConceptosTarifa concepto = new ConceptosTarifa();
        concepto.setLCC_ID("18");
        GestionServiciosLiquidacionLocal2 gestionLiquidador = new GestionServiciosLiquidacionLocal2();
        conceptos = (ArrayList)gestionLiquidador.getConceptosTarifa(concepto, vehiculo);
        try{
        generarReportes.generarReporte(conceptos, "1120106132670", vehiculo, propietario, "30567", "30567", "1 de 2","30567", codigoBarras,"");
        }catch(Exception e){throw new Exception (e.getMessage());}  
        System.out.println("Fin");
    }

    public boolean auditarCorrecciones(List listaConceptosAuditar, List listaConceptos, int idUsuario, String myIp,
                                       String myHost) {
        boolean res = false;
        try {
            conn = conexion.conectar();
            for (int i = 0; i < listaConceptos.size() && i < listaConceptosAuditar.size(); i++) {
                //Campos para la auditoria
                ConceptosTarifa objNuevo = (ConceptosTarifa)listaConceptos.get(i);
                ConceptosTarifa objAnterior = (ConceptosTarifa)listaConceptosAuditar.get(i);
                //auditar
                Auditoria myAuditoria = new Auditoria();
                AuditoriaSystem myAuditSx = new AuditoriaSystem();
                myAuditSx.setTABLAAFECTADA("L_FACTURASDET");
                myAuditSx.setCAMPOCLAVE("LTD_ID");
                myAuditSx.setVLRCAMPOCLAVE(objNuevo.getLTD_ID());
                myAuditSx.setID_USUARIO(idUsuario);
                myAuditSx.setIP(myIp);
                myAuditSx.setNOMBREEQUIPO(myHost);
                myAuditoria.auditarEdicion(conn, myAuditSx, objAnterior, objNuevo, myIp, myHost, 0);
                //-- para la auditoria
            }
        } catch (Exception e) {
            e.printStackTrace();
            ;
        } finally {
            conexion.cerrarCx();
        }
        return res;
    }

    public int crearL_FACTURAS(Factura factura, int idUsuario, String myIp, String myHost) {
        List lista = null;
        int id = 0;
        try {
            //Campos para la auditoria
            conn = conexion.conectar();
            facturaDao.create(conn, factura, myMotor);
            //auditar
            Auditoria myAuditoria = new Auditoria();
            AuditoriaSystem myAuditSx = new AuditoriaSystem();
            myAuditSx.setTABLAAFECTADA("L_FACTURAS");
            myAuditSx.setCAMPOCLAVE("LF_ID");
            myAuditSx.setVLRCAMPOCLAVE(String.valueOf(factura.getLF_ID()));
            myAuditSx.setID_USUARIO(idUsuario);
            myAuditSx.setIP(myIp);
            myAuditSx.setNOMBREEQUIPO(myHost);
            myAuditoria.auditarInsersion(conn, myAuditSx, factura, 0);

        } catch (Exception e) {
            e.printStackTrace();
            ;
        } finally {
            conexion.cerrarCx();
        }
        return id;
    }

    public int crearL_FACTURASTEMP(Factura factura, int idUsuario, String myIp, String myHost) {
        List lista = null;
        int id = 0;
        try {
            //Campos para la auditoria
            conn = conexion.conectar();
            facturaDao.createTemp(conn, factura, myMotor);
            //auditar
            Auditoria myAuditoria = new Auditoria();
            AuditoriaSystem myAuditSx = new AuditoriaSystem();
            myAuditSx.setTABLAAFECTADA("L_FACTURASTEMP");
            myAuditSx.setCAMPOCLAVE("LF_ID");
            myAuditSx.setVLRCAMPOCLAVE(String.valueOf(factura.getLF_ID()));
            myAuditSx.setID_USUARIO(idUsuario);
            myAuditSx.setIP(myIp);
            myAuditSx.setNOMBREEQUIPO(myHost);
            myAuditoria.auditarInsersion(conn, myAuditSx, factura, 0);

        } catch (Exception e) {
            e.printStackTrace();
            ;
        } finally {
            conexion.cerrarCx();
        }
        return id;
    }

    public int modificarNumeroFacturaRunt(Factura factura, int idUsuario, String myIp, String myHost) {
        List lista = null;
        int id = 0;
        try {
            conn = conexion.conectar();
            //auditar
            Factura anterior = new Factura();
            anterior.setLF_ID(factura.getLF_ID());
            facturaDao.load(conn, anterior);
            facturaDao.saveNumeroFacturaRunt(conn, factura);
            //auditar
            Auditoria myAuditoria = new Auditoria();
            AuditoriaSystem myAuditSx = new AuditoriaSystem();
            myAuditSx.setTABLAAFECTADA("L_FACTURAS");
            myAuditSx.setCAMPOCLAVE("LF_ID");
            myAuditSx.setVLRCAMPOCLAVE(String.valueOf(factura.getLF_ID()));
            myAuditSx.setID_USUARIO(idUsuario);
            myAuditSx.setIP(myIp);
            myAuditSx.setNOMBREEQUIPO(myHost);
            myAuditoria.auditarEdicion(conn, myAuditSx, anterior, factura, myIp, myHost, 0);


        } catch (Exception e) {
            e.printStackTrace();
            ;
        } finally {
            conexion.cerrarCx();
        }
        return id;
    }

    public Factura buscarFactura(String idVehiculo, String idPersona) {
        List lista = null;
        int id = 0;
        Factura factura = new Factura();
        if(idPersona!= null)      
        {
            if(!idPersona.equals(""))
            {
                factura.setLF_ID_PERSONA(idPersona);
            }
        }
        
        factura.setLF_V_ID(idVehiculo);
        factura.setLF_ESTADO("1");
        try {
            conn = conexion.conectar();
            lista = (List)facturaDao.searchMatching(conn, factura);
            if (lista != null && lista.size() > 0) {
                factura = (Factura)lista.get(0);
            } else {
                factura.setLF_NUMERO("0");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return factura;
    }


    public int crearL_FACTURAS_DET(FacturaDet facturaDet, int idUsuario, String myIp, String myHost) {
        List lista = null;
        int id = 0;

        try {
            conn = conexion.conectar();
            facturaDetDao.create(conn, facturaDet);
            //auditar
            Auditoria myAuditoria = new Auditoria();
            AuditoriaSystem myAuditSx = new AuditoriaSystem();
            myAuditSx.setTABLAAFECTADA("L_FACTURASDET");
            myAuditSx.setCAMPOCLAVE("LFD_ID");
            myAuditSx.setVLRCAMPOCLAVE(String.valueOf(facturaDet.getLFD_ID()));
            myAuditSx.setID_USUARIO(idUsuario);
            myAuditSx.setIP(myIp);
            myAuditSx.setNOMBREEQUIPO(myHost);
            myAuditoria.auditarInsersion(conn, myAuditSx, facturaDet, 0);

        } catch (Exception e) {
            e.printStackTrace();
            ;
        } finally {
            conexion.cerrarCx();
        }
        return id;
    }

    public int crearL_FACTURAS_DETTEMP(FacturaDet facturaDet, int idUsuario, String myIp, String myHost) {
        List lista = null;
        int id = 0;

        try {
            conn = conexion.conectar();
            facturaDetDao.createTemp(conn, facturaDet);
            //auditar
            Auditoria myAuditoria = new Auditoria();
            AuditoriaSystem myAuditSx = new AuditoriaSystem();
            myAuditSx.setTABLAAFECTADA("L_FACTURASDETTEMP");
            myAuditSx.setCAMPOCLAVE("LFD_ID");
            myAuditSx.setVLRCAMPOCLAVE(String.valueOf(facturaDet.getLFD_ID()));
            myAuditSx.setID_USUARIO(idUsuario);
            myAuditSx.setIP(myIp);
            myAuditSx.setNOMBREEQUIPO(myHost);
            myAuditoria.auditarInsersion(conn, myAuditSx, facturaDet, 0);

        } catch (Exception e) {
            e.printStackTrace();
            ;
        } finally {
            conexion.cerrarCx();
        }
        return id;
    }

    public int getGeneradorL_Factura() {
        ArrayList lista = null;
        int gen = 0;
        try {
            conn = conexion.conectar();
            gen = facturaDao.getMaxId(conn,myMotor);
        } catch (Exception e) {

        } finally {
            conexion.cerrarCx();
        }
        return gen;
    }

    public int getGeneradorL_FacturaTemp() {
        ArrayList lista = null;
        int gen = 0;
        try {
            conn = conexion.conectar();
            gen = facturaDao.getMaxIdTemp(conn, myMotor);
        } catch (Exception e) {

        } finally {
            conexion.cerrarCx();
        }
        return gen;
    }

    public int getGeneradorL_FacturaNuevo() {
        int gen = 0;
        myMotor = "";
        
        try{
            myMotor = Funciones.leer_ini("/WSTransito.ini", "MOTOR");
        }catch(Exception exce){}
        if(myMotor.equals(""))
        try{
            myMotor = Funciones.leer_ini("c:\\WSTransito.ini", "MOTOR");
        }catch(Exception exce){}
        
        System.out.println("getGeneradorL_FacturaNuevo =" + myMotor);
        try {
            conn = conexion.conectar();
            gen = facturaDao.getNuevoFacturaId(conn, myMotor);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return gen;
    }

    public int getGeneradorL_FacturaTempNuevo() {
        int gen = 0;
        myMotor = Funciones.leer_ini("/WSTransitoArmeniaContravencional.ini", "MOTOR");
        System.out.println("getGeneradorL_FacturaNuevo =" + myMotor);
        try {
            conn = conexion.conectar();
            gen = facturaDao.getNuevoFacturaTempId(conn, myMotor);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return gen;
    }


    public int getGeneradorL_FacturaDet() {
        ArrayList lista = null;
        int gen = 0;
        try {
            conn = conexion.conectar();
            gen = facturaDetDao.getMaxId(conn, myMotor);
        } catch (Exception e) {

        } finally {
            conexion.cerrarCx();
        }
        return gen;
    }

    public int getGeneradorL_FacturaDetTemp() {
        ArrayList lista = null;
        int gen = 0;
        try {
            conn = conexion.conectar();
            gen = facturaDetDao.getMaxIdTemp(conn, myMotor);
        } catch (Exception e) {

        } finally {
            conexion.cerrarCx();
        }
        return gen;
    }

    public String getNumeroFactura(int idL_factura) {
        
        
        int numerosecuencia = 0;
        myMotor = "";
        
        try{
            myMotor = Funciones.leer_ini("/WSTransito.ini", "MOTOR");
        }catch(Exception exce){}
        if(myMotor.equals(""))
        try{
            myMotor = Funciones.leer_ini("c:\\WSTransito.ini", "MOTOR");
        }catch(Exception exce){}
        
        GestionServiciosTransitoLocal mygestiontransito = new GestionServiciosTransitoLocal();
        Transito transito = mygestiontransito.getTransito();

        System.out.println("getNumeroFactura =" + myMotor);

        if (myMotor.equals("FIREBIRD"))
            numerosecuencia = getGeneradorL_FacturaNuevo() - 1;
        else if (myMotor.equals("ORACLE"))
            numerosecuencia = getGeneradorL_FacturaNuevo();

        if (numerosecuencia > -1) {
            Date date = new Date();
            SimpleDateFormat formatter = new SimpleDateFormat("yyMMdd");
            String str_date = (String)formatter.format(date);
            //String numero = "1" + str_date + idL_factura;
            String numero="";
            
            if(transito.getPREFIJOFACTURACION()!=null)
            {
             numero = transito.getPREFIJOFACTURACION().toString() + str_date + numerosecuencia;
            } else {
                numero = "1" + str_date + numerosecuencia;
            }

            return numero;
        }
        return "";
    }

    public String getNumeroFacturaTemp(int idL_factura) {


        int numerosecuencia = 0;
        myMotor = Funciones.leer_ini("/WSTransitoArmeniaContravencional.ini", "MOTOR");

        GestionServiciosTransitoLocal mygestiontransito = new GestionServiciosTransitoLocal();
        Transito transito = mygestiontransito.getTransito();

        System.out.println("getNumeroFactura =" + myMotor);

        if (myMotor.equals("FIREBIRD"))
            numerosecuencia = getGeneradorL_FacturaTempNuevo() - 1;
        else if (myMotor.equals("ORACLE"))
            numerosecuencia = getGeneradorL_FacturaTempNuevo();

        if (numerosecuencia > -1) {
            Date date = new Date();
            SimpleDateFormat formatter = new SimpleDateFormat("yyMMdd");
            String str_date = (String)formatter.format(date);
            //String numero = "1" + str_date + idL_factura;
            String numero = "";

            if (transito.getPREFIJOFACTURACION() != null) {
                numero = transito.getPREFIJOFACTURACION().toString() + str_date + numerosecuencia;
            } else {
                numero = "1" + str_date + numerosecuencia;
            }

            return numero;
        }
        return "";
    }


    public String getFechaFactura() {

        String str_date = "";

        if (myMotor.equals("FIREBIRD")) {
            Date date = new Date();
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            str_date = (String)formatter.format(date);
            System.out.println(str_date);

        } else if (myMotor.equals("ORACLE")) {
            Date date = new Date();
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yy hh:mm:ss");
            str_date = (String)formatter.format(date);
            System.out.println(str_date);

        }
        return str_date;
    }

    public boolean permiteMultipleLiquidacion(int ltd_id) {
        boolean permite = false;
        try {
            LtarifasDetDao tarifasDetDao = new LtarifasDetDao();
            LtarifasDao tarifasDao = new LtarifasDao();
            conn = conexion.conectar();
            LtarifasDet tarifasDet = new LtarifasDet(ltd_id);
            tarifasDetDao.load(conn, tarifasDet);
            Ltarifas tarifas = new Ltarifas(tarifasDet.getLTD_LT_ID());
            tarifasDao.load(conn, tarifas);
            if (tarifas.getLT_LIQMULTIPLE() == 1)
                permite = true;
            else
                permite = false;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return permite;
    }

    public boolean editarNotaFactura(String lf_numero, String lf_nota) {
        boolean res = false;
        try {
            conn = conexion.conectar();
            facturaDao.editarNotaFactura(conn, lf_numero, lf_nota);
            res = true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return res;
    }

    public boolean ActualizarSecuencialFacturas(int valor) {
        myMotor = "";
        
        try{
            myMotor = Funciones.leer_ini("/WSTransito.ini", "MOTOR");
        }catch(Exception exce){}
        if(myMotor.equals(""))
        try{
            myMotor = Funciones.leer_ini("c:\\WSTransito.ini", "MOTOR");
        }catch(Exception exce){}
        boolean res = false;
        try {
            conn = conexion.conectar();
            facturaDao.actualizarNuevoFacturaId(conn, valor, myMotor);
            res = true;
        } catch (Exception e) {
            res = false;
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return res;

    }

    public int ConsultarSecuencialFacturas() {

        myMotor = "";
        
        try{
            myMotor = Funciones.leer_ini("/WSTransito.ini", "MOTOR");
        }catch(Exception exce){}
        if(myMotor.equals(""))
        try{
            myMotor = Funciones.leer_ini("c:\\WSTransito.ini", "MOTOR");
        }catch(Exception exce){}

        
        int res;
        try {
            conn = conexion.conectar();
            res = facturaDao.consultarNuevoFacturaId(conn, myMotor);

        } catch (Exception e) {
            res = -1;
            e.printStackTrace();
        } finally {
            conexion.cerrarCx();
        }
        return res;

    }

    public Factura crearFacturaSimple(Factura obj) {
        List lista = null;
        try {
            FacturaDao dao = new FacturaDao();
            myMotor = Funciones.leer_ini("/WSTransitoArmeniaContravencional.ini", "MOTOR");
            
            
            int id = getGeneradorL_Factura();
            obj.setLF_ID(id);
            obj.setLF_FECHA(getFechaFactura());
            conn = conexion.conectar();
            dao.createSimple(conn, obj, myMotor);
            
            //verificar existencia
            obj = new Factura();
            obj.setLF_ID(id);
            lista = dao.searchMatching(conn, obj);
            if (lista != null && lista.size() > 0) {
                obj = (Factura)lista.get(0);
            } else {
                obj.setLF_ID(-1);
            }
        } catch (Exception e) {
            e.printStackTrace();
            obj.setLF_ID(-1);
        } finally {
            conexion.cerrarCx();
        }
        return obj;
      

    }
    
    public boolean setFacturaEstadoPagoSimple(Factura obj)
    {
        boolean resultado;
        resultado = false;
        int id = 0;
        try {
            FacturaDao dao = new FacturaDao();
            conn = conexion.conectar();
            dao.saveEstadoPagado(conn, obj);
            resultado = true;
        } catch (Exception e) {
            e.printStackTrace();
            resultado = false;
        } finally {
            conexion.cerrarCx();
        }
        return resultado;
        
        
        
    }
    


}
