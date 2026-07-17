package Progetto;
import java.util.ArrayList;
import java.util.List;
public class ResponsabileOrari extends Utente{
public ResponsabileOrari(String nome,String cognome,String email,String password,String username) {
super(nome,cognome,email,password,username);
}
public boolean definisceInsegnamento(Insegnamento i,List<Insegnamento> listaGlobale) {
	if (i.nome == null || i.nome.trim().isEmpty() || i.numeroCFU <= 0 || i.docenteTitolare == null || i.annoCorso == null) {
        System.out.println("Errore: Dati dell'insegnamento non validi o incompleti.");
        return false;
    }
    
    // 2. Creazione dell'istanza (Oggetto reale) sfruttando l'associazione
    Insegnamento nuovoInsegnamento = new Insegnamento(i.nome,i.numeroCFU,i.annoCorso,i.docenteTitolare);
    
    // 3. Aggiunta alla lista centralizzata del sistema
    listaGlobale.add(nuovoInsegnamento);
    
    System.out.println("Insegnamento '" + i.nome + "' definito con successo e assegnato al Prof. " + i.docenteTitolare.getCognome());
    return true;
}
}