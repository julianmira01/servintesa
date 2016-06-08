package modelo.datos.dao.comparendos.generales;


import java.sql.*;
import java.util.*;
import java.math.*;

import modelo.datos.dao.NotFoundException;
import modelo.datos.objetos.comparendos.generales.ViewComparendosResolSancionComp;

import utilidades.Funciones;


/**
  * ViewComparendosResolSancion Data Access Object (DAO) migrado a firebird 2.5.
  * This class contains all database handling that is needed to
  * permanently store and retrieve ViewComparendosResolSancion object instances.
  */

 /**
  * This sourcecode has been generated by FREE DaoGen generator version 2.4.1.
  * The usage of generated code is restricted to OpenSource software projects
  * only. DaoGen is available in http://titaniclinux.net/daogen/
  * It has been programmed by Tuomo Lukka, Tuomo.Lukka@iki.fi
  *
  * DaoGen license: The following DaoGen generated source code is licensed
  * under the terms of GNU GPL license. The full text for license is available
  * in GNU project's pages: http://www.gnu.org/copyleft/gpl.html
  *
  * If you wish to use the DaoGen generator to produce code for closed-source
  * commercial applications, you must pay the lisence fee. The price is
  * 5 USD or 5 Eur for each database table, you are generating code for.
  * (That includes unlimited amount of iterations with all supported languages
  * for each database table you are paying for.) Send mail to
  * "Tuomo.Lukka@iki.fi" for more information. Thank you!
  */



public class ViewComparendosResolSancionCompDao {



    /**
     * createValueObject-method. This method is used when the Dao class needs
     * to create new value object instance. The reason why this method exists
     * is that sometimes the programmer may want to extend also the valueObject
     * and then this method can be overrided to return extended valueObject.
     * NOTE: If you extend the valueObject class, make sure to override the
     * clone() method in it!
     */
    public ViewComparendosResolSancionComp createValueObject() {
          return new ViewComparendosResolSancionComp();
    }


    /**
     * getObject-method. This will create and load valueObject contents from database 
     * using given Primary-Key as identifier. This method is just a convenience method 
     * for the real load-method which accepts the valueObject as a parameter. Returned
     * valueObject will be created using the createValueObject() method.
     */
    public ViewComparendosResolSancionComp getObject(Connection conn, int ID_COMPARENDO) throws NotFoundException, SQLException {

          ViewComparendosResolSancionComp valueObject = createValueObject();
          valueObject.setID_COMPARENDO(ID_COMPARENDO);
          load(conn, valueObject);
          return valueObject;
    }


    /**
     * load-method. This will load valueObject contents from database using
     * Primary-Key as identifier. Upper layer should use this so that valueObject
     * instance is created and only primary-key should be specified. Then call
     * this method to complete other persistent information. This method will
     * overwrite all other fields except primary-key and possible runtime variables.
     * If load can not find matching row, NotFoundException will be thrown.
     *
     * @param conn         This method requires working database connection.
     * @param valueObject  This parameter contains the class instance to be loaded.
     *                     Primary-key field must be set for this to work properly.
     */
    public void load(Connection conn, ViewComparendosResolSancionComp valueObject) throws NotFoundException, SQLException {

          String sql = "SELECT * FROM VIEW_COMPARENDOSRESOLSANCION WHERE (ID_COMPARENDO = ? ) "; 
          PreparedStatement stmt = null;

          try {
               stmt = conn.prepareStatement(sql);
               stmt.setInt(1, valueObject.getID_COMPARENDO()); 

               singleQuery(conn, stmt, valueObject);

          } finally {
              //if (stmt != null)
              //    stmt.close();
          }
    }


    /**
     * LoadAll-method. This will read all contents from database table and
     * build a List containing valueObjects. Please note, that this method
     * will consume huge amounts of resources if table has lot's of rows. 
     * This should only be used when target tables have only small amounts
     * of data.
     *
     * @param conn         This method requires working database connection.
     */
    public List loadAll(Connection conn) throws SQLException {

          String sql = "SELECT * FROM VIEW_COMPARENDOSRESOLSANCION ORDER BY ID_COMPARENDO ASC ";
          List searchResults = listQuery(conn, conn.prepareStatement(sql));

          return searchResults;
    }



