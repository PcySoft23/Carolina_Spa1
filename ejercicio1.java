import java.util.Scanner;

//Realiza un programa que pida dos números y que luego muestre el resultado
//de su multiplicación.


public class Ejercicio01 {
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		
	 int numero1;
	 int numero2;
	 int operacion;
		
		System.out.println("Introduzca un número: ");
		numero1=teclado.nextInt();
		
		System.out.println("Introduzca otro número: ");
		numero2=teclado.nextInt();
		
		operacion = (numero1 * numero2);
		
		System.out.println("El resultado de la operacion es:" + operacion);
		
		
		
		

	}

}
