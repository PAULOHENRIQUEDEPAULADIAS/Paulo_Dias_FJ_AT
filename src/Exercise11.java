import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.regex.Pattern;

public class Exercise11 {

    private Scanner sc = new Scanner(System.in);

    public void Loteria(){

        int[] numerosDaSorte = new int[6];
        for (int i = 0; i < numerosDaSorte.length; i++){
            numerosDaSorte[i] = (int) (Math.random() * 60) + 1;
        }

        while(true){

            System.out.print("Digite 6 números entre 1 e 60 com um espaço entre cada (Formato X X X X X X): ");
            String palpite = sc.nextLine();

            if (!ValidaSeisNumerosInseridos(palpite)){
                System.out.println("Erro: valor inserido inválido");
                continue;
            }

            String[] arrayDePalpite = palpite.split(" ");
            int[] palpiteConvertidos = new int[palpite.length()];

            for(int i = 0; i < arrayDePalpite.length; i++){
                palpiteConvertidos[i] = Integer.parseInt(arrayDePalpite[i]);
            }

            Set<Integer> acertos = new HashSet<>();

            for (int numero : palpiteConvertidos) {
                if (Arrays.stream(numerosDaSorte).anyMatch(sorteio -> sorteio == numero)) {
                    acertos.add(numero);
                }
            }

            if (acertos.isEmpty()) {
                System.out.println("Nenhum número acertado.");
            } else {
                System.out.println("Você acertou os números: " + acertos);
            }
            break;
        }
    }

    public boolean ValidaSeisNumerosInseridos(String valor){
        String patter = "^(?:([1-9]|[1-5]\\d|60)\\s){5}([1-9]|[1-5]\\d|60)$";
        return Pattern.matches(patter, valor);
    }
}
