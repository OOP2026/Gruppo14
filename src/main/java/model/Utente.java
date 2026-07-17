package Progetto;

public class Utente {
public String nome;
public String cognome;
public String email;
private String password;
public String username;
public Utente(String nome,String cognome,String email,String password,String username) {
	this.nome=nome;
	this.cognome=cognome;
	this.email=email;
	this.password=password;
	this.username=username;
}
public boolean login(String email,String password) {
	if (this.email.equals(email) && this.password.equals(password)) {
        return true;
    } else {
        return false;
    }
}
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
