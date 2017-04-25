package com.mycompany.widget.dao;

import java.io.File; 
import java.io.FileInputStream; 
import java.io.FileNotFoundException;  
import java.io.FileOutputStream; 
import java.io.IOException; 
import java.io.ObjectInputStream; 
import java.io.ObjectOutputStream;
import java.nio.charset.Charset;
import java.sql.*;
import java.util.ArrayList; 
import java.util.List;

import com.mycompany.widget.dao.*;
import com.mycompany.widget.model.AvgRating;
import com.mycompany.widget.model.RateWidget;

public class WidgetDAO { 
      
   public List<RateWidget> saveWidgetRating(int uid, int wid, int rating) throws SQLException
   { 
	   DBConnection db = new DBConnection();
	   Connection conn= null;
	   PreparedStatement query = null;
	   List<RateWidget> returnList = new ArrayList<RateWidget>();
	   int code;
      try 
      { 
    	  conn = db.getConnection();
		  query = conn.prepareStatement("INSERT INTO public.rating(uid, wid, rating) VALUES (?,?,?);");
		  query.setInt(1, uid);
		  query.setInt(2, wid);
		  query.setInt(3, rating);
		  query.executeUpdate();
		  code=200;
      } catch (SQLException e) 
      { 
         e.printStackTrace();
         code=500;
      } 
      if(code==200)
      {
    	  RateWidget robj = new RateWidget();
    	  robj.setUid(uid);
    	  robj.setWid(wid);
    	  robj.setWrating(rating);
    	  robj.setMessage("Widget rated Successfully");
    	  returnList.add(robj);
      }
      else
      {
    	  RateWidget robj = new RateWidget();
    	  robj.setUid(uid);
    	  robj.setWid(wid);
    	  robj.setWrating(rating);
    	  robj.setMessage("There was a problem rating the widget");
    	  returnList.add(robj); 
      }
      return returnList;
   }
 
   public List<AvgRating> getWidgetAvgRating(int wid) throws SQLException
   { 
	   DBConnection db = new DBConnection();
	   AvgRating wavg = new AvgRating();
	   List<AvgRating> returnList = new ArrayList<AvgRating>();
	   Connection conn= null;
	   PreparedStatement query = null;
	   String myString = null;
	   String returnString = null;
	   try{
		   conn = db.getConnection();
		   query = conn.prepareStatement("SELECT trunc(avg(rating),2) as average from rating where wid="+wid+";");
		   ResultSet rs = query.executeQuery();
		   while(rs.next())
		   {
			   wavg.setWavgrating(Float.parseFloat((rs.getString("average"))));
			   wavg.setWid(wid);
		   }
		   returnList.add(wavg);
		   }
	   catch(Exception e)
	   {
		   e.printStackTrace();
	   }
	   finally
	   {
		   query.close();
	   }
	   return returnList;
   }
}