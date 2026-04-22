package model;

public class Studente extends Utente {
    private String Matricola;

    public Studente (String login, String password ,String Matricola){
        //Chiamo il costruttore di utente
        super(login,password);
        this.Matricola=Matricola;
    }
}
