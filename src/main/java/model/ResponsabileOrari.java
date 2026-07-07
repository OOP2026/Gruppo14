package Progetto;
import java.util.List;
import java.util.ArrayList;
public class ResponsabileOrari extends Utente {
	public ResponsabileOrari(String nome,String cognome,String email,String password) {
		super(nome,cognome,email,password);
	}
	public boolean definisceInsegnamento(Insegnamento i) {
		if(i.nome==null || i.numeroCFU<0 || i.docenteTitolare==null || i.annoCorso==null) {
			System.out.println("Errore!!! valori non validi");
			return false;
		}
	 Insegnamento nuovoInsegnamento=new Insegnamento(i.nome,i.numeroCFU,i.annoCorso,i.docenteTitolare);
	 List<Insegnamento>listaInsegnamenti=new ArrayList<>();
	 listaInsegnamenti.add(nuovoInsegnamento);
	 System.out.println("Insegnamento '" + nome + "' definito con successo e assegnato al Prof. " + i.docenteTitolare.getCognome());
     return true;
 }
	}
}
