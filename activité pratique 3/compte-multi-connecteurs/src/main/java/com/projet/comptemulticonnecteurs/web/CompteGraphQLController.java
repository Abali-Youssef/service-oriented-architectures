package com.projet.comptemulticonnecteurs.web;

import com.projet.comptemulticonnecteurs.dto.CompteRequestDTO;
import com.projet.comptemulticonnecteurs.dto.CompteResponseDTO;
import com.projet.comptemulticonnecteurs.mappers.CompteMapper;
import com.projet.comptemulticonnecteurs.repositories.CompteRepository;
import com.projet.comptemulticonnecteurs.service.CompteService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class CompteGraphQLController {
    private CompteRepository compteRepository;
    private CompteService compteService;
    private CompteMapper compteMapper ;

    public CompteGraphQLController(CompteRepository compteRepository, CompteService compteService, CompteMapper compteMapper) {
        this.compteRepository = compteRepository;
        this.compteService = compteService;
        this.compteMapper = compteMapper;
    }
    @QueryMapping
    public List<CompteResponseDTO> comptes(){
        return compteService.listComptes();
    }
    @QueryMapping
    public CompteResponseDTO getCompte(Long id){
        return compteService.getCompte(id);
    }
    @MutationMapping
    public boolean deleteCompte(@Argument Long id ){
        compteRepository.deleteById(id);
        return true;
}
    @MutationMapping
    public CompteResponseDTO addCompte(@Argument CompteRequestDTO compteRequestDTO){
        return compteMapper.compteToCompteResponseDTO(compteMapper.compteResponseDTOToCompte(compteService.save(compteRequestDTO)));
    }

    @MutationMapping
    public CompteResponseDTO updateCompte(@Argument Long code,@Argument CompteRequestDTO compteRequestDTO){
        return compteService.update(code,compteRequestDTO);
    }

}
