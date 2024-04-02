package src.models;

public class Medicamento {
    private String codMedicamento;
    private String nomeMedicamento;

    public Medicamento(String codMedicamento, String nomeMedicamento) {
        this.codMedicamento = codMedicamento;
        this.nomeMedicamento = nomeMedicamento;
    }

    public String getCodMedicamento() {
        return codMedicamento;
    }

    public void setCodMedicamento(String codMedicamento) {
        this.codMedicamento = codMedicamento;
    }

    public String getNomeMedicamento() {
        return nomeMedicamento;
    }

    public void setNomeMedicamento(String nomeMedicamento) {
        this.nomeMedicamento = nomeMedicamento;
    }
    
}
