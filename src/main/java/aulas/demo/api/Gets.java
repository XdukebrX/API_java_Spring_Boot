package aulas.demo.api;

import dao.*;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/get")
public class Gets {
	
	
	public @RequestMapping(value = "/aluno", method = RequestMethod.GET,//especifica o caminho para a request e qual o metodo HTTP
	produces = MediaType.APPLICATION_JSON_VALUE) String getaluno(@RequestParam(value ="name" /** Indica que havera entrada de dados via url**/)
	String name/**indica que o methodo ira receber dados String **/)  {
		String la = Alunodao.getAluno_byname(name);/** solicita que seja verificado no banco resultados com o nome
													 informado ja retornando em formato JSON e os salva em uma variavel**/
		return la;// retorna o JSON para o usuario
	}

	public @RequestMapping(value = "/professor", method = RequestMethod.GET,
	produces = MediaType.APPLICATION_JSON_VALUE) String getprofessor(@RequestParam(value ="name" )String name)  {
		String la = Professordao.getProfessor_byname(name);/** solicita que seja verificado no banco resultados com o nome
													 informado ja retornando em formato JSON e os salva em uma variavel**/
		return la;// retorna o JSON para o usuario
	}


	

    
}
