import java.util.Scanner;

public class Exercise12 {
    private Scanner sc = new Scanner(System.in);

    public void Chat(){

        System.out.print("Digite o nome do primeiro usuário: ");
        String nome1 = sc.nextLine();

        System.out.print("Digite o nome do segundo usuário: ");
        String nome2 = sc.nextLine();

        String[] chat = new String[10];

        for (int i = 0; i < chat.length; i++){
            String nomeAtual = (i % 2 == 0) ? nome1 : nome2;
            System.out.print(nomeAtual + " digite sua mensagem: ");
            String captura = sc.nextLine();
            chat[i] = nomeAtual + " : " + captura;
        }

        System.out.println("===== Histórico de Mensagens =====\n");
        for (String linha : chat){
            System.out.println(linha);
        }
        System.out.println("\nObrigado por utilizarem o sistema! Boa sorte para vocês!");
    }
}
