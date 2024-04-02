package src.models;

public class Internacao {
    private String dataInternacao;
    private String dataAlta = null;
    private Paciente pacienteInternado;
    private Enfermaria enfermariaInternacao;

    public Internacao(String dataInternacao, Paciente pacienteInternado, Enfermaria enfermariaInternacao) {
        this.dataInternacao = dataInternacao;
        this.pacienteInternado = pacienteInternado;
        this.enfermariaInternacao = enfermariaInternacao;
    }

    public String getDataInternacao() {
        return dataInternacao;
    }

    public void setDataInternacao(String dataInternacao) {
        this.dataInternacao = dataInternacao;
    }

    public String getDataAlta() {
        return dataAlta;
    }

    public void setDataAlta(String dataAlta) {
        this.dataAlta = dataAlta;
    }

    public Paciente getPacienteInternado() {
        return pacienteInternado;
    }

    public void setPacienteInternado(Paciente pacienteInternado) {
        this.pacienteInternado = pacienteInternado;
    }

    public Enfermaria getEnfermariaInternacao() {
        return enfermariaInternacao;
    }

    public void setEnfermariaInternacao(Enfermaria enfermariaInternacao) {
        this.enfermariaInternacao = enfermariaInternacao;
    }
}
