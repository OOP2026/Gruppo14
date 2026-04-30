package model;
import java.util.*;
public class Lezione {
String insegnamento;
String giornoSettimana;
Date oraInizio;
Date oraFine;
String aula;
public Lezione(String insegnamento,String giornoSettimana,Date oraInizio,Date oraFine,String aula) {
	this.insegnamento=insegnamento;
	this.giornoSettimana=giornoSettimana;
	this.oraInizio=oraInizio;
	this.oraFine=oraFine;
	this.aula=aula;
}
}
