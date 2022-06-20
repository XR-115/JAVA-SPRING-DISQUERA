package com.sena.disqueraspring.model.service.disquera;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sena.disqueraspring.model.Disquera;
import com.sena.disqueraspring.model.IDisquera;



@Service
public class DisqueraServiceImpl implements IDisqueraService{
     //---------------------------------------MÉTODO PARA LISTAR TODOS LOS DATOS DE CANCION--------------------------------------------//
     @Autowired
     private IDisquera disD;
 
     @Override
     public List<Disquera> findAll() {
     return (List<Disquera>) disD.findAll();
     }
 
      //---------------------------------------MÉTODO PARA TOMAR UN ID ACTUALIZAR O REGISTRAR UN DATO DE CANCION--------------------------------------------//
 
      @Override
      public Disquera findOne(Integer idDisquera){
          return disD.findById(idDisquera).orElse(null);
      }
 
      //---------------------------------------MÉTODO PARA GUARDAR UN DATO DE CANCION-------------------------------------------//
      @Override
      public void save(Disquera disquera) {
      disD.save(disquera);
          }
 
     //---------------------------------------MÉTODO PARA GUARDAR UN DATO DE CANCION-------------------------------------------//
      @Override
      public void delete(Integer idDisquera) {
      disD.deleteById(idDisquera);
          }
}
