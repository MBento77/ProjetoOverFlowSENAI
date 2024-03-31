package paineis;

import arquivos.LerEscreverProdutos;
import classes.LimitarCaracteres;
import classes.Produto;
import javax.swing.*;
import javax.swing.text.Document;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
public class PainelProdutos extends Panel {
    //painel produtos

    //declaração de atributos
    private JLabel jlNomeProduto, jlCategoriaProduto, jlPrecoProduto, jlDimensaoProduto, jlDimensaoProdutoL, jlDimensaoProdutoC, jlDimensaoProdutoA, jlQuantidadeProduto, jlCodigoProduto; //textos
    private JTextField jtfNomeProduto, jtfCategoriaProduto, jtfPrecoProduto, jtfDimensaoProdutoL, jtfDimensaoProdutoC, jtfDimensaoProdutoA, jtfQuantidadeProduto, jtfCodigoProduto; //caixas de textos
    private JButton jbCadastrar; //botões
    private List<Produto> produtos;
    private LerEscreverProdutos arquivosProduto = new LerEscreverProdutos();

    public PainelProdutos(List<Produto> produtos) {
        super();
        setSize(400, 400);
        setLayout(null);
        Color customizarCor = Color.decode("#8a2be2"); //para mudar a cor de fundo através do código hexadecimal da cor
        setBackground(customizarCor); //colocar cor de fundo
        this.produtos = produtos;
        iniciarComponentes();
        criarEventos();
    }

    private void iniciarComponentes() {

        //criação de objetos

        jlNomeProduto = new JLabel("Nome do produto: ");
        jtfNomeProduto = new JTextField();

        jlCategoriaProduto = new JLabel("Categoria: ");
        jtfCategoriaProduto = new JTextField();
        jtfCategoriaProduto.setDocument((Document) new LimitarCaracteres(50, LimitarCaracteres.TipoDadoEntrada.letras));

        jlPrecoProduto = new JLabel("Preço: ");
        jtfPrecoProduto = new JTextField();
        jtfPrecoProduto.setDocument((Document) new LimitarCaracteres(10, LimitarCaracteres.TipoDadoEntrada.decimal));

        jlDimensaoProduto = new JLabel("Dimensões: (centímetros)");

        jlDimensaoProdutoL = new JLabel("L: ");
        jtfDimensaoProdutoL = new JTextField();
        jtfDimensaoProdutoL.setDocument((Document) new LimitarCaracteres(7, LimitarCaracteres.TipoDadoEntrada.decimal));

        jlDimensaoProdutoC = new JLabel("C: ");
        jtfDimensaoProdutoC = new JTextField();
        jtfDimensaoProdutoC.setDocument((Document) new LimitarCaracteres(7, LimitarCaracteres.TipoDadoEntrada.decimal));

        jlDimensaoProdutoA = new JLabel("A: ");
        jtfDimensaoProdutoA = new JTextField();
        jtfDimensaoProdutoA.setDocument((Document) new LimitarCaracteres(7, LimitarCaracteres.TipoDadoEntrada.decimal));

        jlQuantidadeProduto = new JLabel("Quantidade: ");
        jtfQuantidadeProduto = new JTextField();
        jtfQuantidadeProduto.setDocument((Document) new LimitarCaracteres(4, LimitarCaracteres.TipoDadoEntrada.numeroInteiro));

        jlCodigoProduto = new JLabel("Código do produto:");
        jtfCodigoProduto = new JTextField();
        jtfCodigoProduto.setDocument((Document) new LimitarCaracteres(4, LimitarCaracteres.TipoDadoEntrada.numeroInteiro));

        jbCadastrar = new JButton("Cadastrar");


        //adicionar objetos na tela
        add(jlNomeProduto);
        add(jlCategoriaProduto);
        add(jlPrecoProduto);
        add(jlDimensaoProduto);
        add(jlDimensaoProdutoL);
        add(jlDimensaoProdutoC);
        add(jlDimensaoProdutoA);
        add(jlQuantidadeProduto);
        add(jlCodigoProduto);
        add(jtfNomeProduto);
        add(jtfCategoriaProduto);
        add(jtfPrecoProduto);
        add(jtfDimensaoProdutoL);
        add(jtfDimensaoProdutoC);
        add(jtfDimensaoProdutoA);
        add(jtfQuantidadeProduto);
        add(jtfCodigoProduto);
        add(jbCadastrar);


        //dimensionar objetos na tela;
        jlNomeProduto.setBounds(95, 25, 230, 20);
        jtfNomeProduto.setBounds(95, 45, 230, 20);
        jlCategoriaProduto.setBounds(95, 65, 230, 20);
        jtfCategoriaProduto.setBounds(95, 85, 230, 20);
        jlPrecoProduto.setBounds(95, 110, 230, 20);
        jtfPrecoProduto.setBounds(95, 130, 230, 20);
        jlDimensaoProduto.setBounds(95, 160, 230, 20);
        jlDimensaoProdutoL.setBounds(95, 180, 20, 20);
        jtfDimensaoProdutoL.setBounds(115, 180, 50, 20);
        jlDimensaoProdutoC.setBounds(175, 180, 20, 20);
        jtfDimensaoProdutoC.setBounds(195, 180, 50, 20);
        jlDimensaoProdutoA.setBounds(255, 180, 20, 20);
        jtfDimensaoProdutoA.setBounds(275, 180, 50, 20);
        jlQuantidadeProduto.setBounds(95, 210, 230, 20);
        jtfQuantidadeProduto.setBounds(95, 230, 230, 20);
        jlCodigoProduto.setBounds(95, 260, 230, 20);
        jtfCodigoProduto.setBounds(95, 285, 230, 20);
        jbCadastrar.setBounds(150, 325, 110, 20);


    }

