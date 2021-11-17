package tps.tp4.ParteA;

import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author Alexandre Figueiredo A48577 21D-A
 * @version 1.02
 */
public class Voo {
    private final static List<Voo> voos = new ArrayList<>();
    /* Get actual class name to be printed on */
    static Logger log = Logger.getLogger(Voo.class.getName());
    private static int numero = 0;
    private final int distancia;
    private final List<Passageiro> passageiros = new ArrayList<>();
    private final String origem;
    private final String horaPartida;
    private final double precoOriginal;
    private final int[] lugares;
    private final String destino;
    private final int numeroVoo;
    private final int capacidade;
    private int numeroAssentosDisponiveis;

    /**
     * Construtor
     *
     * @param origem      Origem do Voo
     * @param destino     Destino do Voo
     * @param distancia   Distancia do Voo
     * @param horaPartida Hora de Partida do Voo
     * @param capacidade  Capacidade do Voo
     */
    public Voo(String origem, String destino, int distancia, String horaPartida, int capacidade) {
        if (destino.equals(origem)) {
            log.error("Destino e Origem são os mesmos");
            throw new IllegalArgumentException("Destino e Origem são os mesmos");
        }
        this.numeroVoo = numero;
        numero = numero + 1;
        this.origem = origem;
        this.destino = destino;
        // TODO calcular distancia usando o nome das cidades e talvez o http://www.geonames.org/
        this.distancia = distancia;
        this.horaPartida = horaPartida;
        this.capacidade = capacidade;
        this.numeroAssentosDisponiveis = capacidade;
        this.precoOriginal = getPrecoOriginal(this.distancia);
        voos.add(this);
        lugares = new int[capacidade];
        fill(lugares);
        log.info("Voo criado");
    }

    public static List<Voo> getListaVoos() {
        return voos;
    }

    /**
     * Método Main
     */
    public static void main(String[] args) {
        // Teste ao Construtor
        Voo v1 = new Voo("Lisboa", "Paris", 2300, "12:05", 400);
        Voo v2 = new Voo("Lisboa", "Porto", 400, "17:00", 5);

        // Teste ao toString
        System.out.println(v1);
        System.out.println(v2);
        System.out.println();

        // Teste ao reservar
        System.out.println(v2.getNumeroAssentosDisponiveis());
        v2.reservar();
        System.out.println(v2.getNumeroAssentosDisponiveis());
        v2.reservar();
        v2.reservar();
        System.out.println(v2.reservar());
        v2.reservar();
        v2.reservar();
        System.out.println(v2.reservar());
        System.out.println(v2.getNumeroAssentosDisponiveis());
        System.out.println();

        // Teste ao getNumeroLugar
        for (int i = 0; i < 6; i++) System.out.println(v2.getNumeroLugar());
        System.out.println();

        // Teste ao addPassageiros e getListaPassageiros
        Membro m1 = new Membro(24, 60, "Alexandre Figueiredo");
        NaoMembro nm2 = new NaoMembro(70, "Nuno Figueiredo");
        for (int i = 0; i < 5; i++) m1.comprar(v1);
        nm2.comprar(v1);
        m1.comprar(v1);
        System.out.println(v1.getListaPassageiros());
        System.out.println();
        System.out.println(getListaVoos());
        // Teste aos Erros
        try {
            new Voo("Lisboa", "Lisboa", 400, "17:00", 120);
        } catch (IllegalArgumentException ex) {
            ex.printStackTrace();
        }
    }

    public int getCapacidade() {
        return capacidade;
    }

    /**
     * Este método calcula o preço conforme a distância entre o ponto de partida e o destino
     *
     * @param distancia Distancia entre o ponto de partida e o destino
     * @return Preço de um Bilhete
     */
    public double getPrecoOriginal(int distancia) {
        log.info("A calcular preço original");
        return Math.round(0.0567899 * distancia);
    }

