package com.projet.comptemulticonnecteurs.web;

import com.projet.comptemulticonnecteurs.dto.CompteRequestDTO;
import com.projet.comptemulticonnecteurs.dto.CompteResponseDTO;
import com.projet.comptemulticonnecteurs.service.CompteService;
import org.springframework.stereotype.Service;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import java.util.List;
@Service
@WebService(serviceName = "soap")

public class CompteSoapWS {
    CompteService compteService;

    public CompteSoapWS(CompteService compteService) {

        this.compteService = compteService;
    }

    @WebMethod
    public List<CompteResponseDTO> allComptes(){
        return compteService.listComptes();
    }


    @WebMethod
    public CompteResponseDTO save(@WebParam(name = "customerRequestDTO") CompteRequestDTO customerRequestDTO){
        return compteService.save(customerRequestDTO);
    }
    @WebMethod
    public CompteResponseDTO update( @WebParam(name = "code") Long code,@WebParam(name = "customerRequestDTO") CompteRequestDTO customerRequestDTO){
        return compteService.update(code,customerRequestDTO);
    }


    @WebMethod
    public CompteResponseDTO getCustomer(@WebParam(name = "code")  Long code){
        return compteService.getCompte(code);
    }
}
