package utilidades;


import java.text.NumberFormat;
import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Vector;

import modelo.datos.objetos.accesorias.Diasfestivos;
import modelo.datos.objetos.comparendos.accesorias.InfraccionesComp;
import modelo.datos.objetos.comparendos.generales.ComparendoComp;
import modelo.datos.objetos.comparendos.generales.InfracionComparendoComp;
import modelo.datos.objetos.comparendos.generales.VehiculosComp;
import modelo.datos.objetos.generales.vehiculo.Vehiculo;
import modelo.datos.objetos.liquidador.Salario;

import modelo.logica.generales.GestionServiciosDiasfestivos;


/**
 * <p>T-*-tulo: </p>
 * <p>Descripci-*-n: </p>
 * <p>Copyright: Copyright (c) 2007</p>
 * <p>Empresa: </p>
 * @author sin atribuir
 * @version 1.0
 */

public class CompiladorComparendo {

    /*Variables*/

    /*Conexion a la base*/

    public String avalu;
    public String grupo;
    public Vector vigenciaErrada;
    private ArrayList salarios;
    private String[] fecha;
    private InfracionComparendoComp infraccionComparendo;
    private InfraccionesComp infracion;
    private ComparendoComp comparendo;
    private VehiculosComp vehiculo;


    public CompiladorComparendo(String[] fecha, ArrayList salarios) {
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
    }


    public String compilar(String argumento, String vigencia, InfracionComparendoComp infraccionComparendo, String tie,
                           ComparendoComp comparendo, InfraccionesComp infraccion, VehiculosComp vehiculo) {
        if (infraccion != null)
            this.infracion = infraccion;
        this.infraccionComparendo = infraccionComparendo;
        this.comparendo = comparendo;
        this.vehiculo = vehiculo;
        String pregunta, izq, der, opera, linea;
        pregunta = izq = der = opera = "";
        int in, fin;
        try {
            /*vigenciaErrada = "";
            avalu = "si";*/
            grupo = null;
            argumento = logica(argumento, vigencia, tie);
            return operacion(argumento, vigencia, tie);
        } catch (Exception e) {
            e.printStackTrace();
            return "0";
        }

    }

    private String logica(String argumento, String vigencia, String tie) {
        String pregunta, izq, der, opera;
        pregunta = izq = der = opera = "";
        int in, fin;
        Vehiculo carro = null;
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
            } else if (pregunta.indexOf("AND") != -1) {
                if (operadorAND(pregunta, carro, vigencia, tie))
                    argumento = opera.substring(0, fin);
                else
                    argumento = opera.substring(fin + 1, opera.length());
            }
            
