package Progetto;

public class Studente extends Utente {
	String matricola;
	public Studente(String nome,String cognome,String email,String password,String username,String matricola) {
		super(nome,cognome,email,password,username);
		this.matricola=matricola;
		}
	public void aggiungiMatricola(String matricola) {
		if(matricola!=null && !matricola.trim().isEmpty()) {
			this.matricola=matricola;
			System.out.println("Matricola" + matricola + "aggiunta con successo allo studente");
		}
		else {
			System.out.println("Matricola non valida!");
		}
	}
	public String getMatricola() {
		return matricola;
	}
}
