package utilidades;

import java.lang.reflect.Method;

import modelo.datos.objetos.accesorias.Diasfestivos;


public class Evaluador {
    public Evaluador() {
        super();
    }

    public void listarMetodos() {
        try {
            Archivo a = new Archivo();
            Class c = Class.forName("modelo.datos.objetos.accesorias.Diasfestivos");
            Method m[] = c.getDeclaredMethods();
            for (int i = 0; i < m.length; i++)
                System.out.println(m[i].toString());
        } catch (Throwable e) {
            System.err.println(e);
        }
    }

    public void invocarMetodo(Object obj) {
        try {
            Class cls = obj.getClass();
            Method meth = cls.getMethod("getDescripcion", null);
            Object res = meth.invoke(obj, null);
            System.out.println("" + res);
        } catch (Throwable e) {
            System.err.println(e);
        }
    }

    public static void main(String[] args) {
        Evaluador evaluador = new Evaluador();
        evaluador.listarMetodos();
        Diasfestivos obj = new Diasfestivos(1);
        obj.setDescripcion("la descripcion de dias festivos");
        evaluador.invocarMetodo(obj);
    }
}
