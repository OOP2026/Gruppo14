package model;

public class Responsabile extends Utente {

    public Responsabile(String nome, String cognome, String email, String password, String login) {
        super(nome, cognome, email, password, login, Ruolo.RESPONSABILE);
    }

    public void definisceInsegnamento() {
        // Logica per definire un insegnamento
    }

    public void modificaOrario() {
        // Logica per modificare l'orario delle lezioni
    }

    public void creaLezione() {
        // Logica per creare una nuova lezione
    }
}