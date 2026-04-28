package model;

public class Studente extends Utente {
    private final String  Matricola;

    public Studente (String login, String password ,String Matricola, String email, String nome, String cognome){
        //Chiamo il costruttore di utente
        super(login,password,email,nome,cognome);
        this.Matricola=Matricola;
    }
    public String getMatricola() {
        return Matricola;
    }
}
