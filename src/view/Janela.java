package view;

import javax.swing.*;

import javalar.Planetas;
import javalar.SistemaJavaLar;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
        	
        	
            public void actionPerformed(ActionEvent e) {
            		
            	syst.transladar(1);
            		
                    for (Planetas planeta : syst.planetas) {           
                    	        	
                        malha.mover(planeta.getY(), planeta.getX(), planeta.GetName());
//                        System.out.println(planeta.GetName() +planeta.getX() + " " + planeta.getY());
                        
                    }                
            }
        });


        
        botao1.setPreferredSize(new Dimension(350, 100));
        painelBotoes.add(botao1);

        JButton botao2 = new JButton("Ler novo arquivo de entrada");
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

