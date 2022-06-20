package com.sena.disqueraspring.model.service.artista;

import java.util.List;

import com.sena.disqueraspring.model.Artista;

public interface IArtistaService {
     
    public List<Artista> findAll();
    public void save(Artista artista);
    public Artista findOne(Integer idArtista);
    public void delete(Integer idArtista);
}
