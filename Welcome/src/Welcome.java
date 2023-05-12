import java.util.Scanner;


public class Welcome {

	
	public static void main(String[] args) {
		
		Scanner in = new Scanner (System.in);
		
		System.out.println("Olá, seja bem vindo. Para começar, informe seu nome: ");
		String nome = in.nextLine();
		System.out.println("Agora insira o seu email: ");
		String email = in.nextLine();
		System.out.println("E por último, informe a sua idade: ");
		int idade = in.nextInt();
		System.out.println("""
				Seja bem vindo %s!
				Aqui estão os seus dados:
				Email: %s
				Idade: %d anos
				""".formatted(nome, email, idade));
		
		in.close();
	}
}
