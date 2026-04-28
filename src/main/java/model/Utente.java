package model;

import java.util.ArrayList;

public class Utente {
    protected String login;
    protected String password;
    protected String email;
    protected String nome;
    protected String cognome;

    public Utente(String login, String password,String email,String nome, String cognome) {
        this.login = login;
        this.password = password;
        this.email=email;
        this.nome=nome;
        this.cognome=cognome;
    }


    public boolean login(String login, String password) {
        return ( login.equals(this.login) && password.equals(this.password));
    }
}
