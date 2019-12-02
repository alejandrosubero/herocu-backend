package com.backenwebmail.service;

import com.backenwebmail.execiones.NotalecturaOrIdFound;
import com.backenwebmail.modelo.Nota;

public interface NotaService {

	
	public void createNota(Nota nota); 
	
	public Nota getNotaById(Long id) throws NotalecturaOrIdFound;
	
	public String updateNota(Nota nota) throws NotalecturaOrIdFound;//actualiza nota y envia nota para ser publicada
	
	
	
}
