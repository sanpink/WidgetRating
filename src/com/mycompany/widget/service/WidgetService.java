package com.mycompany.widget.service;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces; 
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.codehaus.jackson.map.ObjectMapper;
import com.mycompany.widget.model.RateWidget;
import com.mycompany.widget.dao.WidgetDAO;
import com.mycompany.widget.model.AvgRating;

@Path("/WidgetService") 

public class WidgetService 
{  
  
   @GET 
   @Path("/widgetavgrating/{varWid}") 
   @Produces(MediaType.APPLICATION_XML) 
   public List<AvgRating> getAvgRating(@PathParam("varWid") int wid) throws SQLException
   {
	  WidgetDAO widDao = new WidgetDAO();  
      return widDao.getWidgetAvgRating(wid); 
   }
   
	@POST
	@Path("/widgetRate") 
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_XML)
	public List<RateWidget> RateWidget(String incomingData) throws Exception
   	{
		WidgetDAO dao = new WidgetDAO();
		List<RateWidget> returnList = new ArrayList<RateWidget>();
		try 
		{
			System.out.println("incomingData: " + incomingData);
			ObjectMapper mapper = new ObjectMapper();  
			RateWidget wrate = (com.mycompany.widget.model.RateWidget) mapper.readValue(incomingData, com.mycompany.widget.model.RateWidget.class);
			returnList = dao.saveWidgetRating(wrate.getUid(), wrate.getWid(), wrate.getWrating());
		}
		catch (Exception e) 
		{
				e.printStackTrace();
		}
		return returnList;
		}
	
	@POST
	@Path("/widgetRate")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public List<RateWidget> RateWidget(@FormParam("uid") int uid,
                                @FormParam("wid") int wid,
                                @FormParam("wrating") int wrating) throws SQLException 
	{
		WidgetDAO dao = new WidgetDAO();
		List<RateWidget> returnList = new ArrayList<RateWidget>();
		returnList = dao.saveWidgetRating(uid, wid, wrating);
		return returnList;
    }
}
   	

