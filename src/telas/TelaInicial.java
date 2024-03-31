package telas;

import arquivos.LerEscreverFuncionarios;
import classes.Funcionario;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class TelaInicial extends JFrame {

    //DECLARANDO COMPONENTES DA TELA
    private JLabel jlLogin, jlSenha, jlLogo; //TEXTO
    private JTextField jtfLogin; //CAIXA DE TEXTO
    private JButton jbLogar, jbCadastrar; //BOTÕES
    private ImageIcon logo; // imagem
    private JPasswordField jpfSenha; //caixa da senha
    private List<Funcionario> funcionarios = new ArrayList<>();
    private LerEscreverFuncionarios arquivosFuncionario = new LerEscreverFuncionarios();


    //CONSTRUTOR
    public TelaInicial(String title) throws HeadlessException {
        super(title);
        setResizable(false);//impede o redimensionamento da tela
        setSize(360, 360); //tamanho da janela da tela
        setLayout(null); //não deixa o java dimensionar nosssos componentes
        setLocationRelativeTo(this); // para a tela aparecer centralizada
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//fechar a janela e encerrar a execução do programa
        Color customizarCor = Color.decode("#4169E1");
        getContentPane().setBackground(customizarCor);//colocar a cor de fundo
        iniciarComponentes();
        criarEventos();
    }

    private void iniciarComponentes() {

        //CRIANDO OBJETOS DOS COMPONENTES
        jlLogin = new JLabel("LOGIN");
        jtfLogin = new JTextField();

        jlSenha = new JLabel("SENHA");
        jpfSenha = new JPasswordField();

        jbCadastrar = new JButton("Cadastrar");

        jbLogar = new JButton("Logar");

        logo = new ImageIcon(getClass().getResource("/imagens/logo.png"));
        jlLogo = new JLabel(logo);//imagem do logo
        this.setIconImage(logo.getImage());


        //ADICIONANDO OS COMPONENTES NA TELA

        add(jlLogin);
        add(jtfLogin);

        add(jlSenha);
        add(jpfSenha);

        add(jbCadastrar);
        add(jbLogar);
        add(jlLogo);

        //DIMENSIONANDO OS COMPONENTES
        jlLogo.setBounds(120, 10, 100, 100);
        jlLogin.setBounds(20, 120, 50, 20);
        jtfLogin.setBounds(20, 140, 300, 20);
        jlSenha.setBounds(20, 170, 50, 20);
        jpfSenha.setBounds(20, 190, 300, 20);
        jbCadastrar.setBounds(90, 230, 150, 20);
        jbLogar.setBounds(90, 260, 150, 20);
    }

    //CRIANDO EVENTOS PARA OS BOTÕES
    private void criarEventos() {

        //botão cadastrar
        jbCadastrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                //entradas
                String login = jtfLogin.getText().toLowerCase();
                String senha = String.valueOf(jpfSenha.getPassword()); //converte um conjunto de caracteres (senha) em uma String

                //Verificação de campos vazios
                if (!jtfLogin.getText().isEmpty() && !String.valueOf(jpfSenha.getPassword()).isEmpty()) {

                    //guardando registro do funcionario em um arquivo
                    funcionarios.add(new Funcionario(login, senha));
                    arquivosFuncionario.escreverArquivoFuncionario(funcionarios);

                    //apagar os campos
                    jtfLogin.setText("");
                    jpfSenha.setText("");

                    //informar o usuario que o cadastro foi efetuado
                    JOptionPane.showMessageDialog(null, "Funcionário cadastrado com sucesso");
                } else {
                    JOptionPane.showMessageDialog(null, "PREENCHA TODOS OS CAMPOS CORRETAMENTE", "CAMPOS VAZIOS", JOptionPane.WARNING_MESSAGE);
                }
            }
        });

        //botão logar
        jbLogar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                //verificação de campos vazios
                if (!jtfLogin.getText().isEmpty() && !String.valueOf(jpfSenha.getPassword()).isEmpty()) {

                    //entradas
                    String pesquisarLogin = jtfLogin.getText();
                    String pesquisarSenha = String.valueOf(jpfSenha.getPassword());

                    //ler os funcionarios cadastrados
                    List<Funcionario> funcionarios = arquivosFuncionario.lerObjetoFuncionario();

                    //verificar se a lista está vazia ou se retornou "null"
                    if (funcionarios != null && !funcionarios.isEmpty()) {
                        boolean achou = false;
                        for (Funcionario funcionario : funcionarios) {
                            if (funcionario.getLogin().equals(pesquisarLogin) && funcionario.getSenha().equals(pesquisarSenha)) {
                                achou = true;
                                break;
                            }
                        }

                        if (achou) {
                            //mudando para a tela de cadastros
                            JOptionPane.showMessageDialog(null, "LOGIN EFETUADO COM SUCESSO!!!");
                            TelaCadastros cadastros = new TelaCadastros("Menu");
                            setVisible(false);
                            cadastros.setVisible(true);
                        } else {
                            JOptionPane.showMessageDialog(null, "LOGIN OU SENHA INCORRETOS!!", "ATENÇÃO", JOptionPane.WARNING_MESSAGE);
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "NENHUM USUÁRIO CADASTRADO!!", "ATENÇÃO", JOptionPane.WARNING_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "PREENCHA TODOS OS CAMPOS CORRETAMENTE", "CAMPOS VAZIOS", JOptionPane.WARNING_MESSAGE);
                }
            }
        });
    }
}