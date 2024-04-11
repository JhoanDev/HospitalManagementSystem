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
        FuncUtils.fechaScanner();
    }
}
