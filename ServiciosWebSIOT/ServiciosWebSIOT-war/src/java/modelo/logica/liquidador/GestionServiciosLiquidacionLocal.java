package modelo.logica.liquidador;

import java.sql.Connection;

import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import modelo.conexion.Conexion;

import modelo.datos.dao.liquidador.ConceptosTarifaDao;
import modelo.datos.dao.liquidador.FacturaDao;
import modelo.datos.dao.liquidador.FacturaDetDao;
import modelo.datos.dao.liquidador.SalarioDao;
import modelo.datos.dao.liquidador.TarifaDao;
import modelo.datos.objetos.generales.Header;
import modelo.datos.objetos.generales.Persona;
import modelo.datos.objetos.generales.ViewPropietario;
import modelo.datos.objetos.generales.vehiculo.Vehiculo;
import modelo.datos.objetos.liquidador.ConceptosTarifa;
import modelo.datos.objetos.liquidador.DatosAdicionalesFactura;
import modelo.datos.objetos.liquidador.DatosFactura;
import modelo.datos.objetos.liquidador.Factura;
import modelo.datos.objetos.liquidador.FacturaDet;
import modelo.datos.objetos.liquidador.Tarifa;

import servicios.generales.ServiciosEmpresas;
import servicios.generales.ServiciosPersonas;
import servicios.generales.ServiciosVehiculos;
import servicios.generales.ServiciosViewPropietario;

import utilidades.Compilador;
import utilidades.Funciones;
import utilidades.GenerarReportes;


//import modelo.datos.objetos.generales.Header;


public class GestionServiciosLiquidacionLocal {

    Conexion conexion;
    Connection conn;
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
    String myMotor;


    public GestionServiciosLiquidacionLocal() {
        super();
        crearObjetos();
    }

