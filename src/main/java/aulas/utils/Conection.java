package aulas.utils;
import java.sql.*;

public class Conection {

	public Conection (){

	}
	    public static  Connection connection () {/**  indica que o retorno do metodo sera do tipo Connection 
											e permite chamar o mesmo sem instanciar a classe que ele pertence*/
		
		
		try {// tenta essa merda e se não joga o erro pro catch que nos retorna a jagonça 
	
			String myDriver = "org.mariadb.jdbc.Driver";// indica o triver a ser utilizado para determinado DB
			String myUrl = "jdbc:mariadb://localhost/api_spring_java";//salva em uma variavel o caminho para conectar no banco
			Class.forName(myDriver);//sinceramente não sei oque isso faz
			Connection c = DriverManager.getConnection(myUrl, "root", "");//aponta para o conector do db onde ele coencta e qual usuario/senha utilizar
			return c;
	   }  catch (Exception e)// pega qualquer erro fatal que tenha occorido durante o try e joga ele para o valor e
	   {
			System.err.println("VE SE O SERVIÇO DO SQL NÃO TA OF FILHO DA PUTA");//copypasta
			System.err.println(e.getMessage());// mostra o erro gerado no try no consolo
	   }
	   return null ;//tive q botar aqui mas confia q ele retorna o return dentro do try
	   
	 

	}
}