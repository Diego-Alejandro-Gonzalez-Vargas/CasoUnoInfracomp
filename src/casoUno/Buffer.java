package casoUno;


import java.util.ArrayList; 
public class Buffer {
    private ArrayList buff ;
    private int n ;

    public Buffer (int n) {
       this.n = n ;
       buff = new ArrayList <Producto>(n) ;
    }


    public void almacenar (Producto i) {
    	buff.add (i) ;
    }
    
    
    public Producto retirar () {
    	Producto i = (Producto) buff.remove (0) ;
        return i ;
    }


	public boolean puedoAlmacenar() {
		boolean centinela = true;
		if(buff.size() == n) {
			centinela = false;
		}
		return centinela;
	}
	public boolean puedoRetirar() {
		boolean centinela = true;
		if(buff.size() == 0) {
			centinela = false;
		}
		return centinela;
	}


}