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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

//*--------------------------------ENTITY´S PARA CREAR TABLAS DE MYSQL--------------------------------*//
 @Entity
    @Table(name="album")
//*--------------------------------ATRIBUTOS DE LA TABLA MANIN--------------------------------*//
public class Album {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idAlbum;
    
    @NotEmpty
    @Column(name="nombreAlbum", length=50)
    private String nombreAlbum;  
    
    @NotEmpty
    @Column(name="anioAlbum", length=4)
    private String anioAlbum;
    
    @Column(name="estadoAlbum")
    private boolean estadoAlbum;





    @ManyToOne(fetch = FetchType.LAZY)
    private Artista fk;

    @ManyToOne(fetch = FetchType.LAZY)
    private Genero fkg;

    @OneToMany(mappedBy = "fk", fetch = FetchType.LAZY, cascade =CascadeType.ALL)
    private List<Cancion> cancion;
   


//*--------------------------------CONSTRUCTORES--------------------------------*//
    public Album() {
        cancion=new ArrayList<Cancion>();
    }
    public Album(Integer idAlbum, @NotEmpty String nombreAlbum, @NotEmpty String anioAlbum, boolean estadoAlbum,
            Artista fk, Genero fkg, List<Cancion> cancion) {
        this.idAlbum = idAlbum;
        this.nombreAlbum = nombreAlbum;
        this.anioAlbum = anioAlbum;
        this.estadoAlbum = estadoAlbum;
        this.fk = fk;
        this.fkg = fkg;
        this.cancion = cancion;
    }

    //*--------------------------------MÉTODOS ACCESORES--------------------------------*//    
    public Integer getIdAlbum() {
        return idAlbum;
    }

    public void setIdAlbum(Integer idAlbum) {
        this.idAlbum = idAlbum;
    }

//*----------------------------------------------------------------*//  
    public String getNombreAlbum() {
        return nombreAlbum;
    }

    public void setNombreAlbum(String nombreAlbum) {
        this.nombreAlbum = nombreAlbum;
    }

//*----------------------------------------------------------------*//  
    public String getAnioAlbum() {
        return anioAlbum;
    }

    public void setAnioAlbum(String anioAlbum) {
        this.anioAlbum = anioAlbum;
    }

//*----------------------------------------------------------------*//  
    public boolean getEstadoAlbum() {
        return estadoAlbum;
    }

    public void setEstadoAlbum(boolean estadoAlbum) {
        this.estadoAlbum = estadoAlbum;
    }




    public Artista getArtista() {
        return fk;
    }

    public void setArtista(Artista artista) {
        this.fk = artista;
    }

    public List<Cancion> getCancion() {
        return cancion;
    }

    public void setCancion(List<Cancion> cancion) {
        this.cancion = cancion;
    }
    
    public Genero getFkg() {
        return fkg;
    }
    public void setFkg(Genero fkg) {
        this.fkg = fkg;
    }    
    
}

