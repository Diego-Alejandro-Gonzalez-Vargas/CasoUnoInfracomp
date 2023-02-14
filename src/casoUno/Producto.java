package casoUno;

public class Producto {
	private String elstring;
	private static Numero numm = new Numero ();
	private int paproducto;
	public Producto () {
		this.paproducto = numm.dar();
		this.elstring = "Este es el producto" + Integer.toString(this.paproducto);
		
				

	  }
	public String getElstring() {
		return elstring;
	}
	public void setElstring(String elstring) {
		this.elstring = elstring;
	}
	public int getPaproducto() {
		return paproducto;
	}
	public void setPaproducto(int paproducto) {
		this.paproducto = paproducto;
	}

}
