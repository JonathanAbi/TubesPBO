/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

/**
 *
 * @author glenn
 */
public class UpdateBarangController {

    private static UpdateBarangController barangUpdate;

    private UpdateBarangController() {

    }

    public static UpdateBarangController getInstance() {
        if (barangUpdate == null) {
            barangUpdate = new UpdateBarangController();
        }
        return barangUpdate;
    }

    
}
