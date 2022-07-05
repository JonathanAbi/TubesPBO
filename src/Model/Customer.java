
package Model;

import java.util.ArrayList;

public class Customer extends Regular implements UserInterface{
    private ArrayList <Alamat> alamat;

    public Customer(ArrayList <Alamat> alamat, String telepon, String name, String username, String password, int id) {
        super(telepon, name, username, password, id);
        this.alamat = alamat;
    }

    public ArrayList<Alamat> getAlamat() {
        return alamat;
    }

    public void setAlamat(ArrayList<Alamat> alamat) {
        this.alamat = alamat;
    }

    
    
}
