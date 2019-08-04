package com.barriaza.springboot.app.productos.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.barriaza.springboot.app.productos.models.entity.Producto;
import com.barriaza.springboot.app.productos.service.IProductoService;

/**
 * Created by bjarriaza.g.07@gmail.com
 * User: Bryan Arriaza
 * Date: 2019-07-21
 * Time: 16:37
 */

@RestController
public class ProductoController {

    @Value("${server.port}")
    private Integer port;

    private IProductoService productoService;

    @Autowired
    public ProductoController(IProductoService productoService) {
        this.productoService = productoService;
    }

    @GetMapping("/listar")
    public List<Producto> listar() {
        return productoService.findAll().stream().map(producto -> {
            producto.setPort(port);
            return producto;
        }).collect(Collectors.toList());
    }

    @GetMapping("/ver/{id}")
    public Producto getProducto(@PathVariable Long id) {
        Producto producto = productoService.findById(id);
        producto.setPort(port);
        return producto;
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public Producto save(@RequestBody Producto producto) {
        return productoService.save(producto);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Producto edit(@RequestBody Producto producto, @PathVariable Long id) {
        Producto productoDB = productoService.findById(id);
        productoDB.setNombre(producto.getNombre());
        productoDB.setPrecio(producto.getPrecio());
        return productoService.save(productoDB);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        productoService.deleteById(id);
    }

}
