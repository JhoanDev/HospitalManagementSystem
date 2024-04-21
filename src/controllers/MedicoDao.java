package src.controllers;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;

import src.data.Banco;
import src.models.Medico;

public class MedicoDao {

    public static void cadastrarMedico(Medico medico, Banco db) {
        String query = String.format(
                "INSERT INTO Medico (nome, cpf, telefone, data_nascimento, sexo, salario, data_admissao, horario_trabalho_inicio, horario_trabalho_final, crm, especialidade, plantao) VALUES ('%s', '%s', '%s', '%tF', %b, '%.2f', '%tF', '%tT', '%tT', '%s', '%s', %b);",
                medico.getNome(), medico.getCpf(), medico.getTelefone(), medico.getDataNasc(),
                medico.isSexo(), medico.getSalario(), medico.getDataDeAdmissao(),
                medico.getHorarioDeTrabalhoInicio(), medico.getHorarioDeTrabalhoFinal(),
                medico.getCrm(), medico.getEspecialidade(), medico.isPlantao());
        db.queryInsup(query);
    }

    public static Medico buscaMedico(String crm, Banco db) throws SQLException {
        String query = "SELECT * FROM Medico WHERE crm = '" + crm + "';";
        ResultSet rs = db.queryBusca(query);
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

            String dataAdmissaoStr = rs.getString("data_admissao");
            Date dataAdmissao = Date.valueOf(dataAdmissaoStr);
            medico.setDataDeAdmissao(dataAdmissao);

            String horarioInicioStr = rs.getString("horario_trabalho_inicio");
            Time horarioInicio = Time.valueOf(horarioInicioStr);
            medico.setHorarioDeTrabalhoInicio(horarioInicio);

            String horarioFinalStr = rs.getString("horario_trabalho_final");
            Time horarioFinal = Time.valueOf(horarioFinalStr);
            medico.setHorarioDeTrabalhoFinal(horarioFinal);

            medico.setCrm(rs.getString("crm"));
            medico.setEspecialidade(rs.getString("especialidade"));
            medico.setPlantao(rs.getBoolean("plantao"));
        } else {
            return null;
        }

        return medico;
    }

    public static void editarMedico(Medico medico, Banco db) throws SQLException {
        String query = String.format(
                "UPDATE Medico SET nome = '%s', cpf = '%s', telefone = '%s', data_nascimento = '%tF', sexo = %b, salario = '%.2f', data_admissao = '%tF', horario_trabalho_inicio = '%tT', horario_trabalho_final = '%tT', crm = '%s', especialidade = '%s', plantao = %b WHERE crm = '%s';",
                medico.getNome(), medico.getCpf(), medico.getTelefone(), medico.getDataNasc(),
                medico.isSexo(), medico.getSalario(), medico.getDataDeAdmissao(),
                medico.getHorarioDeTrabalhoInicio(), medico.getHorarioDeTrabalhoFinal(),
                medico.getCrm(), medico.getEspecialidade(), medico.isPlantao(), medico.getCrm());
        db.queryInsup(query);
    }

    public static void excluirMedico(Medico medico, Banco db) throws SQLException {
        if (medico != null) {
            String querry = "DELETE FROM Medico WHERE crm = '" + medico.getCrm() + "';";
            db.queryInsup(querry);
        }
    }

    public static ArrayList<Medico> listarMedicos(Banco db) throws SQLException {
        String query = "SELECT * FROM Medico;";
        ResultSet rs = db.queryBusca(query);
        ArrayList<Medico> medicos = new ArrayList<Medico>();

        while (rs.next()) {
            Medico medico = new Medico();

            medico.setNome(rs.getString("nome"));
            medico.setCpf(rs.getString("cpf"));
            medico.setTelefone(rs.getString("telefone"));
            medico.setCrm(rs.getString("crm"));
            medico.setEspecialidade(rs.getString("especialidade"));
            medico.setSalario(rs.getDouble("salario"));
            medico.setPlantao(rs.getBoolean("plantao"));
            medico.setSexo(rs.getBoolean("sexo"));

            String dataNascStr = rs.getString("data_nascimento");
            Date dataNasc = Date.valueOf(dataNascStr);
            medico.setDataNasc(dataNasc);

            String dataAdmissaoStr = rs.getString("data_admissao");
            Date dataAdmissao = Date.valueOf(dataAdmissaoStr);
            medico.setDataDeAdmissao(dataAdmissao);

            String horarioInicioStr = rs.getString("horario_trabalho_inicio");
            Time horarioInicio = Time.valueOf(horarioInicioStr);
            medico.setHorarioDeTrabalhoInicio(horarioInicio);

            String horarioFinalStr = rs.getString("horario_trabalho_final");
            Time horarioFinal = Time.valueOf(horarioFinalStr);
            medico.setHorarioDeTrabalhoFinal(horarioFinal);

            medicos.add(medico);
        }
        return medicos;
    }

    public static ArrayList<Medico> verificarMedicosDisponiveisEmAlgumHorario(Time horario, Banco db)
            throws SQLException {
        String query = "SELECT * FROM Medico";
        ResultSet rs = db.queryBusca(query);
        ArrayList<Medico> medicos = new ArrayList<Medico>();
        while (rs.next()) {
            Time horarioDeTrabalhoInicio = Time.valueOf(rs.getString("horario_trabalho_inicio"));
            Time horarioDeTrabalhoFinal = Time.valueOf(rs.getString("horario_trabalho_final"));

            // Verifica se o horário fornecido está dentro do horário de trabalho do médico
            if (horarioDeTrabalhoInicio.before(horario) && horarioDeTrabalhoFinal.after(horario)) {
                Medico medico = new Medico();

                medico.setNome(rs.getString("nome"));
                medico.setCpf(rs.getString("cpf"));
                medico.setTelefone(rs.getString("telefone"));
                medico.setCrm(rs.getString("crm"));
                medico.setEspecialidade(rs.getString("especialidade"));
                medico.setSalario(rs.getDouble("salario"));
                medico.setPlantao(rs.getBoolean("plantao"));
                medico.setSexo(rs.getBoolean("sexo"));

                String dataNascStr = rs.getString("data_nascimento");
                Date dataNasc = Date.valueOf(dataNascStr);
                medico.setDataNasc(dataNasc);

                String dataAdmissaoStr = rs.getString("data_admissao");
                Date dataAdmissao = Date.valueOf(dataAdmissaoStr);
                medico.setDataDeAdmissao(dataAdmissao);

                String horarioInicioStr = rs.getString("horario_trabalho_inicio");
                Time horarioInicio = Time.valueOf(horarioInicioStr);
                medico.setHorarioDeTrabalhoInicio(horarioInicio);

                String horarioFinalStr = rs.getString("horario_trabalho_final");
                Time horarioFinal = Time.valueOf(horarioFinalStr);
                medico.setHorarioDeTrabalhoFinal(horarioFinal);

                medicos.add(medico);
            }
        }
        return medicos;
    }
}