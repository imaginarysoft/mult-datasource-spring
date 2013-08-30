package org.imaginary.conceito.web;

import java.util.HashMap;
import java.util.Map;

import org.imaginary.conceito.datasource.Pessoa;
import org.imaginary.conceito.datasource.PessoaGerencia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("/pessoa")
public class PessoaControle
{

	   
	@Autowired
	PessoaGerencia pessoaGerencia;
	
		@RequestMapping(value = "/ver/{id}", method = RequestMethod.GET)
		public ModelAndView ver(@PathVariable Integer id)
		{

			Map<String, Object> model = new HashMap<String, Object>();
			String view = "pessoa-ver";
			Boolean ok = false;

			Pessoa pes = pessoaGerencia.obterPessoa(id);
		
			
			
			model.put("PES", pes);
			
			
			return new ModelAndView(view, model);

		}
}
