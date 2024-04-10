package src;

import java.sql.SQLException;

import src.controllers.PacienteDao;
import src.models.Paciente;


public class Main {
    public static void main(String[] args) throws SQLException {
        System.out.println("Sistema de Gerenciamento de Hospital");

        //testes----
        PacienteDao pacienteDao = new PacienteDao();
        Paciente paciente = new Paciente("Aujjkusto","132490854","0129312930","2022-08-06",true,false,true);
        pacienteDao.cadastrarPaciente(paciente);
    }


}

