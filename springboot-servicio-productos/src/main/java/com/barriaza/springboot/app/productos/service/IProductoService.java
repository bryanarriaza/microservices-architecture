package com.barriaza.springboot.app.productos.service;

import java.util.List;

import com.barriaza.springboot.app.productos.models.entity.Producto;

/**
 * Created by barriaza@is4tech.com
 * User: Bryan Arriaza
 * Date: 2019-07-21
 * Time: 16:26
 */

public interface IProductoService {

    public List<Producto> findAll();

    public Producto findById(Long id);

}

