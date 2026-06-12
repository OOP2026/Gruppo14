package model;

public class Utente {
    protected String nome;      // # indica protected in UML
    protected String cognome;
    protected String email;
    protected String password;
    protected String login;
    protected Ruolo ruolo;      // Associazione con l'enum Ruolo

    public Utente(String nome, String cognome, String email, String password, String login, Ruolo ruolo) {
        this.nome = nome;
        this.cognome = cognome;
        this.email = email;
        this.password = password;
        this.login = login;
        this.ruolo = ruolo;
    }

    public boolean login(String login, String password) {
        // Implementazione della logica di autenticazione
        return this.login.equals(login) && this.password.equals(password);
    }

    // Getter e Setter
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public String getCognome() { return cognome; }
    public void setCognome(String cognome) { this.cognome = cognome; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
    public String getLogin() { return login; }
    public void setLogin(String login) { this.login = login; }
    public Ruolo getRuolo() { return ruolo; }
    public void setRuolo(Ruolo ruolo) { this.ruolo = ruolo; }
}