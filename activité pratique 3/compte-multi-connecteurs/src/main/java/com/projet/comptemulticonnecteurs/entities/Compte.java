package com.projet.comptemulticonnecteurs.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@XmlRootElement(name = "compte")
@XmlAccessorType(XmlAccessType.FIELD)
@Builder
public class Compte {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long code;
    private Date dateCreation;
    private  double solde;

}
