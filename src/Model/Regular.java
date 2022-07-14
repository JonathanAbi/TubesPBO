
package Model;

public abstract class Regular extends User{
    protected String telepon;

    public Regular(){
        
    }
    public Regular(String telepon, String name, String username, String password, int id) {
        super(name, username, password, id);
        this.telepon = telepon;
    }

    public String getTelepon() {
        return telepon;
    }

    public void setTelepon(String telepon) {
        this.telepon = telepon;
    }
    
}
