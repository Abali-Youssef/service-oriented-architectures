package com.projet.comptemulticonnecteurs.service;

import com.projet.comptemulticonnecteurs.dto.CompteRequestDTO;
import com.projet.comptemulticonnecteurs.dto.CompteResponseDTO;
import com.projet.comptemulticonnecteurs.entities.Compte;
import com.projet.comptemulticonnecteurs.mappers.CompteMapper;
import com.projet.comptemulticonnecteurs.repositories.CompteRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class CompteServiceImpl implements CompteService {
    CompteRepository compteRepository;
    CompteMapper compteMapper ;

    public CompteServiceImpl(CompteRepository compteRepository, CompteMapper compteMapper) {
        this.compteRepository = compteRepository;
        this.compteMapper = compteMapper;
    }

    @Override
    public CompteResponseDTO save(CompteRequestDTO compteRequestDTO) {
    Compte  compte = compteMapper.compteRequestDTOToCompte(compteRequestDTO);
    compte.setDateCreation(new Date());

        return compteMapper.compteToCompteResponseDTO(compteRepository.save(compte));
    }

    @Override
    public List<CompteResponseDTO> listComptes() {
        List<Compte> comptes = compteRepository.findAll();
        List<CompteResponseDTO> compteResponseDTOS = comptes.stream().map(cmt->compteMapper.compteToCompteResponseDTO(cmt)).collect(Collectors.toList());

        return compteResponseDTOS;
    }

    @Override
    public CompteResponseDTO getCompte(Long id) {
        Compte compte = compteRepository.findById(id).get();
        return compteMapper.compteToCompteResponseDTO(compte);
    }

    @Override
    public CompteResponseDTO update(Long code,CompteRequestDTO compteRequestDTO) {
        Compte  compte = compteMapper.compteRequestDTOToCompte(compteRequestDTO);
        compte.setCode(code);
        compte.setDateCreation(compteRepository.findById(code).get().getDateCreation());
        return compteMapper.compteToCompteResponseDTO(compteRepository.save(compte));
    }
}
