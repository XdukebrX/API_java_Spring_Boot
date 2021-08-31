package aulas.demo.api;


import dao.Alunodao;



import org.springframework.http.MediaType;

import com.google.gson.Gson;

import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import aulas.classes.Aluno;


@RestController

public class Gets {
	
	
	
	public @RequestMapping(value = "/get/aluno", method = RequestMethod.GET,
	produces = MediaType.APPLICATION_JSON_VALUE) String start(@RequestParam(value ="name" /** Indica que havera entrada de dados via url**/)
	String name/**indica que o methodo ira receber dados String **/)  {
		String la = Alunodao.getAluno_byname(name);/** solicita que seja verificado no banco resultados com o nome
													 informado ja retornando em formato JSON e os salva em uma variavel**/
		return la;// retorna o JSON para o usuario
	}

    @RequestMapping(value = "/post/aluno", method = RequestMethod.POST)   //indica o metodo da request e a url para acessala  
    public ResponseEntity <String> postAluno(@RequestBody String json/**indica que o methodo ira receber dados tipo String **/) {
 
		Gson gson = new Gson();//instancia a classe para converter o json para objeto 

		Aluno a = gson.fromJson(json, Aluno.class);// converte os dados recebidos via json para string e os coloca nas devidas variaveis
		

        if (!a.getName().isEmpty()  && !a.getEmail().isEmpty() )  {//valida se ambas variaveis estao preenchidas de acordo
			Alunodao.postAluno(a);

            return ResponseEntity.status(HttpStatus.CREATED).build();// retorna status 201 criado 
        }else{
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();// retorna status 204 sem conteudo
        }


    }

    
}
