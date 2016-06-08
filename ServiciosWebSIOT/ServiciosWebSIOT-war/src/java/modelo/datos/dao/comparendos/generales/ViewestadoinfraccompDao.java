package modelo.datos.dao.comparendos.generales;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import java.util.ArrayList;
import java.util.List;

import modelo.datos.objetos.comparendos.generales.Viewestadoinfraccomp;

import utilidades.Funciones;


public class ViewestadoinfraccompDao {


    public Viewestadoinfraccomp createValueObject() {
        return new Viewestadoinfraccomp();
    }

    public Viewestadoinfraccomp getObject(Connection conn, int ID_COMPARENDO) throws SQLException {
        Viewestadoinfraccomp valueObject = createValueObject();
        valueObject.setID_COMPARENDO(ID_COMPARENDO);
        load(conn, valueObject);
        return valueObject;
    }

    public void load(Connection conn, Viewestadoinfraccomp valueObject) throws SQLException {
        String sql = "SELECT * FROM VIEW_ESTADO_INFRAC_COMP WHERE (ID_COMPARENDO = ? )";
        PreparedStatement stmt = null;
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, valueObject.getID_COMPARENDO());
            singleQuery(conn, stmt, valueObject);
        } finally {

        }
    }


    public List loadAll(Connection conn) throws SQLException {
        String sql = "SELECT * FROM VIEW_ESTADO_INFRAC_COMP ORDER BY ID_COMPARENDO ASC ";
        List searchResults = listQuery(conn, conn.prepareStatement(sql));
        return searchResults;
    }

    public List loadEnEstados(Connection conn, String estados, int idinfractor) throws SQLException {
        String sql = "SELECT * FROM VIEW_ESTADO_INFRAC_COMP WHERE ID_ESTADO_COMPARENDO IN ("+ estados +") AND ID_INFRACTOR = "+ String.valueOf(idinfractor) + "  ORDER BY ID_COMPARENDO ASC ";
        List searchResults = listQuery(conn, conn.prepareStatement(sql));
        return searchResults;
    }


    public List loadAll(Connection conn, int limiteInf, int limiteSup) throws SQLException {
        String sql =
            "SELECT * FROM (SELECT *, ROW_NUMBER() OVER (ORDER BY ID_COMPARENDO) AS RowNumber FROM VIEW_ESTADO_INFRAC_COMP) AS CONSULTA WHERE RowNumber >=" +
            limiteInf + " AND RowNumber <=" + limiteSup;
        List searchResults = listQuery(conn, conn.prepareStatement(sql));
        return searchResults;
    }


    public synchronized void create(Connection conn, Viewestadoinfraccomp valueObject) throws SQLException {
        String sql = "";
        PreparedStatement stmt = null;
        ResultSet result = null;
        try {
            sql =
"INSERT INTO VIEW_ESTADO_INFRAC_COMP ( ID_COMPARENDO," + " ID_VEHICULOCOMP, ID_INFRACTOR, NUMEROCOMPARENDO," +
  " FECHACOMPARENDO, HORACOMPARENDO, PLACA," + " ID_INFRACCIONCOMPARENDO, ID_INFRACCION, INFRACCION," +
  " COD_INFRACCION, NUEVO_CODIGO_INFRACCION, NUM_SALARIOS_MINIMOS," +
  " ID_ESTADO_COMPARENDO, COD_ESTADO_COMPARENDO, ESTADO_COMPARENDO" + ")" +
  "VALUES ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, valueObject.getID_COMPARENDO());
            if (!Funciones.EnteroesNulo(valueObject.getID_VEHICULOCOMP()))
                stmt.setInt(2, valueObject.getID_VEHICULOCOMP());
            else
                stmt.setNull(2, Types.INTEGER);
            if (!Funciones.EnteroesNulo(valueObject.getID_INFRACTOR()))
                stmt.setInt(3, valueObject.getID_INFRACTOR());
            else
                stmt.setNull(3, Types.INTEGER);
            if (Funciones.contarCadena(valueObject.getNUMEROCOMPARENDO(), 40))
                stmt.setString(4, valueObject.getNUMEROCOMPARENDO());
            else
                stmt.setNull(4, Types.VARCHAR);
            if (Funciones.contarCadena(valueObject.getFECHACOMPARENDO(), 40))
                stmt.setString(5, valueObject.getFECHACOMPARENDO());
            else
                stmt.setNull(5, Types.VARCHAR);
            
            //if (Funciones.contarCadena(valueObject.getHORACOMPARENDO(), 40))
              //  stmt.setString(6, valueObject.getHORACOMPARENDO());
            //else
              //  stmt.setNull(6, Types.VARCHAR);
                      
          if (Funciones.esTime(valueObject.getHORACOMPARENDO()))
            stmt.setTime(6,Funciones.calendarToTime(Funciones.stringToCalendar(valueObject.getHORACOMPARENDO())));
          else
            stmt.setNull(6, Types.TIME);
            
            if (Funciones.contarCadena(valueObject.getPLACA(), 10))
                stmt.setString(7, valueObject.getPLACA());
            else
                stmt.setNull(7, Types.VARCHAR);
            if (!Funciones.EnteroesNulo(valueObject.getID_INFRACCIONCOMPARENDO()))
                stmt.setInt(8, valueObject.getID_INFRACCIONCOMPARENDO());
            else
                stmt.setNull(8, Types.INTEGER);
            if (!Funciones.EnteroesNulo(valueObject.getID_INFRACCION()))
                stmt.setInt(9, valueObject.getID_INFRACCION());
            else
                stmt.setNull(9, Types.INTEGER);
            if (Funciones.contarCadena(valueObject.getINFRACCION(), 1200))
                stmt.setString(10, valueObject.getINFRACCION());
            else
                stmt.setNull(10, Types.VARCHAR);
            if (Funciones.contarCadena(valueObject.getCOD_INFRACCION(), 5))
                stmt.setString(11, valueObject.getCOD_INFRACCION());
            else
                stmt.setNull(11, Types.VARCHAR);
            if (Funciones.contarCadena(valueObject.getNUEVO_CODIGO_INFRACCION(), 5))
                stmt.setString(12, valueObject.getNUEVO_CODIGO_INFRACCION());
            else
                stmt.setNull(12, Types.VARCHAR);
            if (!Funciones.DoubleEsNulo(valueObject.getNUM_SALARIOS_MINIMOS()))
                stmt.setDouble(13, valueObject.getNUM_SALARIOS_MINIMOS());
            else
                stmt.setNull(13, Types.DOUBLE);
            if (!Funciones.EnteroesNulo(valueObject.getID_ESTADO_COMPARENDO()))
                stmt.setInt(14, valueObject.getID_ESTADO_COMPARENDO());
            else
                stmt.setNull(14, Types.INTEGER);
            if (Funciones.contarCadena(valueObject.getCOD_ESTADO_COMPARENDO(), 5))
                stmt.setString(15, valueObject.getCOD_ESTADO_COMPARENDO());
            else
                stmt.setNull(15, Types.VARCHAR);
            if (Funciones.contarCadena(valueObject.getESTADO_COMPARENDO(), 25))
                stmt.setString(16, valueObject.getESTADO_COMPARENDO());
            else
                stmt.setNull(16, Types.VARCHAR);


            int rowcount = databaseUpdate(conn, stmt);
            if (rowcount != 1) {
                throw new SQLException("PrimaryKey Error when updating DB!");
            }
        } finally {
            if (stmt != null)
                stmt.close();
        }
    }


    public void save(Connection conn, Viewestadoinfraccomp valueObject) throws SQLException {
        PreparedStatement stmt = null;
        String sql = "";
        try {
            sql =
"UPDATE VIEW_ESTADO_INFRAC_COMP SET  ID_VEHICULOCOMP = ?, ID_INFRACTOR = ?, NUMEROCOMPARENDO = ?," + " FECHACOMPARENDO = ?, HORACOMPARENDO = ?, PLACA = ?," +
  " ID_INFRACCIONCOMPARENDO = ?, ID_INFRACCION = ?, INFRACCION = ?," +
  " COD_INFRACCION = ?, NUEVO_CODIGO_INFRACCION = ?, NUM_SALARIOS_MINIMOS = ?," +
  " ID_ESTADO_COMPARENDO = ?, COD_ESTADO_COMPARENDO = ?, ESTADO_COMPARENDO = ?" + " WHERE (ID_COMPARENDO= ?)";
            stmt = conn.prepareStatement(sql);
            if (!Funciones.EnteroesNulo(valueObject.getID_VEHICULOCOMP()))
                stmt.setInt(1, valueObject.getID_VEHICULOCOMP());
            else
                stmt.setNull(1, Types.INTEGER);
            if (!Funciones.EnteroesNulo(valueObject.getID_INFRACTOR()))
                stmt.setInt(2, valueObject.getID_INFRACTOR());
            else
                stmt.setNull(2, Types.INTEGER);
            if (Funciones.contarCadena(valueObject.getNUMEROCOMPARENDO(), 40))
                stmt.setString(3, valueObject.getNUMEROCOMPARENDO());
            else
                stmt.setNull(3, Types.VARCHAR);
            if (Funciones.contarCadena(valueObject.getFECHACOMPARENDO(), 40))
                stmt.setString(4, valueObject.getFECHACOMPARENDO());
            else
                stmt.setNull(4, Types.VARCHAR);
            if (Funciones.contarCadena(valueObject.getHORACOMPARENDO(), 40))
                stmt.setString(5, valueObject.getHORACOMPARENDO());
            else
                stmt.setNull(5, Types.VARCHAR);
            if (Funciones.contarCadena(valueObject.getPLACA(), 10))
                stmt.setString(6, valueObject.getPLACA());
            else
                stmt.setNull(6, Types.VARCHAR);
            if (!Funciones.EnteroesNulo(valueObject.getID_INFRACCIONCOMPARENDO()))
                stmt.setInt(7, valueObject.getID_INFRACCIONCOMPARENDO());
            else
                stmt.setNull(7, Types.INTEGER);
            if (!Funciones.EnteroesNulo(valueObject.getID_INFRACCION()))
                stmt.setInt(8, valueObject.getID_INFRACCION());
            else
                stmt.setNull(8, Types.INTEGER);
            if (Funciones.contarCadena(valueObject.getINFRACCION(), 1200))
                stmt.setString(9, valueObject.getINFRACCION());
            else
                stmt.setNull(9, Types.VARCHAR);
            if (Funciones.contarCadena(valueObject.getCOD_INFRACCION(), 5))
                stmt.setString(10, valueObject.getCOD_INFRACCION());
            else
                stmt.setNull(10, Types.VARCHAR);
            if (Funciones.contarCadena(valueObject.getNUEVO_CODIGO_INFRACCION(), 5))
                stmt.setString(11, valueObject.getNUEVO_CODIGO_INFRACCION());
            else
                stmt.setNull(11, Types.VARCHAR);
            if (!Funciones.DoubleEsNulo(valueObject.getNUM_SALARIOS_MINIMOS()))
                stmt.setDouble(12, valueObject.getNUM_SALARIOS_MINIMOS());
            else
                stmt.setNull(12, Types.DOUBLE);
            if (!Funciones.EnteroesNulo(valueObject.getID_ESTADO_COMPARENDO()))
                stmt.setInt(13, valueObject.getID_ESTADO_COMPARENDO());
            else
                stmt.setNull(13, Types.INTEGER);
            if (Funciones.contarCadena(valueObject.getCOD_ESTADO_COMPARENDO(), 5))
                stmt.setString(14, valueObject.getCOD_ESTADO_COMPARENDO());
            else
                stmt.setNull(14, Types.VARCHAR);
            if (Funciones.contarCadena(valueObject.getESTADO_COMPARENDO(), 25))
                stmt.setString(15, valueObject.getESTADO_COMPARENDO());
            else
                stmt.setNull(15, Types.VARCHAR);
            stmt.setInt(16, valueObject.getID_COMPARENDO());

            int rowcount = databaseUpdate(conn, stmt);
            if (rowcount == 0) {
                throw new SQLException();
            }
        } finally {
            if (stmt != null)
                stmt.close();
        }
    }


    public void delete(Connection conn, Viewestadoinfraccomp valueObject) throws SQLException {
        PreparedStatement stmt = null;
        String sql = "";
        try {
            sql = "DELETE FROM VIEW_ESTADO_INFRAC_COMP WHERE (ID_COMPARENDO = ? )";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, valueObject.getID_COMPARENDO());

            int rowcount = databaseUpdate(conn, stmt);
            if (rowcount == 0) {
                throw new SQLException();
            }
            if (rowcount > 1) {
                throw new SQLException("PrimaryKey Error when updating DB! (Many objects were deleted!)");
            }
        } finally {
            if (stmt != null)
                stmt.close();
        }
    }


    public int countAll(Connection conn) throws SQLException {
        String sql = "SELECT count(*) FROM VIEW_ESTADO_INFRAC_COMP";
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

    public List searchMatching(Connection conn, Viewestadoinfraccomp valueObject) throws SQLException {
        List searchResults;

        boolean first = true;
        StringBuffer sql = new StringBuffer("SELECT * FROM VIEW_ESTADO_INFRAC_COMP WHERE 1=1 ");
        if (valueObject.getID_COMPARENDO() != 0) {
            if (first) {
                first = false;
            }
            sql.append("AND ID_COMPARENDO= ").append(valueObject.getID_COMPARENDO()).append(" ");
        }

        if (valueObject.getID_VEHICULOCOMP() != 0) {
            if (first) {
                first = false;
            }
            sql.append("AND ID_VEHICULOCOMP= ").append(valueObject.getID_VEHICULOCOMP()).append(" ");
        }

        if (valueObject.getID_INFRACTOR() != 0) {
            if (first) {
                first = false;
            }
            sql.append("AND ID_INFRACTOR= ").append(valueObject.getID_INFRACTOR()).append(" ");
        }

        if (valueObject.getNUMEROCOMPARENDO() != null && !valueObject.getNUMEROCOMPARENDO().equals("")) {
            if (first) {
                first = false;
            }
            sql.append("AND NUMEROCOMPARENDO= '").append(valueObject.getNUMEROCOMPARENDO()).append("' ");
        }

        if (valueObject.getFECHACOMPARENDO() != null && !valueObject.getFECHACOMPARENDO().equals("")) {
            if (first) {
                first = false;
            }
            sql.append("AND FECHACOMPARENDO= '").append(valueObject.getFECHACOMPARENDO()).append("' ");
        }

        if (valueObject.getHORACOMPARENDO() != null && !valueObject.getHORACOMPARENDO().equals("")) {
            if (first) {
                first = false;
            }
            sql.append("AND HORACOMPARENDO= '").append(valueObject.getHORACOMPARENDO()).append("' ");
        }

        if (valueObject.getPLACA() != null && !valueObject.getPLACA().equals("")) {
            if (first) {
                first = false;
            }
            sql.append("AND PLACA= '").append(valueObject.getPLACA()).append("' ");
        }

        if (valueObject.getID_INFRACCIONCOMPARENDO() != 0) {
            if (first) {
                first = false;
            }
            sql.append("AND ID_INFRACCIONCOMPARENDO= ").append(valueObject.getID_INFRACCIONCOMPARENDO()).append(" ");
        }

        if (valueObject.getID_INFRACCION() != 0) {
            if (first) {
                first = false;
            }
            sql.append("AND ID_INFRACCION= ").append(valueObject.getID_INFRACCION()).append(" ");
        }

        if (valueObject.getINFRACCION() != null && !valueObject.getINFRACCION().equals("")) {
            if (first) {
                first = false;
            }
            sql.append("AND INFRACCION= '").append(valueObject.getINFRACCION()).append("' ");
        }

        if (valueObject.getCOD_INFRACCION() != null && !valueObject.getCOD_INFRACCION().equals("")) {
            if (first) {
                first = false;
            }
            sql.append("AND COD_INFRACCION= '").append(valueObject.getCOD_INFRACCION()).append("' ");
        }

        if (valueObject.getNUEVO_CODIGO_INFRACCION() != null && !valueObject.getNUEVO_CODIGO_INFRACCION().equals("")) {
            if (first) {
                first = false;
            }
            sql.append("AND NUEVO_CODIGO_INFRACCION= '").append(valueObject.getNUEVO_CODIGO_INFRACCION()).append("' ");
        }

        if (valueObject.getNUM_SALARIOS_MINIMOS() != 0) {
            if (first) {
                first = false;
            }
            sql.append("AND NUM_SALARIOS_MINIMOS= ").append(valueObject.getNUM_SALARIOS_MINIMOS()).append(" ");
        }

        if (valueObject.getID_ESTADO_COMPARENDO() != 0) {
            if (first) {
                first = false;
            }
            sql.append("AND ID_ESTADO_COMPARENDO= ").append(valueObject.getID_ESTADO_COMPARENDO()).append(" ");
        }

        if (valueObject.getCOD_ESTADO_COMPARENDO() != null && !valueObject.getCOD_ESTADO_COMPARENDO().equals("")) {
            if (first) {
                first = false;
            }
            sql.append("AND COD_ESTADO_COMPARENDO= '").append(valueObject.getCOD_ESTADO_COMPARENDO()).append("' ");
        }

        if (valueObject.getESTADO_COMPARENDO() != null && !valueObject.getESTADO_COMPARENDO().equals("")) {
            if (first) {
                first = false;
            }
            sql.append("AND ESTADO_COMPARENDO= '").append(valueObject.getESTADO_COMPARENDO()).append("' ");
        }

        sql.append("ORDER BY ID_COMPARENDO ASC ");

        if (first)
            searchResults = new ArrayList();
        else
            searchResults = listQuery(conn, conn.prepareStatement(sql.toString()));

        return searchResults;
    }
    
    
  public List searchMatchingSql(Connection conn, int idInfractor) throws SQLException {
      List searchResults;

      boolean first = true;
      StringBuffer sql = new StringBuffer("SELECT *\n" + 
      "FROM VIEW_ESTADO_INFRAC_COMP\n" + 
      "WHERE VIEW_ESTADO_INFRAC_COMP.id_estado_comparendo = 4\n" + 
      "AND VIEW_ESTADO_INFRAC_COMP.id_comparendo NOT IN (SELECT id_comparendo\n" + 
      "FROM expedientecomparendo)\n" + 
      "AND ID_INFRACTOR = " + idInfractor + " ORDER BY FECHACOMPARENDO");
      
      searchResults = listQuery(conn, conn.prepareStatement(sql.toString()));

      return searchResults;
  }
    
    
    


    public List searchMatching(Connection conn, Viewestadoinfraccomp valueObject, int limiteInf,
                               int limiteSup) throws SQLException {
        List searchResults;

        boolean first = true;
        StringBuffer sql =
            new StringBuffer("SELECT * FROM (SELECT *, ROW_NUMBER() OVER (ORDER BY ID_COMPARENDO) AS RowNumber FROM VIEW_ESTADO_INFRAC_COMP WHERE 1=1 ");
        if (valueObject.getID_COMPARENDO() != 0) {
            if (first) {
                first = false;
            }
            sql.append("AND ID_COMPARENDO= ").append(valueObject.getID_COMPARENDO()).append(" ");
        }

        if (valueObject.getID_VEHICULOCOMP() != 0) {
            if (first) {
                first = false;
            }
            sql.append("AND ID_VEHICULOCOMP= ").append(valueObject.getID_VEHICULOCOMP()).append(" ");
        }

        if (valueObject.getID_INFRACTOR() != 0) {
            if (first) {
                first = false;
            }
            sql.append("AND ID_INFRACTOR= ").append(valueObject.getID_INFRACTOR()).append(" ");
        }

        if (valueObject.getNUMEROCOMPARENDO() != null && !valueObject.getNUMEROCOMPARENDO().equals("")) {
            if (first) {
                first = false;
            }
            sql.append("AND NUMEROCOMPARENDO= '").append(valueObject.getNUMEROCOMPARENDO()).append("' ");
        }

        if (valueObject.getFECHACOMPARENDO() != null && !valueObject.getFECHACOMPARENDO().equals("")) {
            if (first) {
                first = false;
            }
            sql.append("AND FECHACOMPARENDO= '").append(valueObject.getFECHACOMPARENDO()).append("' ");
        }

        if (valueObject.getHORACOMPARENDO() != null && !valueObject.getHORACOMPARENDO().equals("")) {
            if (first) {
                first = false;
            }
            sql.append("AND HORACOMPARENDO= '").append(valueObject.getHORACOMPARENDO()).append("' ");
        }

        if (valueObject.getPLACA() != null && !valueObject.getPLACA().equals("")) {
            if (first) {
                first = false;
            }
            sql.append("AND PLACA= '").append(valueObject.getPLACA()).append("' ");
        }

        if (valueObject.getID_INFRACCIONCOMPARENDO() != 0) {
            if (first) {
                first = false;
            }
            sql.append("AND ID_INFRACCIONCOMPARENDO= ").append(valueObject.getID_INFRACCIONCOMPARENDO()).append(" ");
        }

        if (valueObject.getID_INFRACCION() != 0) {
            if (first) {
                first = false;
            }
            sql.append("AND ID_INFRACCION= ").append(valueObject.getID_INFRACCION()).append(" ");
        }

        if (valueObject.getINFRACCION() != null && !valueObject.getINFRACCION().equals("")) {
            if (first) {
                first = false;
            }
            sql.append("AND INFRACCION= '").append(valueObject.getINFRACCION()).append("' ");
        }

        if (valueObject.getCOD_INFRACCION() != null && !valueObject.getCOD_INFRACCION().equals("")) {
            if (first) {
                first = false;
            }
            sql.append("AND COD_INFRACCION= '").append(valueObject.getCOD_INFRACCION()).append("' ");
        }

        if (valueObject.getNUEVO_CODIGO_INFRACCION() != null && !valueObject.getNUEVO_CODIGO_INFRACCION().equals("")) {
            if (first) {
                first = false;
            }
            sql.append("AND NUEVO_CODIGO_INFRACCION= '").append(valueObject.getNUEVO_CODIGO_INFRACCION()).append("' ");
        }

        if (valueObject.getNUM_SALARIOS_MINIMOS() != 0) {
            if (first) {
                first = false;
            }
            sql.append("AND NUM_SALARIOS_MINIMOS= ").append(valueObject.getNUM_SALARIOS_MINIMOS()).append(" ");
        }

        if (valueObject.getID_ESTADO_COMPARENDO() != 0) {
            if (first) {
                first = false;
            }
            sql.append("AND ID_ESTADO_COMPARENDO= ").append(valueObject.getID_ESTADO_COMPARENDO()).append(" ");
        }

        if (valueObject.getCOD_ESTADO_COMPARENDO() != null && !valueObject.getCOD_ESTADO_COMPARENDO().equals("")) {
            if (first) {
                first = false;
            }
            sql.append("AND COD_ESTADO_COMPARENDO= '").append(valueObject.getCOD_ESTADO_COMPARENDO()).append("' ");
        }

        if (valueObject.getESTADO_COMPARENDO() != null && !valueObject.getESTADO_COMPARENDO().equals("")) {
            if (first) {
                first = false;
            }
            sql.append("AND ESTADO_COMPARENDO= '").append(valueObject.getESTADO_COMPARENDO()).append("' ");
        }

        sql.append(") AS CONSULTA WHERE RowNumber >=" + limiteInf + " AND RowNumber <=" + limiteSup);

        if (first)
            searchResults = new ArrayList();
        else
            searchResults = listQuery(conn, conn.prepareStatement(sql.toString()));

        return searchResults;
    }


    public int countSearchMatching(Connection conn, Viewestadoinfraccomp valueObject) throws SQLException {
        boolean first = true;
        StringBuffer sql = new StringBuffer("SELECT COUNT(*) FROM VIEW_ESTADO_INFRAC_COMP WHERE 1=1 ");
        if (valueObject.getID_COMPARENDO() != 0) {
            if (first) {
                first = false;
            }
            sql.append("AND ID_COMPARENDO= ").append(valueObject.getID_COMPARENDO()).append(" ");
        }

        if (valueObject.getID_VEHICULOCOMP() != 0) {
            if (first) {
                first = false;
            }
            sql.append("AND ID_VEHICULOCOMP= ").append(valueObject.getID_VEHICULOCOMP()).append(" ");
        }

        if (valueObject.getID_INFRACTOR() != 0) {
            if (first) {
                first = false;
            }
            sql.append("AND ID_INFRACTOR= ").append(valueObject.getID_INFRACTOR()).append(" ");
        }

        if (valueObject.getNUMEROCOMPARENDO() != null && !valueObject.getNUMEROCOMPARENDO().equals("")) {
            if (first) {
                first = false;
            }
            sql.append("AND NUMEROCOMPARENDO= '").append(valueObject.getNUMEROCOMPARENDO()).append("' ");
        }

        if (valueObject.getFECHACOMPARENDO() != null && !valueObject.getFECHACOMPARENDO().equals("")) {
            if (first) {
                first = false;
            }
            sql.append("AND FECHACOMPARENDO= '").append(valueObject.getFECHACOMPARENDO()).append("' ");
        }

        if (valueObject.getHORACOMPARENDO() != null && !valueObject.getHORACOMPARENDO().equals("")) {
            if (first) {
                first = false;
            }
            sql.append("AND HORACOMPARENDO= '").append(valueObject.getHORACOMPARENDO()).append("' ");
        }

        if (valueObject.getPLACA() != null && !valueObject.getPLACA().equals("")) {
            if (first) {
                first = false;
            }
            sql.append("AND PLACA= '").append(valueObject.getPLACA()).append("' ");
        }

        if (valueObject.getID_INFRACCIONCOMPARENDO() != 0) {
            if (first) {
                first = false;
            }
            sql.append("AND ID_INFRACCIONCOMPARENDO= ").append(valueObject.getID_INFRACCIONCOMPARENDO()).append(" ");
        }

        if (valueObject.getID_INFRACCION() != 0) {
            if (first) {
                first = false;
            }
            sql.append("AND ID_INFRACCION= ").append(valueObject.getID_INFRACCION()).append(" ");
        }

        if (valueObject.getINFRACCION() != null && !valueObject.getINFRACCION().equals("")) {
            if (first) {
                first = false;
            }
            sql.append("AND INFRACCION= '").append(valueObject.getINFRACCION()).append("' ");
        }

        if (valueObject.getCOD_INFRACCION() != null && !valueObject.getCOD_INFRACCION().equals("")) {
            if (first) {
                first = false;
            }
            sql.append("AND COD_INFRACCION= '").append(valueObject.getCOD_INFRACCION()).append("' ");
        }

        if (valueObject.getNUEVO_CODIGO_INFRACCION() != null && !valueObject.getNUEVO_CODIGO_INFRACCION().equals("")) {
            if (first) {
                first = false;
            }
            sql.append("AND NUEVO_CODIGO_INFRACCION= '").append(valueObject.getNUEVO_CODIGO_INFRACCION()).append("' ");
        }

        if (valueObject.getNUM_SALARIOS_MINIMOS() != 0) {
            if (first) {
                first = false;
            }
            sql.append("AND NUM_SALARIOS_MINIMOS= ").append(valueObject.getNUM_SALARIOS_MINIMOS()).append(" ");
        }

        if (valueObject.getID_ESTADO_COMPARENDO() != 0) {
            if (first) {
                first = false;
            }
            sql.append("AND ID_ESTADO_COMPARENDO= ").append(valueObject.getID_ESTADO_COMPARENDO()).append(" ");
        }

        if (valueObject.getCOD_ESTADO_COMPARENDO() != null && !valueObject.getCOD_ESTADO_COMPARENDO().equals("")) {
            if (first) {
                first = false;
            }
            sql.append("AND COD_ESTADO_COMPARENDO= '").append(valueObject.getCOD_ESTADO_COMPARENDO()).append("' ");
        }

        if (valueObject.getESTADO_COMPARENDO() != null && !valueObject.getESTADO_COMPARENDO().equals("")) {
            if (first) {
                first = false;
            }
            sql.append("AND ESTADO_COMPARENDO= '").append(valueObject.getESTADO_COMPARENDO()).append("' ");
        }

        PreparedStatement stmt = null;
        ResultSet result = null;
        int allRows = 0;
        try {
            stmt = conn.prepareStatement(sql.toString());
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


    protected int databaseUpdate(Connection conn, PreparedStatement stmt) throws SQLException {
        int result = stmt.executeUpdate();
        return result;
    }


    protected void singleQuery(Connection conn, PreparedStatement stmt,
                               Viewestadoinfraccomp valueObject) throws SQLException {

        ResultSet result = null;
        try {
            result = stmt.executeQuery();
            if (result.next()) {

                valueObject.setID_COMPARENDO(result.getInt("ID_COMPARENDO"));
                valueObject.setID_VEHICULOCOMP(result.getInt("ID_VEHICULOCOMP"));
                valueObject.setID_INFRACTOR(result.getInt("ID_INFRACTOR"));
                valueObject.setNUMEROCOMPARENDO(result.getString("NUMEROCOMPARENDO"));
                valueObject.setFECHACOMPARENDO(result.getString("FECHACOMPARENDO"));
                valueObject.setHORACOMPARENDO(result.getString("HORACOMPARENDO"));
                valueObject.setPLACA(result.getString("PLACA"));
                valueObject.setID_INFRACCIONCOMPARENDO(result.getInt("ID_INFRACCIONCOMPARENDO"));
                valueObject.setID_INFRACCION(result.getInt("ID_INFRACCION"));
                valueObject.setINFRACCION(result.getString("INFRACCION"));
                valueObject.setCOD_INFRACCION(result.getString("COD_INFRACCION"));
                valueObject.setNUEVO_CODIGO_INFRACCION(result.getString("NUEVO_CODIGO_INFRACCION"));
                valueObject.setNUM_SALARIOS_MINIMOS(result.getDouble("NUM_SALARIOS_MINIMOS"));
                valueObject.setID_ESTADO_COMPARENDO(result.getInt("ID_ESTADO_COMPARENDO"));
                valueObject.setCOD_ESTADO_COMPARENDO(result.getString("COD_ESTADO_COMPARENDO"));
                valueObject.setESTADO_COMPARENDO(result.getString("ESTADO_COMPARENDO"));

            } else {
                throw new SQLException();
            }
        } finally {
            if (result != null)
                result.close();
            if (stmt != null)
                stmt.close();
        }
    }


    protected List listQuery(Connection conn, PreparedStatement stmt) throws SQLException {

        ArrayList searchResults = new ArrayList();
        ResultSet result = null;
        try {
            result = stmt.executeQuery();
            while (result.next()) {
                Viewestadoinfraccomp temp = createValueObject();

                temp.setID_COMPARENDO(result.getInt("ID_COMPARENDO"));
                temp.setID_VEHICULOCOMP(result.getInt("ID_VEHICULOCOMP"));
                temp.setID_INFRACTOR(result.getInt("ID_INFRACTOR"));
                temp.setNUMEROCOMPARENDO(result.getString("NUMEROCOMPARENDO"));
                temp.setFECHACOMPARENDO(result.getString("FECHACOMPARENDO"));
                temp.setHORACOMPARENDO(result.getString("HORACOMPARENDO"));
                temp.setPLACA(result.getString("PLACA"));
                temp.setID_INFRACCIONCOMPARENDO(result.getInt("ID_INFRACCIONCOMPARENDO"));
                temp.setID_INFRACCION(result.getInt("ID_INFRACCION"));
                temp.setINFRACCION(result.getString("INFRACCION"));
                temp.setCOD_INFRACCION(result.getString("COD_INFRACCION"));
                temp.setNUEVO_CODIGO_INFRACCION(result.getString("NUEVO_CODIGO_INFRACCION"));
                temp.setNUM_SALARIOS_MINIMOS(result.getDouble("NUM_SALARIOS_MINIMOS"));
                temp.setID_ESTADO_COMPARENDO(result.getInt("ID_ESTADO_COMPARENDO"));
                temp.setCOD_ESTADO_COMPARENDO(result.getString("COD_ESTADO_COMPARENDO"));
                temp.setESTADO_COMPARENDO(result.getString("ESTADO_COMPARENDO"));
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
