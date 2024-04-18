package src.views;

import java.sql.Date;
import java.sql.Time;

import src.controllers.AdministradorDao;
import src.data.Banco;
import src.models.Administrador;
import src.utils.FuncUtils;

public class MenuAdministrador {
    public static void adminMenu(Banco db) {
        int opcao = 0, opcao2 = 0;
        String nome, cpf, telefone, login,senha;
        Date dataNasc, dataDeAdmissao;
        Time horarioDeTrabalhoInicio, horarioDeTrabalhoFinal;
        boolean sexo;
        double salario;
        Administrador administrador;
        try {
            while (opcao != 6) {
                exibirMenu();
                opcao = FuncUtils.readInt();
                switch (opcao) {
                    case 1:
                        System.out.print("Digite o login: ");
                        login = FuncUtils.readOnlyLettersAndSpaces();

                        System.out.print("Digite a senha: ");
                        senha = FuncUtils.readPassword();

                        System.out.print("Digite o nome: ");
                        nome = FuncUtils.readOnlyLettersAndSpaces();

                        cpf = FuncUtils.readCPF();
                        telefone = FuncUtils.readPhoneNumber();

                        System.out.print("Insira a data de nascimento, ");
                        dataNasc = FuncUtils.readDate();

                        sexo = FuncUtils.readSex();
                        salario = FuncUtils.readSalary();

                        System.out.print("Insira a data de admissão, ");
                        dataDeAdmissao = FuncUtils.readDate();

                        System.out.print("insira o inicio do expediente, ");
                        horarioDeTrabalhoInicio = FuncUtils.readTime();

                        System.out.print("insira o final do expediente, ");
                        horarioDeTrabalhoFinal = FuncUtils.readTime();

                        AdministradorDao.cadastrarAdministrador(new Administrador(nome, cpf, telefone, dataNasc, sexo, salario, dataDeAdmissao,
                                horarioDeTrabalhoInicio, horarioDeTrabalhoFinal,login,senha), db);
                        break;
                    case 2:
                        // Editar administrador
                        // Implementação da edição aqui
                        break;
                    case 3:
                        // Excluir administrador
                        // Implementação da exclusão aqui
                        break;
                    case 4:
                        // Listar administradores
                        break;
                    case 5:
                        // Buscar administrador
                        // Implementação da busca aqui
                        break;
                    case 6:
                        System.out.println("Saindo...");
                        return;
                    default:
                        System.out.println("Opção inválida.");
                        break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void exibirMenu() {
        FuncUtils.clearScreen();
        System.out.println("[1] - Cadastrar administrador");
        System.out.println("[2] - Editar administrador");
        System.out.println("[3] - Excluir administrador");
        System.out.println("[4] - Listar administradores");
        System.out.println("[5] - Buscar administrador");
        System.out.println("[6] - Sair");
        System.out.print("Digite sua opcao: ");
    }
}