package casoUno;

public class ProcesoDos extends Thread{
	private int aConsumir;
	  private int consumidos = 0;
	  private Buffer theBufferIn;
	  private Buffer theBufferOut;
	  //private int myId;
	  private String color;
	  
	  public ProcesoDos (int i, Buffer bufferin, Buffer bufferout, String colorr) {
		this.aConsumir = i;
		this.theBufferIn = bufferin;
		this.theBufferOut = bufferout;
		this.color = colorr;
		//myId = id;
	  }
	  
	  public void run() {
		Producto i;  
		while (consumidos < aConsumir) {
			
			i = theBufferIn.retirar(this.color);
			System.out.println("Paso por etapa dos del producto " + i.getElstring());
			consumidos++;
			try {
	            // Esperamos entre 0 y 4 segundos 
	            sleep((int) (Math.random() * 4000));
	        } catch (InterruptedException e) { }
			
			theBufferOut.almacenar(i, this.color);
		}
	  }

}
