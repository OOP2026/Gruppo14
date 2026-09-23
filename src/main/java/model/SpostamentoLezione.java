package Progetto;
import java.time.*;
public class SpostamentoLezione {
	private String idSpostamento;
	private LocalTime orarioIniziale;
	private Lezione l;
	private GiornoSettimana nuovoGiorno;
	private LocalTime orarioFinale;
	private Stato stato;
	private Aula aula;
	/**
	 * Costruttore della classe SpostamentoLezione:
	 * @param id: usato per identificare ciascuno spostamento
	 * @param orarioIniziale
	 * @param giornoIniziale
	 * @param giornoProposto
	 * @param orarioProposto
	 */
	public SpostamentoLezione(String id,Lezione l,GiornoSettimana giornoIniziale,LocalTime orarioIniziale,LocalTime orarioFinale) {
		this.idSpostamento=id;
		this.l=l;
		this.giornoIniziale=giornoIniziale;
		this.orarioIniziale=orarioIniziale;
		this.giornoIniziale=giornoIniziale;
		this.orarioFinale=orarioFinale;
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

	public void setIdSpost(String idSpostamento){
		this.idSpostamento=idSpostamento;
	}
	public String getIdSpost() {
		return idSpostamento;
	}
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
        return this.orarioIniziale.isBefore(altra.getOrarioFinale()) && altra.getOrarioFinale().isBefore(this.orarioFinale);
    }
	/**
	 * Restituisce l'aula per confrontare il conflitto tra due lezioni
	 * @return aula
	 */
	public Aula getAula() {
		return aula;
	}
	/**
	 * Restituisce l'orario prima dello spostamento della lezione
	 * @return orarioIniziale
	 */
	public LocalTime getOrarioIniziale() {
		return orarioIniziale;
	}
	/**
	 * Restituisce l'orario proposto per lo spostamento
	 * @return orarioProposto
	 */
	public LocalTime getOrarioFinale() {
		return orarioFinale;
	}
	/**
	 * Restituisce il giorno prima dello spostamento lezione
	 * @return giornoIniziale 
	 */
	public GiornoSettimana getNuovoGiorno() {
		return giornoIniziale;
	}
	
	public Lezione getLezione(){
		return l;
	}
	@Override
	public String toString() {
		return "SpostamentoLezione [idSpostamento=" + idSpostamento + ", orarioIniziale=" + orarioIniziale
				+ ", nuovoGiorno=" + nuovoGiorno +  ",orarioProposto="
				+ orarioFinale + ", stato=" + stato + ", aula=" + aula + "]";
	}
}
