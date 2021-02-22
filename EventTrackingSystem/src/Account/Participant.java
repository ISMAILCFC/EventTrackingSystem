/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Account;

import java.util.ArrayList;

/**
 *
 * @author velik
 */
public class Participant extends Account implements  IUser{
    
   
    private static int total_par=0;
    private Users user;
   
    

    public Participant( String username, String password,String user_name, String user_sur, String gender, String city, String email, String user_age) {
        super(username, password);
        this.user = new Users(user_name, user_sur, gender, city, email, user_age);
        total_par++;
    }

   
   

    public static int getTotal_par() {
        return total_par;
    }

    @Override
    public String toString() {
        return  super.toString() + user ;
    }

    public String dispToString()
            
    {
        return  super.dispToStringAccount()+user.dispToStringUsers();
    
    
    
    }
    
    
    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public static int getTotal_account() {
        return total_account;
    }

    public int getAccount_id() {
        return account_id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

 

    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
