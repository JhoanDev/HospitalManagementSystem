package src.views;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

import src.controllers.AdministradorDao;
import src.data.Banco;
import src.models.Administrador;
import src.utils.FuncUtils;

public class TelaLogin {

    public static void loginScreen(Banco db) throws SQLException, NoSuchAlgorithmException, UnsupportedEncodingException {
        while (true) {
            System.out.println("\nDigite seu login: ");
            String login = FuncUtils.readOnlyLettersAndSpaces();
            System.out.println("Digite sua senha: ");
            String senha = FuncUtils.readPassword();
            Administrador administrador = AdministradorDao.buscaAdministrador(login, db);
            if (administrador.getSenha() == senha) {
                System.out.println("Login efetuado com sucesso!");
                return;
            } else {
                System.out.println("Login ou senha inválidos. Tente novamente.");
            }
        }
    }
}
