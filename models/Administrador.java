package models;

public class Administrador extends Funcionario {

    public Administrador(String nome, String cpf, String telefone, String dataNasc, boolean sexo, String codFunc, double salario, String dataDeAdmissao, String horarioDeTrabalhoInicio, String horarioDeTrabalhoFinal) {
        super(nome, cpf, telefone, dataNasc, sexo, codFunc, salario, dataDeAdmissao, horarioDeTrabalhoInicio, horarioDeTrabalhoFinal);
    }
}
