package src;

import java.sql.SQLException;
import java.sql.Date;
import src.controllers.PacienteDao;
import src.models.*;
import src.utils.FuncUtils;

public class DemoPaciente {
    public static void main(String[] args) throws SQLException {
        FuncUtils.clearScreen();
        System.out.println("Sistema de Gerenciamento de Hospital");
        PacienteDao pacienteDao = new PacienteDao();
        int opcao = 0, opcao2 = 0;
        String nome, cpf, telefone, cod;
        Date data;
        boolean sexo, planoSaude, edit = false;
        Paciente paciente;

        while (opcao != 8) {
            exibirMenu();
            opcao = FuncUtils.readInt();
            switch (opcao) {
                case 1:
                    System.out.print("Digite o nome do paciente: ");
                    nome = FuncUtils.readOnlyLettersAndSpaces();
                    cpf = FuncUtils.readCPF();
                    telefone = FuncUtils.readPhoneNumber();
                    data = FuncUtils.readDate();
                    sexo = FuncUtils.readSex();
                    planoSaude = FuncUtils.readHealthPlan();

                    pacienteDao.cadastrarPaciente(new Paciente(nome, cpf, telefone, data, sexo, false, planoSaude));
                    break;
                case 2:
                    System.out.println("Digite o código do paciente: ");
                    cod = FuncUtils.readCod();
                    paciente = pacienteDao.buscaPaciente(cod);
                    System.out.println(paciente);
                    if (paciente != null) {
                        edit = true;
                        System.out.println(paciente);
                        System.out.println("O que deseja editar?");
                        System.out.println("[1] - Nome");
                        System.out.println("[2] - CPF");
                        System.out.println("[3] - Telefone");
                        System.out.println("[4] - Data de nascimento");
                        System.out.println("[5] - Sexo");
                        System.out.println("[6] - Internado");
                        System.out.println("[7] - Plano de saúde");
                        System.out.println("[8] - Cancelar");
                        opcao2 = FuncUtils.readInt();
                        switch (opcao2) {
                            case 1:
                                System.out.print("Digite o novo nome: ");
                                paciente.setNome(FuncUtils.readOnlyLettersAndSpaces());
                                break;
                            case 2:
                                paciente.setCpf(FuncUtils.readCPF());
                                break;
                            case 3:
                                paciente.setTelefone(FuncUtils.readPhoneNumber());
                                break;
                            case 4:
                                paciente.setDataNasc(FuncUtils.readDate());
                                break;
                            case 5:
                                paciente.setSexo(FuncUtils.readSex());
                                break;
                            case 6:
                                paciente.setInternado(FuncUtils.readHospitalized());
                                break;
                            case 7:
                                paciente.setPlanoDeSaude(FuncUtils.readHealthPlan());
                                break;
                            case 8:
                                System.out.println("Operação cancelada");
                                edit = false;
                                break;
                            default:
                                System.out.println("Opção inválida");
                                edit = false;
                                break;
                        }
                        if (edit) {
                            pacienteDao.editarPaciente(paciente);
                        }
                    }
                    break;
                case 3:
                    System.out.println("Digite o codigo do paciente que deseja excluir: ");
                    cod = FuncUtils.readCod();
                    paciente = pacienteDao.buscaPaciente(cod);
                    if (paciente != null) {
                        pacienteDao.excluirPaciente(paciente);
                    }
                    else{
                        System.out.println("Paciente não encontrado.");
                    }
                    break;
                case 4:
                    System.out.println("Digite o código do paciente que deseja buscar: ");
                    cod = FuncUtils.readCod();
                    paciente = pacienteDao.buscaPaciente(cod);
                    if (paciente != null) {
                        System.out.println(paciente);
                    }
                    break;
                case 5:
                    pacienteDao.listarPacientes();
                    break;
                case 6:
                    System.out.println("Digite o código do paciente que deseja dar alta: "); // obs vai ter outre
                    cod = FuncUtils.readCod();
                    paciente = pacienteDao.buscaPaciente(cod);
                    if (paciente != null) {
                        pacienteDao.alta(paciente);
                    }
                    break;
                case 7:
                    System.out.println("Digite o código do paciente que deseja Internar: "); // obs ele vai sair da
                                                                                             // enfermaria que ele está
                    cod = FuncUtils.readCod();
                    paciente = pacienteDao.buscaPaciente(cod);
                    if (paciente != null) {
                        pacienteDao.internar(paciente);
                    }
                    break;
                case 8:
                    System.out.println("Saindo do programa...");
                    pacienteDao.fech();

                    return;
                default:
                    System.out.println("Opção inválida. Por favor, escolha uma opção válida.");
            }
        }
        FuncUtils.fechaScanner();
    }

    public static void exibirMenu() {
        System.out.println("\nMenu:");
        System.out.println("[1] Cadastrar Paciente");
        System.out.println("[2] Editar Paciente");
        System.out.println("[3] Excluir Paciente");
        System.out.println("[4] Buscar Paciente");
        System.out.println("[5] Listar Pacientes");
        System.out.println("[6] Dar Alta");
        System.out.println("[7] Internar Paciente");
        System.out.println("[8] Sair do programa");
    }

}
