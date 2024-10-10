package com.example.Innovationproject.controller;

import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.example.Innovationproject.InnovationMainProjectApplication;
import com.example.Innovationproject.dao.AddCartDao;
import com.example.Innovationproject.dao.Dao;
import com.example.Innovationproject.dao.ItemsDao;
import com.example.Innovationproject.daoimp.ItemsDaoImp;
import com.example.Innovationproject.entity.AddCart;
import com.example.Innovationproject.entity.ItemPrices;
import com.example.Innovationproject.entity.UserData;
import com.example.Innovationproject.otp.EmailSenderservice;



@Controller
public class LoginController {
	@Autowired
	Dao dao;
	
	@Autowired
	private ItemsDao itemsDao;
	
	@Autowired
	private AddCartDao addCartDao;
	
	@Autowired
	private EmailSenderservice emailSenderservice;

	@RequestMapping("/loginpage")
	public String loginpage() {
		return "login.html";
	}
	
	
	@RequestMapping("/signpage")
	public String signpage() {
		return "signpage.html";
	}
	
	@RequestMapping("/forget")
	public String forget() {
		return "forget.html";
	}
	
	String mailString="";
	UserData userData1;
	@RequestMapping("/savedata")
	public String savedata(UserData userData,Model model){
		mailString=userData.getEmailid();
		UserData ud=dao.findByUsername(userData.getUsername());
		if(ud==null) {
			userData1=userData;
			return "otp.html";
		}
		else {
			model.addAttribute("msg","Invlaid user name");
			return "signpage.html";
		}
		
	}
	
	
	
	String usernameString="";
	UserData userdata;
	@RequestMapping("/login")
	public ModelAndView login(@RequestParam("emailid") String emailid,@RequestParam("password") String password) {
		ModelAndView mv;
		 userdata=dao.findByEmailid(emailid);
		 usernameString=userdata.getUsername();
		if(userdata!=null && userdata.getPassword().equals(password)) {
			mv=new ModelAndView("homepage.html");
			mv.addObject("msg",usernameString);
			usernameString="";
			List<ItemPrices> products = itemsDao.findAll();
			for (ItemPrices product : products) {
	            if (product.getImgData() != null) {
	                String encodedImage = Base64.encodeBase64String(product.getImgData());
	                product.setEncodedImage(encodedImage); // Add encodedImage field in ItemPrices class
	            }
	        }
			
			mv.addObject("products", products);
			return mv;
		}
		else {
			mv=new ModelAndView("login.html");
			mv.addObject("msg","Invalid Cradentials..!! ReTry 😎");
			return mv;
		}
		
	}
	
	String otString="";
	@RequestMapping("/otp")
	public void otp(@RequestParam("emailid") String emailid,Model model) {
		System.out.println(emailid+"...."+mailString);
		if(emailid.equals(mailString)) {
		String otp=emailSenderservice.generateOtp();
		otString=otp;
		System.out.println(otp);
		String body=otp+" this is once time password of innovation resturent /n"+ "don't share any one";
		String subjcetString="Innovation resturent OTP Check";
		String result=emailSenderservice.sendSimpleEmail(emailid,otp,body,subjcetString);
			if ("successfully".equals(result)) {
                model.addAttribute("otpmsgs", "Sent successfully");
            } else {
                model.addAttribute("otpmsg", "Failed to send email");
            }
			mailString="";
			
		}
		else {
			model.addAttribute("otpmsg","Email id not a correct");
			mailString="";
		}
	}
	@RequestMapping("/check")
	public ModelAndView check(@RequestParam("otp") String otp) {
		ModelAndView mv;
		String s=null;
		if (otp.equals(otString) && otp!=s ) {
			dao.save(userData1);
			mv=new ModelAndView("login.html");
			otString="";
			mv.addObject("msg",usernameString);
			usernameString="";
			return mv;
		}
		else {
			mv=new ModelAndView("otp.html");
			mv.addObject("msg","Invalid OTP..!! ReTry 😎");
			otString="";
			return mv;
		}
		
		
	}
	
	
	// forget gmail checking
	StringBuilder sb;
	@RequestMapping("/mailcheck")
	public boolean mailcheck(@RequestParam("emailid") String emailid,Model model) {
		//mailString=emailid;
		boolean mailcheck=false;
		UserData userdata=dao.findByEmailid(emailid);
		if(userdata!=null) {
			sb=new StringBuilder(userdata.getEmailid());
			mailcheck=true;
		}
		else {
			model.addAttribute("otpmsg","Invalid Cradentials..!! ReTry 😎");
			mailcheck=false;
		}
		return mailcheck;
		
	}
	
