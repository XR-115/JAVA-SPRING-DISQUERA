package com.sena.disqueraspring.model.service.album;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sena.disqueraspring.model.Album;
import com.sena.disqueraspring.model.IAlbum;

@Service
public class AlbumServiceImpl implements IAlbumService {
    
    //---------------------------------------MÉTODO PARA LISTAR TODOS LOS DATOS DE ALBUM--------------------------------------------//
    @Autowired
    private IAlbum albumD;
        @Override
    public List<Album> findAll() {
    return (List<Album>) albumD.findAll();
    }

    //---------------------------------------MÉTODO PARA TOMAR UN ID ACTUALIZAR O REGISTRAR UN DATO DE ALBUM--------------------------------------------//
    @Override   
    public Album findOne(Integer idAlbum) {
    return albumD.findById(idAlbum).orElse(null);
    }

    //---------------------------------------MÉTODO PARA GUARDAR UN DATO DE ALBUM--------------------------------------------//
    @Override
    public void save(Album album) {
    albumD.save(album);
        }

    //---------------------------------------MÉTODO PARA BORRAR UN DATO DE ALBUM--------------------------------------------//
    @Override
    public void delete(Integer idAlbum) {
    albumD.deleteById(idAlbum);
}
}
