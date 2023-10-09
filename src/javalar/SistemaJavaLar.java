package javalar;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SistemaJavaLar {
	
	protected ArrayList<Planetas> planetas;
	protected ArrayList<Planetas> planetasexplodidos;
	protected ArrayList<Bugs> Bug;
	protected ArrayList<Bugs> RemoverBugs;
	protected ArrayList<Devs> Dev;
	protected ArrayList<Devs> RemoverDevs;
	protected int contadorInstantes;
	
	PlanoCartesiano plan = new PlanoCartesiano();

	public void adicionarPlaneta() {
		planetas.add(new Python());
        planetas.add(new JavaScript());
        planetas.add(new RubyOnRails());
        planetas.add(new PHP());
        planetas.add(new Csharp());
        planetas.add(new CPlusPlus());
        planetas.add(new C());
    }
	
	
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
	
	
	
	public SistemaJavaLar() {
		this.planetas = new ArrayList<Planetas>();
		this.planetasexplodidos = new ArrayList<Planetas>();
		this.Bug = new ArrayList<Bugs>();
		this.Dev = new ArrayList<Devs>();
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
	
	public void removerBugs() {
		
		for (Planetas planeta : planetas) {
            for (Bugs bug : Bug) {
                if (planeta.getX() == bug.getX() && planeta.getY() == bug.getY()) {
                    RemoverBugs.add(bug);
                }
            }
        }
		
		Bug.removeAll(RemoverBugs);
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
            for (Bugs bug : Bug) {
                if (planeta.getX() == bug.getX() && planeta.getY() == bug.getY()) {
                    planeta.diminuirTranslacao();
                    System.out.println("\nHouve colisao com bug: " + planeta.Nome);
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
	
	public void removerDevs() {
		
		for (Planetas planeta : planetas) {
            for (Devs dev : Dev) {
                if (planeta.getX() == dev.getX() && planeta.getY() == dev.getY()) {
                    RemoverDevs.add(dev);
                }
            }
        }
		
		Dev.removeAll(RemoverDevs);
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
            for (Devs dev : Dev) {
                if (planeta.getX() == dev.getX() && planeta.getY() == dev.getY()) {
                    planeta.aumentarTranslacao();
                    System.out.println("\nHouve colisao com dev: " + planeta.Nome);
                }
            }
        }
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
	
	
	public void showYearHour(int instante) {		
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
