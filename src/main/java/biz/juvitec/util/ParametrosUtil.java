/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biz.juvitec.util;

/**
 *
 * @author fesquivelc
 */
public class ParametrosUtil {
    public static String obtenerDriver(int tipoBD){
        switch(tipoBD){
            case 1:
                return "com.microsoft.jdbc.sqlserver.SQLServerDriver";
            case 3:
                return "com.mysql.jdbc.Driver";
            case 2:
                return "org.postgresql.Driver";
            default:
                return "";
        }
    }
}
