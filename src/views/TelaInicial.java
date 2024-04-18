package src.views;

import java.sql.SQLException;
import src.data.Banco;
import src.utils.FuncUtils;

public class TelaInicial {
    public static void homeScreen(Banco db) throws SQLException{
        FuncUtils.clearScreen();
        while (true) {
            System.out.println("\n[1] - Logar");
            System.out.println("[2] - Sair");
            System.out.print("Digite sua opcao: ");
            int opcao = 0;
            try {
                opcao = FuncUtils.readInt();
                if (opcao == 1) {
                    TelaLogin.loginScreen(db);
                    break;
                } else if (opcao == 2) {
                    System.out.println("Saindo...");
                    return;
                } else {
                    System.out.println("Opção inválida. Por favor, digite uma opção válida.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Opção inválida. Por favor, digite um número.");
            }
        }
    }
}
