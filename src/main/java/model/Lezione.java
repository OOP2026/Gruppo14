package model;
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
private String id;
/**
 * Costruttore della classe Lezione
 * @param giorno
 * @param oraInizio
 * @param oraFine
 * @param i
 * @param a
 * @param d
 * @param r
 */
	public Lezione(GiornoSettimana giorno,LocalTime oraInizio,LocalTime oraFine,Insegnamento i,Aula a,Responsabile r) {
		this.giorno=giorno;
		this.oraInizio=oraInizio;
		this.oraFine=oraFine;
		this.insegnamento=i;
		this.aula=a;
		this.r=r;
	}
	/**
	 * Ritorna l'insegnamento cui si riferisce
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
		return this.insegnamento.getDocente();
	}
	/**
	 * Imposta il docente che tiene una specifica lezione attraverso l'oggetto riferimento Insegnamento
	 * @param i
	 */
	public void setDocente(Insegnamento i) {
		this.d=i.getDocente();
	}
	/**
	 * Ritorna il responsabile che crea la lezione
	 * @return responsabile
	 */
	public Responsabile getResponsabile() {
		return r;
	}
	/**
	 * Ritorna il giorno della settimana di lezione
	 * @return giorno
	 */
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
	 * Imposta l'orario non ancora inizializzato
	 * @param o
	 */
	public void setOrario(Orario o) {
		this.o=o;
	}
	/**
	 * Restituisce l'orario in cui è contenuta la lezione
	 * @return orario
	 */
	public Orario getOrario() {
		return o;
	}
	@Override
	public String toString() {
		return "Lezione [giorno=" + giorno + ", oraInizio=" + oraInizio + ", oraFine=" + oraFine + ", insegnamento="
				+(insegnamento!=null ?insegnamento.getNomeIns():"N/D") + ", aula="  +(aula!=null ?aula.getNomeAula():"N/D")+"d=" + (d!=null ? d.getNome()+""+d.getCognome():"N/D") + ", r=" +(r!=null ? r.getNome()+""+r.getCognome():"N/D") + "]";
	}
	/**
	 * Imposta un nuovo giorno alla lezione
	 * @param nuovoGiorno
	 */
	public void setGiorno(GiornoSettimana nuovoGiorno) {
		this.giorno=nuovoGiorno;
		
	}
	/**
	 * Imposta il nuovo orario di inizio
	 * @param orarioIniziale
	 */
	public void setOraInizio(LocalTime orarioIniziale) {
		this.oraInizio=orarioIniziale;
		
	}
	/**
	 * Imposta il nuovo orario di fine
	 * @param orarioFinale
	 */
	public void setOraFine(LocalTime orarioFinale) {
		this.oraFine=orarioFinale;
		
	}
	/**
	 * Imposta una nuova aula alla Lezione
	 * @param aula2
	 */
	public void setAula(Aula aula2) {
		this.aula=aula2;
		
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	
}


