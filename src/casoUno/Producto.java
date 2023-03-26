package casoUno;

public class Producto {
	private String elstring;
	private static Numero numm = new Numero ();
	private int identificador;
	private String color;
	public Producto (String colorr) {
		this.identificador = numm.dar();
		this.elstring = "Este es el producto" + Integer.toString(this.identificador)+colorr;
		this.color = colorr;
	  }
	public String getColor() {
		return color;
	}
	public String getElstring() {
		return elstring;
	}
	public void setElstring(String elstring) {
		this.elstring = elstring;
	}
	public int getIdentificador() {
		return identificador;
	}
	

}
