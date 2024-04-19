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

                    System.out.println();
                    medicos = MedicoDao.verificarMedicosDisponiveisEmAlgumHorario(horarioConsulta, db);
                    if (medicos.isEmpty()) {
                        System.out.println("Não há médicos disponíveis para no horário da consulta.");
                        System.out.println("Cadastro de consulta cancelado.");
                        break;
                    } 
                    MenuMedico.listDoctors(medicos);
                    System.out.print("Insira o crm do médico da consulta: ");
                    crmMedico = FuncUtils.readCod();

                    ConsultaDao.cadastrarConsulta(new Consulta(dataConsulta, horarioConsulta, diagnostico, sintomas, precisaInternar, encaminhamento, crmMedico, idPaciente), db);
                    break;
                case 2:
                    System.out.println("Editar Consulta");
                    break;
                case 3:
                    System.out.println("Excluir Consulta");
                    break;
                case 4:
                    System.out.println("Listar Consultas");
                    break;
                case 5:
                    System.out.println("Buscar Consulta");
                    break;
                case 6:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida. Por favor, digite uma opção válida.");
                    break;
            }
        }
    }

    public static void displayMenu(){
        System.out.println("[1] - Cadastrar Consulta");
        System.out.println("[2] - Editar Consulta");
        System.out.println("[3] - Excluir Consulta");
        System.out.println("[4] - Listar Consultas");
        System.out.println("[5] - Buscar Consulta");
        System.out.println("[6] - Sair");
        System.out.print("Digite sua opcao: ");
    }
}