    /**
     * create-method. This will create new row in database according to supplied
     * valueObject contents. Make sure that values for all NOT NULL columns are
     * correctly specified. Also, if this table does not use automatic surrogate-keys
     * the primary-key must be specified. After INSERT command this method will 
     * read the generated primary-key back to valueObject if automatic surrogate-keys
     * were used. 
     *
     * @param conn         This method requires working database connection.
     * @param valueObject  This parameter contains the class instance to be created.
     *                     If automatic surrogate-keys are not used the Primary-key 
     *                     field must be set for this to work properly.
     */
    public synchronized void create(Connection conn, ViewComparendosResolSancionComp valueObject) throws SQLException {

          String sql = "";
          PreparedStatement stmt = null;
          ResultSet result = null;

          try {
               sql = "INSERT INTO VIEW_COMPARENDOSRESOLSANCION ( ID_COMPARENDO, ID_INFRACTOR, ID_ESTADO, "
               + "NUMEROCOMPARENDO, FECHACOMPARENDO, PLACA, "
               + "ID, IDINFRACCION, DESCRIPCION, "
               + "NUEVO_CODIGO, COD_INFRACCION, SALARIOS, ESTADO, "
               + "ID_SERVICIO, VALORINFRACCION) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) ";
               stmt = conn.prepareStatement(sql);

               stmt.setInt(1, valueObject.getID_COMPARENDO()); 
               stmt.setInt(2, valueObject.getID_INFRACTOR()); 
               stmt.setInt(3, valueObject.getID_ESTADO()); 
               stmt.setString(4, valueObject.getNUMEROCOMPARENDO()); 
               stmt.setString(5, valueObject.getFECHACOMPARENDO()); 
               stmt.setString(6, valueObject.getPLACA()); 
               stmt.setInt(7, valueObject.getID()); 
               stmt.setInt(8, valueObject.getIDINFRACCION()); 
               stmt.setString(9, valueObject.getDESCRIPCION()); 
               stmt.setString(10, valueObject.getNUEVO_CODIGO()); 
               stmt.setString(11, valueObject.getCOD_INFRACCION());
               stmt.setString(12, valueObject.getSALARIOS());
               stmt.setString(13, valueObject.getESTADO()); 
               stmt.setInt(14, valueObject.getID_SERVICIO()); 
               stmt.setString(15, valueObject.getVALORINFRACCION());
              
               int rowcount = databaseUpdate(conn, stmt);
               if (rowcount != 1) {
                    //System.out.println("PrimaryKey Error when updating DB!");
                    throw new SQLException("PrimaryKey Error when updating DB!");
               }

          } finally {
              if (stmt != null)
                  stmt.close();
          }


    }


