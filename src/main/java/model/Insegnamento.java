package Progetto;
import java.util.ArrayList;
import java.util.List;
public class Insegnamento {
public String nome;
public int numeroCFU;
public AnnoCorso annoCorso;
public Docente docenteTitolare;
public List<Lezione> lezioni;
public Insegnamento(String nome,int numeroCFU,AnnoCorso annoCorso,Docente docenteTitolare) {
	this.nome=nome;
	this.numeroCFU=numeroCFU;
	this.annoCorso=annoCorso;
	this.docenteTitolare=docenteTitolare;
	this.lezioni=new ArrayList<>();
}
public String getNome() {
	return nome;
}
public int getNumeroCFU() {
	return numeroCFU;
}
public AnnoCorso getAnnoCorso() {
	return annoCorso;
}
public Docente getDocenteTitolare() {
	return docenteTitolare;
}
public List<Lezione> getLezioni() {
	return lezioni;
}
}
