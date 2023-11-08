import javax.swing.plaf.synth.SynthTextAreaUI;
import java.net.SecureCacheResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GerenciaFuncionario {
    Scanner leitura = new Scanner(System.in);
    List<Funcionario> listaDeFuncionarios = new ArrayList<>();

    public void adicionarFuncionario() {

        System.out.println("Digite o nome do funcionario!");
        String nome = leitura.nextLine();
        System.out.println("Digite o cpf do funcionário: ");
        String cpf = leitura.nextLine();
        boolean cpfJaExiste = false;
        for (Funcionario funcionario : listaDeFuncionarios) {
            if (funcionario.getCpf().equals(cpf)) {
                cpfJaExiste = true;
                break;
            }
        }
        if (cpfJaExiste) {
            System.out.println("CPF já cadastrado. Não é possível adicionar o mesmo CPF novamente.");
        } else {
            Funcionario novoFuncionario = new Funcionario(nome, cpf);
            listaDeFuncionarios.add(novoFuncionario);
            System.out.println("Funcionário adicionado com sucesso.");
        }
    }

    public void listarFuncionarios() {
        for (var funcionario : listaDeFuncionarios) {
            System.out.println("***** " + (listaDeFuncionarios.indexOf(funcionario) + 1) + " *****");
            System.out.println("Nome: " + funcionario.getNome());
            System.out.println("Cpf: " + funcionario.getCpf());
            System.out.println("");
        }
    }

    public void excluirFuncionario(String cpf) {
        boolean achou = false;

        for (var funcionario : listaDeFuncionarios) {
            if (cpf.equals(funcionario.getCpf())) {
                listaDeFuncionarios.remove(funcionario);
                achou = true;
                System.out.println("Excluído com sucesso!");
                break;
            }
        }
        if (!achou) {
            System.out.println("Funcionário não encontrado!");
        }
    }
}
