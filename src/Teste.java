package src;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.sql.Date;
import java.sql.Time;

import src.controllers.AdministradorDao;
import src.controllers.ConsultaDao;
import src.data.Banco;
import src.models.Administrador;
import src.models.Consulta;


public class Teste {
    public static void main(String[] args) throws NoSuchAlgorithmException, UnsupportedEncodingException {
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
        String crmMedico = "CRM/RN 777777"; // CRM do médico
        ConsultaDao.cadastrarConsulta(new Consulta(dataConsulta, horarioConsulta, diagnostico, sintomas, precisaInternar, encaminhamento, crmMedico, idPaciente), db);
    }

    public static void testeCadastroAdministrador(Banco db) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        String login = "jotinha"; // Login
        String senha = "jotinha"; // Senha
        String nome = "Jhoan"; // Nome
        String cpf = "12345678900"; // CPF
        String telefone = "8434567890"; // Telefone
        Date dataNasc = Date.valueOf("1990-01-01"); // Data de nascimento
        boolean sexo = true; // Sexo (true para masculino, false para feminino)
        double salario = 15000.00; // Salário
        Date dataDeAdmissao = Date.valueOf("2020-01-01"); // Data de admissão
        Time horarioDeTrabalhoInicio = Time.valueOf("08:00:00"); // Início do expediente
        Time horarioDeTrabalhoFinal = Time.valueOf("17:00:00"); // Final do expediente
    
        // Realizar o cadastro do administrador
        AdministradorDao.cadastrarAdministrador(
                new Administrador(nome, cpf, telefone, dataNasc, sexo, salario, dataDeAdmissao,
                        horarioDeTrabalhoInicio, horarioDeTrabalhoFinal, login, senha),
                db);
    }
    
}
