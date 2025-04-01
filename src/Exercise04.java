import java.text.DecimalFormat;
import java.util.Scanner;

import static java.lang.System.out;

public class Exercise04 {

    public void SimuladorEmprestimo(){
        Scanner sc = new Scanner(System.in);
        DecimalFormat formato = new DecimalFormat("#.00");
        while (true)
        {

            out.print("Digite seu nome: ");
            String nome = sc.nextLine();

            out.print("Digite o valor do empréstimo desejado: R$ ");
            String emprestimo = sc.nextLine();

            if(!Main.entradaNumerica(emprestimo))
            {
                out.println("Valor do empréstimo inválido! Operação cancelada!");
                break;
            }

            out.print("Digite o número de parcelas desejadas (min 6 - max 48): ");
            String numeroDeParcelas = sc.nextLine();

            int parcelasConvertidas = 0;

            try {
                parcelasConvertidas = Integer.parseInt(numeroDeParcelas);
                if(parcelasConvertidas <= 5 || parcelasConvertidas >= 49)
                {
                    System.out.println("Número de parcelas inválido! Operação cancelada!");
                    break;
                }

            } catch (NumberFormatException e) {
                System.out.println("Número de parcelas inválido! Operação cancelada!");
                break;
            }

            double emprestimoConvertido = Double.parseDouble(emprestimo);
            double jurosMensais = (double)3 / 100;

            double jurosTotais = parcelasConvertidas * jurosMensais;
            double valorTotalJuros = emprestimoConvertido * jurosTotais;
            double valorTotalEmprestimo = emprestimoConvertido + valorTotalJuros;

            out.println(nome + ", seu empréstimo total será de R$ " + formato.format(valorTotalEmprestimo) +" em " + parcelasConvertidas + " meses,\n" +
                    "e sua parcela mensal de R$ " + formato.format(valorTotalEmprestimo / parcelasConvertidas));
            break;
        }
    }
}
