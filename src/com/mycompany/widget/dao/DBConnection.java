package com.mycompany.widget.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection 
{
	Connection c = null;
	
	public Connection getConnection()
	{
    try 
    {
       Class.forName("org.postgresql.Driver");
       c = DriverManager
          .getConnection("jdbc:postgresql://localhost:5432/postgres",
          "postgres", "G00gle@01");
    } 
    catch (Exception e) 
    {
       e.printStackTrace();
       System.err.println(e.getClass().getName()+": "+e.getMessage());
       System.exit(0);
    }
    return c;
	}
    

}
