/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Account;

import java.text.SimpleDateFormat;
import java.util.Calendar;


public class Event {
  
    private int event_id=99+Admin.getMyEvent().size();
    private String event_name,location;
    private Calendar date;
   
    public Event(String event_name, String location, Calendar date) {
        this.event_name = event_name;
        this.location = location;
        this.date = date;
        event_id++;
    }  
  

    @Override
    public String toString() {
        return   event_id +","+ event_name +"," + location +"," +convertDate(date)+"\n" ;
    }

    public int getEvent_id() {
        return event_id;
    }

    public String getEvent_name() {
        return event_name;
    }

    public String getLocation() {
        return location;
    }

    public Calendar getDate() {
        return date;
    }
    
    public  String getCalendartoString()
    {   SimpleDateFormat format1 = new SimpleDateFormat("dd.MM.yyyy");
        String formatted = format1.format(date.getTime());
        
        return formatted;

            }
    public void setEvent_id(int event_id) {
        this.event_id = event_id;
    }

   
  


    public void setEvent_name(String event_name) {
        this.event_name = event_name;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setDate(Calendar date) {
        this.date = date;
    }

   
    public static String convertDate(Calendar date)
    {
         
     SimpleDateFormat format1 = new SimpleDateFormat("dd.MM.yyyy");
     String formatted = format1.format(date.getTime());
    
     return formatted;
    }

    
    
    
}
