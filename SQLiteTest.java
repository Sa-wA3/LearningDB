import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLiteTest {

    public static void main(String[] args) throws SQLException {
        String dbname = "reservation.db"; // 利用するデータベースファイル
        Connection conn = null; 
        Statement stmt = null;
        try {
            Class.forName("org.sqlite.JDBC"); 
            conn = DriverManager.getConnection("jdbc:sqlite:" + dbname);
            System.out.println(dbname + "への接続成功");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    static void printDB() {

    }

}