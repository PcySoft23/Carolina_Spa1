//Ejercicio 2
//Realiza un conversor de euros a pesetas. La cantidad de euros que se quiere
//convertir debe ser introducida por teclado.
import java.util.Scanner;
public class Ejercicio02 {

	private static Scanner teclado;

	public static void main(String[] args) {
		  teclado = new Scanner(System.in);

		double operacion;
		double euros;
		
		System.out.println("Introduzca la cantidad de € que quiere convertir a pesetas: ");
		euros=teclado.nextDouble();
		
		operacion = euros * 166.386;
		
		System.out.println("La cantidad de Euros convertida a Pesetas, es de: " + operacion);
		
		
		

	}

}
