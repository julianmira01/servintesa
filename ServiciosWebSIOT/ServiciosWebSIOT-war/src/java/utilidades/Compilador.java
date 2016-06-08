package utilidades;


import java.sql.Connection;

import java.text.NumberFormat;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Vector;

import modelo.conexion.Conexion;

import modelo.datos.dao.comparendos.generales.ComparendoCompDao;
import modelo.datos.dao.comparendos.generales.InfracionComparendoCompDao;
import modelo.datos.dao.comparendos.generales.InfractorCompDao;
import modelo.datos.dao.generales.LicenciaDeTransitoDao;
import modelo.datos.dao.generales.LimitacionPropVehiculoDao;
import modelo.datos.dao.generales.PropietarioDeVehiculoDao;
import modelo.datos.dao.generales.ViewPropietarioDao;
import modelo.datos.dao.generales.vehiculo.LInfoVehiculoDao;
import modelo.datos.dao.generales.vehiculo.VehInmovilizacionDao;
import modelo.datos.dao.medidasCautelares.JPendienteViewCTDao;
import modelo.datos.objetos.avaluos.Avaluo;
import modelo.datos.objetos.avaluos.ClaseVehiculoAvaluo;
import modelo.datos.objetos.comparendos.generales.ComparendoComp;
import modelo.datos.objetos.comparendos.generales.InfracionComparendoComp;
import modelo.datos.objetos.comparendos.generales.InfractorComp;
import modelo.datos.objetos.generales.LicenciaDeTransito;
import modelo.datos.objetos.generales.LimitacionPropVehiculo;
import modelo.datos.objetos.generales.ViewPropietario;
import modelo.datos.objetos.generales.propietarioDeVehiculo.PropietarioDeVehiculo;
import modelo.datos.objetos.generales.vehiculo.LInfoVehiculo;
import modelo.datos.objetos.generales.vehiculo.VehInmovilizacion;
import modelo.datos.objetos.generales.vehiculo.Vehiculo;
import modelo.datos.objetos.liquidador.Salario;
import modelo.datos.objetos.medidasCautelares.JPendienteViewCT;

import modelo.logica.generales.GestionServiciosAvaluos;


/**
 * <p>T-*-tulo: </p>
 * <p>Descripci-*-n: </p>
 * <p>Copyright: Copyright (c) 2007</p>
 * <p>Empresa: </p>
 * @author sin atribuir
 * @version 1.0
 */

public class Compilador {

    /*Variables*/

    /*Conexion a la base*/

    public String avalu;
    public String grupo;
    public Vector vigenciaErrada;
    private ArrayList salarios;
    private String[] fecha;
    private Vehiculo carro;
    public Integer vigenciaInmovilizacion = null;
    public String descripcion;

    public Connection conn;
    public Connection connComp;
    public Conexion conexion;
    public Conexion conexionComp;
    public String myMotor;

    public Compilador(String[] fecha, ArrayList salarios) {
        this.fecha = fecha;
        this.salarios = salarios;
        avalu = "";
        grupo = "";
        vigenciaErrada = new Vector();
    }

    public static void main(String[] args) {
        //String ar="IF(ID_MOTIVOCANCELACION=NULL,,ACTIVO)\nIF(VIGENCIA_PAGADA<ANO,IMPUESTO,)\n ";
        //Compilador compilador1 = new Compilador();
        //System.out.println(compilador1.flotanteAstring(ar,"2008","15227",""));
        //System.out.println(compilador1.flotanteAstring(4615598));
        String[] fecha = { "" };
        ArrayList salarios = null;
        int idVehiculo = 14119;
        String res;

        Compilador com = new Compilador(fecha, salarios);

        com.vigenciaInmovilizacion = 2011;
        res =
com.getInmovilizacionMeses(idVehiculo) + " meses " + com.getInmovilizacionDias(idVehiculo) + " dias " + com.getInmovilizacionHoras(idVehiculo) +
  " horas";
        System.out.println(res);

        com.vigenciaInmovilizacion = 2012;
        res =
com.getInmovilizacionMeses(idVehiculo) + " meses " + com.getInmovilizacionDias(idVehiculo) + " dias " + com.getInmovilizacionHoras(idVehiculo) +
  " horas";
        System.out.println(res);
    }

    public String operacion(String opera, String vigencia, String tie) {
        String resultado = "";
        int cord = 0;

        while ((opera.indexOf("(") != -1) && (opera.indexOf(")") != -1)) {
            for (int i = 0; i < opera.length(); i++) {
                if (opera.charAt(i) == '(')
                    cord = i;
                else if (opera.charAt(i) == ')') {
                    resultado = opera.substring(cord + 1, i);
                    resultado = resolver(resultado, vigencia, tie);
                    opera = remplaza(opera, resultado, cord, i);
                }
            }
        }
        this.descripcion = opera;
        opera = resolver(opera, vigencia, tie);
        return opera;
    }

    private String remplaza(String opera, String cambio, int ini, int fin) {
        String res = "";
        char l;
        for (int i = 0; i < opera.length(); i++) {
            l = opera.charAt(i);
            if (i >= ini && i <= fin) {
                res = res + cambio;
                i = fin;
            } else
                res = res + opera.charAt(i);
        }
        return res;
    }

    private double getSalario(String vigencia) {
        Iterator it;
        Salario salario;
        double sala = 0;
        try {
            it = salarios.iterator();
            while (it.hasNext() && sala == 0) {
                salario = (Salario)it.next();

                if (salario.getANO() == Integer.parseInt(vigencia))
                    sala = Double.parseDouble(salario.getVALOR());
            }
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("Error en getSalario Pedro " + e.getMessage());
        }
        return sala;
    }

