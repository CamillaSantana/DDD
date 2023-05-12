import java.util.Scanner;

public class ParOuImpar {
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		
		System.out.println("Digite um número:");
		int numero = in.nextInt();
		
		if (numero % 2 == 0) {
			System.out.println("O número %d é par".formatted(numero));
		} else { 
			System.out.println("O número %d é impar".formatted(numero));
		}
		
		in.close();
	}	
}
