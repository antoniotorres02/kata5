package kata5;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MailTableApp {

    private static String database = "jdbc:sqlite:kata5P1.db";

    private Connection connect() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(database);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return conn;
    }

    public void insert(String mail) {
        String sql = "INSERT INTO direcc_email(Mail) VALUES(?)";
        try ( Connection conn = this.connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, mail);
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
