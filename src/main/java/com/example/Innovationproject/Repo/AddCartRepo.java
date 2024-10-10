package com.example.Innovationproject.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Innovationproject.entity.AddCart;

@Repository
public interface AddCartRepo extends JpaRepository<AddCart, Long>{

}
