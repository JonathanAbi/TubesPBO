/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;

/**
 *
 * @author glenn
 */
public class SingletonCustomer {
    private static SingletonCustomer instance;
    private ArrayList<Customer> listCustomer = new ArrayList<>();
    
    public static SingletonCustomer getInstance() {
        if (instance == null) {
            instance = new SingletonCustomer();
        }
        return instance;
    }
    
    public void reset(){
        this.listCustomer = new ArrayList<>();
    }
    
    public ArrayList<Customer> getListCustomer(){
        return listCustomer;
    }
    
    public Customer getCustomer(int index){
        return listCustomer.get(index);
    }
    
    public void addCustomer(Customer c){
        this.listCustomer.add(c);
    }
}
