package com.projet.comptemulticonnecteurs.web;

import com.projet.comptemulticonnecteurs.dto.CompteRequestDTO;
import com.projet.comptemulticonnecteurs.dto.CompteResponseDTO;
import com.projet.comptemulticonnecteurs.service.CompteService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api")
public class CompteRESTAPI {
    CompteService compteService;

    public CompteRESTAPI(CompteService compteService) {

        this.compteService = compteService;
    }
    @GetMapping(path = "/comptes")
    public List<CompteResponseDTO> allComptes(){
        return compteService.listComptes();
    }


    @PostMapping(path = "/compte")
    public CompteResponseDTO save(@RequestBody CompteRequestDTO customerRequestDTO){
        return compteService.save(customerRequestDTO);
    }


    @GetMapping(path = "/compte/{id}")
    public CompteResponseDTO getCustomer(@PathVariable  Long id){
        return compteService.getCompte(id);
    }
}
