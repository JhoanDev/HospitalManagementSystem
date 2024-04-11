package src;

import java.sql.SQLException;

import src.data.Banco;
import src.models.*;
import src.controllers.*;

public class DemoPaciente {
    public static Banco bd = new Banco();

    public static void main(String[] args) throws SQLException {
        System.out.println("Sistema de Gerenciamento de Hospital");
        FuncUtils.clearScreen();
        PacienteDao.cadastrarPaciente(bd);
        PacienteDao.editarPaciente(bd);;
        PacienteDao.excluirPaciente(bd);
        Paciente paciente = PacienteDao.buscaPaciente("1", bd);
        System.out.println(paciente);
        FuncUtils.clearScreen();
        PacienteDao.listarPacientes(bd);
        PacienteDao.alta(bd);
        PacienteDao.internar(bd);
        PacienteDao.listarPacientes(bd);        
    }
}
