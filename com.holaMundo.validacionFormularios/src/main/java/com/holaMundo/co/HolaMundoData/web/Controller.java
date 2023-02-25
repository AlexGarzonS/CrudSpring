package com.holaMundo.co.HolaMundoData.web;

import com.holaMundo.co.HolaMundoData.domain.Persona;
import com.holaMundo.co.HolaMundoData.services.PersonaServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;




@org.springframework.stereotype.Controller
public class Controller {
    
    @Autowired
    private PersonaServices personaServices;
    
    @GetMapping("/")
    public String inicio(Model model)
    {
        Iterable<Persona> personas;
        personas = personaServices.listaPersonas();
        
        model.addAttribute("personas",personas);
        return "index";
    }
    @GetMapping("/agregar")
    public String agregar(Persona persona)
    {
        return "modificar";
    }
    @GetMapping("/editar/{id_persona}")
    public String editar(Persona persona, Model model)
    {
        persona = personaServices.encontrarPersona(persona);
        model.addAttribute("persona", persona);
        return "modificar";
    }
    @GetMapping("/eliminar")
    public String eliminar(Persona persona)
    {
        personaServices.eliminar(persona);
        return "redirect:/";
    }
    
    @PostMapping("/guardar")
    public String guardar(Persona persona)
    {
        personaServices.guardar(persona);
        return "redirect:/";
    }
}
