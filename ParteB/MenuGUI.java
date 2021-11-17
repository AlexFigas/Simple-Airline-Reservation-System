package tps.tp4.ParteB;

import org.apache.log4j.Logger;
import tps.tp4.ParteA.Login;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuGUI extends JFrame {
    /* Get actual class name to be printed on */
    static Logger log = Logger.getLogger(MenuGUI.class.getName());

    private JButton passageirosButton;
    private JPanel mainPanel;
    private JButton backButton;
    private JButton vooButton;
    private JButton bilhetesButton;
    private JLabel menuImage;

    /**
     * Construtor
     */
    public MenuGUI() {
        this.setTitle("Menu Principal");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(mainPanel);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setVisible(true);
        this.setSize(1100, 480);

        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation((dim.width - this.getWidth()) / 2, (dim.height - this.getHeight()) / 2);

        // Remover backgrounds
        backButton.setBorderPainted(false);
        backButton.setContentAreaFilled(false);
        backButton.setFocusPainted(false);
        backButton.setOpaque(false);
        passageirosButton.setBorderPainted(false);
        passageirosButton.setContentAreaFilled(false);
        passageirosButton.setFocusPainted(false);
        passageirosButton.setOpaque(false);
        vooButton.setBorderPainted(false);
        vooButton.setContentAreaFilled(false);
        vooButton.setFocusPainted(false);
        vooButton.setOpaque(false);
        bilhetesButton.setBorderPainted(false);
        bilhetesButton.setContentAreaFilled(false);
        bilhetesButton.setFocusPainted(false);
        bilhetesButton.setOpaque(false);

        // Icones
        Image icon = Toolkit.getDefaultToolkit().getImage("src/imagens/appIcon.png");
        this.setIconImage(icon);
        backButton.setIcon(new ImageIcon("src/imagens/backButton.png"));
        passageirosButton.setIcon(new ImageIcon("src/imagens/passageirosButton.png"));
        vooButton.setIcon(new ImageIcon("src/imagens/vooButton.png"));
        bilhetesButton.setIcon(new ImageIcon("src/imagens/bilhetesButton.png"));
        menuImage.setIcon(new ImageIcon("src/imagens/menuImage.png"));

        passageirosButton.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                log.info("A abrir janela PassageirosGUI");
                new PassageirosGUI();
            }
        });
        backButton.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                int input = JOptionPane.showConfirmDialog(null, "Tem a certeza que pretende Terminar" +
                        "Sessão?", "Terminar Sessão", JOptionPane.YES_NO_OPTION);
                if (input == 0) {
                    dispose();
                    new LoginGUI();
                    log.info("A voltar janela LoginGUI");
                } else {
                    log.info("Terminar Sessão Cancelado");
                    JOptionPane.showMessageDialog(null, "Cancelado!");
                }
            }
        });
        vooButton.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                log.info("A abrir janela LoginGUI");
                new VooGUI();
            }
        });

        log.info("MenuGUI criado");
        bilhetesButton.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                new ListagemBilhetesGUI();
            }
        });
    }

    /**
     * Método main
     */
    public static void main(String[] args) {
        new MenuGUI();
    }
}