    /**
     * save-method. This method will save the current state of valueObject to database.
     * Save can not be used to create new instances in database, so upper layer must
     * make sure that the primary-key is correctly specified. Primary-key will indicate
     * which instance is going to be updated in database. If save can not find matching 
     * row, NotFoundException will be thrown.
     *
     * @param conn         This method requires working database connection.
     * @param valueObject  This parameter contains the class instance to be saved.
     *                     Primary-key field must be set for this to work properly.
     */
    public void save(Connection conn, ViewComparendosResolSancionComp valueObject) 
          throws NotFoundException, SQLException {

          String sql = "UPDATE VIEW_COMPARENDOSRESOLSANCION SET ID_INFRACTOR = ?, ID_ESTADO = ?, NUMEROCOMPARENDO = ?, "
               + "FECHACOMPARENDO = ?, PLACA = ?, ID = ?, "
               + "IDINFRACCION = ?, DESCRIPCION = ?, NUEVO_CODIGO = ?, "
               + "COD_INFRACCION = ?, COD_INFRACCION = ?, ESTADO = ?, ID_SERVICIO = ?, VALORINFRACCION = ? WHERE (ID_COMPARENDO = ? ) ";
          PreparedStatement stmt = null;

          try {
              stmt = conn.prepareStatement(sql);
              stmt.setInt(1, valueObject.getID_INFRACTOR()); 
              stmt.setInt(2, valueObject.getID_ESTADO()); 
              stmt.setString(3, valueObject.getNUMEROCOMPARENDO()); 
              stmt.setString(4, valueObject.getFECHACOMPARENDO()); 
              stmt.setString(5, valueObject.getPLACA()); 
              stmt.setInt(6, valueObject.getID()); 
              stmt.setInt(7, valueObject.getIDINFRACCION()); 
              stmt.setString(8, valueObject.getDESCRIPCION()); 
              stmt.setString(9, valueObject.getNUEVO_CODIGO()); 
              stmt.setString(10, valueObject.getCOD_INFRACCION()); 
              stmt.setString(11, valueObject.getSALARIOS()); 
              stmt.setString(12, valueObject.getESTADO()); 
              stmt.setInt(13, valueObject.getID_SERVICIO()); 
              stmt.setInt(14, valueObject.getID_COMPARENDO()); 
              stmt.setString(15, valueObject.getVALORINFRACCION());
              
              int rowcount = databaseUpdate(conn, stmt);
              if (rowcount == 0) {
                   //System.out.println("Object could not be saved! (PrimaryKey not found)");
                   throw new NotFoundException("Object could not be saved! (PrimaryKey not found)");
              }
              if (rowcount > 1) {
                   //System.out.println("PrimaryKey Error when updating DB! (Many objects were affected!)");
                   throw new SQLException("PrimaryKey Error when updating DB! (Many objects were affected!)");
              }
          } finally {
              if (stmt != null)
                  stmt.close();
          }
    }


    /**
     * delete-method. This method will remove the information from database as identified by
     * by primary-key in supplied valueObject. Once valueObject has been deleted it can not 
     * be restored by calling save. Restoring can only be done using create method but if 
     * database is using automatic surrogate-keys, the resulting object will have different 
     * primary-key than what it was in the deleted object. If delete can not find matching row,
     * NotFoundException will be thrown.
     *
     * @param conn         This method requires working database connection.
     * @param valueObject  This parameter contains the class instance to be deleted.
     *                     Primary-key field must be set for this to work properly.
     */
    public void delete(Connection conn, ViewComparendosResolSancionComp valueObject) 
          throws NotFoundException, SQLException {

          String sql = "DELETE FROM VIEW_COMPARENDOSRESOLSANCION WHERE (ID_COMPARENDO = ? ) ";
          PreparedStatement stmt = null;

          try {
              stmt = conn.prepareStatement(sql);
              stmt.setInt(1, valueObject.getID_COMPARENDO()); 

              int rowcount = databaseUpdate(conn, stmt);
              if (rowcount == 0) {
                   //System.out.println("Object could not be deleted (PrimaryKey not found)");
                   throw new NotFoundException("Object could not be deleted! (PrimaryKey not found)");
              }
              if (rowcount > 1) {
                   //System.out.println("PrimaryKey Error when updating DB! (Many objects were deleted!)");
                   throw new SQLException("PrimaryKey Error when updating DB! (Many objects were deleted!)");
              }
          } finally {
              if (stmt != null)
                  stmt.close();
          }
    }


    /**
     * deleteAll-method. This method will remove all information from the table that matches
     * this Dao and ValueObject couple. This should be the most efficient way to clear table.
     * Once deleteAll has been called, no valueObject that has been created before can be 
     * restored by calling save. Restoring can only be done using create method but if database 
     * is using automatic surrogate-keys, the resulting object will have different primary-key 
     * than what it was in the deleted object. (Note, the implementation of this method should
     * be different with different DB backends.)
     *
     * @param conn         This method requires working database connection.
     */
    public void deleteAll(Connection conn) throws SQLException {

          String sql = "DELETE FROM VIEW_COMPARENDOSRESOLSANCION";
          PreparedStatement stmt = null;

          try {
              stmt = conn.prepareStatement(sql);
              int rowcount = databaseUpdate(conn, stmt);
          } finally {
              if (stmt != null)
                  stmt.close();
          }
    }


