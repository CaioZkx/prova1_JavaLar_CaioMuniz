package persistencia;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LerArquivo {

    public static void main(String[] args) {
        // Caminho do arquivo a ser lido
        String caminhoArquivo = "C:\\Users\\caiom\\OneDrive\\Área de Trabalho\\Eclipse Projects\\JavaLar\\src\\AE_10.csv";

        // Tente abrir e ler o arquivo
        try {
            // Cria um BufferedReader para ler o arquivo
            BufferedReader leitor = new BufferedReader(new FileReader(caminhoArquivo));

            // String para armazenar cada linha lida do arquivo
            String linha;

            // Loop para ler cada linha do arquivo
            while ((linha = leitor.readLine()) != null) {
                // Faça algo com a linha lida, por exemplo, imprimir no console
                System.out.println(linha);
            }

            // Fecha o BufferedReader após a leitura
            leitor.close();

        } catch (IOException e) {
            // Trata possíveis erros de leitura do arquivo
            e.printStackTrace();
        }
    }
}

