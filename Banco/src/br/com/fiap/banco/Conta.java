package br.com.fiap.banco;

public class Conta extends Object { 
	
	private String numero;
	private double saldo;
	
	public Conta(String numero) {
		this.numero = numero;
	}
	
	public void depositar(double valor) {
		if (valor < 0) {
			System.out.println("Valor inválido!");
		}else {
			saldo += valor;
			System.out.println("""
					\nDepósito concluído!
					Seu saldo atual é de: %.2f""".formatted(this.saldo));
		}
	}
	
	public void sacar(double valor) {
		if (valor > this.saldo) {
			System.out.println("Saldo indisponível!");
		}else {
			saldo -= valor;
			System.out.println("""
					\nSaque realizado com sucesso!
					Seu saldo atual é de: %.2f""".formatted(this.saldo));
		}
	}
	
	public void transferir(double valor, Conta destino) {
		if (valor > this.saldo) {
			System.out.println("Valor inválido!");
		} else {
			saldo -= valor;
			destino.depositar(valor);
		}
	}

	public String getNumero() {
		return numero;
	}

	public double getSaldo() {
		return saldo;
	}
	
	
	
	

}