    /**
     * coutAll-method. This method will return the number of all rows from table that matches
     * this Dao. The implementation will simply execute "select count(primarykey) from table".
     * If table is empty, the return value is 0. This method should be used before calling
     * loadAll, to make sure table has not too many rows.
     *
     * @param conn         This method requires working database connection.
     */
    public int countAll(Connection conn) throws SQLException {

          String sql = "SELECT count(*) FROM VIEW_COMPARENDOSRESOLSANCION";
          PreparedStatement stmt = null;
          ResultSet result = null;
          int allRows = 0;

          try {
              stmt = conn.prepareStatement(sql);
              result = stmt.executeQuery();

              if (result.next())
                  allRows = result.getInt(1);
          } finally {
              if (result != null)
                  result.close();
              if (stmt != null)
                  stmt.close();
          }
          return allRows;
    }
    
    /*public List buscarComparendosEnRangoFechas(Connection conn, String fechaIni,
                                    String fechaFin, int idEstadoComparendo) throws NotFoundException, SQLException {
        String sql = "SELECT * FROM VIEW_COMPARENDOSRESOLSANCION WHERE " +
            "(FECHACOMPARENDO BETWEEN '" + Funciones.convFechaFormatoMotor(fechaIni) + "' AND '" + Funciones.convFechaFormatoMotor(fechaFin) + "') " +
            "AND ID_ESTADO = " + idEstadoComparendo;
        
        PreparedStatement stmt = null;
        List lista;
  
        try {
            stmt = conn.prepareStatement(sql);                      
            lista = listQuery(conn, stmt);
        } finally {
            if (stmt != null)
                stmt.close();
        }
        return lista;
    }
*/
    
    
    public List buscarComparendosEnRangoFechas(Connection conn,
                                               String fechaIni,
                                               String fechaFin,
                                               ViewComparendosResolSancionComp valueObject, String tipoEstado) throws NotFoundException,
                                                                                                   SQLException {
        List searchResults;
        boolean first = true;

        StringBuffer sql =
            new StringBuffer("SELECT * FROM VIEW_COMPARENDOSRESOLSANCION WHERE " +
                             "(FECHACOMPARENDO BETWEEN '" +
                             Funciones.convFechaFormatoMotor(fechaIni) +
                             "' AND '" +
                             Funciones.convFechaFormatoMotor(fechaFin) +
                             "')  ");

        if (valueObject.getID_COMPARENDO() != 0) {
            if (first) {
                first = false;
            }
            sql.append("AND ID_COMPARENDO = ").append(valueObject.getID_COMPARENDO()).append(" ");
        }

        if (valueObject.getID_INFRACTOR() != 0) {
            if (first) {
                first = false;
            }
            sql.append("AND ID_INFRACTOR = ").append(valueObject.getID_INFRACTOR()).append(" ");
        }
if(tipoEstado.equals("I"))
{
        if (valueObject.getID_ESTADO() != 0) {
            if (first) {
                first = false;
            }
            sql.append("AND ID_ESTADO = ").append(valueObject.getID_ESTADO()).append(" ");
        }
}else
{
        if (valueObject.getID_ESTADO() != 0) {
            if (first) {
                first = false;
            }
            sql.append("AND ID_ESTADO != ").append(valueObject.getID_ESTADO()).append(" ");
        }
    }
        if (valueObject.getNUMEROCOMPARENDO() != null) {
            if (first) {
                first = false;
            }
            sql.append("AND NUMEROCOMPARENDO = '").append(valueObject.getNUMEROCOMPARENDO()).append("' ");
        }

        if (valueObject.getFECHACOMPARENDO() != null) {
            if (first) {
                first = false;
            }
            sql.append("AND FECHACOMPARENDO = '").append(valueObject.getFECHACOMPARENDO()).append("' ");
        }

        if (valueObject.getPLACA() != null) {
            if (first) {
                first = false;
            }
            sql.append("AND PLACA = '").append(valueObject.getPLACA()).append("' ");
        }

        if (valueObject.getID() != 0) {
            if (first) {
                first = false;
            }
            sql.append("AND ID = ").append(valueObject.getID()).append(" ");
        }

        if (valueObject.getIDINFRACCION() != 0) {
            if (first) {
                first = false;
            }
            sql.append("AND IDINFRACCION = ").append(valueObject.getIDINFRACCION()).append(" ");
        }

        if (valueObject.getDESCRIPCION() != null) {
            if (first) {
                first = false;
            }
            sql.append("AND DESCRIPCION = '").append(valueObject.getDESCRIPCION()).append("' ");
        }

        if (valueObject.getNUEVO_CODIGO() != null) {
            if (first) {
                first = false;
            }
            sql.append("AND NUEVO_CODIGO = '").append(valueObject.getNUEVO_CODIGO()).append("' ");
        }

        if (valueObject.getCOD_INFRACCION() != null) {
            if (first) {
                first = false;
            }
            sql.append("AND COD_INFRACCION = '").append(valueObject.getCOD_INFRACCION()).append("' ");
        }

        if (valueObject.getESTADO() != null) {
            if (first) {
                first = false;
            }
            sql.append("AND ESTADO = ").append(valueObject.getESTADO()).append(" ");
        }

        if (valueObject.getID_SERVICIO() != 0) {
            if (first) {
                first = false;
            }
            sql.append("AND ID_SERVICIO = ").append(valueObject.getID_SERVICIO()).append(" ");
        }
        
        if (valueObject.getVALORINFRACCION() != null) {
            if (first) {
                first = false;
            }
            sql.append("AND VALORINFRACCION = ").append(valueObject.getVALORINFRACCION()).append(" ");
        }

        sql.append("ORDER BY FECHACOMPARENDO ASC ");
        
        searchResults = listQuery(conn, conn.prepareStatement(sql.toString()));

        return searchResults;

    }

