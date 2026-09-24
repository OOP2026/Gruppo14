package model;
import java.util.*;
import java.time.*;
public class Orario {
String idOrario;
Insegnamento corso;
AnnoCorso anno;
GiornoSettimana giorno;
LocalTime inizio;
LocalTime fine;
Docente docente;
Aula aula;
ArrayList<Lezione> lezioni;
/**
 * Costruttore della classe Orario:
 * @param corso
 * @param anno
 * @param l
 * @param g
 * @param i
 * @param f
 * @param d
 * @param a
 */
	public Orario(String idOrario,AnnoCorso anno) {
		this.idOrario=idOrario;
		this.anno=anno;
		lezioni=new ArrayList<>();
		// TODO Auto-generated constructor stub
	}
	/**
      * Verifica i conflitti tra due o più lezioni nello stesso orario
	 * @param altraLez
	 * @return
	 */
	public boolean verificaConflitti(Lezione altraLez) {
		if (this.giorno !=altraLez.getGiorno()) {
            return false;
        }
        
        /**
         *  Verifica la sovrapposizione temporale (intervalli aperti/chiusi)
         */
        /**
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
 * Aggiunge una lezione verificando che non ci siano sovrapposizioni d'orario.
 * @param nuovaLezione la lezione da aggiungere
 * @throws Exception se la lezione si sovrappone a una già esistente
 */
public void aggiungiLezione(Lezione nuovaLezione) throws Exception {
    if (nuovaLezione == null) {
        throw new IllegalArgumentException("La lezione non può essere nulla.");
    }

    for (Lezione l : lezioni) {
        // Controlla se le due lezioni sono nello stesso giorno
        if (l.getGiorno().equals(nuovaLezione.getGiorno())) {
            
            // Verifica sovrapposizione temporale:
            // (inizio1 < fine2) AND (inizio2 < fine1)
            boolean sovrapposizione = nuovaLezione.getOraInizio().isBefore(l.getOraFine()) && 
                                     l.getOraInizio().isBefore(nuovaLezione.getOraFine());

            if (sovrapposizione) {
                throw new Exception("Conflitto d'orario: esiste già una lezione il " 
                        + nuovaLezione.getGiorno() + " tra le " 
                        + l.getOraInizio() + " e le " + l.getOraFine());
            }
        }
    }

    // Se non ci sono sovrapposizioni, aggiunge la lezione
    this.lezioni.add(nuovaLezione);
}
	public ArrayList<Lezione> getLezioni(){
		return lezioni;
	}
}


