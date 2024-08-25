package BDD;

import java.sql.Connection; //Importa uma classe que permite que usemos comandos SQL para interagir com os dados
import java.sql.DriverManager; //Usado para obter uma conexão com um banco de dados específico usando uma URL, nome de usuário e senha.
import java.sql.ResultSet; //Importa a classe ResultSet, que representa o resultado de uma consulta SQL executada em um banco de dados. Um ResultSet é uma tabela de dados que contém os resultados, e você pode percorrê-lo linha por linha para acessar os dados retornados pela consulta.
import java.sql.SQLException; //Importa a classe SQLException que faz o tratamento de erros como problemas de conexão, erros SQL ou problemas para acessar dados.
import java.sql.Statement; //Importa a classe que Statement que permite que os comandos SELECT, ou comandos INSERT, UPDATE, e DELETE sejam usáveis.


public class BancoDeDados {
   public static void main(String[] args) {
      //Variáveis do tipo String
      String url = "jdbc:mysql://localhost:3306/moviedb";
      String username = "root";
      String password = "password";
      String query = "SELECT * FROM movies"; //Comando para pegar algo da tabela do Banco de Dados

      try {
         Connection connection = DriverManager.getConnection(url, username, password); //Estabelece uma conexão com o banco de dados usando a URL, o nome de usuário e a senha fornecidos.
         Statement statement = connection.createStatement(); //Cria um objeto Statement que será usado para enviar comandos SQL ao banco de dados.
         //OBS: Esse objeto Statement permite que você execute consultas e outras instruções SQL no banco de dados.

         ResultSet resultSet = statement.executeQuery(query); //Executa a consulta SQL (que está na variável query) e armazena o resultado em um objeto ResultSet.

         while(resultSet.next()) {//Move para a próxima linha do ResultSet. Retorna true se houver uma linha seguinte; caso contrário, retorna false, encerrando o loop.

            //Todos abaixo serão mostrados por causa do 'getString' e 'getInt'
            int id = resultSet.getInt("id");
            String title = resultSet.getString("title");
            int year = resultSet.getInt("year");
            String director = resultSet.getString("director");

            System.out.println(id+" "+title+" "+year+" "+director);
         }

         connection.close(); //Depois que o while não for mais verdadeiro, ele encerra a conexão
      } catch(SQLException erro) { //Se o erro for um do tipo "SQLException", ele captura e executa o "printStackTrace()"
         erro.printStackTrace();
      }
   }
}