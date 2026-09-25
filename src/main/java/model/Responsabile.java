package model;
import java.util.*;
import java.time.*;
import java.util.logging.*;
public class Responsabile extends Utente {
	ArrayList<Insegnamento> insegnamentiAttivi=new ArrayList<>();
	ArrayList<Lezione> lezioni= new ArrayList<>();
	ArrayList<SpostamentoLezione> spostamenti=new ArrayList<>();
	private static final Logger LOGGER = Logger.getLogger(Responsabile.class.getName());
	/**
	 * Costruttore della classe Responsabile eredita dalla classe Utente
	 * @param nome
	 * @param cognome
	 * @param email
	 * @param login
	 * @param password
	 * @param insegnamentiAttivi
	 */
	public Responsabile(String nome,String cognome,String email,String login,String password,Insegnamento insegnamentiAttivi) {
		super(nome,cognome,email,login,password);
		this.insegnamentiAttivi.add(insegnamentiAttivi); 
	}
	/**
	 * Definisce un insegnamento: un Docente ci deve sempre essere,il numero di CFU deve essere maggiore di 0 e deve anche essere specificato il nome dell'insegnamento
	 * @param i
	 * @return true o false
	 */
	public boolean definisceInsegnamento(Insegnamento i) {
		return i.getDocente()==null || i.getCFU()<=0 || i.getNomeIns()==null;
	}
	/**
	 * Permette al responsabile di modificare gli orari scolastici:
	 * @param o
	 * @param nuovaAula
	 * @param nuovaOraInizio
	 * @param nuovaOraFine
	 * @param nuovoGiorno
	 */
	public void modificaOrario(Orario o,Aula nuovaAula,LocalTime nuovaOraInizio,LocalTime nuovaOraFine,GiornoSettimana nuovoGiorno) {
	     o.aula=nuovaAula;
	     o.inizio=nuovaOraInizio;
	     o.fine=nuovaOraFine;
	     o.giorno=nuovoGiorno;
	}
	/**
	 * Visualizza le richieste di spostamento lezioni da parte dei docenti
	 * @return spostamenti
	 */
	public List<SpostamentoLezione> visualizzaRichieste(){
		return spostamenti;
	}
	/**
	 * Il responsabile può approvare la richiesta di spostamento
	 * @param s
	 */
	public void approvaRichiesta(SpostamentoLezione s) {
		if(s==null) {
			throw new IllegalArgumentException("Impossibile avere una richiesta nulla.");
		}
		if (s.getStato() ==Stato.IN_ATTESA) {
            s.setStato(Stato.APPROVATA);
            LOGGER.info("Lo spostamento" +s.getIdSpost() + " è stato approvato! ");
        } else {
            LOGGER.severe("Impossibile approvare: lo spostamento è già nello stato " + s.getStato());
        }
    }
	/**
	 * Riceve una nuova richiesta
	 * @param s
	 */
	public void riceviRichiesta(SpostamentoLezione s) {
		if(s!=null) {
			this.spostamenti.add(s);
			LOGGER.info("Spostamento" + s.getIdSpost() + " ricevuto con successo.");
		}
	}
	/**
	 * Visualizza se sono presenti conflitti negli spostamenti
	 */
	public void visualizzaConflitti() {
        LOGGER.info("\n--- VERIFICA CONFLITTI ---");
        boolean conflittiTrovati = false;

        // Confronta ogni richiesta con le successive per evitare doppioni
        for (int i = 0; i < spostamenti.size(); i++) {
            for (int j = i + 1; j < spostamenti.size(); j++) {
                SpostamentoLezione s1 = spostamenti.get(i);
                SpostamentoLezione s2 = spostamenti.get(j);

                if (s1.vaInConflittoCon(s2)) {
                    conflittiTrovati = true;
                    LOGGER.severe("CONFLITTO RILEVATO nell'aula " + s1.getAula() + ":");
                    LOGGER.info("  - Spostamento A: " + s1.getIdSpost() + " (" + s1.getNuovoGiorno() +s1.getOrarioIniziale()+ " -> " + s1.getNuovoGiorno() +s1.getOrarioFinale()+")");
                    LOGGER.info("  - Spostamento B: " + s2.getIdSpost() + " (" + s2.getNuovoGiorno() +s2.getOrarioIniziale()+ " -> " + s2.getNuovoGiorno() +s2.getOrarioFinale()+")");
                }
            }
        }

        if (!conflittiTrovati) {
            LOGGER.info("Nessun conflitto rilevato tra le richieste.");
        }
    }
	/**
	 * Il responsabile può rifiutare la richiesta di spostamento
	 * @param s
	 */
	public void rifiutaRichiesta(SpostamentoLezione s) {
		if(s==null) {
			throw new IllegalArgumentException("Impossibile avere una richiesta nulla");
		}
		if(s.getStato()==Stato.IN_ATTESA) {
			s.setStato(Stato.RIFIUTATA);
			LOGGER.info("Lo spostamento"+s.getIdSpost()+"è stato rifiutato!");
		}
		else {
			LOGGER.info("Spostamento già rifiutato");
		}
		
	}
	}

