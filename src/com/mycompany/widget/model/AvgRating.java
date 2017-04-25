package com.mycompany.widget.model;

import java.io.Serializable;  
import javax.xml.bind.annotation.XmlElement; 
import javax.xml.bind.annotation.XmlRootElement; 
@XmlRootElement(name = "average-rating") 

public class AvgRating implements Serializable {  
   private static final long serialVersionUID = 1L; 
   private int wid; 
   private Float wavgrating; 
   
   public AvgRating(){} 
    
   public AvgRating(int wid, Float wavgrating){  
      this.wid = wid; 
      this.wavgrating = wavgrating; 
      }  
   public int getWid() { 
      return wid; 
   }  
   @XmlElement 
   public void setWid(int wid) { 
      this.wid = wid; 
   } 
   public Float getWavgrating() { 
      return wavgrating; 
   } 
   @XmlElement
   public void setWavgrating(Float wavgrating) { 
      this.wavgrating = wavgrating; 
   } 
} 