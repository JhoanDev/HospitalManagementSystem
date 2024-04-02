package src.models;

public abstract class Funcionario extends Pessoa {
    private String codFunc;
    private double salario;
    private String dataDeAdmissao;
    private String horarioDeTrabalhoInicio;
    private String horarioDeTrabalhoFinal;

    public Funcionario(String nome, String cpf, String telefone, String dataNasc, boolean sexo, String codFunc, double salario, String dataDeAdmissao, String horarioDeTrabalhoInicio, String horarioDeTrabalhoFinal) {
        super(nome, cpf, telefone, dataNasc, sexo);
        this.codFunc = codFunc;
        this.salario = salario;
        this.dataDeAdmissao = dataDeAdmissao;
        this.horarioDeTrabalhoInicio = horarioDeTrabalhoInicio;
        this.horarioDeTrabalhoFinal = horarioDeTrabalhoFinal;
    }

    public String getCodFunc() {
        return codFunc;
    }

    public void setCodFunc(String codFunc) {
        this.codFunc = codFunc;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public String getDataDeAdmissao() {
        return dataDeAdmissao;
    }

    public void setDataDeAdmissao(String dataDeAdmissao) {
        this.dataDeAdmissao = dataDeAdmissao;
    }

    public String getHorarioDeTrabalhoInicio() {
        return horarioDeTrabalhoInicio;
    }

    public void setHorarioDeTrabalhoInicio(String horarioDeTrabalhoInicio) {
        this.horarioDeTrabalhoInicio = horarioDeTrabalhoInicio;
    }

    public String getHorarioDeTrabalhoFinal() {
        return horarioDeTrabalhoFinal;
    }

    public void setHorarioDeTrabalhoFinal(String horarioDeTrabalhoFinal) {
        this.horarioDeTrabalhoFinal = horarioDeTrabalhoFinal;
    }
}
