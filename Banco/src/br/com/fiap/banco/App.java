package br.com.fiap.banco;

public class App {
	
	public static void main(String[] args) {
		Conta conta = new Conta("00123-5");
		ContaPoupanca poupanca = new ContaPoupanca("00321-5");
		Conta conta1 = new Conta("00123-6");

		
		
		conta.depositar(1005);
		
		conta.sacar(5);
		
		conta.transferir(500, poupanca);
		
		
		System.out.println(conta.getSaldo());
		System.out.println(conta1.getSaldo());
		System.out.println(poupanca.getSaldo());
		
		poupanca.sacar(10);
		System.out.println(poupanca.getSaldo());
		
		
		/*ContaPoupanca poupanca = new ContaPoupanca("00321-5");
		poupanca.depositar(-54);
		poupanca.getNumero();*/
		
	}

}
