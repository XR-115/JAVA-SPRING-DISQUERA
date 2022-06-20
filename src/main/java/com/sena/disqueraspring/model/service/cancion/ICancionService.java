package com.sena.disqueraspring.model.service.cancion;

import java.util.List;

import com.sena.disqueraspring.model.Cancion;

public interface ICancionService {

    public List<Cancion> findAll();
    public void save(Cancion cancion);
    public Cancion findOne(Integer idCancion);
    public void delete(Integer idCancion);

}