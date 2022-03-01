package Mocks;

import Mocks.Excepciones.ExcepcionBase;
import Mocks.Excepciones.Fatal;
import Mocks.Excepciones.Retryable;

public class ReservarBoletosNoTesteable {
	private static enum RESULTADO {
		EXITOSO,
		FALLO,
		YA_EXISTE
	}
	
	private static int INTENTOS_MAXIMOS = 1;
	
	private BaseDeDatos manejadorBase = new BaseDeDatos();
	
	/**
	 * Este método reserva el boleto.
	 * Si existe regresa que ya existe, sino lo registra en la base de datos
	 * Y regresa Exitoso.
	 * 
	 * Si falla, hace un re-intento de guardarlo
	 * 
	 * @param boleto
	 * @return
	 */
	public RESULTADO reservaBoleto(Boleto boleto) throws ExcepcionBase {
		// primero validamos que el boleto tenga datos
		validaBoleto(boleto);
		// Una vez que sabemos que el boleto es valido, vemos si ya existe en la base
		return reservaBoletoInt(boleto, 0);
	}
	
	private RESULTADO reservaBoletoInt(Boleto boleto, int attempts) throws ExcepcionBase {
		// Revisamos si se puede volver a intentar
		if (attempts > INTENTOS_MAXIMOS) {
			throw new Fatal("No se pudo guardar, intentos excedidos");
		}
		// Una vez que sabemos que el boleto es valido, vemos si ya existe en la base
		try {
			if (manejadorBase.existe(boleto)) {
				return  RESULTADO.YA_EXISTE;
			}
			manejadorBase.guardar(boleto);	
		} catch (Retryable ex) {
			return reservaBoletoInt(boleto, attempts);	
		} catch (Fatal fatal) {
		    return RESULTADO.FALLO;
		}
		return RESULTADO.EXITOSO;
	}

	private void validaBoleto(Boleto boleto) throws ExcepcionBase {
		if (boleto == null) {
			throw new ExcepcionBase("Boleto es nulo");
		}
		if (!boleto.tieneNombre()) {
			throw new ExcepcionBase("Boleto no tiene nombre");
		}
		if (!boleto.tieneAsiento()) {
			throw new ExcepcionBase("Boleto no tiene asiento");
		}
	}
}
