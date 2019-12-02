package com.backenwebmail.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backenwebmail.execiones.NotalecturaOrIdFound;
import com.backenwebmail.modelo.Nota;
import com.backenwebmail.repository.NotaRepository;
import com.backenwebmail.service.NotaService;



@Service
public class NotaServiceImpl implements NotaService {

	@Autowired
	private NotaRepository notaRepository;
	
	
	@Override
	public void createNota(Nota nota) {
		//crea las tablas manualmente en la base de datos
	}

	
	
	@Override
	public Nota getNotaById(Long id) throws NotalecturaOrIdFound  {
			Nota nota = notaRepository.findById(id).orElseThrow(() -> new NotalecturaOrIdFound("no existe el id"));
		return nota;
	}
	
	

	@Override
	public String updateNota(Nota nota) throws NotalecturaOrIdFound {
		
		Nota toNota = getNotaById(nota.getId());
		mapNota(nota, toNota);
		notaRepository.save(toNota);
		
		return toNota.getLectura();
	}
	

	
	protected void mapNota(Nota notaUse, Nota to) {
		to.setId(notaUse.getId());
		to.setLectura(notaUse.getLectura());
	}
	

	
	
	
}
