import java.util.ArrayList;

public class Sala {
    private int numero;
    private String bloco;
    private int capacidadeMax;
    private String tipoSala;
    private Veterinario veterinarioResponsavel;
    private ArrayList<Atendimento> atendimentos = new ArrayList<>(); 
    private int contadorFinalizados = 0; 

    public Sala(int numero, String bloco, int capacidadeMax, String tipoSala) {
        this.numero = numero;
        this.bloco = bloco;
        this.capacidadeMax = capacidadeMax;
        this.tipoSala = tipoSala;
    }

    public boolean adicionarAtendimento(Atendimento atendimento) {
        if (!atendimentos.isEmpty()) {
            String procExistente = atendimentos.get(0).getProcedimento().getNome();
            if (!procExistente.equalsIgnoreCase(atendimento.getProcedimento().getNome())) {
                System.out.println("Erro: Esta sala ja contem o procedimento " + procExistente);
                return false;
            }
        }
        atendimentos.add(atendimento);
        return true;
    }

    public void finalizarAtendimento(Atendimento atendimento) {
        if (atendimentos.remove(atendimento)) {
            contadorFinalizados++;
        }
    }

    public void mostrAtendimento() {
        int cont = 0;
        for (Atendimento atendimento : atendimentos) {
            System.out.print(atendimento);
            cont++;
        }
        System.out.println("Total de atendimentos na sala: " + cont);
    }

    public void atendimentosFinalizados() {
        System.out.println("Sala " + numero + " teve " + contadorFinalizados + " atendimentos finalizados.");
    }

    public int getNumero() { return numero; }
    public Veterinario getVeterinarioResponsavel() { return veterinarioResponsavel; }
    public void setVeterinarioResponsavel(Veterinario v) { this.veterinarioResponsavel = v; }
    public ArrayList<Atendimento> getAtendimentos() { return atendimentos; }
}
