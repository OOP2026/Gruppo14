package model;

import java.util.ArrayList;
import java.util.List;

public class TestModel {

	public static void main(String[] args) {
		Utente u = new Utente("topolino","minni","topolinomeail","Michey","Mouse");
		System.out.println(u.login("pippo","pluto"));
		System.out.println(u.login("topolino","minni"));
		//Test studente
		Studente studente1 = new Studente("mario.rossi", "pass123", "100200300","studmail@","Mario","Rossi",1,"Informaticà");
		System.out.println(studente1.login("mario rossi","pass123"));
		System.out.println(studente1.getMatricola());

		//Test docente
		Docente prof1 = new Docente("luigi.bianchi", "profpass","profmail@","Luigi","Bianchi");
		Docente prof2= new  Docente ("Paolo.rossi","profpass2","prof2mail@","Paolo","Rossi");
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
		
		r1.creaLezione("Algebra","Giovedì","14:00","16:00","A1",prof2);
		System.out.println("Lezione Creata: "+r1.creaLezione("Matematica","Lunedi","11:00","13:00","B4",prof2));


		//Test Lezione
		Lezione lez=new Lezione("Metodi Matematici","Mercoledi","17:00","19:00","A8",prof1);
		System.out.println("La lezione di "+lez.giornoSettimana+" di "+lez.insegnamento+
				" inizia alle ore "+lez.oraInizio+" e finisce alle "+lez.oraFine+"." );

		//Test Oraio
		List<Lezione> lezioni=new ArrayList<>();
		Lezione Lezione1=new Lezione("Fisica","Lunedì","9:00","11:00","B3",prof1);
		Lezione Lezione2=new Lezione("Matematica","Lunedi","11:00","13:00","B4",prof1);
		Lezione Lezione3=new Lezione("Basi di Dati","Lunedì","14:00","16:00","B3",prof1);
		lezioni.add(Lezione1);
		lezioni.add(Lezione2);
		lezioni.add(Lezione3);

		Orario Lunedi=new Orario(lezioni,"Informatica",1);
		System.out.println("Orario:"+Lunedi);
		//Test visualizza orario
		System.out.println(studente1.visualizzaOrario(Lunedi,1,"Informatica"));
		studente1.visualizzaOrario(Lunedi,2,"Ingegneria Informatica");
		//Richieste di spostamento
		Spostamento_Lezione rich1=prof1.richiediSpostamento("14:00","27/04/2026","10:00","28/04/2026",r1);
		Spostamento_Lezione rich2=new Spostamento_Lezione("14:00","27/04/2026","10:00","28/04/2026",prof1);

		System.out.println(r1.visualizzaRichieste());
		//Approva richiesta
		r1.approvaRichiesta(rich1);
		r1.rifiutaRichiesta(rich2);

		//Test vedi lezione di docente
		Orario orarioCompleto = new Orario(lezioni, "Informatica", 1);

		// Il docente visualizza solo le sue lezioni
		List<Lezione> lezioniMie = prof1.vediLezione(orarioCompleto);
		System.out.println("Lezioni di " + prof1.nome + ": " + lezioniMie);

	}

}
