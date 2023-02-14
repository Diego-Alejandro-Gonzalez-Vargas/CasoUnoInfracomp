package casoUno;

import java.util.Scanner;

public class Principal {
	public static void main(String[] args) {
        Buffer bufferUno = new Buffer(1000) ;
        Buffer bufferDos = new Buffer(1000) ;

        Scanner myObj = new Scanner(System.in);  
        System.out.println("Ingrese la cantidad de producidos del proceso Azul 1");
        int capAzul1 = Integer.parseInt(myObj.nextLine());
        
        Scanner myObj2 = new Scanner(System.in);  
        System.out.println("Ingrese la cantidad de producidos del proceso Azul 2");
        int capAzul2 = Integer.parseInt(myObj2.nextLine());
        
        Scanner myObj3 = new Scanner(System.in);  
        System.out.println("Ingrese la cantidad de producidos del proceso Naranja");
        int capNaranja = Integer.parseInt(myObj3.nextLine());
        
        
        
        ProcesoUno p1Azul1 = new ProcesoUno (capAzul1, bufferUno, "AZUL");
        ProcesoUno p1Azul2 = new ProcesoUno (capAzul1, bufferUno, "AZUL");
        ProcesoUno p1Naranja = new ProcesoUno (capNaranja, bufferUno, "NARANJA");
        
        p1Azul1.start () ; 
        p1Azul2.start () ;
        p1Naranja.start () ;
        
        ProcesoDos p2Azul1 = new ProcesoDos (capAzul1, bufferUno, bufferDos, "AZUL");
        ProcesoDos p2Azul2 = new ProcesoDos (capAzul1, bufferUno, bufferDos, "AZUL");
        ProcesoDos p2Naranja = new ProcesoDos (capNaranja, bufferUno, bufferDos, "NARANJA");
        
        p2Azul1.start () ; 
        p2Azul2.start () ;
        p2Naranja.start () ;
    }

}