    private String resolver(String resultado, String vigencia, String tie) {
        //AvaluoFacade verAvaluo=null;
        //Avaluos avaluo=null;
        Date fechaHoy = new Date();
        double a, salario, salarioa;
        float sal = 0;
        int i;
        String aux = "", aa;
        salario = salarioa = 0;

        while (resultado.indexOf("SMLVD") != -1) {
            if (salario == 0)
                salario = getSalario(vigencia);
            System.out.println("SSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSAlario=" + salario);
            aux = flotanteAstring(salario / 30);
            resultado = remplaza(resultado, aux, resultado.indexOf("SMLVD"), resultado.indexOf("SMLVD") + 4);
            System.out.println("SSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSResultado=" + resultado);
        }

        while (resultado.indexOf("SMLDV") != -1) {
            if (salario == 0)
                salario = getSalario(vigencia);
            aux = flotanteAstring(salario / 30);
            resultado = remplaza(resultado, aux, resultado.indexOf("SMLDV"), resultado.indexOf("SMLDV") + 4);
        }

        while (resultado.indexOf("SMLAD") != -1) {
            if (salarioa == 0)
                salarioa = getSalario(fecha[2]);
            aux = flotanteAstring(salarioa / 30);
            resultado = remplaza(resultado, aux, resultado.indexOf("SMLAD"), resultado.indexOf("SMLAD") + 4);
            //System.out.println(resultado);
        }

        while (resultado.indexOf("SMLA") != -1) {
            if (salarioa == 0)
                salarioa = getSalario(fecha[2]);
            aux = flotanteAstring(salarioa);
            resultado = remplaza(resultado, aux, resultado.indexOf("SMLA"), resultado.indexOf("SMLA") + 3);
            //System.out.println(resultado);
        }

        while (resultado.indexOf("SMLV") != -1) {
            if (salario == 0)
                salario = getSalario(vigencia);
            aux = flotanteAstring(salario);
            resultado = remplaza(resultado, aux, resultado.indexOf("SMLV"), resultado.indexOf("SMLV") + 3);
            //System.out.println(resultado);
        }

        /*while (resultado.indexOf("AVALUO") != -1) {
            double valAvaluo = 100000;
            valAvaluo = getAvaluo(vigencia);
            aux = flotanteAstring(valAvaluo);
            resultado =
                remplaza(resultado, aux, resultado.indexOf("AVALUO"), resultado.indexOf("AVALUO") + 5);
            //System.out.println(resultado);
        }*/

        while (resultado.indexOf("CAPACIDADTON") != -1) {
            aux = carro.getCAPACIDADTON() == null ? "0" : carro.getCAPACIDADTON();
            sal = Float.valueOf(aux).floatValue();
            resultado =
                    remplaza(resultado, Float.toString(sal), resultado.indexOf("CAPACIDADTON"), resultado.indexOf("CAPACIDADTON") +
                             11);
            //System.out.println(resultado);
        }

        while (resultado.indexOf("CAPACIDADPAS") != -1) {
            aux = carro.getCAPACIDAD() == null ? "0" : carro.getCAPACIDAD();
            sal = Float.valueOf(aux).floatValue();
            resultado =
                    remplaza(resultado, Float.toString(sal), resultado.indexOf("CAPACIDADPAS"), resultado.indexOf("CAPACIDADPAS") +
                             11);
            //System.out.println(resultado);
        }

        while (resultado.indexOf("ID_CVEHICULO") != -1) {
            sal = Float.valueOf(carro.getID_CVEHICULO() == null ? "0" : carro.getID_CVEHICULO()).floatValue();
            resultado =
                    remplaza(resultado, Float.toString(sal), resultado.indexOf("ID_CVEHICULO"), resultado.indexOf("ID_CVEHICULO") +
                             11);
            //System.out.println(resultado);
        }

        while (resultado.indexOf("ID_SERVICIO") != -1) {
            if (tie == null || tie.equals("")) {
                sal = Float.valueOf(carro.getID_SERVICIO() == null ? "0" : carro.getID_SERVICIO()).floatValue();
            } else {
                sal = Float.valueOf(tie).floatValue();
            }
            resultado =
                    remplaza(resultado, Float.toString(sal), resultado.indexOf("ID_SERVICIO"), resultado.indexOf("ID_SERVICIO") +
                             10);
            //System.out.println(resultado);
        }

        while (resultado.indexOf("CILINDRAJE") != -1) {
            sal = Float.valueOf(carro.getCILINDRAJE() == null ? "0" : carro.getCILINDRAJE()).floatValue();
            resultado =
                    remplaza(resultado, Float.toString(sal), resultado.indexOf("CILINDRAJE"), resultado.indexOf("CILINDRAJE") +
                             10);
            //System.out.println(resultado);
        }

        while (resultado.indexOf("ID_MOTIVOCANCELACION") != -1) {
            aux = carro.getID_MOTIVOCANCELACION() == null ? "0" : carro.getID_MOTIVOCANCELACION();
            resultado =
                    remplaza(resultado, aux, resultado.indexOf("ID_MOTIVOCANCELACION"), resultado.indexOf("ID_MOTIVOCANCELACION") +
                             19);
            //System.out.println(resultado);
        }

        while (resultado.indexOf("LIV_VIGENCIA_PAGADA") != -1) {
            aux = vigenciaUltimoImpuestoPago(carro);
            resultado =
                    remplaza(resultado, aux, resultado.indexOf("LIV_VIGENCIA_PAGADA"), resultado.indexOf("LIV_VIGENCIA_PAGADA") +
                             "LIV_VIGENCIA_PAGADA".length() - 1);
        }
        while (resultado.indexOf("VIGENCIA_PAGADA") != -1) {
            //aux = carro.getVigencia();
            aux = vigenciaUltimoImpuestoPago(carro);
            //TODO
            resultado =
                    remplaza(resultado, aux, resultado.indexOf("VIGENCIA_PAGADA"), resultado.indexOf("VIGENCIA_PAGADA") +
                             14);
        }

        while (resultado.indexOf("ANO") != -1) {
            String ano = "" + (new Date().getYear() + 1900);
            resultado = remplaza(resultado, ano, resultado.indexOf("ANO"), resultado.indexOf("ANO") + 2);
        }
        
        while (resultado.indexOf("MESES") != -1) {
            String meses = "" + (12 - (new Date().getMonth() + 1));
            //System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX" + meses);
            resultado = meses;
            //remplaza(resultado, meses, resultado.indexOf("MESES"), resultado.indexOf("MESES") + 2);
            System.out.println("YYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYY" + resultado);
        }

        while (resultado.indexOf("MESES") != -1) {
            String meses = "" + (12 - (new Date().getMonth() + 1));
            //System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX" + meses);
            resultado = meses;
            //remplaza(resultado, meses, resultado.indexOf("MESES"), resultado.indexOf("MESES") + 2);
            System.out.println("YYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYY" + resultado);
        }

        //para condicines de liquidacion
        while (resultado.indexOf("VEHREGIST") != -1) {
            aux = estaVehiculoRegistrado(carro);
            resultado =
                    remplaza(resultado, aux, resultado.indexOf("VEHREGIST"), resultado.indexOf("VEHREGIST") + "VEHREGIST".length() -
                             1);
        }
        while (resultado.indexOf("VEHACTIVO") != -1) {
            aux = esVehiculoActivo(carro);
            resultado =
                    remplaza(resultado, aux, resultado.indexOf("VEHACTIVO"), resultado.indexOf("VEHACTIVO") + "VEHACTIVO".length() -
                             1);
        }
        while (resultado.indexOf("COMPARENDO") != -1) {
            aux = tieneComparendos(carro);
            resultado =
                    remplaza(resultado, aux, resultado.indexOf("COMPARENDO"), resultado.indexOf("COMPARENDO") + "COMPARENDO".length() -
                             1);
        }
        while (resultado.indexOf("LIMITACION") != -1) {
            aux = tieneLimitacion(carro);
            resultado =
                    remplaza(resultado, aux, resultado.indexOf("LIMITACION"), resultado.indexOf("LIMITACION") + "LIMITACION".length() -
                             1);
        }

        while (resultado.indexOf("CAUTELARES") != -1) {
            aux = tieneMedidaCautelar(carro);
            resultado =
                    remplaza(resultado, aux, resultado.indexOf("CAUTELARES"), resultado.indexOf("CAUTELARES") + "CAUTELARES".length() -
                             1);
        }


        while (resultado.indexOf("PENDIENTEJUDICIAL") != -1) {
            aux = tienePendienteJudicial(carro);
            resultado =
                    remplaza(resultado, aux, resultado.indexOf("PENDIENTEJUDICIAL"), resultado.indexOf("PENDIENTEJUDICIAL") +
                             "PENDIENTEJUDICIAL".length() - 1);
        }
        while (resultado.indexOf("ID_MOTIVOCANCELACION") != -1) {
            aux = tieneMotivoCancelacion(carro);
            resultado =
                    remplaza(resultado, aux, resultado.indexOf("ID_MOTIVOCANCELACION"), resultado.indexOf("ID_MOTIVOCANCELACION") +
                             "ID_MOTIVOCANCELACION".length() - 1);
        }
        while (resultado.indexOf("IDVIDAUTIL") != -1) {
            aux = vidaUtil(carro);
            resultado =
                    remplaza(resultado, aux, resultado.indexOf("IDVIDAUTIL"), resultado.indexOf("IDVIDAUTIL") + "IDVIDAUTIL".length() -
                             1);
        }
        while (resultado.indexOf("IDCANCELACION") != -1) {
            aux = cancelacion(carro);
            resultado =
                    remplaza(resultado, aux, resultado.indexOf("IDCANCELACION"), resultado.indexOf("IDCANCELACION") +
                             "IDCANCELACION".length() - 1);
        }
        while (resultado.indexOf("VLRFACTURA") != -1) {
            aux = "0";
            if (carro.getVLRFACTURA() != null && carro.getVLRFACTURA() != "")
                aux = carro.getVLRFACTURA();
            resultado =
                    remplaza(resultado, aux, resultado.indexOf("VLRFACTURA"), resultado.indexOf("VLRFACTURA") + "VLRFACTURA".length() -
                             1);
        }
        while (resultado.indexOf("BLINDADO") != -1) {
            aux = blindado(carro);
            resultado =
                    remplaza(resultado, aux, resultado.indexOf("BLINDADO"), resultado.indexOf("BLINDADO") + "BLINDADO".length() -
                             1);
        }
        while (resultado.indexOf("INTTEMPORALMENTE") != -1) {
            aux = internadoTemporalmente(carro);
            resultado =
                    remplaza(resultado, aux, resultado.indexOf("INTTEMPORALMENTE"), resultado.indexOf("INTTEMPORALMENTE") +
                             "INTTEMPORALMENTE".length() - 1);
        }
        while (resultado.indexOf("ANTICLASI") != -1) {
            aux = esAntiguoClasico(carro);
            resultado =
                    remplaza(resultado, aux, resultado.indexOf("ANTICLASI"), resultado.indexOf("ANTICLASI") + "ANTICLASI".length() -
                             1);
        }
        /* while (resultado.indexOf("MATRSANANDRES") != -1) {
            aux = cancelacion(carro);
            resultado = remplaza(resultado, aux, resultado.indexOf("MATRSANANDRES"), resultado.indexOf("MATRSANANDRES") +
                "MATRSANANDRES".length() - 1);
        } */

        //para parqueadero
        while (resultado.indexOf("MENSUALIDAD") != -1) {
            aux = getInmovilizacionMeses(carro.getID_VEHICULO());
            resultado =
                    remplaza(resultado, aux, resultado.indexOf("MENSUALIDAD"), resultado.indexOf("MENSUALIDAD") + "MENSUALIDAD".length() -
                             1);
        }

        while (resultado.indexOf("DIARIO") != -1) {
            aux = getInmovilizacionDias(carro.getID_VEHICULO());
            resultado =
                    remplaza(resultado, aux, resultado.indexOf("DIARIO"), resultado.indexOf("DIARIO") + "DIARIO".length() -
                             1);
        }

        while (resultado.indexOf("HORAS") != -1) {
            aux = getInmovilizacionHoras(carro.getID_VEHICULO());
            resultado =
                    remplaza(resultado, aux, resultado.indexOf("HORAS"), resultado.indexOf("HORAS") + "HORAS".length() -
                             1);
        }

        descripcion = resultado;
        resultado = resultado.replaceAll(",", ".");

        System.out.println("RRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRResultado sin coma = " + resultado);

        while (resultado.indexOf("*") != -1)
        {
            resultado = resultado(resultado, "*");
            resultado = resultado.replaceAll(",", ".");
        System.out.println("RRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRResultado primera multiplicacion = " + resultado);
        }

        while (resultado.indexOf("/") != -1)
        {
            resultado = resultado(resultado, "/");
            resultado = resultado.replaceAll(",", ".");
        }

        while (resultado.indexOf("+") != -1)
        {
            resultado = resultado(resultado, "+");
            resultado = resultado.replaceAll(",", ".");
        }

        while ((resultado.indexOf("-") != -1) && !(resultado.equals("-1")))
        {
            resultado = resultado(resultado, "-");
            resultado = resultado.replaceAll(",", ".");
        }

        return resultado;
    }

