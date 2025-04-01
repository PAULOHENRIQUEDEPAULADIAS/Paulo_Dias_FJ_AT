import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.Scanner;

public class Compra {
    private String produto;
    private int quantidade;
    private double precoUnitario;

    private static final Path ARQUIVO = Path.of("compras.txt");
    private Scanner sc = new Scanner(System.in);

    //Construtor vazio
    public Compra() {
    }

    public void SolicitarESalvarCompra(){
        try {
            if (!Files.exists(ARQUIVO)) {
                Files.createFile(ARQUIVO);
                System.out.println("Arquivo 'compras.txt' criado com sucesso!");
            }
        } catch (IOException e) {
            System.out.println("Erro ao criar o arquivo: " + e.getMessage());
        }

        System.out.print("Digite o nome do produto: ");
        this.produto = sc.nextLine();
        while (true) {
            System.out.print("Digite a quantidade adquirida: ");
            String quantidade = sc.nextLine();
            try{
                this.quantidade = Integer.parseInt(quantidade);
                if (this.quantidade < 0) throw new NumberFormatException();
                break;
            }
            catch (NumberFormatException ex){
                System.out.println("Por favor, digite uma quantidade acima de 0.");
            }
        }

        while (true) {
            System.out.print("Digite o preço unitário: R$ ");
            String precoUnitario = sc.nextLine();
            try {
                this.precoUnitario = Double.parseDouble(precoUnitario);
                if (this.precoUnitario <= 0) throw new NumberFormatException();
                break;
            } catch (NumberFormatException ex) {
                System.out.println("Por favor, digite um valor numérico válido maior que 0.");
            }
        }

        String dadosCompra = produto + "," + quantidade + "," + precoUnitario + "\n";

        try {
            Files.writeString(ARQUIVO, dadosCompra, StandardOpenOption.CREATE, StandardOpenOption.APPEND);
            System.out.println("Compra salva com sucesso!");
        } catch (IOException e) {
            System.out.println("Erro ao salvar a compra: " + e.getMessage());
        }
    }

    public void LerArquivo() throws IOException {

        if (!Files.exists(ARQUIVO)) {
            System.out.println("Arquivo 'compras.txt' inexistente!");
            return;
        }

        List<String> linhas = Files.readAllLines(ARQUIVO, StandardCharsets.UTF_8);

        if (linhas.isEmpty()) {
            System.out.println("O arquivo 'compras.txt' está vazio. Nenhuma compra registrada.");
            return;
        }

        linhas.forEach(System.out::println);
    }
}