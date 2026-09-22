package controller;
import java.time.*;
import Progetto.*;
import GUI.*;
import java.util.ArrayList;
import java.util.List;
public class Controller {

	    /**
	     *  Liste in memoria per simulare il database (niente persistenza per ora)
	     */
		private List<Utente> utenti;
	    private List<SpostamentoLezione> richiesteSpostamento;
	    private List<Orario> orari;
	    private Utente utenteLoggato;
	    private Insegnamento i1;
	    private ArrayList<Insegnamento>insegnamenti=new ArrayList<>();
	    private Insegnamento i2;
	    private Docente d1;
	    private Docente d2;
	    private Aula aula;
	    private Responsabile r;
	    private Orario o;
	    private ArrayList<Lezione> l;
	    /**
	     * Costruttore controller
	     */
	    public Controller() {
	        this.utenti = new ArrayList<>();
	        this.richiesteSpostamento = new ArrayList<>();
	        this.orari = new ArrayList<>();
	        this.d1=new Docente("Silvio","Barra","silviobarra15@gmail.com","Dfvdffg05","sbarra_15");
	        this.d2=new Docente("Porfirio","Tramontana","porfiriotramontana8@gmail.com","CFdcfd34","porfytram_56");
	        this.i1=new Insegnamento("Basi di Dati",LocalDate.of(2026, 3, 1),LocalDate.of(2027, 1, 7),d1,12);
	        this.i2=new Insegnamento("Programmazione OOP",LocalDate.of(2026, 4, 5),LocalDate.of(2027, 1, 19),d2,9);
	        this.aula=new Aula("A6");
	        this.l=new ArrayList<>();
	        this.r=new Responsabile("Giuseppe","Esposito","giuseppeesposito_04@gmail.com","Dcfdej19","giuseespo_19",i1);
	        
	        /**
	         *  Si possono popolare qui dei dati di prova (mock data) per testare l'app
	         */
	        popolaDatiIniziali();
	    }
	    // --- METODI P
	    /**
	     * ritorna l'utente che esegue una richiesta HTTP per personalizzare i dati o eseguire operazioni riservate.
	     * @return utenteLoggato
	     */
	    public Utente getUtenteLoggato() {
	        return utenteLoggato;
	    }

	    /**
	     * Ottiene l'orario di ogni singolo studente
	     * @param s
	     * @return metodo che ritorna oggetto di tipo Orario
	     */
	    public Orario getOrarioStudente(Studente s) {
	        return s.visualizzaOrario();
	    }

