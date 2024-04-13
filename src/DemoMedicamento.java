package src;

import java.sql.SQLException;

import src.controllers.MedicamentoDao;
import src.models.Medicamento;
import src.utils.FuncUtils;

public class DemoMedicamento {
    public static void main(String[] args) throws SQLException {
        MedicamentoDao medicamentoDao = new MedicamentoDao();
        int opcao = 0;
        String nome;
        Medicamento medicamento;
        while (opcao != 6) {
            exibirMenu();
            opcao = FuncUtils.readInt();
            switch (opcao) {
                case 1:
                    System.out.print("Digite o nome do medicamento: ");
                    nome = FuncUtils.readOnlyLettersAndSpaces();
                    medicamentoDao.cadastrarMedicamento(new Medicamento(nome));
                    break;
                case 2:
                    System.out.print("Digite o nome do medicamento que deseja buscar: ");
                    nome = FuncUtils.readOnlyLettersAndSpaces();
                    medicamento = medicamentoDao.buscaMedicamento(nome);
                    if (medicamento != null) {
                        System.out.println(medicamento);
                    }
                    break;
                case 3:
                    System.out.print("Digite o nome do medicamento que deseja editar: ");
                    nome = FuncUtils.readOnlyLettersAndSpaces();
                    medicamento = medicamentoDao.buscaMedicamento(nome);
                    if (medicamento != null) {
                        System.out.print("Digite o novo nome do medicamento: ");
                        nome = FuncUtils.readOnlyLettersAndSpaces();
                        medicamento.setNome(nome);
                        medicamentoDao.editaMedicamento(medicamento);
                    }
                    break;
                case 4:

                    break;
                case 5:

                    break;
                case 6:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida.");
                    break;
            }
        }
    }

    public static void exibirMenu() {
        System.out.println("Escolha uma opção:");
        System.out.println("[1] - Cadastrar medicamento");
        System.out.println("[2] - Buscar medicamento");
        System.out.println("[3] - Editar medicamento");
        System.out.println("[4] - Excluir medicamento");
        System.out.println("[5] - Listar medicamentos");
        System.out.println("[6] - Sair");
    }
}
