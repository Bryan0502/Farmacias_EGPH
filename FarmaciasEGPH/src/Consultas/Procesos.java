package Consultas;

import Inserciones.InsertarTablas;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import dbConexion.Conexion;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.*;
import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import static Formas.Comprar.CorreoCliente;


public class Procesos {
private BufferedReader lector;
public static String CorreoCliente2;
    public void ExportarCatalogo(String tipo){
        String path="C:/FARMACIAEGPH/Catalogo_Exportado/";
        String s;
        s=path+"Catalogo."+tipo;

        try{
            Conexion conectar = new Conexion();
            conectar.conectarDb();
            FileWriter writer = new FileWriter(s);
            List<String> datos = new ArrayList<String>();
            String sql = " select * from medicamentos";
            try{
                PreparedStatement pSt = conectar.getConexion().prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
                ResultSet datosRespuesta=pSt.executeQuery();
                datosRespuesta.last();
                int filas=datosRespuesta.getRow();
                if (filas!=0){
                    datosRespuesta.beforeFirst();
                    while(datosRespuesta.next()){
                        datos.clear();
                        datos.add(datosRespuesta.getString("id_medica"));
                        datos.add(datosRespuesta.getString("Descripcion"));
                        datos.add(datosRespuesta.getString("Precio"));
                        datos.add(datosRespuesta.getString("Activo"));
                        if(tipo=="csv"){
                        String collect = datos.stream().collect(Collectors.joining(";"));
                        writer.write(collect);}
                        else{
                            String collect = datos.stream().collect(Collectors.joining("~"));
                            writer.write(collect);}

                        writer.write("\n");
                    }

                    writer.close();
                    datosRespuesta.close();
                    conectar.desconectarDb();
                    JOptionPane.showMessageDialog(null, "El catalogo ha sido Exportado existosamente");
                }
                else{
                    impresionDialogo("No hay inventario por el momento","Sin Medicamentos",1);
                }
            }catch (SQLException ex){
                impresionDialogo("Error al exportar inventario [Comuniquese con Tecnología]","Error en Conexión",0);
            }
        }catch (Exception ex){
            impresionDialogo("Error al conectarse[Comuniquese con Tecnología]","Error en Conexión",0);
        }

    }

    public void ImportarCatalogo(String path, String tipo){
        String linea;
        String partes [] = null;
        ArrayList<String> dataCsv = new ArrayList<>();
        InsertarTablas obj = new InsertarTablas();

        try{
            lector = new BufferedReader(new FileReader(path));
            while ((linea = lector.readLine()) != null){

                if(tipo=="csv"){partes = linea.split(";");}
                else{partes = linea.split("~");}

                for(int i=0;i< partes.length;i++){
                    dataCsv.add(partes[i]);}

            }
            try{
                obj.RegistrarCatalogo(dataCsv);
            }catch(Exception e){
                impresionDialogo("Error al importar catalogo reigstro los datos","ERROR de Lectura",0);
            }

        }catch(Exception e){
            impresionDialogo("Error al leer los datos","ERROR de Lectura",0);
        }

    }

