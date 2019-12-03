package com.backenwebmail.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backenwebmail.execiones.NotalecturaOrIdFound;
import com.backenwebmail.modelo.Nota;
import com.backenwebmail.service.NotaService;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/publica")
public class NotaController {

	
	@Autowired
	NotaService notaService;
	
	
	@GetMapping("/nota/{id}")
	public Nota publicarNota(@PathVariable("id")Long id) throws NotalecturaOrIdFound {
		Nota notas = notaService.getNotaById(id);
		return notas;
	}
	
	@PostMapping("/editNota")
	public Nota postEditNota(@RequestBody Nota nota, BindingResult result ) throws NotalecturaOrIdFound {
		return notaService.updateNota(nota);
	}
	
	
	@PostMapping("/salveNota")
	public boolean postSaveNota(@RequestBody Nota nota, BindingResult result ) throws NotalecturaOrIdFound {
		return notaService.createNota(nota);
	}
	

	
}
