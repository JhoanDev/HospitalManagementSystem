package src.controllers;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import src.data.Banco;
import src.models.Medicamento;

public class MedicamentoDao {

    public static void cadastrarMedicamento(Medicamento medicamento, Banco db) {
        String query = String.format("INSERT INTO Medicamento (nome) VALUES ('%s');", medicamento.getNome());
        db.queryInsup(query);
    }

    public static Medicamento buscaMedicamento(String nome, Banco db) throws SQLException {
        String query = String.format("SELECT * FROM Medicamento WHERE nome = '%s';", nome);
        ResultSet rs = db.queryBusca(query);
        if (rs.next() && rs != null) {
            String nomeMed = rs.getString("nome");
            String codMedicamento = rs.getString("id_medicamento");
            Medicamento medicamento = new Medicamento(codMedicamento, nomeMed);
            return medicamento;
        }
        return null;
    }

    public static void editaMedicamento(Medicamento medicamento, Banco db) {
        String query = String.format("UPDATE Medicamento SET nome = '%s' WHERE id_medicamento = '%s';",
                medicamento.getNome(), medicamento.getCodMedicamento());
        db.queryInsup(query);
    }

    public static void excluirMedicamento(Medicamento medicamento, Banco db) throws SQLException {
        if (medicamento != null) {
            String querry = "DELETE FROM Medicamento WHERE id_medicamento = '" + medicamento.getCodMedicamento() + "';";
            db.queryInsup(querry);
        }
    }

    public static ArrayList<Medicamento> listarMedicamentos(Banco db) throws SQLException {
        String query = "SELECT * FROM Medicamento;";
        ResultSet rs = db.queryBusca(query);
        ArrayList<Medicamento> medicamentos = new ArrayList<Medicamento>();

        while (rs.next()) {
            Medicamento medicamento = new Medicamento(rs.getString("id_medicamento"), rs.getString("nome"));
            medicamentos.add(medicamento);
        }
        return medicamentos;
    }
}
