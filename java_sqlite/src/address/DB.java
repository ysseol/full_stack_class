package address;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class DB {
	public static Connection dbConn() {
		
		Connection conn = null;
		
		try {
			
			FileInputStream fis = new FileInputStream("c:/work/sqlite.prop");
			Properties prop = new Properties();
			prop.load(fis);
			String url = prop.getProperty("url");
			conn = DriverManager.getConnection(url);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
}