            else if (pregunta.indexOf("RETENEDOR") != -1) {
                
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
    
    /**
     *
     * @param opera
     * @param vigencia
     * @param tie
     * @return
     */
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
            e.printStackTrace();
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
        
        if (resultado.indexOf("SMLDV") != -1) {
            resultado.replaceAll("SMLDV", "SMLVD");
        }

        while (resultado.indexOf("SMLVD") != -1) {
            if (salario == 0)
                salario = getSalario(vigencia);
            aux = flotanteAstring(salario / 30);
            resultado = remplaza(resultado, aux, resultado.indexOf("SMLVD"), resultado.indexOf("SMLVD") + 4);
            //System.out.println(resultado);
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

        while (resultado.indexOf("FECHACOMPARENDO") != -1) {
            aux = comparendo.getFECHACOMPARENDO();
            resultado =
                    remplaza(resultado, aux, resultado.indexOf("FECHACOMPARENDO"), resultado.indexOf("FECHACOMPARENDO") +
                             14);
            //System.out.println(resultado);
        }

        while (resultado.indexOf("REPORTAFUGA") != -1) {
            aux = comparendo.getREPORTAFUGA() == null ? "N" : comparendo.getREPORTAFUGA();
            resultado =
                    remplaza(resultado, aux, resultado.indexOf("REPORTAFUGA"), resultado.indexOf("REPORTAFUGA") + 10);
            //System.out.println(resultado);
        }

        while (resultado.indexOf("REPORTAACCIDENTE") != -1) {
            aux = comparendo.getREPORTAACCIDENTE() == null ? "N" : comparendo.getREPORTAACCIDENTE();
            resultado =
                    remplaza(resultado, aux, resultado.indexOf("REPORTAACCIDENTE"), resultado.indexOf("REPORTAACCIDENTE") +
                             15);
            //System.out.println(resultado);
        }

        while (resultado.indexOf("REPORTAINMOVILIZACION") != -1) {
            aux = comparendo.getREPORTAINMOVILIZACION() == null ? "N" : comparendo.getREPORTAINMOVILIZACION();
            resultado =
                    remplaza(resultado, aux, resultado.indexOf("REPORTAINMOVILIZACION"), resultado.indexOf("REPORTAINMOVILIZACION") +
                             20);
            //System.out.println(resultado);
        }

        while (resultado.indexOf("REPORTAGRUA") != -1) {
            aux = comparendo.getREPORTAGRUA() == null ? "N" : comparendo.getREPORTAGRUA();
            resultado =
                    remplaza(resultado, aux, resultado.indexOf("REPORTAGRUA"), resultado.indexOf("REPORTAGRUA") + 10);
            //System.out.println(resultado);
        }

        while (resultado.indexOf("POLCA") != -1) {
            aux = comparendo.getPOLCA();
            resultado = remplaza(resultado, aux, resultado.indexOf("POLCA"), resultado.indexOf("POLCA") + 4);
        }

        while (resultado.indexOf("PRACTICOALCOLEMIA") != -1) {
            aux = comparendo.getPRACTICOALCOLEMIA() == null ? "N" : comparendo.getPRACTICOALCOLEMIA();
            resultado =
                    remplaza(resultado, fecha[2], resultado.indexOf("PRACTICOALCOLEMIA"), resultado.indexOf("PRACTICOALCOLEMIA") +
                             16);
        }

        while (resultado.indexOf("VALORALCOLEMIA") != -1) {
            aux = String.valueOf(comparendo.getVALORALCOLEMIA());
            resultado =
                    remplaza(resultado, aux, resultado.indexOf("VALORALCOLEMIA"), resultado.indexOf("VALORALCOLEMIA") +
                             13);
        }

        while (resultado.indexOf("TIENECERTIFICADO") != -1) {
            aux = comparendo.getTIENECERTIFICADO() == null ? "N" : comparendo.getTIENECERTIFICADO();
            resultado =
                    remplaza(resultado, aux, resultado.indexOf("TIENECERTIFICADO"), resultado.indexOf("TIENECERTIFICADO") +
                             15);
        }

        while (resultado.indexOf("NUEVO_CODIGO") != -1) {
            aux = infracion.getNUEVO_CODIGO();
            resultado =
                    remplaza(resultado, aux, resultado.indexOf("NUEVO_CODIGO"), resultado.indexOf("NUEVO_CODIGO") + 11);
        }

        while (resultado.indexOf("NUMEROSALARIO") != -1) {
            aux = String.valueOf(infracion.getNUMEROSALARIO());
            resultado =
                    remplaza(resultado, aux, resultado.indexOf("NUMEROSALARIO"), resultado.indexOf("NUMEROSALARIO") +
                             12);
        }


        while (resultado.indexOf("VALORINFRACCION") != -1) {
            aux = String.valueOf(infraccionComparendo.getVALORINFRACCION());
            resultado =
                    remplaza(resultado, aux, resultado.indexOf("VALORINFRACCION"), resultado.indexOf("VALORINFRACCION") +
                             14);
        }


        while (resultado.indexOf("VLRINFRACCIONTOTAL") != -1) {
            aux = String.valueOf(infraccionComparendo.getVALORINFRACCION());
            if (comparendo.getREPORTAFUGA().equals("Si") || comparendo.getREPORTAFUGA().equals("SI") ||
                comparendo.getREPORTAFUGA().equals("si") || comparendo.getREPORTAFUGA().equals("S") ||
                comparendo.getREPORTAFUGA().equals("s")) {
                //aux = aux + "*2";
                aux = (2 * Double.parseDouble(aux)) + "";
            }
            resultado =
                    remplaza(resultado, aux, resultado.indexOf("VLRINFRACCIONTOTAL"), resultado.indexOf("VLRINFRACCIONTOTAL") +
                             17);
        }

        while (resultado.indexOf("DIASTRASCURRIDOS") != -1) {
            aux = getDiasTranscurridos(comparendo.getFECHACOMPARENDO());
            resultado =
                    remplaza(resultado, aux, resultado.indexOf("DIASTRASCURRIDOS"), resultado.indexOf("DIASTRASCURRIDOS") +
                             15);
        }

        while (resultado.indexOf("NRODIAS") != -1) {
            aux = getDiasTranscurridos(comparendo.getFECHACOMPARENDO());
            resultado =
                    remplaza(resultado, aux, resultado.indexOf("NRODIAS"), resultado.indexOf("NRODIAS") + "NRODIAS".length() -
                             1);
        }

        while (resultado.indexOf("ID_TIPOINFRACCION") != -1) {
            aux = infracion.getID_INFRACCION() + "";
            resultado =
                    remplaza(resultado, aux, resultado.indexOf("ID_TIPOINFRACCION"), resultado.indexOf("ID_TIPOINFRACCION") +
                             "ID_TIPOINFRACCION".length() - 1);
        }

        while (resultado.indexOf("ID_SERVICIO") != -1) {
            aux = vehiculo.getID_SERVICIO() + "";
            resultado =
                    remplaza(resultado, aux, resultado.indexOf("ID_SERVICIO"), resultado.indexOf("ID_SERVICIO") + "ID_SERVICIO".length() -
                             1);
        }

        while (resultado.indexOf("REPORTARSIMIT") != -1) {
            aux = infracion.getREPORTARSIMIT() == null ? "N" : infracion.getREPORTARSIMIT();
            resultado =
                    remplaza(resultado, aux, resultado.indexOf("REPORTARSIMIT"), resultado.indexOf("REPORTARSIMIT") +
                             "REPORTARSIMIT".length() - 1);
        }

        while (resultado.indexOf("APLICADESCUENTO") != -1) {
            aux = getAplicaDescuento();
            resultado =
                    remplaza(resultado, aux, resultado.indexOf("APLICADESCUENTO"), resultado.indexOf("APLICADESCUENTO") +
                             "APLICADESCUENTO".length() - 1);
        }
        
        while (resultado.indexOf("INTERESMORA") != -1) {
            aux = getInteresMora(comparendo.getFECHACOMPARENDO());
            resultado =
                    remplaza(resultado, aux, resultado.indexOf("INTERESMORA"), resultado.indexOf("INTERESMORA") + "INTERESMORA".length() -
                             1);
        }

        resultado = resultado.replaceAll(",", ".");

        while (resultado.indexOf("*") != -1)
            resultado = resultado(resultado, "*");

        while (resultado.indexOf("/") != -1)
            resultado = resultado(resultado, "/");

        while (resultado.indexOf("+") != -1)
            resultado = resultado(resultado, "+");

        while (resultado.indexOf("-") > 0)
            resultado = resultado(resultado, "-");

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

            izq = izq.replace("(", "").replace(")", "");
            der = der.replace("(", "").replace(")", "");

            if (ope == "*")
                sal = Float.valueOf(izq).floatValue() * Float.valueOf(der).floatValue();
            else if (ope == "/")
                sal = Float.valueOf(izq).floatValue() / Float.valueOf(der).floatValue();
            else if (ope == "+")
                sal = Float.valueOf(izq).floatValue() + Float.valueOf(der).floatValue();
            else if (ope == "-")
                sal = Float.valueOf(izq).floatValue() - Float.valueOf(der).floatValue();
            val = flotanteAstring(sal);
            return remplaza(resultado, val, ini, fin);

        }
        //return String.valueOf(remplaza(resultado,String.valueOf(sal),ini,fin));
        return "";

    }
    
