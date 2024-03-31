package classes;

import java.io.Serializable;

public class Funcionario implements Serializable {

    //ATRIBUTOS
    protected String login;
    protected String senha;

    //CONSTRUTOR
    public Funcionario(String login, String senha) {
        this.login = login;
        this.senha = senha;
    }

    public String getLogin() {
        return login;
    }

    public String getSenha() {
        return senha;
    }
}
