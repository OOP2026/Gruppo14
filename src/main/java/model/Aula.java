package Progetto;
import java.util.List;
import java.util.ArrayList;
/**
 * Rappresenta un'aula universitaria all'interno dell'ateneo:
 * <br>gestisce l'identificativo dell'aula e l'elenco delle lezioni ospitate</br>
 * @author Matteo Gentile
 *  @version 1.0
 */
public class Aula {
	/**Il nome univoco dell'aula(es.N2,Aula magna,ecc...)*/
	String nomeAula;
	/** Lista delle lezioni assegnate a questa specifica aula */
	Lezione lezione;
	/**
     * Costruttore della classe Aula.
     * Inizializza l'aula con il nome specificato e una lista di lezioni vuota.
     * * @param nomeAula
     */
    public Aula(String nomeAula) {
		this.nomeAula=nomeAula;
		this.lezione=lezione;
	}
    /**
     * Restituisce il nome dell'aula.
     * @return Il nome dell'aula come {@link String}
     */
	public String getNomeAula() {
		return nomeAula;
	}
    /**
     * Ottiene il nome della lezione assegnata ad una specifica aula
     * @return lezione
     */
	public Lezione getLezione() {
        return lezione;
    }
}
