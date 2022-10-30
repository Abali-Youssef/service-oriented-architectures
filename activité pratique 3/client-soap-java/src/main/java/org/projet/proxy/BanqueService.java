
package org.projet.proxy;

import java.util.List;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebResult;
import jakarta.jws.WebService;
import jakarta.xml.bind.annotation.XmlSeeAlso;
import jakarta.xml.ws.Action;
import jakarta.xml.ws.RequestWrapper;
import jakarta.xml.ws.ResponseWrapper;


/**
 * This class was generated by the XML-WS Tools.
 * XML-WS Tools 4.0.0
 * Generated source version: 3.0
 * 
 */
@WebService(name = "BanqueService", targetNamespace = "http://ws.projet.org/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface BanqueService {


    /**
     * 
     * @param montant
     * @return
     *     returns double
     */
    @WebMethod(operationName = "Convert")
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "Convert", targetNamespace = "http://ws.projet.org/", className = "org.projet.proxy.Convert")
    @ResponseWrapper(localName = "ConvertResponse", targetNamespace = "http://ws.projet.org/", className = "org.projet.proxy.ConvertResponse")
    @Action(input = "http://ws.projet.org/BanqueService/ConvertRequest", output = "http://ws.projet.org/BanqueService/ConvertResponse")
    public double convert(
        @WebParam(name = "montant", targetNamespace = "")
        double montant);

    /**
     * 
     * @param code
     * @return
     *     returns org.projet.proxy.Compte
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getCompte", targetNamespace = "http://ws.projet.org/", className = "org.projet.proxy.GetCompte")
    @ResponseWrapper(localName = "getCompteResponse", targetNamespace = "http://ws.projet.org/", className = "org.projet.proxy.GetCompteResponse")
    @Action(input = "http://ws.projet.org/BanqueService/getCompteRequest", output = "http://ws.projet.org/BanqueService/getCompteResponse")
    public Compte getCompte(
        @WebParam(name = "code", targetNamespace = "")
        int code);

    /**
     * 
     * @return
     *     returns java.util.List<org.projet.proxy.Compte>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "listeComptes", targetNamespace = "http://ws.projet.org/", className = "org.projet.proxy.ListeComptes")
    @ResponseWrapper(localName = "listeComptesResponse", targetNamespace = "http://ws.projet.org/", className = "org.projet.proxy.ListeComptesResponse")
    @Action(input = "http://ws.projet.org/BanqueService/listeComptesRequest", output = "http://ws.projet.org/BanqueService/listeComptesResponse")
    public List<Compte> listeComptes();

}
