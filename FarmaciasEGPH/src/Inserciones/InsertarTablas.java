package Inserciones;


import Consultas.Procesos;
import Formas.Comprar;
import dbConexion.Conexion;
import javax.swing.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class InsertarTablas {
    Procesos obj = new Procesos();

    public int registarMedicamentos(String nombreMedica, double precio) {

        int idMedica = 0;
        int enc = 0;
        try{
        Conexion conectar = new Conexion();
        conectar.conectarDb();
        String sql2 = "SELECT Descripcion from medicamentos where Descripcion LIKE '%";
        sql2+=nombreMedica;
        sql2+="%'";
        PreparedStatement pt;

        try {
            pt = conectar.getConexion().prepareStatement(sql2, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            pt.executeQuery();
            ResultSet medi = pt.executeQuery();


            medi.last();
            int filas = medi.getRow();
            if (filas != 0) {
                enc = 1;
                medi.close();
                conectar.desconectarDb();
                obj.impresionDialogo("Medicamento ya existente", "ERROR", 0);
            } else {
                enc = 2;
            }

        } catch (Exception e) {
            obj.impresionDialogo("Error al conectarse[Comuniquese con Tecnología]", "Error en Conexión", 0);
        }
    }catch (Exception e) {
            obj.impresionDialogo("Error al ejecutar comando[Comuniquese con Tecnología]", "Error en Conexión", 0);
        }

        if (enc == 2) {
            try{
                Conexion conectar = new Conexion();
                conectar.conectarDb();
                String sql=" Insert into medicamentos (Descripcion,Precio) VALUES (?,?)";
                PreparedStatement ps;
                try {
                    ps = conectar.getConexion().prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
                    ps.setString(1,nombreMedica);
                    ps.setDouble(2,precio);
                    ps.executeUpdate();
                    ResultSet rsLlave = ps.getGeneratedKeys();
                    rsLlave.next();
                    idMedica=rsLlave.getInt(1);
                    obj.impresionDialogo("Medicamento Registrado Correctamente ","Medicamentos",1);
                    rsLlave.close();
                    conectar.desconectarDb();
                }catch (SQLException e){
                    obj.impresionDialogo("Error al Registar medicamentos","Error ",0);
                }

            }catch (Exception e){
                obj.impresionDialogo("Error al conectarse[Comuniquese con Tecnología]","Error en Conexión",0);
            }
    }
        return idMedica;
    }

    public void RegistrarCatalogo(ArrayList data){
        try{
            Conexion conectar = new Conexion();
            conectar.conectarDb();
            PreparedStatement ps;
            try {
                for(int i=0;i< data.size();i=i+4) {
                    String sql = " Insert into medicamentos (Descripcion,Precio) VALUES ('";
                    sql+=data.get(i+1)+"',";
                    sql+=data.get(i+2)+")";
                    ps = conectar.getConexion().prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

                    ps.executeUpdate();
                    sql="";
                }
                obj.impresionDialogo("El catalogo ha sido importado exitosamente","Catalogo Importado",1);
                conectar.desconectarDb();
            }catch (SQLException e){
                obj.impresionDialogo("Error al Importar Catalogo","Error ",0);
            }

        }catch (Exception e){
            obj.impresionDialogo("Error al conectarse[Comuniquese con Tecnología]","Error en Conexión",0);
        }
    }

    public void CrearUsuario(String nombre, String direccion, String correo, String telefono, String fecha, String pass){

        int enc = 0;
        try{
            Conexion conectar = new Conexion();
            conectar.conectarDb();
            String sql2 = "SELECT Correo from clientes where Correo LIKE '%";
            sql2+=correo;
            sql2+="%'";
            PreparedStatement pt;

            try {
                pt = conectar.getConexion().prepareStatement(sql2, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
                pt.executeQuery();
                ResultSet medi = pt.executeQuery();

                medi.last();
                int filas = medi.getRow();
                if (filas != 0) {
                    enc = 1;
                    medi.close();
                    conectar.desconectarDb();
                    obj.impresionDialogo("Usuario ya existente", "ERROR Usuario Existente", 0);
                } else {
                    enc = 2;
                }

            } catch (Exception e) {
                obj.impresionDialogo("Error al conectarse[Comuniquese con Tecnología]", "Error en Conexión", 0);
            }
        }catch (Exception e) {
            obj.impresionDialogo("Error al ejecutar comando[Comuniquese con Tecnología]", "Error en Conexión", 0);
        }

    if(enc==2){
        try{
            Conexion conectar = new Conexion();
            conectar.conectarDb();
            String sql ="insert into clientes (Nombre, Direccion, Correo, Telefono_Movil, Fecha_de_nacimiento, Password) values('"+nombre+"','"+direccion+"','"+correo+"','"+telefono+"','"+fecha+"','"+pass+"')";
            PreparedStatement ps;
            try {
                    ps = conectar.getConexion().prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
                    ps.executeUpdate();

                    obj.impresionDialogo("Usuario creado correctamente!","Nuevo Usuario Creado",1);
                    conectar.desconectarDb();
            }catch (SQLException e){
                obj.impresionDialogo("Error al Crear Usuario","Error ",0);
            }

        }catch (Exception e){
            obj.impresionDialogo("Error al conectarse[Comuniquese con Tecnología]","Error en Conexión",0);
            }
        }

    }

    public void RegistrarFacturas(String id_cliente){
        try{
            Conexion conectar = new Conexion();
            conectar.conectarDb();
            String sql ="insert into facturas(id_cliente) values("+id_cliente+")";
            PreparedStatement ps;
            try {
                ps = conectar.getConexion().prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
                ps.executeUpdate();
                obj.impresionDialogo("Factura registrada correctamente!","Factura Registrada",1);
                conectar.desconectarDb();
            }catch (SQLException e){
                obj.impresionDialogo("Error al Registrar Factura","Error ",0);
            }

        }catch (Exception e){
            obj.impresionDialogo("Error al conectarse[Comuniquese con Tecnología]","Error en Conexión",0);
        }
    }

    public void RegistrarDetalleFacturas(String id_med, String cantidad, String precio, String detalle){
        Conexion conectar = new Conexion();
        conectar.conectarDb();
        PreparedStatement ps;
        String consulta="";
        String sql2="select num_factura, fechaCreacion from facturas order by fechaCreacion desc";
        try {
            ps = conectar.getConexion().prepareStatement(sql2, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ps.executeQuery();
            ResultSet datosconsulta = ps.executeQuery();
            datosconsulta.beforeFirst();
            datosconsulta.next();
            consulta=datosconsulta.getString("num_factura");
            Comprar.numfac=consulta;
        }catch (SQLException e){
            obj.impresionDialogo("Error al Buscar Fecha","Error ",0);
        }

        String sql="insert into detalle_facturas(num_factura,num_detalle,medicamento,cantidad,precio) values("+consulta+","+detalle+","+id_med+","+cantidad+","+precio+")";
        try {
            ps = conectar.getConexion().prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ps.executeUpdate();
            conectar.desconectarDb();
        }catch (SQLException e){
            obj.impresionDialogo("Error al Registrar Factura","Error ",0);
        }
    }
}
