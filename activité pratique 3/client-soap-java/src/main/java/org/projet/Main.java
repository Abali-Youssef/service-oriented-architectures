package org.projet;

import org.projet.proxy.BanqueService;
import org.projet.proxy.BanqueWS;
import org.projet.proxy.Compte;

public class Main {
    public static void main(String[] args) {
        BanqueService stub = new BanqueWS().getBanqueServicePort();
        System.out.println("23MAD = "+stub.convert(23)+"USD");
        Compte compte =stub.getCompte(5);
        System.out.println("le solde du user ayant le code 5 est  "+compte.getSolde());
    }
}