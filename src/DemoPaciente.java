package src;

//Não mudei muita coisa aqui, só o básico para nao apresentar erro!

import java.sql.SQLException;
import java.sql.Date;
import javax.sound.midi.Soundbank;

import src.controllers.PacienteDao;
import src.models.*;
import src.utils.FuncUtils;

public class DemoPaciente {

    public static void main(String[] args) throws SQLException {
        FuncUtils.clearScreen();
        System.out.println("Sistema de Gerenciamento de Hospital");

        int opcao = 0;
        while (opcao != 8) {
            exibirMenu();
            opcao = FuncUtils.readInt();
            switch (opcao) {
                case 1:
                    Paciente paciente = new Paciente();
                    
                    System.out.println("Digite o nome do paciente: ");
                    String nome = FuncUtils.readOnlyLettersAndSpaces();
                    paciente.setNome(nome);

                    System.out.println("Digite o CPF do paciente: ");
                    String cpf = FuncUtils.readCPF();
                    paciente.setCpf(cpf);

                    System.out.println("Digite o telefone do paciente: ");
                    String telefone = FuncUtils.readPhoneNumber();
                    paciente.setTelefone(telefone);

                    System.out.println("Digite a data de nascimento do paciente: ");
                    Date data = FuncUtils.readDate();
                    paciente.setDataNasc(data);

                    System.out.println("Sexo do paciente: ");
                    boolean sexo = FuncUtils.readSex();
                    paciente.setSexo(sexo);


                    PacienteDao pacientedao = new PacienteDao();
                    pacientedao.cadastrarPaciente(paciente);
                    pacientedao.fech();
                    break;
                case 2:
                    //PacienteDao.editarPaciente("1");

                    break;
                case 3:
                    //PacienteDao.excluirPaciente("13821");
                    break;
                case 4:
                    PacienteDao pacientedao2 = new PacienteDao();
                    String codPaciente = FuncUtils.readCod();
                    Paciente aux = pacientedao2.buscaPaciente(codPaciente);
                    pacientedao2.fech();
                    if (aux != null) {
                        System.out.println(aux);
                    }
                    break;
                case 5:
                   // PacienteDao.listarPacientes();
                    break;
                case 6:
                    //PacienteDao.alta("12312");
                    break;
                case 7:
                    //PacienteDao.internar("12312");
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
