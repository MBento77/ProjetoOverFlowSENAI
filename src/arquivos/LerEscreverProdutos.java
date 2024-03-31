package arquivos;

import classes.Produto;
import java.io.*;
import java.util.List;

public class LerEscreverProdutos {

    public void escreverArquivoProduto(List<Produto> lista) {
        try {
            FileOutputStream fluxo = new FileOutputStream("Produto.bin"); // cria um arquivo chamado Produto
            ObjectOutputStream objeto = new ObjectOutputStream(fluxo);
            objeto.writeObject(lista);
            objeto.close();//fecha o arquivo
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Produto> lerObjetoProduto() {
        //Declaração da variável para receber o objeto gravado
        List<Produto> lista;// variavel para receber o objeto
        try {
            FileInputStream fluxo = new FileInputStream("Produto.bin"); //ler arquivo Produto
            ObjectInputStream objeto = new ObjectInputStream(fluxo);
            lista = (List<Produto>) objeto.readObject();

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