    private void criarEventos() {
        jbCadastrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nomeProduto, categoriaProduto;
                double precoProduto, dimensaoProdutoL, dimensaoProdutoC, dimensaoProdutoA;
                int quantidadeProduto, codigoProduto;
                String erroCampoVazio = "";

                //verificação de campos vazios
                if (!jtfNomeProduto.getText().isEmpty() && !jtfCategoriaProduto.getText().isEmpty() && !jtfPrecoProduto.getText().isEmpty() && !jtfDimensaoProdutoL.getText().isEmpty() && !jtfDimensaoProdutoC.getText().isEmpty() && !jtfDimensaoProdutoA.getText().isEmpty() && !jtfQuantidadeProduto.getText().isEmpty() && !jtfCodigoProduto.getText().isEmpty()) {

                    //entradas
                    nomeProduto = jtfNomeProduto.getText();
                    categoriaProduto = jtfCategoriaProduto.getText();
                    precoProduto = Double.parseDouble(jtfPrecoProduto.getText().replaceAll(",", "."));
                    dimensaoProdutoL = Double.parseDouble(jtfDimensaoProdutoL.getText().replaceAll(",", "."));
                    dimensaoProdutoC = Double.parseDouble(jtfDimensaoProdutoC.getText().replaceAll(",", "."));
                    dimensaoProdutoA = Double.parseDouble(jtfDimensaoProdutoA.getText().replaceAll(",", "."));
                    quantidadeProduto = Integer.parseInt(jtfQuantidadeProduto.getText());
                    codigoProduto = Integer.parseInt(jtfCodigoProduto.getText());

                    //adicionando na lista atraves do objeto da classe produto com o construtor
                    produtos.add(new Produto(nomeProduto, categoriaProduto, precoProduto, dimensaoProdutoL, dimensaoProdutoC, dimensaoProdutoA, quantidadeProduto, codigoProduto));

                    //escrever arquivo de produto
                    arquivosProduto.escreverArquivoProduto(produtos);

                    //limpando os campos
                    jtfNomeProduto.setText("");
                    jtfCategoriaProduto.setText("");
                    jtfPrecoProduto.setText("");
                    jtfDimensaoProdutoL.setText("");
                    jtfDimensaoProdutoC.setText("");
                    jtfDimensaoProdutoA.setText("");
                    jtfQuantidadeProduto.setText("");
                    jtfCodigoProduto.setText("");

                    //verificação campo a campo
                } else {
                    if (jtfNomeProduto.getText().isEmpty()) {
                        erroCampoVazio += "Nome do produto;\n";
                    }
                    if (jtfCategoriaProduto.getText().isEmpty()) {
                        erroCampoVazio += "Categoria;\n";
                    }
                    if (jtfPrecoProduto.getText().isEmpty()) {
                        erroCampoVazio += "Preço;\n";
                    }
                    if (jtfDimensaoProdutoL.getText().isEmpty()) {
                        erroCampoVazio += "Dimensão da largura;\n";
                    }
                    if (jtfDimensaoProdutoC.getText().isEmpty()) {
                        erroCampoVazio += "Dimensão do comprimento;\n";
                    }
                    if (jtfDimensaoProdutoA.getText().isEmpty()) {
                        erroCampoVazio += "Dimensão da altura;\n";
                    }
                    if (jtfQuantidadeProduto.getText().isEmpty()) {
                        erroCampoVazio += "Quantidade;\n";
                    }
                    if (jtfCodigoProduto.getText().isEmpty()) {
                        erroCampoVazio += "Código;\n";
                    }
                    JOptionPane.showMessageDialog(null, "Os seguintes campos estão vazios:\n\n" + erroCampoVazio + "\nPreencha todos os dados corretamente.", "Aviso", JOptionPane.WARNING_MESSAGE);
                }
            }
        });
    }
}

