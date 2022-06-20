package com.sena.disqueraspring.controllers;


import javax.validation.Valid;

import com.sena.disqueraspring.model.Genero;
import com.sena.disqueraspring.model.IGenero;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;    


@Controller
@SessionAttributes("genero")
@RequestMapping("/genero")

public class GeneroController {

//-------------------------------------------------------------LISTAR GÉNERO----------------------------------------------------//
    @Autowired
    private IGenero generoD;

    @GetMapping(path = "/genero")
        public String genero (Model m) {

            m.addAttribute("genero", generoD.findAll());

            return "views/genero/genero";
        }
//-------------------------------------------------------------LLEVAR ID POR URL DE GÉNERO----------------------------------------------------//
    @GetMapping("/editar/{idGenero}")
    public String editar (@PathVariable Integer idGenero,  Model m){
        Genero genero=null;
        if (idGenero>0){
            genero=generoD.findOne(idGenero);
            
        } else {
            return "redirect:genero";
        }
        m.addAttribute("genero",genero);    
        m.addAttribute("accion","Actualizar Genero");
        
        return "views/genero/add-genero";
    }   
//-------------------------------------------------------------AÑADIR GÉNERO----------------------------------------------------//
    @GetMapping("/addG")
    public String addG(Model m) {
        Genero genero= new Genero();
        m.addAttribute("genero", genero);
        m.addAttribute("accion","Añadir Género");
        return "views/genero/add-genero";
}   


//-------------------------------------------------------------REDIRECCIONAR AL INDEX----------------------------------------------------//
@GetMapping(path = {"/","../","/index","/home"})
public String index() {
   return "redirect:/index";
   }
//-------------------------------------------------------------AÑADIR UN DATO POR POST----------------------------------------------------//

@PostMapping("/addG")

    public String addG(@Valid Genero genero,BindingResult br, Model m,SessionStatus status){
        if(br.hasErrors()){
            return "views/genero/add-genero";
            }

        generoD.save(genero);
        status.setComplete();
        return "redirect:genero";
    }
//-------------------------------------------------------------ELIMINAR DATO POR ID PA----------------------------------------------------//
    @GetMapping("/delete/{idGenero}")  
    public String delete(@PathVariable Integer idGenero){
        if (idGenero > 0) {
            generoD.delete(idGenero);
        }
        
            return "redirect:/genero/genero";
        
    }

    @GetMapping("/ver-genero/{idGenero}")
    public String verAlbum(@PathVariable Integer idGenero,Model m){
    Genero genero=null;
    if(idGenero>0){
        genero=generoD.findOne(idGenero);
    }else{
    return "redirect:genero";
    }
    m.addAttribute("genero",genero);
    m.addAttribute("accion", "Detalle del album");
    return "views/genero/ver-genero";
    }
}
