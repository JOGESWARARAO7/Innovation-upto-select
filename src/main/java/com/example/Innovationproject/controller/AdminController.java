package com.example.Innovationproject.controller;

import java.io.IOException;
import java.lang.ProcessBuilder.Redirect;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.view.RedirectView;

import com.example.Innovationproject.dao.ItemsDao;
import com.example.Innovationproject.entity.ItemPrices;

import org.apache.tomcat.util.codec.binary.Base64;

@Controller
public class AdminController {
	
	@Autowired
	private ItemsDao itemsDao;
	
	
	
	 @GetMapping("/itemsAdd")
	    public String itemsAdd() {
	        // Redirecting to the HTML page
	        return "ItemsAdded.html";
	    }

	 @PostMapping("/upload")
	 public String uploadItem(@RequestParam("itemname") String itemname,
			 						@RequestParam("cost") double cost,
			 						@RequestParam("quantiy") double quantity,
			 						@RequestParam("itemdiscription") String itemdiscription,
			 						@RequestParam("itemType" ) String itemType,
			 						@RequestParam("image") MultipartFile image,Model model) {
		try {
			
			itemsDao.saveProduct(itemname,cost,quantity,itemdiscription,itemType,image);
			model.addAttribute("message","ItemAdded");
			return "ItemsAdded.html";
		} catch (IOException e) {
			model.addAttribute("message","Item Not Added");
			return "ItemsAdded.html";
		}
		
		 
	 }
	 
	 @GetMapping("/getProductList")
	 public String getProductList(Model model) {
		    // Fetch all products from the database
		    List<ItemPrices> products = itemsDao.findAll();
		    for (ItemPrices product : products) {
	            if (product.getImgData() != null) {
	                String encodedImage = Base64.encodeBase64String(product.getImgData());
	                product.setEncodedImage(encodedImage); // Add encodedImage field in ItemPrices class
	            }
	        }
		    model.addAttribute("products", products);
		    // Return the HTML view name
		   return "homeFile.html"; 
		}
	

}
