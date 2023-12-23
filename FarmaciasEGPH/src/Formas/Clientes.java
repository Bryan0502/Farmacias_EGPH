/*
 * Created by JFormDesigner on Mon Jul 11 04:35:02 COT 2022
 */

package Formas;

import Consultas.Consultas;

import java.awt.event.*;
import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.table.DefaultTableModel;

/**
 * @author Bryan
 */
public class Clientes extends JFrame {
    public Clientes() {
        initComponents();
        this.setTitle("Clientes");
    }

    private void button1(ActionEvent e) {
        // TODO add your code here
        Consultas objConsulta= new Consultas();
        jtClientes.setModel(objConsulta.consultaClientes());
    }

    private void button2(ActionEvent e) {
        // TODO add your code here
        Inicio frame = new Inicio();
        frame.setVisible(true);
        dispose();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Bryan
        scrollPane1 = new JScrollPane();
        jtClientes = new JTable();
        label1 = new JLabel();
        label3 = new JLabel();
        button2 = new JButton();
        button1 = new JButton();

        //======== this ========
        var contentPane = getContentPane();

        //======== scrollPane1 ========
        {
            scrollPane1.setViewportView(jtClientes);
        }

        //---- label1 ----
        label1.setText("Clientes Registrados");

        //---- label3 ----
        label3.setText("text");
        label3.setIcon(new ImageIcon("C:\\Logo EGHP.png"));

        //---- button2 ----
        button2.setIcon(new ImageIcon("C:\\Home.png"));
        button2.addActionListener(e -> button2(e));

        //---- button1 ----
        button1.setText("Ver Clientes");
        button1.addActionListener(e -> button1(e));

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(27, 27, 27)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                            .addGroup(contentPaneLayout.createParallelGroup()
                                .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addComponent(button2, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 172, Short.MAX_VALUE)
                                    .addComponent(label1))
                                .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addGap(0, 251, Short.MAX_VALUE)
                                    .addComponent(button1)))
                            .addGap(62, 62, 62)
                            .addComponent(label3, GroupLayout.PREFERRED_SIZE, 201, GroupLayout.PREFERRED_SIZE)
                            .addContainerGap())
                        .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                            .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 541, GroupLayout.PREFERRED_SIZE)
                            .addGap(50, 50, 50))))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                        .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(label3)
                            .addGap(41, 41, 41))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(17, 17, 17)
                            .addGroup(contentPaneLayout.createParallelGroup()
                                .addComponent(label1)
                                .addComponent(button2, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(button1)
                            .addGap(29, 29, 29)))
                    .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 292, GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(18, Short.MAX_VALUE))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
        DefaultTableModel titulosTabla= new DefaultTableModel();
        titulosTabla.addColumn("ID Clientes");
        titulosTabla.addColumn("Nombre");
        titulosTabla.addColumn("Direccion");
        titulosTabla.addColumn("Telefono Movil");
        titulosTabla.addColumn("Fecha de nacimiento");
        jtClientes.setModel(titulosTabla);
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Bryan
    private JScrollPane scrollPane1;
    private JTable jtClientes;
    private JLabel label1;
    private JLabel label3;
    private JButton button2;
    private JButton button1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
