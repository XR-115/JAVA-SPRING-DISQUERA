package com.sena.disqueraspring.controllers;


import javax.validation.Valid;

import com.sena.disqueraspring.model.Album;
import com.sena.disqueraspring.model.service.album.AlbumServiceImpl;

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

@SessionAttributes("album")
@RequestMapping("/album")

public class AlbumController {
    
    @Autowired
    private AlbumServiceImpl albumD;

//-------------------------------------------------------------LISTAR ÁLBUM----------------------------------------------------//
 @GetMapping(value="/album")
    public String album(Model m) {

        m.addAttribute("album", albumD.findAll());

        return "views/album/album";
    }   

//-------------------------------------------------------------AÑADIR ÁLBUM----------------------------------------------------//
    @GetMapping(value="/addA")
    public String addA(Model m) {
        Album album=new Album();
        m.addAttribute("album", album);
        m.addAttribute("accion","Añadir Álbumxd");
        return "views/album/add-album";
} 
//-------------------------------------------------------------ACTUALIZAR ÁLBUM----------------------------------------------------//   
@GetMapping("/editar/{idAlbum}")
public String editar (@PathVariable Integer idAlbum,  Model m){
    Album album=null;
    if (idAlbum>0){
        album=albumD.findOne(idAlbum);

    } else {
        return "redirect:album";
    }
    m.addAttribute("album",album);
    m.addAttribute("accion","Actualizar álbum");
    
    return "views/album/add-album";
}   
//-------------------------------------------------------------REDIRECCIONAR ÁLBUM----------------------------------------------------//
    @GetMapping("/index")
    public String index(){
    return "redirect:/index";
    }

//-------------------------------------------------------------REDIRECCIONAR ÁLBUM----------------------------------------------------//
    @PostMapping("/addA")
    public String add(@Valid Album album,BindingResult br, Model m, SessionStatus status){
        if(br.hasErrors()){
            return "views/album/add-album";
            }
        albumD.save(album);
        status.setComplete();
        return "redirect:album";
    }
 //------------------------------------------------------------BORRAR ÁLBUM------------------------------------------------------------// 
 @GetMapping("/delete/{idAlbum}")  
 public String delete(@PathVariable Integer idAlbum){
     if (idAlbum > 0) {
         albumD.delete(idAlbum);
     }
     
         return "redirect:/album/album";
     
 }  

 //------------------------------------------------------------VER LOS GENEROS ÁLBUM------------------------------------------------------------// 

}
