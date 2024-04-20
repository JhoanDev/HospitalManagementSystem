package src.controllers;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import src.data.Banco;
import src.models.Medicamento;
import src.models.Prescricao;

public class PrescricaoDao {
    public static void cadastrarPrescricao(Prescricao prescricao, Banco db) {
        String query = String.format(
                "INSERT INTO Prescricao (id_consulta, id_medicamento, dosagem, posologia)VALUES ('%d', '%d', '%s', '%s');",
                Integer.parseInt(prescricao.getCodConsulta()),
                Integer.parseInt(prescricao.getMedicamento().getCodMedicamento()), prescricao.getDosagem(),
                prescricao.getPosologia());
        db.queryInsup(query);
    }

    public static Prescricao buscaPrescricao(String codPrescricao, Banco db) throws SQLException {
        String query = "SELECT * FROM Prescricao WHERE id_prescricao = '" + codPrescricao + "';";
        ResultSet rs = db.queryBusca(query);
        Prescricao prescricao = new Prescricao();
        while (rs.next()) {
            String codConsulta = rs.getString("id_consulta");
            String codMedicamento = rs.getString("id_medicamento");
            Medicamento medicamento = MedicamentoDao.buscaMedicamento(codMedicamento, db);
            String dosagem = rs.getString("dosagem");
            String posologia = rs.getString("posologia");
            prescricao.setCodConsulta(codConsulta);
            prescricao.setMedicamento(medicamento);
            prescricao.setDosagem(dosagem);
            prescricao.setPosologia(posologia);
            return prescricao;
        }
        return null;
    }

    public static void excluirPrescricao(Prescricao prescricao, Banco db) {
        String query = "DELETE FROM Prescricao WHERE id_prescricao = '" + prescricao.getCodPrescricao() + "';";
        db.queryInsup(query);
    }

    public static ArrayList<Prescricao> listarPrescricoes(Banco db) throws SQLException {
        String query = "SELECT * FROM Prescricao;";
        ResultSet rs = db.queryBusca(query);
        ArrayList<Prescricao> prescricoes = new ArrayList<Prescricao>();
        Prescricao prescricao;
        while (rs.next()) {
            String codPrescricao = rs.getString("id_prescricao");
            String codConsulta = rs.getString("id_consulta");
            String codMedicamento = rs.getString("id_medicamento");
            Medicamento medicamento = MedicamentoDao.buscaMedicamento(codMedicamento, db);
            String dosagem = rs.getString("dosagem");
            String posologia = rs.getString("posologia");
            prescricao = new Prescricao(codPrescricao, codConsulta, medicamento, dosagem, posologia);
            prescricoes.add(prescricao);
        }
        return prescricoes;
    }

    public static ArrayList<Prescricao> listarPrescricoes(String codConsulta, Banco db) throws SQLException {
        String query = "SELECT * FROM Prescricao WHERE id_consulta = '" + codConsulta + "';";
        ResultSet rs = db.queryBusca(query);
        ArrayList<Prescricao> prescricoes = new ArrayList<Prescricao>();
        ArrayList<String> codPrescricao = new ArrayList<String>();
        ArrayList<String> codMedicamento = new ArrayList<String>();
        ArrayList<String> dosagem = new ArrayList<String>();
        ArrayList<String> posologia = new ArrayList<String>();
        Prescricao prescricao;
        while (rs.next()) {
            codPrescricao.add(rs.getString("id_prescricao"));
            codMedicamento.add(rs.getString("id_medicamento"));
            dosagem.add(rs.getString("dosagem"));
            posologia.add(rs.getString("posologia"));
        }
        for (int i = 0; i < codPrescricao.size(); i++) {
            Medicamento medicamento = MedicamentoDao.buscaMedicamento(codMedicamento.get(i), db);
            prescricao = new Prescricao(codPrescricao.get(i), codConsulta, medicamento, dosagem.get(i), posologia.get(i));
            prescricoes.add(prescricao);
        }
        return prescricoes;
    }
}
