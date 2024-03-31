package classes;

import java.io.Serializable;

public class Produto implements Serializable {

    //declaração de atributos
    protected String nomeProduto;
    protected String categoriaProduto;
    protected double precoProduto;
    protected double dimensaoProdutoL;
    protected double dimensaoProdutoC;
    protected double dimensaoProdutoA;
    protected int quantidadeProduto;
    protected int codigoProduto;

    //construtor
    //o objetivo do construtor é requerer os seguintes atributos como obrigatórios ao utilizar
    //a classe Produto.
    public Produto(String nomeProduto, String categoriaProduto, double precoProduto, double dimensaoProdutoL, double dimensaoProdutoC, double dimensaoProdutoA, int quantidadeProduto, int codigoProduto) {
        this.nomeProduto = nomeProduto;
        this.categoriaProduto = categoriaProduto;
        this.precoProduto = precoProduto;
        this.dimensaoProdutoL = dimensaoProdutoL;
        this.dimensaoProdutoC = dimensaoProdutoC;
        this.dimensaoProdutoA = dimensaoProdutoA;
        this.quantidadeProduto = quantidadeProduto;
        this.codigoProduto = codigoProduto;
    }

    //métodos
    //o objetivo do método mostrarDados é retornar uma string com todos os dados que forem inseridos nos atributos do objeto.
    public String mostrarDados() {
        return "Produto: " + this.nomeProduto +
                "\nCategoria: " + this.categoriaProduto +
                "\nPreço: " + this.precoProduto +
                "\nDimensão: " + this.dimensaoProdutoL + " x " + this.dimensaoProdutoC + " x " + this.dimensaoProdutoA +
                "\nQuantidade: " + this.quantidadeProduto +
                "\nCódigo do produto: " + this.codigoProduto + "\n" + "----------------------------------------------------" + "\n";
    }

    public int getCodigoProduto() {
        return codigoProduto;
    }
}


