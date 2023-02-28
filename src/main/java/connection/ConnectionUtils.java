package connection;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConnectionUtils {
    private final static String USER_NAME = "ulka";
    private final static String USER_PASSWORD = "123456";
    private final static String URL = "jdbc:mysql://localhost:3306/shop_magazines?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    private static final Logger LOGGER = Logger.getLogger(ConnectionUtils.class);

    public static Connection openConnection() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
//    try{
//            DOMConfigurator.configure("loggerConfig.xml");
//            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
//            System.out.println("Connection successfull!");
//        }
//        catch(Exception ex) {
//            System.out.println("Connection failed...");
//            LOGGER.error(ex);
//        }
//        return DriverManager.getConnection (URL, USER_NAME, USER_PASSWORD);
//    }
        try {
            DOMConfigurator.configure("loggerConfig.xml");
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
        } catch (Exception ex) {
            System.out.println("Connection failed...");
            LOGGER.error(ex);
        }
        return DriverManager.getConnection(URL, USER_NAME, USER_PASSWORD);
    }
}
