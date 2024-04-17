package src.controllers;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;

import src.data.Banco;
import src.models.Medico;
import src.utils.FuncUtils;
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
            System.out.println("Médico não encontrado.");
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

/*     public static void listarMedicos(Banco db) throws SQLException {
        String query = "SELECT * FROM Medico;";
        ResultSet rs = db.queryBusca(query);
    
        System.out.printf("|Cod%s|Nome%s|Sexo%s|Salário%s|CRM%s|Especialidade%s|Plantão\n",
                FuncUtils.spacesGenerator(4), FuncUtils.spacesGenerator(26), FuncUtils.spacesGenerator(9),
                FuncUtils.spacesGenerator(3),
                FuncUtils.spacesGenerator(12), FuncUtils.spacesGenerator(8));
    
        while (rs.next()) {
            String cod = rs.getString("id_medico");
            String nome = rs.getString("nome");
            boolean sexo = rs.getBoolean("sexo");
            double salario = rs.getDouble("salario");
            String crm = rs.getString("crm");
            String especialidade = rs.getString("especialidade");
            boolean plantao = rs.getBoolean("plantao");
    
            String sexoStr = sexo ? "Masculino" : "Feminino";
            String plantaoStr = plantao ? "Sim" : "Não";
    
            System.out.printf("|%-7s|%-30s|%-13s|%-10.2f|%-15s|%-21s|%s\n", cod, nome, sexoStr, salario, crm,
                    especialidade, plantaoStr);
        }
        
    } */
    
    public static void verificarMedicosDisponiveisEmAlgumHorario(Time horario, Banco db) throws SQLException {
        String query = "SELECT * FROM Medico";
        ResultSet rs = db.queryBusca(query);
        System.out.printf("|Cod%s|Nome%s|Sexo%s|Salário%s|CRM%s|Especialidade%s|Plantão\n",
        FuncUtils.spacesGenerator(4), FuncUtils.spacesGenerator(26), FuncUtils.spacesGenerator(9),
        FuncUtils.spacesGenerator(3),
        FuncUtils.spacesGenerator(12), FuncUtils.spacesGenerator(8));
        while (rs.next()) {
            Time horarioDeTrabalhoInicio = Time.valueOf(rs.getString("horario_trabalho_inicio"));
            Time horarioDeTrabalhoFinal = Time.valueOf(rs.getString("horario_trabalho_final"));
            
            // Verifica se o horário fornecido está dentro do horário de trabalho do médico
            if (horarioDeTrabalhoInicio.before(horario) && horarioDeTrabalhoFinal.after(horario)) {
                String cod = rs.getString("id_medico");
                String nome = rs.getString("nome");
                boolean sexo = rs.getBoolean("sexo");
                double salario = rs.getDouble("salario");
                String crm = rs.getString("crm");
                String especialidade = rs.getString("especialidade");
                boolean plantao = rs.getBoolean("plantao");
        
                String sexoStr = sexo ? "Masculino" : "Feminino";
                String plantaoStr = plantao ? "Sim" : "Não";
        
                System.out.printf("|%-7s|%-30s|%-13s|%-10.2f|%-15s|%-21s|%s\n", cod, nome, sexoStr, salario, crm,
                        especialidade, plantaoStr);
            }
        }
        
    }
}