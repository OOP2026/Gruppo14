package model;
import java.util.ArrayList;
import java.util.List;
public class Orario {
    List<Lezione> orari;
    String corso;
    int anno;
    public Orario(List<Lezione> orario,String corso,int anno){
        this.orari=new ArrayList<>(orario);
        this.corso=corso;
        this.anno=anno;
    }
    //costruttore vuoto
    public Orario(){
        this.orari=new ArrayList<>();
    }
    public int getAnno() { return anno; }
    public String getCorso() { return corso; }
    @Override
    public String toString(){
       return orari.toString();
    }

    // Converte "HH:MM" in minuti totali per confronto numerico
    private int toMinuti(String ora) {
        String[] parti = ora.split(":");
        return Integer.parseInt(parti[0]) * 60 + Integer.parseInt(parti[1]);
    }
    //Verifico che le fasce orarie delle lezioni non vadino in conflitto
    protected boolean sovrapposti(Lezione a, Lezione b) {
        if (!a.giornoSettimana.equals(b.giornoSettimana)) return false;
        int inizioA = toMinuti(a.oraInizio), fineA = toMinuti(a.oraFine);
        int inizioB = toMinuti(b.oraInizio), fineB = toMinuti(b.oraFine);
        return inizioA < fineB && inizioB < fineA;
    }

    public List<String> verificaConflitti() {
        List<String> conflitti = new ArrayList<>();

        //Vedo in tutto l'orario se ci sono conflitti
        for (int i = 0; i < orari.size(); i++) {
            for (int j = i + 1; j < orari.size(); j++) {

                Lezione a = orari.get(i);
                Lezione b = orari.get(j);

                if (!sovrapposti(a, b)) continue;

                // Conflitto stessa aula nello stesso orario
                if (a.aula.equals(b.aula)) {
                    conflitti.add("CONFLITTO AULA [" + a.aula + "]: "
                            + a + " <-> " + b);
                }

                // Conflitto del docente che sostiene più lezioni contemporaneamente
                if (a.docAssegnato != null && a.docAssegnato == b.docAssegnato) {
                    conflitti.add("CONFLITTO DOCENTE ["
                            + a.docAssegnato.nome + " " + a.docAssegnato.cognome + "]: "
                            + a + " <-> " + b);
                }
            }
        }
        return conflitti;
    }
}
