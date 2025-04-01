import java.text.DecimalFormat;
import java.util.Scanner;

public class Exercise03 {
    public void CalculoDeImposto(){
        Scanner sc = new Scanner(System.in);
        DecimalFormat formato = new DecimalFormat("#.00");

        while (true){
            System.out.print("Digite seu nome: ");
            String nome = sc.nextLine();

            System.out.print("Digite seu salário líquido mensal: ");
            String salario = sc.nextLine();

            if (!Main.entradaNumerica(salario))
            {
                System.out.println("Salário inválido, operação cancelada!");
                break;
            }

            double salarioConvertido = Double.parseDouble(salario);

            //Aqui não estamos considerando décimo terceiro, PLR, etc. Apenas o salário líquido
            // anual com base no líquido mensal.
            double salarioAnual = salarioConvertido * 12;

            double impostos = 0;

            if (salarioAnual <= 22847.76)
            {
                System.out.println( nome + "Seu salário anual de R$" + formato.format(salarioAnual) + " é isento de tributação!");
                break;
            }
            else if (salarioAnual <= 33919.80)
            {
                impostos = salarioAnual * .075;
                System.out.println("Salário anual de R$ " + formato.format(salarioAnual) + " sujeito a tributação de 7,5%");
                System.out.println("Valor à ser tributado: R$ " + (formato.format(impostos)));
                System.out.println( nome + "seu salário anual líquido de: R$ " + (formato.format(salarioAnual - impostos)));
                break;
            }
            else if (salarioAnual <= 45012.60)
            {
                impostos = salarioAnual * .15;
                System.out.println("Salário anual de R$ " + formato.format(salarioAnual) + " sujeito a tributação de 15%");
                System.out.println("Valor à ser tributado: R$ " + (formato.format(impostos)));
                System.out.println( nome + "seu salário anual líquido de: R$ " + (formato.format(salarioAnual - impostos)));
                break;
            }
            else
            {
                impostos = salarioAnual * .275;
                System.out.println("Salário anual de R$ " + formato.format(salarioAnual) + " sujeito a tributação de 27,5%");
                System.out.println("Valor à ser tributado: R$ " + (formato.format(impostos)) );
                System.out.println( nome + "seu salário anual líquido de: R$ " + (formato.format(salarioAnual - impostos)));
                break;
            }
        }
    }
}
