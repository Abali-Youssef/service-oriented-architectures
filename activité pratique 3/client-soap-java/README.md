## Client soap java




le proxy généré :

![ les classes et interfaces générées](/proxy.png "c'est les classes généré à partir du WSDL")

le code du java client soap API :

``` 
    public static void main(String[] args) {
        BanqueService stub = new BanqueWS().getBanqueServicePort();
        System.out.println("23MAD = "+stub.convert(23)+"USD");
        Compte compte =stub.getCompte(5);
        System.out.println("le solde du user ayant le code 5 est  "+compte.getSolde());
    } 
 ```
 et les dépendences utilisées :
```
    <dependency>
            <groupId>com.sun.xml.ws</groupId>
            <artifactId>jaxws-ri</artifactId>
            <version>4.0.0</version>
            <type>pom</type>
        </dependency>
```
