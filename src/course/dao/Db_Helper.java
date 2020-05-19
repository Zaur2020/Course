
package course.dao;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Locale;
import java.util.Properties;

public class Db_Helper {
	public static Connection getconnection() throws Exception {

		Locale.setDefault(Locale.ENGLISH);
		Properties p = new Properties();
		p.load(new FileReader("config.properties"));
		Class.forName(p.getProperty("db.driver"));
		Connection con = DriverManager.getConnection(p.getProperty("db.url"), p.getProperty("db.username"),
				p.getProperty("db.password"));

		return con;

	}

}
