import java.util.Scanner;

//Ejercicio 3
//Realiza un conversor de pesetas a euros. La cantidad de pesetas que se quiere
//convertir debe ser introducida por teclado.

public class Ejercicio03 {

	public static void main(String[] args) {
		  Scanner teclado = new Scanner(System.in);

		double euros;
		int pesetas;
		
		System.out.println("Introduzca la cantidad de Pesetas que quiere convertir a Euros: ");
		pesetas=teclado.nextInt();
		
		
		euros = pesetas /166.386;
		
		System.out.printf("La cantidad de Pesetas convertida a Euros, es de: %.2f %s ", euros,"€");
		

	}

}
