package Progetto;
import java.util.*;
import java.time.*;
public class Orario {
Insegnamento corso;
AnnoCorso anno;
GiornoSettimana giorno;
LocalTime inizio;
LocalTime fine;
Docente docente;
Aula aula;
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
	}


