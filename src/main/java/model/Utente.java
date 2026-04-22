package model;

import java.util.ArrayList;

public class Utente {
    protected String login;
    protected String password;
    protected String email;
    protected String nome;
    protected String cognome;

    public Utente(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public boolean login(String login, String password) {
        return ( login.equals(this.login) && password.equals(this.password));
    }
}
