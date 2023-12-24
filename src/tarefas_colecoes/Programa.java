package tarefas_colecoes;

import java.util.*;

public class Programa {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, String> pessoas = new HashMap<>();

        System.out.print("Quantas pessoas deseja cadastrar? ");
        int quantidade = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Cadastre as pessoas:");
        cadastrarPessoas(quantidade, pessoas, scanner);

        ordenarEImprimirNomes(pessoas);
        mostrarPessoasPorSexo(pessoas, "M", "Masculino");
        mostrarPessoasPorSexo(pessoas, "F", "Feminino");
    }

    public static void cadastrarPessoas(int quantidade, Map<String, String> pessoas, Scanner scanner) {
        for (int i = 0; i < quantidade; i++) {
            System.out.println("Pessoa " + (i + 1) + ":");
            System.out.print("Nome: ");
            String nome = scanner.nextLine();
            System.out.print("Sexo (M/F): ");
            String sexo = scanner.nextLine().toUpperCase();

            pessoas.put(nome, sexo);
        }
    }

    public static void ordenarEImprimirNomes(Map<String, String> pessoas) {
        List<String> nomesOrdenados = new ArrayList<>(pessoas.keySet());
        Collections.sort(nomesOrdenados);

        System.out.print("Nomes ordenados: ");
        for (int i = 0; i < nomesOrdenados.size(); i++) {
            System.out.print(nomesOrdenados.get(i));
            if (i < nomesOrdenados.size() - 1) {
                System.out.print(", ");
            }
        }
        System.out.println();
    }

    public static void mostrarPessoasPorSexo(Map<String, String> pessoas, String sexoProcurado, String descricaoSexo) {
        List<String> pessoasSexo = new ArrayList<>();
        pessoas.forEach((nome, sexo) -> {
            if (sexo.equals(sexoProcurado)) {
                pessoasSexo.add(nome);
            }
        });

        System.out.println("=== Pessoas do sexo " + descricaoSexo + " ===");
        System.out.println(String.join(", ", pessoasSexo));
    }
}