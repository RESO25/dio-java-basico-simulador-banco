import com.simuladorBanco.Banco.Banco;
import com.simuladorBanco.Banco.Conta.Conta;
import com.simuladorBanco.Cliente.Cliente;

public class Main {
    public static void main(String[] args) {
        Banco nubank = new Banco("Nubank");

        Cliente jonas = new Cliente("Jonas");
        Cliente pedro = new Cliente("Pedro");
        Cliente maria = new Cliente("Maria");

        Conta contaN1 = nubank.CriarContaCorrente(jonas);
        Conta contaN2 = nubank.CriarContaCorrente(pedro);
        Conta contaN3 = nubank.CriarContaPoupanca(maria);

        contaN1.depositar(100);
        contaN2.depositar(450.90);
        contaN3.depositar(256.32);

        nubank.ExibirContas();

        System.out.println("\n-------------------------------------\n");

        Banco santander = new Banco("Santander");

        Conta contaS1 = santander.CriarContaPoupanca(pedro);
        Conta contaS2 = santander.CriarContaPoupanca(jonas);
        Conta contaS3 = santander.CriarContaCorrente(maria);

        contaS1.depositar(200);
        contaS2.depositar(180.89);
        contaS3.depositar(21);

        santander.ExibirContas();
    }
}
