package GUI;

import ControllerPackage.Controller;
import Progetto.*;
import java.awt.*;
import javax.swing.*;

public class GestioneLezioniFrame extends JFrame {

    private Controller controller;
    private JComboBox<Insegnamento> comboInsegnamento;
    private JComboBox<String> comboGiorno;
    private JTextField txtOraInizio;
    private JTextField txtOraFine;
    private JTextField txtAula;
    /**
     * Costruttore della classe GestioneLezioniFrame, finestra per la gestione delle lezioni
     * @param controller
     */
    public GestioneLezioniFrame(Controller controller) {
        this.controller = controller;

        setTitle("Gestione Lezioni - Aggiungi Lezione");
        setSize(450, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new GridLayout(6, 2, 10, 10));

        // Form di inserimento
        add(new JLabel(" Insegnamento:"));
        comboInsegnamento = new JComboBox<>();
        // Popola la combo box con gli insegnamenti presenti nel controller
        for (Insegnamento ins : controller.getInsegnamenti()) {
            comboInsegnamento.addItem(ins);
        }
        add(comboInsegnamento);

        add(new JLabel(" Giorno:"));
        String[] giorni = {"Lunedì", "Martedì", "Mercoledì", "Giovedì", "Venerdì"};
        comboGiorno = new JComboBox<>(giorni);
        add(comboGiorno);

        add(new JLabel(" Ora Inizio (HH:mm):"));
        txtOraInizio = new JTextField();
        add(txtOraInizio);

        add(new JLabel(" Ora Fine (HH:mm):"));
        txtOraFine = new JTextField();
        add(txtOraFine);

        add(new JLabel(" Nome Aula:"));
        txtAula = new JTextField();
        add(txtAula);

        // Bottoni di azione
        JButton btnSalva = new JButton("Salva Lezione");
        JButton btnAnnulla = new JButton("Annulla");

        add(btnSalva);
        add(btnAnnulla);

        // Azione Salva con gestione eccezioni (cattura i trigger del DB)
        btnSalva.addActionListener(e -> salvaLezione());
        btnAnnulla.addActionListener(e -> dispose());
    }
    /**
     * Permette di compilare tutti i form della Lezione, come l'insegnamento a cui si riferisce, il giorno in cui si tiene la lezione,ecc..
     * Stampa un messaggio di avviso all'utente se lascia vuoti i campi
     * Inoltre c'è anche un blocco try catch che serve a gestire l'eccezione dovuta al corretto salvataggio della lezione 
     */
    private void salvaLezione() {
        try {
            Insegnamento ins = (Insegnamento) comboInsegnamento.getSelectedItem();
            String giorno = (String) comboGiorno.getSelectedItem();
            String oraInizio = txtOraInizio.getText().trim();
            String oraFine = txtOraFine.getText().trim();
            String nomeAula = txtAula.getText().trim();

            if (oraInizio.isEmpty() || oraFine.isEmpty() || nomeAula.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Compilare tutti i campi!", "Attenzione", JOptionPane.WARNING_MESSAGE);
                return;
            }

            // Richiesta al controller per l'inserimento
            // Se il trigger sul DB trova conflitti d'orario, l'eccezione verrà catturata qui
            controller.aggiungiLezione(ins, giorno, oraInizio, oraFine, nomeAula);

            JOptionPane.showMessageDialog(this, "Lezione aggiunta con successo!");
            dispose();

        } catch (Exception ex) {
            // Mostra l'errore generato dal trigger PostgreSQL (RAISE EXCEPTION)
            JOptionPane.showMessageDialog(this, "Errore: " + ex.getMessage(), "Errore Salvataggio", JOptionPane.ERROR_MESSAGE);
        }
    }
}
