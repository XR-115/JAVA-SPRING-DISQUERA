package com.sena.disqueraspring.controllers;

import javax.validation.Valid;

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

import com.sena.disqueraspring.model.Artista;
import com.sena.disqueraspring.model.service.artista.ArtistaServiceImpl;

@Controller

//----------------------------RUTA PRINCIPAL------------------------//
    @SessionAttributes("artista")
    @RequestMapping("/artista")

public class ArtistaController {
    
    @Autowired
private ArtistaServiceImpl artD;

//-------------------------------------------------------------LISTAR ARTISTA----------------------------------------------------//
 @GetMapping(value = "/artista")
   public String artista(Model m){

    m.addAttribute("artista", artD.findAll());

       return "views/artista/artista";
   }

 //-------------------------------------------------------------AÑADIR DISQUERA----------------------------------------------------//
 @GetMapping(value="/addA")
 public String addA(Model m) {
    Artista artista=new Artista();
     m.addAttribute("artista", artista);
     m.addAttribute("accion","Añadir artista");
     return "views/artista/add-artista";
} 
 //-------------------------------------------------------------ACTUALIZAR DISQUERA----------------------------------------------------//
 @GetMapping("/editar/{idArtista}")
public String editar (@PathVariable Integer idArtista,  Model m){
    Artista artista=null;
    if (idArtista>0){
        artista=artD.findOne(idArtista);

    } else {
        return "redirect:artista";
    }
    m.addAttribute("artista",artista);
    m.addAttribute("accion","Actualizar artista");
    
    return "views/artista/add-artista";
}   

//------------------------------------------------------------POST DE LA INFO----------------------------------------------------//
    @PostMapping("/addA")
    public String add(@Valid Artista artista,BindingResult br, Model m, SessionStatus status){
        if(br.hasErrors()){
            return "views/artista/add-artista";
            }
        artD.save(artista);
        status.setComplete();
        return "redirect:artista";
    }

//-------------------------------------------------------------REDIRECCIONAR ÁLBUM----------------------------------------------------//
    @GetMapping("/index")
    public String index(){
    return "redirect:/index";
    }

//------------------------------------------------------------BORRAR ÁLBUM------------------------------------------------------------// 
 @GetMapping("/delete/{idArtista}")  
 public String delete(@PathVariable Integer idArtista){
     if (idArtista > 0) {
        artD.delete(idArtista);
     }
     
         return "redirect:/artista/artista";
     
 }  
    
}
