package modelo.datos.objetos.generales;

import java.util.*;

public class Header {
    
    String login;
    String password;
    String idUsuario;
    List parametros;
    
    public Header() {
        super();
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getLogin() {
        return login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setParametros(List parametros) {
        this.parametros = parametros;
    }

    public List getParametros() {
        return parametros;
    }
}
