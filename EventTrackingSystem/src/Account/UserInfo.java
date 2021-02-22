/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 *
author:Veli Karagül

*/
package Account;




import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import java.io.PrintWriter;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author velik
 */
public class UserInfo {
  private static ArrayList<Account> myAdmin = new ArrayList<Account>();
  private  static ArrayList <Participant> myparticipants=new ArrayList<Participant>();
  private  static ArrayList <Participant> myusers=new ArrayList<Participant>();


  
 public static ArrayList<Participant> getMyParticipants() {
        return myparticipants;
    }

    public static ArrayList<Participant> getMyusers() {
        return myusers;
    }

    public static void setMyparticipants(ArrayList<Participant> myparticipants) {
        UserInfo.myparticipants = myparticipants;
    }

    public static void setMyusers(ArrayList<Participant> myusers) {
        UserInfo.myusers = myusers;
    }

   


    public static ArrayList<Account> getMyAdmin() {
        return myAdmin;
    }

    public static void setMyAdmin(ArrayList<Account> myAdmin) {
        UserInfo.myAdmin = myAdmin;
    }
      
  
    
    
    public static void addAdmin(Account eAdmin){
    
    myAdmin.add(eAdmin);
  
    }  
   
    
    public static boolean controlAdmin(String username , String password){ //check pass and username for admin
         
        
            for (int i = 0; i <myAdmin.size(); i++) {
            
                Account m = myAdmin.get(i);
            if(m.findAdmin(username, password)){
                 return true ;
        }
         
        }
        return false ;
    }
    
    
    public static boolean control_loginUser(String username,String password)//check pass and username for user
    {
        for (int i = 0; i < myusers.size(); i++) {
            Account z=myusers.get(i);
            if(z.findUser(username,password))
            {
                return true;
            }     
        }
    
    return false;
    }
    
    public static boolean control_loginParticipant(String username,String  pass)
    {
        for (int i = 0; i < myparticipants.size(); i++) {
           
            if(myparticipants.get(i).username.equals(username) && myparticipants.get(i).password.equals(pass))
                return true;
        }
    
    
    return false;
    }
    
   
    public static void addUser(Participant U)
    {
        myusers.add(U); 
        
    }
    
    public static void removeUser(Participant U){
        
        myusers.remove(U);
    }
    
    
    public static String Display()
    {
        String output="";
        
        for (int i = 0; i < myusers.size(); i++) {
            output+=myusers.get(i).toString();
            
        }
    return output;
    
    }
    
    public static boolean delete(int id)
    {
        for (int i = 0; i < myusers.size(); i++) {
            if(myusers.get(i).getAccount_id() == id)
            {
                myusers.remove(i);
                return true;
            }
            
        }
        return false;
        
    }
    
    public static Account search(int id)
    {
        for (int i = 0; i <myusers.size() ; i++) {
            if(myusers.get(i).getAccount_id() == id)
            return myusers.get(i);
        }
    
    return null;
    }
    
  
   public static boolean  controlUserName(String username){ //check if someone has same username 
       
       for (int i = 0; i <myusers.size()-1; i++) {
          
           Account m = myusers.get(i);
           if(m.findUser(username)){
               return true ;
           }
       }
       return false ;
   }
   
   
 
