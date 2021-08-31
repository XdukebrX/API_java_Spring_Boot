package dao;

import java.sql.*;
import java.util.LinkedList;

import com.google.gson.Gson;

import aulas.classes.Aluno;
import aulas.utils.Conection;

public class Alunodao {
   
    public static String getAluno_byname(String name) {
        Connection c = Conection.connection();
       LinkedList<Aluno> la = new LinkedList<Aluno>();
        String sql = "SELECT * from users where name =?";
        try {
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setString(1, name);
            ResultSet rs = ps.executeQuery();
         
            while (rs.next()) {
				Aluno p = new Aluno(rs.getString("name"), rs.getString("email"), rs.getInt("id_users"));
               la.add(p);
		}
			c.close();
        
            
        } catch (Exception e) {

          System.out.println("CHAMA O BOPE QUE DEU MERDA !!");
          e.printStackTrace();
        }
        String Alunojson = new Gson().toJson(la);
        return Alunojson;
    }

    public static void postAluno  (Aluno a){
      Connection c =  Conection.connection();
      String sql = "INSERT INTO users (name, email) vaLues (?,?)";
      try {
        PreparedStatement ps = c.prepareStatement(sql);
        ps.setString(1, a.getName() );
        ps.setString(2, a.getEmail());
        ps.executeUpdate();
        c.close();
      } catch (Exception e) {
        System.err.println(e);
      }




    }



    
}
