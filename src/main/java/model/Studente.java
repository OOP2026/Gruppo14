package model;
import java.util.List;
import java.util.ArrayList;
public class Studente extends Utente {
    private final String  Matricola;
    int annoDiCorso;
    String facolta;


    public Studente (String login, String password ,String Matricola, String email, String nome, String cognome,int annoDiCorso,String facolta){
        //Chiamo il costruttore di utente
        super(login,password,email,nome,cognome);
        this.Matricola=Matricola;
        this.annoDiCorso=annoDiCorso;
        this.facolta=facolta;
    }
    public String getMatricola() {
        return Matricola;
    }

    public Orario visualizzaOrario(Orario attuale,int annoDiCorso,String facolta){
        if (attuale.getAnno() == annoDiCorso && attuale.getCorso().equals(facolta)) {
            return attuale; // L'orario è già filtrato per corso e anno
        } else {
            System.out.println("Nessun orario disponibile per il corso '"
                    + facolta + "' anno " + annoDiCorso);
            return new Orario(); // Orario vuoto
        }
    }

}
