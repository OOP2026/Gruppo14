package Progetto;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
public class RichiestaSpostamento {
    // Gli attributi che hai già messo
    public giornoSettimana giornoLezione;
    public String orarioLezione;
    
    // Le associazioni: i puntatori agli oggetti coinvolti
    public ResponsabileOrari responsabileDestinatario;
    public Docente docenteRichiedente;
    
    // Ecco la traduzione della linea che hai appena aggiunto verso Lezione
    public Lezione lezioneDaSpostare; 

    // Aggiorna il costruttore per includere la lezione
    public RichiestaSpostamento(giornoSettimana giornoLezione, String orarioLezione, 
                                ResponsabileOrari responsabile, Docente docente, Lezione lezione) {
        this.giornoLezione = giornoLezione;
        this.orarioLezione = orarioLezione;
        this.responsabileDestinatario = responsabile;
        this.docenteRichiedente = docente;
        this.lezioneDaSpostare = lezione; // Assegnazione della relazione
    }

    public Lezione getLezioneDaSpostare() {
        return lezioneDaSpostare;
    }
}
