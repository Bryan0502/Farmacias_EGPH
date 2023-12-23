/*
 * Created by JFormDesigner on Sun Jul 24 12:40:03 COT 2022
 */

package Formas;

import Consultas.Consultas;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.*;
import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.table.DefaultTableModel;

import Consultas.Consultas;
import Consultas.Procesos;
import Inicio_Sesion.Bienvenida;
import Inserciones.InsertarTablas;

/**
 * @author Bryan
 */
public class Comprar extends JFrame {

    public static String CorreoCliente;
    private String id_cliente;
    public static String numfac;
    DefaultTableModel modelo = new DefaultTableModel();
    Procesos obj = new Procesos();
    Consultas objConsulta= new Consultas();

    public Comprar() {
        initComponents();
        this.setTitle("Comprar Productos");
        JTableDatos();
    }

    public DefaultTableModel JTableDatos(){

        String titulos[]={"Nombre","ID","Cantidad","Precio","Total"};
        modelo=new DefaultTableModel(null,titulos);
        JTableDatos.setModel(modelo);
        return modelo;
    }

    private void button3(ActionEvent e) {
        // TODO add your code here
        Inicio frame = new Inicio();
        frame.setVisible(true);
        dispose();
    }

    private void button1(ActionEvent e) {//agregar producto a la tabla
        // TODO add your code here
        if(!JtextID.getText().equals("") && !JtextCant.getText().equals("")){
            String id=JtextID.getText();
            String cantidad=JtextCant.getText();
            String datos[];
            datos=objConsulta.DatosFactura(id,cantidad);
            if(datos==null){
            }else{modelo.addRow(datos);}
        }else{
            obj.impresionDialogo("Uno de los campos esta en blanco ","Sin Datos",1);
        }
    }

    private void button2(ActionEvent e) {//borrar datos de la tabla
        // TODO add your code here
        if(JTableDatos.getSelectedRow() != -1){
            modelo.removeRow(JTableDatos.getSelectedRow());
        }else{
            obj.impresionDialogo("No ha seleccionado ningun producto de la tabla","ERROR SELECCION",1);
        }
    }

