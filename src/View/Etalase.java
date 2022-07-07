package View;

import Controller.EtalaseController;

public class Etalase {
        
    public static void main(String[] args) {
        new Etalase();
    }
    
    public Etalase(){
        EtalaseController controller = new EtalaseController();
        controller.getFrame();
    }
}
