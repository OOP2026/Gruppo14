package model;

public class Studente extends Utente {
    private String matricola;
    private int annoDiCorso;

    public Studente(String nome, String cognome, String email, String password, String login, String matricola, int annoDiCorso) {
        super(nome, cognome, email, password, login, Ruolo.STUDENTE);
        this.matricola = matricola;
        this.annoDiCorso = annoDiCorso;
    }

    public void visualizzaOrario() {
        // Logica per mostrare l'orario allo studente
    }

    // Getter e Setter
    public String getMatricola() { return matricola; }
    public void setMatricola(String matricola) { this.matricola = matricola; }
    public int getAnnoDiCorso() { return annoDiCorso; }
    public void setAnnoDiCorso(int annoDiCorso) { this.annoDiCorso = annoDiCorso; }
}