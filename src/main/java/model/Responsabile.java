package Progetto;
import java.util.*;
import java.time.*;
public class Responsabile extends Utente {
	ArrayList<Insegnamento> insegnamentiAttivi=new ArrayList<>();
	ArrayList<Lezione> lezioni= new ArrayList<>();
	ArrayList<SpostamentoLezione> spostamenti=new ArrayList<>();
	/**
	 * Costruttore della classe Responsabile:
	 * @param nome
	 * @param cognome
	 * @param email
	 * @param login
	 * @param password
	 * @param insegnamentiAttivi
	 */
	/**
	 * Eredita dalla classe Utente.
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
		if(i.getDocente()==null || i.getCFU()<=0 || i.getNomeIns()==null) {
			return false;
		}
		else {
			return true;
		}
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
	public ArrayList<SpostamentoLezione> visualizzaRichieste(){
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
            System.out.println("Lo spostamento" +s.getIdSpost() + " è stato approvato! ");
        } else {
            System.out.println("Impossibile approvare: lo spostamento è già nello stato " + s.getStato());
        }
    }
	/**
	 * Riceve una nuova richiesta
	 * @param s
	 */
	public void riceviRichiesta(SpostamentoLezione s) {
		if(s!=null) {
			this.spostamenti.add(s);
			System.out.println("Spostamento" + s.getIdSpost() + " ricevuto con successo.");
		}
	}
	public void visualizzaConflitti() {
        System.out.println("\n--- VERIFICA CONFLITTI ---");
        boolean conflittiTrovati = false;

        // Confronta ogni richiesta con le successive per evitare doppioni
        for (int i = 0; i < spostamenti.size(); i++) {
            for (int j = i + 1; j < spostamenti.size(); j++) {
                SpostamentoLezione s1 = spostamenti.get(i);
                SpostamentoLezione s2 = spostamenti.get(j);

                if (s1.vaInConflittoCon(s2)) {
                    conflittiTrovati = true;
                    System.out.println("CONFLITTO RILEVATO nell'aula " + s1.getAula() + ":");
                    System.out.println("  - Spostamento A: " + s1.getIdSpost() + " (" + s1.getGiornoIniziale() +s1.getOrarioIniziale()+ " -> " + s1.getGiornoProposto() +s1.getOrarioProposto()+")");
                    System.out.println("  - Spostamento B: " + s2.getIdSpost() + " (" + s2.getGiornoIniziale() +s2.getOrarioIniziale()+ " -> " + s2.getGiornoProposto() +s2.getOrarioProposto()+")");
                }
            }
        }

        if (!conflittiTrovati) {
            System.out.println("Nessun conflitto rilevato tra le richieste.");
        }
    }
	public void rifiutaRichiesta(SpostamentoLezione s) {
		if(s==null) {
			throw new IllegalArgumentException("Impossibile avere una richiesta nulla");
		}
		if(s.getStato()==Stato.IN_ATTESA) {
			s.setStato(Stato.RIFIUTATA);
			System.out.println("Lo spostamento"+s.getIdSpost()+"è stato rifiutato!");
		}
		else {
			System.out.println("Spostamento già rifiutato");
		}
		
	}
	}

