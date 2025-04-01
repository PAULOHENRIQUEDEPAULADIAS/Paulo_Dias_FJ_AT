public class Estagiario extends  Funcionario{

    public Estagiario(String nome, double salarioBase)
    {
        super(nome, salarioBase * .90);
    }
}
