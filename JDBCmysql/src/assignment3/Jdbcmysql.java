package assignment3;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Jdbcmysql{

    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "Mahadev@3");
                 Statement stmt = con.createStatement();
                 ResultSet rs = stmt.executeQuery("SELECT * FROM Student")) {

                System.out.println("ID\tName\t\tAge\tCourse\t\tMarks");
                System.out.println("-----------------------------------------------------------");

                while (rs.next()) {
                    int id = rs.getInt("id");
                    String name = rs.getString("name");
                    int age = rs.getInt("age");
                    String course = rs.getString("course");
                    double marks = rs.getDouble("marks");

                    System.out.println(id + "\t" + name + "\t\t" + age + "\t" + course + "\t\t" + marks);
                }

            } catch (SQLException e) {
                System.out.println("SQL error: " + e.getMessage());
            }

        } catch (ClassNotFoundException e) {
            System.out.println("JDBC Driver not found: " + e.getMessage());
        }
    }
}