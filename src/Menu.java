import java.sql.SQLOutput;
import java.util.Scanner;

public class Menu {
    Scanner leitura = new Scanner(System.in);
    GerenciaFuncionario gerenciaFuncionario = new GerenciaFuncionario();

    public void mostrarMenu() {
        int op;
        do {
            System.out.println("""
                    1- Inserir Funcionário
                    2- Listar Funcionários
                    3- Excluir Funcionários
                    4- Sair""");
            op = leitura.nextInt();
            switch (op) {
                case 1:
                    gerenciaFuncionario.adicionarFuncionario();
                    int decision;
                    do{
                        System.out.println("""
                                Adicionar mais um funcionario?
                                1- Sim 2- Não
                                """);
                         decision = leitura.nextInt();
                        if (decision == 1) {
                            gerenciaFuncionario.adicionarFuncionario();
                        } else if (decision == 2) {

                        } else {
                            System.out.println("Opção inválida. Digite 1 para Sim ou 2 para Não.");
                        }
                    }
                    while (decision == 1);
                    break;
                case 2:
                    gerenciaFuncionario.listarFuncionarios();
                    break;
                case 3:
                    System.out.println("Digite o cpf do funcionário");
                    leitura.nextLine();
                    String cpf = leitura.nextLine();
                    gerenciaFuncionario.excluirFuncionario(cpf);
                    mostrarMenu();
                    break;
                case   4:
                    break;
                default:
                    System.out.println("Digite uma opção válida!");
            }

        }
        while (op != 3);

    }
}
