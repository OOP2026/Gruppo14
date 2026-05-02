package model;

import java.util.ArrayList;
import java.util.List;

public class TestModel {

	public static void main(String[] args) {
		Utente u = new Utente("topolino","minni","topolinomeail","Michey","Mouse");
		System.out.println(u.login("pippo","pluto"));
		System.out.println(u.login("topolino","minni"));
		//Test studente
		Studente studente1 = new Studente("mario.rossi", "pass123", "100200300","studmail@","Mario","Rossi");
		System.out.println(studente1.login("mario rossi","pass123"));
		System.out.println(studente1.getMatricola());

		//Test docente
		Docente prof1 = new Docente("luigi.bianchi", "profpass","profmail@","Luigi","Bianchi");
		prof1.AddMateria("Analisi Matematica 1");
		prof1.AddMateria("Fisica Generale");
		prof1.AddMateria("Informatica");
		System.out.println("Info Prof Aggiornate: " + prof1.geTMaterieInsegnate());
		prof1.RemoveMateria("Fisica Generale");
		System.out.println("Info Prof dopo rimozione: " + prof1.geTMaterieInsegnate());
		List<String> nuoveMaterie = new ArrayList<>();
		nuoveMaterie.add("Sistemi Operativi");
		nuoveMaterie.add("Reti di Calcolatori");
		prof1.InserisciMaterie(nuoveMaterie);
		System.out.println("Info Prof Finali: " + prof1.geTMaterieInsegnate());

		//Test resp
		Utente r1=new Responsabile("Luca.rossi","resppass","respmail@","Luca","Rossi");
		System.out.println(r1.login("Luca.rossi","resppass"));

		//Test Lezione
		Lezione lez=new Lezione("Metodi Matematici","Mercoledi","17:00","19:00","A8");
		System.out.println("La lezione di "+lez.giornoSettimana+" di "+lez.insegnamento+
				" inizia alle ore "+lez.oraInizio+" e finisce alle "+lez.oraFine+"." );

		//Test Oraio
		List<Lezione> lezioni=new ArrayList<>();
		Lezione Lezione1=new Lezione("Fisica","Lunedì","9:00","11:00","B3");
		Lezione Lezione2=new Lezione("Matematica","Lunedi","11:00","13:00","B4");
		Lezione Lezione3=new Lezione("Basi di Dati","Lunedì","14:00","16:00","B3");
		lezioni.add(Lezione1);
		lezioni.add(Lezione2);
		lezioni.add(Lezione3);
		Orario Lunedi=new Orario(lezioni);
		System.out.println("Orario:"+Lunedi);

	}

}
