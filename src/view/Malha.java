package view;

import java.awt.*;
import javax.swing.*;

public class Malha extends JPanel {

    private JPanel[][] quadradinhos;

    public Malha() {
        setLayout(new GridLayout(16, 16));

        quadradinhos = new JPanel[16][16];

        for (int linha = 0; linha < 16; linha++) {
            for (int coluna = 0; coluna < 16; coluna++) {
            	JPanel quadradinho = new JPanel();
                quadradinho.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                add(quadradinho);

                int novaLinha = 15 - linha;
                int novaColuna = coluna;
                quadradinhos[novaLinha][novaColuna] = quadradinho;
            }
        }

        quadradinhos[8][8].setBackground(Color.yellow);
        quadradinhos[9][8].setBackground(Color.red);;
        quadradinhos[10][8].setBackground(Color.blue);
        quadradinhos[11][8].setBackground(Color.gray);
        quadradinhos[12][8].setBackground(Color.green);
        quadradinhos[13][8].setBackground(Color.black);
        quadradinhos[14][8].setBackground(Color.cyan);
        quadradinhos[15][8].setBackground(Color.darkGray);
        
    }    
    
    public void mover(int x, int y, String name) {      
    	           
        if(name == "Python") {
        	quadradinhos[x][y].setBackground(Color.red);;       		
        }
        else if(name == "JavaScript") {
        	quadradinhos[x][y].setBackground(Color.blue);
        }
       	else if(name == "Ruby On Rails") {
       		quadradinhos[x][y].setBackground(Color.gray);
       	}
       	else if(name == "PHP") {
       		quadradinhos[x][y].setBackground(Color.green);
       	}
       	else if(name == "C#") {
       		quadradinhos[x][y].setBackground(Color.black);
       	}
       	else if(name == "C++") {
       		quadradinhos[x][y].setBackground(Color.cyan);
       	}
       	else if(name == "C") {
       		quadradinhos[x][y].setBackground(Color.darkGray);
       	}
       
        quadradinhos[x][y].revalidate();
        quadradinhos[x][y].repaint();

    }
    
    public void remove() {
    	for(int i = 0; i <= 15; i++) {
    		for(int j = 0; j <= 15; j++) {
    			quadradinhos[i][j].setBackground(null);
    		}
    	}
    	quadradinhos[8][8].setBackground(Color.YELLOW);
    }
  
    
}

