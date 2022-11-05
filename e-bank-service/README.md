# Architectures orientées services

## activité pratique  : Mise en oeuvre d'un connecteur Rest 

Enoncé :
```
Mettre en oeuvre d'un connecteurs Rest pour manipuler les comptes bancaires ceci doit permettre de :
Lister l'ensemble des comptes bancaire
       -Récupérer un compte par son identifiant
       -Enregistrer un compte bancaire
       -Modifier les infromations d'un compte bancaire
       -Supprimer un compte bancaire
```

le programme principale ou on ajoute des comptes de test :
```
@SpringBootApplication
public class EBankServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EBankServiceApplication.class, args);

	}

	@Bean
	CommandLineRunner start(BankAccountRepository bankAccountRepository) {
		return args -> {
			for (int i = 0; i < 10; i++) {
				BankAccount bankAccount = BankAccount.builder()
						.id(UUID.randomUUID().toString())
						.type(Math.random() > 0.5 ? AccountType.CURRENT_ACCOUNT : AccountType.SAVING_ACCOUNT)
						.balance(1000 + Math.random() * 444)
						.createdAt(new Date())
						.currency("MAD")
						.build();
				bankAccountRepository.save(bankAccount);


			}

		};

	}
}


```


l'entité BankAccount :
```
@Entity
@Data
@NoArgsConstructor @AllArgsConstructor @Builder
public class BankAccount {
    @Id
    private String id;
    private Date createdAt ;
    private Double balance ;
    private String currency ;
    @Enumerated(EnumType.STRING)
    private AccountType type;

}

```
L'interface Account service :
```
public interface AccountService {
    public BankAccountResponseDTO addAccount(BankAccountRequestDTO bankAccountRequestDTO);
    public BankAccountResponseDTO updateAccount(BankAccountReqDTO bankAccountReqDTO);
}

```
la controleur REST :
```
@RestController
@AllArgsConstructor
public class AccountRestController {
    private BankAccountRepository bankAccountRepository;
    private AccountService accountService ;



    @GetMapping("/bankaccounts")
    public List<BankAccount> bankAccounts(){
        return bankAccountRepository.findAll();
        }
    @GetMapping("/bankaccounts/{id}")
    public BankAccount bankAccount(@PathVariable String id){
        return bankAccountRepository.findById(id).orElse(null);
    }
    @PostMapping("/bankaccounts")
    public BankAccountResponseDTO save (@RequestBody BankAccountRequestDTO bankAccountRequestDTO){
        return accountService.addAccount(bankAccountRequestDTO);
    }

    @PostMapping("/bankaccounts/{id}")
    public  BankAccountResponseDTO update (@PathVariable String id ,@RequestBody BankAccountReqDTO bankAccount){
       return  accountService.updateAccount(bankAccount);
    }
    @DeleteMapping("/bankaccounts/{id}")
    public  void delete (@PathVariable String id){
        bankAccountRepository.deleteById((id));
    }
}


```
