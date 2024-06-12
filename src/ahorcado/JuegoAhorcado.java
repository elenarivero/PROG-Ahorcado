package ahorcado;

import java.util.Random;

public class JuegoAhorcado {
	public static final String[] PALABRAS = {"humanidad",
			"persona",
			"hombre",
			"mujer",
			"individuo",
			"cuerpo",
			"pierna",
			"cabeza",
			"brazo",
			"familia",
			"ventana",
			"persiana",
			"ordenador"};
	
	public final static int NUMINTENTOS = 7;
	
	public static String palabraSecreta = "";
	
	public static String palabraPista = "";
	
	public static String noAcertadas = "";
	
	public static void generaPalabra() {
		Random rand = new Random();
		int pos = rand.nextInt(0, PALABRAS.length);
		palabraSecreta = PALABRAS[pos];
		
		for(int i=0;i<palabraSecreta.length(); i++) {
			palabraPista += "_";
		}
	}
	
	public void compruebaLetra(char letra) {
		char letraMin = Character.toLowerCase(letra);
		int pos = palabraSecreta.indexOf(letraMin);
		char[] pistaArray = palabraPista.toCharArray();
		
		if(pos<0) {
			noAcertadas += letra + " ";
		} else {
			while(pos>=0) {
				pistaArray[pos] = letra;
				pos = palabraSecreta.indexOf(letra, pos+1);
			}
			palabraPista = String.valueOf(pistaArray);
		}
	}
	
	public void compruebaLetra2(char letra) {
		char letraMin = Character.toLowerCase(letra);
		int posFinal = palabraSecreta.indexOf(letraMin);
		int posInicio = 0;
		
		if(posFinal<0) {
			noAcertadas += letra + " ";
		} else {
			while(posFinal>=0) {
				palabraPista = palabraPista.substring(posInicio, posFinal) + letra + palabraPista.substring(posFinal+1, palabraPista.length());
				posFinal = palabraSecreta.indexOf(letra, posFinal+1);
			}
			
		}
	}
	
	public void compruebaPalabra(String palabra) {
		if(palabra.equalsIgnoreCase(palabraSecreta)) {
			palabraPista = palabra;
		}
	}
	
	public static void pintaPista() {
		System.out.println("No acertadas: " + noAcertadas);
		System.out.println("Pista: " + palabraPista);
	}
}
