package src.controllers;

import src.data.Banco;
import src.models.Consulta;

public class ConsultaDao {
    public static void cadastrarConsulta(Consulta consulta, Banco db) {
        String sintomas = String.join(",", consulta.getSintomas());
        String query = String.format("INSERT INTO Consulta (data_consulta, horario_consulta, diagnostico, precisa_internar, encaminhamento, sintomas) VALUES ('%s', '%s', '%s', '%s', '%s', '%s');",
                consulta.getDataConsulta(), consulta.getHorarioConsulta(), consulta.getDiagnostico(), consulta.isPrecisaInternar(), consulta.getEncaminhamento(), sintomas);
        db.queryInsup(query);
    }
    
    
}
