package Progetto;

public class Utente {
String nome;
String cognome;
String email;
String password;
public Utente(String nome,String cognome,String email,String password) {
	this.nome=nome;
	this.cognome=cognome;
	this.email=email;
	this.password=password;
}
boolean login(String email,String password) {
	if (this.email.equals(email) && this.password.equals(password)) {
        return true;
    } else {
        return false;
    }
}
}
