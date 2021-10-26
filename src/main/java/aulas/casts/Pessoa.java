package aulas.casts;

public abstract class Pessoa{
   private int id  ;
   private String name, email,cpf;

    
   public String getCpf() {
    return cpf;
   }

   public String getEmail() {
    return email;
   }

  public Integer getId() {
    return id;
  }


 public String getName() {
    return name;
 }
public void setCpf(String cpf) {
    this.cpf = cpf;
}



public void setEmail(String email) {
    this.email = email;
}

public void setId(Integer id) {
    this.id = id;
}

public void setName(String name) {
    this.name = name;
}
    
}
