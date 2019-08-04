package com.barriaza.springboot.app.item.rest;

import com.barriaza.springboot.app.commons.models.entity.Producto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by bjarriaza.g.07@gmail.com
 * User: Bryan Arriaza
 * Date: 2019-07-21
 * Time: 19:19
 */

@FeignClient(name = "servicio-productos")
public interface ProductoClienteRest {

    @GetMapping("/listar")
    public List<Producto> listar();

    @GetMapping("/ver/{id}")
    public Producto detalle(@PathVariable Long id);

    @PostMapping
    public Producto save(@RequestBody Producto producto);

    @PutMapping("/{id}")
    public Producto update(@RequestBody Producto producto, @PathVariable Long id);

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id);

}

