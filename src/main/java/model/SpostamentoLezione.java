package model;
import java.time.*;
public class SpostamentoLezione {
	private String idSpostamento;
	private LocalTime nuovoOrarioIniziale;
	private GiornoSettimana nuovoGiorno;
	private LocalTime nuovoOrarioFinale;
	private Stato stato;
	private Aula aula;
	private Lezione l;
	/**
	 * 
	 * @param id:identifica ciascuno spostamento
	 * @param l
	 * @param orarioIniziale
	 * @param nuovoGiorno
	 * @param nuovoOrarioFinale
	 */
	public SpostamentoLezione(String id,Lezione l,LocalTime orarioIniziale,GiornoSettimana nuovoGiorno,LocalTime nuovoOrarioFinale) {
		this.idSpostamento=id;
		this.l=l;
		this.nuovoOrarioIniziale=orarioIniziale;
		this.nuovoGiorno=nuovoGiorno;
		this.nuovoOrarioFinale=nuovoOrarioFinale;
		this.stato=Stato.IN_ATTESA; 
		/**
		 * Stato di default:IN_ATTESA
		 */
	}
	/**
	 * Restituisce lo stato dello spostamento (IN_ATTESA,RIFUTATO,APPROVATO)
	 * @return stato
	 */
	public Stato getStato() {
		return stato;
	}
	/**
	 * Consente di modificare lo stato dello spostamento
	 * @param stato
	 */
	public void setStato(Stato stato) {
        this.stato = stato;
    }
	/**
	 * Ottiene l'id dello spostamento
	 * @return idSpostamento
	 */
	public String getIdSpost() {
		return idSpostamento;
	}
	public void setIdSpost(String id) {
		idSpostamento=id;
	}
	/**
	 * Verifica se sono presenti conflitti negli spostamenti
	 * @param altra
	 * @return true o false
	 */
	public boolean vaInConflittoCon(SpostamentoLezione altra) {
        /**
         *  Se non riguardano la stessa aula, non c'è conflitto
         */
		/**
		 * equalsignorecase confronta due stringhe senza tener conto delle maiuscole o minuscole (case asensitive).
		 */
        if (this.getNuovoGiorno()!=altra.getNuovoGiorno()) {
            return false;
        }
        /**
         *  Due intervalli temporali [A, B] e [C, D] si sovrappongono se A < D e C < B
         */
        return this.nuovoOrarioIniziale.isBefore(altra.getOrarioFinale()) && altra.getOrarioFinale().isBefore(this.nuovoOrarioFinale);
    }
	/**
	 * Restituisce l'aula per confrontare il conflitto tra due lezioni
	 * @return aula
	 */
	public Aula getAula() {
		return aula;
	}
	
	public void setAula(Aula aula) {
		this.aula = aula;
	}
	/**
	 * Restituisce il nuovo orario iniziale
	 * @return nuovoOrarioIniziale
	 */
	public LocalTime getOrarioIniziale() {
		return nuovoOrarioIniziale;
	}
	/**
	 * Restituisce l'orario finale dello spostamento
	 * @return nuovoOrarioFinale
	 */
	public LocalTime getOrarioFinale() {
		return nuovoOrarioFinale;
	}
	/**
	 * Restituisce il nuovo giorno per lo spostamento
	 * @return nuovoGiorno
	 */
	public GiornoSettimana getNuovoGiorno() {
		return nuovoGiorno;
	}
	@Override
	public String toString() {
		return "SpostamentoLezione [idSpostamento=" + idSpostamento + ", orarioIniziale=" + nuovoOrarioIniziale
				+ ", giornoIniziale=" + nuovoGiorno + ", giornoProposto=" + nuovoGiorno + ", orarioProposto="
				+ nuovoOrarioFinale + ", stato=" + stato + ", aula=" + aula + "]";
	}
	/**
	 * Ottiene la lezione inclusa nello spostamento
	 * @return l
	 */
	public Lezione getLezione() {
		return l;
	}
	public void setLezione(Lezione l) {
		this.l=l;
	}
	public void setNuovoGiorno(GiornoSettimana nuovoGiorno) {
		this.nuovoGiorno=nuovoGiorno;
	}
	public void setOraInizio(LocalTime oraInizio) {
		this.nuovoOrarioIniziale=oraInizio;
	}
	public void setOraFine(LocalTime oraFine) {
		this.nuovoOrarioFinale=oraFine;
	}
}
