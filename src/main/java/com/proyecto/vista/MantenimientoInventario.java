/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.proyecto.vista;

import com.proyecto.beans.Ambiente;
import com.proyecto.beans.Bien;
import com.proyecto.beans.Inventario;
import com.proyecto.beans.Periodo;
import com.proyecto.control.AbstractControlador;
import com.proyecto.control.BienControlador;
import com.proyecto.control.InventarioControlador;
import com.proyecto.control.PeriodoControlador;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import org.apache.commons.beanutils.BeanUtils;
import org.jdesktop.beansbinding.AutoBinding;
import org.jdesktop.beansbinding.BeanProperty;
import org.jdesktop.observablecollections.ObservableCollections;
import org.jdesktop.swingbinding.JTableBinding;
import org.jdesktop.swingbinding.SwingBindings;

/**
 *
 * @author Documentos
 */
public class MantenimientoInventario extends javax.swing.JInternalFrame {

    /**
     * Creates new form MantenimientoInventario
     */
    private static MantenimientoInventario instancia;

    public MantenimientoInventario() {
        initComponents();
        cargarComboPeriodo();
        listar();
    }

    public static MantenimientoInventario getInstancia() {
        if (instancia == null) {
            instancia = new MantenimientoInventario();
        }
        return instancia;
    }

    private List<Inventario> lista;
    private final BienControlador bienControlador = new BienControlador();
    private final InventarioControlador inventarioControlador = new InventarioControlador();
    private Bien bien;

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblInventario = new javax.swing.JTable();
        cmbPeriodo = new javax.swing.JComboBox();
        jdateInicio = new com.toedter.calendar.JDateChooser();
        jDateFin = new com.toedter.calendar.JDateChooser();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setClosable(true);
        setTitle("Mantenimiento Inventario");

        jLabel1.setText("Periodo");

        tblInventario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(tblInventario);

        cmbPeriodo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbPeriodo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbPeriodoActionPerformed(evt);
            }
        });

        jLabel7.setText("-");

        jLabel8.setText("Rango de Fechas");

        jButton1.setText("Buscar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jScrollPane2)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel1)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(cmbPeriodo, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(489, 489, 489)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jdateInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 4, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jDateFin, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(cmbPeriodo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(14, 14, 14)
                        .addComponent(jDateFin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(45, 45, 45)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jdateInicio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton1)
                                .addGap(10, 10, 10)))
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        Periodo periodo = (Periodo) cmbPeriodo.getSelectedItem();
        Date inicio = jdateInicio.getDate();
        Date fin = jDateFin.getDate();

        Calendar cal = Calendar.getInstance();

        if (jdateInicio == null) {
            cal.set(cal.get(Calendar.YEAR), cal.getActualMinimum(Calendar.MONTH), cal.getActualMinimum(Calendar.DAY_OF_MONTH));
                        
            jdateInicio.setDate(cal.getTime());
        }else if(jDateFin == null){
            cal.set(cal.get(Calendar.YEAR), cal.getActualMaximum(Calendar.MONTH), cal.getActualMaximum(Calendar.DAY_OF_MONTH));
                        
            jdateInicio.setDate(cal.getTime());
        }

        lista.clear();
        lista.addAll(inventarioControlador.buscarXFecha(inicio, fin));
    }//GEN-LAST:event_jButton1ActionPerformed

    private void cmbPeriodoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbPeriodoActionPerformed
        // TODO add your handling code here:
        lista.clear();
        lista.addAll(inventarioControlador.buscarXPeriodo((Periodo)cmbPeriodo.getSelectedItem()));
    }//GEN-LAST:event_cmbPeriodoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox cmbPeriodo;
    private javax.swing.JButton jButton1;
    private com.toedter.calendar.JDateChooser jDateFin;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane2;
    private com.toedter.calendar.JDateChooser jdateInicio;
    private javax.swing.JTable tblInventario;
    // End of variables declaration//GEN-END:variables

    private void listar() {
        lista = new ArrayList();
        lista = ObservableCollections.observableList(lista);

        JTableBinding binding = SwingBindings.createJTableBinding(AutoBinding.UpdateStrategy.READ, lista, tblInventario);

        BeanProperty bBienId = BeanProperty.create("bien");
        BeanProperty bSerie = BeanProperty.create("serie");
        BeanProperty bAmbienteId = BeanProperty.create("ambiente");
        BeanProperty bPeriodoId = BeanProperty.create("periodo");
        BeanProperty bBaja = BeanProperty.create("baja");

        binding.addColumnBinding(bBienId).setColumnName("BIEN").setEditable(false);
        binding.addColumnBinding(bSerie).setColumnName("SERIE").setEditable(false);
        binding.addColumnBinding(bAmbienteId).setColumnName("AMBIENTE").setEditable(false);
        binding.addColumnBinding(bPeriodoId).setColumnName("PERIODO").setEditable(false);
        binding.addColumnBinding(bBaja).setColumnName("BAJA").setEditable(false).setColumnClass(Boolean.class);

        binding.bind();

    }

    private void cargarComboPeriodo() {
        PeriodoControlador periodoControlador = new PeriodoControlador();
        List<Periodo> periodo = periodoControlador.buscarTodos();
        cmbPeriodo.setModel(new DefaultComboBoxModel(periodo.toArray()));
    }
}
