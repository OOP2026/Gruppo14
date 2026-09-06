package Progetto;

public class Studente extends Utente {
String matricola;
AnnoCorso annoDiCorso;
String facoltà;
/**
 * Costruttore della classe Studente:
 * @param matricola
 * @param annoDiCorso
 * @param facoltà
 */
/**
 * Eredita anch'essa dalla classe Utente
 */
	public Studente(String nome,String cognome,String email,String login,String password,String matricola,AnnoCorso annoDiCorso,String facoltà) {
		super(nome,cognome,email,login,password);
		this.matricola=matricola;
		this.annoDiCorso=annoDiCorso;
		this.facoltà=facoltà;
}
	/**
	 * Mostra all'utente l'orario con tutte le lezioni
	 * @param o
	 * @return o
	 */
	public Orario visualizzaOrario(Orario o) {
		return o;
	}

}