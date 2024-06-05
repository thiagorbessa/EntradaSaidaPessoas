package com.br.entrada.saida.pessoas;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller //define a classe como classe controller
public class PessoaController {
	
	private static final ArrayList<Pessoa> LISTA_PESSOA = new ArrayList<>();//criar uma lista que vai armazenar 
	//todas as listas de pessoa

	//private static final Pessoa[] LISTA_PESSOA2 = new Pessoa[10];//esse era o antigo mas pela necessidade de 
	//ter que escolher a quantidade maximo o ArrayList é melhor
	
	static {//bloco estatico
		//Pessoa pessoa = new Pessoa();
		//pessoa.setId("1"); adiciona todas as funcoes
		//LISTA_PESSOA.add(pessoa)
		

		//Pessoa pessoa = new Pessoa("1","Thiago","4045","hc4","informatica",
		//"s1","funcionario","");//outra forma
		
		LISTA_PESSOA.add(new Pessoa("1","Thiago","4045","hc4","informatica",
				"s1","funcionario",""));//forma mais direta
		LISTA_PESSOA.add(new Pessoa("2","Diego","4045","hc4","informatica",
				"s1","funcionario",""));//forma mais direta
		LISTA_PESSOA.add(new Pessoa("3","Matheus","4045","hc4","informatica",
				"s1","funcionario",""));//forma mais direta
		LISTA_PESSOA.add(new Pessoa("4","Guttemberg","4045","hc4","informatica",
				"s1","funcionario",""));//forma mais direta
		LISTA_PESSOA.add(new Pessoa("5","Marcio","4045","hc4","informatica",
				"s1","funcionario",""));//forma mais direta
		
		
	}
	
	@GetMapping("/")//voce esta indicando se voce digitar somente localhost8080 
	public String index() {//ele vai procurar em resourses> template  o return sinalizado
		return "index";//coloca o nome do arquivo
	}
	
	@GetMapping("/pessoas")//voce esta indicando se voce digitar somente localhost:8080/contatos 
	public ModelAndView listar() {//ele vai procurar em resourses> template  o return sinalizado
		ModelAndView modelAndView = new ModelAndView("listar");//adiciona o html de retorno
		//retorna um modelo de visualizacao
		//adiciona um objeto
		modelAndView.addObject("pessoas",LISTA_PESSOA);// pessoas é a referencia que faz a lista que voce esta passando
		return modelAndView;//coloca o nome do arquivo
	}
	
	//@GetMapping("/pessoas/novo")//voce esta indicando se voce digitar somente localhost:8080/pessoas/novo
	// public String novo() {//ele vai procurar em resourses> template  o return sinalizado
	//	return "formulario";//coloca o nome do arquivo
	//esse metodo nao pode ser pois precisa retornar algo para <form th:action="${pessoa.novo} ? @{/pessoas} : @{/pessoas/{pessoa}(pessoa=${pessoa.id})}" 
	//th:object="${pessoa}" th:method="${contato.novo} ? post : put">
	@GetMapping("/pessoas/novo")//aqui voce esta indicando se voce digitar somente localhost:8080/pessoas/novo
	public ModelAndView novo() {//então, como o metodo acima de lsitar, deverá ser retornado algo
		ModelAndView modelAndView = new ModelAndView("formulario");//aqui o nome do arquivo html
		modelAndView.addObject("pessoas",new Pessoa());//aqui voce adiciona uma instancia de Pessoa
		return modelAndView;
	}
	
	@GetMapping("/formularioSaida")//voce esta indicando se voce digitar somente localhost:8080/contatos 
	public String formularioSAida() {//ele vai procurar em resourses> template  o return sinalizado
		return "formularioSaida";//coloca o nome do arquivo
	}
}
