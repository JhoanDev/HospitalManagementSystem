package src;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Time;
import src.controllers.AdministradorDao;
import src.models.Administrador;
import src.utils.FuncUtils;


public class DemoAdministrador {
    public static void main(String[] args) throws SQLException, NoSuchAlgorithmException, UnsupportedEncodingException {

        AdministradorDao administradorDao = new AdministradorDao();
        int opcao = 0, opcao2 = 0;
        String nome, cpf, telefone, login,senha;
        Date dataNasc, dataDeAdmissao;
        Time horarioDeTrabalhoInicio, horarioDeTrabalhoFinal;
        boolean sexo;
        double salario;
        Administrador administrador;
        while (opcao != 6) {
            exibirMenu();
            opcao = FuncUtils.readInt();
            switch (opcao) {
                case 1:
                    System.out.println("Digite o login do Administrador: ");
                    login = FuncUtils.readOnlyLettersAndSpaces();
                	System.out.println("Digite a senha do Administrador: ");
                    senha = FuncUtils.readPassword();
                    System.out.print("Digite o nome do administrador: ");
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

                    administradorDao.cadastrarAdministrador(new Administrador(nome, cpf, telefone, dataNasc, sexo, salario, dataDeAdmissao,
                            horarioDeTrabalhoInicio, horarioDeTrabalhoFinal,login,senha), db);
                    break;
                case 2:
                    System.out.println("Digite o login do adm");
                    login = FuncUtils.readOnlyLettersAndSpaces();
                    administrador = administradorDao.buscaAdministrador(login);
                    if (administrador!= null) {
                        System.out.println(administrador);
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
                                administrador.setNome(FuncUtils.readOnlyLettersAndSpaces());
                                break;
                            case 2:
                                administrador.setCpf(FuncUtils.readCPF());
                                break;
                            case 3:
                                administrador.setTelefone(FuncUtils.readPhoneNumber());
                                break;
                            case 4:
                                administrador.setDataNasc(FuncUtils.readDate());
                                break;
                            case 5:
                                System.out.println("Insira o novo sexo do administrador:");
                                administrador.setSexo(FuncUtils.readSex());
                                break;
                            case 6:
                                administrador.setSalario(FuncUtils.readSalary());
                                break;
                            case 7:
                                System.out.print("Insira a nova data de admissão, ");
                                administrador.setDataDeAdmissao(FuncUtils.readDate());
                                break;
                            case 8:
                                System.out.print("Insira o novo horário de trabalho (início), ");
                                administrador.setHorarioDeTrabalhoInicio(FuncUtils.readTime());
                                break;
                            case 9:
                                System.out.print("Insira o novo horário de trabalho (final), ");
                                administrador.setHorarioDeTrabalhoFinal(FuncUtils.readTime());
                                break;
                            case 10:
                                break;
                            default:
                                System.out.println("Opção inválida.");
                                break;
                        }
                        if (opcao2 != 12) {
                            administradorDao.editarAdministrador(administrador);
                        }
                    }
                    break;
                case 3:
                    System.out.println("Digite o login do adm");
                    login = FuncUtils.readOnlyLettersAndSpaces();
                    administrador = administradorDao.buscaAdministrador(login);
                    administradorDao.excluirAdministrador(administrador);
                    
                    break;
                case 4:
                    administradorDao.listarAdministradores();
                    break;
                case 5:
                    System.out.println("Digite o login do adm");
                    login = FuncUtils.readOnlyLettersAndSpaces();
                    administrador = administradorDao.buscaAdministrador(login);
                    if (administrador != null) {
                        System.out.println("\n" + administrador);
                    }
                    break;
                case 6:
                    System.out.println("Saindo...");
                    administradorDao.administradorFech();
                    break;
            default:
                    System.out.println("Opção inválida.");
                    break;
            }
        }
        FuncUtils.fechaScanner();
    }

    public static void exibirMenu() {
        System.out.println("Menu de administradores");
        System.out.println("[1] - Cadastrar administrador");
        System.out.println("[2] - Editar administrador");
        System.out.println("[3] - Excluir administrador");
        System.out.println("[4] - Listar administradores");
        System.out.println("[5] - Buscar administrador");
        System.out.println("[6] - Sair");
    }
}
