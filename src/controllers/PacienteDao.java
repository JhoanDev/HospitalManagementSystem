package src.controllers;

import java.sql.ResultSet;
import java.sql.SQLException;
import src.data.Banco;
import src.models.FuncUtils;
import src.models.Paciente;
import java.sql.Date;

public class PacienteDao {

    public static void cadastrarPaciente(Banco db) {
        FuncUtils.clearScreen();
        Paciente paciente = new Paciente();
        paciente.preenchePaciente();
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
        if (paciente.getNome().length() < 3) {
            System.out.println("Paciente não encontrado.");
            return null;
        }
        return paciente;
    }

    public static void editarPaciente(Banco db) throws SQLException {
        listarPacientes(db);
        String codPaciente = FuncUtils.readCod();
        Paciente paciente = buscaPaciente(codPaciente, db);
        if (paciente.getNome().length() < 3) {
            System.out.println("Paciente não encontrado.");
            return;
        }

        FuncUtils.clearScreen();
        if (!paciente.editaPaciente())
            return;
        String querry = String.format(
                "UPDATE Paciente SET nome = '%s', cpf = '%s', telefone = '%s', data_nascimento = '%tF', sexo = %b, internado = %b, plano_saude = %b WHERE id_paciente = '%s';",
                paciente.getNome(), paciente.getCpf(), paciente.getTelefone(), paciente.getDataNasc(),
                paciente.getSexo(),
                paciente.isInternado(), paciente.isPlanoDeSaude(), paciente.getCodPaciente());
        db.querry_insup(querry);
    }

    public static void excluirPaciente(Banco db) throws SQLException {
        FuncUtils.clearScreen();
        listarPacientes(db);

        String codPaciente = FuncUtils.readCod();

        String querry = "DELETE FROM Paciente WHERE id_paciente = '" + codPaciente + "';";
        db.querry_insup(querry);
    }

    public static void listarPacientes(Banco db) throws SQLException {
        String query = "SELECT * FROM Paciente;";
        ResultSet rs = db.querry_busca(query);

        System.out.printf("Cod%s Nome%s CPF%s Telefone%s Nascimento%s Sexo%s Internado%s Plano de Saúde\n",
                FuncUtils.spacesGenerator(4), FuncUtils.spacesGenerator(26), FuncUtils.spacesGenerator(9),
                FuncUtils.spacesGenerator(4),
                FuncUtils.spacesGenerator(2), FuncUtils.spacesGenerator(8), FuncUtils.spacesGenerator(6));

        while (rs.next()) {
            String cod = rs.getString("id_paciente");
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

            System.out.printf("%-7s %-30s %-12s %-12s %-12s %-12s %-15s %s\n", cod, nome, cpf, telefone, dataNascimento,
                    sexoStr,
                    internadoStr, planoSaudeStr);
        }
    }

    public static void internar(Banco db) throws SQLException {
        listarPacientes(db);
        String codPaciente = FuncUtils.readCod();

        Paciente aux = buscaPaciente(codPaciente, db);
        if (aux.getNome().length() < 3) {
            System.out.println("Paciente não encontrado.");
            return;
        }
        String querry = "UPDATE Paciente SET internado = 1 WHERE id_paciente = '" + codPaciente + "';";
        db.querry_insup(querry);
        System.out.println("\n" + aux.getNome() + " foi internado.");
    }

    public static void alta(Banco db) throws SQLException {
        listarPacientes(db);
        String codPaciente = FuncUtils.readCod();

        Paciente aux = buscaPaciente(codPaciente, db);
        if (aux.getNome().length() < 3) {
            System.out.println("Paciente não encontrado.");
            return;
        }

        String querry = "UPDATE Paciente SET internado = 0 WHERE id_paciente = '" + codPaciente + "';";
        db.querry_insup(querry);
        System.out.println("\n" + aux.getNome() + " recebeu alta.");
    }
}
