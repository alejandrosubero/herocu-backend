package com.backenwebmail.service;

import com.backenwebmail.entity.ListaDeCorreos;

import java.util.List;

public interface CorreosServices {
    public void addNewCorreo(ListaDeCorreos lista);
    public List<String> getListacorreos(String categoria);
    public int crearListasDeCorreoInterno(String categoria);
    public List<String> infoCategorias();
}
