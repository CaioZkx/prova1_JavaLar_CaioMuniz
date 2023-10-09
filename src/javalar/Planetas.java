package javalar;

public abstract class Planetas extends PlanoCartesiano {
	protected String Nome;
	protected int VelTranslacao;
	protected double VelRotacao;
	
	protected double Horastotal = 0;
	protected double Anostotal = 0;
	protected double Anos = 0;
	protected double Horas =0;
	
	
	protected int QntEspacos;
		
	public void translacao(int instante) {
		int moves = instante * VelTranslacao;
		while (moves > 0) {
			if(y == Ymax && x > Xmin) {
				x--;
				moves--;
			}
			else if(x == Xmin && y > Ymin) {
				y--;
				moves--;
			}
			else if(y == Ymin && x < Xmax) {
				x++;
				moves--;
		    }
			else if(x == Xmax && y < Ymax) {
				y++;
				moves--;
			}	
	    }
		System.out.println("("+ x +"," + y+")");
	}
	
	
	public void diminuirTranslacao() {
		VelTranslacao--;
	}
	
	public void aumentarTranslacao() {
		VelTranslacao++;
	}

	public void GetName() {
		System.out.println(Nome);
	}

	public void HorasRodada(int instante) {
		Horas = instante * VelRotacao;		
		Horastotal();
		System.out.println(Horas + " horas");
	}
	
	public void Horastotal() {
		Horastotal += Horas;
	}
	
	public void ImprimirHorastotal() {
		System.out.println(Horastotal + " horas");
	}
	
	public void Anostotal() {
		Anostotal += Anos;
	}
	
	public void ImprimirAnostotal() {
		System.out.println(Anostotal + " anos");
	}
	
	public void AnosRodada(int instante) {
		Anos = instante / (QntEspacos / VelTranslacao) ;
		Anostotal();
		System.out.println(Anos + " anos");
	}
	
	
}
