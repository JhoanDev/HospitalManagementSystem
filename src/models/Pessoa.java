package src.models;

//import java.util.Date;

public abstract class Pessoa {
    private String nome;
    private String cpf;
    private String telefone;
    private String dataNasc;
    private boolean sexo; // true = masculino, false = feminino

    public Pessoa(String nome, String cpf, String telefone, String dataNasc, boolean sexo) {
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.dataNasc = dataNasc;
        this.sexo = sexo;
    }
    public Pessoa(){
        
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getDataNasc() {
        return dataNasc;
    }

    public void setDataNasc(String dataNasc) {
        this.dataNasc = dataNasc;
    }

    public boolean isSexo() {
        return sexo;
    }

    public void setSexo(boolean sexo) {
        this.sexo = sexo;
    }

    public String getSexo() {
        return sexo ? "Masculino" : "Feminino";
    }

    public void setSexo(String sexo) {
        this.sexo = sexo.equals("M") ? true : false;
    }
}
