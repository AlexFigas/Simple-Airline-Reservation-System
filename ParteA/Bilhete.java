package tps.tp4.ParteA;

import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Alexandre Figueiredo A48577 21D-A
 * @version 1.02
 */
public class Bilhete {
    private static final List<Bilhete> bilhetes = new ArrayList<>();
    /* Get actual class name to be printed on */
    static Logger log = Logger.getLogger(Bilhete.class.getName());
    private final int lugar;
    private final String horaPartida;
    private final int numeroVoo;
    private final Passageiro passageiro;
    private final Voo voo;
    private double preco;

    /**
     * Construtor
     *
     * @param v     Voo comprado
     * @param lugar Lugar do Voo comprado
     */
    public Bilhete(Voo v, Passageiro p, int lugar) {
        if (v == null) {
            log.error("O voo não pode ser nulo.");
            throw new IllegalArgumentException("O voo não pode ser nulo.");
        } else if (lugar <= 0) {
            log.error("O lugar não pode ser menor 0");
            throw new IllegalArgumentException("O lugar não pode ser menor 0");
        } else if (lugar > v.getCapacidade()) {
            log.error("O número do lugar não pode ser maior do que a capacidade do avião");
            throw new IllegalArgumentException("O número do lugar não pode ser maior do que a capacidade do avião");
        }
        this.voo = v;
        preco = v.getPrecoOriginal(v.getDistancia());
        this.lugar = lugar;
        horaPartida = v.getHoraPartida();
        numeroVoo = v.getNumeroVoo();
        passageiro = p;
        bilhetes.add(this);
        log.info("Bilhete criado");
    }

    public static List<Bilhete> getListaBilhetes() {
        return bilhetes;
    }

    /**
     * Método Main
     */
    public static void main(String[] args) {
        Voo v1 = new Voo("Lisboa", "Paris", 2000, "12:50", 20);
        Voo v2 = new Voo("Paris", "Lisboa", 2000, "12:50", 20);

        // Teste ao Construtor
        Membro m = new Membro(123, 321, "Alexandre");
        Bilhete b1 = m.comprar(v1);
        m.comprar(v1);
        m.comprar(v1);
        m.comprar(v2);

        // Teste ao getPreco
        System.out.println(b1.getPreco());
        System.out.println();

        // Teste ao setPreco
        b1.setPreco(69);
        System.out.println(b1.getPreco());
        System.out.println();

        // Teste ao toString
        System.out.println(b1);
        System.out.println();

        // Teste aos Erros
        try {
            new Bilhete(v1, m, 25);
        } catch (IllegalArgumentException ex) {
            ex.printStackTrace();
        }

        try {
            new Bilhete(v1, m, 0);
        } catch (IllegalArgumentException ex) {
            ex.printStackTrace();
        }

        try {
            new Bilhete(null, m, 0);
        } catch (IllegalArgumentException ex) {
            ex.printStackTrace();
        }
    }

    public Voo getVoo() {
        return voo;
    }

    /**
     * @return Preço do Bilhete
     */
    public double getPreco() {
        log.info("Getting preço");
        return preco;
    }

    /**
     * @param preco Novo preço a atribuir ao Bilhete
     */
    public void setPreco(double preco) {
        log.info("Setting preço");
        this.preco = preco;
    }

    /**
     * @return O lugar reservado para o Passageiro no Bilhete
     */
    public int getLugar() {
        return lugar;
    }

    /**
     * @return Hora de Partida do Voo
     */
    public String getHoraPartida() {
        log.info("Getting hora de partida");
        return horaPartida;
    }

    public int getNumeroVoo() {
        return numeroVoo;
    }

    public Passageiro getPassageiro() {
        return passageiro;
    }

    /**
     * @return String com as informações do Bilhete
     */
    @Override
    public String toString() {
        log.info("Bilhete to String");
        return "[Voo: '" + getNumeroVoo() + "', Nome: '" + getPassageiro().getNome() + "', Lugar: '" + getLugar() + "', Hora de Partida: '" + getHoraPartida() +
                "', Preço: '" + getPreco() + "']";
    }
}
