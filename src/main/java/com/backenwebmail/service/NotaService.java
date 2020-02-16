package com.backenwebmail.service;

import com.backenwebmail.execiones.NotalecturaOrIdFound;
import com.backenwebmail.modelo.entity.Nota;

public interface NotaService {

	
	public boolean createNota(Nota nota); 
	
	public Nota getNotaById(Long id) throws NotalecturaOrIdFound;
	
	public Nota updateNota(Nota nota) throws NotalecturaOrIdFound;//actualiza nota y envia nota para ser publicada
	
	
	
}
