package auxiliary;
import static epsilon.Panel.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/** Database management. @author https://github.com/bufferum7011 */

public class Exec_sql {

    public Connection get_conn() {
        try { return DriverManager.getConnection(panel.mysql_server, panel.mysql_user, panel.mysql_password); }
        catch(Exception e) { print.error("[SQL] - " + e); return null; }
    }

    public Statement get_statement() {
        try { return sql.get_conn().createStatement(); }
        catch(Exception e) { print.error("[get_statement] - " + e); return null; }
    }

    /** Sql_callback. Table data as an array. */
    public ResultSet sql_callback(String sql_query) {
        try { print.way("[Sql_callback]"); return sql.get_statement().executeQuery(sql_query); }
        catch(Exception e) { print.error("[Sql_callback] - " + e); return null; }
    }

    /** Sql_update. To execute sql queries without return. */
    public void sql_update(String sql_query) {
        try { sql.get_statement().executeUpdate(sql_query); print.way("[Sql_update]"); }
        catch(Exception e) { print.error("[Sql_update] - " + e); }
    }

}