/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Account;



/**
 *
 * @author velik
 */
public class Users {
    
    private  String user_name,user_sur,gender,city,email,user_age;
    

    public Users(String user_name, String user_sur, String gender, String city, String email, String user_age) {
        this.user_name = user_name;
        this.user_sur = user_sur;
        this.gender = gender;
        this.city = city;
        this.email = email;
        this.user_age = user_age;
    }

   
    @Override
    public String toString() {
         return "\nName :" + user_name +"\nSurname :" +user_sur +"\nGender:" + gender + "\nCity :"+ city + "\nE-mail :"+email +"\nAge : " +user_age ;
    }
   
    
    public  String dispToStringUsers(){
      return  "," +user_name +"," + user_sur +","  + gender +","  +city +","  + email +","+ user_age+"\n";
    }
   
    

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_sur() {
        return user_sur;
    }

    public void setUser_sur(String user_sur) {
        this.user_sur = user_sur;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUser_age() {
        return user_age;
    }

    public void setUser_age(String user_age) {
        this.user_age = user_age;
    }

  
  public static double averageAge()
     {
         double sum=0;
     
         for (int i = 0; i < UserInfo.getMyusers().size(); i++) {
             sum+=Double.parseDouble(UserInfo.getMyusers().get(i).getUser().user_age);
       }
     
     
     return sum/UserInfo.getMyusers().size();
     }
  
    
    
    
    
    
    
    
}