    public List buscarComparendosEnRangoFechasPorcDesc(Connection conn,
                                               String fechaIni,
                                               String fechaFin,
                                               ViewComparendosResolSancionComp valueObject, String tipoEstado, String porcDesc) throws NotFoundException,
                                                                                                   SQLException {
        List searchResults;
        boolean first = true;

        StringBuffer sql =
            new StringBuffer("" +
            
        "SELECT DISTINCT "+
                    " VIEW_COMPARENDOSRESOLSANCION.*, l_tarifas.lt_descripcion"+
                    " FROM"+
                    " VIEW_COMPARENDOSRESOLSANCION"+
                    " LEFT OUTER JOIN INFRACCIONCOMPARENDO ON (INFRACCIONCOMPARENDO.idcomparendo = VIEW_COMPARENDOSRESOLSANCION.id_comparendo)"+
                    " LEFT OUTER JOIN DATOSLIQUIDACION ON (DATOSLIQUIDACION.idinfraccion = INFRACCIONCOMPARENDO.id)"+
                    " LEFT OUTER JOIN l_tarifasdet ON (l_tarifasdet.ltd_id = DATOSLIQUIDACION.l_tarifasdet)"+
                    " LEFT OUTER JOIN l_tarifas ON (l_tarifas.lt_id = l_tarifasdet.ltd_lt_id)"+
                    " WHERE"+
                    " l_tarifas.lt_descripcion is not null"+
                    " AND l_tarifas.lt_descripcion LIKE '%"+porcDesc+"%'"+
                    " AND VIEW_COMPARENDOSRESOLSANCION.FECHACOMPARENDO BETWEEN '"+Funciones.convFechaFormatoMotor(fechaIni)+"'"+
                    " AND '"+ Funciones.convFechaFormatoMotor(fechaFin) +"' ");
            
            
            

        if (valueObject.getID_COMPARENDO() != 0) {
            if (first) {
                first = false;
            }
            sql.append("AND ID_COMPARENDO = ").append(valueObject.getID_COMPARENDO()).append(" ");
        }

        if (valueObject.getID_INFRACTOR() != 0) {
            if (first) {
                first = false;
            }
            sql.append("AND ID_INFRACTOR = ").append(valueObject.getID_INFRACTOR()).append(" ");
        }
    if(tipoEstado.equals("I"))
    {
        if (valueObject.getID_ESTADO() != 0) {
            if (first) {
                first = false;
            }
            sql.append("AND ID_ESTADO = ").append(valueObject.getID_ESTADO()).append(" ");
        }
    }else
    {
        if (valueObject.getID_ESTADO() != 0) {
            if (first) {
                first = false;
            }
            sql.append("AND ID_ESTADO != ").append(valueObject.getID_ESTADO()).append(" ");
        }
    }
        if (valueObject.getNUMEROCOMPARENDO() != null) {
            if (first) {
                first = false;
            }
            sql.append("AND NUMEROCOMPARENDO = '").append(valueObject.getNUMEROCOMPARENDO()).append("' ");
        }

        if (valueObject.getFECHACOMPARENDO() != null) {
            if (first) {
                first = false;
            }
            sql.append("AND FECHACOMPARENDO = '").append(valueObject.getFECHACOMPARENDO()).append("' ");
        }

        if (valueObject.getPLACA() != null) {
            if (first) {
                first = false;
            }
            sql.append("AND PLACA = '").append(valueObject.getPLACA()).append("' ");
        }

        if (valueObject.getID() != 0) {
            if (first) {
                first = false;
            }
            sql.append("AND ID = ").append(valueObject.getID()).append(" ");
        }

        if (valueObject.getIDINFRACCION() != 0) {
            if (first) {
                first = false;
            }
            sql.append("AND IDINFRACCION = ").append(valueObject.getIDINFRACCION()).append(" ");
        }

        if (valueObject.getDESCRIPCION() != null) {
            if (first) {
                first = false;
            }
            sql.append("AND DESCRIPCION = '").append(valueObject.getDESCRIPCION()).append("' ");
        }

        if (valueObject.getNUEVO_CODIGO() != null) {
            if (first) {
                first = false;
            }
            sql.append("AND NUEVO_CODIGO = '").append(valueObject.getNUEVO_CODIGO()).append("' ");
        }

        if (valueObject.getCOD_INFRACCION() != null) {
            if (first) {
                first = false;
            }
            sql.append("AND COD_INFRACCION = '").append(valueObject.getCOD_INFRACCION()).append("' ");
        }

        if (valueObject.getESTADO() != null) {
            if (first) {
                first = false;
            }
            sql.append("AND ESTADO = ").append(valueObject.getESTADO()).append(" ");
        }

        if (valueObject.getID_SERVICIO() != 0) {
            if (first) {
                first = false;
            }
            sql.append("AND ID_SERVICIO = ").append(valueObject.getID_SERVICIO()).append(" ");
        }

        sql.append("ORDER BY FECHACOMPARENDO ASC ");
        
        searchResults = listQuery(conn, conn.prepareStatement(sql.toString()));

        return searchResults;

    }
    
    
    

