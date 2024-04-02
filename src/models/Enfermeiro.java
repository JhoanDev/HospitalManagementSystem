package src.models;

import java.sql.Time;
import java.util.Date;

public class Enfermeiro extends Funcionario {
    private String coren;

    public Enfermeiro(String nome, String cpf, String telefone, Date dataNasc, boolean sexo, String codFunc,
            double salario, Date dataDeAdmissao, Time horarioDeTrabalhoInicio, Time horarioDeTrabalhoFinal,
            String coren) {
        super(nome, cpf, telefone, dataNasc, sexo, codFunc, salario, dataDeAdmissao, horarioDeTrabalhoInicio,
                horarioDeTrabalhoFinal);
        this.coren = coren;
    }

    public String getCoren() {
        return coren;
    }

    public void setCoren(String coren) {
        this.coren = coren;
    }

}
