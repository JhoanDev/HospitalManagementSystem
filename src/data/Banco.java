package src.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Banco { //nao funciona ainda
    public Connection db = null;
    public Statement statement = null;
    
    public Banco(){
        try{
            this.db = DriverManager.getConnection("jdbc:sqlite:data.db");
            this.statement = db.createStatement();
            statement.setQueryTimeout(30);  // Espera só por 30 segundos para conectar     
        }catch (SQLException e){
            System.out.println("Erro na conexão");
            System.out.println(e);
        }
    }

    public void desconect(){
        try {
            if(db != null){
              db.close();
            }
          } catch(SQLException e) {
            System.out.println("Erro na hora de fechar conexão");
            System.out.println(e);
          }
    }


    public void querry_insup(String querry){
        try{
            statement.executeUpdate(querry);
        }catch(SQLException e){
            System.out.println("Erro na querry");
            System.out.println(e);
        }
    }

    public ResultSet querry_busca(String querry_busca){
        ResultSet rs = null;
        try{
            rs = statement.executeQuery(querry_busca);
            return rs;
        }catch (SQLException e){
            System.out.println("Erro na querry");
            System.out.println(e);
            return rs;
        }
    }
}
