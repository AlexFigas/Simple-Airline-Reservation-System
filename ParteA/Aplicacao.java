package tps.tp4.ParteA;

import org.apache.log4j.Logger;

/**
 * @author Alexandre Figueiredo A48577 21D-A
 * @version 1.02
 */
public class Aplicacao {

    /* Get actual class name to be printed on */
    static Logger log = Logger.getLogger(Aplicacao.class.getName());

    /**
     * Método aplicacao utilizado como "Aplicação" em modo consola.
     */
    public static void main(String[] args) {
        /*
        while(true) {
            String input = "";

            // Limpa os espaços em branco no início e fim da string
            input = input.trim();

            switch(input.toLowerCase()) {
                case "alterar":
                    break;
                case "listar":
                    break;
                case "ajuda":
                case "help":
                    break;
                case "inserir":
                    break;
                case "eliminar":
                    break;
                case "voltar":
                case "return":
                case "back":
                    return;
                case "sair":
                case "quit":
                    break;
                default:
                    System.out.println("Comando inválido. Execute o comando \"ajuda\" ou \"help\" para apresentar os comandos disponíveis");
                    break;
            }
         */

        // Criar Membros
        log.info("Criando membros");
        log.warn("Idade tem de se > 0");
        log.warn("Meses de subscrição tem de ser >= 0");
        log.warn("Nome tem de conter pelo menos um char");
        Membro m1 = new Membro(29, 34, "Alexandre Figueiredo");
        Membro m2 = new Membro(1, 45, "Alfredo Ribeiro");
        Membro m3 = new Membro(13, 18, "Sofia Marques");
        log.info("Membros Criados");

        // Criar Não Membros
        log.info("Criando Não Membros");
        log.warn("Idade tem de se > 0");
        log.warn("Nome tem de conter pelo menos um char");
        NaoMembro nm1 = new NaoMembro(80, "Frederico Calado");
        NaoMembro nm2 = new NaoMembro(50, "João H.");
        log.info("Membros Não Membros");

        // Criar Voos
        log.info("Criando Voos");
        log.warn("O destino não pode ser igual á origem");
        Voo v1 = new Voo("Lisboa", "Paris", 2300, "12:05", 400);
        Voo v2 = new Voo("Lisboa", "Porto", 400, "17:00", 120);
        log.info("Voos Criados");

        // Criar Login
        log.info("Criando Logins");
        log.warn("Username e password não podem ser iguais");
        new Login("Admin", "admin");
        new Login("User", "user");
        log.info("Login Criados");

        // Comprar Bilhete
        log.info("Passageiros a comprar bilhetes");
        // Membros
        m1.comprar(v1);
        m1.comprar(v2);
        m2.comprar(v1);
        m2.comprar(v2);
        m3.comprar(v2);
        // Não membros
        nm1.comprar(v1);
        nm1.comprar(v1);
        nm2.comprar(v2);
        log.info("Bilhete comprados");

        // Teste ao login
        System.out.println(Login.getListaLogin());
        System.out.println(Login.equals("Admin", "admin"));
        System.out.println(Login.equals("dmin", "admin"));
        System.out.println();

        // Caso queira ver a lista de voos
        System.out.println(Voo.getListaVoos());

        // Caso queira ver todos os Passageiros de um Voo
        System.out.println(v1.getListaPassageiros());
        System.out.println(v2.getListaPassageiros());
        System.out.println();

        // Caso queira ver bilhetes comprados por um certo passageiro
        System.out.println(m1.getListaBilhetes());
        System.out.println(nm2.getListaBilhetes());
        System.out.println();

        // Caso queira ver todos os passageiros
        System.out.println(Membro.getListaMembros());
        System.out.println(NaoMembro.getListaNaoMembros());
        System.out.println();

        // Caso queira ver a lista de bilhetes comprados
        System.out.println(Bilhete.getListaBilhetes());
        System.out.println();

    }
}
