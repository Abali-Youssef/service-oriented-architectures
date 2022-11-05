package org.projet;

import jakarta.xml.ws.Endpoint;
import org.projet.ws.BanqueService;

public class ServerJWS {
    public static void main(String[] args) {

//show WSDL on the browser =>   http://localhost:9191/?wsdl
        Endpoint.publish("http://0.0.0.0:9191/",new BanqueService());
        System.out.println("W S déploiyé");
    }
}