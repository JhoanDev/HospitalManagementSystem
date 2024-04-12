package src.controllers;

import src.data.Banco;
import src.models.Medico;

public class MedicoDao {
    Banco db;

    public MedicoDao() {
        db = new Banco();
    }

    public void cadastrarMedico(Medico medico) {
        String query = String.format(
                "INSERT INTO Medico (nome, cpf, telefone, data_nascimento, sexo, salario, dataDeAdmissao, horarioDeTrabalhoInicio, horarioDeTrabalhoFinal, bonus, crm, especialidade, plantao) VALUES ('%s', '%s', '%s', '%tF', %b, %.2f, '%tF', '%tT', '%tT', %.2f, '%s', '%s', %b);",
                medico.getNome(), medico.getCpf(), medico.getTelefone(), medico.getDataNasc(),
                medico.isSexo(), medico.getSalario(), medico.getDataDeAdmissao(),
                medico.getHorarioDeTrabalhoInicio(), medico.getHorarioDeTrabalhoFinal(), medico.getBonus(),
                medico.getCrm(), medico.getEspecialidade(), medico.isPlantao());
        db.querry_insup(query);
    }
    

    public void fech() {
        db.desconect();
    }
}
