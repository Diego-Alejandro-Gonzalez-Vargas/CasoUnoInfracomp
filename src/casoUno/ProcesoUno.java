package casoUno;

import java.util.concurrent.ThreadLocalRandom;

public class ProcesoUno extends Thread{

  private int aProducir;
  private int producidos = 0;
  private Buffer theBuffer;
  private String color;
 
  public ProcesoUno (int i, Buffer buffer, String colorr) {
	aProducir = i;
	theBuffer = buffer;
	color = colorr;

  }
  
  public void run() {
	
	while (producidos < aProducir) {

		almacenar();
		
	}
  }
  
  
  public  void almacenar() {
	  if(color.equals("AZUL")) {
		  Producto prod = new Producto("AZUL");
		  Integer tiempoImprimir = ThreadLocalRandom.current().nextInt(50, 500);
          try {
			sleep(tiempoImprimir);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		  System.out.println("Produje el producto: " + prod.getElstring()+ ". DEMORA ETAPA 1: " +tiempoImprimir + "mseg.");
		  String transformador = prod.getElstring() + "DEMORA ETAPA 1: " +tiempoImprimir + "mseg.";
	      prod.setElstring(transformador);
		  synchronized(theBuffer) {
      	while (!theBuffer.almacenarBien(prod)) { 
      		
          	    try {
                   theBuffer.wait() ;
          	     } 
                 catch (InterruptedException e) {
          	
                 }
      		
      	}
      	
  
        producidos++;
        
        theBuffer.notifyAll () ;
        }   
      }
      else {
    	  
    	  Producto prod = new Producto("NARANJA");
    	  Integer tiempoImprimir = ThreadLocalRandom.current().nextInt(50, 500);
          try {
			sleep(tiempoImprimir);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		  System.out.println("Produje el producto: " + prod.getElstring()+ ". DEMORA ETAPA 1: " +tiempoImprimir + "mseg.");
		  String transformador = prod.getElstring() + "DEMORA ETAPA 1: " +tiempoImprimir + "mseg.";
	      prod.setElstring(transformador);
    		while (!theBuffer.almacenarBien(prod)) 
      	{
      		Thread.yield();
      	}
      	producidos++;
      	
      
       
      }
  }

}
