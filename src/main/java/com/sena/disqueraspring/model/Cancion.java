package com.sena.disqueraspring.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="cancion")
public class Cancion {
    //-------------------------------------------ATRIBUTOS---------------------------------------//
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCancion;
    
    @NotEmpty
    @Column(name="nombreCancion", length=50)
    private String nombreCancion;  
    
    @NotNull
    @Column(name="fechaCancion", length=4)
    private Integer fechaCancion;
    
    @NotEmpty
    @Column(name="duracionCancion", length=5)
    private String duracionCancion;  


    @Column(name="estadoCancion")
    private boolean estadoCancion;

    @ManyToOne(fetch = FetchType.LAZY)
    private Album fk;
    

    //-------------------------------------------CONSTRUCTORES---------------------------------------//
    public Cancion() {
    }

    public Cancion(Integer idCancion, @NotEmpty String nombreCancion, @NotNull Integer fechaCancion,
            @NotEmpty String duracionCancion, boolean estadoCancion, Album fk) {
        this.idCancion = idCancion;
        this.nombreCancion = nombreCancion;
        this.fechaCancion = fechaCancion;
        this.duracionCancion = duracionCancion;
        this.estadoCancion = estadoCancion;
        this.fk = fk;
    }

    //-------------------------------------------GETTERS Y SETTERS---------------------------------------//


    public Integer getIdCancion() {
        return idCancion;
    }
    public void setIdCancion(Integer idCancion) {
        this.idCancion = idCancion;
    }


    public String getNombreCancion() {
        return nombreCancion;
    }
    public void setNombreCancion(String nombreCancion) {
        this.nombreCancion = nombreCancion;
    }


    public Integer getFechaCancion() {
        return fechaCancion;
    }
    public void setFechaCancion(Integer fechaCancion) {
        this.fechaCancion = fechaCancion;
    }


    public String getDuracionCancion() {
        return duracionCancion;
    }
    public void setDuracionCancion(String duracionCancion) {
        this.duracionCancion = duracionCancion;
    }


    public boolean isEstadoCancion() {
        return estadoCancion;
    }
    public void setEstadoCancion(boolean estadoCancion) {
        this.estadoCancion = estadoCancion;
    }

    public Album getFk() {
        return fk;
    }

    public void setFk(Album fk) {
        this.fk = fk;
    }

    
    //-------------------------------------------GETTERS Y SETTERS---------------------------------------//

   
   
}
