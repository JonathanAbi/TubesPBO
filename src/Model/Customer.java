
package Model;

public class Customer extends Regular implements UserInterface{
    private Alamat alamat;

    public Customer(Alamat alamat, String telepon, String name, String username, String password, int id) {
        super(telepon, name, username, password, id);
        this.alamat = alamat;
    }

    public Alamat getAlamat() {
        return alamat;
    }

    public void setAlamat(Alamat alamat) {
        this.alamat = alamat;
    }
    
}
