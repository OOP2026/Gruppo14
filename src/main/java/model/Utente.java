package Progetto;
import java.util.HashSet;
/**
 * La classe Utente si specializza rispettivamente in: Studente,ResponsabileOrari,Docente
 */
public class Utente {
public String nome;
public String cognome;
public HashSet<String> email;
private String password;
public String username;
/**
 * Costruttore della classe Utente:
 * @param nome
 * @param cognome
 * @param email: univoca per ciascun utente, quindi uso un oggetto di tipo HashSet
 * @param password
 * @param username
 */
public Utente(String nome,String cognome,HashSet<String> email,String password,String username) {
	this.nome=nome;
	this.cognome=cognome;
	this.email=email;
	this.password=password;
	this.username=username;
}
/**
 * Funzione di autenticazione di ciascun utente al sistema, accetta 3 parametri (email,username,password) ed 1 valore di ritorno booleano
 * per verificare se l'autenticazione dell'utente è andata a buon fine.
 * @param email
 * @param username
 * @param password
 * @return
 */
public boolean login(String email,String username,String password) {
	if (this.email.equals(email) && this.password.equals(password) && this.username.equals(username)) {
        return true;
    } else {
        return false;
    }
}
/**
 * Mostra l'orario a ciascun utente.
 * @param orarioGenerale
 */
public void visualizzaOrario(Orario orarioGenerale) {
	if(orarioGenerale==null || orarioGenerale.getListaLezioni().isEmpty()) {
		System.out.println("Orario non disponibile o non programmato!");
	}
	System.out.println("Orario delle lezioni:");
	for(Lezione l:orarioGenerale.getListaLezioni()) {
		System.out.println("Materia" +l.getInsegnamento());
		System.out.println("Giorno" + l.getGiorno());
		System.out.println("Ora inizio:" +l.getOraInizio() + "-" + l.getOraFine());
	}
}
}
