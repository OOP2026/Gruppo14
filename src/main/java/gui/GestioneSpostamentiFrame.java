package GUI;

import Controller.controller;
import Progetto.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
/**
 * La classe GestioneSpostamentiFrame è usata per gestire gli spostamenti delle lezioni, settando i loro stati a uno dei 3 valori:[APPROVATO,RIFIUTATO,IN_ATTESA]
 */
public class GestioneSpostamentiFrame extends JFrame {

    private controller controller;
    private JTable tabellaSpostamenti;
    private DefaultTableModel tableModel;
/**
 * Costruttore della classe GestioneSpostamentiFrame
 * @param controller
 */
    public GestioneSpostamentiFrame(controller controller) {
        this.controller = controller;

        setTitle("Gestione Richieste Spostamento");
        setSize(650, 350);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        // Tabella con le richieste
        String[] colonne = {"ID Richiesta", "Materia","Docente", "Nuovo Giorno", "Nuovo Orario Iniziale","Nuovo orario finale", "Stato"};
        tableModel = new DefaultTableModel(colonne, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        tabellaSpostamenti = new JTable(tableModel);
        add(new JScrollPane(tabellaSpostamenti), BorderLayout.CENTER);

        // Pannello inferiore per le azioni
        JPanel panelAzioni = new JPanel();
        JButton btnApprova = new JButton("Approva");
        JButton btnRifiuta = new JButton("Rifiuta");
        JButton btnChiudi = new JButton("Chiudi");

        panelAzioni.add(btnApprova);
        panelAzioni.add(btnRifiuta);
        panelAzioni.add(btnChiudi);
        add(panelAzioni, BorderLayout.SOUTH);

        // Eventi sui bottoni
        btnApprova.addActionListener(e -> gestisciRichiesta(Stato.APPROVATA));
        btnRifiuta.addActionListener(e -> gestisciRichiesta(Stato.RIFIUTATA));
        btnChiudi.addActionListener(e -> dispose());

        caricaRichieste();
    }
    /**
     * Metodo caricaRichieste, usata per aggiornare la tabella con nuove richieste
     */
    private void caricaRichieste() {
        tableModel.setRowCount(0); 
        for (SpostamentoLezione s : controller.getRichiestePendenti()) {
            Object[] riga = {s.getIdSpost(), s.getLezione().getInsegnamento().getNomeIns(),s.getLezione().getDocente().getNome()+" "+s.getLezione().getDocente().getCognome(),s.getNuovoGiorno(), s.getOrarioIniziale(),s.getOrarioFinale(), s.getStato()};
            tableModel.addRow(riga);
        }
    }
    /**
     * Metodo gestisciRichiesta, accetta un parametro di tipo Stato, che va ad aggiornare uno specifico spostamento con lo stato definito.
     * @param nuovoStato
     */
    private void gestisciRichiesta(Stato nuovoStato) {
        int selectedRow = tabellaSpostamenti.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Seleziona una richiesta dalla tabella.", "Attenzione", JOptionPane.WARNING_MESSAGE);
            return;
        }

        String idRichiesta = (String)tableModel.getValueAt(selectedRow, 0);

        try {
            // Aggiorna lo stato tramite il controller
            controller.aggiornaStatoSpostamento(idRichiesta, nuovoStato);
            JOptionPane.showMessageDialog(this, "Richiesta " + nuovoStato + " con successo!");
            caricaRichieste(); // Rinfresca la tabella
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Errore: " + ex.getMessage(), "Errore Operazione", JOptionPane.ERROR_MESSAGE);
        }
    }
}
