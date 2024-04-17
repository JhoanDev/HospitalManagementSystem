package src;

import java.sql.SQLException;
import src.data.Banco;

public class Main {
    public static void main(String[] args) throws SQLException {
        System.out.println("Sistema de Gerenciamento de Hospital");
        Banco db = new Banco();
        db.disconnect();
    }
}