package Mocks;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class BoletoTest {
	private Boleto objetoAProbar;
	
	@BeforeAll()
	public static void setup() {
		System.out.println("Se ejecutó");
	}
	
	@Test
	public void test1() {
		objetoAProbar = new Boleto();
		objetoAProbar.setAsiento("A1");
		
		assertTrue(objetoAProbar.tieneAsiento());
		assertFalse(objetoAProbar.tieneNombre());
	}
}