    private String resultado(String resultado, String ope) {
        //     System.out.println(resultado);
        float sal = 0;
        int centro, i, ini, fin;
        String izq, der, val;

        izq = der = null;
        ini = fin = 0;

        if (resultado.indexOf(ope) != -1) {
            centro = resultado.indexOf(ope);
            for (i = centro - 1; i >= 0; i--) {
                if (((((int)resultado.charAt(i) < 47) || ((int)resultado.charAt(i) > 58)) &&
                     (resultado.charAt(i) != '.')) || (i == 0)) {
                    izq = resultado.substring(i, centro);
                    ini = i;
                    break;
                }
            }
            //    System.out.print("\n");
            for (i = centro + 1; i < resultado.length(); i++) {
                //    System.out.print(resultado.charAt(i));
                if (((((int)resultado.charAt(i) < 47) || ((int)resultado.charAt(i) > 58)) &&
                     (resultado.charAt(i) != '.')) || (i == resultado.length() - 1)) { //funcion ASCII
                    if (i == resultado.length() - 1) {
                        der = resultado.substring(centro + 1, i + 1);
                        fin = i + 1;
                    } else {
                        der = resultado.substring(centro + 1, i);
                        fin = i - 1;
                    }
                    break;
                }
            }

            if (ope == "*") {
                try {
                    sal = Float.valueOf(izq).floatValue() * Float.valueOf(der).floatValue();
                } catch (Exception ee) {
                    sal = (float)0.0;
                }
            } else if (ope == "/") {
                try {
                    sal = Float.valueOf(izq).floatValue() / Float.valueOf(der).floatValue();
                } catch (Exception ee) {
                    sal = (float)0.0;
                }
            } else if (ope == "+") {
                try {
                    sal = Float.valueOf(izq).floatValue() + Float.valueOf(der).floatValue();
                } catch (Exception ee) {
                    sal = (float)0.0;
                }
            } else if (ope == "-") {
                try {
                    sal = Float.valueOf(izq).floatValue() - Float.valueOf(der).floatValue();
                } catch (Exception ee) {
                    sal = (float)0.0;
                }
            }


            val = flotanteAstring(sal);

            return remplaza(resultado, val, ini, fin);

        }
        //return String.valueOf(remplaza(resultado,String.valueOf(sal),ini,fin));
        return "";

    }

