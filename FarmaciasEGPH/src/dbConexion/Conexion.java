package dbConexion;

import Consultas.Procesos;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    private Connection conexion;
    Procesos obj= new Procesos();

    public Connection getConexion() {
        return conexion;
    }

    public void conectarDb(){
        LeerXml objXml = new LeerXml();
        try {
            objXml.datosXML();
        }catch (Exception ex){
            obj.impresionDialogo("Error al conectarse[Comuniquese con Tecnología]","Error en Conexión",0);
        }
        String dbUrl= "jdbc:sqlserver://"+objXml.getServerName()+":"+objXml.getPuerto()+";databaseName="+objXml.getDbName()+";user="+objXml.getUsuario()+";password="+objXml.getPass()+";encrypt=true;trustServerCertificate=true;" ;
        try {
            conexion= DriverManager.getConnection(dbUrl);
            //obj.impresionDialogo("Conexion Realizada ","Conexión",1);
            System.out.println("Conexion Realizada");

        }catch (SQLException e){
            System.out.println(e.getMessage());
            obj.impresionDialogo("Error al conectarse[Comuniquese con Tecnología]","Error en Conexión",0);
        }
    }

    public void desconectarDb(){
        try {
            conexion.close();
        } catch (SQLException e) {
            //throw new RuntimeException(e);
            obj.impresionDialogo("Error [Comuniquese con Tecnología]","Error",0);
        }
    }




}
