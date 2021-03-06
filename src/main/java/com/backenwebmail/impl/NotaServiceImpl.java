package com.backenwebmail.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backenwebmail.execiones.NotalecturaOrIdFound;
import com.backenwebmail.entity.Nota;
import com.backenwebmail.repository.NotaRepository;
import com.backenwebmail.service.NotaService;

import java.util.List;


@Service
public class NotaServiceImpl implements NotaService {

	@Autowired
	private NotaRepository notaRepository;
	
	
	@Override
	public boolean createNota(Nota nota) {
		try {
			notaRepository.save(nota);
			return true;
		} catch (Exception e) {
			return false;	
		}
	}

	
	@Override
	public Nota getNotaById(Long id) throws NotalecturaOrIdFound  {
			Nota nota = notaRepository.findById(id).orElseThrow(() -> new NotalecturaOrIdFound("no existe el id"));
		return nota;
	}
	
	

	@Override
	public Nota updateNota(Nota nota) throws NotalecturaOrIdFound {
		Nota toNota = getNotaById(nota.getId());
		mapNota(nota, toNota);
		notaRepository.save(toNota);
		return toNota;
	}

	@Override
	public List<Nota> getNotas() {
		return (List<Nota>) notaRepository.findAll();
	}


	protected void mapNota(Nota notaUse, Nota to) {
		to.setId(notaUse.getId());
		to.setTitulo(notaUse.getTitulo());
		to.setLectura(notaUse.getLectura());
	}
	

	
	
	
}
