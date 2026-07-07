package Progetto;

public class Studente extends Utente {
	String matricola;
	public Studente(String nome,String cognome,String email,String password,String matricola) {
		super(nome,cognome,email,password);
		this.matricola=matricola;
		}
	void aggiungiMatricola(String matricola) {
		this.matricola=matricola;
	}
}
