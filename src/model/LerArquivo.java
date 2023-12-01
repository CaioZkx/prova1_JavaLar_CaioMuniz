package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import javalar.SistemaJavaLar;
import view.Malha;

public class LerArquivo {

	SistemaJavaLar syst = new SistemaJavaLar();
	Malha malha = new Malha();
	int linhaAtual = 2;
	
    public String[] lerArquivo(String DiretorioArquivo) {
    	try {
            File arquivo = new File(DiretorioArquivo);
            Scanner scanner = new Scanner(arquivo);

            // Descartar a primeira linha
            if (scanner.hasNextLine()) {
                scanner.nextLine();
            }

            // Encontra a linha desejada
            for (int i = 2; i < linhaAtual; i++) {
                if (scanner.hasNextLine()) {
                    scanner.nextLine();
                } else {
                    // Reinicia a leitura do arquivo quando chegar ao final
                    scanner.close();
                    scanner = new Scanner(arquivo);
                    // Descarta a primeira linha novamente
                    scanner.nextLine();
                }
            }

            if (scanner.hasNextLine()) {
                String linha = scanner.nextLine();
                linhaAtual++;

                return linha.split(",");
            }

            scanner.close();

        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }

        return null;
    }

}

