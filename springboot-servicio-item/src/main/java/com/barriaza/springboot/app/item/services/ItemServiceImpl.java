package com.barriaza.springboot.app.item.services;

import com.barriaza.springboot.app.item.models.Item;
import com.barriaza.springboot.app.item.models.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by bjarriaza.g.07@gmail.com
 * User: Bryan Arriaza
 * Date: 2019-07-21
 * Time: 18:03
 */

@Service("serviceItemRestTemplate")
public class ItemServiceImpl implements ItemService {

    @Autowired
    private RestTemplate clientRestTemplate;

    @Autowired
    public ItemServiceImpl(RestTemplate clientRestTemplate) {
        this.clientRestTemplate = clientRestTemplate;
    }

    @Override
    public List<Item> findAll() {
        List<Producto> productos = Arrays.asList(clientRestTemplate.getForObject("http://servicio-productos/listar", Producto[].class));
        return productos.stream().map(producto -> new Item(producto, 1)).collect(Collectors.toList());
    }

    @Override
    public Item findById(Long id, Integer cantidad) {
        Map<String, String> pathVariables = new HashMap<String, String>();
        pathVariables.put("id", id.toString());
        Producto producto = clientRestTemplate.getForObject("http://servicio-productos/ver/{id}", Producto.class, pathVariables);
        return new Item(producto, cantidad);
    }

    @Override
    public Producto save(Producto producto) {
        HttpEntity<Producto> body = new HttpEntity<Producto>(producto);
        ResponseEntity<Producto> response = clientRestTemplate.exchange("http://servicio-productos", HttpMethod.POST, body, Producto.class);
        Producto productoResponse = response.getBody();
        return productoResponse;
    }

    @Override
    public Producto update(Producto producto, Long id) {
        Map<String, String> pathVariables = new HashMap<String, String>();
        pathVariables.put("id", id.toString());
        HttpEntity<Producto> body = new HttpEntity<Producto>(producto);
        ResponseEntity<Producto> response = clientRestTemplate.exchange("http://servicio-productos/{id}", HttpMethod.PUT, body, Producto.class, pathVariables);
        return response.getBody();
    }

    @Override
    public void delete(Long id) {
        Map<String, String> pathVariables = new HashMap<String, String>();
        pathVariables.put("id", id.toString());
        clientRestTemplate.delete("http://servicio-productos/{id}", pathVariables);
    }

}
