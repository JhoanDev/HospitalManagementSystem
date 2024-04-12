package src;

import src.utils.*;
import src.models.Medico;
import src.controllers.MedicoDao;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Time;

public class DemoMedico {

    public static void main(String[] args) throws SQLException {
        MedicoDao medicoDao = new MedicoDao();
        int opcao = 0, opcao2 = 0;
        String nome, cpf, telefone, crm, especialidade;
        Date dataNasc, dataDeAdmissao;
        Time horarioDeTrabalhoInicio, horarioDeTrabalhoFinal;
        boolean sexo, plantao;
        double salario;
        Medico medico;
        while (opcao != 7) {
            exibirMenu();
            opcao = FuncUtils.readInt();
            switch (opcao) {
                case 1:
                    System.out.print("Digite o nome do médico: ");
                    nome = FuncUtils.readOnlyLettersAndSpaces();
                    cpf = FuncUtils.readCPF();
                    telefone = FuncUtils.readPhoneNumber();
                    System.out.print("Insira a data de nascimento, ");
                    dataNasc = FuncUtils.readDate();
                    sexo = FuncUtils.readSex();
                    salario = FuncUtils.readSalary();
                    crm = FuncUtils.readCrm();
                    System.out.print("Insira a data de admissão, ");
                    dataDeAdmissao = FuncUtils.readDate();
                    System.out.print("insira o inicio do expediente, ");
                    horarioDeTrabalhoInicio = FuncUtils.readTime();
                    System.out.print("insira o final do expediente, ");
                    horarioDeTrabalhoFinal = FuncUtils.readTime();
                    System.out.print("Digite a especialidade do médico: ");
                    especialidade = FuncUtils.readOnlyLettersAndSpaces();
                    plantao = false;
                    medicoDao.cadastrarMedico(new Medico(nome, cpf, telefone, dataNasc, sexo, salario, dataDeAdmissao,
                            horarioDeTrabalhoInicio, horarioDeTrabalhoFinal, crm, especialidade, plantao));
                    break;
                case 2:
                crm = FuncUtils.readCrm();
                medico = medicoDao.buscaMedico(crm);
                if (medico != null) {
                    System.out.println(medico);
                    System.out.println("O que deseja editar?");
                    System.out.println("[1] - Nome");
                    System.out.println("[2] - CPF");
                    System.out.println("[3] - Telefone");
                    System.out.println("[4] - Data de nascimento");
                    System.out.println("[5] - Sexo");
                    System.out.println("[6] - Salário");
                    System.out.println("[7] - Data de admissão");
                    System.out.println("[8] - Horário de trabalho (início)");
                    System.out.println("[9] - Horário de trabalho (final)");
                    System.out.println("[10] - Especialidade");
                    System.out.println("[11] - Plantão");
                    System.out.println("[12] - Cancelar");
                    opcao2 = FuncUtils.readInt();
                    switch (opcao2) {
                        case 1:
                            System.out.print("Digite o novo nome: ");
                            medico.setNome(FuncUtils.readOnlyLettersAndSpaces());
                            break;
                        case 2:
                            medico.setCpf(FuncUtils.readCPF());
                            break;
                        case 3:
                            medico.setTelefone(FuncUtils.readPhoneNumber());
                            break;
                        case 4:
                            medico.setDataNasc(FuncUtils.readDate());
                            break;
                        case 5:
                            System.out.println("Insira o novo sexo do médico:");
                            medico.setSexo(FuncUtils.readSex());
                            break;
                        case 6:
                            medico.setSalario(FuncUtils.readSalary());
                            break;
                        case 7:
                            System.out.print("Insira a nova data de admissão, ");
                            medico.setDataDeAdmissao(FuncUtils.readDate());
                            break;
                        case 8:
                            System.out.print("Insira o novo horário de trabalho (início), ");
                            medico.setHorarioDeTrabalhoInicio(FuncUtils.readTime());
                            break;
                        case 9:
                            System.out.print("Insira o novo horário de trabalho (final), ");
                            medico.setHorarioDeTrabalhoFinal(FuncUtils.readTime());
                            break;
                        case 10:
                            System.out.print("Digite a nova especialidade do médico: ");
                            medico.setEspecialidade(FuncUtils.readOnlyLettersAndSpaces());
                            break;
                        case 11:
                            medico.setPlantao(FuncUtils.readShift());
                            break;
                        case 12:
                            break;
                        default:
                            System.out.println("Opção inválida.");
                            break;
                    }
                    if (opcao2 != 12) {
                        medicoDao.editarMedico(medico);
                    }
                } else {
                    System.out.println("Médico não encontrado.");
                }
                
                    break;
                case 3:

                    break;
                case 4:

                    break;
                case 5:
                    crm = FuncUtils.readCrm();
                    medico = medicoDao.buscaMedico(crm);
                    if (medico != null) {
                        System.out.println("\n" + medico);
                    } else {
                        System.out.println("Médico não encontrado.");
                    }
                    break;
                case 7:
                    System.out.println("Saindo...");
                    medicoDao.fech();
                    break;
                default:
                    System.out.println("Opção inválida.");
                    break;
            }
        }
        FuncUtils.fechaScanner();
    }

    public static void exibirMenu() {
        System.out.println("Menu de Médicos");
        System.out.println("[1] - Cadastrar Médico");
        System.out.println("[2] - Editar Médico");
        System.out.println("[3] - Excluir Médico");
        System.out.println("[4] - Listar Médicos");
        System.out.println("[5] - Buscar Médico");
        System.out.println("[6] - Verificar se há Médicos no horário");
        System.out.println("[7] - Sair");
    }
}
