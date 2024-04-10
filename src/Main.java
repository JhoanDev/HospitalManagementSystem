package src;

import java.sql.SQLException;

import src.data.Banco;
import src.models.*;
import src.controllers.*;

public class Main {
    public static Banco bd = new Banco();

    public static void main(String[] args) throws SQLException {
        System.out.println("Sistema de Gerenciamento de Hospital");
        FuncUtils.clearScreen();
        Paciente paciente = new Paciente("João", "123456789", "123456789", new java.sql.Date(System.currentTimeMillis()), true, "123", true, true);
        PacienteDao.cadastrarPaciente(paciente, bd);
        Paciente paciente2 = PacienteDao.buscaPaciente("1", bd);
        System.out.println(paciente2);
        FuncUtils.input.close();
    }
}