    private void button4(ActionEvent e) {
        // TODO add your code here
        try {
            obj.crearcarpeta("C:/FARMACIAEGPH/Facturas_Enviadas_GMAIL");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        ArrayList<String> datoscorreo = new ArrayList<String>();
        ArrayList<String> datostabla = new ArrayList<String>();

        if(JTableDatos.getRowCount()!=0) {
            InsertarTablas objInsertar = new InsertarTablas();
            id_cliente = objConsulta.id_cliente(CorreoCliente);
            objInsertar.RegistrarFacturas(id_cliente);

            for (int i = 0; i < JTableDatos.getRowCount(); i++) {
                for (int j = 0; j < JTableDatos.getColumnCount(); j = j + 5) {
                    String id_med = String.valueOf(JTableDatos.getValueAt(i, j + 1));
                    String cantidad = String.valueOf(JTableDatos.getValueAt(i, j + 2));
                    String precio = String.valueOf(JTableDatos.getValueAt(i, j + 3));
                    String detalle = String.valueOf(i + 1);
                    objInsertar.RegistrarDetalleFacturas(id_med, cantidad, precio, detalle);

                    datostabla.add(String.valueOf(JTableDatos.getValueAt(i,j)));
                    datostabla.add(String.valueOf(JTableDatos.getValueAt(i,j+1)));
                    datostabla.add(String.valueOf(JTableDatos.getValueAt(i,j+2)));
                    datostabla.add(String.valueOf(JTableDatos.getValueAt(i,j+3)));
                    datostabla.add(String.valueOf(JTableDatos.getValueAt(i,j+4)));

                }
            }
            try {
                datoscorreo = obj.FacturaEnviadaCorreo(numfac, datostabla);
            }catch(Exception ex){
                obj.impresionDialogo("No se crea el PDF","ERROR PDF",0);
            }
            int tipo=1;
            obj.EnviarCorreo(datoscorreo,tipo);

        }else{
            obj.impresionDialogo("No hay datos para facturar", "ERROR DATOS",0);
        }

    }

    private void JtextIDKeyTyped(KeyEvent e) {
        // TODO add your code here
        char digito = e.getKeyChar();
        if((digito<'0' || digito > '9')){
            e.consume();
        }
    }

    private void JtextCantKeyTyped(KeyEvent e) {
        // TODO add your code here
        char digito = e.getKeyChar();
        if((digito<'0' || digito > '9')){
            e.consume();
        }
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Bryan
        label1 = new JLabel();
        label2 = new JLabel();
        label3 = new JLabel();
        JtextID = new JTextField();
        JtextCant = new JTextField();
        button1 = new JButton();
        button2 = new JButton();
        label4 = new JLabel();
        button3 = new JButton();
        scrollPane1 = new JScrollPane();
        JTableDatos = new JTable();
        button4 = new JButton();

        //======== this ========
        var contentPane = getContentPane();

        //---- label1 ----
        label1.setText("Comprar Productos");

        //---- label2 ----
        label2.setText("ID de medicamento");

        //---- label3 ----
        label3.setText("Cantidad");

        //---- JtextID ----
        JtextID.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                JtextIDKeyTyped(e);
            }
        });

        //---- JtextCant ----
        JtextCant.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                JtextCantKeyTyped(e);
            }
        });

        //---- button1 ----
        button1.setText("Agregar Producto");
        button1.addActionListener(e -> button1(e));

        //---- button2 ----
        button2.setText("Eliminar Producto Seleccionado");
        button2.addActionListener(e -> button2(e));

        //---- label4 ----
        label4.setText("text");
        label4.setIcon(new ImageIcon("C:\\Logo EGHP.png"));

        //---- button3 ----
        button3.setIcon(new ImageIcon("C:\\Home.png"));
        button3.addActionListener(e -> button3(e));

        //======== scrollPane1 ========
        {
            scrollPane1.setViewportView(JTableDatos);
        }

        //---- button4 ----
        button4.setText("Hacer Factura");
        button4.addActionListener(e -> button4(e));

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(17, 17, 17)
                            .addComponent(button3, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(28, 28, 28)
                            .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addComponent(label3)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(JtextCant, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE))
                                .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addComponent(label2)
                                    .addGap(18, 18, 18)
                                    .addComponent(JtextID, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE))))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(129, 129, 129)
                            .addGroup(contentPaneLayout.createParallelGroup()
                                .addComponent(button1)
                                .addComponent(button2)
                                .addComponent(button4))))
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(49, 49, 49)
                            .addComponent(label1)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 262, Short.MAX_VALUE)
                            .addComponent(label4, GroupLayout.PREFERRED_SIZE, 201, GroupLayout.PREFERRED_SIZE))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(35, 35, 35)
                            .addComponent(scrollPane1, GroupLayout.DEFAULT_SIZE, 581, Short.MAX_VALUE)))
                    .addContainerGap())
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(17, 17, 17)
                            .addGroup(contentPaneLayout.createParallelGroup()
                                .addComponent(label1)
                                .addComponent(button3, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)))
                        .addComponent(label4))
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(19, 19, 19)
                            .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(label2)
                                .addComponent(JtextID, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                            .addGap(18, 18, 18)
                            .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(label3)
                                .addComponent(JtextCant, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                            .addGap(45, 45, 45)
                            .addComponent(button1)
                            .addGap(18, 18, 18)
                            .addComponent(button2)
                            .addGap(57, 57, 57)
                            .addComponent(button4))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 400, GroupLayout.PREFERRED_SIZE)))
                    .addContainerGap(80, Short.MAX_VALUE))
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
    private JTextField JtextID;
    private JTextField JtextCant;
    private JButton button1;
    private JButton button2;
    private JLabel label4;
    private JButton button3;
    private JScrollPane scrollPane1;
    private JTable JTableDatos;
    private JButton button4;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
