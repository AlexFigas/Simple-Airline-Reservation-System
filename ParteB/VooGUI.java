package tps.tp4.ParteB;

import org.apache.log4j.Logger;
import tps.tp4.ParteA.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class VooGUI extends JFrame {
    /* Get actual class name to be printed on */
    static Logger log = Logger.getLogger(VooGUI.class.getName());

    private JButton criarButton;
    private JButton listagemButton;
    private JPanel mainPanel;
    private JButton backButton;
    private JLabel vooImage;

    /**
     * Construtor
     */
    public VooGUI() {
        this.setTitle("Menu de Voos");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(mainPanel);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setVisible(true);
        this.setSize(1100, 490);

        // Remover backgrounds
        backButton.setBorderPainted(false);
        backButton.setContentAreaFilled(false);
        backButton.setFocusPainted(false);
        backButton.setOpaque(false);
        criarButton.setBorderPainted(false);
        criarButton.setContentAreaFilled(false);
        criarButton.setFocusPainted(false);
        criarButton.setOpaque(false);
        listagemButton.setBorderPainted(false);
        listagemButton.setContentAreaFilled(false);
        listagemButton.setFocusPainted(false);
        listagemButton.setOpaque(false);

        // Icones
        Image icon = Toolkit.getDefaultToolkit().getImage("src/imagens/appIcon.png");
        this.setIconImage(icon);
        backButton.setIcon(new ImageIcon("src/imagens/backButton.png"));
        criarButton.setIcon(new ImageIcon("src/imagens/vooButton.png"));
        listagemButton.setIcon(new ImageIcon("src/imagens/listagemVoosButton.png"));
        vooImage.setIcon(new ImageIcon("src/imagens/vooImage.png"));

        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation((dim.width - this.getWidth()) / 2, (dim.height - this.getHeight()) / 2);

        criarButton.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                log.info("A abrir janela CriarVooGUI");
                new CriarVooGUI();
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
                dispose();
                log.info("A voltar janela MenuGUI");
                new MenuGUI();
            }
        });
        listagemButton.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                log.info("A abrir janela ListagemVooGUI");
                new ListagemVooGUI();
            }
        });
    }

    /**
     * Método main
     */
    public static void main(String[] args) {
        new Voo("DummyOrigin", "DummyDestination", 1452694, "20H13", 853);
        new Voo("DummyOrigin", "DummyDestination", 1452694, "20H13", 853);
        new Voo("DummyOrigin", "DummyDestination", 1452694, "20H13", 853);
        new Voo("DummyOrigin", "DummyDestination", 1452694, "20H13", 853);
        new Voo("DummyOrigin", "DummyDestination", 1452694, "20H13", 853);
        new Voo("DummyOrigin", "DummyDestination", 1452694, "20H13", 853);
        new Voo("DummyOrigin", "DummyDestination", 1452694, "20H13", 853);
        new Voo("DummyOrigin", "DummyDestination", 1452694, "20H13", 853);
        new Voo("DummyOrigin", "DummyDestination", 1452694, "20H13", 853);
        new Voo("DummyOrigin", "DummyDestination", 1452694, "20H13", 853);
        new Voo("DummyOrigin", "DummyDestination", 1452694, "20H13", 853);
        new Voo("DummyOrigin", "DummyDestination", 1452694, "20H13", 853);
        new Voo("DummyOrigin", "DummyDestination", 1452694, "20H13", 853);
        new Voo("DummyOrigin", "DummyDestination", 1452694, "20H13", 853);
        new Voo("DummyOrigin", "DummyDestination", 1452694, "20H13", 853);
        new Voo("DummyOrigin", "DummyDestination", 1452694, "20H13", 853);
        new Voo("DummyOrigin", "DummyDestination", 1452694, "20H13", 853);
        new Voo("DummyOrigin", "DummyDestination", 1452694, "20H13", 853);
        new Voo("DummyOrigin", "DummyDestination", 1452694, "20H13", 853);
        new Voo("DummyOrigin", "DummyDestination", 1452694, "20H13", 853);
        new Voo("DummyOrigin", "DummyDestination", 1452694, "20H13", 853);
        new Voo("DummyOrigin", "DummyDestination", 1452694, "20H13", 853);
        new Voo("DummyOrigin", "DummyDestination", 1452694, "20H13", 853);
        new Voo("DummyOrigin", "DummyDestination", 1452694, "20H13", 853);
        new Voo("DummyOrigin", "DummyDestination", 1452694, "20H13", 853);
        new Voo("DummyOrigin", "DummyDestination", 1452694, "20H13", 853);
        new Voo("DummyOrigin", "DummyDestination", 1452694, "20H13", 853);
        new Voo("DummyOrigin", "DummyDestination", 1452694, "20H13", 853);
        new Voo("DummyOrigin", "DummyDestination", 1452694, "20H13", 853);
        new Voo("DummyOrigin", "DummyDestination", 1452694, "20H13", 853);
        new Voo("DummyOrigin", "DummyDestination", 1452694, "20H13", 853);
        new Voo("DummyOrigin", "DummyDestination", 1452694, "20H13", 853);
        new Voo("DummyOrigin", "DummyDestination", 1452694, "20H13", 853);
        new VooGUI();
    }

    public static class ListagemPassageirosVooGUI extends JFrame {
        /* Get actual class name to be printed on */
        static Logger log = Logger.getLogger(ListagemPassageirosVooGUI.class.getName());
        Voo voo;
        private JPanel mainPanel;
        private JTable passageirosVooTable;
        private JTextField vooText;
        private JButton backButton;

        /**
         * Construtor
         *
         * @param voo voo para listar na tabela
         */
        ListagemPassageirosVooGUI(Voo voo) {
            this.voo = voo;
            this.setTitle("Listagem de Passageiros do Voo");
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.setContentPane(mainPanel);
            this.setLocationRelativeTo(null);
            this.setResizable(false);
            this.setVisible(true);
            this.pack();
            this.setSize(800, 360);

            vooText.setEditable(false);
            vooText.setText(voo.toString());

            Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
            this.setLocation((dim.width - this.getWidth()) / 2, (dim.height - this.getHeight()) / 2);

            // Remover backgrounds
            backButton.setBorderPainted(false);
            backButton.setContentAreaFilled(false);
            backButton.setFocusPainted(false);
            backButton.setOpaque(false);

            // Icones
            Image icon = Toolkit.getDefaultToolkit().getImage("src/imagens/appIcon.png");
            this.setIconImage(icon);
            backButton.setIcon(new ImageIcon("src/imagens/backButtonSmall.png"));

            backButton.addActionListener(new ActionListener() {
                /**
                 * Invoked when an action occurs.
                 *
                 * @param e the event to be processed
                 */
                @Override
                public void actionPerformed(ActionEvent e) {
                    dispose();
                    new ListagemVooGUI();
                }
            });
            log.info("ListagemPassageirosVooGUI criado");
        }

        /**
         * Método main
         */
        public static void main(String[] args) {
            Membro m = new Membro(12, 24, "Dummy1");
            new NaoMembro(90, "Alfredo Lopes");

            Voo v1 = new Voo("DummyOrigin", "DummyDestination", 1452694, "20H13", 853);
            Voo v2 = new Voo("a", "v", 1452694, "20H13", 853);
            m.comprar(v1);
            m.comprar(v1);
            m.comprar(v1);
            m.comprar(v2);
            System.out.println(Bilhete.getListaBilhetes());
            new ListagemPassageirosVooGUI(v2);
            new ListagemPassageirosVooGUI(v1);
        }

        /**
         * Cria a tabela.
         */
        private void createUIComponents() {

            // Tabela de Voos
            this.passageirosVooTable = new JTable();

            passageirosVooTable.setModel(new PassageirosGUI.ListagemPassageirosGUI.ModeloNaoEditavel(
                    new Object[][]{},
                    new String[]{"Nome", "Idade"}
            ));
            DefaultTableModel vTable = (DefaultTableModel) passageirosVooTable.getModel();

            // Preencher a tabela
            for (Passageiro i : voo.getListaPassageiros()) {
                vTable.addRow(new Object[]{i.getNome(), i.getIdade()});
            }
            passageirosVooTable.setFont(new Font("Arial", Font.PLAIN, 12));
        }
    }

    public static class CriarVooGUI extends JFrame {
        /* Get actual class name to be printed on */
        static Logger log = Logger.getLogger(CriarVooGUI.class.getName());

        private JTextField origemText;
        private JButton criarButton;
        private JButton backButton;
        private JTextField capacidadeText;
        private JTextField horaDePartidaText;
        private JTextField distanciaText;
        private JTextField destinoText;
        private JPanel mainPanel;

        /**
         * Construtor
         */
        public CriarVooGUI() {
            this.setTitle("Criar Voo");
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.setContentPane(mainPanel);
            this.setLocationRelativeTo(null);
            this.setResizable(false);
            this.setVisible(true);
            this.setSize(300, 300);

            Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
            this.setLocation((dim.width - this.getWidth()) / 2, (dim.height - this.getHeight()) / 2);

            // Remover backgrounds
            backButton.setBorderPainted(false);
            backButton.setContentAreaFilled(false);
            backButton.setFocusPainted(false);
            backButton.setOpaque(false);
            criarButton.setBorderPainted(false);
            criarButton.setContentAreaFilled(false);
            criarButton.setFocusPainted(false);
            criarButton.setOpaque(false);

            // Icones
            Image icon = Toolkit.getDefaultToolkit().getImage("src/imagens/appIcon.png");
            this.setIconImage(icon);
            backButton.setIcon(new ImageIcon("src/imagens/backButtonSmall.png"));
            criarButton.setIcon(new ImageIcon("src/imagens/criarButton.png"));

            backButton.addActionListener(new ActionListener() {
                /**
                 * Invoked when an action occurs.
                 *
                 * @param e the event to be processed
                 */
                @Override
                public void actionPerformed(ActionEvent e) {
                    dispose();
                }
            });
            criarButton.addActionListener(new ActionListener() {
                /**
                 * Invoked when an action occurs.
                 *
                 * @param e the event to be processed
                 */
                @Override
                public void actionPerformed(ActionEvent e) {
                    String origem = origemText.getText();
                    String destino = destinoText.getText();
                    String distancia = distanciaText.getText();
                    String horaPartida = horaDePartidaText.getText();
                    String capacidade = capacidadeText.getText();

                    int d = Integer.parseInt(distancia);
                    int c = Integer.parseInt(capacidade);

                    new Voo(origem, destino, d, horaPartida, c);

                    JOptionPane.showMessageDialog(null, "Voo Criado!");
                }
            });
            log.info("CriarVooGUI criado");
        }

        /**
         * Método main
         */
        public static void main(String[] args) {
            new CriarVooGUI();
        }
    }

    public static class ListagemVooGUI extends JFrame {
        /* Get actual class name to be printed on */
        static Logger log = Logger.getLogger(ListagemVooGUI.class.getName());

        private JTable voosTable;
        private JPanel mainPanel;
        private JButton backButton;

        /**
         * Construtor
         */
        ListagemVooGUI() {
            this.setTitle("Lista de Voos");
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.setContentPane(mainPanel);
            this.setLocationRelativeTo(null);
            this.setResizable(false);
            this.setVisible(true);
            this.setSize(900, 480);

            Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
            this.setLocation((dim.width - this.getWidth()) / 2, (dim.height - this.getHeight()) / 2);

            // Icones
            Image icon = Toolkit.getDefaultToolkit().getImage("src/imagens/appIcon.png");
            this.setIconImage(icon);
            backButton.setIcon(new ImageIcon("src/imagens/backButtonSmall.png"));

            // Remover backgrounds
            backButton.setBorderPainted(false);
            backButton.setContentAreaFilled(false);
            backButton.setFocusPainted(false);
            backButton.setOpaque(false);

            backButton.addActionListener(new ActionListener() {
                /**
                 * Invoked when an action occurs.
                 *
                 * @param e the event to be processed
                 */
                @Override
                public void actionPerformed(ActionEvent e) {
                    dispose();
                }
            });
        }

        /**
         * Método main
         */
        public static void main(String[] args) {
            new Voo("DummyOrigin", "DummyDestination", 1452694, "20H13", 853);
            new Voo("DummyOrigin", "DummyDestination", 1452694, "20H13", 853);
            new Voo("DummyOrigin", "DummyDestination", 1452694, "20H13", 853);
            new Voo("DummyOrigin", "DummyDestination", 1452694, "20H13", 853);
            new Voo("DummyOrigin", "DummyDestination", 1452694, "20H13", 853);
            new Voo("DummyOrigin", "DummyDestination", 1452694, "20H13", 853);
            new Voo("DummyOrigin", "DummyDestination", 1452694, "20H13", 853);
            new Voo("DummyOrigin", "DummyDestination", 1452694, "20H13", 853);
            new Voo("DummyOrigin", "DummyDestination", 1452694, "20H13", 853);
            new Voo("DummyOrigin", "DummyDestination", 1452694, "20H13", 853);
            new Voo("DummyOrigin", "DummyDestination", 1452694, "20H13", 853);
            new Voo("DummyOrigin", "DummyDestination", 1452694, "20H13", 853);
            new Voo("DummyOrigin", "DummyDestination", 1452694, "20H13", 853);
            new Voo("DummyOrigin", "DummyDestination", 1452694, "20H13", 853);
            new Voo("DummyOrigin", "DummyDestination", 1452694, "20H13", 853);
            new Voo("DummyOrigin", "DummyDestination", 1452694, "20H13", 853);
            new Voo("DummyOrigin", "DummyDestination", 1452694, "20H13", 853);
            new Voo("DummyOrigin", "DummyDestination", 1452694, "20H13", 853);
            new Voo("DummyOrigin", "DummyDestination", 1452694, "20H13", 853);
            new Voo("DummyOrigin", "DummyDestination", 1452694, "20H13", 853);
            new Voo("DummyOrigin", "DummyDestination", 1452694, "20H13", 853);
            new Voo("DummyOrigin", "DummyDestination", 1452694, "20H13", 853);
            new Voo("DummyOrigin", "DummyDestination", 1452694, "20H13", 853);
            new Voo("DummyOrigin", "DummyDestination", 1452694, "20H13", 853);
            new Voo("DummyOrigin", "DummyDestination", 1452694, "20H13", 853);
            new Voo("DummyOrigin", "DummyDestination", 1452694, "20H13", 853);
            new Voo("DummyOrigin", "DummyDestination", 1452694, "20H13", 853);
            new Voo("DummyOrigin", "DummyDestination", 1452694, "20H13", 853);
            new Voo("DummyOrigin", "DummyDestination", 1452694, "20H13", 853);
            new Voo("DummyOrigin", "DummyDestination", 1452694, "20H13", 853);
            new Voo("DummyOrigin", "DummyDestination", 1452694, "20H13", 853);
            new Voo("DummyOrigin", "DummyDestination", 1452694, "20H13", 853);
            new Voo("DummyOrigin", "DummyDestination", 1452694, "20H13", 853);
            new Voo("DummyOrigin", "DummyDestination", 1452694, "20H13", 853);
            new Voo("DummyOrigin", "DummyDestination", 1452694, "20H13", 853);
            new Voo("DummyOrigin", "DummyDestination", 1452694, "20H13", 853);
            new Voo("DummyOrigin", "DummyDestination", 1452694, "20H13", 853);
            new Voo("DummyOrigin", "DummyDestination", 1452694, "20H13", 853);
            new Voo("DummyOrigin", "DummyDestination", 1452694, "20H13", 853);
            new Voo("DummyOrigin", "DummyDestination", 1452694, "20H13", 853);
            new Voo("DummyOrigin", "DummyDestination", 1452694, "20H13", 853);
            new Voo("DummyOrigin", "DummyDestination", 1452694, "20H13", 853);
            new Voo("DummyOrigin", "DummyDestination", 1452694, "20H13", 853);
            new Voo("DummyOrigin", "DummyDestination", 1452694, "20H13", 853);
            new Voo("DummyOrigin", "DummyDestination", 1452694, "20H13", 853);
            new Voo("DummyOrigin", "DummyDestination", 1452694, "20H13", 853);
            new Voo("DummyOrigin", "DummyDestination", 1452694, "20H13", 853);
            new Voo("DummyOrigin", "DummyDestination", 1452694, "20H13", 853);
            new Voo("DummyOrigin", "DummyDestination", 1452694, "20H13", 853);
            new Voo("DummyOrigin", "DummyDestination", 1452694, "20H13", 853);
            new Voo("DummyOrigin", "DummyDestination", 1452694, "20H13", 853);
            new Voo("DummyOrigin", "DummyDestination", 1452694, "20H13", 853);
            new Voo("DummyOrigin", "DummyDestination", 1452694, "20H13", 853);
            new Voo("DummyOrigin", "DummyDestination", 1452694, "20H13", 853);
            new Voo("DummyOrigin", "DummyDestination", 1452694, "20H13", 853);
            new Voo("DummyOrigin", "DummyDestination", 1452694, "20H13", 853);
            new Voo("DummyOrigin", "DummyDestination", 1452694, "20H13", 853);
            new Voo("DummyOrigin", "DummyDestination", 1452694, "20H13", 853);
            new Voo("DummyOrigin", "DummyDestination", 1452694, "20H13", 853);
            new Voo("DummyOrigin", "DummyDestination", 1452694, "20H13", 853);
            new Voo("DummyOrigin", "DummyDestination", 1452694, "20H13", 853);
            new Voo("DummyOrigin", "DummyDestination", 1452694, "20H13", 853);
            new Voo("DummyOrigin", "DummyDestination", 1452694, "20H13", 853);
            new Voo("DummyOrigin", "DummyDestination", 1452694, "20H13", 853);
            new Voo("DummyOrigin", "DummyDestination", 1452694, "20H13", 853);
            new Voo("DummyOrigin", "DummyDestination", 1452694, "20H13", 853);
            new Voo("DummyOrigin", "DummyDestination", 1452694, "20H13", 853);
            new Voo("DummyOrigin", "DummyDestination", 1452694, "20H13", 853);
            new Voo("DummyOrigin", "DummyDestination", 1452694, "20H13", 853);
            new Voo("DummyOrigin", "DummyDestination", 1452694, "20H13", 853);
            new Voo("DummyOrigin", "DummyDestination", 1452694, "20H13", 853);
            new Voo("DummyOrigin", "DummyDestination", 1452694, "20H13", 853);
            new Voo("DummyOrigin", "DummyDestination", 1452694, "20H13", 853);
            new Voo("DummyOrigin", "DummyDestination", 1452694, "20H13", 853);
            new Voo("DummyOrigin", "DummyDestination", 1452694, "20H13", 853);
            new Voo("DummyOrigin", "DummyDestination", 1452694, "20H13", 853);
            new Voo("DummyOrigin", "DummyDestination", 1452694, "20H13", 853);
            new Voo("DummyOrigin", "DummyDestination", 1452694, "20H13", 853);
            new Voo("DummyOrigin", "DummyDestination", 1452694, "20H13", 853);
            new Voo("DummyOrigin", "DummyDestination", 1452694, "20H13", 853);
            new Voo("DummyOrigin", "DummyDestination", 1452694, "20H13", 853);
            new Voo("DummyOrigin", "DummyDestination", 1452694, "20H13", 853);
            new Voo("DummyOrigin", "DummyDestination", 1452694, "20H13", 853);
            new Voo("DummyOrigin", "DummyDestination", 1452694, "20H13", 853);
            new Voo("DummyOrigin", "DummyDestination", 1452694, "20H13", 853);
            new Voo("DummyOrigin", "DummyDestination", 1452694, "20H13", 853);
            new Voo("DummyOrigin", "DummyDestination", 1452694, "20H13", 853);
            new Voo("DummyOrigin", "DummyDestination", 1452694, "20H13", 853);
            new Voo("DummyOrigin", "DummyDestination", 1452694, "20H13", 853);
            new Voo("DummyOrigin", "DummyDestination", 1452694, "20H13", 853);
            new Voo("DummyOrigin", "DummyDestination", 1452694, "20H13", 853);
            new ListagemVooGUI();
        }

        /**
         * Cria a tabela.
         */
        private void createUIComponents() {

            // Tabela de Voos
            this.voosTable = new JTable();

            voosTable.setModel(new PassageirosGUI.ListagemPassageirosGUI.ModeloNaoEditavel(
                    new Object[][]{},
                    new String[]{"Número", "Origem", "Destino", "Hora da Partida", "Número de Lugares Disponiveis"}
            ));
            DefaultTableModel vTable = (DefaultTableModel) voosTable.getModel();

            // Preencher a tabela
            for (Voo i : Voo.getListaVoos()) {
                vTable.addRow(new Object[]{i.getNumeroVoo(), i.getOrigem(), i.getDestino(), i.getHoraPartida(),
                        i.getNumeroAssentosDisponiveis()});
            }
            voosTable.addMouseListener(new VerPassageirosVooListener());
            voosTable.setFont(new Font("Arial", Font.PLAIN, 12));
        }

        public class VerPassageirosVooListener extends MouseAdapter {

            public void mouseClicked(MouseEvent event) {
                int row = voosTable.getSelectedRow();
                Voo v = Voo.getListaVoos().get(row);
                dispose();
                new ListagemPassageirosVooGUI(v);
            }
        }
    }
}
