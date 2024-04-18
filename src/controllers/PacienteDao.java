package src.controllers;

import java.sql.ResultSet;
import java.sql.SQLException;
import src.data.Banco;
import src.models.Paciente;
import java.util.ArrayList;
import java.sql.Date;

public class PacienteDao {

    public static void cadastrarPaciente(Paciente paciente, Banco db) {
        String querry = String.format(
                "INSERT INTO Paciente (nome, cpf, telefone, data_nascimento, sexo, internado, plano_saude)VALUES ('%s', '%s', '%s', '%tF', %b, %b, %b);",
                paciente.getNome(), paciente.getCpf(), paciente.getTelefone(), paciente.getDataNasc(),
                paciente.isSexo(),
                paciente.isInternado(), paciente.isPlanoDeSaude());
        db.queryInsup(querry);
    }

    public static Paciente buscaPaciente(String codPaciente, Banco db) throws SQLException {
        String query = "SELECT * FROM Paciente WHERE id_paciente = '" + codPaciente + "';";
        ResultSet rs = db.queryBusca(query);
        Paciente paciente = new Paciente();

        if (rs.next() && rs != null) {
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
        } else {
            System.out.println("Paciente não encontrado.");
            return null;
        }
        return paciente;
    }

    public static void editarPaciente(Paciente paciente, Banco db) throws SQLException {
        String querry = String.format(
                "UPDATE Paciente SET nome = '%s', cpf = '%s', telefone = '%s', data_nascimento = '%tF', sexo = %b, internado = %b, plano_saude = %b WHERE id_paciente = '%s';",
                paciente.getNome(), paciente.getCpf(), paciente.getTelefone(), paciente.getDataNasc(),
                paciente.isSexo(),
                paciente.isInternado(), paciente.isPlanoDeSaude(), paciente.getCodPaciente());
        db.queryInsup(querry);
    }

    public static void excluirPaciente(Paciente paciente, Banco db) throws SQLException {
        if (paciente != null) {
            String querry = "DELETE FROM Paciente WHERE id_paciente = '" + paciente.getCodPaciente() + "';";
            db.queryInsup(querry);
        }
    }

    public static ArrayList<Paciente> listarPacientes(Banco db) throws SQLException {
        String query = "SELECT * FROM Paciente;";
        ResultSet rs = db.queryBusca(query);
        ArrayList<Paciente> pacientes = new ArrayList<Paciente>();

        while (rs.next()) {
            Paciente paciente = new Paciente();
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

            pacientes.add(paciente);
        }
        return pacientes;
    }

    public static void internar(Paciente paciente, Banco db) throws SQLException {
        if (paciente != null) {
            String querry = "UPDATE Paciente SET internado = 1 WHERE id_paciente = '" + paciente.getCodPaciente()
                    + "';";
            db.queryInsup(querry);
            System.out.println("\n" + paciente.getNome() + " foi internado.");
        }
    }

    public static void alta(Paciente paciente, Banco db) throws SQLException {
        if (paciente != null) {
            String querry = "UPDATE Paciente SET internado = 0 WHERE id_paciente = '" + paciente.getCodPaciente()
                    + "';";
            db.queryInsup(querry);
            System.out.println("\n" + paciente.getNome() + " recebeu alta.");
        }
    }
}
