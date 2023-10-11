package javalar;

public class PlanoCartesiano {
	protected int x;
	protected int y;
	protected int Xmin;
	protected int Ymin;
	protected int Xmax;
	protected int Ymax;
	protected int north;
	protected int south;
	
	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
	
	
	public int getNorth() {
		return north;
	}

	public int getSouth() {
		return south;
	}
	
	
	
	public boolean verifyNorthSouth() {
		if(y > 8) {
			return true;
		}
		else return false;
	}
	
	public void northSouthCounter() {
		north = 0;
		south = 0;
		if(verifyNorthSouth()) {
			north++;
		}
		else south++;
	}
	
	
	
}


