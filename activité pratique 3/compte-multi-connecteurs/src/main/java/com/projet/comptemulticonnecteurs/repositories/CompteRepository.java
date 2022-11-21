package com.projet.comptemulticonnecteurs.repositories;

import com.projet.comptemulticonnecteurs.entities.Compte;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompteRepository extends JpaRepository<Compte,Long> {
}
