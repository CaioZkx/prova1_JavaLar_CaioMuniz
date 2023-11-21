package view;

import javax.swing.*;

import javalar.Planetas;
import javalar.SistemaJavaLar;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Janela extends JFrame {

    private JPanel painelBotoes;
    private Malha malha;
    
    SistemaJavaLar syst = new SistemaJavaLar();

    public Janela() {
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(1, 2));
        montarJanela();
        setVisible(true);
    }

    private void montarJanela() {
        painelBotoes = new JPanel();
        painelBotoes.setLayout(new FlowLayout());
        malha = new Malha();
        
        
        
        
        JButton botao1 = new JButton("Processar proximo instante");
        syst.adicionarPlaneta();
        
        botao1.addActionListener(new ActionListener() {
        	
        	int linhaAtual = 2;
        	
        	
            public void actionPerformed(ActionEvent e) {
            	
            	try {
                    File arquivo = new File(ArquivoParaLer());
                    Scanner scanner = new Scanner(arquivo);

                    // Descarta a primeira linha (cabeçalho)
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

                    // Lê a próxima linha
                    if (scanner.hasNextLine()) {
                        String linha = scanner.nextLine();
                        linhaAtual++;

                        // Use a linha inteira como uma string
                        System.out.println("Linha lida: " + linha);

                        // Divida a linha em valores usando a vírgula como delimitador
                        String[] valores = linha.split(",");

                        // Se há pelo menos 2 valores, você pode acessar o segundo e o último
                        if (valores.length >= 2) {

                            int valorBugs = Integer.parseInt(valores[8]);
                            int valorDevs = Integer.parseInt(valores[9]);

                            syst.adicionarBugs(valorBugs);
                            syst.adicionarDevs(valorDevs);
                            syst.verificarColisaoPlanetaBug();
                            syst.verificarColisaoPlanetaDev();

                            for (Planetas pl : syst.planetas) {
                                
                            	if(pl.GetName() == "Pyton") {
                                	int i = Integer.parseInt(valores[1]);
                                	syst.transladar(i);
                                	malha.mover(pl.getY(), pl.getX(), pl.GetName());
                                }
                            	else if(pl.GetName() == "JavaScript") {
                            		int i = Integer.parseInt(valores[2]);
                            		syst.transladar(i);
                            		malha.mover(pl.getY(), pl.getX(), pl.GetName());
                            	}
                            	else if(pl.GetName() == "Ruby On Rails") {
                            		int i = Integer.parseInt(valores[3]);
                            		syst.transladar(i);
                            		malha.mover(pl.getY(), pl.getX(), pl.GetName());
                            	}
                            	else if(pl.GetName() == "PHP") {
                            		int i = Integer.parseInt(valores[4]);
                            		syst.transladar(i);
                            		malha.mover(pl.getY(), pl.getX(), pl.GetName());
                            	}
                            	else if(pl.GetName() == "C#") {
                            		int i = Integer.parseInt(valores[5]);
                            		syst.transladar(i);
                            		malha.mover(pl.getY(), pl.getX(), pl.GetName());
                            	}
                            	else if(pl.GetName() == "C++") {
                            		int i = Integer.parseInt(valores[6]);
                            		syst.transladar(i);
                            		malha.mover(pl.getY(), pl.getX(), pl.GetName());
                            	}
                            	else if(pl.GetName() == "C") {
                            		int i = Integer.parseInt(valores[7]);
                            		syst.transladar(i);
                            		malha.mover(pl.getY(), pl.getX(), pl.GetName());
                            	}
                                	
                            }
                            
//                            for (Planetas planeta : syst.planetas) {
//                                malha.mover(planeta.getY(), planeta.getX(), planeta.GetName());
//                            }
                        }
                    }

                    scanner.close();

                } catch (FileNotFoundException ex) {
                    ex.printStackTrace();
                }
            }
        });

        botao1.setPreferredSize(new Dimension(350, 100));
        painelBotoes.add(botao1);
        
        

        JButton botao2 = new JButton("Ler novo arquivo de entrada");
        int i = 1;
        
        
        
        botao2.addActionListener(new ActionListener() {
			
        	
        	public String ArquivoParaLer() {
        		
        		if(i == 1) {
        			String s = "C:\\Users\\caiom\\OneDrive\\Área de Trabalho\\Eclipse Projects\\JavaLar\\src\\AE_10.csv";
        			
        			return s;
        		}
        		else if(i == 2) {
        			String s = "C:\\Users\\caiom\\OneDrive\\Área de Trabalho\\Eclipse Projects\\JavaLar\\src\\AE_50.csv";
        			return s;
        		}
        		else if(i == 3) {
        			String s = "C:\\Users\\caiom\\OneDrive\\Área de Trabalho\\Eclipse Projects\\JavaLar\\src\\AE_100.csv";
        			return s;
        		}
        		else if(i == 4) {
        			String s = "C:\\Users\\caiom\\OneDrive\\Área de Trabalho\\Eclipse Projects\\JavaLar\\src\\AE_500.csv";
        			return s;
        		}
        		else if(i == 5) {
        			String s = "C:\\Users\\caiom\\OneDrive\\Área de Trabalho\\Eclipse Projects\\JavaLar\\src\\AE_1000.csv";
        			return s;
        		}
        		else if(i == 6) {
        			String s = "C:\\Users\\caiom\\OneDrive\\Área de Trabalho\\Eclipse Projects\\JavaLar\\src\\AE_1500.csv";
        			return s;
        		}
        		else if(i == 7) {
        			String s = "C:\\Users\\caiom\\OneDrive\\Área de Trabalho\\Eclipse Projects\\JavaLar\\src\\AE_2000.csv";
        			return s;
        		}
        		else return null;
        	}
			
			public void actionPerformed(ActionEvent e) {
				
				
			}
		});
        
        botao2.setPreferredSize(new Dimension(350, 100));
        painelBotoes.add(botao2);

        JButton botao3 = new JButton("Gravar relatorio");
        botao3.setPreferredSize(new Dimension(350, 100));
        painelBotoes.add(botao3);

        JButton botao4 = new JButton("Ler dados de outros participantes");
        botao4.setPreferredSize(new Dimension(350, 100));
        painelBotoes.add(botao4);

        JButton botao5 = new JButton("Gravar arquivo de saida");
        botao5.setPreferredSize(new Dimension(350, 100));
        painelBotoes.add(botao5);

        
        this.add(malha);
        this.add(painelBotoes);
    }
}

