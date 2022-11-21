package com.projet.comptemulticonnecteurs.service;

import com.projet.comptemulticonnecteurs.dto.CompteRequestDTO;
import com.projet.comptemulticonnecteurs.dto.CompteResponseDTO;
import com.projet.comptemulticonnecteurs.entities.Compte;

import java.util.List;

public interface CompteService {
    public CompteResponseDTO save(CompteRequestDTO compteRequestDTO) ;
    public List<CompteResponseDTO> listComptes();

    public CompteResponseDTO getCompte (Long id);

    public CompteResponseDTO update(Long code,CompteRequestDTO compteRequestDTO);
}
