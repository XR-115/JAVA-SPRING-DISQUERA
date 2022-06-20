package com.sena.disqueraspring.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import javax.validation.constraints.NotEmpty;

    @Entity
        @Table(name="genero")
public class Genero { 
   
//*--------------------------------ATRIBUTOS DE LA TABLA MANIN--------------------------------*//
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idGenero;
    

    @NotEmpty
    @Column(length=50)
    private String nombreGenero;
    
    
    @Column()
    private boolean estadoGenero;

    @OneToMany(mappedBy = "fk", fetch = FetchType.LAZY, cascade =CascadeType.ALL)
    private List<Album> album;


  //*--------------------------------CONSTRUCTORES--------------------------------*//  
    public Genero() {
        album=new ArrayList<Album>();
    }

    public Genero(Integer idGenero, @NotEmpty String nombreGenero, boolean estadoGenero, List<Album> album) {
        this.idGenero = idGenero;
        this.nombreGenero = nombreGenero;
        this.estadoGenero = estadoGenero;
        this.album = album;
    }

    //*--------------------------------MÉTODOS ACCESORES--------------------------------*//
    public Integer getIdGenero() {
        return idGenero;
    }

    public void setIdGenero(Integer idGenero) {
        this.idGenero = idGenero;
    }

    public String getNombreGenero() {
        return nombreGenero;
    }

    public void setNombreGenero(String nombreGenero) {
        this.nombreGenero = nombreGenero;
    }

    public boolean getEstadoGenero() {
        return estadoGenero;
    }

    public void setEstadoGenero(boolean estadoGenero) {
        this.estadoGenero = estadoGenero;
    }

    public List<Album> getAlbum() {
        return album;
    }

    public void setAlbum(List<Album> album) {
        this.album = album;
    }

  



    
}
