package com.simuladorBanco.Banco.Conta;

import com.simuladorBanco.Cliente.Cliente;

public abstract class Conta implements IConta, Comparable<Conta> {

	
	protected int agencia;
	protected int numero;
	protected double saldo;
	protected Cliente cliente;
	
	public Conta(Cliente cliente, int agencia, int numero) {
		this.agencia = agencia;
		this.numero = numero;
		this.cliente = cliente;
	}

	@Override
	public int compareTo(Conta conta) {
		return this.cliente.getNome().compareToIgnoreCase(conta.cliente.getNome());
	}

	@Override
	public void sacar(double valor) {
		saldo -= valor;
	}

	@Override
	public void depositar(double valor) {
		saldo += valor;
	}

	@Override
	public void transferir(double valor, IConta contaDestino) {
		this.sacar(valor);
		contaDestino.depositar(valor);
	}

	public int getAgencia() {
		return agencia;
	}

	public int getNumero() {
		return numero;
	}

	public double getSaldo() {
		return saldo;
	}

	protected void imprimirInfosComuns() {
		System.out.println(String.format("Titular: %s", this.cliente.getNome()));
		System.out.println(String.format("Agencia: %d", this.agencia));
		System.out.println(String.format("Numero: %d", this.numero));
		System.out.println(String.format("Saldo: %.2f", this.saldo));
	}

}