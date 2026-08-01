package Progetto;
import java.util.List;
import java.util.ArrayList;
import java.util.*;
/**
 * Rappresenta un <b>Docente</b> all'interno dell'ateneo
 */
public class Docente extends Utente {
	/**
	 * un docente può sostenere più insegnamenti
	 */
	public ArrayList<Insegnamento> insegnamento;
	ResponsabileOrari responsabile;
	/**
	 * nel corso della giornata, un docente può tenere più lezioni
	 */
	public ArrayList<Lezione> lezioni;
	/**
	 * Costruttore della classe Docente:
	 * @param nome
	 * @param cognome
	 * @param email
	 * @param password
	 * @param username
	 * @param insegnamento
	 * @param responsabile
	 * @param lezioni
	 */
	public Docente(String nome,String cognome,HashSet<String> email,String password,String username,ArrayList<Insegnamento>insegnamento,ResponsabileOrari responsabile,ArrayList<Lezione> lezioni) {
		super(nome,cognome,email,password,username);
		this.insegnamento=new ArrayList<>();
		this.responsabile=responsabile;
		this.lezioni=new ArrayList<>();
	}
	/**
	 * @return cognome
	 *<br>Restituisce il cognome del docente</br>
	 */
public String getCognome() {
	return cognome;
}
}
