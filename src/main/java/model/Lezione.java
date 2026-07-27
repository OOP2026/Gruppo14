package Progetto;
import java.time.LocalTime;
public class Lezione {
	Insegnamento insegnamento;
	giornoSettimana giorno;
	LocalTime oraInizio;
	LocalTime oraFine;
	Aula aulaAssegnata;
	Orario orario;
	/**
	 * Costruttore della classe Lezione:
	 * @param insegnamento
	 * @param giorno
	 * @param oraInizio
	 * @param oraFine
	 * @param aulaAssegnata
	 */
	public Lezione(Insegnamento insegnamento,giornoSettimana giorno,LocalTime oraInizio,LocalTime oraFine,Aula aulaAssegnata,Orario orario) {
		this.insegnamento=insegnamento;
		this.giorno=giorno;
		this.oraInizio=oraInizio;
		this.oraFine=oraFine;
		this.aulaAssegnata=aulaAssegnata;
		this.orario=orario;
	}
	/**
	 * Restituisce l'insegnamento
	 * @return insegnamento
	 */
	public Insegnamento getInsegnamento() {
		return insegnamento;
	}
	/**
	 * Restituisce il giorno della settimana di lezione
	 * @return giorno
	 */
	public giornoSettimana getGiorno() {
		return giorno;
	}
	/**
	 * Restituisce ora d'inizio della lezione
	 * @return oraInizio
	 */
	public LocalTime getOraInizio() {
		return oraInizio;
	}
	/**
	 * Restituisce ora d'inizio della lezione
	 * @return oraFine
	 */
	public LocalTime getOraFine() {
		return oraFine;
	}
	/**
	 * Restituisce l'aula assegnata alla specifica Lezione
	 * @return aulaAssegnata
	 */
	public Aula getAulaAssegnata() {
		return aulaAssegnata;
	}
	/**
	 * Restituisce l'orario specifico a cui appartiene
	 * @return orario
	 */
	public Orario getOrario() {
		return orario;
	}
}
