import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        Veiculos veiculo1 = new Veiculos("XPTOZ", "Honda", 2018, 50000);
        Veiculos veiculo2 = new Veiculos("XYZOP", "Chevrolet", 2018, 52000);

        ContaBancaria exercicio09 = new ContaBancaria("João da Silva Santos", 5000);

        while (true) {
            System.out.println("\n\nEscolha uma opção:");
            System.out.println("1 - Exercício 1 - Instalando e Configurando o Ambiente Java");
            System.out.println("2 - Exercício 2 - Validação de Senha Segura");
            System.out.println("3 - Exercício 3 - Calculadora de Impostos");
            System.out.println("4 - Exercício 4 - Simulador de Empréstimo Bancário");
            System.out.println("5 - Exercício 5 - Criando um Programa CGI em Java");
            System.out.println("6 - Exercício 6 - Cadastro de Veículos");
            System.out.println("7 - Exercício 7 - Gerenciador de Alunos");
            System.out.println("8 - Exercício 8 - Sistema de Funcionários");
            System.out.println("9 - Exercício 9 - Conta Bancária com Encapsulamento");
            System.out.println("10 - Exercício 10 - Registro de Compras em Arquivo");
            System.out.println("11 - Exercício 11 - Simulação de Loteria");
            System.out.println("12 - Exercício 12 - Sistema de Chat Simples com Arrays");
            System.out.println("0 - Sair");

            System.out.print("Digite o número da opção desejada: ");
            String opcao = sc.nextLine();

            if(!entradaNumerica(opcao)){
                System.out.println("Erro, entrada inválida!");
                continue;
            }

            int escolha = Integer.parseInt(opcao);

            if (escolha == 0 ) {
                System.out.println("Saindo...");
                break;
            } else if (escolha == 1) {
                Main exercise1 = new Main();
                exercise1.OlaMundo();

            } else if (escolha == 2) {

                Exercise02 exercise02 = new Exercise02();
                exercise02.Senha();

            } else if (escolha == 3) {

                Exercise03 exercise03 = new Exercise03();
                exercise03.CalculoDeImposto();

            } else if (escolha == 4) {

                Exercise04 exercise04 = new Exercise04();
                exercise04.SimuladorEmprestimo();

            } else if (escolha == 5) {

                Exercise05 exercise05 = new Exercise05();
                exercise05.SimuladorCGI();

            } else if (escolha == 6) {
                while (true)
                {
                    System.out.println("\n----- Opções -----");
                    System.out.println("01 - Exibir detalhes do veículo");
                    System.out.println("02 - Registrar viagem");
                    System.out.println("00 - Sair\n");

                    System.out.print("Digite o número da opção desejada: ");
                    String opcaoInterna = sc.nextLine();

                    if(!entradaNumerica(opcaoInterna)){
                        System.out.println("\nErro, entrada inválida!\n");
                        continue;
                    }

                    int escolhaInterna = Integer.parseInt(opcaoInterna);

                    if (escolhaInterna == 0){
                        System.out.println("Saindo...\n");
                        break;
                    }
                    else if(escolhaInterna == 1){
                        System.out.println("Deseja ver informações sobre o veículo 1 ou veículo 2?\n");

                        System.out.print("Digite o número da opção desejada: ");
                        String opcaoDeVeiculo = sc.nextLine();

                        if(!entradaNumerica(opcaoDeVeiculo)){
                            System.out.println("\nErro, entrada inválida!\n");
                            continue;
                        }

                        int escolhaDeVeiculo = Integer.parseInt(opcaoDeVeiculo);

                        switch (escolhaDeVeiculo) {
                            case 1:
                                veiculo1.ExibirDetalhes();
                                break;
                            case 2:
                                veiculo2.ExibirDetalhes();
                                break;
                            default:
                                System.out.println("Opcao inválida!");
                        }
                    }
                    else if (escolhaInterna == 2){
                        System.out.println("Deseja ver adicionar km ao veículo 1 ou ao veículo 2?\n");

                        System.out.print("Digite o número da opção desejada: ");
                        String opcaoDeVeiculo = sc.nextLine();

                        if(!entradaNumerica(opcaoDeVeiculo)){
                            System.out.println("\nErro, entrada inválida!\n");
                            continue;
                        }

                        int escolhaDeVeiculo = Integer.parseInt(opcaoDeVeiculo);

                        System.out.print("Digite quantos km deseja adicionar: ");
                        String km = sc.nextLine();

                        if(!entradaNumerica(km)){
                            System.out.println("\nErro, entrada inválida!\n");
                            continue;
                        }

                        double kmConvertido = Double.parseDouble(km);

                        switch (escolhaDeVeiculo) {
                            case 1:
                                veiculo1.RegistrarViagem(kmConvertido);
                                break;
                            case 2:
                                veiculo2.RegistrarViagem(kmConvertido);
                                break;
                            default:
                                System.out.println("Opcao inválida!");
                        }
                    }
                    else {
                        System.out.println("Opção inválida. Tente novamente.");
                    }
                }
            } else if (escolha == 7) {

                System.out.print("Digite seu nome: ");
                String nome = sc.nextLine();

                System.out.print("Digite o número da sua matrícula: ");
                String matricula = sc.nextLine();

                System.out.print("Digite suas 3 notas separadas por espaços: ");
                String notas = sc.nextLine();

                if (!Main.entradaDeTresNumeros(notas)){
                    System.out.println("Entrada de notas inválida!");
                    continue;
                }

                String[] nota = notas.split(" ");

                int[] notaConvertida = new int[nota.length];

                for (int i = 0; i < nota.length; i++)
                {
                    notaConvertida[i] = Integer.parseInt(nota[i]);
                }

                int n1 = notaConvertida[0];
                int n2 = notaConvertida[1];
                int n3 = notaConvertida[2];

                Aluno exercise07 = new Aluno(nome, matricula, n1, n2, n3);

                exercise07.VerificarAprovacao();

            } else if (escolha == 8) {

                Funcionario exercise08_f = new Funcionario("Thiago Freitas", 3000);
                Estagiario exercise08_e = new Estagiario("Lucas Santos", 3000);
                Gerente exercise08_g = new Gerente("Mateus Lazarus", 3000);


                System.out.println(exercise08_f.getNome() + " " + exercise08_f.getSalarioBase());
                System.out.println(exercise08_e.getNome() + " " + exercise08_e.getSalarioBase());
                System.out.println(exercise08_g.getNome() + " " + exercise08_g.getSalarioBase());


            } else if (escolha == 9) {

                while (true)
                {
                    System.out.println("\n----- Opções -----");
                    System.out.println("01 - Exibir Saldo");
                    System.out.println("02 - Depositar");
                    System.out.println("03 - Sacar");
                    System.out.println("00 - Sair\n");

                    System.out.print("Digite o número da opção desejada: ");
                    String opcaoInterna = sc.nextLine();

                    if(!entradaNumerica(opcaoInterna)){
                        System.out.println("\nErro, entrada inválida!\n");
                        continue;
                    }

                    int escolhaInterna = Integer.parseInt(opcaoInterna);

                    if (escolhaInterna == 0){
                        System.out.println("Saindo...\n");
                    }
                    else if(escolhaInterna == 1){
                        exercicio09.ExibirSaldo();
                    }
                    else if (escolhaInterna == 2){
                        System.out.print("Digite o valor que deseja depositar: R$ ");
                        String valor = sc.nextLine();

                        if(!Main.entradaNumerica(valor)){
                            System.out.println("\nErro, entrada inválida!\n");
                        }

                        double valorConvertido = Double.parseDouble(valor);
                        exercicio09.Depositar(valorConvertido);
                    }
                    else if (escolhaInterna == 3){
                        System.out.print("Digite o valor que deseja sacar: R$ ");
                        String valor = sc.nextLine();

                        if(!Main.entradaNumerica(valor)){
                            System.out.println("\nErro, entrada inválida!\n");
                        }

                        double valorConvertido = Double.parseDouble(valor);
                        exercicio09.Sacar(valorConvertido);
                    }
                    else {
                        System.out.println("Opção inválida. Tente novamente.");
                    }
                }

            } else if (escolha == 10) {
                Compra exercise10 = new Compra();

                while (true) {
                    System.out.println("\n----- Opções -----");
                    System.out.println("01 - Cadastrar Compras");
                    System.out.println("02 - Ler Lista de Compras");
                    System.out.println("00 - Sair\n");

                    System.out.print("Digite o número da opção desejada: ");
                    String opcaoInterna = sc.nextLine();

                    if (!Main.entradaNumerica(opcaoInterna)) {
                        System.out.println("\nErro, entrada inválida!\n");
                        continue;
                    }

                    int escolhaInterna = Integer.parseInt(opcaoInterna);

                    if (escolhaInterna == 0) {
                        System.out.println("Saindo...\n");
                        break;
                    }
                    else if (escolhaInterna == 1){
                        exercise10.SolicitarESalvarCompra();
                    }
                    else if (escolhaInterna == 2){
                        exercise10.LerArquivo();
                    }
                    else {
                        System.out.println("Opção inválida. Tente novamente.");
                    }
                }
            } else if (escolha == 11) {

                Exercise11 exercise11 = new Exercise11();
                exercise11.Loteria();

            } else if (escolha == 12) {

                Exercise12 exercise12 = new Exercise12();
                exercise12.Chat();
            } else {
                System.out.println("Opção inválida. Tente novamente.");
            }
        }
        sc.close();

    }

    public void OlaMundo(){
        System.out.println("Olá, meu nome é Paulo Dias \ne estou aprendendo Java!");
    }

    // Regex para validar apenas números positivos (inteiros ou decimais)
    public static boolean entradaNumerica(String input) {
        String regex = "^\\d+(\\.\\d+)?$";

        return Pattern.matches(regex, input);
    }

    //Regex para validar apenas 3 números inteiros entre 0 e 10 na mesma string
    public static boolean entradaDeTresNumeros(String input){
        String regex = "^(?:[0-9]|10)\\s(?:[0-9]|10)\\s(?:[0-9]|10)$";

        return Pattern.matches(regex, input);
    }
}
