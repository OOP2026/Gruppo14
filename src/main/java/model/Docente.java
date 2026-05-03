package model;
import java.util.ArrayList;
import java.util.List;

public class Docente extends Utente{
    private List<String> Materie_Ins;
    public Docente (String login, String password,String email, String nome, String cognome){
        //Chiamo il costruttore di utente
        super(login,password,email,nome,cognome);
        this.Materie_Ins = new ArrayList<>();
    }
    public List<String> geTMaterieInsegnate(){
        return Materie_Ins;
    }
    //Metodo per aggiungere l'intera lista di materie insegnate di un docente
    public void inserisciMaterie(List<String> Materie_Ins){
        this.Materie_Ins=Materie_Ins;
    }

    //Aggiungo la singola materia che insegna il docente
    public void addMateria(String Materia){
         this.Materie_Ins.add(Materia);
    }

    //Rimuove la singola materia dalla lista
    public void removeMateria(String Materia){
        this.Materie_Ins.remove(Materia);
    }

    public Spostamento_Lezione richiediSpostamento(String orarioIniziale, String giornoIniziale,
                                                   String orarioProposto, String giornoProposto,
                                                   Responsabile responsabile) {
        Spostamento_Lezione richiesta = new Spostamento_Lezione(
                orarioIniziale, giornoIniziale,
                orarioProposto, giornoProposto,
                this // passa se stesso come richiedente
        );
        responsabile.riceviRichiesta(richiesta);
        System.out.println("Richiesta inoltrata a " + responsabile.nome);
        return richiesta;
    }

    //Vedi lezione del docente.
    public List<Lezione> vediLezione(Orario orario) {
        List<Lezione> lezioniDocente = new ArrayList<>();

        for (Lezione lezione : orario.orari) {
            if (lezione.docAssegnato == this) {  // confronto per riferimento
                lezioniDocente.add(lezione);
            }
        }

        if (lezioniDocente.isEmpty()) {
            System.out.println("Nessuna lezione trovata per " + this.nome + " " + this.cognome);
        }

        return lezioniDocente;
    }

}
