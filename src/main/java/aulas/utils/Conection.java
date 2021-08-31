package aulas.utils;


import java.sql.*;

public class Conection {

	public Conection (){

	}

    public static  Connection connection () {
		
		
		try {
	
			// create a mysql database connection
			String myDriver = "org.mariadb.jdbc.Driver";
			String myUrl = "jdbc:mariadb://localhost/api_spring_java";
			Class.forName(myDriver);
			Connection c = DriverManager.getConnection(myUrl, "root", "");
			return c;
	   }  catch (Exception e)
	   {
			System.err.println("Got an exception!");
			System.err.println(e.getMessage());
	   }
	   return null ;
	   
	 

	}
}