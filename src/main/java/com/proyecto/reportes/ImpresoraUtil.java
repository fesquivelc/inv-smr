/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.proyecto.reportes;

import com.proyecto.beans.Inventario;
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
        String commands = "";
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
    private static final Logger LOG = Logger.getLogger(ImpresoraUtil.class.getName());

    public static boolean imprimirCodBarInventario(List<Inventario> lista, PrintService impresora) {
        DocPrintJob job = impresora.createPrintJob();
        int pag = 1;
        int xp1 = 20;
        int xp2 = 450;
        String titulo = "C.E.P. SANTA MARÍA REINA";
        String subtitulo;
        String codigo;
        String ambienteCodigo;
        String bienNombre;
        int coordenada;
        String comandos = "";
        for (Inventario inventario : lista) {
            subtitulo = "INVENTARIO " + inventario.getPeriodo().getPeriodo();
            codigo = inventario.getBien().getClase().getCodigo() + inventario.getSerie();
            ambienteCodigo = inventario.getAmbiente().getCodigo();
            bienNombre = inventario.getBien().getNombre();
            if (bienNombre.length() > 35) {
                bienNombre = bienNombre.substring(0, 34);
            }
            if (pag == 1) {
                coordenada = xp1;
            } else {
                coordenada = xp2;
            }

            if (pag == 1) {
                comandos += "N\n";
            }

            comandos += "A" + coordenada + ",20,0,3,1,1,N,\"" + titulo + "\" \n"
                    + "A" + coordenada + ",45,0,2,1,1,N,\"" + subtitulo + "\"\n"
                    + "B" + coordenada + ",70,0,1,2,2,62,N,\"" + codigo + "\"\n"
                    + "A" + coordenada + ",137,0,2,1,1,N,\"" + ambienteCodigo + " / " + codigo + "\"\n"
                    + "A" + coordenada + ",160,0,1,1,1,N,\"" + bienNombre + ".\"\n";

            if (pag == 2) {
                comandos += "P1\n";                                
            }
            
            if(pag == 1){
                pag++;
            }else{
                pag = 1;
            }

        }
        
        if(pag == 2){
            comandos += "P1\n";
        }
        LOG.info(comandos);
        DocFlavor flavor = DocFlavor.BYTE_ARRAY.AUTOSENSE;
        Doc doc = new SimpleDoc(comandos.getBytes(), flavor, null);
        try {
            job.print(doc, null);
            return true;
        } catch (PrintException ex) {
            Logger.getLogger(ImpresoraUtil.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
}
