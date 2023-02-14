package casoUno;

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
		//System.out.println("Productor " + " produciendo: " + producidos);
		almacenar();
		//System.out.println("guarde producto");
		try {
            // Esperamos entre 0 y 4 segundos 
            sleep((int) (Math.random() * 4000));
        } catch (InterruptedException e) { }
	}
  }
  
  public synchronized void almacenar() {
	  if(color.equals("AZUL")) {
      	while (!theBuffer.puedoAlmacenar()) { 
          	try {
                 wait() ;
          	} 
          catch (InterruptedException e) {
          	
          }
      	}
      	Producto prod = new Producto();
        theBuffer.almacenar(prod) ;
        producidos++;
        System.out.println("Produje el producto: " + prod.getElstring());
        notify () ;
      }
      else {
      	while (!theBuffer.puedoAlmacenar()) 
      	{
      		Thread.yield();
      	}
      	Producto prod = new Producto();
      	theBuffer.almacenar(prod) ;
      	producidos++;
      	System.out.println("Produje el producto: " + prod.getElstring());
        notify () ;
      }
  }
}