    public static boolean isNumeric(String str) { 
  try {  
    Integer.parseInt(str);  
    return true;
  } catch(NumberFormatException e){  
    return false;  
  }  
}
    
    
    public static void readFıleAdmin()
    {
        try (Scanner input =new Scanner(new FileReader("admin.txt")))
        {
     
            while(input.hasNextLine())
            {
                String admin=input.nextLine(); 
                String [] arr=admin.split(",");
               
                
                Admin admin1=new Admin(arr[0],arr[1],arr[2], arr[3],arr[4], arr[5], arr[6],arr[7]);
                myAdmin.add(admin1);
               
                  
            }
            input.close();
        } 
        catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null,"File could not found !","File ",JOptionPane.ERROR_MESSAGE);
       }
    
        
    }
    
     public static void readFıleUser()
    {
        try (Scanner input =new Scanner(new FileReader("users.txt")))
        {
     
            while(input.hasNextLine())
            {
                String admin=input.nextLine(); 
                String [] arr=admin.split(",");
               
                
                Participant participant1=new Participant(arr[0],arr[1],arr[2], arr[3],arr[4], arr[5], arr[6],arr[7]);
                myusers.add(participant1);
               
                  
            }
            input.close();
        } 
        catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null,"File could not found !","File ",JOptionPane.ERROR_MESSAGE);
       }
    
        
    }
     
     
     public static void readFıleParticipant()
    {
        try (Scanner input =new Scanner(new FileReader("participant.txt")))
        {
     
            while(input.hasNextLine())
            {
                String admin=input.nextLine();
            
                String [] arr=admin.split(",");
               
                
                Participant participant1=new Participant(arr[0],arr[1],arr[2], arr[3],arr[4], arr[5], arr[6],arr[7]);
               
                myparticipants.add(participant1);
               
                  
            }
            input.close();
        } 
        catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null,"File could not found !","File ",JOptionPane.ERROR_MESSAGE);
       }
    }
        
  
      
            
     
     
    public static void writeToParticipant(String firstname,String surname,String username,String pass,String mail,String age,String city,String gender)
    {
        FileWriter writer=null;
            try{
                writer=new FileWriter("participant.txt",true);
            
               writer.write(username+","+pass+","+firstname+","+surname+","+city+","+gender+","+mail+","+age+"\n");
               writer.close();
            
            } catch (IOException ex) {
            JOptionPane.showMessageDialog(null,"File could not opened !","File ",JOptionPane.ERROR_MESSAGE);
       }
        finally{
            if(writer!=null)
                try {
                    writer.close();
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null,"File could not closed !","File ",JOptionPane.ERROR_MESSAGE);
            }           
            }
 
    }
   
     public static void writeToFileAdmin(Account eAccount){
         FileWriter writer = null ;
         
      try {
          writer = new FileWriter("admin.txt",true);
          
          writer.write(eAccount.toString()+"\n");
          
          
      } catch (IOException ex) {
          Logger.getLogger(UserInfo.class.getName()).log(Level.SEVERE, null, ex);
      }
         
     }
    
    public static void writeUserToUser()
    {
        FileWriter writer=null;
        String str="";
      
            try{
                writer=new FileWriter("users.txt",true);
                
            for (int i = 0; i <myparticipants.size(); i++) {
              str+=myparticipants.get(i).dispToString();
          }
             
            writer.write(str);
            writer.close();
            } catch (IOException ex) {
            JOptionPane.showMessageDialog(null,"File could not opened !","File ",JOptionPane.ERROR_MESSAGE);
       }
    finally{
            if(writer!=null)
                try {
                    writer.close();
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null,"File could not closed !","File ",JOptionPane.ERROR_MESSAGE);
            }           
            }
 
    }

    public static void DeleteContent()
    {
        PrintWriter writer=null;
      try {
          writer = new PrintWriter("participant.txt");
           writer.print("");
         writer.close();
      } catch (FileNotFoundException ex) {
          JOptionPane.showMessageDialog(null,"File could not closed !","File ",JOptionPane.ERROR_MESSAGE);
      }
       
    
    
    }
    
    
    public static void AcceptRequest ()
    {
        
        writeUserToUser();
        for (int i = 0; i < myparticipants.size(); i++) {
            myusers.add(myparticipants.get(i));
            
            
        }
    
    myparticipants.removeAll(myparticipants);//array is empty !
    
    
    DeleteContent();//participant.txt is empty
        
    
    }
    
    
    
    public static void writeToEvent (int event_id,String event_name, String location,Calendar date)
    {
        FileWriter writer=null;
            try{
                writer=new FileWriter("event.txt",true);
            
               writer.write(event_id+","+event_name+","+location+","+Event.convertDate(date)+"\n");
                
            
            } catch (IOException ex) {
            JOptionPane.showMessageDialog(null,"File could not opened !","File ",JOptionPane.ERROR_MESSAGE);
       }
    finally{
            if(writer!=null)
                try {
                    writer.close();
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null,"File could not closed !","File ",JOptionPane.ERROR_MESSAGE);
            }           
            }
 
    }
   
 
    public static Calendar StringtoCalender(String str_date) throws ParseException
    {
        DateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");
        Date date = (Date)formatter.parse(str_date); 

 
        Calendar cal=Calendar.getInstance();
        cal.setTime(date);

 
         return cal;
 
 }  
    
     public static void readevents() throws ParseException
    {
        try (Scanner input =new Scanner(new FileReader("event.txt")))
        {
     
            while(input.hasNextLine())
            {
                String admin=input.nextLine(); 
                String [] arr=admin.split(",");
              
            String date_event=arr[3];
            String event_id=arr[0];
            Event e=new Event(arr[1],arr[2],StringtoCalender(date_event));
            Admin.getMyEvent().add(e); 
               
                  
            }
            
        } 
        catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null,"File could not found !","File ",JOptionPane.ERROR_MESSAGE);
       } 
       
      }
     
     
     public static void writeToEventforUpdate ()
    {
        FileWriter writer=null;
            try{
                writer=new FileWriter("event.txt");
            String str="";
                for (int i = 0; i < Admin.getMyEvent().size(); i++) {
                    str+=Admin.getMyEvent().get(i).toString();
                }
                writer.write(str);
            
            } catch (IOException ex) {
            JOptionPane.showMessageDialog(null,"File could not opened !","File ",JOptionPane.ERROR_MESSAGE);
       }
    finally{
            if(writer!=null)
                try {
                    writer.close();
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null,"File could not closed !","File ",JOptionPane.ERROR_MESSAGE);
            }           
            }
 
    }
     
     
     public static void writeUserToUserforUpdate()
    {
        FileWriter writer=null;
        String str="";
      
            try{
                writer=new FileWriter("users.txt");
                
            for (int i = 0; i <myusers.size(); i++) {
              str+=myusers.get(i).dispToString();
          }
             
            writer.write(str);
            writer.close();
            } catch (IOException ex) {
            JOptionPane.showMessageDialog(null,"File could not opened !","File ",JOptionPane.ERROR_MESSAGE);
       }
    finally{
            if(writer!=null)
                try {
                    writer.close();
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null,"File could not closed !","File ",JOptionPane.ERROR_MESSAGE);
            }           
            }
 
    }
     
    public static void joinedEventWriter (String username,int event_id,String event_name,String eventloc,String eventDate)
    {
        FileWriter writer=null;
        UserPanel a=new UserPanel();
        
        
            try{
                writer=new FileWriter("joinedEvent.txt",true);
            
          
              writer.write(username+","+event_id+","+event_name+","+eventloc+","+eventDate+"\n");
               
           
            
            } catch (IOException ex) {
            JOptionPane.showMessageDialog(null,"File could not opened !","File ",JOptionPane.ERROR_MESSAGE);
       }
    finally{
            if(writer!=null)
                try {
                    writer.close();
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null,"File could not closed !","File ",JOptionPane.ERROR_MESSAGE);
            }           
            }
 
    }
  
   
   
    
     
     
     
     
     
     
   
        
    }
   
    
    
    
    

    
    

