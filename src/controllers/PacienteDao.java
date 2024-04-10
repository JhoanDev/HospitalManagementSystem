package src.controllers;

import java.sql.ResultSet;
import java.sql.SQLException;
import src.data.Banco;
import src.models.Paciente;

public class PacienteDao {
    private Banco db;

    public PacienteDao(){
        this.db = new Banco();
    }

    public void cadastrarPaciente(Paciente paciente){
        
        String querry = String.format("INSERT INTO Paciente (nome,cpf,telefone,data_nascimento,sexo,internado,plano_saude) VALUES ('%s','%s','%s','%s',%b,%b,%b);",
        paciente.getNome(),paciente.getCpf(),paciente.getTelefone(),paciente.getDataNasc(),paciente.getSexo(),paciente.isInternado(),paciente.isPlanoDeSaude());
        System.out.println("controle");
        System.out.println(querry);
        this.db.querry_insup(querry);
        
    }

    public void atualizaPaciente(Paciente paciente, int id){
        String querry = String.format("UPDATE Paciente SET cpf = %s ,telefone = %s ,data_nascimento = %tD ,sexo = %b,internado = %b, plano_saude = %b);",
        paciente.getCpf(),paciente.getTelefone(),paciente.getDataNasc(),paciente.isSexo(),paciente.isInternado(),paciente.isPlanoDeSaude());
        this.db.querry_insup(querry);
    }

    public Paciente buscaPaciente(int id) throws SQLException{
        String querry = "SELECT * FROM Paciente WHERE id_paciente = " + id + ";";
        ResultSet rs = this.db.querry_busca(querry);
        Paciente paciente = new Paciente();

        paciente.setCpf(rs.getString("cpf"));
        paciente.setTelefone(rs.getString("telefone"));
        //paciente.setDataNasc(); o set retorna uma string e eu n faço ideia de como converter pra data ajeite ai
        paciente.setCodPaciente(rs.getInt("id_paciente"));
        paciente.setSexo(rs.getBoolean("sexo"));
        paciente.setPlanoDeSaude(rs.getBoolean("plano_saude"));
        paciente.setInternado(rs.getBoolean("internado"));
        return paciente;
    }
}
