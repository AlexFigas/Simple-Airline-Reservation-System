package tps.tp4.ParteA;

import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Alexandre Figueiredo A48577 21D-A
 * @version 1.02
 */
public class Membro extends Passageiro {
    private final static List<Membro> membros = new ArrayList<>();
    /* Get actual class name to be printed on */
    static Logger log = Logger.getLogger(Membro.class.getName());
    private final int mesesDeSubscricao;

    /**
     * Construtor
     *
     * @param mesesDeSubscricao Meses de subscrição consecutivos do passageiro, após algum tempo irá ter mais desconto
     *                          no bilhete comprado
     * @param idade             Idade do Passageiro
     * @param nome              Nome do Passageiro
     */
    public Membro(int mesesDeSubscricao, int idade, String nome) {
        super(idade, nome);

        if (mesesDeSubscricao <= 0) {
            log.error("A quantidade de meses da subscrição não pode ser inferior ou igual a zero");
            throw new IllegalArgumentException("A quantidade de meses da subscrição não pode ser inferior ou igual a zero");
        }

        this.mesesDeSubscricao = mesesDeSubscricao;
        membros.add(this);
        log.info("Passageiro Criado");
    }

    /**
     * Método Main
     */
    public static void main(String[] args) {
        Voo v1 = new Voo("Lisboa", "Paris", 2000, "12:50", 20);
        Voo v2 = new Voo("Haro", "Paris", 15100, "12:50", 20);

        // Teste ao Construtor
        Membro m1 = new Membro(12, 19, "Inocente Bonaparte");

        // Teste ao getNome
        System.out.println(m1.getNome());
        System.out.println();

        // Teste ao getIdade
        System.out.println(m1.getIdade());
        System.out.println();

        // Teste ao comprar e ao getListaBilhetes
        m1.comprar(v1);
        m1.comprar(v1);
        m1.comprar(v2);
        System.out.println(m1.getListaBilhetes());
        System.out.println();

        // Teste ao getMesesDeSubscricao
        System.out.println(m1.getMesesDeSubscricao());
        System.out.println();

        // Teste ao desconto
        System.out.println(m1.desconto(150));
        System.out.println();

        // Teste ao toString
        System.out.println(m1);
        System.out.println();

        // Teste aos Erros
        try {
            new Membro(0, 60, "Napolião");
        } catch (IllegalArgumentException ex) {
            ex.printStackTrace();
        }

        try {
            new Membro(10, -60, "Napolião");
        } catch (IllegalArgumentException ex) {
            ex.printStackTrace();
        }

        try {
            new Membro(10, 60, "");
        } catch (IllegalArgumentException ex) {
            ex.printStackTrace();
        }
    }

    public static List<Membro> getListaMembros() {
        return membros;
    }

    /**
     * @return Meses de subscricao do serviço
     */
    public int getMesesDeSubscricao() {
        log.info("Getting meses de subscrição");
        return mesesDeSubscricao;
    }

    /**
     * Este método obtem o preço após aplicar um desconto
     * Aplica desconto conforme a quantidade de meses sucessivos de subscrição ao serviço
     * Quanto maior a quantidade de meses maior o desconto
     *
     * @param preco Preço original do bilhete
     * @return Preço do bilhete após desconto
     */
    @Override
    public double desconto(double preco) {
        log.info("Obtendo desconto");
        int meses = getMesesDeSubscricao();

        if (meses >= 24) {
            preco = preco / 2;
            return preco;
        } else if (meses > 12) {
            preco = preco * 0.75;
            return preco;
        } else if (meses > 0) {
            preco = preco * 0.9;
            return preco;
        }

        return preco;
    }

    /**
     * @return String com as informações do Passageiro Membro
     */
    @Override
    public String toString() {
        log.info("Membro to String");
        return "[Meses de Subscrição: '" + getMesesDeSubscricao() + "', Nome: " + getNome() + "', Idade: '" +
                getIdade() + "']";
    }
}
