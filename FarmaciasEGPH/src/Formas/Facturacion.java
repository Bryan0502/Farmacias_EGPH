/*
 * Created by JFormDesigner on Mon Jul 11 11:39:30 COT 2022
 */

package Formas;

import Consultas.Consultas;
import Consultas.Procesos;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.GroupLayout;

/**
 * @author Bryan
 */
public class Facturacion extends JFrame {
    public Facturacion() {
        initComponents();
        this.setTitle("Facturacion");
    }

    Procesos obj = new Procesos();
    private void button1(ActionEvent e) {
        // TODO add your code here
        if(!jtextFecha.getText().equals("")){
            Consultas objConsulta= new Consultas();
            jtResultado.setModel(objConsulta.consultaFacturas(jtextFecha.getText()));
        }else{
            obj.impresionDialogo("El campo fecha esta en blanco ","Sin Datos",1);
        }
    }

    private void button2(ActionEvent e) {
        // TODO add your code here
        if(!jtextNfac.getText().equals("")){
            Consultas objConsulta= new Consultas();
            jtResultado.setModel(objConsulta.consultaFacturas(jtextNfac.getText()));
        }else{
            obj.impresionDialogo("El campo numero de factura esta en blanco ","Sin Datos",1);
        }
    }

    private void button3(ActionEvent e) {
        // TODO add your code here
        Inicio frame = new Inicio();
        frame.setVisible(true);
        dispose();
    }

    private void button4(ActionEvent e) {
        // TODO add your code here
    }


    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Bryan
        scrollPane1 = new JScrollPane();
        jtResultado = new JTable();
        jtextFecha = new JTextField();
        label1 = new JLabel();
        label2 = new JLabel();
        jtextNfac = new JTextField();
        button2 = new JButton();
        label3 = new JLabel();
        button3 = new JButton();
        button1 = new JButton();

        //======== this ========
        var contentPane = getContentPane();

        //======== scrollPane1 ========
        {
            scrollPane1.setViewportView(jtResultado);
        }

        //---- label1 ----
        label1.setText("Fecha");

        //---- label2 ----
        label2.setText("N\u00b0 Factura");

        //---- button2 ----
        button2.setText("Buscar por N\u00b0");
        button2.addActionListener(e -> button2(e));

        //---- label3 ----
        label3.setText("text");
        label3.setIcon(new ImageIcon("C:\\Logo EGHP.png"));

        //---- button3 ----
        button3.setIcon(new ImageIcon("C:\\Home.png"));
        button3.addActionListener(e -> button3(e));

        //---- button1 ----
        button1.setText("Buscar por Fecha");
        button1.addActionListener(e -> button1(e));

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(button3, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(91, 91, 91)
                            .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 452, GroupLayout.PREFERRED_SIZE)))
                    .addContainerGap(180, Short.MAX_VALUE))
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(67, 67, 67)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                        .addComponent(label2)
                        .addComponent(label1, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addComponent(jtextNfac, GroupLayout.PREFERRED_SIZE, 133, GroupLayout.PREFERRED_SIZE)
                        .addComponent(jtextFecha, GroupLayout.PREFERRED_SIZE, 134, GroupLayout.PREFERRED_SIZE))
                    .addGap(34, 34, 34)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addComponent(button2)
                            .addContainerGap(313, Short.MAX_VALUE))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addComponent(button1)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 127, Short.MAX_VALUE)
                            .addComponent(label3, GroupLayout.PREFERRED_SIZE, 201, GroupLayout.PREFERRED_SIZE)
                            .addGap(14, 14, 14))))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addComponent(button3)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(jtextFecha, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(label1)
                                .addComponent(button1)))
                        .addComponent(label3))
                    .addGap(21, 21, 21)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(jtextNfac, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(label2)
                        .addComponent(button2))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                    .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 280, GroupLayout.PREFERRED_SIZE)
                    .addGap(31, 31, 31))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Bryan
    private JScrollPane scrollPane1;
    private JTable jtResultado;
    private JTextField jtextFecha;
    private JLabel label1;
    private JLabel label2;
    private JTextField jtextNfac;
    private JButton button2;
    private JLabel label3;
    private JButton button3;
    private JButton button1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
