package com.example.Innovationproject.daoimp;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.Innovationproject.Repo.ItemsRepo;
import com.example.Innovationproject.dao.ItemsDao;
import com.example.Innovationproject.entity.ItemPrices;

@Service
public class ItemsDaoImp implements ItemsDao{

	@Autowired
	ItemsRepo itemsRepo;

	@Override
	public ItemPrices findByItemname(String itemname) {
		// TODO Auto-generated method stub
		return itemsRepo.findByItemname(itemname);
	}

	@Override
	public void saveProduct(String itemname, double cost, double quantity,String itemdiscription,String itemType ,MultipartFile image) throws IOException {
		// TODO Auto-generated method stub
		ItemPrices itemPrices =new ItemPrices();
		itemPrices.setItemname(itemname);
		itemPrices.setCost(cost);
		itemPrices.setQuantity(quantity);
		itemPrices.setImageType(image.getContentType());
		itemPrices.setImagename(image.getOriginalFilename());
		itemPrices.setImgData(image.getBytes());
		itemPrices.setDate(LocalDate.now());
		itemPrices.setDiscription(itemdiscription);
		itemPrices.setItemType(itemType);
		itemsRepo.save(itemPrices);
		
	}

	@Override
	public List<ItemPrices> findAll() {
		// TODO Auto-generated method stub
		 return itemsRepo.findAll();
	}

	@Override
	public ItemPrices findByItemSerial(int itemserial) {
		// TODO Auto-generated method stub
		return itemsRepo.getReferenceById(itemserial);
	}
	
	

}