	String otpforgot="";
	StringBuilder sb1;
	StringBuilder sb2;
	@RequestMapping("/forgetotpmail")
	public String forgetotpmail(@RequestParam("emailid") String emailid,Model model) {
		boolean b=mailcheck(emailid, model);
		if(b==true) {
		if(emailid.equals(sb.toString())) {
		String otp=emailSenderservice.generateOtp();
		otpforgot=otp;
		String body=otp+" this is once time password of innovation resturent /n"
				+ "don't share any one";
		String subjcetString="Innovation resturent OTP Check";
		String result=emailSenderservice.sendSimpleEmail(emailid,otp,body,subjcetString);
			if ("successfully".equals(result)) {
				sb2=new StringBuilder(emailid+otp);
				sb1=new StringBuilder(emailid);
                model.addAttribute("otpmsgs", "Sent Otp this Email successfully");
            } else {
                model.addAttribute("otpmsg", "Invalid Cradentials..!! ReTry 😎");
            }
			sb.delete(0,sb.length());
		}
		}
		
		else  {
			model.addAttribute("otpmsg", "Invalid Cradentials..!! ReTry 😎");
		}	
		return "forget";	
	}
	
	//new password otp
	@RequestMapping("/forgetotp")
	public String forgetotp(@RequestParam("otp") String otp,Model model) {
		String s=null;
		if (otp.equals(otpforgot) && otp!=s && otp.equals(sb2.substring(sb2.length()-6))) {
			otpforgot="";
			model.addAttribute("msg1","Sucessfull OTP");	
			
		}
		else {
			model.addAttribute("msg","Invalid OTP..!! ReTry 😎");
			otpforgot="";	
		}
		return "forget";
		
	}
	@RequestMapping("/setpassword")
	public String setpassword(@RequestParam("newpass") String password,Model model) {
		if (sb1==null) {
			model.addAttribute("msg","you didn't enter new password");
			return "signpage";
		}
		UserData userdata=dao.findByEmailid(sb1.toString());
		if(password.equals(userdata.getPassword())) {
			model.addAttribute("msgch","Past and Present Password same try to beginning");
			sb1.delete(0,sb1.length());
			return "signpage.html";
		}
		else {
			userdata.setPassword(password);
			dao.save(userdata);
			sb1.delete(0,sb1.length());
			return "login.html";
		}
}
	@RequestMapping("/menuitem")
	public String menuitem(@RequestParam("username") String username, Model model) {
		
		List<ItemPrices> products = itemsDao.findAll();
		for (ItemPrices product : products) {
            if (product.getImgData() != null) {
                String encodedImage = Base64.encodeBase64String(product.getImgData());
                product.setEncodedImage(encodedImage); // Add encodedImage field in ItemPrices class
            }
        }
		model.addAttribute("username", username);
		model.addAttribute("products", products);
		return "itemdetails.html";
		
	}
	
	
	@RequestMapping("/selecteditem")
	public ModelAndView selecteditem(@RequestParam(name = "itemname",required = false,defaultValue = "default") String itemname,@RequestParam(name = "username",required = false,defaultValue = "default") String usename) {
		ModelAndView mView;
		ItemPrices itemsDaoObject=itemsDao.findByItemname(itemname);
		
		if(itemsDaoObject!=null) {
			String encodedImage = Base64.encodeBase64String(itemsDaoObject.getImgData());
            itemsDaoObject.setEncodedImage(encodedImage); // Add encodedImage field in ItemPrices class
			mView=new ModelAndView("Itemselect.html");
			mView.addObject("username", usename);
			mView.addObject("Item",itemsDaoObject);
			
		}
		else {
			mView=new ModelAndView("Itemdetails.html");
			mView.addObject("username", usename);
			mView.addObject("Noitem","Item was not a present Now... Choosice Nother one");
		}
		return mView;
		
	}
	
	
	@RequestMapping("/addCart")
	public String addCart(@RequestParam(name = "itemserial",required = false,defaultValue = "default") int itemserial,@RequestParam(name = "username",required = false,defaultValue = "default") String username,Model model) {
		AddCart addCart=new AddCart();
		addCart.setItemserialid(itemserial);
		addCart.setUsername(username);
		addCartDao.save(addCart);
		ItemPrices itemPrices=new ItemPrices();
		itemPrices=itemsDao.findByItemSerial(itemserial);
		
		
		if(itemPrices!=null) {
			String encodedImage = Base64.encodeBase64String(itemPrices.getImgData());
			itemPrices.setEncodedImage(encodedImage); // Add encodedImage field in ItemPrices class
			model.addAttribute("username", username);
			model.addAttribute("Item", itemPrices);
			
		}
		
		return "Itemselect";
	}
	
	
	
}
