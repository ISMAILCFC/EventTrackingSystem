
package Account;

/**
 *
 * @author velik
 */
public abstract class Account implements IUser{
  protected static int i =100 ;
    protected static int total_account=0;
    protected  int account_id;
    protected  String username,password;

    public Account(String username, String password) {
        this.username = username;
        this.password = password;
        account_id=i++;
    }
   
   

 

    public static int getTotal_account() {
        return total_account;
    }

    public static void setTotal_account(int total_account) {
        Account.total_account = total_account;
    }

    public int getAccount_id() {
        return account_id;
    }

    public void setAccount_id(int account_id) {
        this.account_id = account_id;
    }

 

   

   
    @Override
    public String toString() {
       
        return "\n\nAccount id:"+account_id+"\n\nUsername :" +username +"\nPassword:"+password;
    }

   
    public  String dispToStringAccount(){
        
        return  username+"," + password;
        
    }
 
    public boolean findAdmin(String username , String password){
        if(this.username.equals(username) && this.password.equals(password)){
            return true;
        }
        else
        return false ;
        
        
    }
   
    
    public boolean findUser(String username,String pass){ //check user pass and username for login
        
        if(this.username.equals(username) && this.password.equals(pass)){
            return true ;
        }
        else{
            return false ;
        }
    }

      public boolean findUser(String username){ //check if someone has same username  for register
        
        if(this.username.equals(username)){
            return true ;
        }
        else{
            return false ;
        }
    }
      
  

    
    
    
    
    
    
    
}
