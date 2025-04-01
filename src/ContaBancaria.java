import java.text.DecimalFormat;

public class ContaBancaria {
    public String titular;
    private double saldo;

    private DecimalFormat formato = new DecimalFormat("#,###.00");

    public ContaBancaria(String titular, double saldo){
        this.titular = titular;
        this.saldo = saldo;
    }

    public String getTitular() {
        return titular;
    }

    private void setTitular(String titular) {
        this.titular = titular;
    }

    public double getSaldo() {
        return saldo;
    }

    private void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public void Depositar(double valor)
    {

        System.out.println("\nDepósito de R$ " + formato.format(valor) + " sendo processado...\n");
        if (valor <= 0 )
        {
            System.out.println("Valor à depositar precisa ser maior que 0!\n");
            return;
        }

        this.saldo += valor;

        System.out.println("Depósito realizado com sucesso!");
        System.out.println("Novo saldo bancário de: R$ " + formato.format(this.saldo) + "\n");
    }

    public void Sacar(double valor){

        System.out.println("\nSaque de R$ " + formato.format(valor) + " sendo processado...\n");
        if(this.saldo < valor){
            System.out.println("Saldo bancário insuficiente para realizar o saque!");
            return;
        }
        else{
            this.saldo -= valor;
            System.out.println("Saque realizado com sucesso!");
            System.out.println("Novo saldo bancário de: R$ " + formato.format(this.saldo));
        }
    }

    public void ExibirSaldo(){
        System.out.println("\n----- Dados Bancários -----");
        System.out.println("Titular: " + this.titular);
        System.out.println("Saldo em Conta: R$ " + formato.format(this.saldo) + "\n");
    }
}
