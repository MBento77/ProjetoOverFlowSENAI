package paineis;

import arquivos.LerEscreverClientes;
import arquivos.LerEscreverProdutos;
import classes.Cliente;
import classes.Produto;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class PainelMostrarDados extends JPanel {

    //declarando os componentes do painel
    private JButton jbCliente, jbProduto;
    private JTextArea jtaMostrar;
    private JScrollPane jsMostrar;
    private List<Cliente> clientes;
    private List<Produto> produtos;
    private LerEscreverClientes arquivosClientes = new LerEscreverClientes();
    private LerEscreverProdutos arquivosProdutos = new LerEscreverProdutos();
    private JLabel jlMostrarDados;


    public PainelMostrarDados(List<Cliente> clientes, List<Produto> produtos) {
        super();
        setSize(400, 400);
        setLayout(null); //não deixa o java dimensionar nossos componentes
        Color customizarCor = Color.decode("#4169e1"); //para mudar a cor de fundo através do código hexadecimal da cor
        setBackground(customizarCor); //colocar a cor de fundo
        this.clientes = clientes;
        this.produtos = produtos;
        abrirArquivoCliente();
        abrirArquivoProduto();
        iniciarComponentes();
        criarEventos();
    }


    //LER ARQUIVOS DE CLIENTE OU CRIAR UM NOVO ARQUIVO CASO NÃO TENHA NENHUM
    private void abrirArquivoCliente() {//ler um arquivo recuperando os dados
        if (arquivosClientes.lerObjetoCliente() != null) {
            clientes = arquivosClientes.lerObjetoCliente();
        } else {
            arquivosClientes.escreverArquivoCliente(clientes);
        }//criar um arquivo caso seja a primeira vez

    }

    //LER ARQUIVOS DE PRODUTO OU CRIAR UM NOVO ARQUIVO CASO NÃO TENHA NENHUM

    private void abrirArquivoProduto() {
        if (arquivosProdutos.lerObjetoProduto() != null) {
            produtos = arquivosProdutos.lerObjetoProduto();
        } else {
            arquivosProdutos.escreverArquivoProduto(produtos);
        }
    }


    private void iniciarComponentes() {
        //objetos
        jbCliente = new JButton("Clientes");
        jbProduto = new JButton("Produtos");
        jtaMostrar = new JTextArea();
        jsMostrar = new JScrollPane(jtaMostrar);
        jlMostrarDados = new JLabel("Mostrar dados de: ");

        //adicionar
        add(jbCliente);
        add(jbProduto);
        add(jsMostrar);
        add(jlMostrarDados);

        //dimensionar
        jbCliente.setBounds(75, 70, 120, 20);
        jbProduto.setBounds(235, 70, 120, 20);
        jsMostrar.setBounds(60, 120, 320, 200);
        jlMostrarDados.setBounds(150, 40, 150, 20);
    }

    private void criarEventos() {
        //cliente
        jbCliente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!clientes.isEmpty()) { //verificação de lista vazia
                    jtaMostrar.setText("******************CADASTROS DE CLIENTES***************\n");
                    for (Cliente cliente : clientes) {
                        jtaMostrar.append(cliente.mostrarDadosCadastrados());
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Nenhum cliente cadastrado", "erro", JOptionPane.WARNING_MESSAGE);
                }
            }
        });


        //produto
        jbProduto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!produtos.isEmpty()) { //verificação de lista vazia
                    jtaMostrar.setText("***********CADASTROS DE PRODUTOS***************\n");
                    for (Produto produto : produtos) {
                        jtaMostrar.append(produto.mostrarDados());
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Nenhum produto cadastrado", "erro", JOptionPane.WARNING_MESSAGE);
                }
            }
        });
    }
}
