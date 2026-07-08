package Progetto;
import java.util.List;
import java.util.ArrayList;
public class ResponsabileOrari extends Utente {
	public ResponsabileOrari(String nome,String cognome,String email,String password) {
		super(nome,cognome,email,password);
	}
	public boolean definisceInsegnamento(Insegnamento i) {
		if(i.nome==null ||nome.trim().isEmpty()|| i.numeroCFU<=0 || i.docenteTitolare==null || i.annoCorso==null) {
			System.out.println("Errore!!! valori non validi");
			return false;
		}
	 Insegnamento nuovoInsegnamento=new Insegnamento(i.nome,i.numeroCFU,i.annoCorso,i.docenteTitolare);
	 List<Insegnamento>listaInsegnamenti=new ArrayList<>();
	 listaInsegnamenti.add(nuovoInsegnamento);
	 System.out.println("Insegnamento '" + nome + "' definito con successo e assegnato al Prof. " + i.docenteTitolare.getCognome());
     return true;
 }
	public boolean inserisceAula(Aula a,List<Aula>elencoAule) {
		if(a==null) {
			System.out.println("Errore! aula non valida");
			return false;
		}
		for (Aula a2 : elencoAule) {
            if (a2.getNomeAula().equalsIgnoreCase(a.getNomeAula())) {
                System.out.println("Errore: L'aula " + a.getNomeAula() + " è già presente nel sistema.");
                return false;
            }
        }
		elencoAule.add(a);
		System.out.println("Aula"+a.getNomeAula()+"inserita con successo!!");
		return true;
	}
	public boolean creaLezione(Lezione l,List<Lezione>elencoLezioni) {
		if(l==null) {
			return false;
		}
		elencoLezioni.add(l);
		return true;
	}
	}
