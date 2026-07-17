package Progetto;
import java.util.List;
import java.util.ArrayList;
public class Docente extends Utente {
	public List<Insegnamento> insegnamento;
	ResponsabileOrari responsabile;
	public Docente(String nome,String cognome,String email,String password,String username,ArrayList<Insegnamento>insegnamento,ResponsabileOrari responsabile) {
		super(nome,cognome,email,password,username);
		this.insegnamento=new ArrayList<>();
		this.responsabile=responsabile;
	}
public String getCognome() {
	return cognome;
}
}
