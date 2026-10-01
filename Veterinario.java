public class Veterinario {
    private String nome; 
    private String cpf;
    private String especialidade;
    private String telefone;
    private Sala sala;

    public Veterinario(String nome, String cpf, String specialty, String telefone) {
        this.nome = nome;
        this.cpf = cpf;
        this.especialidade = specialty;
        this.telefone = telefone;
    }

    public void atribuirSala(Sala sala) {
        this.sala = sala;
    }

    public String getNome() { return this.nome; }
    public String getCpf() { return this.cpf; }
    public String getTelefone() { return this.telefone; }
    public String getEspecialidade() { return this.especialidade; }
    public Sala getSala() { return this.sala; }
}
