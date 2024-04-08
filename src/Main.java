package src;
import src.data.Banco;

public class Main {
    public static void main(String[] args) {
        System.out.println("Sistema de Gerenciamento de Hospital");
        Banco bd = new Banco();
        System.out.println(bd);
        bd.querry_insup("INSERT INTO Paciente(cpf,telefone,data_nascimento,sexo,internado,plano_saude) VALUES (213821,18234701,2002-08-06,1,0,1)");
        bd.desconect();
    }
}