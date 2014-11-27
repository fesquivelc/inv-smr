/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.proyecto.vista;

import com.proyecto.beans.Usuario;

/**
 *
 * @author juvitec
 */
public class UsuarioUtil {
    
    private static Usuario user;
    
    public static void setUsuarioActual(Usuario usuario){
        user =  usuario;
    }
    
    public static Usuario getUsuarioActual(){
        return user;
    }
    
}