    /** 
     * searchMatching-Method. This method provides searching capability to 
     * get matching valueObjects from database. It works by searching all 
     * objects that match permanent instance variables of given object.
     * Upper layer should use this by setting some parameters in valueObject
     * and then  call searchMatching. The result will be 0-N objects in a List, 
     * all matching those criteria you specified. Those instance-variables that
     * have NULL values are excluded in search-criteria.
     *
     * @param conn         This method requires working database connection.
     * @param valueObject  This parameter contains the class instance where search will be based.
     *                     Primary-key field should not be set.
     */
    public List searchMatching(Connection conn, ViewComparendosResolSancionComp valueObject) throws SQLException {

          List searchResults;

          boolean first = true;
          StringBuffer sql = new StringBuffer("SELECT * FROM VIEW_COMPARENDOSRESOLSANCION WHERE 1=1 ");

          if (valueObject.getID_COMPARENDO() != 0) {
              if (first) { first = false; }
              sql.append("AND ID_COMPARENDO = ").append(valueObject.getID_COMPARENDO()).append(" ");
          }

          if (valueObject.getID_INFRACTOR() != 0) {
              if (first) { first = false; }
              sql.append("AND ID_INFRACTOR = ").append(valueObject.getID_INFRACTOR()).append(" ");
          }

          if (valueObject.getID_ESTADO() != 0) {
              if (first) { first = false; }
              sql.append("AND ID_ESTADO = ").append(valueObject.getID_ESTADO()).append(" ");
          }

          if (valueObject.getNUMEROCOMPARENDO() != null) {
              if (first) { first = false; }
              sql.append("AND NUMEROCOMPARENDO = '").append(valueObject.getNUMEROCOMPARENDO()).append("' ");
          }

          if (valueObject.getFECHACOMPARENDO() != null) {
              if (first) { first = false; }
              sql.append("AND FECHACOMPARENDO = '").append(valueObject.getFECHACOMPARENDO()).append("' ");
          }

          if (valueObject.getPLACA() != null) {
              if (first) { first = false; }
              sql.append("AND PLACA = '").append(valueObject.getPLACA()).append("' ");
          }

          if (valueObject.getID() != 0) {
              if (first) { first = false; }
              sql.append("AND ID = ").append(valueObject.getID()).append(" ");
          }

          if (valueObject.getIDINFRACCION() != 0) {
              if (first) { first = false; }
              sql.append("AND IDINFRACCION = ").append(valueObject.getIDINFRACCION()).append(" ");
          }

          if (valueObject.getDESCRIPCION() != null) {
              if (first) { first = false; }
              sql.append("AND DESCRIPCION = '").append(valueObject.getDESCRIPCION()).append("' ");
          }

          if (valueObject.getNUEVO_CODIGO() != null) {
              if (first) { first = false; }
              sql.append("AND NUEVO_CODIGO = '").append(valueObject.getNUEVO_CODIGO()).append("' ");
          }

          if (valueObject.getCOD_INFRACCION() != null) {
              if (first) { first = false; }
              sql.append("AND COD_INFRACCION = '").append(valueObject.getCOD_INFRACCION()).append("' ");
          }
          
        if (valueObject.getSALARIOS() != null) {
            if (first) { first = false; }
            sql.append("AND SALARIOS = '").append(valueObject.getSALARIOS()).append("' ");
        }


          if (valueObject.getESTADO() != null) {
              if (first) { first = false; }
              sql.append("AND ESTADO = ").append(valueObject.getESTADO()).append(" ");
          }

          if (valueObject.getID_SERVICIO() != 0) {
              if (first) { first = false; }
              sql.append("AND ID_SERVICIO = ").append(valueObject.getID_SERVICIO()).append(" ");
          }
          
        if (valueObject.getVALORINFRACCION() != null) {
            if (first) { first = false; }
            sql.append("AND VALORINFRACCION = ").append(valueObject.getVALORINFRACCION()).append(" ");
        }


          sql.append("ORDER BY FECHACOMPARENDO ASC ");

          // Prevent accidential full table results.
          // Use loadAll if all rows must be returned.
          if (first)
               searchResults = new ArrayList();
          else
               searchResults = listQuery(conn, conn.prepareStatement(sql.toString()));

          return searchResults;
    }


