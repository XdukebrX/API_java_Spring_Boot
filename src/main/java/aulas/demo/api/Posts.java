package aulas.demo.api;


import dao.Alunodao;




import com.google.gson.Gson;

import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import aulas.classes.Aluno;
import aulas.utils.ValidaCPF;

@RestController
@RequestMapping("/post")
public class Posts
{




    @RequestMapping(value = "/aluno", method = RequestMethod.POST)   //indica o metodo da request e a url para acessala  
    public ResponseEntity <String> postAluno(@RequestBody String json/**indica que o methodo ira receber dados tipo String **/) {
 
		Gson gson = new Gson();//instancia a classe para converter o json para objeto 

		Aluno a = gson.fromJson(json, Aluno.class);// converte os dados recebidos via json para string e os coloca nas devidas variaveis
		

        if (!a.getName().isEmpty()  && !a.getEmail().isEmpty() && !a.getCpf().isEmpty() )  {//valida se ambas variaveis estao preenchidas de acordo
			
           if( ValidaCPF.isCPF(a.getCpf())==true){

            Alunodao.postAluno(a);
                System.out.println("PROCEDE ZERO MEIA");
           
           }else{
            System.out.println("NEGATIVO VINTE E DOIS");

           }
            
            return ResponseEntity.status(HttpStatus.CREATED).build();// retorna status 201 criado 
        }else{
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body("adasdasdasdasd");// retorna status 204 sem conteudo
        }


    }





















    
}
