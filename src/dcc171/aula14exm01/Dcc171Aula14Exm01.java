
package dcc171.aula14exm01;

import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Dcc171Aula14Exm01 {    
    private static Connection connection = null;
    private static String driverURL = "jdbc:derby://localhost:1527/2017-dcc171";
    
    public static void inserirProdutos() throws SQLException{
        Scanner entrada = new Scanner(System.in);
        String Nome;
        Integer qtd;
        
        System.out.println("Insira o Nome: ");
        Nome = entrada.nextLine();
        System.out.println("Insira a Quantidade: ");
        qtd = entrada.nextInt();

        Statement statement;
        statement = connection.createStatement();
        statement.executeUpdate("insert into PRODUTO(NOME, QTD, ATUALIZADO) VALUES ('" + Nome + "', " + qtd + ", CURRENT_TIMESTAMP)");
            
    }
    
    public static void inserirPessoas() throws SQLException{
        Scanner entrada = new Scanner(System.in);
        String Nome;
        Integer idade;
        
        System.out.println("Conexão realizada com sucesso!");

        System.out.println("Insira o Nome: ");
        Nome = entrada.nextLine();
        System.out.println("Insira a Idade: ");
        idade = entrada.nextInt();

        Statement statement;
        statement = connection.createStatement();
        statement.executeUpdate("insert into PESSOA(NOME, IDADE) VALUES ('" + Nome + "', " + idade + ")");            
    }
    
    public static void main(String[] args) {
        try {
            //Carrega driver
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            System.out.println("Driver carregado com sucesso!");
            
            //Conecta no banco
            connection = DriverManager.getConnection(driverURL, "usuario", "12345");
            
            Scanner entrada = new Scanner(System.in);
            int cmd = -1;
            do{
                System.out.println("Ecolha uma opção(0 p/ sair): ");
                System.out.println("/t 1 - Insere Produto.");
                System.out.println("/t 2 - Insere Pessoa.");
                cmd = entrada.nextInt();
                
                switch(cmd){
                    case 1:
                        inserirProdutos();
                        break;
                    case 2:
                        inserirPessoas();
                        break;
                    default:
                }                
            } while(cmd != 0);
            
            
        } catch (Exception ex) {
            Logger.getLogger(Dcc171Aula14Exm01.class.getName()).log(Level.SEVERE, "Driver de banco não disponível!");
            Logger.getLogger(Dcc171Aula14Exm01.class.getName()).log(Level.SEVERE, null, ex);
        }
         
        /*Scanner entrada = new Scanner(System.in);
        String Nome;
        Integer idade;           

        System.out.println("Conexão realizada com sucesso!");

        System.out.println("Insira o Nome: ");
        Nome = entrada.nextLine();
        System.out.println("Insira a Idade: ");
        idade = entrada.nextInt();

        Statement statement = connection.createStatement();
        statement.executeUpdate("insert into PESSOA(NOME, IDADE) VALUES ('" + Nome + "', " + idade + ")");
        */
    }
    
}
