package Consultas;

import dbConexion.Conexion;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;

import com.itextpdf.text.Document;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.FileOutputStream;
import java.util.ArrayList;

public class Consultas {
    Procesos obj = new Procesos();

    public DefaultTableModel consultaFacturas(String dato){
        Document documento = new Document();
        String path="C:/FARMACIAEGPH/Reportes/Factura_", ext=".pdf";
        String s=path+dato+ext;
        DefaultTableModel datoConsulta = new DefaultTableModel();
        String sql;
        String titulos[]={"No Factura","Nombre","Total"};
        datoConsulta=new DefaultTableModel(null,titulos);
        try{
            Conexion conectar = new Conexion();
            conectar.conectarDb();

            String datos[]=new String[4];
            sql = " select a.num_factura, b.nombre, sum(c.cantidad*c.precio) as total ";
            sql +=" from  facturas as a inner join clientes b on a.id_cliente=b.id_cliente";
            sql +="  inner join detalle_facturas c on a.num_factura = c.num_factura";
            if (validartipo(dato)) {
                sql += " where a.num_factura=? ";
            } else {
                sql += " where a.fecha=? ";
            }
            sql +="GROUP BY a.num_factura, b.nombre";
            try{

                PreparedStatement pSt = conectar.getConexion().prepareStatement(sql,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
                pSt.setString(1,dato);

                ResultSet datosRespuesta=pSt.executeQuery();
                datosRespuesta.last();
                int filas=datosRespuesta.getRow();
                if (filas!=0){
                    PdfWriter.getInstance(documento, new FileOutputStream(s));
                    documento.open();
                    PdfPTable tabla = new PdfPTable(3);
                    tabla.addCell("No Factura");
                    tabla.addCell("Nombre");
                    tabla.addCell("Total");

                    datosRespuesta.beforeFirst();
                    while(datosRespuesta.next()){
                        datos[0]= datosRespuesta.getString("num_factura");
                        datos[1]= datosRespuesta.getString("nombre");
                        datos[2]= datosRespuesta.getString("total");

                        tabla.addCell(datosRespuesta.getString(1));
                        tabla.addCell(datosRespuesta.getString(2));
                        tabla.addCell(datosRespuesta.getString(3));

                        datoConsulta.addRow(datos);
                    }
                    documento.add(tabla);
                    documento.close();
                    datosRespuesta.close();
                    conectar.desconectarDb();
                    JOptionPane.showMessageDialog(null, "Reporte creado.");
                }else{
                    obj.impresionDialogo("No hay datos para la fecha/numero de factura","Sin Datos",1);
                }
            }catch (SQLException ex){
                obj.impresionDialogo("Error al Buscar [Comuniquese con Tecnología]","Error en Conexión",0);
            }
        }catch (Exception ex){
            obj.impresionDialogo("Error al conectarse[Comuniquese con Tecnología]","Error en Conexión",0);
        }

        return datoConsulta;
    }

    public DefaultTableModel consultaInventario(){
        Document documento = new Document();
        String path="C:/FARMACIAEGPH/Reportes/Inventario_Medicamentos.pdf";
        DefaultTableModel datoConsulta = new DefaultTableModel();
        String sql;
        String titulos[]={"ID Medicamento","Descripcion","Precio","Activo"};
        datoConsulta=new DefaultTableModel(null,titulos);
        try{
            Conexion conectar = new Conexion();
            conectar.conectarDb();

            String datos[]=new String[4];
            sql = " select * from medicamentos";
            try{
                PreparedStatement pSt = conectar.getConexion().prepareStatement(sql,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
                ResultSet datosRespuesta=pSt.executeQuery();
                datosRespuesta.last();
                int filas=datosRespuesta.getRow();
                if (filas!=0){
                    PdfWriter.getInstance(documento, new FileOutputStream(path));
                    documento.open();
                    PdfPTable tabla = new PdfPTable(4);
                    tabla.addCell("ID Medicamento");
                    tabla.addCell("Descripcion");
                    tabla.addCell("Precio");
                    tabla.addCell("Activo");

                    datosRespuesta.beforeFirst();
                    while(datosRespuesta.next()){
                        datos[0]= datosRespuesta.getString("id_medica");
                        datos[1]= datosRespuesta.getString("Descripcion");
                        datos[2]= datosRespuesta.getString("Precio");
                        datos[3]= datosRespuesta.getString("Activo");

                        tabla.addCell(datosRespuesta.getString(1));
                        tabla.addCell(datosRespuesta.getString(2));
                        tabla.addCell(datosRespuesta.getString(3));
                        tabla.addCell(datosRespuesta.getString(4));

                        datoConsulta.addRow(datos);
                    }
                    documento.add(tabla);
                    documento.close();
                    datosRespuesta.close();
                    conectar.desconectarDb();
                    JOptionPane.showMessageDialog(null, "Reporte creado.");
                }
                else{
                    obj.impresionDialogo("No hay inventario por el momento","Sin Medicamentos",1);
                }
            }catch (SQLException ex){
                obj.impresionDialogo("Error al verficar inventario [Comuniquese con Tecnología]","Error en Conexión",0);
            }
        }catch (Exception ex){
            obj.impresionDialogo("Error al conectarse[Comuniquese con Tecnología]","Error en Conexión",0);
        }

        return datoConsulta;
    }

    public DefaultTableModel consultaClientes(){
        Document documento = new Document();
        String path="C:/FARMACIAEGPH/Reportes/Clientes.pdf";
        DefaultTableModel datoConsulta = new DefaultTableModel();
        String sql;
        String titulos[]={"ID Cliente","Nombre","Direccion","Telefono Movil","Fecha de nacimiento"};
        datoConsulta=new DefaultTableModel(null,titulos);
        try{
            Conexion conectar = new Conexion();
            conectar.conectarDb();

            String datos[]=new String[5];
            sql = " select * from clientes";
            try{
                PreparedStatement pSt = conectar.getConexion().prepareStatement(sql,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);

                ResultSet datosRespuesta=pSt.executeQuery();
                datosRespuesta.last();

                int filas=datosRespuesta.getRow();
                if (filas!=0){
                    PdfWriter.getInstance(documento, new FileOutputStream(path));
                    documento.open();
                    PdfPTable tabla = new PdfPTable(5);
                    tabla.addCell("ID Cliente");
                    tabla.addCell("Nombre");
                    tabla.addCell("Direccion");
                    tabla.addCell("Telefono Movil");
                    tabla.addCell("Fecha de nacimiento");

                    datosRespuesta.beforeFirst();
                    while(datosRespuesta.next()){
                        datos[0]= datosRespuesta.getString("id_cliente");
                        datos[1]= datosRespuesta.getString("Nombre");
                        datos[2]= datosRespuesta.getString("Direccion");
                        datos[3]= datosRespuesta.getString("Telefono_Movil");
                        datos[4]= datosRespuesta.getString("Fecha_de_nacimiento");

                        tabla.addCell(datosRespuesta.getString(1));
                        tabla.addCell(datosRespuesta.getString(2));
                        tabla.addCell(datosRespuesta.getString(3));
                        tabla.addCell(datosRespuesta.getString(4));
                        tabla.addCell(datosRespuesta.getString(5));

                        datoConsulta.addRow(datos);
                    }
                    documento.add(tabla);
                    documento.close();
                    datosRespuesta.close();
                    conectar.desconectarDb();
                    JOptionPane.showMessageDialog(null, "Reporte creado.");
                }else{
                    obj.impresionDialogo("No hay clientes registrados","Sin Clientes",1);
                }
            }catch (SQLException ex){
                obj.impresionDialogo("Error al verficar los clientes [Comuniquese con Tecnología]","Error en Conexión",0);
            }
        }catch (Exception ex){
            obj.impresionDialogo("Error al conectarse[Comuniquese con Tecnología]","Error en Conexión",0);
        }

        return datoConsulta;
    }

    public int ValidarUsuario(String correo, String pass){//1= inicio false, 2=exception, 3=bloqueo, 4= inicio true
        int back=0;
        try{
            Conexion conectar = new Conexion();
            conectar.conectarDb();
            String sql="Select * from clientes where Correo = '"+correo+"'";
            PreparedStatement pt;

            try {
                pt = conectar.getConexion().prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
                pt.executeQuery();
                ResultSet medi = pt.executeQuery();
                medi.last();
                int filas = medi.getRow();
                medi.beforeFirst();
                medi.next();
                if (filas != 0) {
                    medi.close();
                    String sql2="select Intentos from  clientes where correo='"+correo+"' GROUP BY Intentos";
                    try{
                        pt = conectar.getConexion().prepareStatement(sql2, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
                        pt.executeQuery();
                        ResultSet nombre=pt.executeQuery();
                        nombre.beforeFirst();
                        nombre.next();
                        if(nombre.getInt("Intentos")>=3){
                            obj.impresionDialogo("Usuario Bloqueado [Comuniquese con Tecnología]", "Usuario Bloqueado", 0);
                            back=3;
                            return back;
                        }
                        nombre.close();
                    }catch (Exception e) {
                        obj.impresionDialogo("Error al conectarse bloqueo [Comuniquese con Tecnología]", "Error en Conexión", 0);
                        back=2;
                        return back;
                    }

                    //verificar correo y pass
                    String sql4="select Password from  clientes where Correo='"+correo+"' GROUP BY Password";
                    try{
                        String datos[]=new String[1];
                        pt = conectar.getConexion().prepareStatement(sql4, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
                        pt.executeQuery();
                        ResultSet nombre=pt.executeQuery();
                        nombre.beforeFirst();
                        nombre.next();
                        datos[0]=nombre.getString("Password");
                        if(!pass.equals(datos[0])){
                            obj.impresionDialogo("Correo o Contraseña incorrectos", "Datos Incorrectos", 0);
                            int num=1;
                            BloquearCuenta(correo,num);
                            back=1;
                            return back;
                        }
                        nombre.close();
                    }catch (Exception e) {
                        obj.impresionDialogo("Error al conectarse incorrecto [Comuniquese con Tecnología]", "Error en Conexión", 0);
                        back=2;
                        return back;}

                            String sql3 = "select Nombre from  clientes where correo='" + correo + "' GROUP BY nombre";
                            PreparedStatement px;
                            String nomb[] = new String[1];
                            try {
                                px = conectar.getConexion().prepareStatement(sql3, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
                                px.executeQuery();
                                ResultSet nombre = px.executeQuery();
                                String nom = "Bienvenido ";
                                nombre.beforeFirst();
                                nombre.next();
                                nomb[0] = nombre.getString("Nombre");
                                nom += nomb[0];
                                obj.impresionDialogo(nom, "Usuario y Contraseña correctos", 1);
                                int num=0;
                                BloquearCuenta(correo,num);
                                conectar.desconectarDb();
                                nombre.close();
                                back = 4;
                                return back;
                            } catch (Exception e) {
                                obj.impresionDialogo("Error al conectarse correcto [Comuniquese con Tecnología]", "Error en Conexión", 0);
                                back = 2;
                                return back;
                            }


                } else {
                        obj.impresionDialogo("Correo no encontrado", "Correo Incorrecto", 0);
                    back=2;
                    return back;
                }

            } catch (Exception e) {
                obj.impresionDialogo("Error al conectarse [Comuniquese con Tecnología]", "Error en Conexión", 0);
                back=2;
                return back;
            }
        }catch (Exception e) {
            obj.impresionDialogo("Error al ejecutar comando[Comuniquese con Tecnología]", "Error en Conexión", 0);
            back=2;
            return back;
        }
    }

    public void BloquearCuenta(String correo, int num){
        int intentos=1;
        if(num==1){
        try{
            Conexion conectar = new Conexion();
            conectar.conectarDb();
            String sql2 ="select Intentos from clientes where correo = '"+correo+"'";
            PreparedStatement ps;
            PreparedStatement pt;
            try {

                pt = conectar.getConexion().prepareStatement(sql2, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
                pt.executeQuery();
                ResultSet intento = pt.executeQuery();
                intento.beforeFirst();
                intento.next();
                intentos+=intento.getInt("Intentos");
                String sql ="update clientes set Intentos = "+intentos+" where correo = '"+correo+"'";
                ps = conectar.getConexion().prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
                ps.executeUpdate();

                conectar.desconectarDb();
            }catch (SQLException e){
                obj.impresionDialogo("Error al bloquear Usuario set+1","Error ",0);
            }

        }catch (Exception e){
            obj.impresionDialogo("Error al conectarse[Comuniquese con Tecnología]","Error en Conexión",0);
        }
        }
        else{
            try{
                Conexion conectar = new Conexion();
                conectar.conectarDb();
                String sql ="update clientes set Intentos = 0 where correo = '"+correo+"'";
                PreparedStatement ps;
                try {
                    ps = conectar.getConexion().prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
                    ps.executeUpdate();
                    conectar.desconectarDb();
                }catch (SQLException e){
                    obj.impresionDialogo("Error al bloquear Usuario set 0","Error ",0);
                }

            }catch (Exception e){
                obj.impresionDialogo("Error al conectarse[Comuniquese con Tecnología]","Error en Conexión",0);
            }
        }
    }

    public String[] DatosFactura(String IDmed, String cantidad){
        String sql;
        String datos[]=new String[5];

        try{
            Conexion conectar = new Conexion();
            conectar.conectarDb();

            sql = " select * from medicamentos where id_medica = "+IDmed;
            PreparedStatement pSt;
            try{

                pSt = conectar.getConexion().prepareStatement(sql,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);

                ResultSet datosRespuesta=pSt.executeQuery();
                datosRespuesta.last();
                int filas=datosRespuesta.getRow();
                if (filas!=0){

                        datos[0]= datosRespuesta.getString("Descripcion");
                        datos[1]=datosRespuesta.getString("id_medica");
                        datos[2]= cantidad;
                        datos[3]= datosRespuesta.getString("Precio");
                        double costo = (datosRespuesta.getDouble("Precio"))*Integer.parseInt(cantidad);
                        double costo2 = Math.round(costo*100.0)/100.0;
                        datos[4]= String.valueOf(costo2);

                    datosRespuesta.close();
                    conectar.desconectarDb();

                }else{
                    obj.impresionDialogo("El ID de medicamento NO EXISTE","ERROR ID",1);
                    datos=null;
                }
            }catch (SQLException ex){
                obj.impresionDialogo("Error al Buscar [Comuniquese con Tecnología]","Error en Conexión",0);
            }
        }catch (Exception ex){
            obj.impresionDialogo("Error al conectarse[Comuniquese con Tecnología]","Error en Conexión",0);
        }
        return datos;
    }

    public String id_cliente(String correo){
        String sql, idcl="";
        try{
            Conexion conectar = new Conexion();
            conectar.conectarDb();
            sql = " select id_cliente from clientes where Correo = '"+correo+"'";
            PreparedStatement pSt;
            try{
                pSt = conectar.getConexion().prepareStatement(sql,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
                ResultSet datosRespuesta=pSt.executeQuery();
                datosRespuesta.last();
                idcl=datosRespuesta.getString("id_cliente");

            }catch (SQLException ex){
                obj.impresionDialogo("Error al Buscar [Comuniquese con Tecnología]","Error en Conexión",0);
            }
        }catch (Exception ex){
            obj.impresionDialogo("Error al conectarse[Comuniquese con Tecnología]","Error en Conexión",0);
        }
        return idcl;
    }

    private boolean validartipo(String dato) {
            try {
                int sum=Integer.valueOf(dato)-1;
            } catch (Exception e) {
                return false;
            }
            return true;
    }

}
