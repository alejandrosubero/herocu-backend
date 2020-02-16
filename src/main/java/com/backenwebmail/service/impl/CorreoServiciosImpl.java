package com.backenwebmail.service.impl;

import com.backenwebmail.modelo.entity.ListaDeCorreos;
import com.backenwebmail.modelo.pojo.ClaseDeListasInternas;
import com.backenwebmail.repository.ListaDeCorreoRepository;
import com.backenwebmail.service.CorreosServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service("correoService")
public class CorreoServiciosImpl implements CorreosServices {

    @Autowired
    private ListaDeCorreoRepository listaDeCorreoRepository;


    @Autowired
    private ClaseDeListasInternas claseDeListasInternas;


    @Override
    public void addNewCorreo(ListaDeCorreos lista) {
        listaDeCorreoRepository.save(lista);
        System.out.println(lista);
    }


    @Override//este metodo retorna una ArrayList <String> de correos
    public List<String> getListacorreos(String categoria) {

        List<String> correos = new ArrayList<>();
        List<ListaDeCorreos> lista = listaDeCorreoRepository.findAll();
        for (ListaDeCorreos elemento : lista) {
            if (elemento.getCategoriaCorreo().equals(categoria))
                correos.add(elemento.getCoreo());
        }
        return correos;
    }

    @Override
    public int crearListasDeCorreoInterno(String categoria) {
        int contador = 0;
        for (String correo : claseDeListasInternas.Crear(categoria)) {
            ListaDeCorreos listas = new ListaDeCorreos();
            listas.setCategoriaCorreo(categoria);
            listas.setCoreo(correo);
            addNewCorreo(listas);
            contador++;
        }
        return contador;
    }


    @Override
    public List<String> infoCategorias() {
        List<String> infoCategorias = Arrays.asList(claseDeListasInternas.categoriasInfo());
        return infoCategorias;
    }

}
