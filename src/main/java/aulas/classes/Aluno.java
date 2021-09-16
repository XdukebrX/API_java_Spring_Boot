package aulas.classes;



public class Aluno {
    private String name, email,cpf;//não vo botar nada aqui ja q é bem obvio
    private Integer id, r_n ;
    

    public Integer getR_n() {
        return r_n;
    }

 

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

    public void setR_n(Integer r_n) {
        this.r_n = r_n;
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

    public Aluno (String name_, String email_, Integer id_, String cpf_, Integer r_n_){
       setName(name_);
       setEmail(email_);
       setId(id_);
       setCpf(cpf_);
       setR_n(r_n_);
    }


    
}
