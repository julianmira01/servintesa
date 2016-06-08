package usuarios;

import java.sql.Connection;
import java.sql.SQLException;


import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 * @author racar@unicauca.edu.co
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class Conexion {
	public Connection conn=null;
	
	
	public Connection conectar(){
		//Connection conn=null;
		try{
			Context initContext = new InitialContext();
			//Context envContext  = (Context)initContext.lookup("java:/comp/env");
			//DataSource ds = (DataSource)envContext.lookup("jdbc/postgres");
           DataSource ds =   (DataSource)initContext.lookup("java:/comp/env/jdbc/runt");
           conn =	ds.getConnection();
			
			
        }
        catch(SQLException e){
        	e.printStackTrace();
        }
        catch(NamingException e){
        	e.printStackTrace();
        }
        return conn;
	
	}
	
	public Connection conectarSeguro(){
		//Connection conn=null;
		try{
			Context initContext = new InitialContext();
			//Context envContext  = (Context)initContext.lookup("java:/comp/env");
			//DataSource ds = (DataSource)envContext.lookup("jdbc/postgres");
           DataSource ds =   (DataSource)initContext.lookup("java:/comp/env/jdbc/baicSeguro");
			conn =	ds.getConnection();
			
			
        }
        catch(SQLException e){
        	e.printStackTrace();
        }
        catch(NamingException e){
        	e.printStackTrace();
        }
        return conn;
	
	}

	
	 public boolean cerrarCx(){
	        try {
	        	if (!conn.isClosed()){
	        		   conn.close();	
	        	}	         
	            return true;
	        }
	        catch (SQLException e){
	           System.out.println("ERROR "+e.getMessage());
	           return false;
	        }
	   }
}
	

	