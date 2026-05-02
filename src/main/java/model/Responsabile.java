package model;
import java.util.*;
public class Responsabile extends Utente {
    List<Elenco> InsegnAttivo;

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
                               String oraInizio, String oraFine, String aula) {

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
        return new Lezione(insegnamento, giornoSettimana, oraInizio, oraFine, aula);
    }

    @Override
    public String toString() {
        return InsegnAttivo.toString();
    }
}
