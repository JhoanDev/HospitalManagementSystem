package models;

public class Paciente extends Pessoa{
    private String codPaciente;
    private boolean interado;
    private boolean planoDeSaude;

    public Paciente(String nome, String cpf, String telefone, String dataNasc, boolean sexo, String codPaciente, boolean interado, boolean planoDeSaude) {
        super(nome, cpf, telefone, dataNasc, sexo);
        this.codPaciente = codPaciente;
        this.interado = interado;
        this.planoDeSaude = planoDeSaude;
    }

    public String getCodPaciente() {
        return codPaciente;
    }

    public void setCodPaciente(String codPaciente) {
        this.codPaciente = codPaciente;
    }

    public boolean isInterado() {
        return interado;
    }

    public void setInterado(boolean interado) {
        this.interado = interado;
    }

    public boolean isPlanoDeSaude() {
        return planoDeSaude;
    }

    public void setPlanoDeSaude(boolean planoDeSaude) {
        this.planoDeSaude = planoDeSaude;
    }
}
