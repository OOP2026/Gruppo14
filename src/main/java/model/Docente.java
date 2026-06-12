package model;

import java.util.ArrayList;
import java.util.List;

public class Docente extends Utente {
    private List<String> materieIns; // Inizializzato come lista per la molteplicità del diagramma

    public Docente(String nome, String cognome, String email, String password, String login) {
        super(nome, cognome, email, password, login, Ruolo.DOCENTE);
        this.materieIns = new ArrayList<>();
    }

    public void addMateria(String materia) {
        if (!this.materieIns.contains(materia)) {
            this.materieIns.add(materia);
        }
    }

    public void removeMateria(String materia) {
        this.materieIns.remove(materia);
    }

    // Getter e Setter
    public List<String> getMaterieIns() { return materieIns; }
    public void setMaterieIns(List<String> materieIns) { this.materieIns = materieIns; }
}