    public boolean enLista(String pregunta, Vehiculo carro, String vigencia, String tie) {
        //ENLISTA(ID_CVEHICULO=19|17|14|10)

        String item, compara = "";
        boolean retorno = false, si = true;

        //ID_CVEHICULO
        item = pregunta.substring((pregunta.indexOf("(") + 1), pregunta.indexOf("="));
        item = resolver(item, vigencia, tie);
        item = item.substring(0, item.indexOf("."));

        //19|17|14|10
        String strValores = pregunta.substring((pregunta.indexOf("=") + 1), pregunta.indexOf(")"));
        //strValores.replace("|", ",");
        String[] valores = strValores.split("\\|");

        for (String valor : valores) {
            if (valor.equals(item))
                return true;
        }

        return false;
    }

    public Vector funciones(String argumento, String vigencia, String id, String tie) {
        Vector tarifaAnula = new Vector();
        argumento = quitarEspacios(argumento.toUpperCase());
        String linea;
        System.out.println(argumento);
        if (argumento.indexOf("\n") != -1) {
            while (argumento.indexOf("\n") != -1) {
                linea = argumento.substring(0, argumento.indexOf("\n"));
                argumento = argumento.substring(argumento.indexOf("\n") + 1, argumento.length() - 1);
                linea = compilar(linea, vigencia, null, tie);
                tarifaAnula = vectorAnulaTarifa(tarifaAnula, linea, vigencia);
            }
        }
        if (argumento.length() > 0) {
            linea = compilar(argumento, vigencia, null, tie);
            tarifaAnula = vectorAnulaTarifa(tarifaAnula, linea, vigencia);
        }
        return tarifaAnula;
    }

    private Vector vectorAnulaTarifa(Vector anula, String linea, String vigencia) {
        /*PEDRO   Vector tarifas;
	   int i;
	   if(!linea.equals("")) {
		   tarifas = datos.tarifaAnula(linea,vigencia);
		   if (tarifas.size()>0) {
			   for(i=0; i<tarifas.size(); i++) {
				   anula.addElement(tarifas.get(i));
			   }
		   }
	   }
PEDRO*/
        return anula;
    }

    private String logica(String argumento, String vigencia, String tie) {
        String pregunta, izq, der, opera;
        pregunta = izq = der = opera = "";
        int in, fin;
        //try {
        argumento = quitarEspacios(argumento.toUpperCase());
        System.out.println(argumento);
        //System.out.println(argumento);

        while (argumento.indexOf("IF") != -1) {
            pregunta = (argumento.substring(argumento.indexOf("IF") + 3, argumento.indexOf(","))).trim();
            opera = (argumento.substring(pregunta.length() + 4, argumento.length() - 1)).trim();
            /*
               System.out.println(pregunta);
               System.out.println(opera);
         */
            if (opera.indexOf("IF") == 0)
                fin = terminaIF(opera) + 1;
            else
                fin = opera.indexOf(",");

            if (pregunta.indexOf("ENLISTA") != -1) {
                if (enLista(pregunta, carro, vigencia, tie))
                    argumento = opera.substring(0, fin);
                else
                    argumento = opera.substring(fin + 1, opera.length());
            } else if (pregunta.indexOf("RETENEDOR") != -1) {
                if (esRetenedor(carro))
                    argumento = opera.substring(0, fin);
                else
                    argumento = opera.substring(fin + 1, opera.length());
            } else if (pregunta.indexOf("<=") != -1) {
                izq = operacion(pregunta.substring(0, pregunta.indexOf("<=")), vigencia, tie);
                if (izq.indexOf(".") != -1)
                    izq = izq.substring(0, izq.indexOf("."));
                der = operacion(pregunta.substring(pregunta.indexOf("<=") + 2, pregunta.length()), vigencia, tie);
                if (izq.indexOf(".") != -1)
                    der = der.substring(0, der.indexOf("."));

                if (Double.valueOf(izq).doubleValue() <= Double.valueOf(der).doubleValue())
                    argumento = opera.substring(0, fin);
                else
                    argumento = opera.substring(fin + 1, opera.length());
                //System.out.println(argumento);
            } else if (pregunta.indexOf(">=") != -1) {
                izq = operacion(pregunta.substring(0, pregunta.indexOf(">=")), vigencia, tie);
                if (izq.indexOf(".") != -1)
                    izq = izq.substring(0, izq.indexOf("."));
                der = operacion(pregunta.substring(pregunta.indexOf(">=") + 2, pregunta.length()), vigencia, tie);
                if (izq.indexOf(".") != -1)
                    der = der.substring(0, der.indexOf("."));

                if (Double.valueOf(izq).doubleValue() >= Double.valueOf(der).doubleValue())
                    argumento = opera.substring(0, fin);
                else
                    argumento = opera.substring(fin + 1, opera.length());
                //System.out.println(argumento);
            } else if (pregunta.indexOf("=") != -1) {
                izq = operacion(pregunta.substring(0, pregunta.indexOf("=")), vigencia, tie);
                if (izq.indexOf(".") != -1)
                    izq = izq.substring(0, izq.indexOf("."));
                der = operacion(pregunta.substring(pregunta.indexOf("=") + 1, pregunta.length()), vigencia, tie);
                if (izq.indexOf(".") != -1)
                    der = der.substring(0, der.indexOf("."));
                if (izq.equals(der))
                    argumento = opera.substring(0, fin);
                else
                    argumento = opera.substring(fin + 1, opera.length());
                //System.out.println(argumento);
            } else if (pregunta.indexOf("<>") != -1) {
                izq = operacion(pregunta.substring(0, pregunta.indexOf("<>")), vigencia, tie);
                der = operacion(pregunta.substring(pregunta.indexOf("<>") + 2, pregunta.length()), vigencia, tie);
                if (!izq.equals(der))
                    argumento = opera.substring(0, fin);
                else
                    argumento = opera.substring(fin + 1, opera.length());
                //System.out.println(argumento);
            } else if (pregunta.indexOf("<") != -1) {
                izq = operacion(pregunta.substring(0, pregunta.indexOf("<")), vigencia, tie);
                der = operacion(pregunta.substring(pregunta.indexOf("<") + 1, pregunta.length()), vigencia, tie);
                if (Double.valueOf(izq).doubleValue() < Double.valueOf(der).doubleValue())
                    argumento = opera.substring(0, fin);
                else
                    argumento = opera.substring(fin + 1, opera.length());
                //System.out.println(argumento);
            } else if (pregunta.indexOf(">") != -1) {
                izq = operacion(pregunta.substring(0, pregunta.indexOf(">")), vigencia, tie);
                der = operacion(pregunta.substring(pregunta.indexOf(">") + 1, pregunta.length()), vigencia, tie);
                if (Double.valueOf(izq).doubleValue() > Double.valueOf(der).doubleValue())
                    argumento = opera.substring(0, fin);
                else
                    argumento = opera.substring(fin + 1, opera.length());
                //System.out.println(argumento);
            }
        }
        return argumento; /*
    }catch(Exception e) {
      return "";
    }*/
    }

