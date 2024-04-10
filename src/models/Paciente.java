package src.models;

import java.sql.Date;

public class Paciente extends Pessoa {
    private String codPaciente;
    private boolean internado;
    private boolean planoDeSaude;

    public Paciente(){
        super("", "", "", new Date(System.currentTimeMillis()), true);
        this.codPaciente = "";
        this.internado = false;
        this.planoDeSaude = false;
    }
    
    public Paciente(String nome, String cpf, String telefone, Date dataNasc, boolean sexo, String codPaciente,
            boolean internado, boolean planoDeSaude) {
        super(nome, cpf, telefone, dataNasc, sexo);
        this.codPaciente = codPaciente;
        this.internado = internado;
        this.planoDeSaude = planoDeSaude;
    }

    public String getCodPaciente() {
        return codPaciente;
    }

    public void setCodPaciente(String codPaciente) {
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

    public void editarPaciente(){
        System.out.println(this.toString());
        System.out.println("O que deseja editar?");
        System.out.println("[1] - Nome");
        System.out.println("[2] - CPF");
        System.out.println("[3] - Telefone");
        System.out.println("[4] - Data de nascimento");
        System.out.println("[5] - Sexo");
        System.out.println("[6] - Internado");
        System.out.println("[7] - Plano de saúde");
        System.out.println("[8] - Cancelar");
        int opcao = FuncUtils.readInt();
        switch (opcao) {
            case 1:
                System.out.println("Digite o novo nome: ");
                this.setNome(FuncUtils.readOnlyLettersAndSpaces());
                break;
            case 2:
                System.out.println("Digite o novo CPF: ");
                this.setCpf(FuncUtils.readCPF());
                break;
            case 3:
                System.out.println("Digite o novo telefone: ");
                this.setTelefone(FuncUtils.readPhoneNumber());
                break;
            case 4:
                System.out.println("Digite a nova data de nascimento: ");
                this.setDataNasc(FuncUtils.readDate());
                break;
            case 5:
                System.out.println("Digite o novo sexo: ");
                this.setSexo(FuncUtils.readSex());
                break;
            case 6:
                System.out.println("Digite se está internado: ");
                this.setInternado(FuncUtils.readHospitalized());
                break;
            case 7:
                System.out.println("Digite se possui plano de saúde: ");
                this.setPlanoDeSaude(FuncUtils.readHealthPlan());
                break;
            case 8:
                break;
            default:
                System.out.println("Opção inválida");
                break;
        }
    }
}
