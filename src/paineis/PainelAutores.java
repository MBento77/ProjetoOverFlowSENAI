package paineis;

import javax.swing.*;
import java.awt.*;

public class PainelAutores extends JPanel {

    //atributos/componentes da tela
    private JLabel jlAutores, jlBento, jlGiovana, jlFernando, jlHelmes;

    public PainelAutores() {
        super();
        setLayout(null); //para que os componentes não sejam dimensionados automaticamente
        Color customizarCor = Color.decode("#7B68EE"); //para mudar a cor de fundo através do código hexadecimal da cor
        setBackground(customizarCor); //colocar cor de fundo
        iniciarComponentes();
    }

    private void iniciarComponentes() {

        //objetos
        jlAutores = new JLabel("AUTORES:");
        jlBento = new JLabel("Matheus Bento");
        jlFernando = new JLabel("Fernando Teixeira");
        jlGiovana = new JLabel("Giovana Rufino");
        jlHelmes = new JLabel("Helmes Franklim");

        //adicionando na tela
        add(jlAutores);
        add(jlBento);
        add(jlFernando);
        add(jlGiovana);
        add(jlHelmes);

        //redimensionando
        jlAutores.setBounds(180, 50, 130, 20);
        jlBento.setBounds(165, 120, 130, 20);
        jlGiovana.setBounds(165, 170, 130, 20);
        jlHelmes.setBounds(165, 220, 130, 20);
        jlFernando.setBounds(162, 270, 130, 20);
    }
}