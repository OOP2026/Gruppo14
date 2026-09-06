package Progetto;
public class Aula {

    // Attributo dal Class Diagram
    private String nomeAula;

    // Relazione OSPITA (molteplicità 0..1 con Lezione)
    private Lezione lezioneOspitata; // Può essere null se l'aula è libera

    // Costruttore
    public Aula(String nomeAula) {
        this.nomeAula = nomeAula;
        this.lezioneOspitata = null; // Di default l'aula non ospita alcuna lezione
    }

    // Getter e Setter per nomeAula
    public String getNomeAula() {
        return nomeAula;
    }

    public void setNomeAula(String nomeAula) {
        this.nomeAula = nomeAula;
    }

    // Gestione della relazione con Lezione (0..1)
    public Lezione getLezioneOspitata() {
        return lezioneOspitata;
    }

    public void setLezioneOspitata(Lezione lezione) {
        this.lezioneOspitata = lezione;
    }

    // Metodo di utilità per verificare se l'aula è libera
    public boolean isLibera() {
        return this.lezioneOspitata == null;
    }
}