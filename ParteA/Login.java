package tps.tp4.ParteA;

import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Alexandre Figueiredo A48577 21D-A
 * @version 1.02
 */
public class Login {
    private final static List<Login> login = new ArrayList<>();

    /* Get actual class name to be printed on */
    static Logger log = Logger.getLogger(Login.class.getName());
    private final String username;
    private final String password;

    /**
     * Construtor
     *
     * @param username Username do Utilizador
     * @param password Passworrd do Utilizador
     */
    public Login(String username, String password) {
        if (username.equals("") || password.equals("")) {
            log.error("Username ou password vazios.");
            throw new IllegalArgumentException("Username ou password vazios.");
        } else if (username.equals(password)) {
            log.error("Username tem de ser diferente da password");
            throw new IllegalArgumentException("Username tem de ser diferente da password");
        }

        this.username = username;
        this.password = password;

        login.add(this);
        log.info("Login criado");
    }

    /**
     * Método Main
     */
    public static void main(String[] args) {
        // Teste do Construtor
        Login l1 = new Login("Username", "Password");

        // Teste ao login
        System.out.println(equals("Username", "Password"));
        System.out.println(equals("Username", "password"));
        System.out.println();

        // Teste toString
        System.out.println(l1);
        System.out.println();

        try {
            new Login("Same", "Same");
        } catch (IllegalArgumentException ex) {
            ex.printStackTrace();
        }
    }

    public static List<Login> getListaLogin() {
        return login;
    }

    public static boolean equals(String username, String password) {
        for (Login i : login) {
            if (i.getUsername().equals(username) && i.getPassword().equals(password)) return true;
        }
        return false;
    }

    /**
     * @return Username do Login
     */
    public String getUsername() {
        log.info("Getting username");
        return username;
    }

    /**
     * @return Password do Login
     */
    public String getPassword() {
        log.info("Getting password");
        return password;
    }

    /**
     * @return String com a informação do Login.
     */
    @Override
    public String toString() {
        log.info("Login to String");
        return "[Username: '" + getUsername() + "', Password: '" + getPassword() + "']";
    }
}
