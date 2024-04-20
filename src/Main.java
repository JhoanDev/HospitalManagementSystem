package src;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

import src.controllers.ConsultaDao;
import src.data.Banco;
import src.utils.FuncUtils;
import src.views.TelaInicial;

public class Main {
    public static void main(String[] args) throws SQLException, NoSuchAlgorithmException, UnsupportedEncodingException {
        Banco db = new Banco();
        TelaInicial.homeScreen(db);
        db.disconnect();
        FuncUtils.fechaScanner();
    }
}