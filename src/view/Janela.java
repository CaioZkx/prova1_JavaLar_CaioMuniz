package view;

import javax.swing.*;
import javalar.Planetas;
import javalar.SistemaJavaLar;
import model.LerArquivo;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Janela extends JFrame {
	
	SistemaJavaLar syst = new SistemaJavaLar();
    LerArquivo arq = new LerArquivo();
    JLabel label = new JLabel(syst.getArquivo());
    
    
    private JPanel painelBotoes;
    private Malha malha;
    private String arquivoAtual = syst.getArquivo();
 	

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
        
        
            
        JButton botao1 = new JButton("Processar proximo instante");
        
        syst.adicionarPlaneta();
        botao1.addActionListener(new ActionListener() {
   	
            public void actionPerformed(ActionEvent e) {
            	
            	
            	String[] aux = arq.lerArquivo(arquivoAtual);
            	
            	int valorBugs = Integer.parseInt(aux[8]);
                int valorDevs = Integer.parseInt(aux[9]);

                syst.adicionarBugs(valorBugs);
                syst.adicionarDevs(valorDevs);    
                malha.remove();
                
                for (Planetas pl : syst.getPlanetas()) {
                    
                	if(pl.GetName() == "Python") {
                    	int i = Integer.parseInt(aux[1]);
                    	syst.transladar(i);
                    	malha.mover(pl.getY(), pl.getX(), pl.GetName());
                    }
                	else if(pl.GetName() == "JavaScript") {
                		int i = Integer.parseInt(aux[2]);
                		syst.transladar(i);
                		malha.mover(pl.getY(), pl.getX(), pl.GetName());
                	}
                	else if(pl.GetName() == "Ruby On Rails") {
                		int i = Integer.parseInt(aux[3]);
                		syst.transladar(i);
                		malha.mover(pl.getY(), pl.getX(), pl.GetName());
                	}
                	else if(pl.GetName() == "PHP") {
                		int i = Integer.parseInt(aux[4]);
                		syst.transladar(i);
                		malha.mover(pl.getY(), pl.getX(), pl.GetName());
                	}
                	else if(pl.GetName() == "C#") {
                		int i = Integer.parseInt(aux[5]);
                		syst.transladar(i);
                		malha.mover(pl.getY(), pl.getX(), pl.GetName());
                	}
                	else if(pl.GetName() == "C++") {
                		int i = Integer.parseInt(aux[6]);
                		syst.transladar(i);
                		malha.mover(pl.getY(), pl.getX(), pl.GetName());
                	}
                	else if(pl.GetName() == "C") {
                		int i = Integer.parseInt(aux[7]);
                		syst.transladar(i);
                		malha.mover(pl.getY(), pl.getX(), pl.GetName());              	
                	}               
                }
                syst.verificarColisaoPlanetaBug();
                syst.verificarColisaoPlanetaDev();
            	
            }
        });
        botao1.setPreferredSize(new Dimension(350, 100));
        painelBotoes.add(botao1);
        
        

        JButton botao2 = new JButton("Ler novo arquivo de entrada");          
        botao2.addActionListener(new ActionListener() {			
        				
			public void actionPerformed(ActionEvent e) {
			
				arquivoAtual = syst.proximoArquivo(arquivoAtual);
				
				painelBotoes.remove(label);
				label = new JLabel(arquivoAtual);
				painelBotoes.add(label);
				
				painelBotoes.repaint();
				painelBotoes.revalidate();
			
			}
		});              
        botao2.setPreferredSize(new Dimension(350, 100));
        painelBotoes.add(botao2);
        
        

        JButton botao3 = new JButton("Gravar relatorio");
        botao3.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
					syst.gravarRelatorio();

			}
		});                
        botao3.setPreferredSize(new Dimension(350, 100));
        painelBotoes.add(botao3);
        
        

        JButton botao4 = new JButton("Ler dados de outros participantes");
        botao4.addActionListener(new ActionListener() {
			

			public void actionPerformed(ActionEvent e) {
				syst.saidaArquivo();
				
			}
		});
        
        botao4.setPreferredSize(new Dimension(350, 100));
        painelBotoes.add(botao4);

        JButton botao5 = new JButton("Gravar arquivo de saida");
        botao5.addActionListener(new ActionListener() {
			

			public void actionPerformed(ActionEvent e) {
				syst.arquivoDeSaida();
				
			}
		});
        
        botao5.setPreferredSize(new Dimension(350, 100));
        painelBotoes.add(botao5);

        
        painelBotoes.add(new JLabel("Arquivo de entrada atual:"));
        painelBotoes.add(label);
               
        malha = new Malha();
        this.add(malha);
        this.add(painelBotoes);
    }
}

