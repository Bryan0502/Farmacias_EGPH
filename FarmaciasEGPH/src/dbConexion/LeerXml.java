package dbConexion;

import org.xml.sax.SAXException;
import org.w3c.dom.Document;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.Base64;

public class LeerXml {
    private String serverName, dbName, puerto, usuario, pass;

    public String getServerName() {
        return serverName;
    }

    public String getDbName() {
        return dbName;
    }

    public String getPuerto() {
        return puerto;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getPass() {
        return pass;
    }

    public void datosXML () throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilderFactory factory =DocumentBuilderFactory.newInstance();
        Base64.Decoder decoder= Base64.getUrlDecoder();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document documento = builder.parse(new File("Archivo/datacon.xml"));
        serverName=documento.getElementsByTagName("serverName").item(0).getTextContent();
        serverName=new String(decoder.decode(serverName));
        dbName=documento.getElementsByTagName("dbName").item(0).getTextContent();
        dbName=new String(decoder.decode(dbName));
        puerto=documento.getElementsByTagName("port").item(0).getTextContent();
        puerto=new String(decoder.decode(puerto));
        usuario=documento.getElementsByTagName("user").item(0).getTextContent();
        usuario=new String(decoder.decode(usuario));
        pass=documento.getElementsByTagName("password").item(0).getTextContent();
        pass=new String(decoder.decode(pass));
    }
}
