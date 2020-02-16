package com.backenwebmail.controller;


import com.backenwebmail.service.CorreosServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/Listascorreo")
public class ListasInternasController {

    @Autowired
    private CorreosServices correosServices;

    @GetMapping("/verListas")
    public List<String> listasinternasInfo() {
        return correosServices.infoCategorias();
    }


    @GetMapping("/api/foos")
    @ResponseBody
    public int getFoos(@RequestParam String categoria) {
        return correosServices.crearListasDeCorreoInterno(categoria);
    }

}
