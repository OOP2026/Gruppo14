package Progetto;
import java.time.*; 
import java.util.*;
public class Insegnamento {
private String nomeIns;
private LocalDate dataInizio;
private LocalDate dataFine;
private boolean attivoManuale;
private Docente d;
private int CFU;
ArrayList<Lezione> l=new ArrayList<>();
/**
 * Costruttore della classe Insegnamento:
 * @param insegnamento
 * @param dataInizio
 * @param dataFine
 */
/**
 * Si può aggiungere un flag booleano(attivoManuale) se un insegnamento può essere disattivato prima della sua data di fine naturale
 */
	public Insegnamento(String insegnamento,LocalDate dataInizio,LocalDate dataFine,Docente d,int CFU) {
		this.nomeIns = insegnamento;
        this.dataInizio = dataInizio;
        this.dataFine = dataFine;
        this.attivoManuale = true;
        this.d=d;
        this.CFU=CFU;
		// TODO Auto-generated constructor stub
	}
	/**
	 * Metodo isAttivo restituisce true se l'insegnamento è attivo e nel periodo di attività, false in caso contrario.
	 * @return attivoManuale
	 * @return inPeriodo
	 */
	public boolean isAttivo() {
		LocalDate oggi = LocalDate.now();
        boolean inPeriodo = (oggi.isEqual(dataInizio) || oggi.isAfter(dataInizio)) &&
                            (oggi.isEqual(dataFine) || oggi.isBefore(dataFine));
                            
        return attivoManuale && inPeriodo;
	}
	/**
	 *  Aggiunge una singola lezione in un insegnamento
	 * @param l
	 */
    public void addLezione(Lezione l) {
        if (l != null) {
            this.l.add(l);
        }
    }

    /**
     *  Rimuove una lezione da un insegnamento
     * @param l
     */
    public void removeLezione(Lezione l) {
        this.l.remove(l);
    }

    /**
     *  Restituisce la lista (in capsula per sicurezza)
     * @return l
     */
    public List<Lezione> getLezioni() {
        return Collections.unmodifiableList(l);
    }
    /**
     * Restituisce il rispettivo docente dell'insegnamento
     * @return docente
     */
    public Docente getDocente() {
    	return d;
    }
    /**
     * Restituisce il numero di CFU dell'insegnamento
     * @return CFU
     */
    public int getCFU() {
    	return CFU;
    }
    /**
     * Restituisce il nome dell'insegnamento
     * @return nomeIns
     */
    public String getNomeIns() {
    	return nomeIns;
    }
}

