import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DaUtil {
    public static Connection con = null;
    public static Connection getConnection(){

        try {
            File f= new File("C:\\Users\\usha\\IdeaProjects\\BankManagement\\src\\main\\resources\\da.properties");
            FileInputStream fis = new FileInputStream(f);
            Properties p = new Properties();
            p.load(fis);
            //Class.forName(p.getProperty("driver"));
            con = DriverManager.getConnection(p.getProperty("url"),p.getProperty("user"),p.getProperty("password"));
        } catch (IOException e) {
            e.printStackTrace();
        } /*catch (ClassNotFoundException e) {
            e.printStackTrace();
        } */
        catch (SQLException e) {
            e.printStackTrace();
        }


        return con;
    }
}
