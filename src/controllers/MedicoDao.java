package src.controllers;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;

import src.data.Banco;
import src.models.Medico;

public class MedicoDao {
    Banco db;

    public MedicoDao() {
        db = new Banco();
    }

    public void cadastrarMedico(Medico medico) {
        String query = String.format(
                "INSERT INTO Medico (nome, cpf, telefone, data_nascimento, sexo, salario, dataDeAdmissao, horarioDeTrabalhoInicio, horarioDeTrabalhoFinal, bonus, crm, especialidade, plantao) VALUES ('%s', '%s', '%s', '%tF', %b, '%.2f', '%tF', '%tT', '%tT', '%.2f', '%s', '%s', %b);",
                medico.getNome(), medico.getCpf(), medico.getTelefone(), medico.getDataNasc(),
                medico.isSexo(), medico.getSalario(), medico.getDataDeAdmissao(),
                medico.getHorarioDeTrabalhoInicio(), medico.getHorarioDeTrabalhoFinal(), medico.getBonus(),
                medico.getCrm(), medico.getEspecialidade(), medico.isPlantao());
        db.querry_insup(query);
    }

    public Medico buscaMedico(String crm) throws SQLException {
        String query = "SELECT * FROM Medico WHERE crm = '" + crm + "';";
        ResultSet rs = db.querry_busca(query);
        Medico medico = new Medico();

        if (rs.next() && rs != null) {
            medico.setNome(rs.getString("nome"));
            medico.setCpf(rs.getString("cpf"));
            medico.setTelefone(rs.getString("telefone"));
            medico.setSexo(rs.getBoolean("sexo"));
            String dataNascStr = rs.getString("data_nascimento");
            Date dataNasc = Date.valueOf(dataNascStr);
            medico.setDataNasc(dataNasc);

            medico.setSalario(rs.getDouble("salario"));
            System.out.println(medico.getSalario());

            String dataAdmissaoStr = rs.getString("dataDeAdmissao");
            Date dataAdmissao = Date.valueOf(dataAdmissaoStr);
            medico.setDataDeAdmissao(dataAdmissao);

            String horarioInicioStr = rs.getString("horarioDeTrabalhoInicio");
            Time horarioInicio = Time.valueOf(horarioInicioStr);
            medico.setHorarioDeTrabalhoInicio(horarioInicio);

            String horarioFinalStr = rs.getString("horarioDeTrabalhoFinal");
            Time horarioFinal = Time.valueOf(horarioFinalStr);
            medico.setHorarioDeTrabalhoFinal(horarioFinal);

            medico.setBonus(rs.getDouble("bonus"));
            System.out.println(medico.getBonus());
           

            medico.setCrm(rs.getString("crm"));
            medico.setEspecialidade(rs.getString("especialidade"));
            medico.setPlantao(rs.getBoolean("plantao"));
        } else {
            System.out.println("Médico não encontrado.");
            return null;
        }
        return medico;
    }

    public void editarMedico(Medico medico) throws SQLException {
        String query = String.format(
                "UPDATE Medico SET nome = '%s', cpf = '%s', telefone = '%s', data_nascimento = '%tF', sexo = %b, salario = '%.2f', dataDeAdmissao = '%tF', horarioDeTrabalhoInicio = '%tT', horarioDeTrabalhoFinal = '%tT', bonus = '%.2f', crm = '%s', especialidade = '%s', plantao = %b WHERE crm = '%s';",
                medico.getNome(), medico.getCpf(), medico.getTelefone(), medico.getDataNasc(),
                medico.isSexo(), medico.getSalario(), medico.getDataDeAdmissao(),
                medico.getHorarioDeTrabalhoInicio(), medico.getHorarioDeTrabalhoFinal(),
                medico.getBonus(),
                medico.getCrm(), medico.getEspecialidade(), medico.isPlantao(), medico.getCrm());
        db.querry_insup(query);
    }

    public void fech() {
        db.desconect();
    }
}
