package src.models;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;

public class Consulta {
    private String codConsulta;
    private String idMedico;
    private String idPaciente;
    private Date dataConsulta;
    private Time horarioConsulta;
    private String diagnostico;
    private ArrayList<String> sintomas;
    private ArrayList<Prescricao> prescricoes;
    private boolean precisaInternar;

    public Consulta(String codConsulta, Date dataConsulta, Time horarioConsulta, String diagnostico,
            ArrayList<String> sintomas, boolean precisaInternar, String idMedico, String idPaciente) {
        this.codConsulta = codConsulta;
        this.dataConsulta = dataConsulta;
        this.horarioConsulta = horarioConsulta;
        this.diagnostico = diagnostico;
        this.sintomas = sintomas;
        this.precisaInternar = precisaInternar;
        this.idMedico = idMedico;
        this.idPaciente = idPaciente;
    }

    public Consulta(Date dataConsulta, Time horarioConsulta, String diagnostico,
            ArrayList<String> sintomas, boolean precisaInternar, String idMedico, String idPaciente) {
        this.dataConsulta = dataConsulta;
        this.horarioConsulta = horarioConsulta;
        this.diagnostico = diagnostico;
        this.sintomas = sintomas;
        this.precisaInternar = precisaInternar;
        this.idMedico = idMedico;
        this.idPaciente = idPaciente;
    }

    public Consulta() {

    }

    public String getCodConsulta() {
        return codConsulta;
    }

    public void setCodConsulta(String codConsulta) {
        this.codConsulta = codConsulta;
    }

    public String getIdMedico() {
        return idMedico;
    }

    public void setIdMedico(String idMedico) {
        this.idMedico = idMedico;
    }

    public String getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(String idPaciente) {
        this.idPaciente = idPaciente;
    }

    public Date getDataConsulta() {
        return dataConsulta;
    }

    public void setDataConsulta(Date dataConsulta) {
        this.dataConsulta = dataConsulta;
    }

    public Time getHorarioConsulta() {
        return horarioConsulta;
    }

    public void setHorarioConsulta(Time horarioConsulta) {
        this.horarioConsulta = horarioConsulta;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    public ArrayList<String> getSintomas() {
        return sintomas;
    }

    public void setSintomas(ArrayList<String> sintomas) {
        this.sintomas = sintomas;
    }

    public boolean isPrecisaInternar() {
        return precisaInternar;
    }

    public String getPrecisaInternar() {
        if (precisaInternar)
            return "Sim";
        return "Não";
    }

    public void setPrecisaInternar(boolean precisaInternar) {
        this.precisaInternar = precisaInternar;
    }

    public ArrayList<Prescricao> getPrescricoes() {
        return prescricoes;
    }

    public void setPrescricoes(ArrayList<Prescricao> prescricoes) {
        this.prescricoes = prescricoes;
    }

    @Override
    public String toString() {
        String s = "";
        s += "Código da consulta: " + codConsulta + "\n";
        s += "Data da consulta: " + dataConsulta + "\n";
        s += "Horário da consulta: " + horarioConsulta + "\n";
        s += "Diagnóstico: " + diagnostico + "\n";
        s += "Sintomas: ";
        for (String sintoma : sintomas)
            s += sintoma + ", ";
        s += "\n";
        s += "Precisa internar: " + getPrecisaInternar() + "\n";
        return s;
    }

}
