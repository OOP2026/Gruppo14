package model;
public class Studente extends Utente {
String matricola;
AnnoCorso annoDiCorso;
String facolta;
Orario o;

/**
	 * Costruttore della classe Studente eredita dalla classe Utente
	 * @param nome
	 * @param cognome
	 * @param email
	 * @param login
	 * @param password
	 * @param matricola:univoca per ciascuno studente
	 * @param annoDiCorso
	 * @param facoltà
	 */
	@SuppressWarnings({"java:S107","all"})
	public Studente(String nome,String cognome,String email,String login,String password,String matricola,AnnoCorso annoDiCorso,String facolta) {
		super(nome,cognome,email,login,password);
		this.matricola=matricola;
		this.annoDiCorso=annoDiCorso;
		this.facolta=facolta;
}
	/**
	 * Mostra all'utente l'orario con tutte le lezioni
	 * @param o
	 * @return o
	 */
	public Orario visualizzaOrario() {
		return o;
	}
	/**
	 * Imposta un orario alla lezione
	 * @param orario
	 */
	public void setOrario(Orario orario) {
        this.o = orario;
    }
	/**
	 * Ottiene l'orario di appartenenza della lezione
	 * @return o
	 */
    public Orario getOrario() {
        return this.o;
    }

}