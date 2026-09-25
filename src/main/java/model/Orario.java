package model;
import java.util.*;
import java.time.*;
public class Orario {
Insegnamento corso;
String materia;
AnnoCorso anno;
GiornoSettimana giorno;
LocalTime inizio;
LocalTime fine;
Docente docente;
Aula aula;
ArrayList<Lezione> l;
/**
 * Costruttore della classe Orario
 */
public Orario() {
	this.l=new ArrayList<>();
}
	/**
      * Verifica i conflitti tra due o più lezioni nello stesso orario
	 * @param altraLez
	 * @return true o false a seconda se sono presenti conflitti o meno
	 */
	public boolean verificaConflitti(Lezione altraLez) {
		if (this.giorno !=altraLez.getGiorno()) {
            return false;
        }
     
        /**
         *  Verifica la sovrapposizione temporale (intervalli aperti/chiusi)
         *  C'è sovrapposizione se l'inizio di una è prima della fine dell'altra e viceversa
         */
        boolean sovrapposizioneTemporale = this.inizio.isBefore(altraLez.getOraFine()) && this.fine.isAfter(altraLez.getOraInizio());
        
        if (!sovrapposizioneTemporale) {
            return false;
        }
        
        /**
         *  C'è conflitto se condividono lo stesso docente o la stessa aula
         */
        return this.docente.equals(altraLez.getDocente()) || this.aula.equals(altraLez.getAula());
    }
	@Override
	public String toString() {
		return "Orario [corso=" + corso.getNomeIns() + ", anno=" + anno + "]";
	}
	/**
	 * Aggiunge una nuova lezione all'orario
	 * @param l
	 */
	public void aggiungiLezione(Lezione l) {
		this.l.add(l);
	}
	/**
	 * Rimuove una lezione dall'orario
	 * @param l
	 */
	public void rimuoviLezione(Lezione l) {
		this.l.remove(l);
	}
	/**
	 * Ottiene le lezioni contenute nell'orario
	 * @return l
	 */
	public List<Lezione> getLezioni(){
		return l;
	}
	}


