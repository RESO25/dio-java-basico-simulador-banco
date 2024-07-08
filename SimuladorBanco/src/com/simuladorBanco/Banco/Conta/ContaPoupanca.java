package com.simuladorBanco.Banco.Conta;

import com.simuladorBanco.Cliente.Cliente;

public class ContaPoupanca extends Conta{
    
    public ContaPoupanca(Cliente cliente, int agencia, int numero) {
        super(cliente, agencia, numero);
    }

	@Override
	public void imprimirExtrato() {
		System.out.println("=== Extrato Conta Poupança ===");
		super.imprimirInfosComuns();
	}
    
}
