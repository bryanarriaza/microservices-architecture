package com.barriaza.springboot.app.item.services;

import com.barriaza.springboot.app.item.models.Item;

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

}

