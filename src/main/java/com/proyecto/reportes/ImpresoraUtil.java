/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.proyecto.reportes;

import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.print.Doc;
import javax.print.DocFlavor;
import javax.print.DocPrintJob;
import javax.print.PrintException;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.print.SimpleDoc;

/**
 *
 * @author fesquivelc
 */
public class ImpresoraUtil {

    public static List<PrintService> impresoras() {
        PrintService[] services = PrintServiceLookup.lookupPrintServices(null, null);
        return Arrays.asList(services);
    }

    public static boolean imprimirCodigoDeBarras(String codigo, PrintService impresora) {
        DocPrintJob job = impresora.createPrintJob();
        String commands = "^XA\n\r^MNM\n\r^FO050,50\n\r^B8N,100,Y,N\n\r^FD1234567\n\r^FS\n\r^PQ3\n\r^XZ";
        DocFlavor flavor = DocFlavor.BYTE_ARRAY.AUTOSENSE;
        Doc doc = new SimpleDoc(commands.getBytes(), flavor, null);
        try {
            job.print(doc, null);
            return true;
        } catch (PrintException ex) {            
            Logger.getLogger(ImpresoraUtil.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
}
