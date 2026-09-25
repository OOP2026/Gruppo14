package model;
public class Aula {
    private String nomeAula;

    /**
     *  Relazione OSPITA (molteplicità 0..1 con Lezione): può essere null se l'aula è libera
     *  */
    private Lezione lezioneOspitata; 

   /**
    * Costruttore classe Aula
    * @param nomeAula
    */
    public Aula(String nomeAula) {
        this.nomeAula = nomeAula;
        this.lezioneOspitata = null; // Di default l'aula non ospita alcuna lezione
    }

    /**
     * Ottiene il nome dell'aula
     * @return nomeAula
     */
    public String getNomeAula() {
        return nomeAula;
    }
    /**
     * Imposta un nuovo nome all'oggetto di classe Aula
     * @param nomeAula
     */
    public void setNomeAula(String nomeAula) {
        this.nomeAula = nomeAula;
    }

    /**
     * Ottiene il nome della lezione tenuta in quell'aula,se presente
     * @return
     */
    public Lezione getLezioneOspitata() {
        return lezioneOspitata;
    }
    /**
     * Setta un nuovo nome all'oggetto di classe Lezione
     * @param lezione
     */
    public void setLezioneOspitata(Lezione lezione) {
        this.lezioneOspitata = lezione;
    }

   /**
    * Metodo di utilità per verificare se l'aula è libera
    * @return true o false
    */
    public boolean isLibera() {
        return this.lezioneOspitata==null;
    }
    /**
     * Metodo toString  serve a convertire o rappresentare un oggetto in formato di testo (stringa). 
     */
    @Override
   	public String toString() {
   		return "Aula [nomeAula=" + nomeAula + ", lezioneOspitata=" + lezioneOspitata + "]";
   	}

}