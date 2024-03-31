package telas;

import classes.Cliente;
import classes.Produto;
import paineis.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

public class TelaCadastros extends JFrame {

    //DECLARANDO COMPONENTES DA TELA
    private ImageIcon logo;
    private Container contentPane; // quando quero manipular/fazer alguma coisa com a minha tela
    private JMenuBar jmbBarra; // barra para segurar o menu
    private JMenu jmArquivo, jmCadastro, jmMostrar, jmSobre;// esse é o menu
    private JMenuItem jmiSair, jmiClientes, jmiProdutos, jmiDados, jmiPesquisa, jmiSite, jmiAutores; //itens dos menus
    private List<Cliente> clientes = new ArrayList<>();
    private List<Produto> produtos = new ArrayList<>();

    public TelaCadastros(String title) throws HeadlessException {
        super(title);
        setResizable(false); //impede o redimensionamento da tela
        setSize(450, 450); //dimensionando o tamanho da tela
        setLocationRelativeTo(null); //faz com que a tela apareça centralizada
        getContentPane().setBackground(Color.blue);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //clicar no X fecha a tela e encerra a execução do aplicativo
        iniciarComponentes();
        criarEventos();
    }

    private void iniciarComponentes() {

        logo = new ImageIcon(getClass().getResource("/imagens/logo.png"));//logo/icone da tela
        this.setIconImage(logo.getImage());

        //CRIANDO OBJETOS DOS COMPONENTES
        contentPane = getContentPane(); //devolve um OBJETO do tipo Container
        jmbBarra = new JMenuBar();
        setJMenuBar(jmbBarra);// adicionando a barra na tela

        //PAINEL
        //1
        jmArquivo = new JMenu("Arquivo");
        jmiSair = new JMenuItem("Sair");

        //2
        jmCadastro = new JMenu("Cadastro");
        jmiClientes = new JMenuItem("Clientes");
        jmiProdutos = new JMenuItem("Produtos");

        //3
        jmMostrar = new JMenu("Mostrar");
        jmiDados = new JMenuItem("Dados");
        jmiPesquisa = new JMenuItem("Pesquisa");

        //4
        jmSobre = new JMenu("Sobre");
        jmiSite = new JMenuItem("Acessar Site");
        jmiAutores = new JMenuItem("Autores");


        //ADICIONANDO OS COMPONENTES NA TELA

        //painel
        //1
        jmbBarra.add(jmArquivo);
        jmArquivo.add(jmiSair);

        //2
        jmbBarra.add(jmCadastro);
        jmCadastro.add(jmiClientes);
        jmCadastro.add(jmiProdutos);

        //3
        jmbBarra.add(jmMostrar);
        jmMostrar.add(jmiDados);
        jmMostrar.add(jmiPesquisa);

        //4
        jmbBarra.add(jmSobre);
        jmSobre.add(jmiSite);
        jmSobre.add(jmiAutores);
    }

    private void criarEventos() {

        //EVENTOS DOS MENUS

        jmiSair.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            } //fecha o programa parando a execução
        });

        jmiClientes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                //criando objeto para passar os valores através dele
                PainelCliente cliente = new PainelCliente(clientes); //passar o endereço da matriz dinâmica (Arraylist()) para o painel cliente
                contentPane.removeAll(); //remove todos os componentes da tela
                contentPane.add(cliente); //adicionar um novo painel na tela
                contentPane.validate(); //para validar

            }
        });

        jmiProdutos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //criando objeto para passar os valores através dele
                PainelProdutos painelProdutos = new PainelProdutos(produtos); //passar o endereço da matriz dinâmica (Arraylist()) para o painel produtos
                contentPane.removeAll(); //remove todos os componentes da tela
                contentPane.add(painelProdutos); //adicionar um novo painel na tela
                contentPane.validate(); //para validar
            }
        });

        jmiDados.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PainelMostrarDados dados = new PainelMostrarDados(clientes, produtos); //passar o endereço da matriz dinâmica (Arraylist()) para o painel mostrar dados
                contentPane.removeAll(); //remove todos os componentes da tela
                contentPane.add(dados); //adicionar um novo painel na tela
                contentPane.validate(); //para validar
            }
        });
        jmiPesquisa.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                //criando objeto para passar os valores através dele
                PainelPesquisa pesquisa = new PainelPesquisa(clientes, produtos); //passar o endereço da matriz dinâmica (Arraylist()) para o painel pesquisa
                contentPane.removeAll(); //remove todos os componentes da tela
                contentPane.add(pesquisa); //adicionar um novo painel na tela
                contentPane.validate(); //para validar
            }
        });

        jmiSite.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Desktop.getDesktop().browse(new URI("https://overflowsquad.github.io/infinitystore/index.html")); //abre o site da infinity store ao clicar no menuitem
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        jmiAutores.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                //criando objeto para passar os valores através dele
                PainelAutores autores = new PainelAutores(); //passar o endereço da matriz dinâmica (Arraylist()) para o painel Autores
                contentPane.removeAll(); //remove todos os componentes da tela
                contentPane.add(autores); //adicionar um novo painel na tela
                contentPane.validate(); //para validar

            }
        });
    }
}