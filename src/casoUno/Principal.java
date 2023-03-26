package casoUno;

import java.util.Scanner;

public class Principal {
	public static void main(String[] args) {

        Scanner myObj = new Scanner(System.in);  
        System.out.println("Ingrese la cantidad de procesos de etapa 1");
        int numprocesos = Integer.parseInt(myObj.nextLine());
        
        Scanner myObj1 = new Scanner(System.in);  
        System.out.println("Ingrese la cantidad de producidos POR PROCESO");
        int numpros = Integer.parseInt(myObj1.nextLine());
        
        Scanner myObj2 = new Scanner(System.in);  
        System.out.println("Ingrese la cantidad de productos en el primer buffer");
        int bufOneCap = Integer.parseInt(myObj2.nextLine());
        

        Scanner myObj3 = new Scanner(System.in);  
        System.out.println("Ingrese la cantidad de productos en el segundo buffer");
        int bufTwoCap = Integer.parseInt(myObj3.nextLine());
        
        Buffer bufferUno = new Buffer(bufOneCap, "elprimero", false) ;
        Buffer bufferDos = new Buffer(bufTwoCap, "elsegundo", false) ;
        Buffer bufferTres = new Buffer(1000, "eltercero", true) ;
        
        if(numprocesos > 1) {
        for(int i = 1; i<numprocesos; i++)
        {
        	ProcesoUno e1Azul = new ProcesoUno (numpros, bufferUno, "AZUL");
            e1Azul.start () ; 
            ProcesoDos e2Azul = new ProcesoDos (numpros, bufferUno, bufferDos, "AZUL", 2);
            e2Azul.start () ;
            ProcesoDos e3Azul = new ProcesoDos (numpros,  bufferDos, bufferTres, "AZUL", 3);
            e3Azul.start () ;
        	
        }
        }
        ProcesoUno e1Naranja = new ProcesoUno (numpros, bufferUno, "NARANJA");
        e1Naranja.start () ; 
        ProcesoDos e2Naranja = new ProcesoDos (numpros, bufferUno, bufferDos, "NARANJA", 2);
        e2Naranja.start () ;
        ProcesoDos e3Naranja = new ProcesoDos (numpros, bufferDos, bufferTres, "NARANJA", 3);
        e3Naranja.start () ;
        int totalnaranja = numpros;

        int totalazules = (numpros*numprocesos)-numpros;
        System.out.println("EL TOTAL NARANJA ES:"+totalnaranja);
        System.out.println("EL TOTAL AZUL ES:"+totalazules);
        System.out.println("PRECAUCION: ESTO PUEDE TARDAR(BASTANTE)....");
        ProcesoTres e4 = new ProcesoTres (totalazules, totalnaranja,bufferTres );
        e4.start () ;
    }

}
