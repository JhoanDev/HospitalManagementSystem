package src.controllers;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import src.data.Banco;
import src.models.Internacao;


public class InternacaoDao {
    
    public static void cadastrarInternacao(Internacao internacao, Banco db) {
        String query = String.format(
                "INSERT INTO Internacao (data_internacao, data_alta, id_paciente, id_enfermaria) VALUES ('%tF,'%s','%s');",
                internacao.getDataInternacao(),Integer.parseInt(internacao.getIdPaciente()),
                Integer.parseInt(internacao.getIdEnfermaria()));
        db.queryInsup(query);
    }

    public static Internacao buscaInternacao(String codInternacao, Banco db) throws SQLException {
        String query = "SELECT * FROM Internacao WHERE id_internacao = '" + codInternacao + "';";
        ResultSet rs = db.queryBusca(query);
        if (rs.next()) {
            Internacao internacao = new Internacao();
            internacao.setCodInternacao(rs.getString("id_internacao"));

            String dataInternacaoStr = rs.getString("data_internacao");
            Date dataInternacao = Date.valueOf(dataInternacaoStr);
            internacao.setDataInternacao(dataInternacao);

            internacao.setIdPaciente(rs.getString("id_paciente"));
            internacao.setIdEnfermaria(rs.getString("id_enfemaria"));

     
        }
        return null;
    }

    public static void editarInternacao(Internacao internacao, Banco db) throws SQLException {
        String query = String.format(
                "UPDATE Internacao SET data_internacao = '%tF', data_alta = '%tF', id_paciente = '%s', id_enfermaria = '%s' WHERE id_internacao = '%s';",
                internacao.getDataInternacao(), internacao.getDataAlta(), internacao.getIdPaciente(), internacao.getIdEnfermaria(), internacao.getCodInternacao());
        db.queryInsup(query);
    }

    public static void excluirInternacao(Internacao internacao, Banco db) throws SQLException {
        String query = String.format("DELETE FROM Internacao WHERE id_Internacao = '%s';", internacao.getCodInternacao());
        db.queryInsup(query);
    }

    public static ArrayList<Internacao> listarInternacoes(Banco db) throws SQLException {
        String query = "SELECT * FROM Internacao;";
        ResultSet rs = db.queryBusca(query);
        ArrayList<Internacao> internacoes = new ArrayList<Internacao>();
        while (rs.next()) {
            Internacao internacao = new Internacao();
            internacao.setCodInternacao(rs.getString("id_internacao"));

            String dataInternacaoStr = rs.getString("data_internacao");
            Date dataInternacao = Date.valueOf(dataInternacaoStr);
            internacao.setDataInternacao(dataInternacao);

            internacao.setIdPaciente(rs.getString("id_paciente"));
            internacao.setIdEnfermaria(rs.getString("id_enfermaria"));


            internacoes.add(internacao);
        }
        return internacoes;
    }

    public static ArrayList<Internacao> listarInternacoesAtivas(Banco db) throws SQLException {
        String query = "SELECT * FROM Internacao WHERE data_alta != null;";
        ResultSet rs = db.queryBusca(query);
        ArrayList<Internacao> internacoes = new ArrayList<Internacao>();
        while (rs.next()) {
            Internacao internacao = new Internacao();
            internacao.setCodInternacao(rs.getString("id_internacao"));

            String dataInternacaoStr = rs.getString("data_internacao");
            Date dataInternacao = Date.valueOf(dataInternacaoStr);
            internacao.setDataInternacao(dataInternacao);

            internacao.setIdPaciente(rs.getString("id_paciente"));
            internacao.setIdEnfermaria(rs.getString("id_enfermaria"));


            internacoes.add(internacao);
        }
        return internacoes;
    }

}
