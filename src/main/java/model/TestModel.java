package model;

import java.util.ArrayList;
import java.util.List;

public class TestModel {

	public static void main(String[] args) {
		Utente u = new Utente("topolino","minni");
		System.out.println(u.login("pippo","pluto"));
		System.out.println(u.login("topolino","minni"));
		//Test studente
		Studente studente1 = new Studente("mario.rossi", "pass123", "100200300");
		System.out.println(studente1.login("mario rossi","pass123"));
		System.out.println(studente1.getMatricola());

		//Test docente
		Docente prof1 = new Docente("luigi.bianchi", "profpass");
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
	}

}
