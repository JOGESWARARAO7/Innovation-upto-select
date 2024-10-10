package com.example.Innovationproject.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.Innovationproject.dao.ItemsDao;
import com.example.Innovationproject.entity.ItemPrices;

@Repository
public interface ItemsRepo extends JpaRepository<ItemPrices,Integer>{

	ItemPrices findByItemname(String itemname);


}