    /**
     * ENLISTA(X|1|2|3)
     * @param pregunta
     * @param carro
     * @param vigencia
     * @param tie
     * @return
     */
    public boolean enLista(String pregunta, Vehiculo carro, String vigencia, String tie) {
        String item, compara = "";
        boolean retorno = false, si = true;
        item = pregunta.substring((pregunta.indexOf("(") + 1), pregunta.indexOf("|"));
        item = resolver(item, vigencia, tie);

        if (pregunta.indexOf("ENLISTA") != -1) {
            pregunta = pregunta.substring("ENLISTA".length() + 1, pregunta.length() - 1);
            pregunta = pregunta + "|";
        }
        pregunta = pregunta.substring((pregunta.indexOf("|") + 1));
        while (pregunta.indexOf("|") != -1) {
            compara = pregunta.substring(0, pregunta.indexOf("|"));
            if (compara.equals(item)) {
                retorno = true;
                break;
            }
            pregunta = pregunta.substring((pregunta.indexOf("|") + 1));
        }
        return retorno;
    }
    
    /**
     * Realiza una operacion de cumplimiento de varias sentencias que puede incluir (variable operador variable)
     * Ejemplo: AND(X=1|Y>=0|Z<>4)
     * @param pregunta
     * @param vehiculo
     * @param vigencia
     * @param string2
     * @return
     */
    private boolean operadorAND(String preguntas, Vehiculo vehiculo, String vigencia, String tie) {
        boolean retorno = true;
        boolean resPregunta = false;
        String pregunta;
        String res;
        
        if (preguntas.indexOf("AND") != -1) {
            preguntas = preguntas.substring("AND".length() + 1, preguntas.length() - 1);
            preguntas = preguntas + "|";
        }
        while (retorno && preguntas.indexOf("|") != -1) {
            pregunta = resolver(preguntas.substring(0, preguntas.indexOf("|")), vigencia, tie);
            res = logica("IF(" + pregunta + ",S,N)", vigencia, tie);
            resPregunta = res.equals("S");
            retorno = retorno && resPregunta;
            preguntas = preguntas.substring((preguntas.indexOf("|") + 1));
        }
        return retorno;
    }

