package src;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import java.sql.Date;
import java.sql.Time;
import src.controllers.ConsultaDao;
import src.data.Banco;
import src.models.Consulta;


public class Teste {
    public static void main(String[] args) {
        Banco db = new Banco();
        testeCadastroConsulta(db);

        db.disconnect();
    }

    public static void testeCadastroConsulta(Banco db) {
        Date dataConsulta = Date.valueOf("2024-04-19"); // Data da consulta
        Time horarioConsulta = Time.valueOf("10:00:00"); // Horário da consulta
        String diagnostico = "Dor de cabeça"; // Diagnóstico
        ArrayList<String> sintomas = new ArrayList<>();
        sintomas.add("febre");
        boolean precisaInternar = false; // Precisa internar?
        String encaminhamento = "Repouso"; // Encaminhamento
        String idPaciente = "1"; // ID do paciente
        String crmMedico = "CRM/RN 727374"; // CRM do médico
        ConsultaDao.cadastrarConsulta(new Consulta(dataConsulta, horarioConsulta, diagnostico, sintomas, precisaInternar, encaminhamento, crmMedico, idPaciente), db);
    }
}
