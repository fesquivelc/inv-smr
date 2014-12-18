/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.proyecto.vista;

import com.proyecto.beans.Campo;
import com.proyecto.beans.Clase;
import com.proyecto.beans.UnidadMedida;
import com.proyecto.control.Controlador;
import com.proyecto.control.CampoControlador;
import com.proyecto.control.ClaseControlador;
import com.proyecto.control.UnidadMedidaControlador;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
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
public class MantenimientoCampo extends javax.swing.JInternalFrame {

    /**
     * Creates new form MantenimientoClase
     */
    private static MantenimientoCampo instancia;
    private int limite;
    private int offset;

    public MantenimientoCampo() {
        initComponents();
        listar();

        FormularioUtil.activarComponente(panelDatos, false);
        FormularioUtil.activarComponente(panelOpciones, true);
        FormularioUtil.activarComponente(panelGuardar, false);
    }

    public static MantenimientoCampo getInstancia() {
        if (instancia == null) {
            instancia = new MantenimientoCampo();
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

        panelDatos = new javax.swing.JPanel();
        nombreLabel = new javax.swing.JLabel();
        nombreField = new javax.swing.JTextField();
        nombreLabel1 = new javax.swing.JLabel();
        cmbClase = new javax.swing.JComboBox();
        panelOpciones = new javax.swing.JPanel();
        btnnuevo = new javax.swing.JButton();
        btnmodificar = new javax.swing.JButton();
        btneliminar = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtbuscar = new javax.swing.JTextField();
        btnbuscar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblclase = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        panelGuardar = new javax.swing.JPanel();
        btnguardar = new javax.swing.JButton();
        btncancelar = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setTitle("Mantenimiento de Campos");

        panelDatos.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 10))); // NOI18N
        panelDatos.setToolTipText("");

        nombreLabel.setText("Nombre:");

        nombreLabel1.setText("Clase");

        cmbClase.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout panelDatosLayout = new javax.swing.GroupLayout(panelDatos);
        panelDatos.setLayout(panelDatosLayout);
        panelDatosLayout.setHorizontalGroup(
            panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDatosLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(nombreLabel)
                    .addComponent(nombreLabel1))
                .addGap(27, 27, 27)
                .addGroup(panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cmbClase, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nombreField, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(35, Short.MAX_VALUE))
        );
        panelDatosLayout.setVerticalGroup(
            panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDatosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nombreLabel)
                    .addComponent(nombreField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nombreLabel1)
                    .addComponent(cmbClase, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelOpciones.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Opciones", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 10))); // NOI18N
        panelOpciones.setToolTipText("");

        btnnuevo.setText("Nuevo");
        btnnuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnnuevoActionPerformed(evt);
            }
        });

        btnmodificar.setText("Modificar");
        btnmodificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnmodificarActionPerformed(evt);
            }
        });

        btneliminar.setText("Eliminar");
        btneliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneliminarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelOpcionesLayout = new javax.swing.GroupLayout(panelOpciones);
        panelOpciones.setLayout(panelOpcionesLayout);
        panelOpcionesLayout.setHorizontalGroup(
            panelOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelOpcionesLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(panelOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnmodificar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btneliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnnuevo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(27, 27, 27))
        );
        panelOpcionesLayout.setVerticalGroup(
            panelOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelOpcionesLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnnuevo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnmodificar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btneliminar)
                .addContainerGap())
        );

        jLabel1.setText("Buscar: ");

        txtbuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtbuscarKeyReleased(evt);
            }
        });

        btnbuscar.setText("Buscar");
        btnbuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbuscarActionPerformed(evt);
            }
        });

        tblclase.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblclase);

        jLabel2.setText("Lista de campos:");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(txtbuscar)
                        .addGap(18, 18, 18)
                        .addComponent(btnbuscar))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnbuscar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );

        panelGuardar.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        btnguardar.setText("Guardar");
        btnguardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnguardarActionPerformed(evt);
            }
        });

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
                .addGap(34, 34, 34)
                .addGroup(panelGuardarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnguardar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btncancelar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(32, 32, 32))
        );
        panelGuardarLayout.setVerticalGroup(
            panelGuardarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelGuardarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnguardar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btncancelar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(panelDatos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(panelGuardar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(1, 1, 1))
                            .addComponent(panelOpciones, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(5, 5, 5)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(panelOpciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(panelGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 29, Short.MAX_VALUE))
                    .addComponent(panelDatos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnnuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnnuevoActionPerformed
        // TODO add your handling code here:
       
        accion = Controlador.NUEVO;
        campoControlador.prepararCrear();
        FormularioUtil.activarComponente(panelOpciones, false);
        FormularioUtil.activarComponente(panelGuardar, true);
        FormularioUtil.activarComponente(panelDatos, true);
        nombreField.requestFocusInWindow();
        FormularioUtil.limpiarComponente(panelDatos);
        cargarCombos();
    }//GEN-LAST:event_btnnuevoActionPerformed

    private void btnguardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnguardarActionPerformed
        // TODO add your handling code here:
        String palabra = "";
        String palabra2 = "";
        if (accion == 1) {
            palabra = "registrar";
            palabra2 = "registrado";

            if (JOptionPane.showConfirmDialog(null, "¿Desea " + palabra + " el Campo?", "Mensaje del Sistema", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {

                campoControlador.getSeleccionado().setNombre(nombreField.getText().toUpperCase());
                campoControlador.getSeleccionado().setClase((Clase) cmbClase.getSelectedItem());
//                campoControlador.getSeleccionado().setUnidadMedida((UnidadMedida) cmbUnidad.getSelectedItem());

                campoControlador.accion(accion);
                lista.add(campoControlador.getSeleccionado());

                if (accion == 1) {
                    JOptionPane.showMessageDialog(null, "Campo " + palabra2 + " correctamente", "Mensaje del Sistema", JOptionPane.INFORMATION_MESSAGE);
                    FormularioUtil.limpiarComponente(panelDatos);
                } else {
                    JOptionPane.showMessageDialog(null, "Campo no " + palabra2, "Mensaje del Sistema", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                FormularioUtil.limpiarComponente(panelDatos);
                JOptionPane.showMessageDialog(null, "Campo no " + palabra2, "Mensaje del Sistema", JOptionPane.ERROR_MESSAGE);
            }
        } else if (accion == 2) {
            palabra = "modificar";
            palabra2 = "modificado";

            if (JOptionPane.showConfirmDialog(null, "¿Desea " + palabra + " el Campo?", "Mensaje del Sistema", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {

                if (accion == 2) {
                    JOptionPane.showMessageDialog(null, "Campo " + palabra2 + " correctamente", "Mensaje del Sistema", JOptionPane.INFORMATION_MESSAGE);

                    lista.clear();

                    campoControlador.getSeleccionado().setNombre(nombreField.getText().toUpperCase());
                    campoControlador.getSeleccionado().setClase((Clase) cmbClase.getSelectedItem());
//                    campoControlador.getSeleccionado().setUnidadMedida((UnidadMedida) cmbUnidad.getSelectedItem());

                    campoControlador.accion(accion);
                    listar();

                    FormularioUtil.limpiarComponente(panelDatos);

                } else {
                    JOptionPane.showMessageDialog(null, "Campo no " + palabra2, "Mensaje del Sistema", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                FormularioUtil.limpiarComponente(panelDatos);
                JOptionPane.showMessageDialog(null, "Campo no " + palabra2, "Mensaje del Sistema", JOptionPane.ERROR_MESSAGE);
            }
        }

        FormularioUtil.activarComponente(panelOpciones, true);
        FormularioUtil.activarComponente(panelGuardar, false);
        FormularioUtil.activarComponente(panelDatos, false);

    }//GEN-LAST:event_btnguardarActionPerformed

    private void btneliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneliminarActionPerformed
        // TODO add your handling code here:
        accion = Controlador.ELIMINAR;
        if (tblclase.getSelectedRow() != -1) {

            Integer id = tblclase.getSelectedRow();

            Campo campo = campoControlador.buscarPorId(lista.get(id).getId());

            if (campo != null) {
                if (JOptionPane.showConfirmDialog(null, "¿Desea Eliminar el Campo?", "Mensaje del Sistema", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {

                    int[] filas = tblclase.getSelectedRows();
                    for (int i = 0; i < filas.length; i++) {
                        Campo campo2 = lista.get(filas[0]);
                        lista.remove(campo2);
                        campoControlador.setSeleccionado(campo2);
                        campoControlador.accion(accion);
                    }
                    if (campoControlador.accion(accion) == 3) {
                        JOptionPane.showMessageDialog(null, "Campo eliminada correctamente", "Mensaje del Sistema", JOptionPane.INFORMATION_MESSAGE);

                    } else {
                        JOptionPane.showMessageDialog(null, "Campo no eliminada", "Mensaje del Sistema", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Campo no eliminada", "Mensaje del Sistema", JOptionPane.ERROR_MESSAGE);
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Debe seleccionar un Campo de la lista", "Mensaje del Sistema", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btneliminarActionPerformed

    private void btnmodificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnmodificarActionPerformed
        // TODO add your handling code here:
        accion = Controlador.MODIFICAR;
        cargarCombos();

        int fila = this.tblclase.getSelectedRow();
        if (fila != -1) {
            FormularioUtil.activarComponente(panelDatos, true);
            FormularioUtil.activarComponente(panelOpciones, false);
            FormularioUtil.activarComponente(panelGuardar, true);

            accion = Controlador.MODIFICAR;
            campoControlador.setSeleccionado(lista.get(fila));
            Campo campo = campoControlador.getSeleccionado();
            try {
                nombreField.setText(BeanUtils.getProperty(campo, "nombre"));

                cmbClase.setSelectedItem(campo.getClase());
//                cmbUnidad.setSelectedItem(campo.getUnidadMedida());

            } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException ex) {
                Logger.getLogger(MantenimientoCampo.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Debe seleccionar un Campo de la lista", "Mensaje del Sistema", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnmodificarActionPerformed

    private void btnbuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbuscarActionPerformed
        // TODO add your handling code here:
        lista.clear();
        lista.addAll(this.campoControlador.buscarXNombre(txtbuscar.getText().toUpperCase()));
    }//GEN-LAST:event_btnbuscarActionPerformed

    private void btncancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncancelarActionPerformed
        // TODO add your handling code here:
        FormularioUtil.activarComponente(panelDatos, false);
        FormularioUtil.limpiarComponente(panelDatos);
        FormularioUtil.activarComponente(panelOpciones, true);
        FormularioUtil.activarComponente(panelGuardar, false);
    }//GEN-LAST:event_btncancelarActionPerformed

    private void txtbuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtbuscarKeyReleased
        // TODO add your handling code here:
        lista.clear();
        lista.addAll(this.campoControlador.buscarXNombre(txtbuscar.getText().toUpperCase()));
    }//GEN-LAST:event_txtbuscarKeyReleased

    private int accion;
    private List<Campo> lista;
    private final CampoControlador campoControlador = new CampoControlador();
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnbuscar;
    private javax.swing.JButton btncancelar;
    private javax.swing.JButton btneliminar;
    private javax.swing.JButton btnguardar;
    private javax.swing.JButton btnmodificar;
    private javax.swing.JButton btnnuevo;
    private javax.swing.JComboBox cmbClase;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField nombreField;
    private javax.swing.JLabel nombreLabel;
    private javax.swing.JLabel nombreLabel1;
    private javax.swing.JPanel panelDatos;
    private javax.swing.JPanel panelGuardar;
    private javax.swing.JPanel panelOpciones;
    private javax.swing.JTable tblclase;
    private javax.swing.JTextField txtbuscar;
    // End of variables declaration//GEN-END:variables

    private void listar() {
        lista = campoControlador.buscarTodos();
        lista = ObservableCollections.observableList(lista);

        JTableBinding binding = SwingBindings.createJTableBinding(AutoBinding.UpdateStrategy.READ, lista, tblclase);

        BeanProperty bId = BeanProperty.create("id");
        BeanProperty bNombre = BeanProperty.create("nombre");
        BeanProperty bClase = BeanProperty.create("clase");

        binding.addColumnBinding(bId).setColumnName("ID").setEditable(false);
        binding.addColumnBinding(bNombre).setColumnName("NOMBRE").setEditable(false);
        binding.addColumnBinding(bClase).setColumnName("CLASE").setEditable(false);

        binding.bind();

    }

    private void cargarComboClase() {
        ClaseControlador claseControl = new ClaseControlador();
        List<Clase> clase = claseControl.buscarTodos();
        cmbClase.setModel(new DefaultComboBoxModel(clase.toArray()));

    }
    
    private void cargarComboUnidad(){
        UnidadMedidaControlador unidadControl = new UnidadMedidaControlador();
        List<UnidadMedida> unidad = new ArrayList();
        unidad.add(null);
        unidad.addAll(unidadControl.buscarTodos());
//        cmbUnidad.setModel(new DefaultComboBoxModel(unidad.toArray()));
    }
    
    private void cargarCombos(){
        cargarComboClase();
        cargarComboUnidad();
    }

}
