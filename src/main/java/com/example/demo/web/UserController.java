package com.example.demo.web;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.Product;

@RestController
@RequestMapping("/user")
public class UserController {

	@RequestMapping("/{userId}")
	public String displayUser(@PathVariable int userId) {
		return "User Found:"+userId;
	}
	
	@RequestMapping("/{userId}/invoices")
	public String displayUserInvoices(@PathVariable int userId, @RequestParam(value="date", required=false) Date dateOrNull) {
		return "Invoice found for user :"+userId+" on "+dateOrNull;
	}
	
	@RequestMapping("/{userId}/products_as_json")
	public List<Product> displayProductJson(){
		return Arrays.asList(new Product(1, "shoes", 99.99),
							 new Product(2, "books", 19.54),
							 new Product(3, "bags", 35.00));
	}
	
	
}
