/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.proyecto.main;

import com.proyecto.vista.Principal;
import javax.swing.UIManager;

/**
 *
 * @author Documentos
 */
public class Main {

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel("com.seaglasslookandfeel.SeaGlassLookAndFeel");
        } catch (Exception e) {
        }
        Principal prueba = new Principal();
        prueba.setVisible(true);
    }
}
