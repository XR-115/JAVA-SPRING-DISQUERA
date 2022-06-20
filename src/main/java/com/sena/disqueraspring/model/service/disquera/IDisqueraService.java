package com.sena.disqueraspring.model.service.disquera;

import java.util.List;

import com.sena.disqueraspring.model.Disquera;

public interface IDisqueraService {

    public List<Disquera> findAll();
    public void save(Disquera disquera);
    public Disquera findOne(Integer idDisquera);
    public void delete(Integer idDisquera);
}
