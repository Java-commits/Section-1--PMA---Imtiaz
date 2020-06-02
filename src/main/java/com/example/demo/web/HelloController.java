package com.example.demo.web;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("greeting")
public class HelloController {

	@RequestMapping("/user_entry")
	public String userEntry( String fname, String lname ) {
		return "<form action=\"/greeting/user_greeting\" method=\"POST\">\n" + 
				"  <label for=\"firstName\">First name:</label><br>\n" + 
				"  <input type=\"text\" id=\"fname\" name=\"firstName\"><br>\n" + 
				"  <label for=\"lastName\">Last name:</label><br>\n" + 
				"  <input type=\"text\" id=\"lname\" name=\"lastName\"><br><br>\n" + 
				"  <input type=\"submit\" value=\"Submit\">\n" + 
				"</form>  ";
	}
	
	@RequestMapping(value = "/user_greeting", method=RequestMethod.POST)
	public String userGreeting(@RequestParam String firstName,@RequestParam String lastName  ) {
		return "Hello "+firstName+" "+lastName;
//		return "Form Submitted";
	}
	
	@RequestMapping(value = "/order/{id}", method=RequestMethod.GET)
	public String getOrder(@PathVariable String id) {
		return "Order ID: "+id;
		
	}
	
	
}