	    /**
	     * Aggiunge una richiesta alla lista di spostamenti
	     * @param spostamento
	     */
	    public void creaRichiestaSpostamento(SpostamentoLezione spostamento) {
	        richiesteSpostamento.add(spostamento);
	    }
	    /**
	     * Permette di ottenere tutte le richieste non ancora accettate o rifiutate
	     * @return richiesteSpostamento
	     */
	    public List<SpostamentoLezione> getRichiestePendenti() {
	        return richiesteSpostamento;
	    }
	    /**
	     * Metodo per approvare una richiesta di spostamento 
	     * @param s
	     */
	    public void approvaRichiesta(SpostamentoLezione s) {
	        // Logica per aggiornare lo stato e l'orario tramite il Model
	        s.setStato(Stato.APPROVATA);
	    }
	    /**
	     * Ritorna lista di insegnamenti
	     * @return insegnamenti
	     */
	    public ArrayList<Insegnamento> getInsegnamenti(){
	    	return insegnamenti;
	    }
	    /**
	     * Metodo per aggiungere una nuova lezione
	     * @param insegnamento
	     * @param giorno
	     * @param oraInizio
	     * @param oraFine
	     * @param nomeAula
	     */
	    public void aggiungiLezione(Insegnamento insegnamento, String giorno, String oraInizio, String oraFine, String nomeAula) throws Exception {
	        
	        // 1. Recupera il docente associato a questo insegnamento (se presente)
	        Docente docente = insegnamento.getDocente(); 

	        // 2. Crea l'oggetto Aula
	        Aula aula = new Aula(nomeAula);

	        // 3. Istanzia la nuova Lezione
	        Lezione nuovaLezione = new Lezione(GiornoSettimana.LUNEDI, LocalTime.of(8, 45), LocalTime.of(10, 30), i1, aula,r,o);

	        this.l.add(nuovaLezione);

	        // 6. Assegna la lezione all'orario dello studente/docente interessato
	        if (utenteLoggato instanceof Studente) {
	            ((Studente) utenteLoggato).visualizzaOrario().aggiungiLezione(nuovaLezione);
	        }
	    }
	    /**
	     * Metodo per popolare l'applicazione con dati di prova
	     */
	    private void popolaDatiIniziali() {
	    	Studente s1=new Studente("Matteo","Gentile","mat.gentile@studenti.unina.it","mgentile_005","matt005","N86005554",AnnoCorso.I,"Informatica");
	    	this.utenti.add(s1);
	    	Lezione l1=new Lezione(GiornoSettimana.LUNEDI,LocalTime.of(8, 45),LocalTime.of(10, 30),i1,aula,r);
	    	Lezione l2=new Lezione(GiornoSettimana.MERCOLEDI,LocalTime.of(14, 0),LocalTime.of(16, 0),i2,aula,r);
	    	Orario orarioMatteo=new Orario();
	    	orarioMatteo.add(l1);
	    	orarioMatteo.add(l2);
	    	insegnamenti.add(i1);
	    	insegnamenti.add(i2);
	    	SpostamentoLezione r1=new SpostamentoLezione("N5430",l1,LocalTime.of(15, 0),GiornoSettimana.MARTEDI,LocalTime.of(17, 0));
	    	richiesteSpostamento.add(r1);
	    	s1.setOrario(orarioMatteo);
	    	
	    }
	    /**
	     * Metodo login per l'autenticazione al sistema dell'utente
	     * @param email
	     * @param login
	     * @param pass
	     * @return true o false, corrispondenti ad autenticazione riuscita o fallita
	     */
	public boolean Login(String email, String login, String pass) {
		for (Utente u : utenti) {
            // Nota: in un'applicazione reale usaresti getter, qui si simula la verifica
            if (u.login(email, login ,pass )) { 
                this.utenteLoggato = u;
                return true;
            }
        }
        return false;
	}
	/**
	 * Metodo aggiornaStatoSpostamento
	 * @param idRichiesta
	 * @param nuovoStato
	 * @throws Exception
	 */
	public void aggiornaStatoSpostamento(String idRichiesta, Stato nuovoStato) throws Exception {
		SpostamentoLezione richiestaTrovata = null;

        // 1. Cerca la richiesta nella lista per ID
        for (SpostamentoLezione s : richiesteSpostamento) {
            if (s.getIdSpost().equals(idRichiesta)) {
                richiestaTrovata = s;
                break;
            }
        }

        if (richiestaTrovata == null) {
            throw new Exception("Richiesta di spostamento con ID " + idRichiesta + " non trovata.");
        }

        // 2. Se stai usando la connessione JDBC al database PostgreSQL:
        // Qui aggiorni il record su DB. Se il trigger 'blocco_modifica_spostamento'
        // rileva che era già APPROVATO/RIFIUTATO, o se ci sono conflitti d'orario, 
        // verrà sollevata un'eccezione che blocca l'operazione.
        // spostamentoDAO.updateStato(idRichiesta, nuovoStato);

        // 3. Aggiorna lo stato dell'oggetto in memoria
        richiestaTrovata.setStato(nuovoStato);

        // 4. Se la richiesta viene APPROVATA, aggiorna la lezione corrispondente con i nuovi dati
        if ("APPROVATO".equals(nuovoStato)) {
            Lezione lezioneOriginale = richiestaTrovata.getLezione();
            if (lezioneOriginale != null) {
                lezioneOriginale.setGiorno(richiestaTrovata.getNuovoGiorno());
                lezioneOriginale.setOraInizio(richiestaTrovata.getOrarioIniziale());
                lezioneOriginale.setOraFine(richiestaTrovata.getOrarioFinale());
                if (richiestaTrovata.getAula() != null) {
                    lezioneOriginale.setAula(richiestaTrovata.getAula());
                }
            }
        }
		
	}
}
