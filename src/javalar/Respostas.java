package javalar;

import java.util.ArrayList;

public class Respostas {

	
	public void manipularArquivos(ArrayList<ArrayList<String>> dados) {

        String nomeMaisFrequente = null;
        String matriculaMaisFrequente = null;
        int frequenciaMaxima = 0;
        
        ArrayList<String> colunaNome = dados.get(1);
        ArrayList<String> colunaMatricula = dados.get(2);
        
        for (int i = 0; i < colunaNome.size(); i++) {
        	String nomeAtual = colunaNome.get(i);
        	String matriculaAtual = colunaMatricula.get(i);
            int contagemAtual = 1;

            for (int j = i + 1; j < colunaNome.size(); j++) {
                if (nomeAtual.equals(colunaNome.get(j))) {
                    contagemAtual++;
                    matriculaAtual = colunaMatricula.get(j);
                }
            }
            if (contagemAtual > frequenciaMaxima) {
                frequenciaMaxima = contagemAtual;
                nomeMaisFrequente = nomeAtual;
                matriculaMaisFrequente = matriculaAtual;
            }
        }
        System.out.println("Nome mais frequente: " + nomeMaisFrequente);
        System.out.println("mat mais frequente: " + matriculaMaisFrequente);
		
	}
}