    /**
     * @param intArray Array para colocar o número dos lugares
     */
    private void fill(int[] intArray) {
        log.debug("Fill array");
        for (int i = 1; i <= intArray.length; i++) {
            intArray[i - 1] = i;
        }
    }

    /**
     * @return Distancia do Voo
     */
    public int getDistancia() {
        log.info("Getting distancia");
        return distancia;
    }

    /**
     * @return Preco Original do Voo
     */
    public double getPreco() {
        log.info("Getting preco");
        return precoOriginal;
    }

    /**
     * @return Numero de Assentos Disponiveis no Voo
     */
    public int getNumeroAssentosDisponiveis() {
        log.info("Getting numero de acentos disponiveis");
        return numeroAssentosDisponiveis;
    }

    /**
     * @param numeroAssentosDisponiveis Novo Número de Assentos Disponiveis
     */
    public void setNumeroAssentosDisponiveis(int numeroAssentosDisponiveis) {
        log.info("Setting numero de acentos disponiveis");
        this.numeroAssentosDisponiveis = numeroAssentosDisponiveis;
    }

    /**
     * @return Numero do Voo
     */
    public int getNumeroVoo() {
        log.info("Getting numero de voo");
        return numeroVoo;
    }

    /**
     * @return Destino do Voo
     */
    public String getDestino() {
        log.info("Getting destino");
        return destino;
    }

    /**
     * @return Hora da Partida do Voo
     */
    public String getHoraPartida() {
        log.info("Getting hora de partida");
        return horaPartida;
    }

    /**
     * @return Origem de Voo
     */
    public String getOrigem() {
        log.info("Getting origem");
        return origem;
    }

    /**
     * Este método efetua uma reserva de um Lugar no voo.
     *
     * @return True caso haja lugares disponiveis, false caso contrário.
     */
    public boolean reservar() {
        log.info("Reservar bilhete se possivel");
        int numeroAssentosDisponiveis = getNumeroAssentosDisponiveis();

        if (numeroAssentosDisponiveis > 0) {
            setNumeroAssentosDisponiveis(numeroAssentosDisponiveis - 1);

            return true;
        }

        return false;
    }

    /**
     * Este método gera um lugar aleatório da lista de lugares disponiveis, o lugar que é selecionado é marcado no array
     * como indisponivel (-1).
     *
     * @return Um lugar aleatório da lista de lugares disponiveis, caso não exista um lugar válido retorna -2147483648
     */
    public int getNumeroLugar() {
        log.info("Getting numero de lugar se possivel");
        int index;
        int num;
        Random r = new Random();

        do {
            index = r.nextInt(lugares.length);
            num = lugares[index];
            if (apenasValor(lugares)) {
                num = -2147483648;
                break;
            }
        } while (num == -1);

        lugares[index] = -1;
        return num;
    }

    /**
     * Este método procura no array se existem
     *
     * @param array Array de inteiros no qual queremos procurar o valor -1
     * @return True se existir apenas este valor no array, false caso contrário
     */
    private boolean apenasValor(int[] array) {
        log.debug("Procurar se existe apenas " + -1 + " no array");
        boolean flag = true;

        for (int s : array) {
            if (s != -1) {
                flag = false;
                break;
            }
        }

        return flag;
    }

    /**
     * Este método adiciona o nome do passageiro á lista de passageiros
     *
     * @param nome Nome do Passageiro
     */
    public void addPassageiro(Passageiro nome) {
        log.info("Adicionando passageiros");
        passageiros.add(nome);
    }

    /**
     * @return Lista de Passageiros do Voo
     */
    public List<Passageiro> getListaPassageiros() {
        log.info("Getting lista de passageiros");
        return passageiros;
    }

    /**
     * @return String com as informações do Voo
     */
    public String toString() {
        log.info("Voo to string");
        return "[Número: '" + getNumeroVoo() + "', Origem: '" + getOrigem() + "', Destino: '" + getDestino() +
                "', Hora de Partida: '" + getHoraPartida() + "', Preço: '" + getPreco() + "']";
    }
}
