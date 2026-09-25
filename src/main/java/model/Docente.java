package model;
import java.util.*;
/**
 * Classe Docente(sottoclasse di Utente) definisce 2 riferimenti:
 * @param richiesteSpostamento che il docente effettua;
 * @param lezioni che il Docente tiene.
 */
public class Docente extends Utente {
	

	private List<SpostamentoLezione> richiesteSpostamento;
	private List<Lezione> lezioni;                         
    
	/**
     * Costruttore della classe Docente eredita dalla classe Utente
     * @param nome
     * @param cognome
     * @param email
     * @param password
     * @param login
     */
    public Docente(String nome, String cognome, String email, String password, String login) {
        super(nome, cognome, email, password, login);
        this.richiesteSpostamento = new ArrayList<>();
        this.lezioni = new ArrayList<>();
    }
    /**
     * Metodo che restituisce l'orario scolastico da visualizzare
     * @param o
     * @return o
     */
    public Orario visualizzaOrario(Orario o) {
        return o;
    }
    /**
     * Aggiunge una richiesta di spostamento lezione (Relazione RICHIEDE)
     * @param spostamento
     */
    public void richiedeSpostamento(SpostamentoLezione spostamento) {
        if (spostamento != null) {
            this.richiesteSpostamento.add(spostamento);
        }
    }

    /**
     * Aggiunge una lezione tenuta dal docente (Relazione TIENE)
     * @param lezione
     */
    public void addLezione(Lezione lezione) {
        if (lezione != null && !this.lezioni.contains(lezione)) {
            this.lezioni.add(lezione);
        }
    }
    /**
     * Restituisce le richieste di spostamento del docente
     * @return richiesteSpostamento
     */
    public List<SpostamentoLezione> getRichiesteSpostamento() {
        return richiesteSpostamento;
    }
    /**
     * Restituisce le lezioni tenute dal docente
     * @return lezioni
     */
	public List<Lezione> getLezioni() {
        return lezioni;
    }
    @Override
   	public String toString() {
   		return "Docente [richiesteSpostamento=" + richiesteSpostamento + ", lezioni=" + lezioni + "]";
   	}
}
