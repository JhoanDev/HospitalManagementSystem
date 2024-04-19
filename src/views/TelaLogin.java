package src.views;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import src.controllers.AdministradorDao;
import src.data.Banco;
import src.models.Administrador;
import src.utils.FuncUtils;

public class TelaLogin {

    public static void loginScreen(Banco db)
            throws SQLException, NoSuchAlgorithmException, UnsupportedEncodingException {
        FuncUtils.clearScreen();
        while (true) {
            System.out.print("\nDigite seu login: ");
            String login = FuncUtils.readLogin();
            System.out.print("Digite sua senha: ");
            String senha = FuncUtils.readPassword();

            //encriptando para fazer a comparação
            senha = FuncUtils.encryptMD5(senha);

            Administrador administrador = AdministradorDao.buscaAdministrador(login, db);
            if (login.equals(administrador.getLogin()) && senha.equals(administrador.getSenha()))// tem erro na senha então por enquanto deixei assim
            {
                MenuInicial.initialMenu(db);
                return;
            } else {
                System.out.println("Login ou senha inválidos. Tente novamente.");
            }
        }
    }
}
