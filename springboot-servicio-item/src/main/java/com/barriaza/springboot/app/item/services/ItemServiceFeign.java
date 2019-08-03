package com.barriaza.springboot.app.item.services;

import com.barriaza.springboot.app.item.models.Item;
import com.barriaza.springboot.app.item.rest.ProductoClienteRest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by barriaza@is4tech.com
 * User: Bryan Arriaza
 * Date: 2019-07-21
 * Time: 19:21
 */

@Service("serviceProductoFeign")
public class ItemServiceFeign implements ItemService {

    @Autowired
    private ProductoClienteRest productoClienteFeign;

    @Override
    public List<Item> findAll() {
        return productoClienteFeign.listar().stream().map(producto -> new Item(producto, 1)).collect(Collectors.toList());
    }

    @Override
    public Item findById(Long id, Integer cantidad) {
        return new Item(productoClienteFeign.detalle(id), cantidad);
    }

}
