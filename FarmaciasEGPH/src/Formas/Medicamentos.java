/*
 * Created by JFormDesigner on Mon Jul 11 12:48:36 COT 2022
 */

package Formas;

import Consultas.Procesos;
import Inserciones.InsertarTablas;

import java.awt.event.*;
import javax.swing.*;
import javax.swing.GroupLayout;

/**
 * @author Bryan
 */
public class Medicamentos extends JFrame {
    public Medicamentos() {
        initComponents();
        this.setTitle("Registrar Medicamento");
    }

    Procesos obj = new Procesos();
    private void jtextPrecioKeyTyped(KeyEvent e) {
        // TODO add your code here
        char digito = e.getKeyChar();
        if((digito<'0' || digito > '9') && digito !='.'){
            e.consume();
        }
    }

    private void button1(ActionEvent e) {
        // TODO add your code here
        if (!jtextNombreMedi.getText().equals("") && !jtextPrecio.getText().equals("")){
            InsertarTablas objInsertar = new InsertarTablas();
            jtextIdMedi.setText(Integer.toString(objInsertar.registarMedicamentos(jtextNombreMedi.getText(), Double.parseDouble(jtextPrecio.getText()))));
        }
        else{
            obj.impresionDialogo("Uno de los datos esta vacio, rellena los datos e intentalo de nuevo","ERROR NO DATA",0);
        }
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
        label1 = new JLabel();
        jtextIdMedi = new JTextField();
        label2 = new JLabel();
        jtextNombreMedi = new JTextField();
        label3 = new JLabel();
        jtextPrecio = new JTextField();
        button1 = new JButton();
        label4 = new JLabel();
        button2 = new JButton();

        //======== this ========
        var contentPane = getContentPane();

        //---- label1 ----
        label1.setText("ID");

        //---- jtextIdMedi ----
        jtextIdMedi.setEditable(false);

        //---- label2 ----
        label2.setText("Nombre del Medicamento");

        //---- label3 ----
        label3.setText("Precio");

        //---- jtextPrecio ----
        jtextPrecio.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                jtextPrecioKeyTyped(e);
            }
        });

        //---- button1 ----
        button1.setText("Registrar");
        button1.addActionListener(e -> button1(e));

        //---- label4 ----
        label4.setText("text");
        label4.setIcon(new ImageIcon("C:\\Logo EGHP.png"));

        //---- button2 ----
        button2.setIcon(new ImageIcon("C:\\Home.png"));
        button2.addActionListener(e -> button2(e));

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                            .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(label4, GroupLayout.PREFERRED_SIZE, 201, GroupLayout.PREFERRED_SIZE))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGroup(contentPaneLayout.createParallelGroup()
                                .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addGap(23, 23, 23)
                                    .addGroup(contentPaneLayout.createParallelGroup()
                                        .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                                            .addComponent(label1)
                                            .addGap(37, 37, 37))
                                        .addGroup(contentPaneLayout.createSequentialGroup()
                                            .addGroup(contentPaneLayout.createParallelGroup()
                                                .addComponent(label2)
                                                .addComponent(button2, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE))
                                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED))))
                                .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                                    .addContainerGap()
                                    .addComponent(label3)
                                    .addGap(18, 18, 18)))
                            .addGroup(contentPaneLayout.createParallelGroup()
                                .addComponent(jtextIdMedi, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
                                .addComponent(jtextNombreMedi, GroupLayout.PREFERRED_SIZE, 271, GroupLayout.PREFERRED_SIZE)
                                .addComponent(jtextPrecio, GroupLayout.PREFERRED_SIZE, 131, GroupLayout.PREFERRED_SIZE))
                            .addGap(0, 61, Short.MAX_VALUE)))
                    .addContainerGap())
                .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                    .addGap(0, 192, Short.MAX_VALUE)
                    .addComponent(button1)
                    .addGap(241, 241, 241))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(label4))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(16, 16, 16)
                            .addComponent(button2)))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(jtextIdMedi, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(label1))
                    .addGap(72, 72, 72)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addComponent(label2)
                        .addComponent(jtextNombreMedi, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(28, 28, 28)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(jtextPrecio, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(label3))
                    .addGap(26, 26, 26)
                    .addComponent(button1)
                    .addContainerGap(48, Short.MAX_VALUE))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Bryan
    private JLabel label1;
    private JTextField jtextIdMedi;
    private JLabel label2;
    private JTextField jtextNombreMedi;
    private JLabel label3;
    private JTextField jtextPrecio;
    private JButton button1;
    private JLabel label4;
    private JButton button2;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
