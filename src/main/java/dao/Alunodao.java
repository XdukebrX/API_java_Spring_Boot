package dao;

import java.sql.*;

import java.util.LinkedList;

import com.google.gson.Gson;

import aulas.casts.Aluno;
import aulas.utils.Conection;

public class Alunodao {
   
    public static String getAluno_byname /**  indica que o methodo pode ser chamado sem instanciar a classe a que ele pertence **/ (String name/** indica que o methodo ira receber uma String para pesquisa**/) {
       Connection c = Conection.connection();//instancia a classe para conexao do banco de dados
       LinkedList<Aluno> la = new LinkedList<Aluno>();// cria um vetor semi infinito de alunos
       String sql;
        if (name.isEmpty()){
           sql = "SELECT * from students";
        }else{
          sql = "SELECT * from students where id_users =1";//seta em uma String a querry a ser feita e define rotulo
        }

         
        try { // tenta essa merda e se não joga o erro pro catch que nos retorna a jagonça 
          
            PreparedStatement ps = c.prepareStatement(sql);// prepara a querry para ser enviada ao banco
            System.out.println(sql);
            ps.setString(1, name); // troca o 1 rotulo por seu valor verdadeiro enviado quando o methodo foi chamado
            ResultSet rs = ps.executeQuery();// executa a pesquisa e insere o retorno na variavel 
         
            while (rs.next()) {// fica rodando o while enquanto houver um proximo valor no vetor

				    Aluno p = new Aluno(rs.getString("name"), rs.getString("email"), rs.getInt("id_users"),rs.getString("cpf"),rs.getInt("reg_number"));/**pega os valores relacionados a cada coluna especificada e 
                                                                                                                                                                         os insere em uma instacia da classe aluno a cada iteração do while*/
               la.add(p);//adiciona um objeto novo  e aumenta o tamanho do vetora cada iteração do while
		}
			c.close();//fecha a conexao com o banco para evitar problemas
        
            
        } catch (Exception e) { // pega qualquer erro fatal que tenha occorido durante o try e joga ele para o valor e

          System.out.println("CHAMA O BOPE QUE DEU MERDA !!");// comentario generico pra saber de onde saiu o exeption ja que tem uns 3
          e.printStackTrace();// mostra a porra do erro que deu no consolo
        }
        String Alunojson = new Gson().toJson(la); // converte os dados de uma string para um JSON
        return Alunojson;// retorna o JSON pra oque tenha chamado o metodo usar
    }

    public static void postAluno /**  indica que o methodo pode ser chamado sem instanciar a classe a que ele pertence **/ (Aluno a/** indica que o methodo ira receber um objeto do tipo aluno**/)
    {
      Connection c =  Conection.connection();//chama a conexao para o banco de dados
      String sql = "INSERT INTO students (name, email,cpf, reg_number ) values (?,?,?,?)";/**seta em uma variavel string a querry a ser feita no
                                                                  banco e define os rotulos suponho eu para evitar SQL inject **/

      try {// tenta essa merda e se não joga o erro pro catch que nos retorna a jagonça 
        PreparedStatement ps = c.prepareStatement(sql);// prepara a querry para ser enviada ao banco
        ps.setString(1, a.getName());// troca o 1 rotulo por seu valor verdadeiro enviado quando o methodo foi chamado
        ps.setString(2, a.getEmail());//troca o 2 rotulo ...
        ps.setString(3, a.getCpf());
        ps.setInt(4, a.getR_n());
        ps.executeUpdate();//executa a querry no banco
        c.close();//fecha a conexao com o banco para evitar problemas
      } catch (Exception e) {// pega qualquer erro fatal que tenha occorido durante o try e joga ele para o valor e
        System.err.println(e);// mostra a porra do erro que deu no consolo
      }
    }



    
}
