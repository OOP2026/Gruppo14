package model;


public class Lezione {
	String insegnamento;
	String giornoSettimana;
	String oraInizio;
	String oraFine;
	String aula;

	public Lezione(String insegnamento,String giornoSettimana,String oraInizio,String oraFine,String aula) {
		this.insegnamento=insegnamento;
		this.giornoSettimana=giornoSettimana;
		this.oraInizio=oraInizio;
		this.oraFine=oraFine;
		this.aula=aula;
	}
	@Override
	public String toString() {
		return insegnamento +" "+ giornoSettimana+" (" + oraInizio + "-" + oraFine + ", " + aula + ")";
	}
}

