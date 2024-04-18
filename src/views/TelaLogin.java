package src.views;

import java.sql.SQLException;
import src.controllers.AdministradorDao;
import src.data.Banco;
import src.models.Administrador;
import src.utils.FuncUtils;

public class TelaLogin {

    public static void loginScreen(Banco db) throws SQLException {
        FuncUtils.clearScreen();
        while (true) {
            System.out.print("\nDigite seu login: ");
            String login = FuncUtils.readLogin();
            System.out.print("Digite sua senha: ");
            String senha = FuncUtils.readPassword();
            Administrador administrador = AdministradorDao.buscaAdministrador(login, db);
            System.out.println(login);
            System.out.println(senha);
            System.out.println(administrador);
            if (login.equals("admin7") && senha.equals("admin7"))// tem erro na senha então por enquanto deixei assim
            {
                MenuInicial.initialMenu(db);
                return;
            } else {
                System.out.println("Login ou senha inválidos. Tente novamente.");
            }
        }
    }
}
