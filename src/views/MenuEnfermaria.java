package src.views;

import java.sql.SQLException;

import src.controllers.EnfermariaDao;
import src.data.Banco;
import src.models.Enfermaria;
import src.utils.FuncUtils;

public class MenuEnfermaria {
    public static void wardMenu(Banco db) throws SQLException {
        int option = 0, leitos = 0, leitosDisponiveis = 0;
        String codEnfermaria;
        Enfermaria enfermaria;
        while (option != 6) {
            displayMenu();
            option = FuncUtils.readInt();
            switch (option) {
                case 1:
                    System.out.print("Insira a quantidade de leitos da enfermaria: ");
                    leitos = FuncUtils.readInt();
                    EnfermariaDao.cadastrarEnfermaria(new Enfermaria(leitos), db);
                    break;
                case 2:
                    System.out.print("Insira o codigo da enfermaria que deseja buscar: ");
                    String cod = FuncUtils.readCod();
                    enfermaria = EnfermariaDao.buscaEnfermaria(cod, db);
                    if (enfermaria != null) {
                        System.out.println(enfermaria);
                    }
                    break;
                case 3:
                    System.out.print("Insira o codigo da enfermaria que deseja editar: ");
                    codEnfermaria = FuncUtils.readCod();
                    enfermaria = EnfermariaDao.buscaEnfermaria(codEnfermaria, db);
                    if (enfermaria != null) {
                        System.out.print("Insira a nova quantidade de leitos da enfermaria: ");
                        leitos = FuncUtils.readInt();
                        leitosDisponiveis = (enfermaria.getLeitosDisponiveis() - enfermaria.getQtdeLeitos()) + leitos;
                        enfermaria.setQtdeLeitos(leitos);
                        enfermaria.setLeitosDisponiveis(leitosDisponiveis);
                        EnfermariaDao.editaEnfermaria(enfermaria, db);
                    }
                    break;
                case 4:
                    System.out.print("Insira o codigo da enfermaria que deseja excluir: ");
                    codEnfermaria = FuncUtils.readCod();
                    enfermaria = EnfermariaDao.buscaEnfermaria(codEnfermaria, db);
                    if (enfermaria != null) {
                        EnfermariaDao.excluirEnfermaria(enfermaria, db);
                    }
                    break;
                case 5:
                    System.out.println("Listar enfermarias");
                    break;
                case 6:
                    System.out.println("Saindo...");
                    return;
                default:
                    System.out.println("Opção inválida.");
                    break;
            }
        }
    }

    public static void displayMenu() {
        System.out.println("[1] - Cadastrar enfermaria");
        System.out.println("[2] - Buscar enfermaria");
        System.out.println("[3] - Editar enfermaria");
        System.out.println("[4] - Excluir enfermaria");
        System.out.println("[5] - Listar enfermarias");
        System.out.println("[6] - Sair");
        System.out.print("Digite sua opção: ");
    }
}
