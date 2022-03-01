package Mocks;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import Mocks.ReservadorBoletos.RESULTADO;
import Mocks.Excepciones.ExcepcionBase;
import Utility.Matematicas;

@ExtendWith(MockitoExtension.class)
public class ReservarBoletosTest {
	
	@Mock
	private BaseDeDatos baseDeDatos;
	
	private ReservadorBoletos objeto;
	
	@Test
	public void probarBoletoNull() {
		objeto = new ReservadorBoletos(baseDeDatos);
		
		assertThrows(ExcepcionBase.class, () -> {
			 objeto.reservaBoleto(null);
		});
	}
	
	@Test
	public void probarBoletoNoTieneNombre() {
		Boleto boleto = new Boleto();
		objeto = new ReservadorBoletos(baseDeDatos);
		
		assertThrows(ExcepcionBase.class, () -> {
			 objeto.reservaBoleto(boleto);
		});
	}
	
	@Test
	public void probarBoletoNoTieneAsiento() {
		Boleto boleto = new Boleto();
		boleto.setNombreReservar("Un Nombre");
		objeto = new ReservadorBoletos(baseDeDatos);
		
		assertThrows(ExcepcionBase.class, () -> {
			 objeto.reservaBoleto(boleto);
		});
	}
	
	@Test
	public void probarBoletoYaExiste() throws ExcepcionBase {
		//Preparacion
		Boleto boleto = new Boleto();
		boleto.setNombreReservar("Un Nombre");
		boleto.setAsiento("A1");
		objeto = new ReservadorBoletos(baseDeDatos);
		when(baseDeDatos.existe(boleto)).thenReturn(true);
		
		RESULTADO result = objeto.reservaBoleto(boleto);
		
		assertTrue(result == RESULTADO.YA_EXISTE);
	}
	
	@Test
	public void probarBoletoHappyPath() throws ExcepcionBase {
		Boleto boleto = new Boleto();
		boleto.setNombreReservar("Un Nombre");
		boleto.setAsiento("A1");
		objeto = new ReservadorBoletos(baseDeDatos);
		when(baseDeDatos.existe(boleto)).thenReturn(false);
		when(baseDeDatos.guardar(boleto)).thenReturn("SE GUARDO");
		// when(baseDeDatos.guardar(boleto)).thenThrow(throwableType)
		
		RESULTADO result = objeto.reservaBoleto(boleto);
		
		assertTrue(result == RESULTADO.EXITOSO);
	}
}
