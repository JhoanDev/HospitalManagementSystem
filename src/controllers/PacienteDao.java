package src.controllers;

import java.sql.ResultSet;
import java.sql.SQLException;
import src.data.Banco;
import src.models.FuncUtils;
import src.models.Paciente;
import java.sql.Date;

public class PacienteDao {

    public static void cadastrarPaciente(Paciente paciente, Banco db) {
        String querry = String.format(
                "INSERT INTO Paciente (nome, cpf, telefone, data_nascimento, sexo, internado, plano_saude)VALUES ('%s', '%s', '%s', '%tF', %b, %b, %b);",
                paciente.getNome(), paciente.getCpf(), paciente.getTelefone(), paciente.getDataNasc(),
                paciente.getSexo(),
                paciente.isInternado(), paciente.isPlanoDeSaude());
        db.querry_insup(querry);
    }

    public static Paciente buscaPaciente(String codPaciente, Banco db) throws SQLException {
        String query = "SELECT * FROM Paciente WHERE id_paciente = '" + codPaciente + "';";
        ResultSet rs = db.querry_busca(query);
        Paciente paciente = new Paciente();

        if (rs.next()) {
            paciente.setNome(rs.getString("nome"));
            paciente.setCpf(rs.getString("cpf"));
            paciente.setTelefone(rs.getString("telefone"));

            String dataNascStr = rs.getString("data_nascimento");
            Date dataNasc = Date.valueOf(dataNascStr);
            paciente.setDataNasc(dataNasc);

            paciente.setCodPaciente(rs.getString("id_paciente"));
            paciente.setSexo(rs.getBoolean("sexo"));
            paciente.setPlanoDeSaude(rs.getBoolean("plano_saude"));
            paciente.setInternado(rs.getBoolean("internado"));
        }

        return paciente;
    }

    public static void atualizarPaciente(Paciente paciente, Banco db) {
        if (!paciente.editarPaciente())
            return;
        String querry = String.format(
                "UPDATE Paciente SET nome = '%s', cpf = '%s', telefone = '%s', data_nascimento = '%tF', sexo = %b, internado = %b, plano_saude = %b WHERE id_paciente = '%s';",
                paciente.getNome(), paciente.getCpf(), paciente.getTelefone(), paciente.getDataNasc(),
                paciente.getSexo(),
                paciente.isInternado(), paciente.isPlanoDeSaude(), paciente.getCodPaciente());
        db.querry_insup(querry);
    }

    public static void deletarPaciente(String codPaciente, Banco db) {
        String querry = "DELETE FROM Paciente WHERE id_paciente = '" + codPaciente + "';";
        db.querry_insup(querry);
    }

    public static void listarPacientes(Banco db) throws SQLException {
        String query = "SELECT * FROM Paciente;";
        ResultSet rs = db.querry_busca(query);

        // Imprimindo o cabeçalho
        System.out.printf("Nome%s CPF%s Telefone%s Nascimento%s Sexo%s Internado%s Plano de Saúde\n",
        FuncUtils.spacesGenerator(26), FuncUtils.spacesGenerator(9), FuncUtils.spacesGenerator(4), FuncUtils.spacesGenerator(2), FuncUtils.spacesGenerator(8), FuncUtils.spacesGenerator(6));
        // Imprimindo os registros
        while (rs.next()) {
            String nome = rs.getString("nome");
            String cpf = rs.getString("cpf");
            String telefone = rs.getString("telefone");
            String dataNascimento = rs.getString("data_nascimento");
            boolean sexo = rs.getBoolean("sexo");
            boolean internado = rs.getBoolean("internado");
            boolean planoSaude = rs.getBoolean("plano_saude");

            String sexoStr = sexo ? "Masculino" : "Feminino";
            String internadoStr = internado ? "Internado" : "Não internado";
            String planoSaudeStr = planoSaude ? "Possui plano de saúde" : "Não possui plano de saúde";

            // Imprimindo os registros com espaçamento fixo
            System.out.printf("%-30s %-12s %-12s %-12s %-12s %-15s %s\n", nome, cpf, telefone, dataNascimento, sexoStr,
                    internadoStr, planoSaudeStr);
        }
    }
}