    public Vector funciones(String argumento, String vigencia, String id, String tie) {
        Vector tarifaAnula = new Vector();
        argumento = quitarEspacios(argumento.toUpperCase());
        String linea = null;
        System.out.println(argumento);
        if (argumento.indexOf("\n") != -1) {
            while (argumento.indexOf("\n") != -1) {
                linea = argumento.substring(0, argumento.indexOf("\n"));
                argumento = argumento.substring(argumento.indexOf("\n") + 1, argumento.length() - 1);
                //pedro quitar linea = compilar(linea, vigencia,null,tie);
                tarifaAnula = vectorAnulaTarifa(tarifaAnula, linea, vigencia);
            }
        }
        if (argumento.length() > 0) {
            // pedro quitar linea = compilar(argumento, vigencia,null, tie);
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
        int n, i;
        for (i = 0; i < cadena.length(); i++) {
            if (cadena.charAt(i) != ' ' && (int)cadena.charAt(i) != 160) {
                ret = ret + cadena.charAt(i);
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


    private String getDiasTranscurridos(String fecha) {
        Diasfestivos diasfestivos;
        GestionServiciosDiasfestivos gestionDiasfestivos = new GestionServiciosDiasfestivos();
        int dias = 0;
        try {
            Date dateActual = new Date();
            SimpleDateFormat formatoTo = new SimpleDateFormat("yyyy-MM-dd");
            SimpleDateFormat formatoBack = new SimpleDateFormat("MM/dd/yyyy");
            Calendar cDate = Calendar.getInstance();
            Date date = formatoTo.parse(fecha);
            cDate.setTime(date);
            List lista = gestionDiasfestivos.loadAll();
            Diasfestivos obj;
            boolean esFestivo;

            while (!dateActual.before(date)) {
                diasfestivos = new Diasfestivos();
                //diasfestivos.setFecha(formatoBack.format(date));
                //List objs = gestionDiasfestivos.searchMatching(diasfestivos);
                esFestivo = false;
                for (int i = 0; i < lista.size(); i++) {
                    obj = (Diasfestivos)lista.get(i);
                    if (obj.getFecha().equals(formatoTo.format(date))) {
                        esFestivo = true;
                        break;
                    }
                }
                if (!esFestivo)
                    dias++;
                cDate.add(Calendar.DATE, 1); // number of days to add
                date = cDate.getTime(); // dt is now the new date
            }
        } catch (Exception exp) {
            exp.printStackTrace();
            return "0";
        }
        return dias + "";
    }
    
    private boolean esDiaFestivo(String fecha){
        Diasfestivos diasfestivos;
        boolean esFestivo = false;
        GestionServiciosDiasfestivos gestionDiasfestivos = new GestionServiciosDiasfestivos();
        try {
            List lista = gestionDiasfestivos.loadAll();
            Diasfestivos obj;

            diasfestivos = new Diasfestivos();
            esFestivo = false;
            for (int i = 0; i < lista.size(); i++) {
                obj = (Diasfestivos)lista.get(i);
                if (obj.getFecha().equals(fecha)) {
                    esFestivo = true;
                    break;
                }
            }
        }catch (Exception exp) {
            exp.printStackTrace();
        }
        return esFestivo;
    }

    private String getAplicaDescuento() {
        String[] fechaIni = null;
        String[] fechaFin= null;
        String[] fechaAmn= null;
        String[] fechaCom= null;
        
            try{
                fechaIni = Funciones.leer_ini("/WSTransito.ini", "DESCUENTOCOMPARENDO_FECHAINICIAL").split("/");
            }catch(Exception exce){}
            if(fechaIni == null || fechaIni.length==0)
            try{
                fechaIni = Funciones.leer_ini("c:\\WSTransito.ini", "DESCUENTOCOMPARENDO_FECHAINICIAL").split("/");
            }catch(Exception exce){}

        
        try{
                fechaFin = Funciones.leer_ini("/WSTransito.ini", "DESCUENTOCOMPARENDO_FECHAFINAL").split("/");
            }catch(Exception exce){}
            if(fechaFin == null || fechaIni.length==0)
            try{
                fechaFin = Funciones.leer_ini("c:\\WSTransito.ini", "DESCUENTOCOMPARENDO_FECHAFINAL").split("/");
            }catch(Exception exce){}
        
        try{
                fechaAmn = Funciones.leer_ini("/WSTransito.ini", "DESCUENTOCOMPARENDO_FECHAFINAMNISTIA").split("/");
            }catch(Exception exce){}
            if(fechaAmn == null || fechaAmn.length==0)
            try{
                fechaAmn = Funciones.leer_ini("c:\\WSTransito.ini", "DESCUENTOCOMPARENDO_FECHAFINAMNISTIA").split("/");
            }catch(Exception exce){}
            
        fechaCom = comparendo.getFECHACOMPARENDO().split("-");
        Date now = new Date();
        Date dateIni =
            new Date(Integer.parseInt(fechaIni[2]), Integer.parseInt(fechaIni[1]), Integer.parseInt(fechaIni[0]));
        Date dateFin =
            new Date(Integer.parseInt(fechaFin[2]), Integer.parseInt(fechaFin[1]), Integer.parseInt(fechaFin[0]));
        Date dateAmn =
            new Date(Integer.parseInt(fechaAmn[2]), Integer.parseInt(fechaAmn[1]), Integer.parseInt(fechaAmn[0]));
        Date dateCom =
            new Date(Integer.parseInt(fechaCom[0]), Integer.parseInt(fechaCom[1]), Integer.parseInt(fechaCom[2]));
        //TODO
        if (dateCom.after(dateIni) && dateCom.before(dateFin) && now.before(dateAmn))
            return "T";
        return "F";
    }
    
    private String getInteresMora(String fecha)
    {
            Diasfestivos diasfestivos;
            GestionServiciosDiasfestivos gestionDiasfestivos = new GestionServiciosDiasfestivos();
            Funciones func = new Funciones();
            
            System.out.println("Fecha COMPARENDO RECIBIDA INTERES MORA:" + fecha);
                    
            int dias = 0;
            try {
                Date dateActual = new Date();
                SimpleDateFormat formatoTo = new SimpleDateFormat("yyyy-MM-dd");
                SimpleDateFormat formatoBack = new SimpleDateFormat("MM/dd/yyyy");
                Calendar cDate = Calendar.getInstance();
                Date date = formatoTo.parse(fecha);
                cDate.setTime(date);
                List lista = gestionDiasfestivos.loadAll();
                Diasfestivos obj;
                boolean esFestivo;

                while (!dateActual.before(date)) {
                    diasfestivos = new Diasfestivos();
                    //diasfestivos.setFecha(formatoBack.format(date));
                    //List objs = gestionDiasfestivos.searchMatching(diasfestivos);
                    esFestivo = false;
                    String objfecha="";
                    Date fechafestivo;
                    for (int i = 0; i < lista.size(); i++) {
                        obj = (Diasfestivos)lista.get(i);
                        //System.out.println("Fecha Festivo: " + obj.getFecha() + " Fecha comparendo: " +formatoTo.format(date));
                         fechafestivo = formatoTo.parse(obj.getFecha());                   
                        if (formatoTo.format(fechafestivo).equals(formatoTo.format(date))) {
                            esFestivo = true;
                            break;
                        }
                    }
                    if (!esFestivo)
                        dias++;
                    cDate.add(Calendar.DATE, 1); // number of days to add
                    date = cDate.getTime(); // dt is now the new date
                }
            } catch (Exception exp) {
                exp.printStackTrace();
                return "0";
            }
            int diasinteres=0;
            diasinteres = dias-30;
            
            System.out.println("dias: "  + dias);
            
            if(diasinteres>0)
            {
            String strinteres;
            strinteres = "";
        
            try{
                strinteres = Funciones.leer_ini("/WSTransito.ini", "MOTOR");
            }catch(Exception exce){}
            if(strinteres.equals(""))
            try{
                strinteres = Funciones.leer_ini("c:\\WSTransito.ini", "MOTOR");
            }catch(Exception exce){}
        
            double tasa = 0;
            tasa = Double.valueOf(strinteres);
            double valor = infraccionComparendo.getVALORINFRACCION();
            
            
            double interes = (valor*tasa)*(diasinteres);
            System.out.println("TASA = " + tasa);
            System.out.println("diasinteres = " + diasinteres);
            System.out.println("valor = " + valor);
            System.out.println("interes = " + interes);
            
            return interes + "";
            }
            else
            {
             return "0";
            }
                    
        }
}
