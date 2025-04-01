public class Veiculos {
    private String placa;
    private String modelo;
    private int anoDeFabricacao;
    private double quilometragem;

    public Veiculos(String placa, String modelo, int anoDeFabricacao, double quilometragem){
        this.placa = placa;
        this.modelo = modelo;
        this.anoDeFabricacao = anoDeFabricacao;
        this.quilometragem = quilometragem;
    }


    public double getQuilometragem() {
        return quilometragem;
    }

    public void ExibirDetalhes(){
        System.out.println("----- Dados do Veículo -----");
        System.out.println("Placa: " + this.placa);
        System.out.println("Modelo: " + this.modelo);
        System.out.println("Ano de Fabricação: " + this.anoDeFabricacao);
        System.out.println("Quilometragem: " + this.quilometragem + "\n");
    }


    /* Levando em consideração um cenário real, essa lógica estaria divergente,
     pois uma locadora de veículos iria conferir o painel e pegar a nova quilometragem ao invés de
     adicionar + km ao sistema. Uma melhor forma seria somente settar a quilmetragem para um novo valor
     desde que esse valor fosse maior que o valor anterior.*/
    public void RegistrarViagem(double km){
        System.out.println("Quilometragem atual: " + this.quilometragem + "\n");
        this.quilometragem += km;
        System.out.println("Quilometragem atualizada para: " + this.quilometragem + "\n");
    }


}