    public String compilar(String argumento, String vigencia, Vehiculo carro, String tie) {
        if (carro != null)
            this.carro = carro;
        String pregunta, izq, der, opera, linea;
        pregunta = izq = der = opera = "";
        int in, fin;
        try {
            /*vigenciaErrada = "";
            avalu = "si";*/
            grupo = null;
            System.out.println("Argumento Antes=" + argumento);
            argumento = logica(argumento, vigencia, tie);
            //this.descripcion = argumento;
            System.out.println("Argumento Despues=" + argumento);
            return operacion(argumento, vigencia, tie);
        } catch (Exception e) {
            e.printStackTrace();
            return "0";
        }

    }

    private int cuantas(String cadena, String comp) {
        int i = -1;
        while (cadena.indexOf(comp) != -1) {
            i++;
            cadena = cadena.substring(cadena.indexOf(comp) + comp.length());
        }
        return i;
    }

    private int dondeEsta(String cad, String com, int num) {
        int i = -1;
        int n = 0;
        while ((cad.indexOf(com) != -1) && (n < num)) {
            n++;
            i = i + cad.indexOf(com) + com.length();
            cad = cad.substring(cad.indexOf(com) + com.length());
        }
        return i;
    }

    private int terminaIF(String entonces) {
        int i, j, n = 0;
        char l;
        j = 0;

        for (i = 0; i < entonces.length(); i++) {
            l = entonces.charAt(i);
            if (entonces.charAt(i) == '(') {
                j = 1;
                n++;
            } else if (entonces.charAt(i) == ')') {
                n--;
                if (n == 0)
                    break;
            }
        }
        if ((n == 0) && (j == 1))
            return i;
        else
            return -1;
    }

    private String quitarEspacios(String cadena) {
        String ret = "";
        boolean esCadenaSimple = false;
        boolean esCadenaDoble = false;
        int n, i;
        for (i = 0; i < cadena.length(); i++) {
            if (esCadenaSimple || esCadenaDoble) {
                ret = ret + cadena.charAt(i);
            } else if (cadena.charAt(i) != ' ' && (int)cadena.charAt(i) != 160) {
                ret = ret + cadena.charAt(i);
            }
            if ((int)cadena.charAt(i) == 39) {
                esCadenaSimple = !esCadenaSimple;
            }
            if ((int)cadena.charAt(i) == 34) {
                esCadenaDoble = !esCadenaDoble;
            }
        }
        return ret;
    }

    public String flotanteAstring(double numero) {
        String aa;
        aa = NumberFormat.getInstance(Locale.CANADA_FRENCH).format(numero);
        aa = quitarEspacios(aa);

        return aa;
    }

    /**
     *
     * @param vehiculo
     * @return
     */
    private boolean esRetenedor(Vehiculo vehiculo) {
        try {
            if (conn.isClosed()) {
                conexion.cerrarCx();
                conn = conexion.conectar();
            }
            PropietarioDeVehiculo propietario = new PropietarioDeVehiculo();
            propietario.setPLACA(vehiculo.getPLACA());
            propietario.setPROPIETARIOACTUAL("T");
            propietario.setEMPPER("EMP");
            PropietarioDeVehiculoDao dao = new PropietarioDeVehiculoDao();
            List propietarios = dao.searchMatching(conn, propietario);
            if (propietarios != null && propietarios.size() > 0)
                return true;
        } catch (Exception exp) {
            exp.printStackTrace();
        }
        return false;
    }

    private double getAvaluo(String vigencia) {
        //cerrar conexion existente
        try {
            if (!conn.isClosed())
                conexion.cerrarCx();
        } catch (Exception exp) {
            exp.printStackTrace();
        }

        double valoravaluo = 100000.0;
        GestionServiciosAvaluos gestionServiciosAvaluos = new GestionServiciosAvaluos();
        Avaluo avaluo = new Avaluo();
        boolean blindado =
            (carro.getBLINDADO() == null ? false : (carro.getBLINDADO().toLowerCase().equals("t") ? true :
                                                    (carro.getBLINDADO().toLowerCase().equals("s") ? true : false)));
        avaluo.setBlindado(blindado); //TODO
        if (Funciones.esDouble(carro.getCAPACIDADTON()))
            avaluo.setCCarga(Double.parseDouble(carro.getCAPACIDADTON())); //TODO
        if (Funciones.esEntero(carro.getCAPACIDAD()))
            avaluo.setCPas(Integer.parseInt(carro.getCAPACIDAD())); //TODO
        if (Funciones.esEntero(carro.getCILINDRAJE()))
            avaluo.setCilindraje(Integer.parseInt(carro.getCILINDRAJE()));
        //else avaluo.setCilindraje(0);
        avaluo.setCod_ciudad(0); //TODO
        avaluo.setFrontera(false);
        if (Funciones.esEntero(carro.getID_CVEHICULO()))
            avaluo.setIdTipoVehiculo(Integer.parseInt(carro.getID_CVEHICULO()));
        //else avaluo.setIdTipoVehiculo(1);
        if (Funciones.esEntero(carro.getID_TCARROCERIA()))
            avaluo.setId_carroceria(Integer.parseInt(carro.getID_TCARROCERIA()));
        //else avaluo.setId_carroceria(1);

        if (Funciones.esEntero(carro.getID_SERVICIO()))
            avaluo.setId_clase(Integer.parseInt(carro.getID_SERVICIO()));
        //else avaluo.setId_clase(1);
        if (Funciones.esEntero(carro.getID_LINEA()))
            avaluo.setId_linea(Integer.parseInt(carro.getID_LINEA()));
        //else avaluo.setId_linea(1);
        if (Funciones.esEntero(carro.getID_MARCA()))
            avaluo.setId_marca(Integer.parseInt(carro.getID_MARCA()));
        //else avaluo.setId_marca(1);
        if (Funciones.esEntero(carro.getMODELO()))
            avaluo.setModelo(Integer.parseInt(carro.getMODELO()));
        //else avaluo.setModelo(1);

        //avaluo.setTipoVehiculo(carro.getID_CVEHICULO());
        ClaseVehiculoAvaluo claseVehiculoAvaluo = new ClaseVehiculoAvaluo();
        if (Funciones.esEntero(carro.getID_CVEHICULO()))
            claseVehiculoAvaluo.setID_CLASEVEHICULOAVALUO(Integer.parseInt(carro.getID_CVEHICULO()));
        else
            claseVehiculoAvaluo.setID_CLASEVEHICULOAVALUO(1);
        List clases = gestionServiciosAvaluos.searchTipoVehiculoAvaluo(claseVehiculoAvaluo);
        if (clases != null && clases.size() > 0) {
            claseVehiculoAvaluo = (ClaseVehiculoAvaluo)clases.get(0);
            String tipoVehiculo = claseVehiculoAvaluo.getTIPO();
            avaluo.setTipoVehiculo(tipoVehiculo.equals("P") ? "C" : tipoVehiculo);
        } else
            avaluo.setTipoVehiculo("A");

        if (Funciones.esEntero(vigencia))
            avaluo.setVigencia(Integer.parseInt(vigencia));
        //else avaluo.setModelo(2011);

        avaluo.setIdVehiculo(carro.getID_VEHICULO());

        valoravaluo = gestionServiciosAvaluos.getAvaluo(avaluo,"");

        //reconectar
        //try {
        //    if (conn.isClosed())
        //        conn = conexion.conectar();
        //}
        //catch(Exception exp) {
        //    exp.printStackTrace();
        //}

        return valoravaluo;
    }

