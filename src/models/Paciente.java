package src.models;

//import java.util.Date;

public class Paciente extends Pessoa {
    private int codPaciente;
    private boolean internado;
    private boolean planoDeSaude;

    public Paciente(String nome, String cpf, String telefone, String dataNasc, boolean sexo,
            boolean internado, boolean planoDeSaude) {
        super(nome, cpf, telefone, dataNasc, sexo);
        this.internado = internado;
        this.planoDeSaude = planoDeSaude;
    }
    
    public Paciente(){

    }

    public int getCodPaciente() {
        return codPaciente;
    }

    public void setCodPaciente(int codPaciente) {
        this.codPaciente = codPaciente;
    }

    public boolean isInternado() {
        return internado;
    }

    public void setInternado(boolean internado) {
        this.internado = internado;
    }

    public boolean isPlanoDeSaude() {
        return planoDeSaude;
    }

    public void setPlanoDeSaude(boolean planoDeSaude) {
        this.planoDeSaude = planoDeSaude;
    }

    public String getInterado() {
        if (internado) {
            return "Internado";
        } else {
            return "Não internado";
        }
    }

    public String getPlanoDeSaude() {
        if (planoDeSaude) {
            return "Possui plano de saúde";
        } else {
            return "Não possui plano de saúde";
        }
    }

    @Override
    public String toString() {
        String s = "";
        s += "Nome: " + getNome() + "\n";
        s += "CPF: " + getCpf() + "\n";
        s += "Telefone: " + getTelefone() + "\n";
        s += "Data de nascimento: " + getDataNasc() + "\n";
        s += "Sexo: " + getSexo() + "\n";
        s += "Internado: " + getInterado() + "\n";
        s += "Plano de saúde: " + getPlanoDeSaude() + "\n";
        return s;
    }
}
