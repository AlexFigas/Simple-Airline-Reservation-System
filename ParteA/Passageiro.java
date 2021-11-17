package tps.tp4.ParteA;

import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Alexandre Figueiredo A48577 21D-A
 * @version 1.02
 */
public abstract class Passageiro {
    /* Get actual class name to be printed on */
    static Logger log = Logger.getLogger(Passageiro.class.getName());

    private final String nome;
    private final int idade;
    private final List<Bilhete> bilhetes = new ArrayList<>();

    /**
     * Construtor
     *
     * @param idade Idade do Passageiro
     * @param nome  Nome do Passageiro
     */
    public Passageiro(int idade, String nome) {
        if (idade < 0) {
            log.error("A idade nao pode ser inferior a zero.");
            throw new IllegalArgumentException("A idade nao pode ser inferior a zero.");
        } else if (nome.replaceAll("\\s+", "").length() == 0) {
            log.error("O nome tem de conter pelo menos 1 caractere.");
            throw new IllegalArgumentException("O nome tem de conter pelo menos 1 caractere.");
        }

        this.nome = nome;
        this.idade = idade;
        log.debug("Passageiro criado, vou passar agora para Membo ou NaoMembro");
    }

    public String getNome() {
        log.info("Getting Nome");
        return nome;
    }

    public int getIdade() {
        log.info("Getting Idade");
        return idade;
    }

    /**
     * Este método destina-se a criar um bilhete comprado pelo Passageiro
     *
     * @param voo Voo para o qual o bilhete é comprado
     * @return Um novo bilhete com todas as informações para o passageiro conseguir embarcar
     */
    public Bilhete comprar(Voo voo) {
        log.info("Comprar bilhete se possivel");
        boolean reserva = voo.reservar();
        int lugar;

        if (reserva) {
            lugar = voo.getNumeroLugar();
        } else {
            log.debug("Não foi possivel comprar bilhete return null");
            return null;
        }

        Bilhete bilhete = new Bilhete(voo, this, lugar);

        double preco = this.desconto(bilhete.getPreco());
        bilhete.setPreco(preco);

        bilhetes.add(bilhete);
        voo.addPassageiro(this);
        return bilhete;
    }

    public List<Bilhete> getListaBilhetes() {
        log.info("Getting lista de bilhetes");
        return bilhetes;
    }

    abstract public double desconto(double p);
}