    private String getInmovilizacionMeses(int idVehiculo) {
        String res = "0";
        VehInmovilizacion obj = getVehInmovilizacion(idVehiculo);
        if (obj != null) {
            Calendar calIni = Funciones.convFechaSC(obj.getFECHAINIINMOVILIZA());
            Calendar calFin = Funciones.convFechaSC(obj.getFECHAFININMOVILIZA());
            if (calIni.get(Calendar.YEAR) < vigenciaInmovilizacion) {
                calIni.set(Calendar.YEAR, vigenciaInmovilizacion);
                calIni.set(Calendar.MONTH, 0);
                calIni.set(Calendar.DAY_OF_MONTH, 1);
            }
            if (calFin.get(Calendar.YEAR) > vigenciaInmovilizacion) {
                calFin.set(Calendar.YEAR, vigenciaInmovilizacion);
                calFin.set(Calendar.MONTH, 11);
                calFin.set(Calendar.DAY_OF_MONTH, 31);
            }
            //System.out.println(calIni.getTime());
            //System.out.println(calFin.getTime());
            int meses = calFin.get(Calendar.DAY_OF_YEAR) - calIni.get(Calendar.DAY_OF_YEAR);
            meses = (int)meses / 30;
            res = "" + meses;
        }
        return res;
    }

    private String getInmovilizacionDiasOld(int idVehiculo) {
        String res = "0";
        VehInmovilizacion obj = getVehInmovilizacion(idVehiculo);
        if (obj != null) {
            Calendar calIni =
                Funciones.convFechaTiempo(obj.getFECHAINIINMOVILIZA() + " " + obj.getHORAINIINMOVILIZA());
            Calendar calFin =
                Funciones.convFechaTiempo(obj.getFECHAFININMOVILIZA() + " " + obj.getHORAFININMOVILIZA());
            if (calIni.get(Calendar.YEAR) < vigenciaInmovilizacion) {
                calIni.set(Calendar.YEAR, vigenciaInmovilizacion);
                calIni.set(Calendar.MONTH, 0);
                calIni.set(Calendar.DAY_OF_MONTH, 1);
            }
            if (calFin.get(Calendar.YEAR) > vigenciaInmovilizacion) {
                calFin.set(Calendar.YEAR, vigenciaInmovilizacion);
                calFin.set(Calendar.MONTH, 11);
                calFin.set(Calendar.DAY_OF_MONTH, 31);
            }
            //System.out.println(calIni.getTime());
            //System.out.println(calFin.getTime());

            //calFin.set(Calendar.YEAR, calFin.get(Calendar.YEAR) - calIni.get(Calendar.YEAR));
            calFin.set(Calendar.MONTH, calFin.get(Calendar.MONTH) - calIni.get(Calendar.MONTH));
            calFin.set(Calendar.DAY_OF_MONTH, calFin.get(Calendar.DAY_OF_MONTH) - calIni.get(Calendar.DAY_OF_MONTH));
            calFin.set(Calendar.HOUR_OF_DAY, calFin.get(Calendar.HOUR_OF_DAY) - calIni.get(Calendar.HOUR_OF_DAY));
            calFin.set(Calendar.MINUTE, calFin.get(Calendar.MINUTE) - calIni.get(Calendar.MINUTE));
            calFin.set(Calendar.SECOND, calFin.get(Calendar.SECOND) - calIni.get(Calendar.SECOND));

            //System.out.println(calIni.getTime());
            //System.out.println(calFin.getTime());

            int dias = 0;
            //dias = calFin.get(Calendar.DAY_OF_YEAR) - (calIni.get(Calendar.DAY_OF_YEAR) - 0);
            //int tiempoIni = 24 - calIni.get(Calendar.HOUR_OF_DAY);
            //int tiempoFin = calFin.get(Calendar.HOUR_OF_DAY);
            //if (dias > 0 && tiempoIni + tiempoFin > 24)
            //    dias++;
            dias = (int)(calFin.get(Calendar.DAY_OF_MONTH) % calFin.getActualMaximum(Calendar.DAY_OF_MONTH));
            res = "" + dias; //(dias - 1);
        }
        return res;
    }

    private String getInmovilizacionDias(int idVehiculo) {
        String res = "";
        try {
            VehInmovilizacion obj = getVehInmovilizacion(idVehiculo);
            res = getDiferenciaDias(obj.getFECHAINIINMOVILIZA(), obj.getFECHAFININMOVILIZA());
            
            

        } catch (Exception exp) {
            exp.printStackTrace();
            res = "0";
        }

        return res;
    }

