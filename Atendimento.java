public class Atendimento {
    private String codigo;
    private String nomeAnimal;
    private String especie;
    private String nomeTutor;
    private String data;
    private String horario;
    private String status; 
    private String observacoes;
    private Procedimento procedimento;

    public Atendimento(String codigo, String nomeAnimal, String especie, String nomeTutor, String data, String horario, String observacoes, Procedimento procedimento) {
        this.codigo = codigo;
        this.nomeAnimal = nomeAnimal;
        this.especie = especie;
        this.nomeTutor = nomeTutor;
        this.data = data;
        this.horario = horario;
        this.status = "agendado"; 
        this.observacoes = observacoes;
        this.procedimento = procedimento;
    }

    public String getCodigo() { return codigo; }
    public String getNomeAnimal() { return nomeAnimal; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public Procedimento getProcedimento() { return procedimento; }

}
