import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static ArrayList<Veterinario> vetiList = new ArrayList<>();
    private static ArrayList<Sala> salaList = new ArrayList<>();
    private static ArrayList<Atendimento> atenList = new ArrayList<>();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        Veterinario v1 = new Veterinario("Dr. Silva", "098656778493", "Cirurgia", "3386764324");
        Veterinario v2 = new Veterinario("Dra. Santos", "09876767678493", "Dermatologia", "34132764324");
        Veterinario v3 = new Veterinario("Dr. Oliveira", "09444778493", "Comportamento", "2789764324");
        vetiList.add(v1); vetiList.add(v2); vetiList.add(v3);
        
        Sala s1 = new Sala(201, "bloco A", 10, "Centro cirurgico");
        Sala s2 = new Sala(202, "bloco A", 16, "Centro cirurgico");
        Sala s3 = new Sala(301, "bloco B", 24, "Analise comportamental");
        salaList.add(s1); salaList.add(s2); salaList.add(s3);

        v1.atribuirSala(s1); s1.setVeterinarioResponsavel(v1);
        v2.atribuirSala(s2); s2.setVeterinarioResponsavel(v2);
        v3.atribuirSala(s3); s3.setVeterinarioResponsavel(v3);

        int op;
        do {
            System.out.print("\n1.Cadastrar\n2.Mudar Status/Sala\n3.Ver Sala\n4.Finalizados\n5.Buscar Status\n0.Sair\nOpcao: ");
            op = Integer.parseInt(sc.nextLine());

            switch(op) {
                case 1 -> { 
                    System.out.print("Cod, Animal, Proc: ");
                    String[] dados = sc.nextLine().split(",");
                    Procedimento p = new Procedimento(dados[2].trim(), "30m", 150.0, "Media");
                    atenList.add(new Atendimento(dados[0].trim(), dados[1].trim(), "Cao", "Tutor", "01/01", "10h", "Nenhuma", p));
                }
                case 2 -> { 
                    System.out.print("Cod Atendimento, Status (1-Andamento, 2-Finalizado): ");
                    String[] dados = sc.nextLine().split(",");
                    Atendimento a = null;
                    for (Atendimento at : atenList) if (at.getCodigo().equals(dados[0].trim())) a = at;
                    
                    if (a != null) {
                        if (dados[1].trim().equals("1")) {
                            System.out.print("Num Sala: "); int n = Integer.parseInt(sc.nextLine());
                            for (Sala s : salaList) if (s.getNumero() == n && s.adicionarAtendimento(a)) a.setStatus("em andamento");
                        } else {
                            for (Sala s : salaList) if (s.getAtendimentos().contains(a)) { s.finalizarAtendimento(a); a.setStatus("finalizado"); }
                        }
                    }
                }
                case 3 -> { 
                    System.out.print("Num Sala: "); int n = Integer.parseInt(sc.nextLine());
                    for (Sala s : salaList) if (s.getNumero() == n) s.mostrAtendimento();
                }
                case 4 -> { // 5. Informar finalizados por cada sala
                    for (Sala s : salaList) s.atendimentosFinalizados();
                }
                case 5 -> { 
                    System.out.print("Status: "); String st = sc.nextLine();
                    for (Atendimento at : atenList) if (at.getStatus().equalsIgnoreCase(st)) System.out.print(at);
                }
            }
        } while (op != 0);
    }
}
