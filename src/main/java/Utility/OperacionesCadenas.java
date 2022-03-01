package Utility;

public class OperacionesCadenas {
	
	public static String regresaVocales(String a) {
		StringBuilder result = new StringBuilder();
		for (int i=0;i<a.length();i++) {
			char caracterActual = a.charAt(i);
			switch (caracterActual) {
			case 'a':
			case 'e':
			case 'i':
			case 'o':
			case 'u':
				result.append(caracterActual);
			}
		}
		return result.toString();
	}
	
	/**
	 * Encontrar los errores de este algoritmo por medio de pruebas
	 * @param a
	 * @return
	 */
	public static String regresaDominio(String a) {
		String resultado = "";
		for (int i=0;i<a.length();i++) {
			if (a.charAt(i) == '@') {
				resultado = a.substring(i+1);
			}
		}
		return resultado;
	}
}
