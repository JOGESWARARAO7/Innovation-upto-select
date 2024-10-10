package com.example.Innovationproject.dao;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.example.Innovationproject.entity.ItemPrices;

public interface ItemsDao{

	ItemPrices findByItemname(String itemname);

	void saveProduct(String itemname, double cost, double quantity,String itemdiscription,String itemType,MultipartFile image) throws IOException;

	List<ItemPrices> findAll();

	ItemPrices findByItemSerial(int itemserial);


}
