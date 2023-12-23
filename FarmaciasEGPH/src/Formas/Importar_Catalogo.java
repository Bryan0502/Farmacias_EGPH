/*
 * Created by JFormDesigner on Mon Jul 11 11:46:51 COT 2022
 */

package Formas;

import Consultas.Procesos;

import java.awt.event.*;
import javax.swing.*;
import javax.swing.GroupLayout;

/**
 * @author Bryan
 */
public class Importar_Catalogo extends JFrame {
    public Importar_Catalogo() {
        initComponents();
        this.setTitle("Importar Catalogo");
    }

    Procesos obj = new Procesos();
    private void button2(ActionEvent e) {//buscar csv
        // TODO add your code here
        JFileChooser j = new JFileChooser();
        j.showOpenDialog(j);
        csvPath.setText(j.getSelectedFile().getAbsolutePath());
    }

    private void button3(ActionEvent e) {//Importar txt
        // TODO add your code here
        if(!txtPath.getText().equals("")){
            String path, tipo="txt";
            path=txtPath.getText();
            obj.ImportarCatalogo(path,tipo);
        }else{
            obj.impresionDialogo("La ruta del TXT esta en blanco ","Sin Datos",1);
        }


    }

    private void button5(ActionEvent e) {//buscar txt
        // TODO add your code here
        JFileChooser j = new JFileChooser();
        j.showOpenDialog(j);
        txtPath.setText(j.getSelectedFile().getAbsolutePath());
    }

    private void button1(ActionEvent e) {//Importar csv
        // TODO add your code here
        if(!csvPath.getText().equals("")){
            String path,tipo="csv";
            path=csvPath.getText();
            obj.ImportarCatalogo(path,tipo);
        }else{
            obj.impresionDialogo("La ruta del CSV esta en blanco ","Sin Datos",1);
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
        label1 = new JLabel();
        label3 = new JLabel();
        label2 = new JLabel();
        button2 = new JButton();
        csvPath = new JTextField();
        label4 = new JLabel();
        label5 = new JLabel();
        button3 = new JButton();
        txtPath = new JTextField();
        button1 = new JButton();
        button4 = new JButton();
        button5 = new JButton();

        //======== this ========
        var contentPane = getContentPane();

        //---- label1 ----
        label1.setText("Importar Catalogo");

        //---- label3 ----
        label3.setText("text");
        label3.setIcon(new ImageIcon("C:\\Logo EGHP.png"));

        //---- label2 ----
        label2.setText("Elige el archivo y metodo de importacion:");

        //---- button2 ----
        button2.setText("Buscar");
        button2.addActionListener(e -> button2(e));

        //---- label4 ----
        label4.setText("Archivo TXT");

        //---- label5 ----
        label5.setText("Archivo CSV");

        //---- button3 ----
        button3.setText("Importar TXT");
        button3.addActionListener(e -> button3(e));

        //---- button1 ----
        button1.setText("Importar CSV");
        button1.addActionListener(e -> button1(e));

        //---- button4 ----
        button4.setIcon(new ImageIcon("C:\\Home.png"));
        button4.addActionListener(e -> button4(e));

        //---- button5 ----
        button5.setText("Buscar");
        button5.addActionListener(e -> button5(e));

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(button4, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE)
                            .addGap(191, 191, 191)
                            .addComponent(label1)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(label3, GroupLayout.PREFERRED_SIZE, 201, GroupLayout.PREFERRED_SIZE))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGroup(contentPaneLayout.createParallelGroup()
                                .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addGap(45, 45, 45)
                                    .addComponent(label2))
                                .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addContainerGap()
                                    .addComponent(label4)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtPath, GroupLayout.PREFERRED_SIZE, 314, GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(button5))
                                .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addContainerGap()
                                    .addComponent(label5)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(csvPath, GroupLayout.PREFERRED_SIZE, 314, GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(button2))
                                .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addGap(57, 57, 57)
                                    .addComponent(button3)
                                    .addGap(113, 113, 113)
                                    .addComponent(button1)))
                            .addGap(0, 0, Short.MAX_VALUE)))
                    .addContainerGap())
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(19, 19, 19)
                            .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(label1)
                                .addComponent(button4)))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(label3)))
                    .addGap(35, 35, 35)
                    .addComponent(label2)
                    .addGap(38, 38, 38)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label4)
                        .addComponent(txtPath, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(button5))
                    .addGap(39, 39, 39)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label5)
                        .addComponent(csvPath, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(button2))
                    .addGap(39, 39, 39)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(button3)
                        .addComponent(button1))
                    .addContainerGap(74, Short.MAX_VALUE))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Bryan
    private JLabel label1;
    private JLabel label3;
    private JLabel label2;
    private JButton button2;
    private JTextField csvPath;
    private JLabel label4;
    private JLabel label5;
    private JButton button3;
    private JTextField txtPath;
    private JButton button1;
    private JButton button4;
    private JButton button5;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
