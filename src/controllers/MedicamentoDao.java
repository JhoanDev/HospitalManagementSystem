package src.controllers;

import java.sql.ResultSet;
import java.sql.SQLException;

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
        System.out.println("Medicamento não encontrado.");
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

/*     public static void listarMedicamentos(Banco db) throws SQLException {
        String query = "SELECT * FROM Medicamento;";
        ResultSet rs = db.queryBusca(query);

        System.out.printf("|Cod%s|Nome\n", FuncUtils.spacesGenerator(4));

        while (rs.next()) {
            String codMedicamento = rs.getString("id_medicamento");
            String nome = rs.getString("nome");
            System.out.printf("|%-7s|%-30s\n", codMedicamento, nome);
        }
    } */
}
