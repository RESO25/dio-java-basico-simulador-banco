package com.simuladorBanco.Banco.Conta;

import com.simuladorBanco.Cliente.Cliente;

public class ContaCorrente extends Conta{

    public ContaCorrente(Cliente cliente, int agencia, int numero) {
        super(cliente, agencia, numero);
    }

    @Override
	public void imprimirExtrato() {
		System.out.println("=== Extrato Conta Corrente ===");
		super.imprimirInfosComuns();
	}
    
}