    private String getInmovilizacionHoras(int idVehiculo) {
        myMotor = Funciones.leer_ini("", "MOTOR");
        String res = "0";
        VehInmovilizacion obj = getVehInmovilizacion(idVehiculo);
        if (obj != null) {
            Calendar calIni = null;
            Calendar calFin = null;

            if (myMotor.equals("FIREBIRD")) {
                calIni = Funciones.convFechaTiempo(obj.getFECHAINIINMOVILIZA() + " " + obj.getHORAINIINMOVILIZA());
                calFin = Funciones.convFechaTiempo(obj.getFECHAFININMOVILIZA() + " " + obj.getHORAFININMOVILIZA());
            } else if (myMotor.equals("ORACLE")) {
                calIni = Funciones.convFechaTiempo(obj.getFECHAINIINMOVILIZA().replaceAll("\\d\\d:\\d\\d:\\d\\d", "") + " " + obj.getHORAINIINMOVILIZA().replaceAll("\\d\\d\\d\\d-\\d\\d-\\d\\d", ""));
                calFin = Funciones.convFechaTiempo(obj.getFECHAFININMOVILIZA().replaceAll("\\d\\d:\\d\\d:\\d\\d", "") + " " + obj.getHORAFININMOVILIZA().replaceAll("\\d\\d\\d\\d-\\d\\d-\\d\\d", ""));
                               
            }

            if (calIni.get(Calendar.YEAR) < vigenciaInmovilizacion) {
                calIni.set(Calendar.YEAR, vigenciaInmovilizacion);
                calIni.set(Calendar.MONTH, 0);
                calIni.set(Calendar.DAY_OF_MONTH, 1);
                calIni.set(Calendar.HOUR_OF_DAY, 24);
                calIni.set(Calendar.MINUTE, 0);
                calIni.set(Calendar.SECOND, 0);
            }
            if (calFin.get(Calendar.YEAR) > vigenciaInmovilizacion) {
                calFin.set(Calendar.YEAR, vigenciaInmovilizacion);
                calFin.set(Calendar.MONTH, 11);
                calFin.set(Calendar.DAY_OF_MONTH, 31);
                calFin.set(Calendar.HOUR_OF_DAY, 23);
                calFin.set(Calendar.MINUTE, 59);
                calFin.set(Calendar.SECOND, 59);
            }
            /*int dias = calFin.get(Calendar.DAY_OF_YEAR) - (calIni.get(Calendar.DAY_OF_YEAR));
            int tiempoIni = 0;
            int tiempoFin = 0;
            if (dias > 0 && calIni.get(Calendar.HOUR_OF_DAY) != calFin.get(Calendar.HOUR_OF_DAY)) {
                tiempoIni = 24 - calIni.get(Calendar.HOUR_OF_DAY);
                tiempoFin = calFin.get(Calendar.HOUR_OF_DAY);
            }
            else {
                tiempoIni = calFin.get(Calendar.HOUR_OF_DAY) - calIni.get(Calendar.HOUR_OF_DAY);
            }
            if (tiempoIni + tiempoFin > 24)
                tiempoIni -= 24;
            res = (tiempoIni + tiempoFin) + "";//TODO*/

            //System.out.println(calIni.getTime());
            //System.out.println(calFin.getTime());
            //calFin.set(Calendar.YEAR, calFin.get(Calendar.YEAR) - calIni.get(Calendar.YEAR));
            calFin.set(Calendar.MONTH, calFin.get(Calendar.MONTH) - calIni.get(Calendar.MONTH));
            calFin.set(Calendar.DAY_OF_MONTH,
                       calFin.get(Calendar.DAY_OF_MONTH) - calIni.get(Calendar.DAY_OF_MONTH) + 1);
            calFin.set(Calendar.HOUR_OF_DAY, calFin.get(Calendar.HOUR_OF_DAY) - calIni.get(Calendar.HOUR_OF_DAY));
            calFin.set(Calendar.MINUTE, calFin.get(Calendar.MINUTE) - calIni.get(Calendar.MINUTE));
            calFin.set(Calendar.SECOND, calFin.get(Calendar.SECOND) - calIni.get(Calendar.SECOND));

            res = "" + (calFin.get(Calendar.HOUR_OF_DAY));
        }
        return res;
    }

