package javalar;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import model.DAO;
import view.Janela;

public class SistemaJavaLar {
	
	protected ArrayList<Planetas> planetas;
	protected ArrayList<Planetas> planetasexplodidos;
	protected ArrayList<Bugs> Bug;
	protected ArrayList<Devs> Dev;
	protected int contadorInstantes;
	protected String arquivoAtual = "AE_10.csv";
	
	DAO dao = new DAO(this);
	Respostas respostas = new Respostas();
	
	public SistemaJavaLar() {
		this.planetas = new ArrayList<Planetas>();
		this.planetasexplodidos = new ArrayList<Planetas>();
		this.Bug = new ArrayList<Bugs>();
		this.Dev = new ArrayList<Devs>();
//		menuOperacoes();
	}
	
	public void adicionarPlaneta() {
		planetas.add(new Python());
        planetas.add(new JavaScript());
        planetas.add(new RubyOnRails());
        planetas.add(new PHP());
        planetas.add(new Csharp());
        planetas.add(new CPlusPlus());
        planetas.add(new C());
        
    }
	
//	private void menuOperacoes() {
//		Scanner scanner = new Scanner(System.in);
//		int op = 1;
//		int instante;
//		int bugs;
//		int devs;
//		
//		System.out.println("***************************BEM VINDO AO SISTEMA JAVALAR**************************" + "\nPara comecar, digite a quantidade de instantes, bugs e desenvolvedores que deseja ");
//		adicionarPlaneta();
//		
//		while(op == 1) {
//			System.out.print("Instantes: ");
//			instante = scanner.nextInt();
//			contadorDeInstantes(instante);
//			
//			System.out.print("Bugs: ");
//			bugs = scanner.nextInt();
//			
//			System.out.print("Desenvolvedores: ");
//			devs = scanner.nextInt();
//			
//			
//			
//			System.out.println("\n******** Dias em horas e anos da rodada ********");	
//			showYearHour(instante);
//
//			
//			System.out.println("\n******** Numero de Bugs e Desenvolvedores e suas posicoes ********");
//			System.out.println("Numero de Bugs: " + bugs);
//			adicionarBugs(bugs);
//			mostrarPosicaoBugs();
//			
//			System.out.println("\nNumero de Desenvolvedores: " + devs);
//			adicionarDevs(devs);
//			mostrarPosicaoDevs();
//			
//
//			transladar(instante);
//			
//			verificarColisaoPlanetaBug();
//			verificarColisaoPlanetaDev();
//			
//			verificarExplosaoPlanetas();
//			
//			System.out.println("\n******** Dados adicionais ********\n");
//			
//			
//			System.out.print("Numero de planetas no Norte: ");
//			northPlanets();
//			
//			System.out.print("Numero de planetas no Sul: ");
//			southPlanets();
//			
//			System.out.println("\nOcorrencia de alinhamento:");
//			verificarAlinhamento();
//			
//			System.out.println("\nDistancia entre planetas:");
//			calcularArea();
//			
//			System.out.println("\nDistancia euclidiana:");
//			calcularDistanciaEuclidiana();
//			
//			System.out.println("\nVelocidades de translacao:");
//			getVelTranslacao();
//			
//			
//			System.out.println("\nDeseja colocar novos dados? 1 - Sim / 2 - Nao");
//			op = scanner.nextInt();
//			
//			}
//		
//		System.out.println("\n******** Relatorio do sistema ********");
//		
//		System.out.println("\nNumero de colisoes de cada planeta:\n");
//		mostrarNumeroColisoes();
//		
//		System.out.println("\nInformacoes sobre os planetas:");
//		dadosPlanetas();
//		
//		System.out.println("\nPlanetas que explodiram:");
//		mostrarPlanetasExplodidos();
//		
//		System.out.println("\nQuantidade de instantes total:");
//		PrintContador();
//		
//		System.out.println("\nDias em horas e anos totais passados em cada planeta:");
//		mostrarAnosHorasTotais();
//		
//		System.out.println("\nResumo sobre cada planeta do sistema:");
//		relatorio.exibirResumo();
//	}
	
	private void mostrarNumeroColisoes() {
		for (Planetas p : planetas) {
			System.out.println(p.GetName() + ": " + p.colisoesComBug + " colisoes com bugs e " + p.colisoesComDev + " colisoes com devs\n");
		}
		for (Planetas p : planetasexplodidos) {
			System.out.println(p.GetName() + ": " + p.colisoesComBug + " colisoes com bugs e " + p.colisoesComDev + " colisoes com devs\n");
		}
	}
	
	private void mostrarPlanetasExplodidos() {
		for (Planetas palnetas : planetasexplodidos) {
			System.out.println(palnetas.GetName());
		}
	}
	
	private void mostrarAnosHorasTotais() {
		for (Planetas planeta : planetas) {
			System.out.println("\n" + planeta.GetName());
            planeta.ImprimirHorastotal();
            planeta.ImprimirAnostotal();
        }
		for (Planetas p : planetasexplodidos) {
			System.out.println("\n" + p.GetName());
            p.ImprimirHorastotal();
            p.ImprimirAnostotal();
		}
	}
	
	public void transladar(int instante) {
		for (Planetas p : planetas) {
			p.translacao(instante);
		}
	}
	
	private void calcularArea() {
		for (Planetas planeta1 : planetas) {
			for (Planetas planeta2 : planetas) {
				System.out.print(planeta2.GetName() + " X " + planeta1.GetName() + ": " + calculadoraArea(planeta2.getX(), planeta2.getY(), planeta1.getX(), planeta1.getY()) + "\n");
			}
		}
	}
	
