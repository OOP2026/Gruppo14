package Progetto;

public class Docente extends Utente {
	Insegnamento insegnamento;
	public Docente(String nome,String cognome,String email,String password,Insegnamento insegnamento) {
		super(nome,cognome,email,password);
		this.insegnamento=insegnamento;
	}

}
