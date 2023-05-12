import java.util.Scanner;


public class Soma {
	public static void main(String[] args) {
		
		int num1;
		int num2;
		
		Scanner in = new Scanner (System.in);
		
		System.out.println("Digite o primeiro número: ");
		num1 = in.nextInt();
		System.out.println("Digite o segundo número: ");
		num2 = in.nextInt();
		
		System.out.println("A soma entre %d e %d é igual a %d".formatted(num1, num2, (num1+num2)));

		in.close();
		
	}
}
