package classes;

import java.io.Serializable;

public class Cliente implements Serializable {
    //ATRIBUTOS
    protected String nomeCliente;
    protected String cpfCliente;
    protected String dataNascimentoCliente;
    protected String generoCliente;
    protected String telefoneCliente;
    protected String emailCliente;
    protected String senhaCliente;
    protected String divulgacaoCliente;


    //CONSTRUTOR
    public Cliente(String nomeCliente, String cpfCliente, String dataNascimentoCliente, String generoCliente, String telefoneCliente, String emailCliente, String senhaCliente, String divulgacaoCliente) {
        this.nomeCliente = nomeCliente;
        this.cpfCliente = cpfCliente;
        this.dataNascimentoCliente = dataNascimentoCliente;
        this.generoCliente = generoCliente;
        this.telefoneCliente = telefoneCliente;
        this.emailCliente = emailCliente;
        this.senhaCliente = senhaCliente;
        this.divulgacaoCliente = divulgacaoCliente;
    }

    //MÉTODOS
    public String mostrarDadosCadastrados() {
        return "Nome do cliente: " + this.nomeCliente + "\nCpf: " + this.cpfCliente + "\nGênero: " + this.generoCliente + "\nTelefone: " + this.telefoneCliente + "\nData de Nascimento: " + this.dataNascimentoCliente + "\nEmail: " + this.emailCliente + "\nSenha: " + this.senhaCliente + "\nComo soube do nosso site: " + this.divulgacaoCliente + "\n" + "----------------------------------------------------" + "\n";
    }

    public String getCpfCliente() {
        return cpfCliente;
    }
}