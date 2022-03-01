package Mocks;

public class GeneradorId {
	private static String CARACTERES_VALIDOS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ" + "0123456789"; 
	
	public static String generaId(int largo) {
        StringBuilder builder;
        
        //create the StringBuffer
        builder = new StringBuilder(largo); 

        for (int m = 0; m < largo; m++) { 
            // generate numeric
            int myindex  = (int)(CARACTERES_VALIDOS.length() * Math.random()); 
            // add the characters
            builder.append(CARACTERES_VALIDOS.charAt(myindex)); 
        } 
        return builder.toString(); 
	}
}
