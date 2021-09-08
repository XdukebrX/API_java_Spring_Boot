package aulas.classes;



public class Aluno {
    private String name, email,cpf;//não vo botar nada aqui ja q é bem obvio
    private int id, r_n ;
    

    public int getR_n() {
        return r_n;
    }

 

    public String getCpf() {
        return cpf;
    }

    public String getEmail() {
        return email;
    }

    public int getId() {
        return id;
    }

   
     public String getName() {
        return name;
    }

    public void setR_n(int r_n) {
        this.r_n = r_n;
    }

  


    public void setCpf(String cpf) {
        this.cpf = cpf;
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

    public Aluno (String name_, String email_, int id_, String cpf_, int r_n_){
       setName(name_);
       setEmail(email_);
       setId(id_);
       setCpf(cpf_);
       setR_n(r_n_);
    }


    
}
