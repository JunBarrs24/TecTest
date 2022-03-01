package Mocks;

import Mocks.Excepciones.ExcepcionBase;

/**
 * NO ME HAGAS CASO, ES PARA COMPLETAR
 * @author junba
 *
 */
public class BaseDeDatos {
	
	/**
	 * Este método en ocasiones puede tirar una excepción 
	 * o regresar "Error"
	 * @param boleto
	 * @return
	 */
	public String guardar(Boleto boleto) throws ExcepcionBase {
		return "Te guardé el boleto";
	}
	
	/**
	 * Revisa el nombre del boleto y si existe regresa true.
	 * Sino regresa false.
	 * Tira excepción por algunas razones
	 * @param boleto
	 * @return
	 * @throws Exception
	 */
	public boolean existe(Boleto boleto) throws ExcepcionBase {
		return true;
	}
}
