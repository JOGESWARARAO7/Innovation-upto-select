package com.example.Innovationproject.dao;

import com.example.Innovationproject.entity.ItemPrices;

public interface ItemsDao{

	ItemPrices findByItemname(String itemname);


}
