package aulas.casts;



public class Aluno extends Pessoa {
   //não vo botar nada aqui ja q é bem obvio
    private Integer  r_n ;
    

    public Integer getR_n() {
        return r_n;
    }

 


    public void setR_n(Integer r_n) {
        this.r_n = r_n;
    }

  


    

    public Aluno (String name_, String email_, Integer id_, String cpf_, Integer r_n_){
       
       setName(name_);
       setEmail(email_);
       setId(id_);
       setCpf(cpf_);
       setR_n(r_n_);
    }


    
}
