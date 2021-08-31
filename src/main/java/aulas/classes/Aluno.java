package aulas.classes;

public class Aluno {
    private String name, email;
    private int id;

    public String getEmail() {
        return email;
    }

    public int getId() {
        return id;
    }

   
     public String getName() {
        return name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Aluno (String name_, String email_, int id_){
       setName(name_);
       setEmail(email_);
       setId(id_);
    }


    
}
