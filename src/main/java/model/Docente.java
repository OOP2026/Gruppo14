package Progetto;
import java.util.*;
public class Docente extends Utente {
	private List<SpostamentoLezione> richiesteSpostamento;
	private List<Lezione> lezioni;                         // Relazione 1 a 1..* con Lezione (TIENE)
    private Aula aulaAssociata;                            // Relazione 1 a 1 con Aula (TIENE)

    // Costruttore
    public Docente(String nome, String cognome, String email, String password, String login) {
        super(nome, cognome, email, password, login);
        this.richiesteSpostamento = new ArrayList<>();
        this.lezioni = new ArrayList<>();
    }

    // Metodo presente direttamente nel Class Diagram
    public Orario visualizzaOrario(Orario o) {
        // Restituisce l'oggetto Orario passato come parametro
        return o;
    }

    // --- Metodi di supporto per gestire le relazioni del diagramma ---

    // Aggiunge una richiesta di spostamento lezione (Relazione RICHIEDE)
    public void richiedeSpostamento(SpostamentoLezione spostamento) {
        if (spostamento != null) {
            this.richiesteSpostamento.add(spostamento);
        }
    }

    // Aggiunge una lezione tenuta dal docente (Relazione TIENE)
    public void addLezione(Lezione lezione) {
        if (lezione != null && !this.lezioni.contains(lezione)) {
            this.lezioni.add(lezione);
        }
    }

    // Getter e Setter
    public List<SpostamentoLezione> getRichiesteSpostamento() {
        return richiesteSpostamento;
    }

    public List<Lezione> getLezioni() {
        return lezioni;
    }

    public Aula getAulaAssociata() {
        return aulaAssociata;
    }

    public void setAulaAssociata(Aula aulaAssociata) {
        this.aulaAssociata = aulaAssociata;
    }
}
