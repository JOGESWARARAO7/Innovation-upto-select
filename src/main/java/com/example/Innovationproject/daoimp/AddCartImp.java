package com.example.Innovationproject.daoimp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Innovationproject.Repo.AddCartRepo;
import com.example.Innovationproject.dao.AddCartDao;
import com.example.Innovationproject.entity.AddCart;

@Service
public class AddCartImp implements AddCartDao{
	
	@Autowired
	private AddCartRepo addCartRepo;

	@Override
	public void save(AddCart addCart) {
		// TODO Auto-generated method stub
		addCartRepo.save(addCart);
	}

	
}
