package com.sena.disqueraspring.model.service.artista;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sena.disqueraspring.model.Artista;
import com.sena.disqueraspring.model.IArtista;

@Service
public class ArtistaServiceImpl implements IArtistaService {
      //---------------------------------------MÉTODO PARA LISTAR TODOS LOS DATOS DE artista--------------------------------------------//
      @Autowired
      private IArtista artD;
  
      @Override
      public List<Artista> findAll() {
      return (List<Artista>) artD.findAll();
      }
  
       //---------------------------------------MÉTODO PARA TOMAR UN ID ACTUALIZAR O REGISTRAR UN DATO DE artista--------------------------------------------//
  
       @Override
       public Artista findOne(Integer idArtista){
           return artD.findById(idArtista).orElse(null);
       }
  
       //---------------------------------------MÉTODO PARA GUARDAR UN DATO DE artista-------------------------------------------//
       @Override
       public void save(Artista artista) {
        artD.save(artista);
           }
  
      //---------------------------------------MÉTODO PARA GUARDAR UN DATO DE artista-------------------------------------------//
       @Override
       public void delete(Integer idArtista) {
       artD.deleteById(idArtista);
           }
}
