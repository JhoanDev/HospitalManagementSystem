package src;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Time;

import src.controllers.AdministradorDao;
import src.data.Banco;
import src.models.Administrador;
import src.utils.FuncUtils;
import src.views.TelaInicial;

public class Main {
    public static void main(String[] args) throws SQLException, NoSuchAlgorithmException, UnsupportedEncodingException {
        Banco db = new Banco();
        TelaInicial.homeScreen(db);
        db.disconnect();
    }
}