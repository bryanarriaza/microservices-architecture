package com.barriaza.springboot.app.productos.service;

import java.util.List;

import com.barriaza.springboot.app.productos.models.entity.Producto;

/**
 * Created by bjarriaza.g.07@gmail.com
 * User: Bryan Arriaza
 * Date: 2019-07-21
 * Time: 16:26
 */

public interface IProductoService {

    public List<Producto> findAll();

    public Producto findById(Long id);

    public Producto save(Producto producto);

    public void deleteById(Long id);

}
