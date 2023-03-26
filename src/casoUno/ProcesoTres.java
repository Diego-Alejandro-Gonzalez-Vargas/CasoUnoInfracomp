package casoUno;

import java.util.ArrayList;

public class ProcesoTres extends Thread{
	private Producto[] loslistos;
	private int cuantosVoy=0;
	private int totales;
	private Buffer theBuffer;
	
	public ProcesoTres(int totalesAzul, int totalesNaranja, Buffer elbuffer)
	{
		this.totales = totalesAzul+totalesNaranja;
		this.loslistos = new Producto[totalesAzul+totalesNaranja];
		this.theBuffer = elbuffer;
	}
	public void run() {
		  while(cuantosVoy<totales) {
			  
			  retirar();
		  }
		  imprimirSorted();
	  }
	
	private void retirar() {
		
		Producto i = null;
		while ((i=theBuffer.retirarFinal())==null) 
      	{
			
      	}
		loslistos[i.getIdentificador()-1]=i;
		cuantosVoy++;
	}
	private void imprimirSorted() {
		System.out.println("=================EL PRINT FORMATEADO PARA LA ENTREGA===========================");
		for(Producto i: loslistos) {
			System.out.println(i.getElstring());
		}
		
	}
	
	
	

}
