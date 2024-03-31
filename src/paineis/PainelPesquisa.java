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

public class PainelPesquisa extends JPanel {

    //declaração de componentes da tela
    private JButton jbPesquisaCliente, jbPesquisaProduto;
    private JTextArea jtaMostrar;
    private JScrollPane jsMostrar;
    private List<Cliente> clientes;
    private List<Produto> produtos;
    private LerEscreverClientes arquivosClientes = new LerEscreverClientes();
    private LerEscreverProdutos arquivosProdutos = new LerEscreverProdutos();
    private JLabel jlPesquisarDados;

    public PainelPesquisa(List<Cliente> clientes, List<Produto> produtos) {
        super();
        setSize(450, 450);
        setLayout(null);
        Color customizarCor = Color.decode("#8a2be2"); //para mudar a cor de fundo através do código hexadecimal da cor
        setBackground(customizarCor); //colocar cor de fundo
        this.clientes = clientes;
        this.produtos = produtos;
        abrirArquivoCliente();
        abrirArquivoProduto();
        iniciarComponentes();
        criarEventos();
    }

    private void abrirArquivoCliente() {//ler um arquivo recuperando os dados
        if (arquivosClientes.lerObjetoCliente() != null) {
            clientes = arquivosClientes.lerObjetoCliente();
        } else {
            arquivosClientes.escreverArquivoCliente(clientes);
        }//criar um arquivo caso seja a primeira vez

    }

    //LER ARQUIVOS DE PRODUTO OU CRIAR UM NOVO ARQUIVO CASO NÃO TENHA NENHNUM

    private void abrirArquivoProduto() {
        if (arquivosProdutos.lerObjetoProduto() != null) {
            produtos = arquivosProdutos.lerObjetoProduto();
        } else {
            arquivosProdutos.escreverArquivoProduto(produtos);
        }
    }

    private void iniciarComponentes() {
        // Objetos
        jbPesquisaCliente = new JButton("Clientes");
        jbPesquisaProduto = new JButton("Produtos");
        jtaMostrar = new JTextArea();
        jsMostrar = new JScrollPane(jtaMostrar);
        jlPesquisarDados = new JLabel("Pesquisar dados de:");
        //adicionar
        add(jbPesquisaCliente);
        add(jbPesquisaProduto);
        add(jsMostrar);
        add(jlPesquisarDados);

        //dimensionar
        jbPesquisaCliente.setBounds(75, 70, 120, 20);
        jbPesquisaProduto.setBounds(235, 70, 120, 20);
        jsMostrar.setBounds(60, 120, 320, 200);
        jlPesquisarDados.setBounds(150, 40, 150, 20);
    }

    private void criarEventos() {
        jbPesquisaCliente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (!clientes.isEmpty()) { //verificação de lista vazia
                    String pesquisaClienteCpf = JOptionPane.showInputDialog("Digite o cpf do cliente"); //entrada da variavel para a pesquisa
                    if (pesquisaClienteCpf != null) {
                        boolean achou = false; //VARIAVEL PARA SABER SE A PLACA FOI ACHADA
                        jtaMostrar.setText("**********PESQUISAR**********\n\n");

                        for (Cliente cliente : clientes) {
                            if (pesquisaClienteCpf.equals(cliente.getCpfCliente())) {
                                jtaMostrar.append(cliente.mostrarDadosCadastrados());
                                achou = true;
                                break;//sair do laço
                            }
                        }
                        if (achou == false) {
                            JOptionPane.showMessageDialog(null, "CPF não encontrado", "ERRO", JOptionPane.WARNING_MESSAGE);
                            jtaMostrar.setText("CPF não encontrado");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Pesquisa cancelada pelo usuário", "Pesquisa Cancelada", JOptionPane.INFORMATION_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Nenhum cpf cadastrado", "erro", JOptionPane.WARNING_MESSAGE);
                }
            }
        });

        jbPesquisaProduto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (!produtos.isEmpty()) { //verificação de lista vazia
                    String pesquisaProdutoCodigo = JOptionPane.showInputDialog("Digite o código do produto"); //entrada da variavel para a pesquisa
                    if (pesquisaProdutoCodigo != null){
                        boolean achou = false; //VARIAVEL PARA SABER SE A PLACA FOI ACHADA
                        jtaMostrar.setText("**********PESQUISAR**********\n\n");

                        for (Produto produto : produtos) {
                            if (Integer.parseInt(pesquisaProdutoCodigo) == produto.getCodigoProduto()) {
                                jtaMostrar.append(produto.mostrarDados());
                                achou = true;
                                break;//sair do laço
                            }

                        }
                        if (achou == false) {
                            JOptionPane.showMessageDialog(null, "Produto não encontrado", "ERRO", JOptionPane.WARNING_MESSAGE);
                            jtaMostrar.setText("Produto não encontrado");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Pesquisa cancelada pelo usuário", "Pesquisa Cancelada", JOptionPane.INFORMATION_MESSAGE);
                    }

                } else {
                    JOptionPane.showMessageDialog(null, "Nenhum produto cadastrado", "erro", JOptionPane.WARNING_MESSAGE);
                }
            }
        });
    }
}
