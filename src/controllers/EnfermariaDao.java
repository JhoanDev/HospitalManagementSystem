package src.controllers;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import src.data.Banco;
import src.models.Enfermaria;

public class EnfermariaDao {

    public static void cadastrarEnfermaria(Enfermaria enfermaria, Banco db) {
        String query = String.format("INSERT INTO Enfermaria (qnt_leitos, leitos_disponiveis) VALUES ('%d', '%d');", enfermaria.getLeitosDisponiveis(), enfermaria.getLeitosDisponiveis());
        db.queryInsup(query);
    }

    public static Enfermaria buscaEnfermaria(String codEnfermaria, Banco db) throws SQLException {
        String query = String.format("SELECT * FROM Enfermaria WHERE id_enfermaria = '%s';", codEnfermaria);
        ResultSet rs = db.queryBusca(query);
        if (rs.next() && rs != null) {
            String cod = rs.getString("id_enfermaria");
            int qnt_leitos = rs.getInt("qnt_leitos");
            int leitos_disponiveis = rs.getInt("leitos_disponiveis");
            Enfermaria enfermaria = new Enfermaria(cod, qnt_leitos, leitos_disponiveis);
            return enfermaria;
        }
        System.out.println("Enfermaria não encontrada.");
        return null;
    }

    public static void editaEnfermaria(Enfermaria enfermaria, Banco db) {
        String query = String.format("UPDATE Enfermaria SET qnt_leitos = '%d', leitos_disponiveis = '%d' WHERE id_enfermaria = '%s';",
                enfermaria.getQtdeLeitos(), enfermaria.getLeitosDisponiveis(), enfermaria.getCodEnfermaria());
        db.queryInsup(query);
    }
    
    public static void excluirEnfermaria(Enfermaria enfermaria, Banco db) throws SQLException {
        String query = String.format("DELETE FROM Enfermaria WHERE id_enfermaria = '%s';", enfermaria.getCodEnfermaria());
        db.queryInsup(query);
    }
    

    public static ArrayList<Enfermaria> listarEnfermarias(Banco db) throws SQLException {
        String query = "SELECT * FROM Enfermaria;";
        ResultSet rs = db.queryBusca(query);
        ArrayList<Enfermaria> enfermarias = new ArrayList<Enfermaria>();
        while (rs.next()) {
            Enfermaria enfermaria = new Enfermaria();
            String codEnfermaria = rs.getString("id_enfermaria");
            int qnt_leitos = rs.getInt("qnt_leitos");
            int leitos_disponiveis = rs.getInt("leitos_disponiveis");
            enfermaria.setCodEnfermaria(codEnfermaria);
            enfermaria.setQtdeLeitos(qnt_leitos);
            enfermaria.setLeitosDisponiveis(leitos_disponiveis);
            enfermarias.add(enfermaria);
        }
        return enfermarias;
    } 
}
