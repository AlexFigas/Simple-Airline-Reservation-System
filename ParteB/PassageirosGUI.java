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

public class PassageirosGUI extends JFrame {

    /* Get actual class name to be printed on */
    static Logger log = Logger.getLogger(PassageirosGUI.class.getName());

    private JButton membrosButton;
    private JButton naoMembrosButton;
    private JPanel mainPanel;
    private JButton mostrarListaPassageirosButton;
    private JButton backButton;
    private JLabel passageirosImage;

    /**
     * Construtor
     */
    public PassageirosGUI() {
        this.setTitle("Menu de Passageiros");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(mainPanel);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setVisible(true);
        this.setSize(1100, 510);

        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation((dim.width - this.getWidth()) / 2, (dim.height - this.getHeight()) / 2);

        // Remover backgrounds
        backButton.setBorderPainted(false);
        backButton.setContentAreaFilled(false);
        backButton.setFocusPainted(false);
        backButton.setOpaque(false);
        membrosButton.setBorderPainted(false);
        membrosButton.setContentAreaFilled(false);
        membrosButton.setFocusPainted(false);
        membrosButton.setOpaque(false);
        naoMembrosButton.setBorderPainted(false);
        naoMembrosButton.setContentAreaFilled(false);
        naoMembrosButton.setFocusPainted(false);
        naoMembrosButton.setOpaque(false);
        mostrarListaPassageirosButton.setBorderPainted(false);
        mostrarListaPassageirosButton.setContentAreaFilled(false);
        mostrarListaPassageirosButton.setFocusPainted(false);
        mostrarListaPassageirosButton.setOpaque(false);

        // Icones
        Image icon = Toolkit.getDefaultToolkit().getImage("src/imagens/appIcon.png");
        this.setIconImage(icon);
        backButton.setIcon(new ImageIcon("src/imagens/backButton.png"));
        membrosButton.setIcon(new ImageIcon("src/imagens/membroButton.png"));
        naoMembrosButton.setIcon(new ImageIcon("src/imagens/naoMembroButton.png"));
        mostrarListaPassageirosButton.setIcon(new ImageIcon("src/imagens/mostrarListaPassageirosButton.png"));
        passageirosImage.setIcon(new ImageIcon("src/imagens/passageirosImage.png"));

        membrosButton.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                log.info("A abrir janela MembroGUI");
                new MembroGUI();
            }
        });
        naoMembrosButton.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                log.info("A abrir janela NaoMembroGUI");
                new NaoMembroGUI();
            }
        });
        mostrarListaPassageirosButton.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                log.info("A abrir janela ListagemPassageirosGUI");
                new ListagemPassageirosGUI();
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
        log.info("PassageeirosGUI criado");
    }

    /**
     * Método main
     */
    public static void main(String[] args) {
        new PassageirosGUI();
    }

    public static class NaoMembroGUI extends JFrame {
        /* Get actual class name to be printed on */
        static Logger log = Logger.getLogger(NaoMembroGUI.class.getName());

        private JPanel mainPanel;
        private JTextField nomeText;
        private JButton criarButton;
        private JButton backButton;
        private JTextField idadeText;

        /**
         * Construtor
         */
        public NaoMembroGUI() {
            this.setTitle("Criar NaoMembro");
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.setContentPane(mainPanel);
            this.setLocationRelativeTo(null);
            this.setResizable(false);
            this.setVisible(true);
            this.setSize(250, 200);

            // Remover Backgrounds
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
                    int input = JOptionPane.showConfirmDialog(null, "Tem a certeza que pretende criar" +
                            " um NãoMembro?", "Criar NãoMembro", JOptionPane.YES_NO_OPTION);
                    if (input == 0) {
                        String nome = nomeText.getText();
                        int idade = Integer.parseInt(idadeText.getText());
                        idadeText.setText("");
                        nomeText.setText("");
                        new NaoMembro(idade, nome);
                        log.info("NãoMembro criado!");
                        JOptionPane.showMessageDialog(null, "Criado!");
                    } else {
                        log.info("Criar NãoMembro Cancelado");
                        JOptionPane.showMessageDialog(null, "Cancelado!");
                    }
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
                    log.info("A voltar janela PassageirosGUI");
                }
            });
            log.info("NaoMembroGUI criado");
        }
    }

    public static class MembroGUI extends JFrame {
        /* Get actual class name to be printed on */
        static Logger log = Logger.getLogger(MembroGUI.class.getName());

        private JTextField nomeText;
        private JTextField idadeText;
        private JTextField mesesDeSubscricaoText;
        private JButton criarButton;
        private JButton backButton;
        private JPanel mainPanel;

        /**
         * Construtor
         */
        public MembroGUI() {
            this.setTitle("Criar Membro");
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.setContentPane(mainPanel);
            this.setLocationRelativeTo(null);
            this.setResizable(false);
            this.setVisible(true);
            this.setSize(350, 250);

            // Remover Backgrounds
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
                    int input = JOptionPane.showConfirmDialog(null, "Tem a certeza que pretende criar" +
                            " um Membro?", "Criar Membro", JOptionPane.YES_NO_OPTION);
                    if (input == 0) {
                        String nome = nomeText.getText();
                        int idade = Integer.parseInt(idadeText.getText());
                        int meses = Integer.parseInt(mesesDeSubscricaoText.getText());
                        idadeText.setText("");
                        nomeText.setText("");
                        mesesDeSubscricaoText.setText("");
                        new Membro(meses, idade, nome);
                        JOptionPane.showMessageDialog(null, "Criado!");
                    } else {
                        log.info("Criar Membro Cancelado");
                        JOptionPane.showMessageDialog(null, "Cancelado!");
                    }
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
                }
            });
            log.info("NaoMembroGUI criado");
        }
    }

    public static class ListagemPassageirosGUI extends JFrame {
        /* Get actual class name to be printed on */
        static Logger log = Logger.getLogger(ListagemPassageirosGUI.class.getName());

        private JTable membrosTable;
        private JButton backButton;
        private JPanel mainPanel;
        private JTable naoMembrosTable;

        /**
         * Construtor
         */
        ListagemPassageirosGUI() {
            this.setTitle("Lista de Passageiros");
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.setContentPane(mainPanel);
            this.setLocationRelativeTo(null);
            this.setResizable(false);
            this.setVisible(true);
            this.setSize(650, 700);

            Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
            this.setLocation((dim.width - this.getWidth()) / 2, (dim.height - this.getHeight()) / 2);

            // Remover Backgrounds
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
                }
            });

            log.info("ListagemPassageirosGUI criado");
        }

        /**
         * Método main
         */
        public static void main(String[] args) {
            new Membro(12, 24, "Dummy1");
            new Membro(2, 44, "Dummy2");
            new Membro(1, 14, "Dummy3");
            new NaoMembro(24, "Dummy4");
            new NaoMembro(44, "Dummy5");
            new NaoMembro(14, "Dummy5");
            new Membro(12, 24, "Dummy6");
            new Membro(2, 44, "Dummy7");
            new Membro(1, 14, "Dummy8");
            new NaoMembro(24, "Dummy9");
            new NaoMembro(44, "Dummy10");
            new NaoMembro(14, "Dummy11");
            new Membro(12, 24, "Dummy12");
            new Membro(2, 44, "Dummy13");
            new Membro(1, 14, "Dummy14");
            new NaoMembro(24, "Dummy15");
            new NaoMembro(44, "Dummy16");
            new NaoMembro(14, "Dummy17");
            new Membro(12, 24, "Dummy1");
            new Membro(2, 44, "Dummy2");
            new Membro(1, 14, "Dummy3");
            new NaoMembro(24, "Dummy4");
            new NaoMembro(44, "Dummy5");
            new NaoMembro(14, "Dummy5");
            new Membro(12, 24, "Dummy6");
            new Membro(2, 44, "Dummy7");
            new Membro(1, 14, "Dummy8");
            new NaoMembro(24, "Dummy9");
            new NaoMembro(44, "Dummy10");
            new NaoMembro(14, "Dummy11");
            new Membro(12, 24, "Dummy12");
            new Membro(2, 44, "Dummy13");
            new Membro(1, 14, "Dummy14");
            new NaoMembro(24, "Dummy15");
            new NaoMembro(44, "Dummy16");
            new NaoMembro(14, "Dummy17");
            new Membro(12, 24, "Dummy1");
            new Membro(2, 44, "Dummy2");
            new Membro(1, 14, "Dummy3");
            new NaoMembro(24, "Dummy4");
            new NaoMembro(44, "Dummy5");
            new NaoMembro(14, "Dummy5");
            new Membro(12, 24, "Dummy6");
            new Membro(2, 44, "Dummy7");
            new Membro(1, 14, "Dummy8");
            new NaoMembro(24, "Dummy9");
            new NaoMembro(44, "Dummy10");
            new NaoMembro(14, "Dummy11");
            new Membro(12, 24, "Dummy12");
            new Membro(2, 44, "Dummy13");
            new Membro(1, 14, "Dummy14");
            new NaoMembro(24, "Dummy15");
            new NaoMembro(44, "Dummy16");
            new NaoMembro(14, "Dummy17");
            new ListagemPassageirosGUI();
        }

        /**
         * Cria as tabelas.
         */
        private void createUIComponents() {
            // Tabela de Membros
            this.membrosTable = new JTable();

            membrosTable.setModel(new ModeloNaoEditavel(
                    new Object[][]{},
                    new String[]{"Nome", "Idade", "Meses de Subscrição"}
            ));
            DefaultTableModel mTable = (DefaultTableModel) membrosTable.getModel();

            // Preencher a tabela
            for (Membro i : Membro.getListaMembros()) {
                mTable.addRow(new Object[]{i.getNome(), i.getIdade(), i.getMesesDeSubscricao()});
            }

            // Tabela de Não Membros
            this.naoMembrosTable = new JTable();

            naoMembrosTable.setModel(new ModeloNaoEditavel(
                    new Object[][]{},
                    new String[]{"Nome", "Idade"}
            ));
            DefaultTableModel nmTable = (DefaultTableModel) naoMembrosTable.getModel();

            // Preencher a tabela
            for (NaoMembro i : NaoMembro.getListaNaoMembros()) {
                nmTable.addRow(new Object[]{i.getNome(), i.getIdade()});
            }

            naoMembrosTable.addMouseListener(new NaoMembrosListener());
            membrosTable.addMouseListener(new MembrosListener());
            naoMembrosTable.setFont(new Font("Arial", Font.PLAIN, 12));
            membrosTable.setFont(new Font("Arial", Font.PLAIN, 12));
        }

        static class ModeloNaoEditavel extends DefaultTableModel {
            ModeloNaoEditavel(Object[][] data, String[] columnNames) {
                super(data, columnNames);
            }

            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }

        }

        public class NaoMembrosListener extends MouseAdapter {
            public void mouseClicked(MouseEvent event) {
                int row = naoMembrosTable.getSelectedRow();

                System.out.println(NaoMembro.getListaNaoMembros().get(row));
                dispose();
                new ComprarGUI(NaoMembro.getListaNaoMembros().get(row));
            }
        }

        public class MembrosListener extends MouseAdapter {

            public void mouseClicked(MouseEvent event) {
                int row = membrosTable.getSelectedRow();
                dispose();
                new ComprarGUI(Membro.getListaMembros().get(row));
            }
        }
    }

    public static class ComprarGUI extends JFrame {
        /* Get actual class name to be printed on */
        static Logger log = Logger.getLogger(ComprarGUI.class.getName());

        private final Passageiro passageiro;
        private JTable voosTable;
        private JPanel mainPanel;
        private JTextField passageiroInfoText;
        private JButton backButton;

        /**
         * Construtor
         *
         * @param p passageiro que quer comprar um bilhete
         */
        public ComprarGUI(Passageiro p) {
            this.setTitle("Comprar Bilhetes");
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.setContentPane(mainPanel);
            this.setLocationRelativeTo(null);
            this.setResizable(false);
            this.setVisible(true);
            this.setSize(900, 480);

            Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
            this.setLocation((dim.width - this.getWidth()) / 2, (dim.height - this.getHeight()) / 2);

            passageiroInfoText.setEditable(false);
            passageiroInfoText.setText(p.toString());
            this.passageiro = p;

            // Remover Backgrounds
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
                    new ListagemPassageirosGUI();
                }
            });
            log.info("PassageiroGUI criado");
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
            new ComprarGUI(new Membro(28, 20, "Alexandre Figueiredo"));

        }

        /**
         * Cria a tabela
         */
        private void createUIComponents() {
            // Tabela de Voos
            this.voosTable = new JTable();

            voosTable.setModel(new ListagemPassageirosGUI.ModeloNaoEditavel(
                    new Object[][]{},
                    new String[]{"Número", "Origem", "Destino", "Hora da Partida", "Número de Lugares Disponiveis"}
            ));
            DefaultTableModel vTable = (DefaultTableModel) voosTable.getModel();

            // Preencher a tabela
            for (Voo i : Voo.getListaVoos()) {
                vTable.addRow(new Object[]{i.getNumeroVoo(), i.getOrigem(), i.getDestino(), i.getHoraPartida(),
                        i.getNumeroAssentosDisponiveis()});
            }
            voosTable.addMouseListener(new ComprarListener());
            voosTable.setFont(new Font("Arial", Font.PLAIN, 12));
        }

        public class ComprarListener extends MouseAdapter {

            public void mouseClicked(MouseEvent event) {
                int input = JOptionPane.showConfirmDialog(null, "Tem a certeza que pretende comprar " +
                        "um bilhete para\n" + Voo.getListaVoos().get(voosTable.getSelectedRow()).toString() + " ?",
                        "Comprar", JOptionPane.YES_NO_OPTION);
                if (input == 0) {
                    int row = voosTable.getSelectedRow();
                    Voo v = Voo.getListaVoos().get(row);
                    String b = passageiro.comprar(v).toString();
                    voosTable.setValueAt(v.getNumeroAssentosDisponiveis(), row, 4);
                    JOptionPane.showMessageDialog(null, "Bilhete comprado com sucesso!\n" + b);
                } else {
                    JOptionPane.showMessageDialog(null, "Cancelado!");
                }
            }
        }
    }
}
