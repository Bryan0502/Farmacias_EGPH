/*
 * Created by JFormDesigner on Mon Jul 11 04:10:43 COT 2022
 */

package Inicio_Sesion;

import javax.swing.plaf.*;

import Consultas.Consultas;
import Formas.Comprar;
import Formas.Datos_Clientes;
import Formas.Inicio;
import Consultas.Procesos;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.GroupLayout;

/**
 * @author Bryan
 */
public class Bienvenida extends JFrame {
    public Bienvenida() {
        initComponents();
        this.setTitle("Bienvenido");
    }

    public static void main(String[] args) {
        Bienvenida frame = new Bienvenida();
        frame.setVisible(true);
    }

    Consultas objconsulta = new Consultas();
    Procesos obj = new Procesos();
    private void button1(ActionEvent e) {//Ingresar
        // TODO add your code here
            if (!jtextCorreo.getText().equals("") && !jtextPass.getText().equals("")) {
                String correo, pass;
                correo = jtextCorreo.getText();
                pass = jtextPass.getText();
                int bak=objconsulta.ValidarUsuario(correo, pass);
                if (bak==4) {
                    Comprar.CorreoCliente = jtextCorreo.getText();
                    Datos_Clientes.correo = jtextCorreo.getText();
                    Inicio frame = new Inicio();
                    frame.setVisible(true);
                    dispose();
                }
                else if(bak == 3){
                    ArrayList<String> datoscorreo = new ArrayList<String>();
                    int tipo=2;
                    datoscorreo.add("2");
                    datoscorreo.add("2");
                    Procesos.CorreoCliente2=jtextCorreo.getText();
                    obj.EnviarCorreo(datoscorreo,tipo);
                }
            } else {
                obj.impresionDialogo("Uno de los campos de usuario esta en blanco ", "Sin Datos", 1);
            }
    }

    private void button2(ActionEvent e) {//Registrase
        // TODO add your code here
        Registro_Usuario frame = new Registro_Usuario();
        frame.setVisible(true);
    }

    private void button3(ActionEvent e) {
        // TODO add your code here
        System.exit(1);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Bryan
        label2 = new JLabel();
        label3 = new JLabel();
        label4 = new JLabel();
        label5 = new JLabel();
        jtextCorreo = new JTextField();
        jtextPass = new JTextField();
        button1 = new JButton();
        label6 = new JLabel();
        button2 = new JButton();
        button3 = new JButton();

        //======== this ========
        var contentPane = getContentPane();

        //---- label2 ----
        label2.setText("text");
        label2.setIcon(new ImageIcon("C:\\Fondo EGPH2.jpg"));

        //---- label3 ----
        label3.setText("Bienvenido a Farmacias EGPH");

        //---- label4 ----
        label4.setText("Correo");

        //---- label5 ----
        label5.setText("Contrase\u00f1a");

        //---- button1 ----
        button1.setText("Ingresar");
        button1.addActionListener(e -> button1(e));

        //---- label6 ----
        label6.setText("\u00bfNo tienes cuenta?");

        //---- button2 ----
        button2.setText("Registrarse");
        button2.addActionListener(e -> button2(e));

        //---- button3 ----
        button3.setIcon(new ImageIcon("C:\\shutdown.png"));
        button3.addActionListener(e -> button3(e));

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(134, 134, 134)
                            .addComponent(button1)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 174, Short.MAX_VALUE)
                            .addComponent(button2))
                        .addGroup(GroupLayout.Alignment.LEADING, contentPaneLayout.createSequentialGroup()
                            .addGap(5, 5, 5)
                            .addComponent(label5)
                            .addGap(18, 18, 18)
                            .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                .addComponent(jtextCorreo, GroupLayout.DEFAULT_SIZE, 265, Short.MAX_VALUE)
                                .addComponent(jtextPass, GroupLayout.DEFAULT_SIZE, 265, Short.MAX_VALUE))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                            .addComponent(label6)))
                    .addGap(61, 61, 61))
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(62, 62, 62)
                    .addComponent(label2, GroupLayout.PREFERRED_SIZE, 398, GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 78, Short.MAX_VALUE))
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(14, 14, 14)
                            .addComponent(label4)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 402, Short.MAX_VALUE))
                        .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                            .addContainerGap(161, Short.MAX_VALUE)
                            .addComponent(label3)
                            .addGap(134, 134, 134)))
                    .addComponent(button3, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)
                    .addGap(22, 22, 22))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(21, 21, 21)
                            .addComponent(button3)
                            .addGap(32, 32, 32))
                        .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(label3)
                            .addGap(18, 18, 18)
                            .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(label4)
                                .addComponent(jtextCorreo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                            .addGap(18, 18, 18)))
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label6)
                        .addComponent(label5)
                        .addComponent(jtextPass, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(button2)
                        .addComponent(button1))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                    .addComponent(label2, GroupLayout.PREFERRED_SIZE, 216, GroupLayout.PREFERRED_SIZE)
                    .addGap(22, 22, 22))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Bryan
    private JLabel label2;
    private JLabel label3;
    private JLabel label4;
    private JLabel label5;
    private JTextField jtextCorreo;
    private JTextField jtextPass;
    private JButton button1;
    private JLabel label6;
    private JButton button2;
    private JButton button3;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
