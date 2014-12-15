/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.proyecto.reportes;

/**
 *
 * @author fesquivelc
 */
public class asd {
    
    private asd() {
    }
    
    public static asd getInstance() {
        return asdHolder.INSTANCE;
    }
    
    private static class asdHolder {

        private static final asd INSTANCE = new asd();
    }
}
