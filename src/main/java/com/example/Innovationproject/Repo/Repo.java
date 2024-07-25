package com.example.Innovationproject.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.Innovationproject.entity.UserData;

@Repository
public interface Repo extends JpaRepository<UserData, Long>{

	UserData findByUsername(String username);

	UserData findByEmailid(String emailid);


}