    /** 
     * getDaogenVersion will return information about
     * generator which created these sources.
     */
    public String getDaogenVersion() {
        return "DaoGen version 2.4.1";
    }


    /**
     * databaseUpdate-method. This method is a helper method for internal use. It will execute
     * all database handling that will change the information in tables. SELECT queries will
     * not be executed here however. The return value indicates how many rows were affected.
     * This method will also make sure that if cache is used, it will reset when data changes.
     *
     * @param conn         This method requires working database connection.
     * @param stmt         This parameter contains the SQL statement to be excuted.
     */
    protected int databaseUpdate(Connection conn, PreparedStatement stmt) throws SQLException {

          int result = stmt.executeUpdate();

          return result;
    }



    /**
     * databaseQuery-method. This method is a helper method for internal use. It will execute
     * all database queries that will return only one row. The resultset will be converted
     * to valueObject. If no rows were found, NotFoundException will be thrown.
     *
     * @param conn         This method requires working database connection.
     * @param stmt         This parameter contains the SQL statement to be excuted.
     * @param valueObject  Class-instance where resulting data will be stored.
     */
    protected void singleQuery(Connection conn, PreparedStatement stmt, ViewComparendosResolSancionComp valueObject) 
          throws NotFoundException, SQLException {

          ResultSet result = null;

          try {
              result = stmt.executeQuery();

              if (result.next()) {

                   valueObject.setID_COMPARENDO(result.getInt("ID_COMPARENDO")); 
                   valueObject.setID_INFRACTOR(result.getInt("ID_INFRACTOR")); 
                   valueObject.setID_ESTADO(result.getInt("ID_ESTADO")); 
                   valueObject.setNUMEROCOMPARENDO(result.getString("NUMEROCOMPARENDO")); 
                   valueObject.setFECHACOMPARENDO(result.getString("FECHACOMPARENDO")); 
                   valueObject.setPLACA(result.getString("PLACA")); 
                   valueObject.setID(result.getInt("ID")); 
                   valueObject.setIDINFRACCION(result.getInt("IDINFRACCION")); 
                   valueObject.setDESCRIPCION(result.getString("DESCRIPCION")); 
                   valueObject.setNUEVO_CODIGO(result.getString("NUEVO_CODIGO")); 
                   valueObject.setCOD_INFRACCION(result.getString("COD_INFRACCION")); 
                   valueObject.setSALARIOS(result.getString("SALARIOS"));
                   valueObject.setESTADO(result.getString("ESTADO")); 
                   valueObject.setID_SERVICIO(result.getInt("ID_SERVICIO")); 
                   valueObject.setVALORINFRACCION(result.getString("VALORINFRACCION")); 

              } else {
                    //System.out.println("ViewComparendosResolSancion Object Not Found!");
                    throw new NotFoundException("ViewComparendosResolSancion Object Not Found!");
              }
          } finally {
              if (result != null)
                  result.close();
              if (stmt != null)
                  stmt.close();
          }
    }


