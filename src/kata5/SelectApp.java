package kata5;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

public class SelectApp {
    
    private static String ruta = "jdbc:sqlite:kata5P1.db"; 
    
    private Connection connect() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(ruta);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return conn;
    }
    
    public void selectAll() {
        try (Connection conn = this.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM PEOPLE")) {
        
            while (rs.next()){
                System.out.println(rs.getInt("ID") + "\t" +
                                   rs.getString("NAME").trim() + "\t" +
                                   rs.getString("APELLIDOS").trim() + "\t" +
                                   rs.getString("DEPARTAMENTO").trim() + "\t" );
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
             
    }

}
