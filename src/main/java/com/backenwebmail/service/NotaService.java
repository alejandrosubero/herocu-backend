package com.backenwebmail.service;

import com.backenwebmail.execiones.NotalecturaOrIdFound;
import com.backenwebmail.entity.Nota;

import java.util.List;

public interface NotaService {
	public boolean createNota(Nota nota);
	public Nota getNotaById(Long id) throws NotalecturaOrIdFound;
	public Nota updateNota(Nota nota) throws NotalecturaOrIdFound;
	public List<Nota> getNotas();
	
}
