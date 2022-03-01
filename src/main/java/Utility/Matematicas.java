package Utility;

public class Matematicas {
	
	public static int suma(int a, int b) {
		return a+b;
	}
	
	public static int resta(int a, int b) {
		return a-b;
	}
	
	public static double divide(double a, double b) throws Exception {
		if (b == 0) {
			throw new Exception("No se puede dividir entre 0");
		} else {
			return a/b;
		}
	}
}
