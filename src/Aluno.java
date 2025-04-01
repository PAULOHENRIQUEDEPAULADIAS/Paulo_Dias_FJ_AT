public class Aluno {
    private String nome;
    private String matricula;
    private double nota1;
    private double nota2;
    private double nota3;

    public Aluno(String nome, String matricula, double nota1, double nota2, double nota3) {
        this.nome = nome;
        this.matricula = matricula;
        this.nota1 = nota1;
        this.nota2 = nota2;
        this.nota3 = nota3;
    }

    public double CalcularMedia(){
        return (this.nota1 + this.nota2 + this.nota3) / 3;
    }

    public void VerificarAprovacao(){

        String status = CalcularMedia() >= 7 ? "Estudante Aprovado" : "Estudante Reprovado";

        System.out.println("\nNome: " + this.nome);
        System.out.println("Matricula: " + this.matricula);
        System.out.println("Média: " + CalcularMedia());
        System.out.println("Status: " + status );
    }
}
