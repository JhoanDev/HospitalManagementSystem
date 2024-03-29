package models;

public class Prescricao {
    private String medicamento;
    private String dosagem; //pode ser em ml, mg e etc
    private String posologia;

    public Prescricao(String medicamento, String dosagem, String posologia) {
        this.medicamento = medicamento;
        this.dosagem = dosagem;
        this.posologia = posologia;
    }

    public String getMedicamento() {
        return medicamento;
    }

    public void setMedicamento(String medicamento) {
        this.medicamento = medicamento;
    }

    public String getDosagem() {
        return dosagem;
    }

    public void setDosagem(String dosagem) {
        this.dosagem = dosagem;
    }

    public String getPosologia() {
        return posologia;
    }

    public void setPosologia(String posologia) {
        this.posologia = posologia;
    }
}   