package Progetto;

public class Insegnamento {
public String nome;
public int numeroCFU;
public AnnoCorso annoCorso;
public Docente docenteTitolare;
public Insegnamento(String nome,int numeroCFU,AnnoCorso annoCorso,Docente docenteTitolare) {
	this.nome=nome;
	this.numeroCFU=numeroCFU;
	this.annoCorso=annoCorso;
	this.docenteTitolare=docenteTitolare;
}
}
