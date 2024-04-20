package src.views;

import java.sql.Date;
import java.sql.SQLException;

import java.util.ArrayList;

import src.controllers.EnfermariaDao;
import src.controllers.InternacaoDao;
import src.controllers.PacienteDao;
import src.data.Banco;
import src.models.Enfermaria;
import src.models.Internacao;
import src.models.Paciente;
import src.utils.FuncUtils;

public class InternacaoView {
    public static void main(String[] args) throws SQLException {
        Banco db = new Banco();
        hospitalizationMenu(db);
    }
    public static void hospitalizationMenu(Banco db) throws SQLException {
        int opcao = 0, opcao2 = 0;
        Date dataInternacao;
        Date dataAlta;
        String idPaciente, codEnfemaria;
        Internacao internacao = new Internacao();
        ArrayList<Enfermaria> enfermarias;
        ArrayList<Paciente> pacientes;
        Enfermaria enfermaria;
        Paciente paciente;

        while (opcao != 5) {
            displayMenu();
            opcao = FuncUtils.readInt();
            FuncUtils.clearScreen();
            switch (opcao) {
                case 1:
                    System.out.print("Insira a data da consulta, ");
                    dataInternacao = FuncUtils.readDate();

                    System.out.println();
                    pacientes = PacienteDao.listarPacientes(db);
                    if (pacientes.isEmpty()) {
                        System.out.println("Não há pacientes cadastrados.");
                        System.out.println("Cadastro de consulta cancelado.");
                        break;
                    }
                    PacienteView.listPatients(pacientes);
                    
                    System.out.print("Insira o código do paciente da consulta: ");
                    idPaciente = FuncUtils.readCod();
                    if (PacienteDao.buscaPaciente(idPaciente, db) == null || PacienteDao.buscaPaciente(idPaciente, db).isInternado() == true ) {
                        System.out.println("Código não está nos pacientes cadastrados ou já se encontra Internado.");
                        System.out.println("Cadastro de internação cancelado.");
                        break;
                    }
                    System.out.println();

                    enfermarias = EnfermariaDao.listarEnfermariasDisponiveis(db);
                    if (enfermarias.isEmpty()) {
                        System.out.println("Não há enfemarias disponíveis para no horário da consulta.");
                        System.out.println("Cadastro de consulta cancelado.");
                        break;
                    }
                    EnfermariaView.listWards(enfermarias);

                    System.out.print("Insira o codigo da enfemaria da Internação: ");
                    codEnfemaria = FuncUtils.readCod();
                    if (EnfermariaDao.buscaEnfermaria(codEnfemaria, db)== null || EnfermariaDao.buscaEnfermaria(codEnfemaria, db).getLeitosDisponiveis()<=0) {
                        System.out.println("Enfemaria não existe no sistema ou está lotada!.");
                        System.out.println("Cadastro de consulta cancelado.");
                        break;
                    }
                    System.out.println();
                    internacao.setDataInternacao(dataInternacao);
                    internacao.setDataAlta(null);
                    internacao.setIdEnfermaria(codEnfemaria);
                    internacao.setIdPaciente(idPaciente);
                    InternacaoDao.cadastrarInternacao(internacao, db);

                    enfermaria = EnfermariaDao.buscaEnfermaria(codEnfemaria, db);
                    enfermaria.setLeitosDisponiveis(enfermaria.getLeitosDisponiveis()-1);
                    EnfermariaDao.editaEnfermaria(enfermaria, db);

                    paciente = PacienteDao.buscaPaciente(idPaciente, db);
                    paciente.setInternado(true);
                    PacienteDao.editarPaciente(paciente, db);
                    
                    
                    break;
                /*case 2:
                    System.out.print("Insira o código da consulta: ");
                    codConsulta = FuncUtils.readCod();
                    consulta = ConsultaDao.buscaConsulta(codConsulta, db);
                    if (consulta == null) {
                        System.out.println("Consulta não encontrada.");
                        break;
                    }
                    System.out.println(consulta);
                    System.out.println("Deseja realmente excluir a consulta? [1] - Sim [2] - Não");
                    opcao2 = FuncUtils.readInt();
                    if (opcao2 == 1) {
                        ConsultaDao.excluirConsulta(consulta, db);
                        System.out.println("Consulta excluída com sucesso.");
                    }
                    break;
                case 3:
                    consultas = ConsultaDao.listarConsultas(db);
                    if (consultas.isEmpty()) {
                        System.out.println("Não há consultas cadastradas.");
                        break;
                    }
                    System.out.printf("|Cod%s|Data%s|Hora%s|Medico%s|Paciente\n", FuncUtils.spacesGenerator(4),
                            FuncUtils.spacesGenerator(7), FuncUtils.spacesGenerator(5), FuncUtils.spacesGenerator(24));
                    for (Consulta c : consultas) {
                        medico = MedicoDao.buscaMedico(c.getIdMedico(), db);
                        paciente = PacienteDao.buscaPaciente(c.getIdPaciente(), db);
                        System.out.printf("|%-7s|%-11s|%-9s|%-30s|%-30s\n", c.getCodConsulta(), c.getDataConsulta(),
                                c.getHorarioConsulta(), medico.getNome(), paciente.getNome());
                    }
                    System.out.println();
                    break;
                case 4:
                    System.out.print("Insira o código da consulta: ");
                    codConsulta = FuncUtils.readCod();
                    consulta = ConsultaDao.buscaConsulta(codConsulta, db);
                    if (consulta == null) {
                        System.out.println("Consulta não encontrada.");
                        break;
                    }
                    System.out.println(consulta);
                    break;*/                 
                case 5:
                    System.out.println("Saindo...");
                    return;
                default:
                    System.out.println("Opção inválida. Por favor, digite uma opção válida.");
                    break;
            }
        }
    }

    public static void displayMenu() {
        System.out.println("----------- MENU INTERNAÇÃO -----------");
        System.out.println("[1] - Cadastrar Internação");
        System.out.println("[2] - Excluir Consulta");
        System.out.println("[3] - Listar Internação");
        System.out.println("[4] - Buscar Internação");
        System.out.println("[5] - Sair");
        System.out.print("Digite sua opcao: ");
    }
}
