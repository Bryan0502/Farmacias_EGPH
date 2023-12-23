/*
 * Created by JFormDesigner on Mon Jul 11 12:42:07 COT 2022
 */

package Formas;

import Consultas.Consultas;

import java.awt.event.*;
import javax.swing.*;
import javax.swing.GroupLayout;

/**
 * @author Bryan
 */
public class Inventario extends JFrame {
    public Inventario() {
        initComponents();
        this.setTitle("Inventario");
    }

    private void button1(ActionEvent e) {
        // TODO add your code here
        Consultas objConsulta= new Consultas();
        jtInventario.setModel(objConsulta.consultaInventario());
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
        jtInventario = new JTable();
        label1 = new JLabel();
        label3 = new JLabel();
        button1 = new JButton();
        button2 = new JButton();

        //======== this ========
        var contentPane = getContentPane();

        //======== scrollPane1 ========
        {
            scrollPane1.setViewportView(jtInventario);
        }

        //---- label1 ----
        label1.setText("Inventario de Medicamentos");

        //---- label3 ----
        label3.setText("text");
        label3.setIcon(new ImageIcon("C:\\Logo EGHP.png"));

        //---- button1 ----
        button1.setText("Ver Inventario");
        button1.addActionListener(e -> button1(e));

        //---- button2 ----
        button2.setIcon(new ImageIcon("C:\\Home.png"));
        button2.addActionListener(e -> button2(e));

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(21, 21, 21)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addComponent(button2, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 58, Short.MAX_VALUE)
                            .addComponent(label1)
                            .addGap(18, 18, 18))
                        .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                            .addGap(0, 151, Short.MAX_VALUE)
                            .addComponent(button1)
                            .addGap(37, 37, 37)))
                    .addComponent(label3, GroupLayout.PREFERRED_SIZE, 201, GroupLayout.PREFERRED_SIZE)
                    .addGap(16, 16, 16))
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(34, 34, 34)
                    .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 452, GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(47, Short.MAX_VALUE))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(label3))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(15, 15, 15)
                            .addGroup(contentPaneLayout.createParallelGroup()
                                .addComponent(label1)
                                .addComponent(button2))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                            .addComponent(button1)))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 280, GroupLayout.PREFERRED_SIZE)
                    .addGap(49, 49, 49))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Bryan
    private JScrollPane scrollPane1;
    private JTable jtInventario;
    private JLabel label1;
    private JLabel label3;
    private JButton button1;
    private JButton button2;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
