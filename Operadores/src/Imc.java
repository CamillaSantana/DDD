import java.util.Scanner;


public class Imc {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		
		System.out.println("Insira o peso: ");
		double peso = in.nextDouble();
		System.out.println("Insira a altura: ");
		double altura = in.nextDouble();
		
		in.close();
		
		double imc = (peso)/(altura * 2);
		
		System.out.println("O IMC é %.2f".formatted(imc));
		
		
	}
}
