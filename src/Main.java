package src;
import src.data.Banco;

public class Main {
    public static void main(String[] args) {
        System.out.println("Sistema de Gerenciamento de Hospital");
        Banco bd = new Banco();
    
        bd.querry_insup("INSERT INTO Administrador (cpf,telefone, data_nascimento, sexo, salario, inicio_expediente, fim_expediente, login,senha) VALUES ('cpf_value', 'telefone_value', 'data_nascimento_value', 1,  1234, 'inicio_expediente_value', 'fim_expediente_value', 'login_value', 'senha_value')", bd.statement);
    }
}

