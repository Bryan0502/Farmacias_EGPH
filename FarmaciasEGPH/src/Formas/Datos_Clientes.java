/*
 * Created by JFormDesigner on Mon Jul 11 04:54:33 COT 2022
 */

package Formas;

import Consultas.Procesos;

import java.awt.event.*;
import javax.swing.*;
import javax.swing.GroupLayout;

/**
 * @author Bryan
 */
public class Datos_Clientes extends JFrame {
    public Datos_Clientes() {
        initComponents();
        this.setTitle("Actualizar Datos de Clientes");
    }
    Procesos obj = new Procesos();
    public static String correo;

    private void button1(ActionEvent e) {//actualizar nombre
        // TODO add your code here
        if(!nomPath.getText().equals("")){
            String info,dato,tipo="cliente";
            info="Nombre";
            dato=nomPath.getText();
            obj.ActualizarDatos(correo,info,dato,tipo);
        }else{
            obj.impresionDialogo("El campo nombre esta en blanco ","Sin Datos",1);
        }
    }

    private void button2(ActionEvent e) {//actualizar direccion
        // TODO add your code here
        if(!dirPath.getText().equals("")){
            String info,dato,tipo="cliente";
            info="Direccion";
            dato=dirPath.getText();
            obj.ActualizarDatos(correo,info,dato,tipo);
        }else{
            obj.impresionDialogo("El campo direccion esta en blanco ","Sin Datos",1);
        }
    }

    private void button3(ActionEvent e) {//actualizar correo
        // TODO add your code here
        if(!correoPath.getText().equals("")){
            String info,dato,tipo="cliente";
            info="Correo";
            dato=correoPath.getText();
            obj.ActualizarDatos(correo,info,dato,tipo);
        }else{
            obj.impresionDialogo("El campo correo esta en blanco ","Sin Datos",1);
        }
    }

    private void button4(ActionEvent e) {//actualizar telefono movil
        // TODO add your code here
        if(!telPath.getText().equals("")){
            String info,dato,tipo="cliente";
            info="Telefono_Movil";
            dato=telPath.getText();
            obj.ActualizarDatos(correo,info,dato,tipo);
        }else{
            obj.impresionDialogo("El campo telefono movil esta en blanco ","Sin Datos",1);
        }
    }

    private void button5(ActionEvent e) {//actualizar fecha de nacimiento
        // TODO add your code here
        if(!fechaPath.getText().equals("")){
            String info,dato,tipo="cliente";
            info="Fecha_de_nacimiento";
            dato=fechaPath.getText();
            obj.ActualizarDatos(correo,info,dato,tipo);
        }else{
            obj.impresionDialogo("El campo fecha de nacimiento esta en blanco ","Sin Datos",1);
        }
    }

    private void button6(ActionEvent e) {
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
        label4 = new JLabel();
        label5 = new JLabel();
        label6 = new JLabel();
        label7 = new JLabel();
        label8 = new JLabel();
        nomPath = new JTextField();
        dirPath = new JTextField();
        correoPath = new JTextField();
        telPath = new JTextField();
        fechaPath = new JTextField();
        button1 = new JButton();
        button2 = new JButton();
        button3 = new JButton();
        button4 = new JButton();
        button5 = new JButton();
        label9 = new JLabel();
        button6 = new JButton();

        //======== this ========
        var contentPane = getContentPane();

        //---- label3 ----
        label3.setText("text");
        label3.setIcon(new ImageIcon("C:\\Logo EGHP.png"));

        //---- label1 ----
        label1.setText("Actualizar Datos de Clientes");

        //---- label4 ----
        label4.setText("Nombre");

        //---- label5 ----
        label5.setText("Direccion");

        //---- label6 ----
        label6.setText("Correo");

        //---- label7 ----
        label7.setText("Telefono Movil");

        //---- label8 ----
        label8.setText("Fecha de nacimiento(a\u00f1o-mes-dia)");

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
        button4.setText("Actualizar");
        button4.addActionListener(e -> button4(e));

        //---- button5 ----
        button5.setText("Actualizar");
        button5.addActionListener(e -> button5(e));

        //---- label9 ----
        label9.setText("Elegir el campo a Actualizar");

        //---- button6 ----
        button6.setIcon(new ImageIcon("C:\\Home.png"));
        button6.addActionListener(e -> button6(e));

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(26, 26, 26)
                            .addComponent(button6, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
                            .addGap(198, 198, 198)
                            .addComponent(label1)
                            .addGap(18, 18, 18)
                            .addComponent(label3, GroupLayout.PREFERRED_SIZE, 201, GroupLayout.PREFERRED_SIZE))
                        .addComponent(label9)
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addComponent(label4)
                            .addGap(37, 37, 37)
                            .addComponent(nomPath, GroupLayout.PREFERRED_SIZE, 335, GroupLayout.PREFERRED_SIZE)
                            .addGap(6, 6, 6)
                            .addComponent(button1))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addComponent(label5)
                            .addGap(31, 31, 31)
                            .addComponent(dirPath, GroupLayout.PREFERRED_SIZE, 335, GroupLayout.PREFERRED_SIZE)
                            .addGap(6, 6, 6)
                            .addComponent(button2))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addComponent(label6)
                            .addGap(45, 45, 45)
                            .addComponent(correoPath, GroupLayout.PREFERRED_SIZE, 335, GroupLayout.PREFERRED_SIZE)
                            .addGap(6, 6, 6)
                            .addComponent(button3))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addComponent(label7)
                            .addGap(6, 6, 6)
                            .addComponent(telPath, GroupLayout.PREFERRED_SIZE, 331, GroupLayout.PREFERRED_SIZE)
                            .addGap(6, 6, 6)
                            .addComponent(button4))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addComponent(label8)
                            .addGap(6, 6, 6)
                            .addComponent(fechaPath, GroupLayout.PREFERRED_SIZE, 182, GroupLayout.PREFERRED_SIZE)
                            .addGap(6, 6, 6)
                            .addComponent(button5)))
                    .addGap(0, 0, Short.MAX_VALUE))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(0, 3, Short.MAX_VALUE)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(15, 15, 15)
                            .addGroup(contentPaneLayout.createParallelGroup()
                                .addComponent(label1)
                                .addComponent(button6)))
                        .addComponent(label3))
                    .addGap(90, 90, 90)
                    .addComponent(label9)
                    .addGap(18, 18, 18)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(7, 7, 7)
                            .addComponent(label4))
                        .addComponent(nomPath, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(button1))
                    .addGap(18, 18, 18)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(7, 7, 7)
                            .addComponent(label5))
                        .addComponent(dirPath, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(button2))
                    .addGap(18, 18, 18)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(7, 7, 7)
                            .addComponent(label6))
                        .addComponent(correoPath, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(button3))
                    .addGap(18, 18, 18)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(7, 7, 7)
                            .addComponent(label7))
                        .addComponent(telPath, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(button4))
                    .addGap(18, 18, 18)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(7, 7, 7)
                            .addComponent(label8))
                        .addComponent(fechaPath, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(button5))
                    .addGap(0, 3, Short.MAX_VALUE))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Bryan
    private JLabel label3;
    private JLabel label1;
    private JLabel label4;
    private JLabel label5;
    private JLabel label6;
    private JLabel label7;
    private JLabel label8;
    private JTextField nomPath;
    private JTextField dirPath;
    private JTextField correoPath;
    private JTextField telPath;
    private JTextField fechaPath;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    private JButton button5;
    private JLabel label9;
    private JButton button6;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
