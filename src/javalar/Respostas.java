package javalar;

import java.util.ArrayList;

import model.ArquivoDeSaida;

public class Respostas {
	
	ArquivoDeSaida arquivo = new ArquivoDeSaida();
	
	public void manipularArquivos(ArrayList<ArrayList<String>> dados) {
		
		String R1 = Responder1(dados);
		String R2 = Responder2(dados);
		String R3 = Responder3(dados);
		String R4 = responder4(dados);
		String R5 = Responder5(dados);
		int R6 = Responder6(dados);
		String R7 = Responder7(dados);
		int R8 = Responder8(dados);
		int R9 = Responder9(dados);
		int R10 = Responder10(dados);
		int R11 = Responder11(dados);
	
		arquivo.escreverArquivoDeSaida(R1,R2,R3,R4,R5,R6,R7,R8,R9,R10,R11);
        
	}
	
	public String Responder1(ArrayList<ArrayList<String>> dados) {
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
		
		String a = matriculaMaisFrequente + " - " + nomeMaisFrequente;
		return a;
	}
	
	public String Responder2(ArrayList<ArrayList<String>> dados) {

            String planetaMaisAfetado = null;
            int maxVelocidadeZero = 0;


            String[] nomesDosPlanetas = {"Python", "JavaScript", "Ruby", "PHP", "C#", "C++", "C"};


            for (int i = 18; i <= 24; i++) { 
                ArrayList<String> colunaVelocidade = dados.get(i);

                int contagemAtual = 0;
                String planetaAtual = null;

                for (String velocidade : colunaVelocidade) {
                    if (velocidade.equals("0")) {
                        contagemAtual++;

                        if (contagemAtual > maxVelocidadeZero) {
                            maxVelocidadeZero = contagemAtual;
                            planetaMaisAfetado = nomesDosPlanetas[i - 18]; 
                        }
                    } else {

                        contagemAtual = 0;
                        planetaAtual = nomesDosPlanetas[i - 18]; 
                    }
                }
            }

            return planetaMaisAfetado;

    }
	
	public String Responder3(ArrayList<ArrayList<String>> dados) {

            int maxSoma = 0;
            int colunaComMaiorSoma = -1;

            String[] nomesDosPlanetas = {"Python", "JavaScript", "Ruby", "PHP", "C#", "C++", "C"};

            for (int i = 18; i <= 24; i++) { 
                ArrayList<String> colunaVelocidade = dados.get(i);

                int somaAtual = 0;

                // Somar os valores da coluna
                for (String valor : colunaVelocidade) {

                    try {
                        somaAtual += Integer.parseInt(valor);
                    } catch (NumberFormatException e) {

                        e.printStackTrace();
                    }
                }

                if (somaAtual > maxSoma) {
                    maxSoma = somaAtual;
                    colunaComMaiorSoma = i;
                }
            }

                String nomeDoPlaneta = nomesDosPlanetas[colunaComMaiorSoma - 18];
                
                return nomeDoPlaneta;

	}
	
	public String responder4(ArrayList<ArrayList<String>> dados) {

        int maxSoma = 0;
        int colunaComMaiorSoma = -1;


        String[] nomesDosQuadrantes = {"1", "2", "3", "4"};

        for (int i = 39; i <= 42; i++) { 
            ArrayList<String> colunaQuadrante = dados.get(i);

            int somaAtual = 0;

            for (String valor : colunaQuadrante) {    
            	if(valor != null)
                somaAtual += Integer.parseInt(valor);
            	else {
            		
            	}
            }

            if (somaAtual > maxSoma) {
                maxSoma = somaAtual;
                colunaComMaiorSoma = i;
            }
        }

            String nomeDoQuadrante = nomesDosQuadrantes[colunaComMaiorSoma - 39];
            return nomeDoQuadrante;


	}
	
	public String Responder5(ArrayList<ArrayList<String>> dados) {

        int maxSoma = 0;
        int colunaComMaiorSoma = -1;

        String[] nomesDosQuadrantes = {"1", "2", "3", "4"};

        for (int i = 43; i <= 46; i++) { 
            ArrayList<String> colunaQuadrante = dados.get(i);

            int somaAtual = 0;

            for (String valor : colunaQuadrante) {    
            	if(valor != null)
                somaAtual += Integer.parseInt(valor);
            	else {
            		
            	}
            }

            if (somaAtual > maxSoma) {
                maxSoma = somaAtual;
                colunaComMaiorSoma = i;
            }
        }
            String nomeDoQuadrante = nomesDosQuadrantes[colunaComMaiorSoma - 43];
            return nomeDoQuadrante;
	}
	
	public int Responder6(ArrayList<ArrayList<String>> dados) {

		int cont = 0;
		ArrayList<String> aux = dados.get(1);

		for (int i = 0; i < aux.size(); i++) {
			cont++;
		}

        return cont;
    }
	
	public String Responder7(ArrayList<ArrayList<String>> dados) {
        String[] nomesDosPlanetas = {"Python", "JavaScript", "Ruby", "PHP", "C#", "C++", "C"};

        String resultado = "";

        for (int i = 18; i <= 24; i++) {
            ArrayList<String> colunaVelocidade = dados.get(i);

            int somaAtual = 0;

            for (String valor : colunaVelocidade) {
                    somaAtual += Integer.parseInt(valor);
            }

            double media = (double) somaAtual / Responder6(dados);

            resultado += nomesDosPlanetas[i - 18] + ":" + media + " - ";
        }

        return resultado;
	}
	
	public int Responder8(ArrayList<ArrayList<String>> dados) {

        int somaTotal = 0;

        for (int i = 39; i <= 42; i++) {
            ArrayList<String> coluna = dados.get(i);

            for (String valor : coluna) {
            	if(valor != null)
                    somaTotal += Integer.parseInt(valor);
            }
        }

        return somaTotal;
	}
	
	public int Responder9(ArrayList<ArrayList<String>> dados) {


        int somaTotal = 0;


        for (int i = 43; i <= 46; i++) {
            ArrayList<String> coluna = dados.get(i);

            for (String valor : coluna) {
            	if(valor != null)
                    somaTotal += Integer.parseInt(valor);
            }
        }

        return somaTotal;
	}
	
	public int Responder10(ArrayList<ArrayList<String>> dados) {
        int somaTotal = 0;


        for (int i = 25; i <= 31; i++) {
            ArrayList<String> coluna = dados.get(i);

            for (String valor : coluna) {
            	if(valor != null)
                    somaTotal += Integer.parseInt(valor);
            }
        }

        return somaTotal;
	}
	
	public int Responder11(ArrayList<ArrayList<String>> dados) {
        int somaTotal = 0;


        for (int i = 32; i <= 38; i++) {
            ArrayList<String> coluna = dados.get(i);

            for (String valor : coluna) {
            	if(valor != null)
                    somaTotal += Integer.parseInt(valor);
            }
        }

        return somaTotal;
	}
}
