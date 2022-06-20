package com.sena.disqueraspring.model.service.cancion;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sena.disqueraspring.model.Cancion;
import com.sena.disqueraspring.model.ICancion;

@Service
public class CancionServiceImpl implements ICancionService{

    //---------------------------------------MÉTODO PARA LISTAR TODOS LOS DATOS DE CANCION--------------------------------------------//
    @Autowired
    private ICancion canD;

    @Override
    public List<Cancion> findAll() {
    return (List<Cancion>) canD.findAll();
    }

     //---------------------------------------MÉTODO PARA TOMAR UN ID ACTUALIZAR O REGISTRAR UN DATO DE CANCION--------------------------------------------//

     @Override
     public Cancion findOne(Integer idCancion){
         return canD.findById(idCancion).orElse(null);
     }

     //---------------------------------------MÉTODO PARA GUARDAR UN DATO DE CANCION-------------------------------------------//
     @Override
     public void save(Cancion cancion) {
     canD.save(cancion);
         }

    //---------------------------------------MÉTODO PARA GUARDAR UN DATO DE CANCION-------------------------------------------//
     @Override
     public void delete(Integer idCancion) {
     canD.deleteById(idCancion);
         }
}
