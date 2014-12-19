/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.proyecto.reportes;

import com.personal.reporteutil.ReporteUtil;
import com.proyecto.beans.Ambiente;
import com.proyecto.beans.Area;
import com.proyecto.beans.Inventario;
import com.proyecto.beans.Periodo;
import com.proyecto.control.InventarioControlador;
import com.proyecto.control.PeriodoControlador;
import com.proyecto.dao.DAO;
import java.awt.Component;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.plaf.basic.BasicComboBoxRenderer;
import net.sf.jasperreports.engine.JRException;
import org.jdesktop.beansbinding.AutoBinding;
import org.jdesktop.beansbinding.BeanProperty;
import org.jdesktop.beansbinding.BindingGroup;
import org.jdesktop.observablecollections.ObservableCollections;
import org.jdesktop.swingbinding.JComboBoxBinding;
import org.jdesktop.swingbinding.JTableBinding;
import org.jdesktop.swingbinding.SwingBindings;

/**
 *
 * @author fesquivelc
 */
public class ReporteBienesXAmbiente extends javax.swing.JInternalFrame {

    /**
     * Creates new form ReporteBienesXAmbiente
     */
    private ReporteBienesXAmbiente() {
        initComponents();
        reporteUtil = new ReporteUtil(DAO.driver,DAO.url,DAO.usuario,DAO.password);
        periodoControlador = new PeriodoControlador();
        bindeoSalvaje();
        bindeoSalvaje2();
    }

    public static ReporteBienesXAmbiente getInstance() {
        return ReporteBienesXAmbienteHolder.INSTANCE;
    }

    private void seleccionarAmbiente() {
        DlgAmbiente dlg = new DlgAmbiente(this, true);
        ambienteSeleccionado = dlg.getSeleccionado();
        if (ambienteSeleccionado != null) {
            txtAmbiente.setText(ambienteSeleccionado.getCodigo() + " " + ambienteSeleccionado.getNombre());
            buscar();
        }

    }

    private Area areaSeleccionada;

    private void seleccionarArea() {
//        DlgArea dlg = new DlgArea(this, true);
//        areaSeleccionada = dlg.getSeleccionado();
//        if (areaSeleccionada != null) {
//            txtArea.setText(areaSeleccionada.getNombre());
//            buscarXArea();
//        }

    }

    private void buscarXArea() {
//        if (areaSeleccionada != null) {
//            inventarioList2.clear();
//            inventarioList2.addAll(inventarioControlador.buscarXArea(areaSeleccionada));
//            tabla2.packAll();
//            btnImprimirAmbiente.setEnabled(true);
//        }
    }

    private void buscar() {
        if (ambienteSeleccionado != null) {
            inventarioList.clear();
            inventarioList.addAll(inventarioControlador.buscarXAmbiente(ambienteSeleccionado, periodoSeleccionado));
            tabla.packAll();
            btnImprimirAmbiente.setEnabled(true);
        }
    }

    private static class ReporteBienesXAmbienteHolder {

        private static final ReporteBienesXAmbiente INSTANCE = new ReporteBienesXAmbiente();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        btnImprimirAmbiente = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txtAmbiente = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabla = new org.jdesktop.swingx.JXTable();
        cboPeriodo = new javax.swing.JComboBox();

        setClosable(true);
        setTitle("Reporte de bienes");
        setToolTipText("");

        java.awt.GridBagLayout jPanel1Layout = new java.awt.GridBagLayout();
        jPanel1Layout.columnWidths = new int[] {0, 5, 0, 5, 0, 5, 0, 5, 0};
        jPanel1Layout.rowHeights = new int[] {0, 6, 0, 6, 0};
        jPanel1.setLayout(jPanel1Layout);

        jPanel2.setLayout(new java.awt.GridLayout(1, 0, 5, 0));

