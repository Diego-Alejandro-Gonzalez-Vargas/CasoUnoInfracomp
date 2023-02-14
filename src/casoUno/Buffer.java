package casoUno;


import java.util.ArrayList; 
public class Buffer {
    private ArrayList buff ;
    private int n ;

    public Buffer (int n) {
       this.n = n ;
       buff = new ArrayList <Producto>(n) ;
    }


    public synchronized void almacenar (Producto i, String colorr) {

        if(colorr.equals("AZUL")) {
        	while (buff.size() == n) 
            	try {
                   wait() ;
            	} 
            catch (InterruptedException e) {
            	
            }

            buff.add (i) ; 
            notify () ;
        }
        else {
        	if (buff.size() == n) 
        	{
        		Thread.yield();
        	}
            buff.add (i) ; 
            notify () ;
        }
    }
    

    public synchronized Producto retirar (String colorr) {

        if(colorr.equals("AZUL")) {
        	while (buff.size () == 0) 
            	try {
                    wait() ;  //Conceptual
             	} 
             catch (InterruptedException e) {
             	
             }

            Producto i = (Producto) buff.remove (0) ;
            notify () ;

            return i ;
        }
        else {
        	if (buff.size() == 0) 
        	{
        		Thread.yield();
        	}
            Producto i = (Producto) buff.remove (0) ;
            notify () ;

            return i ;
        }
    }


}