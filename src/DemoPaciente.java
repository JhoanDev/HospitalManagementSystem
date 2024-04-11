package src;

//Não mudei muita coisa aqui, só o básico para nao apresentar erro!

import java.sql.SQLException;

import src.models.*;
import src.utils.FuncUtils;
import src.controllers.*;

public class DemoPaciente {

    public static void main(String[] args) throws SQLException {
        FuncUtils.clearScreen();
        System.out.println("Sistema de Gerenciamento de Hospital");
        Paciente paciente= new Paciente(); //so para parar erros
        int opcao = 0;
        while (opcao != 8) {
            exibirMenu();
            opcao = FuncUtils.readInt();

            switch (opcao) {
                case 1:
                    PacienteDao.cadastrarPaciente(paciente);
                    break;
                case 2:
                    PacienteDao.editarPaciente("182");
                    break;
                case 3:
                    PacienteDao.excluirPaciente("13821");
                    break;
                case 4:
                    String codPaciente = FuncUtils.readCod();
                    Paciente aux = PacienteDao.buscaPaciente(codPaciente);
                    if (aux != null) {
                        System.out.println(aux);
                    }
                    break;
                case 5:
                    PacienteDao.listarPacientes();
                    break;
                case 6:
                    PacienteDao.alta("12312");
                    break;
                case 7:
                    PacienteDao.internar("12312");
                    break;
                case 8:
                    System.out.println("Saindo do programa...");
                    return;
                default:
                    System.out.println("Opção inválida. Por favor, escolha uma opção válida.");
            }
        }
        FuncUtils.fechaScanner();
    }

    public static void exibirMenu() {
        System.out.println("\nMenu:");
        System.out.println("1. Cadastrar Paciente");
        System.out.println("2. Editar Paciente");
        System.out.println("3. Excluir Paciente");
        System.out.println("4. Buscar Paciente");
        System.out.println("5. Listar Pacientes");
        System.out.println("6. Dar Alta");
        System.out.println("7. Internar Paciente");
        System.out.println("8. Sair do programa");
    }
    
}
