package model;
import java.util.*;
public class Responsabile extends Utente {
    List<Elenco> InsegnAttivo;

    public  Responsabile(String login, String password, String email, String nome, String cognome){
        super(login,password,email,nome,cognome);

    }



}
