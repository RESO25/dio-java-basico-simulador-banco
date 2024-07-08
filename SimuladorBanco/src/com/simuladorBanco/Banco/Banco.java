package com.simuladorBanco.Banco;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import com.simuladorBanco.Banco.Conta.*;
import com.simuladorBanco.Cliente.Cliente;

public class Banco {
    public String nomeBanco;
    private static final int AGENCIA_PADRAO = 1;
	private static int SEQUENCIAL = 1;
    private List<Conta> contas;

    public Conta CriarContaCorrente(Cliente cliente){
        Conta contaNova = new ContaCorrente(cliente, Banco.AGENCIA_PADRAO, SEQUENCIAL++);
        AdiconarConta(contaNova);
        return AcessarConta(contaNova.getAgencia(), contaNova.getNumero());
    }

    public Conta CriarContaPoupanca(Cliente cliente){
        Conta contaNova = new ContaPoupanca(cliente, Banco.AGENCIA_PADRAO, SEQUENCIAL++);
        AdiconarConta(contaNova);
        return AcessarConta(contaNova.getAgencia(), contaNova.getNumero());
    }

    public Conta AcessarConta(int agenciaConta, int numeroConta){
        Conta contaProcurada = null;
        for(Conta conta : contas){
            if(conta.getAgencia() == agenciaConta && conta.getNumero() == numeroConta){
                contaProcurada = conta;
            }
        }        
        return contaProcurada;
    }

    private void AdiconarConta(Conta contaParaAdiconar){
        this.contas.add(contaParaAdiconar);
        OrdenarContas();
    }

    private void OrdenarContas(){
        List<Conta> contasOrdenadas = new ArrayList<>(this.contas);
        Collections.sort(contasOrdenadas);
        this.contas = contasOrdenadas;

    }

    public void ExibirContas(){
        System.out.println("=== "+ this.getNomeBanco() +" ===");
        for(Conta conta : this.contas){
            conta.imprimirExtrato();
        }
    }

    public Banco(String nomeBanco) {
        this.contas = new ArrayList<>();
        this.nomeBanco = nomeBanco;
    }

    public String getNomeBanco() {
        return nomeBanco;
    }

}
