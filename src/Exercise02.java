import java.util.regex.Pattern;
import java.util.Scanner;

public class Exercise02 {
    public void Senha() {
        Scanner sc = new Scanner(System.in);

        int count = 3;
        while (count != 0) {

            System.out.println("Digite uma senha alpha numérica.\n" +
                    "(Sua senha deve conter 8 caracteres;\n" +
                    "Conter ao menos uma letra maiúscula;\n" +
                    "Conter ao menos um número; e\n" +
                    "Conter um caracter especial (#@$...)).\n");

            String password = sc.nextLine();

            if (!validadosDeSenha(password)) {
                System.out.println("Formaoto de senha inválida!\n");
                count -= 1;

                if (count == 0){
                    System.out.println("Limite de tentativas excedido!");
                    break;
                }
                continue;
            }

            System.out.println("Senha salva com sucesso!\n");
            break;

        }
    }

    // Regex para validar a senha
    public static boolean validadosDeSenha(String password) {
        String regex = "^(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%^&+=!])(?=\\S+$).{8,}$";
        return Pattern.matches(regex, password);
    }
}
