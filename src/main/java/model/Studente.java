package Progetto;
import java.util.*;
public class Studente extends Utente {
	String matricola;
	/**
	 * Il costruttore della classe Studente eredita dalla sua superclasse Utente (definendo in più un proprio attributo Matricola):
	 * @param nome
	 * @param cognome
	 * @param email
	 * @param password
	 * @param username
	 * @param matricola
	 */
	public Studente(String nome,String cognome,HashSet<String> email,String password,String username,String matricola) {
		super(nome,cognome,email,password,username);
		this.matricola=matricola;
		}
	/**
	 * Aggiunge la matricola a ciascuno studente, deve essere un campo obbligatorio poichè serve a riconoscere univocamente ogni studente nel sistema
	 * @param matricola
	 */
	public void aggiungiMatricola(String matricola) {
		if(matricola!=null && !matricola.trim().isEmpty()) {
			this.matricola=matricola;
			System.out.println("Matricola" + matricola + "aggiunta con successo allo studente");
		}
		else {
			System.out.println("Matricola non valida!");
		}
	}
	/**
	 * Ritorna la matricola di ciascuno studente
	 * @return matricola
	 */
	public String getMatricola() {
		return matricola;
	}
}
