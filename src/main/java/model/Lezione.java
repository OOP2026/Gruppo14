package Progetto;
import java.time.LocalTime;
public class Lezione {
private GiornoSettimana giorno;
private LocalTime oraInizio;
private LocalTime oraFine;
private Insegnamento insegnamento;
private Aula aula;
private Docente d;
private Responsabile r;
private Orario o;
/**
 * Costruttore della classe Lezione:
 * @param giorno
 * @param oraInizio
 * @param oraFine
 * @param i
 * @param a
 */
	public Lezione(GiornoSettimana giorno,LocalTime oraInizio,LocalTime oraFine,Insegnamento i,Aula a,Docente d,Responsabile r,Orario o) {
		this.giorno=giorno;
		this.oraInizio=oraInizio;
		this.oraFine=oraFine;
		this.insegnamento=i;
		this.aula=a;
		this.d=d;
		this.r=r;
		this.o=o;		// TODO Auto-generated constructor stub
	}
	/**
	 * Restituisce l'insegnamento cui si riferisce
	 * @return insegnamento
	 */
	public Insegnamento getInsegnamento() {
		return insegnamento;
	}
	/**
	 * Restituisce l'aula in cui si tiene la lezione
	 * @return aula
	 */
	public Aula getAula() {
		return aula;
	}
	/**
	 * Ritorna il docente della lezione
	 * @return docente
	 */
	public Docente getDocente() {
		return d;
	}
	/**
	 * Ritorna il responsabile che crea la lezione
	 * @return responsabile
	 */
	public Responsabile getResponsabile() {
		return r;
	}
	public GiornoSettimana getGiorno() {
		return giorno;
	}
	/**
	 * Restituisce ora di inizio della lezione
	 * @return oraInizio
	 */
	public LocalTime getOraInizio() {
		return oraInizio;
	}
	/**
	 * Restituisce ora fine della lezione
	 * @return oraFine
	 */
	public LocalTime getOraFine() {
		return oraFine;
	}
	/**
	 * Restituisce l'orario in cui è contenuta la lezione
	 * @return orario
	 */
	public Orario getOrario() {
		return o;
	}
}


