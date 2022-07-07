
package Model;

public class SingletonProfile {
    
    private static SingletonProfile instance;
    private User user;
    
    private SingletonProfile(){
        
    }

    public static SingletonProfile getInstance() {
        if(instance==null){
            instance=new SingletonProfile();
        }
        return instance;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}
