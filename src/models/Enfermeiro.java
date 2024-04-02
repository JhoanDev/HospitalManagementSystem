package src.models;

public class Enfermeiro extends Funcionario{
    private String coren;
    
    public Enfermeiro(String nome, String cpf, String telefone, String dataNasc, boolean sexo, String codFunc, double salario, String dataDeAdmissao, String horarioDeTrabalhoInicio, String horarioDeTrabalhoFinal, String coren) {
        super(nome, cpf, telefone, dataNasc, sexo, codFunc, salario, dataDeAdmissao, horarioDeTrabalhoInicio, horarioDeTrabalhoFinal);
        this.coren = coren;
    }

    public String getCoren() {
        return coren;
    }

    public void setCoren(String coren) {
        this.coren = coren;
    }
    
}
