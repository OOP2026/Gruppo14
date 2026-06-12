package model;

import java.util.ArrayList;
import java.util.List;

public class Orario {
    // Gestisce la relazione di composizione (rombo nero nel diagramma) con Lezione
    private List<Lezione> listaLezioni; 
    private int annoAccademico;

    public Orario(int annoAccademico) {
        this.annoAccademico = annoAccademico;
        this.listaLezioni = new ArrayList<>();
    }

    public boolean verificaConflitti() {
        // Logica per scorrere la listaLezioni e verificare sovrapposizioni di aule o docenti
        return false;
    }

    // Getter e Setter
    public List<Lezione> getListaLezioni() { return listaLezioni; }
    public void setListaLezioni(List<Lezione> listaLezioni) { this.listaLezioni = listaLezioni; }
    public int getAnnoAccademico() { return annoAccademico; }
    public void setAnnoAccademico(int annoAccademico) { this.annoAccademico = annoAccademico; }
}