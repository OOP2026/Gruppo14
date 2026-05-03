package model;


import java.util.Date;

public class Lezione {
	String insegnamento;
	String giornoSettimana;
	String oraInizio;
	String oraFine;
	String aula;
	Docente docAssegnato;

	public Lezione(String insegnamento,String giornoSettimana,String oraInizio,String oraFine,String aula,Docente docAssegnato) {
		this.insegnamento=insegnamento;
		this.giornoSettimana=giornoSettimana;
		this.oraInizio=oraInizio;
		this.oraFine=oraFine;
		this.aula=aula;
		this.docAssegnato=docAssegnato;
	}
	@Override
	public String toString() {
		return insegnamento +" "+ giornoSettimana+" (" + oraInizio + "-" + oraFine + ", " + aula + ")";
	}
}

