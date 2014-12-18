/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.proyecto.vista;

import com.proyecto.beans.TipoUsuario;
import com.proyecto.beans.Usuario;
import com.proyecto.control.Controlador;
import com.proyecto.control.TipoUsuarioControlador;
import com.proyecto.control.UsuarioControlador;
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
 * @author juvitec
 */
public class MantenimientoUsuario extends javax.swing.JInternalFrame {

    /**
     * Creates new form MantenimientoUsuario
     */
    private static MantenimientoUsuario instancia;
    
    public MantenimientoUsuario() {
        initComponents();
        cargarCombo();
        listar();
    }
    
    public static MantenimientoUsuario getInstancia() {
        if (instancia == null) {
            instancia = new MantenimientoUsuario();
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

        jLabel1 = new javax.swing.JLabel();
        txtbuscar = new javax.swing.JTextField();
        btnbuscar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblusuario = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        idLabel = new javax.swing.JLabel();
        nombreLabel = new javax.swing.JLabel();
        passwordField = new javax.swing.JTextField();
        nombreLabel1 = new javax.swing.JLabel();
        usuarioField = new javax.swing.JTextField();
        cmbtipo = new javax.swing.JComboBox();
        jPanel2 = new javax.swing.JPanel();
        btnnuevo = new javax.swing.JButton();
        btnguardar = new javax.swing.JButton();
        btnmodificar = new javax.swing.JButton();
        btneliminar = new javax.swing.JButton();
        btncancelar = new javax.swing.JButton();

        setClosable(true);

        jLabel1.setText("Buscar: ");

        btnbuscar.setText("Buscar");
        btnbuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbuscarActionPerformed(evt);
            }
        });

        tblusuario.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblusuario);

        jLabel2.setText("Lista de usuarios:");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 10))); // NOI18N
        jPanel1.setToolTipText("");

        idLabel.setText("Usuario:");

        nombreLabel.setText("Contraseña:");

        nombreLabel1.setText("Tipo de usuario: ");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(idLabel)
                    .addComponent(nombreLabel)
                    .addComponent(nombreLabel1))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(passwordField, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(usuarioField, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(cmbtipo, 0, 215, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(idLabel)
                    .addComponent(usuarioField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nombreLabel)
                    .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nombreLabel1)
                    .addComponent(cmbtipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Opciones", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 10))); // NOI18N
        jPanel2.setToolTipText("");

        btnnuevo.setText("Nuevo");
        btnnuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnnuevoActionPerformed(evt);
            }
        });

        btnguardar.setText("Guardar");
        btnguardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnguardarActionPerformed(evt);
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

        btncancelar.setText("Cancelar");
        btncancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnmodificar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btneliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnguardar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnnuevo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btncancelar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(31, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnnuevo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnmodificar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btneliminar)
                .addGap(18, 18, 18)
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
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(txtbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 403, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnbuscar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jScrollPane1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel2)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnbuscar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnbuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbuscarActionPerformed
        // TODO add your handling code here:
        lista.clear();
        lista.addAll(this.usuarioControlador.buscarXNombre(txtbuscar.getText().toUpperCase()));
    }//GEN-LAST:event_btnbuscarActionPerformed

    private void btnnuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnnuevoActionPerformed
        // TODO add your handling code here:
        btnguardar.setEnabled(true);
        passwordField.setEnabled(true);
        btnnuevo.setEnabled(false);
        accion = Controlador.NUEVO;
        usuarioControlador.prepararCrear();
        usuarioField.setEnabled(true);
        usuarioField.requestFocusInWindow();
        txtbuscar.setText(null);
    }//GEN-LAST:event_btnnuevoActionPerformed

    private void btnguardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnguardarActionPerformed
        // TODO add your handling code here:
        String palabra = "";
        String palabra2 = "";
        if (accion == 1) {
            palabra = "registrar";
            palabra2 = "registrado";

            if (JOptionPane.showConfirmDialog(null, "¿Desea " + palabra + " el Usuario?", "Mensaje del Sistema", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                usuarioControlador.getSeleccionado().setNombre(usuarioField.getText());
                usuarioControlador.getSeleccionado().setPassword(passwordField.getText());
                
                int index = cmbtipo.getSelectedIndex();
                TipoUsuarioControlador tipoUsuarioControlador = new TipoUsuarioControlador();                
                TipoUsuario tipoUsuario = (TipoUsuario)cmbtipo.getSelectedItem();
                
                usuarioControlador.getSeleccionado().setTipoUsuario(tipoUsuario);

                lista.add(usuarioControlador.getSeleccionado());
                usuarioControlador.accion(accion);
                if (accion == 1) {
                    JOptionPane.showMessageDialog(null, "Usuario " + palabra2 + " correctamente", "Mensaje del Sistema", JOptionPane.INFORMATION_MESSAGE);
                    passwordField.setText(null);
                    usuarioField.setText(null);
                } else {
                    JOptionPane.showMessageDialog(null, "Usuario no " + palabra2, "Mensaje del Sistema", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                passwordField.setText(null);
                usuarioField.setText(null);
                JOptionPane.showMessageDialog(null, "Usuario no " + palabra2, "Mensaje del Sistema", JOptionPane.ERROR_MESSAGE);
            }
        } else if (accion == 2) {
            palabra = "modificar";
            palabra2 = "modificado";

            if (JOptionPane.showConfirmDialog(null, "¿Desea " + palabra + "el Usuario?", "Mensaje del Sistema", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {

                if (accion == 2) {
                    JOptionPane.showMessageDialog(null, "Usuario " + palabra2 + " correctamente", "Mensaje del Sistema", JOptionPane.INFORMATION_MESSAGE);
                    passwordField.setText(null);
                    usuarioField.setText(null);
                } else {
                    JOptionPane.showMessageDialog(null, "Usuario no " + palabra2, "Mensaje del Sistema", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                passwordField.setText(null);
                usuarioField.setText(null);
                JOptionPane.showMessageDialog(null, "Usuario no " + palabra2, "Mensaje del Sistema", JOptionPane.ERROR_MESSAGE);
            }
        }

        btnguardar.setEnabled(false);
        passwordField.setEnabled(false);
        usuarioField.setEnabled(false);
        usuarioField.setEditable(false);
        btnnuevo.setEnabled(true);
        btnmodificar.setEnabled(true);
        btncancelar.setEnabled(false);
    }//GEN-LAST:event_btnguardarActionPerformed

    private void btnmodificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnmodificarActionPerformed
        // TODO add your handling code here:
        accion = Controlador.MODIFICAR;
        btnguardar.setEnabled(true);
        btnmodificar.setEnabled(false);
        btnnuevo.setEnabled(false);
    }//GEN-LAST:event_btnmodificarActionPerformed

    private void btneliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneliminarActionPerformed
        // TODO add your handling code here:
        accion = Controlador.ELIMINAR;
        if (tblusuario.getSelectedRow() != -1) {
            Integer codigo = (Integer) tblusuario.getModel().getValueAt(tblusuario.getSelectedRow(), 0);

            Usuario clase = usuarioControlador.buscarPorId(codigo);

            if (clase != null) {
                if (JOptionPane.showConfirmDialog(null, "¿Desea Eliminar el Usuario?", "Mensaje del Sistema", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {

                    int[] filas = tblusuario.getSelectedRows();
                    for (int i = 0; i < filas.length; i++) {
                        Usuario clase2 = lista.get(filas[0]);
                        lista.remove(clase2);
                        usuarioControlador.setSeleccionado(clase2);
                        usuarioControlador.accion(accion);
                    }
                    if (usuarioControlador.accion(accion) == 3) {
                        JOptionPane.showMessageDialog(null, "Usuario eliminado correctamente", "Mensaje del Sistema", JOptionPane.INFORMATION_MESSAGE);

                    } else {
                        JOptionPane.showMessageDialog(null, "Usuario no eliminado", "Mensaje del Sistema", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Usuario no eliminado", "Mensaje del Sistema", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }//GEN-LAST:event_btneliminarActionPerformed

    private void btncancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncancelarActionPerformed
        // TODO add your handling code here:
        btnnuevo.setEnabled(true);
        btnmodificar.setEnabled(true);
        btneliminar.setEnabled(true);
    }//GEN-LAST:event_btncancelarActionPerformed

    private int accion;
    private List<Usuario> lista;
    private final UsuarioControlador usuarioControlador = new UsuarioControlador();

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnbuscar;
    private javax.swing.JButton btncancelar;
    private javax.swing.JButton btneliminar;
    private javax.swing.JButton btnguardar;
    private javax.swing.JButton btnmodificar;
    private javax.swing.JButton btnnuevo;
    private javax.swing.JComboBox cmbtipo;
    private javax.swing.JLabel idLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel nombreLabel;
    private javax.swing.JLabel nombreLabel1;
    private javax.swing.JTextField passwordField;
    private javax.swing.JTable tblusuario;
    private javax.swing.JTextField txtbuscar;
    private javax.swing.JTextField usuarioField;
    // End of variables declaration//GEN-END:variables

    private void cargarCombo() {
        TipoUsuarioControlador tipoUsuarioControlador = new TipoUsuarioControlador();
         List<TipoUsuario> periodo = tipoUsuarioControlador.buscarTodos();
         DefaultComboBoxModel modeloCombo = new DefaultComboBoxModel(periodo.toArray());
         
//         
//         modeloCombo.addElement("-- Seleccionar --");
//         for (int i = 0; i < periodo.size(); i++) {
//             modeloCombo.addElement(periodo.get(i).getNombre());
//         }
         cmbtipo.setModel(modeloCombo);
     }
    
    private void listar() {
        lista = usuarioControlador.buscarTodos();
        lista = ObservableCollections.observableList(lista);
        JTableBinding binding = SwingBindings.createJTableBinding(AutoBinding.UpdateStrategy.READ, lista, tblusuario);

        BeanProperty bId = BeanProperty.create("id");
        BeanProperty bNombre = BeanProperty.create("nombre");
        BeanProperty bPassword = BeanProperty.create("password");

        binding.addColumnBinding(bId).setColumnName("ID").setEditable(false);
        binding.addColumnBinding(bNombre).setColumnName("NOMBRE").setEditable(false);
        binding.addColumnBinding(bPassword).setColumnName("PASSWORD").setEditable(false);

        binding.bind();

    }
}
