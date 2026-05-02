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
}
