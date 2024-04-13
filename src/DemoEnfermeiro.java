package src;

import java.sql.Date;
import java.sql.SQLException;
import java.sql.Time;

import src.controllers.EnfermeiroDao;
import src.models.Enfermeiro;
import src.utils.FuncUtils;

public class DemoEnfermeiro {
    public static void main(String[] args) throws SQLException {

        EnfermeiroDao enfermeiroDao = new EnfermeiroDao();
        int opcao = 0, opcao2 = 0;
        String nome, cpf, telefone, coren;
        Date dataNasc, dataDeAdmissao;
        Time horarioDeTrabalhoInicio, horarioDeTrabalhoFinal;
        boolean sexo;
        double salario;
        Enfermeiro enfermeiro;
        while (opcao != 7) {
            exibirMenu();
            opcao = FuncUtils.readInt();
            switch (opcao) {
                case 1:
                    System.out.print("Digite o nome do enfermeiro: ");
                    nome = FuncUtils.readOnlyLettersAndSpaces();
                    cpf = FuncUtils.readCPF();
                    telefone = FuncUtils.readPhoneNumber();
                    System.out.print("Insira a data de nascimento, ");
                    dataNasc = FuncUtils.readDate();
                    sexo = FuncUtils.readSex();
                    salario = FuncUtils.readSalary();
                    coren = FuncUtils.readCoren();
                    System.out.print("Insira a data de admissão, ");
                    dataDeAdmissao = FuncUtils.readDate();
                    System.out.print("insira o inicio do expediente, ");
                    horarioDeTrabalhoInicio = FuncUtils.readTime();
                    System.out.print("insira o final do expediente, ");
                    horarioDeTrabalhoFinal = FuncUtils.readTime();
                    enfermeiroDao.cadastrarEnfermeiro(new Enfermeiro(nome, cpf, telefone, dataNasc, sexo, salario, dataDeAdmissao,
                            horarioDeTrabalhoInicio, horarioDeTrabalhoFinal, coren));
                    break;
                case 2:
                    coren = FuncUtils.readCoren();
                    enfermeiro = enfermeiroDao.buscaEnfermeiro(coren);
                    if (enfermeiro!= null) {
                        System.out.println(enfermeiro);
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
                        System.out.println("[10] - Cancelar");
                        opcao2 = FuncUtils.readInt();
                        switch (opcao2) {
                            case 1:
                                System.out.print("Digite o novo nome: ");
                                enfermeiro.setNome(FuncUtils.readOnlyLettersAndSpaces());
                                break;
                            case 2:
                                enfermeiro.setCpf(FuncUtils.readCPF());
                                break;
                            case 3:
                                enfermeiro.setTelefone(FuncUtils.readPhoneNumber());
                                break;
                            case 4:
                                enfermeiro.setDataNasc(FuncUtils.readDate());
                                break;
                            case 5:
                                System.out.println("Insira o novo sexo do enfermeiro:");
                                enfermeiro.setSexo(FuncUtils.readSex());
                                break;
                            case 6:
                                enfermeiro.setSalario(FuncUtils.readSalary());
                                break;
                            case 7:
                                System.out.print("Insira a nova data de admissão, ");
                                enfermeiro.setDataDeAdmissao(FuncUtils.readDate());
                                break;
                            case 8:
                                System.out.print("Insira o novo horário de trabalho (início), ");
                                enfermeiro.setHorarioDeTrabalhoInicio(FuncUtils.readTime());
                                break;
                            case 9:
                                System.out.print("Insira o novo horário de trabalho (final), ");
                                enfermeiro.setHorarioDeTrabalhoFinal(FuncUtils.readTime());
                                break;
                            case 10:
                                break;
                            default:
                                System.out.println("Opção inválida.");
                                break;
                        }
                        if (opcao2 != 12) {
                            enfermeiroDao.editarEnfermeiro(enfermeiro);
                        }
                    }
                    break;
                case 3:
                    coren = FuncUtils.readCoren();
                    enfermeiro = enfermeiroDao.buscaEnfermeiro(coren);
                    enfermeiroDao.excluirEnfermeiro(enfermeiro);
                    
                    break;
                case 4:
                    enfermeiroDao.listarEnfermeiros();
                    break;
                case 5:
                    coren = FuncUtils.readCoren();
                    enfermeiro = enfermeiroDao.buscaEnfermeiro(coren);
                    if (enfermeiro != null) {
                        System.out.println("\n" + enfermeiro);
                    }
                    break;
                case 6:
                    System.out.println("Saindo...");
                    enfermeiroDao.enfermeiroFech();
                    break;
            default:
                    System.out.println("Opção inválida.");
                    break;
            }
        }
        FuncUtils.fechaScanner();
    }

    public static void exibirMenu() {
        System.out.println("Menu de enfermeiros");
        System.out.println("[1] - Cadastrar enfermeiro");
        System.out.println("[2] - Editar enfermeiro");
        System.out.println("[3] - Excluir enfermeiro");
        System.out.println("[4] - Listar enfermeiros");
        System.out.println("[5] - Buscar enfermeiro");
        System.out.println("[6] - Sair");
    }
}