	private double calculadoraArea(int x, int y, int x2, int y2) {
		double area = (Math.abs(x2 - x) + 1) * (Math.abs(y2 - y) + 1);
		
		return area;
	}

	private double calculaoraEuclidiana(int x, int y, int x2, int y2) {
		double distancia = Math.sqrt(Math.pow(Math.abs(x2 - x) + 1, 2) + Math.pow(Math.abs(y2 - y) + 1, 2));
		
		return distancia;
		
	}
	
	private void calcularDistanciaEuclidiana() {
		for (Planetas planeta1 : planetas) {
			for (Planetas planeta2 : planetas) {
				System.out.println(planeta2.GetName() + " X " + planeta1.GetName() + ": " + calculaoraEuclidiana(planeta2.getX(), planeta2.getY(), planeta1.getX(), planeta1.getY()));
				
			}
		}
	}

	private void northPlanets() {
		int cont = 0;
		
		for (Planetas planeta : planetas) {
			if(planeta.getY() > 8) {
				cont++;
			}
		}
		System.out.println(cont);
	}	

	private void southPlanets() {
		int cont = 0;
		
		for (Planetas planeta : planetas) {
			if(planeta.getY() < 8 ) {
				cont++;
			}
		}
		System.out.println(cont);
	}	
	
	private void getVelTranslacao() {
		for (Planetas p : planetas) {
			System.out.println(p.GetName() +": " +  p.VelTranslacao + " UI");
		}
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
	
	public boolean verificarCoordenadasBugs(int x, int y) {
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
	                planeta.colisoesComBug++;
//	                System.out.println("\nHouve colisao com bug: " + planeta.Nome + " (" + bug.getX() + "," + bug.getY()+ ")");
	                Bug.remove(i);
	                i--;
	            }
	        }
	    }
	}

	private void dadosPlanetas() {
		for (Planetas planeta : planetas) {
			System.out.println("\n" + planeta.GetName());
			System.out.println("Velocidade de Rotacao: " + planeta.VelRotacao + " UI");
			System.out.println("Velocidade de Translacao: " + planeta.VelTranslacao + " UI");
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

	public boolean verificarCoordenadasDevs(int x, int y) {
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
	                planeta.colisoesComDev++;
//	                System.out.println("\nHouve colisao com dev: " + planeta.Nome + " (" + dev.getX() + "," + dev.getY() + ")");
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

	            planetasexplodidos.add(planeta);
	            
	            planetasParaRemover.add(planeta);
	            
	            System.out.println("\nPlaneta explodiu: " + planeta.Nome);
	        }
	    }
	    
	    planetas.removeAll(planetasParaRemover);
	}

	
	private void mostrarPosicaoBugs() {
		for (Bugs bugs : Bug) {
			System.out.print("(" + bugs.getX() + "," + bugs.getY() + ")");
		}
	}
	private void mostrarPosicaoDevs() {
		for (Devs devs : Dev) {
			System.out.print("(" + devs.getX() + "," + devs.getY() + ")");
		}
	}
	
	
	private void showYearHour(int instante) {		
		for (Planetas planeta : planetas) {
			System.out.print(planeta.GetName() + ": ");
			planeta.HorasRodada(instante);
			planeta.AnosRodada(instante);		
		}
	}
	
	
	
	private void contadorDeInstantes(int instante) {
		contadorInstantes += instante;
	}
	private void PrintContador() {
		System.out.println(contadorInstantes);
	}
	
	private void verificarAlinhamento() {
		int cont = 0;
		for (Planetas p : planetas) {
			for (Planetas p2 : planetas) {
				if(p.getX() == p2.getX() || p.getY() == p2.getY())
					cont++;
			}
		}
		if(cont == 49)
			System.out.println("Ocorreu alinhamento");
		else System.out.println("Nao ocorreu alinhamento");
	}
	
	public String proximoArquivo(String arq) {
		
		if(arq == "AE_10.csv") {
			arquivoAtual = "AE_50.csv";			
			return arquivoAtual;
		}
		else if(arq == "AE_50.csv") {
			arquivoAtual = "AE_100.csv";
			return arquivoAtual;
		}
		else if(arq == "AE_100.csv") {
			arquivoAtual = "AE_500.csv";
			return arquivoAtual;
		}
		else if(arq == "AE_500.csv") {
			arquivoAtual = "AE_1000.csv";
			return arquivoAtual;
		}	
		else if(arq == "AE_1000.csv") {
			arquivoAtual = "AE_1500.csv";
			return arquivoAtual;
		}
		else if(arq == "AE_1500.csv") {
			arquivoAtual = "AE_2000.csv";
			return arquivoAtual;
		}
		else if(arq == "AE_2000.csv") {
			arquivoAtual = "AE_10.csv";
			return arquivoAtual;
		}
		return null;
	}
	
	public ArrayList<Planetas> getPlanetas() {
		return planetas;
	}

	public ArrayList<Bugs> getBug() {
		return Bug;
	}

	public ArrayList<Devs> getDev() {
		return Dev;
	}
	
	public String getArquivo() {
		return arquivoAtual;
	}
	
	public void gravarRelatorio() {
		dao.relatorio();
	}
	
	public void saidaArquivo() {
		dao.pegarArquivos();
	}
	
	public void arquivoDeSaida() {
		respostas.manipularArquivos(dao.getDados());
	}
	
}
