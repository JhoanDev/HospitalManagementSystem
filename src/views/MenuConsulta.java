package src.views;

import java.sql.Date;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;

import src.controllers.ConsultaDao;
import src.controllers.MedicoDao;
import src.controllers.PacienteDao;
import src.data.Banco;
import src.models.Consulta;
import src.models.Medico;
import src.models.Paciente;
import src.utils.FuncUtils;

public class MenuConsulta {
    public static void appointmentMenu(Banco db) throws SQLException{
        int opcao = 0, opcao2 = 0;
        Date dataConsulta;
        Time horarioConsulta;
        String diagnostico, codConsulta, crmMedico, idPaciente;
        ArrayList<String> sintomas;
        boolean precisaInternar;
        String encaminhamento;
        Consulta consulta;
        ArrayList<Consulta> consultas;
        ArrayList<Medico> medicos;
        ArrayList<Paciente> pacientes;
        Medico medico;
        Paciente paciente;
        while (opcao != 6) {
            displayMenu();
            opcao = FuncUtils.readInt();
            FuncUtils.clearScreen();
            switch (opcao) {
                case 1:
                    System.out.print("Insira a data da consulta, ");
                    dataConsulta = FuncUtils.readDate();
                    System.out.print("Insira o horário da consulta, ");
                    horarioConsulta = FuncUtils.readTime();
                    System.out.print("Insira o diagnóstico: ");
                    diagnostico = FuncUtils.readOnlyLettersAndSpaces();
                    sintomas = FuncUtils.readSymptoms();
                    precisaInternar = FuncUtils.readNeedToHospitalize();
                    System.out.print("Encaminhamento: ");
                    encaminhamento = FuncUtils.readOnlyLettersAndSpaces();

                    System.out.println();
                    pacientes = PacienteDao.listarPacientes(db);
                    if (pacientes.isEmpty()) {
                        System.out.println("Não há pacientes cadastrados.");
                        System.out.println("Cadastro de consulta cancelado.");
                        break;
                    }
                    MenuPaciente.listPatients(pacientes);
                    System.out.print("Insira o código do paciente da consulta: ");
                    idPaciente = FuncUtils.readCod();
                    if (PacienteDao.buscaPaciente(idPaciente, db) == null){
                        System.out.println("Código não está nos pacientes cadastrados.");
                        System.out.println("Cadastro de consulta cancelado.");
                        break;
                    }
                    System.out.println();
                    medicos = MedicoDao.verificarMedicosDisponiveisEmAlgumHorario(horarioConsulta, db);
                    if (medicos.isEmpty()) {
                        System.out.println("Não há médicos disponíveis para no horário da consulta.");
                        System.out.println("Cadastro de consulta cancelado.");
                        break;
                    } 
                    MenuMedico.listDoctors(medicos);
                    System.out.print("Insira o crm do médico da consulta: ");
                    crmMedico = FuncUtils.readCrm();
                    if (MedicoDao.buscaMedico(crmMedico, db) == null){
                        System.out.println("CRM não está nos médicos disponíveis.");
                        System.out.println("Cadastro de consulta cancelado.");
                        break;
                    }
                    ConsultaDao.cadastrarConsulta(new Consulta(dataConsulta, horarioConsulta, diagnostico, sintomas, precisaInternar, encaminhamento, crmMedico, idPaciente), db);
                    break;
                case 2:
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
                    System.out.printf("|Cod%s|Data%s|Hora%s|Medico%s|Paciente\n", FuncUtils.spacesGenerator(4), FuncUtils.spacesGenerator(7), FuncUtils.spacesGenerator(5), FuncUtils.spacesGenerator(24));
                    for (Consulta c : consultas) {
                        medico = MedicoDao.buscaMedico(c.getIdMedico(), db);
                        paciente = PacienteDao.buscaPaciente(c.getIdPaciente(), db);
                        System.out.printf("|%-7s|%-11s|%-9s|%-30s|%-30s\n", c.getCodConsulta(), c.getDataConsulta(), c.getHorarioConsulta(), medico.getNome(), paciente.getNome());
                    }
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
                    break;
                case 5:
                    System.out.println("Saindo...");
                    return;
                default:
                    System.out.println("Opção inválida. Por favor, digite uma opção válida.");
                    break;
            }
        }
    }

    public static void displayMenu(){
        System.out.println("[1] - Cadastrar Consulta");
        System.out.println("[2] - Excluir Consulta");
        System.out.println("[3] - Listar Consultas");
        System.out.println("[4] - Buscar Consulta");
        System.out.println("[5] - Sair");
        System.out.print("Digite sua opcao: ");
    }
}
