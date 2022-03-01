package Utility;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class MatematicasTest {
	
	@Test
	public void testSuma() {
		// Preparacion
		int a = 3;
		int b = 3;

		// Ejecucion
		int result = Matematicas.suma(a, b);
		
		// Validacion
		assertTrue(result==6);
	}
	
	
	@Test
	public void testResta() {
		int a = 4;
		int b = 2;
		
		int result = Matematicas.resta(4, 2);
		
		assertTrue(result == 2);
	}
	
	@Test
	public void testDivide() throws Exception {
		double a = 6;
		double b = 3;
		
		double result = Matematicas.divide(a, b);
		
		assertTrue(result == 2);
	}
	
	@Test
	public void testDivide2() throws Exception {
		double a = 6;
		double b = -3;
		
		double result = Matematicas.divide(a, b);
		
		assertTrue(result == -2);
	}
	
	@Test
	public void testDivide3() throws Exception {
		double a = -6;
		double b = -3;
		
		double result = Matematicas.divide(a, b);
		
		assertTrue(result == 2);
	}
	
	@Test
	public void testDivide4() throws Exception {
		double a = 0;
		double b = -3;
		
		double result = Matematicas.divide(a, b);
		
		assertTrue(result == 0);
	}
	
	@Test
	public void testDivideEntre0() throws Exception {
		double a = 3;
		double b = 0;

		assertThrows(Exception.class, () -> {
			 Matematicas.divide(a, b);
		});
	}
	
	
	/*
	 * 
		verify(jaja, )
		import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;
	 */
}
