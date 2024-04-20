package src.controllers;

import src.data.Banco;
import src.models.Consulta;

public class ConsultaDao {
    public static void cadastrarConsulta(Consulta consulta, Banco db) {
        String sintomas = String.join(",", consulta.getSintomas());
        String query = String.format("INSERT INTO Consulta (data_consulta, hora_consulta, diagnostico, precisa_internar, encaminhamento, sintomas, id_paciente, id_medico) VALUES ('%tF', '%tT', '%s', '%s', '%s', '%s', '%d', '%s');",
                consulta.getDataConsulta(), consulta.getHorarioConsulta(), consulta.getDiagnostico(), consulta.isPrecisaInternar(), consulta.getEncaminhamento(), sintomas, Integer.parseInt(consulta.getIdPaciente()), consulta.getIdMedico());
        db.queryInsup(query);
    }
    
    
}
