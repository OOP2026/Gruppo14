package Progetto;

public class Utente {
public String nome;
public String cognome;
public String email;
protected String password;
public String login;
public Utente(String nome,String cognome,String email,String password) {
	this.nome=nome;
	this.cognome=cognome;
	this.email=email;
	this.password=password;
}
public boolean toLogin(String email,String password) {
	if (this.email.equals(email) && this.password.equals(password)) {
        return true;
    } else {
        return false;
    }
}
}
