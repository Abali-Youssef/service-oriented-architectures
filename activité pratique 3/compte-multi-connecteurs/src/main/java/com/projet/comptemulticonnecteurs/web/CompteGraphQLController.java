package com.projet.comptemulticonnecteurs.web;

import com.projet.comptemulticonnecteurs.dto.CompteResponseDTO;
import com.projet.comptemulticonnecteurs.repositories.CompteRepository;
import com.projet.comptemulticonnecteurs.service.CompteService;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class CompteGraphQLController {
    private CompteRepository compteRepository;
    private CompteService compteService;

    public CompteGraphQLController(CompteRepository compteRepository, CompteService compteService) {
        this.compteRepository = compteRepository;
        this.compteService = compteService;
    }
    @QueryMapping
    public List<CompteResponseDTO> comptes(){
        return compteService.listComptes();
    }
    @QueryMapping
    public CompteResponseDTO getCompte(Long id){
        return compteService.getCompte(id);
    }

}
