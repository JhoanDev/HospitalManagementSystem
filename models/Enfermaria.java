package models;

public class Enfermaria {
    private String codEnfermaria;
    private int qtdeLeitos;
    
    public Enfermaria(String codEnfermaria, int qtdeLeitos) {
        this.codEnfermaria = codEnfermaria;
        this.qtdeLeitos = qtdeLeitos;
    }

    public String getCodEnfermaria() {
        return codEnfermaria;
    }

    public void setCodEnfermaria(String codEnfermaria) {
        this.codEnfermaria = codEnfermaria;
    }

    public int getQtdeLeitos() {
        return qtdeLeitos;
    }

    public void setQtdeLeitos(int qtdeLeitos) {
        this.qtdeLeitos = qtdeLeitos;
    }
    
}
