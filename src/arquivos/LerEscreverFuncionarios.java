package arquivos;
import classes.Funcionario;
import java.io.*;
import java.util.List;

public class LerEscreverFuncionarios {

    public void escreverArquivoFuncionario(List<Funcionario> lista) {
        try {
            FileOutputStream fluxo = new FileOutputStream("Funcionario.bin"); // cria um arquivo chamado Funcionario
            ObjectOutputStream objeto = new ObjectOutputStream(fluxo);
            objeto.writeObject(lista);
            objeto.close();//fecha o arquivo

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Funcionario> lerObjetoFuncionario() {
        //Declaração da variável para receber o objeto gravado
        List<Funcionario> lista;// variavel para receber o objeto
        try {
            FileInputStream fluxo = new FileInputStream("Funcionario.bin"); //ler arquivo Funcionario
            ObjectInputStream objeto = new ObjectInputStream(fluxo);
            lista = (List<Funcionario>) objeto.readObject();

            objeto.close(); //fechar o arquivo

        } catch (FileNotFoundException e) {
            return null;
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        return lista;
    }

}
