/*
 * Created by JFormDesigner on Mon Jul 11 12:56:53 COT 2022
 */

package Inicio_Sesion;

import Consultas.Consultas;
import Consultas.Procesos;
import Formas.Inicio;
import Inserciones.InsertarTablas;

import java.awt.event.*;
import javax.swing.*;
import javax.swing.GroupLayout;

/**
 * @author Bryan
 */
public class Registro_Usuario extends JFrame {
    public Registro_Usuario() {
        initComponents();
        this.setTitle("Registro de Usuario");
    }

    Procesos obj = new Procesos();
    InsertarTablas objInsertar = new InsertarTablas();
    private void button1(ActionEvent e) {
        // TODO add your code here
        if(!nomPath.getText().equals("") && !dirPath.getText().equals("") && !correoPath.getText().equals("") && !telPath.getText().equals("") && !fechaPath.getText().equals("") && !passPath.getText().equals("")){
            String nombre,direccion,correo,telefono,fecha,pass;
            nombre=nomPath.getText();
            direccion=dirPath.getText();
            correo=correoPath.getText();
            telefono=telPath.getText();
            fecha=fechaPath.getText();
            pass=passPath.getText();
            objInsertar.CrearUsuario(nombre,direccion,correo,telefono,fecha,pass);
            dispose();
        }else{
            obj.impresionDialogo("Uno de los campos de usuario esta en blanco ","Sin Datos",1);
        }
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Bryan
        label1 = new JLabel();
        label2 = new JLabel();
        label3 = new JLabel();
        label4 = new JLabel();
        label5 = new JLabel();
        label6 = new JLabel();
        nomPath = new JTextField();
        dirPath = new JTextField();
        correoPath = new JTextField();
        telPath = new JTextField();
        fechaPath = new JTextField();
        button1 = new JButton();
        label7 = new JLabel();
        passPath = new JTextField();

        //======== this ========
        var contentPane = getContentPane();

        //---- label1 ----
        label1.setText("Rellena los campos requeridos");

        //---- label2 ----
        label2.setText("Nombre");

        //---- label3 ----
        label3.setText("Direccion");

        //---- label4 ----
        label4.setText("Correo");

        //---- label5 ----
        label5.setText("Telefono Movil");

        //---- label6 ----
        label6.setText("Fecha de nacimiento (a\u00f1o-mes-dia)");

        //---- button1 ----
        button1.setText("Registrar Usuario");
        button1.addActionListener(e -> button1(e));

        //---- label7 ----
        label7.setText("Contrase\u00f1a");

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(184, 184, 184)
                            .addComponent(label1))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(198, 198, 198)
                            .addComponent(button1))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(22, 22, 22)
                            .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addComponent(label7)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(passPath))
                                .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                        .addComponent(label2)
                                        .addComponent(label3))
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(contentPaneLayout.createParallelGroup()
                                        .addComponent(nomPath, GroupLayout.PREFERRED_SIZE, 396, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(dirPath)))
                                .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addComponent(label4)
                                    .addGap(18, 18, 18)
                                    .addComponent(correoPath, GroupLayout.PREFERRED_SIZE, 396, GroupLayout.PREFERRED_SIZE))
                                .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addComponent(label5)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(telPath, GroupLayout.PREFERRED_SIZE, 367, GroupLayout.PREFERRED_SIZE))
                                .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addComponent(label6)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(fechaPath, GroupLayout.PREFERRED_SIZE, 257, GroupLayout.PREFERRED_SIZE)))))
                    .addContainerGap(69, Short.MAX_VALUE))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(19, 19, 19)
                    .addComponent(label1)
                    .addGap(25, 25, 25)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label2)
                        .addComponent(nomPath, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label3)
                        .addComponent(dirPath, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label4)
                        .addComponent(correoPath, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label5)
                        .addComponent(telPath, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label6)
                        .addComponent(fechaPath, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label7)
                        .addComponent(passPath, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                    .addComponent(button1)
                    .addGap(30, 30, 30))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Bryan
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JLabel label4;
    private JLabel label5;
    private JLabel label6;
    private JTextField nomPath;
    private JTextField dirPath;
    private JTextField correoPath;
    private JTextField telPath;
    private JTextField fechaPath;
    private JButton button1;
    private JLabel label7;
    private JTextField passPath;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
