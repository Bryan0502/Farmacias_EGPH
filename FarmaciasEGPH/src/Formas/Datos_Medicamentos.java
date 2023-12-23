/*
 * Created by JFormDesigner on Mon Jul 11 11:08:54 COT 2022
 */

package Formas;

import Consultas.Procesos;

import java.awt.event.*;
import javax.swing.*;
import javax.swing.GroupLayout;

/**
 * @author Bryan
 */
public class Datos_Medicamentos extends JFrame {
    public Datos_Medicamentos() {
        initComponents();
        this.setTitle("Actualizar Datos de Medicamentos");
    }
    Procesos obj = new Procesos();
    private void precioPathKeyTyped(KeyEvent e) {
        // TODO add your code here
        char digito = e.getKeyChar();
        if((digito<'0' || digito > '9') && digito !='.'){
            e.consume();
        }
    }

    private void actPathKeyTyped(KeyEvent e) {
        // TODO add your code here
        char digito = e.getKeyChar();
        if((digito<'0' || digito > '1')){
            e.consume();
        }
    }

    private void button1(ActionEvent e) {
        // TODO add your code here
        if(!descriPath.getText().equals("")){
            String id,info,dato,tipo="medicamento";
            id=idmedPath.getText();
            info="Descripcion";
            dato=descriPath.getText();
            obj.ActualizarDatos(id,info,dato,tipo);
        }else{
            obj.impresionDialogo("El campo descripcion esta en blanco ","Sin Datos",1);
        }
    }

    private void button2(ActionEvent e) {
        // TODO add your code here
        if(!precioPath.getText().equals("")){
            String id,info,dato,tipo="medicamento";
            id=idmedPath.getText();
            info="Precio";
            dato=precioPath.getText();
            obj.ActualizarDatos(id,info,dato,tipo);
        }else{
            obj.impresionDialogo("El campo precio esta en blanco ","Sin Datos",1);
        }
    }

    private void button3(ActionEvent e) {
        // TODO add your code here
        if(!actPath.getText().equals("")){
            String id,info,dato,tipo="medicamento";
            id=idmedPath.getText();
            info="Activo";
            dato=actPath.getText();
            obj.ActualizarDatos(id,info,dato,tipo);
        }else{
            obj.impresionDialogo("El campo activo esta en blanco ","Sin Datos",1);
        }
    }

    private void button4(ActionEvent e) {
        // TODO add your code here
        Inicio frame = new Inicio();
        frame.setVisible(true);
        dispose();
    }


    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Bryan
        label3 = new JLabel();
        label1 = new JLabel();
        label2 = new JLabel();
        idmedPath = new JTextField();
        label4 = new JLabel();
        label5 = new JLabel();
        label6 = new JLabel();
        descriPath = new JTextField();
        precioPath = new JTextField();
        actPath = new JTextField();
        label9 = new JLabel();
        button1 = new JButton();
        button2 = new JButton();
        button3 = new JButton();
        button4 = new JButton();

        //======== this ========
        var contentPane = getContentPane();

        //---- label3 ----
        label3.setText("text");
        label3.setIcon(new ImageIcon("C:\\Logo EGHP.png"));

        //---- label1 ----
        label1.setText("Actualizar Datos de Medicamentos");

        //---- label2 ----
        label2.setText("Escriba el ID del medicamento");

        //---- label4 ----
        label4.setText("Descripcion");

        //---- label5 ----
        label5.setText("Precio");

        //---- label6 ----
        label6.setText("Activo");

