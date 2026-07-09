package Progetto;
import java.time.LocalTime;
public class Lezione {
	Insegnamento insegnamento;
	giornoSettimana giorno;
	LocalTime oraInizio;
	LocalTime oraFine;
	Aula aulaAssegnata;
	public Lezione(Insegnamento insegnamento,giornoSettimana giorno,LocalTime oraInizio,LocalTime oraFine,Aula aulaAssegnata) {
		this.insegnamento=insegnamento;
		this.giorno=giorno;
		this.oraInizio=oraInizio;
		this.oraFine=oraFine;
		this.aulaAssegnata=aulaAssegnata;
	}
}
