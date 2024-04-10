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
        ResultSet rs = bd.querry_busca("SELECT * FROM Administrador WHERE id_adm = 2");
        System.out.println(rs.getString("cpf"));
    }
}
