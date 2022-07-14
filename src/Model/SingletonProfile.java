
package Model;

public class SingletonProfile {
    
    private static SingletonProfile instance;
    private User user = null;
    
    private SingletonProfile(){
        
    }

    public static SingletonProfile getInstance() {
        if(instance==null){
            instance=new SingletonProfile();
        }
        return instance;
    }
    
    public void reset(){
        this.user = null;
    }
    
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}
