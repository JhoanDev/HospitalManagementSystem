package src;

import src.utils.*;
import src.models.Medico;
import src.controllers.MedicoDao;
import java.sql.Date;
import java.sql.Time;

public class DemoMedico {

    public static void main(String[] args) {
        FuncUtils.clearScreen();
        MedicoDao medicoDao = new MedicoDao();
        Date dataNasc = Date.valueOf("1990-01-01");
        Date dataAdmissao = Date.valueOf("2021-01-01");
        Time horarioInicio = Time.valueOf("08:00:00");
        Time horarioFinal = Time.valueOf("18:00:00");
        Medico medico = new Medico("João", "123.456.789-00", "1234-5678", dataNasc, true, "123",
                10000.0, dataAdmissao, horarioInicio, horarioFinal, "123456", "Cardiologista", true);
        medicoDao.cadastrarMedico(medico);
        medicoDao.fech();
    }

}
