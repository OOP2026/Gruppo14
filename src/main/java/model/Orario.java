package model;
import java.util.ArrayList;
import java.util.List;
public class Orario {
    List<Lezione> orari;

    public Orario(List<Lezione> orario){
        this.orari=new ArrayList<>(orario);
    }
    @Override
    public String toString(){
       return orari.toString();
    }
}
