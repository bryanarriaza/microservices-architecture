package com.barriaza.springboot.app.commons.models.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by bjarriaza.g.07@gmail.com
 * User: Bryan Arriaza
 * Date: 2019-08-03
 * Time: 22:15
 */

@Entity
@Table(name = "productos")
public class Producto implements Serializable {

    private static final long serialVersionUID = -1294095330371437704L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private Double precio;

    @Column(name = "create_at")
    @Temporal(TemporalType.DATE)
    private Date createAt;

    @Transient
    private Integer port;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

}

