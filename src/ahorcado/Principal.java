package ahorcado;

import java.util.Scanner;

public class Principal {

	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		JuegoAhorcado ja = new JuegoAhorcado();
		String palabra;
		char letra;
		int opc;
		int intentos = 1;

		JuegoAhorcado.generaPalabra();

//		System.out.println(JuegoAhorcado.palabraSecreta);

		JuegoAhorcado.pintaPista();

		while (!JuegoAhorcado.palabraSecreta.equalsIgnoreCase(JuegoAhorcado.palabraPista)
				&& intentos < JuegoAhorcado.NUMINTENTOS) {

			do {
				opc = menu();

				switch (opc) {
				case 1:
					System.out.println("Introduzca una letra");
					letra = sc.nextLine().charAt(0);
					if (!JuegoAhorcado.palabraPista.contains(String.valueOf(letra))
							&& !JuegoAhorcado.noAcertadas.contains(String.valueOf(letra))) {
						intentos++;
						ja.compruebaLetra(letra);
					}
					break;
				case 2:
					System.out.println("Introduzca una palabra");
					palabra = sc.next();
					sc.nextLine();
					ja.compruebaPalabra(palabra);
					intentos++;
					break;
				default:
					System.out.println("Opción no válida");
					break;
				}
			} while (opc != 1 && opc != 2);

			JuegoAhorcado.pintaPista();

			System.out.println("Te quedan " + (JuegoAhorcado.NUMINTENTOS-intentos) + " intentos restantes");

		}

		if (intentos >= JuegoAhorcado.NUMINTENTOS) {
			System.out.println("HAS PERDIDO");
		} else {
			System.out.println("HAS GANADO");
		}

		sc.close();
	}

	private static int menu() {
		int opc = 0;
		System.out.println("Selecciona una de las siguientes opciones");
		System.out.println("1. Introducir letra");
		System.out.println("2. Introducir palabra");
		opc = sc.nextInt();
		sc.nextLine();
		return opc;
	}

}