    public void crearObjetos() {
        conexion = new Conexion();
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

    public List getTarifas(Tarifa tarifa) {
        List lista = null;
        try {
            conn = conexion.conectar();
            if (tarifa != null && !tarifa.getLT_VIGENCIA().equals("")) {
                lista = (ArrayList)tarifaDao.searchMatching(conn, tarifa);
            } else {
                lista = (ArrayList)tarifaDao.loadAll(conn);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            conexion.cerrarCx();
        }
        return lista;
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


    public List getConceptosTarifa(ConceptosTarifa conceptoTarifa, Vehiculo vehi) {
        List lista = null;
        String valor = "";
        try {
            conn = conexion.conectar();
            lista = (ArrayList)conceptosTarifaDao.searchMatching(conn, conceptoTarifa);
            if (lista != null && lista.size() > 0) {
                for (int i = 0; i < lista.size(); i++) {
                    conceptoTarifa = (ConceptosTarifa)lista.get(i);
                    valor =
                            compilador.compilar(conceptoTarifa.getLTD_CALCULO(), conceptoTarifa.getLT_VIGENCIA(), vehi, "");
                    conceptoTarifa.setLTD_VALOR(valor);
                    lista.remove(i);
                    lista.add(i, conceptoTarifa);
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            conexion.cerrarCx();
        }
        return lista;
    }


    public DatosFactura facturar(Header header, List listaConceptos, DatosAdicionalesFactura datosAdionalesFactura, String avaluo) throws Exception {
        DatosFactura datosFactura = new DatosFactura();
        Tarifa tarifa;
        ConceptosTarifa conceptoTarifa;
        Factura factura = new Factura();
        FacturaDet facturaDet = null;
        int idL_factura = 0;
        int idL_facturaDet = 0;
        idL_factura = getGeneradorL_Factura();
        factura.setLF_ESTADO("1");
        String numeroFactura = "";
        ViewPropietario propietario = new ViewPropietario();

        factura.setLF_FECHA(getFechaFactura());
        factura.setLF_TOTAL(String.valueOf(datosAdionalesFactura.getTotal()));
        factura.setLF_NOTA(datosAdionalesFactura.getNota());
        factura.setLF_ID_USUARIO(header.getIdUsuario());
        numeroFactura = getNumeroFactura(idL_factura);
        factura.setLF_NUMERO(numeroFactura);
        factura.setLF_ID(idL_factura);
        if (datosAdionalesFactura.getTipoPE().equals("1")) { // persona
            factura.setLF_ID_PERSONA(datosAdionalesFactura.getIdPersona());
            Persona persona = new Persona();
            persona.setID_PERSONAS(Integer.parseInt(datosAdionalesFactura.getIdPersona()));
            try{
            persona = serviciosPersonas.getPersona(persona);
            }catch(Exception e){throw new Exception (e.getMessage());};
            propietario.setEMPPER("PER");
            propietario.setIDENTIFICACION(persona.getIDENTIFICACION());
            propietario.setNOMBRE(persona.getNOMBRES());
        } else if (datosAdionalesFactura.getTipoPE().equals("2")) { // vehiculo
            factura.setLF_V_ID(datosAdionalesFactura.getIdVehiculo());
        }

        crearL_FACTURAS(factura);

        for (int i = 0; i < listaConceptos.size(); i++) {

            idL_facturaDet = getGeneradorL_FacturaDet();
            conceptoTarifa = (ConceptosTarifa)listaConceptos.get(i);
            facturaDet = new FacturaDet();
            facturaDet.setLFD_ID(idL_facturaDet);
            facturaDet.setLFD_LCC_ID(conceptoTarifa.getLCC_ID());
            facturaDet.setLFD_LF_ID(String.valueOf(idL_factura));

            facturaDet.setLFD_LTD_ID(conceptoTarifa.getLTD_ID());
            facturaDet.setLFD_VIGENCIA(conceptoTarifa.getLT_VIGENCIA());
            if (conceptoTarifa.getLTD_VALOR() != null && !conceptoTarifa.getLTD_VALOR().equals("")) {
                facturaDet.setLFD_VALOR(conceptoTarifa.getLTD_VALOR());
            }
            crearL_FACTURAS_DET(facturaDet);
        }


        try {
            Vehiculo vehiculo = new Vehiculo();
            if (datosAdionalesFactura.getIdVehiculo() != null) {
                vehiculo.setID_VEHICULO(Integer.parseInt(datosAdionalesFactura.getIdVehiculo()));
                vehiculo = serviciosVehiculos.getVehiculo(vehiculo);


                propietario.setID_VEHICULO(Integer.parseInt(datosAdionalesFactura.getIdVehiculo()));

                List listaPropietarios = serviciosViewPropietarios.listarViewPropietarios(propietario);
                if (listaPropietarios != null && listaPropietarios.size() > 0) {
                    propietario = (ViewPropietario)listaPropietarios.get(0);
                }
            }
            
            String codigoBarras = "11111111102222222202333333333044444444405855555550";

            generarReportes.generarReporte(listaConceptos, numeroFactura, vehiculo, propietario, factura.getLF_TOTAL(),
                                           factura.getLF_TOTAL(), "1 de 1", factura.getLF_TOTAL(), codigoBarras, avaluo);

            datosFactura.setNumeroFacturaLocal(numeroFactura);

            datosFactura.setTotalFacturaLocal(factura.getLF_TOTAL());
        } catch (Exception e) {
            System.out.println("error mensajes=" + e.getMessage());
        }
        return datosFactura;
    }


    public int crearL_FACTURAS(Factura factura) {
        List lista = null;
        int id = 0;
        try {
            conn = conexion.conectar();
            facturaDao.create(conn, factura, myMotor);

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
        factura.setLF_ID_PERSONA(idPersona);
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
            ;
        } finally {
            conexion.cerrarCx();
        }
        System.out.println("consultar factura ");
        return factura;
    }


    public int crearL_FACTURAS_DET(FacturaDet facturaDet) {
        List lista = null;
        int id = 0;
        try {
            conn = conexion.conectar();
            facturaDetDao.create(conn, facturaDet);

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
            gen = facturaDao.getMaxId(conn, myMotor);
        } catch (Exception e) {

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

    public String getNumeroFactura(int idL_factura) {

        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyMMdd");
        String str_date = (String)formatter.format(date);
        String numero = "1" + str_date + idL_factura;
        return numero;
    }

    public String getFechaFactura() {

        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String str_date = (String)formatter.format(date);
        System.out.println(str_date);
        return str_date;
    }


}
