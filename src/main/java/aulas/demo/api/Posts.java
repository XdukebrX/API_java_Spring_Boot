package aulas.demo.api;


import dao.Alunodao;






import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import aulas.casts.Aluno;
import aulas.utils.ValidaCPF;

@RestController
@RequestMapping("/post")
public class Posts
{



    @ResponseBody
    @RequestMapping(value = "/aluno", method = RequestMethod.POST)   //indica o metodo da request e a url para acessala  
    public ResponseEntity <String> postAluno(@RequestBody Aluno json/**indica que o methodo ira receber dados tipo String **/) {
 
		

		Aluno a = json;// converte os dados recebidos via json para string e os coloca nas devidas variaveis
		

        if (!a.getName().isEmpty()  && !a.getEmail().isEmpty() && !a.getCpf().isEmpty() )  {//valida se ambas variaveis estao preenchidas de acordo
			
           if( ValidaCPF.isCPF(a.getCpf())==true){

            Alunodao.postAluno(a);
                System.out.println("PROCEDE ZERO MEIA");
           
           }else{
            System.out.println("NEGATIVO VINTE E DOIS");

           }
            
            return ResponseEntity.status(HttpStatus.CREATED).body("teu cu")  ;// retorna status 201 criado 
           
        }else{
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body("falta dados");// retorna status 204 sem conteudo
        }


    }





















    
}
