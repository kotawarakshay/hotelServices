package com.cg.hotelservices.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBConnection
{
		public static Connection getConnection() throws SQLException, ClassNotFoundException, IOException
		{
			
			FileInputStream fis = new FileInputStream("resources/DB.properties");
			Properties prop = new Properties();
			prop.load(fis);
			Connection c=null;
			String u= prop.getProperty("url");
			String user = prop.getProperty("user");
			String pass=prop.getProperty("pwd");
			String driver = prop.getProperty("driver");
			Class.forName(driver);
			c = DriverManager.getConnection(u,user,pass);
			return c;
		}

}
