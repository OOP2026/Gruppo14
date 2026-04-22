package model;
import java.util.ArrayList;
import java.util.List;
public class Docente extends Utente{
    private List<String> Materie_Ins;
    public Docente (String login, String password){
        //Chiamo il costruttore di utente
        super(login,password);
        this.Materie_Ins = new ArrayList<>();
    }
    public List<String> geTMaterieInsegnate(){
        return Materie_Ins;
    }
    //Metodo per aggiungere l'intera lista di materie insegnate di un docente
    public void InserisciMaterie(List<String> Materie_Ins){
        this.Materie_Ins=Materie_Ins;
    }

    //Aggiungo la singola materia che insegna il docente
    public void AddMateria(String Materia){
         this.Materie_Ins.add(Materia);
    }

    //Rimuove la singola materia dalla lista
    public void RemoveMateria(String Materia){
        this.Materie_Ins.remove(Materia);
    }

}
