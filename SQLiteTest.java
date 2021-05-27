import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SQLiteTest {

    public static void main(String[] args) throws SQLException {
        String dbname = "reservation.db"; // 利用するデータベースファイル
        Connection conn = null; 
        Statement stmt = null;
        try {
            Class.forName("org.sqlite.JDBC"); 
            conn = DriverManager.getConnection("jdbc:sqlite:" + dbname);
            System.out.println("Connection to " + dbname + " is succeeded.");

            stmt = conn.createStatement();
            // stmt.executeUpdate("CREATE TABLE reservation (student_id INTEGER NOT NULL, name VARCHAR(20) NOT NULL, grade INTEGER NOT NULL, PRIMARY KEY (student_id))");
            // System.out.println("Create reservation table.");

            // stmt.executeUpdate("INSERT INTO reservation VALUES(1, 'Sawa', 1)");
            // stmt.executeUpdate("INSERT INTO reservation VALUES(2, 'Ken', 2)");
            // stmt.executeUpdate("INSERT INTO reservation VALUES(3, 'Kazu', 1)");
            // stmt.executeUpdate("INSERT INTO reservation VALUES(4, 'Kei', 2)");
            // System.out.println("Completed data insertation.");

            ResultSet rs = stmt
                    .executeQuery("SELECT * FROM reservation WHERE student_id = 1");
            // System.out.println("選択");
            System.out.println("Show reservation table.");
            while (rs.next()) {
                int student_id = rs.getInt("student_id");
                String name = rs.getString("name");
                int grade = rs.getInt("grade");
                // System.out.println(student_id + "\t" + name + "\t" + price);
                String greeting = "会員番号" + student_id + "、" + grade + "年の" + name + "さんですね。";
                System.out.println(greeting);
                System.out.println("今日も勉強頑張っていきましょう！");
            }
            rs.close();

            // stmt.executeUpdate("DROP TABLE products");
            // System.out.println("テーブル削除");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}