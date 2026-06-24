package Progetto;

package domain;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class GestoreOrari {
    private List<Lezione> tutteLeLezioni = new ArrayList<>();

    // Metodo core per validare e inserire una nuova lezione senza generare conflitti
    public boolean pianificaLezione(Insegnamento ins, Aula aula, Giorno giorno, LocalTime inizio, LocalTime fine) {
        Docente docente = ins.getDocenteTitolare();

        // 1. Verifica dei vincoli personali del docente
        if (docente.haVincolo(giorno, inizio, fine)) {
            System.out.println("Errore: Il docente ha inserito un vincolo in questa fascia oraria.");
            return false;
        }

        // 2. Verifica dei conflitti strutturali con altre lezioni esistenti
        for (Lezione l : tutteLeLezioni) {
            if (l.vaInConflittoCon(giorno, inizio, fine, aula, docente)) {
                System.out.println("Errore: Conflitto di occupazione rilevato (Aula occupata o Docente già impegnato).");
                return false;
            }
        }

        // Se tutti i controlli passano, la lezione viene registrata nell'orario settimanale
        tutteLeLezioni.add(new Lezione(ins, aula, giorno, inizio, fine));
        return true;
    }
}
