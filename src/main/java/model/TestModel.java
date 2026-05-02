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
		Responsabile r1=new Responsabile("Luca.rossi","resppass","respmail@","Luca","Rossi");
		System.out.println(r1.login("Luca.rossi","resppass"));
		//Parte necessaria per definire gli insegnamenti attivi
		List<Elenco> InseAttivi=new ArrayList<>();
		List<String> Auledisp1=new ArrayList<>();
		List<String> Auledisp2=new ArrayList<>();
		Auledisp1.add("A6");
		Auledisp1.add("B4");
		Auledisp2.add("B3");
		Auledisp2.add("B5");

		Elenco primo=new Elenco("Matematica",8,1,"Luca rossi",Auledisp1);
		Elenco secondo=new Elenco("Fisica",6,2,"Gaetano Accardo",Auledisp2);
		InseAttivi.add(primo);
		InseAttivi.add(secondo);
		//Controllo se l'elenco di insegnamenti attivi è stato definito.
		System.out.println(r1.isDefinito());
		System.out.println(r1.definisci(InseAttivi));
		System.out.println(r1.isDefinito());
		//Crea lezione di responsabile
		r1.creaLezione("Matematica","Lunedi","11:00","13:00","B4");
		r1.creaLezione("Algebra","Giovedì","14:00","16:00","A1");
			


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
