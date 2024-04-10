package src;

import java.sql.ResultSet;
import java.sql.SQLException;

import src.data.Banco;
import src.models.FuncUtils;

public class Main {
    public static Banco bd = new Banco();

    public static void main(String[] args) throws SQLException {
        System.out.println("Sistema de Gerenciamento de Hospital");
        FuncUtils.clearScreen();
        Paciente paciente = new Paciente("12345678910", "123456789", "01/01/2000", true, true, true);
    }
}
