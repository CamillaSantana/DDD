import java.util.Scanner;

public class Media {
	public static void main(String[] args) {
		
		Scanner in = new Scanner (System.in);
		System.out.println("Informe o primeiro número: ");
		int numero1 = in.nextInt();
		System.out.println("Informe o segundo número: ");
		int numero2 = in.nextInt();
		
		double media = (numero1 + numero2)/2;
		
		System.out.println("A média é %.2f".formatted(media));
		
		in.close();
	
	}

}
