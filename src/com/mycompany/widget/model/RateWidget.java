package com.mycompany.widget.model;

import java.io.Serializable;  
import javax.xml.bind.annotation.XmlElement; 
import javax.xml.bind.annotation.XmlRootElement; 
@XmlRootElement(name = "rate-widget") 

public class RateWidget implements Serializable {  
   private static final long serialVersionUID = 1L; 
   private int wid; 
   private int uid;
   private int wrating;
   private String message;
     
   public RateWidget(){} 
    
   public RateWidget(int wid, int uid, int wrating)
   {  
    this.wid = wid; 
    this.uid = uid;
    this.wrating = wrating;
    this.message = "Object Created";
   }
   
   public RateWidget(int wid, int uid, int wrating, String msg)
   {  
      this.wid = wid; 
      this.uid = uid;
      this.wrating = wrating;
      this.message = msg;
    }
   
   public int getWid() 
   { 
      return wid; 
   }  
   @XmlElement 
   public void setWid(int wid) 
   { 
      this.wid = wid; 
   } 
   
   public int getUid() 
   { 
      return uid; 
   } 
   
   @XmlElement
   public void setUid(int uid) 
   { 
      this.uid = uid; 
   }
   
   public int getWrating() 
   { 
	  return wrating; 
   }
   
	@XmlElement 
	public void setWrating(int wrating) 
	{ 
	  this.wrating = wrating; 
	}
	   
	   public String getMessage() {
			return message;
		}
	   @XmlElement 
		public void setMessage(String message) {
			this.message = message;
		}
} 