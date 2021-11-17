package tps.tp4.ParteA;

import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Alexandre Figueiredo A48577 21D-A
 * @version 1.02
 */
public class NaoMembro extends Passageiro {
    private final static List<NaoMembro> naoMembros = new ArrayList<>();
    /* Get actual class name to be printed on */
    static Logger log = Logger.getLogger(NaoMembro.class.getName());

    /**
     * Construtor
     *
     * @param idade - Idade do Passageiro
     * @param nome  - Nome do Passageiro
     */
    public NaoMembro(int idade, String nome) {
        super(idade, nome);
        naoMembros.add(this);
        log.info("Membro criado");
    }

    public static List<NaoMembro> getListaNaoMembros() {
        return naoMembros;
    }

    /**
     * Método Main
     */
    public static void main(String[] args) {
        Voo v1 = new Voo("Lisboa", "Paris", 2000, "12:50", 20);
        Voo v2 = new Voo("Haro", "Paris", 15100, "12:50", 20);

        // Teste ao Construtor
        NaoMembro nm1 = new NaoMembro(80, "Inocente Bonaparte");
        new NaoMembro(14, "Fisgas");

        // Teste ao getNome
        System.out.println(nm1.getNome());
        System.out.println();

        // Teste ao getIdade
        System.out.println(nm1.getIdade());
        System.out.println();

        // Teste ao comprar e ao getListaBilhetes
        nm1.comprar(v1);
        nm1.comprar(v1);
        nm1.comprar(v2);
        System.out.println(nm1.getListaBilhetes());
        System.out.println();

        // Teste ao desconto
        System.out.println(nm1.desconto(150));
        System.out.println();

        // Teste ao toString
        System.out.println(nm1);
        System.out.println();

        System.out.println(naoMembros);
        // Teste de Erros
        try {
            new NaoMembro(-10, "Napolião");
        } catch (IllegalArgumentException ex) {
            ex.printStackTrace();
        }

        try {
            new NaoMembro(10, "");
        } catch (IllegalArgumentException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Este método obtem o preço após aplicar um desconto
     * Apenas aplica desconto caso a idade do Passageiro Não Membro passar dos 65 anos
     *
     * @param preco - Preço original do bilhete
     * @return - Preço do bilhete após desconto
     */
    public double desconto(double preco) {
        log.info("Obtendo desconto se possivel");
        if (getIdade() > 65) {
            preco = preco * 0.9;
            return preco;
        }
        return preco;
    }

    /**
     * @return - String com as informações do Passageiro Não Membro
     */
    @Override
    public String toString() {
        log.info("Nao Membro to String");
        return "[Nome: '" + getNome() + "', Idade: '" + getIdade() + "']";
    }
}
