package javalar;

import java.util.ArrayList;

public class Relatorio extends SistemaJavaLar {
	
	public Relatorio() {
		this.planetas = planetas;
		
	}
	
	public void dadosPlanetas() {
		for (Planetas planeta : planetas) {
			planeta.GetName();
			System.out.println(planeta.VelRotacao);
			System.out.println(planeta.VelTranslacao);
		}
	}
	
	
}
