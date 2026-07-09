package Progetto;
import java.util.List;
import java.util.ArrayList;
public class Orario {
	ArrayList<Lezione>l;
	public Orario(ArrayList<Lezione> l) {
		this.l=new ArrayList<>();
	}
	public List<Lezione> getListaLezione(){
		return l;
	}
}
