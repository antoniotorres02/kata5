package kata5;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Kata5 {

    public static void main(String[] args) {
        String url = "jdbc:sqlite:kata5P1.db";
        String sql = "CREATE TABLE IF NOT EXISTS direcc_email (\n"
                    + " Id integer PRIMARY KEY AUTOINCREMENT,\n"
                    + " Mail text NOT NULL);";
        
        try (Connection conn = DriverManager.getConnection(url);
            Statement stmt = conn.createStatement()) {
            // Se crea la nueva tabla
            stmt.execute(sql);
            System.out.println("Tabla creada");
            sql = "SELECT * FROM sqlite_master WHERE type = \"table\"";
            ResultSet resultSet = stmt.executeQuery(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        printTables();
    }
    
    public static String printTables() {
        String url = "jdbc:sqlite:kata5P1.db";
        
        try (Connection conn = DriverManager.getConnection(url)) {
            ResultSet rs = conn.getMetaData().getTables(null, null,
                                                       null, null);
            System.out.println("\nTablas creadas:"
                    + "\n----------");
            while (rs.next()) System.out.println(rs.getString("TABLE_NAME"));
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
        return null;
    }
}
