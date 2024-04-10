package src.controllers;

import java.sql.ResultSet;
import java.sql.SQLException;
import src.data.Banco;
import src.models.Paciente;

public class PacienteDao {

    public static void cadastrarPaciente(Paciente paciente, Banco db){
        String querry = String.format("INSERT INTO Paciente (cpf,telefone,data_nascimento,sexo,internado,plano_saude VALUES (%s,%s,%tD,%b,%b,%b);",
        paciente.getCpf(),paciente.getTelefone(),paciente.getDataNasc(),paciente.getSexo(),paciente.isInternado(),paciente.isPlanoDeSaude());
        db.querry_insup(querry);
    }
    

    public void atualizaPaciente(Paciente paciente, int id, Banco db){
        String querry = String.format("UPDATE Paciente SET cpf = %s ,telefone = %s ,data_nascimento = %tD ,sexo = %b,internado = %b, plano_saude = %b);",
        paciente.getCpf(),paciente.getTelefone(),paciente.getDataNasc(),paciente.getSexo(),paciente.isInternado(),paciente.isPlanoDeSaude());
        db.querry_insup(querry);
    }

    public Paciente buscaPaciente(int id, Banco db) throws SQLException{
        String querry = "SELECT * FROM Paciente WHERE id_paciente = " + id + ";";
        ResultSet rs = db.querry_busca(querry);
        Paciente paciente = new Paciente();

        paciente.setCpf(rs.getString("cpf"));
        paciente.setTelefone(rs.getString("telefone"));
        //paciente.setDataNasc(); o set retorna a merda de uma string e eu n faço ideia de como converter pra data ajeite ai cara de priquito
        paciente.setCodPaciente(rs.getString("id_paciente"));
        paciente.setSexo(rs.getBoolean("sexo"));
        paciente.setPlanoDeSaude(rs.getBoolean("plano_saude"));
        paciente.setInternado(rs.getBoolean("internado"));
        return paciente;
    }
}
