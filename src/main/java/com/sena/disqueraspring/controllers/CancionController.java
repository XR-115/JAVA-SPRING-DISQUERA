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

import com.sena.disqueraspring.model.Cancion;
import com.sena.disqueraspring.model.service.cancion.CancionServiceImpl;
 

@Controller

//----------------------------RUTA PRINCIPAL------------------------//
    @SessionAttributes("cancion")
    @RequestMapping("/cancion")


//----------------------------HANDLERS------------------------//
public class CancionController {
    @Autowired
    CancionServiceImpl canD;
//-------------------------------------------------------------LISTAR CANCIÓN----------------------------------------------------//
 @GetMapping(value = "/cancion")
   public String cancion(Model m){

    m.addAttribute("cancion", canD.findAll());

       return "views/cancion/cancion";
   }

 //-------------------------------------------------------------AÑADIR CANCIÓN----------------------------------------------------//
 @GetMapping(value = "/addC")
   public String addC(Model m){

    Cancion cancion=new Cancion();
    m.addAttribute("cancion", cancion);
    m.addAttribute("accion","Añadir Canción");

    
       return "views/cancion/add-cancion";
   }  



//-------------------------------------------------------------POST DE AGREGAR Y ACTUALIZAR----------------------------------------------------//
    @PostMapping("/addC")
    public String addC(@Valid Cancion cancion,BindingResult br, Model m, SessionStatus status){
        if(br.hasErrors()){
            return "views/cancion/add-cancion";
            }
        canD.save(cancion);
        status.setComplete();
        return "redirect:cancion";
    }

    //-------------------------------------------------------------ELIMINAR DATO POR ID PA----------------------------------------------------//
    @GetMapping("/delete/{idCancion}")  
    public String delete(@PathVariable Integer idCancion){
        if (idCancion > 0) {
            canD.delete(idCancion);
        }
        
            return "redirect:/cancion/cancion";
        
    }



//-------------------------------------------------------------ACTUALIZAR CANCIÓN----------------------------------------------------//
 @GetMapping(value = "/editar/{idCancion}")
 public String editar(Model m, @PathVariable Integer idCancion){
     Cancion cancion=new Cancion();
     if (idCancion>0) {
         cancion=canD.findOne(idCancion);
     }else{
         return("redirect:cancion");
     }
     m.addAttribute("cancion", cancion);
     m.addAttribute("accion", "Actualizar canción");

  
     return "views/cancion/add-cancion";
 }  
 
 //-------------------------------------------------------------REDIRECCIONAR ÁLBUM----------------------------------------------------//
 @GetMapping("/index")
 public String index(){
 return "redirect:/index";
 }

   
}
