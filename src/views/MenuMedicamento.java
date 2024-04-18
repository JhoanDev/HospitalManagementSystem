package src.views;

import java.sql.SQLException;
import java.util.ArrayList;

import src.controllers.MedicamentoDao;
import src.data.Banco;
import src.models.Medicamento;
import src.utils.FuncUtils;

public class MenuMedicamento {
    public static void medicamentMenu(Banco db) throws SQLException {
        int opcao = 0;
        String nome;
        Medicamento medicamento;
        ArrayList<Medicamento> medicamentos;
        while (opcao != 6) {
            exibirMenu();
            opcao = FuncUtils.readInt();
            FuncUtils.clearScreen();
            switch (opcao) {
                case 1:
                    System.out.print("Digite o nome do medicamento: ");
                    nome = FuncUtils.readOnlyLettersAndSpaces();
                    MedicamentoDao.cadastrarMedicamento(new Medicamento(nome), db);
                    break;
                case 2:
                    System.out.print("Digite o nome do medicamento que deseja buscar: ");
                    nome = FuncUtils.readOnlyLettersAndSpaces();
                    medicamento = MedicamentoDao.buscaMedicamento(nome, db);
                    if (medicamento != null) {
                        System.out.println(medicamento);
                    } else {
                        System.out.println("Medicamento não encontrado.");
                    }
                    break;
                case 3:
                    System.out.print("Digite o nome do medicamento que deseja editar: ");
                    nome = FuncUtils.readOnlyLettersAndSpaces();
                    medicamento = MedicamentoDao.buscaMedicamento(nome, db);
                    if (medicamento != null) {
                        System.out.print("Digite o novo nome do medicamento: ");
                        nome = FuncUtils.readOnlyLettersAndSpaces();
                        medicamento.setNome(nome);
                        MedicamentoDao.editaMedicamento(medicamento, db);
                    } else {
                        System.out.println("Medicamento não encontrado.");
                    }
                    break;
                case 4:
                    System.out.print("Digite o nome do medicamento que deseja excluir: ");
                    nome = FuncUtils.readOnlyLettersAndSpaces();
                    medicamento = MedicamentoDao.buscaMedicamento(nome, db);
                    if (medicamento != null) {
                        MedicamentoDao.excluirMedicamento(medicamento, db);
                    } else {
                        System.out.println("Medicamento não encontrado.");
                    }
                    break;
                case 5:
                    medicamentos = MedicamentoDao.listarMedicamentos(db);
                    if (medicamentos.isEmpty()) {
                        System.out.println("Nenhum medicamento cadastrado.");
                        break;
                    }
                    System.out.printf("|Cod%s|Nome\n", FuncUtils.spacesGenerator(4));
                    for (Medicamento m : medicamentos) {
                        System.out.printf("|%-7s|%-30s\n", m.getCodMedicamento(), m.getNome());
                    }
                    System.out.println();
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
        System.out.println("[1] - Cadastrar medicamento");
        System.out.println("[2] - Buscar medicamento");
        System.out.println("[3] - Editar medicamento");
        System.out.println("[4] - Excluir medicamento");
        System.out.println("[5] - Listar medicamentos");
        System.out.println("[6] - Sair");
        System.out.print("Digite sua opção: ");
    }
}