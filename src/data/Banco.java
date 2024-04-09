package src.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Banco { 
    public Connection db = null;
    public Statement statement = null;
    
    public Banco(){
        try{
            this.db = DriverManager.getConnection("jdbc:sqlite:src\\data\\data.db");
            this.statement = this.db.createStatement();
            statement.setQueryTimeout(30);  // Espera só por 30 segundos para conectar     
        }catch (SQLException e){
            System.out.println("Erro na conexão");
            System.out.println(e);
        }
    }

    public void desconect(Connection db){
        try {
            if(db != null){
              db.close();
            }
          } catch(SQLException e) {
            System.out.println("Erro na hora de fechar conexão");
            System.out.println(e);
          }
    }


    public void querry_insup(String querry, Statement statement){
        try{
            statement.executeUpdate(querry);
        }catch(SQLException e){
            System.out.println("Erro na querry");
            System.out.println(e);
        }
    }

    public ResultSet querry_busca(String querry_busca,Statement statement){
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

    public void testConnection(Statement statement) {
        try {
            ResultSet rs = statement.executeQuery("SELECT 1");
            if (rs.next()) {
                System.out.println("Conexão bem sucedida!");
            } else {
                System.out.println("Conexão falhou!");
            }
        } catch (SQLException e) {
            System.out.println("Erro na querry");
            System.out.println(e);
        }
    }
}
