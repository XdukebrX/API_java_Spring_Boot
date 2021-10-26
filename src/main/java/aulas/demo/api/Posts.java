package aulas.demo.api;



import dao.*;

import com.google.gson.*;

import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import aulas.casts.*;
import aulas.utils.ValidaCPF;

@RestController
@RequestMapping("/post")
public class Posts
{
    @ResponseBody
    @RequestMapping(value = "/aluno", method = RequestMethod.POST)   //indica o metodo da request e a url para acessala  
    public ResponseEntity <String> postAluno(@RequestBody String json/**indica que o methodo ira receber dados tipo String **/) {
 
		Gson gson = new Gson();//instancia a classe para converter o json para objeto 
	
		Aluno aln = gson.fromJson(json, Aluno.class);// converte os dados recebidos via json para string e os coloca nas devidas variaveis

        if (!aln.getName().isEmpty()  && !aln.getEmail().isEmpty() && ValidaCPF.isCPF(aln.getCpf())==true  )  {//valida  se as variaveis possuem valoer e se o cpf é valido
	           
            Alunodao.postAluno(aln);
                
            return ResponseEntity.status(HttpStatus.CREATED).body("criado com sucesso!!")  ;// retorna status 201 criado 
           
        }else{
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("falta dados ou CPF errado");// 
        }


    }

    @ResponseBody
    @RequestMapping(value = "/professor", method = RequestMethod.POST)   //indica o metodo da request e a url para acessala  
    public ResponseEntity <String> postProfessor(@RequestBody String json/**indica que o methodo ira receber dados tipo String **/) {
 
		Gson gson = new Gson();//instancia a classe para converter o json para objeto 
	
		Professor prof = gson.fromJson(json, Professor.class);// converte os dados recebidos via json para string e os coloca nas devidas variaveis

        if (!prof.getName().isEmpty()  && !prof.getEmail().isEmpty() && ValidaCPF.isCPF(prof.getCpf())==true  )  {//valida  se as variaveis possuem valoer e se o cpf é valido
	           
            Professordao.postProfessor(prof);
                
            return ResponseEntity.status(HttpStatus.CREATED).body("criado com sucesso!!")  ;// retorna status 201 criado 
           
        }else{
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("falta dados ou CPF errado");// 
        }

        
    }

    @ResponseBody
    @RequestMapping(value = "/materia", method = RequestMethod.POST)   //indica o metodo da request e a url para acessala  
    public ResponseEntity <String> postMateria(@RequestBody String aaaaa/**indica que o methodo ira receber dados tipo String **/) {
     
        System.out.println("**********JSON**********");
        System.out.println(aaaaa);
        System.out.println("***********************");
		Gson gson = new Gson();//instancia a classe para converter o json para objeto 
	
		Materia mat = gson.fromJson(aaaaa, Materia.class);// converte os dados recebidos via json para string e os coloca nas devidas variaveis

        if ( !mat.getName().isEmpty() && mat.getWorkload() !=0  )  {//valida  se as variaveis possuem valoer e se o cpf é valido
            System.out.println("***********************");
            System.out.println(mat.getId_materia());
            System.out.println(  mat.getId_professor() );
            System.out.println(  mat.getName() );
            System.out.println(  mat.getWorkload() );
            System.out.println("***********************");

            Materiadao.postMateria(mat);
                
            return ResponseEntity.status(HttpStatus.CREATED).body("criado com sucesso!!")  ;// retorna status 201 criado 
           
        }else{
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("falta dados ou CPF errado");// 
        }

        
    }





















    
}
