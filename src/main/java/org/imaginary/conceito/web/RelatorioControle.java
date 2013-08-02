package org.imaginary.conceito.web;


import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/relatorio")
public class RelatorioControle
{

	//url -> http://localhost:8080/relatorios/relatorio/contatos/lista.pdf?nomeRelatorio=contatos
	@RequestMapping("/pessoal")
	public ModelAndView montarRelatorio(HttpServletRequest request, 
			                    HttpServletResponse response,
			                    @RequestParam(value="nomeRelatorio",required=true)String nomeRelatorio) {
	
		String uri = request.getRequestURI();
		String format = uri.substring(uri.lastIndexOf(".") + 1);
		
	
		
		Map<String, Object> model =new HashMap<String, Object>();
		/*
		model.put("dtInicio", dtInicio);
		model.put("dtFim", dtFim);
		model.put("op", op);
		model.put("os", os);
		model.put("osa", osa);
		model.put("pesMat", pesMat);
		model.put("atividade", atv);
		*/
		
		String view = nomeRelatorio ;
		
		
		model.put("format", format);
		
		Locale locale = new Locale("pt", "BR");	
        
		//model.put(JRParameter.REPORT_LOCALE, locale);
	    
		return new ModelAndView(view, model);	
	}
}
