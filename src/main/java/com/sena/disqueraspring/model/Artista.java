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
import javax.validation.constraints.NotNull;

@Entity
@Table(name="artista")
public class Artista {


    //-------------------------------------------ATRIBUTOS---------------------------------------//
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idArtista;

    @NotEmpty
    @Column(name="noDocArtista", length=20)
    private String noDocArtista;  

    @NotEmpty
    @Column(name="tipoDocArtista", length=20)
    private String tipoDocArtista;  
    
    @NotEmpty
    @Column(name="nombreArtista", length=50)
    private String nombreArtista;
    
    @NotEmpty
    @Column(name="apellidoArtista", length=50)
    private String apellidoArtista; 

    @NotEmpty
    @Column(name="nomArtistcArtista", length=50)
    private String nomArtistcArtista;

    @NotNull
    @Column(name="fechaNacArtista", length=4)
    private Integer fechaNacArtista;
    
    @NotEmpty
    @Column(name="emailArtista", length=50)
    private String emailArtista;  


    @Column(name="estadoArtista")
    private boolean estadoArtista;

    
    @ManyToOne(fetch = FetchType.LAZY)
    private Disquera fk;

    @OneToMany(mappedBy = "fk", fetch = FetchType.LAZY, cascade =CascadeType.ALL)
    private List<Album> album;



//-------------------------------------------CONSTRUCTORES---------------------------------------//

    public Artista() {
        album=new ArrayList<Album>();
    }

    public Artista(Integer idArtista, @NotEmpty String noDocArtista, @NotEmpty String tipoDocArtista,
            @NotEmpty String nombreArtista, @NotEmpty String apellidoArtista, @NotEmpty String nomArtistcArtista,
            @NotNull Integer fechaNacArtista, @NotEmpty String emailArtista, boolean estadoArtista, Disquera disquera,
            List<Album> album) {
        this.idArtista = idArtista;
        this.noDocArtista = noDocArtista;
        this.tipoDocArtista = tipoDocArtista;
        this.nombreArtista = nombreArtista;
        this.apellidoArtista = apellidoArtista;
        this.nomArtistcArtista = nomArtistcArtista;
        this.fechaNacArtista = fechaNacArtista;
        this.emailArtista = emailArtista;
        this.estadoArtista = estadoArtista;
        this.fk = disquera;
        this.album = album;
    }



//-------------------------------------------MÉTODOS ACCESORES---------------------------------------//
 public Integer getIdArtista() {
        return idArtista;
    }
    
    public void setIdArtista(Integer idArtista) {
        this.idArtista = idArtista;
    }

    public String getNoDocArtista() {
        return noDocArtista;
    }

    public void setNoDocArtista(String noDocArtista) {
        this.noDocArtista = noDocArtista;
    }

    public String getTipoDocArtista() {
        return tipoDocArtista;
    }

    public void setTipoDocArtista(String tipoDocArtista) {
        this.tipoDocArtista = tipoDocArtista;
    }

    public String getNombreArtista() {
        return nombreArtista;
    }

    public void setNombreArtista(String nombreArtista) {
        this.nombreArtista = nombreArtista;
    }

    public String getApellidoArtista() {
        return apellidoArtista;
    }

    public void setApellidoArtista(String apellidoArtista) {
        this.apellidoArtista = apellidoArtista;
    }

    public String getNomArtistcArtista() {
        return nomArtistcArtista;
    }

    public void setNomArtistcArtista(String nomArtistcArtista) {
        this.nomArtistcArtista = nomArtistcArtista;
    }

    public Integer getFechaNacArtista() {
        return fechaNacArtista;
    }

    public void setFechaNacArtista(Integer fechaNacArtista) {
        this.fechaNacArtista = fechaNacArtista;
    }

    public String getEmailArtista() {
        return emailArtista;
    }

    public void setEmailArtista(String emailArtista) {
        this.emailArtista = emailArtista;
    }

    public boolean isEstadoArtista() {
        return estadoArtista;
    }

    public void setEstadoArtista(boolean estadoArtista) {
        this.estadoArtista = estadoArtista;
    }

    public Disquera getDisquera() {
        return fk;
    }

    public void setDisquera(Disquera disquera) {
        this.fk = disquera;
    }

    public List<Album> getAlbum() {
        return album;
    }

    public void setAlbum(List<Album> album) {
        this.album = album;
    }
    

}