    private VehInmovilizacion getVehInmovilizacion(int idVehiculo) {
        try {
            if (conn.isClosed()) {
                conexion.cerrarCx();
                conn = conexion.conectar();
            }
            VehInmovilizacionDao dao = new VehInmovilizacionDao();
            VehInmovilizacion obj = new VehInmovilizacion();
            obj.setID_VEHICULO(idVehiculo);
            obj.setACTIVA("T");
            List objs = dao.searchMatching(conn, obj);
            if (objs != null && objs.size() > 0) {
                obj = (VehInmovilizacion)objs.get(0);
                return obj;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    private String estaVehiculoRegistrado(Vehiculo vehiculo) {
        if (vehiculo != null && vehiculo.getID_VEHICULO() > 0) {
            try {
                if (conn.isClosed()) {
                    conexion.cerrarCx();
                    conn = conexion.conectar();
                }
                LicenciaDeTransito obj = new LicenciaDeTransito();
                obj.setID_VEHICULO(vehiculo.getID_VEHICULO());
                LicenciaDeTransitoDao dao = new LicenciaDeTransitoDao();
                List lista = dao.searchMatching(conn, obj);
                if (lista != null && lista.size() > 0) {
                    for (int i = 0; i < lista.size(); i++) {
                        obj = (LicenciaDeTransito)lista.get(i);
                        if (obj.getANULADA().equals(""))
                            return "T";
                        if (obj.getANULADA().equals("R"))
                            return "R";
                    }
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return "F";
    }

    private String esVehiculoActivo(Vehiculo vehiculo) {
        if (vehiculo.getID_MOTIVOCANCELACION() == null ||
            vehiculo.getID_MOTIVOCANCELACION().toUpperCase().equals("NULL") ||
            vehiculo.getID_MOTIVOCANCELACION().equals("") || vehiculo.getID_MOTIVOCANCELACION().equals("0"))
            return "T";
        else
            return "F";
    }

    private String tieneComparendos(Vehiculo vehiculo) {
        String res = "F";

        List lista = null;
        ViewPropietario vista = new ViewPropietario();

        try {
            //buscamos los propietarios del vehiculo
            vista.setID_VEHICULO(vehiculo.getID_VEHICULO());
            ViewPropietarioDao vistaDao = new ViewPropietarioDao();
            lista = vistaDao.searchMatching(conn, vista);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        try {
            if (conn.isClosed()) {
                conexion.cerrarCx();
                conn = conexion.conectar();
            }
            List listaInfractorComp;
            List listaComparendo;
            List listaInfraccionComparendo;

            if (lista != null && lista.size() > 0) {
                for (int i = 0; i < lista.size(); i++) {
                    //por cada propietario
                    vista = (ViewPropietario)lista.get(i);
                    //buscamos si esta registrado como infractor de transito
                    InfractorComp infractorComp = new InfractorComp();
                    infractorComp.setNROIDENTIFICACION(vista.getIDENTIFICACION());
                    InfractorCompDao infractorCompDao = new InfractorCompDao();
                    listaInfractorComp = infractorCompDao.searchMatching(connComp, infractorComp);
                    if (listaInfractorComp != null && listaInfractorComp.size() > 0) {
                        for (int j = 0; j < listaInfractorComp.size(); j++) {
                            //por cada infractor comparendo
                            infractorComp = (InfractorComp)listaInfractorComp.get(j);
                            //buscamos los comparendos
                            ComparendoComp comparendo = new ComparendoComp();
                            comparendo.setID_INFRACTOR(infractorComp.getID_INFRACTOR());
                            ComparendoCompDao comparendoDao = new ComparendoCompDao();
                            listaComparendo = comparendoDao.searchMatching(connComp, comparendo);
                            if (listaComparendo != null && listaComparendo.size() > 0) {
                                for (int k = 0; k < listaComparendo.size(); k++) {
                                    //por cada comparendo
                                    comparendo = (ComparendoComp)listaComparendo.get(k);
                                    //buscamos las infraccion comparendo
                                    InfracionComparendoComp infraccionComp = new InfracionComparendoComp();
                                    infraccionComp.setIDCOMPARENDO(comparendo.getID_COMPARENDO());
                                    InfracionComparendoCompDao infraccionCompDao = new InfracionComparendoCompDao();
                                    listaInfraccionComparendo =
                                            infraccionCompDao.searchMatching(connComp, infraccionComp);
                                    if (listaInfraccionComparendo != null && listaInfraccionComparendo.size() > 0) {
                                        for (int m = 0; m < listaInfraccionComparendo.size(); m++) {
                                            //por cada infraccion comparendo
                                            infraccionComp = (InfracionComparendoComp)listaInfraccionComparendo.get(m);
                                            if (infraccionComp.getIDESTADO() == 10 ||
                                                infraccionComp.getIDESTADO() == 11 ||
                                                infraccionComp.getIDESTADO() == 14 ||
                                                infraccionComp.getIDESTADO() == 16 ||
                                                infraccionComp.getIDESTADO() == 20) {
                                                res = "T";
                                                break;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }

    private String vigenciaUltimoImpuestoPago(Vehiculo vehiculo) {
        String res = "1900";
        try {
            if (conn.isClosed()) {
                conexion.cerrarCx();
                conn = conexion.conectar();
            }
            LInfoVehiculo obj = new LInfoVehiculo();
            obj.setLIV_V_ID(vehiculo.getID_VEHICULO());
            LInfoVehiculoDao dao = new LInfoVehiculoDao();

            dao.load(conn, obj);
            res = "" + obj.getLIV_VIGENCIA_PAGADA();
        } catch (Exception exp) {
            exp.printStackTrace();
        }
        return res;
    }

    private String tieneLimitacion(Vehiculo vehiculo) {
        String res = "F";

        try {
            if (conn.isClosed()) {
                conexion.cerrarCx();
                conn = conexion.conectar();
            }
            LimitacionPropVehiculo obj = new LimitacionPropVehiculo();
            obj.setID_VEHICULO(vehiculo.getID_VEHICULO());
            LimitacionPropVehiculoDao dao = new LimitacionPropVehiculoDao();
            List lista = dao.searchMatching(conn, obj);
            if (lista != null && lista.size() > 0) {
                res = "T";
            } else
                res = "F";
        } catch (Exception exp) {
            exp.printStackTrace();
            res = "F";
        }
        return res;
    }

    private String tieneMedidaCautelar(Vehiculo vehiculo) {
        String res = "F";
        try {
            if (conn.isClosed()) {
                conexion.cerrarCx();
                conn = conexion.conectar();
            }

            JPendienteViewCT medida = new JPendienteViewCT();
            medida.setID_VEHICULO((String.valueOf(vehiculo.getID_VEHICULO())));
            medida.setJP_ESTADO("ACT");
            JPendienteViewCTDao medidadao = new JPendienteViewCTDao();
            List lista = medidadao.searchMatching(conn, medida);
            if (lista != null && lista.size() > 0) {
                res = "T";
            } else
                res = "F";

        } catch (Exception exp) {
            exp.printStackTrace();
            res = "F";
        }

        return res;
    }


    private String tienePendienteJudicial(Vehiculo vehiculo) {
        String res = "F";

        try {
            if (conn.isClosed()) {
                conexion.cerrarCx();
                conn = conexion.conectar();
            }
            JPendienteViewCT obj = new JPendienteViewCT();
            obj.setID_VEHICULO("" + vehiculo.getID_VEHICULO());
            JPendienteViewCTDao dao = new JPendienteViewCTDao();
            List lista = dao.searchMatching(conn, obj);
            if (lista != null && lista.size() > 0) {
                res = "T";
            } else
                res = "F";
        } catch (Exception exp) {
            exp.printStackTrace();
            res = "F";
        }
        return res;
    }

    private String tieneMotivoCancelacion(Vehiculo vehiculo) {
        String res = vehiculo.getID_MOTIVOCANCELACION();
        return res;
    }

    private String vidaUtil(Vehiculo vehiculo) {
        return "5"; //TODO
    }

    private String cancelacion(Vehiculo vehiculo) {
        return "9";
    }

    private String blindado(Vehiculo vehiculo) {
        String blindado = "F";

        if (vehiculo.getBLINDADO() != null && !vehiculo.getBLINDADO().equals("")) {

            blindado = vehiculo.getBLINDADO().toUpperCase();
            if (blindado.equals("F") || blindado.equals("NO") || blindado.equals("N")) {
                blindado = "F";
            } else if (blindado.equals("T") || blindado.equals("V") || blindado.equals("S") || blindado.equals("SI") ||
                       blindado.equals("S-*-")) {
                blindado = "T";
            } else
                blindado = "F";
        }
        return blindado;
    }

    private String internadoTemporalmente(Vehiculo vehiculo) {
        String internado = "F";
        internado = vehiculo.getID_RUNTTIPOMATRICULA();

        if (internado == null || internado.isEmpty())
            return "F";

        if (internado.equals("2"))
            internado = "T";
        else
            internado = "F";

        return internado;
    }

    private String esAntiguoClasico(Vehiculo vehiculo) {
        String anticlasi = "F";
        anticlasi = vehiculo.getID_RUNTANTIGUOCLASICO();

        if (anticlasi == null || anticlasi.isEmpty())
            return "F";

        if (anticlasi.equals("1") || anticlasi.equals("2"))
            anticlasi = "T";
        else
            anticlasi = "F";

        return anticlasi;
    }

    private String getDiferenciaDias(String fechainicial, String fechafinal) {
        final long MILLSECS_PER_DAY = 24 * 60 * 60 * 1000;
        String res = "";
        Date finicial, ffinal;
        finicial = new Date(Funciones.convFechaTiempoSolofecha(fechainicial).getTimeInMillis());
        ffinal = new Date(Funciones.convFechaTiempoSolofecha(fechafinal).getTimeInMillis());

        long diferencia = 0;
        diferencia = (ffinal.getTime() - finicial.getTime()) / MILLSECS_PER_DAY;
        if(diferencia>30)
            diferencia=0;
        
        if (diferencia < 0)
            res = "0";
        else
            res = "" + diferencia;

        return res;
    }


}
