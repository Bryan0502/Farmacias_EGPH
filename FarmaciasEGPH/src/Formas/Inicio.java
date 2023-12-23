/*
 * Created by JFormDesigner on Mon Jul 11 04:19:06 COT 2022
 */

package Formas;

import Consultas.Procesos;
import Inicio_Sesion.Bienvenida;
import dbConexion.Conexion;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import javax.swing.*;
import javax.swing.GroupLayout;

/**
 * @author Bryan
 */
public class Inicio extends JFrame {

    Procesos obj = new Procesos();

    public Inicio() {
        initComponents();
        this.setTitle("Inicio");
    }

    private void menuItem1(ActionEvent e) {//comprar medicamento
        // TODO add your code here
        Comprar frame = new Comprar();
        frame.setVisible(true);
        dispose();
    }

    private void menuItem2(ActionEvent e) {//registrar medicamento
        // TODO add your code here
        Medicamentos frame = new Medicamentos();
        frame.setVisible(true);
        dispose();
    }

    private void menuItem3(ActionEvent e) {//ver reporte de inventario
        // TODO add your code here
        try {
            obj.crearcarpeta("C:/FARMACIAEGPH/Reportes");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        Inventario frame = new Inventario();
        frame.setVisible(true);
        dispose();
    }

    private void menuItem4(ActionEvent e) {//ver reporte de clientes
        // TODO add your code here
        try {
            obj.crearcarpeta("C:/FARMACIAEGPH/Reportes");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        Clientes frame = new Clientes();
        frame.setVisible(true);
        dispose();
    }

    private void menuItem5(ActionEvent e) {//ver reporte de facturas
        // TODO add your code here
        try {
            obj.crearcarpeta("C:/FARMACIAEGPH/Reportes");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        Facturacion frame = new Facturacion();
        frame.setVisible(true);
        dispose();
    }

    private void menuItem6(ActionEvent e) {//importar catalogo
        // TODO add your code here
        Importar_Catalogo frame = new Importar_Catalogo();
        frame.setVisible(true);
        dispose();
    }

    private void menuItem7(ActionEvent e) {//exportar catalogo
        // TODO add your code here
        try {
            obj.crearcarpeta("C:/FARMACIAEGPH/Catalogo_Exportado");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        Exportar_Catalogo frame = new Exportar_Catalogo();
        frame.setVisible(true);
        dispose();
    }

    private void menuItem8(ActionEvent e) {//actualizar datos de clientes
        // TODO add your code here
        Datos_Clientes frame = new Datos_Clientes();
        frame.setVisible(true);
        dispose();
    }

    private void menuItem9(ActionEvent e) {//actualizar datos de medicamentos
        // TODO add your code here
        Datos_Medicamentos frame = new Datos_Medicamentos();
        frame.setVisible(true);
        dispose();
    }


    private void button2(ActionEvent e) {//volver al inicio
        // TODO add your code here
        Bienvenida frame = new Bienvenida();
        frame.setVisible(true);
        dispose();
    }


    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Bryan
        label3 = new JLabel();
        button2 = new JButton();
        menuBar1 = new JMenuBar();
        menu1 = new JMenu();
        menuItem1 = new JMenuItem();
        menu2 = new JMenu();
        menuItem2 = new JMenuItem();
        menu3 = new JMenu();
        menuItem3 = new JMenuItem();
        menuItem4 = new JMenuItem();
        menuItem5 = new JMenuItem();
        menu4 = new JMenu();
        menuItem6 = new JMenuItem();
        menuItem7 = new JMenuItem();
        menu5 = new JMenu();
        menuItem8 = new JMenuItem();
        menuItem9 = new JMenuItem();

        //======== this ========
        var contentPane = getContentPane();

        //---- label3 ----
        label3.setText("text");
        label3.setIcon(new ImageIcon("C:\\Logo EGHP.png"));

        //---- button2 ----
        button2.setText("Cerrar Sesion");
        button2.addActionListener(e -> button2(e));

        //======== menuBar1 ========
        {
            menuBar1.setMinimumSize(new Dimension(130, 22));
            menuBar1.setPreferredSize(new Dimension(130, 22));

            //======== menu1 ========
            {
                menu1.setText("Servicios");

                //---- menuItem1 ----
                menuItem1.setText("Comprar");
                menuItem1.addActionListener(e -> menuItem1(e));
                menu1.add(menuItem1);
            }
            menuBar1.add(menu1);

            //======== menu2 ========
            {
                menu2.setText("Registrar");
                menu2.setMinimumSize(new Dimension(65, 21));
                menu2.setPreferredSize(new Dimension(65, 21));

                //---- menuItem2 ----
                menuItem2.setText("Medicamentos");
                menuItem2.addActionListener(e -> menuItem2(e));
                menu2.add(menuItem2);
            }
            menuBar1.add(menu2);

            //======== menu3 ========
            {
                menu3.setText("Reportes");

                //---- menuItem3 ----
                menuItem3.setText("Ver Inventario");
                menuItem3.addActionListener(e -> menuItem3(e));
                menu3.add(menuItem3);

                //---- menuItem4 ----
                menuItem4.setText("Ver Clientes");
                menuItem4.addActionListener(e -> menuItem4(e));
                menu3.add(menuItem4);

                //---- menuItem5 ----
                menuItem5.setText("Ver Facturas");
                menuItem5.addActionListener(e -> menuItem5(e));
                menu3.add(menuItem5);
            }
            menuBar1.add(menu3);

            //======== menu4 ========
            {
                menu4.setText("Catalogo");

                //---- menuItem6 ----
                menuItem6.setText("Importar");
                menuItem6.addActionListener(e -> menuItem6(e));
                menu4.add(menuItem6);

                //---- menuItem7 ----
                menuItem7.setText("Exportar");
                menuItem7.addActionListener(e -> menuItem7(e));
                menu4.add(menuItem7);
            }
            menuBar1.add(menu4);

            //======== menu5 ========
            {
                menu5.setText("Actualizar Datos");

                //---- menuItem8 ----
                menuItem8.setText("Clientes");
                menuItem8.addActionListener(e -> menuItem8(e));
                menu5.add(menuItem8);

                //---- menuItem9 ----
                menuItem9.setText("Medicamentos");
                menuItem9.addActionListener(e -> menuItem9(e));
                menu5.add(menuItem9);
            }
            menuBar1.add(menu5);
        }

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addComponent(menuBar1, GroupLayout.PREFERRED_SIZE, 357, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 89, Short.MAX_VALUE)
                            .addComponent(label3, GroupLayout.PREFERRED_SIZE, 201, GroupLayout.PREFERRED_SIZE))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addContainerGap(544, Short.MAX_VALUE)
                            .addComponent(button2)))
                    .addGap(21, 21, 21))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                    .addGap(16, 16, 16)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addComponent(menuBar1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(label3))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 251, Short.MAX_VALUE)
                    .addComponent(button2)
                    .addGap(20, 20, 20))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Bryan
    private JLabel label3;
    private JButton button2;
    private JMenuBar menuBar1;
    private JMenu menu1;
    private JMenuItem menuItem1;
    private JMenu menu2;
    private JMenuItem menuItem2;
    private JMenu menu3;
    private JMenuItem menuItem3;
    private JMenuItem menuItem4;
    private JMenuItem menuItem5;
    private JMenu menu4;
    private JMenuItem menuItem6;
    private JMenuItem menuItem7;
    private JMenu menu5;
    private JMenuItem menuItem8;
    private JMenuItem menuItem9;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
