package src;


import java.sql.ResultSet;
import java.sql.SQLException;

import src.data.Banco;

public class Main {
    public static void main(String[] args) throws SQLException {
        System.out.println("Sistema de Gerenciamento de Hospital");
        Banco bd = new Banco();
        ResultSet rs = bd.querry_busca("SELECT * FROM Administrador WHERE id_adm = 3");
        System.out.println(rs.getString("cpf"));
        
    }
}