        //---- precioPath ----
        precioPath.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                precioPathKeyTyped(e);
            }
        });

        //---- actPath ----
        actPath.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                actPathKeyTyped(e);
            }
        });

        //---- label9 ----
        label9.setText("Elegir el campo a Actualizar");

        //---- button1 ----
        button1.setText("Actualizar");
        button1.addActionListener(e -> button1(e));

        //---- button2 ----
        button2.setText("Actualizar");
        button2.addActionListener(e -> button2(e));

        //---- button3 ----
        button3.setText("Actualizar");
        button3.addActionListener(e -> button3(e));

        //---- button4 ----
        button4.setIcon(new ImageIcon("C:\\Home.png"));
        button4.addActionListener(e -> button4(e));

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createParallelGroup()
                    .addGroup(contentPaneLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(contentPaneLayout.createParallelGroup()
                            .addGroup(contentPaneLayout.createSequentialGroup()
                                .addGap(181, 181, 181)
                                .addComponent(label1)
                                .addGap(29, 29, 29)
                                .addComponent(label3, GroupLayout.PREFERRED_SIZE, 201, GroupLayout.PREFERRED_SIZE))
                            .addGroup(contentPaneLayout.createSequentialGroup()
                                .addComponent(label2)
                                .addGap(6, 6, 6)
                                .addComponent(idmedPath, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE))
                            .addComponent(label9)
                            .addGroup(contentPaneLayout.createSequentialGroup()
                                .addComponent(label4)
                                .addGap(12, 12, 12)
                                .addComponent(descriPath, GroupLayout.PREFERRED_SIZE, 384, GroupLayout.PREFERRED_SIZE))
                            .addGroup(contentPaneLayout.createSequentialGroup()
                                .addComponent(label5)
                                .addGap(12, 12, 12)
                                .addComponent(precioPath, GroupLayout.PREFERRED_SIZE, 151, GroupLayout.PREFERRED_SIZE))
                            .addGroup(contentPaneLayout.createSequentialGroup()
                                .addComponent(label6)
                                .addGap(12, 12, 12)
                                .addComponent(actPath, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(button1)
                    .addGap(104, 104, 104))
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(254, 254, 254)
                            .addGroup(contentPaneLayout.createParallelGroup()
                                .addComponent(button3)
                                .addComponent(button2)))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(31, 31, 31)
                            .addComponent(button4, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE)))
                    .addContainerGap(363, Short.MAX_VALUE))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createParallelGroup()
                    .addGroup(contentPaneLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(contentPaneLayout.createParallelGroup()
                            .addGroup(contentPaneLayout.createSequentialGroup()
                                .addGap(13, 13, 13)
                                .addComponent(label1))
                            .addComponent(label3))
                        .addGap(29, 29, 29)
                        .addGroup(contentPaneLayout.createParallelGroup()
                            .addGroup(contentPaneLayout.createSequentialGroup()
                                .addGap(7, 7, 7)
                                .addComponent(label2))
                            .addComponent(idmedPath, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addGap(29, 29, 29)
                        .addComponent(label9)
                        .addGap(18, 18, 18)
                        .addGroup(contentPaneLayout.createParallelGroup()
                            .addGroup(contentPaneLayout.createSequentialGroup()
                                .addGap(7, 7, 7)
                                .addComponent(label4))
                            .addComponent(descriPath, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(contentPaneLayout.createParallelGroup()
                            .addGroup(contentPaneLayout.createSequentialGroup()
                                .addGap(7, 7, 7)
                                .addComponent(label5))
                            .addComponent(precioPath, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(contentPaneLayout.createParallelGroup()
                            .addGroup(contentPaneLayout.createSequentialGroup()
                                .addGap(7, 7, 7)
                                .addComponent(label6))
                            .addComponent(actPath, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(27, 27, 27)
                    .addComponent(button4)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 181, Short.MAX_VALUE)
                    .addComponent(button1)
                    .addGap(10, 10, 10)
                    .addComponent(button2)
                    .addGap(29, 29, 29)
                    .addComponent(button3)
                    .addGap(40, 40, 40))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Bryan
    private JLabel label3;
    private JLabel label1;
    private JLabel label2;
    private JTextField idmedPath;
    private JLabel label4;
    private JLabel label5;
    private JLabel label6;
    private JTextField descriPath;
    private JTextField precioPath;
    private JTextField actPath;
    private JLabel label9;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
