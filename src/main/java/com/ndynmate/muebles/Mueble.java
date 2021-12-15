package com.ndynmate.muebles;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Table(name = "muebles")
@Entity
public class Mueble {
    @Column(name = "id")
    private Integer id;

    @Column(name = "tipo", nullable = false)
    private String tipo;

    @Column(name = "material", nullable = false)
    private String material;

    @Column(name = "precio", nullable = false)
    private Integer precio;

    public Integer getPrecio() {
        return precio;
    }

    public void setPrecio(Integer precio) {
        this.precio = precio;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}