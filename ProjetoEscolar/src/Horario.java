import java.util.Scanner;

public class Horario {
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		
		System.out.println("""
				Escolha uma opção:
				a - segunda
				b - terça
				c - quarta
				d - quinta
				e - quinta
				""");
		
		char resposta = in.next().charAt(0);
		
		switch (resposta) {
		case 'a':
			System.out.println("Aula da segunda: IA % CHATBOT");
			break;
		case 'b':
			System.out.println("Aula da terca: BUILDING RELATIONAL DATABASE");
			break;
		case 'c':
			System.out.println("Aula da quarta: COMPUTIONAL THINKING");
			break;
		case 'd':
			System.out.println("Aula da quinta: DOMAIN DRIVEN DESIGN");
			break;
		case 'e':
			System.out.println("Aula da sexta: RESPONSIVE WEB");
			break;
		default:
			System.out.println("Opcao invalida");
			break;
		}
		
		
		in.close();

		
		
	}
}