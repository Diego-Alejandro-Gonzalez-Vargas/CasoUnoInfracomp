package casoUno;

public class Numero {
	private static int numero=0;
	
	public Numero() {
		//this.numero = nummm;
	}
	public synchronized int dar(){
		numero++;
		return numero;
	}
	

}
