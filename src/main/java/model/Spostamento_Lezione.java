package model;

public class Spostamento_Lezione {
    private String orarioIniziale;
    private String giornoIniziale;
    private String orarioProposto;
    private String giornoProposto;
    private int id_lezione;

    public Spostamento_Lezione(String orarioIniziale, String giornoIniziale, String orarioProposto, String giornoProposto, int id_lezione) {
        this.orarioIniziale = orarioIniziale;
        this.giornoIniziale = giornoIniziale;
        this.orarioProposto = orarioProposto;
        this.giornoProposto = giornoProposto;
        this.id_lezione = id_lezione;
    }

    // Getter e Setter
    public String getOrarioIniziale() { return orarioIniziale; }
    public void setOrarioIniziale(String orarioIniziale) { this.orarioIniziale = orarioIniziale; }
    public String getGiornoIniziale() { return giornoIniziale; }
    public void setGiornoIniziale(String giornoIniziale) { this.giornoIniziale = giornoIniziale; }
    public String getOrarioProposto() { return orarioProposto; }
    public void setOrarioProposto(String orarioProposto) { this.orarioProposto = orarioProposto; }
    public String getGiornoProposto() { return giornoProposto; }
    public void setGiornoProposto(String giornoProposto) { this.giornoProposto = giornoProposto; }
    public int getId_lezione() { return id_lezione; }
    public void setId_lezione(int id_lezione) { this.id_lezione = id_lezione; }
}