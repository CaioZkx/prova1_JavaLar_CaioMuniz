package javalar;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class SistemaJavaLar {
	
	protected ArrayList<Planetas> planetas;
	protected ArrayList<Planetas> planetasexplodidos;
	protected ArrayList<Bugs> Bug;
	protected ArrayList<Devs> Dev;
	protected int contadorInstantes;
	
	PlanoCartesiano plan = new PlanoCartesiano();
//	Relatorio relatorio = new Relatorio();
	
	public void adicionarPlaneta() {
		planetas.add(new Python());
        planetas.add(new JavaScript());
        planetas.add(new RubyOnRails());
        planetas.add(new PHP());
        planetas.add(new Csharp());
        planetas.add(new CPlusPlus());
        planetas.add(new C());
    }
	
	
	//apenas teste
//	public void posicoes(int instante) {
//		System.out.println("Posicoes:");
//		for (Planetas planeta : planetas) {
//			planeta.GetName();
//            planeta.translacao(instante);
//        }
//	}
	
	
//	public void dadosPlanetas() {
//		for (Planetas planeta : planetas) {
//			planeta.GetName();
//			System.out.println(planeta.VelRotacao);
//			System.out.println(planeta.VelTranslacao);
//		}
//	}
	
	
	
//	public void calcularArea() {
//		for (Planetas planeta1 : planetas) {
//			for (Planetas planeta2 : planetas) {
//				planeta2.GetName();
//				planeta1.GetName();
//				calculadora(planeta2.getX(), planeta2.getY(), planeta1.getX(), planeta1.getY());
//			}
//		}
//	}
//	
//	
//	
//	public void calculadora(int x, int y, int x2, int y2) {
//		int area = 1;
//		if(x > x2 && y > y2) {
//			int area = ((x- x2) + 1) * ((y - y2) + 1); 
//			System.out.println(area);
//		}
//		else if(x < x2 && y < y2) {
//			int area = ((x2 - x) + 1) * ((y2 - y) + 1);
//			System.out.println(area);
//		}
//		else if(x > x2 && y < y2) {
//			int area = ((x - x2) + 1) * ((y2 - y) + 1);
//			System.out.println(area);
//		}
//		else if(x < x2 && y > y2) {
//			int area = ((x2 - x) + 1) * ((y - y2) + 1);
//			System.out.println(area);
//		}
//		
//	}

	
	
	public void northPlanets() {
		for (Planetas planeta : planetas) {
			plan.verifyNorthSouth();
			plan.northSouthCounter();
		}
		System.out.println(plan.getNorth());
	}	
	public void southPlanets() {
		for (Planetas planeta : planetas) {
			plan.verifyNorthSouth();
			plan.northSouthCounter();
		}
		System.out.println(plan.getSouth());
	}
	
	private void menuOperacoes() {
		Scanner scanner = new Scanner(System.in);
		int op = 1;
		int instante;
		int bugs;
		int devs;
		
		
		
		
		System.out.println("***************************BEM VINDO AO SISTEMA JAVALAR**************************" + "\nPara comecar, digite a quantidade de instantes, bugs e desenvolvedores que deseja ");
		adicionarPlaneta();
		
		while(op == 1) {
			System.out.print("Instantes: ");
			instante = scanner.nextInt();
			contadorDeInstantes(instante);
			
			System.out.print("Bugs: ");
			bugs = scanner.nextInt();
			
			System.out.print("Desenvolvedores: ");
			devs = scanner.nextInt();
			
			
			
			System.out.println("******** Dias em horas e anos da rodada ********");	
			showYearHour(instante);

			
			System.out.println("******** Numero de Bugs e Desenvolvedores e suas posicoes ********");
			System.out.println("Numero de Bugs: " + bugs);
			adicionarBugs(bugs);
			mostrarPosicaoBugs();
			
			System.out.println("\nNumero de Desenvolvedores: " + devs);
			adicionarDevs(devs);
			mostrarPosicaoDevs();
			
//			posicoes(instante);
			
			verificarColisaoPlanetaBug();
			verificarColisaoPlanetaDev();
			
			verificarExplosaoPlanetas();

			
			System.out.println("\nDados adicionais:");
			
			
			System.out.println("Numero de planetas no Norte:");
			northPlanets();
			
			System.out.println("Numero de planetas no Sul:");
			southPlanets();
			
			System.out.println("Ocorrencia de alinhamento:");
			
			
			System.out.println("Distancia entre planetas:");
//			calcularArea();
			
			System.out.println("Distancia euclidiana:");
			
			
			System.out.println("Velocidades de translacao:");
			
			
			
			System.out.println("Deseja colocar novos dados? 1 - Sim / 2 - Nao");
			op = scanner.nextInt();
			
			}
		
		System.out.println("******** Relatorio do sistema ********");
		
		System.out.println("Numero de colisoes de cada planeta:");
		
		
		System.out.println("Informacoes sobre os planetas:");
//		relatorio.dadosPlanetas();

		
		
		System.out.println("Planetas que explodiram:");
		
		
		System.out.println("Quantidade de instantes total:");
		PrintContador();
		
		System.out.println("Dias em horas e anos totais passados em cada planeta:");
//		for (Planetas planeta : planetas) {
//            planeta.ImprimirHorastotal();
//            planeta.ImprimirAnostotal();
//        }
		
		System.out.println("Resumo sobre cada planeta do sistema:");
	}
	
	public SistemaJavaLar() {
		this.planetas = new ArrayList<Planetas>();
		this.planetasexplodidos = new ArrayList<Planetas>();
		this.Bug = new ArrayList<Bugs>();
		this.Dev = new ArrayList<Devs>();
		menuOperacoes();
	}
	
	public void adicionarBugs(int qntBugs) {
	    Random random = new Random();
	    
	    for (int i = 0; i < qntBugs; i++) {
	        int x, y;
	        
	        do {
	        	x = random.nextInt(15) + 1;
	            y = random.nextInt(15) + 1;
	        } while (verificarCoordenadasBugs(x, y));
	        
	        Bugs bug = new Bugs(x, y);  
	        Bug.add(bug);
	    }
	}
	
	private boolean verificarCoordenadasBugs(int x, int y) {
	    for (Bugs bug : Bug) {
	        if (bug.getX() == x && bug.getY() == y) {
	            return true;
	        }
	    }
	    return false;
	}
	
	public void verificarColisaoPlanetaBug() {
	    for (Planetas planeta : planetas) {
	        for (int i = 0; i < Bug.size(); i++) {
	            Bugs bug = Bug.get(i);
	            if (planeta.getX() == bug.getX() && planeta.getY() == bug.getY()) {
	                planeta.diminuirTranslacao();
	                System.out.println("\nHouve colisao com bug: " + planeta.Nome + "(" + bug.getX() + "," + bug.getY()+ ")");
	                Bug.remove(i);
	                i--;
	            }
	        }
	    }
	}

	

	
	public void adicionarDevs(int qntDevs) {
		Random random = new Random();
	    
	    for (int i = 0; i < qntDevs; i++) {
	        int x, y;
	        
	        do {
	        	x = random.nextInt(15) + 1;
	            y = random.nextInt(15) + 1;
	        } while (verificarCoordenadasDevs(x, y));
	        
	        Devs devs = new Devs(x, y);  
	        Dev.add(devs);
	    }
	}

	private boolean verificarCoordenadasDevs(int x, int y) {
	    for (Devs devs : Dev) {
	        if (devs.getX() == x && devs.getY() == y) {
	            return true;
	        }
	    }
	    return false;
	}

	public void verificarColisaoPlanetaDev() {
	    for (Planetas planeta : planetas) {
	        for (int i = 0; i < Dev.size(); i++) {
	            Devs dev = Dev.get(i);
	            if (planeta.getX() == dev.getX() && planeta.getY() == dev.getY()) {
	                planeta.aumentarTranslacao();
	                System.out.println("\nHouve colisao com dev: " + planeta.Nome);
	                Dev.remove(i);
	                i--;
	            }
	        }
	    }
	}	
	
	
	public void verificarExplosaoPlanetas() {
	    List<Planetas> planetasParaRemover = new ArrayList<>();
	    
	    for (Planetas planeta : planetas) {
	        if (planeta.VelTranslacao == 0) {
	            // Adicione o planeta ao array de planetas explodidos
	            planetasexplodidos.add(planeta);
	            
	            // Adicione o planeta à lista de planetas para remoção
	            planetasParaRemover.add(planeta);
	            
	            System.out.println("\nPlaneta explodiu: " + planeta.Nome);
	        }
	    }
	    
	    // Remova os planetas da lista de planetas
	    planetas.removeAll(planetasParaRemover);
	}

	
	public void mostrarPosicaoBugs() {
		for (Bugs bugs : Bug) {
			System.out.print("(" + bugs.getX() + "," + bugs.getY() + ")");
		}
	}
	public void mostrarPosicaoDevs() {
		for (Devs devs : Dev) {
			System.out.print("(" + devs.getX() + "," + devs.getY() + ")");
		}
	}
	
	
	private void showYearHour(int instante) {		
		for (Planetas planeta : planetas) {
			planeta.GetName();
			planeta.HorasRodada(instante);
			planeta.AnosRodada(instante);		
		}
	}
	
	
	
	public void contadorDeInstantes(int instante) {
		contadorInstantes += instante;
	}
	public void PrintContador() {
		System.out.println(contadorInstantes);
	}
	
	
	
}
