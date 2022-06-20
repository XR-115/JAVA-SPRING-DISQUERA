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
import javax.validation.constraints.NotNull;



    @Entity
@Table(name="disquera")

public class Disquera {
    //-------------------------------------------ATRIBUTOS---------------------------------------//
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idDisquera;
    
    @NotEmpty
    @Column(name="nitDisquera", length=20)
    private String nitDisquera;  

    @NotEmpty
    @Column(name="nombreDisquera", length=100)
    private String nombreDisquera;  
    
    @NotNull
    @Column(name="telefonoDisquera", length=15)
    private Integer telefonoDisquera;
    
    @NotEmpty
    @Column(name="direccionDisquera", length=100)
    private String direccionDisquera;  


    @Column(name="estadoDisquera")
    private boolean estadoDisquera;
    
    @OneToMany(mappedBy = "fk", fetch = FetchType.LAZY, cascade =CascadeType.ALL)
    private List<Artista> artista;

   

  //-------------------------------------------CONSTRUCTORES---------------------------------------//
 
    public Disquera() {
        artista=new ArrayList<Artista>();
    }

    public Disquera(Integer idDisquera, @NotEmpty String nitDisquera, @NotEmpty String nombreDisquera,
            @NotNull Integer telefonoDisquera, @NotEmpty String direccionDisquera, boolean estadoDisquera,
            List<Artista> artista) {
        this.idDisquera = idDisquera;
        this.nitDisquera = nitDisquera;
        this.nombreDisquera = nombreDisquera;
        this.telefonoDisquera = telefonoDisquera;
        this.direccionDisquera = direccionDisquera;
        this.estadoDisquera = estadoDisquera;
        this.artista = artista;
    }

//-------------------------------------------MÉTODOS ACCESORES---------------------------------------//
   public Integer getIdDisquera() {
    return idDisquera;
}




public void setIdDisquera(Integer idDisquera) {
    this.idDisquera = idDisquera;
}


public String getNitDisquera() {
    return nitDisquera;
}


public void setNitDisquera(String nitDisquera) {
    this.nitDisquera = nitDisquera;
}


public String getNombreDisquera() {
    return nombreDisquera;
}


public void setNombreDisquera(String nombreDisquera) {
    this.nombreDisquera = nombreDisquera;
}


public Integer getTelefonoDisquera() {
    return telefonoDisquera;
}


public void setTelefonoDisquera(Integer telefonoDisquera) {
    this.telefonoDisquera = telefonoDisquera;
}


public String getDireccionDisquera() {
    return direccionDisquera;
}


public void setDireccionDisquera(String direccionDisquera) {
    this.direccionDisquera = direccionDisquera;
}


public boolean isEstadoDisquera() {
    return estadoDisquera;
}


public void setEstadoDisquera(boolean estadoDisquera) {
    this.estadoDisquera = estadoDisquera;
}

    
}

