package src.controllers;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;

import src.data.Banco;
import src.models.Enfermeiro;

public class EnfermeiroDao {

    public static void cadastrarEnfermeiro(Enfermeiro enfermeiro, Banco db) {
        String query = String.format(
                "INSERT INTO Enfermeiro (nome, cpf, telefone, data_nascimento, sexo, salario, data_admissao, horario_trabalho_inicio, horario_trabalho_final, coren )VALUES ('%s', '%s', '%s', '%tF', %b, '%.2f', '%tF', '%tT', '%tT', '%s');",
                enfermeiro.getNome(), enfermeiro.getCpf(), enfermeiro.getTelefone(), enfermeiro.getDataNasc(),
                enfermeiro.isSexo(), enfermeiro.getSalario(), enfermeiro.getDataDeAdmissao(),
                enfermeiro.getHorarioDeTrabalhoInicio(), enfermeiro.getHorarioDeTrabalhoFinal(),
                enfermeiro.getCoren());
        db.queryInsup(query);
    }

    public static Enfermeiro buscaEnfermeiro(String coren, Banco db) throws SQLException {
        String query = "SELECT * FROM Enfermeiro WHERE coren = '" + coren + "';";
        ResultSet rs = db.queryBusca(query);
        Enfermeiro enfermeiro = new Enfermeiro();

        if (rs.next() && rs != null) {
            enfermeiro.setNome(rs.getString("nome"));
            enfermeiro.setCpf(rs.getString("cpf"));
            enfermeiro.setTelefone(rs.getString("telefone"));
            enfermeiro.setSexo(rs.getBoolean("sexo"));
            String dataNascStr = rs.getString("data_nascimento");
            Date dataNasc = Date.valueOf(dataNascStr);
            enfermeiro.setDataNasc(dataNasc);

            enfermeiro.setSalario(rs.getDouble("salario"));

            String dataAdmissaoStr = rs.getString("data_admissao");
            Date dataAdmissao = Date.valueOf(dataAdmissaoStr);
            enfermeiro.setDataDeAdmissao(dataAdmissao);

            String horarioInicioStr = rs.getString("horario_trabalho_inicio");
            Time horarioInicio = Time.valueOf(horarioInicioStr);
            enfermeiro.setHorarioDeTrabalhoInicio(horarioInicio);

            String horarioFinalStr = rs.getString("horario_trabalho_final");
            Time horarioFinal = Time.valueOf(horarioFinalStr);
            enfermeiro.setHorarioDeTrabalhoFinal(horarioFinal);

            enfermeiro.setCoren(rs.getString("coren"));
        } else {
            System.out.println("Enfermeiro não encontrado.");
            return null;
        }

        return enfermeiro;
    }

    public static void editarEnfermeiro(Enfermeiro enfermeiro, Banco db) throws SQLException {
        String query = String.format(
                "UPDATE Enfermeiro SET nome = '%s', cpf = '%s', telefone = '%s', data_nascimento = '%tF', sexo = %b, salario = '%.2f', data_admissao = '%tF', horario_trabalho_inicio = '%tT', horario_trabalho_final = '%tT', coren = '%s' WHERE coren = '%s';",
                enfermeiro.getNome(), enfermeiro.getCpf(), enfermeiro.getTelefone(), enfermeiro.getDataNasc(),
                enfermeiro.isSexo(), enfermeiro.getSalario(), enfermeiro.getDataDeAdmissao(),
                enfermeiro.getHorarioDeTrabalhoInicio(), enfermeiro.getHorarioDeTrabalhoFinal(),
                enfermeiro.getCoren(), enfermeiro.getCoren());
        db.queryInsup(query);
    }

    public static void excluirEnfermeiro(Enfermeiro enfermeiro, Banco db) throws SQLException {
        if (enfermeiro != null) {
            String querry = "DELETE FROM Enfermeiro WHERE coren = '" + enfermeiro.getCoren() + "';";
            db.queryInsup(querry);
        }
    }

/*     public static void listarEnfermeiros(Banco db) throws SQLException {
        String query = "SELECT * FROM Enfermeiro;";
        ResultSet rs = db.queryBusca(query);

        System.out.printf("|Cod%s|Nome%s|Sexo%s|Salário%s|Coren%s|\n",
                FuncUtils.spacesGenerator(4), FuncUtils.spacesGenerator(26), FuncUtils.spacesGenerator(9),
                FuncUtils.spacesGenerator(3),
                FuncUtils.spacesGenerator(12), FuncUtils.spacesGenerator(8));

        while (rs.next()) {
            String cod = rs.getString("id_enfermeiro");
            String nome = rs.getString("nome");
            boolean sexo = rs.getBoolean("sexo");
            double salario = rs.getDouble("salario");
            String coren = rs.getString("coren");
            String sexoStr = sexo ? "Masculino" : "Feminino";

            System.out.printf("|%-7s|%-30s|%-13s|%-10.2f|%s\n", cod, nome, sexoStr, salario, coren);
        }
    } */
}
