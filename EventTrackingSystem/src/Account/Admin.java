/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Account;



import java.util.ArrayList;
import java.util.Calendar;



/**
 *
 * @author velik
 */
public class Admin extends Account implements  IUser{
    
    private static final ArrayList <Event> myEvent=new ArrayList <Event> ();
    
    private static int total_admin=0;
    
    private static Users user;

    public Admin( String username, String password,String user_name, String user_sur, String gender, String city, String email, String user_age) {
        super( username, password);
       this.user=new Users(user_name, user_sur, gender, city, email, user_age);
        total_admin++;
    }

    public static Users getUser() {
        return user;
    }

    
    
  
    public static ArrayList<Event> getMyEvent() {
        return myEvent;
    }


    public static int getTotal_admin() {
        return total_admin;
    }

   
    
        public static String Display()
    {
        String output="";
        for (int i = 0; i < myEvent.size(); i++) {
            output+=myEvent.get(i).toString();
            
        }
    
    return output;
    
    }
    
    public static String DisplayIndex(int index)
    {
        return myEvent.get(index).toString();
        
    
    }
        
        
    public static void addEvent(Event e)
    {
        myEvent.add(e);
    }
    
    public static boolean removeEvent(int id)
    {
        for (int i = 0; i < myEvent.size(); i++) {
            if(myEvent.get(i).getEvent_id()==id)
            {
             myEvent.remove(i);
            return true;
            }
            }
        return false;
    
    }
    
    public static int searchfor (String name)//searching for event  
    {
        for (int i = 0; i < myEvent.size(); i++) {
            if(myEvent.get(i).getEvent_name().equalsIgnoreCase(name))
            return i;
        }
    
    return -1;
    
    }
   
    
  
    
    public static boolean control(int id)//events id control
    {
        for (int i = 0; i < myEvent.size(); i++) {
            if(myEvent.get(i).getEvent_id()==id )
            return true;
        
        }
    return false;
    
    }
    
   
    public String dispToString(){
        
        return  user.dispToStringUsers();
    }
    
    public static boolean updateCity(String city,int id)
    {
        
        for (int j = 0; j < myEvent.size(); j++) {
            if(myEvent.get(j).getEvent_id()==id)
            { myEvent.get(j).setLocation(city);
            return true;
            }            
        
            }
    
    return false;
    }   
    
    public  static  boolean updateDate(Calendar date,int id)
    {
        for (int j = 0; j < myEvent.size(); j++) {
            if(myEvent.get(j).getEvent_id()==id)
            {
                myEvent.get(j).setDate(date);
                return true;
            
            }
        }
    
    return false;
    
    
    }        
            
            
   
    
    
    
  
    
 
    
}