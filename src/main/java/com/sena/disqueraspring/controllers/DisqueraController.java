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

import com.sena.disqueraspring.model.Disquera;
import com.sena.disqueraspring.model.service.disquera.DisqueraServiceImpl;




@Controller
@SessionAttributes("disquera")
@RequestMapping("/disquera")
public class DisqueraController {

@Autowired
private DisqueraServiceImpl disD;

//-------------------------------------------------------------LISTAR DISQUERA----------------------------------------------------//
 @GetMapping(value = "/disquera")
   public String disquera(Model m){

    m.addAttribute("disquera", disD.findAll());

       return "views/disquera/disquera";
   }

 //-------------------------------------------------------------AÑADIR DISQUERA----------------------------------------------------//
 @GetMapping(value="/addD")
 public String addD(Model m) {
     Disquera disquera=new Disquera();
     m.addAttribute("disquera", disquera);
     m.addAttribute("accion","Añadir Disquera");
     return "views/disquera/add-disquera";
} 
 //-------------------------------------------------------------ACTUALIZAR DISQUERA----------------------------------------------------//
 @GetMapping("/editar/{idDisquera}")
public String editar (@PathVariable Integer idDisquera,  Model m){
    Disquera disquera=null;
    if (idDisquera>0){
        disquera=disD.findOne(idDisquera);

    } else {
        return "redirect:disquera";
    }
    m.addAttribute("disquera",disquera);
    m.addAttribute("accion","Actualizar disquera");
    
    return "views/disquera/add-disquera";
}   

//------------------------------------------------------------POST DE LA INFO----------------------------------------------------//
    @PostMapping("/addD")
    public String add(@Valid Disquera disquera,BindingResult br, Model m, SessionStatus status){
        if(br.hasErrors()){
            return "views/disquera/add-disquera";
            }
        disD.save(disquera);
        status.setComplete();
        return "redirect:disquera";
    }

//-------------------------------------------------------------REDIRECCIONAR ÁLBUM----------------------------------------------------//
    @GetMapping("/index")
    public String index(){
    return "redirect:/index";
    }

//------------------------------------------------------------BORRAR ÁLBUM------------------------------------------------------------// 
 @GetMapping("/delete/{idDisquera}")  
 public String delete(@PathVariable Integer idDisquera){
     if (idDisquera > 0) {
         disD.delete(idDisquera);
     }
     
         return "redirect:/disquera/disquera";
     
 }  
}
