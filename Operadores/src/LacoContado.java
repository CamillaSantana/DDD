import java.util.Scanner;


public class LacoContado {
	public static void main(String[] args) {
		
		Scanner in = new Scanner (System.in);
		
		System.out.println("Até que número você quer contar? ");
		int conteAte = in.nextInt();
		
		
		for( int i = 0; i <= conteAte ; i++) {
			System.out.println(i);
		}
		
		in.close();
	}
}
