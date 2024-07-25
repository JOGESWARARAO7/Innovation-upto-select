package com.example.Innovationproject.daoimp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.Innovationproject.Repo.ItemsRepo;
import com.example.Innovationproject.dao.ItemsDao;
import com.example.Innovationproject.entity.ItemPrices;

@Component
public class ItemsDaoImp implements ItemsDao{

	@Autowired
	ItemsRepo itemsRepo;

	@Override
	public ItemPrices findByItemname(String itemname) {
		// TODO Auto-generated method stub
		return itemsRepo.findByItemname(itemname);
	}
	
	

}
