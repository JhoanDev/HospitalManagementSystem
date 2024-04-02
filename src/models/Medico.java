package src.models;

import java.util.ArrayList;

public class Medico extends Funcionario{
    private String crm;
    private String especialidade;
    private boolean plantao;
    private ArrayList<Consulta> consultasRealizadas;

    public Medico(String nome, String cpf, String telefone, String dataNasc, boolean sexo, String codFunc, double salario, String dataDeAdmissao, String horarioDeTrabalhoInicio, String horarioDeTrabalhoFinal, String crm, String especialidade, boolean plantao) {
        super(nome, cpf, telefone, dataNasc, sexo, codFunc, salario, dataDeAdmissao, horarioDeTrabalhoInicio, horarioDeTrabalhoFinal);
        this.crm = crm;
        this.especialidade = especialidade;
        this.plantao = plantao;
        this.consultasRealizadas = new ArrayList<>();
    }
    
    public String getCrm() {
        return crm;
    }

    public void setCrm(String crm) {
        this.crm = crm;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public boolean isPlantao() {
        return plantao;
    }

    public void setPlantao(boolean plantao) {
        this.plantao = plantao;
    }

    public ArrayList<Consulta> getConsultasRealizadas() {
        return consultasRealizadas;
    } 

    public void setConsultasRealizadas(ArrayList<Consulta> consultasRealizadas) {
        this.consultasRealizadas = consultasRealizadas;
    }
    
}
