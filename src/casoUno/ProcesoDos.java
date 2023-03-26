package casoUno;

import java.util.concurrent.ThreadLocalRandom;

public class ProcesoDos extends Thread{
	  private int aAlmacenar;
	  private int almacenados = 0;
	  private Buffer theBufferIn;
	  private Buffer theBufferOut;
	  private int etapa;
	  private String color;
	  
	  public ProcesoDos (int ii, Buffer bufferin, Buffer bufferout, String colorr, int etapaa) {
		this.aAlmacenar = ii;
		this.theBufferIn = bufferin;
		this.theBufferOut = bufferout;
		this.color = colorr;
		this.etapa = etapaa;
	  }
	  
	  public void run() {
		  while(almacenados<aAlmacenar) {
		  procesos();
		  }
	  }

	
	public  void procesos() {
		Producto i = null;
		
		  if(color.equals("AZUL")) {
			  
			  synchronized(theBufferIn) {
				  while ((i=theBufferIn.retirar("AZUL"))==null) { 
	      		
	          	    try {
	                   theBufferIn.wait() ;
	          	     } 
	                 catch (InterruptedException e) {
	          	
	                 }
	      		
	      	}

            theBufferIn.notifyAll () ;
            Integer tiempoImprimir = ThreadLocalRandom.current().nextInt(50, 500);
            try {
  			sleep(tiempoImprimir);
  		} catch (InterruptedException e1) {
  			// TODO Auto-generated catch block
  			e1.printStackTrace();
  		}
	        String transformador = i.getElstring() + " PASE POR LA ETAPA "+etapa+" DE COLOR "+color + " DEMORANDOME: "+tiempoImprimir+"mseg.";
	       
	        
	        i.setElstring(transformador);
	        System.out.println("SACOOO"+i.getElstring()+i.getColor());
	        }   
	      }
	      else {
	    	  
	    	  
	    		
		      	while ((i=theBufferIn.retirar("NARANJA"))==null) 
		      	{
		      		Thread.yield();
		      	}
		      	
		      	synchronized(theBufferIn) {
		      	theBufferIn.notifyAll () ;
		      	}
		      	Integer tiempoImprimir = ThreadLocalRandom.current().nextInt(50, 500);
	            try {
	  			sleep(tiempoImprimir);
	  		} catch (InterruptedException e1) {
	  			// TODO Auto-generated catch block
	  			e1.printStackTrace();
	  		}
		        String transformador = i.getElstring() + " PASE POR LA ETAPA "+etapa+" DE COLOR "+color + " DEMORANDOME: "+tiempoImprimir+"mseg.";
		       
		      	i.setElstring(transformador);
				System.out.println("SACOOO"+i.getElstring()+i.getColor());
	    	  
	      
	       
	      }
		  //AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA
		  //A PARTIR DE ACA ALMACENO
		  //AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA
		  
		  if(color.equals("AZUL")) {
			  synchronized(theBufferOut) {
	      	while (!theBufferOut.almacenarBien(i)) { 
	      		
	          	    try {
	                   theBufferOut.wait() ;
	          	     } 
	                 catch (InterruptedException e) {
	          	
	                 }
	      		
	      	}
	      	
	  
	        almacenados++;
	        
	        theBufferOut.notifyAll () ;
	        }   
	      }
	      else {
	    	  synchronized(theBufferOut) {
	      	while (!theBufferOut.almacenarBien(i)) 
	      	{
	      		
	      		Thread.yield();
	      	}
	      	almacenados++;
	      	theBufferOut.notifyAll () ;
	    	  }
	      
	       
	      }
		  
		  
	  }

	

}
