package src.views;

import src.data.Banco;
import src.utils.FuncUtils;

public class MenuInicial {
    public static void initialMenu(Banco db) {
        FuncUtils.clearScreen();
        System.out.println("[1] - Menu Administrador");
        System.out.println("[2] - Menu Paciente");
        System.out.println("[3] - Menu Médico");
        System.out.println("[4] - Menu Enfermeiro");
        System.out.println("[5] - Menu Medicamentos");
        System.out.println("[6] - Menu Consulta");
        System.out.println("[7] - Menu Enfermaria");
        System.out.println("[8] - Menu Internação");
        System.out.println("[9] - Logout");
        System.out.print("Digite sua opção: ");
        int opcao = 0;
        try {
            opcao = FuncUtils.readInt();
            switch (opcao) {
                case 1:
                    MenuAdministrador.adminMenu(db);
                    initialMenu(db);
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    MenuEnfermeiro.nurseMenu(db);
                    initialMenu(db);
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
                    break;
                case 8:
                    break;
                case 9:
                    System.out.println("Saindo...");
                    return;
                default:
                    System.out.println("Opção inválida. Por favor, digite uma opção válida.");
                    break;
            }
        } catch (NumberFormatException e) {
            System.out.println("Opção inválida. Por favor, digite um número.");
        }
    }
}
