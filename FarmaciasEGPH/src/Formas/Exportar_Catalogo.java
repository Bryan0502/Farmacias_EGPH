/*
 * Created by JFormDesigner on Mon Jul 11 11:35:05 COT 2022
 */

package Formas;

import Consultas.Procesos;

import java.awt.event.*;
import javax.swing.*;
import javax.swing.GroupLayout;

/**
 * @author Bryan
 */
public class Exportar_Catalogo extends JFrame {
    public Exportar_Catalogo() {
        initComponents();
        this.setTitle("Exportar Catalogo de Medicamentos");
    }

    Procesos obj = new Procesos();
    private void button1(ActionEvent e) {
        // TODO add your code here
        String tipo="txt";
        obj.ExportarCatalogo(tipo);
    }

    private void button2(ActionEvent e) {
        // TODO add your code here
        String tipo="csv";
        obj.ExportarCatalogo(tipo);
    }

    private void button3(ActionEvent e) {
        // TODO add your code here
        Inicio frame = new Inicio();
        frame.setVisible(true);
        dispose();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Bryan
        label1 = new JLabel();
        label3 = new JLabel();
        button1 = new JButton();
        button2 = new JButton();
        label2 = new JLabel();
        button3 = new JButton();

        //======== this ========
        var contentPane = getContentPane();

        //---- label1 ----
        label1.setText("Exportar Catalogo de Medicamentos");

        //---- label3 ----
        label3.setText("text");
        label3.setIcon(new ImageIcon("C:\\Logo EGHP.png"));

        //---- button1 ----
        button1.setText("Archivo TXT");
        button1.addActionListener(e -> button1(e));

        //---- button2 ----
        button2.setText("Archivo CSV");
        button2.addActionListener(e -> button2(e));

        //---- label2 ----
        label2.setText("Elegir Metodo de Exportacion:");

        //---- button3 ----
        button3.setIcon(new ImageIcon("C:\\Home.png"));
        button3.addActionListener(e -> button3(e));

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createParallelGroup()
                    .addGroup(contentPaneLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(contentPaneLayout.createParallelGroup()
                            .addGroup(contentPaneLayout.createSequentialGroup()
                                .addGap(76, 76, 76)
                                .addComponent(label1)
                                .addGap(6, 6, 6)
                                .addComponent(label3, GroupLayout.PREFERRED_SIZE, 201, GroupLayout.PREFERRED_SIZE))
                            .addComponent(label2)
                            .addComponent(button1)
                            .addComponent(button2))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(20, 20, 20)
                    .addComponent(button3, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(479, Short.MAX_VALUE))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createParallelGroup()
                    .addGroup(contentPaneLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(contentPaneLayout.createParallelGroup()
                            .addGroup(contentPaneLayout.createSequentialGroup()
                                .addGap(32, 32, 32)
                                .addComponent(label1))
                            .addComponent(label3))
                        .addGap(18, 18, 18)
                        .addComponent(label2)
                        .addGap(28, 28, 28)
                        .addComponent(button1)
                        .addGap(44, 44, 44)
                        .addComponent(button2)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(23, 23, 23)
                    .addComponent(button3)
                    .addContainerGap(359, Short.MAX_VALUE))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Bryan
    private JLabel label1;
    private JLabel label3;
    private JButton button1;
    private JButton button2;
    private JLabel label2;
    private JButton button3;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
