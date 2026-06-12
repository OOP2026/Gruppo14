package model;

public class Lezione {
    private String insegnamento;
    private String aula;
    private String giornoSettimana;
    private String oraInizio;
    private String oraFine;

    public Lezione(String insegnamento, String aula, String giornoSettimana, String oraInizio, String oraFine) {
        this.insegnamento = insegnamento;
        this.aula = aula;
        this.giornoSettimana = giornoSettimana;
        this.oraInizio = oraInizio;
        this.oraFine = oraFine;
    }

    // Getter e Setter
    public String getInsegnamento() { return insegnamento; }
    public void setInsegnamento(String insegnamento) { this.insegnamento = insegnamento; }
    public String getAula() { return aula; }
    public void setAula(String aula) { this.aula = aula; }
    public String getGiornoSettimana() { return giornoSettimana; }
    public void setGiornoSettimana(String giornoSettimana) { this.giornoSettimana = giornoSettimana; }
    public String getOraInizio() { return oraInizio; }
    public void setOraInizio(String oraInizio) { this.oraInizio = oraInizio; }
    public String getOraFine() { return oraFine; }
    public void setOraFine(String oraFine) { this.oraFine = oraFine; }
}