package com.barriaza.springboot.app.item.services;

import com.barriaza.springboot.app.item.models.Item;
import com.barriaza.springboot.app.item.models.Producto;

import java.util.List;

/**
 * Created by barriaza@is4tech.com
 * User: Bryan Arriaza
 * Date: 2019-07-21
 * Time: 18:02
 */

public interface ItemService {

    public List<Item> findAll();

    public Item findById(Long id, Integer cantidad);

    public Producto save(Producto producto);

    public Producto update(Producto producto, Long id);

    public void delete(Long id);

}

