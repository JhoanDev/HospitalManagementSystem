package src.models;

import java.sql.Date;
import java.sql.Time;

public abstract class Funcionario extends Pessoa {
    private double salario;
    private Date dataDeAdmissao;
    private Time horarioDeTrabalhoInicio;
    private Time horarioDeTrabalhoFinal;
    private double bonus;

    public Funcionario() {
        super();
    }

    // Construtor com bunus
    public Funcionario(String nome, String cpf, String telefone, Date dataNasc, boolean sexo,
            double salario, Date dataDeAdmissao, Time horarioDeTrabalhoInicio, Time horarioDeTrabalhoFinal,
            double bonus) {
        super(nome, cpf, telefone, dataNasc, sexo);
        this.salario = salario;
        this.dataDeAdmissao = dataDeAdmissao;
        this.horarioDeTrabalhoInicio = horarioDeTrabalhoInicio;
        this.horarioDeTrabalhoFinal = horarioDeTrabalhoFinal;
        this.bonus = bonus;
    }

    // Construtor sem bonus
    public Funcionario(String nome, String cpf, String telefone, Date dataNasc, boolean sexo,
            double salario, Date dataDeAdmissao, Time horarioDeTrabalhoInicio, Time horarioDeTrabalhoFinal) {
        super(nome, cpf, telefone, dataNasc, sexo);
        this.salario = salario;
        this.dataDeAdmissao = dataDeAdmissao;
        this.horarioDeTrabalhoInicio = horarioDeTrabalhoInicio;
        this.horarioDeTrabalhoFinal = horarioDeTrabalhoFinal;
        this.bonus = 1.0;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public Date getDataDeAdmissao() {
        return dataDeAdmissao;
    }

    public void setDataDeAdmissao(Date dataDeAdmissao) {
        this.dataDeAdmissao = dataDeAdmissao;
    }

    public Time getHorarioDeTrabalhoInicio() {
        return horarioDeTrabalhoInicio;
    }

    public void setHorarioDeTrabalhoInicio(Time horarioDeTrabalhoInicio) {
        this.horarioDeTrabalhoInicio = horarioDeTrabalhoInicio;
    }

    public Time getHorarioDeTrabalhoFinal() {
        return horarioDeTrabalhoFinal;
    }

    public void setHorarioDeTrabalhoFinal(Time horarioDeTrabalhoFinal) {
        this.horarioDeTrabalhoFinal = horarioDeTrabalhoFinal;
    }

    public double gerarSalarioAnual() {
        return (this.salario * this.bonus) * 12;
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

}