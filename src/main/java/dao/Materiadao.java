package dao;


import java.sql.*;

import java.util.LinkedList;

import com.google.gson.Gson;

import aulas.casts.Materia;
import aulas.utils.Conection;

public class Materiadao {


    public static String getMateria_byname /**  indica que o methodo pode ser chamado sem instanciar a classe a que ele pertence **/ (String name/** indica que o methodo ira receber uma String para pesquisa**/) {
        Connection c = Conection.connection();//instancia a classe para conexao do banco de dados
        LinkedList<Materia> la = new LinkedList<Materia>();// cria um vetor semi infinito de Materias
        String sql;
         if (name.isEmpty()){
            
            sql = "SELECT * from subjects";
         }else{
           sql = "SELECT * from subjects where name =?";//seta em uma String a querry a ser feita e define rotulo
         }
 
          
         try { // tenta essa merda e se não joga o erro pro catch que nos retorna a jagonça 
           
             PreparedStatement ps = c.prepareStatement(sql);// prepara a querry para ser enviada ao banco
             System.out.println(sql);
             ps.setString(1, name); // troca o 1 rotulo por seu valor verdadeiro enviado quando o methodo foi chamado
             ResultSet rs = ps.executeQuery();// executa a pesquisa e insere o retorno na variavel 
          
             while (rs.next()) {// fica rodando o while enquanto houver um proximo valor no vetor
 
                     Materia p = new Materia(rs.getInt("idsubjects"), rs.getInt("workload"), rs.getInt("id_teacher"),rs.getString("name"));/**pega os valores relacionados a cada coluna especificada e 
                                                                                                                                                                          os insere em uma instacia da classe Materia a cada iteração do while*/
                la.add(p);//adiciona um objeto novo  e aumenta o tamanho do vetora cada iteração do while
         }
             c.close();//fecha a conexao com o banco para evitar problemas
         
             
         } catch (Exception e) { // pega qualquer erro fatal que tenha occorido durante o try e joga ele para o valor e
 
           System.out.println("CHAMA O BOPE QUE DEU MERDA !!");// comentario generico pra saber de onde saiu o exeption ja que tem uns 3
           e.printStackTrace();// mostra a porra do erro que deu no consolo
         }
         String Materiajson = new Gson().toJson(la); // converte os dados de uma string para um JSON
         return Materiajson;// retorna o JSON pra oque tenha chamado o metodo usar
     }
 
     public static void postMateria /**  indica que o methodo pode ser chamado sem instanciar a classe a que ele pertence **/ (Materia a/** indica que o methodo ira receber um objeto do tipo Materia**/)
     {
       Connection c =  Conection.connection();//chama a conexao para o banco de dados
        
        System.out.println(a.getId_materia());
        System.out.println(  a.getId_professor() );
        System.out.println(  a.getName() );
        System.out.println(  a.getWorkload() );


       String sql = " INSERT INTO subjects (name, workload, id_teachers ) values ('viado',3000,2)";/**seta em uma variavel string a querry a ser feita no
                                                                   banco e define os rotulos suponho eu para evitar SQL inject **/
            
       try {// tenta essa merda e se não joga o erro pro catch que nos retorna a jagonça 
         PreparedStatement ps = c.prepareStatement(sql);// prepara a querry para ser enviada ao banco
       //  ps.setString(1, a.getName());// troca o 1 rotulo por seu valor verdadeiro enviado quando o methodo foi chamado
      //   ps.setInt(2, a.getWorkload());//troca o 2 rotulo ...
      //   ps.setInt(3, a.getId_professor());
         
         ps.executeUpdate();//executa a querry no banco
         c.close();//fecha a conexao com o banco para evitar problemas
       } catch (Exception e) {// pega qualquer erro fatal que tenha occorido durante o try e joga ele para o valor e
         System.err.println(e);// mostra a porra do erro que deu no consolo
       }
     }





    
}
