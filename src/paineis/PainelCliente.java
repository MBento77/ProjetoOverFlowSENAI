package paineis;

import arquivos.LerEscreverClientes;
import classes.Cliente;
import classes.LimitarCaracteres;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class PainelCliente extends JPanel {

    //DECLARANDO COMPONENTES DA TELA
    private JLabel jlNome, jlCpf, jlGenero, jlTelefone, jlDataNascimento, jlEmail, jlSenha, jlDivulgacao; //TEXTOS
    private JTextField jtfNome, jtfCpf, jtfGenero, jtfTelefone, jtfDataNascimento, jtfEmail, jtfDivulgacao; //CAIXAS DE TEXTO
    private JButton jbCadastrar; //BOTÕES
    private JPasswordField jpfSenha; //CAIXA DE SENHA
    private JTextArea jtaMostrar; //ÁREA PARA TEXTOS COM VARIAS LINHAS
    private JScrollPane jspMostrar; //PAINEL DE ROLAGEM PARA COLOCAR A JTEXTAREA
    private ImageIcon logo; //imagem do logo/ícone
    private LerEscreverClientes arquivos = new LerEscreverClientes(); //objeto da classe de arquivos
    private List<Cliente> clientes; //lista de clientes

    //CONSTRUTOR
    public PainelCliente(List<Cliente> clientes) throws HeadlessException {
        super();
        setLayout(null); //não deixa o java dimensionar nossos componentes
        Color customizarCor = Color.decode("#4169e1"); //para mudar a cor de fundo através do código hexadecimal da cor
        setBackground(customizarCor); //colocar a cor de fundo
        this.clientes = clientes;
        //criar o arquivo:
        iniciarComponentes();
        criarEventos();
    }

    private void iniciarComponentes() {

        //CRIANDO OBJETOS DOS COMPONENTES

        jlNome = new JLabel("Nome");
        jtfNome = new JTextField();
        jtfNome.setDocument(new LimitarCaracteres(120, LimitarCaracteres.TipoDadoEntrada.letras));

        jlCpf = new JLabel("Cpf");
        jtfCpf = new JTextField();
        jtfCpf.setDocument(new LimitarCaracteres(11, LimitarCaracteres.TipoDadoEntrada.numeroInteiro));

        jlGenero = new JLabel("Gênero");
        jtfGenero = new JTextField();
        jtfGenero.setDocument(new LimitarCaracteres(9, LimitarCaracteres.TipoDadoEntrada.letras));

        jlTelefone = new JLabel("Telefone");
        jtfTelefone = new JTextField();
        jtfTelefone.setDocument(new LimitarCaracteres(11, LimitarCaracteres.TipoDadoEntrada.numeroInteiro));

        jlDataNascimento = new JLabel("Data de Nascimento");
        jtfDataNascimento = new JTextField();
        jtfDataNascimento.setDocument(new LimitarCaracteres(10, LimitarCaracteres.TipoDadoEntrada.data));

        jlEmail = new JLabel("Email");
        jtfEmail = new JTextField();
        jtfEmail.setDocument(new LimitarCaracteres(50, LimitarCaracteres.TipoDadoEntrada.email));

        jlSenha = new JLabel("Senha");
        jpfSenha = new JPasswordField();

        jlDivulgacao = new JLabel("Como soube do nosso site?");
        jtfDivulgacao = new JTextField();
        jtfDivulgacao.setDocument(new LimitarCaracteres(200, LimitarCaracteres.TipoDadoEntrada.letras));

        jbCadastrar = new JButton("Cadastrar");

        jtaMostrar = new JTextArea();
        jspMostrar = new JScrollPane(jtaMostrar);

        logo = new ImageIcon(getClass().getResource("/imagens/logo.png"));
        //this.setIconImage(logo.getImage());

        //ADICIONANDO OS COMPONENTES NA TELA

        add(jlNome);
        add(jtfNome);
        add(jlCpf);
        add(jtfCpf);
        add(jlGenero);
        add(jtfGenero);
        add(jlTelefone);
        add(jtfTelefone);
        add(jlDataNascimento);
        add(jtfDataNascimento);
        add(jlEmail);
        add(jtfEmail);
        add(jlSenha);
        add(jpfSenha);
        add(jlDivulgacao);
        add(jtfDivulgacao);
        add(jbCadastrar);
        add(jspMostrar);

        //DIMENSIONANDO OS COMPONENTES

        jlNome.setBounds(95, 40, 50, 20);
        jtfNome.setBounds(95, 60, 245, 20);

        jlCpf.setBounds(95, 80, 50, 20);
        jtfCpf.setBounds(95, 100, 100, 20);

        jlGenero.setBounds(95, 120, 50, 20);
        jtfGenero.setBounds(95, 140, 100, 20);

        jlTelefone.setBounds(225, 80, 200, 20);
        jtfTelefone.setBounds(225, 100, 115, 20);

        jlDataNascimento.setBounds(225, 120, 200, 20);
        jtfDataNascimento.setBounds(225, 140, 115, 20);

        jlEmail.setBounds(95, 160, 50, 20);
        jtfEmail.setBounds(95, 180, 245, 20);

        jlSenha.setBounds(95, 200, 100, 20);
        jpfSenha.setBounds(95, 220, 245, 20);

        jlDivulgacao.setBounds(95, 250, 200, 20);
        jtfDivulgacao.setBounds(95, 270, 245, 20);

        jbCadastrar.setBounds(155, 310, 100, 20);


    }

    private void criarEventos() {
        //CRIANDO OS EVENTOS DOS BOTÕES

        //BOTÃO CADASTRAR
        jbCadastrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                //VARIÁVEIS
                String nomeCliente, cpfCliente, generoCliente, telefoneCliente, dataNascimentoCliente, emailCliente, senhaCliente, divulgacaoCliente;
                String erroCampoVazio = "";

                //ENTRADAS

                //VERIFICANDO SE TODOS OS CAMPOS FORAM PREENCHIDOS

                if (!jtfNome.getText().isEmpty() && !jtfCpf.getText().isEmpty() && !jtfGenero.getText().isEmpty() && !jtfTelefone.getText().isEmpty() && !jtfDataNascimento.getText().isEmpty() && !jtfEmail.getText().isEmpty() && !String.valueOf(jpfSenha.getPassword()).isEmpty() && !jtfDivulgacao.getText().isEmpty()) {

                    //entradas
                    nomeCliente = jtfNome.getText();
                    cpfCliente = jtfCpf.getText();
                    generoCliente = jtfGenero.getText();
                    telefoneCliente = jtfTelefone.getText();
                    dataNascimentoCliente = jtfDataNascimento.getText();
                    emailCliente = jtfEmail.getText().toLowerCase();
                    senhaCliente = String.valueOf(jpfSenha.getPassword());
                    divulgacaoCliente = jtfDivulgacao.getText();

                    //OBJETO
                    clientes.add(new Cliente(nomeCliente, cpfCliente, dataNascimentoCliente, generoCliente, telefoneCliente, emailCliente, senhaCliente, divulgacaoCliente));
                    //escrever arquivo
                    arquivos.escreverArquivoCliente(clientes);
                    //LIMPANDO TODOS OS CAMPOS
                    jtfNome.setText("");
                    jtfCpf.setText("");
                    jtfGenero.setText("");
                    jtfTelefone.setText("");
                    jtfDataNascimento.setText("");
                    jtfEmail.setText("");
                    jpfSenha.setText("");
                    jtfDivulgacao.setText("");
                } else {
                    //verificação campo a campo
                    if (jtfNome.getText().isEmpty()) {
                        erroCampoVazio += "Nome";
                    }
                    if (jtfCpf.getText().isEmpty()) {
                        erroCampoVazio += "\nCpf";
                    }
                    if (jtfGenero.getText().isEmpty()) {
                        erroCampoVazio += "\ngênero";
                    }
                    if (jtfTelefone.getText().isEmpty()) {
                        erroCampoVazio += "\nTelefone";
                    }
                    if (jtfDataNascimento.getText().isEmpty()) {
                        erroCampoVazio += "\nData de Nascimento";
                    }
                    if (jtfEmail.getText().isEmpty()) {
                        erroCampoVazio += "\nEmail";
                    }
                    if (String.valueOf(jpfSenha.getPassword()).isEmpty()) {
                        erroCampoVazio += "\nSenha";
                    }
                    if (jtfDivulgacao.getText().isEmpty()) {
                        erroCampoVazio += "\n''Como soube do nosso site?''";
                    }
                    JOptionPane.showMessageDialog(null, "Os seguintes campos estão vazios: \n\n" + erroCampoVazio + "\n\n Por favor, preencha todos os campos corretamente.", "Aviso", JOptionPane.WARNING_MESSAGE);
                }
            }
        });
    }
}