    /**
     * databaseQuery-method. This method is a helper method for internal use. It will execute
     * all database queries that will return multiple rows. The resultset will be converted
     * to the List of valueObjects. If no rows were found, an empty List will be returned.
     *
     * @param conn         This method requires working database connection.
     * @param stmt         This parameter contains the SQL statement to be excuted.
     */
    protected List listQuery(Connection conn, PreparedStatement stmt) throws SQLException {

          ArrayList searchResults = new ArrayList();
          ResultSet result = null;

          try {
              result = stmt.executeQuery();

              while (result.next()) {
                   ViewComparendosResolSancionComp temp = createValueObject();

                   temp.setID_COMPARENDO(result.getInt("ID_COMPARENDO")); 
                   temp.setID_INFRACTOR(result.getInt("ID_INFRACTOR")); 
                   temp.setID_ESTADO(result.getInt("ID_ESTADO")); 
                   temp.setNUMEROCOMPARENDO(result.getString("NUMEROCOMPARENDO")); 
                   temp.setFECHACOMPARENDO(result.getString("FECHACOMPARENDO")); 
                   temp.setPLACA(result.getString("PLACA")); 
                   temp.setID(result.getInt("ID")); 
                   temp.setIDINFRACCION(result.getInt("IDINFRACCION")); 
                   temp.setDESCRIPCION(result.getString("DESCRIPCION")); 
                   temp.setNUEVO_CODIGO(result.getString("NUEVO_CODIGO")); 
                   temp.setCOD_INFRACCION(result.getString("COD_INFRACCION")); 
                   temp.setSALARIOS(result.getString("SALARIOS")); 
                   temp.setESTADO(result.getString("ESTADO")); 
                   temp.setID_SERVICIO(result.getInt("ID_SERVICIO")); 
                   temp.setVALORINFRACCION(result.getString("VALORINFRACCION")); 

                   searchResults.add(temp);
              }

          } finally {
              if (result != null)
                  result.close();
              if (stmt != null)
                  stmt.close();
          }

          return (List)searchResults;
    }


}