        btnImprimirAmbiente.setText(" Imprimir por ambiente");
        btnImprimirAmbiente.setEnabled(false);
        btnImprimirAmbiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImprimirAmbienteActionPerformed(evt);
            }
        });
        jPanel2.add(btnImprimirAmbiente);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 7;
        jPanel1.add(jPanel2, gridBagConstraints);

        jLabel2.setText("Ambiente:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        jPanel1.add(jLabel2, gridBagConstraints);

        txtAmbiente.setEditable(false);
        txtAmbiente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                txtAmbienteMouseReleased(evt);
            }
        });
        txtAmbiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAmbienteActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.1;
        jPanel1.add(txtAmbiente, gridBagConstraints);

        jButton1.setText("...");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 0;
        jPanel1.add(jButton1, gridBagConstraints);

        jButton3.setText("Buscar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 8;
        gridBagConstraints.gridy = 0;
        jPanel1.add(jButton3, gridBagConstraints);

        tabla.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(tabla);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 9;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        jPanel1.add(jScrollPane2, gridBagConstraints);

        cboPeriodo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cboPeriodo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboPeriodoActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        jPanel1.add(cboPeriodo, gridBagConstraints);

        jTabbedPane1.addTab("Bienes por ambiente", jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 647, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 419, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cboPeriodoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboPeriodoActionPerformed
        // TODO add your handling code here:
        int index = this.cboPeriodo.getSelectedIndex();
        if (index != -1) {
            periodoSeleccionado = periodoList.get(index);
        }
    }//GEN-LAST:event_cboPeriodoActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        buscar();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        seleccionarAmbiente();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txtAmbienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAmbienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAmbienteActionPerformed

    private void txtAmbienteMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtAmbienteMouseReleased
        // TODO add your handling code here:
        seleccionarAmbiente();
    }//GEN-LAST:event_txtAmbienteMouseReleased

    private void btnImprimirAmbienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImprimirAmbienteActionPerformed
        // TODO add your handling code here:
        if (ambienteSeleccionado != null) {
            try {
                File reporte = new File("reportes/bienes_ambiente_seleccionado.jasper");
                Map mapa = new HashMap();
                mapa.put("ambiente_codigo", ambienteSeleccionado.getCodigo());
                mapa.put("periodo_id", periodoSeleccionado.getId());
                reporteUtil.generarReporte(reporte, mapa, JOptionPane.getFrameForComponent(this));
            } catch (JRException ex) {
                Logger.getLogger(ReporteBienesXAmbiente.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnImprimirAmbienteActionPerformed

    private final ReporteUtil reporteUtil;
    private Ambiente ambienteSeleccionado;
    private final InventarioControlador inventarioControlador = new InventarioControlador();
    private List<Inventario> inventarioList;
    private List<Inventario> inventarioList2;
    private List<Periodo> periodoList;
    private final PeriodoControlador periodoControlador;
    private Periodo periodoSeleccionado;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnImprimirAmbiente;
    private javax.swing.JComboBox cboPeriodo;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private org.jdesktop.swingx.JXTable tabla;
    private javax.swing.JTextField txtAmbiente;
    // End of variables declaration//GEN-END:variables

    private void bindeoSalvaje() {
        BindingGroup bindingGroup = new BindingGroup();
        inventarioList = ObservableCollections.observableList(new ArrayList<Inventario>());
        periodoList = periodoControlador.buscarTodos();

        JTableBinding bindeoSalvajeTabla = SwingBindings.createJTableBinding(AutoBinding.UpdateStrategy.READ, inventarioList, tabla);
        JComboBoxBinding bindeoComboSalvaje = SwingBindings.createJComboBoxBinding(AutoBinding.UpdateStrategy.READ, periodoList, cboPeriodo);

        BeanProperty bBien = BeanProperty.create("bien");
        BeanProperty bBienNombre = BeanProperty.create(bBien, "nombre");
        BeanProperty bClase = BeanProperty.create(BeanProperty.create(bBien, "clase"), "codigo");
        BeanProperty bSerie = BeanProperty.create("serie");
        BeanProperty bCodigoFabrica = BeanProperty.create("codigoFabrica");
        BeanProperty bEstado = BeanProperty.create("estado");

        bindeoSalvajeTabla.addColumnBinding(bClase).setColumnName("Clase").setEditable(false).setColumnClass(String.class);
        bindeoSalvajeTabla.addColumnBinding(bSerie).setColumnName("Serie").setEditable(false).setColumnClass(String.class);
        bindeoSalvajeTabla.addColumnBinding(bCodigoFabrica).setColumnName("Codigo de Fabrica").setEditable(false).setColumnClass(String.class);
        bindeoSalvajeTabla.addColumnBinding(bBienNombre).setColumnName("Bien").setEditable(false).setColumnClass(String.class);
        bindeoSalvajeTabla.addColumnBinding(bEstado).setColumnName("Estado").setEditable(false).setColumnClass(String.class);

        bindingGroup.addBinding(bindeoSalvajeTabla);
        bindingGroup.addBinding(bindeoComboSalvaje);

        bindingGroup.bind();

        cboPeriodo.setRenderer(new BasicComboBoxRenderer() {

            @Override
            public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                if (value instanceof Periodo) {
                    value = ((Periodo) value).getPeriodo();
                }
                return super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus); //To change body of generated methods, choose Tools | Templates.
            }

        });
    }

    private void bindeoSalvaje2() {
//        inventarioList2 = ObservableCollections.observableList(new ArrayList<Inventario>());
//
//        JTableBinding binding = SwingBindings.createJTableBinding(AutoBinding.UpdateStrategy.READ, inventarioList2, tabla2);
//
//        BeanProperty bBien = BeanProperty.create("bien");
//        BeanProperty bBienNombre = BeanProperty.create(bBien, "nombre");
//        BeanProperty bClase = BeanProperty.create(BeanProperty.create(bBien, "clase"), "codigo");
//        BeanProperty bSerie = BeanProperty.create("serie");
//        BeanProperty bCodigoFabrica = BeanProperty.create("codigoFabrica");
//        BeanProperty bEstado = BeanProperty.create("estado");
//
//        binding.addColumnBinding(bClase).setColumnName("Clase").setEditable(false).setColumnClass(String.class);
//        binding.addColumnBinding(bSerie).setColumnName("Serie").setEditable(false).setColumnClass(String.class);
//        binding.addColumnBinding(bCodigoFabrica).setColumnName("Codigo de Fabrica").setEditable(false).setColumnClass(String.class);
//        binding.addColumnBinding(bBienNombre).setColumnName("Bien").setEditable(false).setColumnClass(String.class);
//        binding.addColumnBinding(bEstado).setColumnName("Estado").setEditable(false).setColumnClass(String.class);
//
//        binding.bind();
    }
}
