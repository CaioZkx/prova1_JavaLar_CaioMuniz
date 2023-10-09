package javalar;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int op = 1;
		int instant = 0;
		int instante;
		int bugs;
		int devs;
        
		SistemaJavaLar system = new SistemaJavaLar();
		Relatorio relatorio = new Relatorio();
		
		System.out.println("***************************BEM VINDO AO SISTEMA JAVALAR**************************" + "\nPara comecar, digite a quantidade de instantes, bugs e desenvolvedores que deseja ");
		
		while(op == 1) {
		System.out.print("Instantes: ");
		instante = scanner.nextInt();
		system.contadorDeInstantes(instante);
		
		System.out.print("Bugs: ");
		bugs = scanner.nextInt();
		
		System.out.print("Desenvolvedores: ");
		devs = scanner.nextInt();
		
		system.adicionarPlaneta();
		
		System.out.println("******** Dias em horas e anos da rodada ********");	
		system.showYearHour(instante);

		
		System.out.println("******** Numero de Bugs e Desenvolvedores e suas posicoes ********");
		System.out.println("Numero de Bugs: " + bugs);
		system.adicionarBugs(bugs);
		system.mostrarPosicaoBugs();
		System.out.println("\nNumero de Desenvolvedores: " + devs);
		system.adicionarDevs(devs);
		system.mostrarPosicaoDevs();
		
		
//		System.out.println("Posicoes:")
//		for (Planetas planeta : planetas) {
//			planeta.GetName();
//            planeta.translacao(instante);
//        }
		
		system.verificarColisaoPlanetaBug();
		system.verificarColisaoPlanetaDev();
		
//		system.removerBugs();
//		system.removerDevs();
		
		System.out.println("\nDados adicionais:");
		
		
		System.out.println("Numero de planetas no Norte:");
		system.northPlanets();
		
		System.out.println("Numero de planetas no Sul:");
		system.southPlanets();
		
		System.out.println("Ocorrencia de alinhamento:");
		
		
		System.out.println("Distancia entre planetas:");
//		system.calcularArea();
		
		System.out.println("Distancia euclidiana:");
		
		
		System.out.println("Velocidades de translacao:");
		
		
		
		System.out.println("Deseja colocar novos dados? 1 - Sim / 2 - Nao");
		op = scanner.nextInt();
		
		instant = instante;
		
		}
		
		System.out.println("******** Relatorio do sistema ********");
		
		System.out.println("Numero de colisoes de cada planeta:");
		
		
		System.out.println("Informacoes sobre os planetas:");
		relatorio.dadosPlanetas();
//		system.dadosPlanetas();
		
		
		System.out.println("Planetas que explodiram:");
		
		
		System.out.println("Quantidade de instantes total:");
		system.PrintContador();
		
		System.out.println("Dias em horas e anos totais passados em cada planeta:");
//		for (Planetas planeta : planetas) {
//            planeta.ImprimirHorastotal();
//            planeta.ImprimirAnostotal();
//        }
		
		System.out.println("Resumo sobre cada planeta do sistema:");
	}
}
