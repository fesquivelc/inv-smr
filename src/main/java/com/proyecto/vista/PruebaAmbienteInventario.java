/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.proyecto.vista;

import com.proyecto.beans.Ambiente;
import com.proyecto.beans.Inventario;
import com.proyecto.beans.Periodo;
import com.proyecto.control.AbstractControlador;
import com.proyecto.control.InventarioControlador;
import com.proyecto.control.PeriodoControlador;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import org.jdesktop.beansbinding.AutoBinding;
import org.jdesktop.beansbinding.BeanProperty;
import org.jdesktop.observablecollections.ObservableCollections;
import org.jdesktop.swingbinding.JTableBinding;
import org.jdesktop.swingbinding.SwingBindings;

/**
 *
 * @author Documentos
 */
public class PruebaAmbienteInventario extends javax.swing.JInternalFrame {

    /**
     * Creates new form PruebaAmbienteInventario
     */
    private static PruebaAmbienteInventario instancia;

    public PruebaAmbienteInventario() {
        initComponents();
        cargarComboPeriodo();
        FormularioUtil.activarComponente(panelGuardar, false);
        FormularioUtil.activarComponente(panelDatos, false);
        this.txtBuscar.requestFocusInWindow();
    }

    public static PruebaAmbienteInventario getInstancia() {
        if (instancia == null) {
            instancia = new PruebaAmbienteInventario();
        }
        return instancia;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        ambienteField = new javax.swing.JTextField();
        jButton11 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblInventario = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        txtBuscar = new javax.swing.JTextField();
        panelDatos = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        ambienteField1 = new javax.swing.JTextField();
        jButton12 = new javax.swing.JButton();
        jButton13 = new javax.swing.JButton();
        chckImprimir = new javax.swing.JCheckBox();
        jLabel5 = new javax.swing.JLabel();
        lblSerie = new javax.swing.JLabel();
        lblBien = new javax.swing.JLabel();
        panelGuardar = new javax.swing.JPanel();
        btnguardar = new javax.swing.JButton();
        btncancelar = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        cmbPeriodo = new javax.swing.JComboBox();

        setClosable(true);

        jLabel3.setText("Ambiente");

        jButton11.setIcon(new javax.swing.ImageIcon("img/iconos/Search.png"));
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        jButton10.setIcon(new javax.swing.ImageIcon("img/iconos/clear.png"));
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

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
        tblInventario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tblInventarioMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tblInventario);

        jLabel1.setText("Bienes Inventariados del Ambiente:");

        txtBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarKeyReleased(evt);
            }
        });

        panelDatos.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 10))); // NOI18N

        jLabel2.setText("SERIE:");

        jLabel4.setText("Ambiente");

        jButton12.setIcon(new javax.swing.ImageIcon("img/iconos/Search.png"));
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });

        jButton13.setIcon(new javax.swing.ImageIcon("img/iconos/clear.png"));
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });

        chckImprimir.setText("Impresion pendiente");

        jLabel5.setText("BIEN:");

        javax.swing.GroupLayout panelDatosLayout = new javax.swing.GroupLayout(panelDatos);
        panelDatos.setLayout(panelDatosLayout);
        panelDatosLayout.setHorizontalGroup(
            panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDatosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelDatosLayout.createSequentialGroup()
                        .addComponent(ambienteField1, javax.swing.GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton13, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29))
                    .addGroup(panelDatosLayout.createSequentialGroup()
                        .addComponent(chckImprimir)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(panelDatosLayout.createSequentialGroup()
                        .addComponent(lblSerie, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelDatosLayout.createSequentialGroup()
                        .addComponent(lblBien, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        panelDatosLayout.setVerticalGroup(
            panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDatosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblSerie, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(lblBien, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4)
                        .addComponent(ambienteField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton12)
                    .addComponent(jButton13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(chckImprimir)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        panelGuardar.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Acciones", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 10))); // NOI18N

        btnguardar.setIcon(new javax.swing.ImageIcon("img/iconos/Save.png"));
        btnguardar.setText("Guardar");
        btnguardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnguardarActionPerformed(evt);
            }
        });

        btncancelar.setIcon(new javax.swing.ImageIcon("img/iconos/Delete.png"));
        btncancelar.setText("Cancelar");
        btncancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelGuardarLayout = new javax.swing.GroupLayout(panelGuardar);
        panelGuardar.setLayout(panelGuardarLayout);
        panelGuardarLayout.setHorizontalGroup(
            panelGuardarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelGuardarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnguardar, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btncancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelGuardarLayout.setVerticalGroup(
            panelGuardarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelGuardarLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelGuardarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnguardar)
                    .addComponent(btncancelar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel6.setText("Periodo");

        cmbPeriodo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(txtBuscar)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cmbPeriodo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(ambienteField, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelDatos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panelGuardar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(cmbPeriodo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel3)
                                .addComponent(ambienteField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jButton11)
                            .addComponent(jButton10))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(panelDatos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(panelGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 256, Short.MAX_VALUE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    InventarioControlador inventarioControlador = new InventarioControlador();
    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        // TODO add your handling code here:
        DlgAmbienteBusqueda ambienteDialog = new DlgAmbienteBusqueda(this);

        ambiente = ambienteDialog.getAmbiente();

        if (ambiente != null) {
            ambienteField.setText(ambiente.toString());
            listarInventarios(ambiente);
        }
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        // TODO add your handling code here:
        ambienteField.setText(null);
        inventarioControlador.getSeleccionado().setAmbiente(null);
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        // TODO add your handling code here:
        DlgAmbienteBusqueda ambienteDialog = new DlgAmbienteBusqueda(this);

        inventarioControlador.getSeleccionado().setAmbiente(ambienteDialog.getAmbiente());

        if (inventarioControlador.getSeleccionado().getAmbiente() != null) {
            ambienteField.setText(inventarioControlador.getSeleccionado().getAmbiente().toString());
        }
    }//GEN-LAST:event_jButton12ActionPerformed

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton13ActionPerformed

    private int accion;
    Ambiente ambiente;
    private void btnguardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnguardarActionPerformed
        // TODO add your handling code here:
        if (accion == 2) {
            String palabra = "modificado";

            if (JOptionPane.showConfirmDialog(null, "¿Desea " + palabra + " el Inventario?", "Mensaje del Sistema", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {

                JOptionPane.showMessageDialog(null, "Inventario " + palabra + " correctamente", "Mensaje del Sistema", JOptionPane.INFORMATION_MESSAGE);
                
                inventarioControlador.getSeleccionado().setImpresionPendiente(chckImprimir.isSelected());

            } else {
                JOptionPane.showMessageDialog(null, "Inventario no " + palabra, "Mensaje del Sistema", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnguardarActionPerformed

    private void btncancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncancelarActionPerformed
        // TODO add your handling code here:
        FormularioUtil.limpiarComponente(panelDatos);
        FormularioUtil.activarComponente(panelGuardar, false);
        FormularioUtil.activarComponente(panelDatos, false);
        this.txtBuscar.requestFocusInWindow();
    }//GEN-LAST:event_btncancelarActionPerformed

    private void tblInventarioMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblInventarioMouseReleased
        // TODO add your handling code here:
        if (evt.getClickCount() == 2) {
            
            accion = AbstractControlador.MODIFICAR;
            
            FormularioUtil.activarComponente(panelGuardar, true);
            FormularioUtil.activarComponente(panelDatos, true);

            int fila = tblInventario.getSelectedRow();
            Inventario bien = lista.get(fila);
            inventarioControlador.setSeleccionado(bien);

            ambienteField1.setText(inventarioControlador.getSeleccionado().getAmbiente().toString());
            if(inventarioControlador.getSeleccionado().getImpresionPendiente() != null){
                chckImprimir.setSelected(inventarioControlador.getSeleccionado().getImpresionPendiente());
            }
            
            lblSerie.setText(inventarioControlador.getSeleccionado().getSerie());
            lblBien.setText(inventarioControlador.getSeleccionado().getBien().getNombre());
        }
    }//GEN-LAST:event_tblInventarioMouseReleased

    private void txtBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyReleased
        // TODO add your handling code here:
        lista.clear();
        lista.addAll(inventarioControlador.buscarInventarioXNombreBien(txtBuscar.getText().toUpperCase(), ambiente, (Periodo) cmbPeriodo.getSelectedItem()));
    }//GEN-LAST:event_txtBuscarKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField ambienteField;
    private javax.swing.JTextField ambienteField1;
    private javax.swing.JButton btncancelar;
    private javax.swing.JButton btnguardar;
    private javax.swing.JCheckBox chckImprimir;
    private javax.swing.JComboBox cmbPeriodo;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblBien;
    private javax.swing.JLabel lblSerie;
    private javax.swing.JPanel panelDatos;
    private javax.swing.JPanel panelGuardar;
    private javax.swing.JTable tblInventario;
    private javax.swing.JTextField txtBuscar;
    // End of variables declaration//GEN-END:variables

    List<Inventario> lista;

    private void listarInventarios(Ambiente ambiente) {
        lista = inventarioControlador.buscarXAmbiente(ambiente, (Periodo) cmbPeriodo.getSelectedItem());
        lista = ObservableCollections.observableList(lista);

        JTableBinding binding = SwingBindings.createJTableBinding(AutoBinding.UpdateStrategy.READ, lista, tblInventario);

        BeanProperty bBienId = BeanProperty.create("bien");
        BeanProperty bSerie = BeanProperty.create("serie");

        binding.addColumnBinding(bBienId).setColumnName("BIEN").setEditable(false);
        binding.addColumnBinding(bSerie).setColumnName("SERIE").setEditable(false);
        
        binding.bind();
    }

    private void cargarComboPeriodo() {
        PeriodoControlador periodoC = new PeriodoControlador();
        List<Periodo> periodos = periodoC.buscarTodos();
        cmbPeriodo.setModel(new DefaultComboBoxModel(periodos.toArray()));
    }
}