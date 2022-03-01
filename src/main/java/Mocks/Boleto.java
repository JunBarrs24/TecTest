package Mocks;

/**
 * Una clase que representa un objeto
 * @author junba
 *
 */
public class Boleto {
	
	public Boleto() {
		this.id = GeneradorId.generaId(10);
	}
	
	public String getNombreReservar() {
		return NombreReservar;
	}
	public void setNombreReservar(String nombreReservar) {
		NombreReservar = nombreReservar;
	}
	public String getAsiento() {
		return asiento;
	}
	public void setAsiento(String asiento) {
		this.asiento = asiento;
	}
	
	public boolean tieneAsiento() {
		return !this.isNullOrEmpty(this.NombreReservar);
	}
	
	
	public boolean tieneNombre() {
		return !this.isNullOrEmpty(this.asiento);
	}
	
	public boolean esDelJefazo() {
		return NombreReservar.equals("JuanB");
	}
	
	private boolean isNullOrEmpty(String cadena) {
		if (cadena == null) {
			return true;
		}
		if (cadena.trim().equals("")) {
			return true;
		}
		return false;
	}
	
	private String NombreReservar;
	private String asiento;
	private String id;
}
