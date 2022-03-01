package Utility;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class MatematicasTest {
	@Test
	public void testSuma() {
		int a = 3;
		int b = 3;
		int result = Matematicas.suma(a, b);
		
		assertTrue(result==6);
	}
}
