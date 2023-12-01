package model;

import java.io.*;

public class ArquivoDeSaida {

	public void escreverArquivoDeSaida(String a1, String a2, String a3, String a4, String a5, int a6, String a7, int a8, int a9, int a10, int a11) {

        String caminhoArquivo = "Arquivo.txt";

        try {

            FileWriter fileWriter = new FileWriter(caminhoArquivo);

            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            bufferedWriter.write(a1 + ", " + a2 + ", "+ a3 + ", "+ a4 + ", "+ a5 + ", "+ a6 + ", "+ a7 + ", "+ "\n" + a8 + ", "+ a9 + ", "+ a10 + ", "+ a11);

            bufferedWriter.close();
            fileWriter.close();

//            System.out.println("Escrita no arquivo concluída com sucesso.");

        } catch (IOException e) {
            e.printStackTrace();
        }
	}
}
