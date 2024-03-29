package models;

import java.util.List;

public class Consulta {
    private String codConsulta;
    private String dataConsulta;
    private String horarioConsulta;
    private String diagnostico;
    private List<String> sintomas;
    private boolean precisaInternar;
    private String encaminhamento;

    public Consulta(String codConsulta, String dataConsulta, String horarioConsulta, String diagnostico, List<String> sintomas, boolean precisaInternar, String encaminhamento) {
        this.codConsulta = codConsulta;
        this.dataConsulta = dataConsulta;
        this.horarioConsulta = horarioConsulta;
        this.diagnostico = diagnostico;
        this.sintomas = sintomas;
        this.precisaInternar = precisaInternar;
        this.encaminhamento = encaminhamento;
    }

    public String getCodConsulta() {
        return codConsulta;
    }

    public void setCodConsulta(String codConsulta) {
        this.codConsulta = codConsulta;
    }

    public String getDataConsulta() {
        return dataConsulta;
    }

    public void setDataConsulta(String dataConsulta) {
        this.dataConsulta = dataConsulta;
    }

    public String getHorarioConsulta() {
        return horarioConsulta;
    }

    public void setHorarioConsulta(String horarioConsulta) {
        this.horarioConsulta = horarioConsulta;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    public List<String> getSintomas() {
        return sintomas;
    }

    public void setSintomas(List<String> sintomas) {
        this.sintomas = sintomas;
    }

    public boolean isPrecisaInternar() {
        return precisaInternar;
    }

    public void setPrecisaInternar(boolean precisaInternar) {
        this.precisaInternar = precisaInternar;
    }

    public String getEncaminhamento() {
        return encaminhamento;
    }

    public void setEncaminhamento(String encaminhamento) {
        this.encaminhamento = encaminhamento;
    }
}
