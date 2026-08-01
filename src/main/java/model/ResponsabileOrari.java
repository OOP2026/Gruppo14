package Progetto;
import java.util.ArrayList;
import java.util.List;
import java.util.*;
public class ResponsabileOrari extends Utente{
/**
*Il costruttore della classe ResponsabileOrari non ha alcun attributo ed eredita tutti gli attributi ed alcuni metodi della sua superclasse Utente.
 */
public ResponsabileOrari(String nome,String cognome,HashSet<String> email,String password,String username) {
super(nome,cognome,email,password,username);
}
/**
 * 1. Metodo definisceInsegnamento, capacità di un Responsabile degli Orari di creare insegnamenti validi (ad esempio non è possibile avere come valore di Docente null)
 * @param i
 * @param listaGlobale
 * @return boolean(true o false)
 */
public boolean definisceInsegnamento(Insegnamento i,List<Insegnamento> listaGlobale) {
	if (i.nome == null || i.nome.trim().isEmpty() || i.numeroCFU <= 0 || i.docenteTitolare == null || i.annoCorso == null) {
        System.out.println("Errore: Dati dell'insegnamento non validi o incompleti.");
        return false;
    }
    
    /**
     *  2. Creazione dell'istanza (Oggetto reale) sfruttando l'associazione
     */
    Insegnamento nuovoInsegnamento = new Insegnamento(i.nome,i.numeroCFU,i.annoCorso,i.docenteTitolare,i.orari);
    
   /**
    * 3. Aggiunta alla lista centralizzata del sistema
    */
    listaGlobale.add(nuovoInsegnamento);
    /**
     * 4. Stampa dei valori dell'insegnamento
     */
    System.out.println("Insegnamento '" + i.nome + "' definito con successo e assegnato al Prof. " + i.docenteTitolare.getCognome());
    return true;
}
}