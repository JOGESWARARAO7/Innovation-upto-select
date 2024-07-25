package com.example.Innovationproject.dao;

import com.example.Innovationproject.entity.UserData;

public interface Dao {

	UserData save(UserData userData);

	UserData findByUsername(String username);

	UserData findByEmailid(String emailid);

	



}
