package Progetto;
import java.util.List;
import java.util.ArrayList;
public class Aula {
	String nomeAula;
	List<Lezione>lezioniOspitate;
    public Aula(String nomeAula) {
		this.nomeAula=nomeAula;
		this.lezioniOspitate=new ArrayList<>();
	}
	public String getNomeAula() {
		return nomeAula;
	}
	public void aggiungiLezione(Lezione lezione) {
        if (lezione != null) {
            this.lezioniOspitate.add(lezione);
        }
	}
	public List<Lezione> getLezioniOspitate() {
        return lezioniOspitate;
    }
}
