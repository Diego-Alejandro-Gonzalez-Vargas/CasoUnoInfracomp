package casoUno;


import java.util.ArrayList; 
public class Buffer {
    private ArrayList buff = new ArrayList <Producto>() ;
    private int n ;
    private String nombre;
    private boolean esfinal;

    public Buffer (int n, String nombree, boolean esfinall) {
       this.n = n ;
       this.nombre = nombree;
       this.esfinal = esfinall;
       buff = new ArrayList <Producto>(n) ;
    }


    public synchronized Producto retirar (String colorrr) {
    	for(int x = 0; x<buff.size();x++) {
    		if(((Producto) buff.get(x)).getColor().equals(colorrr)) {
    			Producto palreturn = (Producto) buff.get(x);
    			buff.remove(x);
    			return palreturn;
    		}
    	}
    	return null;
        
    }
    
    public synchronized Producto retirarFinal () {
    	for(int x = 0; x<buff.size();x++) {
    		Producto palreturn = (Producto) buff.get(x);
			buff.remove(x);
			return palreturn;
    	}
    	return null;
        
    }

    
	public synchronized boolean almacenarBien(Producto p) {
		boolean centinela = true;
		if(esfinal) {
			buff.add(p);
		}
		else if(buff.size() == n) {
			centinela = false;
		}
		else {
			buff.add(p);
		}
		return centinela;
	}
	
	
	


}