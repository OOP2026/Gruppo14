package model;
import java.util.*;
public class Responsabile extends Utente {
    List<Elenco> InsegnAttivo;
    //richiesta in attesa
    private List<Spostamento_Lezione> listarichieste = new ArrayList<>();
    public  Responsabile(String login, String password, String email, String nome, String cognome){
        super(login,password,email,nome,cognome);

    }

    public List<Elenco> definisci(List<Elenco> insegnamenti){
        this.InsegnAttivo = new ArrayList<>(insegnamenti);
        return insegnamenti;
    }

    // Controlla se l'elenco è stato definito e non è vuoto
    public boolean isDefinito(){
        return InsegnAttivo != null && !InsegnAttivo.isEmpty();
    }

    public Lezione creaLezione(String insegnamento, String giornoSettimana,
                               String oraInizio, String oraFine, String aula,Docente docAssegnato) {

        // Controlla se l'elenco è stato definito
        if (!isDefinito()) {
            System.out.println("Errore: nessun insegnamento attivo definito.");
            return null;
        }

        // Controlla se l'insegnamento richiesto esiste nell'elenco attivo
        boolean insegnamentoEsiste = false;
        for (Elenco e : InsegnAttivo) {
            if (e.nomeInsegnamento.equals(insegnamento)) {
                insegnamentoEsiste = true;
                break;
            }
        }

        if (!insegnamentoEsiste) {
            System.out.println("Errore: l'insegnamento '" + insegnamento + "' non è presente nell'elenco attivo.");
            return null;
        }

        // Crea e restituisce la lezione
        return new Lezione(insegnamento, giornoSettimana, oraInizio, oraFine, aula,docAssegnato);
    }
    //Riceve la richiesta
    public void riceviRichiesta(Spostamento_Lezione richiesta) {
        listarichieste.add(richiesta);
        System.out.println("Richiesta ricevuta: " + richiesta);
    }
    //Approva la richiesta
    public void approvaRichiesta(Spostamento_Lezione richiesta) {
        if (listarichieste.contains(richiesta)) {
            richiesta.setStato(Spostamento_Lezione.Stato.approvata);
            listarichieste.remove(richiesta);
            System.out.println("Richiesta approvata: " + richiesta);
        } else {
            System.out.println("Richiesta non trovata.");
        }
    }

    // Rifiuta la richiesta
    public void rifiutaRichiesta(Spostamento_Lezione richiesta) {
        if (listarichieste.contains(richiesta)) {
            richiesta.setStato(Spostamento_Lezione.Stato.rifiutata);
            listarichieste.remove(richiesta);
            System.out.println("Richiesta rifiutata: " + richiesta);
        } else {
            System.out.println("Richiesta non trovata.");
        }
    }

    public List<Spostamento_Lezione> visualizzaRichieste() {
        return listarichieste;
    }

    //Visualizza conflitti di Responsabile
    public void visualizzaConflitti(Orario orario) {
        List<String> conflitti = orario.verificaConflitti();

        if (conflitti.isEmpty()) {
            System.out.println("Nessun conflitto rilevato nell'orario.");
        } else {
            System.out.println("=== CONFLITTI RILEVATI (" + conflitti.size() + ") ===");
            for (String c : conflitti) {
                System.out.println("  - " + c);
            }
        }
    }
    @Override
    public String toString() {
        return InsegnAttivo.toString();
    }
}
