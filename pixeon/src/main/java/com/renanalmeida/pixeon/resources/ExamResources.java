package com.renanalmeida.pixeon.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.renanalmeida.pixeon.services.ExamServices;

@RestController
@RequestMapping(value="/exams")
public class ExamResources {
	
	@Autowired
	private ExamServices exames;
	
	@RequestMapping(value="/listar/{id}/{cnpj}",method=RequestMethod.GET)
	public Object listar(@PathVariable int id, @PathVariable String cnpj) {
		
		Object listaExames = exames.getExame(id, cnpj); 
		
		return listaExames;
	}
	@RequestMapping(value="/criarExame/{cnpjInstitution}/{patientName}/{patientAge}/{patientGender}/{physicianName}/{physicianCRM}/{procedureName}",method=RequestMethod.GET)
	public Object criarExame(@PathVariable String cnpjInstitution, @PathVariable String patientName, @PathVariable int patientAge, 
			              @PathVariable String patientGender,   @PathVariable String physicianName,
			              @PathVariable int physicianCRM, @PathVariable String procedureName) {
		
		Object exameId;
		
		exameId = exames.criarExame(cnpjInstitution, patientName, patientAge, patientGender, physicianName, physicianCRM, procedureName);
		
		return exameId;		
	}
	
	@RequestMapping(value="/criarInstituicao/{cnpj}/{name}",method=RequestMethod.GET)
	public Object criarInstituicao(@PathVariable String cnpj, @PathVariable String name) {
		
		exames.inserirInstituicao(cnpj, name);
		
		return "Instituição criada";
	}
	
	@RequestMapping(value="/buscar/{id}/{cnpj}",method=RequestMethod.GET)
	public Object criarInstituicao(@PathVariable int id, @PathVariable String cnpj) {
		
		Object listaExames = exames.getExame(id, cnpj); 
		
		return listaExames;
	}
}
