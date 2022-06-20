package com.sena.disqueraspring.model;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import org.springframework.stereotype.Repository;

@Repository
public class GeneroDao implements IGenero{

    @PersistenceContext
    private EntityManager em;
//---------------------------------------MÉTODO PARA LISTAR TODOS LOS DATOS DE LA GENERO--------------------------------------------//
     @SuppressWarnings("unchecked")

     @Override
    public List<Genero> findAll() {
      
      return em.createQuery("from Genero").getResultList();
    } 


 //---------------------------------------MÉTODO PARA REGISTRAR DATOS DE LA GENERO--------------------------------------------//     
    
  @Transactional
        @Override
        public void save(Genero genero) {
          if (genero.getIdGenero() != null && genero.getIdGenero() > 0) {
            em.merge(genero);
          } else {
            em.persist(genero);
          }
  
    }


  //---------------------------------------MÉTODO PARA ACTUALIZAR LOS DATOS DE LA GENERO--------------------------------------------//  

    @Override

      public Genero findOne(Integer idGenero){

        return em.find(Genero.class, idGenero);
      }

  //---------------------------------------MÉTODO PARA ACTUALIZAR LOS DATOS DE LA GENERO--------------------------------------------//  
      @Override
      @Transactional
      public void delete(Integer idGenero) {
      em.remove(findOne(idGenero));
      }

}

