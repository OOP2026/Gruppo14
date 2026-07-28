package Progetto;
import java.util.ArrayList;
import java.util.List;
/**
 * Classe Orario contiene 1 oppure N lezioni programmate
 */
public class Orario {
    private List<Lezione> listaLezioni;
    private List<Insegnamento> insegnamento;
/**
 * Costruttore classe insegnamento
 * @param listaLezioni
 * @param insegnamento
 */
    public Orario(List<Lezione> listaLezioni,List<Insegnamento> insegnamento) {
        this.listaLezioni = new ArrayList<>();
    }

    /**
     * Verifica se la nuova lezione si sovrappone a una già esistente nell'orario.
     * Controlla conflitti di Aula o di Docente nello stesso giorno e stessa ora.
     */
    public boolean haConflittiOrari(Lezione nuovaLezione) {
        for (Lezione esistente : listaLezioni) {
            // 1. Controlliamo se sono lo stesso giorno
            if (esistente.getGiorno() == nuovaLezione.getGiorno()) {
                
            	/**
            	 * Controlla se sono presenti 2 lezioni che vanno in conflitto
            	 */
                /**
                 *  2. Controllo della sovrapposizione oraria
                 *  (Assumendo che gli orari siano in formato "HH:mm", es. "09:00". String.compareTo funziona perfettamente)
                 */
                boolean siSovrappongono = (nuovaLezione.getOraInizio().compareTo(esistente.getOraFine()) < 0) &&
                                          (nuovaLezione.getOraFine().compareTo(esistente.getOraInizio()) > 0);
                /**
                 * Caso A: Stessa aula occupata contemporaneamente
                 */

                if (siSovrappongono) {
                    
                    if (esistente.getAulaAssegnata().equals(nuovaLezione.getAulaAssegnata())) {
                        System.out.println("Errore: L'aula " + esistente.getAulaAssegnata().getNomeAula() + " è già occupata!");
                        return true;
                    }
                    /**
                     * Caso B: Lo stesso docente è impegnato in un'altra lezione contemporaneamente
                     */
                    if (esistente.getInsegnamento().getDocenteTitolare().equals(nuovaLezione.getInsegnamento().getDocenteTitolare())) {
                        System.out.println("Errore: Il docente " + esistente.getInsegnamento().getDocenteTitolare().getCognome() + " è già impegnato!");
                        return true;
                    }
                }
            }
        }
        /**
         * Nessun conflitto trovato
         */
        return false;
    }

    /**
     * Aggiunge la lezione solo se supera il controllo di contemporaneità
     */
    public boolean aggiungiLezione(Lezione nuovaLezione) {
        if (nuovaLezione == null) return false;

        /**
         * Si esegue il blocco di sicurezza dei vincoli
         */
        if (haConflittiOrari(nuovaLezione)) {
            System.out.println("Impossibile inserire la lezione a causa di una sovrapposizione.");
            return false; 
        }

        this.listaLezioni.add(nuovaLezione);
        return true;
    }

    public List<Lezione> getListaLezioni() {
        return listaLezioni;
    }
}
