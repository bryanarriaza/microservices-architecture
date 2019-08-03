package com.barriaza.springboot.app.productos.repository;

import com.barriaza.springboot.app.productos.models.entity.Producto;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by barriaza@is4tech.com
 * User: Bryan Arriaza
 * Date: 2019-07-21
 * Time: 16:23
 */

@Repository
public interface ProductoRepository extends CrudRepository<Producto, Long>{
}
