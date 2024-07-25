package com.example.Innovationproject.daoimp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.example.Innovationproject.Repo.Repo;
import com.example.Innovationproject.dao.Dao;
import com.example.Innovationproject.entity.UserData;

@Component
public class Daoimp implements Dao{

	@Autowired
	Repo repo;

	@Override
	public UserData save(UserData userData) {
		// TODO Auto-generated method stub
		return repo.save(userData);
	}

	@Override
	public UserData findByUsername(String username) {
		// TODO Auto-generated method stub
		return repo.findByUsername(username);
	}

	@Override
	public UserData findByEmailid(String emailid) {
		// TODO Auto-generated method stub
		return repo.findByEmailid(emailid);
	}

	


	
}
