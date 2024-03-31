package arquivos;

import classes.Cliente;
import java.io.*;
import java.util.List;

public class LerEscreverClientes {

    public void escreverArquivoCliente(List<Cliente> lista) {
        try {
            FileOutputStream fluxo = new FileOutputStream("Cliente.bin"); // cria um arquivo chamado Cliente
            ObjectOutputStream objeto = new ObjectOutputStream(fluxo);
            objeto.writeObject(lista);
            objeto.close();//fecha o arquivo
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public List<Cliente> lerObjetoCliente() {
        //Declaração da variável para receber o objeto gravado
        List<Cliente> lista;// variavel para receber o objeto
        try {
            FileInputStream fluxo = new FileInputStream("Cliente.bin"); //ler arquivo Cliente
            ObjectInputStream objeto = new ObjectInputStream(fluxo);
            lista = (List<Cliente>) objeto.readObject();

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
