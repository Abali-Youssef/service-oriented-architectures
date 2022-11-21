package com.projet.comptemulticonnecteurs.mappers;

import com.projet.comptemulticonnecteurs.dto.CompteRequestDTO;
import com.projet.comptemulticonnecteurs.dto.CompteResponseDTO;
import com.projet.comptemulticonnecteurs.entities.Compte;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CompteMapper {

    CompteResponseDTO compteToCompteResponseDTO (Compte compte);
    Compte compteResponseDTOToCompte (CompteResponseDTO compteResponseDTO);

    CompteRequestDTO compteToCompteRequestDTO (Compte compte);
    Compte compteRequestDTOToCompte (CompteRequestDTO compteRequestDTO);
}
