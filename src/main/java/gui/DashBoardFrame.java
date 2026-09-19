package GUI;

import controller.Controller;
import Progetto.*;
import java.awt.*;
import javax.swing.*;

public class DashBoardFrame extends JFrame {

    private Controller controller;
/**
 * Costruttore della classe DashBoardFrame che, come LoginFrame, estendono la loro superclasse JFrame contenente tutte le caratteristiche di una classe
 * come ridimensionamento,layout,ecc...
 * @param controller
 */
    public DashBoardFrame(Controller controller) {
        this.controller = controller;
        JButton btnGestisciLezioni = new JButton("Gestisci Lezioni");
        JButton btnGestisciSpostamenti = new JButton("Gestisci Spostamenti");

        // Apertura Gestione Lezioni
        btnGestisciLezioni.addActionListener(e -> {
            GestioneLezioniFrame fLezioni = new GestioneLezioniFrame(controller);
            fLezioni.setVisible(true);
        });

        // Apertura Gestione Spostamenti
        btnGestisciSpostamenti.addActionListener(e -> {
            GestioneSpostamentiFrame fSpostamenti = new GestioneSpostamentiFrame(controller);
            fSpostamenti.setVisible(true);
        });

        // Recupera l'utente attualmente autenticato
        Utente utente = controller.getUtenteLoggato();

        // Configurazioni base del Frame
        setTitle("Dashboard - Sistema Gestione Orari");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

        // --- 1. INTESTAZIONE (Pannello Nord) ---
        JPanel headerPanel = new JPanel();
        headerPanel.setBackground(new Color(230, 230, 250));
        JLabel lblBenvenuto = new JLabel("Benvenuto/a, " + utente.getNome() + " " + utente.getCognome());
        lblBenvenuto.setFont(new Font("Arial", Font.BOLD, 16));
        headerPanel.add(lblBenvenuto);
        add(headerPanel, BorderLayout.NORTH);

        // --- 2. MENU AZIONI (Pannello Centrale) ---
        JPanel menuPanel = new JPanel();
        menuPanel.setLayout(new GridLayout(0, 1, 10, 10)); // Layout verticale
        menuPanel.setBorder(BorderFactory.createEmptyBorder(20, 40, 20, 40));

        // Pulsante comune a tutti gli utenti
        JButton btnVisualizzaOrario = new JButton("Visualizza Orario Lezioni");
        btnVisualizzaOrario.addActionListener(e -> {
            // TODO: new OrarioFrame(controller).setVisible(true);
        	new OrarioFrame(controller).setVisible(true);
            JOptionPane.showMessageDialog(this, "Apertura orario in corso...");
        });
        menuPanel.add(btnVisualizzaOrario);

        // --- 3. CONTROLLO RUOLI (Logica Dinamica) ---
        if (utente instanceof Docente) {
            JButton btnRichiediSpostamento = new JButton("Richiedi Spostamento Lezione");
            btnRichiediSpostamento.addActionListener(e -> {
                // TODO: new RichiestaSpostamentoFrame(controller).setVisible(true);
            });
            menuPanel.add(btnRichiediSpostamento);

        } else if (utente instanceof Responsabile) {
            JButton btnGestisciRichieste = new JButton("Gestisci Richieste Pendenti");
            btnGestisciRichieste.addActionListener(e -> {
                // TODO: new ApprovazioneSpostamentiFrame(controller).setVisible(true);
            });
            menuPanel.add(btnGestisciRichieste);
        }

        add(menuPanel, BorderLayout.CENTER);

        // --- 4. PIÈ DI PAGINA / LOGOUT (Pannello Sud) ---
        JPanel bottomPanel = new JPanel();
        JButton btnLogout = new JButton("Logout");
        btnLogout.addActionListener(e -> {
            // Riapre il Login e chiude la Dashboard
            new LoginFrame(controller).setVisible(true);
            dispose();
        });
        bottomPanel.add(btnLogout);
        add(bottomPanel, BorderLayout.SOUTH);
        menuPanel.add(btnGestisciLezioni);
        menuPanel.add(btnGestisciSpostamenti);
    }
}
