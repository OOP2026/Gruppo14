package model;

public class Spostamento_Lezione {
    String orarioIniziale;
    String orarioProposto;
    String giornoIniziale;
    String giornoProposto;
    Docente richiedente;
    enum Stato{ inAttesa,approvata,rifiutata}
    Stato stato;
    Spostamento_Lezione(String orarioIniziale,String giornoIniziale,String orarioProposto,String giornoProposto,Docente richiedente){
        this.orarioIniziale=orarioIniziale;
        this.orarioProposto=orarioProposto;
        this.giornoIniziale= giornoIniziale;
        this.giornoProposto=giornoProposto;
        this.richiedente=richiedente;
        this.stato=Stato.inAttesa;

    }


    @Override
    public String toString() {
        return "Richiesta di " + richiedente.nome + ": "
                + giornoIniziale + " " + orarioIniziale
                + " → " + giornoProposto + " " + orarioProposto
                + " [" + stato + "]";
    }
}