    public void ActualizarDatos(String busqueda, String info, String dato, String tipo){
        int enc=0;
        try{
            Conexion conectar = new Conexion();
            conectar.conectarDb();
            String sql2="Select";
            if(tipo=="cliente"){
                sql2+= " Correo from clientes where Correo LIKE '%";
                sql2+=busqueda;
                sql2+="%'";
            }
            else if(tipo=="medicamento"){
                sql2+= " id_medica from medicamentos where id_medica LIKE '%";
                sql2+=busqueda;
                sql2+="%'";
            }

            PreparedStatement pt;

            try {
                pt = conectar.getConexion().prepareStatement(sql2, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
                pt.executeQuery();
                ResultSet medi = pt.executeQuery();
                medi.last();
                int filas = medi.getRow();
                if (filas != 0) {
                    enc=1;
                    medi.close();
                    conectar.desconectarDb();
                    if(tipo=="cliente"){
                        impresionDialogo("Correo de usuario encontrado", "Correo Encontrado", 1);
                    }
                    else if(tipo=="medicamento"){
                        impresionDialogo("ID de Medicamento encontrado", "ID Encontrado", 1);
                    }
                } else {
                    enc=2;
                    if(tipo=="cliente"){
                        impresionDialogo("Correo de usuario no encontrado", "Correo Incorrecto", 0);
                    }
                    else if(tipo=="medicamento"){
                        impresionDialogo("ID de medicamento no encontrado", "ID Incorrecto", 0);
                    }

                }

            } catch (Exception e) {
                impresionDialogo("Error al conectarse [Comuniquese con Tecnología]", "Error en Conexión", 0);
            }
        }catch (Exception e) {
            impresionDialogo("Error al ejecutar comando[Comuniquese con Tecnología]", "Error en Conexión", 0);
        }

        if(enc==1){
            try{
                Conexion conectar = new Conexion();
                conectar.conectarDb();
                String sql="Update";
                if(info=="Descripcion"){
                    sql+=" medicamentos set "+info+" = '"+dato+"' where id_medica = '"+busqueda+"'";
                }
                else if(tipo=="cliente"){
                    sql+=" clientes set "+info+" = '"+dato+"' where correo = '"+busqueda+"'";
                }
                else if(tipo=="medicamento"){
                    sql+=" medicamentos set "+info+" = "+dato+" where id_medica = '"+busqueda+"'";
                }

                PreparedStatement ps;
                try {
                    ps = conectar.getConexion().prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
                    ps.executeUpdate();
                    impresionDialogo("Datos Actualizados Correctamente ","Datos Actualizados",1);
                    conectar.desconectarDb();
                }catch (SQLException e){
                    impresionDialogo("Error al Actualizar los Datos","Error ",0);
                }

            }catch (Exception e){
                impresionDialogo("Error al conectarse [Comuniquese con Tecnología]","Error en Conexión",0);
            }
        }

    }

    public ArrayList<String> FacturaEnviadaCorreo(String dato, ArrayList<String> datostabla){
        Document documento = new Document();
        String path="C:/FARMACIAEGPH/Facturas_Enviadas_GMAIL/", ext=".pdf";
        String archivo="Factura_";
        String s=path+archivo+dato+ext;
        String archi=archivo+dato+ext;
        ArrayList<String> datoscorreo = new ArrayList<String>();
        datoscorreo.add(archi);
        datoscorreo.add(s);
        try{
            Conexion conectar = new Conexion();
            conectar.conectarDb();
            Double sumatot = 0.0;
            PdfWriter.getInstance(documento, new FileOutputStream(s));
            documento.open();
            PdfPTable tabla = new PdfPTable(5);
            tabla.addCell("Nombre");
            tabla.addCell("ID");
            tabla.addCell("Cantidad");
            tabla.addCell("Precio");
            tabla.addCell("Total");
            for (int i = 0; i < datostabla.size(); i=i+5) {
                tabla.addCell(String.valueOf(datostabla.get(i)));
                tabla.addCell(String.valueOf(datostabla.get(i+1)));
                tabla.addCell(String.valueOf(datostabla.get(i+2)));
                tabla.addCell(String.valueOf(datostabla.get(i+3)));
                tabla.addCell(String.valueOf(datostabla.get(i+4)));
                sumatot = sumatot + Double.valueOf(datostabla.get(i+4));
            }
            String sums="Suma Total: ";
            sums+=String.valueOf(sumatot);
            documento.add(tabla);
            documento.add(Chunk.NEWLINE);
            documento.add(new Paragraph(sums));
            documento.close();
            conectar.desconectarDb();
            JOptionPane.showMessageDialog(null, "Reporte creado.");

        }catch (Exception ex){
            impresionDialogo("Error al conectarse[Comuniquese con Tecnología]","Error en Conexión",0);
        }
        return datoscorreo;
    }

    public void EnviarCorreo(ArrayList<String> DatosEnviarCorreo, int tipo){
        Properties propiedad = new Properties();
        propiedad.setProperty("mail.smtp.host", "smtp.gmail.com");
        propiedad.setProperty("mail.smtp.starttls.enable", "true");
        propiedad.setProperty("mail.smtp.port", "587");
        propiedad.setProperty("mail.smtp.auth", "true");
        propiedad.setProperty("mail.smtp.ssl.protocols", "TLSv1.2");

        Session sesion = Session.getDefaultInstance(propiedad);
        MimeMultipart m = new MimeMultipart();

        if(tipo==1) {
            BodyPart texto = new MimeBodyPart();
            try {
                texto.setText("Factura Certificada FarmaciasEGPH");
            } catch (MessagingException ex) {
                ex.printStackTrace();
            }
            BodyPart adjunto = new MimeBodyPart();
            try {
                adjunto.setDataHandler(new DataHandler(new FileDataSource(DatosEnviarCorreo.get(1))));
            } catch (MessagingException ex) {
                ex.printStackTrace();
            }
            try {
                adjunto.setFileName(DatosEnviarCorreo.get(0));
            } catch (MessagingException ex) {
                ex.printStackTrace();
            }
            try {
                m.addBodyPart(texto);
            } catch (MessagingException ex) {
                ex.printStackTrace();
            }
            try {
                m.addBodyPart(adjunto);
            } catch (MessagingException ex) {
                ex.printStackTrace();
            }
        }

        String correoEnvia="farmaciasegph@gmail.com";
        String contrasena="bqhpdxfvdwattbtn";
        String receptor="";
        if(tipo==1){
            receptor = CorreoCliente;
        }
        else if(tipo==2){
            receptor = CorreoCliente2;
        }
        String asunto="";
        if(tipo==1){
            asunto = "Factura de compra en FarmaciasEGPH";
        }
        else if(tipo==2){
            asunto = "Usuario Bloqueado";
        }

        String mensaje="Su usuario ha sido bloqueado por seguridad debido a que se ha tratado de iniciar sesion en 3 intentos con claves incorrectas. Porfavor comuniquese con Tecnologia para ayudarlo a desbloquearla";

        MimeMessage mail = new MimeMessage(sesion);
        try {
            mail.setFrom(new InternetAddress(correoEnvia));
            mail.addRecipient(Message.RecipientType.TO, new InternetAddress (receptor));
            mail.setSubject(asunto);
            if(tipo==1){
                mail.setContent(m);
            }
            else if(tipo==2){
                mail.setText(mensaje);
            }

            Transport transportar = sesion.getTransport("smtp");
            transportar.connect(correoEnvia,contrasena);
            transportar.sendMessage(mail, mail.getRecipients(Message.RecipientType.TO));
            transportar.close();
            if(tipo==1){
                impresionDialogo("Factura enviada a su correo!", "Factura Enviada", 1);
            }

        } catch (AddressException ex) {
            Logger.getLogger(Panel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MessagingException ex) {
            Logger.getLogger(Panel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public File crearcarpeta(String path) throws IOException {
        File directorio = new File(path);
        if (!directorio.exists()) {
            if (directorio.mkdirs()) {
                impresionDialogo("Directorio creado","Directorio Creado",1);
            } else {
                impresionDialogo("Error al crear directorio","ERROR",0);
            }
        }
        return directorio;
    }

    public void impresionDialogo(String mensaje, String titulo,int icono){
        JOptionPane.showMessageDialog(null,mensaje,titulo,icono);
    }
}
