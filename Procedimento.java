public class Procedimento {
    private String nome;
    private String duracao;
    private double valor;
    private String nivelComplexidade;

    public Procedimento(String nome, String duracao, double valor, String nivelComplexidade) {
        this.nome = nome;
        this.duracao = duracao;
        this.valor = valor;
        this.nivelComplexidade = nivelComplexidade;
    }

    public String getNome() { return nome; }
}
